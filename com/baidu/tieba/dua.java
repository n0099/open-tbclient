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
import com.baidu.tieba.hua;
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
public class dua implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final dua c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<yta, a> b;

    /* loaded from: classes4.dex */
    public class a implements hua.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<oua<?>> a;
        public final Queue<oua<?>> b;
        public final hua c;
        public HonorPushErrorEnum d;
        public final yta e;
        public final /* synthetic */ dua f;

        public a(dua duaVar, yta ytaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duaVar, ytaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = duaVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new kua(this);
            this.d = null;
            this.e = ytaVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lta.g(this.f.a);
                kua kuaVar = (kua) this.c;
                int i = kuaVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        kuaVar.a.set(4);
                        return;
                    }
                    return;
                }
                nua nuaVar = kuaVar.d;
                if (nuaVar != null) {
                    nuaVar.c();
                }
                kuaVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    lta.g(this.f.a);
                    for (oua<?> ouaVar : this.a) {
                        ouaVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(oua<?> ouaVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ouaVar) == null) {
                synchronized (this) {
                    this.b.add(ouaVar);
                    hua huaVar = this.c;
                    b bVar = new b(ouaVar);
                    ouaVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = ouaVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        nta.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + ouaVar.a);
                    IPushInvoke iPushInvoke = ((kua) huaVar).b;
                    String str = ouaVar.a;
                    RequestHeader requestHeader = ouaVar.d;
                    IMessageEntity iMessageEntity = ouaVar.b;
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
                    lta.g(this.f.a);
                    this.d = null;
                    for (oua<?> ouaVar : this.a) {
                        c(ouaVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements rua {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public oua<?> a;

        public b(oua<?> ouaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ouaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ouaVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718425, "Lcom/baidu/tieba/dua;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718425, "Lcom/baidu/tieba/dua;");
                return;
            }
        }
        c = new dua();
    }

    public dua() {
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

    public <TResult> eua<TResult> a(oua<TResult> ouaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ouaVar)) == null) {
            wua<TResult> wuaVar = new wua<>();
            ouaVar.e = wuaVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, ouaVar));
            return wuaVar.a;
        }
        return (eua) invokeL.objValue;
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
                oua<?> ouaVar = (oua) message.obj;
                yta ytaVar = ouaVar.c;
                a aVar2 = this.b.get(ytaVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, ytaVar);
                    this.b.put(ytaVar, aVar2);
                }
                synchronized (aVar2) {
                    lta.g(aVar2.f.a);
                    String str = "sendRequest " + ouaVar.a;
                    if (((kua) aVar2.c).b()) {
                        aVar2.c(ouaVar);
                    } else {
                        aVar2.a.add(ouaVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                lta.g(aVar2.f.a);
                                if (((kua) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((kua) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        kua kuaVar = (kua) aVar2.c;
                                        kuaVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = kuaVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            sta staVar = sta.e;
                                            int b2 = HonorApiAvailability.b(staVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                kuaVar.a.set(5);
                                                ota a2 = HonorApiAvailability.a(staVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                nua nuaVar = new nua(a2);
                                                kuaVar.d = nuaVar;
                                                nuaVar.b = new jua(kuaVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + nuaVar.a;
                                                    nuaVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = nuaVar.a.c();
                                                    String b3 = nuaVar.a.b();
                                                    String d = nuaVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (nua.e) {
                                                        if (staVar.a().bindService(intent, nuaVar, 1)) {
                                                            Handler handler = nuaVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                nuaVar.c = new Handler(Looper.getMainLooper(), new mua(nuaVar));
                                                            }
                                                            nuaVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            nuaVar.d = true;
                                                            nuaVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                kuaVar.a(b2);
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
                oua ouaVar2 = (oua) message.obj;
                yta ytaVar2 = ouaVar2.c;
                if (ytaVar2 != null && this.b.containsKey(ytaVar2) && (aVar = this.b.get(ytaVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + ouaVar2.a;
                        aVar.b.remove(ouaVar2);
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
