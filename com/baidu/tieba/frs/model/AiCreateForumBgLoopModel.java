package com.baidu.tieba.frs.model;

import android.os.CountDownTimer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.model.AiCreateForumBgLoopModel;
import com.baidu.tieba.frs.model.AiCreateForumBgLoopModel$loopListener$2;
import com.baidu.tieba.k28;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0002\u0010\u001c\u0018\u00002\u00020\u0001:\u0002+,B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u001e\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\u000e\u0010&\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010'\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020!H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006-"}, d2 = {"Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel;", "", "()V", "countDownTimer", "Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel$SafeCountDownTimer;", "getCountDownTimer", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel$SafeCountDownTimer;", "countDownTimer$delegate", "Lkotlin/Lazy;", "loopCallback", "Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel$LoopCallback;", "getLoopCallback", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel$LoopCallback;", "setLoopCallback", "(Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel$LoopCallback;)V", "loopListener", "com/baidu/tieba/frs/model/AiCreateForumBgLoopModel$loopListener$2$1", "getLoopListener", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel$loopListener$2$1;", "loopListener$delegate", "primaryTaskId", "", "tag", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "timer", "Ljava/util/Timer;", "timerTask", "com/baidu/tieba/frs/model/AiCreateForumBgLoopModel$createNewTimerTask$1", "Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel$createNewTimerTask$1;", "createNewTimerTask", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel$createNewTimerTask$1;", "destroy", "", "registerHttpTask", "registerListener", "registerTaskAndListener", "requestData", "startLoop", "stopLoop", "useCallBack", "", "unRegisterTaskAndListener", "LoopCallback", "SafeCountDownTimer", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AiCreateForumBgLoopModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public Timer c;
    public a d;
    public final Lazy e;
    public c f;
    public final Lazy g;

    /* loaded from: classes6.dex */
    public interface a {

        /* renamed from: com.baidu.tieba.frs.model.AiCreateForumBgLoopModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0283a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public static void a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(65536, null, aVar) == null) {
                }
            }

            public static void b(a aVar, k28 loopData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(65537, null, aVar, loopData) == null) {
                    Intrinsics.checkNotNullParameter(loopData, "loopData");
                }
            }
        }

        void a(k28 k28Var);

        void onError();
    }

    /* loaded from: classes6.dex */
    public static final class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AiCreateForumBgLoopModel> a;

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AiCreateForumBgLoopModel loopModel, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loopModel, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(loopModel, "loopModel");
            this.a = new WeakReference<>(loopModel);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DefaultLog.getInstance().i("AiCreateForumBgLoop", "轮询超时 停止轮询");
                AiCreateForumBgLoopModel aiCreateForumBgLoopModel = this.a.get();
                if (aiCreateForumBgLoopModel != null) {
                    aiCreateForumBgLoopModel.l(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AiCreateForumBgLoopModel a;

        public c(AiCreateForumBgLoopModel aiCreateForumBgLoopModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aiCreateForumBgLoopModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aiCreateForumBgLoopModel;
        }

        public static final void a(AiCreateForumBgLoopModel this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.i();
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeHandler inst = SafeHandler.getInst();
                final AiCreateForumBgLoopModel aiCreateForumBgLoopModel = this.a;
                inst.post(new Runnable() { // from class: com.baidu.tieba.j28
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            AiCreateForumBgLoopModel.c.a(AiCreateForumBgLoopModel.this);
                        }
                    }
                });
            }
        }
    }

    public AiCreateForumBgLoopModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.c = new Timer();
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<AiCreateForumBgLoopModel$loopListener$2.a>(this) { // from class: com.baidu.tieba.frs.model.AiCreateForumBgLoopModel$loopListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AiCreateForumBgLoopModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes6.dex */
            public static final class a extends HttpMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AiCreateForumBgLoopModel a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(AiCreateForumBgLoopModel aiCreateForumBgLoopModel) {
                    super(CmdConfigHttp.CMD_AI_CREATE_FORUM_BG_MESSAGE);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aiCreateForumBgLoopModel};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aiCreateForumBgLoopModel;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003586 && (httpResponsedMessage instanceof AiCreateForumBgLoopRespondedMessage)) {
                            AiCreateForumBgLoopRespondedMessage aiCreateForumBgLoopRespondedMessage = (AiCreateForumBgLoopRespondedMessage) httpResponsedMessage;
                            if (aiCreateForumBgLoopRespondedMessage.getError() != 0) {
                                TbLog defaultLog = DefaultLog.getInstance();
                                defaultLog.i("AiCreateForumBgLoop", "请求结束，返回错误，停止轮询，错误码为：" + aiCreateForumBgLoopRespondedMessage.getError());
                                AiCreateForumBgLoopModel.m(this.a, false, 1, null);
                                AiCreateForumBgLoopModel.a d = this.a.d();
                                if (d != null) {
                                    d.onError();
                                    return;
                                }
                                return;
                            }
                            k28 aiCreateForumBgLoopData = aiCreateForumBgLoopRespondedMessage.getAiCreateForumBgLoopData();
                            if (aiCreateForumBgLoopData != null) {
                                AiCreateForumBgLoopModel aiCreateForumBgLoopModel = this.a;
                                DefaultLog.getInstance().i("AiCreateForumBgLoop", "请求结束，有返回数据");
                                if (aiCreateForumBgLoopData.b()) {
                                    DefaultLog.getInstance().i("AiCreateForumBgLoop", "请求结束，有返回数据，已经生成表情, 停止轮询");
                                    AiCreateForumBgLoopModel.m(aiCreateForumBgLoopModel, false, 1, null);
                                    AiCreateForumBgLoopModel.a d2 = aiCreateForumBgLoopModel.d();
                                    if (d2 != null) {
                                        d2.a(aiCreateForumBgLoopData);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            AiCreateForumBgLoopModel aiCreateForumBgLoopModel2 = this.a;
                            DefaultLog.getInstance().i("AiCreateForumBgLoop", "请求结束，返回数据为空，结束轮询");
                            AiCreateForumBgLoopModel.m(aiCreateForumBgLoopModel2, false, 1, null);
                            AiCreateForumBgLoopModel.a d3 = aiCreateForumBgLoopModel2.d();
                            if (d3 != null) {
                                d3.onError();
                                return;
                            }
                            return;
                        }
                        DefaultLog.getInstance().i("AiCreateForumBgLoop", "请求结束，数据不合法，停止轮询");
                        AiCreateForumBgLoopModel.m(this.a, false, 1, null);
                        AiCreateForumBgLoopModel.a d4 = this.a.d();
                        if (d4 != null) {
                            d4.onError();
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this.this$0);
                }
                return (a) invokeV.objValue;
            }
        });
        this.f = b();
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<b>(this) { // from class: com.baidu.tieba.frs.model.AiCreateForumBgLoopModel$countDownTimer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AiCreateForumBgLoopModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AiCreateForumBgLoopModel.b invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new AiCreateForumBgLoopModel.b(this.this$0, 15000L, 500L);
                }
                return (AiCreateForumBgLoopModel.b) invokeV.objValue;
            }
        });
        h();
    }

    public final void j(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public static /* synthetic */ void m(AiCreateForumBgLoopModel aiCreateForumBgLoopModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        aiCreateForumBgLoopModel.l(z);
    }

    public final c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new c(this);
        }
        return (c) invokeV.objValue;
    }

    public final b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (b) this.g.getValue();
        }
        return (b) invokeV.objValue;
    }

    public final a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (a) invokeV.objValue;
    }

    public final AiCreateForumBgLoopModel$loopListener$2.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (AiCreateForumBgLoopModel$loopListener$2.a) this.e.getValue();
        }
        return (AiCreateForumBgLoopModel$loopListener$2.a) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e().setSelfListener(true);
            MessageManager.getInstance().registerListener(e());
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f();
            g();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AI_CREATE_FORUM_BG_MESSAGE);
            httpMessage.setTag(this.a);
            httpMessage.addParam("primary_task_id", this.b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AI_CREATE_FORUM_BG_MESSAGE, TbConfig.SERVER_ADDRESS + "c/f/forum/queryAIPic");
            tbHttpMessageTask.setResponsedClass(AiCreateForumBgLoopRespondedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void k(String primaryTaskId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, primaryTaskId) == null) {
            Intrinsics.checkNotNullParameter(primaryTaskId, "primaryTaskId");
            this.b = primaryTaskId;
            this.c.cancel();
            c().cancel();
            this.a = BdUniqueId.gen();
            e().setTag(this.a);
            this.c = new Timer();
            this.f = b();
            c().start();
            this.c.schedule(this.f, 0L, 500L);
        }
    }

    @JvmOverloads
    public final void l(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            DefaultLog.getInstance().i("AiCreateForumBgLoop", "结束轮询");
            this.c.cancel();
            c().cancel();
            e().setTag(null);
            if (z && (aVar = this.d) != null) {
                aVar.onError();
            }
        }
    }
}
