package com.baidu.tieba.homepage.topic.topictab.model;

import c.a.d.a.f;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseHttpGetTopicListMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseSocketGetTopicListMessage;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class TopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.o1.k.c.a f46248e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.c.g.a f46249f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f46250g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.c.g.a f46251h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46252i;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TopicModel topicModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = topicModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j2;
            long j3;
            c.a.t0.o1.k.c.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j2 = blessHttpResponseMessage.userPkId;
                j3 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j2 = blessSocketResponseMessage.userPkId;
                j3 = blessSocketResponseMessage.pkID;
            } else {
                j2 = 0;
                j3 = 0;
            }
            if (j3 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j3 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j3 == 0 || this.a.f46250g == null) {
                return;
            }
            for (n nVar : this.a.f46250g) {
                if ((nVar instanceof c.a.t0.o1.k.c.c.a) && (bVar = ((c.a.t0.o1.k.c.c.a) nVar).c0) != null && j3 == bVar.f21283b) {
                    bVar.f21284c = j2;
                    return;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TopicModel topicModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = topicModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f46252i = false;
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.a.unique_id != responsedMessage.getOrginalMessage().getTag() || this.a.f46248e == null) {
                    return;
                }
                List<n> topicDataList = responsedMessage instanceof ResponseHttpGetTopicListMessage ? ((ResponseHttpGetTopicListMessage) responsedMessage).getTopicDataList() : null;
                if (responsedMessage instanceof ResponseSocketGetTopicListMessage) {
                    topicDataList = ((ResponseSocketGetTopicListMessage) responsedMessage).getTopicDataList();
                }
                this.a.f46250g = topicDataList;
                this.a.f46248e.netCallback(responsedMessage.getError(), topicDataList);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicModel(TbPageContext<?> tbPageContext) {
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
        this.f46251h = new a(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        c.a.t0.w3.f0.a.h(309628, ResponseSocketGetTopicListMessage.class, false, false);
        c.a.t0.w3.f0.a.c(309628, CmdConfigHttp.CMD_TOPIC_LIST, TbConfig.URL_GET_TAB_TOPIC_LIST, ResponseHttpGetTopicListMessage.class, false, false, true, false);
        c.a.t0.w3.f0.a.h(309629, ResponseSocketGetTopicDetailMessage.class, false, false);
        c.a.t0.w3.f0.a.c(309629, CmdConfigHttp.CMD_TOPIC_DETAIL, TbConfig.URL_GET_TOPIC_DETAIL, ResponseHttpGetTopicDetailMessage.class, false, false, true, false);
        c.a.t0.w3.f0.a.h(309631, ResponseSocketGetTopicThreadMessage.class, false, false);
        c.a.t0.w3.f0.a.c(309631, CmdConfigHttp.CMD_TOPIC_THREAD, TbConfig.URL_GET_TOPIC_THREAD, ResponseHttpGetTopicThreadMessage.class, false, false, true, false);
        c.a.t0.w3.f0.a.h(309085, BlessSocketResponseMessage.class, false, false);
        c.a.t0.w3.f0.a.c(309085, CmdConfigHttp.CMD_TOPIC_BLESS, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
        this.f46249f = new b(this, CmdConfigHttp.CMD_TOPIC_LIST, 309628);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!l.A()) {
                c.a.t0.o1.k.c.a aVar = this.f46248e;
                if (aVar != null) {
                    aVar.netCallback(-1, null);
                }
            } else if (this.f46252i) {
            } else {
                cancelLoadData();
                RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
                requestGetTopicListMessage.setCallFrom("topic_tab");
                requestGetTopicListMessage.setTag(this.unique_id);
                if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                    this.f46252i = true;
                }
            }
        }
    }

    public void C(c.a.t0.o1.k.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f46248e = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f46249f);
            MessageManager.getInstance().unRegisterListener(this.f46251h);
            this.f46252i = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.f46249f.setTag(bdUniqueId);
            registerListener(this.f46249f);
            this.f46251h.setTag(bdUniqueId);
            registerListener(this.f46251h);
        }
    }
}
