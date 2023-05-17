package com.baidu.tieba.downloadball;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107J\u0010\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010\u0004J\u0010\u0010:\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u000e\u0010\u001c\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u000e\u0010 \u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u000e\u0010'\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001c\u00101\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\b¨\u0006<"}, d2 = {"Lcom/baidu/tieba/downloadball/DownloadFloatBallConfig;", "", "()V", "apkIcon", "", "getApkIcon", "()Ljava/lang/String;", "setApkIcon", "(Ljava/lang/String;)V", "apkName", "getApkName", "setApkName", "apkVersion", "getApkVersion", "setApkVersion", "downloadCompletionText", "getDownloadCompletionText", "setDownloadCompletionText", "downloadCompletionTextDefault", "gameId", "getGameId", "setGameId", "gameUrl", "getGameUrl", "setGameUrl", "installedText", "getInstalledText", "setInstalledText", "installedTextDefault", "notDownloadText", "getNotDownloadText", "setNotDownloadText", "notDownloadTextDefault", PrefetchEvent.EVENT_KEY_PAGE_URL, "getPageUrl", "setPageUrl", "pauseText", "getPauseText", "setPauseText", "pauseTextDefault", "pkgName", "getPkgName", "setPkgName", "source", "getSource", "setSource", "unfoldGuideText", "getUnfoldGuideText", "setUnfoldGuideText", PushService.APP_VERSION_CODE, "getVersionCode", "setVersionCode", "parseDownloadInfoJson", "", "jsonObject", "Lorg/json/JSONObject;", "parseDownloadInfoStrJson", "jsonStr", "parseSyncJson", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadFloatBallConfig {
    public static /* synthetic */ Interceptable $ic;
    public static final a o;
    public static final Lazy<DownloadFloatBallConfig> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;

    public static final DownloadFloatBallConfig g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? o.a() : (DownloadFloatBallConfig) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final DownloadFloatBallConfig a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (DownloadFloatBallConfig) DownloadFloatBallConfig.p.getValue();
            }
            return (DownloadFloatBallConfig) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-83114880, "Lcom/baidu/tieba/downloadball/DownloadFloatBallConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-83114880, "Lcom/baidu/tieba/downloadball/DownloadFloatBallConfig;");
                return;
            }
        }
        o = new a(null);
        p = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) DownloadFloatBallConfig$Companion$instance$2.INSTANCE);
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public DownloadFloatBallConfig() {
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
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.download_float_not_download);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getResources()…nload_float_not_download)");
        this.a = string;
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.download_float_completion);
        Intrinsics.checkNotNullExpressionValue(string2, "getInst().getResources()…ownload_float_completion)");
        this.b = string2;
        String string3 = TbadkCoreApplication.getInst().getResources().getString(R.string.download_float_installed);
        Intrinsics.checkNotNullExpressionValue(string3, "getInst().getResources()…download_float_installed)");
        this.c = string3;
        String string4 = TbadkCoreApplication.getInst().getResources().getString(R.string.download_float_pause_guide);
        Intrinsics.checkNotNullExpressionValue(string4, "getInst().getResources()…wnload_float_pause_guide)");
        this.d = string4;
        this.e = this.a;
        this.f = this.b;
        this.g = this.c;
        this.h = "";
        this.i = string4;
    }

    public final void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) && jSONObject != null) {
            jSONObject.optString("gameUrl");
            jSONObject.optString("gameId");
            this.j = jSONObject.optString("apkName");
            this.k = jSONObject.optString("apkIcon");
            this.l = jSONObject.optString("apkVersion");
            jSONObject.optString(PushService.APP_VERSION_CODE);
            this.m = jSONObject.optString("pkgName");
            jSONObject.optString("source");
            this.n = jSONObject.optString(PrefetchEvent.EVENT_KEY_PAGE_URL);
        }
    }

    public final void o(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) && jSONObject != null) {
            String completionTextTemp = jSONObject.optString("download_completion_text");
            boolean z2 = false;
            if (completionTextTemp != null && !StringsKt__StringsJVMKt.isBlank(completionTextTemp)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Intrinsics.checkNotNullExpressionValue(completionTextTemp, "completionTextTemp");
                this.f = completionTextTemp;
            }
            String installedTextTemp = jSONObject.optString("installed_text");
            if (!((installedTextTemp == null || StringsKt__StringsJVMKt.isBlank(installedTextTemp)) ? true : true)) {
                Intrinsics.checkNotNullExpressionValue(installedTextTemp, "installedTextTemp");
                this.g = installedTextTemp;
            }
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && !StringUtils.isNullStr(str)) {
            m(new JSONObject(str));
        }
    }
}
