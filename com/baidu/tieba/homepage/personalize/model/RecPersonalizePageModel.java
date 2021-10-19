package com.baidu.tieba.homepage.personalize.model;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.c.e.c.h;
import c.a.q0.d1.e;
import c.a.q0.q0.d;
import c.a.q0.q0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes7.dex */
public class RecPersonalizePageModel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static RecPersonalizePageModel f52397e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f52398a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52399b;

    /* renamed from: c  reason: collision with root package name */
    public int f52400c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.c.g.a f52401d;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecPersonalizePageModel f52402a;

        /* renamed from: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1767a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f52403a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f52404b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f52405c;

            public C1767a(a aVar, ResponsedMessage responsedMessage, boolean z) {
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
                this.f52405c = aVar;
                this.f52403a = responsedMessage;
                this.f52404b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f52405c.f52402a.k(this.f52403a, this.f52404b);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f52406a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f52407b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f52408c;

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
                this.f52408c = aVar;
                this.f52406a = responsedMessage;
                this.f52407b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f52408c.f52402a.i(this.f52406a, this.f52407b);
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
            this.f52402a = recPersonalizePageModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
            if (r0.getNeedForumlist() == 1) goto L21;
         */
        @Override // c.a.e.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (this.f52402a.f52400c == 2 && SpeedStatsManager.getInstance().getAttachWindowSpeedStats() != null) {
                    SpeedStatsManager.getInstance().getAttachWindowSpeedStats().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY);
                }
                if (responsedMessage == null || this.f52402a.f52398a == null) {
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
                        c.a.q0.s.z.a.a("homePage", -1L, responsedMessage.getCmd(), "rec_personalized_error", responsedMessage.getError(), responsedMessage.getErrorString(), new Object[0]);
                    }
                    this.f52402a.f52398a.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                } else {
                    DataRes dataRes = null;
                    if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                        dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                        dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                    }
                    this.f52402a.f52398a.a(dataRes, z, z2);
                }
                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                    Looper.myQueue().addIdleHandler(new C1767a(this, responsedMessage, z));
                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    Looper.myQueue().addIdleHandler(new b(this, responsedMessage, z));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(DataRes dataRes, boolean z, boolean z2);

        void onLoadError(int i2, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-757213191, "Lcom/baidu/tieba/homepage/personalize/model/RecPersonalizePageModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-757213191, "Lcom/baidu/tieba/homepage/personalize/model/RecPersonalizePageModel;");
                return;
            }
        }
        f52397e = new RecPersonalizePageModel();
    }

    public RecPersonalizePageModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52399b = false;
        this.f52400c = 1;
        this.f52401d = new a(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        l();
        m();
        MessageManager.getInstance().registerListener(this.f52401d);
    }

    public static RecPersonalizePageModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f52397e : (RecPersonalizePageModel) invokeV.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52398a : (b) invokeV.objValue;
    }

    public void g(int i2, int i3, @NonNull e eVar, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setLoadType(i2);
            recPersonalizeRequest.setThreadCount(i3);
            recPersonalizeRequest.setPreAdThreadCount(eVar.f12928a);
            recPersonalizeRequest.setAdFloorInfo(eVar.f12929b);
            recPersonalizeRequest.setPn(i4);
            recPersonalizeRequest.setSuggestCount(i5);
            recPersonalizeRequest.setNeedForumlist(0);
            int i6 = this.f52400c;
            this.f52400c = i6 + 1;
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
                            c.a.q0.s.z.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                            return true;
                        }
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
            MessageManager.getInstance().sendMessage(recPersonalizeRequest);
        }
    }

    public void h(int i2, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage}) == null) && k.d().g() && c.a.r0.h1.d.a.d().b() > 0) {
            long f2 = c.a.r0.h1.d.a.d().f(1);
            long b2 = c.a.r0.h1.d.a.d().b();
            long c2 = c.a.r0.h1.d.a.d().c(1);
            long j2 = f2 + b2;
            long a2 = c.a.r0.h1.d.a.d().a(1);
            if (a2 > 0) {
                j2 = System.currentTimeMillis() - a2;
            }
            d dVar = new d(1005, z, responsedMessage, 0L, b2, c2, false, j2);
            dVar.F = i2;
            dVar.c();
            c.a.r0.h1.d.a.d().h(0L);
        }
    }

    public final void i(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, responsedMessage, z) == null) {
            if (!this.f52399b) {
                this.f52399b = true;
                h(1, true, responsedMessage);
            }
            j(z, true, responsedMessage);
        }
    }

    public void j(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), responsedMessage}) == null) && k.d().g()) {
            long f2 = c.a.r0.h1.d.a.d().f(1);
            long b2 = c.a.r0.h1.d.a.d().b();
            d dVar = new d(1005, z2, responsedMessage, 0L, b2, c.a.r0.h1.d.a.d().c(1), false, f2 + b2);
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

    public final void k(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, responsedMessage, z) == null) {
            if (!this.f52399b) {
                this.f52399b = true;
                h(1, false, responsedMessage);
            }
            j(z, false, responsedMessage);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, c.a.r0.k3.e0.a.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.z0.b bVar = new c.a.q0.z0.b(309264);
            bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f52398a = bVar;
        }
    }
}
