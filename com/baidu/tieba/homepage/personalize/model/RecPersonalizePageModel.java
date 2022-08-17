package com.baidu.tieba.homepage.personalize.model;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tbadk.switchs.MainTabDataSwitch;
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
import com.repackage.ab;
import com.repackage.cw6;
import com.repackage.ea;
import com.repackage.gu4;
import com.repackage.jb;
import com.repackage.jk8;
import com.repackage.ka5;
import com.repackage.lb5;
import com.repackage.m60;
import com.repackage.vd5;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class RecPersonalizePageModel {
    public static /* synthetic */ Interceptable $ic;
    public static RecPersonalizePageModel f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile c a;
    public boolean b;
    public int c;
    public TbHttpMessageTask d;
    public ab e;

    /* loaded from: classes3.dex */
    public class a extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecPersonalizePageModel a;

        /* renamed from: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0216a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResponsedMessage a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ a c;

            public C0216a(a aVar, ResponsedMessage responsedMessage, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, responsedMessage, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = responsedMessage;
                this.b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.c.a.m(this.a, this.b);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecPersonalizePageModel recPersonalizePageModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recPersonalizePageModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = recPersonalizePageModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
            if (r0.getNeedForumlist() == 1) goto L21;
         */
        @Override // com.repackage.ab
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (this.a.c == 2 && SpeedStatsManager.getInstance().getAttachWindowSpeedStats() != null) {
                    SpeedStatsManager.getInstance().getAttachWindowSpeedStats().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY);
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
                        gu4.a("homePage", -1L, responsedMessage.getCmd(), "rec_personalized_error", responsedMessage.getError(), responsedMessage.getErrorString(), new Object[0]);
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
                    Looper.myQueue().addIdleHandler(new C0216a(this, responsedMessage, z));
                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    this.a.k(responsedMessage, z);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpClient.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecPersonalizePageModel e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecPersonalizePageModel recPersonalizePageModel, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            super(httpMessage, httpMessageTask);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recPersonalizePageModel, httpMessage, httpMessageTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((HttpMessage) objArr2[0], (HttpMessageTask) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = recPersonalizePageModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void publishProgress(ResponsedMessage<?>... responsedMessageArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessageArr) == null) || responsedMessageArr == null || responsedMessageArr.length <= 0) {
                return;
            }
            this.e.e.onMessage(responsedMessageArr[0]);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(DataRes dataRes, boolean z, boolean z2);

        void onLoadError(int i, String str);
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
        f = new RecPersonalizePageModel();
    }

    public RecPersonalizePageModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = 1;
        this.e = new a(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        p();
        q();
        MessageManager.getInstance().registerListener(this.e);
    }

    public static RecPersonalizePageModel g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f : (RecPersonalizePageModel) invokeV.objValue;
    }

    public c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (c) invokeV.objValue;
    }

    public final RecPersonalizeRequest h(int i, int i2, @NonNull vd5 vd5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), vd5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            recPersonalizeRequest.setPreAdThreadCount(vd5Var.a);
            recPersonalizeRequest.setAdFloorInfo(vd5Var.b);
            recPersonalizeRequest.setPn(i3);
            recPersonalizeRequest.setSuggestCount(i4);
            recPersonalizeRequest.setNeedForumlist(0);
            int i5 = this.c;
            this.c = i5 + 1;
            recPersonalizeRequest.setRequestTime(i5);
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
                        int i6 = newInitContext.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
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
                        if (socketResponsedMessage == null || !(socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == ea.o)) {
                            return false;
                        }
                        if (TbSingleton.getInstance().needUploadMoreLog()) {
                            gu4.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
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

    public void i(int i, int i2, @NonNull vd5 vd5Var, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), vd5Var, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            MessageManager.getInstance().sendMessage(h(i, i2, vd5Var, i3, i4));
        }
    }

    public void j(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && cw6.d().b() > 0) {
            long f2 = cw6.d().f(1);
            long b2 = cw6.d().b();
            long c2 = cw6.d().c(1);
            long j = f2 + b2;
            long a2 = cw6.d().a(1);
            if (a2 > 0) {
                j = System.currentTimeMillis() - a2;
            }
            ka5 ka5Var = new ka5(1005, z, responsedMessage, 0L, b2, c2, false, j);
            ka5Var.F = i;
            ka5Var.c();
            cw6.d().h(0L);
        }
    }

    public final void k(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, responsedMessage, z) == null) {
            if (!this.b) {
                this.b = true;
                j(1, true, responsedMessage);
            }
            l(z, true, responsedMessage);
        }
    }

    public void l(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), responsedMessage}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            long f2 = cw6.d().f(1);
            long b2 = cw6.d().b();
            ka5 ka5Var = new ka5(1005, z2, responsedMessage, 0L, b2, cw6.d().c(1), false, f2 + b2);
            ka5Var.F = 1;
            if (z) {
                ka5Var.C = f2;
                ka5Var.e(false);
                return;
            }
            ka5Var.B = f2;
            ka5Var.e(true);
        }
    }

    public final void m(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, responsedMessage, z) == null) {
            if (!this.b) {
                this.b = true;
                j(1, false, responsedMessage);
            }
            l(z, false, responsedMessage);
        }
    }

    public void n(ResponsedMessage<?> responsedMessage) {
        ab abVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, responsedMessage) == null) || (abVar = this.e) == null) {
            return;
        }
        abVar.onMessage(responsedMessage);
    }

    public void o(int i, int i2, @NonNull vd5 vd5Var, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), vd5Var, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (MainTabDataSwitch.isCacheOpen()) {
                RecPersonalizeRequest h = h(1, 0, vd5Var, 1, 0);
                h.setNetType(NetMessage.NetType.HTTP);
                m60.e(h.getHttpMessage(), this.d);
                return;
            }
            RecPersonalizeRequest h2 = h(i, i2, vd5Var, i3, i4);
            h2.setNetType(NetMessage.NetType.HTTP);
            new b(this, h2.getHttpMessage(), this.d).execute(new HttpMessage[0]);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, jk8.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            this.d = tbHttpMessageTask;
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            this.d.setResponsedClass(RecPersonalizeHttpResponse.class);
            this.d.setTimeOut(jb.d().b());
            this.d.setRetry(jb.d().a());
            this.d.setConnectTimeOut(jb.d().c());
            this.d.setPriority(4);
            MessageManager.getInstance().registerTask(this.d);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            lb5 lb5Var = new lb5(309264);
            lb5Var.setResponsedClass(RecPersonalizeSocketResponse.class);
            lb5Var.g(true);
            lb5Var.setPriority(4);
            MessageManager.getInstance().registerTask(lb5Var);
        }
    }

    public void r(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.a = cVar;
        }
    }
}
