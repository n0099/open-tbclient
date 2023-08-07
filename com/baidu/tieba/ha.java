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
import com.baidu.tieba.ea;
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
public class ha extends z9<SocketMessage, SocketMessageTask> implements oa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ea.a b;
    public final LinkedList<fa> c;
    public final LinkedList<fa> d;
    public final LinkedList<fa> e;
    public oa f;
    public boolean g;
    public ca h;
    public long i;

    @Override // com.baidu.tieba.w9
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(fa faVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, faVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ea.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha a;

        public a(ha haVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {haVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = haVar;
        }

        @Override // com.baidu.tieba.ea.a
        public void a(ea.b bVar) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(252769942, "Lcom/baidu/tieba/ha$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(252769942, "Lcom/baidu/tieba/ha$b;");
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
    public ha(MessageManager messageManager) {
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

    @Override // com.baidu.tieba.w9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            da.m(this.c, i, bdUniqueId);
            da.m(this.d, i, bdUniqueId);
            da.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!da.c(this.d, i, bdUniqueId) && !da.c(this.c, i, bdUniqueId) && !da.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, fa faVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, faVar) == null) {
            if (i == 2) {
                if (faVar.r() != null) {
                    i2 = faVar.r().getErrorCode();
                } else {
                    i2 = ia.i;
                }
            } else {
                i2 = ia.n;
            }
            String i3 = ia.i(i2);
            C(faVar);
            v(faVar, i2, i3);
        }
    }

    public void A(fa faVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, faVar) == null) {
            if (faVar != null && faVar.i() && faVar.p() < faVar.l()) {
                da.j(this.c, this.e, faVar);
                ca caVar = this.h;
                if (caVar != null) {
                    caVar.b(true, "timeout seq = " + faVar.q());
                }
                ja.c("queue", faVar.m(), faVar.q(), "onSendTimeOut", ia.t, String.valueOf(faVar.p()));
                return;
            }
            C(faVar);
            v(faVar, ia.m, null);
            E();
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(fa faVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faVar) != null) || faVar == null) {
            return;
        }
        faVar.w();
        da.n(faVar, this.c);
        da.n(faVar, this.d);
        da.n(faVar, this.e);
    }

    public void F(oa oaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, oaVar) == null) {
            this.f = oaVar;
        }
    }

    public void G(ca caVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, caVar) == null) {
            this.h = caVar;
        }
    }

    @Override // com.baidu.tieba.oa
    public void a(String str) {
        oa oaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (oaVar = this.f) != null) {
            oaVar.a(str);
        }
    }

    @Override // com.baidu.tieba.oa
    public void c(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, uiVar) == null) {
            E();
            oa oaVar = this.f;
            if (oaVar != null) {
                oaVar.c(uiVar);
            }
        }
    }

    public final void k(LinkedList<fa> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            fa l = da.l(linkedList);
            if (l != null) {
                l.w();
                v(l, ia.o, null);
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
            return BdAsyncTask.getTaskNum(String.valueOf(i), ea.e());
        }
        return invokeI.intValue;
    }

    public void z(fa faVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, faVar) != null) || faVar == null) {
            return;
        }
        if (faVar.v()) {
            faVar.h();
            da.j(this.d, this.c, faVar);
            return;
        }
        da.n(faVar, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w9
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            BdUtilHelper.checkMainThread();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.getDupLicateMode())) {
                    ja.c("queue", socketMessage, 0, "sendMessage", ia.q, "duplicate message be removed");
                    return;
                }
                fa faVar = new fa(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    ja.c("queue", socketMessage, 0, "sendMessage", ia.z, "user manual close socket");
                    faVar.a(ia.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    ja.c("queue", socketMessage, 0, "sendMessage", ia.p, "isManualBlock message be removed");
                    faVar.a(ia.p);
                } else {
                    ja.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    da.h(faVar, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.oa
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            oa oaVar = this.f;
            if (oaVar != null) {
                oaVar.b(i, str);
            }
            ca caVar = this.h;
            if (caVar != null) {
                caVar.a();
            }
            if (BdUtilHelper.isNetOk() && !da.a(this.e) && !da.a(this.d) && !da.a(this.c) && BdSocketLinkService.isAvailable()) {
                da.b(this.c);
                da.i(this.d, this.e);
                da.i(this.d, this.c);
                while (true) {
                    fa k = da.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, ia.o, null);
                }
                if (da.q(this.d) <= 0) {
                    return false;
                }
                ja.a("queue", 0, 0, "onClose", ia.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        fa f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = da.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            ja.c("queue", f.m(), 0, "sendNext", ia.r, "");
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
            ja.a("queue", 0, 0, "unBlockMessageQueue", ia.s, "Queue block has release");
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

    public ca q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (ca) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(ea.e());
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

    @Override // com.baidu.tieba.oa
    public void d(cj cjVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, cjVar) != null) || cjVar == null || (bArr = cjVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            ma c = la.f().c(bArr);
            int b2 = c.a.b();
            int h = c.a.h();
            ja.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            fa o = o(b2, h);
            if (o != null) {
                o.m = cjVar.b;
                o.n = cjVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && da.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, ia.A, null);
                }
            } else {
                new ea(c, o, this.b, h).execute(new String[0]);
            }
            oa oaVar = this.f;
            if (oaVar != null) {
                oaVar.d(cjVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            ja.a("queue", 0, 0, "onBinaryMesssage", ia.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.oa
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            ga.a().c(map);
            ca caVar = this.h;
            if (caVar != null) {
                caVar.e();
            }
            this.g = true;
            ja.a("queue", 0, 0, "onConnected", ia.y, "Queue blocked");
            oa oaVar = this.f;
            if (oaVar != null) {
                oaVar.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof ba)) {
                ba baVar = (ba) socketMessage;
                if (da.d(this.d, baVar, socketMessage.getCmd()) || da.d(this.c, baVar, socketMessage.getCmd()) || da.d(this.e, baVar, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(ea.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        fa faVar = bVar.b;
        if (faVar != null) {
            v(faVar, ia.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        ja.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
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
                            if (da.e(this.d, cmd) || da.e(this.c, cmd) || da.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    da.o(this.d, cmd);
                    return false;
                }
                da.o(this.d, cmd);
                da.o(this.c, cmd);
                da.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final fa o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                fa p = da.p(i2, this.c);
                if (p == null && (p = da.p(i2, this.e)) == null && (p = da.p(i2, this.d)) == null) {
                    ja.a("queue", i, i2, "findSenderData", ia.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                ja.a("queue", i, i2, "findSenderData", ia.v, "received ack message");
                return p;
            }
            return null;
        }
        return (fa) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(fa faVar, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, faVar, i, str) == null) && faVar != null && faVar.m() != null) {
            int cmd = faVar.m().getCmd();
            int q = faVar.q();
            ja.c("queue", faVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + faVar.p());
            NetLog.getInstance().i("Request_socket", "onMessageSendFail ： " + i + str);
            if (faVar != null) {
                socketMessageTask = faVar.t();
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
                    socketResponsedMessage.setErrorString(ia.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(faVar.m());
                ja.c("queue", faVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
