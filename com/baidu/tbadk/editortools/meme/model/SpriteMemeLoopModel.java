package com.baidu.tbadk.editortools.meme.model;

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
import com.baidu.tbadk.editortools.meme.model.SpriteMemeLoopModel;
import com.baidu.tbadk.editortools.meme.model.SpriteMemeLoopModel$spriteMemeLoopListener$2;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.dg5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.vf5;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0002\u0014\u001e\u0018\u00002\u00020\u0001:\u0002-.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010 \u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\u000e\u0010(\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010)\u001a\u00020#2\b\b\u0002\u0010*\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020#H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006/"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel;", "", "interval", "", "(J)V", "countDownTimer", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$SafeCountDownTimer;", "getCountDownTimer", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$SafeCountDownTimer;", "countDownTimer$delegate", "Lkotlin/Lazy;", "loopCallback", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$LoopCallback;", "getLoopCallback", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$LoopCallback;", "setLoopCallback", "(Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$LoopCallback;)V", "queryId", "", "spriteMemeLoopListener", "com/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$spriteMemeLoopListener$2$1", "getSpriteMemeLoopListener", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$spriteMemeLoopListener$2$1;", "spriteMemeLoopListener$delegate", "tag", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "timer", "Ljava/util/Timer;", "timerTask", "com/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$createNewTimerTask$1", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$createNewTimerTask$1;", "createNewTimerTask", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel$createNewTimerTask$1;", "destroy", "", "registerHttpTask", "registerListener", "registerTaskAndListener", "requestData", "startLoop", "stopLoop", "useCallBack", "", "unRegisterTaskAndListener", "LoopCallback", "SafeCountDownTimer", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteMemeLoopModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public BdUniqueId b;
    public String c;
    public Timer d;
    public a e;
    public final Lazy f;
    public c g;
    public final Lazy h;

    /* loaded from: classes5.dex */
    public interface a {
        void a(dg5 dg5Var);

        void onError();
    }

    /* loaded from: classes5.dex */
    public static final class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<SpriteMemeLoopModel> a;

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SpriteMemeLoopModel spriteMemeLoopModel, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteMemeLoopModel, Long.valueOf(j), Long.valueOf(j2)};
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
            Intrinsics.checkNotNullParameter(spriteMemeLoopModel, "spriteMemeLoopModel");
            this.a = new WeakReference<>(spriteMemeLoopModel);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DefaultLog.getInstance().i("SpriteMemeLoop", "轮询超时 停止轮训");
                SpriteMemeLoopModel spriteMemeLoopModel = this.a.get();
                if (spriteMemeLoopModel != null) {
                    spriteMemeLoopModel.l(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpriteMemeLoopModel a;

        public c(SpriteMemeLoopModel spriteMemeLoopModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteMemeLoopModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spriteMemeLoopModel;
        }

        public static final void a(SpriteMemeLoopModel this$0) {
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
                final SpriteMemeLoopModel spriteMemeLoopModel = this.a;
                inst.post(new Runnable() { // from class: com.baidu.tieba.cg5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            SpriteMemeLoopModel.c.a(SpriteMemeLoopModel.this);
                        }
                    }
                });
            }
        }
    }

    public SpriteMemeLoopModel(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j;
        this.b = BdUniqueId.gen();
        this.d = new Timer();
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<SpriteMemeLoopModel$spriteMemeLoopListener$2.a>(this) { // from class: com.baidu.tbadk.editortools.meme.model.SpriteMemeLoopModel$spriteMemeLoopListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteMemeLoopModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            /* loaded from: classes5.dex */
            public static final class a extends HttpMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SpriteMemeLoopModel a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(SpriteMemeLoopModel spriteMemeLoopModel) {
                    super(CmdConfigHttp.CMD_HTTP_SPRITE_MEME_LOOP);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {spriteMemeLoopModel};
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
                    this.a = spriteMemeLoopModel;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003581 && (httpResponsedMessage instanceof SpriteMemeLoopRespondedMessage)) {
                            SpriteMemeLoopRespondedMessage spriteMemeLoopRespondedMessage = (SpriteMemeLoopRespondedMessage) httpResponsedMessage;
                            if (spriteMemeLoopRespondedMessage.getError() != 0) {
                                TbLog defaultLog = DefaultLog.getInstance();
                                defaultLog.i("SpriteMemeLoop", "请求结束，返回错误，，停止轮训，错误码为：" + spriteMemeLoopRespondedMessage.getError());
                                SpriteMemeLoopModel.m(this.a, false, 1, null);
                                SpriteMemeLoopModel.a d = this.a.d();
                                if (d != null) {
                                    d.onError();
                                    return;
                                }
                                return;
                            }
                            dg5 spriteMemeLoopData = spriteMemeLoopRespondedMessage.getSpriteMemeLoopData();
                            if (spriteMemeLoopData != null) {
                                SpriteMemeLoopModel spriteMemeLoopModel = this.a;
                                DefaultLog.getInstance().i("SpriteMemeLoop", "请求结束，有返回数据");
                                if (spriteMemeLoopData.b() == 0) {
                                    DefaultLog.getInstance().i("SpriteMemeLoop", "请求结束，有返回数据，已经生成表情, 停止轮训");
                                    SpriteMemeLoopModel.m(spriteMemeLoopModel, false, 1, null);
                                    SpriteMemeLoopModel.a d2 = spriteMemeLoopModel.d();
                                    if (d2 != null) {
                                        d2.a(spriteMemeLoopData);
                                    }
                                }
                                if (spriteMemeLoopData.b() == 1) {
                                    DefaultLog.getInstance().i("SpriteMemeLoop", "请求结束，有返回数据，生成表情失败，停止轮训");
                                    SpriteMemeLoopModel.m(spriteMemeLoopModel, false, 1, null);
                                    SpriteMemeLoopModel.a d3 = spriteMemeLoopModel.d();
                                    if (d3 != null) {
                                        d3.onError();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            SpriteMemeLoopModel spriteMemeLoopModel2 = this.a;
                            DefaultLog.getInstance().i("SpriteMemeLoop", "请求结束，返回数据为空，结束轮训");
                            SpriteMemeLoopModel.m(spriteMemeLoopModel2, false, 1, null);
                            SpriteMemeLoopModel.a d4 = spriteMemeLoopModel2.d();
                            if (d4 != null) {
                                d4.onError();
                                return;
                            }
                            return;
                        }
                        DefaultLog.getInstance().i("SpriteMemeLoop", "请求结束，数据不合法，停止轮训");
                        SpriteMemeLoopModel.m(this.a, false, 1, null);
                        SpriteMemeLoopModel.a d5 = this.a.d();
                        if (d5 != null) {
                            d5.onError();
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
        this.g = b();
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<b>(this) { // from class: com.baidu.tbadk.editortools.meme.model.SpriteMemeLoopModel$countDownTimer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteMemeLoopModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
            public final SpriteMemeLoopModel.b invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new SpriteMemeLoopModel.b(this.this$0, vf5.a.a().d(), vf5.a.a().d());
                }
                return (SpriteMemeLoopModel.b) invokeV.objValue;
            }
        });
        h();
    }

    public final void k(String queryId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, queryId) == null) {
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            this.c = queryId;
            this.d.cancel();
            c().cancel();
            this.b = BdUniqueId.gen();
            e().setTag(this.b);
            this.d = new Timer();
            this.g = b();
            c().start();
            this.d.schedule(this.g, 0L, this.a);
        }
    }

    public final void j(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public static /* synthetic */ void m(SpriteMemeLoopModel spriteMemeLoopModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        spriteMemeLoopModel.l(z);
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
            return (b) this.h.getValue();
        }
        return (b) invokeV.objValue;
    }

    public final a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (a) invokeV.objValue;
    }

    public final SpriteMemeLoopModel$spriteMemeLoopListener$2.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (SpriteMemeLoopModel$spriteMemeLoopListener$2.a) this.f.getValue();
        }
        return (SpriteMemeLoopModel$spriteMemeLoopListener$2.a) invokeV.objValue;
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
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_SPRITE_MEME_LOOP);
            httpMessage.setTag(this.b);
            httpMessage.addParam("query_id", this.c);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_SPRITE_MEME_LOOP, TbConfig.SERVER_ADDRESS + "c/f/sprite/checkMemeStatus");
            tbHttpMessageTask.setResponsedClass(SpriteMemeLoopRespondedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @JvmOverloads
    public final void l(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            DefaultLog.getInstance().i("SpriteMemeLoop", "结束轮训");
            this.d.cancel();
            c().cancel();
            e().setTag(null);
            if (z && (aVar = this.e) != null) {
                aVar.onError();
            }
        }
    }
}
