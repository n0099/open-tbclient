package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.livesdk.AlaLiveSdkStatic;
import com.baidu.tieba.tp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* loaded from: classes3.dex */
public class a58 extends pj1<cg5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements cg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<lg5> c;
        @NonNull
        public final Map<Long, mg5> d;
        public final IChatRoomMsgReceiveListener e;
        public final Map<Long, tp5> f;
        public final Map<ng5, IConnectListener> g;
        @NonNull
        public final Map<Long, String> h;

        /* loaded from: classes3.dex */
        public class b implements tp5.c<tp5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ jg5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.a58$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0208a implements IChatRoomEnterListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ tp5.c b;
                public final /* synthetic */ b c;

                public C0208a(b bVar, boolean z, tp5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = bVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener
                public void onResult(int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, chatRoomInfo) == null) {
                        l58.f(this.c.b.longValue(), i, str);
                        if (i != 0) {
                            if (this.a) {
                                l58.k("im_enter_auto_retry_", this.c.b.longValue());
                                b bVar = this.c;
                                bVar.c.a(bVar.b.longValue(), i, str, chatRoomInfo);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        l58.k("im_enter_auto_retry_", this.c.b.longValue());
                        this.c.d.f.remove(this.c.b);
                        b bVar2 = this.c;
                        bVar2.c.a(bVar2.b.longValue(), i, str, chatRoomInfo);
                    }
                }
            }

            public b(a aVar, Context context, Long l, jg5 jg5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, l, jg5Var};
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
                this.b = l;
                this.c = jg5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.tp5.c
            public void call(boolean z, tp5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.enterChatRoom(this.a, this.b.longValue(), new C0208a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements tp5.c<tp5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ kg5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.a58$a$c$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0209a implements IChatRoomExitListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ tp5.c b;
                public final /* synthetic */ c c;

                public C0209a(c cVar, boolean z, tp5.c cVar2) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar, Boolean.valueOf(z), cVar2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = cVar;
                    this.a = z;
                    this.b = cVar2;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomExitListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        l58.g(this.c.b.longValue(), i, str);
                        if (i != 0) {
                            if (this.a) {
                                l58.k("im_exit_auto_retry_", this.c.b.longValue());
                                c cVar = this.c;
                                cVar.c.a(cVar.b.longValue(), i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        l58.k("im_exit_auto_retry_", this.c.b.longValue());
                        this.c.d.f.remove(this.c.b);
                        c cVar2 = this.c;
                        cVar2.c.a(cVar2.b.longValue(), i, str);
                    }
                }
            }

            public c(a aVar, Context context, Long l, kg5 kg5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, l, kg5Var};
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
                this.b = l;
                this.c = kg5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.tp5.c
            public void call(boolean z, tp5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.exitChatRoom(this.a, this.b.longValue(), new C0209a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes3.dex */
        public class e implements IFetchMsgByIdListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ pg5 e;
            public final /* synthetic */ og5 f;

            /* renamed from: com.baidu.tieba.a58$a$e$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0210a implements Function1<List<? extends ChatMsg>, Unit> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ e c;

                public C0210a(e eVar, int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar, Integer.valueOf(i), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = eVar;
                    this.a = i;
                    this.b = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a */
                public Unit invoke(List<? extends ChatMsg> list) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                        TreeSet<ChatMsg> treeSet = new TreeSet<>(cg5.b);
                        treeSet.addAll(list);
                        this.c.f.a(this.a, this.b, treeSet);
                        return null;
                    }
                    return (Unit) invokeL.objValue;
                }
            }

            public e(a aVar, long j, long j2, boolean z, boolean z2, pg5 pg5Var, og5 og5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), pg5Var, og5Var};
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
                this.b = j2;
                this.c = z;
                this.d = z2;
                this.e = pg5Var;
                this.f = og5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), arrayList}) == null) {
                    int size = arrayList.size();
                    if (i != 0 || size < 2) {
                        l58.e(this.a, this.b, i3, this.c, this.d, i, str, size);
                    }
                    pg5 pg5Var = this.e;
                    if (pg5Var != null) {
                        pg5Var.a(this.a, arrayList, new C0210a(this, i, str));
                        return;
                    }
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(cg5.b);
                    treeSet.addAll(arrayList);
                    this.f.a(i, str, treeSet);
                }
            }
        }

        /* renamed from: com.baidu.tieba.a58$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0207a implements IChatRoomMsgReceiveListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0207a(a aVar) {
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
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list}) == null) {
                    for (lg5 lg5Var : this.a.c) {
                        if (lg5Var.a(i, j, list)) {
                            return;
                        }
                    }
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(cg5.b);
                    treeSet.addAll(list);
                    ((mg5) this.a.d.get(Long.valueOf(j))).a(i, j, treeSet);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements ISendMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qg5 a;

            public d(a aVar, qg5 qg5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, qg5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qg5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                    this.a.onSendMessageResult(i, chatMsg);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class f implements IConnectListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ng5 a;

            public f(a aVar, ng5 ng5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ng5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ng5Var;
            }

            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    this.a.onResult(i);
                }
            }
        }

        public a(a58 a58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            AlaLiveSdkStatic.k();
            this.c = new ArrayList();
            this.d = new HashMap();
            this.e = new C0207a(this);
            this.f = new HashMap();
            this.g = new HashMap();
            this.h = new HashMap();
        }

        @Override // com.baidu.tieba.cg5
        public void e(@NonNull ng5 ng5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, ng5Var) == null) {
                f fVar = new f(this, ng5Var);
                this.g.put(ng5Var, fVar);
                BIMManager.registerConnectListenerToList(fVar);
            }
        }

        @Override // com.baidu.tieba.cg5
        public void g(@NonNull ng5 ng5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ng5Var) == null) {
                BIMManager.unregisterConnectListenerFromList(this.g.remove(ng5Var));
            }
        }

        @Override // com.baidu.tieba.cg5
        public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull mg5 mg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, mg5Var) == null) {
                for (Long l : list) {
                    pp5.b(l);
                    if (this.d.get(l) == mg5Var) {
                        BIMManager.unregisterChatRoomMsgReceiveListener(context, l.longValue(), this.e);
                        this.d.remove(l);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.cg5
        public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
                for (Long l : list) {
                    pp5.b(l);
                    Map<Long, String> map = this.h;
                    map.put(l, str + context);
                }
            }
        }

        @Override // com.baidu.tieba.cg5
        public void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable pg5 pg5Var, @NonNull og5 og5Var) {
            int i2;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), pg5Var, og5Var}) == null) {
                long j4 = 0;
                if (z) {
                    j3 = Long.MAX_VALUE;
                    i2 = i * (-1);
                } else if (z2) {
                    j3 = j2;
                    i2 = i * (-1);
                } else {
                    j4 = j2;
                    i2 = i;
                    j3 = Long.MAX_VALUE;
                }
                BIMManager.fetchChatRoomMsgRequest(context, 10773430L, AccountManager.getUK(context), 4, j, j4, j3, i2, z ? 1 : 0, new e(this, j, j4, z, z2, pg5Var, og5Var));
            }
        }

        @Override // com.baidu.tieba.cg5
        public void c(@NonNull Context context, @NonNull List<Long> list, @NonNull mg5 mg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, mg5Var) == null) {
                for (Long l : list) {
                    pp5.b(l);
                    this.d.put(l, mg5Var);
                    BIMManager.registerChatRoomMsgReceiveListener(context, l.longValue(), this.e);
                }
            }
        }

        @Override // com.baidu.tieba.cg5
        public void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull jg5 jg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, list, jg5Var) == null) {
                for (Long l : list) {
                    pp5.b(l);
                    Map<Long, String> map = this.h;
                    map.put(l, str + context);
                    tp5 m = m(l.longValue());
                    l58.d("im_enter_auto_retry_", l.longValue());
                    m.i(new b(this, context, l, jg5Var));
                }
            }
        }

        @Override // com.baidu.tieba.cg5
        public void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull kg5 kg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, list, kg5Var) == null) {
                for (Long l : list) {
                    pp5.b(l);
                    if (!TextUtils.equals(this.h.get(l), str + context)) {
                        kg5Var.a(l.longValue(), -200, "");
                    } else {
                        tp5 m = m(l.longValue());
                        l58.d("im_exit_auto_retry_", l.longValue());
                        m.i(new c(this, context, l, kg5Var));
                    }
                }
            }
        }

        @Override // com.baidu.tieba.cg5
        public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull qg5 qg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, qg5Var}) == null) {
                BIMManager.sendMsgToChatRoom(context, j, BIMManager.getBdUKFromBdUid(chatMsg.getSenderUid()), chatMsg, new d(this, qg5Var));
            }
        }

        @NonNull
        public final tp5 m(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                tp5 tp5Var = this.f.get(Long.valueOf(j));
                if (tp5Var == null) {
                    tp5 g = tp5.g();
                    this.f.put(Long.valueOf(j), g);
                    return g;
                }
                tp5Var.h();
                return tp5Var;
            }
            return (tp5) invokeJ.objValue;
        }
    }

    public a58() {
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
    @Override // com.baidu.tieba.pj1
    /* renamed from: a */
    public cg5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (cg5) invokeV.objValue;
    }
}
