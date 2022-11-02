package com.baidu.tieba.homepage.personalize.model;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.c80;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import com.baidu.tieba.io8;
import com.baidu.tieba.ne5;
import com.baidu.tieba.of5;
import com.baidu.tieba.pb;
import com.baidu.tieba.ta;
import com.baidu.tieba.wg;
import com.baidu.tieba.wh5;
import com.baidu.tieba.xz6;
import com.baidu.tieba.yb;
import com.baidu.tieba.zx4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecPersonalizePageModel {
    public static /* synthetic */ Interceptable $ic;
    public static RecPersonalizePageModel f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile b a;
    public boolean b;
    public int c;
    public TbHttpMessageTask d;
    public pb e;

    /* loaded from: classes4.dex */
    public interface b {
        void a(DataRes dataRes, boolean z, boolean z2);

        void onLoadError(int i, String str);
    }

    /* loaded from: classes4.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecPersonalizePageModel a;

        /* renamed from: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0291a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResponsedMessage a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ a c;

            public C0291a(a aVar, ResponsedMessage responsedMessage, boolean z) {
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
                if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                    return invokeV.booleanValue;
                }
                this.c.a.k(this.a, this.b);
                return false;
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
        @Override // com.baidu.tieba.pb
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
                if (responsedMessage != null && this.a.a != null) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof RecPersonalizeRequest) {
                            RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                            z2 = true;
                            if (recPersonalizeRequest.getLoadType() == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                    }
                    z = false;
                    z2 = false;
                    if (responsedMessage.getError() != 0) {
                        if (TbSingleton.getInstance().needUploadMoreLog()) {
                            zx4.a("homePage", -1L, responsedMessage.getCmd(), "rec_personalized_error", responsedMessage.getError(), responsedMessage.getErrorString(), new Object[0]);
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
                        Looper.myQueue().addIdleHandler(new C0291a(this, responsedMessage, z));
                    } else if (!(responsedMessage instanceof RecPersonalizeHttpResponse)) {
                    } else {
                        this.a.i(responsedMessage, z);
                    }
                }
            }
        }
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

    public static RecPersonalizePageModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return f;
        }
        return (RecPersonalizePageModel) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            of5 of5Var = new of5(309264);
            of5Var.setResponsedClass(RecPersonalizeSocketResponse.class);
            of5Var.g(true);
            of5Var.setPriority(4);
            MessageManager.getInstance().registerTask(of5Var);
        }
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
        n();
        o();
        MessageManager.getInstance().registerListener(this.e);
    }

    public void l(ResponsedMessage<?> responsedMessage) {
        pb pbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, responsedMessage) == null) && (pbVar = this.e) != null) {
            pbVar.onMessage(responsedMessage);
        }
    }

    public void p(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public final RecPersonalizeRequest f(int i, int i2, @NonNull wh5 wh5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), wh5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            recPersonalizeRequest.setPreAdThreadCount(wh5Var.a);
            recPersonalizeRequest.setAdFloorInfo(wh5Var.b);
            recPersonalizeRequest.setPn(i3);
            recPersonalizeRequest.setSuggestCount(i4);
            recPersonalizeRequest.setNeedForumlist(0);
            int i5 = this.c;
            this.c = i5 + 1;
            recPersonalizeRequest.setRequestTime(i5);
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
                        if (socketResponsedMessage == null || (socketResponsedMessage.getError() != 110004 && socketResponsedMessage.getError() != 110005 && socketResponsedMessage.getError() != ta.o)) {
                            return false;
                        }
                        if (TbSingleton.getInstance().needUploadMoreLog()) {
                            zx4.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                            return true;
                        }
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getPushTid())) {
                String pushTid = TbSingleton.getInstance().getPushTid();
                TbSingleton.getInstance().setPushTid(null);
                long g = wg.g(pushTid, -1L);
                if (g != -1) {
                    recPersonalizeRequest.setPushTid(g);
                }
            }
            return recPersonalizeRequest;
        }
        return (RecPersonalizeRequest) invokeCommon.objValue;
    }

    public void g(int i, int i2, @NonNull wh5 wh5Var, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), wh5Var, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            MessageManager.getInstance().sendMessage(f(i, i2, wh5Var, i3, i4));
        }
    }

    public void h(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && xz6.d().b() > 0) {
            long f2 = xz6.d().f(1);
            long b2 = xz6.d().b();
            long c = xz6.d().c(1);
            long j = f2 + b2;
            long a2 = xz6.d().a(1);
            if (a2 > 0) {
                j = System.currentTimeMillis() - a2;
            }
            ne5 ne5Var = new ne5(1005, z, responsedMessage, 0L, b2, c, false, j);
            ne5Var.F = i;
            ne5Var.c();
            xz6.d().h(0L);
        }
    }

    public void j(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), responsedMessage}) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        long f2 = xz6.d().f(1);
        long b2 = xz6.d().b();
        ne5 ne5Var = new ne5(1005, z2, responsedMessage, 0L, b2, xz6.d().c(1), false, f2 + b2);
        ne5Var.F = 1;
        if (z) {
            ne5Var.C = f2;
            ne5Var.e(false);
            return;
        }
        ne5Var.B = f2;
        ne5Var.e(true);
    }

    public final void i(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, responsedMessage, z) == null) {
            if (!this.b) {
                this.b = true;
                h(1, true, responsedMessage);
            }
            j(z, true, responsedMessage);
        }
    }

    public final void k(ResponsedMessage<?> responsedMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, responsedMessage, z) == null) {
            if (!this.b) {
                this.b = true;
                h(1, false, responsedMessage);
            }
            j(z, false, responsedMessage);
        }
    }

    public void m(int i, int i2, @NonNull wh5 wh5Var, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), wh5Var, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            RecPersonalizeRequest f2 = f(1, 0, wh5Var, 1, 0);
            f2.setNetType(NetMessage.NetType.HTTP);
            c80.e(f2.getHttpMessage(), this.d);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, io8.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            this.d = tbHttpMessageTask;
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            this.d.setResponsedClass(RecPersonalizeHttpResponse.class);
            this.d.setTimeOut(yb.d().b());
            this.d.setRetry(yb.d().a());
            this.d.setConnectTimeOut(yb.d().c());
            this.d.setPriority(4);
            MessageManager.getInstance().registerTask(this.d);
        }
    }
}
