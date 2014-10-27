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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGift.SendGiftResIdl;
/* loaded from: classes.dex */
public class BuyGiftActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private View TO;
    private View TP;
    private EditText TQ;
    private TextView TR;
    private TextView TS;
    private BaseViewPager TT;
    private IndicatorView TU;
    private LinearLayout TV;
    private View TW;
    private View TX;
    private View TY;
    private ListView TZ;
    private w Ub;
    private y Uc;
    private GiftCommonList Ud;
    private int Ue;
    private int Uf;
    private int Ug;
    private GiftCommonList.GiftItem Uh;
    private View Uk;
    private View Ul;
    private EditText Um;
    private View Un;
    private View Uo;
    private View Up;
    private String mPassword;
    private long mReceiverId;
    private List<View> Ua = new ArrayList();
    private SparseIntArray Ui = new SparseIntArray();
    private boolean Uj = false;
    private final HttpMessageListener Uq = new a(this, CmdConfigHttp.GET_GIFT_LIST);
    private final com.baidu.adp.framework.listener.e Ur = new h(this, 308001);
    private final com.baidu.adp.framework.listener.e Us = new i(this, 308003);
    private final CustomMessageListener Ut = new j(this, 2001233);

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
        rY();
        initData();
    }

    private void rY() {
        this.TO = findViewById(com.baidu.tieba.v.empty_layout);
        this.TO.setOnClickListener(new k(this));
        this.TP = findViewById(com.baidu.tieba.v.gift_list_layout);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        this.TQ = (EditText) findViewById(com.baidu.tieba.v.gift_count_input);
        this.TQ.setSelection(1);
        aw(false);
        this.TQ.addTextChangedListener(new s(this, null));
        this.TQ.setOnClickListener(new l(this, inputMethodManager));
        this.TQ.setOnFocusChangeListener(new n(this, inputMethodManager));
        this.TR = (TextView) findViewById(com.baidu.tieba.v.gift_count_result);
        this.TS = (TextView) findViewById(com.baidu.tieba.v.gift_button);
        this.TS.setEnabled(false);
        this.TS.setOnClickListener(new o(this));
        this.TW = findViewById(com.baidu.tieba.v.gift_lower_layout);
        this.TT = (BaseViewPager) findViewById(com.baidu.tieba.v.gift_viewpager);
        this.TT.setOnPageChangeListener(this);
        this.TU = (IndicatorView) findViewById(com.baidu.tieba.v.gift_tab_indicator);
        this.TV = (LinearLayout) findViewById(com.baidu.tieba.v.gift_tab_layout);
        this.TX = findViewById(com.baidu.tieba.v.gift_progress_layout);
        this.TY = findViewById(com.baidu.tieba.v.gift_num_layout);
        this.TY.setOnClickListener(new p(this));
        this.TZ = (ListView) findViewById(com.baidu.tieba.v.gift_num_list);
        this.TZ.setOnItemClickListener(new r(this, null));
        this.Uk = findViewById(com.baidu.tieba.v.password_dialog);
        this.Uk.setBackgroundResource(com.baidu.tieba.s.result_view);
        this.Uk.setOnClickListener(new b(this, inputMethodManager));
        this.Ul = this.Uk.findViewById(com.baidu.tieba.v.password_dialog_ll);
        this.Ul.setOnClickListener(new d(this));
        this.Um = (EditText) this.Uk.findViewById(com.baidu.tieba.v.password_dialog_input);
        this.Un = this.Uk.findViewById(com.baidu.tieba.v.password_dialog_ok);
        this.Un.setOnClickListener(new e(this));
        this.Uo = this.Uk.findViewById(com.baidu.tieba.v.password_dialog_cancel);
        this.Uo.setOnClickListener(new f(this));
        this.Up = this.Uk.findViewById(com.baidu.tieba.v.password_dialog_warning);
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra(BuyGiftActivityConfig.GIFT_RECEIVER_ID, 0L);
        }
        rZ();
        registerListener();
        sa();
    }

    private void rZ() {
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
        registerListener(this.Uq);
        registerListener(this.Ur);
        registerListener(this.Us);
        registerListener(this.Ut);
    }

    private void sa() {
        this.TX.setVisibility(0);
        this.TW.setVisibility(8);
        this.TY.setVisibility(8);
        aw(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.TQ);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    public void g(int i, String str) {
        if (i != 0 || this.Ud == null || this.Ud.getGiftInfo() == null || this.Ud.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(com.baidu.tieba.y.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.TS.setEnabled(true);
        this.TX.setVisibility(8);
        this.TW.setVisibility(0);
        sc();
    }

    public void sb() {
        if (this.Uh != null && this.mReceiverId > 0) {
            if (this.Uk.getVisibility() == 0) {
                this.Un.setClickable(false);
                this.Uo.setClickable(false);
            }
            this.TS.setEnabled(false);
            this.TX.setVisibility(0);
            RequestSendGiftSocketMessage requestSendGiftSocketMessage = new RequestSendGiftSocketMessage();
            requestSendGiftSocketMessage.setParams(this.mReceiverId, this.Uh.getGiftId(), this.Uh.getPrice(), com.baidu.adp.lib.g.c.f(this.TQ.getText().toString(), 1), 1, this.mPassword);
            sendMessage(requestSendGiftSocketMessage);
        }
    }

    public void a(int i, String str, SendGiftResIdl sendGiftResIdl) {
        if (this.Uk.getVisibility() == 0) {
            this.Un.setClickable(true);
            this.Uo.setClickable(true);
        }
        this.TX.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.Uj) {
            int av = av(false);
            int intValue = (sendGiftResIdl == null || sendGiftResIdl.data == null || sendGiftResIdl.data.money == null) ? 0 : av - sendGiftResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getString(com.baidu.tieba.y.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(this, av)));
        } else if (i == 1990028) {
            if (this.Uk.getVisibility() == 0) {
                this.Up.setVisibility(0);
            }
        } else if (i == 1990019) {
            r(str, 0);
            sa();
        } else if (i == 1990027) {
            this.Uk.setVisibility(0);
            this.Um.setText("");
            this.Up.setVisibility(8);
            this.Um.requestFocus();
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

    private void sc() {
        if (this.Ud != null && this.Ud.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.Ud.getGiftInfo().getTypeInfo();
            j(typeInfo);
            l(typeInfo);
            n(this.Ud.getGiftInfo().getNumInfo());
        }
    }

    private void j(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.TV.removeAllViews();
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
                    this.TV.addView(textView, layoutParams);
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
        int childCount = this.TV.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.TV.getChildAt(i2);
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
            this.Ui.clear();
            this.Ua.clear();
            this.TT.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> m = m(list.get(i).getGiftItems());
                int size = m.size();
                if (size > 0) {
                    if (this.Uh == null) {
                        this.Uh = m.get(0);
                        av(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.Ui.append(i, ceil);
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
                            this.Ua.add(b(subList, this.Uf));
                        } else {
                            this.Ua.add(b(subList, -1));
                        }
                    }
                }
            }
            this.Uc = new y(this.Ua);
            this.TT.setAdapter(this.Uc);
            sd();
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

    public void sd() {
        int i = 0;
        for (int i2 = 0; i2 < this.Ui.size(); i2++) {
            for (int i3 = 0; i3 < this.Ui.get(i2); i3++) {
                if (i + i3 == this.Ue) {
                    if (this.Ui.get(i2) <= 1) {
                        this.TU.setVisibility(4);
                    } else {
                        this.TU.setVisibility(0);
                    }
                    this.TU.setCount(this.Ui.get(i2));
                    this.TU.setPosition(i3);
                    cL(i2);
                    return;
                }
            }
            i += this.Ui.get(i2);
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
        this.Ub = new w(this);
        this.TZ.setAdapter((ListAdapter) this.Ub);
        this.Ub.o(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        getLayoutMode().L(z);
        getLayoutMode().h(this.TP);
        getLayoutMode().h(this.Uk);
        if (this.Ub != null) {
            this.Ub.notifyDataSetChanged();
        }
        if (z) {
            this.TU.setSelector(getResources().getDrawable(com.baidu.tieba.u.icon_pagecontrol_on_1));
            this.TU.setDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_pagecontrol_off_1));
            return;
        }
        this.TU.setSelector(getResources().getDrawable(com.baidu.tieba.u.icon_pagecontrol_on));
        this.TU.setDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Uk.getVisibility() == 0) {
                this.Um.clearFocus();
                this.Uk.setVisibility(8);
                return true;
            } else if (this.TY.getVisibility() == 0) {
                this.TY.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int av(boolean z) {
        int i;
        int f = com.baidu.adp.lib.g.c.f(this.TQ.getText().toString(), 1);
        if (this.Uh != null) {
            i = this.Uh.getPrice() > 0 ? this.Uh.getPrice() : 1;
        } else {
            i = 1;
        }
        int i2 = i * f;
        if (z) {
            this.TR.setText(String.format(getString(com.baidu.tieba.y.tdou_count_format), ay.bB(i2)));
            if (i2 <= 0) {
                aw.h((View) this.TS, com.baidu.tieba.u.btn_gift_give_d);
                this.TS.setEnabled(false);
            } else {
                aw.h((View) this.TS, com.baidu.tieba.u.btn_gift_give_normal);
                this.TS.setEnabled(true);
            }
        }
        return i2;
    }

    public void aw(boolean z) {
        this.TQ.setCursorVisible(z);
        this.TQ.setFocusable(z);
        this.TQ.setFocusableInTouchMode(z);
        if (z) {
            this.TQ.requestFocus();
        } else {
            this.TQ.clearFocus();
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
        this.Ue = i;
        sd();
        if (i >= 0 && i < this.Ua.size()) {
            GridView gridView = (GridView) this.Ua.get(i);
            if (gridView.getAdapter() != null) {
                u uVar = (u) gridView.getAdapter();
                if (uVar.se() >= 0 && i != this.Uf) {
                    uVar.cM(-1);
                    uVar.notifyDataSetChanged();
                }
                if (uVar.se() < 0 && i == this.Uf) {
                    uVar.cM(this.Ug);
                    uVar.notifyDataSetChanged();
                }
            }
        }
    }
}
