package com.baidu.tieba.enterForum.recommend.model;

import b.a.e.a.f;
import b.a.e.f.p.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.enterForum.recommend.message.RequestRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketRecommendMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RecommendModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.o0.k.a f48575e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.e.c.g.a f48576f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48577g;

    /* loaded from: classes8.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendModel f48578a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendModel recommendModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48578a = recommendModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f48578a.f48577g = false;
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.f48578a.unique_id != responsedMessage.getOrginalMessage().getTag() || this.f48578a.f48575e == null) {
                    return;
                }
                b.a.r0.o0.k.c.a recommendData = responsedMessage instanceof ResponseHttpRecommendMessage ? ((ResponseHttpRecommendMessage) responsedMessage).getRecommendData() : null;
                if (responsedMessage instanceof ResponseSocketRecommendMessage) {
                    recommendData = ((ResponseSocketRecommendMessage) responsedMessage).getRecommendData();
                }
                this.f48578a.f48575e.netCallback(responsedMessage.getError(), recommendData);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48576f = new a(this, CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630);
    }

    public void A(b.a.r0.o0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f48575e = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f48576f);
            this.f48577g = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.f48576f.setTag(bdUniqueId);
            registerListener(this.f48576f);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!j.A()) {
                b.a.r0.o0.k.a aVar = this.f48575e;
                if (aVar != null) {
                    aVar.netCallback(-1, null);
                }
            } else if (this.f48577g) {
            } else {
                cancelLoadData();
                RequestRecommendMessage requestRecommendMessage = new RequestRecommendMessage();
                requestRecommendMessage.setTag(this.unique_id);
                if (MessageManager.getInstance().sendMessage(requestRecommendMessage)) {
                    this.f48577g = true;
                }
            }
        }
    }
}
