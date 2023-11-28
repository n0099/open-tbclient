package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data.PersonFetchMsgResponse;
import com.baidu.tieba.impersonal.sprite.ImSpriteSysLog;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final sk5 b;
    public final int c;
    public BroadcastReceiver d;
    public final SpriteMsgProcessor e;
    public final au5<String> f;
    public final String g;
    public final HashSet<b> h;

    /* loaded from: classes5.dex */
    public interface b {
        static {
            a aVar = a.a;
        }

        void a(List<? extends lb9> list);

        void b(int i, String str, qb9<?> qb9Var);

        void c(int i);

        void d(String str);

        void e(int i);

        void onError(int i);

        /* loaded from: classes5.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public static final /* synthetic */ a a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1762558057, "Lcom/baidu/tieba/bd9$b$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1762558057, "Lcom/baidu/tieba/bd9$b$a;");
                        return;
                    }
                }
                a = new a();
            }

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.bd9.b
        public void b(int i, String errorMsg, qb9<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errorMsg, msg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(msg, "msg");
            }
        }

        @Override // com.baidu.tieba.bd9.b
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.bd9.b
        public void d(String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgKey) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            }
        }

        @Override // com.baidu.tieba.bd9.b
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.bd9.b
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public bd9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.b = rk5.a();
        this.c = 20;
        this.e = new SpriteMsgProcessor(this.a);
        this.f = au5.c();
        this.g = "fetchMsgFirst";
        this.h = new HashSet<>();
    }

    public static final void d(final bd9 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        List<ChatMsg> msgs;
        List<ChatMsg> msgs2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            Integer num = null;
            if (i == 0) {
                TbLog imSpriteSysLog = ImSpriteSysLog.getInstance();
                String s = this$0.e.s();
                StringBuilder sb = new StringBuilder();
                sb.append("fetchHistoryMsg success ：  responseCode : ");
                sb.append(i);
                sb.append(" errMsg : ");
                sb.append(str);
                sb.append(" response : ");
                if (personFetchMsgResponse != null && (msgs2 = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs2.size());
                }
                sb.append(num);
                imSpriteSysLog.i(s, sb.toString());
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.m());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.y(SpriteMsgProcessor.n.a(), treeSet, new SpriteMsgProcessor.e(1));
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.sc9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            bd9.e(bd9.this);
                        }
                    }
                });
            } else {
                TbLog imSpriteSysLog2 = ImSpriteSysLog.getInstance();
                String s2 = this$0.e.s();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("fetchHistoryMsg error ：  responseCode : ");
                sb2.append(i);
                sb2.append(" errMsg : ");
                sb2.append(str);
                sb2.append(" response : ");
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs.size());
                }
                sb2.append(num);
                imSpriteSysLog2.i(s2, sb2.toString());
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.jc9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            bd9.f(bd9.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void o(final bd9 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        List<ChatMsg> msgs;
        List<ChatMsg> msgs2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            BdLog.e(StatConstants.KEY_EXT_ERR_MSG + str);
            Integer num = null;
            if (i == 0) {
                TbLog imSpriteSysLog = ImSpriteSysLog.getInstance();
                String s = this$0.e.s();
                StringBuilder sb = new StringBuilder();
                sb.append("firstFetchMsg success ：  responseCode : ");
                sb.append(i);
                sb.append(" errMsg : ");
                sb.append(str);
                sb.append(" response : ");
                if (personFetchMsgResponse != null && (msgs2 = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs2.size());
                }
                sb.append(num);
                imSpriteSysLog.i(s, sb.toString());
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.m());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.y(SpriteMsgProcessor.n.a(), treeSet, new SpriteMsgProcessor.e(0));
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.mc9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            bd9.p(bd9.this);
                        }
                    }
                });
            } else {
                TbLog imSpriteSysLog2 = ImSpriteSysLog.getInstance();
                String s2 = this$0.e.s();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("firstFetchMsg error ：  responseCode : ");
                sb2.append(i);
                sb2.append(" errMsg : ");
                sb2.append(str);
                sb2.append(" response : ");
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs.size());
                }
                sb2.append(num);
                imSpriteSysLog2.i(s2, sb2.toString());
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.xc9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            bd9.q(bd9.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void e(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(1);
            }
        }
    }

    public static final void f(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(1);
            }
        }
    }

    public static final void g(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(1);
            }
        }
    }

    public static final void i(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(2);
            }
        }
    }

    public static final void k(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(2);
            }
        }
    }

    public static final void l(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(2);
            }
        }
    }

    public static final void n(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(0);
            }
        }
    }

    public static final void p(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(0);
            }
        }
    }

    public static final void q(bd9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(0);
            }
        }
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (bVar != null) {
                this.h.add(bVar);
            }
            this.e.f(bVar);
        }
    }

    public final void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.qc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        bd9.i(bd9.this);
                    }
                }
            });
            this.b.b(this.a, j, Long.MAX_VALUE, this.c, SpriteMsgProcessor.n.a(), new tk5() { // from class: com.baidu.tieba.nc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.tk5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        bd9.j(bd9.this, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void u(qb9<?> msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.e.H(msg);
        }
    }

    public final void v(db9 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.e.J(callback);
        }
    }

    public final void w(SpriteMsgProcessor.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.e.I(dVar);
        }
    }

    public static final void j(final bd9 this$0, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        List<ChatMsg> msgs;
        List<ChatMsg> msgs2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65542, null, this$0, i, str, personFetchMsgResponse) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Integer num = null;
            if (i == 0) {
                TbLog imSpriteSysLog = ImSpriteSysLog.getInstance();
                String s = this$0.e.s();
                StringBuilder sb = new StringBuilder();
                sb.append("fetchNextMsg success ：  responseCode : ");
                sb.append(i);
                sb.append(" errMsg : ");
                sb.append(str);
                sb.append(" response : ");
                if (personFetchMsgResponse != null && (msgs2 = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs2.size());
                }
                sb.append(num);
                imSpriteSysLog.i(s, sb.toString());
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.m());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.y(SpriteMsgProcessor.n.a(), treeSet, new SpriteMsgProcessor.e(2));
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.wc9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            bd9.k(bd9.this);
                        }
                    }
                });
                return;
            }
            TbLog imSpriteSysLog2 = ImSpriteSysLog.getInstance();
            String s2 = this$0.e.s();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fetchNextMsg error ：  responseCode : ");
            sb2.append(i);
            sb2.append(" errMsg : ");
            sb2.append(str);
            sb2.append(" response : ");
            if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                num = Integer.valueOf(msgs.size());
            }
            sb2.append(num);
            imSpriteSysLog2.i(s2, sb2.toString());
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.zc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        bd9.l(bd9.this);
                    }
                }
            });
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.e();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d = this.b.a(this.a, this.e);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.G();
        }
    }

    public final void x() {
        BroadcastReceiver broadcastReceiver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (broadcastReceiver = this.d) != null) {
            sk5 sk5Var = this.b;
            Context context = this.a;
            Intrinsics.checkNotNull(broadcastReceiver);
            sk5Var.c(context, broadcastReceiver);
        }
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && this.f.b(this.g) && this.f.a("fetchHistoryMsg")) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.oc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        bd9.g(bd9.this);
                    }
                }
            });
            this.b.b(this.a, 0L, j, -this.c, SpriteMsgProcessor.n.a(), new tk5() { // from class: com.baidu.tieba.hc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.tk5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        bd9.d(bd9.this, r2, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void r(Object msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg instanceof qb9) {
                qb9 qb9Var = (qb9) msg;
                if (qb9Var.h() instanceof ChatMsg) {
                    SpriteMsgProcessor spriteMsgProcessor = this.e;
                    Object h = qb9Var.h();
                    if (h != null) {
                        spriteMsgProcessor.B((ChatMsg) h);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.imsdk.chatmessage.messages.ChatMsg");
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            final String str = this.g;
            if (!this.f.a(str)) {
                return;
            }
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ad9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        bd9.n(bd9.this);
                    }
                }
            });
            this.b.b(this.a, 0L, Long.MAX_VALUE, this.c, SpriteMsgProcessor.n.a(), new tk5() { // from class: com.baidu.tieba.yc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.tk5
                public final void a(int i, String str2, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, personFetchMsgResponse) == null) {
                        bd9.o(bd9.this, str, i, str2, personFetchMsgResponse);
                    }
                }
            });
        }
    }
}
