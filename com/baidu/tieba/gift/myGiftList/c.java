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
/* loaded from: classes9.dex */
public class c extends d<MyGiftListActivity> {
    private View bNO;
    private View epV;
    private View.OnClickListener fko;
    private NavigationBar iIw;
    private NoNetworkView jTH;
    private BdListView jTI;
    private View jTJ;
    private View jTK;
    private View jTL;
    private BdListView.e jTM;
    private TextView jTN;
    private TextView jTO;
    private TextView jTP;
    private TextView jTQ;
    private TextView jTR;
    private LinearLayout jTS;
    private String jTT;
    private String jTU;
    private b jTV;
    private String jTW;
    private LinearLayout jTX;
    private View jTY;
    private TextView jTZ;
    private MyGiftListActivity jTs;
    private ImageView jUa;
    private AdapterView.OnItemClickListener jUb;
    private boolean mIsHost;
    private g mPullView;
    private h refreshView;

    public c(MyGiftListActivity myGiftListActivity, BdListView.e eVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.mPullView = null;
        this.jUb = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a.C0757a item = c.this.jTV.getItem(i);
                if (item != null && item.aZk > 0 && !StringUtils.isNull(item.aZm)) {
                    if (c.this.mIsHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(c.this.jTs.getPageContext().getPageActivity(), item.aZk, item.aZm, item.nameShow, GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    } else if (!j.isNetWorkAvailable()) {
                        c.this.jTs.showToast(R.string.neterror);
                    } else {
                        c.this.jTs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.aZk), item.aZm)));
                    }
                }
            }
        };
        this.fko = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.3
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.myGiftList.MyGiftListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view != c.this.jTP) {
                        if (view == c.this.jTR && !StringUtils.isNull(c.this.jTW)) {
                            be.bwv().b(c.this.jTs.getPageContext(), new String[]{c.this.jTW});
                        }
                    } else if (!l.isNetOk()) {
                        UtilHelper.showToast(c.this.jTs.getPageContext().getPageActivity(), c.this.jTs.getResources().getString(R.string.neterror));
                    } else {
                        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(c.this.jTs.getPageContext().getPageActivity(), 0L);
                        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    }
                }
            }
        };
        this.jTs = myGiftListActivity;
        this.mIsHost = z;
        this.jTM = eVar;
        initView();
        cPY();
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jTX.setVisibility(8);
        } else {
            this.jTX.setVisibility(0);
        }
    }

    private void initView() {
        this.jTs.setContentView(R.layout.my_gift_list_activity);
        this.jTT = null;
        this.epV = this.jTs.findViewById(R.id.root);
        this.jTI = (BdListView) this.epV.findViewById(R.id.list_view);
        this.iIw = (NavigationBar) this.epV.findViewById(R.id.navigation_bar);
        if (this.jTs.userType == 1) {
            this.iIw.setCenterTextTitle(this.jTs.getPageContext().getString(R.string.forum_gift_list));
        } else {
            String format = String.format(this.jTs.getPageContext().getString(R.string.he_gift_title), this.jTs.cPW());
            if (this.mIsHost) {
                this.iIw.setCenterTextTitle(this.jTs.getPageContext().getString(R.string.my_gift_list));
            } else {
                this.iIw.setTitleText(format);
            }
        }
        this.iIw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jTH = (NoNetworkView) this.epV.findViewById(R.id.no_networkview);
        this.jTK = LayoutInflater.from(this.jTs.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
        this.jTK.setVisibility(8);
        this.jTJ = LayoutInflater.from(this.jTs.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
        this.jTJ.setVisibility(8);
        this.jTS = (LinearLayout) this.jTJ.findViewById(R.id.view_link_info);
        this.jTN = (TextView) this.jTJ.findViewById(R.id.textview_gift_number);
        this.jTO = (TextView) this.jTJ.findViewById(R.id.textview_tdou_number);
        this.jTP = (TextView) this.jTJ.findViewById(R.id.view_get_tdou);
        this.jTQ = (TextView) this.jTJ.findViewById(R.id.textview_blue_number);
        this.jTR = (TextView) this.jTJ.findViewById(R.id.view_get_blue);
        this.jTR.setOnClickListener(this.fko);
        this.jTP.setOnClickListener(this.fko);
        this.bNO = LayoutInflater.from(this.jTs.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
        this.jTL = this.bNO.findViewById(R.id.gift_footer_lay);
        if (this.mIsHost) {
            this.jTI.addHeaderView(this.jTJ);
        } else {
            if (this.jTs.userType == 1) {
                this.jTK.setVisibility(0);
                this.jTI.addHeaderView(this.jTK);
            }
            if (TbadkApplication.getInst().isGiftSwitchOn()) {
                this.bNO.setPadding(0, 0, 0, l.getDimens(this.jTs.getPageContext().getPageActivity(), R.dimen.ds156));
            }
        }
        this.jTI.addFooterView(this.bNO);
        this.jTV = new b(this.jTs, this.mIsHost);
        this.jTI.setAdapter((ListAdapter) this.jTV);
        this.mPullView = new g(this.jTs.getPageContext());
        this.jTI.setPullRefresh(this.mPullView);
        this.jTI.setOnSrollToBottomListener(this.jTM);
        this.jTI.setOnItemClickListener(this.jUb);
    }

    public void aR(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.mContext.getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.Zj();
                    c.this.startPullRefresh();
                }
            });
        }
        this.refreshView.setLayoutMargin(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.attachView(this.epV, z);
        this.refreshView.showRefreshButton();
        this.jTX.setVisibility(8);
        this.jTI.setVisibility(8);
    }

    public void Zj() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.epV);
            this.refreshView = null;
            this.jTI.setVisibility(0);
        }
    }

    private void cPY() {
        this.jTX = (LinearLayout) this.jTs.findViewById(R.id.gift_relation_ll);
        this.jTZ = (TextView) this.jTs.findViewById(R.id.gift_relation_text);
        this.jTX.setOnClickListener(this.jTs.cPU());
        this.jTY = this.jTs.findViewById(R.id.gift_send_gift_top_line);
        this.jUa = (ImageView) this.jTs.findViewById(R.id.gift_send_gift_icon);
    }

    public View cPZ() {
        return this.jTL;
    }

    public void b(a aVar) {
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jTX.setVisibility(8);
        } else {
            this.jTX.setVisibility(0);
        }
        if (aVar != null) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.cPR();
        }
        Zj();
        c(aVar);
        d(aVar);
    }

    private void c(a aVar) {
        if (aVar == null || !this.mIsHost) {
            this.jTJ.setVisibility(8);
            return;
        }
        this.jTJ.setVisibility(0);
        this.jTT = aVar.cPT().aJH;
        this.jTU = aVar.cPT().jTi;
        this.jTW = aVar.urlTitleData.eQx;
        this.jTN.setText(a(R.drawable.icon_gift_my_gift, aVar.cPQ(), 0));
        this.jTO.setText(a(R.drawable.icon_gift_my_tdou, aVar.cPR(), 1));
        this.jTQ.setText(a(R.drawable.icon_gift_bluedrill, aVar.jTa, 2));
        this.jTR.setText(aVar.urlTitleData.eQw);
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
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.getDimens(this.jTs.getPageContext().getPageActivity(), R.dimen.fontsize22));
        UtilHelper.setSpan(spannableString, str, this.jTs.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
        UtilHelper.setSpan(spannableString, str, this.jTs.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
        return spannableString;
    }

    private void d(a aVar) {
        if (aVar == null || aVar.getGiftList() == null || aVar.getGiftList().size() <= 0) {
            this.bNO.setVisibility(8);
            this.jTX.setVisibility(8);
            this.jTV.setData(null);
            return;
        }
        if (aVar.cPS() != null) {
            if (aVar.cPS().jTg == 1) {
                this.bNO.setVisibility(0);
            } else {
                this.bNO.setVisibility(8);
            }
        }
        this.jTV.setData(aVar.getGiftList());
    }

    public void onChangeSkinType(int i) {
        this.jTs.getLayoutMode().setNightMode(i == 1);
        this.jTs.getLayoutMode().onModeChanged(this.epV);
        this.jTs.getLayoutMode().onModeChanged(this.jTJ);
        this.jTs.getLayoutMode().onModeChanged(this.jTK);
        this.jTs.getLayoutMode().onModeChanged(this.bNO);
        this.iIw.onChangeSkinType(getPageContext(), i);
        this.jTH.onChangeSkinType(this.jTs.getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.jTV != null) {
            this.jTV.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.jTY, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jTX, R.color.CAM_X0201);
        ao.setViewTextColor(this.jTZ, R.color.CAM_X0302);
        ao.setImageResource(this.jUa, R.drawable.icon_gift_list);
    }

    public void cQa() {
        this.jTI.completePullRefreshPostDelayed(0L);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void h(NoNetworkView.a aVar) {
        this.jTH.a(aVar);
    }

    public void startPullRefresh() {
        this.jTI.setVisibility(0);
        this.jTI.startPullRefresh();
    }
}
