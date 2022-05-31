package com.baidu.tieba.frs.game.strategy.message;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jn;
import com.repackage.mh6;
import com.repackage.nh6;
import com.repackage.th6;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes3.dex */
public class FrsGameStrategySocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHasMore;
    public List<th6> mTabList;
    public List<jn> mThreadList;

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

    public List<th6> getTabList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTabList : (List) invokeV.objValue;
    }

    public List<jn> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mThreadList : (List) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHasMore : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            Message<?> orginalMessage = getOrginalMessage();
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = (orginalMessage == null || !(orginalMessage.getExtra() instanceof FrsGameStrategyRequestMessage)) ? null : (FrsGameStrategyRequestMessage) orginalMessage.getExtra();
            if (frsGameStrategyRequestMessage != null) {
                new nh6().d(String.valueOf(frsGameStrategyRequestMessage.getFid()), bArr, false);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            GameForumGuideTabResIdl gameForumGuideTabResIdl = (GameForumGuideTabResIdl) new Wire(new Class[0]).parseFrom(bArr, GameForumGuideTabResIdl.class);
            if (gameForumGuideTabResIdl == null) {
                return;
            }
            Error error = gameForumGuideTabResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(gameForumGuideTabResIdl.error.errmsg);
            }
            this.mTabList = mh6.a(gameForumGuideTabResIdl.data.sub_tab_list);
            this.mThreadList = mh6.b(gameForumGuideTabResIdl.data.thread_list);
            this.mHasMore = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
        }
    }
}
