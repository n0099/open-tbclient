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
import com.baidu.tieba.k0b;
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
public class g0b implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final g0b c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<b0b, a> b;

    /* loaded from: classes5.dex */
    public class a implements k0b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<r0b<?>> a;
        public final Queue<r0b<?>> b;
        public final k0b c;
        public HonorPushErrorEnum d;
        public final b0b e;
        public final /* synthetic */ g0b f;

        public a(g0b g0bVar, b0b b0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0bVar, b0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = g0bVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new n0b(this);
            this.d = null;
            this.e = b0bVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oza.g(this.f.a);
                n0b n0bVar = (n0b) this.c;
                int i = n0bVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        n0bVar.a.set(4);
                        return;
                    }
                    return;
                }
                q0b q0bVar = n0bVar.d;
                if (q0bVar != null) {
                    q0bVar.c();
                }
                n0bVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    oza.g(this.f.a);
                    for (r0b<?> r0bVar : this.a) {
                        r0bVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(r0b<?> r0bVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r0bVar) == null) {
                synchronized (this) {
                    this.b.add(r0bVar);
                    k0b k0bVar = this.c;
                    b bVar = new b(r0bVar);
                    r0bVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = r0bVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        qza.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + r0bVar.a);
                    IPushInvoke iPushInvoke = ((n0b) k0bVar).b;
                    String str = r0bVar.a;
                    RequestHeader requestHeader = r0bVar.d;
                    IMessageEntity iMessageEntity = r0bVar.b;
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
                    oza.g(this.f.a);
                    this.d = null;
                    for (r0b<?> r0bVar : this.a) {
                        c(r0bVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements u0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public r0b<?> a;

        public b(r0b<?> r0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r0bVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947741520, "Lcom/baidu/tieba/g0b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947741520, "Lcom/baidu/tieba/g0b;");
                return;
            }
        }
        c = new g0b();
    }

    public g0b() {
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

    public <TResult> h0b<TResult> a(r0b<TResult> r0bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r0bVar)) == null) {
            z0b<TResult> z0bVar = new z0b<>();
            r0bVar.e = z0bVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, r0bVar));
            return z0bVar.a;
        }
        return (h0b) invokeL.objValue;
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
                r0b<?> r0bVar = (r0b) message.obj;
                b0b b0bVar = r0bVar.c;
                a aVar2 = this.b.get(b0bVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, b0bVar);
                    this.b.put(b0bVar, aVar2);
                }
                synchronized (aVar2) {
                    oza.g(aVar2.f.a);
                    String str = "sendRequest " + r0bVar.a;
                    if (((n0b) aVar2.c).b()) {
                        aVar2.c(r0bVar);
                    } else {
                        aVar2.a.add(r0bVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                oza.g(aVar2.f.a);
                                if (((n0b) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((n0b) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        n0b n0bVar = (n0b) aVar2.c;
                                        n0bVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = n0bVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            vza vzaVar = vza.e;
                                            int b2 = HonorApiAvailability.b(vzaVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                n0bVar.a.set(5);
                                                rza a2 = HonorApiAvailability.a(vzaVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                q0b q0bVar = new q0b(a2);
                                                n0bVar.d = q0bVar;
                                                q0bVar.b = new m0b(n0bVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + q0bVar.a;
                                                    q0bVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = q0bVar.a.c();
                                                    String b3 = q0bVar.a.b();
                                                    String d = q0bVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (q0b.e) {
                                                        if (vzaVar.a().bindService(intent, q0bVar, 1)) {
                                                            Handler handler = q0bVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                q0bVar.c = new Handler(Looper.getMainLooper(), new p0b(q0bVar));
                                                            }
                                                            q0bVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            q0bVar.d = true;
                                                            q0bVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                n0bVar.a(b2);
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
                r0b r0bVar2 = (r0b) message.obj;
                b0b b0bVar2 = r0bVar2.c;
                if (b0bVar2 != null && this.b.containsKey(b0bVar2) && (aVar = this.b.get(b0bVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + r0bVar2.a;
                        aVar.b.remove(r0bVar2);
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
