package com.baidu.tbadk.gift;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyGiftActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGift.SendGiftResIdl;
/* loaded from: classes.dex */
public class BuyGiftActivity extends BaseActivity<BuyGiftActivity> implements ViewPager.OnPageChangeListener {
    private View ZX;
    private View ZY;
    private EditText ZZ;
    private TextView aaa;
    private TextView aab;
    private BaseViewPager aac;
    private IndicatorView aad;
    private LinearLayout aae;
    private View aaf;
    private View aag;
    private View aah;
    private ListView aai;
    private w aak;
    private y aal;
    private GiftCommonList aam;
    private int aan;
    private int aao;
    private int aap;
    private GiftCommonList.GiftItem aaq;
    private View aat;
    private View aau;
    private EditText aav;
    private View aaw;
    private View aax;
    private View aay;
    private String mPassword;
    private long mReceiverId;
    private List<View> aaj = new ArrayList();
    private SparseIntArray aar = new SparseIntArray();
    private boolean aas = false;
    private final HttpMessageListener aaz = new a(this, CmdConfigHttp.GET_GIFT_LIST);
    private final com.baidu.adp.framework.listener.e aaA = new h(this, 308001);
    private final com.baidu.adp.framework.listener.e aaB = new i(this, 308003);
    private final CustomMessageListener aaC = new j(this, 2001233);

