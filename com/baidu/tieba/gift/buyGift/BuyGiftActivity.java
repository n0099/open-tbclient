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
/* loaded from: classes9.dex */
public class BuyGiftActivity extends BaseActivity<BuyGiftActivity> implements ViewPager.OnPageChangeListener {
    private LinearLayout bcS;
    private int bdf;
    private int bdg;
    private View jRA;
    private EditText jRB;
    private TextView jRC;
    private String jRD;
    private InputMethodManager jRF;
    private FrameLayout jRi;
    private View jRj;
    private View jRk;
    private EditText jRl;
    private TextView jRm;
    private TextView jRn;
    private BaseViewPager jRo;
    private IndicatorView jRp;
    private View jRq;
    private View jRr;
    private View jRs;
    private ListView jRt;
    private com.baidu.tieba.gift.buyGift.b jRu;
    private GiftPagerAdapter jRv;
    private GiftCommonList jRw;
    private GiftCommonList.GiftItem jRx;
    private com.baidu.tbadk.core.dialog.a jRz;
    private int mFrom;
    private String mPassword;
    private long mReceiverId;
    private int mSelectedPosition;
    private List<View> bdb = new ArrayList();
    private SparseIntArray bdn = new SparseIntArray();
    private boolean jRy = false;
    private boolean jRE = false;
    private SendGiftSuccessMessage.a mGiftInfo = new SendGiftSuccessMessage.a();
    private final HttpMessageListener jRG = new HttpMessageListener(1001509) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetGiftCommonListHttpResponseMessage) {
                GetGiftCommonListHttpResponseMessage getGiftCommonListHttpResponseMessage = (GetGiftCommonListHttpResponseMessage) httpResponsedMessage;
                BuyGiftActivity.this.jRw = getGiftCommonListHttpResponseMessage.getGiftInfo();
                BuyGiftActivity.this.bw(getGiftCommonListHttpResponseMessage.getError(), getGiftCommonListHttpResponseMessage.getErrorString());
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jRH = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_GIFT_LIST) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof GetGiftCommonListSocketResponseMessage) {
                GetGiftCommonListSocketResponseMessage getGiftCommonListSocketResponseMessage = (GetGiftCommonListSocketResponseMessage) socketResponsedMessage;
                BuyGiftActivity.this.jRw = getGiftCommonListSocketResponseMessage.getGiftInfo();
                BuyGiftActivity.this.bw(getGiftCommonListSocketResponseMessage.getError(), getGiftCommonListSocketResponseMessage.getErrorString());
            }
        }
    };
    private final com.baidu.adp.framework.listener.a jRI = new com.baidu.adp.framework.listener.a(1001510, CmdConfigSocket.CMD_SEND_GIFT) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.9
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof SendGiftSocketResponseMessage) {
                BuyGiftActivity.this.jRn.setEnabled(true);
                SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) responsedMessage;
                BuyGiftActivity.this.a(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
            } else if (responsedMessage instanceof SendGiftHttpResponseMessage) {
                BuyGiftActivity.this.jRn.setEnabled(true);
                SendGiftHttpResponseMessage sendGiftHttpResponseMessage = (SendGiftHttpResponseMessage) responsedMessage;
                BuyGiftActivity.this.a(sendGiftHttpResponseMessage.getError(), sendGiftHttpResponseMessage.getErrorString(), sendGiftHttpResponseMessage.getResponseData());
            }
        }
    };
    private final CustomMessageListener jRJ = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BuyGiftActivity.this.jRy = true;
            BuyGiftActivity.this.Iw();
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
        if (z && !this.jRE) {
            aFR();
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

    private void aFR() {
        this.jRj.setBackgroundColor(ao.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.jRj.startAnimation(alphaAnimation);
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
                BuyGiftActivity.this.jRk.setVisibility(0);
                BuyGiftActivity.this.cPE();
            }
        });
        this.jRk.startAnimation(loadAnimation);
        this.jRE = true;
    }

    private void Xj() {
        this.jRj.setBackgroundColor(ao.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.jRj.startAnimation(alphaAnimation);
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
        this.jRk.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Xj();
    }

    private void initViews() {
        this.jRi = (FrameLayout) findViewById(R.id.gift_panel_lay);
        this.jRj = findViewById(R.id.empty_layout);
        this.jRj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BuyGiftActivity.this.jRs.getVisibility() == 0) {
                    BuyGiftActivity.this.jRs.setVisibility(8);
                } else {
                    BuyGiftActivity.this.closeActivity();
                }
            }
        });
        this.jRk = findViewById(R.id.gift_list_layout);
        this.jRF = (InputMethodManager) getSystemService("input_method");
        this.jRl = (EditText) findViewById(R.id.gift_count_input);
        this.jRl.setSelection(1);
        rJ(false);
        this.jRl.addTextChangedListener(new c());
        this.jRl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jRF, BuyGiftActivity.this.jRl);
                BuyGiftActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BuyGiftActivity.this.rJ(false);
                        BuyGiftActivity.this.jRs.setVisibility(0);
                    }
                }, 200L);
            }
        });
        this.jRl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.15
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    BuyGiftActivity.this.ShowSoftKeyPad(BuyGiftActivity.this.jRF, BuyGiftActivity.this.jRl);
                } else {
                    BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jRF, BuyGiftActivity.this.jRl);
                }
            }
        });
        this.jRm = (TextView) findViewById(R.id.gift_count_result);
        this.jRn = (TextView) findViewById(R.id.gift_button);
        this.jRn.setEnabled(false);
        this.jRn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.Iw();
            }
        });
        this.jRq = findViewById(R.id.gift_lower_layout);
        this.jRo = (BaseViewPager) findViewById(R.id.gift_viewpager);
        this.jRo.setOnPageChangeListener(this);
        this.jRp = (IndicatorView) findViewById(R.id.gift_tab_indicator);
        this.bcS = (LinearLayout) findViewById(R.id.gift_tab_layout);
        this.jRr = findViewById(R.id.gift_progress_layout);
        this.jRs = findViewById(R.id.gift_num_layout);
        this.jRs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.jRs.setVisibility(8);
            }
        });
        this.jRt = (ListView) findViewById(R.id.gift_num_list);
        this.jRt.setOnItemClickListener(new b());
        this.jRz = new com.baidu.tbadk.core.dialog.a(getActivity());
        this.jRA = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_tdou_pay_pwd, (ViewGroup) null);
        this.jRB = (EditText) this.jRA.findViewById(R.id.password_dialog_input);
        this.jRC = (TextView) this.jRA.findViewById(R.id.password_dialog_warning);
        this.jRz.br(this.jRA);
        this.jRz.jI(false);
        this.jRz.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                BuyGiftActivity.this.mPassword = "";
                BuyGiftActivity.this.jRB.clearFocus();
                BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jRF, BuyGiftActivity.this.jRB);
                BuyGiftActivity.this.jRz.dismiss();
            }
        });
        this.jRz.a(getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                BuyGiftActivity.this.rH(false);
                BuyGiftActivity.this.mPassword = BuyGiftActivity.this.jRB.getText().toString();
                if (StringUtils.isValidPassWord(BuyGiftActivity.this.mPassword)) {
                    if (!StringUtils.isNull(BuyGiftActivity.this.jRD)) {
                        try {
                            com.baidu.ueg.encrypt.a a2 = com.baidu.ueg.encrypt.b.a(new com.baidu.ueg.encrypt.entity.a(EncryptAlgorithm.RSA, BuyGiftActivity.this.jRD));
                            BuyGiftActivity.this.mPassword = a2.encrypt(BuyGiftActivity.this.mPassword);
                        } catch (Exception e) {
                            BuyGiftActivity.this.mPassword = "";
                            e.printStackTrace();
                        }
                    }
                    BuyGiftActivity.this.Iw();
                    BuyGiftActivity.this.jRB.setText("");
                    return;
                }
                BuyGiftActivity.this.rH(true);
            }
        });
        this.jRz.b(getPageContext());
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
        registerListener(this.jRG);
        registerListener(this.jRH);
        registerListener(this.jRI);
        registerListener(this.jRJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPE() {
        this.jRr.setVisibility(0);
        this.jRq.setVisibility(8);
        this.jRs.setVisibility(8);
        rJ(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.jRl);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(int i, String str) {
        if (i != 0 || this.jRw == null || this.jRw.getGiftInfo() == null || this.jRw.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.jRn.setEnabled(true);
        this.jRr.setVisibility(8);
        this.jRq.setVisibility(0);
        cPG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iw() {
        if (this.jRx != null && this.mReceiverId > 0) {
            if (this.jRz != null && this.jRz.isShowing()) {
                this.jRz.setYesBtnClickable(false);
                this.jRz.setNoBtnClickable(false);
            }
            this.jRn.setEnabled(false);
            this.jRr.setVisibility(0);
            RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
            int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(this.jRl.getText()), 1);
            requestSendGiftNetMessage.setParams(this.mReceiverId, this.jRx.getGiftId(), this.jRx.getPrice(), i, cPF(), this.mPassword);
            this.mGiftInfo.setCount(i);
            this.mGiftInfo.setName(this.jRx.getName());
            this.mGiftInfo.setUrl(this.jRx.getThumbnailUrl());
            this.mGiftInfo.setId(this.jRx.getGiftId());
            this.mGiftInfo.BB(TbadkCoreApplication.getCurrentAccountName());
            sendMessage(requestSendGiftNetMessage);
        }
    }

    public int cPF() {
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
        if (this.jRz != null && this.jRz.isShowing()) {
            this.jRz.setYesBtnClickable(true);
            this.jRz.setNoBtnClickable(true);
        }
        this.jRr.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.jRy) {
            int rI = rI(false);
            int intValue = (sendGiftAndroidResIdl == null || sendGiftAndroidResIdl.data == null || sendGiftAndroidResIdl.data.money == null) ? 0 : rI - sendGiftAndroidResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(R.string.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), rI)));
            if (this.jRF != null) {
                HidenSoftKeyPad(this.jRF, this.jRl);
            }
            if (this.jRz != null && this.jRz.isShowing()) {
                this.jRz.dismiss();
            }
        } else if (i == 1990028) {
            rH(true);
        } else if (i == 1990019) {
            bb(str, 0);
            cPE();
        } else if (i == 1990027) {
            if (sendGiftAndroidResIdl != null && sendGiftAndroidResIdl.data != null && sendGiftAndroidResIdl.data.public_key != null) {
                this.jRD = sendGiftAndroidResIdl.data.public_key;
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    BuyGiftActivity.this.jRz.btY();
                }
            });
            this.jRB.setText("");
            rH(false);
            this.jRB.requestFocus();
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    BuyGiftActivity.this.ShowSoftKeyPad((InputMethodManager) BuyGiftActivity.this.getSystemService("input_method"), BuyGiftActivity.this.jRB);
                }
            });
        } else if (i != 0) {
            bb(str, R.string.neterror);
        } else {
            SendGiftSuccessMessage sendGiftSuccessMessage = new SendGiftSuccessMessage(CmdConfigCustom.CMD_GET_GIFT_SUCCEED, Long.valueOf(this.mReceiverId));
            sendGiftSuccessMessage.setGiftInfo(this.mGiftInfo);
            MessageManager.getInstance().dispatchResponsedMessageToUI(sendGiftSuccessMessage);
            bb(str, R.string.send_gift_succeed);
            closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH(boolean z) {
        if (z) {
            this.jRC.setVisibility(0);
        } else {
            this.jRC.setVisibility(8);
        }
    }

    private void bb(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            if (i > 0) {
                showToast(i);
                return;
            }
            return;
        }
        showToast(str);
    }

    private void cPG() {
        if (this.jRw != null && this.jRw.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.jRw.getGiftInfo().getTypeInfo();
            dL(typeInfo);
            dN(typeInfo);
            K(this.jRw.getGiftInfo().getNumInfo());
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dL(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.bcS.removeAllViews();
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
                    this.bcS.addView(textView, layoutParams);
                }
            }
            eE(0);
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
    private void eE(int i) {
        int childCount = this.bcS.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.bcS.getChildAt(i2);
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
            this.bdn.clear();
            this.bdb.clear();
            this.jRo.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> dO = dO(list.get(i).getGiftItems());
                int size = dO.size();
                if (size > 0) {
                    if (this.jRx == null) {
                        this.jRx = dO.get(0);
                        rI(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.bdn.append(i, ceil);
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
                            this.bdb.add(h(subList, this.bdg));
                        } else {
                            this.bdb.add(h(subList, -1));
                        }
                    }
                }
            }
            this.jRv = new GiftPagerAdapter(this.bdb);
            this.jRo.setAdapter(this.jRv);
            Jb();
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
        aVar.er(i);
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
    public void Jb() {
        int i = 0;
        for (int i2 = 0; i2 < this.bdn.size(); i2++) {
            for (int i3 = 0; i3 < this.bdn.get(i2); i3++) {
                if (i + i3 == this.bdf) {
                    if (this.bdn.get(i2) <= 1) {
                        this.jRp.setVisibility(4);
                    } else {
                        this.jRp.setVisibility(0);
                    }
                    this.jRp.setCount(this.bdn.get(i2));
                    this.jRp.setPosition(i3);
                    eE(i2);
                    return;
                }
            }
            i += this.bdn.get(i2);
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
        this.jRu = new com.baidu.tieba.gift.buyGift.b(getPageContext().getPageActivity());
        this.jRt.setAdapter((ListAdapter) this.jRu);
        this.jRu.J(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        getLayoutMode().setNightMode(z);
        getLayoutMode().onModeChanged(this.jRk);
        if (this.jRu != null) {
            this.jRu.notifyDataSetChanged();
        }
        if (z) {
            this.jRp.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on_1));
            this.jRp.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off_1));
            return;
        }
        this.jRp.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on));
        this.jRp.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jRz != null && this.jRz.isShowing()) {
                this.jRB.clearFocus();
                this.jRz.dismiss();
                return true;
            } else if (this.jRs.getVisibility() == 0) {
                this.jRs.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
                BuyGiftActivity.this.rI(true);
                return;
            }
            int i2 = i >= 0 ? i : 0;
            BuyGiftActivity.this.jRl.setText("" + i2);
            BuyGiftActivity.this.jRl.setSelection(String.valueOf(i2).length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BuyGiftActivity.this.bdg = BuyGiftActivity.this.bdf;
            BuyGiftActivity.this.mSelectedPosition = i;
            com.baidu.tieba.gift.buyGift.a aVar = (com.baidu.tieba.gift.buyGift.a) adapterView.getAdapter();
            if (aVar != null) {
                GiftCommonList.GiftItem item = aVar.getItem(i);
                if (item != null) {
                    BuyGiftActivity.this.jRx = item;
                }
                aVar.er(i);
                aVar.notifyDataSetChanged();
            }
            BuyGiftActivity.this.rI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rI(boolean z) {
        int i;
        int i2 = com.baidu.adp.lib.f.b.toInt(this.jRl.getText().toString(), 1);
        if (this.jRx != null) {
            i = this.jRx.getPrice() > 0 ? this.jRx.getPrice() : 1;
        } else {
            i = 1;
        }
        int i3 = i * i2;
        if (z) {
            this.jRm.setText(String.format(getPageContext().getString(R.string.tdou_count_format), at.numFormat(i3)));
            if (i3 <= 0) {
                ao.setBackgroundResource(this.jRn, R.drawable.btn_gift_give_d);
                this.jRn.setEnabled(false);
            } else {
                ao.setBackgroundResource(this.jRn, R.drawable.btn_gift_give_normal);
                this.jRn.setEnabled(true);
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (BuyGiftActivity.this.jRw != null && BuyGiftActivity.this.jRw.getGiftInfo() != null) {
                List<GiftCommonList.NumInfo> numInfo = BuyGiftActivity.this.jRw.getGiftInfo().getNumInfo();
                if (i == numInfo.size()) {
                    BuyGiftActivity.this.rJ(true);
                    Selection.selectAll(BuyGiftActivity.this.jRl.getText());
                } else {
                    BuyGiftActivity.this.jRl.setCursorVisible(true);
                    BuyGiftActivity.this.jRl.setFocusable(true);
                    GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                    if (numInfo2 != null) {
                        BuyGiftActivity.this.jRl.setText("" + numInfo2.getNum());
                    }
                }
                BuyGiftActivity.this.jRs.setVisibility(8);
                BuyGiftActivity.this.rI(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(boolean z) {
        this.jRl.setCursorVisible(z);
        this.jRl.setFocusable(z);
        this.jRl.setFocusableInTouchMode(z);
        if (z) {
            this.jRl.requestFocus();
        } else {
            this.jRl.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        private int mPosition;

        public d(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.mPosition, BuyGiftActivity.this.bdn.size());
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i++;
                i2 = BuyGiftActivity.this.bdn.get(i) + i2;
            }
            BuyGiftActivity.this.bdf = i2;
            BuyGiftActivity.this.jRo.setCurrentItem(BuyGiftActivity.this.bdf);
            BuyGiftActivity.this.Jb();
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
        this.bdf = i;
        Jb();
        if (i >= 0 && i < this.bdb.size()) {
            GridView gridView = (GridView) this.bdb.get(i);
            if (gridView.getAdapter() != null) {
                com.baidu.tieba.gift.buyGift.a aVar = (com.baidu.tieba.gift.buyGift.a) gridView.getAdapter();
                if (aVar.IA() >= 0 && i != this.bdg) {
                    aVar.er(-1);
                    aVar.notifyDataSetChanged();
                }
                if (aVar.IA() < 0 && i == this.bdg) {
                    aVar.er(this.mSelectedPosition);
                    aVar.notifyDataSetChanged();
                }
            }
        }
    }
}
