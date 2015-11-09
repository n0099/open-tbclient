package com.baidu.tieba.gift.buyGift;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyGiftActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.SendGiftSuccessMessage;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes.dex */
public class BuyGiftActivity extends BaseActivity<BuyGiftActivity> implements ViewPager.OnPageChangeListener {
    private int baQ;
    private FrameLayout bmA;
    private View bmB;
    private View bmC;
    private EditText bmD;
    private TextView bmE;
    private TextView bmF;
    private BaseViewPager bmG;
    private IndicatorView bmH;
    private LinearLayout bmI;
    private View bmJ;
    private View bmK;
    private View bmL;
    private ListView bmM;
    private r bmO;
    private s bmP;
    private GiftCommonList bmQ;
    private int bmR;
    private int bmS;
    private GiftCommonList.GiftItem bmT;
    private com.baidu.tbadk.core.dialog.a bmW;
    private View bmX;
    private EditText bmY;
    private TextView bmZ;
    private InputMethodManager bnb;
    private int mFrom;
    private String mPassword;
    private String mPublicKey;
    private long mReceiverId;
    private List<View> bmN = new ArrayList();
    private SparseIntArray bmU = new SparseIntArray();
    private boolean bmV = false;
    private boolean bna = false;
    private SendGiftSuccessMessage.a mGiftInfo = new SendGiftSuccessMessage.a();
    private final HttpMessageListener bnc = new com.baidu.tieba.gift.buyGift.a(this, CmdConfigHttp.GET_GIFT_LIST);
    private final com.baidu.adp.framework.listener.e bnd = new h(this, 308001);
    private final com.baidu.adp.framework.listener.a bne = new i(this, CmdConfigHttp.SEND_GIFT, 308007);
    private final CustomMessageListener bnf = new j(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(i.g.activity_buy_gift);
        FZ();
        initData();
        this.mFrom = getIntent().getIntExtra("from", 1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bna) {
            QE();
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

    private void QE() {
        this.bmB.setBackgroundColor(an.getColor(i.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.bmB.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new k(this));
        this.bmC.startAnimation(loadAnimation);
        this.bna = true;
    }

    private void QF() {
        this.bmB.setBackgroundColor(an.getColor(i.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.bmB.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new l(this));
        this.bmC.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        QF();
    }

    private void FZ() {
        this.bmA = (FrameLayout) findViewById(i.f.gift_panel_lay);
        this.bmB = findViewById(i.f.empty_layout);
        this.bmB.setOnClickListener(new m(this));
        this.bmC = findViewById(i.f.gift_list_layout);
        this.bnb = (InputMethodManager) getSystemService("input_method");
        this.bmD = (EditText) findViewById(i.f.gift_count_input);
        this.bmD.setSelection(1);
        cB(false);
        this.bmD.addTextChangedListener(new c(this, null));
        this.bmD.setOnClickListener(new n(this));
        this.bmD.setOnFocusChangeListener(new p(this));
        this.bmE = (TextView) findViewById(i.f.gift_count_result);
        this.bmF = (TextView) findViewById(i.f.gift_button);
        this.bmF.setEnabled(false);
        this.bmF.setOnClickListener(new com.baidu.tieba.gift.buyGift.b(this));
        this.bmJ = findViewById(i.f.gift_lower_layout);
        this.bmG = (BaseViewPager) findViewById(i.f.gift_viewpager);
        this.bmG.setOnPageChangeListener(this);
        this.bmH = (IndicatorView) findViewById(i.f.gift_tab_indicator);
        this.bmI = (LinearLayout) findViewById(i.f.gift_tab_layout);
        this.bmK = findViewById(i.f.gift_progress_layout);
        this.bmL = findViewById(i.f.gift_num_layout);
        this.bmL.setOnClickListener(new com.baidu.tieba.gift.buyGift.c(this));
        this.bmM = (ListView) findViewById(i.f.gift_num_list);
        this.bmM.setOnItemClickListener(new b(this, null));
        this.bmW = new com.baidu.tbadk.core.dialog.a(getActivity());
        this.bmX = LayoutInflater.from(getActivity()).inflate(i.g.dialog_tdou_pay_pwd, (ViewGroup) null);
        this.bmY = (EditText) this.bmX.findViewById(i.f.password_dialog_input);
        this.bmZ = (TextView) this.bmX.findViewById(i.f.password_dialog_warning);
        this.bmW.m(this.bmX);
        this.bmW.ak(false);
        this.bmW.b(getPageContext().getString(i.h.cancel), new com.baidu.tieba.gift.buyGift.d(this));
        this.bmW.a(getPageContext().getString(i.h.confirm), new e(this));
        this.bmW.b(getPageContext());
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra(BuyGiftActivityConfig.GIFT_RECEIVER_ID, 0L);
        }
        BP();
        registerListener();
    }

    private void BP() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_GIFT_LIST, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GIFT_COMMONLIST + "?cmd=308001");
        tbHttpMessageTask.setResponsedClass(GetGiftCommonListHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(308001);
        bVar.setResponsedClass(GetGiftCommonListSocketResponseMessage.class);
        bVar.i(true);
        bVar.j(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.SEND_GIFT, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEND_GIFT + "?cmd=308007");
        tbHttpMessageTask2.setResponsedClass(SendGiftHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask2);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(308007);
        bVar2.setResponsedClass(SendGiftSocketResponseMessage.class);
        bVar2.i(true);
        bVar2.j(false);
        bVar2.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar2);
    }

    private void registerListener() {
        registerListener(this.bnc);
        registerListener(this.bnd);
        registerListener(this.bne);
        registerListener(this.bnf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QG() {
        this.bmK.setVisibility(0);
        this.bmJ.setVisibility(8);
        this.bmL.setVisibility(8);
        cB(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.bmD);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i, String str) {
        if (i != 0 || this.bmQ == null || this.bmQ.getGiftInfo() == null || this.bmQ.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(i.h.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.bmF.setEnabled(true);
        this.bmK.setVisibility(8);
        this.bmJ.setVisibility(0);
        QJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QH() {
        if (this.bmT != null && this.mReceiverId > 0) {
            if (this.bmW != null && this.bmW.isShowing()) {
                this.bmW.am(false);
                this.bmW.an(false);
            }
            this.bmF.setEnabled(false);
            this.bmK.setVisibility(0);
            RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
            int g = com.baidu.adp.lib.g.b.g(String.valueOf(this.bmD.getText()), 1);
            requestSendGiftNetMessage.setParams(this.mReceiverId, this.bmT.getGiftId(), this.bmT.getPrice(), g, QI(), this.mPassword);
            this.mGiftInfo.setCount(g);
            this.mGiftInfo.setName(this.bmT.getName());
            this.mGiftInfo.setUrl(this.bmT.getThumbnailUrl());
            this.mGiftInfo.setId(this.bmT.getGiftId());
            this.mGiftInfo.cx(TbadkCoreApplication.getCurrentAccountName());
            sendMessage(requestSendGiftNetMessage);
        }
    }

    public int QI() {
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
        if (this.bmW != null && this.bmW.isShowing()) {
            this.bmW.am(true);
            this.bmW.an(true);
        }
        this.bmK.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.bmV) {
            int cA = cA(false);
            int intValue = (sendGiftAndroidResIdl == null || sendGiftAndroidResIdl.data == null || sendGiftAndroidResIdl.data.money == null) ? 0 : cA - sendGiftAndroidResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(i.h.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), cA)));
            if (this.bnb != null) {
                HidenSoftKeyPad(this.bnb, this.bmD);
            }
            if (this.bmW != null && this.bmW.isShowing()) {
                this.bmW.dismiss();
            }
        } else if (i == 1990028) {
            cz(true);
        } else if (i == 1990019) {
            y(str, 0);
            QG();
        } else if (i == 1990027) {
            if (sendGiftAndroidResIdl != null && sendGiftAndroidResIdl.data != null && sendGiftAndroidResIdl.data.public_key != null) {
                this.mPublicKey = sendGiftAndroidResIdl.data.public_key;
            }
            this.mHandler.post(new f(this));
            this.bmY.setText("");
            cz(false);
            this.bmY.requestFocus();
            this.mHandler.post(new g(this));
        } else if (i != 0) {
            y(str, i.h.neterror);
        } else {
            SendGiftSuccessMessage sendGiftSuccessMessage = new SendGiftSuccessMessage(CmdConfigCustom.CMD_GET_GIFT_SUCCEED, Long.valueOf(this.mReceiverId));
            sendGiftSuccessMessage.setGiftInfo(this.mGiftInfo);
            MessageManager.getInstance().dispatchResponsedMessageToUI(sendGiftSuccessMessage);
            y(str, i.h.send_gift_succeed);
            closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(boolean z) {
        if (z) {
            this.bmZ.setVisibility(0);
        } else {
            this.bmZ.setVisibility(8);
        }
    }

    private void y(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            if (i > 0) {
                showToast(i);
                return;
            }
            return;
        }
        showToast(str);
    }

    private void QJ() {
        if (this.bmQ != null && this.bmQ.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.bmQ.getGiftInfo().getTypeInfo();
            ay(typeInfo);
            aA(typeInfo);
            aC(this.bmQ.getGiftInfo().getNumInfo());
        }
    }

    private void ay(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.bmI.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            az(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GiftCommonList.TypeInfo typeInfo = list.get(i);
                if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                    TextView textView = (TextView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.gift_tab_item, (ViewGroup) null);
                    an.j((View) textView, i.c.cp_bg_line_e);
                    textView.setText(typeInfo.getTypeName());
                    textView.setOnClickListener(new d(i));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setPadding(8, 0, 8, 0);
                    this.bmI.addView(textView, layoutParams);
                }
            }
            gM(0);
        }
    }

    private void az(List<GiftCommonList.TypeInfo> list) {
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

    private void gM(int i) {
        int childCount = this.bmI.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.bmI.getChildAt(i2);
                if (i2 != i) {
                    an.b(textView, i.c.gift_tab_textcolor_normal, 1);
                } else {
                    an.b(textView, i.c.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void aA(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list != null) {
            this.bmU.clear();
            this.bmN.clear();
            this.bmG.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> aB = aB(list.get(i).getGiftItems());
                int size = aB.size();
                if (size > 0) {
                    if (this.bmT == null) {
                        this.bmT = aB.get(0);
                        cA(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.bmU.append(i, ceil);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        if (i2 == ceil - 1) {
                            if (i2 * 8 == size - 1) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(aB.get(size - 1));
                                subList = arrayList;
                            } else {
                                subList = aB.subList(i2 * 8, size);
                            }
                        } else {
                            subList = aB.subList(i2 * 8, (i2 + 1) * 8);
                        }
                        if (i == 0 && i2 == 0) {
                            this.bmN.add(e(subList, this.bmR));
                        } else {
                            this.bmN.add(e(subList, -1));
                        }
                    }
                }
            }
            this.bmP = new s(this.bmN);
            this.bmG.setAdapter(this.bmP);
            QK();
        }
    }

    private List<GiftCommonList.GiftItem> aB(List<GiftCommonList.GiftItem> list) {
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

    private GridView e(List<GiftCommonList.GiftItem> list, int i) {
        q qVar = new q(getPageContext().getPageActivity());
        qVar.setGiftItems(list);
        qVar.gN(i);
        GridView gridView = new GridView(getPageContext().getPageActivity());
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setNumColumns(4);
        gridView.setVerticalSpacing(8);
        gridView.setHorizontalSpacing(8);
        gridView.setSelector(i.c.transparent);
        gridView.setAdapter((ListAdapter) qVar);
        gridView.setPadding(4, 0, 4, 0);
        gridView.setOnItemClickListener(new a(this, null));
        return gridView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QK() {
        int i = 0;
        for (int i2 = 0; i2 < this.bmU.size(); i2++) {
            for (int i3 = 0; i3 < this.bmU.get(i2); i3++) {
                if (i + i3 == this.baQ) {
                    if (this.bmU.get(i2) <= 1) {
                        this.bmH.setVisibility(4);
                    } else {
                        this.bmH.setVisibility(0);
                    }
                    this.bmH.setCount(this.bmU.get(i2));
                    this.bmH.setPosition(i3);
                    gM(i2);
                    return;
                }
            }
            i += this.bmU.get(i2);
        }
    }

    private void aC(List<GiftCommonList.NumInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (GiftCommonList.NumInfo numInfo : list) {
                if (numInfo.getNum() <= 0) {
                    arrayList.add(numInfo);
                }
            }
            list.removeAll(arrayList);
        }
        this.bmO = new r(getPageContext().getPageActivity());
        this.bmM.setAdapter((ListAdapter) this.bmO);
        this.bmO.aD(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        getLayoutMode().ad(z);
        getLayoutMode().k(this.bmC);
        if (this.bmO != null) {
            this.bmO.notifyDataSetChanged();
        }
        if (z) {
            this.bmH.setSelector(getResources().getDrawable(i.e.icon_pagecontrol_on_1));
            this.bmH.setDrawable(getResources().getDrawable(i.e.icon_pagecontrol_off_1));
            return;
        }
        this.bmH.setSelector(getResources().getDrawable(i.e.icon_pagecontrol_on));
        this.bmH.setDrawable(getResources().getDrawable(i.e.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bmW != null && this.bmW.isShowing()) {
                this.bmY.clearFocus();
                this.bmW.dismiss();
                return true;
            } else if (this.bmL.getVisibility() == 0) {
                this.bmL.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        private c() {
        }

        /* synthetic */ c(BuyGiftActivity buyGiftActivity, c cVar) {
            this();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v2 int)] */
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int g = com.baidu.adp.lib.g.b.g(editable.toString(), 0);
            if (editable.toString().length() != String.valueOf(g).length()) {
                int i = g >= 0 ? g : 0;
                BuyGiftActivity.this.bmD.setText(new StringBuilder().append(i).toString());
                BuyGiftActivity.this.bmD.setSelection(String.valueOf(i).length());
                return;
            }
            BuyGiftActivity.this.cA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        /* synthetic */ a(BuyGiftActivity buyGiftActivity, a aVar) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BuyGiftActivity.this.bmR = BuyGiftActivity.this.baQ;
            BuyGiftActivity.this.bmS = i;
            q qVar = (q) adapterView.getAdapter();
            if (qVar != null) {
                GiftCommonList.GiftItem item = qVar.getItem(i);
                if (item != null) {
                    BuyGiftActivity.this.bmT = item;
                }
                qVar.gN(i);
                qVar.notifyDataSetChanged();
            }
            BuyGiftActivity.this.cA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cA(boolean z) {
        int i;
        int g = com.baidu.adp.lib.g.b.g(this.bmD.getText().toString(), 1);
        if (this.bmT != null) {
            i = this.bmT.getPrice() > 0 ? this.bmT.getPrice() : 1;
        } else {
            i = 1;
        }
        int i2 = i * g;
        if (z) {
            this.bmE.setText(String.format(getPageContext().getString(i.h.tdou_count_format), as.cA(i2)));
            if (i2 <= 0) {
                an.i((View) this.bmF, i.e.btn_gift_give_d);
                this.bmF.setEnabled(false);
            } else {
                an.i((View) this.bmF, i.e.btn_gift_give_normal);
                this.bmF.setEnabled(true);
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        /* synthetic */ b(BuyGiftActivity buyGiftActivity, b bVar) {
            this();
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0072: INVOKE  (r0v11 int A[REMOVE]) = (r0v10 com.baidu.tieba.gift.buyGift.GiftCommonList$NumInfo) type: VIRTUAL call: com.baidu.tieba.gift.buyGift.GiftCommonList.NumInfo.getNum():int)] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (BuyGiftActivity.this.bmQ != null && BuyGiftActivity.this.bmQ.getGiftInfo() != null) {
                List<GiftCommonList.NumInfo> numInfo = BuyGiftActivity.this.bmQ.getGiftInfo().getNumInfo();
                if (i != numInfo.size()) {
                    BuyGiftActivity.this.bmD.setCursorVisible(true);
                    BuyGiftActivity.this.bmD.setFocusable(true);
                    GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                    if (numInfo2 != null) {
                        BuyGiftActivity.this.bmD.setText(new StringBuilder().append(numInfo2.getNum()).toString());
                    }
                } else {
                    BuyGiftActivity.this.cB(true);
                    Selection.selectAll(BuyGiftActivity.this.bmD.getText());
                }
                BuyGiftActivity.this.bmL.setVisibility(8);
                BuyGiftActivity.this.cA(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(boolean z) {
        this.bmD.setCursorVisible(z);
        this.bmD.setFocusable(z);
        this.bmD.setFocusableInTouchMode(z);
        if (z) {
            this.bmD.requestFocus();
        } else {
            this.bmD.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        private int anQ;

        public d(int i) {
            this.anQ = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.anQ, BuyGiftActivity.this.bmU.size());
            int i = 0;
            for (int i2 = 0; i2 < min; i2++) {
                i += BuyGiftActivity.this.bmU.get(i2);
            }
            BuyGiftActivity.this.baQ = i;
            BuyGiftActivity.this.bmG.setCurrentItem(BuyGiftActivity.this.baQ);
            BuyGiftActivity.this.QK();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.baQ = i;
        QK();
        if (i >= 0 && i < this.bmN.size()) {
            GridView gridView = (GridView) this.bmN.get(i);
            if (gridView.getAdapter() != null) {
                q qVar = (q) gridView.getAdapter();
                if (qVar.QL() >= 0 && i != this.bmR) {
                    qVar.gN(-1);
                    qVar.notifyDataSetChanged();
                }
                if (qVar.QL() < 0 && i == this.bmR) {
                    qVar.gN(this.bmS);
                    qVar.notifyDataSetChanged();
                }
            }
        }
    }
}
