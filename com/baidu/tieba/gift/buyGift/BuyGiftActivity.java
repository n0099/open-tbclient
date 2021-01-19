package com.baidu.tieba.gift.buyGift;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SendGiftSuccessMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes8.dex */
public class BuyGiftActivity extends BaseActivity<BuyGiftActivity> implements ViewPager.OnPageChangeListener {
    private LinearLayout aYe;
    private int aYr;
    private int aYs;
    private FrameLayout jMD;
    private View jME;
    private View jMF;
    private EditText jMG;
    private TextView jMH;
    private TextView jMI;
    private BaseViewPager jMJ;
    private IndicatorView jMK;
    private View jML;
    private View jMM;
    private View jMN;
    private ListView jMO;
    private com.baidu.tieba.gift.buyGift.b jMP;
    private GiftPagerAdapter jMQ;
    private GiftCommonList jMR;
    private GiftCommonList.GiftItem jMS;
    private com.baidu.tbadk.core.dialog.a jMU;
    private View jMV;
    private EditText jMW;
    private TextView jMX;
    private String jMY;
    private InputMethodManager jNa;
    private int mFrom;
    private String mPassword;
    private long mReceiverId;
    private int mSelectedPosition;
    private List<View> aYn = new ArrayList();
    private SparseIntArray aYz = new SparseIntArray();
    private boolean jMT = false;
    private boolean jMZ = false;
    private SendGiftSuccessMessage.a mGiftInfo = new SendGiftSuccessMessage.a();
    private final HttpMessageListener jNb = new HttpMessageListener(1001509) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetGiftCommonListHttpResponseMessage) {
                GetGiftCommonListHttpResponseMessage getGiftCommonListHttpResponseMessage = (GetGiftCommonListHttpResponseMessage) httpResponsedMessage;
                BuyGiftActivity.this.jMR = getGiftCommonListHttpResponseMessage.getGiftInfo();
                BuyGiftActivity.this.bx(getGiftCommonListHttpResponseMessage.getError(), getGiftCommonListHttpResponseMessage.getErrorString());
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jNc = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_GIFT_LIST) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof GetGiftCommonListSocketResponseMessage) {
                GetGiftCommonListSocketResponseMessage getGiftCommonListSocketResponseMessage = (GetGiftCommonListSocketResponseMessage) socketResponsedMessage;
                BuyGiftActivity.this.jMR = getGiftCommonListSocketResponseMessage.getGiftInfo();
                BuyGiftActivity.this.bx(getGiftCommonListSocketResponseMessage.getError(), getGiftCommonListSocketResponseMessage.getErrorString());
            }
        }
    };
    private final com.baidu.adp.framework.listener.a jNd = new com.baidu.adp.framework.listener.a(1001510, CmdConfigSocket.CMD_SEND_GIFT) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.9
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof SendGiftSocketResponseMessage) {
                BuyGiftActivity.this.jMI.setEnabled(true);
                SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) responsedMessage;
                BuyGiftActivity.this.a(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
            } else if (responsedMessage instanceof SendGiftHttpResponseMessage) {
                BuyGiftActivity.this.jMI.setEnabled(true);
                SendGiftHttpResponseMessage sendGiftHttpResponseMessage = (SendGiftHttpResponseMessage) responsedMessage;
                BuyGiftActivity.this.a(sendGiftHttpResponseMessage.getError(), sendGiftHttpResponseMessage.getErrorString(), sendGiftHttpResponseMessage.getResponseData());
            }
        }
    };
    private final CustomMessageListener jNe = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BuyGiftActivity.this.jMT = true;
            BuyGiftActivity.this.EB();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(R.layout.activity_buy_gift);
        initViews();
        initData();
        this.mFrom = getIntent().getIntExtra("from", 1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.jMZ) {
            aBX();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFrom = intent.getIntExtra("from", 1);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        closeActivity();
    }

    private void aBX() {
        this.jME.setBackgroundColor(ao.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.jME.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.11
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BuyGiftActivity.this.jMF.setVisibility(0);
                BuyGiftActivity.this.cLM();
            }
        });
        this.jMF.startAnimation(loadAnimation);
        this.jMZ = true;
    }

    private void Tq() {
        this.jME.setBackgroundColor(ao.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.jME.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.12
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BuyGiftActivity.this.finish();
            }
        });
        this.jMF.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Tq();
    }

    private void initViews() {
        this.jMD = (FrameLayout) findViewById(R.id.gift_panel_lay);
        this.jME = findViewById(R.id.empty_layout);
        this.jME.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BuyGiftActivity.this.jMN.getVisibility() == 0) {
                    BuyGiftActivity.this.jMN.setVisibility(8);
                } else {
                    BuyGiftActivity.this.closeActivity();
                }
            }
        });
        this.jMF = findViewById(R.id.gift_list_layout);
        this.jNa = (InputMethodManager) getSystemService("input_method");
        this.jMG = (EditText) findViewById(R.id.gift_count_input);
        this.jMG.setSelection(1);
        rF(false);
        this.jMG.addTextChangedListener(new c());
        this.jMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jNa, BuyGiftActivity.this.jMG);
                BuyGiftActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BuyGiftActivity.this.rF(false);
                        BuyGiftActivity.this.jMN.setVisibility(0);
                    }
                }, 200L);
            }
        });
        this.jMG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.15
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    BuyGiftActivity.this.ShowSoftKeyPad(BuyGiftActivity.this.jNa, BuyGiftActivity.this.jMG);
                } else {
                    BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jNa, BuyGiftActivity.this.jMG);
                }
            }
        });
        this.jMH = (TextView) findViewById(R.id.gift_count_result);
        this.jMI = (TextView) findViewById(R.id.gift_button);
        this.jMI.setEnabled(false);
        this.jMI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.EB();
            }
        });
        this.jML = findViewById(R.id.gift_lower_layout);
        this.jMJ = (BaseViewPager) findViewById(R.id.gift_viewpager);
        this.jMJ.setOnPageChangeListener(this);
        this.jMK = (IndicatorView) findViewById(R.id.gift_tab_indicator);
        this.aYe = (LinearLayout) findViewById(R.id.gift_tab_layout);
        this.jMM = findViewById(R.id.gift_progress_layout);
        this.jMN = findViewById(R.id.gift_num_layout);
        this.jMN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.jMN.setVisibility(8);
            }
        });
        this.jMO = (ListView) findViewById(R.id.gift_num_list);
        this.jMO.setOnItemClickListener(new b());
        this.jMU = new com.baidu.tbadk.core.dialog.a(getActivity());
        this.jMV = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_tdou_pay_pwd, (ViewGroup) null);
        this.jMW = (EditText) this.jMV.findViewById(R.id.password_dialog_input);
        this.jMX = (TextView) this.jMV.findViewById(R.id.password_dialog_warning);
        this.jMU.br(this.jMV);
        this.jMU.jE(false);
        this.jMU.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                BuyGiftActivity.this.mPassword = "";
                BuyGiftActivity.this.jMW.clearFocus();
                BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jNa, BuyGiftActivity.this.jMW);
                BuyGiftActivity.this.jMU.dismiss();
            }
        });
        this.jMU.a(getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                BuyGiftActivity.this.rD(false);
                BuyGiftActivity.this.mPassword = BuyGiftActivity.this.jMW.getText().toString();
                if (StringUtils.isValidPassWord(BuyGiftActivity.this.mPassword)) {
                    if (!StringUtils.isNull(BuyGiftActivity.this.jMY)) {
                        try {
                            com.baidu.ueg.encrypt.a a2 = com.baidu.ueg.encrypt.b.a(new com.baidu.ueg.encrypt.entity.a(EncryptAlgorithm.RSA, BuyGiftActivity.this.jMY));
                            BuyGiftActivity.this.mPassword = a2.encrypt(BuyGiftActivity.this.mPassword);
                        } catch (Exception e) {
                            BuyGiftActivity.this.mPassword = "";
                            e.printStackTrace();
                        }
                    }
                    BuyGiftActivity.this.EB();
                    BuyGiftActivity.this.jMW.setText("");
                    return;
                }
                BuyGiftActivity.this.rD(true);
            }
        });
        this.jMU.b(getPageContext());
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra("gift_receiver_id", 0L);
        }
        registerTask();
        registerListener();
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001509, TbConfig.SERVER_ADDRESS + TbConfig.GIFT_COMMONLIST + "?cmd=" + CmdConfigSocket.CMD_GET_GIFT_LIST);
        tbHttpMessageTask.setResponsedClass(GetGiftCommonListHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_GET_GIFT_LIST);
        bVar.setResponsedClass(GetGiftCommonListSocketResponseMessage.class);
        bVar.setNeedAck(true);
        bVar.setNeedCompress(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1001510, TbConfig.SERVER_ADDRESS + TbConfig.SEND_GIFT + "?cmd=" + CmdConfigSocket.CMD_SEND_GIFT);
        tbHttpMessageTask2.setResponsedClass(SendGiftHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask2);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_SEND_GIFT);
        bVar2.setResponsedClass(SendGiftSocketResponseMessage.class);
        bVar2.setNeedAck(true);
        bVar2.setNeedCompress(false);
        bVar2.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar2);
    }

    private void registerListener() {
        registerListener(this.jNb);
        registerListener(this.jNc);
        registerListener(this.jNd);
        registerListener(this.jNe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLM() {
        this.jMM.setVisibility(0);
        this.jML.setVisibility(8);
        this.jMN.setVisibility(8);
        rF(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.jMG);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, String str) {
        if (i != 0 || this.jMR == null || this.jMR.getGiftInfo() == null || this.jMR.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.jMI.setEnabled(true);
        this.jMM.setVisibility(8);
        this.jML.setVisibility(0);
        cLO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EB() {
        if (this.jMS != null && this.mReceiverId > 0) {
            if (this.jMU != null && this.jMU.isShowing()) {
                this.jMU.setYesBtnClickable(false);
                this.jMU.setNoBtnClickable(false);
            }
            this.jMI.setEnabled(false);
            this.jMM.setVisibility(0);
            RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
            int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(this.jMG.getText()), 1);
            requestSendGiftNetMessage.setParams(this.mReceiverId, this.jMS.getGiftId(), this.jMS.getPrice(), i, cLN(), this.mPassword);
            this.mGiftInfo.setCount(i);
            this.mGiftInfo.setName(this.jMS.getName());
            this.mGiftInfo.setUrl(this.jMS.getThumbnailUrl());
            this.mGiftInfo.setId(this.jMS.getGiftId());
            this.mGiftInfo.Aq(TbadkCoreApplication.getCurrentAccountName());
            sendMessage(requestSendGiftNetMessage);
        }
    }

    public int cLN() {
        switch (this.mFrom) {
            case 1:
            default:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, SendGiftAndroidResIdl sendGiftAndroidResIdl) {
        if (this.jMU != null && this.jMU.isShowing()) {
            this.jMU.setYesBtnClickable(true);
            this.jMU.setNoBtnClickable(true);
        }
        this.jMM.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.jMT) {
            int rE = rE(false);
            int intValue = (sendGiftAndroidResIdl == null || sendGiftAndroidResIdl.data == null || sendGiftAndroidResIdl.data.money == null) ? 0 : rE - sendGiftAndroidResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(R.string.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), rE)));
            if (this.jNa != null) {
                HidenSoftKeyPad(this.jNa, this.jMG);
            }
            if (this.jMU != null && this.jMU.isShowing()) {
                this.jMU.dismiss();
            }
        } else if (i == 1990028) {
            rD(true);
        } else if (i == 1990019) {
            bc(str, 0);
            cLM();
        } else if (i == 1990027) {
            if (sendGiftAndroidResIdl != null && sendGiftAndroidResIdl.data != null && sendGiftAndroidResIdl.data.public_key != null) {
                this.jMY = sendGiftAndroidResIdl.data.public_key;
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    BuyGiftActivity.this.jMU.bqe();
                }
            });
            this.jMW.setText("");
            rD(false);
            this.jMW.requestFocus();
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    BuyGiftActivity.this.ShowSoftKeyPad((InputMethodManager) BuyGiftActivity.this.getSystemService("input_method"), BuyGiftActivity.this.jMW);
                }
            });
        } else if (i != 0) {
            bc(str, R.string.neterror);
        } else {
            SendGiftSuccessMessage sendGiftSuccessMessage = new SendGiftSuccessMessage(CmdConfigCustom.CMD_GET_GIFT_SUCCEED, Long.valueOf(this.mReceiverId));
            sendGiftSuccessMessage.setGiftInfo(this.mGiftInfo);
            MessageManager.getInstance().dispatchResponsedMessageToUI(sendGiftSuccessMessage);
            bc(str, R.string.send_gift_succeed);
            closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rD(boolean z) {
        if (z) {
            this.jMX.setVisibility(0);
        } else {
            this.jMX.setVisibility(8);
        }
    }

    private void bc(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            if (i > 0) {
                showToast(i);
                return;
            }
            return;
        }
        showToast(str);
    }

    private void cLO() {
        if (this.jMR != null && this.jMR.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.jMR.getGiftInfo().getTypeInfo();
            dL(typeInfo);
            dN(typeInfo);
            K(this.jMR.getGiftInfo().getNumInfo());
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dL(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.aYe.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            dM(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GiftCommonList.TypeInfo typeInfo = list.get(i);
                if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                    TextView textView = (TextView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                    ao.setBackgroundColor(textView, R.color.CAM_X0205);
                    textView.setText(typeInfo.getTypeName());
                    textView.setOnClickListener(new d(i));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setPadding(8, 0, 8, 0);
                    this.aYe.addView(textView, layoutParams);
                }
            }
            cY(0);
        }
    }

    private void dM(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (GiftCommonList.TypeInfo typeInfo : list) {
                if (TextUtils.isEmpty(typeInfo.getTypeName()) || typeInfo.getGiftItems().size() <= 0) {
                    arrayList.add(typeInfo);
                }
            }
            list.removeAll(arrayList);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cY(int i) {
        int childCount = this.aYe.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.aYe.getChildAt(i2);
                if (i2 != i) {
                    ao.setViewTextColor(textView, R.color.gift_tab_textcolor_normal, 1);
                } else {
                    ao.setViewTextColor(textView, R.color.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void dN(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list != null) {
            this.aYz.clear();
            this.aYn.clear();
            this.jMJ.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> dO = dO(list.get(i).getGiftItems());
                int size = dO.size();
                if (size > 0) {
                    if (this.jMS == null) {
                        this.jMS = dO.get(0);
                        rE(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.aYz.append(i, ceil);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        if (i2 == ceil - 1) {
                            if (i2 * 8 == size - 1) {
                                subList = new ArrayList<>();
                                subList.add(dO.get(size - 1));
                            } else {
                                subList = dO.subList(i2 * 8, size);
                            }
                        } else {
                            subList = dO.subList(i2 * 8, (i2 + 1) * 8);
                        }
                        if (i == 0 && i2 == 0) {
                            this.aYn.add(h(subList, this.aYs));
                        } else {
                            this.aYn.add(h(subList, -1));
                        }
                    }
                }
            }
            this.jMQ = new GiftPagerAdapter(this.aYn);
            this.jMJ.setAdapter(this.jMQ);
            Fg();
        }
    }

    private List<GiftCommonList.GiftItem> dO(List<GiftCommonList.GiftItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (GiftCommonList.GiftItem giftItem : list) {
            if (giftItem.getPrice() > 0 && giftItem.getGiftId() > 0) {
                arrayList.add(giftItem);
            }
        }
        return arrayList;
    }

    private GridView h(List<GiftCommonList.GiftItem> list, int i) {
        com.baidu.tieba.gift.buyGift.a aVar = new com.baidu.tieba.gift.buyGift.a(getPageContext().getPageActivity());
        aVar.setGiftItems(list);
        aVar.cL(i);
        GridView gridView = new GridView(getPageContext().getPageActivity());
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setNumColumns(4);
        gridView.setVerticalSpacing(8);
        gridView.setHorizontalSpacing(8);
        gridView.setSelector(R.color.common_color_10022);
        gridView.setAdapter((ListAdapter) aVar);
        gridView.setPadding(4, 0, 4, 0);
        gridView.setOnItemClickListener(new a());
        return gridView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fg() {
        int i = 0;
        for (int i2 = 0; i2 < this.aYz.size(); i2++) {
            for (int i3 = 0; i3 < this.aYz.get(i2); i3++) {
                if (i + i3 == this.aYr) {
                    if (this.aYz.get(i2) <= 1) {
                        this.jMK.setVisibility(4);
                    } else {
                        this.jMK.setVisibility(0);
                    }
                    this.jMK.setCount(this.aYz.get(i2));
                    this.jMK.setPosition(i3);
                    cY(i2);
                    return;
                }
            }
            i += this.aYz.get(i2);
        }
    }

    private void K(List<GiftCommonList.NumInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (GiftCommonList.NumInfo numInfo : list) {
                if (numInfo.getNum() <= 0) {
                    arrayList.add(numInfo);
                }
            }
            list.removeAll(arrayList);
        }
        this.jMP = new com.baidu.tieba.gift.buyGift.b(getPageContext().getPageActivity());
        this.jMO.setAdapter((ListAdapter) this.jMP);
        this.jMP.J(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        getLayoutMode().setNightMode(z);
        getLayoutMode().onModeChanged(this.jMF);
        if (this.jMP != null) {
            this.jMP.notifyDataSetChanged();
        }
        if (z) {
            this.jMK.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on_1));
            this.jMK.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off_1));
            return;
        }
        this.jMK.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on));
        this.jMK.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jMU != null && this.jMU.isShowing()) {
                this.jMW.clearFocus();
                this.jMU.dismiss();
                return true;
            } else if (this.jMN.getVisibility() == 0) {
                this.jMN.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c implements TextWatcher {
        private c() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i = com.baidu.adp.lib.f.b.toInt(editable.toString(), 0);
            if (editable.toString().length() == String.valueOf(i).length()) {
                BuyGiftActivity.this.rE(true);
                return;
            }
            int i2 = i >= 0 ? i : 0;
            BuyGiftActivity.this.jMG.setText("" + i2);
            BuyGiftActivity.this.jMG.setSelection(String.valueOf(i2).length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BuyGiftActivity.this.aYs = BuyGiftActivity.this.aYr;
            BuyGiftActivity.this.mSelectedPosition = i;
            com.baidu.tieba.gift.buyGift.a aVar = (com.baidu.tieba.gift.buyGift.a) adapterView.getAdapter();
            if (aVar != null) {
                GiftCommonList.GiftItem item = aVar.getItem(i);
                if (item != null) {
                    BuyGiftActivity.this.jMS = item;
                }
                aVar.cL(i);
                aVar.notifyDataSetChanged();
            }
            BuyGiftActivity.this.rE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rE(boolean z) {
        int i;
        int i2 = com.baidu.adp.lib.f.b.toInt(this.jMG.getText().toString(), 1);
        if (this.jMS != null) {
            i = this.jMS.getPrice() > 0 ? this.jMS.getPrice() : 1;
        } else {
            i = 1;
        }
        int i3 = i * i2;
        if (z) {
            this.jMH.setText(String.format(getPageContext().getString(R.string.tdou_count_format), at.numFormat(i3)));
            if (i3 <= 0) {
                ao.setBackgroundResource(this.jMI, R.drawable.btn_gift_give_d);
                this.jMI.setEnabled(false);
            } else {
                ao.setBackgroundResource(this.jMI, R.drawable.btn_gift_give_normal);
                this.jMI.setEnabled(true);
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (BuyGiftActivity.this.jMR != null && BuyGiftActivity.this.jMR.getGiftInfo() != null) {
                List<GiftCommonList.NumInfo> numInfo = BuyGiftActivity.this.jMR.getGiftInfo().getNumInfo();
                if (i == numInfo.size()) {
                    BuyGiftActivity.this.rF(true);
                    Selection.selectAll(BuyGiftActivity.this.jMG.getText());
                } else {
                    BuyGiftActivity.this.jMG.setCursorVisible(true);
                    BuyGiftActivity.this.jMG.setFocusable(true);
                    GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                    if (numInfo2 != null) {
                        BuyGiftActivity.this.jMG.setText("" + numInfo2.getNum());
                    }
                }
                BuyGiftActivity.this.jMN.setVisibility(8);
                BuyGiftActivity.this.rE(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rF(boolean z) {
        this.jMG.setCursorVisible(z);
        this.jMG.setFocusable(z);
        this.jMG.setFocusableInTouchMode(z);
        if (z) {
            this.jMG.requestFocus();
        } else {
            this.jMG.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        private int mPosition;

        public d(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.mPosition, BuyGiftActivity.this.aYz.size());
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i++;
                i2 = BuyGiftActivity.this.aYz.get(i) + i2;
            }
            BuyGiftActivity.this.aYr = i2;
            BuyGiftActivity.this.jMJ.setCurrentItem(BuyGiftActivity.this.aYr);
            BuyGiftActivity.this.Fg();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aYr = i;
        Fg();
        if (i >= 0 && i < this.aYn.size()) {
            GridView gridView = (GridView) this.aYn.get(i);
            if (gridView.getAdapter() != null) {
                com.baidu.tieba.gift.buyGift.a aVar = (com.baidu.tieba.gift.buyGift.a) gridView.getAdapter();
                if (aVar.EF() >= 0 && i != this.aYs) {
                    aVar.cL(-1);
                    aVar.notifyDataSetChanged();
                }
                if (aVar.EF() < 0 && i == this.aYs) {
                    aVar.cL(this.mSelectedPosition);
                    aVar.notifyDataSetChanged();
                }
            }
        }
    }
}
