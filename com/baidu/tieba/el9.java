package com.baidu.tieba;

import android.content.Context;
import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class el9 {
    public static /* synthetic */ Interceptable $ic;
    public static el9 c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;

    /* loaded from: classes5.dex */
    public class a implements CyberPlayerManager.InstallListener2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CyberPlayerManager.InstallListener a;
        public final /* synthetic */ el9 b;

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
        public void onInstallInfo(int i, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        public a(el9 el9Var, CyberPlayerManager.InstallListener installListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el9Var, installListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = el9Var;
            this.a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                if (this.b.b < 3) {
                    el9.c(this.b);
                    this.b.g(this.a);
                    return;
                }
                this.b.b = 0;
                CyberPlayerManager.InstallListener installListener = this.a;
                if (installListener != null) {
                    installListener.onInstallError(i, i2, str);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                this.b.b = 0;
                this.b.a = true;
                CyberPlayerManager.InstallListener installListener = this.a;
                if (installListener != null) {
                    installListener.onInstallSuccess(i, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CyberPlayerManager.InstallListener2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CyberPlayerManager.InstallListener a;
        public final /* synthetic */ el9 b;

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
        public void onInstallInfo(int i, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        public b(el9 el9Var, CyberPlayerManager.InstallListener installListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el9Var, installListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = el9Var;
            this.a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                if (this.b.b < 3) {
                    el9.c(this.b);
                    this.b.g(this.a);
                    return;
                }
                this.b.b = 0;
                CyberPlayerManager.InstallListener installListener = this.a;
                if (installListener != null) {
                    installListener.onInstallError(i, i2, str);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                this.b.b = 0;
                this.b.a = true;
                CyberPlayerManager.InstallListener installListener = this.a;
                if (installListener != null) {
                    installListener.onInstallSuccess(i, str);
                }
            }
        }
    }

    public el9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
    }

    public static el9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (c == null) {
                i();
            }
            return c;
        }
        return (el9) invokeV.objValue;
    }

    public static synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (el9.class) {
                if (c == null) {
                    c = new el9();
                }
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean isCoreLoaded = CyberPlayerManager.isCoreLoaded(3);
            if (isCoreLoaded && !this.a) {
                this.a = true;
            }
            return isCoreLoaded;
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ int c(el9 el9Var) {
        int i = el9Var.b;
        el9Var.b = i + 1;
        return i;
    }

    public void g(CyberPlayerManager.InstallListener installListener) {
        String absolutePath;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, installListener) == null) && !CyberPlayerManager.isCoreLoaded(3)) {
            this.a = false;
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
            if (cacheDir != null) {
                absolutePath = cacheDir.getAbsolutePath();
            } else {
                absolutePath = Environment.getDownloadCacheDirectory().getAbsolutePath();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cache-path", absolutePath);
            try {
                CyberPlayerManager.install((Context) TbadkCoreApplication.getInst(), cuidGalaxy2, (String) null, 3, (Class<?>) null, (Map<String, String>) hashMap, (CyberPlayerManager.InstallListener2) new a(this, installListener));
            } catch (Exception unused) {
            }
        }
    }

    public void h(CyberPlayerManager.InstallListener installListener, int i) {
        String absolutePath;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, installListener, i) == null) && !CyberPlayerManager.isCoreLoaded(i)) {
            this.a = false;
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
            if (cacheDir != null) {
                absolutePath = cacheDir.getAbsolutePath();
            } else {
                absolutePath = Environment.getDownloadCacheDirectory().getAbsolutePath();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cache-path", absolutePath);
            try {
                CyberPlayerManager.install((Context) TbadkCoreApplication.getInst(), cuidGalaxy2, (String) null, i, (Class<?>) null, (Map<String, String>) hashMap, (CyberPlayerManager.InstallListener2) new b(this, installListener));
            } catch (Exception unused) {
            }
        }
    }
}
