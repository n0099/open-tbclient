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
/* loaded from: classes3.dex */
public class a72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<cd4, Set<c>> a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, xf3 xf3Var);
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static a72 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-992899569, "Lcom/baidu/tieba/a72$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-992899569, "Lcom/baidu/tieba/a72$b;");
                    return;
                }
            }
            a = new a72(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947568013, "Lcom/baidu/tieba/a72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947568013, "Lcom/baidu/tieba/a72;");
                return;
            }
        }
        b = ok1.a;
    }

    public a72() {
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

    public static a72 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (a72) invokeV.objValue;
    }

    public /* synthetic */ a72(a aVar) {
        this();
    }

    public synchronized void a(cd4 cd4Var, PMSDownloadType pMSDownloadType, xf3 xf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cd4Var, pMSDownloadType, xf3Var) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadError:" + cd4Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(cd4Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.b(pMSDownloadType, xf3Var);
                        }
                    }
                    this.a.remove(cd4Var);
                }
            }
        }
    }

    public synchronized void b(cd4 cd4Var, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cd4Var, pMSDownloadType) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + cd4Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(cd4Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.a(pMSDownloadType);
                        }
                    }
                    this.a.remove(cd4Var);
                }
            }
        }
    }

    public synchronized void d(cd4 cd4Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cd4Var, cVar) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "registerResultListener:" + cd4Var);
                }
                if (cd4Var != null && cVar != null) {
                    Set<c> set = this.a.get(cd4Var);
                    if (set != null) {
                        set.add(cVar);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(cVar);
                        this.a.put(cd4Var, hashSet);
                    }
                }
            }
        }
    }
}
