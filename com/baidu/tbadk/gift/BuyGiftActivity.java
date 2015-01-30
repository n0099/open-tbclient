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
    private EditText aaA;
    private TextView aaB;
    private TextView aaC;
    private BaseViewPager aaD;
    private IndicatorView aaE;
    private LinearLayout aaF;
    private View aaG;
    private View aaH;
    private View aaI;
    private ListView aaJ;
    private w aaL;
    private y aaM;
    private GiftCommonList aaN;
    private int aaO;
    private int aaP;
    private int aaQ;
    private GiftCommonList.GiftItem aaR;
    private View aaU;
    private View aaV;
    private EditText aaW;
    private View aaX;
    private View aaY;
    private View aaZ;
    private View aay;
    private View aaz;
    private String mPassword;
    private long mReceiverId;
    private List<View> aaK = new ArrayList();
    private SparseIntArray aaS = new SparseIntArray();
    private boolean aaT = false;
    private final HttpMessageListener aba = new a(this, CmdConfigHttp.GET_GIFT_LIST);
    private final com.baidu.adp.framework.listener.e abb = new h(this, 308001);
    private final com.baidu.adp.framework.listener.e abc = new i(this, 308003);
    private final CustomMessageListener abd = new j(this, 2001233);

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
        vX();
        initData();
    }

    private void vX() {
        this.aay = findViewById(com.baidu.tieba.w.empty_layout);
        this.aay.setOnClickListener(new k(this));
        this.aaz = findViewById(com.baidu.tieba.w.gift_list_layout);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        this.aaA = (EditText) findViewById(com.baidu.tieba.w.gift_count_input);
        this.aaA.setSelection(1);
        aM(false);
        this.aaA.addTextChangedListener(new s(this, null));
        this.aaA.setOnClickListener(new l(this, inputMethodManager));
        this.aaA.setOnFocusChangeListener(new n(this, inputMethodManager));
        this.aaB = (TextView) findViewById(com.baidu.tieba.w.gift_count_result);
        this.aaC = (TextView) findViewById(com.baidu.tieba.w.gift_button);
        this.aaC.setEnabled(false);
        this.aaC.setOnClickListener(new o(this));
        this.aaG = findViewById(com.baidu.tieba.w.gift_lower_layout);
        this.aaD = (BaseViewPager) findViewById(com.baidu.tieba.w.gift_viewpager);
        this.aaD.setOnPageChangeListener(this);
        this.aaE = (IndicatorView) findViewById(com.baidu.tieba.w.gift_tab_indicator);
        this.aaF = (LinearLayout) findViewById(com.baidu.tieba.w.gift_tab_layout);
        this.aaH = findViewById(com.baidu.tieba.w.gift_progress_layout);
        this.aaI = findViewById(com.baidu.tieba.w.gift_num_layout);
        this.aaI.setOnClickListener(new p(this));
        this.aaJ = (ListView) findViewById(com.baidu.tieba.w.gift_num_list);
        this.aaJ.setOnItemClickListener(new r(this, null));
        this.aaU = findViewById(com.baidu.tieba.w.password_dialog);
        this.aaU.setBackgroundResource(com.baidu.tieba.t.result_view);
        this.aaU.setOnClickListener(new b(this, inputMethodManager));
        this.aaV = this.aaU.findViewById(com.baidu.tieba.w.password_dialog_ll);
        this.aaV.setOnClickListener(new d(this));
        this.aaW = (EditText) this.aaU.findViewById(com.baidu.tieba.w.password_dialog_input);
        this.aaX = this.aaU.findViewById(com.baidu.tieba.w.password_dialog_ok);
        this.aaX.setOnClickListener(new e(this));
        this.aaY = this.aaU.findViewById(com.baidu.tieba.w.password_dialog_cancel);
        this.aaY.setOnClickListener(new f(this));
        this.aaZ = this.aaU.findViewById(com.baidu.tieba.w.password_dialog_warning);
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra(BuyGiftActivityConfig.GIFT_RECEIVER_ID, 0L);
        }
        vT();
        registerListener();
        vY();
    }

    private void vT() {
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
        registerListener(this.aba);
        registerListener(this.abb);
        registerListener(this.abc);
        registerListener(this.abd);
    }

    private void vY() {
        this.aaH.setVisibility(0);
        this.aaG.setVisibility(8);
        this.aaI.setVisibility(8);
        aM(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.aaA);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    public void p(int i, String str) {
        if (i != 0 || this.aaN == null || this.aaN.getGiftInfo() == null || this.aaN.getGiftInfo().getTypeInfo().size() <= 0) {
            if (TextUtils.isEmpty(str)) {
                showToast(z.neterror);
            } else {
                showToast(str);
            }
            closeActivity();
            return;
        }
        this.aaC.setEnabled(true);
        this.aaH.setVisibility(8);
        this.aaG.setVisibility(0);
        wa();
    }

    public void vZ() {
        if (this.aaR != null && this.mReceiverId > 0) {
            if (this.aaU.getVisibility() == 0) {
                this.aaX.setClickable(false);
                this.aaY.setClickable(false);
            }
            this.aaC.setEnabled(false);
            this.aaH.setVisibility(0);
            RequestSendGiftSocketMessage requestSendGiftSocketMessage = new RequestSendGiftSocketMessage();
            requestSendGiftSocketMessage.setParams(this.mReceiverId, this.aaR.getGiftId(), this.aaR.getPrice(), com.baidu.adp.lib.g.c.toInt(this.aaA.getText().toString(), 1), 1, this.mPassword);
            sendMessage(requestSendGiftSocketMessage);
        }
    }

    public void a(int i, String str, SendGiftResIdl sendGiftResIdl) {
        if (this.aaU.getVisibility() == 0) {
            this.aaX.setClickable(true);
            this.aaY.setClickable(true);
        }
        this.aaH.setVisibility(8);
        this.mPassword = "";
        if (i == 1990018 && !this.aaT) {
            int aL = aL(false);
            int intValue = (sendGiftResIdl == null || sendGiftResIdl.data == null || sendGiftResIdl.data.money == null) ? 0 : aL - sendGiftResIdl.data.money.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(z.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), aL)));
        } else if (i == 1990028) {
            if (this.aaU.getVisibility() == 0) {
                this.aaZ.setVisibility(0);
            }
        } else if (i == 1990019) {
            t(str, 0);
            vY();
        } else if (i == 1990027) {
            this.aaU.setVisibility(0);
            this.aaW.setText("");
            this.aaZ.setVisibility(8);
            this.aaW.requestFocus();
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

    private void wa() {
        if (this.aaN != null && this.aaN.getGiftInfo() != null) {
            List<GiftCommonList.TypeInfo> typeInfo = this.aaN.getGiftInfo().getTypeInfo();
            n(typeInfo);
            p(typeInfo);
            r(this.aaN.getGiftInfo().getNumInfo());
        }
    }

    private void n(List<GiftCommonList.TypeInfo> list) {
        if (list != null && list.size() > 0) {
            this.aaF.removeAllViews();
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
                    this.aaF.addView(textView, layoutParams);
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
        int childCount = this.aaF.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) this.aaF.getChildAt(i2);
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
            this.aaS.clear();
            this.aaK.clear();
            this.aaD.setAdapter(null);
            for (int i = 0; i < list.size(); i++) {
                List<GiftCommonList.GiftItem> q = q(list.get(i).getGiftItems());
                int size = q.size();
                if (size > 0) {
                    if (this.aaR == null) {
                        this.aaR = q.get(0);
                        aL(true);
                    }
                    int ceil = (int) Math.ceil(size / 8.0d);
                    this.aaS.append(i, ceil);
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
                            this.aaK.add(b(subList, this.aaP));
                        } else {
                            this.aaK.add(b(subList, -1));
                        }
                    }
                }
            }
            this.aaM = new y(this.aaK);
            this.aaD.setAdapter(this.aaM);
            wb();
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

    public void wb() {
        int i = 0;
        for (int i2 = 0; i2 < this.aaS.size(); i2++) {
            for (int i3 = 0; i3 < this.aaS.get(i2); i3++) {
                if (i + i3 == this.aaO) {
                    if (this.aaS.get(i2) <= 1) {
                        this.aaE.setVisibility(4);
                    } else {
                        this.aaE.setVisibility(0);
                    }
                    this.aaE.setCount(this.aaS.get(i2));
                    this.aaE.setPosition(i3);
                    dr(i2);
                    return;
                }
            }
            i += this.aaS.get(i2);
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
        this.aaL = new w(getPageContext().getPageActivity());
        this.aaJ.setAdapter((ListAdapter) this.aaL);
        this.aaL.s(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        getLayoutMode().ab(z);
        getLayoutMode().h(this.aaz);
        getLayoutMode().h(this.aaU);
        if (this.aaL != null) {
            this.aaL.notifyDataSetChanged();
        }
        if (z) {
            this.aaE.setSelector(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_on_1));
            this.aaE.setDrawable(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_off_1));
            return;
        }
        this.aaE.setSelector(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_on));
        this.aaE.setDrawable(getResources().getDrawable(com.baidu.tieba.v.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aaU.getVisibility() == 0) {
                this.aaW.clearFocus();
                this.aaU.setVisibility(8);
                return true;
            } else if (this.aaI.getVisibility() == 0) {
                this.aaI.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int aL(boolean z) {
        int i;
        int i2 = com.baidu.adp.lib.g.c.toInt(this.aaA.getText().toString(), 1);
        if (this.aaR != null) {
            i = this.aaR.getPrice() > 0 ? this.aaR.getPrice() : 1;
        } else {
            i = 1;
        }
        int i3 = i * i2;
        if (z) {
            this.aaB.setText(String.format(getPageContext().getString(z.tdou_count_format), bf.cf(i3)));
            if (i3 <= 0) {
                bc.i((View) this.aaC, com.baidu.tieba.v.btn_gift_give_d);
                this.aaC.setEnabled(false);
            } else {
                bc.i((View) this.aaC, com.baidu.tieba.v.btn_gift_give_normal);
                this.aaC.setEnabled(true);
            }
        }
        return i3;
    }

    public void aM(boolean z) {
        this.aaA.setCursorVisible(z);
        this.aaA.setFocusable(z);
        this.aaA.setFocusableInTouchMode(z);
        if (z) {
            this.aaA.requestFocus();
        } else {
            this.aaA.clearFocus();
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
        this.aaO = i;
        wb();
        if (i >= 0 && i < this.aaK.size()) {
            GridView gridView = (GridView) this.aaK.get(i);
            if (gridView.getAdapter() != null) {
                u uVar = (u) gridView.getAdapter();
                if (uVar.wc() >= 0 && i != this.aaP) {
                    uVar.ds(-1);
                    uVar.notifyDataSetChanged();
                }
                if (uVar.wc() < 0 && i == this.aaP) {
                    uVar.ds(this.aaQ);
                    uVar.notifyDataSetChanged();
                }
            }
        }
    }
}
