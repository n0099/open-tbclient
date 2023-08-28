package com.baidu.tieba;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aub;
import com.baidu.tieba.wtb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class gub implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final Object e;
    public transient /* synthetic */ FieldHolder $fh;
    public final htb a;
    public a b;
    public Handler c;
    public boolean d;

    /* loaded from: classes6.dex */
    public interface a {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947807829, "Lcom/baidu/tieba/gub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947807829, "Lcom/baidu/tieba/gub;");
                return;
            }
        }
        e = new Object();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (e) {
                Handler handler = this.c;
                if (handler != null) {
                    handler.removeMessages(1001);
                    this.c = null;
                }
            }
        }
    }

    public gub(htb htbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {htbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = false;
        this.a = htbVar;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, componentName) == null) {
            Log.i("AIDLSrvConnection", "enter onNullBinding, than unBind.");
            if (this.d) {
                this.d = false;
                return;
            }
            c();
            a();
            a aVar = this.b;
            if (aVar != null) {
                cub cubVar = (cub) aVar;
                cubVar.a.a.set(1);
                cubVar.a.a(8002005);
                cubVar.a.b = null;
            }
        }
    }

    public final void b(int i) {
        a aVar;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (aVar = this.b) != null) {
            cub cubVar = (cub) aVar;
            AtomicInteger atomicInteger = cubVar.a.a;
            if (i == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            atomicInteger.set(i2);
            cubVar.a.a(i);
            cubVar.a.b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, componentName) == null) {
            Log.i("AIDLSrvConnection", "enter onServiceDisconnected.");
            a aVar = this.b;
            if (aVar != null) {
                cub cubVar = (cub) aVar;
                cubVar.a.a.set(1);
                cubVar.a.a(8002002);
                cubVar.a.b = null;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                Log.i("AIDLSrvConnection", "trying to unbind service from " + this);
                ltb.e.a().unbindService(this);
            } catch (Exception e2) {
                String str = "on unBind service exception:" + e2.getMessage();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, componentName, iBinder) == null) {
            Log.i("AIDLSrvConnection", "enter onServiceConnected.");
            a();
            a aVar = this.b;
            if (aVar != null) {
                cub cubVar = (cub) aVar;
                cubVar.a.b = IPushInvoke.Stub.asInterface(iBinder);
                if (cubVar.a.b == null) {
                    cubVar.a.d.c();
                    cubVar.a.a.set(1);
                    cubVar.a.a(8002001);
                    return;
                }
                cubVar.a.a.set(3);
                aub.a aVar2 = cubVar.a.c;
                if (aVar2 != null) {
                    wtb.a aVar3 = (wtb.a) aVar2;
                    if (Looper.myLooper() == aVar3.f.a.getLooper()) {
                        aVar3.d();
                    } else {
                        aVar3.f.a.post(new ttb(aVar3));
                    }
                }
            }
        }
    }
}
