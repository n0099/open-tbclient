package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e50;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class[] a;
        public final /* synthetic */ e50.a b;
        public final /* synthetic */ Context c;

        public a(Class[] clsArr, e50.a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clsArr, aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clsArr;
            this.b = aVar;
            this.c = context;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE] complete} */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, componentName, iBinder) != null) {
                return;
            }
            try {
                try {
                    Object invoke = this.a[0].getMethod("asInterface", IBinder.class).invoke(null, iBinder);
                    this.b.a(true, (String) invoke.getClass().getMethod("getOAID", new Class[0]).invoke(invoke, new Object[0]));
                } finally {
                    try {
                        this.c.unbindService(this);
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
                this.b.a(false, null);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    public static void a(Context context, e50.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, aVar) == null) {
            if (context == null) {
                aVar.a(false, null);
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            Class[] clsArr = new Class[1];
            try {
                clsArr[0] = Class.forName("com.samsung.android.deviceidservice.IDeviceIdService$Stub");
            } catch (Throwable unused) {
            }
            if (clsArr[0] == null) {
                aVar.a(false, null);
                return;
            }
            try {
                context.bindService(intent, new a(clsArr, aVar, context), 1);
            } catch (Throwable unused2) {
                aVar.a(false, null);
            }
        }
    }
}
