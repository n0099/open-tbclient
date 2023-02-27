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
import com.baidu.tieba.hea;
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
/* loaded from: classes4.dex */
public class dea implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final dea c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<yda, a> b;

    /* loaded from: classes4.dex */
    public class a implements hea.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<oea<?>> a;
        public final Queue<oea<?>> b;
        public final hea c;
        public HonorPushErrorEnum d;
        public final yda e;
        public final /* synthetic */ dea f;

        public a(dea deaVar, yda ydaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deaVar, ydaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = deaVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new kea(this);
            this.d = null;
            this.e = ydaVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lda.g(this.f.a);
                kea keaVar = (kea) this.c;
                int i = keaVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        keaVar.a.set(4);
                        return;
                    }
                    return;
                }
                nea neaVar = keaVar.d;
                if (neaVar != null) {
                    neaVar.c();
                }
                keaVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    lda.g(this.f.a);
                    for (oea<?> oeaVar : this.a) {
                        oeaVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(oea<?> oeaVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oeaVar) == null) {
                synchronized (this) {
                    this.b.add(oeaVar);
                    hea heaVar = this.c;
                    b bVar = new b(oeaVar);
                    oeaVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = oeaVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        nda.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + oeaVar.a);
                    IPushInvoke iPushInvoke = ((kea) heaVar).b;
                    String str = oeaVar.a;
                    RequestHeader requestHeader = oeaVar.d;
                    IMessageEntity iMessageEntity = oeaVar.b;
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
                    lda.g(this.f.a);
                    this.d = null;
                    for (oea<?> oeaVar : this.a) {
                        c(oeaVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements rea {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public oea<?> a;

        public b(oea<?> oeaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oeaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oeaVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703049, "Lcom/baidu/tieba/dea;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703049, "Lcom/baidu/tieba/dea;");
                return;
            }
        }
        c = new dea();
    }

    public dea() {
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

    public <TResult> eea<TResult> a(oea<TResult> oeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oeaVar)) == null) {
            wea<TResult> weaVar = new wea<>();
            oeaVar.e = weaVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, oeaVar));
            return weaVar.a;
        }
        return (eea) invokeL.objValue;
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
                oea<?> oeaVar = (oea) message.obj;
                yda ydaVar = oeaVar.c;
                a aVar2 = this.b.get(ydaVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, ydaVar);
                    this.b.put(ydaVar, aVar2);
                }
                synchronized (aVar2) {
                    lda.g(aVar2.f.a);
                    String str = "sendRequest " + oeaVar.a;
                    if (((kea) aVar2.c).b()) {
                        aVar2.c(oeaVar);
                    } else {
                        aVar2.a.add(oeaVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                lda.g(aVar2.f.a);
                                if (((kea) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((kea) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        kea keaVar = (kea) aVar2.c;
                                        keaVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = keaVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            sda sdaVar = sda.e;
                                            int b2 = HonorApiAvailability.b(sdaVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                keaVar.a.set(5);
                                                oda a2 = HonorApiAvailability.a(sdaVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                nea neaVar = new nea(a2);
                                                keaVar.d = neaVar;
                                                neaVar.b = new jea(keaVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + neaVar.a;
                                                    neaVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = neaVar.a.c();
                                                    String b3 = neaVar.a.b();
                                                    String d = neaVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (nea.e) {
                                                        if (sdaVar.a().bindService(intent, neaVar, 1)) {
                                                            Handler handler = neaVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                neaVar.c = new Handler(Looper.getMainLooper(), new mea(neaVar));
                                                            }
                                                            neaVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            neaVar.d = true;
                                                            neaVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                keaVar.a(b2);
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
                oea oeaVar2 = (oea) message.obj;
                yda ydaVar2 = oeaVar2.c;
                if (ydaVar2 != null && this.b.containsKey(ydaVar2) && (aVar = this.b.get(ydaVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + oeaVar2.a;
                        aVar.b.remove(oeaVar2);
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
