package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class de2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<fk4, Set<c>> a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, an3 an3Var);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static de2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-864530150, "Lcom/baidu/tieba/de2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-864530150, "Lcom/baidu/tieba/de2$b;");
                    return;
                }
            }
            a = new de2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947701592, "Lcom/baidu/tieba/de2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947701592, "Lcom/baidu/tieba/de2;");
                return;
            }
        }
        b = rr1.a;
    }

    public de2() {
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
        this.a = new HashMap<>();
    }

    public static de2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (de2) invokeV.objValue;
    }

    public /* synthetic */ de2(a aVar) {
        this();
    }

    public synchronized void a(fk4 fk4Var, PMSDownloadType pMSDownloadType, an3 an3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, fk4Var, pMSDownloadType, an3Var) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadError:" + fk4Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(fk4Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.b(pMSDownloadType, an3Var);
                        }
                    }
                    this.a.remove(fk4Var);
                }
            }
        }
    }

    public synchronized void b(fk4 fk4Var, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fk4Var, pMSDownloadType) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + fk4Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(fk4Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.a(pMSDownloadType);
                        }
                    }
                    this.a.remove(fk4Var);
                }
            }
        }
    }

    public synchronized void d(fk4 fk4Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fk4Var, cVar) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "registerResultListener:" + fk4Var);
                }
                if (fk4Var != null && cVar != null) {
                    Set<c> set = this.a.get(fk4Var);
                    if (set != null) {
                        set.add(cVar);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(cVar);
                        this.a.put(fk4Var, hashSet);
                    }
                }
            }
        }
    }
}
