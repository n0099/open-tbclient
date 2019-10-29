package com.baidu.tieba.ala.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
public class AlaSdkWalletActivity extends BaseActivity<AlaSdkWalletActivity> {
    public static final String KEY_GET_WALLET_PLUGIN_INSTALLED = "get_wallet_plugin_installed";
    private static final int PAY_STATUS_FAIL = 1;
    private static final int PAY_STATUS_NO_ORDER = 3;
    private static final int PAY_STATUS_NO_SUC = 2;
    private static final int PAY_STATUS_SUC = 0;
    private static final String PAY_TYPE_URL = "url";
    public static final String TAG = "MAActivity";
    public static final String WALLET_PLUGIN_NOT_INSTALLED = "wallet_plugin_not_installed";
    private AlaSdkWalletActivity mActivity;
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
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    AlaSdkWalletActivity.this.sendGetPayInfoMessage();
                    return;
                default:
                    return;
            }
        }
    };
    private HttpMessageListener mGetPayOrderListener = new HttpMessageListener(1003029) { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            AlaSdkWalletActivity.this.mIsPaying = false;
            AlaSdkWalletActivity.this.closeLoadingDialog();
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetOrderHttpResponsedMessage)) {
                AlaSdkWalletActivity.this.showToast(a.i.sdk_pay_fail);
                AlaSdkWalletActivity.this.mPayStatus = 3;
                AlaSdkWalletActivity.this.finishSelf();
                return;
            }
            ah aMn = ((GetOrderHttpResponsedMessage) httpResponsedMessage).aMn();
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = AlaSdkWalletActivity.this.mContext.getResources().getString(a.i.sdk_neterror);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                AlaSdkWalletActivity.this.showToast(errorString);
                AlaSdkWalletActivity.this.mPayStatus = 3;
                AlaSdkWalletActivity.this.finishSelf();
            } else if (aMn == null) {
                AlaSdkWalletActivity.this.showToast(a.i.sdk_pay_fail);
                AlaSdkWalletActivity.this.mPayStatus = 3;
                AlaSdkWalletActivity.this.finishSelf();
            } else {
                AlaSdkWalletActivity.this.mOrderId = aMn.orderId;
                AlaSdkWalletActivity.this.mCurPayOrderInfo = aMn;
                if (TextUtils.isEmpty(AlaSdkWalletActivity.this.mCurPayOrderInfo.pay_channel) || "url".equalsIgnoreCase(AlaSdkWalletActivity.this.mCurPayOrderInfo.call_type)) {
                    AlaSdkWalletActivity.this.payByWallet();
                    return;
                }
                AlaSdkWalletActivity.this.mViewController = new a(AlaSdkWalletActivity.this.mActivity, AlaSdkWalletActivity.this.mCallback, AlaSdkWalletActivity.this.mCurPayConfig);
                AlaSdkWalletActivity.this.mViewController.isValidData(AlaSdkWalletActivity.this.mCurPayOrderInfo.pay_channel);
                AlaSdkWalletActivity.this.mViewController.hideLoadingView();
                AlaSdkWalletActivity.this.mViewController.a(AlaSdkWalletActivity.this.mCurPayOrderInfo);
            }
        }
    };
    private HttpMessageListener mGetPayInfoListener = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            AlaSdkWalletActivity.this.closeLoadingDialog();
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001505) {
                AlaSdkWalletActivity.this.mPayStatus = 4;
                AlaSdkWalletActivity.this.finishSelf();
                return;
            }
            ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
            HttpMessage httpMessage = (HttpMessage) responseGetPayinfoMessage.getOrginalMessage();
            if (httpMessage.getExtra() instanceof String) {
                AlaSdkWalletActivity.this.mTbeanNum = (String) httpMessage.getExtra();
            }
            if (responseGetPayinfoMessage.getError() != 0 || responseGetPayinfoMessage.hasError()) {
                AlaSdkWalletActivity.this.handleResult(false);
            } else if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                AlaSdkWalletActivity.this.mPayInfoStatus = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 2) {
                    if (AlaSdkWalletActivity.this.hasResendGetMsg) {
                        AlaSdkWalletActivity.this.handleResult(true);
                        return;
                    }
                    AlaSdkWalletActivity.this.hasResendGetMsg = true;
                    AlaSdkWalletActivity.this.mHandler.sendMessageDelayed(AlaSdkWalletActivity.this.mHandler.obtainMessage(1), 5000L);
                } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 0) {
                    AlaSdkWalletActivity.this.handleResult(true);
                } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 1) {
                    AlaSdkWalletActivity.this.handleResult(false);
                } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 3) {
                    AlaSdkWalletActivity.this.handleResult(false);
                } else {
                    AlaSdkWalletActivity.this.handleResult(false);
                }
            }
        }
    };
    private a.b mCallback = new a.b() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.4
        @Override // com.baidu.tieba.ala.live.a.b
        public void doFinish() {
            AlaSdkWalletActivity.this.finishSelf();
        }

        @Override // com.baidu.tieba.ala.live.a.b
        public void doPay(String str) {
            AlaSdkWalletActivity.this.mCurPayOrderInfo.UB = str;
            AlaSdkWalletActivity.this.realPay();
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                AlaSdkWalletActivity.this.finishSelf();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initBundle(bundle);
        this.isPayDialog = this.mCurPayConfig.getIsPayDialog();
        if (this.isPayDialog) {
            setTheme(16973835);
            requestWindowFeature(1);
        }
        super.onCreate(bundle);
        if (this.isPayDialog) {
            PageDialogHelper.setDialogLayout(getActivity());
        }
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        registerTask();
        registerListener();
        this.mContext = getPageContext().getPageActivity();
        this.mActivity = this;
        this.mOrderModel = new com.baidu.tieba.ala.live.b.a(getPageContext());
        this.mPayChannel = PayChannelManager.getInstance().buildPayChannel();
        showLoadingDialog(this.mContext.getString(a.i.sdk_pay_loading));
        if (PayManager.getInstance().getWalletSwan() != null) {
            PayManager.getInstance().getWalletSwan().getWalletUA(new WalletSwan.WalletPayCallback() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.5
                @Override // com.baidu.live.tbadk.pay.WalletSwan.WalletPayCallback
                public void onResult(int i, String str) {
                    if (i == -1 && AlaSdkWalletActivity.WALLET_PLUGIN_NOT_INSTALLED.equals(str)) {
                        AlaSdkWalletActivity.this.closeLoadingDialog();
                        AlaSdkWalletActivity.this.finish();
                        return;
                    }
                    ExtraParamsManager.setWalletSdkUa(str);
                    AlaSdkWalletActivity.this.sendGetOrderMessage(AlaSdkWalletActivity.this.mCurPayConfig);
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
            finishSelf();
        }
    }

    private void initCallback() {
        this.mPayCallback = new IPayCallback() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletActivity.6
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                switch (i) {
                    case 0:
                        AlaSdkWalletActivity.this.sendGetPayInfoMessage();
                        break;
                    case 2:
                        AlaSdkWalletActivity.this.mPayStatus = 1;
                        AlaSdkWalletActivity.this.finishSelf();
                        break;
                    case 3:
                        AlaSdkWalletActivity.this.showToast(a.i.sdk_pay_fail);
                        AlaSdkWalletActivity.this.mPayStatus = 5;
                        AlaSdkWalletActivity.this.finishSelf();
                        break;
                }
                AlaSdkWalletActivity.this.mPayChannel.release();
                AlaSdkWalletActivity.this.mPayCallback = null;
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
            finishSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void payByWallet() {
        if (this.mCurPayOrderInfo == null) {
            showToast(a.i.sdk_pay_fail);
            this.mPayStatus = 3;
            finishSelf();
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
        finishSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishSelf() {
        Intent intent = new Intent();
        getActivity().setResult(-1, intent);
        intent.putExtra("result_code", this.mPayStatus);
        intent.putExtra("result_payinfo_status", this.mPayInfoStatus);
        intent.putExtra("result_tbean_num", this.mTbeanNum);
        intent.putExtra("result_order_id", this.mOrderId);
        getActivity().finish();
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
