package com.baidu.tieba.downloadball;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.downloadball.DownloadFloatBall;
import com.baidu.tieba.downloadball.DownloadFloatBallManager;
import com.baidu.tieba.ef7;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.gf7;
import com.baidu.tieba.j3a;
import com.baidu.tieba.pda;
import com.baidu.tieba.qy6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&J^\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000fJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u000206J\u0016\u00107\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u00108\u001a\u00020)J\u0018\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020)H\u0002J\u0018\u0010<\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u0010H\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u000fH\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\u00060\bR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001a¨\u0006A"}, d2 = {"Lcom/baidu/tieba/downloadball/DownloadFloatBallManager;", "", "()V", "downloadBall", "Lcom/baidu/tieba/downloadball/DownloadFloatBall;", "getDownloadBall", "()Lcom/baidu/tieba/downloadball/DownloadFloatBall;", "downloadStatusCallback", "Lcom/baidu/tieba/downloadball/DownloadFloatBallManager$DownloadStatusCallback;", "getDownloadStatusCallback", "()Lcom/baidu/tieba/downloadball/DownloadFloatBallManager$DownloadStatusCallback;", "downloadStatusCallback$delegate", "Lkotlin/Lazy;", "downloaderTypeMap", "", "", "", "mPreference", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getMPreference", "()Landroid/content/SharedPreferences;", "mPreference$delegate", "tbDownloadManager", "Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "getTbDownloadManager", "()Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "tbDownloadManager$delegate", "clearSpInfo", "", "closeCurrentAppBall", "generatorFloatBallData", "getFoldText", "downloadData", "Lcom/baidu/tbadk/download/DownloadData;", "hide", "installSuccess", "intent", "Landroid/content/Intent;", "saveDownloadInfo", "isStart", "", "gameUrl", "gameId", "apkName", "apkIcon", "apkVersion", PushService.APP_VERSION_CODE, "pkgName", "source", "extInfo", PrefetchEvent.EVENT_KEY_PAGE_URL, "setData", "data", "Lcom/baidu/tieba/downloadball/DownloadFloatBallData;", "show", "isColdBoot", "spPutBoolean", "key", "value", "spPutInt", "updateDownloaderManagerType", "downloadId", "Companion", "DownloadStatusCallback", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadFloatBallManager {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public static final Lazy<DownloadFloatBallManager> g;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadFloatBall a;
    public final Lazy b;
    public final Lazy c;
    public final Map<String, Integer> d;
    public final Lazy e;

    public /* synthetic */ DownloadFloatBallManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final DownloadFloatBallManager l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f.a() : (DownloadFloatBallManager) invokeV.objValue;
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

        public final DownloadFloatBallManager a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (DownloadFloatBallManager) DownloadFloatBallManager.g.getValue();
            }
            return (DownloadFloatBallManager) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class b implements gf7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadFloatBallManager a;

        @Override // com.baidu.tieba.gf7
        public void a(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(DownloadFloatBallManager downloadFloatBallManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadFloatBallManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadFloatBallManager;
        }

        @Override // com.baidu.tieba.gf7
        public void b(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.h();
                this.a.s(false, false);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void c(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.h();
            }
        }

        @Override // com.baidu.tieba.gf7
        public void d(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.h();
            }
        }

        @Override // com.baidu.tieba.gf7
        public void e(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.h();
            }
        }

        @Override // com.baidu.tieba.gf7
        public void f(DownloadData data, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, data, i) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (this.a.d.containsKey(data.getId())) {
                    this.a.d.remove(data.getId());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1873154105, "Lcom/baidu/tieba/downloadball/DownloadFloatBallManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1873154105, "Lcom/baidu/tieba/downloadball/DownloadFloatBallManager;");
                return;
            }
        }
        f = new a(null);
        g = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) DownloadFloatBallManager$Companion$instance$2.INSTANCE);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SharedPreferences.Editor edit = m().edit();
            Intrinsics.checkNotNullExpressionValue(edit, "mPreference.edit()");
            edit.remove("key_h5_game_download_info");
            edit.remove("key_download_float_ball_cold_boot_show_times");
            edit.remove("key_download_float_ball_cold_boot_close");
            edit.apply();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && j3a.i(DownloadFloatBallConfig.o.a().k())) {
            o();
            f();
        }
    }

    public final b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (b) this.c.getValue();
        }
        return (b) invokeV.objValue;
    }

    public final SharedPreferences m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (SharedPreferences) this.e.getValue();
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public final TbDownloadManager n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (TbDownloadManager) this.b.getValue();
        }
        return (TbDownloadManager) invokeV.objValue;
    }

    public final void o() {
        DownloadFloatBall i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (i = i()) != null) {
            i.j();
        }
    }

    public DownloadFloatBallManager() {
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
        this.b = LazyKt__LazyJVMKt.lazy(DownloadFloatBallManager$tbDownloadManager$2.INSTANCE);
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<b>(this) { // from class: com.baidu.tieba.downloadball.DownloadFloatBallManager$downloadStatusCallback$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadFloatBallManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DownloadFloatBallManager.b invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new DownloadFloatBallManager.b(this.this$0);
                }
                return (DownloadFloatBallManager.b) invokeV.objValue;
            }
        });
        this.d = new LinkedHashMap();
        this.e = LazyKt__LazyJVMKt.lazy(DownloadFloatBallManager$mPreference$2.INSTANCE);
        n().w(2);
        n().g(j());
        n().w(1);
        n().g(j());
    }

    public static final void a(DownloadFloatBall this_apply, DownloadFloatBallManager this$0, View view2) {
        TbPageContext<?> currentPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, this_apply, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this_apply.k() && (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(BdActivityStack.getInst().currentActivity())) != null) {
                UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{this_apply.b().d()});
                this$0.g();
            }
            this_apply.q(TbadkCoreStatisticKey.DOWNLOAD_FLOAT_BALL_CLICK, false, false);
        }
    }

    public static final void b(DownloadFloatBallManager this$0, DownloadFloatBall this_apply, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, this_apply, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this$0.g();
            this$0.t("key_download_float_ball_cold_boot_close", true);
            this_apply.q(TbadkCoreStatisticKey.DOWNLOAD_FLOAT_BALL_CLICK, true, false);
        }
    }

    public final void r(qy6 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            DownloadFloatBall i = i();
            if (i != null) {
                i.m(data);
            }
        }
    }

    public final void h() {
        DownloadFloatBall i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (i = i()) != null) {
            DownloadData downloadData = new DownloadData(DownloadFloatBallConfig.o.a().c() + ".v" + DownloadFloatBallConfig.o.a().d());
            downloadData.setName(DownloadFloatBallConfig.o.a().c());
            String id = downloadData.getId();
            Intrinsics.checkNotNullExpressionValue(id, "downloadData.id");
            v(id);
            qy6 b2 = i.b();
            b2.h(n().q(downloadData));
            b2.j(DownloadFloatBallConfig.o.a().b());
            b2.m(n().p(downloadData));
            b2.n(DownloadFloatBallConfig.o.a().l());
            b2.i(k(downloadData));
            b2.k(DownloadFloatBallConfig.o.a().i());
            b2.l(DownloadFloatBallConfig.o.a().k());
            r(b2);
        }
    }

    public final DownloadFloatBall i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        final DownloadFloatBall downloadFloatBall = new DownloadFloatBall();
                        downloadFloatBall.o(new View.OnClickListener() { // from class: com.baidu.tieba.py6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    DownloadFloatBallManager.a(DownloadFloatBall.this, this, view2);
                                }
                            }
                        });
                        downloadFloatBall.n(new View.OnClickListener() { // from class: com.baidu.tieba.oy6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    DownloadFloatBallManager.b(DownloadFloatBallManager.this, downloadFloatBall, view2);
                                }
                            }
                        });
                        this.a = downloadFloatBall;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return this.a;
        }
        return (DownloadFloatBall) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0051: INVOKE  (r5v4 int A[REMOVE]) = 
      (wrap: com.baidu.tieba.filedownloader.TbDownloadManager : 0x004d: INVOKE  (r1v3 com.baidu.tieba.filedownloader.TbDownloadManager A[REMOVE]) = (r4v0 'this' com.baidu.tieba.downloadball.DownloadFloatBallManager A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.baidu.tieba.downloadball.DownloadFloatBallManager.n():com.baidu.tieba.filedownloader.TbDownloadManager)
      (r5v0 com.baidu.tbadk.download.DownloadData)
     type: VIRTUAL call: com.baidu.tieba.filedownloader.TbDownloadManager.p(com.baidu.tbadk.download.DownloadData):int), ('%' char)] */
    public final String k(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, downloadData)) == null) {
            if (j3a.i(DownloadFloatBallConfig.o.a().k())) {
                return DownloadFloatBallConfig.o.a().f();
            }
            int q = n().q(downloadData);
            if (q != 0) {
                if (q != 1) {
                    if (q != 3) {
                        if (q != 7) {
                            return DownloadFloatBallConfig.o.a().h();
                        }
                        return DownloadFloatBallConfig.o.a().j();
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(n().p(downloadData));
                    sb.append('%');
                    return sb.toString();
                }
            }
            return DownloadFloatBallConfig.o.a().e();
        }
        return (String) invokeL.objValue;
    }

    public final void p(Intent intent) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Uri data = intent.getData();
            if (data != null) {
                String k = DownloadFloatBallConfig.o.a().k();
                if (k != null && !StringsKt__StringsJVMKt.isBlank(k)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && Intrinsics.areEqual(DownloadFloatBallConfig.o.a().k(), data.getSchemeSpecificPart())) {
                    h();
                    s(false, false);
                }
            }
        }
    }

    public final void v(String str) {
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (this.d.containsKey(str)) {
                TbDownloadManager n = n();
                Integer num = this.d.get(str);
                if (num != null) {
                    a2 = num.intValue();
                } else {
                    a2 = ef7.a.a();
                }
                n.w(a2);
                return;
            }
            pda h = n().m().h(str, "");
            ItemData itemData = new ItemData();
            itemData.parseJson(h.c());
            int i = itemData.mTbFileDownloaderType;
            n().w(i);
            this.d.put(str, Integer.valueOf(i));
        }
    }

    public final void q(boolean z, String gameUrl, String gameId, String apkName, String apkIcon, String apkVersion, int i, String pkgName, int i2, String extInfo, String pageUrl) {
        String str;
        boolean z2;
        String str2;
        boolean z3;
        DownloadFloatBallManager downloadFloatBallManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), gameUrl, gameId, apkName, apkIcon, apkVersion, Integer.valueOf(i), pkgName, Integer.valueOf(i2), extInfo, pageUrl}) == null) {
            Intrinsics.checkNotNullParameter(gameUrl, "gameUrl");
            Intrinsics.checkNotNullParameter(gameId, "gameId");
            Intrinsics.checkNotNullParameter(apkName, "apkName");
            Intrinsics.checkNotNullParameter(apkIcon, "apkIcon");
            Intrinsics.checkNotNullParameter(apkVersion, "apkVersion");
            Intrinsics.checkNotNullParameter(pkgName, "pkgName");
            Intrinsics.checkNotNullParameter(extInfo, "extInfo");
            Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
            String str3 = null;
            try {
                JSONObject jSONObject = new JSONObject(extInfo);
                str3 = jSONObject.optString("type");
                z2 = TextUtils.equals("1", jSONObject.optString("showFloatBall"));
                str = str3;
            } catch (JSONException e) {
                BdLog.e(e);
                str = str3;
                z2 = false;
            }
            String str4 = "";
            String string = m().getString("key_h5_game_download_info", "");
            if (StringUtils.isNotNull(string)) {
                str2 = "key_h5_game_download_info";
                try {
                    String optString = new JSONObject(string).optString("gameUrl", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "infoJson.optString(Downl…tBallConfig.GAME_URL, \"\")");
                    str4 = optString;
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            } else {
                str2 = "key_h5_game_download_info";
            }
            if (z && (Intrinsics.areEqual("game_activity", str) || z2)) {
                if (StringUtils.isNotNull(gameUrl) && !Intrinsics.areEqual(gameUrl, str4)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("gameUrl", gameUrl);
                        jSONObject2.put("gameId", gameId);
                        jSONObject2.put("apkName", apkName);
                        jSONObject2.put("apkIcon", apkIcon);
                        jSONObject2.put("apkVersion", apkVersion);
                        jSONObject2.put(PushService.APP_VERSION_CODE, i);
                        jSONObject2.put("pkgName", pkgName);
                        jSONObject2.put("source", i2);
                        jSONObject2.put(PrefetchEvent.EVENT_KEY_PAGE_URL, pageUrl);
                        DownloadFloatBallConfig.o.a().m(jSONObject2);
                        SharedPreferences.Editor edit = m().edit();
                        Intrinsics.checkNotNullExpressionValue(edit, "mPreference.edit()");
                        edit.putString(str2, jSONObject2.toString());
                        edit.apply();
                        z3 = false;
                        downloadFloatBallManager = this;
                        try {
                            downloadFloatBallManager.u("key_download_float_ball_cold_boot_show_times", 0);
                            downloadFloatBallManager.t("key_download_float_ball_cold_boot_close", false);
                        } catch (JSONException e3) {
                            e = e3;
                            BdLog.e(e);
                            downloadFloatBallManager.s(true, z3);
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        z3 = false;
                        downloadFloatBallManager = this;
                    }
                } else {
                    z3 = false;
                    downloadFloatBallManager = this;
                }
                downloadFloatBallManager.s(true, z3);
            }
        }
    }

    public final void s(boolean z, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            String string = m().getString("key_h5_game_download_info", "");
            int i = 0;
            if (string != null && !StringsKt__StringsJVMKt.isBlank(string)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                return;
            }
            boolean z4 = m().getBoolean("key_download_float_ball_cold_boot_close", false);
            if (z2 && z4 && (i = m().getInt("key_download_float_ball_cold_boot_show_times", 0)) >= 1) {
                f();
                return;
            }
            DownloadFloatBall i2 = i();
            if (i2 != null) {
                if (i2.l()) {
                    return;
                }
                DownloadFloatBallConfig.o.a().n(string);
                h();
                i2.p(z);
            }
            if (z2 && z4) {
                u("key_download_float_ball_cold_boot_show_times", i + 1);
            }
        }
    }

    public final void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) {
            SharedPreferences.Editor edit = m().edit();
            Intrinsics.checkNotNullExpressionValue(edit, "mPreference.edit()");
            edit.putBoolean(str, z);
            edit.apply();
        }
    }

    public final void u(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) {
            SharedPreferences.Editor edit = m().edit();
            Intrinsics.checkNotNullExpressionValue(edit, "mPreference.edit()");
            edit.putInt(str, i);
            edit.apply();
        }
    }
}
