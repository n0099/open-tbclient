package com.baidu.tieba.gift.myGiftList;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.a;
/* loaded from: classes9.dex */
public class c extends d<MyGiftListActivity> {
    private View bMM;
    private View eno;
    private View.OnClickListener fhT;
    private NavigationBar iJN;
    private MyGiftListActivity jWD;
    private NoNetworkView jWS;
    private BdListView jWT;
    private View jWU;
    private View jWV;
    private View jWW;
    private BdListView.e jWX;
    private TextView jWY;
    private TextView jWZ;
    private TextView jXa;
    private TextView jXb;
    private TextView jXc;
    private LinearLayout jXd;
    private String jXe;
    private String jXf;
    private b jXg;
    private String jXh;
    private LinearLayout jXi;
    private View jXj;
    private TextView jXk;
    private ImageView jXl;
    private AdapterView.OnItemClickListener jXm;
    private boolean mIsHost;
    private g mPullView;
    private h refreshView;

    public c(MyGiftListActivity myGiftListActivity, BdListView.e eVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.mPullView = null;
        this.jXm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a.C0742a item = c.this.jXg.getItem(i);
                if (item != null && item.aXC > 0 && !StringUtils.isNull(item.aXE)) {
                    if (c.this.mIsHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(c.this.jWD.getPageContext().getPageActivity(), item.aXC, item.aXE, item.nameShow, GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    } else if (!j.isNetWorkAvailable()) {
                        c.this.jWD.showToast(R.string.neterror);
                    } else {
                        c.this.jWD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.aXC), item.aXE)));
                    }
                }
            }
        };
        this.fhT = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.3
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.myGiftList.MyGiftListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view != c.this.jXa) {
                        if (view == c.this.jXc && !StringUtils.isNull(c.this.jXh)) {
                            bf.bsV().b(c.this.jWD.getPageContext(), new String[]{c.this.jXh});
                        }
                    } else if (!l.isNetOk()) {
                        UtilHelper.showToast(c.this.jWD.getPageContext().getPageActivity(), c.this.jWD.getResources().getString(R.string.neterror));
                    } else {
                        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(c.this.jWD.getPageContext().getPageActivity(), 0L);
                        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    }
                }
            }
        };
        this.jWD = myGiftListActivity;
        this.mIsHost = z;
        this.jWX = eVar;
        initView();
        cOk();
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jXi.setVisibility(8);
        } else {
            this.jXi.setVisibility(0);
        }
    }

    private void initView() {
        this.jWD.setContentView(R.layout.my_gift_list_activity);
        this.jXe = null;
        this.eno = this.jWD.findViewById(R.id.root);
        this.jWT = (BdListView) this.eno.findViewById(R.id.list_view);
        this.iJN = (NavigationBar) this.eno.findViewById(R.id.navigation_bar);
        if (this.jWD.userType == 1) {
            this.iJN.setCenterTextTitle(this.jWD.getPageContext().getString(R.string.forum_gift_list));
        } else {
            String format = String.format(this.jWD.getPageContext().getString(R.string.he_gift_title), this.jWD.cOi());
            if (this.mIsHost) {
                this.iJN.setCenterTextTitle(this.jWD.getPageContext().getString(R.string.my_gift_list));
            } else {
                this.iJN.setTitleText(format);
            }
        }
        this.iJN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jWS = (NoNetworkView) this.eno.findViewById(R.id.no_networkview);
        this.jWV = LayoutInflater.from(this.jWD.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
        this.jWV.setVisibility(8);
        this.jWU = LayoutInflater.from(this.jWD.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
        this.jWU.setVisibility(8);
        this.jXd = (LinearLayout) this.jWU.findViewById(R.id.view_link_info);
        this.jWY = (TextView) this.jWU.findViewById(R.id.textview_gift_number);
        this.jWZ = (TextView) this.jWU.findViewById(R.id.textview_tdou_number);
        this.jXa = (TextView) this.jWU.findViewById(R.id.view_get_tdou);
        this.jXb = (TextView) this.jWU.findViewById(R.id.textview_blue_number);
        this.jXc = (TextView) this.jWU.findViewById(R.id.view_get_blue);
        this.jXc.setOnClickListener(this.fhT);
        this.jXa.setOnClickListener(this.fhT);
        this.bMM = LayoutInflater.from(this.jWD.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
        this.jWW = this.bMM.findViewById(R.id.gift_footer_lay);
        if (this.mIsHost) {
            this.jWT.addHeaderView(this.jWU);
        } else {
            if (this.jWD.userType == 1) {
                this.jWV.setVisibility(0);
                this.jWT.addHeaderView(this.jWV);
            }
            if (TbadkApplication.getInst().isGiftSwitchOn()) {
                this.bMM.setPadding(0, 0, 0, l.getDimens(this.jWD.getPageContext().getPageActivity(), R.dimen.ds156));
            }
        }
        this.jWT.addFooterView(this.bMM);
        this.jXg = new b(this.jWD, this.mIsHost);
        this.jWT.setAdapter((ListAdapter) this.jXg);
        this.mPullView = new g(this.jWD.getPageContext());
        this.jWT.setPullRefresh(this.mPullView);
        this.jWT.setOnSrollToBottomListener(this.jWX);
        this.jWT.setOnItemClickListener(this.jXm);
    }

    public void aQ(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.mContext.getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.WZ();
                    c.this.startPullRefresh();
                }
            });
        }
        this.refreshView.setLayoutMargin(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.attachView(this.eno, z);
        this.refreshView.showRefreshButton();
        this.jXi.setVisibility(8);
        this.jWT.setVisibility(8);
    }

    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.eno);
            this.refreshView = null;
            this.jWT.setVisibility(0);
        }
    }

    private void cOk() {
        this.jXi = (LinearLayout) this.jWD.findViewById(R.id.gift_relation_ll);
        this.jXk = (TextView) this.jWD.findViewById(R.id.gift_relation_text);
        this.jXi.setOnClickListener(this.jWD.cOg());
        this.jXj = this.jWD.findViewById(R.id.gift_send_gift_top_line);
        this.jXl = (ImageView) this.jWD.findViewById(R.id.gift_send_gift_icon);
    }

    public View cOl() {
        return this.jWW;
    }

    public void b(a aVar) {
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jXi.setVisibility(8);
        } else {
            this.jXi.setVisibility(0);
        }
        if (aVar != null) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.cOd();
        }
        WZ();
        c(aVar);
        d(aVar);
    }

    private void c(a aVar) {
        if (aVar == null || !this.mIsHost) {
            this.jWU.setVisibility(8);
            return;
        }
        this.jWU.setVisibility(0);
        this.jXe = aVar.cOf().aHq;
        this.jXf = aVar.cOf().jWt;
        this.jXh = aVar.urlTitleData.eNY;
        this.jWY.setText(a(R.drawable.icon_gift_my_gift, aVar.cOc(), 0));
        this.jWZ.setText(a(R.drawable.icon_gift_my_tdou, aVar.cOd(), 1));
        this.jXb.setText(a(R.drawable.icon_gift_bluedrill, aVar.jWl, 2));
        this.jXc.setText(aVar.urlTitleData.eNX);
    }

    private SpannableString a(int i, long j, int i2) {
        String str = "[icon]" + au.formatOverBaiwanNum(j);
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(i);
        int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30);
        if (i2 == 2) {
            drawable.setBounds(0, 3, dimens, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26));
        } else {
            drawable.setBounds(0, 0, dimens, dimens);
        }
        if (TbadkApplication.getInst().getSkinType() == 1) {
            drawable.setAlpha(179);
        } else {
            drawable.setAlpha(255);
        }
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(drawable);
        dVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.getDimens(this.jWD.getPageContext().getPageActivity(), R.dimen.fontsize22));
        UtilHelper.setSpan(spannableString, str, this.jWD.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
        UtilHelper.setSpan(spannableString, str, this.jWD.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
        return spannableString;
    }

    private void d(a aVar) {
        if (aVar == null || aVar.getGiftList() == null || aVar.getGiftList().size() <= 0) {
            this.bMM.setVisibility(8);
            this.jXi.setVisibility(8);
            this.jXg.setData(null);
            return;
        }
        if (aVar.cOe() != null) {
            if (aVar.cOe().jWr == 1) {
                this.bMM.setVisibility(0);
            } else {
                this.bMM.setVisibility(8);
            }
        }
        this.jXg.setData(aVar.getGiftList());
    }

    public void onChangeSkinType(int i) {
        this.jWD.getLayoutMode().setNightMode(i == 1);
        this.jWD.getLayoutMode().onModeChanged(this.eno);
        this.jWD.getLayoutMode().onModeChanged(this.jWU);
        this.jWD.getLayoutMode().onModeChanged(this.jWV);
        this.jWD.getLayoutMode().onModeChanged(this.bMM);
        this.iJN.onChangeSkinType(getPageContext(), i);
        this.jWS.onChangeSkinType(this.jWD.getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.jXg != null) {
            this.jXg.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.jXj, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jXi, R.color.CAM_X0201);
        ap.setViewTextColor(this.jXk, R.color.CAM_X0302);
        ap.setImageResource(this.jXl, R.drawable.icon_gift_list);
    }

    public void cOm() {
        this.jWT.completePullRefreshPostDelayed(0L);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void h(NoNetworkView.a aVar) {
        this.jWS.a(aVar);
    }

    public void startPullRefresh() {
        this.jWT.setVisibility(0);
        this.jWT.startPullRefresh();
    }
}
