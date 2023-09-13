package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.n81;
import com.baidu.tieba.pa1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class da1 extends ba1 implements ra1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public RelativeLayout b;
    public String c;
    public final Object d;
    public final fa1 e;

    /* loaded from: classes5.dex */
    public static final class a implements n81.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ da1 a;

        /* renamed from: com.baidu.tieba.da1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class RunnableC0259a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;
            public final /* synthetic */ AbsNadBrowserView b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;

            public RunnableC0259a(a aVar, AbsNadBrowserView absNadBrowserView, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, absNadBrowserView, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
                this.b = absNadBrowserView;
                this.c = str;
                this.d = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || k71.a(this.b.getUrl(), this.c)) {
                    return;
                }
                this.a.a(this.d);
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(da1 da1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = da1Var;
        }

        @Override // com.baidu.tieba.n81.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                AbsNadBrowserView m = this.a.e.m();
                String str2 = this.a.a;
                jb1.a(str2, "js is " + str + " and browserView is " + m);
                if (m != null) {
                    AbsNadBrowserView.C(m, str, null, 2, null);
                }
            }
        }

        @Override // com.baidu.tieba.n81.b
        public void b(String str, String str2) {
            AbsNadBrowserView m;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && (m = this.a.e.m()) != null) {
                m.post(new RunnableC0259a(this, m, str2, str));
            }
        }
    }

    public da1(fa1 container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(container, "container");
        this.e = container;
        AbsNadBrowserView m = container.m();
        if (m != null) {
            m.setDownloadListener(this);
        }
        this.a = "DownloadPlugin";
        this.c = "";
        this.d = new Object();
    }

    @Override // com.baidu.tieba.ra1
    public boolean a(Context context, String str, String str2, String str3, String str4, long j, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, str4, Long.valueOf(j), str5})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            String str6 = this.a;
            jb1.a(str6, "onDownloadStart :: url = " + str + ",ua = " + str2 + ",contentDisposition = " + str3 + ",mimetype = " + str4 + ",contentLength = " + j);
            if (t61.b(t61.c(t61.e(str, str3, str4)), str4) == 3) {
                JSONObject c = i31.c(this.c);
                Intrinsics.checkNotNullExpressionValue(c, "JSONUtils.newJSONObject(downloadParams)");
                i31.f(c, "url", str);
                i31.e(c, BreakpointSQLiteKey.CONTENT_LENGTH, j);
                n81 a2 = t81.a();
                if (a2 != null) {
                    a2.b(context, this.b, c.toString());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.ba1
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = this.a;
            jb1.a(str, "context " + this.e.b());
            super.c();
        }
    }

    @Override // com.baidu.tieba.ba1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n81 a2 = t81.a();
            if (a2 != null) {
                a2.release();
            }
            fn0.a().unregister(this.d);
            super.d();
        }
    }

    @Override // com.baidu.tieba.ba1
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n81 a2 = t81.a();
            if (a2 != null) {
                a2.a(this.d, new a(this));
            }
            q();
            p();
            super.m();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0051 A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078 A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085 A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p() {
        pa1.c cVar;
        String b;
        String str;
        String str2;
        String str3;
        String str4;
        String f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pa1.d l = this.e.l();
            String str5 = null;
            if (l != null) {
                cVar = l.e();
            } else {
                cVar = null;
            }
            JSONObject jSONObject = new JSONObject();
            String str6 = "";
            if (l != null) {
                try {
                    b = l.b();
                } catch (JSONException e) {
                    jb1.d(e);
                }
                if (b != null) {
                    jSONObject.put(LegoListActivityConfig.AD_ID, b);
                    if (l != null || (r6 = l.l()) == null) {
                        String str7 = "";
                    }
                    jSONObject.put("lp_url", str7);
                    if (l != null && (f = l.f()) != null) {
                        str6 = f;
                    }
                    jSONObject.put("log_ext", str6);
                    jSONObject.put("business", "native_ads");
                    if (cVar == null) {
                        str = cVar.e();
                    } else {
                        str = null;
                    }
                    jSONObject.put("key", str);
                    if (cVar == null) {
                        str2 = cVar.d();
                    } else {
                        str2 = null;
                    }
                    jSONObject.put("url", str2);
                    if (cVar == null) {
                        str3 = cVar.c();
                    } else {
                        str3 = null;
                    }
                    jSONObject.put("close_v_dl", str3);
                    if (cVar == null) {
                        str4 = cVar.a();
                    } else {
                        str4 = null;
                    }
                    jSONObject.put("app_icon", str4);
                    if (cVar != null) {
                        str5 = cVar.b();
                    }
                    jSONObject.put("app_name", str5);
                    Intrinsics.checkNotNullExpressionValue(jSONObject.toString(), "paramsJson.apply {\n     …\n            }.toString()");
                    this.c = jSONObject.toString();
                }
            }
            b = "";
            jSONObject.put(LegoListActivityConfig.AD_ID, b);
            if (l != null) {
            }
            String str72 = "";
            jSONObject.put("lp_url", str72);
            if (l != null) {
                str6 = f;
            }
            jSONObject.put("log_ext", str6);
            jSONObject.put("business", "native_ads");
            if (cVar == null) {
            }
            jSONObject.put("key", str);
            if (cVar == null) {
            }
            jSONObject.put("url", str2);
            if (cVar == null) {
            }
            jSONObject.put("close_v_dl", str3);
            if (cVar == null) {
            }
            jSONObject.put("app_icon", str4);
            if (cVar != null) {
            }
            jSONObject.put("app_name", str5);
            Intrinsics.checkNotNullExpressionValue(jSONObject.toString(), "paramsJson.apply {\n     …\n            }.toString()");
            this.c = jSONObject.toString();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.e.j() != null && this.e.m() != null) {
            this.b = new RelativeLayout(this.e.b());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            RelativeLayout relativeLayout = this.b;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(0);
            }
            RelativeLayout relativeLayout2 = this.b;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            FrameLayout j = this.e.j();
            if (j != null) {
                j.addView(this.b, layoutParams);
            }
        }
    }
}
