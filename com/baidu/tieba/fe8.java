package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data.PersonFetchMsgResponse;
import com.baidu.tieba.impersonal.sprite.ImSpriteSysLog;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
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
/* loaded from: classes4.dex */
public final class fe8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final di5 b;
    public final int c;
    public BroadcastReceiver d;
    public final SpriteMsgProcessor e;
    public final mr5<String> f;
    public final String g;
    public final HashSet<b> h;

    /* loaded from: classes4.dex */
    public interface b {
        static {
            a aVar = a.a;
        }

        void a(List<? extends uc8> list);

        void b(int i, String str, zc8<?> zc8Var);

        void c(int i);

        void d(String str);

        void e(int i);

        void onError(int i);

        /* loaded from: classes4.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public static final /* synthetic */ a a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1772590517, "Lcom/baidu/tieba/fe8$b$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1772590517, "Lcom/baidu/tieba/fe8$b$a;");
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

    /* loaded from: classes4.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.fe8.b
        public void b(int i, String errorMsg, zc8<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errorMsg, msg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(msg, "msg");
            }
        }

        @Override // com.baidu.tieba.fe8.b
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.fe8.b
        public void d(String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgKey) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            }
        }

        @Override // com.baidu.tieba.fe8.b
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.fe8.b
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

    public fe8(Context context) {
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
        this.b = ci5.a();
        this.c = 20;
        this.e = new SpriteMsgProcessor(this.a);
        this.f = mr5.c();
        this.g = "fetchMsgFirst";
        this.h = new HashSet<>();
    }

    public static final void c(final fe8 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.w(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(1));
                ng.e(new Runnable() { // from class: com.baidu.tieba.xd8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            fe8.d(fe8.this);
                        }
                    }
                });
            } else {
                dj8 imSpriteSysLog = ImSpriteSysLog.getInstance();
                String s = this$0.e.s();
                StringBuilder sb = new StringBuilder();
                sb.append("fetchHistoryMsg ： responseCode : ");
                sb.append(i);
                sb.append("errMsg : ");
                sb.append(str);
                sb.append("response : ");
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs.size());
                } else {
                    num = null;
                }
                sb.append(num);
                imSpriteSysLog.c(s, sb.toString());
                ng.e(new Runnable() { // from class: com.baidu.tieba.pd8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            fe8.e(fe8.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void n(final fe8 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            BdLog.e(StatConstants.KEY_EXT_ERR_MSG + str);
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.w(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(0));
                ng.e(new Runnable() { // from class: com.baidu.tieba.sd8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            fe8.o(fe8.this);
                        }
                    }
                });
            } else {
                dj8 imSpriteSysLog = ImSpriteSysLog.getInstance();
                String s = this$0.e.s();
                StringBuilder sb = new StringBuilder();
                sb.append("firstFetchMsg ： responseCode : ");
                sb.append(i);
                sb.append("errMsg : ");
                sb.append(str);
                sb.append("response : ");
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs.size());
                } else {
                    num = null;
                }
                sb.append(num);
                imSpriteSysLog.c(s, sb.toString());
                ng.e(new Runnable() { // from class: com.baidu.tieba.be8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            fe8.p(fe8.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void d(fe8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(1);
            }
        }
    }

    public static final void e(fe8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(1);
            }
        }
    }

    public static final void f(fe8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(1);
            }
        }
    }

    public static final void h(fe8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(2);
            }
        }
    }

    public static final void j(fe8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(2);
            }
        }
    }

    public static final void k(fe8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(2);
            }
        }
    }

    public static final void m(fe8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(0);
            }
        }
    }

    public static final void o(fe8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(0);
            }
        }
    }

    public static final void p(fe8 this$0) {
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
            this.e.e(bVar);
        }
    }

    public final void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            ng.e(new Runnable() { // from class: com.baidu.tieba.vd8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fe8.h(fe8.this);
                    }
                }
            });
            this.b.b(this.a, j, Long.MAX_VALUE, this.c, SpriteMsgProcessor.m.a(), new ei5() { // from class: com.baidu.tieba.td8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ei5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        fe8.i(fe8.this, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void t(zc8<?> msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.e.G(msg);
        }
    }

    public final void u(SpriteMsgProcessor.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.e.H(dVar);
        }
    }

    public static final void i(final fe8 this$0, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65542, null, this$0, i, str, personFetchMsgResponse) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.w(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(2));
                ng.e(new Runnable() { // from class: com.baidu.tieba.ae8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            fe8.j(fe8.this);
                        }
                    }
                });
                return;
            }
            dj8 imSpriteSysLog = ImSpriteSysLog.getInstance();
            String s = this$0.e.s();
            StringBuilder sb = new StringBuilder();
            sb.append("fetchNextMsg ： responseCode : ");
            sb.append(i);
            sb.append("errMsg : ");
            sb.append(str);
            sb.append("response : ");
            if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                num = Integer.valueOf(msgs.size());
            } else {
                num = null;
            }
            sb.append(num);
            imSpriteSysLog.c(s, sb.toString());
            ng.e(new Runnable() { // from class: com.baidu.tieba.de8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fe8.k(fe8.this);
                    }
                }
            });
        }
    }

    public final void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.f.b(this.g) && this.f.a("fetchHistoryMsg")) {
            ng.e(new Runnable() { // from class: com.baidu.tieba.ud8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fe8.f(fe8.this);
                    }
                }
            });
            this.b.b(this.a, 0L, j, -this.c, SpriteMsgProcessor.m.a(), new ei5() { // from class: com.baidu.tieba.nd8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ei5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        fe8.c(fe8.this, r2, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void q(Object msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg instanceof zc8) {
                zc8 zc8Var = (zc8) msg;
                if (zc8Var.h() instanceof ChatMsg) {
                    SpriteMsgProcessor spriteMsgProcessor = this.e;
                    Object h = zc8Var.h();
                    if (h != null) {
                        spriteMsgProcessor.z((ChatMsg) h);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.imsdk.chatmessage.messages.ChatMsg");
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            final String str = this.g;
            if (!this.f.a(str)) {
                return;
            }
            ng.e(new Runnable() { // from class: com.baidu.tieba.ee8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fe8.m(fe8.this);
                    }
                }
            });
            this.b.b(this.a, 0L, Long.MAX_VALUE, this.c, SpriteMsgProcessor.m.a(), new ei5() { // from class: com.baidu.tieba.ce8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ei5
                public final void a(int i, String str2, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, personFetchMsgResponse) == null) {
                        fe8.n(fe8.this, str, i, str2, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = this.b.a(this.a, this.e);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.E();
        }
    }

    public final void v() {
        BroadcastReceiver broadcastReceiver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (broadcastReceiver = this.d) != null) {
            di5 di5Var = this.b;
            Context context = this.a;
            Intrinsics.checkNotNull(broadcastReceiver);
            di5Var.c(context, broadcastReceiver);
        }
    }
}
