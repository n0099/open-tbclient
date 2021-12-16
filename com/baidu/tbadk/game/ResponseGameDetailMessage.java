package com.baidu.tbadk.game;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GameInfo;
import tbclient.GetGameDetail.DataRes;
import tbclient.GetGameDetail.GetGameDetailResIdl;
import tbclient.GetGameDetail.RankInfo;
/* loaded from: classes11.dex */
public class ResponseGameDetailMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GameInfo mGameInfo;
    public RankInfo mRankInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseGameDetailMessage() {
        super(303009);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public GameInfo getGameInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mGameInfo : (GameInfo) invokeV.objValue;
    }

    public RankInfo getRankInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRankInfo : (RankInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || bArr == null) {
            return;
        }
        GetGameDetailResIdl getGameDetailResIdl = (GetGameDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameDetailResIdl.class);
        setError(getGameDetailResIdl.error.errorno.intValue());
        setErrorString(getGameDetailResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        DataRes dataRes = getGameDetailResIdl.data;
        this.mGameInfo = dataRes.game_info;
        this.mRankInfo = dataRes.rank_info;
    }
}
