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
import com.baidu.tieba.kac;
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
/* loaded from: classes6.dex */
public class gac implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final gac c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<bac, a> b;

    /* loaded from: classes6.dex */
    public class a implements kac.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<rac<?>> a;
        public final Queue<rac<?>> b;
        public final kac c;
        public HonorPushErrorEnum d;
        public final bac e;
        public final /* synthetic */ gac f;

        public a(gac gacVar, bac bacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gacVar, bacVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = gacVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new nac(this);
            this.d = null;
            this.e = bacVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o9c.g(this.f.a);
                nac nacVar = (nac) this.c;
                int i = nacVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        nacVar.a.set(4);
                        return;
                    }
                    return;
                }
                qac qacVar = nacVar.d;
                if (qacVar != null) {
                    qacVar.c();
                }
                nacVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    o9c.g(this.f.a);
                    for (rac<?> racVar : this.a) {
                        racVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(rac<?> racVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, racVar) == null) {
                synchronized (this) {
                    this.b.add(racVar);
                    kac kacVar = this.c;
                    b bVar = new b(racVar);
                    racVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = racVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        q9c.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + racVar.a);
                    IPushInvoke iPushInvoke = ((nac) kacVar).b;
                    String str = racVar.a;
                    RequestHeader requestHeader = racVar.d;
                    IMessageEntity iMessageEntity = racVar.b;
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
                    o9c.g(this.f.a);
                    this.d = null;
                    for (rac<?> racVar : this.a) {
                        c(racVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements uac {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public rac<?> a;

        public b(rac<?> racVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {racVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = racVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947788640, "Lcom/baidu/tieba/gac;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947788640, "Lcom/baidu/tieba/gac;");
                return;
            }
        }
        c = new gac();
    }

    public gac() {
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

    public <TResult> hac<TResult> a(rac<TResult> racVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, racVar)) == null) {
            zac<TResult> zacVar = new zac<>();
            racVar.e = zacVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, racVar));
            return zacVar.a;
        }
        return (hac) invokeL.objValue;
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
                rac<?> racVar = (rac) message.obj;
                bac bacVar = racVar.c;
                a aVar2 = this.b.get(bacVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, bacVar);
                    this.b.put(bacVar, aVar2);
                }
                synchronized (aVar2) {
                    o9c.g(aVar2.f.a);
                    String str = "sendRequest " + racVar.a;
                    if (((nac) aVar2.c).b()) {
                        aVar2.c(racVar);
                    } else {
                        aVar2.a.add(racVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                o9c.g(aVar2.f.a);
                                if (((nac) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((nac) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        nac nacVar = (nac) aVar2.c;
                                        nacVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = nacVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            v9c v9cVar = v9c.e;
                                            int b2 = HonorApiAvailability.b(v9cVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                nacVar.a.set(5);
                                                r9c a2 = HonorApiAvailability.a(v9cVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                qac qacVar = new qac(a2);
                                                nacVar.d = qacVar;
                                                qacVar.b = new mac(nacVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + qacVar.a;
                                                    qacVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = qacVar.a.c();
                                                    String b3 = qacVar.a.b();
                                                    String d = qacVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (qac.e) {
                                                        if (v9cVar.a().bindService(intent, qacVar, 1)) {
                                                            Handler handler = qacVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                qacVar.c = new Handler(Looper.getMainLooper(), new pac(qacVar));
                                                            }
                                                            qacVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            qacVar.d = true;
                                                            qacVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                nacVar.a(b2);
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
                rac racVar2 = (rac) message.obj;
                bac bacVar2 = racVar2.c;
                if (bacVar2 != null && this.b.containsKey(bacVar2) && (aVar = this.b.get(bacVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + racVar2.a;
                        aVar.b.remove(racVar2);
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
