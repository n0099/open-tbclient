package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class f74 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d04 a;
    public j42 b;
    public String c;

    /* loaded from: classes5.dex */
    public class a implements d04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f74 a;

        @Override // com.baidu.tieba.d04
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.d04
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.d04
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }

        public a(f74 f74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f74Var;
        }

        @Override // com.baidu.tieba.d04
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                g74 g74Var = new g74();
                g74Var.progress = i;
                JSEvent jSEvent = new JSEvent("ProgressChange");
                jSEvent.data = g74Var;
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.d04
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                i74 i74Var = new i74();
                i74Var.state = downloadState.value();
                JSEvent jSEvent = new JSEvent("StateChange");
                jSEvent.data = i74Var;
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.d04
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.c;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f74(JSRuntime jSRuntime, j42 j42Var) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime, j42Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = j42Var;
        if (!y()) {
            return;
        }
        this.a = new a(this);
        t84.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.a);
    }

    public final boolean A(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (context == null) {
                return false;
            }
            try {
                if (context.getPackageManager() == null) {
                    return false;
                }
                if (context.getPackageManager().getPackageInfo(str, 0) == null) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            ej3 ej3Var = new ej3();
            ej3Var.b = str;
            ej3Var.a = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
            ej3Var.a("targetPackageName", str2);
            vi3.g(ej3Var);
        }
    }

    public final void B(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) && context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0 && queryIntentActivities.iterator().next() != null) {
                String str2 = queryIntentActivities.iterator().next().activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(270532608);
                try {
                    context.startActivity(intent2);
                } catch (Exception unused) {
                }
            }
        }
    }

    @JavascriptInterface
    public void deleteDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            t84.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD, this.a);
        }
    }

    @JavascriptInterface
    public void installApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            t84.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.a);
        }
    }

    @JavascriptInterface
    public void openApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            B(AppRuntime.getAppContext(), this.c);
        }
    }

    @JavascriptInterface
    public void pauseDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            t84.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.a);
        }
    }

    @JavascriptInterface
    public void resumeDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            t84.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD, this.a);
        }
    }

    @JavascriptInterface
    public void startDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            t84.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a);
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.c = t84.f().getPackageName();
            if (!t84.f().c()) {
                l64 l64Var = new l64();
                l64Var.errMsg = "download url is empty";
                oe4.call(this.b, false, l64Var);
                z("reallyDownloadNull", this.c);
                return false;
            } else if (A(AppRuntime.getAppContext(), this.c)) {
                l64 l64Var2 = new l64();
                l64Var2.errMsg = "apk has installed";
                oe4.call(this.b, false, l64Var2);
                z("reallyHasInstalled", this.c);
                return false;
            } else {
                h74 h74Var = new h74();
                h74Var.statusCode = 0;
                h74Var.packageName = this.c;
                oe4.call(this.b, true, h74Var);
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
