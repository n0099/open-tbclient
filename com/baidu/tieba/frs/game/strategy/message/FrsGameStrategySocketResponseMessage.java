package com.baidu.tieba.frs.game.strategy.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gj7;
import com.baidu.tieba.hj7;
import com.baidu.tieba.nj7;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes6.dex */
public class FrsGameStrategySocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHasMore;
    public List<nj7> mTabList;
    public List<yh> mThreadList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsGameStrategySocketResponseMessage() {
        super(309478);
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
        this.mHasMore = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            Message<?> orginalMessage = getOrginalMessage();
            if (orginalMessage != null && (orginalMessage.getExtra() instanceof FrsGameStrategyRequestMessage)) {
                frsGameStrategyRequestMessage = (FrsGameStrategyRequestMessage) orginalMessage.getExtra();
            } else {
                frsGameStrategyRequestMessage = null;
            }
            if (frsGameStrategyRequestMessage != null) {
                new hj7().d(String.valueOf(frsGameStrategyRequestMessage.getFid()), bArr, false);
            }
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            boolean z = false;
            GameForumGuideTabResIdl gameForumGuideTabResIdl = (GameForumGuideTabResIdl) new Wire(new Class[0]).parseFrom(bArr, GameForumGuideTabResIdl.class);
            if (gameForumGuideTabResIdl == null) {
                return null;
            }
            Error error = gameForumGuideTabResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(gameForumGuideTabResIdl.error.errmsg);
            }
            this.mTabList = gj7.a(gameForumGuideTabResIdl.data.sub_tab_list);
            this.mThreadList = gj7.b(gameForumGuideTabResIdl.data.thread_list);
            if (gameForumGuideTabResIdl.data.has_more.intValue() == 1) {
                z = true;
            }
            this.mHasMore = z;
            return gameForumGuideTabResIdl;
        }
        return invokeIL.objValue;
    }

    public List<nj7> getTabList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mTabList;
        }
        return (List) invokeV.objValue;
    }

    public List<yh> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mThreadList;
        }
        return (List) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mHasMore;
        }
        return invokeV.booleanValue;
    }
}
