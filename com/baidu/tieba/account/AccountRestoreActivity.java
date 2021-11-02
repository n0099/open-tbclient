package com.baidu.tieba.account;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.l3.n0.b;
import b.a.r0.l3.n0.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes9.dex */
public class AccountRestoreActivity extends BaseActivity<AccountRestoreActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JS_PROMPT_ACCOUNT_METHOD_EXIT = "exit";
    public static final String JS_PROMPT_INTERFACE_NAME = "AccountJsBridge";
    public static final String PAGE_TYPE = "page_type";
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.l3.n0.a jsBridge;
    public c jsCallback;
    public b jsPromptInterface;
    public NavigationBar mNavigationBar;
    public String mPageType;
    public BaseWebView mWebView;

    /* loaded from: classes9.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountRestoreActivity f46631a;

        public a(AccountRestoreActivity accountRestoreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountRestoreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46631a = accountRestoreActivity;
        }

        @Override // b.a.r0.l3.n0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.f46631a.jsBridge != null) {
                    return this.f46631a.jsBridge.b(this.f46631a.mWebView, str, jsPromptResult);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.jsPromptInterface = new b(this) { // from class: com.baidu.tieba.account.AccountRestoreActivity.1
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // b.a.r0.l3.n0.b
            public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
                    if (TextUtils.equals(AccountRestoreActivity.JS_PROMPT_INTERFACE_NAME, str) && TextUtils.equals("exit", str2)) {
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
            if (PageType.PERSON_INFO.toString().equals(this.mPageType)) {
                TbadkCoreApplication.setRefreshFlag(true);
            } else if (PageType.FRS.toString().equals(this.mPageType)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.account_restore_activity);
            b.a.r0.l3.n0.a aVar = new b.a.r0.l3.n0.a();
            this.jsBridge = aVar;
            aVar.a(this.jsPromptInterface);
            this.mPageType = getIntent().getStringExtra("page_type");
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.anti_account_restore));
            ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.webview_acc_restore);
            this.mWebView = baseWebView;
            baseWebView.setOnJsPromptCallback(this.jsCallback);
            BaseWebView baseWebView2 = this.mWebView;
            baseWebView2.loadUrl("http://tieba.baidu.com/mo/q/account_page?_client_version=" + TbConfig.getVersion());
        }
    }
}
