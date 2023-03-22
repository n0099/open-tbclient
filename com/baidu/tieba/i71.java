package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.t71;
import com.baidu.tieba.u51;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes4.dex */
public final class i71 extends f71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zh0 a;
    public final j71 b;

    /* loaded from: classes4.dex */
    public static final class a implements zh0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i71 a;

        public a(i71 i71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i71Var;
        }

        @Override // com.baidu.tieba.zh0
        public final void a(boolean z, Map<String, String> map) {
            AbsNadBrowserView m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String p = ei0.p(map);
                if (!TextUtils.isEmpty(p) && (m = this.a.b.m()) != null) {
                    AbsNadBrowserView.B(m, p, null, 2, null);
                }
            }
        }
    }

    public i71(j71 container) {
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
        this.b = container;
        this.a = new a(this);
    }

    @Override // com.baidu.tieba.f71
    public boolean f(AbsNadBrowserView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            String d = p81.d(str);
            Intrinsics.checkNotNullExpressionValue(d, "UrlUtil.handleAbnormalUrlIfNeeded(url)");
            if (!TextUtils.isEmpty(d) && (StringsKt__StringsJVMKt.startsWith$default(d, "http://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(d, "https://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(d, "ftp://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(d, "sftp://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(d, "ftps://", false, 2, null))) {
                return false;
            }
            if (str != null && this.b.a(str)) {
                return true;
            }
            o(webView, str);
            if (this.b.l() != null) {
                t71.d l = this.b.l();
                Intrinsics.checkNotNull(l);
                if (!l.a()) {
                    return true;
                }
            }
            if (!ci0.a(this.b.c(), str) || oh0.b(this.b.c(), str, false) || u51.b.a().a(this.b.c(), str, webView.getUrl(), this.a) || qh0.c(str, this.b.c())) {
                return true;
            }
            AbsNadBrowserView m = this.b.m();
            if (m != null) {
                m.T();
            }
            return super.f(webView, str);
        }
        return invokeLL.booleanValue;
    }

    public final void o(AbsNadBrowserView absNadBrowserView, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absNadBrowserView, str) == null) && str != null) {
            String str3 = null;
            if (StringsKt__StringsJVMKt.startsWith$default(str, "tel:", false, 2, null) && this.b.c() != null) {
                t71.d l = this.b.l();
                if (l != null) {
                    str2 = l.f();
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    oc1 oc1Var = new oc1();
                    Activity c = this.b.c();
                    Intrinsics.checkNotNull(c);
                    t71.d l2 = this.b.l();
                    if (l2 != null) {
                        str3 = l2.f();
                    }
                    oc1Var.p(c, str3, "tel");
                }
            }
        }
    }
}
