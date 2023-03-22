package com.baidu.tieba.account;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.lx5;
import com.baidu.tieba.oc9;
import com.baidu.tieba.pc9;
import com.baidu.tieba.qc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes3.dex */
public class AccountRestoreActivity extends BaseActivity<AccountRestoreActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JS_PROMPT_ACCOUNT_METHOD_EXIT = "exit";
    public static final String JS_PROMPT_INTERFACE_NAME = "AccountJsBridge";
    public static final String PAGE_TYPE = "page_type";
    public transient /* synthetic */ FieldHolder $fh;
    public oc9 jsBridge;
    public qc9 jsCallback;
    public pc9 jsPromptInterface;
    public NavigationBar mNavigationBar;
    public String mPageType;
    public BaseWebView mWebView;

    /* loaded from: classes3.dex */
    public class a implements qc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountRestoreActivity a;

        public a(AccountRestoreActivity accountRestoreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountRestoreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountRestoreActivity;
        }

        @Override // com.baidu.tieba.qc9
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.jsBridge != null) {
                    return this.a.jsBridge.c(this.a.mWebView, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public AccountRestoreActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.jsPromptInterface = new pc9(this) { // from class: com.baidu.tieba.account.AccountRestoreActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AccountRestoreActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.pc9
            public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
                    if (TextUtils.equals(AccountRestoreActivity.JS_PROMPT_INTERFACE_NAME, str) && TextUtils.equals(AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, str2)) {
                        jsPromptResult.confirm();
                        this.this$0.exitPage();
                        return true;
                    }
                    return false;
                }
                return invokeLLLL.booleanValue;
            }
        };
        this.jsCallback = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (PageType.FRS.toString().equals(this.mPageType)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0024);
            oc9 oc9Var = new oc9();
            this.jsBridge = oc9Var;
            oc9Var.a(this.jsPromptInterface);
            this.mPageType = getIntent().getStringExtra("page_type");
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0291));
            ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.obfuscated_res_0x7f0924a4)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f092872);
            this.mWebView = baseWebView;
            baseWebView.setOnJsPromptCallback(this.jsCallback);
            BaseWebView baseWebView2 = this.mWebView;
            baseWebView2.loadUrl(lx5.a + "?_client_version=" + TbConfig.getVersion());
        }
    }
}
