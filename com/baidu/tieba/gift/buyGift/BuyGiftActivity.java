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
    private int bax;
    private FrameLayout blW;
    private View blX;
    private View blY;
    private EditText blZ;
    private TextView bma;
    private TextView bmb;
    private BaseViewPager bmc;
    private IndicatorView bmd;
    private LinearLayout bme;
    private View bmf;
    private View bmg;
    private View bmh;
    private ListView bmi;
    private r bmk;
    private s bml;
    private GiftCommonList bmm;
    private int bmn;
    private int bmo;
    private GiftCommonList.GiftItem bmp;
    private com.baidu.tbadk.core.dialog.a bms;
    private View bmt;
    private EditText bmu;
    private TextView bmv;
    private InputMethodManager bmx;
    private int mFrom;
    private String mPassword;
    private String mPublicKey;
    private long mReceiverId;
    private List<View> bmj = new ArrayList();
    private SparseIntArray bmq = new SparseIntArray();
    private boolean bmr = false;
    private boolean bmw = false;
    private SendGiftSuccessMessage.a mGiftInfo = new SendGiftSuccessMessage.a();
    private final HttpMessageListener bmy = new com.baidu.tieba.gift.buyGift.a(this, CmdConfigHttp.GET_GIFT_LIST);
    private final com.baidu.adp.framework.listener.e bmz = new h(this, 308001);
    private final com.baidu.adp.framework.listener.a bmA = new i(this, CmdConfigHttp.SEND_GIFT, 308007);
    private final CustomMessageListener bmB = new j(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(i.g.activity_buy_gift);
        Gg();
        initData();
        this.mFrom = getIntent().getIntExtra("from", 1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bmw) {
            Qm();
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

    private void Qm() {
        this.blX.setBackgroundColor(an.getColor(i.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.blX.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new k(this));
        this.blY.startAnimation(loadAnimation);
        this.bmw = true;
    }

    private void Qn() {
        this.blX.setBackgroundColor(an.getColor(i.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.blX.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new l(this));
        this.blY.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Qn();
    }

    private void Gg() {
        this.blW = (FrameLayout) findViewById(i.f.gift_panel_lay);
        this.blX = findViewById(i.f.empty_layout);
        this.blX.setOnClickListener(new m(this));
        this.blY = findViewById(i.f.gift_list_layout);
        this.bmx = (InputMethodManager) getSystemService("input_method");
        this.blZ = (EditText) findViewById(i.f.gift_count_input);
        this.blZ.setSelection(1);
        cz(false);
        this.blZ.addTextChangedListener(new c(this, null));
        this.blZ.setOnClickListener(new n(this));
        this.blZ.setOnFocusChangeListener(new p(this));
        this.bma = (TextView) findViewById(i.f.gift_count_result);
        this.bmb = (TextView) findViewById(i.f.gift_button);
        this.bmb.setEnabled(false);
        this.bmb.setOnClickListener(new com.baidu.tieba.gift.buyGift.b(this));
        this.bmf = findViewById(i.f.gift_lower_layout);
        this.bmc = (BaseViewPager) findViewById(i.f.gift_viewpager);
        this.bmc.setOnPageChangeListener(this);
        this.bmd = (IndicatorView) findViewById(i.f.gift_tab_indicator);
        this.bme = (LinearLayout) findViewById(i.f.gift_tab_layout);
        this.bmg = findViewById(i.f.gift_progress_layout);
        this.bmh = findViewById(i.f.gift_num_layout);
        this.bmh.setOnClickListener(new com.baidu.tieba.gift.buyGift.c(this));
        this.bmi = (ListView) findViewById(i.f.gift_num_list);
        this.bmi.setOnItemClickListener(new b(this, null));
        this.bms = new com.baidu.tbadk.core.dialog.a(getActivity());
        this.bmt = LayoutInflater.from(getActivity()).inflate(i.g.dialog_tdou_pay_pwd, (ViewGroup) null);
        this.bmu = (EditText) this.bmt.findViewById(i.f.password_dialog_input);
        this.bmv = (TextView) this.bmt.findViewById(i.f.password_dialog_warning);
        this.bms.m(this.bmt);
        this.bms.ak(false);
        this.bms.b(getPageContext().getString(i.h.cancel), new com.baidu.tieba.gift.buyGift.d(this));
        this.bms.a(getPageContext().getString(i.h.confirm), new e(this));
        this.bms.b(getPageContext());
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra(BuyGiftActivityConfig.GIFT_RECEIVER_ID, 0L);
        }
        BZ();
        registerListener();
    }

    private void BZ() {
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
        registerListener(this.bmy);
        registerListener(this.bmz);
        registerListener(this.bmA);
        registerListener(this.bmB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qo() {
        this.bmg.setVisibility(0);
        this.bmf.setVisibility(8);
        this.bmh.setVisibility(8);
        cz(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.blZ);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i, String str) {
        if (i != 0 || this.bmm == null || this.bmm.getGiftInfo() == null || this.bmm.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(i.h.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.bmb.setEnabled(true);
        this.bmg.setVisibility(8);
        this.bmf.setVisibility(0);
        Qr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qp() {
        if (this.bmp != null && this.mReceiverId > 0) {
            if (this.bms != null && this.bms.isShowing()) {
                this.bms.am(false);
                this.bms.an(false);
            }
            this.bmb.setEnabled(false);
            this.bmg.setVisibility(0);
            RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
            int g = com.baidu.adp.lib.g.b.g(String.valueOf(this.blZ.getText()), 1);
            requestSendGiftNetMessage.setParams(this.mReceiverId, this.bmp.getGiftId(), this.bmp.getPrice(), g, Qq(), this.mPassword);
            this.mGiftInfo.setCount(g);
            this.mGiftInfo.setName(this.bmp.getName());
            this.mGiftInfo.setUrl(this.bmp.getThumbnailUrl());
            this.mGiftInfo.setId(this.bmp.getGiftId());
            this.mGiftInfo.cx(TbadkCoreApplication.getCurrentAccountName());
            sendMessage(requestSendGiftNetMessage);
        }
    }

    public int Qq() {
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
        if (this.bms != null && this.bms.isShowing()) {
            this.bms.am(true);
            this.bms.an(true);
        }
        this.bmg.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.bmr) {
            int cy = cy(false);
            int intValue = (sendGiftAndroidResIdl == null || sendGiftAndroidResIdl.data == null || sendGiftAndroidResIdl.data.money == null) ? 0 : cy - sendGiftAndroidResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(i.h.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), cy)));
            if (this.bmx != null) {
                HidenSoftKeyPad(this.bmx, this.blZ);
            }
            if (this.bms != null && this.bms.isShowing()) {
                this.bms.dismiss();
            }
        } else if (i == 1990028) {
            cx(true);
        } else if (i == 1990019) {
            y(str, 0);
            Qo();
        } else if (i == 1990027) {
            if (sendGiftAndroidResIdl != null && sendGiftAndroidResIdl.data != null && sendGiftAndroidResIdl.data.public_key != null) {
                this.mPublicKey = sendGiftAndroidResIdl.data.public_key;
            }
            this.mHandler.post(new f(this));
            this.bmu.setText("");
            cx(false);
            this.bmu.requestFocus();
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
    public void cx(boolean z) {
        if (z) {
            this.bmv.setVisibility(0);
        } else {
            this.bmv.setVisibility(8);
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

    private void Qr() {
        if (this.bmm != null && this.bmm.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.bmm.getGiftInfo().getTypeInfo();
            au(typeInfo);
            aw(typeInfo);
            ay(this.bmm.getGiftInfo().getNumInfo());
        }
    }

    private void au(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.bme.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            av(list);
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
                    this.bme.addView(textView, layoutParams);
                }
            }
            gz(0);
        }
    }

    private void av(List<GiftCommonList.TypeInfo> list) {
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

    private void gz(int i) {
        int childCount = this.bme.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.bme.getChildAt(i2);
                if (i2 != i) {
                    an.b(textView, i.c.gift_tab_textcolor_normal, 1);
                } else {
                    an.b(textView, i.c.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void aw(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list != null) {
            this.bmq.clear();
            this.bmj.clear();
            this.bmc.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> ax = ax(list.get(i).getGiftItems());
                int size = ax.size();
                if (size > 0) {
                    if (this.bmp == null) {
                        this.bmp = ax.get(0);
                        cy(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.bmq.append(i, ceil);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        if (i2 == ceil - 1) {
                            if (i2 * 8 == size - 1) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(ax.get(size - 1));
                                subList = arrayList;
                            } else {
                                subList = ax.subList(i2 * 8, size);
                            }
                        } else {
                            subList = ax.subList(i2 * 8, (i2 + 1) * 8);
                        }
                        if (i == 0 && i2 == 0) {
                            this.bmj.add(e(subList, this.bmn));
                        } else {
                            this.bmj.add(e(subList, -1));
                        }
                    }
                }
            }
            this.bml = new s(this.bmj);
            this.bmc.setAdapter(this.bml);
            Qs();
        }
    }

    private List<GiftCommonList.GiftItem> ax(List<GiftCommonList.GiftItem> list) {
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
        qVar.gA(i);
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
    public void Qs() {
        int i = 0;
        for (int i2 = 0; i2 < this.bmq.size(); i2++) {
            for (int i3 = 0; i3 < this.bmq.get(i2); i3++) {
                if (i + i3 == this.bax) {
                    if (this.bmq.get(i2) <= 1) {
                        this.bmd.setVisibility(4);
                    } else {
                        this.bmd.setVisibility(0);
                    }
                    this.bmd.setCount(this.bmq.get(i2));
                    this.bmd.setPosition(i3);
                    gz(i2);
                    return;
                }
            }
            i += this.bmq.get(i2);
        }
    }

    private void ay(List<GiftCommonList.NumInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (GiftCommonList.NumInfo numInfo : list) {
                if (numInfo.getNum() <= 0) {
                    arrayList.add(numInfo);
                }
            }
            list.removeAll(arrayList);
        }
        this.bmk = new r(getPageContext().getPageActivity());
        this.bmi.setAdapter((ListAdapter) this.bmk);
        this.bmk.az(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        getLayoutMode().ad(z);
        getLayoutMode().k(this.blY);
        if (this.bmk != null) {
            this.bmk.notifyDataSetChanged();
        }
        if (z) {
            this.bmd.setSelector(getResources().getDrawable(i.e.icon_pagecontrol_on_1));
            this.bmd.setDrawable(getResources().getDrawable(i.e.icon_pagecontrol_off_1));
            return;
        }
        this.bmd.setSelector(getResources().getDrawable(i.e.icon_pagecontrol_on));
        this.bmd.setDrawable(getResources().getDrawable(i.e.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bms != null && this.bms.isShowing()) {
                this.bmu.clearFocus();
                this.bms.dismiss();
                return true;
            } else if (this.bmh.getVisibility() == 0) {
                this.bmh.setVisibility(8);
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
                BuyGiftActivity.this.blZ.setText(new StringBuilder().append(i).toString());
                BuyGiftActivity.this.blZ.setSelection(String.valueOf(i).length());
                return;
            }
            BuyGiftActivity.this.cy(true);
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
            BuyGiftActivity.this.bmn = BuyGiftActivity.this.bax;
            BuyGiftActivity.this.bmo = i;
            q qVar = (q) adapterView.getAdapter();
            if (qVar != null) {
                GiftCommonList.GiftItem item = qVar.getItem(i);
                if (item != null) {
                    BuyGiftActivity.this.bmp = item;
                }
                qVar.gA(i);
                qVar.notifyDataSetChanged();
            }
            BuyGiftActivity.this.cy(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cy(boolean z) {
        int i;
        int g = com.baidu.adp.lib.g.b.g(this.blZ.getText().toString(), 1);
        if (this.bmp != null) {
            i = this.bmp.getPrice() > 0 ? this.bmp.getPrice() : 1;
        } else {
            i = 1;
        }
        int i2 = i * g;
        if (z) {
            this.bma.setText(String.format(getPageContext().getString(i.h.tdou_count_format), as.cA(i2)));
            if (i2 <= 0) {
                an.i((View) this.bmb, i.e.btn_gift_give_d);
                this.bmb.setEnabled(false);
            } else {
                an.i((View) this.bmb, i.e.btn_gift_give_normal);
                this.bmb.setEnabled(true);
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
            if (BuyGiftActivity.this.bmm != null && BuyGiftActivity.this.bmm.getGiftInfo() != null) {
                List<GiftCommonList.NumInfo> numInfo = BuyGiftActivity.this.bmm.getGiftInfo().getNumInfo();
                if (i != numInfo.size()) {
                    BuyGiftActivity.this.blZ.setCursorVisible(true);
                    BuyGiftActivity.this.blZ.setFocusable(true);
                    GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                    if (numInfo2 != null) {
                        BuyGiftActivity.this.blZ.setText(new StringBuilder().append(numInfo2.getNum()).toString());
                    }
                } else {
                    BuyGiftActivity.this.cz(true);
                    Selection.selectAll(BuyGiftActivity.this.blZ.getText());
                }
                BuyGiftActivity.this.bmh.setVisibility(8);
                BuyGiftActivity.this.cy(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(boolean z) {
        this.blZ.setCursorVisible(z);
        this.blZ.setFocusable(z);
        this.blZ.setFocusableInTouchMode(z);
        if (z) {
            this.blZ.requestFocus();
        } else {
            this.blZ.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        private int anL;

        public d(int i) {
            this.anL = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.anL, BuyGiftActivity.this.bmq.size());
            int i = 0;
            for (int i2 = 0; i2 < min; i2++) {
                i += BuyGiftActivity.this.bmq.get(i2);
            }
            BuyGiftActivity.this.bax = i;
            BuyGiftActivity.this.bmc.setCurrentItem(BuyGiftActivity.this.bax);
            BuyGiftActivity.this.Qs();
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
        this.bax = i;
        Qs();
        if (i >= 0 && i < this.bmj.size()) {
            GridView gridView = (GridView) this.bmj.get(i);
            if (gridView.getAdapter() != null) {
                q qVar = (q) gridView.getAdapter();
                if (qVar.Qt() >= 0 && i != this.bmn) {
                    qVar.gA(-1);
                    qVar.notifyDataSetChanged();
                }
                if (qVar.Qt() < 0 && i == this.bmn) {
                    qVar.gA(this.bmo);
                    qVar.notifyDataSetChanged();
                }
            }
        }
    }
}
