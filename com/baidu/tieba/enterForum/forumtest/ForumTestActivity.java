package com.baidu.tieba.enterForum.forumtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import c.a.o0.b1.q;
import c.a.o0.s.s.f;
import c.a.o0.s.s.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.forumtest.js.ForumTestWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ForumTestActivity extends BaseActivity implements c.a.p0.m0.e.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i.d mDialogSaveToDiskListener;
    public PopupDialog mMoreDialog;
    public List<f> mMoreDialogDataList;
    public i mMoreDialogView;
    public NoNetworkView mNoNetworkView;
    public PermissionJudgePolicy mPermissionJudgement;
    public f mSaveToDickItem;
    public View mStatusBarView;
    public long mTestId;
    public String mUrl;
    public ForumTestWebView mWebView;

    /* loaded from: classes7.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumTestActivity f49878e;

        public a(ForumTestActivity forumTestActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49878e = forumTestActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f49878e.handleLongClick() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f49879e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumTestActivity f49880f;

        public b(ForumTestActivity forumTestActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49880f = forumTestActivity;
            this.f49879e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f49879e.t);
                l.M(this.f49880f, view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumTestActivity f49881a;

        public c(ForumTestActivity forumTestActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49881a = forumTestActivity;
        }

        @Override // c.a.o0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49881a.hideMoreDialog();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumTestActivity f49882a;

        public d(ForumTestActivity forumTestActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49882a = forumTestActivity;
        }

        @Override // c.a.o0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ForumTestActivity forumTestActivity = this.f49882a;
                forumTestActivity.saveImage(forumTestActivity.mWebView.getHitTestResult().getExtra());
                this.f49882a.hideMoreDialog();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumTestActivity f49883a;

        public e(ForumTestActivity forumTestActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49883a = forumTestActivity;
        }

        @Override // c.a.o0.b1.q.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                l.L(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
            }
        }

        @Override // c.a.o0.b1.q.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                l.L(TbadkCoreApplication.getInst(), R.string.save_success);
            }
        }
    }

    public ForumTestActivity() {
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
        this.mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";
        this.mDialogSaveToDiskListener = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        InterceptResult invokeV;
        WebView.HitTestResult hitTestResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            ForumTestWebView forumTestWebView = this.mWebView;
            if (forumTestWebView == null || (hitTestResult = forumTestWebView.getHitTestResult()) == null || hitTestResult.getType() != 5) {
                return false;
            }
            setDialogItems();
            show();
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideMoreDialog() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && (popupDialog = this.mMoreDialog) != null && popupDialog.isShowing()) {
            this.mMoreDialog.dismiss();
        }
    }

    private void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mTestId = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
        this.mUrl += this.mTestId;
    }

    private void initDiaglogView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.mMoreDialog == null) {
                this.mMoreDialogView = new i(this);
            }
            if (this.mMoreDialogDataList == null) {
                this.mMoreDialogDataList = new ArrayList();
            }
            this.mMoreDialog = new PopupDialog(getPageContext(), this.mMoreDialogView);
        }
    }

    private void initStatusBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            if (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mWebView.getLayoutParams();
                layoutParams2.addRule(3, R.id.status_bar_view);
                this.mWebView.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return;
            }
            q qVar = new q(getActivity(), str, new e(this));
            qVar.h(true);
            qVar.execute(new String[0]);
        }
    }

    private void setDialogItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mMoreDialogDataList.clear();
            f fVar = new f(getString(R.string.save_this_image), this.mMoreDialogView);
            this.mSaveToDickItem = fVar;
            fVar.l(this.mDialogSaveToDiskListener);
            this.mMoreDialogDataList.add(this.mSaveToDickItem);
            this.mMoreDialogView.m(new c(this));
            this.mMoreDialogView.k(this.mMoreDialogDataList);
        }
    }

    private void show() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.mMoreDialog == null || isFinishing()) {
            return;
        }
        this.mMoreDialog.showDialog();
    }

    @Override // c.a.p0.m0.e.a.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
            if ("CommonJSBridge".equals(str)) {
                if ("share".equals(str2)) {
                    if (ShareSwitch.isOn()) {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString("desc");
                            String optString3 = jSONObject.optString("img");
                            String optString4 = jSONObject.optString("url");
                            ShareItem shareItem = new ShareItem();
                            shareItem.r = optString;
                            shareItem.s = optString2;
                            shareItem.t = optString4;
                            shareItem.v = Uri.parse(optString3);
                            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this, shareItem, true, true);
                            shareDialogConfig.setIsCopyLink(true);
                            shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
                            sendMessage(new CustomMessage(2001276, shareDialogConfig));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    jsPromptResult.confirm("share");
                    return false;
                } else if (CommonTbJsBridge.FINISH_THIS_PAGE.equals(str2)) {
                    finish();
                    jsPromptResult.confirm(CommonTbJsBridge.FINISH_THIS_PAGE);
                    return true;
                } else if (CommonTbJsBridge.FINISH_TEST_ANSWER.equals(str2)) {
                    try {
                        this.mTestId = new JSONObject(str3).optLong("testId");
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.mTestId)));
                    finish();
                    jsPromptResult.confirm(CommonTbJsBridge.FINISH_TEST_ANSWER);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            setSwipeBackEnabled(false);
            super.onCreate(bundle);
            setContentView(R.layout.activity_forum_test_layout);
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.activity_forum_test_net);
            this.mStatusBarView = findViewById(R.id.status_bar_view);
            ForumTestWebView forumTestWebView = (ForumTestWebView) findViewById(R.id.activity_forum_test_web);
            this.mWebView = forumTestWebView;
            forumTestWebView.init(this);
            initStatusBar();
            initData();
            this.mWebView.loadUrl(this.mUrl);
            this.mWebView.setOnLongClickListener(new a(this));
            initDiaglogView();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ForumTestWebView forumTestWebView = this.mWebView;
            if (forumTestWebView != null) {
                forumTestWebView.loadDataWithBaseURL(null, "", SapiWebView.DATA_MIME_TYPE, "utf-8", null);
                this.mWebView.clearHistory();
                ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
                this.mWebView.destroy();
                this.mWebView = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, keyEvent)) == null) {
            if (i2 == 4 && this.mWebView.canGoBack()) {
                this.mWebView.goBack();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPause();
            this.mWebView.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.mWebView.onResume();
        }
    }
}
