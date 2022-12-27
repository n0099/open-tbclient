package com.baidu.tieba;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ViewStub b;
    public PbGiftListView c;
    public ViewStub d;
    public LinearLayout e;
    public View f;
    public BaseWebView g;

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements BaseWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public a(e38 e38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e38Var};
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

    /* loaded from: classes4.dex */
    public class b implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(e38 e38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e38 a;

        public c(e38 e38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.g != null) {
                        this.a.g.destroy();
                        this.a.g = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    public e38(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090cf9);
        this.d = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0913b7);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (baseWebView = this.g) != null) {
            baseWebView.removeAllViews();
            this.g.getSettings().setBuiltInZoomControls(true);
            this.g.setVisibility(8);
            ah.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void b(xt4 xt4Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{xt4Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (xt4Var != null && !ListUtils.isEmpty(xt4Var.a()) && (viewStub = this.b) != null) {
                if (this.c == null) {
                    this.c = (PbGiftListView) viewStub.inflate();
                }
                this.c.setVisibility(0);
                this.c.g(xt4Var, str, str2, j, j2, j3);
                this.c.i();
                return;
            }
            PbGiftListView pbGiftListView = this.c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(mt4 mt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mt4Var) == null) && mt4Var != null && !xi.isEmpty(mt4Var.e())) {
            BaseWebView baseWebView = this.g;
            if ((baseWebView == null || !baseWebView.getIsLoaded()) && mt4Var.c() == mt4.g && this.d != null) {
                if (mt4Var.f()) {
                    LinearLayout linearLayout = this.e;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.e == null) {
                    LinearLayout linearLayout2 = (LinearLayout) this.d.inflate();
                    this.e = linearLayout2;
                    this.f = linearLayout2.findViewById(R.id.obfuscated_res_0x7f0913b2);
                    this.g = (BaseWebView) this.e.findViewById(R.id.obfuscated_res_0x7f0913b8);
                }
                this.f.setVisibility(0);
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
                this.g.setVisibility(0);
                this.g.setFocusable(false);
                this.g.setBackgroundColor(0);
                this.g.getSettings().setCacheMode(-1);
                this.g.setVerticalScrollBarEnabled(false);
                this.g.setHorizontalScrollBarEnabled(false);
                this.g.getSettings().setAllowFileAccess(true);
                this.g.getSettings().setAppCacheEnabled(true);
                this.g.getSettings().setDomStorageEnabled(true);
                this.g.getSettings().setDatabaseEnabled(true);
                this.g.setOnLoadUrlListener(new a(this));
                this.g.setOnPageFinishedListener(new b(this));
                this.g.loadUrl(mt4Var.e());
            }
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (baseWebView = this.g) != null) {
            try {
                baseWebView.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void e() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (baseWebView = this.g) != null) {
            try {
                baseWebView.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
