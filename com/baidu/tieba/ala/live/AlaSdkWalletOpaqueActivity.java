package com.baidu.tieba.ala.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.util.PageDialogHelper;
import com.baidu.tieba.ala.live.a;
import com.baidu.tieba.ala.live.c.a;
import com.baidu.tieba.ala.live.c.c;
/* loaded from: classes3.dex */
public class AlaSdkWalletOpaqueActivity extends BaseActivity<AlaSdkWalletOpaqueActivity> {
    private static long lastClickTime;
    private AlaSdkWalletOpaqueActivity fpg;
    private Context mContext;
    private PayConfig mCurPayConfig;
    private com.baidu.tieba.ala.live.c.a mPayController;
    private a mViewController;
    private a.b mCallback = new a.b() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.1
        @Override // com.baidu.tieba.ala.live.a.b
        public void doFinish() {
            AlaSdkWalletOpaqueActivity.this.getActivity().finish();
        }

        @Override // com.baidu.tieba.ala.live.a.b
        public void doPay(String str) {
            if (AlaSdkWalletOpaqueActivity.this.mPayController != null) {
                AlaSdkWalletOpaqueActivity.this.mPayController.Aq(str);
            }
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view") && AlaSdkWalletOpaqueActivity.this.mPayController != null) {
                Intent bpR = AlaSdkWalletOpaqueActivity.this.mPayController.bpR();
                AlaSdkWalletOpaqueActivity.this.setResult(-1, bpR);
                AlaSdkWalletOpaqueActivity.this.b(AlaSdkWalletOpaqueActivity.this.mPayController.bpS() == 0, bpR);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initBundle(bundle);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            registerListener();
            this.mContext = getPageContext().getPageActivity();
            this.fpg = this;
            this.mPayController = c.a(this);
            if (this.mPayController == null) {
                finish();
                return;
            }
            this.mPayController.a(new a.InterfaceC0483a() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.2
                @Override // com.baidu.tieba.ala.live.c.a.InterfaceC0483a
                public void Ao(String str) {
                    AlaSdkWalletOpaqueActivity.this.mViewController = new a(AlaSdkWalletOpaqueActivity.this.fpg, AlaSdkWalletOpaqueActivity.this.mCallback, AlaSdkWalletOpaqueActivity.this.mCurPayConfig);
                    AlaSdkWalletOpaqueActivity.this.mViewController.isValidData(str);
                    AlaSdkWalletOpaqueActivity.this.mViewController.hideLoadingView();
                    AlaSdkWalletOpaqueActivity.this.mViewController.setup();
                }

                @Override // com.baidu.tieba.ala.live.c.a.InterfaceC0483a
                public void a(boolean z, Intent intent) {
                    if (AlaSdkWalletOpaqueActivity.this.mViewController != null) {
                        AlaSdkWalletOpaqueActivity.this.mViewController.payResult(z);
                    }
                    AlaSdkWalletOpaqueActivity.this.b(z, intent);
                }
            });
            this.mPayController.d(this.mCurPayConfig);
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
            this.mCurPayConfig = new PayConfig(intExtra, stringExtra, stringExtra2, stringExtra3, stringExtra4, booleanExtra, stringExtra5, booleanExtra2, payForm, intent.getStringExtra("refer_page"), intent.getStringExtra("click_zone"), stringExtra6);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("pay_config", this.mCurPayConfig.getCompileToJson());
        super.onSaveInstanceState(bundle);
    }

    private void registerListener() {
        registerListener(this.notifyDialogDismissListener);
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - lastClickTime;
        if (j > 0 && j < 1200) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isFastDoubleClick()) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Intent intent) {
        if (z) {
            getActivity().finish();
        } else if (this.mViewController != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913137, intent));
            this.mViewController.payResult(false);
        } else {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
