package com.baidu.tieba;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ig0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<nh0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-719596966, "Lcom/baidu/tieba/ig0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-719596966, "Lcom/baidu/tieba/ig0$a;");
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

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ig0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-719596935, "Lcom/baidu/tieba/ig0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-719596935, "Lcom/baidu/tieba/ig0$b;");
                    return;
                }
            }
            a = new ig0(null);
        }
    }

    public ig0() {
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
        this.c = ph0.b();
    }

    public /* synthetic */ ig0(a aVar) {
        this();
    }

    public void a(@NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, vg0Var) != null) || vg0Var.f()) {
            return;
        }
        this.c.b(vg0Var);
        vg0Var.c = AdDownloadStatus.NONE;
        dh0 dh0Var = new dh0();
        dh0Var.b = "install_failed";
        h(AdDownloadAction.FAIL, vg0Var, dh0Var);
    }

    public void j(@NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vg0Var) == null) {
            this.c.c(vg0Var);
        }
    }

    public void l(@NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, vg0Var);
            this.c.d(vg0Var, new jg0(vg0Var));
        }
    }

    public void n(@NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, vg0Var);
            vg0Var.b = this.c.a(vg0Var, new jg0(vg0Var));
            vg0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static ig0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (ig0) invokeV.objValue;
    }

    public static void d(@NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, vg0Var) == null) {
            if (!TextUtils.isEmpty(vg0Var.p.c) && pe0.b(vg0Var.p.c)) {
                if (hj0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
                    e(AdDownloadAction.OPEN, vg0Var);
                    return;
                }
                return;
            }
            fi0.h(vg0Var.d);
            e(AdDownloadAction.OPEN, vg0Var);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, vg0Var) == null) {
            f(adDownloadAction, vg0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, vg0Var) == null) {
            h(adDownloadAction, vg0Var, null);
        }
    }

    public void m(@NonNull vg0 vg0Var, @NonNull jg0 jg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vg0Var, jg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, vg0Var);
            this.c.d(vg0Var, jg0Var);
        }
    }

    public void o(@NonNull vg0 vg0Var, @NonNull jg0 jg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, vg0Var, jg0Var) == null) {
            g(AdDownloadAction.PROGRESS_UPDATE, vg0Var);
            vg0Var.b = this.c.a(vg0Var, jg0Var);
            vg0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public static void f(@NonNull AdDownloadAction adDownloadAction, @NonNull vg0 vg0Var, @Nullable dh0 dh0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, adDownloadAction, vg0Var, dh0Var) != null) || TextUtils.isEmpty(vg0Var.p.a)) {
            return;
        }
        String str = vg0Var.q.j;
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
                if (hj0.b().a().a("nad_als_open_to_click_switch", 0) == 1) {
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
        clogBuilder.y(logType).p(vg0Var.p.a).v(vg0Var.q.a).j(str).k(vg0Var.d).l(vg0Var.q.a).m(vg0Var.q.b).n(vg0Var.g);
        JSONObject jSONObject = new JSONObject();
        ly0.d(jSONObject, "is_swallow", 1);
        if (!TextUtils.isEmpty(vg0Var.q.d)) {
            ly0.f(jSONObject, "ad_download_content_type", vg0Var.q.d);
        }
        long j = vg0Var.q.e;
        if (j > 0) {
            ly0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = vg0Var.n;
        if (i > 0) {
            ly0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(vg0Var.o)) {
            ly0.f(jSONObject, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, vg0Var.o);
        }
        if (dh0Var != null) {
            Exception exc = dh0Var.a;
            if (exc != null) {
                ly0.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = dh0Var.b;
            if (str2 != null) {
                ly0.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        az0.e(clogBuilder);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Context b2 = gf0.b();
            Object systemService = b2.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (!(systemService instanceof ClipboardManager)) {
                return;
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b2.getResources().getString(R.string.nad_invite_code_label), str));
            v01.a().showToast(b2, str2);
        }
    }

    public void h(@NonNull AdDownloadAction adDownloadAction, @NonNull vg0 vg0Var, @Nullable dh0 dh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adDownloadAction, vg0Var, dh0Var) == null) {
            f(adDownloadAction, vg0Var, dh0Var);
            this.b.readLock().lock();
            try {
                List list = (List) my0.b(this.a, vg0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != ky0.l(list); i++) {
                    nh0 nh0Var = (nh0) ky0.d(list, i);
                    if (nh0Var != null && nh0Var.getData() != null) {
                        nh0Var.getData().i(vg0Var);
                        nh0Var.a(adDownloadAction, nh0Var.getData());
                    }
                }
                this.b.readLock().unlock();
                i(adDownloadAction, vg0Var);
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public final void i(@NonNull AdDownloadAction adDownloadAction, @NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, adDownloadAction, vg0Var) == null) && a.a[adDownloadAction.ordinal()] == 1) {
            Context context = null;
            WeakReference<Context> weakReference = vg0Var.p.m;
            if (weakReference != null) {
                context = weakReference.get();
            }
            if (!TextUtils.isEmpty(vg0Var.p.l) && context != null) {
                pe0.c(vg0Var.p.l, context);
            }
            if (vg0Var.q.r) {
                v01.a().a(gf0.b(), R.string.nad_apk_download_start_toast);
            }
            xg0 xg0Var = vg0Var.p.k;
            if (xg0Var != null && !TextUtils.isEmpty(xg0Var.a)) {
                xg0 xg0Var2 = vg0Var.p.k;
                b(xg0Var2.a, xg0Var2.b);
            }
        }
    }

    public void k(String str, nh0 nh0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, nh0Var) == null) && !TextUtils.isEmpty(str) && nh0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) my0.b(this.a, str);
                if (list == null) {
                    list = new ArrayList();
                    my0.e(this.a, str, list);
                }
                ky0.b(list, nh0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }

    public void p(String str, nh0 nh0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, nh0Var) == null) && !TextUtils.isEmpty(str) && nh0Var != null) {
            this.b.writeLock().lock();
            try {
                List list = (List) my0.b(this.a, str);
                if (list == null) {
                    return;
                }
                ky0.j(list, nh0Var);
            } finally {
                this.b.writeLock().unlock();
            }
        }
    }
}
