package com.baidu.tieba.ala.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ah;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.PayManager;
import com.baidu.live.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.live.tbadk.pay.WalletSwan;
import com.baidu.live.tbadk.pay.channel.PayChannelManager;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.util.PageDialogHelper;
import com.baidu.tieba.ala.live.a;
import com.baidu.tieba.ala.live.message.GetOrderHttpResponsedMessage;
/* loaded from: classes6.dex */
public class AlaSdkWalletOpaqueActivity extends BaseActivity<AlaSdkWalletOpaqueActivity> {
    private static long lastClickTime;
    private AlaSdkWalletOpaqueActivity dPL;
    private Context mContext;
    private PayConfig mCurPayConfig;
    private ah mCurPayOrderInfo;
    private String mOrderId;
    private com.baidu.tieba.ala.live.b.a mOrderModel;
    private IPayCallback mPayCallback;
    private IPayChannel mPayChannel;
    private int mPayInfoStatus;
    private String mTbeanNum;
    private a mViewController;
    private final int SEND_GETINFO_MSG = 1;
    private final int RESEND_INTERVAL = 5000;
    private boolean isPayDialog = false;
    private boolean mIsPaying = false;
    private boolean hasResendGetMsg = false;
    private int mPayStatus = 1;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    AlaSdkWalletOpaqueActivity.this.sendGetPayInfoMessage();
                    return;
                default:
                    return;
            }
        }
    };
    private HttpMessageListener mGetPayOrderListener = new HttpMessageListener(1003029) { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            AlaSdkWalletOpaqueActivity.this.mIsPaying = false;
            AlaSdkWalletOpaqueActivity.this.closeLoadingDialog();
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetOrderHttpResponsedMessage)) {
                AlaSdkWalletOpaqueActivity.this.showToast(a.i.sdk_pay_fail);
                AlaSdkWalletOpaqueActivity.this.mPayStatus = 3;
                AlaSdkWalletOpaqueActivity.this.aMk();
                return;
            }
            ah aMl = ((GetOrderHttpResponsedMessage) httpResponsedMessage).aMl();
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = AlaSdkWalletOpaqueActivity.this.mContext.getResources().getString(a.i.sdk_neterror);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                AlaSdkWalletOpaqueActivity.this.showToast(errorString);
                AlaSdkWalletOpaqueActivity.this.mPayStatus = 3;
                AlaSdkWalletOpaqueActivity.this.aMk();
            } else if (aMl == null) {
                AlaSdkWalletOpaqueActivity.this.showToast(a.i.sdk_pay_fail);
                AlaSdkWalletOpaqueActivity.this.mPayStatus = 3;
                AlaSdkWalletOpaqueActivity.this.aMk();
            } else {
                AlaSdkWalletOpaqueActivity.this.mOrderId = aMl.orderId;
                AlaSdkWalletOpaqueActivity.this.mCurPayOrderInfo = aMl;
                if (TextUtils.isEmpty(AlaSdkWalletOpaqueActivity.this.mCurPayOrderInfo.pay_channel) || "url".equalsIgnoreCase(AlaSdkWalletOpaqueActivity.this.mCurPayOrderInfo.call_type)) {
                    AlaSdkWalletOpaqueActivity.this.payByWallet();
                    return;
                }
                AlaSdkWalletOpaqueActivity.this.mViewController = new a(AlaSdkWalletOpaqueActivity.this.dPL, AlaSdkWalletOpaqueActivity.this.mCallback, AlaSdkWalletOpaqueActivity.this.mCurPayConfig);
                AlaSdkWalletOpaqueActivity.this.mViewController.isValidData(AlaSdkWalletOpaqueActivity.this.mCurPayOrderInfo.pay_channel);
                AlaSdkWalletOpaqueActivity.this.mViewController.hideLoadingView();
                AlaSdkWalletOpaqueActivity.this.mViewController.a(AlaSdkWalletOpaqueActivity.this.mCurPayOrderInfo);
            }
        }
    };
    private HttpMessageListener mGetPayInfoListener = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            AlaSdkWalletOpaqueActivity.this.closeLoadingDialog();
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001505) {
                AlaSdkWalletOpaqueActivity.this.mPayStatus = 4;
                AlaSdkWalletOpaqueActivity.this.aMk();
                return;
            }
            ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
            HttpMessage httpMessage = (HttpMessage) responseGetPayinfoMessage.getOrginalMessage();
            if (httpMessage.getExtra() instanceof String) {
                AlaSdkWalletOpaqueActivity.this.mTbeanNum = (String) httpMessage.getExtra();
            }
            if (responseGetPayinfoMessage.getError() != 0 || responseGetPayinfoMessage.hasError()) {
                AlaSdkWalletOpaqueActivity.this.handleResult(false);
            } else if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                AlaSdkWalletOpaqueActivity.this.mPayInfoStatus = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 2) {
                    if (AlaSdkWalletOpaqueActivity.this.hasResendGetMsg) {
                        AlaSdkWalletOpaqueActivity.this.handleResult(true);
                        return;
                    }
                    AlaSdkWalletOpaqueActivity.this.hasResendGetMsg = true;
                    AlaSdkWalletOpaqueActivity.this.mHandler.sendMessageDelayed(AlaSdkWalletOpaqueActivity.this.mHandler.obtainMessage(1), 5000L);
                } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 0) {
                    AlaSdkWalletOpaqueActivity.this.handleResult(true);
                } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 1) {
                    AlaSdkWalletOpaqueActivity.this.handleResult(false);
                } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 3) {
                    AlaSdkWalletOpaqueActivity.this.handleResult(false);
                } else {
                    AlaSdkWalletOpaqueActivity.this.handleResult(false);
                }
            }
        }
    };
    private a.b mCallback = new a.b() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.4
        @Override // com.baidu.tieba.ala.live.a.b
        public void doFinish() {
            AlaSdkWalletOpaqueActivity.this.finish();
        }

        @Override // com.baidu.tieba.ala.live.a.b
        public void doPay(String str) {
            AlaSdkWalletOpaqueActivity.this.mCurPayOrderInfo.Uh = str;
            AlaSdkWalletOpaqueActivity.this.realPay();
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                AlaSdkWalletOpaqueActivity.this.aMk();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initBundle(bundle);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        registerTask();
        registerListener();
        this.mContext = getPageContext().getPageActivity();
        this.dPL = this;
        this.mOrderModel = new com.baidu.tieba.ala.live.b.a(getPageContext());
        this.mPayChannel = PayChannelManager.getInstance().buildPayChannel();
        showLoadingDialog(this.mContext.getString(a.i.sdk_pay_loading));
        if (PayManager.getInstance().getWalletSwan() != null) {
            PayManager.getInstance().getWalletSwan().getWalletUA(new WalletSwan.WalletPayCallback() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.5
                @Override // com.baidu.live.tbadk.pay.WalletSwan.WalletPayCallback
                public void onResult(int i, String str) {
                    if (i == -1 && AlaSdkWalletActivity.WALLET_PLUGIN_NOT_INSTALLED.equals(str)) {
                        AlaSdkWalletOpaqueActivity.this.closeLoadingDialog();
                        AlaSdkWalletOpaqueActivity.this.finish();
                        return;
                    }
                    ExtraParamsManager.setWalletSdkUa(str);
                    AlaSdkWalletOpaqueActivity.this.sendGetOrderMessage(AlaSdkWalletOpaqueActivity.this.mCurPayConfig);
                }
            });
        } else {
            sendGetOrderMessage(this.mCurPayConfig);
        }
    }

    private void initBundle(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("pay_config");
            this.mCurPayConfig = new PayConfig();
            this.mCurPayConfig.parseJson(string);
        } else {
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
        if (this.mCurPayConfig == null) {
            showToast(a.i.sdk_pay_fail);
            this.mPayStatus = 2;
            aMk();
        }
    }

    private void initCallback() {
        this.mPayCallback = new IPayCallback() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletOpaqueActivity.6
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                switch (i) {
                    case 0:
                        AlaSdkWalletOpaqueActivity.this.sendGetPayInfoMessage();
                        break;
                    case 2:
                        AlaSdkWalletOpaqueActivity.this.mPayStatus = 1;
                        AlaSdkWalletOpaqueActivity.this.aMk();
                        break;
                    case 3:
                        AlaSdkWalletOpaqueActivity.this.showToast(a.i.sdk_pay_fail);
                        AlaSdkWalletOpaqueActivity.this.mPayStatus = 5;
                        AlaSdkWalletOpaqueActivity.this.aMk();
                        break;
                }
                AlaSdkWalletOpaqueActivity.this.mPayChannel.release();
                AlaSdkWalletOpaqueActivity.this.mPayCallback = null;
            }
        };
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("pay_config", this.mCurPayConfig.getCompileToJson());
        super.onSaveInstanceState(bundle);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003029, TbConfig.SERVER_ADDRESS + TbConfig.GET_ORDER);
        tbHttpMessageTask.setResponsedClass(GetOrderHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1001505, TbConfig.SERVER_ADDRESS + TbConfig.URL_GETPAYINFO);
        tbHttpMessageTask2.setResponsedClass(ResponseGetPayinfoMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private void registerListener() {
        registerListener(this.mGetPayOrderListener);
        registerListener(this.mGetPayInfoListener);
        registerListener(this.notifyDialogDismissListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetOrderMessage(PayConfig payConfig) {
        if (this.mOrderModel != null && payConfig != null && !this.mIsPaying) {
            this.mOrderModel.setWalletSdkUa(ExtraParamsManager.getWalletSdkUa());
            if (this.mOrderModel.b(payConfig)) {
                this.mIsPaying = true;
                return;
            }
            closeLoadingDialog();
            showToast(a.i.sdk_pay_fail);
            aMk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void payByWallet() {
        if (this.mCurPayOrderInfo == null) {
            showToast(a.i.sdk_pay_fail);
            this.mPayStatus = 3;
            aMk();
            return;
        }
        realPay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realPay() {
        if (this.mPayChannel != null) {
            if (this.mPayCallback == null) {
                initCallback();
            }
            this.mPayChannel.pay(this.mCurPayOrderInfo, this.mPayCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetPayInfoMessage() {
        showLoadingDialog(this.mContext.getString(a.i.sdk_pay_loading));
        String str = this.mOrderId;
        HttpMessage httpMessage = new HttpMessage(1001505);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("pay_id", str);
        httpMessage.setExtra(String.valueOf(this.mCurPayConfig.getTBeanNum()));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResult(boolean z) {
        if (this.mViewController != null) {
            this.mViewController.payResult(z);
        }
        this.mPayStatus = z ? 0 : 4;
        aMk();
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
    public boolean aMk() {
        Intent intent = new Intent();
        getActivity().setResult(-1, intent);
        intent.putExtra("result_code", this.mPayStatus);
        intent.putExtra("result_payinfo_status", this.mPayInfoStatus);
        intent.putExtra("result_tbean_num", this.mTbeanNum);
        intent.putExtra("result_order_id", this.mOrderId);
        if (this.mPayStatus == 0) {
            getActivity().finish();
        } else {
            intent.setAction("com.baidu.minivideo.live.action.pay_broadcast");
            getActivity().sendBroadcast(intent, "com.baidu.minivideo.live.permission.PAY_BROADCAST");
            if (this.mViewController != null) {
                this.mViewController.payResult(false);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterTask(1003029);
        MessageManager.getInstance().unRegisterTask(1001505);
    }
}
