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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
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
    private LinearLayout bbl;
    private int bby;
    private int bbz;
    private String jUA;
    private InputMethodManager jUC;
    private FrameLayout jUf;
    private View jUg;
    private View jUh;
    private EditText jUi;
    private TextView jUj;
    private TextView jUk;
    private BaseViewPager jUl;
    private IndicatorView jUm;
    private View jUn;
    private View jUo;
    private View jUp;
    private ListView jUq;
    private com.baidu.tieba.gift.buyGift.b jUr;
    private GiftPagerAdapter jUs;
    private GiftCommonList jUt;
    private GiftCommonList.GiftItem jUu;
    private com.baidu.tbadk.core.dialog.a jUw;
    private View jUx;
    private EditText jUy;
    private TextView jUz;
    private int mFrom;
    private String mPassword;
    private long mReceiverId;
    private int mSelectedPosition;
    private List<View> bbu = new ArrayList();
    private SparseIntArray bbG = new SparseIntArray();
    private boolean jUv = false;
    private boolean jUB = false;
    private SendGiftSuccessMessage.a mGiftInfo = new SendGiftSuccessMessage.a();
    private final HttpMessageListener jUD = new HttpMessageListener(1001509) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetGiftCommonListHttpResponseMessage) {
                GetGiftCommonListHttpResponseMessage getGiftCommonListHttpResponseMessage = (GetGiftCommonListHttpResponseMessage) httpResponsedMessage;
                BuyGiftActivity.this.jUt = getGiftCommonListHttpResponseMessage.getGiftInfo();
                BuyGiftActivity.this.bD(getGiftCommonListHttpResponseMessage.getError(), getGiftCommonListHttpResponseMessage.getErrorString());
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jUE = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_GIFT_LIST) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof GetGiftCommonListSocketResponseMessage) {
                GetGiftCommonListSocketResponseMessage getGiftCommonListSocketResponseMessage = (GetGiftCommonListSocketResponseMessage) socketResponsedMessage;
                BuyGiftActivity.this.jUt = getGiftCommonListSocketResponseMessage.getGiftInfo();
                BuyGiftActivity.this.bD(getGiftCommonListSocketResponseMessage.getError(), getGiftCommonListSocketResponseMessage.getErrorString());
            }
        }
    };
    private final com.baidu.adp.framework.listener.a jUF = new com.baidu.adp.framework.listener.a(1001510, CmdConfigSocket.CMD_SEND_GIFT) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.9
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof SendGiftSocketResponseMessage) {
                BuyGiftActivity.this.jUk.setEnabled(true);
                SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) responsedMessage;
                BuyGiftActivity.this.a(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
            } else if (responsedMessage instanceof SendGiftHttpResponseMessage) {
                BuyGiftActivity.this.jUk.setEnabled(true);
                SendGiftHttpResponseMessage sendGiftHttpResponseMessage = (SendGiftHttpResponseMessage) responsedMessage;
                BuyGiftActivity.this.a(sendGiftHttpResponseMessage.getError(), sendGiftHttpResponseMessage.getErrorString(), sendGiftHttpResponseMessage.getResponseData());
            }
        }
    };
    private final CustomMessageListener jUG = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BuyGiftActivity.this.jUv = true;
            BuyGiftActivity.this.FR();
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
        if (z && !this.jUB) {
            aCu();
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

    private void aCu() {
        this.jUg.setBackgroundColor(ap.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.jUg.startAnimation(alphaAnimation);
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
                BuyGiftActivity.this.jUh.setVisibility(0);
                BuyGiftActivity.this.cNJ();
            }
        });
        this.jUh.startAnimation(loadAnimation);
        this.jUB = true;
    }

    private void UX() {
        this.jUg.setBackgroundColor(ap.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.jUg.startAnimation(alphaAnimation);
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
        this.jUh.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        UX();
    }

    private void initViews() {
        this.jUf = (FrameLayout) findViewById(R.id.gift_panel_lay);
        this.jUg = findViewById(R.id.empty_layout);
        this.jUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BuyGiftActivity.this.jUp.getVisibility() == 0) {
                    BuyGiftActivity.this.jUp.setVisibility(8);
                } else {
                    BuyGiftActivity.this.closeActivity();
                }
            }
        });
        this.jUh = findViewById(R.id.gift_list_layout);
        this.jUC = (InputMethodManager) getSystemService("input_method");
        this.jUi = (EditText) findViewById(R.id.gift_count_input);
        this.jUi.setSelection(1);
        rQ(false);
        this.jUi.addTextChangedListener(new c());
        this.jUi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jUC, BuyGiftActivity.this.jUi);
                BuyGiftActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BuyGiftActivity.this.rQ(false);
                        BuyGiftActivity.this.jUp.setVisibility(0);
                    }
                }, 200L);
            }
        });
        this.jUi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.15
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    BuyGiftActivity.this.ShowSoftKeyPad(BuyGiftActivity.this.jUC, BuyGiftActivity.this.jUi);
                } else {
                    BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jUC, BuyGiftActivity.this.jUi);
                }
            }
        });
        this.jUj = (TextView) findViewById(R.id.gift_count_result);
        this.jUk = (TextView) findViewById(R.id.gift_button);
        this.jUk.setEnabled(false);
        this.jUk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.FR();
            }
        });
        this.jUn = findViewById(R.id.gift_lower_layout);
        this.jUl = (BaseViewPager) findViewById(R.id.gift_viewpager);
        this.jUl.setOnPageChangeListener(this);
        this.jUm = (IndicatorView) findViewById(R.id.gift_tab_indicator);
        this.bbl = (LinearLayout) findViewById(R.id.gift_tab_layout);
        this.jUo = findViewById(R.id.gift_progress_layout);
        this.jUp = findViewById(R.id.gift_num_layout);
        this.jUp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyGiftActivity.this.jUp.setVisibility(8);
            }
        });
        this.jUq = (ListView) findViewById(R.id.gift_num_list);
        this.jUq.setOnItemClickListener(new b());
        this.jUw = new com.baidu.tbadk.core.dialog.a(getActivity());
        this.jUx = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_tdou_pay_pwd, (ViewGroup) null);
        this.jUy = (EditText) this.jUx.findViewById(R.id.password_dialog_input);
        this.jUz = (TextView) this.jUx.findViewById(R.id.password_dialog_warning);
        this.jUw.bn(this.jUx);
        this.jUw.jG(false);
        this.jUw.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                BuyGiftActivity.this.mPassword = "";
                BuyGiftActivity.this.jUy.clearFocus();
                BuyGiftActivity.this.HidenSoftKeyPad(BuyGiftActivity.this.jUC, BuyGiftActivity.this.jUy);
                BuyGiftActivity.this.jUw.dismiss();
            }
        });
        this.jUw.a(getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                BuyGiftActivity.this.rO(false);
                BuyGiftActivity.this.mPassword = BuyGiftActivity.this.jUy.getText().toString();
                if (StringUtils.isValidPassWord(BuyGiftActivity.this.mPassword)) {
                    if (!StringUtils.isNull(BuyGiftActivity.this.jUA)) {
                        try {
                            com.baidu.ueg.encrypt.a a2 = com.baidu.ueg.encrypt.b.a(new com.baidu.ueg.encrypt.entity.a(EncryptAlgorithm.RSA, BuyGiftActivity.this.jUA));
                            BuyGiftActivity.this.mPassword = a2.encrypt(BuyGiftActivity.this.mPassword);
                        } catch (Exception e) {
                            BuyGiftActivity.this.mPassword = "";
                            e.printStackTrace();
                        }
                    }
                    BuyGiftActivity.this.FR();
                    BuyGiftActivity.this.jUy.setText("");
                    return;
                }
                BuyGiftActivity.this.rO(true);
            }
        });
        this.jUw.b(getPageContext());
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
        registerListener(this.jUD);
        registerListener(this.jUE);
        registerListener(this.jUF);
        registerListener(this.jUG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNJ() {
        this.jUo.setVisibility(0);
        this.jUn.setVisibility(8);
        this.jUp.setVisibility(8);
        rQ(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.jUi);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, String str) {
        if (i != 0 || this.jUt == null || this.jUt.getGiftInfo() == null || this.jUt.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.jUk.setEnabled(true);
        this.jUo.setVisibility(8);
        this.jUn.setVisibility(0);
        cNL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR() {
        if (this.jUu != null && this.mReceiverId > 0) {
            if (this.jUw != null && this.jUw.isShowing()) {
                this.jUw.setYesBtnClickable(false);
                this.jUw.setNoBtnClickable(false);
            }
            this.jUk.setEnabled(false);
            this.jUo.setVisibility(0);
            RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
            int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(this.jUi.getText()), 1);
            requestSendGiftNetMessage.setParams(this.mReceiverId, this.jUu.getGiftId(), this.jUu.getPrice(), i, cNK(), this.mPassword);
            this.mGiftInfo.setCount(i);
            this.mGiftInfo.setName(this.jUu.getName());
            this.mGiftInfo.setUrl(this.jUu.getThumbnailUrl());
            this.mGiftInfo.setId(this.jUu.getGiftId());
            this.mGiftInfo.AH(TbadkCoreApplication.getCurrentAccountName());
            sendMessage(requestSendGiftNetMessage);
        }
    }

    public int cNK() {
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
        if (this.jUw != null && this.jUw.isShowing()) {
            this.jUw.setYesBtnClickable(true);
            this.jUw.setNoBtnClickable(true);
        }
        this.jUo.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.jUv) {
            int rP = rP(false);
            int intValue = (sendGiftAndroidResIdl == null || sendGiftAndroidResIdl.data == null || sendGiftAndroidResIdl.data.money == null) ? 0 : rP - sendGiftAndroidResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(R.string.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), rP)));
            if (this.jUC != null) {
                HidenSoftKeyPad(this.jUC, this.jUi);
            }
            if (this.jUw != null && this.jUw.isShowing()) {
                this.jUw.dismiss();
            }
        } else if (i == 1990028) {
            rO(true);
        } else if (i == 1990019) {
            bc(str, 0);
            cNJ();
        } else if (i == 1990027) {
            if (sendGiftAndroidResIdl != null && sendGiftAndroidResIdl.data != null && sendGiftAndroidResIdl.data.public_key != null) {
                this.jUA = sendGiftAndroidResIdl.data.public_key;
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    BuyGiftActivity.this.jUw.bqx();
                }
            });
            this.jUy.setText("");
            rO(false);
            this.jUy.requestFocus();
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.gift.buyGift.BuyGiftActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    BuyGiftActivity.this.ShowSoftKeyPad((InputMethodManager) BuyGiftActivity.this.getSystemService("input_method"), BuyGiftActivity.this.jUy);
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
    public void rO(boolean z) {
        if (z) {
            this.jUz.setVisibility(0);
        } else {
            this.jUz.setVisibility(8);
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

    private void cNL() {
        if (this.jUt != null && this.jUt.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.jUt.getGiftInfo().getTypeInfo();
            dI(typeInfo);
            dK(typeInfo);
            K(this.jUt.getGiftInfo().getNumInfo());
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dI(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.bbl.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            dJ(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GiftCommonList.TypeInfo typeInfo = list.get(i);
                if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                    TextView textView = (TextView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                    ap.setBackgroundColor(textView, R.color.CAM_X0205);
                    textView.setText(typeInfo.getTypeName());
                    textView.setOnClickListener(new d(i));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setPadding(8, 0, 8, 0);
                    this.bbl.addView(textView, layoutParams);
                }
            }
            dd(0);
        }
    }

    private void dJ(List<GiftCommonList.TypeInfo> list) {
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
    private void dd(int i) {
        int childCount = this.bbl.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.bbl.getChildAt(i2);
                if (i2 != i) {
                    ap.setViewTextColor(textView, R.color.gift_tab_textcolor_normal, 1);
                } else {
                    ap.setViewTextColor(textView, R.color.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void dK(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list != null) {
            this.bbG.clear();
            this.bbu.clear();
            this.jUl.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> dL = dL(list.get(i).getGiftItems());
                int size = dL.size();
                if (size > 0) {
                    if (this.jUu == null) {
                        this.jUu = dL.get(0);
                        rP(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.bbG.append(i, ceil);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        if (i2 == ceil - 1) {
                            if (i2 * 8 == size - 1) {
                                subList = new ArrayList<>();
                                subList.add(dL.get(size - 1));
                            } else {
                                subList = dL.subList(i2 * 8, size);
                            }
                        } else {
                            subList = dL.subList(i2 * 8, (i2 + 1) * 8);
                        }
                        if (i == 0 && i2 == 0) {
                            this.bbu.add(h(subList, this.bbz));
                        } else {
                            this.bbu.add(h(subList, -1));
                        }
                    }
                }
            }
            this.jUs = new GiftPagerAdapter(this.bbu);
            this.jUl.setAdapter(this.jUs);
            Gw();
        }
    }

    private List<GiftCommonList.GiftItem> dL(List<GiftCommonList.GiftItem> list) {
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
        aVar.cQ(i);
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
    public void Gw() {
        int i = 0;
        for (int i2 = 0; i2 < this.bbG.size(); i2++) {
            for (int i3 = 0; i3 < this.bbG.get(i2); i3++) {
                if (i + i3 == this.bby) {
                    if (this.bbG.get(i2) <= 1) {
                        this.jUm.setVisibility(4);
                    } else {
                        this.jUm.setVisibility(0);
                    }
                    this.jUm.setCount(this.bbG.get(i2));
                    this.jUm.setPosition(i3);
                    dd(i2);
                    return;
                }
            }
            i += this.bbG.get(i2);
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
        this.jUr = new com.baidu.tieba.gift.buyGift.b(getPageContext().getPageActivity());
        this.jUq.setAdapter((ListAdapter) this.jUr);
        this.jUr.J(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        getLayoutMode().setNightMode(z);
        getLayoutMode().onModeChanged(this.jUh);
        if (this.jUr != null) {
            this.jUr.notifyDataSetChanged();
        }
        if (z) {
            this.jUm.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on_1));
            this.jUm.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off_1));
            return;
        }
        this.jUm.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on));
        this.jUm.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jUw != null && this.jUw.isShowing()) {
                this.jUy.clearFocus();
                this.jUw.dismiss();
                return true;
            } else if (this.jUp.getVisibility() == 0) {
                this.jUp.setVisibility(8);
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
                BuyGiftActivity.this.rP(true);
                return;
            }
            int i2 = i >= 0 ? i : 0;
            BuyGiftActivity.this.jUi.setText("" + i2);
            BuyGiftActivity.this.jUi.setSelection(String.valueOf(i2).length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BuyGiftActivity.this.bbz = BuyGiftActivity.this.bby;
            BuyGiftActivity.this.mSelectedPosition = i;
            com.baidu.tieba.gift.buyGift.a aVar = (com.baidu.tieba.gift.buyGift.a) adapterView.getAdapter();
            if (aVar != null) {
                GiftCommonList.GiftItem item = aVar.getItem(i);
                if (item != null) {
                    BuyGiftActivity.this.jUu = item;
                }
                aVar.cQ(i);
                aVar.notifyDataSetChanged();
            }
            BuyGiftActivity.this.rP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rP(boolean z) {
        int i;
        int i2 = com.baidu.adp.lib.f.b.toInt(this.jUi.getText().toString(), 1);
        if (this.jUu != null) {
            i = this.jUu.getPrice() > 0 ? this.jUu.getPrice() : 1;
        } else {
            i = 1;
        }
        int i3 = i * i2;
        if (z) {
            this.jUj.setText(String.format(getPageContext().getString(R.string.tdou_count_format), au.numFormat(i3)));
            if (i3 <= 0) {
                ap.setBackgroundResource(this.jUk, R.drawable.btn_gift_give_d);
                this.jUk.setEnabled(false);
            } else {
                ap.setBackgroundResource(this.jUk, R.drawable.btn_gift_give_normal);
                this.jUk.setEnabled(true);
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
            if (BuyGiftActivity.this.jUt != null && BuyGiftActivity.this.jUt.getGiftInfo() != null) {
                List<GiftCommonList.NumInfo> numInfo = BuyGiftActivity.this.jUt.getGiftInfo().getNumInfo();
                if (i == numInfo.size()) {
                    BuyGiftActivity.this.rQ(true);
                    Selection.selectAll(BuyGiftActivity.this.jUi.getText());
                } else {
                    BuyGiftActivity.this.jUi.setCursorVisible(true);
                    BuyGiftActivity.this.jUi.setFocusable(true);
                    GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                    if (numInfo2 != null) {
                        BuyGiftActivity.this.jUi.setText("" + numInfo2.getNum());
                    }
                }
                BuyGiftActivity.this.jUp.setVisibility(8);
                BuyGiftActivity.this.rP(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(boolean z) {
        this.jUi.setCursorVisible(z);
        this.jUi.setFocusable(z);
        this.jUi.setFocusableInTouchMode(z);
        if (z) {
            this.jUi.requestFocus();
        } else {
            this.jUi.clearFocus();
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
            int min = Math.min(this.mPosition, BuyGiftActivity.this.bbG.size());
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i++;
                i2 = BuyGiftActivity.this.bbG.get(i) + i2;
            }
            BuyGiftActivity.this.bby = i2;
            BuyGiftActivity.this.jUl.setCurrentItem(BuyGiftActivity.this.bby);
            BuyGiftActivity.this.Gw();
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
        this.bby = i;
        Gw();
        if (i >= 0 && i < this.bbu.size()) {
            GridView gridView = (GridView) this.bbu.get(i);
            if (gridView.getAdapter() != null) {
                com.baidu.tieba.gift.buyGift.a aVar = (com.baidu.tieba.gift.buyGift.a) gridView.getAdapter();
                if (aVar.FV() >= 0 && i != this.bbz) {
                    aVar.cQ(-1);
                    aVar.notifyDataSetChanged();
                }
                if (aVar.FV() < 0 && i == this.bbz) {
                    aVar.cQ(this.mSelectedPosition);
                    aVar.notifyDataSetChanged();
                }
            }
        }
    }
}
