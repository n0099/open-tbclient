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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.fj;
import com.baidu.tieba.lq4;
import com.baidu.tieba.pu4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class FaceBuyWebViewActivity extends BaseActivity implements BaseWebView.d, BaseWebView.f, BaseWebView.e {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern j;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseWebView a;
    public NavigationBar b;
    public String c;
    public String d;
    public String e;
    public int f;
    public pu4 g;
    public final Handler h;
    public final Runnable i;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceBuyWebViewActivity a;

        public a(FaceBuyWebViewActivity faceBuyWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceBuyWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String guessUrl = URLUtil.guessUrl(this.a.c);
                if (URLUtil.isNetworkUrl(guessUrl)) {
                    this.a.a.loadUrl(guessUrl);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceBuyWebViewActivity a;

        public b(FaceBuyWebViewActivity faceBuyWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceBuyWebViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.E1();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceBuyWebViewActivity a;

        public c(FaceBuyWebViewActivity faceBuyWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceBuyWebViewActivity;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceBuyWebViewActivity a;

        public d(FaceBuyWebViewActivity faceBuyWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceBuyWebViewActivity;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
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
        j = Pattern.compile("[?|&]order_id=(\\w+)&+");
    }

    public FaceBuyWebViewActivity() {
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
        this.h = new Handler();
        this.i = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            this.h.removeCallbacks(this.i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.b;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
            BaseWebView baseWebView = this.a;
            if (baseWebView != null) {
                SkinManager.setBgColor(baseWebView, i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            D1();
            C1(bundle);
            initCookie();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString(WebViewActivityConfig.TAG_URL, this.c);
            bundle.putString("tag_hook_url", this.d);
            bundle.putString(WebViewActivityConfig.TAG_TITLE, this.e);
            bundle.putInt("tag_position", this.f);
        }
    }

    public final void C1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle != null) {
                this.c = bundle.getString(WebViewActivityConfig.TAG_URL);
                this.d = bundle.getString("tag_hook_url");
                this.e = bundle.getString(WebViewActivityConfig.TAG_TITLE);
                this.f = bundle.getInt("tag_position");
            } else {
                this.c = getIntent().getStringExtra(WebViewActivityConfig.TAG_URL);
                this.d = getIntent().getStringExtra("tag_hook_url");
                this.e = getIntent().getStringExtra(WebViewActivityConfig.TAG_TITLE);
                this.f = getIntent().getIntExtra("tag_position", -1);
            }
            this.b.setTitleText(this.e);
            this.h.postDelayed(this.i, 150L);
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d027f);
            ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.obfuscated_res_0x7f0922a2)).getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + fj.f(getActivity(), R.dimen.obfuscated_res_0x7f070282);
            this.a = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f092642);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0925ad);
            this.b = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
            this.b.setTitleText("");
            this.a.setOnLoadUrlListener(this);
            this.a.setOnPageFinishedListener(this);
            this.a.setOnPageStartedListener(this);
            this.a.setHorizontalScrollBarEnabled(false);
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.g == null) {
                pu4 pu4Var = new pu4(getPageContext().getPageActivity());
                this.g = pu4Var;
                pu4Var.setTitle(R.string.obfuscated_res_0x7f0f0914);
                this.g.setCancelable(false);
                this.g.setMessageId(R.string.obfuscated_res_0x7f0f0fab);
                this.g.setPositiveButton(R.string.obfuscated_res_0x7f0f026a, new c(this));
                this.g.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(this));
                this.g.create(getPageContext());
            }
            this.g.show();
        }
    }

    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                lq4.b().c(TbadkCoreApplication.getCurrentBduss());
                CookieSyncManager.createInstance(getPageContext().getContext());
                CookieManager.getInstance().setAcceptCookie(true);
                CookieSyncManager.getInstance().sync();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
    public void m(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            showProgressBar();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent)) == null) {
            if (i == 4) {
                E1();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
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

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, str)) == null) {
            if (str != null && !ej.isEmpty(str) && !ej.isEmpty(this.d)) {
                String lowerCase = str.toLowerCase();
                if (lowerCase.contains(this.d.toLowerCase())) {
                    Matcher matcher = j.matcher(str);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(1);
                            Intent intent = new Intent();
                            intent.putExtra("tag_order_id", group);
                            intent.putExtra("tag_position", this.f);
                            setResult(-1, intent);
                            closeActivity();
                            return true;
                        } catch (Exception e) {
                            BdLog.detailException(e);
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
