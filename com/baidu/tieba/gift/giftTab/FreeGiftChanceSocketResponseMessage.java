package com.baidu.tieba.gift.giftTab;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetUserFreeChance.DataRes;
import tbclient.GetUserFreeChance.GetUserFreeChanceResIdl;
/* loaded from: classes6.dex */
public class FreeGiftChanceSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int freeChance;
    public long sceneId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FreeGiftChanceSocketResponseMessage() {
        super(309060);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.freeChance = 0;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetUserFreeChanceResIdl getUserFreeChanceResIdl = (GetUserFreeChanceResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserFreeChanceResIdl.class);
            if (getUserFreeChanceResIdl == null) {
                return null;
            }
            Error error = getUserFreeChanceResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getUserFreeChanceResIdl.error.usermsg);
            }
            DataRes dataRes = getUserFreeChanceResIdl.data;
            if (dataRes != null) {
                this.freeChance = dataRes.free_chance.intValue();
                this.sceneId = getUserFreeChanceResIdl.data.scene_id.intValue();
            }
            return getUserFreeChanceResIdl;
        }
        return invokeIL.objValue;
    }

    public int getFreeChance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.freeChance;
        }
        return invokeV.intValue;
    }

    public long getSceneId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.sceneId;
        }
        return invokeV.longValue;
    }

    public void setSceneId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.sceneId = j;
        }
    }
}
