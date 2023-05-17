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
/* loaded from: classes5.dex */
public class dk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<il0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-859048637, "Lcom/baidu/tieba/dk0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-859048637, "Lcom/baidu/tieba/dk0$a;");
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

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final dk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-859048606, "Lcom/baidu/tieba/dk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-859048606, "Lcom/baidu/tieba/dk0$b;");
                    return;
                }
            }
            a = new dk0(null);
        }
    }

    public dk0() {
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
        this.c = kl0.b();
    }

    public /* synthetic */ dk0(a aVar) {
        this();
    }

    public void a(@NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, qk0Var) != null) || qk0Var.f()) {
            return;
        }
        this.c.b(qk0Var);
        qk0Var.c = AdDownloadStatus.NONE;
        yk0 yk0Var = new yk0();
        yk0Var.b = "install_failed";
        g(AdDownloadAction.FAIL, qk0Var, yk0Var);
    }

    public void h(@NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qk0Var) == null) {
            this.c.c(qk0Var);
        }
    }

    public void j(@NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qk0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, qk0Var);
            this.c.d(qk0Var, new ek0(qk0Var));
        }
    }

    public void k(@NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, qk0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, qk0Var);
            qk0Var.b = this.c.a(qk0Var, new ek0(qk0Var));
            qk0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static dk0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (dk0) invokeV.objValue;
    }

    public static void c(@NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, qk0Var) == null) {
            if (!TextUtils.isEmpty(qk0Var.p.c) && ki0.b(qk0Var.p.c)) {
                if (vm0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    d(AdDownloadAction.OPEN, qk0Var);
                    return;
                }
                return;
            }
            ul0.g(qk0Var.d);
            d(AdDownloadAction.OPEN, qk0Var);
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, qk0Var) == null) {
            e(adDownloadAction, qk0Var, null);
        }
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, qk0Var) == null) {
            g(adDownloadAction, qk0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull qk0 qk0Var, @Nullable yk0 yk0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, qk0Var, yk0Var) != null) || TextUtils.isEmpty(qk0Var.p.a)) {
            return;
        }
        String str = qk0Var.q.j;
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
                if (vm0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    logType = ClogBuilder.LogType.CLICK;
                    str = ClogBuilder.Area.OPEN_BUTTON.type;
                    break;
                } else {
                    logType = ClogBuilder.LogType.DEEP_LINK;
                    break;
                }
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
        clogBuilder.y(logType).p(qk0Var.p.a).v(qk0Var.q.a).j(str).k(qk0Var.d).l(qk0Var.q.a).m(qk0Var.q.b).n(qk0Var.g);
        JSONObject jSONObject = new JSONObject();
        p11.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(qk0Var.q.d)) {
            p11.f(jSONObject, "ad_download_content_type", qk0Var.q.d);
        }
        long j = qk0Var.q.e;
        if (j > 0) {
            p11.e(jSONObject, "ad_download_content_length", j);
        }
        int i = qk0Var.n;
        if (i > 0) {
            p11.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(qk0Var.o)) {
            p11.f(jSONObject, "version_name", qk0Var.o);
        }
        if (yk0Var != null) {
            Exception exc = yk0Var.a;
            if (exc != null) {
                p11.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = yk0Var.b;
            if (str2 != null) {
                p11.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        e21.b(clogBuilder);
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull qk0 qk0Var, @Nullable yk0 yk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, qk0Var, yk0Var) == null) {
            e(adDownloadAction, qk0Var, yk0Var);
            this.b.readLock().lock();
            try {
                List list = (List) q11.b(this.a, qk0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != o11.l(list); i++) {
                    il0 il0Var = (il0) o11.d(list, i);
                    if (il0Var != null && il0Var.getData() != null) {
                        il0Var.getData().i(qk0Var);
                        il0Var.a(adDownloadAction, il0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void i(String str, il0 il0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, il0Var) == null) && !TextUtils.isEmpty(str) && il0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) q11.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    q11.e(this.a, str, list);
                }
                o11.b(list, il0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void l(String str, il0 il0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, il0Var) == null) && !TextUtils.isEmpty(str) && il0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) q11.b(this.a, str);
                if (list == null) {
                    return;
                }
                o11.j(list, il0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
