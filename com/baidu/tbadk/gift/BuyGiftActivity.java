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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGift.SendGiftResIdl;
/* loaded from: classes.dex */
public class BuyGiftActivity extends BaseActivity<BuyGiftActivity> implements ViewPager.OnPageChangeListener {
    private BaseViewPager aaA;
    private IndicatorView aaB;
    private LinearLayout aaC;
    private View aaD;
    private View aaE;
    private View aaF;
    private ListView aaG;
    private w aaI;
    private y aaJ;
    private GiftCommonList aaK;
    private int aaL;
    private int aaM;
    private int aaN;
    private GiftCommonList.GiftItem aaO;
    private View aaR;
    private View aaS;
    private EditText aaT;
    private View aaU;
    private View aaV;
    private View aaW;
    private View aav;
    private View aaw;
    private EditText aax;
    private TextView aay;
    private TextView aaz;
    private String mPassword;
    private long mReceiverId;
    private List<View> aaH = new ArrayList();
    private SparseIntArray aaP = new SparseIntArray();
    private boolean aaQ = false;
    private final HttpMessageListener aaX = new a(this, CmdConfigHttp.GET_GIFT_LIST);
    private final com.baidu.adp.framework.listener.e aaY = new h(this, 308001);
    private final com.baidu.adp.framework.listener.e aaZ = new i(this, 308003);
    private final CustomMessageListener aba = new j(this, 2001233);

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
        vR();
        initData();
    }

    private void vR() {
        this.aav = findViewById(com.baidu.tieba.w.empty_layout);
        this.aav.setOnClickListener(new k(this));
        this.aaw = findViewById(com.baidu.tieba.w.gift_list_layout);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        this.aax = (EditText) findViewById(com.baidu.tieba.w.gift_count_input);
        this.aax.setSelection(1);
        aM(false);
        this.aax.addTextChangedListener(new s(this, null));
        this.aax.setOnClickListener(new l(this, inputMethodManager));
        this.aax.setOnFocusChangeListener(new n(this, inputMethodManager));
        this.aay = (TextView) findViewById(com.baidu.tieba.w.gift_count_result);
        this.aaz = (TextView) findViewById(com.baidu.tieba.w.gift_button);
        this.aaz.setEnabled(false);
        this.aaz.setOnClickListener(new o(this));
        this.aaD = findViewById(com.baidu.tieba.w.gift_lower_layout);
        this.aaA = (BaseViewPager) findViewById(com.baidu.tieba.w.gift_viewpager);
        this.aaA.setOnPageChangeListener(this);
        this.aaB = (IndicatorView) findViewById(com.baidu.tieba.w.gift_tab_indicator);
        this.aaC = (LinearLayout) findViewById(com.baidu.tieba.w.gift_tab_layout);
        this.aaE = findViewById(com.baidu.tieba.w.gift_progress_layout);
        this.aaF = findViewById(com.baidu.tieba.w.gift_num_layout);
        this.aaF.setOnClickListener(new p(this));
        this.aaG = (ListView) findViewById(com.baidu.tieba.w.gift_num_list);
        this.aaG.setOnItemClickListener(new r(this, null));
        this.aaR = findViewById(com.baidu.tieba.w.password_dialog);
        this.aaR.setBackgroundResource(com.baidu.tieba.t.result_view);
        this.aaR.setOnClickListener(new b(this, inputMethodManager));
        this.aaS = this.aaR.findViewById(com.baidu.tieba.w.password_dialog_ll);
        this.aaS.setOnClickListener(new d(this));
        this.aaT = (EditText) this.aaR.findViewById(com.baidu.tieba.w.password_dialog_input);
        this.aaU = this.aaR.findViewById(com.baidu.tieba.w.password_dialog_ok);
        this.aaU.setOnClickListener(new e(this));
        this.aaV = this.aaR.findViewById(com.baidu.tieba.w.password_dialog_cancel);
        this.aaV.setOnClickListener(new f(this));
        this.aaW = this.aaR.findViewById(com.baidu.tieba.w.password_dialog_warning);
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra(BuyGiftActivityConfig.GIFT_RECEIVER_ID, 0L);
        }
        vN();
        registerListener();
        vS();
    }

    private void vN() {
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
        registerListener(this.aaX);
        registerListener(this.aaY);
        registerListener(this.aaZ);
        registerListener(this.aba);
    }

    private void vS() {
        this.aaE.setVisibility(0);
        this.aaD.setVisibility(8);
        this.aaF.setVisibility(8);
        aM(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.aax);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    public void p(int i, String str) {
        if (i != 0 || this.aaK == null || this.aaK.getGiftInfo() == null || this.aaK.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(z.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.aaz.setEnabled(true);
        this.aaE.setVisibility(8);
        this.aaD.setVisibility(0);
        vU();
    }

    public void vT() {
        if (this.aaO != null && this.mReceiverId > 0) {
            if (this.aaR.getVisibility() == 0) {
                this.aaU.setClickable(false);
                this.aaV.setClickable(false);
            }
            this.aaz.setEnabled(false);
            this.aaE.setVisibility(0);
            RequestSendGiftSocketMessage requestSendGiftSocketMessage = new RequestSendGiftSocketMessage();
            requestSendGiftSocketMessage.setParams(this.mReceiverId, this.aaO.getGiftId(), this.aaO.getPrice(), com.baidu.adp.lib.g.c.toInt(this.aax.getText().toString(), 1), 1, this.mPassword);
            sendMessage(requestSendGiftSocketMessage);
        }
    }

    public void a(int i, String str, SendGiftResIdl sendGiftResIdl) {
        if (this.aaR.getVisibility() == 0) {
            this.aaU.setClickable(true);
            this.aaV.setClickable(true);
        }
        this.aaE.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.aaQ) {
            int aL = aL(false);
            int intValue = (sendGiftResIdl == null || sendGiftResIdl.data == null || sendGiftResIdl.data.money == null) ? 0 : aL - sendGiftResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(z.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), aL)));
        } else if (i == 1990028) {
            if (this.aaR.getVisibility() == 0) {
                this.aaW.setVisibility(0);
            }
        } else if (i == 1990019) {
            t(str, 0);
            vS();
        } else if (i == 1990027) {
            this.aaR.setVisibility(0);
            this.aaT.setText("");
            this.aaW.setVisibility(8);
            this.aaT.requestFocus();
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

    private void vU() {
        if (this.aaK != null && this.aaK.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.aaK.getGiftInfo().getTypeInfo();
            n(typeInfo);
            p(typeInfo);
            r(this.aaK.getGiftInfo().getNumInfo());
        }
    }

    private void n(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.aaC.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            o(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GiftCommonList.TypeInfo typeInfo = list.get(i);
                if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                    TextView textView = (TextView) com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.gift_tab_item, null);
                    bc.j((View) textView, com.baidu.tieba.t.cp_bg_line_e);
                    textView.setText(typeInfo.getTypeName());
                    textView.setOnClickListener(new t(this, i));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setPadding(8, 0, 8, 0);
                    this.aaC.addView(textView, layoutParams);
                }
            }
            dr(0);
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

    private void dr(int i) {
        int childCount = this.aaC.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.aaC.getChildAt(i2);
                if (i2 != i) {
                    bc.b(textView, com.baidu.tieba.t.gift_tab_textcolor_normal, 1);
                } else {
                    bc.b(textView, com.baidu.tieba.t.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void p(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list != null) {
            this.aaP.clear();
            this.aaH.clear();
            this.aaA.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> q = q(list.get(i).getGiftItems());
                int size = q.size();
                if (size > 0) {
                    if (this.aaO == null) {
                        this.aaO = q.get(0);
                        aL(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.aaP.append(i, ceil);
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
                            this.aaH.add(b(subList, this.aaM));
                        } else {
                            this.aaH.add(b(subList, -1));
                        }
                    }
                }
            }
            this.aaJ = new y(this.aaH);
            this.aaA.setAdapter(this.aaJ);
            vV();
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
        uVar.ds(i);
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

    public void vV() {
        int i = 0;
        for (int i2 = 0; i2 < this.aaP.size(); i2++) {
            for (int i3 = 0; i3 < this.aaP.get(i2); i3++) {
                if (i + i3 == this.aaL) {
                    if (this.aaP.get(i2) <= 1) {
                        this.aaB.setVisibility(4);
                    } else {
                        this.aaB.setVisibility(0);
                    }
                    this.aaB.setCount(this.aaP.get(i2));
                    this.aaB.setPosition(i3);
                    dr(i2);
                    return;
                }
            }
            i += this.aaP.get(i2);
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
        this.aaI = new w(getPageContext().getPageActivity());
        this.aaG.setAdapter((ListAdapter) this.aaI);
        this.aaI.s(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        getLayoutMode().ab(z);
        getLayoutMode().h(this.aaw);
        getLayoutMode().h(this.aaR);
        if (this.aaI != null) {
            this.aaI.notifyDataSetChanged();
        }
        if (z) {
            this.aaB.setSelector(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_on_1));
            this.aaB.setDrawable(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_off_1));
            return;
        }
        this.aaB.setSelector(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_on));
        this.aaB.setDrawable(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aaR.getVisibility() == 0) {
                this.aaT.clearFocus();
                this.aaR.setVisibility(8);
                return true;
            } else if (this.aaF.getVisibility() == 0) {
                this.aaF.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int aL(boolean z) {
        int i;
        int i2 = com.baidu.adp.lib.g.c.toInt(this.aax.getText().toString(), 1);
        if (this.aaO != null) {
            i = this.aaO.getPrice() > 0 ? this.aaO.getPrice() : 1;
        } else {
            i = 1;
        }
        int i3 = i * i2;
        if (z) {
            this.aay.setText(String.format(getPageContext().getString(z.tdou_count_format), bf.cf(i3)));
            if (i3 <= 0) {
                bc.i((View) this.aaz, com.baidu.tieba.v.btn_gift_give_d);
                this.aaz.setEnabled(false);
            } else {
                bc.i((View) this.aaz, com.baidu.tieba.v.btn_gift_give_normal);
                this.aaz.setEnabled(true);
            }
        }
        return i3;
    }

    public void aM(boolean z) {
        this.aax.setCursorVisible(z);
        this.aax.setFocusable(z);
        this.aax.setFocusableInTouchMode(z);
        if (z) {
            this.aax.requestFocus();
        } else {
            this.aax.clearFocus();
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
        this.aaL = i;
        vV();
        if (i >= 0 && i < this.aaH.size()) {
            GridView gridView = (GridView) this.aaH.get(i);
            if (gridView.getAdapter() != null) {
                u uVar = (u) gridView.getAdapter();
                if (uVar.vW() >= 0 && i != this.aaM) {
                    uVar.ds(-1);
                    uVar.notifyDataSetChanged();
                }
                if (uVar.vW() < 0 && i == this.aaM) {
                    uVar.ds(this.aaN);
                    uVar.notifyDataSetChanged();
                }
            }
        }
    }
}
