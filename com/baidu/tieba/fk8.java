package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data.PersonFetchMsgResponse;
import com.baidu.tieba.fk8;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fk8 {
    public static /* synthetic */ Interceptable $ic;
    public static final fk8 a;
    public static final po5 b;
    public static final ConcurrentHashMap<Long, List<vk8>> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements ro5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public static final void a(ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(65537, null, arrayList) != null) {
                return;
            }
            fk8.a.e(arrayList);
            gk8.a.a().a(arrayList);
        }

        @Override // com.baidu.tieba.ro5
        public void onReceiveMessage(int i, int i2, final ArrayList<ChatMsg> arrayList) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIIL(1048576, this, i, i2, arrayList) != null) || arrayList == null) {
                return;
            }
            lg.e(new Runnable() { // from class: com.baidu.tieba.dk8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fk8.a.a(arrayList);
                    }
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements qo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk8 a;

        public b(uk8 uk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uk8Var;
        }

        @Override // com.baidu.tieba.qo5
        public void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
            List<ChatMsg> msgs;
            TbBaseMsg tbBaseMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                TreeSet<TbBaseMsg> treeSet = new TreeSet<>(TbBaseMsg.COMPARATOR);
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    for (ChatMsg chatMsg : msgs) {
                        al8<?, ?> a = ik8.c.a(chatMsg.getClass());
                        if (a != null) {
                            Object b = gl8.b(a, tk8.a, chatMsg);
                            if (b instanceof TbBaseMsg) {
                                tbBaseMsg = (TbBaseMsg) b;
                            } else {
                                tbBaseMsg = null;
                            }
                            if (tbBaseMsg != null) {
                                treeSet.add(tbBaseMsg);
                            }
                        } else {
                            throw new IllegalArgumentException("转换器为null，请检查业务逻辑".toString());
                        }
                    }
                }
                uk8 uk8Var = this.a;
                if (str == null) {
                    str = "";
                }
                uk8Var.a(i, str, treeSet);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements so5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbBaseMsg a;
        public final /* synthetic */ wk8 b;

        @Override // com.baidu.tieba.so5
        public void a(ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, chatMsg) == null) {
            }
        }

        public c(TbBaseMsg tbBaseMsg, wk8 wk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbBaseMsg, wk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbBaseMsg;
            this.b = wk8Var;
        }

        @Override // com.baidu.tieba.so5
        public void b(int i, String str, SendMsgResponse sendMsgResponse) {
            TbBaseMsg tbBaseMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, sendMsgResponse) == null) {
                TbBaseMsg tbBaseMsg2 = this.a;
                if (sendMsgResponse != null) {
                    ChatMsg chatMsg = sendMsgResponse.msg;
                    al8<?, ?> a = ik8.c.a(chatMsg.getClass());
                    if (a != null) {
                        Object b = gl8.b(a, tk8.a, chatMsg);
                        if (b instanceof TbBaseMsg) {
                            tbBaseMsg = (TbBaseMsg) b;
                        } else {
                            tbBaseMsg = null;
                        }
                        if (tbBaseMsg == null) {
                            tbBaseMsg = this.a;
                        }
                        tbBaseMsg2 = tbBaseMsg;
                    }
                }
                wk8 wk8Var = this.b;
                if (str == null) {
                    str = "";
                }
                wk8Var.a(i, str, tbBaseMsg2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947767126, "Lcom/baidu/tieba/fk8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947767126, "Lcom/baidu/tieba/fk8;");
                return;
            }
        }
        a = new fk8();
        b = oo5.a();
        c = new ConcurrentHashMap<>();
        b.a(a.getContext(), new a());
    }

    public fk8() {
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

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
            return inst;
        }
        return (Context) invokeV.objValue;
    }

    public static final void h(TbBaseMsg tbMsg, wk8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbMsg, callback) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "$tbMsg");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            a.i(tbMsg, callback);
        }
    }

    public final void g(final TbBaseMsg tbMsg, final wk8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbMsg, callback) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            Intrinsics.checkNotNullParameter(callback, "callback");
            lg.e(new Runnable() { // from class: com.baidu.tieba.ek8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fk8.h(TbBaseMsg.this, callback);
                    }
                }
            });
        }
    }

    public static final void c(long j, long j2, long j3, int i, uk8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            a.d(j, j2, j3, i, callback);
        }
    }

    public final void b(final long j, final long j2, final long j3, final int i, final uk8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            lg.e(new Runnable() { // from class: com.baidu.tieba.ck8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fk8.c(j, j2, j3, i, callback);
                    }
                }
            });
        }
    }

    @WorkerThread
    public final void d(long j, long j2, long j3, int i, uk8 uk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), uk8Var}) == null) {
            b.b(getContext(), j2, j3, i, j, new b(uk8Var));
        }
    }

    @WorkerThread
    public final void e(ArrayList<ChatMsg> arrayList) {
        List<vk8> list;
        TbBaseMsg tbBaseMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            TreeSet<TbBaseMsg> treeSet = new TreeSet<>(TbBaseMsg.COMPARATOR);
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                al8<?, ?> a2 = ik8.c.a(next.getClass());
                if (a2 != null) {
                    Object b2 = gl8.b(a2, tk8.a, next);
                    if (b2 instanceof TbBaseMsg) {
                        tbBaseMsg = (TbBaseMsg) b2;
                    } else {
                        tbBaseMsg = null;
                    }
                    if (tbBaseMsg != null) {
                        treeSet.add(tbBaseMsg);
                    }
                }
            }
            if ((!treeSet.isEmpty()) && (list = c.get(Long.valueOf(treeSet.first().getSessionId()))) != null) {
                for (vk8 vk8Var : list) {
                    vk8Var.a(0, treeSet);
                }
            }
        }
    }

    public final synchronized void f(long j, vk8 listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j, listener) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                if (j == 0) {
                    return;
                }
                List<vk8> list = c.get(Long.valueOf(j));
                if (list == null) {
                    list = new ArrayList<>();
                    c.put(Long.valueOf(j), list);
                }
                list.add(listener);
            }
        }
    }

    @WorkerThread
    public final void i(TbBaseMsg tbBaseMsg, wk8 wk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, tbBaseMsg, wk8Var) == null) {
            al8<?, ?> b2 = ik8.c.b(tbBaseMsg.getClass());
            if (b2 != null) {
                Object a2 = gl8.a(b2, tk8.a, tbBaseMsg);
                if (a2 != null) {
                    ChatMsg chatMsg = (ChatMsg) a2;
                    b.d(getContext(), chatMsg, tbBaseMsg.getSessionId(), new c(tbBaseMsg, wk8Var));
                    gk8.a.a().a(CollectionsKt__CollectionsJVMKt.listOf(chatMsg));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.imsdk.chatmessage.messages.ChatMsg");
            }
            throw new IllegalArgumentException("转换器为null，请检查业务逻辑".toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c A[Catch: all -> 0x003b, TryCatch #0 {, blocks: (B:5:0x0005, B:10:0x0012, B:12:0x0020, B:18:0x002c, B:19:0x0036), top: B:28:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:10:0x0012, B:12:0x0020, B:18:0x002c, B:19:0x0036), top: B:28:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void j(long j, vk8 listener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j, listener) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                if (j == 0) {
                    return;
                }
                List<vk8> list = c.get(Long.valueOf(j));
                if (list != null && !list.isEmpty()) {
                    z = false;
                    if (!z) {
                        c.remove(Long.valueOf(j));
                    } else {
                        list.remove(listener);
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
    }
}
