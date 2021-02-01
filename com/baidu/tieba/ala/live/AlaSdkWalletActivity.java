package com.baidu.tieba.ala.live;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.util.PageDialogHelper;
import com.baidu.tieba.ala.live.b;
import com.baidu.tieba.ala.live.c.a;
import com.baidu.tieba.ala.live.c.c;
/* loaded from: classes11.dex */
public class AlaSdkWalletActivity extends BaseActivity<AlaSdkWalletActivity> {
    public static final String TAG = "AlaSdkWalletActivity";
    private AlaSdkWalletActivity mActivity;
    private Context mContext;
    private PayConfig mCurPayConfig;
    private com.baidu.tieba.ala.live.c.a mPayController;
    private b mViewController;
    private boolean isPayDialog = false;
    private boolean mIsPaying = false;
    private b.InterfaceC0645b mCallback = new b.InterfaceC0645b() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.1
        @Override // com.baidu.tieba.ala.live.b.InterfaceC0645b
        public void doFinish() {
            if (AlaSdkWalletActivity.this.mPayController != null) {
                AlaSdkWalletActivity.this.setResult(-1, AlaSdkWalletActivity.this.mPayController.bYc());
                AlaSdkWalletActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.live.b.InterfaceC0645b
        public void doPay(String str) {
            if (AlaSdkWalletActivity.this.mPayController != null) {
                AlaSdkWalletActivity.this.mPayController.Hi(str);
            }
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view") && AlaSdkWalletActivity.this.mPayController != null) {
                AlaSdkWalletActivity.this.setResult(-1, AlaSdkWalletActivity.this.mPayController.bYc());
                AlaSdkWalletActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initBundle(bundle);
        this.isPayDialog = this.mCurPayConfig.getIsPayDialog();
        if (this.isPayDialog) {
            setTheme(16973835);
            requestWindowFeature(1);
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (this.isPayDialog) {
                PageDialogHelper.setDialogLayout(getActivity());
            }
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            registerListener();
            this.mContext = getPageContext().getPageActivity();
            this.mActivity = this;
            this.mPayController = c.c(this);
            if (this.mPayController == null) {
                finish();
                return;
            }
            this.mPayController.a(new a.InterfaceC0646a() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.2
                @Override // com.baidu.tieba.ala.live.c.a.InterfaceC0646a
                public void GZ(String str) {
                    AlaSdkWalletActivity.this.mViewController = new b(AlaSdkWalletActivity.this.mActivity, AlaSdkWalletActivity.this.mCallback, AlaSdkWalletActivity.this.mCurPayConfig);
                    AlaSdkWalletActivity.this.mViewController.isValidData(str);
                    AlaSdkWalletActivity.this.mViewController.hideLoadingView();
                    AlaSdkWalletActivity.this.mViewController.setup();
                }

                @Override // com.baidu.tieba.ala.live.c.a.InterfaceC0646a
                public void a(boolean z, Intent intent) {
                    if (AlaSdkWalletActivity.this.mViewController != null) {
                        AlaSdkWalletActivity.this.mViewController.payResult(z);
                    }
                    AlaSdkWalletActivity.this.finish();
                }
            });
            this.mPayController.d(this.mCurPayConfig);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    private void initBundle(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("pay_config");
            this.mCurPayConfig = new PayConfig();
            this.mCurPayConfig.parseJson(string);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("pay_type", 2);
            String stringExtra = intent.getStringExtra("is_left");
            String stringExtra2 = intent.getStringExtra("props_id");
            String stringExtra3 = intent.getStringExtra("money");
            String stringExtra4 = intent.getStringExtra("props_mon");
            boolean booleanExtra = intent.getBooleanExtra("isPay", false);
            String stringExtra5 = intent.getStringExtra("tbean_num");
            boolean booleanExtra2 = intent.getBooleanExtra("is_pay_dialog", false);
            int intExtra2 = intent.getIntExtra("pay_from", -1);
            String stringExtra6 = intent.getStringExtra("from");
            PageDialogHelper.PayForm payForm = PageDialogHelper.PayForm.NOT_SET;
            switch (intExtra2) {
                case 0:
                    payForm = PageDialogHelper.PayForm.NOT_SET;
                    break;
                case 1:
                    payForm = PageDialogHelper.PayForm.DIALOG;
                    break;
                case 2:
                    payForm = PageDialogHelper.PayForm.NORMAL;
                    break;
            }
            this.mCurPayConfig = new PayConfig(intExtra, stringExtra, stringExtra2, stringExtra3, stringExtra4, booleanExtra, stringExtra5, booleanExtra2, payForm, intent.getStringExtra("refer_page"), intent.getStringExtra("click_zone"), stringExtra6, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("pay_config", this.mCurPayConfig.getCompileToJson());
        super.onSaveInstanceState(bundle);
    }

    private void registerListener() {
        registerListener(this.notifyDialogDismissListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
