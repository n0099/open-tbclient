package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.s.s.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class FaceBuyWebViewActivity extends ProxyAdkBaseActivity<FaceBuyWebViewActivity> implements BaseWebView.d, BaseWebView.f, BaseWebView.e {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f43733e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f43734f;

    /* renamed from: g  reason: collision with root package name */
    public String f43735g;

    /* renamed from: h  reason: collision with root package name */
    public String f43736h;

    /* renamed from: i  reason: collision with root package name */
    public String f43737i;

    /* renamed from: j  reason: collision with root package name */
    public int f43738j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.s.s.a f43739k;
    public final Handler l;
    public final Runnable m;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceBuyWebViewActivity f43740e;

        public a(FaceBuyWebViewActivity faceBuyWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43740e = faceBuyWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String guessUrl = URLUtil.guessUrl(this.f43740e.f43735g);
                if (URLUtil.isNetworkUrl(guessUrl)) {
                    this.f43740e.f43733e.loadUrl(guessUrl);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceBuyWebViewActivity f43741e;

        public b(FaceBuyWebViewActivity faceBuyWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43741e = faceBuyWebViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43741e.m();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceBuyWebViewActivity f43742e;

        public c(FaceBuyWebViewActivity faceBuyWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43742e = faceBuyWebViewActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f43742e.closeActivity();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceBuyWebViewActivity f43743e;

        public d(FaceBuyWebViewActivity faceBuyWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43743e = faceBuyWebViewActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1645661586, "Lcom/baidu/tieba/faceshop/FaceBuyWebViewActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1645661586, "Lcom/baidu/tieba/faceshop/FaceBuyWebViewActivity;");
                return;
            }
        }
        n = Pattern.compile("[?|&]order_id=(\\w+)&+");
    }

    public FaceBuyWebViewActivity() {
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
        this.l = new Handler();
        this.m = new a(this);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
    public void a(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            showProgressBar();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c.a.q0.s.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
                CookieSyncManager.createInstance(getPageContext().getContext());
                CookieManager.getInstance().setAcceptCookie(true);
                CookieSyncManager.getInstance().sync();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void k(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            if (bundle != null) {
                this.f43735g = bundle.getString(WebViewActivityConfig.TAG_URL);
                this.f43736h = bundle.getString("tag_hook_url");
                this.f43737i = bundle.getString(WebViewActivityConfig.TAG_TITLE);
                this.f43738j = bundle.getInt("tag_position");
            } else {
                this.f43735g = getIntent().getStringExtra(WebViewActivityConfig.TAG_URL);
                this.f43736h = getIntent().getStringExtra("tag_hook_url");
                this.f43737i = getIntent().getStringExtra(WebViewActivityConfig.TAG_TITLE);
                this.f43738j = getIntent().getIntExtra("tag_position", -1);
            }
            this.f43734f.setTitleText(this.f43737i);
            this.l.postDelayed(this.m, 150L);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setContentView(R.layout.face_buy_webview_activity);
            ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + l.f(getActivity(), R.dimen.ds98);
            this.f43733e = (BaseWebView) findViewById(R.id.webview);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.f43734f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
            this.f43734f.setTitleText("");
            this.f43733e.setOnLoadUrlListener(this);
            this.f43733e.setOnPageFinishedListener(this);
            this.f43733e.setOnPageStartedListener(this);
            this.f43733e.setHorizontalScrollBarEnabled(false);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f43739k == null) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                this.f43739k = aVar;
                aVar.setTitle(R.string.inform);
                this.f43739k.setCancelable(false);
                this.f43739k.setMessageId(R.string.quit_buy_confirm);
                this.f43739k.setPositiveButton(R.string.alert_yes_button, new c(this));
                this.f43739k.setNegativeButton(R.string.cancel, new d(this));
                this.f43739k.create(getPageContext());
            }
            this.f43739k.show();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            NavigationBar navigationBar = this.f43734f;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
            }
            BaseWebView baseWebView = this.f43733e;
            if (baseWebView != null) {
                SkinManager.setBgColor(baseWebView, i2);
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            l();
            k(bundle);
            j();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            this.l.removeCallbacks(this.m);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                m();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, webView, str) == null) {
            hideProgressBar();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString(WebViewActivityConfig.TAG_URL, this.f43735g);
            bundle.putString("tag_hook_url", this.f43736h);
            bundle.putString(WebViewActivityConfig.TAG_TITLE, this.f43737i);
            bundle.putInt("tag_position", this.f43738j);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, str)) == null) {
            if (str != null && !k.isEmpty(str) && !k.isEmpty(this.f43736h)) {
                String lowerCase = str.toLowerCase();
                if (lowerCase.contains(this.f43736h.toLowerCase())) {
                    Matcher matcher = n.matcher(str);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(1);
                            Intent intent = new Intent();
                            intent.putExtra("tag_order_id", group);
                            intent.putExtra("tag_position", this.f43738j);
                            setResult(-1, intent);
                            closeActivity();
                            return true;
                        } catch (Exception e2) {
                            BdLog.detailException(e2);
                        }
                    }
                } else if (lowerCase.startsWith("tel:")) {
                    startActivity(new Intent("android.intent.action.DIAL", Uri.parse(lowerCase)));
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
