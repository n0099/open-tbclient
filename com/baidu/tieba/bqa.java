package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bqa {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public volatile boolean b;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final bqa a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-909306023, "Lcom/baidu/tieba/bqa$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-909306023, "Lcom/baidu/tieba/bqa$b;");
                    return;
                }
            }
            a = new bqa(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947654999, "Lcom/baidu/tieba/bqa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947654999, "Lcom/baidu/tieba/bqa;");
                return;
            }
        }
        c = qpa.a;
        d = bqa.class.getSimpleName();
    }

    public static bqa a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (bqa) invokeV.objValue;
    }

    public bqa() {
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
        String b2 = rpa.b("fulllog_switch", null);
        if (!TextUtils.isEmpty(b2)) {
            this.b = Boolean.valueOf(b2).booleanValue();
        }
        Long.parseLong(rpa.b("fulllog_switch_push_time", Long.toString(System.currentTimeMillis())));
    }

    public /* synthetic */ bqa(a aVar) {
        this();
    }

    public final boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j - this.a > 60000) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean b2 = b(currentTimeMillis);
            if (b2) {
                this.a = currentTimeMillis;
            }
            if (z || b2) {
                String b3 = rpa.b("fulllog_switch_push_time", Long.toString(System.currentTimeMillis()));
                ArrayList arrayList = new ArrayList();
                arrayList.add("net");
                IUploadTask iUploadTask = (IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE);
                if (iUploadTask != null) {
                    long j = currentTimeMillis - 5184000000L;
                    long j2 = currentTimeMillis + 3600000;
                    iUploadTask.activeUploadSnapShot("netLog", b3, arrayList, null, 10240L, j, j2, true, null);
                    if (c) {
                        String str = d;
                        Log.i(str, "dataId" + b3 + "   isMatchTimeInterval(curTime) == true");
                        String str2 = d;
                        Log.i(str2, "startTime==" + j + "endTime==" + j2);
                    }
                }
            }
        }
    }

    public synchronized boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, jSONObject2)) == null) {
            synchronized (this) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString("type");
                    String optString2 = jSONObject.optString("fulllog");
                    if (TextUtils.equals(optString, "fulllog_network")) {
                        if (TextUtils.equals(optString2, "1")) {
                            this.a = System.currentTimeMillis();
                            this.b = true;
                            c(true);
                            if (c) {
                                Log.i(d, "Start online real full network log!");
                            }
                            rpa.d("fulllog_switch_push_time", Long.toString(System.currentTimeMillis()));
                        } else if (TextUtils.equals(optString2, "0")) {
                            this.b = false;
                            if (c) {
                                Log.i(d, "Stop online real full network log!");
                            }
                        }
                        rpa.d("fulllog_switch", String.valueOf(this.b));
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
