package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<hj0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-918153981, "Lcom/baidu/tieba/bi0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-918153981, "Lcom/baidu/tieba/bi0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadAction.values().length];
            a = iArr;
            try {
                iArr[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadAction.INSTALL_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AdDownloadAction.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdDownloadAction.FAIL_RETRY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdDownloadAction.FAIL_PERMISSION_DENY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final bi0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-918153950, "Lcom/baidu/tieba/bi0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-918153950, "Lcom/baidu/tieba/bi0$b;");
                    return;
                }
            }
            a = new bi0(null);
        }
    }

    public /* synthetic */ bi0(a aVar) {
        this();
    }

    public static bi0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (bi0) invokeV.objValue;
    }

    public static void c(@NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, pi0Var) == null) {
            if (TextUtils.isEmpty(pi0Var.p.c) || !ng0.b(pi0Var.p.c)) {
                rj0.f(pi0Var.d);
                d(AdDownloadAction.OPEN, pi0Var);
            }
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, pi0Var) == null) {
            e(adDownloadAction, pi0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull pi0 pi0Var, @Nullable xi0 xi0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, adDownloadAction, pi0Var, xi0Var) == null) || TextUtils.isEmpty(pi0Var.p.a)) {
            return;
        }
        String str = pi0Var.q.j;
        switch (a.a[adDownloadAction.ordinal()]) {
            case 1:
                logType = ClogBuilder.LogType.DOWNLOAD_START;
                break;
            case 2:
                logType = ClogBuilder.LogType.DOWNLOAD_PAUSE;
                break;
            case 3:
                logType = ClogBuilder.LogType.DOWNLOAD_CONTINUE;
                break;
            case 4:
                logType = ClogBuilder.LogType.DOWNLOAD_COMPLETE;
                break;
            case 5:
                logType = ClogBuilder.LogType.DOWNLOAD_INSTALL;
                break;
            case 6:
                logType = ClogBuilder.LogType.INSTALL_COMPLETE;
                break;
            case 7:
                logType = ClogBuilder.LogType.DEEP_LINK;
                break;
            case 8:
                logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                break;
            case 9:
                logType = ClogBuilder.LogType.DOWNLOAD_RETRY;
                break;
            default:
                return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ClogBuilder.Area.DOWNLOAD_BUTTON.type;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType).p(pi0Var.p.a).v(pi0Var.q.a).j(str).k(pi0Var.d).l(pi0Var.q.a).m(pi0Var.q.b).n(pi0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(pi0Var.q.d)) {
            yx0.f(jSONObject, "ad_download_content_type", pi0Var.q.d);
        }
        long j = pi0Var.q.e;
        if (j > 0) {
            yx0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = pi0Var.n;
        if (i > 0) {
            yx0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(pi0Var.o)) {
            yx0.f(jSONObject, "version_name", pi0Var.o);
        }
        if (xi0Var != null) {
            Exception exc = xi0Var.a;
            if (exc != null) {
                yx0.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = xi0Var.b;
            if (str2 != null) {
                yx0.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        iy0.b(clogBuilder);
    }

    public void a(@NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pi0Var) == null) || pi0Var.f()) {
            return;
        }
        this.c.b(pi0Var);
        pi0Var.c = AdDownloadStatus.NONE;
        f(AdDownloadAction.FAIL, pi0Var);
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, pi0Var) == null) {
            g(adDownloadAction, pi0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull pi0 pi0Var, @Nullable xi0 xi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, pi0Var, xi0Var) == null) {
            e(adDownloadAction, pi0Var, xi0Var);
            this.b.readLock().lock();
            try {
                List list = (List) zx0.b(this.a, pi0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != xx0.k(list); i++) {
                    hj0 hj0Var = (hj0) xx0.d(list, i);
                    if (hj0Var != null && hj0Var.getData() != null) {
                        hj0Var.getData().i(pi0Var);
                        hj0Var.a(adDownloadAction, hj0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void h(@NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pi0Var) == null) {
            this.c.c(pi0Var);
        }
    }

    public void i(String str, hj0 hj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, hj0Var) == null) || TextUtils.isEmpty(str) || hj0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) zx0.b(this.a, str);
            if (list == null) {
                list = new ArrayList();
                zx0.e(this.a, str, list);
            }
            xx0.b(list, hj0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public void j(@NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pi0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, pi0Var);
            this.c.d(pi0Var, new ci0(pi0Var));
        }
    }

    public void k(@NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pi0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, pi0Var);
            pi0Var.b = this.c.a(pi0Var, new ci0(pi0Var));
            pi0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public void l(String str, hj0 hj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, hj0Var) == null) || TextUtils.isEmpty(str) || hj0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) zx0.b(this.a, str);
            if (list == null) {
                return;
            }
            xx0.j(list, hj0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public bi0() {
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
        this.a = new HashMap<>(32);
        this.b = new ReentrantReadWriteLock();
        this.c = jj0.b();
    }
}