    static {
        TbadkApplication.getInst().RegisterIntent(BuyGiftActivityConfig.class, BuyGiftActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.v.bg_gift_shade));
        }
        setContentView(com.baidu.tieba.x.activity_buy_gift);
        initViews();
        initData();
    }

    private void initViews() {
        this.ZX = findViewById(com.baidu.tieba.w.empty_layout);
        this.ZX.setOnClickListener(new k(this));
        this.ZY = findViewById(com.baidu.tieba.w.gift_list_layout);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        this.ZZ = (EditText) findViewById(com.baidu.tieba.w.gift_count_input);
        this.ZZ.setSelection(1);
        aK(false);
        this.ZZ.addTextChangedListener(new s(this, null));
        this.ZZ.setOnClickListener(new l(this, inputMethodManager));
        this.ZZ.setOnFocusChangeListener(new n(this, inputMethodManager));
        this.aaa = (TextView) findViewById(com.baidu.tieba.w.gift_count_result);
        this.aab = (TextView) findViewById(com.baidu.tieba.w.gift_button);
        this.aab.setEnabled(false);
        this.aab.setOnClickListener(new o(this));
        this.aaf = findViewById(com.baidu.tieba.w.gift_lower_layout);
        this.aac = (BaseViewPager) findViewById(com.baidu.tieba.w.gift_viewpager);
        this.aac.setOnPageChangeListener(this);
        this.aad = (IndicatorView) findViewById(com.baidu.tieba.w.gift_tab_indicator);
        this.aae = (LinearLayout) findViewById(com.baidu.tieba.w.gift_tab_layout);
        this.aag = findViewById(com.baidu.tieba.w.gift_progress_layout);
        this.aah = findViewById(com.baidu.tieba.w.gift_num_layout);
        this.aah.setOnClickListener(new p(this));
        this.aai = (ListView) findViewById(com.baidu.tieba.w.gift_num_list);
        this.aai.setOnItemClickListener(new r(this, null));
        this.aat = findViewById(com.baidu.tieba.w.password_dialog);
        this.aat.setBackgroundResource(com.baidu.tieba.t.result_view);
        this.aat.setOnClickListener(new b(this, inputMethodManager));
        this.aau = this.aat.findViewById(com.baidu.tieba.w.password_dialog_ll);
        this.aau.setOnClickListener(new d(this));
        this.aav = (EditText) this.aat.findViewById(com.baidu.tieba.w.password_dialog_input);
        this.aaw = this.aat.findViewById(com.baidu.tieba.w.password_dialog_ok);
        this.aaw.setOnClickListener(new e(this));
        this.aax = this.aat.findViewById(com.baidu.tieba.w.password_dialog_cancel);
        this.aax.setOnClickListener(new f(this));
        this.aay = this.aat.findViewById(com.baidu.tieba.w.password_dialog_warning);
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra(BuyGiftActivityConfig.GIFT_RECEIVER_ID, 0L);
        }
        vB();
        registerListener();
        vF();
    }

    private void vB() {
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
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(308003);
        bVar2.setResponsedClass(SendGiftSocketResponseMessage.class);
        bVar2.i(true);
        bVar2.j(false);
        bVar2.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar2);
    }

    private void registerListener() {
        registerListener(this.aaz);
        registerListener(this.aaA);
        registerListener(this.aaB);
        registerListener(this.aaC);
    }

    private void vF() {
        this.aag.setVisibility(0);
        this.aaf.setVisibility(8);
        this.aah.setVisibility(8);
        aK(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.ZZ);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    public void p(int i, String str) {
        if (i != 0 || this.aam == null || this.aam.getGiftInfo() == null || this.aam.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(z.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.aab.setEnabled(true);
        this.aag.setVisibility(8);
        this.aaf.setVisibility(0);
        vH();
    }

    public void vG() {
        if (this.aaq != null && this.mReceiverId > 0) {
            if (this.aat.getVisibility() == 0) {
                this.aaw.setClickable(false);
                this.aax.setClickable(false);
            }
            this.aab.setEnabled(false);
            this.aag.setVisibility(0);
            RequestSendGiftSocketMessage requestSendGiftSocketMessage = new RequestSendGiftSocketMessage();
            requestSendGiftSocketMessage.setParams(this.mReceiverId, this.aaq.getGiftId(), this.aaq.getPrice(), com.baidu.adp.lib.g.c.toInt(this.ZZ.getText().toString(), 1), 1, this.mPassword);
            sendMessage(requestSendGiftSocketMessage);
        }
    }

    public void a(int i, String str, SendGiftResIdl sendGiftResIdl) {
        if (this.aat.getVisibility() == 0) {
            this.aaw.setClickable(true);
            this.aax.setClickable(true);
        }
        this.aag.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.aas) {
            int aJ = aJ(false);
            int intValue = (sendGiftResIdl == null || sendGiftResIdl.data == null || sendGiftResIdl.data.money == null) ? 0 : aJ - sendGiftResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(z.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), aJ)));
        } else if (i == 1990028) {
            if (this.aat.getVisibility() == 0) {
                this.aay.setVisibility(0);
            }
        } else if (i == 1990019) {
            t(str, 0);
            vF();
        } else if (i == 1990027) {
            this.aat.setVisibility(0);
            this.aav.setText("");
            this.aay.setVisibility(8);
            this.aav.requestFocus();
            this.mHandler.post(new g(this));
        } else if (i != 0) {
            t(str, z.neterror);
        } else {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001238, Long.valueOf(this.mReceiverId)));
            t(str, z.send_gift_succeed);
            closeActivity();
        }
    }

    private void t(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            if (i > 0) {
                showToast(i);
                return;
            }
            return;
        }
        showToast(str);
    }

    private void vH() {
        if (this.aam != null && this.aam.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.aam.getGiftInfo().getTypeInfo();
            n(typeInfo);
            p(typeInfo);
            r(this.aam.getGiftInfo().getNumInfo());
        }
    }

    private void n(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.aae.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            o(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GiftCommonList.TypeInfo typeInfo = list.get(i);
                if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                    TextView textView = (TextView) com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.gift_tab_item, null);
                    ax.j((View) textView, com.baidu.tieba.t.cp_bg_line_e);
                    textView.setText(typeInfo.getTypeName());
                    textView.setOnClickListener(new t(this, i));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setPadding(8, 0, 8, 0);
                    this.aae.addView(textView, layoutParams);
                }
            }
            dj(0);
        }
    }

    private void o(List<GiftCommonList.TypeInfo> list) {
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

    private void dj(int i) {
        int childCount = this.aae.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.aae.getChildAt(i2);
                if (i2 != i) {
                    ax.b(textView, com.baidu.tieba.t.gift_tab_textcolor_normal, 1);
                } else {
                    ax.b(textView, com.baidu.tieba.t.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void p(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list != null) {
            this.aar.clear();
            this.aaj.clear();
            this.aac.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> q = q(list.get(i).getGiftItems());
                int size = q.size();
                if (size > 0) {
                    if (this.aaq == null) {
                        this.aaq = q.get(0);
                        aJ(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.aar.append(i, ceil);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        if (i2 == ceil - 1) {
                            if (i2 * 8 == size - 1) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(q.get(size - 1));
                                subList = arrayList;
                            } else {
                                subList = q.subList(i2 * 8, size);
                            }
                        } else {
                            subList = q.subList(i2 * 8, (i2 + 1) * 8);
                        }
                        if (i == 0 && i2 == 0) {
                            this.aaj.add(b(subList, this.aao));
                        } else {
                            this.aaj.add(b(subList, -1));
                        }
                    }
                }
            }
            this.aal = new y(this.aaj);
            this.aac.setAdapter(this.aal);
            vI();
        }
    }

    private List<GiftCommonList.GiftItem> q(List<GiftCommonList.GiftItem> list) {
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

    private GridView b(List<GiftCommonList.GiftItem> list, int i) {
        u uVar = new u(getPageContext().getPageActivity());
        uVar.setGiftItems(list);
        uVar.dk(i);
        GridView gridView = new GridView(getPageContext().getPageActivity());
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setNumColumns(4);
        gridView.setVerticalSpacing(8);
        gridView.setHorizontalSpacing(8);
        gridView.setSelector(com.baidu.tieba.t.transparent);
        gridView.setAdapter((ListAdapter) uVar);
        gridView.setPadding(4, 0, 4, 0);
        gridView.setOnItemClickListener(new q(this, null));
        return gridView;
    }

    public void vI() {
        int i = 0;
        for (int i2 = 0; i2 < this.aar.size(); i2++) {
            for (int i3 = 0; i3 < this.aar.get(i2); i3++) {
                if (i + i3 == this.aan) {
                    if (this.aar.get(i2) <= 1) {
                        this.aad.setVisibility(4);
                    } else {
                        this.aad.setVisibility(0);
                    }
                    this.aad.setCount(this.aar.get(i2));
                    this.aad.setPosition(i3);
                    dj(i2);
                    return;
                }
            }
            i += this.aar.get(i2);
        }
    }

    private void r(List<GiftCommonList.NumInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (GiftCommonList.NumInfo numInfo : list) {
                if (numInfo.getNum() <= 0) {
                    arrayList.add(numInfo);
                }
            }
            list.removeAll(arrayList);
        }
        this.aak = new w(getPageContext().getPageActivity());
        this.aai.setAdapter((ListAdapter) this.aak);
        this.aak.s(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        getLayoutMode().ab(z);
        getLayoutMode().h(this.ZY);
        getLayoutMode().h(this.aat);
        if (this.aak != null) {
            this.aak.notifyDataSetChanged();
        }
        if (z) {
            this.aad.setSelector(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_on_1));
            this.aad.setDrawable(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_off_1));
            return;
        }
        this.aad.setSelector(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_on));
        this.aad.setDrawable(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aat.getVisibility() == 0) {
                this.aav.clearFocus();
                this.aat.setVisibility(8);
                return true;
            } else if (this.aah.getVisibility() == 0) {
                this.aah.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int aJ(boolean z) {
        int i;
        int i2 = com.baidu.adp.lib.g.c.toInt(this.ZZ.getText().toString(), 1);
        if (this.aaq != null) {
            i = this.aaq.getPrice() > 0 ? this.aaq.getPrice() : 1;
        } else {
            i = 1;
        }
        int i3 = i * i2;
        if (z) {
            this.aaa.setText(String.format(getPageContext().getString(z.tdou_count_format), ba.bY(i3)));
            if (i3 <= 0) {
                ax.i((View) this.aab, com.baidu.tieba.v.btn_gift_give_d);
                this.aab.setEnabled(false);
            } else {
                ax.i((View) this.aab, com.baidu.tieba.v.btn_gift_give_normal);
                this.aab.setEnabled(true);
            }
        }
        return i3;
    }

    public void aK(boolean z) {
        this.ZZ.setCursorVisible(z);
        this.ZZ.setFocusable(z);
        this.ZZ.setFocusableInTouchMode(z);
        if (z) {
            this.ZZ.requestFocus();
        } else {
            this.ZZ.clearFocus();
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
        this.aan = i;
        vI();
        if (i >= 0 && i < this.aaj.size()) {
            GridView gridView = (GridView) this.aaj.get(i);
            if (gridView.getAdapter() != null) {
                u uVar = (u) gridView.getAdapter();
                if (uVar.vJ() >= 0 && i != this.aao) {
                    uVar.dk(-1);
                    uVar.notifyDataSetChanged();
                }
                if (uVar.vJ() < 0 && i == this.aao) {
                    uVar.dk(this.aap);
                    uVar.notifyDataSetChanged();
                }
            }
        }
    }
}
