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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.NetLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.z9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class ca extends u9<SocketMessage, SocketMessageTask> implements ja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z9.a b;
    public final LinkedList<aa> c;
    public final LinkedList<aa> d;
    public final LinkedList<aa> e;
    public ja f;
    public boolean g;
    public x9 h;
    public long i;
    public int j;

    @Override // com.baidu.tieba.r9
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(aa aaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, aaVar) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements z9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca a;

        public a(ca caVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {caVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = caVar;
        }

        @Override // com.baidu.tieba.z9.a
        public void a(z9.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) {
                return;
            }
            this.a.w(bVar);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(248152337, "Lcom/baidu/tieba/ca$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(248152337, "Lcom/baidu/tieba/ca$b;");
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
    public ca(MessageManager messageManager) {
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
        this.j = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.b = new a(this);
    }

    public void A(aa aaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aaVar) == null) {
            if (aaVar != null && aaVar.i() && aaVar.p() < aaVar.l()) {
                y9.j(this.c, this.e, aaVar);
                x9 x9Var = this.h;
                if (x9Var != null) {
                    x9Var.b(true, "timeout seq = " + aaVar.q());
                }
                ea.c("queue", aaVar.m(), aaVar.q(), "onSendTimeOut", da.t, String.valueOf(aaVar.p()));
                return;
            }
            C(aaVar);
            v(aaVar, da.m, null);
            E();
        }
    }

    @Override // com.baidu.tieba.r9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            y9.m(this.c, i, bdUniqueId);
            y9.m(this.d, i, bdUniqueId);
            y9.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!y9.c(this.d, i, bdUniqueId) && !y9.c(this.c, i, bdUniqueId) && !y9.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, aa aaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, aaVar) == null) {
            if (i == 2) {
                if (aaVar.r() != null) {
                    i2 = aaVar.r().getErrorCode();
                } else {
                    i2 = da.i;
                }
            } else {
                i2 = da.n;
            }
            String i3 = da.i(i2);
            C(aaVar);
            v(aaVar, i2, i3);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(aa aaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar) != null) || aaVar == null) {
            return;
        }
        aaVar.w();
        y9.n(aaVar, this.c);
        y9.n(aaVar, this.d);
        y9.n(aaVar, this.e);
    }

    public void F(ja jaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jaVar) == null) {
            this.f = jaVar;
        }
    }

    public void G(x9 x9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, x9Var) == null) {
            this.h = x9Var;
        }
    }

    @Override // com.baidu.tieba.ja
    public void a(String str) {
        ja jaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (jaVar = this.f) != null) {
            jaVar.a(str);
        }
    }

    @Override // com.baidu.tieba.ja
    public void c(cj cjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cjVar) == null) {
            E();
            ja jaVar = this.f;
            if (jaVar != null) {
                jaVar.c(cjVar);
            }
        }
    }

    public final void k(LinkedList<aa> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            aa l = y9.l(linkedList);
            if (l != null) {
                l.w();
                v(l, da.o, null);
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
            return BdAsyncTask.getTaskNum(String.valueOf(i), z9.e());
        }
        return invokeI.intValue;
    }

    public void z(aa aaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, aaVar) != null) || aaVar == null) {
            return;
        }
        if (aaVar.v()) {
            aaVar.h();
            y9.j(this.d, this.c, aaVar);
            return;
        }
        y9.n(aaVar, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r9
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            hi.c();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.a())) {
                    ea.c("queue", socketMessage, 0, "sendMessage", da.q, "duplicate message be removed");
                    return;
                }
                aa aaVar = new aa(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    ea.c("queue", socketMessage, 0, "sendMessage", da.z, "user manual close socket");
                    aaVar.a(da.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    ea.c("queue", socketMessage, 0, "sendMessage", da.p, "isManualBlock message be removed");
                    aaVar.a(da.p);
                } else {
                    ea.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    y9.h(aaVar, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.ja
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            ja jaVar = this.f;
            if (jaVar != null) {
                jaVar.b(i, str);
            }
            x9 x9Var = this.h;
            if (x9Var != null) {
                x9Var.a();
            }
            if (hi.F() && !y9.a(this.e) && !y9.a(this.d) && !y9.a(this.c) && BdSocketLinkService.isAvailable()) {
                y9.b(this.c);
                y9.i(this.d, this.e);
                y9.i(this.d, this.c);
                while (true) {
                    aa k = y9.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, da.o, null);
                }
                if (y9.q(this.d) <= 0) {
                    return false;
                }
                ea.a("queue", 0, 0, "onClose", da.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        aa f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = y9.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            ea.c("queue", f.m(), 0, "sendNext", da.r, "");
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
            ea.a("queue", 0, 0, "unBlockMessageQueue", da.s, "Queue block has release");
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

    public x9 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (x9) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(z9.e());
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

    @Override // com.baidu.tieba.ja
    public void d(kj kjVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, kjVar) != null) || kjVar == null || (bArr = kjVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            ha c = ga.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            ea.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            aa o = o(b2, h);
            if (o != null) {
                o.m = kjVar.b;
                o.n = kjVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && y9.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, da.A, null);
                }
            } else {
                new z9(c, o, this.b, h).execute(new String[0]);
            }
            ja jaVar = this.f;
            if (jaVar != null) {
                jaVar.d(kjVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = eh.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            ea.a("queue", 0, 0, "onBinaryMesssage", da.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.ja
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            ba.a().c(map);
            x9 x9Var = this.h;
            if (x9Var != null) {
                x9Var.e();
            }
            this.g = true;
            ea.a("queue", 0, 0, "onConnected", da.y, "Queue blocked");
            ja jaVar = this.f;
            if (jaVar != null) {
                jaVar.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof w9)) {
                w9 w9Var = (w9) socketMessage;
                if (y9.d(this.d, w9Var, socketMessage.getCmd()) || y9.d(this.c, w9Var, socketMessage.getCmd()) || y9.d(this.e, w9Var, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(z9.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        aa aaVar = bVar.b;
        if (aaVar != null) {
            v(aaVar, da.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        ea.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
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
                            if (y9.e(this.d, cmd) || y9.e(this.c, cmd) || y9.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    y9.o(this.d, cmd);
                    return false;
                }
                y9.o(this.d, cmd);
                y9.o(this.c, cmd);
                y9.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final aa o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                aa p = y9.p(i2, this.c);
                if (p == null && (p = y9.p(i2, this.e)) == null && (p = y9.p(i2, this.d)) == null) {
                    ea.a("queue", i, i2, "findSenderData", da.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                ea.a("queue", i, i2, "findSenderData", da.v, "received ack message");
                return p;
            }
            return null;
        }
        return (aa) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(aa aaVar, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, aaVar, i, str) == null) && aaVar != null && aaVar.m() != null) {
            int cmd = aaVar.m().getCmd();
            int q = aaVar.q();
            ea.c("queue", aaVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + aaVar.p());
            NetLog.getInstance().c("Request_socket", "onMessageSendFail ： " + i + str);
            if (aaVar != null) {
                socketMessageTask = aaVar.t();
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
                    socketResponsedMessage.setErrorString(da.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(aaVar.m());
                ea.c("queue", aaVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
