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
import com.baidu.tieba.jnb;
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
public class fnb implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final fnb c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<anb, a> b;

    /* loaded from: classes5.dex */
    public class a implements jnb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<qnb<?>> a;
        public final Queue<qnb<?>> b;
        public final jnb c;
        public HonorPushErrorEnum d;
        public final anb e;
        public final /* synthetic */ fnb f;

        public a(fnb fnbVar, anb anbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fnbVar, anbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = fnbVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new mnb(this);
            this.d = null;
            this.e = anbVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nmb.g(this.f.a);
                mnb mnbVar = (mnb) this.c;
                int i = mnbVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        mnbVar.a.set(4);
                        return;
                    }
                    return;
                }
                pnb pnbVar = mnbVar.d;
                if (pnbVar != null) {
                    pnbVar.c();
                }
                mnbVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    nmb.g(this.f.a);
                    for (qnb<?> qnbVar : this.a) {
                        qnbVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(qnb<?> qnbVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qnbVar) == null) {
                synchronized (this) {
                    this.b.add(qnbVar);
                    jnb jnbVar = this.c;
                    b bVar = new b(qnbVar);
                    qnbVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = qnbVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        pmb.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + qnbVar.a);
                    IPushInvoke iPushInvoke = ((mnb) jnbVar).b;
                    String str = qnbVar.a;
                    RequestHeader requestHeader = qnbVar.d;
                    IMessageEntity iMessageEntity = qnbVar.b;
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
                    nmb.g(this.f.a);
                    this.d = null;
                    for (qnb<?> qnbVar : this.a) {
                        c(qnbVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements tnb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qnb<?> a;

        public b(qnb<?> qnbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qnbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qnbVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771311, "Lcom/baidu/tieba/fnb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771311, "Lcom/baidu/tieba/fnb;");
                return;
            }
        }
        c = new fnb();
    }

    public fnb() {
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

    public <TResult> gnb<TResult> a(qnb<TResult> qnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qnbVar)) == null) {
            ynb<TResult> ynbVar = new ynb<>();
            qnbVar.e = ynbVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, qnbVar));
            return ynbVar.a;
        }
        return (gnb) invokeL.objValue;
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
                qnb<?> qnbVar = (qnb) message.obj;
                anb anbVar = qnbVar.c;
                a aVar2 = this.b.get(anbVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, anbVar);
                    this.b.put(anbVar, aVar2);
                }
                synchronized (aVar2) {
                    nmb.g(aVar2.f.a);
                    String str = "sendRequest " + qnbVar.a;
                    if (((mnb) aVar2.c).b()) {
                        aVar2.c(qnbVar);
                    } else {
                        aVar2.a.add(qnbVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                nmb.g(aVar2.f.a);
                                if (((mnb) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((mnb) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        mnb mnbVar = (mnb) aVar2.c;
                                        mnbVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = mnbVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            umb umbVar = umb.e;
                                            int b2 = HonorApiAvailability.b(umbVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                mnbVar.a.set(5);
                                                qmb a2 = HonorApiAvailability.a(umbVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                pnb pnbVar = new pnb(a2);
                                                mnbVar.d = pnbVar;
                                                pnbVar.b = new lnb(mnbVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + pnbVar.a;
                                                    pnbVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = pnbVar.a.c();
                                                    String b3 = pnbVar.a.b();
                                                    String d = pnbVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (pnb.e) {
                                                        if (umbVar.a().bindService(intent, pnbVar, 1)) {
                                                            Handler handler = pnbVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                pnbVar.c = new Handler(Looper.getMainLooper(), new onb(pnbVar));
                                                            }
                                                            pnbVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            pnbVar.d = true;
                                                            pnbVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                mnbVar.a(b2);
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
                qnb qnbVar2 = (qnb) message.obj;
                anb anbVar2 = qnbVar2.c;
                if (anbVar2 != null && this.b.containsKey(anbVar2) && (aVar = this.b.get(anbVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + qnbVar2.a;
                        aVar.b.remove(qnbVar2);
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
