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
/* loaded from: classes4.dex */
public class dv3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static volatile dv3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public ev3 a;
    public ev3 b;
    public DownloadManager c;
    public pv3 d;
    public JSONObject e;
    public AppDownloadNetworkStateReceiver f;
    public long g;

    /* loaded from: classes4.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv3 a;

        /* loaded from: classes4.dex */
        public class a implements xv3 {
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

            @Override // com.baidu.tieba.xv3
            public void a(zv3 zv3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zv3Var) == null) {
                    if (zv3Var != null) {
                        if (zv3Var.d()) {
                            this.c.a.a.b(this.a, new aw3(this.b));
                        } else {
                            this.c.a.a.b(this.a, zv3Var);
                        }
                    }
                    this.c.a.C(this.a);
                }
            }
        }

        public d(dv3 dv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv3Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            String failedReason;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) && download != null && download.getId() != null) {
                String valueOf = String.valueOf(download.getId());
                if (dv3.h) {
                    Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                }
                if (download.getState() == Download.DownloadState.FINISH) {
                    if (!v04.d().a(download)) {
                        fw3.a(download.getKeyByUser(), "startDownload", "success", null, new dw3(this.a.e));
                        fw3.d(2, download.getKeyByUser(), new nv3(download).c(), download.getUrl());
                    }
                    bw3.f().m(download, true, "downloadfinish");
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
                            this.a.a.b(valueOf, new yv3(download.getFailedType().intValue(), failedReason));
                            this.a.C(valueOf);
                            return;
                        }
                        return;
                    }
                    this.a.a.b(valueOf, new yv3(31015, "download is canceled"));
                    this.a.C(valueOf);
                    return;
                }
                this.a.d.f();
                v04.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                new vv3(download, this.a.e).c(new a(this, valueOf, download));
                if (v04.d().a(download)) {
                    v04.d().b(download);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dv3 dv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var};
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) && ok1.a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements xv3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Download b;
        public final /* synthetic */ dv3 c;

        public b(dv3 dv3Var, String str, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var, str, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dv3Var;
            this.a = str;
            this.b = download;
        }

        @Override // com.baidu.tieba.xv3
        public void a(zv3 zv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zv3Var) == null) {
                if (zv3Var != null) {
                    if (zv3Var.d()) {
                        this.c.a.b(this.a, new aw3(this.b));
                    } else {
                        this.c.a.b(this.a, zv3Var);
                    }
                }
                this.c.C(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ dv3 c;

        public c(dv3 dv3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dv3Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || sp2.a().b()) {
                return;
            }
            if (dv3.h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.a);
            intent.putExtra("packageName", this.b);
            if (this.c.e != null) {
                intent.putExtra("ubc_params", this.c.e.toString());
            }
            intent.setFlags(276824064);
            ng3.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv3 this$0;

        public e(dv3 dv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dv3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && intent.getData() != null) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    return;
                }
                if (dv3.h) {
                    Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
                }
                Download o = this.this$0.d.o(schemeSpecificPart);
                if (v04.d().a(o)) {
                    v04.d().c(o);
                } else {
                    this.this$0.p(schemeSpecificPart);
                }
                this.this$0.t(schemeSpecificPart);
                this.this$0.b.b(schemeSpecificPart, new aw3((String) null));
                this.this$0.B(schemeSpecificPart, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements xv3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ dv3 d;

        public f(dv3 dv3Var, Download download, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var, download, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dv3Var;
            this.a = download;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.xv3
        public void a(zv3 zv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zv3Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (zv3Var != null) {
                    if (zv3Var.d()) {
                        if (!TextUtils.isEmpty(this.b)) {
                            fw3.c("installSuccess", this.b, this.c);
                        }
                        this.d.a.b(valueOf, new aw3(this.a));
                    } else {
                        this.d.a.b(valueOf, zv3Var);
                    }
                }
                this.d.C(valueOf);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements xv3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ dv3 b;

        public g(dv3 dv3Var, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv3Var;
            this.a = download;
        }

        @Override // com.baidu.tieba.xv3
        public void a(zv3 zv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zv3Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (zv3Var != null) {
                    if (zv3Var.d()) {
                        this.b.a.b(valueOf, new aw3(this.a));
                    } else {
                        this.b.a.b(valueOf, zv3Var);
                    }
                }
                this.b.C(valueOf);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-848800316, "Lcom/baidu/tieba/dv3$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-848800316, "Lcom/baidu/tieba/dv3$h;");
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

    /* loaded from: classes4.dex */
    public class i implements xv3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.xv3
        public void a(zv3 zv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zv3Var) == null) {
            }
        }

        public i(dv3 dv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947717960, "Lcom/baidu/tieba/dv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947717960, "Lcom/baidu/tieba/dv3;");
                return;
            }
        }
        h = ok1.a;
    }

    public static dv3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (i == null) {
                synchronized (dv3.class) {
                    if (i == null) {
                        i = new dv3();
                    }
                }
            }
            return i;
        }
        return (dv3) invokeV.objValue;
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
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            ln2.c().registerReceiver(this.f, intentFilter);
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
            xw3.c().d();
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

    public dv3() {
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
        this.a = new ev3();
        this.b = new ev3();
        this.g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.c = downloadManager;
        pv3 pv3Var = new pv3(downloadManager);
        this.d = pv3Var;
        pv3Var.e();
        this.d.m();
        A();
        z();
        if (h) {
            this.c.registerOnProgressChangeListener(new a(this));
        }
        bw3.f().j();
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
            new vv3(download, this.e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.d.p(str)) {
                if (download != null) {
                    bw3.f().a(download);
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

    public void B(String str, xv3 xv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, xv3Var) == null) {
            this.b.g(str, xv3Var);
        }
    }

    public final void h(Download download, xv3 xv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, xv3Var) == null) && download.getId() != null) {
            this.a.a(String.valueOf(download.getId()), xv3Var);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (x = this.d.x()) != null && !x.isEmpty()) {
            for (Download download : x) {
                this.a.a(String.valueOf(download.getId()), new i(this));
                if (!v04.d().a(download)) {
                    fw3.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new dw3(this.e));
                }
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull xv3 xv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, xv3Var) == null) {
            if (i()) {
                xv3Var.a(new yv3(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                xv3Var.a(new yv3(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.d.u(optString, optString2);
                    if (u == null) {
                        qv3.b().e(jSONObject, xv3Var);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.a.d(valueOf)) {
                        this.a.a(String.valueOf(u.getId()), xv3Var);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new vv3(u, this.e).c(new b(this, valueOf, u));
                        return;
                    }
                    fw3.a(optString2, "resumeDownload", null, null, new dw3(this.e));
                    this.c.resume(u.getId().longValue());
                    return;
                }
                xv3Var.a(new yv3(31007, "invalid params"));
            }
        }
    }

    public boolean j(String str, xv3 xv3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, xv3Var)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g < 1000) {
                if (ok1.a) {
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
            if (ok1.a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 != 4 && i2 != 5) {
                    if (i2 != 6) {
                        this.d.g(str);
                        return true;
                    }
                    h(v, xv3Var);
                    this.c.resume(v.getId().longValue());
                    if (ok1.a) {
                        Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
                    }
                    return false;
                }
                h(v, xv3Var);
                if (ok1.a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            }
            h(v, xv3Var);
            s(v);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull xv3 xv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, xv3Var) == null) {
            if (i()) {
                xv3Var.a(new yv3(31006, "is not in main process"));
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
                            v04.c().c(optString);
                            break;
                        }
                    }
                    fw3.a(optString2, "deleteDownload", null, null, new dw3(this.e));
                    this.d.h(r);
                    xv3Var.a(new aw3(r));
                    return;
                }
                qv3.b().a(jSONObject, xv3Var);
                return;
            }
            xv3Var.a(new yv3(31007, "invalid params"));
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull xv3 xv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, xv3Var) == null) {
            if (i()) {
                xv3Var.a(new yv3(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.d.u(optString, optString2);
                if (u == null) {
                    qv3.b().c(jSONObject, xv3Var);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    xv3Var.a(new yv3(31013, "download is not started"));
                    return;
                } else {
                    fw3.a(optString2, "pauseDownload", null, null, new dw3(this.e));
                    this.c.pause(u.getId().longValue());
                    xv3Var.a(new aw3(u));
                    return;
                }
            }
            xv3Var.a(new yv3(31007, "invalid params"));
        }
    }

    public void H(String str, String str2, String str3, @NonNull xv3 xv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, xv3Var) == null) {
            if (i()) {
                xv3Var.a(new yv3(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                xv3Var.a(new yv3(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (tv3.h(AppRuntime.getAppContext(), str2)) {
                    xv3Var.a(new yv3(31005, "apk is already installed"));
                } else if (!j(str, xv3Var)) {
                } else {
                    nv3 nv3Var = new nv3();
                    nv3Var.g(str);
                    nv3Var.f(str2);
                    nv3Var.a(str3);
                    Download b2 = nv3Var.b();
                    this.c.start(b2);
                    if (b2.getId() != null) {
                        this.a.a(String.valueOf(b2.getId()), xv3Var);
                    }
                    if (!v04.d().a(b2)) {
                        fw3.a(str2, "startDownload", null, null, new dw3(this.e));
                        fw3.d(1, str2, str3, str);
                    }
                }
            } else {
                xv3Var.a(new yv3(31007, "invalid params"));
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
                    fw3.a(str, "installHijack", null, null, new dw3(this.e));
                    return;
                }
                return;
            }
            fw3.a(str, "installApp", "success", null, new dw3(this.e));
            Download o = this.d.o(str);
            if (o != null) {
                fw3.d(3, str, new nv3(o).c(), o.getUrl());
            }
        }
    }

    public void w(@NonNull xv3 xv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, xv3Var) == null) {
            if (i()) {
                xv3Var.a(new yv3(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.d.n();
            if (n != null && !n.isEmpty()) {
                xv3Var.a(new aw3(n));
            } else {
                xv3Var.a(new yv3(31008, "download is not exist"));
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, str, str2) != null) || (w = this.d.w(str)) == null) {
            return;
        }
        vv3 vv3Var = new vv3(w, this.e);
        if (!TextUtils.isEmpty(str2)) {
            fw3.c("notifyInstall", str2, str);
        }
        vv3Var.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull wv3 wv3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, wv3Var)) == null) {
            if (i()) {
                wv3Var.a(new yv3(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                wv3Var.a(new yv3(31007, "invalid params"));
                return null;
            } else {
                Download o = this.d.o(str2);
                if (o == null) {
                    wv3Var.a(new yv3(31008, "download is not exist"));
                    this.d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    wv3Var.a(new yv3(31017, "download is not finished"));
                    this.d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        wv3Var.a(new yv3(31001, "database no package or file name"));
                        this.d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (tv3.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        wv3Var.a(new aw3("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (sh3.c() <= file.length()) {
                            wv3Var.a(new yv3(31020, "not enough space to install"));
                            return null;
                        }
                        wv3Var.setPackageName(str2);
                        wv3Var.setFilePath(str3);
                        this.b.a(str2, wv3Var);
                        if (!tv3.j(context, str3, false)) {
                            t(str2);
                            B(str2, wv3Var);
                            wv3Var.a(new yv3(31004, "apk install fail"));
                            this.d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = tv3.c();
                            if (tv3.k(c2)) {
                                d43.M().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    wv3Var.a(new yv3(31002, "file is not exist"));
                    this.d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull xv3 xv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, xv3Var) == null) {
            if (i()) {
                xv3Var.a(new yv3(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                xv3Var.a(new yv3(31007, "invalid params"));
                return;
            }
            Download v = this.d.v(optString);
            if (v == null) {
                qv3.b().d(jSONObject, xv3Var);
            } else {
                xv3Var.a(new aw3(v));
            }
        }
    }
}
