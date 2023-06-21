package com.baidu.tieba.homepage.topic.topicdetail.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.a48;
import com.baidu.tieba.e48;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.RequestGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.RequestGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicThreadMessage;
import com.baidu.tieba.jb;
import com.baidu.tieba.k9;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.wn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class TopicDetailModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a48 a;
    public e48 b;
    public jb c;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TopicDetailModel topicDetailModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailModel;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j = blessHttpResponseMessage.userPkId;
                j2 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j = blessSocketResponseMessage.userPkId;
                j2 = blessSocketResponseMessage.pkID;
            } else {
                j = 0;
                j2 = 0;
            }
            if (j2 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j2 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j2 != 0 && this.a.b != null && this.a.b.e != null && this.a.b.e.e != null && this.a.b.e.e.b == j2) {
                this.a.b.e.e.c = j;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TopicDetailModel topicDetailModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailModel;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.a.unique_id != responsedMessage.getOrginalMessage().getTag() || this.a.a == null) {
                return;
            }
            if (responsedMessage instanceof ResponseHttpGetTopicDetailMessage) {
                this.a.b = ((ResponseHttpGetTopicDetailMessage) responsedMessage).getTopicDetailData();
            }
            if (responsedMessage instanceof ResponseSocketGetTopicDetailMessage) {
                this.a.b = ((ResponseSocketGetTopicDetailMessage) responsedMessage).getTopicDetailData();
            }
            this.a.a.t(responsedMessage.getError(), this.a.b);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TopicDetailModel topicDetailModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailModel;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.a.unique_id != responsedMessage.getOrginalMessage().getTag() || this.a.a == null) {
                return;
            }
            List<wn> list = null;
            boolean z = false;
            if (responsedMessage instanceof ResponseHttpGetTopicThreadMessage) {
                ResponseHttpGetTopicThreadMessage responseHttpGetTopicThreadMessage = (ResponseHttpGetTopicThreadMessage) responsedMessage;
                List<wn> dataList = responseHttpGetTopicThreadMessage.getDataList();
                z = responseHttpGetTopicThreadMessage.getHasMore();
                list = dataList;
            }
            if (responsedMessage instanceof ResponseSocketGetTopicThreadMessage) {
                ResponseSocketGetTopicThreadMessage responseSocketGetTopicThreadMessage = (ResponseSocketGetTopicThreadMessage) responsedMessage;
                List<wn> dataList2 = responseSocketGetTopicThreadMessage.getDataList();
                z = responseSocketGetTopicThreadMessage.getHasMore();
                list = dataList2;
            }
            this.a.a.L0(responsedMessage.getError(), z, list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        registerListener(new b(this, CmdConfigHttp.CMD_TOPIC_DETAIL, 309629));
        registerListener(new c(this, CmdConfigHttp.CMD_TOPIC_THREAD, 309631));
        registerListener(this.c);
    }

    public void b0(a48 a48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a48Var) == null) {
            this.a = a48Var;
        }
    }

    public void Z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                a48 a48Var = this.a;
                if (a48Var != null) {
                    a48Var.t(-1, null);
                    return;
                }
                return;
            }
            RequestGetTopicDetailMessage requestGetTopicDetailMessage = new RequestGetTopicDetailMessage();
            requestGetTopicDetailMessage.setTopicId(j);
            requestGetTopicDetailMessage.setCallFrom("topic_tab");
            requestGetTopicDetailMessage.setTag(this.unique_id);
            sendMessage(requestGetTopicDetailMessage);
        }
    }

    public void a0(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                a48 a48Var = this.a;
                if (a48Var != null) {
                    a48Var.L0(-1, false, null);
                    return;
                }
                return;
            }
            RequestGetTopicThreadMessage requestGetTopicThreadMessage = new RequestGetTopicThreadMessage();
            requestGetTopicThreadMessage.setTopicId(j);
            requestGetTopicThreadMessage.setPageNo(j2);
            requestGetTopicThreadMessage.setLastFeedId(j3);
            requestGetTopicThreadMessage.setCallFrom("topic_tab");
            requestGetTopicThreadMessage.setTag(this.unique_id);
            sendMessage(requestGetTopicThreadMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }
}
