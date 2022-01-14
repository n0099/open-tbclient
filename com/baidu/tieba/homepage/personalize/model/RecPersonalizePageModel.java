package com.baidu.tieba.homepage.personalize.model;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.c.e.c.h;
import c.a.s0.e1.g;
import c.a.s0.s0.d;
import c.a.s0.s0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
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
/* loaded from: classes12.dex */
public class RecPersonalizePageModel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static RecPersonalizePageModel f44339f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile c a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44340b;

    /* renamed from: c  reason: collision with root package name */
    public int f44341c;

    /* renamed from: d  reason: collision with root package name */
    public TbHttpMessageTask f44342d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.c.g.a f44343e;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecPersonalizePageModel a;

        /* renamed from: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C1918a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResponsedMessage a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f44344b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f44345c;

            public C1918a(a aVar, ResponsedMessage responsedMessage, boolean z) {
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
                this.f44345c = aVar;
                this.a = responsedMessage;
                this.f44344b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f44345c.a.m(this.a, this.f44344b);
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
            this.a = recPersonalizePageModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
            if (r0.getNeedForumlist() == 1) goto L21;
         */
        @Override // c.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (this.a.f44341c == 2 && SpeedStatsManager.getInstance().getAttachWindowSpeedStats() != null) {
                    SpeedStatsManager.getInstance().getAttachWindowSpeedStats().addStatsTimeStamp(4022);
                }
                if (responsedMessage == null || this.a.a == null) {
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
                        c.a.s0.s.b0.a.a("homePage", -1L, responsedMessage.getCmd(), "rec_personalized_error", responsedMessage.getError(), responsedMessage.getErrorString(), new Object[0]);
                    }
                    this.a.a.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                } else {
                    DataRes dataRes = null;
                    if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                        dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                        dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                    }
                    this.a.a.a(dataRes, z, z2);
                }
                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                    Looper.myQueue().addIdleHandler(new C1918a(this, responsedMessage, z));
                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    this.a.k(responsedMessage, z);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends HttpClient.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecPersonalizePageModel f44346e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecPersonalizePageModel recPersonalizePageModel, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            super(httpMessage, httpMessageTask);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recPersonalizePageModel, httpMessage, httpMessageTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((HttpMessage) objArr2[0], (HttpMessageTask) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44346e = recPersonalizePageModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void publishProgress(ResponsedMessage<?>... responsedMessageArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessageArr) == null) || responsedMessageArr == null || responsedMessageArr.length <= 0) {
                return;
            }
            this.f44346e.f44343e.onMessage(responsedMessageArr[0]);
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
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
        f44339f = new RecPersonalizePageModel();
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
        this.f44340b = false;
        this.f44341c = 1;
        this.f44343e = new a(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        o();
        p();
        MessageManager.getInstance().registerListener(this.f44343e);
    }

    public static RecPersonalizePageModel g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f44339f : (RecPersonalizePageModel) invokeV.objValue;
    }

    public c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (c) invokeV.objValue;
    }

    public final RecPersonalizeRequest h(int i2, int i3, @NonNull g gVar, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), gVar, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setLoadType(i2);
            recPersonalizeRequest.setThreadCount(i3);
            recPersonalizeRequest.setPreAdThreadCount(gVar.a);
            recPersonalizeRequest.setAdFloorInfo(gVar.f12366b);
            recPersonalizeRequest.setPn(i4);
            recPersonalizeRequest.setSuggestCount(i5);
            recPersonalizeRequest.setNeedForumlist(0);
            int i6 = this.f44341c;
            this.f44341c = i6 + 1;
            recPersonalizeRequest.setRequestTime(i6);
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
                            c.a.s0.s.b0.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                            return true;
                        }
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
            return recPersonalizeRequest;
        }
        return (RecPersonalizeRequest) invokeCommon.objValue;
    }

    public void i(int i2, int i3, @NonNull g gVar, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), gVar, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            MessageManager.getInstance().sendMessage(h(i2, i3, gVar, i4, i5));
        }
    }

    public void j(int i2, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage}) == null) && k.d().g() && c.a.t0.o1.d.b.d().b() > 0) {
            long f2 = c.a.t0.o1.d.b.d().f(1);
            long b2 = c.a.t0.o1.d.b.d().b();
            long c2 = c.a.t0.o1.d.b.d().c(1);
            long j2 = f2 + b2;
            long a2 = c.a.t0.o1.d.b.d().a(1);
            if (a2 > 0) {
                j2 = System.currentTimeMillis() - a2;
            }
            d dVar = new d(1005, z, responsedMessage, 0L, b2, c2, false, j2);
            dVar.F = i2;
            dVar.c();
            c.a.t0.o1.d.b.d().h(0L);
        }
    }

    public final void k(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, responsedMessage, z) == null) {
            if (!this.f44340b) {
                this.f44340b = true;
                j(1, true, responsedMessage);
            }
            l(z, true, responsedMessage);
        }
    }

    public void l(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), responsedMessage}) == null) && k.d().g()) {
            long f2 = c.a.t0.o1.d.b.d().f(1);
            long b2 = c.a.t0.o1.d.b.d().b();
            d dVar = new d(1005, z2, responsedMessage, 0L, b2, c.a.t0.o1.d.b.d().c(1), false, f2 + b2);
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

    public final void m(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, responsedMessage, z) == null) {
            if (!this.f44340b) {
                this.f44340b = true;
                j(1, false, responsedMessage);
            }
            l(z, false, responsedMessage);
        }
    }

    public void n(int i2, int i3, @NonNull g gVar, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), gVar, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            RecPersonalizeRequest h2 = h(i2, i3, gVar, i4, i5);
            h2.setNetType(NetMessage.NetType.HTTP);
            new b(this, h2.getHttpMessage(), this.f44342d).execute(new HttpMessage[0]);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, c.a.t0.w3.f0.a.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            this.f44342d = tbHttpMessageTask;
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            this.f44342d.setResponsedClass(RecPersonalizeHttpResponse.class);
            this.f44342d.setTimeOut(c.a.d.c.j.b.d().b());
            this.f44342d.setRetry(c.a.d.c.j.b.d().a());
            this.f44342d.setConnectTimeOut(c.a.d.c.j.b.d().c());
            this.f44342d.setPriority(4);
            MessageManager.getInstance().registerTask(this.f44342d);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.s0.a1.b bVar = new c.a.s0.a1.b(309264);
            bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void q(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.a = cVar;
        }
    }
}
