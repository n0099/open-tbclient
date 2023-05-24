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
import com.baidu.tieba.fa;
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
public class ia extends aa<SocketMessage, SocketMessageTask> implements pa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fa.a b;
    public final LinkedList<ga> c;
    public final LinkedList<ga> d;
    public final LinkedList<ga> e;
    public pa f;
    public boolean g;
    public da h;
    public long i;
    public int j;

    @Override // com.baidu.tieba.x9
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(ga gaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, gaVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements fa.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia a;

        public a(ia iaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iaVar;
        }

        @Override // com.baidu.tieba.fa.a
        public void a(fa.b bVar) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(253693463, "Lcom/baidu/tieba/ia$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(253693463, "Lcom/baidu/tieba/ia$b;");
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
    public ia(MessageManager messageManager) {
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

    public void A(ga gaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gaVar) == null) {
            if (gaVar != null && gaVar.i() && gaVar.p() < gaVar.l()) {
                ea.j(this.c, this.e, gaVar);
                da daVar = this.h;
                if (daVar != null) {
                    daVar.b(true, "timeout seq = " + gaVar.q());
                }
                ka.c("queue", gaVar.m(), gaVar.q(), "onSendTimeOut", ja.t, String.valueOf(gaVar.p()));
                return;
            }
            C(gaVar);
            v(gaVar, ja.m, null);
            E();
        }
    }

    @Override // com.baidu.tieba.x9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            ea.m(this.c, i, bdUniqueId);
            ea.m(this.d, i, bdUniqueId);
            ea.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!ea.c(this.d, i, bdUniqueId) && !ea.c(this.c, i, bdUniqueId) && !ea.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, ga gaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, gaVar) == null) {
            if (i == 2) {
                if (gaVar.r() != null) {
                    i2 = gaVar.r().getErrorCode();
                } else {
                    i2 = ja.i;
                }
            } else {
                i2 = ja.n;
            }
            String i3 = ja.i(i2);
            C(gaVar);
            v(gaVar, i2, i3);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(ga gaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gaVar) != null) || gaVar == null) {
            return;
        }
        gaVar.w();
        ea.n(gaVar, this.c);
        ea.n(gaVar, this.d);
        ea.n(gaVar, this.e);
    }

    public void F(pa paVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, paVar) == null) {
            this.f = paVar;
        }
    }

    public void G(da daVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, daVar) == null) {
            this.h = daVar;
        }
    }

    @Override // com.baidu.tieba.pa
    public void a(String str) {
        pa paVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (paVar = this.f) != null) {
            paVar.a(str);
        }
    }

    @Override // com.baidu.tieba.pa
    public void c(mj mjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mjVar) == null) {
            E();
            pa paVar = this.f;
            if (paVar != null) {
                paVar.c(mjVar);
            }
        }
    }

    public final void k(LinkedList<ga> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            ga l = ea.l(linkedList);
            if (l != null) {
                l.w();
                v(l, ja.o, null);
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
            return BdAsyncTask.getTaskNum(String.valueOf(i), fa.e());
        }
        return invokeI.intValue;
    }

    public void z(ga gaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, gaVar) != null) || gaVar == null) {
            return;
        }
        if (gaVar.v()) {
            gaVar.h();
            ea.j(this.d, this.c, gaVar);
            return;
        }
        ea.n(gaVar, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x9
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            ri.c();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.a())) {
                    ka.c("queue", socketMessage, 0, "sendMessage", ja.q, "duplicate message be removed");
                    return;
                }
                ga gaVar = new ga(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    ka.c("queue", socketMessage, 0, "sendMessage", ja.z, "user manual close socket");
                    gaVar.a(ja.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    ka.c("queue", socketMessage, 0, "sendMessage", ja.p, "isManualBlock message be removed");
                    gaVar.a(ja.p);
                } else {
                    ka.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    ea.h(gaVar, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.pa
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            pa paVar = this.f;
            if (paVar != null) {
                paVar.b(i, str);
            }
            da daVar = this.h;
            if (daVar != null) {
                daVar.a();
            }
            if (ri.F() && !ea.a(this.e) && !ea.a(this.d) && !ea.a(this.c) && BdSocketLinkService.isAvailable()) {
                ea.b(this.c);
                ea.i(this.d, this.e);
                ea.i(this.d, this.c);
                while (true) {
                    ga k = ea.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, ja.o, null);
                }
                if (ea.q(this.d) <= 0) {
                    return false;
                }
                ka.a("queue", 0, 0, "onClose", ja.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        ga f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = ea.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            ka.c("queue", f.m(), 0, "sendNext", ja.r, "");
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
            ka.a("queue", 0, 0, "unBlockMessageQueue", ja.s, "Queue block has release");
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

    public da q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (da) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(fa.e());
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

    @Override // com.baidu.tieba.pa
    public void d(uj ujVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, ujVar) != null) || ujVar == null || (bArr = ujVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            na c = ma.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            ka.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            ga o = o(b2, h);
            if (o != null) {
                o.m = ujVar.b;
                o.n = ujVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && ea.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, ja.A, null);
                }
            } else {
                new fa(c, o, this.b, h).execute(new String[0]);
            }
            pa paVar = this.f;
            if (paVar != null) {
                paVar.d(ujVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = nh.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            ka.a("queue", 0, 0, "onBinaryMesssage", ja.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.pa
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            ha.a().c(map);
            da daVar = this.h;
            if (daVar != null) {
                daVar.e();
            }
            this.g = true;
            ka.a("queue", 0, 0, "onConnected", ja.y, "Queue blocked");
            pa paVar = this.f;
            if (paVar != null) {
                paVar.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof ca)) {
                ca caVar = (ca) socketMessage;
                if (ea.d(this.d, caVar, socketMessage.getCmd()) || ea.d(this.c, caVar, socketMessage.getCmd()) || ea.d(this.e, caVar, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(fa.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        ga gaVar = bVar.b;
        if (gaVar != null) {
            v(gaVar, ja.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        ka.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
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
                            if (ea.e(this.d, cmd) || ea.e(this.c, cmd) || ea.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    ea.o(this.d, cmd);
                    return false;
                }
                ea.o(this.d, cmd);
                ea.o(this.c, cmd);
                ea.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final ga o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                ga p = ea.p(i2, this.c);
                if (p == null && (p = ea.p(i2, this.e)) == null && (p = ea.p(i2, this.d)) == null) {
                    ka.a("queue", i, i2, "findSenderData", ja.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                ka.a("queue", i, i2, "findSenderData", ja.v, "received ack message");
                return p;
            }
            return null;
        }
        return (ga) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(ga gaVar, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, gaVar, i, str) == null) && gaVar != null && gaVar.m() != null) {
            int cmd = gaVar.m().getCmd();
            int q = gaVar.q();
            ka.c("queue", gaVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + gaVar.p());
            NetLog.getInstance().c("Request_socket", "onMessageSendFail ： " + i + str);
            if (gaVar != null) {
                socketMessageTask = gaVar.t();
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
                    socketResponsedMessage.setErrorString(ja.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(gaVar.m());
                ka.c("queue", gaVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
