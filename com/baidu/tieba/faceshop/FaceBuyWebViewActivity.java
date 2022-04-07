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
import com.repackage.dn4;
import com.repackage.dr4;
import com.repackage.ni;
import com.repackage.oi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class FaceBuyWebViewActivity extends BaseActivity<FaceBuyWebViewActivity> implements BaseWebView.d, BaseWebView.f, BaseWebView.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG_HOOK_URL = "tag_hook_url";
    public static final String TAG_ORDER_ID = "tag_order_id";
    public static final String TAG_POSITION = "tag_position";
    public static final String TAG_TITLE = "tag_title";
    public static final String TAG_URL = "tag_url";
    public static final Pattern mOrderIdPattern;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler mHandler;
    public String mHookUrl;
    public NavigationBar mNavigationView;
    public int mPosition;
    public dr4 mQuitConfirm;
    public final Runnable mRunnable;
    public String mTitle;
    public String mUrl;
    public BaseWebView mWebView;

    /* loaded from: classes3.dex */
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
                String guessUrl = URLUtil.guessUrl(this.a.mUrl);
                if (URLUtil.isNetworkUrl(guessUrl)) {
                    this.a.mWebView.loadUrl(guessUrl);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.showQuitBuyDialog();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
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
        mOrderIdPattern = Pattern.compile("[?|&]order_id=(\\w+)&+");
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
        this.mHandler = new Handler();
        this.mRunnable = new a(this);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, bundle) == null) {
            if (bundle != null) {
                this.mUrl = bundle.getString("tag_url");
                this.mHookUrl = bundle.getString(TAG_HOOK_URL);
                this.mTitle = bundle.getString("tag_title");
                this.mPosition = bundle.getInt(TAG_POSITION);
            } else {
                this.mUrl = getIntent().getStringExtra("tag_url");
                this.mHookUrl = getIntent().getStringExtra(TAG_HOOK_URL);
                this.mTitle = getIntent().getStringExtra("tag_title");
                this.mPosition = getIntent().getIntExtra(TAG_POSITION, -1);
            }
            this.mNavigationView.setTitleText(this.mTitle);
            this.mHandler.postDelayed(this.mRunnable, 150L);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0289);
            ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.obfuscated_res_0x7f0920b6)).getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070282);
            this.mWebView = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f092425);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.mNavigationView = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
            this.mNavigationView.setTitleText("");
            this.mWebView.setOnLoadUrlListener(this);
            this.mWebView.setOnPageFinishedListener(this);
            this.mWebView.setOnPageStartedListener(this);
            this.mWebView.setHorizontalScrollBarEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQuitBuyDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.mQuitConfirm == null) {
                dr4 dr4Var = new dr4(getPageContext().getPageActivity());
                this.mQuitConfirm = dr4Var;
                dr4Var.setTitle(R.string.obfuscated_res_0x7f0f08db);
                this.mQuitConfirm.setCancelable(false);
                this.mQuitConfirm.setMessageId(R.string.obfuscated_res_0x7f0f0f28);
                this.mQuitConfirm.setPositiveButton(R.string.obfuscated_res_0x7f0f025d, new c(this));
                this.mQuitConfirm.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new d(this));
                this.mQuitConfirm.create(getPageContext());
            }
            this.mQuitConfirm.show();
        }
    }

    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                dn4.b().c(TbadkCoreApplication.getCurrentBduss());
                CookieSyncManager.createInstance(getPageContext().getContext());
                CookieManager.getInstance().setAcceptCookie(true);
                CookieSyncManager.getInstance().sync();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.mNavigationView;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
            BaseWebView baseWebView = this.mWebView;
            if (baseWebView != null) {
                SkinManager.setBgColor(baseWebView, i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            initUI();
            initData(bundle);
            initCookie();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, keyEvent)) == null) {
            if (i == 4) {
                showQuitBuyDialog();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webView, str) == null) {
            hideProgressBar();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
    public void onPageStarted(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, webView, str) == null) {
            showProgressBar();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("tag_url", this.mUrl);
            bundle.putString(TAG_HOOK_URL, this.mHookUrl);
            bundle.putString("tag_title", this.mTitle);
            bundle.putInt(TAG_POSITION, this.mPosition);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, str)) == null) {
            if (str != null && !ni.isEmpty(str) && !ni.isEmpty(this.mHookUrl)) {
                String lowerCase = str.toLowerCase();
                if (lowerCase.contains(this.mHookUrl.toLowerCase())) {
                    Matcher matcher = mOrderIdPattern.matcher(str);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(1);
                            Intent intent = new Intent();
                            intent.putExtra(TAG_ORDER_ID, group);
                            intent.putExtra(TAG_POSITION, this.mPosition);
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
