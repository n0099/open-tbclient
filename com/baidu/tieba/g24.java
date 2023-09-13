package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static volatile g24 i;
    public transient /* synthetic */ FieldHolder $fh;
    public h24 a;
    public h24 b;
    public DownloadManager c;
    public s24 d;
    public JSONObject e;
    public AppDownloadNetworkStateReceiver f;
    public long g;

    /* loaded from: classes6.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g24 a;

        /* loaded from: classes6.dex */
        public class a implements a34 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ Download b;
            public final /* synthetic */ d c;

            public a(d dVar, String str, Download download) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str, download};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = dVar;
                this.a = str;
                this.b = download;
            }

            @Override // com.baidu.tieba.a34
            public void a(c34 c34Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c34Var) == null) {
                    if (c34Var != null) {
                        if (c34Var.d()) {
                            this.c.a.a.b(this.a, new d34(this.b));
                        } else {
                            this.c.a.a.b(this.a, c34Var);
                        }
                    }
                    this.c.a.C(this.a);
                }
            }
        }

        public d(g24 g24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g24Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            String failedReason;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) && download != null && download.getId() != null) {
                String valueOf = String.valueOf(download.getId());
                if (g24.h) {
                    Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                }
                if (download.getState() == Download.DownloadState.FINISH) {
                    if (!y74.d().a(download)) {
                        i34.a(download.getKeyByUser(), "startDownload", "success", null, new g34(this.a.e));
                        i34.d(2, download.getKeyByUser(), new q24(download).c(), download.getUrl());
                    }
                    e34.f().m(download, true, "downloadfinish");
                }
                if (!this.a.a.d(valueOf)) {
                    return;
                }
                int i = h.a[download.getState().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (TextUtils.isEmpty(download.getFailedReason())) {
                                failedReason = "download is failed";
                            } else {
                                failedReason = download.getFailedReason();
                            }
                            this.a.a.b(valueOf, new b34(download.getFailedType().intValue(), failedReason));
                            this.a.C(valueOf);
                            return;
                        }
                        return;
                    }
                    this.a.a.b(valueOf, new b34(31015, "download is canceled"));
                    this.a.C(valueOf);
                    return;
                }
                this.a.d.f();
                y74.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                new y24(download, this.a.e).c(new a(this, valueOf, download));
                if (y74.d().a(download)) {
                    y74.d().b(download);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g24 g24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) && rr1.a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Download b;
        public final /* synthetic */ g24 c;

        public b(g24 g24Var, String str, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var, str, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g24Var;
            this.a = str;
            this.b = download;
        }

        @Override // com.baidu.tieba.a34
        public void a(c34 c34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c34Var) == null) {
                if (c34Var != null) {
                    if (c34Var.d()) {
                        this.c.a.b(this.a, new d34(this.b));
                    } else {
                        this.c.a.b(this.a, c34Var);
                    }
                }
                this.c.C(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g24 c;

        public c(g24 g24Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g24Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || vw2.a().b()) {
                return;
            }
            if (g24.h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.a);
            intent.putExtra("packageName", this.b);
            if (this.c.e != null) {
                intent.putExtra("ubc_params", this.c.e.toString());
            }
            intent.setFlags(276824064);
            qn3.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g24 this$0;

        public e(g24 g24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = g24Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && intent.getData() != null) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    return;
                }
                if (g24.h) {
                    Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
                }
                Download o = this.this$0.d.o(schemeSpecificPart);
                if (y74.d().a(o)) {
                    y74.d().c(o);
                } else {
                    this.this$0.p(schemeSpecificPart);
                }
                this.this$0.t(schemeSpecificPart);
                this.this$0.b.b(schemeSpecificPart, new d34((String) null));
                this.this$0.B(schemeSpecificPart, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements a34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ g24 d;

        public f(g24 g24Var, Download download, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var, download, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = g24Var;
            this.a = download;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.a34
        public void a(c34 c34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c34Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (c34Var != null) {
                    if (c34Var.d()) {
                        if (!TextUtils.isEmpty(this.b)) {
                            i34.c("installSuccess", this.b, this.c);
                        }
                        this.d.a.b(valueOf, new d34(this.a));
                    } else {
                        this.d.a.b(valueOf, c34Var);
                    }
                }
                this.d.C(valueOf);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements a34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ g24 b;

        public g(g24 g24Var, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g24Var;
            this.a = download;
        }

        @Override // com.baidu.tieba.a34
        public void a(c34 c34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c34Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (c34Var != null) {
                    if (c34Var.d()) {
                        this.b.a.b(valueOf, new d34(this.a));
                    } else {
                        this.b.a.b(valueOf, c34Var);
                    }
                }
                this.b.C(valueOf);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-825682500, "Lcom/baidu/tieba/g24$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-825682500, "Lcom/baidu/tieba/g24$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements a34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.a34
        public void a(c34 c34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c34Var) == null) {
            }
        }

        public i(g24 g24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947742016, "Lcom/baidu/tieba/g24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947742016, "Lcom/baidu/tieba/g24;");
                return;
            }
        }
        h = rr1.a;
    }

    public static g24 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (i == null) {
                synchronized (g24.class) {
                    if (i == null) {
                        i = new g24();
                    }
                }
            }
            return i;
        }
        return (g24) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.registerOnStateChangeListener(new d(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f == null) {
                this.f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            ou2.c().registerReceiver(this.f, intentFilter);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return !ProcessUtils.isMainProcess();
        }
        return invokeV.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.d.d();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            a44.c().d();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.d.m();
        }
    }

    public final synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                AppRuntime.getAppContext().registerReceiver(new e(this), intentFilter);
            }
        }
    }

    public g24() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new h24();
        this.b = new h24();
        this.g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.c = downloadManager;
        s24 s24Var = new s24(downloadManager);
        this.d = s24Var;
        s24Var.e();
        this.d.m();
        A();
        z();
        if (h) {
            this.c.registerOnProgressChangeListener(new a(this));
        }
        e34.f().j();
        F();
        o();
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a.f(str);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) && jSONObject != null) {
            this.e = jSONObject;
        }
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new y24(download, this.e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.d.p(str)) {
                if (download != null) {
                    e34.f().a(download);
                }
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            return this.d.v(str);
        }
        return (Download) invokeL.objValue;
    }

    public void B(String str, a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, a34Var) == null) {
            this.b.g(str, a34Var);
        }
    }

    public final void h(Download download, a34 a34Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, a34Var) == null) && download.getId() != null) {
            this.a.a(String.valueOf(download.getId()), a34Var);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (x = this.d.x()) != null && !x.isEmpty()) {
            for (Download download : x) {
                this.a.a(String.valueOf(download.getId()), new i(this));
                if (!y74.d().a(download)) {
                    i34.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new g34(this.e));
                }
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, a34Var) == null) {
            if (i()) {
                a34Var.a(new b34(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                a34Var.a(new b34(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.d.u(optString, optString2);
                    if (u == null) {
                        t24.b().e(jSONObject, a34Var);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.a.d(valueOf)) {
                        this.a.a(String.valueOf(u.getId()), a34Var);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new y24(u, this.e).c(new b(this, valueOf, u));
                        return;
                    }
                    i34.a(optString2, "resumeDownload", null, null, new g34(this.e));
                    this.c.resume(u.getId().longValue());
                    return;
                }
                a34Var.a(new b34(31007, "invalid params"));
            }
        }
    }

    public boolean j(String str, a34 a34Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, a34Var)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g < 1000) {
                if (rr1.a) {
                    Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.g));
                }
                return false;
            }
            this.g = currentTimeMillis;
            Download v = this.d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (rr1.a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 != 4 && i2 != 5) {
                    if (i2 != 6) {
                        this.d.g(str);
                        return true;
                    }
                    h(v, a34Var);
                    this.c.resume(v.getId().longValue());
                    if (rr1.a) {
                        Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
                    }
                    return false;
                }
                h(v, a34Var);
                if (rr1.a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            }
            h(v, a34Var);
            s(v);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, a34Var) == null) {
            if (i()) {
                a34Var.a(new b34(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            y74.c().c(optString);
                            break;
                        }
                    }
                    i34.a(optString2, "deleteDownload", null, null, new g34(this.e));
                    this.d.h(r);
                    a34Var.a(new d34(r));
                    return;
                }
                t24.b().a(jSONObject, a34Var);
                return;
            }
            a34Var.a(new b34(31007, "invalid params"));
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, a34Var) == null) {
            if (i()) {
                a34Var.a(new b34(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.d.u(optString, optString2);
                if (u == null) {
                    t24.b().c(jSONObject, a34Var);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    a34Var.a(new b34(31013, "download is not started"));
                    return;
                } else {
                    i34.a(optString2, "pauseDownload", null, null, new g34(this.e));
                    this.c.pause(u.getId().longValue());
                    a34Var.a(new d34(u));
                    return;
                }
            }
            a34Var.a(new b34(31007, "invalid params"));
        }
    }

    public void H(String str, String str2, String str3, @NonNull a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, a34Var) == null) {
            if (i()) {
                a34Var.a(new b34(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                a34Var.a(new b34(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (w24.h(AppRuntime.getAppContext(), str2)) {
                    a34Var.a(new b34(31005, "apk is already installed"));
                } else if (!j(str, a34Var)) {
                } else {
                    q24 q24Var = new q24();
                    q24Var.g(str);
                    q24Var.f(str2);
                    q24Var.a(str3);
                    Download b2 = q24Var.b();
                    this.c.start(b2);
                    if (b2.getId() != null) {
                        this.a.a(String.valueOf(b2.getId()), a34Var);
                    }
                    if (!y74.d().a(b2)) {
                        i34.a(str2, "startDownload", null, null, new g34(this.e));
                        i34.d(1, str2, str3, str);
                    }
                }
            } else {
                a34Var.a(new b34(31007, "invalid params"));
            }
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                try {
                    return file.delete();
                } catch (SecurityException e2) {
                    if (h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.d.b(str)) {
                String i2 = this.d.i(str);
                if (!TextUtils.isEmpty(i2) && this.d.c(i2)) {
                    i34.a(str, "installHijack", null, null, new g34(this.e));
                    return;
                }
                return;
            }
            i34.a(str, "installApp", "success", null, new g34(this.e));
            Download o = this.d.o(str);
            if (o != null) {
                i34.d(3, str, new q24(o).c(), o.getUrl());
            }
        }
    }

    public void w(@NonNull a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, a34Var) == null) {
            if (i()) {
                a34Var.a(new b34(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.d.n();
            if (n != null && !n.isEmpty()) {
                a34Var.a(new d34(n));
            } else {
                a34Var.a(new b34(31008, "download is not exist"));
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, str, str2) != null) || (w = this.d.w(str)) == null) {
            return;
        }
        y24 y24Var = new y24(w, this.e);
        if (!TextUtils.isEmpty(str2)) {
            i34.c("notifyInstall", str2, str);
        }
        y24Var.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull z24 z24Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, z24Var)) == null) {
            if (i()) {
                z24Var.a(new b34(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                z24Var.a(new b34(31007, "invalid params"));
                return null;
            } else {
                Download o = this.d.o(str2);
                if (o == null) {
                    z24Var.a(new b34(31008, "download is not exist"));
                    this.d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    z24Var.a(new b34(31017, "download is not finished"));
                    this.d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        z24Var.a(new b34(31001, "database no package or file name"));
                        this.d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (w24.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        z24Var.a(new d34("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (vo3.c() <= file.length()) {
                            z24Var.a(new b34(31020, "not enough space to install"));
                            return null;
                        }
                        z24Var.setPackageName(str2);
                        z24Var.setFilePath(str3);
                        this.b.a(str2, z24Var);
                        if (!w24.j(context, str3, false)) {
                            t(str2);
                            B(str2, z24Var);
                            z24Var.a(new b34(31004, "apk install fail"));
                            this.d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = w24.c();
                            if (w24.k(c2)) {
                                gb3.M().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    z24Var.a(new b34(31002, "file is not exist"));
                    this.d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, a34Var) == null) {
            if (i()) {
                a34Var.a(new b34(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                a34Var.a(new b34(31007, "invalid params"));
                return;
            }
            Download v = this.d.v(optString);
            if (v == null) {
                t24.b().d(jSONObject, a34Var);
            } else {
                a34Var.a(new d34(v));
            }
        }
    }
}
