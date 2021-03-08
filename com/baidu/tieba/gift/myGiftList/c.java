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
/* loaded from: classes8.dex */
public class c extends d<MyGiftListActivity> {
    private View bOm;
    private View eoR;
    private View.OnClickListener fjv;
    private NavigationBar iLw;
    private MyGiftListActivity jYF;
    private NoNetworkView jYU;
    private BdListView jYV;
    private View jYW;
    private View jYX;
    private View jYY;
    private BdListView.e jYZ;
    private TextView jZa;
    private TextView jZb;
    private TextView jZc;
    private TextView jZd;
    private TextView jZe;
    private LinearLayout jZf;
    private String jZg;
    private String jZh;
    private b jZi;
    private String jZj;
    private LinearLayout jZk;
    private View jZl;
    private TextView jZm;
    private ImageView jZn;
    private AdapterView.OnItemClickListener jZo;
    private boolean mIsHost;
    private g mPullView;
    private h refreshView;

    public c(MyGiftListActivity myGiftListActivity, BdListView.e eVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.mPullView = null;
        this.jZo = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a.C0748a item = c.this.jZi.getItem(i);
                if (item != null && item.aZc > 0 && !StringUtils.isNull(item.aZe)) {
                    if (c.this.mIsHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(c.this.jYF.getPageContext().getPageActivity(), item.aZc, item.aZe, item.nameShow, GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    } else if (!j.isNetWorkAvailable()) {
                        c.this.jYF.showToast(R.string.neterror);
                    } else {
                        c.this.jYF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.aZc), item.aZe)));
                    }
                }
            }
        };
        this.fjv = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.3
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.myGiftList.MyGiftListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view != c.this.jZc) {
                        if (view == c.this.jZe && !StringUtils.isNull(c.this.jZj)) {
                            bf.bsY().b(c.this.jYF.getPageContext(), new String[]{c.this.jZj});
                        }
                    } else if (!l.isNetOk()) {
                        UtilHelper.showToast(c.this.jYF.getPageContext().getPageActivity(), c.this.jYF.getResources().getString(R.string.neterror));
                    } else {
                        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(c.this.jYF.getPageContext().getPageActivity(), 0L);
                        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    }
                }
            }
        };
        this.jYF = myGiftListActivity;
        this.mIsHost = z;
        this.jYZ = eVar;
        initView();
        cOr();
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jZk.setVisibility(8);
        } else {
            this.jZk.setVisibility(0);
        }
    }

    private void initView() {
        this.jYF.setContentView(R.layout.my_gift_list_activity);
        this.jZg = null;
        this.eoR = this.jYF.findViewById(R.id.root);
        this.jYV = (BdListView) this.eoR.findViewById(R.id.list_view);
        this.iLw = (NavigationBar) this.eoR.findViewById(R.id.navigation_bar);
        if (this.jYF.userType == 1) {
            this.iLw.setCenterTextTitle(this.jYF.getPageContext().getString(R.string.forum_gift_list));
        } else {
            String format = String.format(this.jYF.getPageContext().getString(R.string.he_gift_title), this.jYF.cOp());
            if (this.mIsHost) {
                this.iLw.setCenterTextTitle(this.jYF.getPageContext().getString(R.string.my_gift_list));
            } else {
                this.iLw.setTitleText(format);
            }
        }
        this.iLw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jYU = (NoNetworkView) this.eoR.findViewById(R.id.no_networkview);
        this.jYX = LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
        this.jYX.setVisibility(8);
        this.jYW = LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
        this.jYW.setVisibility(8);
        this.jZf = (LinearLayout) this.jYW.findViewById(R.id.view_link_info);
        this.jZa = (TextView) this.jYW.findViewById(R.id.textview_gift_number);
        this.jZb = (TextView) this.jYW.findViewById(R.id.textview_tdou_number);
        this.jZc = (TextView) this.jYW.findViewById(R.id.view_get_tdou);
        this.jZd = (TextView) this.jYW.findViewById(R.id.textview_blue_number);
        this.jZe = (TextView) this.jYW.findViewById(R.id.view_get_blue);
        this.jZe.setOnClickListener(this.fjv);
        this.jZc.setOnClickListener(this.fjv);
        this.bOm = LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
        this.jYY = this.bOm.findViewById(R.id.gift_footer_lay);
        if (this.mIsHost) {
            this.jYV.addHeaderView(this.jYW);
        } else {
            if (this.jYF.userType == 1) {
                this.jYX.setVisibility(0);
                this.jYV.addHeaderView(this.jYX);
            }
            if (TbadkApplication.getInst().isGiftSwitchOn()) {
                this.bOm.setPadding(0, 0, 0, l.getDimens(this.jYF.getPageContext().getPageActivity(), R.dimen.ds156));
            }
        }
        this.jYV.addFooterView(this.bOm);
        this.jZi = new b(this.jYF, this.mIsHost);
        this.jYV.setAdapter((ListAdapter) this.jZi);
        this.mPullView = new g(this.jYF.getPageContext());
        this.jYV.setPullRefresh(this.mPullView);
        this.jYV.setOnSrollToBottomListener(this.jYZ);
        this.jYV.setOnItemClickListener(this.jZo);
    }

    public void aQ(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.mContext.getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.Xc();
                    c.this.startPullRefresh();
                }
            });
        }
        this.refreshView.setLayoutMargin(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.attachView(this.eoR, z);
        this.refreshView.showRefreshButton();
        this.jZk.setVisibility(8);
        this.jYV.setVisibility(8);
    }

    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.eoR);
            this.refreshView = null;
            this.jYV.setVisibility(0);
        }
    }

    private void cOr() {
        this.jZk = (LinearLayout) this.jYF.findViewById(R.id.gift_relation_ll);
        this.jZm = (TextView) this.jYF.findViewById(R.id.gift_relation_text);
        this.jZk.setOnClickListener(this.jYF.cOn());
        this.jZl = this.jYF.findViewById(R.id.gift_send_gift_top_line);
        this.jZn = (ImageView) this.jYF.findViewById(R.id.gift_send_gift_icon);
    }

    public View cOs() {
        return this.jYY;
    }

    public void b(a aVar) {
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.jZk.setVisibility(8);
        } else {
            this.jZk.setVisibility(0);
        }
        if (aVar != null) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.cOk();
        }
        Xc();
        c(aVar);
        d(aVar);
    }

    private void c(a aVar) {
        if (aVar == null || !this.mIsHost) {
            this.jYW.setVisibility(8);
            return;
        }
        this.jYW.setVisibility(0);
        this.jZg = aVar.cOm().aIQ;
        this.jZh = aVar.cOm().jYv;
        this.jZj = aVar.urlTitleData.ePz;
        this.jZa.setText(a(R.drawable.icon_gift_my_gift, aVar.cOj(), 0));
        this.jZb.setText(a(R.drawable.icon_gift_my_tdou, aVar.cOk(), 1));
        this.jZd.setText(a(R.drawable.icon_gift_bluedrill, aVar.jYn, 2));
        this.jZe.setText(aVar.urlTitleData.ePy);
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
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.getDimens(this.jYF.getPageContext().getPageActivity(), R.dimen.fontsize22));
        UtilHelper.setSpan(spannableString, str, this.jYF.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
        UtilHelper.setSpan(spannableString, str, this.jYF.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
        return spannableString;
    }

    private void d(a aVar) {
        if (aVar == null || aVar.getGiftList() == null || aVar.getGiftList().size() <= 0) {
            this.bOm.setVisibility(8);
            this.jZk.setVisibility(8);
            this.jZi.setData(null);
            return;
        }
        if (aVar.cOl() != null) {
            if (aVar.cOl().jYt == 1) {
                this.bOm.setVisibility(0);
            } else {
                this.bOm.setVisibility(8);
            }
        }
        this.jZi.setData(aVar.getGiftList());
    }

    public void onChangeSkinType(int i) {
        this.jYF.getLayoutMode().setNightMode(i == 1);
        this.jYF.getLayoutMode().onModeChanged(this.eoR);
        this.jYF.getLayoutMode().onModeChanged(this.jYW);
        this.jYF.getLayoutMode().onModeChanged(this.jYX);
        this.jYF.getLayoutMode().onModeChanged(this.bOm);
        this.iLw.onChangeSkinType(getPageContext(), i);
        this.jYU.onChangeSkinType(this.jYF.getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.jZi != null) {
            this.jZi.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.jZl, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jZk, R.color.CAM_X0201);
        ap.setViewTextColor(this.jZm, R.color.CAM_X0302);
        ap.setImageResource(this.jZn, R.drawable.icon_gift_list);
    }

    public void cOt() {
        this.jYV.completePullRefreshPostDelayed(0L);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void h(NoNetworkView.a aVar) {
        this.jYU.a(aVar);
    }

    public void startPullRefresh() {
        this.jYV.setVisibility(0);
        this.jYV.startPullRefresh();
    }
}
