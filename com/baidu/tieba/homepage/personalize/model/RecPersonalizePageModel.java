package com.baidu.tieba.homepage.personalize.model;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.c.e.c.h;
import d.a.o0.m0.d;
import d.a.o0.m0.k;
import d.a.o0.z0.c;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecPersonalizePageModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f16775e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16776f;

    /* renamed from: g  reason: collision with root package name */
    public int f16777g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f16778h;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecPersonalizePageModel f16779a;

        /* renamed from: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0203a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f16780a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f16781b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f16782c;

            public C0203a(a aVar, ResponsedMessage responsedMessage, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, responsedMessage, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16782c = aVar;
                this.f16780a = responsedMessage;
                this.f16781b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f16782c.f16779a.D(this.f16780a, this.f16781b);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f16783a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f16784b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f16785c;

            public b(a aVar, ResponsedMessage responsedMessage, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, responsedMessage, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16785c = aVar;
                this.f16783a = responsedMessage;
                this.f16784b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f16785c.f16779a.B(this.f16783a, this.f16784b);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecPersonalizePageModel recPersonalizePageModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recPersonalizePageModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f16779a = recPersonalizePageModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
            if (r0.getNeedForumlist() == 1) goto L16;
         */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.f16779a.f16775e == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RecPersonalizeRequest) {
                    RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                    z2 = true;
                    z = recPersonalizeRequest.getLoadType() == 1;
                }
            }
            z = false;
            z2 = false;
            if (responsedMessage.getError() != 0) {
                if (TbSingleton.getInstance().needUploadMoreLog()) {
                    d.a.o0.r.z.a.a("homePage", -1L, responsedMessage.getCmd(), "rec_personalized_error", responsedMessage.getError(), responsedMessage.getErrorString(), new Object[0]);
                }
                this.f16779a.f16775e.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
            } else {
                DataRes dataRes = null;
                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                    dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                }
                this.f16779a.f16775e.a(dataRes, z, z2);
            }
            if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                Looper.myQueue().addIdleHandler(new C0203a(this, responsedMessage, z));
            } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                Looper.myQueue().addIdleHandler(new b(this, responsedMessage, z));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(DataRes dataRes, boolean z, boolean z2);

        void onLoadError(int i2, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecPersonalizePageModel(f<BaseFragmentActivity> fVar, BdUniqueId bdUniqueId) {
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
        this.f16776f = false;
        this.f16777g = 1;
        this.f16778h = new a(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        setUniqueId(bdUniqueId);
        E();
        F();
        registerListener(this.f16778h);
    }

    public void A(int i2, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage}) == null) && k.d().g() && d.a.p0.e1.d.a.d().b() > 0) {
            long f2 = d.a.p0.e1.d.a.d().f(1);
            long b2 = d.a.p0.e1.d.a.d().b();
            long c2 = d.a.p0.e1.d.a.d().c(1);
            long j = f2 + b2;
            long a2 = d.a.p0.e1.d.a.d().a(1);
            if (a2 > 0) {
                j = System.currentTimeMillis() - a2;
            }
            d dVar = new d(1005, z, responsedMessage, 0L, b2, c2, false, j);
            dVar.F = i2;
            dVar.c();
            d.a.p0.e1.d.a.d().h(0L);
        }
    }

    public final void B(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responsedMessage, z) == null) {
            if (!this.f16776f) {
                this.f16776f = true;
                A(1, true, responsedMessage);
            }
            C(z, true, responsedMessage);
        }
    }

    public void C(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), responsedMessage}) == null) && k.d().g()) {
            long f2 = d.a.p0.e1.d.a.d().f(1);
            long b2 = d.a.p0.e1.d.a.d().b();
            d dVar = new d(1005, z2, responsedMessage, 0L, b2, d.a.p0.e1.d.a.d().c(1), false, f2 + b2);
            dVar.F = 1;
            if (z) {
                dVar.C = f2;
                dVar.e(false);
                return;
            }
            dVar.B = f2;
            dVar.e(true);
        }
    }

    public final void D(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, responsedMessage, z) == null) {
            if (!this.f16776f) {
                this.f16776f = true;
                A(1, false, responsedMessage);
            }
            C(z, false, responsedMessage);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, d.a.p0.h3.d0.a.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.o0.v0.b bVar = new d.a.o0.v0.b(309264);
            bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void G(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f16775e = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            int i2 = this.f16777g;
            this.f16777g = i2 + 1;
            recPersonalizeRequest.setRequestTime(i2);
            recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
            recPersonalizeRequest.setSwitchToHttpStrategy(new NetMessage.a(this) { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecPersonalizePageModel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.adp.framework.message.NetMessage.a
                public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, socketResponsedMessage)) == null) {
                        if (socketResponsedMessage == null || !(socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == h.o)) {
                            return false;
                        }
                        if (TbSingleton.getInstance().needUploadMoreLog()) {
                            d.a.o0.r.z.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                            return true;
                        }
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
            sendMessage(recPersonalizeRequest);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z(int i2, int i3, @NonNull c cVar, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setLoadType(i2);
            recPersonalizeRequest.setThreadCount(i3);
            recPersonalizeRequest.setPreAdThreadCount(cVar.f53626a);
            recPersonalizeRequest.setAdFloorInfo(cVar.f53627b);
            recPersonalizeRequest.setTag(getUniqueId());
            recPersonalizeRequest.setPn(i4);
            recPersonalizeRequest.setSuggestCount(i5);
            recPersonalizeRequest.setNeedForumlist(0);
            int i6 = this.f16777g;
            this.f16777g = i6 + 1;
            recPersonalizeRequest.setRequestTime(i6);
            recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
            recPersonalizeRequest.setSwitchToHttpStrategy(new NetMessage.a(this) { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecPersonalizePageModel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i7 = newInitContext.flag;
                        if ((i7 & 1) != 0) {
                            int i8 = i7 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.adp.framework.message.NetMessage.a
                public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, socketResponsedMessage)) == null) {
                        if (socketResponsedMessage == null || !(socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == h.o)) {
                            return false;
                        }
                        if (TbSingleton.getInstance().needUploadMoreLog()) {
                            d.a.o0.r.z.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                            return true;
                        }
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
            sendMessage(recPersonalizeRequest);
        }
    }
}
