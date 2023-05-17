package com.baidu.tieba;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface et1 {
    boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull hx3 hx3Var);

    boolean e(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean f(Context context, JSONObject jSONObject);

    /* loaded from: classes5.dex */
    public static class b implements et1 {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean j;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public f b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public Context h;
        public CallbackHandler i;

        /* loaded from: classes5.dex */
        public class a implements hx3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadParams.SwanAppDownloadType a;
            public final /* synthetic */ b b;

            public a(b bVar, DownloadParams.SwanAppDownloadType swanAppDownloadType) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppDownloadType};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = swanAppDownloadType;
            }

            @Override // com.baidu.tieba.hx3
            public void a(int i) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onProgressChange:" + i);
                }
            }

            @Override // com.baidu.tieba.hx3
            public void d(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
                }
            }

            @Override // com.baidu.tieba.hx3
            public void f(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
                }
            }

            @Override // com.baidu.tieba.hx3
            public void b() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onInstall:");
                }
            }

            @Override // com.baidu.tieba.hx3
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    if (b.j) {
                        Log.d("SwanAdDownloadImpl", "onAppOpen:");
                        return null;
                    }
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.hx3
            public void c(DownloadState downloadState, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                    if (b.j) {
                        Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + downloadState + ", onProgressChange:" + i);
                    }
                    switch (a.a[this.a.ordinal()]) {
                        case 1:
                            this.b.w(downloadState, String.valueOf(i));
                            return;
                        case 2:
                            this.b.y(downloadState, String.valueOf(i));
                            return;
                        case 3:
                            this.b.v(String.valueOf(i));
                            return;
                        case 4:
                            this.b.t();
                            return;
                        case 5:
                            this.b.x(downloadState, String.valueOf(i));
                            return;
                        case 6:
                            this.b.u();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.et1$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0274b implements zn3<ISwanApkFetcher> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ boolean d;

            public C0274b(b bVar, String str, String str2, String str3, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2, str3, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = z;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zn3
            /* renamed from: b */
            public void a(ISwanApkFetcher iSwanApkFetcher) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iSwanApkFetcher) == null) {
                    iSwanApkFetcher.h(this.a, new iv1().N(this.b).I(this.c).H(f93.K().getAppId()).E(Boolean.valueOf(this.d)));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements j43 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ Context e;

            public c(b bVar, String str, String str2, String str3, boolean z, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2, str3, Boolean.valueOf(z), context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = z;
                this.e = context;
            }

            @Override // com.baidu.tieba.j43
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.a));
                    String str2 = Environment.DIRECTORY_DOWNLOADS;
                    String str3 = this.a;
                    request.setDestinationInExternalPublicDir(str2, str3.substring(str3.lastIndexOf("/") + 1));
                    if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                        request.setNotificationVisibility(1);
                        request.setTitle(this.b);
                        request.setDescription(this.c);
                        request.setVisibleInDownloadsUi(true);
                        request.allowScanningByMediaScanner();
                        request.setMimeType("application/vnd.android.package-archive");
                    }
                    DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                    if (downloadManager != null) {
                        downloadManager.enqueue(request);
                        if (!this.d) {
                            pl3.g(this.e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.j43
            public void b(int i, String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && b.j) {
                    Log.d("DownloadImpl", "onAuthorizedFailed,  errorCode: " + i + " errorMsg: " + str);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class d implements zn3<ISwanApkFetcher> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ DownloadParams.SwanAppDownloadType b;
            public final /* synthetic */ hx3 c;

            public d(b bVar, JSONObject jSONObject, DownloadParams.SwanAppDownloadType swanAppDownloadType, hx3 hx3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, jSONObject, swanAppDownloadType, hx3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jSONObject;
                this.b = swanAppDownloadType;
                this.c = hx3Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zn3
            /* renamed from: b */
            public void a(ISwanApkFetcher iSwanApkFetcher) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iSwanApkFetcher) == null) {
                    String optString = this.a.optString("url");
                    if (!this.a.optBoolean("apk_auto_install") && this.b != DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP) {
                        z = false;
                    } else {
                        z = true;
                    }
                    iv1 G = new iv1().L(this.a.optString("name")).H(f93.K().getAppId()).F(this.a.optString("contentDisposition")).K(this.a.optString("mimeType")).O(this.a.optString(TTDownloadField.TT_USERAGENT)).E(Boolean.valueOf(z)).J(this.a.optString("ext_info")).G(this.a.optString("contentLength"));
                    e eVar = new e(optString, this.c, null);
                    iSwanApkFetcher.g(optString, eVar);
                    switch (a.a[this.b.ordinal()]) {
                        case 1:
                            iSwanApkFetcher.d(optString, G);
                            return;
                        case 2:
                            iSwanApkFetcher.h(optString, G);
                            return;
                        case 3:
                            iSwanApkFetcher.j(optString, G);
                            return;
                        case 4:
                            iSwanApkFetcher.e(optString, G);
                            return;
                        case 5:
                            iSwanApkFetcher.f(optString, G);
                            return;
                        case 6:
                            iSwanApkFetcher.h(optString, G.E(Boolean.TRUE));
                            return;
                        case 7:
                            iSwanApkFetcher.release();
                            return;
                        default:
                            iSwanApkFetcher.F(optString, eVar);
                            return;
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public static class e implements ISwanApkFetcher.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public e(String str, hx3 hx3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, hx3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public /* synthetic */ e(String str, hx3 hx3Var, a aVar) {
                this(str, hx3Var);
            }
        }

        /* loaded from: classes5.dex */
        public class f extends BroadcastReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b this$0;
            public long time;

            public f(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = bVar;
                this.time = 0L;
            }

            public /* synthetic */ f(b bVar, a aVar) {
                this(bVar);
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && intent.getData() != null && PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                    if (TextUtils.equals(this.this$0.d, intent.getData().getSchemeSpecificPart())) {
                        b bVar = this.this$0;
                        bVar.i.handleSchemeDispatchCallback(bVar.f, bVar.n(true, null));
                        this.this$0.A();
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-822077975, "Lcom/baidu/tieba/et1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-822077975, "Lcom/baidu/tieba/et1$b;");
                    return;
                }
            }
            j = qp1.a;
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public void A() {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fVar = this.b) != null) {
                this.h.unregisterReceiver(fVar);
                this.b = null;
            }
        }

        @NonNull
        public final String l(DownloadState downloadState, @NonNull String str, @NonNull String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, downloadState, str, str2)) == null) {
                return m(downloadState, str, str2, -1);
            }
            return (String) invokeLLL.objValue;
        }

        public final boolean q(DownloadParams.SwanAppDownloadType swanAppDownloadType, JSONObject jSONObject, hx3 hx3Var) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, swanAppDownloadType, jSONObject, hx3Var)) == null) {
                if (swanAppDownloadType == null) {
                    swanAppDownloadType = DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS;
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                return p(new d(this, jSONObject, swanAppDownloadType, hx3Var));
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.tieba.et1
        public boolean f(Context context, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, jSONObject)) == null) {
                return s(context, jSONObject);
            }
            return invokeLL.booleanValue;
        }

        @NonNull
        public final String n(boolean z, @Nullable String str) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, str)) == null) {
                return o(z, str, null);
            }
            return (String) invokeZL.objValue;
        }

        public final void x(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048592, this, downloadState, str) == null) && j) {
                Log.d("SwanAdDownloadImpl", "handleResumeDownload");
            }
        }

        public final boolean p(zn3<ISwanApkFetcher> zn3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zn3Var)) == null) {
                ISwanApkFetcher b = ns2.b();
                boolean D = b.D();
                if (D && zn3Var != null) {
                    zn3Var.a(b);
                }
                return D;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.et1
        public boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull hx3 hx3Var) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, swanAppDownloadType, hx3Var)) == null) {
                return r(context, jSONObject, swanAppDownloadType, hx3Var);
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.tieba.et1
        public boolean e(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler)) == null) {
                this.h = context;
                this.i = callbackHandler;
                this.f = jSONObject.optString("cb");
                this.g = jSONObject.optString("onProgressUpdate");
                this.c = jSONObject.optString("url");
                this.d = jSONObject.optString("name");
                this.e = String.valueOf(this.c.hashCode());
                if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.c)) {
                    if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
                        z();
                    }
                    DownloadParams.SwanAppDownloadType find = DownloadParams.SwanAppDownloadType.find(swanAppDownloadType.getTypeName());
                    return r(context, jSONObject, find, new a(this, find));
                }
                n(false, "Missing parameters");
                return false;
            }
            return invokeLLLLL.booleanValue;
        }

        @NonNull
        public final String m(DownloadState downloadState, @NonNull String str, @NonNull String str2, int i) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048581, this, downloadState, str, str2, i)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (i > 0) {
                        jSONObject.put("state", i);
                    } else {
                        jSONObject.put("state", downloadState);
                    }
                    jSONObject.put("progress", str);
                    jSONObject.put(StatConstants.KEY_EXT_FILE_ID, str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return o(true, null, jSONObject);
            }
            return (String) invokeLLLI.objValue;
        }

        @NonNull
        public final String o(boolean z, @Nullable String str, @Nullable JSONObject jSONObject) {
            InterceptResult invokeCommon;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, jSONObject})) == null) {
                if (str == null) {
                    if (z) {
                        str = "success";
                    } else {
                        str = SmsLoginView.f.l;
                    }
                }
                if (z) {
                    i = 0;
                } else {
                    i = 1001;
                }
                return UnitedSchemeUtility.wrapCallbackParams(jSONObject, i, str).toString();
            }
            return (String) invokeCommon.objValue;
        }

        public final boolean r(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull hx3 hx3Var) {
            InterceptResult invokeLLLL;
            String str;
            b63 Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, jSONObject, swanAppDownloadType, hx3Var)) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", swanAppDownloadType.getTypeName());
                if (jSONObject != null) {
                    str = jSONObject.toString();
                } else {
                    str = "";
                }
                bundle.putString(PushConstants.PARAMS, str);
                if (!q(swanAppDownloadType, jSONObject, hx3Var) && (Q = b63.Q()) != null) {
                    Q.X(bundle, hq1.class, new iq1(hx3Var, swanAppDownloadType));
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        public final boolean s(Context context, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, jSONObject)) == null) {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("description");
                boolean optBoolean = jSONObject.optBoolean("autoinstall");
                if (TextUtils.isEmpty(optString)) {
                    y83.g(AppRuntime.getAppContext(), "download url is empty");
                    return false;
                } else if (p(new C0274b(this, optString, optString2, optString3, optBoolean))) {
                    return true;
                } else {
                    i43.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new c(this, optString, optString2, optString3, optBoolean, context));
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                this.i.handleSchemeDispatchCallback(this.g, l(DownloadState.DOWNLOAD_FAILED, "0", this.e));
                this.i.handleSchemeDispatchCallback(this.f, n(true, null));
                String str = this.a;
                if (str != null) {
                    this.i.handleSchemeDispatchCallback(str, n(false, "onStopped"));
                    this.a = null;
                }
            }
        }

        public final void z() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.b == null) {
                this.b = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme("package");
                this.h.registerReceiver(this.b, intentFilter);
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                if (j) {
                    Log.d("SwanAdDownloadImpl", "handleInstallApp");
                }
                String concat = new File(hq1.m()).getAbsolutePath().concat("/");
                String concat2 = concat.concat(this.e + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                if (new File(concat2).exists()) {
                    z();
                    if (!yy3.c(concat2, false)) {
                        this.i.handleSchemeDispatchCallback(this.f, n(false, "install apk error"));
                        return;
                    }
                    return;
                }
                this.i.handleSchemeDispatchCallback(this.f, n(false, "Apk Not Found"));
            }
        }

        public final void v(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.i.handleSchemeDispatchCallback(this.g, l(DownloadState.DOWNLOAD_PAUSED, str, this.e));
                this.i.handleSchemeDispatchCallback(this.f, n(true, null));
                String str2 = this.a;
                if (str2 != null) {
                    this.i.handleSchemeDispatchCallback(str2, n(false, MissionEvent.MESSAGE_PAUSE));
                    this.a = null;
                }
            }
        }

        public final void w(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, downloadState, str) == null) {
                this.i.handleSchemeDispatchCallback(this.g, l(downloadState, str, this.e));
                if (downloadState == DownloadState.DOWNLOADED && "-1".equals(str)) {
                    this.i.handleSchemeDispatchCallback(this.f, m(downloadState, str, this.e, DownloadState.DELETED.value()));
                } else if (TextUtils.equals(str, "100")) {
                    this.i.handleSchemeDispatchCallback(this.f, l(DownloadState.DOWNLOADED, str, this.e));
                } else {
                    this.i.handleSchemeDispatchCallback(this.f, l(downloadState, str, this.e));
                }
            }
        }

        public final void y(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, downloadState, str) == null) {
                this.a = this.f;
                this.i.handleSchemeDispatchCallback(this.g, l(downloadState, str, this.e));
                if (downloadState == DownloadState.DOWNLOADED) {
                    this.i.handleSchemeDispatchCallback(this.f, n(true, "onSuccess"));
                    this.a = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-822078006, "Lcom/baidu/tieba/et1$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-822078006, "Lcom/baidu/tieba/et1$a;");
                    return;
                }
            }
            int[] iArr = new int[ISwanApkFetcher.FetchStates.values().length];
            b = iArr;
            try {
                iArr[ISwanApkFetcher.FetchStates.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ISwanApkFetcher.FetchStates.FETCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ISwanApkFetcher.FetchStates.FETCH_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ISwanApkFetcher.FetchStates.FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[ISwanApkFetcher.FetchStates.FETCH_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[ISwanApkFetcher.FetchStates.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[ISwanApkFetcher.FetchStates.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[ISwanApkFetcher.FetchStates.FETCH_PREPARE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[ISwanApkFetcher.FetchStates.WAITING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[DownloadParams.SwanAppDownloadType.values().length];
            a = iArr2;
            try {
                iArr2[DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }
}
