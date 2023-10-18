package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.NetLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes6.dex */
public class g5 extends y4<SocketMessage, SocketMessageTask> implements n5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d5.a b;
    public final LinkedList<e5> c;
    public final LinkedList<e5> d;
    public final LinkedList<e5> e;
    public n5 f;
    public boolean g;
    public b5 h;
    public long i;

    @Override // com.baidu.tieba.v4
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(e5 e5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, e5Var) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements d5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g5 a;

        public a(g5 g5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g5Var;
        }

        @Override // com.baidu.tieba.d5.a
        public void a(d5.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) {
                return;
            }
            this.a.w(bVar);
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(250535617, "Lcom/baidu/tieba/g5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(250535617, "Lcom/baidu/tieba/g5$b;");
                    return;
                }
            }
            int[] iArr = new int[SocketMessageTask.DupLicateMode.values().length];
            a = iArr;
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g5(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = null;
        this.g = true;
        this.h = null;
        this.i = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.b = new a(this);
    }

    @Override // com.baidu.tieba.v4
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            c5.m(this.c, i, bdUniqueId);
            c5.m(this.d, i, bdUniqueId);
            c5.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!c5.c(this.d, i, bdUniqueId) && !c5.c(this.c, i, bdUniqueId) && !c5.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, e5 e5Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, e5Var) == null) {
            if (i == 2) {
                if (e5Var.r() != null) {
                    i2 = e5Var.r().getErrorCode();
                } else {
                    i2 = h5.i;
                }
            } else {
                i2 = h5.n;
            }
            String i3 = h5.i(i2);
            C(e5Var);
            v(e5Var, i2, i3);
        }
    }

    public void A(e5 e5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e5Var) == null) {
            if (e5Var != null && e5Var.i() && e5Var.p() < e5Var.l()) {
                c5.j(this.c, this.e, e5Var);
                b5 b5Var = this.h;
                if (b5Var != null) {
                    b5Var.b(true, "timeout seq = " + e5Var.q());
                }
                i5.c("queue", e5Var.m(), e5Var.q(), "onSendTimeOut", h5.t, String.valueOf(e5Var.p()));
                return;
            }
            C(e5Var);
            v(e5Var, h5.m, null);
            E();
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(e5 e5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e5Var) != null) || e5Var == null) {
            return;
        }
        e5Var.w();
        c5.n(e5Var, this.c);
        c5.n(e5Var, this.d);
        c5.n(e5Var, this.e);
    }

    public void F(n5 n5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, n5Var) == null) {
            this.f = n5Var;
        }
    }

    public void G(b5 b5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b5Var) == null) {
            this.h = b5Var;
        }
    }

    @Override // com.baidu.tieba.n5
    public void a(String str) {
        n5 n5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (n5Var = this.f) != null) {
            n5Var.a(str);
        }
    }

    @Override // com.baidu.tieba.n5
    public void c(ud udVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, udVar) == null) {
            E();
            n5 n5Var = this.f;
            if (n5Var != null) {
                n5Var.c(udVar);
            }
        }
    }

    public final void k(LinkedList<e5> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            e5 l = c5.l(linkedList);
            if (l != null) {
                l.w();
                v(l, h5.o, null);
            } else {
                return;
            }
        }
    }

    public final void l(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, socketResponsedMessage) == null) {
            this.a.dispatchResponsedMessage(socketResponsedMessage);
        }
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            return BdAsyncTask.getTaskNum(String.valueOf(i), d5.e());
        }
        return invokeI.intValue;
    }

    public void z(e5 e5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, e5Var) != null) || e5Var == null) {
            return;
        }
        if (e5Var.v()) {
            e5Var.h();
            c5.j(this.d, this.c, e5Var);
            return;
        }
        c5.n(e5Var, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v4
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            BdUtilHelper.checkMainThread();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.getDupLicateMode())) {
                    i5.c("queue", socketMessage, 0, "sendMessage", h5.q, "duplicate message be removed");
                    return;
                }
                e5 e5Var = new e5(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    i5.c("queue", socketMessage, 0, "sendMessage", h5.z, "user manual close socket");
                    e5Var.a(h5.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    i5.c("queue", socketMessage, 0, "sendMessage", h5.p, "isManualBlock message be removed");
                    e5Var.a(h5.p);
                } else {
                    i5.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    c5.h(e5Var, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.n5
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            n5 n5Var = this.f;
            if (n5Var != null) {
                n5Var.b(i, str);
            }
            b5 b5Var = this.h;
            if (b5Var != null) {
                b5Var.a();
            }
            if (BdUtilHelper.isNetOk() && !c5.a(this.e) && !c5.a(this.d) && !c5.a(this.c) && BdSocketLinkService.isAvailable()) {
                c5.b(this.c);
                c5.i(this.d, this.e);
                c5.i(this.d, this.c);
                while (true) {
                    e5 k = c5.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, h5.o, null);
                }
                if (c5.q(this.d) <= 0) {
                    return false;
                }
                i5.a("queue", 0, 0, "onClose", h5.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        e5 f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = c5.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            i5.c("queue", f.m(), 0, "sendNext", h5.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (this.g && f.n() > -3) {
        } else {
            BdSocketLinkService.sendMessage(f);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = this.g;
            this.g = false;
            i5.a("queue", 0, 0, "unBlockMessageQueue", h5.s, "Queue block has release");
            if (z) {
                E();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            k(this.c);
            k(this.d);
            k(this.e);
        }
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.i;
        }
        return invokeV.longValue;
    }

    public b5 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (b5) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(d5.e());
        }
        return invokeV.intValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (BdSocketLinkService.isOpen() && !this.g && BdSocketLinkService.isAvailable()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n5
    public void d(ce ceVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, ceVar) != null) || ceVar == null || (bArr = ceVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            l5 c = k5.f().c(bArr);
            int b2 = c.a.b();
            int h = c.a.h();
            i5.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            e5 o = o(b2, h);
            if (o != null) {
                o.m = ceVar.b;
                o.n = ceVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && c5.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, h5.A, null);
                }
            } else {
                new d5(c, o, this.b, h).execute(new String[0]);
            }
            n5 n5Var = this.f;
            if (n5Var != null) {
                n5Var.d(ceVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            i5.a("queue", 0, 0, "onBinaryMesssage", h5.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.n5
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            f5.a().c(map);
            b5 b5Var = this.h;
            if (b5Var != null) {
                b5Var.e();
            }
            this.g = true;
            i5.a("queue", 0, 0, "onConnected", h5.y, "Queue blocked");
            n5 n5Var = this.f;
            if (n5Var != null) {
                n5Var.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof a5)) {
                a5 a5Var = (a5) socketMessage;
                if (c5.d(this.d, a5Var, socketMessage.getCmd()) || c5.d(this.c, a5Var, socketMessage.getCmd()) || c5.d(this.e, a5Var, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(d5.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        e5 e5Var = bVar.b;
        if (e5Var != null) {
            v(e5Var, h5.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        i5.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, socketMessage, dupLicateMode)) == null) {
            if (socketMessage != null) {
                int cmd = socketMessage.getCmd();
                int i = b.a[dupLicateMode.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (c5.e(this.d, cmd) || c5.e(this.c, cmd) || c5.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    c5.o(this.d, cmd);
                    return false;
                }
                c5.o(this.d, cmd);
                c5.o(this.c, cmd);
                c5.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final e5 o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                e5 p = c5.p(i2, this.c);
                if (p == null && (p = c5.p(i2, this.e)) == null && (p = c5.p(i2, this.d)) == null) {
                    i5.a("queue", i, i2, "findSenderData", h5.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                i5.a("queue", i, i2, "findSenderData", h5.v, "received ack message");
                return p;
            }
            return null;
        }
        return (e5) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(e5 e5Var, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, e5Var, i, str) == null) && e5Var != null && e5Var.m() != null) {
            int cmd = e5Var.m().getCmd();
            int q = e5Var.q();
            i5.c("queue", e5Var.m(), q, "onMessageSendFail", i, str + " retryTime-" + e5Var.p());
            NetLog.getInstance().i("Request_socket", "onMessageSendFail ： " + i + str);
            if (e5Var != null) {
                socketMessageTask = e5Var.t();
            } else {
                socketMessageTask = null;
            }
            if (socketMessageTask == null) {
                socketMessageTask = (SocketMessageTask) this.a.findTask(cmd);
            }
            if (socketMessageTask != null && socketMessageTask.getResponsedClass() != null) {
                try {
                    socketResponsedMessage = socketMessageTask.getResponsedClass().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    try {
                        socketResponsedMessage = socketMessageTask.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                if (socketResponsedMessage != null) {
                    return;
                }
                socketResponsedMessage.setError(i);
                if (str == null) {
                    socketResponsedMessage.setErrorString(h5.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(e5Var.m());
                i5.c("queue", e5Var.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
