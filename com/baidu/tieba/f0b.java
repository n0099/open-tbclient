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
import com.baidu.tieba.j0b;
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
public class f0b implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final f0b c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<a0b, a> b;

    /* loaded from: classes5.dex */
    public class a implements j0b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<q0b<?>> a;
        public final Queue<q0b<?>> b;
        public final j0b c;
        public HonorPushErrorEnum d;
        public final a0b e;
        public final /* synthetic */ f0b f;

        public a(f0b f0bVar, a0b a0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f0bVar, a0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = f0bVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new m0b(this);
            this.d = null;
            this.e = a0bVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nza.g(this.f.a);
                m0b m0bVar = (m0b) this.c;
                int i = m0bVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        m0bVar.a.set(4);
                        return;
                    }
                    return;
                }
                p0b p0bVar = m0bVar.d;
                if (p0bVar != null) {
                    p0bVar.c();
                }
                m0bVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    nza.g(this.f.a);
                    for (q0b<?> q0bVar : this.a) {
                        q0bVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(q0b<?> q0bVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q0bVar) == null) {
                synchronized (this) {
                    this.b.add(q0bVar);
                    j0b j0bVar = this.c;
                    b bVar = new b(q0bVar);
                    q0bVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = q0bVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        pza.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + q0bVar.a);
                    IPushInvoke iPushInvoke = ((m0b) j0bVar).b;
                    String str = q0bVar.a;
                    RequestHeader requestHeader = q0bVar.d;
                    IMessageEntity iMessageEntity = q0bVar.b;
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
                    nza.g(this.f.a);
                    this.d = null;
                    for (q0b<?> q0bVar : this.a) {
                        c(q0bVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements t0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public q0b<?> a;

        public b(q0b<?> q0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q0bVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947711729, "Lcom/baidu/tieba/f0b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947711729, "Lcom/baidu/tieba/f0b;");
                return;
            }
        }
        c = new f0b();
    }

    public f0b() {
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

    public <TResult> g0b<TResult> a(q0b<TResult> q0bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q0bVar)) == null) {
            y0b<TResult> y0bVar = new y0b<>();
            q0bVar.e = y0bVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, q0bVar));
            return y0bVar.a;
        }
        return (g0b) invokeL.objValue;
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
                q0b<?> q0bVar = (q0b) message.obj;
                a0b a0bVar = q0bVar.c;
                a aVar2 = this.b.get(a0bVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, a0bVar);
                    this.b.put(a0bVar, aVar2);
                }
                synchronized (aVar2) {
                    nza.g(aVar2.f.a);
                    String str = "sendRequest " + q0bVar.a;
                    if (((m0b) aVar2.c).b()) {
                        aVar2.c(q0bVar);
                    } else {
                        aVar2.a.add(q0bVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                nza.g(aVar2.f.a);
                                if (((m0b) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((m0b) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        m0b m0bVar = (m0b) aVar2.c;
                                        m0bVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = m0bVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            uza uzaVar = uza.e;
                                            int b2 = HonorApiAvailability.b(uzaVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                m0bVar.a.set(5);
                                                qza a2 = HonorApiAvailability.a(uzaVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                p0b p0bVar = new p0b(a2);
                                                m0bVar.d = p0bVar;
                                                p0bVar.b = new l0b(m0bVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + p0bVar.a;
                                                    p0bVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = p0bVar.a.c();
                                                    String b3 = p0bVar.a.b();
                                                    String d = p0bVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (p0b.e) {
                                                        if (uzaVar.a().bindService(intent, p0bVar, 1)) {
                                                            Handler handler = p0bVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                p0bVar.c = new Handler(Looper.getMainLooper(), new o0b(p0bVar));
                                                            }
                                                            p0bVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            p0bVar.d = true;
                                                            p0bVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                m0bVar.a(b2);
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
                q0b q0bVar2 = (q0b) message.obj;
                a0b a0bVar2 = q0bVar2.c;
                if (a0bVar2 != null && this.b.containsKey(a0bVar2) && (aVar = this.b.get(a0bVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + q0bVar2.a;
                        aVar.b.remove(q0bVar2);
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
