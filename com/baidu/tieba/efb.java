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
import com.baidu.tieba.ifb;
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
public class efb implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final efb c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<zeb, a> b;

    /* loaded from: classes5.dex */
    public class a implements ifb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<pfb<?>> a;
        public final Queue<pfb<?>> b;
        public final ifb c;
        public HonorPushErrorEnum d;
        public final zeb e;
        public final /* synthetic */ efb f;

        public a(efb efbVar, zeb zebVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {efbVar, zebVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = efbVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new lfb(this);
            this.d = null;
            this.e = zebVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                meb.g(this.f.a);
                lfb lfbVar = (lfb) this.c;
                int i = lfbVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        lfbVar.a.set(4);
                        return;
                    }
                    return;
                }
                ofb ofbVar = lfbVar.d;
                if (ofbVar != null) {
                    ofbVar.c();
                }
                lfbVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    meb.g(this.f.a);
                    for (pfb<?> pfbVar : this.a) {
                        pfbVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(pfb<?> pfbVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pfbVar) == null) {
                synchronized (this) {
                    this.b.add(pfbVar);
                    ifb ifbVar = this.c;
                    b bVar = new b(pfbVar);
                    pfbVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = pfbVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        oeb.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + pfbVar.a);
                    IPushInvoke iPushInvoke = ((lfb) ifbVar).b;
                    String str = pfbVar.a;
                    RequestHeader requestHeader = pfbVar.d;
                    IMessageEntity iMessageEntity = pfbVar.b;
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
                    meb.g(this.f.a);
                    this.d = null;
                    for (pfb<?> pfbVar : this.a) {
                        c(pfbVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements sfb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pfb<?> a;

        public b(pfb<?> pfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfbVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947733832, "Lcom/baidu/tieba/efb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947733832, "Lcom/baidu/tieba/efb;");
                return;
            }
        }
        c = new efb();
    }

    public efb() {
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

    public <TResult> ffb<TResult> a(pfb<TResult> pfbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pfbVar)) == null) {
            xfb<TResult> xfbVar = new xfb<>();
            pfbVar.e = xfbVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, pfbVar));
            return xfbVar.a;
        }
        return (ffb) invokeL.objValue;
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
                pfb<?> pfbVar = (pfb) message.obj;
                zeb zebVar = pfbVar.c;
                a aVar2 = this.b.get(zebVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, zebVar);
                    this.b.put(zebVar, aVar2);
                }
                synchronized (aVar2) {
                    meb.g(aVar2.f.a);
                    String str = "sendRequest " + pfbVar.a;
                    if (((lfb) aVar2.c).b()) {
                        aVar2.c(pfbVar);
                    } else {
                        aVar2.a.add(pfbVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                meb.g(aVar2.f.a);
                                if (((lfb) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((lfb) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        lfb lfbVar = (lfb) aVar2.c;
                                        lfbVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = lfbVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            teb tebVar = teb.e;
                                            int b2 = HonorApiAvailability.b(tebVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                lfbVar.a.set(5);
                                                peb a2 = HonorApiAvailability.a(tebVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                ofb ofbVar = new ofb(a2);
                                                lfbVar.d = ofbVar;
                                                ofbVar.b = new kfb(lfbVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + ofbVar.a;
                                                    ofbVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = ofbVar.a.c();
                                                    String b3 = ofbVar.a.b();
                                                    String d = ofbVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (ofb.e) {
                                                        if (tebVar.a().bindService(intent, ofbVar, 1)) {
                                                            Handler handler = ofbVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                ofbVar.c = new Handler(Looper.getMainLooper(), new nfb(ofbVar));
                                                            }
                                                            ofbVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            ofbVar.d = true;
                                                            ofbVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                lfbVar.a(b2);
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
                pfb pfbVar2 = (pfb) message.obj;
                zeb zebVar2 = pfbVar2.c;
                if (zebVar2 != null && this.b.containsKey(zebVar2) && (aVar = this.b.get(zebVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + pfbVar2.a;
                        aVar.b.remove(pfbVar2);
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
