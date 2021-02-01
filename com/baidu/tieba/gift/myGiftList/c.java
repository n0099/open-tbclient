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
    private NavigationBar iJz;
    private NoNetworkView jWE;
    private BdListView jWF;
    private View jWG;
    private View jWH;
    private View jWI;
    private BdListView.e jWJ;
    private TextView jWK;
    private TextView jWL;
    private TextView jWM;
    private TextView jWN;
    private TextView jWO;
    private LinearLayout jWP;
    private String jWQ;
    private String jWR;
    private b jWS;
    private String jWT;
    private LinearLayout jWU;
    private View jWV;
    private TextView jWW;
    private ImageView jWX;
    private AdapterView.OnItemClickListener jWY;
    private MyGiftListActivity jWp;
    private boolean mIsHost;
    private g mPullView;
    private h refreshView;

    public c(MyGiftListActivity myGiftListActivity, BdListView.e eVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.mPullView = null;
        this.jWY = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a.C0741a item = c.this.jWS.getItem(i);
                if (item != null && item.aXC > 0 && !StringUtils.isNull(item.aXE)) {
                    if (c.this.mIsHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(c.this.jWp.getPageContext().getPageActivity(), item.aXC, item.aXE, item.nameShow, GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    } else if (!j.isNetWorkAvailable()) {
                        c.this.jWp.showToast(R.string.neterror);
                    } else {
                        c.this.jWp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.aXC), item.aXE)));
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
                    if (view != c.this.jWM) {
                        if (view == c.this.jWO && !StringUtils.isNull(c.this.jWT)) {
                            bf.bsV().b(c.this.jWp.getPageContext(), new String[]{c.this.jWT});
                        }
                    } else if (!l.isNetOk()) {
                        UtilHelper.showToast(c.this.jWp.getPageContext().getPageActivity(), c.this.jWp.getResources().getString(R.string.neterror));
                    } else {
                        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(c.this.jWp.getPageContext().getPageActivity(), 0L);
                        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    }
                }
            }
        };
        this.jWp = myGiftListActivity;
        this.mIsHost = z;
        this.jWJ = eVar;
        initView();
        cOd();
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jWU.setVisibility(8);
        } else {
            this.jWU.setVisibility(0);
        }
    }

    private void initView() {
        this.jWp.setContentView(R.layout.my_gift_list_activity);
        this.jWQ = null;
        this.eno = this.jWp.findViewById(R.id.root);
        this.jWF = (BdListView) this.eno.findViewById(R.id.list_view);
        this.iJz = (NavigationBar) this.eno.findViewById(R.id.navigation_bar);
        if (this.jWp.userType == 1) {
            this.iJz.setCenterTextTitle(this.jWp.getPageContext().getString(R.string.forum_gift_list));
        } else {
            String format = String.format(this.jWp.getPageContext().getString(R.string.he_gift_title), this.jWp.cOb());
            if (this.mIsHost) {
                this.iJz.setCenterTextTitle(this.jWp.getPageContext().getString(R.string.my_gift_list));
            } else {
                this.iJz.setTitleText(format);
            }
        }
        this.iJz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jWE = (NoNetworkView) this.eno.findViewById(R.id.no_networkview);
        this.jWH = LayoutInflater.from(this.jWp.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
        this.jWH.setVisibility(8);
        this.jWG = LayoutInflater.from(this.jWp.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
        this.jWG.setVisibility(8);
        this.jWP = (LinearLayout) this.jWG.findViewById(R.id.view_link_info);
        this.jWK = (TextView) this.jWG.findViewById(R.id.textview_gift_number);
        this.jWL = (TextView) this.jWG.findViewById(R.id.textview_tdou_number);
        this.jWM = (TextView) this.jWG.findViewById(R.id.view_get_tdou);
        this.jWN = (TextView) this.jWG.findViewById(R.id.textview_blue_number);
        this.jWO = (TextView) this.jWG.findViewById(R.id.view_get_blue);
        this.jWO.setOnClickListener(this.fhT);
        this.jWM.setOnClickListener(this.fhT);
        this.bMM = LayoutInflater.from(this.jWp.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
        this.jWI = this.bMM.findViewById(R.id.gift_footer_lay);
        if (this.mIsHost) {
            this.jWF.addHeaderView(this.jWG);
        } else {
            if (this.jWp.userType == 1) {
                this.jWH.setVisibility(0);
                this.jWF.addHeaderView(this.jWH);
            }
            if (TbadkApplication.getInst().isGiftSwitchOn()) {
                this.bMM.setPadding(0, 0, 0, l.getDimens(this.jWp.getPageContext().getPageActivity(), R.dimen.ds156));
            }
        }
        this.jWF.addFooterView(this.bMM);
        this.jWS = new b(this.jWp, this.mIsHost);
        this.jWF.setAdapter((ListAdapter) this.jWS);
        this.mPullView = new g(this.jWp.getPageContext());
        this.jWF.setPullRefresh(this.mPullView);
        this.jWF.setOnSrollToBottomListener(this.jWJ);
        this.jWF.setOnItemClickListener(this.jWY);
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
        this.jWU.setVisibility(8);
        this.jWF.setVisibility(8);
    }

    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.eno);
            this.refreshView = null;
            this.jWF.setVisibility(0);
        }
    }

    private void cOd() {
        this.jWU = (LinearLayout) this.jWp.findViewById(R.id.gift_relation_ll);
        this.jWW = (TextView) this.jWp.findViewById(R.id.gift_relation_text);
        this.jWU.setOnClickListener(this.jWp.cNZ());
        this.jWV = this.jWp.findViewById(R.id.gift_send_gift_top_line);
        this.jWX = (ImageView) this.jWp.findViewById(R.id.gift_send_gift_icon);
    }

    public View cOe() {
        return this.jWI;
    }

    public void b(a aVar) {
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jWU.setVisibility(8);
        } else {
            this.jWU.setVisibility(0);
        }
        if (aVar != null) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.cNW();
        }
        WZ();
        c(aVar);
        d(aVar);
    }

    private void c(a aVar) {
        if (aVar == null || !this.mIsHost) {
            this.jWG.setVisibility(8);
            return;
        }
        this.jWG.setVisibility(0);
        this.jWQ = aVar.cNY().aHq;
        this.jWR = aVar.cNY().jWf;
        this.jWT = aVar.urlTitleData.eNY;
        this.jWK.setText(a(R.drawable.icon_gift_my_gift, aVar.cNV(), 0));
        this.jWL.setText(a(R.drawable.icon_gift_my_tdou, aVar.cNW(), 1));
        this.jWN.setText(a(R.drawable.icon_gift_bluedrill, aVar.jVX, 2));
        this.jWO.setText(aVar.urlTitleData.eNX);
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
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.getDimens(this.jWp.getPageContext().getPageActivity(), R.dimen.fontsize22));
        UtilHelper.setSpan(spannableString, str, this.jWp.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
        UtilHelper.setSpan(spannableString, str, this.jWp.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
        return spannableString;
    }

    private void d(a aVar) {
        if (aVar == null || aVar.getGiftList() == null || aVar.getGiftList().size() <= 0) {
            this.bMM.setVisibility(8);
            this.jWU.setVisibility(8);
            this.jWS.setData(null);
            return;
        }
        if (aVar.cNX() != null) {
            if (aVar.cNX().jWd == 1) {
                this.bMM.setVisibility(0);
            } else {
                this.bMM.setVisibility(8);
            }
        }
        this.jWS.setData(aVar.getGiftList());
    }

    public void onChangeSkinType(int i) {
        this.jWp.getLayoutMode().setNightMode(i == 1);
        this.jWp.getLayoutMode().onModeChanged(this.eno);
        this.jWp.getLayoutMode().onModeChanged(this.jWG);
        this.jWp.getLayoutMode().onModeChanged(this.jWH);
        this.jWp.getLayoutMode().onModeChanged(this.bMM);
        this.iJz.onChangeSkinType(getPageContext(), i);
        this.jWE.onChangeSkinType(this.jWp.getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.jWS != null) {
            this.jWS.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.jWV, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jWU, R.color.CAM_X0201);
        ap.setViewTextColor(this.jWW, R.color.CAM_X0302);
        ap.setImageResource(this.jWX, R.drawable.icon_gift_list);
    }

    public void cOf() {
        this.jWF.completePullRefreshPostDelayed(0L);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void h(NoNetworkView.a aVar) {
        this.jWE.a(aVar);
    }

    public void startPullRefresh() {
        this.jWF.setVisibility(0);
        this.jWF.startPullRefresh();
    }
}
