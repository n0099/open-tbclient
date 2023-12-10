package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMEmojiReplyListener;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ku5;
import com.baidu.tieba.livesdk.AlaLiveSdkStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ih9 extends fg1<sk5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements sk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final c c;
        public final IChatRoomMsgReceiveListener d;
        public final Map<Long, ku5> e;
        public final Map<dl5, IConnectListener> f;
        public final b g;

        public final long y(int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                if (i2 == 2) {
                    return 0L;
                }
                return j2;
            }
            return invokeCommon.longValue;
        }

        /* loaded from: classes6.dex */
        public class e implements b.InterfaceC0328b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kl5 a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ a c;

            /* loaded from: classes6.dex */
            public class b implements zk5 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                /* renamed from: com.baidu.tieba.ih9$a$e$b$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0320a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;
                    public final /* synthetic */ int b;
                    public final /* synthetic */ String c;
                    public final /* synthetic */ b d;

                    public RunnableC0320a(b bVar, long j, int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {bVar, Long.valueOf(j), Integer.valueOf(i), str};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.d = bVar;
                        this.a = j;
                        this.b = i;
                        this.c = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        kl5 kl5Var;
                        Interceptable interceptable = $ic;
                        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (kl5Var = this.d.a.a) != null) {
                            kl5Var.b(this.a, this.b, this.c);
                        }
                    }
                }

                public b(e eVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = eVar;
                }

                @Override // com.baidu.tieba.zk5
                public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                        UiUtils.runOnUiThread(new RunnableC0320a(this, j, i, str));
                    }
                }
            }

            /* renamed from: com.baidu.tieba.ih9$a$e$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0319a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ e b;

                public RunnableC0319a(e eVar, long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar, Long.valueOf(j)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = eVar;
                    this.a = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    kl5 kl5Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (kl5Var = this.b.a) != null) {
                        kl5Var.a(this.a);
                    }
                }
            }

            public e(a aVar, kl5 kl5Var, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, kl5Var, context};
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
                this.a = kl5Var;
                this.b = context;
            }

            @Override // com.baidu.tieba.ih9.b.InterfaceC0328b
            public void a(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    th9.j(j);
                    UiUtils.runOnUiThread(new RunnableC0319a(this, j));
                    this.c.l(this.b, j, new b(this));
                }
            }
        }

        /* renamed from: com.baidu.tieba.ih9$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0316a implements IChatRoomMsgReceiveListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.ih9$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0317a implements Function1<cl5, Void> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ long b;
                public final /* synthetic */ TreeSet c;

                public C0317a(C0316a c0316a, int i, long j, TreeSet treeSet) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0316a, Integer.valueOf(i), Long.valueOf(j), treeSet};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = i;
                    this.b = j;
                    this.c = treeSet;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a */
                public Void invoke(cl5 cl5Var) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cl5Var)) == null) {
                        cl5Var.a(this.a, this.b, this.c);
                        return null;
                    }
                    return (Void) invokeL.objValue;
                }
            }

            public C0316a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener
            public void onReceiveMessage(int i, long j, List<ChatMsg> list) {
                boolean z;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list}) != null) || list.isEmpty()) {
                    return;
                }
                if (j == 9) {
                    long j2 = JavaTypesHelper.toLong(list.get(0).getContacterId(), -1L);
                    if (j2 < 0) {
                        return;
                    }
                    j = j2;
                    z = true;
                } else {
                    z = false;
                }
                this.a.g.h(j, list);
                this.a.A(list);
                TreeSet treeSet = new TreeSet(sk5.b);
                treeSet.addAll(list);
                this.a.c.c(j, z, new C0317a(this, i, j, treeSet));
            }
        }

        /* loaded from: classes6.dex */
        public class c implements IFetchMsgByIdListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ b55 e;
            public final /* synthetic */ gl5 f;
            public final /* synthetic */ a g;

            /* renamed from: com.baidu.tieba.ih9$a$c$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0318a implements d55<List<? extends ChatMsg>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ ArrayList c;
                public final /* synthetic */ c d;

                public C0318a(c cVar, int i, String str, ArrayList arrayList) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar, Integer.valueOf(i), str, arrayList};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.d = cVar;
                    this.a = i;
                    this.b = str;
                    this.c = arrayList;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.d55
                /* renamed from: b */
                public void a(@Nullable List<? extends ChatMsg> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        if (list != null) {
                            TreeSet<ChatMsg> treeSet = new TreeSet<>(sk5.b);
                            treeSet.addAll(list);
                            this.d.f.a(this.a, this.b, treeSet);
                            return;
                        }
                        TreeSet<ChatMsg> treeSet2 = new TreeSet<>(sk5.b);
                        treeSet2.addAll(this.c);
                        this.d.f.a(this.a, this.b, treeSet2);
                    }
                }
            }

            public c(a aVar, long j, long j2, boolean z, boolean z2, b55 b55Var, gl5 gl5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), b55Var, gl5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.g = aVar;
                this.a = j;
                this.b = j2;
                this.c = z;
                this.d = z2;
                this.e = b55Var;
                this.f = gl5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), arrayList}) != null) {
                    return;
                }
                this.g.A(arrayList);
                int size = arrayList.size();
                if (i != 0 || size < 2) {
                    th9.e(this.a, this.b, i3, this.c, this.d, i, str, size);
                }
                b55 b55Var = this.e;
                if (b55Var != null) {
                    b55Var.d(arrayList);
                    this.e.f(new C0318a(this, i, str, arrayList));
                    this.e.a(Long.valueOf(this.a), arrayList);
                    return;
                }
                TreeSet<ChatMsg> treeSet = new TreeSet<>(sk5.b);
                treeSet.addAll(arrayList);
                this.f.a(i, str, treeSet);
            }
        }

        /* loaded from: classes6.dex */
        public class f implements ku5.c<ku5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ int b;
            public final /* synthetic */ long c;
            public final /* synthetic */ bl5 d;
            public final /* synthetic */ List e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.ih9$a$f$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0321a implements IChatRoomListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ku5.c b;
                public final /* synthetic */ f c;

                public C0321a(f fVar, boolean z, ku5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = fVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        th9.h(this.c.c, i, str);
                        if (i != 0) {
                            if (this.a) {
                                th9.n("im_group_enter_auto_retry_", this.c.c);
                                this.c.f.e.remove(Long.valueOf(this.c.c));
                                f fVar = this.c;
                                fVar.d.a(fVar.b, fVar.c, fVar.e, i, str);
                                return;
                            }
                            this.b.a(false, null);
                            return;
                        }
                        for (Long l : this.c.e) {
                            this.c.f.g.f(l.longValue());
                        }
                        th9.n("im_group_enter_auto_retry_", this.c.c);
                        this.c.f.e.remove(Long.valueOf(this.c.c));
                        f fVar2 = this.c;
                        fVar2.d.a(fVar2.b, fVar2.c, fVar2.e, i, str);
                    }
                }
            }

            public f(a aVar, Context context, int i, long j, bl5 bl5Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Integer.valueOf(i), Long.valueOf(j), bl5Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.a = context;
                this.b = i;
                this.c = j;
                this.d = bl5Var;
                this.e = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ku5.c
            /* renamed from: b */
            public void a(boolean z, ku5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) {
                    Context context = this.a;
                    int i = this.b;
                    BIMManager.enterChatRoomGroup(context, 9L, i, this.f.y(i, this.c), new C0321a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class g implements ku5.c<ku5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ int b;
            public final /* synthetic */ long c;
            public final /* synthetic */ bl5 d;
            public final /* synthetic */ List e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.ih9$a$g$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0322a implements IChatRoomListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ku5.c b;
                public final /* synthetic */ g c;

                public C0322a(g gVar, boolean z, ku5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = gVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        th9.i(this.c.c, i, str);
                        if (i != 0) {
                            if (this.a) {
                                th9.n("im_group_exit_auto_retry_", this.c.c);
                                this.c.f.e.remove(Long.valueOf(this.c.c));
                                g gVar = this.c;
                                gVar.d.a(gVar.b, gVar.c, gVar.e, i, str);
                                return;
                            }
                            this.b.a(false, null);
                            return;
                        }
                        for (Long l : this.c.e) {
                            this.c.f.g.d(l.longValue());
                        }
                        th9.n("im_group_exit_auto_retry_", this.c.c);
                        this.c.f.e.remove(Long.valueOf(this.c.c));
                        g gVar2 = this.c;
                        gVar2.d.a(gVar2.b, gVar2.c, gVar2.e, i, str);
                    }
                }
            }

            public g(a aVar, Context context, int i, long j, bl5 bl5Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Integer.valueOf(i), Long.valueOf(j), bl5Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.a = context;
                this.b = i;
                this.c = j;
                this.d = bl5Var;
                this.e = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ku5.c
            /* renamed from: b */
            public void a(boolean z, ku5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) {
                    Context context = this.a;
                    int i = this.b;
                    BIMManager.exitChatRoomGroup(context, 9L, i, this.f.y(i, this.c), new C0322a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class h implements ku5.c<ku5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ long b;
            public final /* synthetic */ zk5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.ih9$a$h$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0323a implements IChatRoomEnterListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ku5.c b;
                public final /* synthetic */ h c;

                public C0323a(h hVar, boolean z, ku5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {hVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = hVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener
                public void onResult(int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, chatRoomInfo) == null) {
                        th9.f(this.c.b, i, str);
                        if (i != 0) {
                            if (this.a) {
                                th9.n("im_enter_auto_retry_", this.c.b);
                                this.c.d.e.remove(Long.valueOf(this.c.b));
                                h hVar = this.c;
                                hVar.c.a(hVar.b, i, str, chatRoomInfo);
                                return;
                            }
                            this.b.a(false, null);
                            return;
                        }
                        this.c.d.g.f(this.c.b);
                        th9.n("im_enter_auto_retry_", this.c.b);
                        this.c.d.e.remove(Long.valueOf(this.c.b));
                        h hVar2 = this.c;
                        hVar2.c.a(hVar2.b, i, str, chatRoomInfo);
                    }
                }
            }

            public h(a aVar, Context context, long j, zk5 zk5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Long.valueOf(j), zk5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = context;
                this.b = j;
                this.c = zk5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ku5.c
            /* renamed from: b */
            public void a(boolean z, ku5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) {
                    BIMManager.enterChatRoom(this.a, this.b, new C0323a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class i implements ku5.c<ku5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ long b;
            public final /* synthetic */ WeakReference c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.ih9$a$i$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0324a implements IChatRoomExitListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ku5.c b;
                public final /* synthetic */ i c;

                public C0324a(i iVar, boolean z, ku5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = iVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomExitListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        th9.g(this.c.b, i, str);
                        if (i != 0) {
                            if (this.a) {
                                th9.n("im_exit_auto_retry_", this.c.b);
                                this.c.d.e.remove(Long.valueOf(this.c.b));
                                if (this.c.c.get() != null) {
                                    ((al5) this.c.c.get()).a(this.c.b, i, str);
                                    return;
                                }
                                return;
                            }
                            this.b.a(false, null);
                            return;
                        }
                        this.c.d.g.d(this.c.b);
                        th9.n("im_exit_auto_retry_", this.c.b);
                        this.c.d.e.remove(Long.valueOf(this.c.b));
                        if (this.c.c.get() != null) {
                            ((al5) this.c.c.get()).a(this.c.b, i, str);
                        }
                    }
                }
            }

            public i(a aVar, Context context, long j, WeakReference weakReference) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Long.valueOf(j), weakReference};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = context;
                this.b = j;
                this.c = weakReference;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ku5.c
            /* renamed from: b */
            public void a(boolean z, ku5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) {
                    BIMManager.exitChatRoom(this.a, this.b, new C0324a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class k implements BIMValueCallBack<List<String>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hl5 a;

            /* renamed from: com.baidu.tieba.ih9$a$k$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0325a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List a;
                public final /* synthetic */ k b;

                public RunnableC0325a(k kVar, List list) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {kVar, list};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = kVar;
                    this.a = list;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.a(this.a);
                    }
                }
            }

            public k(a aVar, hl5 hl5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hl5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hl5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i, String str, List<String> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, list) == null) {
                    UiUtils.runOnUiThread(new RunnableC0325a(this, list));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class l implements IMEmojiReplyListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ il5 a;
            public final /* synthetic */ String b;
            public final /* synthetic */ ChatMsg c;

            /* renamed from: com.baidu.tieba.ih9$a$l$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0326a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ l c;

                public RunnableC0326a(l lVar, int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {lVar, Integer.valueOf(i), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = lVar;
                    this.a = i;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        int i = this.a;
                        if (i == 0) {
                            l lVar = this.c;
                            lVar.a.a(lVar.b, lVar.c);
                            return;
                        }
                        l lVar2 = this.c;
                        lVar2.a.b(i, this.b, lVar2.b, lVar2.c);
                    }
                }
            }

            public l(a aVar, il5 il5Var, String str, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, il5Var, str, chatMsg};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = il5Var;
                this.b = str;
                this.c = chatMsg;
            }

            @Override // com.baidu.android.imsdk.mcast.IMEmojiReplyListener
            public void onResult(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.i("send emoji reply request result: " + i + "\t" + str);
                    }
                    UiUtils.runOnUiThread(new RunnableC0326a(this, i, str));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class m implements IMEmojiReplyListListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fl5 a;

            /* renamed from: com.baidu.tieba.ih9$a$m$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0327a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMEmojiReplyListListener.IMEmojiReplyListResponse a;
                public final /* synthetic */ m b;

                public RunnableC0327a(m mVar, IMEmojiReplyListListener.IMEmojiReplyListResponse iMEmojiReplyListResponse) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mVar, iMEmojiReplyListResponse};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = mVar;
                    this.a = iMEmojiReplyListResponse;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.onSuccess(this.a.emojiReplyMap);
                    }
                }
            }

            /* loaded from: classes6.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ m c;

                public b(m mVar, int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mVar, Integer.valueOf(i), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = mVar;
                    this.a = i;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.c.a.onFailure(this.a, this.b);
                    }
                }
            }

            public m(a aVar, fl5 fl5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fl5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fl5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener
            public void onResult(int i, String str, int i2, IMEmojiReplyListListener.IMEmojiReplyListResponse iMEmojiReplyListResponse) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), iMEmojiReplyListResponse}) == null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.i("fetch emoji list result: " + i + "\t" + str);
                    }
                    if (i == 0 && i2 == 1 && iMEmojiReplyListResponse != null) {
                        UiUtils.runOnUiThread(new RunnableC0327a(this, iMEmojiReplyListResponse));
                        return;
                    }
                    if (i2 != 1 && BdLog.isDebugMode()) {
                        BdLog.i("the packageId(" + i2 + ") is error!");
                    }
                    UiUtils.runOnUiThread(new b(this, i, str));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements IMEmojiReplyDetailListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ el5 a;

            public b(a aVar, el5 el5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, el5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = el5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener
            public void onResult(int i, String str, IMEmojiReplyDetailListener.IMEmojiReplyDetailResponse iMEmojiReplyDetailResponse) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, iMEmojiReplyDetailResponse) == null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.i("fetch emoji reply detail result: " + i + "\t" + str);
                    }
                    if (i == 0 && iMEmojiReplyDetailResponse != null) {
                        this.a.a(iMEmojiReplyDetailResponse.hasMore, iMEmojiReplyDetailResponse.emojiReplyDetailList);
                    } else {
                        this.a.onFailure(i, str);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements IConnectListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dl5 a;

            public d(a aVar, dl5 dl5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dl5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dl5Var;
            }

            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    this.a.onResult(i);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class j implements ISendMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jl5 a;

            public j(a aVar, jl5 jl5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jl5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jl5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                    this.a.onSendMessageResult(i, chatMsg);
                }
            }
        }

        public a(ih9 ih9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            AlaLiveSdkStatic.n();
            this.c = new c(null);
            this.d = new C0316a(this);
            this.e = new HashMap();
            this.f = new HashMap();
            this.g = new b(null);
        }

        @Override // com.baidu.tieba.sk5
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.g.c(j2);
            }
        }

        @Override // com.baidu.tieba.sk5
        public void g(@NonNull dl5 dl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, dl5Var) == null) {
                d dVar = new d(this, dl5Var);
                this.f.put(dl5Var, dVar);
                BIMManager.registerConnectListenerToList(dVar);
            }
        }

        @Override // com.baidu.tieba.sk5
        public void k(@NonNull dl5 dl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dl5Var) == null) {
                BIMManager.unregisterConnectListenerFromList(this.f.remove(dl5Var));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void c(@NonNull Context context, long j2, @Nullable kl5 kl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j2), kl5Var}) == null) {
                this.g.i(j2, new e(this, kl5Var, context.getApplicationContext()));
            }
        }

        public final void A(@NonNull List<ChatMsg> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                for (ChatMsg chatMsg : list) {
                    if (StringUtils.isNull(chatMsg.getMsgKey())) {
                        chatMsg.setMsgKey(String.valueOf(chatMsg.getMsgId()));
                    }
                }
            }
        }

        @Nullable
        public final String x(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("zid", TbadkCoreApplication.getInst().getZid(context, TbadkCoreApplication.getCurrentAccount(), 0, null));
                    jSONObject.put("haotianjing", jSONObject2);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    BdLog.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        @NonNull
        public final ku5 z(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j2)) == null) {
                ku5 ku5Var = this.e.get(Long.valueOf(j2));
                if (ku5Var == null) {
                    ku5 g2 = ku5.g();
                    this.e.put(Long.valueOf(j2), g2);
                    return g2;
                }
                ku5Var.h();
                return ku5Var;
            }
            return (ku5) invokeJ.objValue;
        }

        @Override // com.baidu.tieba.sk5
        public void b(@NonNull Context context, @NonNull String str, long j2, @NonNull ChatMsg chatMsg, boolean z, @NonNull il5 il5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, Long.valueOf(j2), chatMsg, Boolean.valueOf(z), il5Var}) == null) {
                IMEmojiReplyListener.IMEmojiReplyRequestInfo iMEmojiReplyRequestInfo = new IMEmojiReplyListener.IMEmojiReplyRequestInfo();
                iMEmojiReplyRequestInfo.emojiContent = str;
                iMEmojiReplyRequestInfo.toUser = j2;
                int i2 = 1;
                iMEmojiReplyRequestInfo.emojiPackageId = 1;
                iMEmojiReplyRequestInfo.msg = chatMsg;
                if (!z) {
                    i2 = 2;
                }
                iMEmojiReplyRequestInfo.opType = i2;
                if (BdLog.isDebugMode()) {
                    BdLog.i("start send emoji reply request");
                }
                BIMManager.emojiReplyForChatRoom(context, iMEmojiReplyRequestInfo, new l(this, il5Var, str, chatMsg));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void d(@NonNull Context context, long j2, @NonNull cl5 cl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), cl5Var}) == null) {
                this.c.a(-1, 0L, j2, cl5Var);
                BIMManager.registerChatRoomMsgReceiveListener(context, j2, this.d);
            }
        }

        @Override // com.baidu.tieba.sk5
        public void l(@NonNull Context context, long j2, @NonNull zk5 zk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Long.valueOf(j2), zk5Var}) == null) {
                Context applicationContext = context.getApplicationContext();
                ku5 z = z(j2);
                th9.d("im_enter_auto_retry_", j2);
                z.i(new h(this, applicationContext, j2, zk5Var));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void o(@NonNull Context context, long j2, @NonNull cl5 cl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j2), cl5Var}) == null) {
                this.c.d(-1, 0L, j2, cl5Var);
                BIMManager.unregisterChatRoomMsgReceiveListener(context, j2, this.d);
            }
        }

        @Override // com.baidu.tieba.sk5
        public void r(@NonNull Context context, long j2, @NonNull al5 al5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{context, Long.valueOf(j2), al5Var}) == null) {
                Context applicationContext = context.getApplicationContext();
                WeakReference weakReference = new WeakReference(al5Var);
                ku5 z = z(j2);
                th9.d("im_exit_auto_retry_", j2);
                z.i(new i(this, applicationContext, j2, weakReference));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void e(@NonNull Context context, boolean z, int i2, @NonNull hl5 hl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2), hl5Var}) == null) {
                BIMManager.getUsedEmoji(context, 1, 4, z, i2, new k(this, hl5Var));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void n(@NonNull Context context, long j2, @NonNull ChatMsg chatMsg, @NonNull jl5 jl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j2), chatMsg, jl5Var}) == null) {
                BIMManager.sendMsgToChatRoomWithSafeParam(context, j2, BIMManager.getBdUKFromBdUid(chatMsg.getSenderUid()), chatMsg, x(context), new j(this, jl5Var));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void f(@NonNull Context context, int i2, long j2, @NonNull List<Long> list, @NonNull cl5 cl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), list, cl5Var}) == null) {
                for (Long l2 : list) {
                    gu5.b(l2);
                    this.c.d(i2, j2, l2.longValue(), cl5Var);
                }
                if (!this.c.b()) {
                    BIMManager.unregisterChatRoomGroupMsgReceiveListener(context, 9L, this.d);
                }
            }
        }

        @Override // com.baidu.tieba.sk5
        public void j(@NonNull Context context, int i2, long j2, @NonNull List<Long> list, @NonNull cl5 cl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), list, cl5Var}) == null) {
                if (!this.c.b()) {
                    BIMManager.registerChatRoomGroupMsgReceiveListener(context, 9L, this.d);
                }
                for (Long l2 : list) {
                    gu5.b(l2);
                    this.c.a(i2, j2, l2.longValue(), cl5Var);
                }
            }
        }

        @Override // com.baidu.tieba.sk5
        public void m(@NonNull Context context, int i2, long j2, @NonNull List<Long> list, @NonNull bl5 bl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), list, bl5Var}) == null) {
                Context applicationContext = context.getApplicationContext();
                ku5 z = z(j2);
                th9.d("im_group_exit_auto_retry_", j2);
                z.i(new g(this, applicationContext, i2, j2, bl5Var, list));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void q(@NonNull Context context, int i2, long j2, @NonNull List<Long> list, @NonNull bl5 bl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), list, bl5Var}) == null) {
                Context applicationContext = context.getApplicationContext();
                ku5 z = z(j2);
                th9.d("im_group_enter_auto_retry_", j2);
                z.i(new f(this, applicationContext, i2, j2, bl5Var, list));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void h(@NonNull Context context, long j2, long j3, int i2, boolean z, boolean z2, @Nullable b55<List<? extends ChatMsg>> b55Var, @NonNull gl5 gl5Var) {
            int i3;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), b55Var, gl5Var}) == null) {
                long j5 = 0;
                if (z) {
                    j4 = Long.MAX_VALUE;
                    i3 = i2 * (-1);
                } else if (z2) {
                    j4 = j3;
                    i3 = i2 * (-1);
                } else {
                    j5 = j3;
                    i3 = i2;
                    j4 = Long.MAX_VALUE;
                }
                BIMManager.fetchChatRoomMsgRequest(context, 10773430L, AccountManager.getUK(context), 4, j2, j5, j4, i3, z ? 1 : 0, new c(this, j2, j5, z, z2, b55Var, gl5Var));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void i(@NonNull Context context, long j2, @NonNull List<ChatMsg> list, @NonNull fl5 fl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Long.valueOf(j2), list, fl5Var}) == null) {
                IMEmojiReplyListListener.IMEmojiReplyListRequestInfo iMEmojiReplyListRequestInfo = new IMEmojiReplyListListener.IMEmojiReplyListRequestInfo();
                iMEmojiReplyListRequestInfo.emojiPackageId = 1;
                iMEmojiReplyListRequestInfo.roomId = j2;
                for (ChatMsg chatMsg : list) {
                    if (chatMsg.hasReaction()) {
                        iMEmojiReplyListRequestInfo.msgs.add(Long.valueOf(chatMsg.getMsgId()));
                    }
                }
                if (BdLog.isDebugMode()) {
                    BdLog.i("start fetch emoji list");
                }
                BIMManager.fetchEmojiReplyList(context, iMEmojiReplyListRequestInfo, new m(this, fl5Var));
            }
        }

        @Override // com.baidu.tieba.sk5
        public void p(@NonNull Context context, long j2, long j3, @NonNull String str, long j4, int i2, @NonNull el5 el5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4), Integer.valueOf(i2), el5Var}) == null) {
                IMEmojiReplyDetailListener.IMEmojiReplyDetailRequestInfo iMEmojiReplyDetailRequestInfo = new IMEmojiReplyDetailListener.IMEmojiReplyDetailRequestInfo();
                iMEmojiReplyDetailRequestInfo.roomId = j2;
                iMEmojiReplyDetailRequestInfo.msgId = j3;
                iMEmojiReplyDetailRequestInfo.emojiContent = str;
                iMEmojiReplyDetailRequestInfo.emojiPackageId = 1L;
                iMEmojiReplyDetailRequestInfo.sortTimeBegin = j4;
                iMEmojiReplyDetailRequestInfo.sortTimeEnd = Long.MAX_VALUE;
                iMEmojiReplyDetailRequestInfo.fetchCount = i2;
                if (BdLog.isDebugMode()) {
                    BdLog.i("start fetch emoji reply detail");
                }
                BIMManager.fetchEmojiReplyDetail(context, iMEmojiReplyDetailRequestInfo, new b(this, el5Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final long d;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Long, Integer> a;
        public final Map<Long, c> b;
        public final Runnable c;

        /* renamed from: com.baidu.tieba.ih9$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public interface InterfaceC0328b {
            void a(long j);
        }

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (b.class) {
                        for (Map.Entry entry : this.a.b.entrySet()) {
                            Long l = (Long) entry.getKey();
                            c cVar = (c) entry.getValue();
                            if (cVar.b() && !this.a.g(l.longValue())) {
                                cVar.a().a(l.longValue());
                            }
                            cVar.c(null);
                        }
                        UiUtils.runOnBgThreadDelay(this, b.d);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Nullable
            public List<ChatMsg> a;
            @NonNull
            public final InterfaceC0328b b;

            public c(@NonNull InterfaceC0328b interfaceC0328b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {interfaceC0328b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = interfaceC0328b;
            }

            public void c(@Nullable List<ChatMsg> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                    this.a = list;
                }
            }

            @NonNull
            public InterfaceC0328b a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.b;
                }
                return (InterfaceC0328b) invokeV.objValue;
            }

            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    List<ChatMsg> list = this.a;
                    if (list != null && !list.isEmpty()) {
                        return false;
                    }
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-718405295, "Lcom/baidu/tieba/ih9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-718405295, "Lcom/baidu/tieba/ih9$b;");
                    return;
                }
            }
            d = TimeUnit.SECONDS.toMillis(30L);
        }

        public b() {
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
            this.a = new ConcurrentHashMap();
            this.b = new ConcurrentHashMap();
            this.c = new a(this);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public synchronized void c(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this) {
                    this.b.remove(Long.valueOf(j));
                    if (this.b.isEmpty()) {
                        UiUtils.removeCallbacksOnBgThread(this.c);
                    }
                }
            }
        }

        public synchronized int e(long j) {
            InterceptResult invokeJ;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                synchronized (this) {
                    Integer num = this.a.get(Long.valueOf(j));
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue();
                    }
                }
                return intValue;
            }
            return invokeJ.intValue;
        }

        public synchronized boolean g(long j) {
            InterceptResult invokeJ;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                synchronized (this) {
                    if (e(j) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                return z;
            }
            return invokeJ.booleanValue;
        }

        public synchronized void d(long j) {
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    Integer num = this.a.get(Long.valueOf(j));
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue() - 1;
                    }
                    Integer valueOf = Integer.valueOf(intValue);
                    if (valueOf.intValue() == 0) {
                        this.a.remove(Long.valueOf(j));
                    } else {
                        this.a.put(Long.valueOf(j), valueOf);
                    }
                }
            }
        }

        public synchronized void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                synchronized (this) {
                    Integer num = this.a.get(Long.valueOf(j));
                    int i = 1;
                    if (num != null) {
                        i = 1 + num.intValue();
                    }
                    this.a.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }

        public synchronized void h(long j, @NonNull List<ChatMsg> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048581, this, j, list) == null) {
                synchronized (this) {
                    c cVar = this.b.get(Long.valueOf(j));
                    if (cVar != null) {
                        cVar.c(list);
                    }
                }
            }
        }

        public synchronized void i(long j, @NonNull InterfaceC0328b interfaceC0328b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048582, this, j, interfaceC0328b) == null) {
                synchronized (this) {
                    if (!this.b.containsKey(Long.valueOf(j))) {
                        this.b.put(Long.valueOf(j), new c(interfaceC0328b));
                        if (this.b.size() == 1) {
                            UiUtils.runOnBgThreadDelay(this.c, d);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Long, Set<a>> a;

        /* loaded from: classes6.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final int a;
            @NonNull
            public final cl5 b;

            public a(int i, long j, @NonNull cl5 cl5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), cl5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i;
                this.b = cl5Var;
            }

            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.a;
                }
                return invokeV.intValue;
            }

            @NonNull
            public cl5 c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.b;
                }
                return (cl5) invokeV.objValue;
            }
        }

        public c() {
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
            this.a = new ConcurrentHashMap();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public synchronized void a(int i, long j, long j2, @NonNull cl5 cl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), cl5Var}) == null) {
                synchronized (this) {
                    Set<a> set = this.a.get(Long.valueOf(j2));
                    if (set == null) {
                        set = new HashSet<>();
                        this.a.put(Long.valueOf(j2), set);
                    }
                    set.add(new a(i, j, cl5Var));
                }
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                for (Set<a> set : this.a.values()) {
                    for (a aVar : set) {
                        if (aVar.b() != -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public synchronized void c(long j, boolean z, @NonNull Function1<cl5, Void> function1) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), function1}) == null) {
                synchronized (this) {
                    Set<a> set = this.a.get(Long.valueOf(j));
                    if (set != null) {
                        for (a aVar : set) {
                            if (aVar.b() == -1) {
                                if (!z) {
                                    function1.invoke(aVar.c());
                                }
                            } else if (z) {
                                function1.invoke(aVar.c());
                            }
                        }
                    }
                }
            }
        }

        public synchronized void d(int i, long j, long j2, @NonNull cl5 cl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), cl5Var}) == null) {
                synchronized (this) {
                    Set<a> set = this.a.get(Long.valueOf(j2));
                    if (set != null) {
                        Iterator<a> it = set.iterator();
                        while (it.hasNext()) {
                            if (it.next().b == cl5Var) {
                                it.remove();
                            }
                        }
                        if (set.isEmpty()) {
                            this.a.remove(Long.valueOf(j2));
                        }
                    }
                }
            }
        }
    }

    public ih9() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fg1
    /* renamed from: a */
    public sk5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (sk5) invokeV.objValue;
    }
}
