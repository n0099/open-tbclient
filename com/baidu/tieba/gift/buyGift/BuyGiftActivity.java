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
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.SendGiftSuccessMessage;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes.dex */
public class BuyGiftActivity extends BaseActivity<BuyGiftActivity> implements ViewPager.OnPageChangeListener {
    private int bhi;
    private View buA;
    private EditText buB;
    private TextView buC;
    private InputMethodManager buE;
    private FrameLayout bud;
    private View bue;
    private View buf;
    private EditText bug;
    private TextView buh;
    private TextView bui;
    private BaseViewPager buj;
    private IndicatorView buk;
    private LinearLayout bul;
    private View bum;
    private View bun;
    private View buo;
    private ListView bup;
    private r bur;
    private s bus;
    private GiftCommonList but;
    private int buu;
    private int buv;
    private GiftCommonList.GiftItem buw;
    private com.baidu.tbadk.core.dialog.a buz;
    private int mFrom;
    private String mPassword;
    private String mPublicKey;
    private long mReceiverId;
    private List<View> buq = new ArrayList();
    private SparseIntArray bux = new SparseIntArray();
    private boolean buy = false;
    private boolean buD = false;
    private SendGiftSuccessMessage.a mGiftInfo = new SendGiftSuccessMessage.a();
    private final HttpMessageListener buF = new com.baidu.tieba.gift.buyGift.a(this, CmdConfigHttp.GET_GIFT_LIST);
    private final com.baidu.adp.framework.listener.e buG = new h(this, 308001);
    private final com.baidu.adp.framework.listener.a buH = new i(this, CmdConfigHttp.SEND_GIFT, 308007);
    private final CustomMessageListener buI = new j(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(n.g.activity_buy_gift);
        initViews();
        initData();
        this.mFrom = getIntent().getIntExtra("from", 1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.buD) {
            SU();
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

    private void SU() {
        this.bue.setBackgroundColor(as.getColor(n.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.bue.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new k(this));
        this.buf.startAnimation(loadAnimation);
        this.buD = true;
    }

    private void SV() {
        this.bue.setBackgroundColor(as.getColor(n.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.bue.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new l(this));
        this.buf.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        SV();
    }

    private void initViews() {
        this.bud = (FrameLayout) findViewById(n.f.gift_panel_lay);
        this.bue = findViewById(n.f.empty_layout);
        this.bue.setOnClickListener(new m(this));
        this.buf = findViewById(n.f.gift_list_layout);
        this.buE = (InputMethodManager) getSystemService("input_method");
        this.bug = (EditText) findViewById(n.f.gift_count_input);
        this.bug.setSelection(1);
        cR(false);
        this.bug.addTextChangedListener(new c(this, null));
        this.bug.setOnClickListener(new n(this));
        this.bug.setOnFocusChangeListener(new p(this));
        this.buh = (TextView) findViewById(n.f.gift_count_result);
        this.bui = (TextView) findViewById(n.f.gift_button);
        this.bui.setEnabled(false);
        this.bui.setOnClickListener(new com.baidu.tieba.gift.buyGift.b(this));
        this.bum = findViewById(n.f.gift_lower_layout);
        this.buj = (BaseViewPager) findViewById(n.f.gift_viewpager);
        this.buj.setOnPageChangeListener(this);
        this.buk = (IndicatorView) findViewById(n.f.gift_tab_indicator);
        this.bul = (LinearLayout) findViewById(n.f.gift_tab_layout);
        this.bun = findViewById(n.f.gift_progress_layout);
        this.buo = findViewById(n.f.gift_num_layout);
        this.buo.setOnClickListener(new com.baidu.tieba.gift.buyGift.c(this));
        this.bup = (ListView) findViewById(n.f.gift_num_list);
        this.bup.setOnItemClickListener(new b(this, null));
        this.buz = new com.baidu.tbadk.core.dialog.a(getActivity());
        this.buA = LayoutInflater.from(getActivity()).inflate(n.g.dialog_tdou_pay_pwd, (ViewGroup) null);
        this.buB = (EditText) this.buA.findViewById(n.f.password_dialog_input);
        this.buC = (TextView) this.buA.findViewById(n.f.password_dialog_warning);
        this.buz.m(this.buA);
        this.buz.am(false);
        this.buz.b(getPageContext().getString(n.i.cancel), new com.baidu.tieba.gift.buyGift.d(this));
        this.buz.a(getPageContext().getString(n.i.confirm), new e(this));
        this.buz.b(getPageContext());
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra("gift_receiver_id", 0L);
        }
        CQ();
        registerListener();
    }

    private void CQ() {
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
        registerListener(this.buF);
        registerListener(this.buG);
        registerListener(this.buH);
        registerListener(this.buI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SW() {
        this.bun.setVisibility(0);
        this.bum.setVisibility(8);
        this.buo.setVisibility(8);
        cR(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.bug);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i, String str) {
        if (i != 0 || this.but == null || this.but.getGiftInfo() == null || this.but.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(n.i.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.bui.setEnabled(true);
        this.bun.setVisibility(8);
        this.bum.setVisibility(0);
        SZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SX() {
        if (this.buw != null && this.mReceiverId > 0) {
            if (this.buz != null && this.buz.isShowing()) {
                this.buz.ao(false);
                this.buz.ap(false);
            }
            this.bui.setEnabled(false);
            this.bun.setVisibility(0);
            RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
            int g = com.baidu.adp.lib.h.b.g(String.valueOf(this.bug.getText()), 1);
            requestSendGiftNetMessage.setParams(this.mReceiverId, this.buw.getGiftId(), this.buw.getPrice(), g, SY(), this.mPassword);
            this.mGiftInfo.setCount(g);
            this.mGiftInfo.setName(this.buw.getName());
            this.mGiftInfo.setUrl(this.buw.getThumbnailUrl());
            this.mGiftInfo.setId(this.buw.getGiftId());
            this.mGiftInfo.cF(TbadkCoreApplication.getCurrentAccountName());
            sendMessage(requestSendGiftNetMessage);
        }
    }

    public int SY() {
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
        if (this.buz != null && this.buz.isShowing()) {
            this.buz.ao(true);
            this.buz.ap(true);
        }
        this.bun.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.buy) {
            int cQ = cQ(false);
            int intValue = (sendGiftAndroidResIdl == null || sendGiftAndroidResIdl.data == null || sendGiftAndroidResIdl.data.money == null) ? 0 : cQ - sendGiftAndroidResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(n.i.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), cQ)));
            if (this.buE != null) {
                HidenSoftKeyPad(this.buE, this.bug);
            }
            if (this.buz != null && this.buz.isShowing()) {
                this.buz.dismiss();
            }
        } else if (i == 1990028) {
            cP(true);
        } else if (i == 1990019) {
            C(str, 0);
            SW();
        } else if (i == 1990027) {
            if (sendGiftAndroidResIdl != null && sendGiftAndroidResIdl.data != null && sendGiftAndroidResIdl.data.public_key != null) {
                this.mPublicKey = sendGiftAndroidResIdl.data.public_key;
            }
            this.mHandler.post(new f(this));
            this.buB.setText("");
            cP(false);
            this.buB.requestFocus();
            this.mHandler.post(new g(this));
        } else if (i != 0) {
            C(str, n.i.neterror);
        } else {
            SendGiftSuccessMessage sendGiftSuccessMessage = new SendGiftSuccessMessage(CmdConfigCustom.CMD_GET_GIFT_SUCCEED, Long.valueOf(this.mReceiverId));
            sendGiftSuccessMessage.setGiftInfo(this.mGiftInfo);
            MessageManager.getInstance().dispatchResponsedMessageToUI(sendGiftSuccessMessage);
            C(str, n.i.send_gift_succeed);
            closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(boolean z) {
        if (z) {
            this.buC.setVisibility(0);
        } else {
            this.buC.setVisibility(8);
        }
    }

    private void C(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            if (i > 0) {
                showToast(i);
                return;
            }
            return;
        }
        showToast(str);
    }

    private void SZ() {
        if (this.but != null && this.but.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.but.getGiftInfo().getTypeInfo();
            aF(typeInfo);
            aH(typeInfo);
            aJ(this.but.getGiftInfo().getNumInfo());
        }
    }

    private void aF(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.bul.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            aG(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GiftCommonList.TypeInfo typeInfo = list.get(i);
                if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                    TextView textView = (TextView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.gift_tab_item, (ViewGroup) null);
                    as.j((View) textView, n.c.cp_bg_line_e);
                    textView.setText(typeInfo.getTypeName());
                    textView.setOnClickListener(new d(i));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setPadding(8, 0, 8, 0);
                    this.bul.addView(textView, layoutParams);
                }
            }
            hp(0);
        }
    }

    private void aG(List<GiftCommonList.TypeInfo> list) {
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

    private void hp(int i) {
        int childCount = this.bul.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.bul.getChildAt(i2);
                if (i2 != i) {
                    as.b(textView, n.c.gift_tab_textcolor_normal, 1);
                } else {
                    as.b(textView, n.c.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void aH(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list != null) {
            this.bux.clear();
            this.buq.clear();
            this.buj.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> aI = aI(list.get(i).getGiftItems());
                int size = aI.size();
                if (size > 0) {
                    if (this.buw == null) {
                        this.buw = aI.get(0);
                        cQ(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.bux.append(i, ceil);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        if (i2 == ceil - 1) {
                            if (i2 * 8 == size - 1) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(aI.get(size - 1));
                                subList = arrayList;
                            } else {
                                subList = aI.subList(i2 * 8, size);
                            }
                        } else {
                            subList = aI.subList(i2 * 8, (i2 + 1) * 8);
                        }
                        if (i == 0 && i2 == 0) {
                            this.buq.add(e(subList, this.buu));
                        } else {
                            this.buq.add(e(subList, -1));
                        }
                    }
                }
            }
            this.bus = new s(this.buq);
            this.buj.setAdapter(this.bus);
            Ta();
        }
    }

    private List<GiftCommonList.GiftItem> aI(List<GiftCommonList.GiftItem> list) {
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
        qVar.hq(i);
        GridView gridView = new GridView(getPageContext().getPageActivity());
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setNumColumns(4);
        gridView.setVerticalSpacing(8);
        gridView.setHorizontalSpacing(8);
        gridView.setSelector(n.c.transparent);
        gridView.setAdapter((ListAdapter) qVar);
        gridView.setPadding(4, 0, 4, 0);
        gridView.setOnItemClickListener(new a(this, null));
        return gridView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        int i = 0;
        for (int i2 = 0; i2 < this.bux.size(); i2++) {
            for (int i3 = 0; i3 < this.bux.get(i2); i3++) {
                if (i + i3 == this.bhi) {
                    if (this.bux.get(i2) <= 1) {
                        this.buk.setVisibility(4);
                    } else {
                        this.buk.setVisibility(0);
                    }
                    this.buk.setCount(this.bux.get(i2));
                    this.buk.setPosition(i3);
                    hp(i2);
                    return;
                }
            }
            i += this.bux.get(i2);
        }
    }

    private void aJ(List<GiftCommonList.NumInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (GiftCommonList.NumInfo numInfo : list) {
                if (numInfo.getNum() <= 0) {
                    arrayList.add(numInfo);
                }
            }
            list.removeAll(arrayList);
        }
        this.bur = new r(getPageContext().getPageActivity());
        this.bup.setAdapter((ListAdapter) this.bur);
        this.bur.aK(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        getLayoutMode().af(z);
        getLayoutMode().k(this.buf);
        if (this.bur != null) {
            this.bur.notifyDataSetChanged();
        }
        if (z) {
            this.buk.setSelector(getResources().getDrawable(n.e.icon_pagecontrol_on_1));
            this.buk.setDrawable(getResources().getDrawable(n.e.icon_pagecontrol_off_1));
            return;
        }
        this.buk.setSelector(getResources().getDrawable(n.e.icon_pagecontrol_on));
        this.buk.setDrawable(getResources().getDrawable(n.e.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.buz != null && this.buz.isShowing()) {
                this.buB.clearFocus();
                this.buz.dismiss();
                return true;
            } else if (this.buo.getVisibility() == 0) {
                this.buo.setVisibility(8);
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
            int g = com.baidu.adp.lib.h.b.g(editable.toString(), 0);
            if (editable.toString().length() != String.valueOf(g).length()) {
                int i = g >= 0 ? g : 0;
                BuyGiftActivity.this.bug.setText(new StringBuilder().append(i).toString());
                BuyGiftActivity.this.bug.setSelection(String.valueOf(i).length());
                return;
            }
            BuyGiftActivity.this.cQ(true);
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
            BuyGiftActivity.this.buu = BuyGiftActivity.this.bhi;
            BuyGiftActivity.this.buv = i;
            q qVar = (q) adapterView.getAdapter();
            if (qVar != null) {
                GiftCommonList.GiftItem item = qVar.getItem(i);
                if (item != null) {
                    BuyGiftActivity.this.buw = item;
                }
                qVar.hq(i);
                qVar.notifyDataSetChanged();
            }
            BuyGiftActivity.this.cQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cQ(boolean z) {
        int i;
        int g = com.baidu.adp.lib.h.b.g(this.bug.getText().toString(), 1);
        if (this.buw != null) {
            i = this.buw.getPrice() > 0 ? this.buw.getPrice() : 1;
        } else {
            i = 1;
        }
        int i2 = i * g;
        if (z) {
            this.buh.setText(String.format(getPageContext().getString(n.i.tdou_count_format), ax.cH(i2)));
            if (i2 <= 0) {
                as.i((View) this.bui, n.e.btn_gift_give_d);
                this.bui.setEnabled(false);
            } else {
                as.i((View) this.bui, n.e.btn_gift_give_normal);
                this.bui.setEnabled(true);
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
            if (BuyGiftActivity.this.but != null && BuyGiftActivity.this.but.getGiftInfo() != null) {
                List<GiftCommonList.NumInfo> numInfo = BuyGiftActivity.this.but.getGiftInfo().getNumInfo();
                if (i != numInfo.size()) {
                    BuyGiftActivity.this.bug.setCursorVisible(true);
                    BuyGiftActivity.this.bug.setFocusable(true);
                    GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                    if (numInfo2 != null) {
                        BuyGiftActivity.this.bug.setText(new StringBuilder().append(numInfo2.getNum()).toString());
                    }
                } else {
                    BuyGiftActivity.this.cR(true);
                    Selection.selectAll(BuyGiftActivity.this.bug.getText());
                }
                BuyGiftActivity.this.buo.setVisibility(8);
                BuyGiftActivity.this.cQ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(boolean z) {
        this.bug.setCursorVisible(z);
        this.bug.setFocusable(z);
        this.bug.setFocusableInTouchMode(z);
        if (z) {
            this.bug.requestFocus();
        } else {
            this.bug.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        private int apI;

        public d(int i) {
            this.apI = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.apI, BuyGiftActivity.this.bux.size());
            int i = 0;
            for (int i2 = 0; i2 < min; i2++) {
                i += BuyGiftActivity.this.bux.get(i2);
            }
            BuyGiftActivity.this.bhi = i;
            BuyGiftActivity.this.buj.setCurrentItem(BuyGiftActivity.this.bhi);
            BuyGiftActivity.this.Ta();
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
        this.bhi = i;
        Ta();
        if (i >= 0 && i < this.buq.size()) {
            GridView gridView = (GridView) this.buq.get(i);
            if (gridView.getAdapter() != null) {
                q qVar = (q) gridView.getAdapter();
                if (qVar.Tb() >= 0 && i != this.buu) {
                    qVar.hq(-1);
                    qVar.notifyDataSetChanged();
                }
                if (qVar.Tb() < 0 && i == this.buu) {
                    qVar.hq(this.buv);
                    qVar.notifyDataSetChanged();
                }
            }
        }
    }
}
