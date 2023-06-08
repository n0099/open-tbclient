package com.baidu.tieba.frs.game.strategy.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.jj7;
import com.baidu.tieba.kj7;
import com.baidu.tieba.qj7;
import com.baidu.tieba.vn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes5.dex */
public class FrsGameStrategyHttpResponseMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHasMore;
    public List<qj7> mTabList;
    public List<vn> mThreadList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsGameStrategyHttpResponseMessage() {
        super(CmdConfigHttp.CMD_FRS_GAME_STRATEGY);
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
                new kj7().d(String.valueOf(frsGameStrategyRequestMessage.getFid()), bArr, false);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            boolean z = false;
            GameForumGuideTabResIdl gameForumGuideTabResIdl = (GameForumGuideTabResIdl) new Wire(new Class[0]).parseFrom(bArr, GameForumGuideTabResIdl.class);
            if (gameForumGuideTabResIdl == null) {
                return;
            }
            Error error = gameForumGuideTabResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(gameForumGuideTabResIdl.error.errmsg);
            }
            this.mTabList = jj7.a(gameForumGuideTabResIdl.data.sub_tab_list);
            this.mThreadList = jj7.b(gameForumGuideTabResIdl.data.thread_list);
            if (gameForumGuideTabResIdl.data.has_more.intValue() == 1) {
                z = true;
            }
            this.mHasMore = z;
        }
    }

    public List<qj7> getTabList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mTabList;
        }
        return (List) invokeV.objValue;
    }

    public List<vn> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mThreadList;
        }
        return (List) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mHasMore;
        }
        return invokeV.booleanValue;
    }
}
