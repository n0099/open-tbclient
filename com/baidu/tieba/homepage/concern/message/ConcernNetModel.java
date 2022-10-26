package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ah5;
import com.baidu.tieba.ej;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipReqMessage;
import com.baidu.tieba.qb;
import com.baidu.tieba.r9;
import com.baidu.tieba.se5;
import com.baidu.tieba.zm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernNetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public c b;
    public boolean c;
    public qb d;
    public qb e;

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(DataRes dataRes, boolean z);

        void onLoadError(int i, String str);
    }

    /* loaded from: classes4.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernNetModel concernNetModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernNetModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = concernNetModel;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && this.a.a != null) {
                boolean z = false;
                this.a.c = false;
                if (responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof ConcernPageRequestMessage) {
                        z = ej.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                    }
                }
                if (responsedMessage.getError() != 0) {
                    this.a.a.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                    return;
                }
                DataRes dataRes = null;
                if (responsedMessage instanceof ConcernPageSocketResMessage) {
                    dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                    dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                }
                this.a.a.a(dataRes, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ConcernNetModel concernNetModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernNetModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = concernNetModel;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
            boolean isShowRedNotify;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && this.a.b != null && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof CheckRedNotifyHttpResMessage) {
                    CheckRedNotifyHttpResMessage checkRedNotifyHttpResMessage = (CheckRedNotifyHttpResMessage) responsedMessage;
                    if (checkRedNotifyHttpResMessage != null) {
                        isShowRedNotify = checkRedNotifyHttpResMessage.isShowRedNotify();
                    }
                    isShowRedNotify = false;
                } else {
                    if ((responsedMessage instanceof CheckRedNotifySocketResMessage) && (checkRedNotifySocketResMessage = (CheckRedNotifySocketResMessage) responsedMessage) != null) {
                        isShowRedNotify = checkRedNotifySocketResMessage.isShowRedNotify();
                    }
                    isShowRedNotify = false;
                }
                this.a.b.a(false);
                if (isShowRedNotify && (responsedMessage.getmOrginalMessage().getExtra() instanceof CheckRedNotifyReqMessage) && ((CheckRedNotifyReqMessage) responsedMessage.getmOrginalMessage().getExtra()).reqUnreadTipAfterFinish) {
                    this.a.sendMessage(new ConcernUnreadTipReqMessage());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernNetModel(r9 r9Var, BdUniqueId bdUniqueId) {
        super(r9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = new a(this, CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
        this.e = new b(this, CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, 309476);
        setUniqueId(bdUniqueId);
        registerHttpTask();
        E();
        registerListener(this.d);
        registerListener(this.e);
    }

    public void D(String str, ah5 ah5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ah5Var) != null) || this.c) {
            return;
        }
        this.c = true;
        ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
        concernPageRequestMessage.setPageTag(str);
        concernPageRequestMessage.setTag(getUniqueId());
        concernPageRequestMessage.setAdInfo(ah5Var);
        sendMessage(concernPageRequestMessage);
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            CheckRedNotifyReqMessage checkRedNotifyReqMessage = new CheckRedNotifyReqMessage();
            checkRedNotifyReqMessage.setTag(getUniqueId());
            checkRedNotifyReqMessage.reqUnreadTipAfterFinish = z;
            sendMessage(checkRedNotifyReqMessage);
        }
    }

    public void F(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.b = cVar;
        }
    }

    public void G(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.a = dVar;
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            se5 se5Var = new se5(309474);
            se5Var.setResponsedClass(ConcernPageSocketResMessage.class);
            se5Var.g(true);
            MessageManager.getInstance().registerTask(se5Var);
            se5 se5Var2 = new se5(309476);
            se5Var2.setResponsedClass(CheckRedNotifySocketResMessage.class);
            se5Var2.g(true);
            MessageManager.getInstance().registerTask(se5Var2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.c = false;
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c) {
                return true;
            }
            this.c = true;
            sendMessage(new ConcernPageRequestMessage());
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerHttpTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, zm8.a(TbConfig.URL_CONCERN_PAGE, 309474));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, zm8.a(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, 309476));
            tbHttpMessageTask2.setIsNeedAddCommenParam(true);
            tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        }
    }
}
