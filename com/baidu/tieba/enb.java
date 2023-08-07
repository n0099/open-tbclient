package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.inb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.ipc.HonorApiAvailability;
import com.huawei.hms.api.IPCTransport;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class enb implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final enb c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<zmb, a> b;

    /* loaded from: classes5.dex */
    public class a implements inb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<pnb<?>> a;
        public final Queue<pnb<?>> b;
        public final inb c;
        public HonorPushErrorEnum d;
        public final zmb e;
        public final /* synthetic */ enb f;

        public a(enb enbVar, zmb zmbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enbVar, zmbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = enbVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new lnb(this);
            this.d = null;
            this.e = zmbVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mmb.g(this.f.a);
                lnb lnbVar = (lnb) this.c;
                int i = lnbVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        lnbVar.a.set(4);
                        return;
                    }
                    return;
                }
                onb onbVar = lnbVar.d;
                if (onbVar != null) {
                    onbVar.c();
                }
                lnbVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    mmb.g(this.f.a);
                    for (pnb<?> pnbVar : this.a) {
                        pnbVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(pnb<?> pnbVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pnbVar) == null) {
                synchronized (this) {
                    this.b.add(pnbVar);
                    inb inbVar = this.c;
                    b bVar = new b(pnbVar);
                    pnbVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = pnbVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        omb.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + pnbVar.a);
                    IPushInvoke iPushInvoke = ((lnb) inbVar).b;
                    String str = pnbVar.a;
                    RequestHeader requestHeader = pnbVar.d;
                    IMessageEntity iMessageEntity = pnbVar.b;
                    Bundle bundle = new Bundle();
                    Bundle bundle2 = new Bundle();
                    MessageCodec.formMessageEntity(requestHeader, bundle);
                    MessageCodec.formMessageEntity(iMessageEntity, bundle2);
                    DataBuffer dataBuffer = new DataBuffer(str, bundle, bundle2);
                    if (iPushInvoke != null) {
                        try {
                            iPushInvoke.call(dataBuffer, rVar);
                        } catch (Exception e2) {
                            String str2 = "transport remote error. " + e2;
                        }
                    }
                    Log.i(IPCTransport.TAG, "end transport parse.");
                }
            }
        }

        public final synchronized void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnected");
                    mmb.g(this.f.a);
                    this.d = null;
                    for (pnb<?> pnbVar : this.a) {
                        c(pnbVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements snb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pnb<?> a;

        public b(pnb<?> pnbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pnbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pnbVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947741520, "Lcom/baidu/tieba/enb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947741520, "Lcom/baidu/tieba/enb;");
                return;
            }
        }
        c = new enb();
    }

    public enb() {
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
        this.b = new ConcurrentHashMap(5, 0.75f, 1);
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper(), this);
    }

    public <TResult> fnb<TResult> a(pnb<TResult> pnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pnbVar)) == null) {
            xnb<TResult> xnbVar = new xnb<>();
            pnbVar.e = xnbVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, pnbVar));
            return xnbVar.a;
        }
        return (fnb) invokeL.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message)) == null) {
            int i = message.what;
            boolean z = false;
            if (i == 1) {
                pnb<?> pnbVar = (pnb) message.obj;
                zmb zmbVar = pnbVar.c;
                a aVar2 = this.b.get(zmbVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, zmbVar);
                    this.b.put(zmbVar, aVar2);
                }
                synchronized (aVar2) {
                    mmb.g(aVar2.f.a);
                    String str = "sendRequest " + pnbVar.a;
                    if (((lnb) aVar2.c).b()) {
                        aVar2.c(pnbVar);
                    } else {
                        aVar2.a.add(pnbVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                mmb.g(aVar2.f.a);
                                if (((lnb) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((lnb) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        lnb lnbVar = (lnb) aVar2.c;
                                        lnbVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = lnbVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            tmb tmbVar = tmb.e;
                                            int b2 = HonorApiAvailability.b(tmbVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                lnbVar.a.set(5);
                                                pmb a2 = HonorApiAvailability.a(tmbVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                onb onbVar = new onb(a2);
                                                lnbVar.d = onbVar;
                                                onbVar.b = new knb(lnbVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + onbVar.a;
                                                    onbVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = onbVar.a.c();
                                                    String b3 = onbVar.a.b();
                                                    String d = onbVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (onb.e) {
                                                        if (tmbVar.a().bindService(intent, onbVar, 1)) {
                                                            Handler handler = onbVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                onbVar.c = new Handler(Looper.getMainLooper(), new nnb(onbVar));
                                                            }
                                                            onbVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            onbVar.d = true;
                                                            onbVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                lnbVar.a(b2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return true;
            } else if (i != 2) {
                return false;
            } else {
                pnb pnbVar2 = (pnb) message.obj;
                zmb zmbVar2 = pnbVar2.c;
                if (zmbVar2 != null && this.b.containsKey(zmbVar2) && (aVar = this.b.get(zmbVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + pnbVar2.a;
                        aVar.b.remove(pnbVar2);
                        if (aVar.a.peek() == null || aVar.b.peek() == null) {
                            aVar.a();
                            aVar.f.b.remove(aVar.e);
                        }
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
