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
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGift.SendGiftResIdl;
/* loaded from: classes.dex */
public class BuyGiftActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private View TS;
    private View TT;
    private EditText TU;
    private TextView TV;
    private TextView TW;
    private BaseViewPager TX;
    private IndicatorView TY;
    private LinearLayout TZ;
    private View Ua;
    private View Ub;
    private View Uc;
    private ListView Ud;
    private w Uf;
    private y Ug;
    private GiftCommonList Uh;
    private int Ui;
    private int Uj;
    private int Uk;
    private GiftCommonList.GiftItem Ul;
    private View Uo;
    private View Up;
    private EditText Uq;
    private View Ur;
    private View Us;
    private View Ut;
    private String mPassword;
    private long mReceiverId;
    private List<View> Ue = new ArrayList();
    private SparseIntArray Um = new SparseIntArray();
    private boolean Un = false;
    private final HttpMessageListener Uu = new a(this, CmdConfigHttp.GET_GIFT_LIST);
    private final com.baidu.adp.framework.listener.e Uv = new h(this, 308001);
    private final com.baidu.adp.framework.listener.e Uw = new i(this, 308003);
    private final CustomMessageListener Ux = new j(this, 2001233);

    static {
        TbadkApplication.m251getInst().RegisterIntent(BuyGiftActivityConfig.class, BuyGiftActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.u.bg_gift_shade));
        }
        setContentView(com.baidu.tieba.w.activity_buy_gift);
        sa();
        initData();
    }

    private void sa() {
        this.TS = findViewById(com.baidu.tieba.v.empty_layout);
        this.TS.setOnClickListener(new k(this));
        this.TT = findViewById(com.baidu.tieba.v.gift_list_layout);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        this.TU = (EditText) findViewById(com.baidu.tieba.v.gift_count_input);
        this.TU.setSelection(1);
        aw(false);
        this.TU.addTextChangedListener(new s(this, null));
        this.TU.setOnClickListener(new l(this, inputMethodManager));
        this.TU.setOnFocusChangeListener(new n(this, inputMethodManager));
        this.TV = (TextView) findViewById(com.baidu.tieba.v.gift_count_result);
        this.TW = (TextView) findViewById(com.baidu.tieba.v.gift_button);
        this.TW.setEnabled(false);
        this.TW.setOnClickListener(new o(this));
        this.Ua = findViewById(com.baidu.tieba.v.gift_lower_layout);
        this.TX = (BaseViewPager) findViewById(com.baidu.tieba.v.gift_viewpager);
        this.TX.setOnPageChangeListener(this);
        this.TY = (IndicatorView) findViewById(com.baidu.tieba.v.gift_tab_indicator);
        this.TZ = (LinearLayout) findViewById(com.baidu.tieba.v.gift_tab_layout);
        this.Ub = findViewById(com.baidu.tieba.v.gift_progress_layout);
        this.Uc = findViewById(com.baidu.tieba.v.gift_num_layout);
        this.Uc.setOnClickListener(new p(this));
        this.Ud = (ListView) findViewById(com.baidu.tieba.v.gift_num_list);
        this.Ud.setOnItemClickListener(new r(this, null));
        this.Uo = findViewById(com.baidu.tieba.v.password_dialog);
        this.Uo.setBackgroundResource(com.baidu.tieba.s.result_view);
        this.Uo.setOnClickListener(new b(this, inputMethodManager));
        this.Up = this.Uo.findViewById(com.baidu.tieba.v.password_dialog_ll);
        this.Up.setOnClickListener(new d(this));
        this.Uq = (EditText) this.Uo.findViewById(com.baidu.tieba.v.password_dialog_input);
        this.Ur = this.Uo.findViewById(com.baidu.tieba.v.password_dialog_ok);
        this.Ur.setOnClickListener(new e(this));
        this.Us = this.Uo.findViewById(com.baidu.tieba.v.password_dialog_cancel);
        this.Us.setOnClickListener(new f(this));
        this.Ut = this.Uo.findViewById(com.baidu.tieba.v.password_dialog_warning);
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra(BuyGiftActivityConfig.GIFT_RECEIVER_ID, 0L);
        }
        sb();
        registerListener();
        sc();
    }

    private void sb() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_GIFT_LIST, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GIFT_COMMONLIST + "?cmd=308001");
        tbHttpMessageTask.setResponsedClass(GetGiftCommonListHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(308001);
        bVar.setResponsedClass(GetGiftCommonListSocketResponseMessage.class);
        bVar.e(true);
        bVar.f(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(308003);
        bVar2.setResponsedClass(SendGiftSocketResponseMessage.class);
        bVar2.e(true);
        bVar2.f(false);
        bVar2.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar2);
    }

    private void registerListener() {
        registerListener(this.Uu);
        registerListener(this.Uv);
        registerListener(this.Uw);
        registerListener(this.Ux);
    }

    private void sc() {
        this.Ub.setVisibility(0);
        this.Ua.setVisibility(8);
        this.Uc.setVisibility(8);
        aw(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.TU);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    public void g(int i, String str) {
        if (i != 0 || this.Uh == null || this.Uh.getGiftInfo() == null || this.Uh.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(com.baidu.tieba.y.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.TW.setEnabled(true);
        this.Ub.setVisibility(8);
        this.Ua.setVisibility(0);
        se();
    }

    public void sd() {
        if (this.Ul != null && this.mReceiverId > 0) {
            if (this.Uo.getVisibility() == 0) {
                this.Ur.setClickable(false);
                this.Us.setClickable(false);
            }
            this.TW.setEnabled(false);
            this.Ub.setVisibility(0);
            RequestSendGiftSocketMessage requestSendGiftSocketMessage = new RequestSendGiftSocketMessage();
            requestSendGiftSocketMessage.setParams(this.mReceiverId, this.Ul.getGiftId(), this.Ul.getPrice(), com.baidu.adp.lib.g.c.f(this.TU.getText().toString(), 1), 1, this.mPassword);
            sendMessage(requestSendGiftSocketMessage);
        }
    }

    public void a(int i, String str, SendGiftResIdl sendGiftResIdl) {
        if (this.Uo.getVisibility() == 0) {
            this.Ur.setClickable(true);
            this.Us.setClickable(true);
        }
        this.Ub.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.Un) {
            int av = av(false);
            int intValue = (sendGiftResIdl == null || sendGiftResIdl.data == null || sendGiftResIdl.data.money == null) ? 0 : av - sendGiftResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getString(com.baidu.tieba.y.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(this, av)));
        } else if (i == 1990028) {
            if (this.Uo.getVisibility() == 0) {
                this.Ut.setVisibility(0);
            }
        } else if (i == 1990019) {
            r(str, 0);
            sc();
        } else if (i == 1990027) {
            this.Uo.setVisibility(0);
            this.Uq.setText("");
            this.Ut.setVisibility(8);
            this.Uq.requestFocus();
            this.mHandler.post(new g(this));
        } else if (i != 0) {
            r(str, com.baidu.tieba.y.neterror);
        } else {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001238, Long.valueOf(this.mReceiverId)));
            r(str, com.baidu.tieba.y.send_gift_succeed);
            closeActivity();
        }
    }

    private void r(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            if (i > 0) {
                showToast(i);
                return;
            }
            return;
        }
        showToast(str);
    }

    private void se() {
        if (this.Uh != null && this.Uh.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.Uh.getGiftInfo().getTypeInfo();
            j(typeInfo);
            l(typeInfo);
            n(this.Uh.getGiftInfo().getNumInfo());
        }
    }

    private void j(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.TZ.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            k(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GiftCommonList.TypeInfo typeInfo = list.get(i);
                if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                    TextView textView = (TextView) com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.gift_tab_item, null);
                    aw.i((View) textView, com.baidu.tieba.s.cp_bg_line_e);
                    textView.setText(typeInfo.getTypeName());
                    textView.setOnClickListener(new t(this, i));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setPadding(8, 0, 8, 0);
                    this.TZ.addView(textView, layoutParams);
                }
            }
            cL(0);
        }
    }

    private void k(List<GiftCommonList.TypeInfo> list) {
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

    private void cL(int i) {
        int childCount = this.TZ.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.TZ.getChildAt(i2);
                if (i2 != i) {
                    aw.b(textView, com.baidu.tieba.s.gift_tab_textcolor_normal, 1);
                } else {
                    aw.b(textView, com.baidu.tieba.s.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void l(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list != null) {
            this.Um.clear();
            this.Ue.clear();
            this.TX.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> m = m(list.get(i).getGiftItems());
                int size = m.size();
                if (size > 0) {
                    if (this.Ul == null) {
                        this.Ul = m.get(0);
                        av(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.Um.append(i, ceil);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        if (i2 == ceil - 1) {
                            if (i2 * 8 == size - 1) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(m.get(size - 1));
                                subList = arrayList;
                            } else {
                                subList = m.subList(i2 * 8, size);
                            }
                        } else {
                            subList = m.subList(i2 * 8, (i2 + 1) * 8);
                        }
                        if (i == 0 && i2 == 0) {
                            this.Ue.add(b(subList, this.Uj));
                        } else {
                            this.Ue.add(b(subList, -1));
                        }
                    }
                }
            }
            this.Ug = new y(this.Ue);
            this.TX.setAdapter(this.Ug);
            sf();
        }
    }

    private List<GiftCommonList.GiftItem> m(List<GiftCommonList.GiftItem> list) {
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
        u uVar = new u(this);
        uVar.setGiftItems(list);
        uVar.cM(i);
        GridView gridView = new GridView(this);
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setNumColumns(4);
        gridView.setVerticalSpacing(8);
        gridView.setHorizontalSpacing(8);
        gridView.setSelector(com.baidu.tieba.s.transparent);
        gridView.setAdapter((ListAdapter) uVar);
        gridView.setPadding(4, 0, 4, 0);
        gridView.setOnItemClickListener(new q(this, null));
        return gridView;
    }

    public void sf() {
        int i = 0;
        for (int i2 = 0; i2 < this.Um.size(); i2++) {
            for (int i3 = 0; i3 < this.Um.get(i2); i3++) {
                if (i + i3 == this.Ui) {
                    if (this.Um.get(i2) <= 1) {
                        this.TY.setVisibility(4);
                    } else {
                        this.TY.setVisibility(0);
                    }
                    this.TY.setCount(this.Um.get(i2));
                    this.TY.setPosition(i3);
                    cL(i2);
                    return;
                }
            }
            i += this.Um.get(i2);
        }
    }

    private void n(List<GiftCommonList.NumInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (GiftCommonList.NumInfo numInfo : list) {
                if (numInfo.getNum() <= 0) {
                    arrayList.add(numInfo);
                }
            }
            list.removeAll(arrayList);
        }
        this.Uf = new w(this);
        this.Ud.setAdapter((ListAdapter) this.Uf);
        this.Uf.o(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        getLayoutMode().L(z);
        getLayoutMode().h(this.TT);
        getLayoutMode().h(this.Uo);
        if (this.Uf != null) {
            this.Uf.notifyDataSetChanged();
        }
        if (z) {
            this.TY.setSelector(getResources().getDrawable(com.baidu.tieba.u.icon_pagecontrol_on_1));
            this.TY.setDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_pagecontrol_off_1));
            return;
        }
        this.TY.setSelector(getResources().getDrawable(com.baidu.tieba.u.icon_pagecontrol_on));
        this.TY.setDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Uo.getVisibility() == 0) {
                this.Uq.clearFocus();
                this.Uo.setVisibility(8);
                return true;
            } else if (this.Uc.getVisibility() == 0) {
                this.Uc.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int av(boolean z) {
        int i;
        int f = com.baidu.adp.lib.g.c.f(this.TU.getText().toString(), 1);
        if (this.Ul != null) {
            i = this.Ul.getPrice() > 0 ? this.Ul.getPrice() : 1;
        } else {
            i = 1;
        }
        int i2 = i * f;
        if (z) {
            this.TV.setText(String.format(getString(com.baidu.tieba.y.tdou_count_format), az.bB(i2)));
            if (i2 <= 0) {
                aw.h((View) this.TW, com.baidu.tieba.u.btn_gift_give_d);
                this.TW.setEnabled(false);
            } else {
                aw.h((View) this.TW, com.baidu.tieba.u.btn_gift_give_normal);
                this.TW.setEnabled(true);
            }
        }
        return i2;
    }

    public void aw(boolean z) {
        this.TU.setCursorVisible(z);
        this.TU.setFocusable(z);
        this.TU.setFocusableInTouchMode(z);
        if (z) {
            this.TU.requestFocus();
        } else {
            this.TU.clearFocus();
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
        this.Ui = i;
        sf();
        if (i >= 0 && i < this.Ue.size()) {
            GridView gridView = (GridView) this.Ue.get(i);
            if (gridView.getAdapter() != null) {
                u uVar = (u) gridView.getAdapter();
                if (uVar.sg() >= 0 && i != this.Uj) {
                    uVar.cM(-1);
                    uVar.notifyDataSetChanged();
                }
                if (uVar.sg() < 0 && i == this.Uj) {
                    uVar.cM(this.Uk);
                    uVar.notifyDataSetChanged();
                }
            }
        }
    }
}
