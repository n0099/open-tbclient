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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.a;
/* loaded from: classes8.dex */
public class c extends d<MyGiftListActivity> {
    private View bJc;
    private View elg;
    private View.OnClickListener ffD;
    private NavigationBar iDP;
    private MyGiftListActivity jON;
    private NoNetworkView jPc;
    private BdListView jPd;
    private View jPe;
    private View jPf;
    private View jPg;
    private BdListView.e jPh;
    private TextView jPi;
    private TextView jPj;
    private TextView jPk;
    private TextView jPl;
    private TextView jPm;
    private LinearLayout jPn;
    private String jPo;
    private String jPp;
    private b jPq;
    private String jPr;
    private LinearLayout jPs;
    private View jPt;
    private TextView jPu;
    private ImageView jPv;
    private AdapterView.OnItemClickListener jPw;
    private boolean mIsHost;
    private g mPullView;
    private h refreshView;

    public c(MyGiftListActivity myGiftListActivity, BdListView.e eVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.mPullView = null;
        this.jPw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a.C0740a item = c.this.jPq.getItem(i);
                if (item != null && item.aUx > 0 && !StringUtils.isNull(item.aUz)) {
                    if (c.this.mIsHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(c.this.jON.getPageContext().getPageActivity(), item.aUx, item.aUz, item.nameShow, GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    } else if (!j.isNetWorkAvailable()) {
                        c.this.jON.showToast(R.string.neterror);
                    } else {
                        c.this.jON.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.aUx), item.aUz)));
                    }
                }
            }
        };
        this.ffD = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.3
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.myGiftList.MyGiftListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view != c.this.jPk) {
                        if (view == c.this.jPm && !StringUtils.isNull(c.this.jPr)) {
                            be.bsB().b(c.this.jON.getPageContext(), new String[]{c.this.jPr});
                        }
                    } else if (!l.isNetOk()) {
                        UtilHelper.showToast(c.this.jON.getPageContext().getPageActivity(), c.this.jON.getResources().getString(R.string.neterror));
                    } else {
                        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(c.this.jON.getPageContext().getPageActivity(), 0L);
                        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    }
                }
            }
        };
        this.jON = myGiftListActivity;
        this.mIsHost = z;
        this.jPh = eVar;
        initView();
        cMg();
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jPs.setVisibility(8);
        } else {
            this.jPs.setVisibility(0);
        }
    }

    private void initView() {
        this.jON.setContentView(R.layout.my_gift_list_activity);
        this.jPo = null;
        this.elg = this.jON.findViewById(R.id.root);
        this.jPd = (BdListView) this.elg.findViewById(R.id.list_view);
        this.iDP = (NavigationBar) this.elg.findViewById(R.id.navigation_bar);
        if (this.jON.userType == 1) {
            this.iDP.setCenterTextTitle(this.jON.getPageContext().getString(R.string.forum_gift_list));
        } else {
            String format = String.format(this.jON.getPageContext().getString(R.string.he_gift_title), this.jON.cMe());
            if (this.mIsHost) {
                this.iDP.setCenterTextTitle(this.jON.getPageContext().getString(R.string.my_gift_list));
            } else {
                this.iDP.setTitleText(format);
            }
        }
        this.iDP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jPc = (NoNetworkView) this.elg.findViewById(R.id.no_networkview);
        this.jPf = LayoutInflater.from(this.jON.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
        this.jPf.setVisibility(8);
        this.jPe = LayoutInflater.from(this.jON.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
        this.jPe.setVisibility(8);
        this.jPn = (LinearLayout) this.jPe.findViewById(R.id.view_link_info);
        this.jPi = (TextView) this.jPe.findViewById(R.id.textview_gift_number);
        this.jPj = (TextView) this.jPe.findViewById(R.id.textview_tdou_number);
        this.jPk = (TextView) this.jPe.findViewById(R.id.view_get_tdou);
        this.jPl = (TextView) this.jPe.findViewById(R.id.textview_blue_number);
        this.jPm = (TextView) this.jPe.findViewById(R.id.view_get_blue);
        this.jPm.setOnClickListener(this.ffD);
        this.jPk.setOnClickListener(this.ffD);
        this.bJc = LayoutInflater.from(this.jON.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
        this.jPg = this.bJc.findViewById(R.id.gift_footer_lay);
        if (this.mIsHost) {
            this.jPd.addHeaderView(this.jPe);
        } else {
            if (this.jON.userType == 1) {
                this.jPf.setVisibility(0);
                this.jPd.addHeaderView(this.jPf);
            }
            if (TbadkApplication.getInst().isGiftSwitchOn()) {
                this.bJc.setPadding(0, 0, 0, l.getDimens(this.jON.getPageContext().getPageActivity(), R.dimen.ds156));
            }
        }
        this.jPd.addFooterView(this.bJc);
        this.jPq = new b(this.jON, this.mIsHost);
        this.jPd.setAdapter((ListAdapter) this.jPq);
        this.mPullView = new g(this.jON.getPageContext());
        this.jPd.setPullRefresh(this.mPullView);
        this.jPd.setOnSrollToBottomListener(this.jPh);
        this.jPd.setOnItemClickListener(this.jPw);
    }

    public void aR(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.mContext.getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.Vq();
                    c.this.startPullRefresh();
                }
            });
        }
        this.refreshView.setLayoutMargin(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.attachView(this.elg, z);
        this.refreshView.showRefreshButton();
        this.jPs.setVisibility(8);
        this.jPd.setVisibility(8);
    }

    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.elg);
            this.refreshView = null;
            this.jPd.setVisibility(0);
        }
    }

    private void cMg() {
        this.jPs = (LinearLayout) this.jON.findViewById(R.id.gift_relation_ll);
        this.jPu = (TextView) this.jON.findViewById(R.id.gift_relation_text);
        this.jPs.setOnClickListener(this.jON.cMc());
        this.jPt = this.jON.findViewById(R.id.gift_send_gift_top_line);
        this.jPv = (ImageView) this.jON.findViewById(R.id.gift_send_gift_icon);
    }

    public View cMh() {
        return this.jPg;
    }

    public void b(a aVar) {
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jPs.setVisibility(8);
        } else {
            this.jPs.setVisibility(0);
        }
        if (aVar != null) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.cLZ();
        }
        Vq();
        c(aVar);
        d(aVar);
    }

    private void c(a aVar) {
        if (aVar == null || !this.mIsHost) {
            this.jPe.setVisibility(8);
            return;
        }
        this.jPe.setVisibility(0);
        this.jPo = aVar.cMb().aEU;
        this.jPp = aVar.cMb().jOD;
        this.jPr = aVar.urlTitleData.eLM;
        this.jPi.setText(a(R.drawable.icon_gift_my_gift, aVar.cLY(), 0));
        this.jPj.setText(a(R.drawable.icon_gift_my_tdou, aVar.cLZ(), 1));
        this.jPl.setText(a(R.drawable.icon_gift_bluedrill, aVar.jOv, 2));
        this.jPm.setText(aVar.urlTitleData.eLL);
    }

    private SpannableString a(int i, long j, int i2) {
        String str = "[icon]" + at.formatOverBaiwanNum(j);
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ao.getDrawable(i);
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
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.getDimens(this.jON.getPageContext().getPageActivity(), R.dimen.fontsize22));
        UtilHelper.setSpan(spannableString, str, this.jON.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
        UtilHelper.setSpan(spannableString, str, this.jON.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
        return spannableString;
    }

    private void d(a aVar) {
        if (aVar == null || aVar.getGiftList() == null || aVar.getGiftList().size() <= 0) {
            this.bJc.setVisibility(8);
            this.jPs.setVisibility(8);
            this.jPq.setData(null);
            return;
        }
        if (aVar.cMa() != null) {
            if (aVar.cMa().jOB == 1) {
                this.bJc.setVisibility(0);
            } else {
                this.bJc.setVisibility(8);
            }
        }
        this.jPq.setData(aVar.getGiftList());
    }

    public void onChangeSkinType(int i) {
        this.jON.getLayoutMode().setNightMode(i == 1);
        this.jON.getLayoutMode().onModeChanged(this.elg);
        this.jON.getLayoutMode().onModeChanged(this.jPe);
        this.jON.getLayoutMode().onModeChanged(this.jPf);
        this.jON.getLayoutMode().onModeChanged(this.bJc);
        this.iDP.onChangeSkinType(getPageContext(), i);
        this.jPc.onChangeSkinType(this.jON.getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.jPq != null) {
            this.jPq.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.jPt, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jPs, R.color.CAM_X0201);
        ao.setViewTextColor(this.jPu, R.color.CAM_X0302);
        ao.setImageResource(this.jPv, R.drawable.icon_gift_list);
    }

    public void cMi() {
        this.jPd.completePullRefreshPostDelayed(0L);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void h(NoNetworkView.a aVar) {
        this.jPc.a(aVar);
    }

    public void startPullRefresh() {
        this.jPd.setVisibility(0);
        this.jPd.startPullRefresh();
    }
}
