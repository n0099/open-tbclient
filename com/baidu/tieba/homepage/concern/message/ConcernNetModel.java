package com.baidu.tieba.homepage.concern.message;

import c.a.e.a.f;
import c.a.e.e.p.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipReqMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Userlike.DataRes;
/* loaded from: classes7.dex */
public class ConcernNetModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f51775e;

    /* renamed from: f  reason: collision with root package name */
    public c f51776f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51777g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.c.g.a f51778h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.e.c.g.a f51779i;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernNetModel f51780a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernNetModel concernNetModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernNetModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f51780a = concernNetModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.f51780a.f51775e == null) {
                return;
            }
            boolean z = false;
            this.f51780a.f51777g = false;
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ConcernPageRequestMessage) {
                    z = k.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                }
            }
            if (responsedMessage.getError() != 0) {
                this.f51780a.f51775e.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                return;
            }
            DataRes dataRes = null;
            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
            }
            this.f51780a.f51775e.a(dataRes, z);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernNetModel f51781a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ConcernNetModel concernNetModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernNetModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f51781a = concernNetModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
            boolean isShowRedNotify;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.f51781a.f51776f == null || responsedMessage.getError() != 0) {
                return;
            }
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
            this.f51781a.f51776f.a(false);
            if (isShowRedNotify && (responsedMessage.getmOrginalMessage().getExtra() instanceof CheckRedNotifyReqMessage) && ((CheckRedNotifyReqMessage) responsedMessage.getmOrginalMessage().getExtra()).reqUnreadTipAfterFinish) {
                this.f51781a.sendMessage(new ConcernUnreadTipReqMessage());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(DataRes dataRes, boolean z);

        void onLoadError(int i2, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernNetModel(f<BaseFragmentActivity> fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdUniqueId};
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
        this.f51777g = false;
        this.f51778h = new a(this, CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
        this.f51779i = new b(this, CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, 309476);
        setUniqueId(bdUniqueId);
        B();
        C();
        registerListener(this.f51778h);
        registerListener(this.f51779i);
    }

    public void A(String str, c.a.o0.b1.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) || this.f51777g) {
            return;
        }
        this.f51777g = true;
        ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
        concernPageRequestMessage.setPageTag(str);
        concernPageRequestMessage.setTag(getUniqueId());
        concernPageRequestMessage.setAdInfo(cVar);
        sendMessage(concernPageRequestMessage);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, c.a.p0.i3.d0.a.a(TbConfig.URL_CONCERN_PAGE, 309474));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, c.a.p0.i3.d0.a.a(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, 309476));
            tbHttpMessageTask2.setIsNeedAddCommenParam(true);
            tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.x0.b bVar = new c.a.o0.x0.b(309474);
            bVar.setResponsedClass(ConcernPageSocketResMessage.class);
            bVar.g(true);
            MessageManager.getInstance().registerTask(bVar);
            c.a.o0.x0.b bVar2 = new c.a.o0.x0.b(309476);
            bVar2.setResponsedClass(CheckRedNotifySocketResMessage.class);
            bVar2.g(true);
            MessageManager.getInstance().registerTask(bVar2);
        }
    }

    public void D(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f51776f = cVar;
        }
    }

    public void E(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f51775e = dVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f51777g) {
                return true;
            }
            this.f51777g = true;
            sendMessage(new ConcernPageRequestMessage());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f51777g = false;
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            CheckRedNotifyReqMessage checkRedNotifyReqMessage = new CheckRedNotifyReqMessage();
            checkRedNotifyReqMessage.setTag(getUniqueId());
            checkRedNotifyReqMessage.reqUnreadTipAfterFinish = z;
            sendMessage(checkRedNotifyReqMessage);
        }
    }
}
