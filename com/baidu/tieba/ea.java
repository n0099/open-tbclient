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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ba;
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
public class ea extends w9<SocketMessage, SocketMessageTask> implements la {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ba.a b;
    public final LinkedList<ca> c;
    public final LinkedList<ca> d;
    public final LinkedList<ca> e;
    public la f;
    public boolean g;
    public z9 h;
    public long i;
    public int j;

    /* loaded from: classes3.dex */
    public class a implements ba.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea a;

        public a(ea eaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eaVar;
        }

        @Override // com.baidu.tieba.ba.a
        public void a(ba.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.a.w(bVar);
            }
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(249999379, "Lcom/baidu/tieba/ea$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(249999379, "Lcom/baidu/tieba/ea$b;");
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
    public ea(MessageManager messageManager) {
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

    public void A(ca caVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, caVar) == null) {
            if (caVar != null && caVar.i() && caVar.p() < caVar.l()) {
                aa.j(this.c, this.e, caVar);
                z9 z9Var = this.h;
                if (z9Var != null) {
                    z9Var.b(true, "timeout seq = " + caVar.q());
                }
                ga.c("queue", caVar.m(), caVar.q(), "onSendTimeOut", fa.t, String.valueOf(caVar.p()));
                return;
            }
            C(caVar);
            v(caVar, fa.m, null);
            E();
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(ca caVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, caVar) == null) || caVar == null) {
            return;
        }
        caVar.w();
        aa.n(caVar, this.c);
        aa.n(caVar, this.d);
        aa.n(caVar, this.e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t9
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            ri.c();
            if (socketMessage == null || socketMessageTask == null) {
                return;
            }
            if (m(socketMessage, socketMessageTask.a())) {
                ga.c("queue", socketMessage, 0, "sendMessage", fa.q, "duplicate message be removed");
                return;
            }
            ca caVar = new ca(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                ga.c("queue", socketMessage, 0, "sendMessage", fa.z, "user manual close socket");
                caVar.a(fa.z);
            } else if (!BdSocketLinkService.isAvailable()) {
                ga.c("queue", socketMessage, 0, "sendMessage", fa.p, "isManualBlock message be removed");
                caVar.a(fa.p);
            } else {
                ga.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                aa.h(caVar, this.d);
                E();
            }
        }
    }

    public final void E() {
        ca f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (f = aa.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            ga.c("queue", f.m(), 0, "sendNext", fa.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.g || f.n() <= -3) {
            BdSocketLinkService.sendMessage(f);
        }
    }

    public void F(la laVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, laVar) == null) {
            this.f = laVar;
        }
    }

    public void G(z9 z9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, z9Var) == null) {
            this.h = z9Var;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = this.g;
            this.g = false;
            ga.a("queue", 0, 0, "unBlockMessageQueue", fa.s, "Queue block has release");
            if (z) {
                E();
            }
        }
    }

    @Override // com.baidu.tieba.la
    public void a(String str) {
        la laVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (laVar = this.f) == null) {
            return;
        }
        laVar.a(str);
    }

    @Override // com.baidu.tieba.la
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            la laVar = this.f;
            if (laVar != null) {
                laVar.b(i, str);
            }
            z9 z9Var = this.h;
            if (z9Var != null) {
                z9Var.a();
            }
            if (ri.D() && !aa.a(this.e) && !aa.a(this.d) && !aa.a(this.c) && BdSocketLinkService.isAvailable()) {
                aa.b(this.c);
                aa.i(this.d, this.e);
                aa.i(this.d, this.c);
                while (true) {
                    ca k = aa.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, fa.o, null);
                }
                if (aa.q(this.d) > 0) {
                    ga.a("queue", 0, 0, "onClose", fa.u, "have retry message, MessageQueue:reconnect");
                    BdSocketLinkService.startService(false, "have retry message");
                    return true;
                }
                return false;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.la
    public void c(lj ljVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ljVar) == null) {
            E();
            la laVar = this.f;
            if (laVar != null) {
                laVar.c(ljVar);
            }
        }
    }

    @Override // com.baidu.tieba.la
    public void d(tj tjVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, tjVar) == null) || tjVar == null || (bArr = tjVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            ja c = ia.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            ga.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            ca o = o(b2, h);
            if (o != null) {
                o.m = tjVar.b;
                o.n = tjVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && aa.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h == 0 || (o != null && o.k() == b2)) {
                new ba(c, o, this.b, h).execute(new String[0]);
            } else if (o != null) {
                v(o, fa.A, null);
            }
            la laVar = this.f;
            if (laVar != null) {
                laVar.d(tjVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = nh.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            ga.a("queue", 0, 0, "onBinaryMesssage", fa.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.t9
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.la
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            da.a().c(map);
            z9 z9Var = this.h;
            if (z9Var != null) {
                z9Var.e();
            }
            this.g = true;
            ga.a("queue", 0, 0, "onConnected", fa.y, "Queue blocked");
            la laVar = this.f;
            if (laVar != null) {
                laVar.g(map);
            }
        }
    }

    @Override // com.baidu.tieba.t9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            aa.m(this.c, i, bdUniqueId);
            aa.m(this.d, i, bdUniqueId);
            aa.m(this.e, i, bdUniqueId);
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

    public final void k(LinkedList<ca> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            ca l = aa.l(linkedList);
            if (l == null) {
                return;
            }
            l.w();
            v(l, fa.o, null);
        }
    }

    public final void l(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, socketResponsedMessage) == null) {
            this.a.dispatchResponsedMessage(socketResponsedMessage);
        }
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, socketMessage, dupLicateMode)) == null) {
            if (socketMessage != null) {
                int cmd = socketMessage.getCmd();
                int i = b.a[dupLicateMode.ordinal()];
                if (i == 1) {
                    aa.o(this.d, cmd);
                    aa.o(this.c, cmd);
                    aa.o(this.e, cmd);
                    return false;
                } else if (i == 2) {
                    aa.o(this.d, cmd);
                    return false;
                } else if (i != 3) {
                    return false;
                } else {
                    return aa.e(this.d, cmd) || aa.e(this.c, cmd) || aa.e(this.e, cmd);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage == null || !(socketMessage instanceof y9)) {
                return false;
            }
            y9 y9Var = (y9) socketMessage;
            return aa.d(this.d, y9Var, socketMessage.getCmd()) || aa.d(this.c, y9Var, socketMessage.getCmd()) || aa.d(this.e, y9Var, socketMessage.getCmd());
        }
        return invokeL.booleanValue;
    }

    public final ca o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                ca p = aa.p(i2, this.c);
                if (p == null && (p = aa.p(i2, this.e)) == null && (p = aa.p(i2, this.d)) == null) {
                    ga.a("queue", i, i2, "findSenderData", fa.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                ga.a("queue", i, i2, "findSenderData", fa.v, "received ack message");
                return p;
            }
            return null;
        }
        return (ca) invokeII.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.i : invokeV.longValue;
    }

    public z9 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.h : (z9) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? BdAsyncTask.getTaskNum(ba.e()) : invokeV.intValue;
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) ? BdAsyncTask.getTaskNum(String.valueOf(i), ba.e()) : invokeI.intValue;
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) ? aa.c(this.d, i, bdUniqueId) || aa.c(this.c, i, bdUniqueId) || aa.c(this.e, i, bdUniqueId) : invokeIL.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? BdSocketLinkService.isOpen() && !this.g && BdSocketLinkService.isAvailable() : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(ca caVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048604, this, caVar, i, str) == null) || caVar == null || caVar.m() == null) {
            return;
        }
        int cmd = caVar.m().getCmd();
        int q = caVar.q();
        ga.c("queue", caVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + caVar.p());
        SocketMessageTask t = caVar != null ? caVar.t() : null;
        if (t == null) {
            t = (SocketMessageTask) this.a.findTask(cmd);
        }
        if (t != null && t.getResponsedClass() != null) {
            try {
                socketResponsedMessage = t.getResponsedClass().newInstance();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                try {
                    socketResponsedMessage = t.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            if (socketResponsedMessage != null) {
                return;
            }
            socketResponsedMessage.setError(i);
            if (str == null) {
                socketResponsedMessage.setErrorString(fa.i(i));
            } else {
                socketResponsedMessage.setErrorString(str);
            }
            socketResponsedMessage.setOrginalMessage(caVar.m());
            ga.c("queue", caVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
            this.a.dispatchResponsedMessage(socketResponsedMessage);
            return;
        }
        socketResponsedMessage = null;
        if (socketResponsedMessage != null) {
        }
    }

    public final void w(ba.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) || bVar == null) {
            return;
        }
        ca caVar = bVar.b;
        if (caVar != null) {
            v(caVar, fa.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        ga.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public void x(int i, ca caVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, caVar) == null) {
            if (i == 2) {
                if (caVar.r() != null) {
                    i2 = caVar.r().getErrorCode();
                } else {
                    i2 = fa.i;
                }
            } else {
                i2 = fa.n;
            }
            String i3 = fa.i(i2);
            C(caVar);
            v(caVar, i2, i3);
        }
    }

    public void y(ca caVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, caVar) == null) {
        }
    }

    public void z(ca caVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, caVar) == null) || caVar == null) {
            return;
        }
        if (caVar.v()) {
            caVar.h();
            aa.j(this.d, this.c, caVar);
            return;
        }
        aa.n(caVar, this.d);
    }
}
