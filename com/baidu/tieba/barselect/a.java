package com.baidu.tieba.barselect;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.b;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CandidateSearchActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
import tbclient.ElectionInfo.NoticeContent;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class a {
    private View bMM;
    private RelativeLayout bMd;
    private View.OnClickListener eHG;
    private LinearLayoutManager eqM;
    private NoNetworkView gAh;
    private PbListView gAi;
    private h gBT;
    private boolean hasMore;
    private View ipA;
    private TextView ipB;
    private SelectRuleView ipC;
    private SearchView ipD;
    private VoteAdapter ipE;
    private FloatMyRecordCard ipF;
    private TextView ipG;
    private int ipH;
    private ViewGroup ipI;
    private BarVoteActivity ipg;
    private int ipm;
    private ViewGroup ipp;
    private TbImageView ipq;
    private View ipr;
    private View ips;
    private TextView ipt;
    private BdRecyclerView ipu;
    private VoteStatusCard ipv;
    private View ipw;
    private TextView ipx;
    private TextView ipy;
    private VoteCandidateCard ipz;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ajU = 3;
    private int status = -1;
    private int ipn = 0;
    private float ipo = 0.0f;
    private View.OnClickListener ipJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gBT != null) {
                    a.this.gBT.dettachView(a.this.mListContainer);
                    a.this.gBT = null;
                }
                a.this.ipg.reload();
                if (a.this.ipu != null) {
                    a.this.ipu.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a ipK = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ipg != null) {
                a.this.ipg.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ipp != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.ipo = Math.abs(a.this.ipp.getTop()) / a.this.ipm;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.ipo);
                a.this.ips.setAlpha(a.this.ipo);
                if (a.this.ipo > 0.5d) {
                    if (a.this.ipn == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.ajU);
                        ap.setViewTextColor(a.this.ipt, R.color.CAM_X0105, 1, a.this.ajU);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, a.this.ajU);
                        a.this.ipn = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.ipo * 2.0f) - 1.0f);
                    a.this.ipt.setAlpha((a.this.ipo * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.ipo * 2.0f) - 1.0f);
                } else if (a.this.ipo <= 0.5d) {
                    if (a.this.ipn == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.ajU);
                        ap.setViewTextColor(a.this.ipt, R.color.CAM_X0101, 1, a.this.ajU);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, a.this.ajU);
                        a.this.ipn = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.ipo * 2.0f));
                    a.this.ipt.setAlpha(1.0f - (a.this.ipo * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.ipo * 2.0f));
                }
            }
        }
    };
    private BdListView.e gVR = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ipu != null) {
                a.this.ipu.stopScroll();
            }
            if (a.this.gAi != null && a.this.ipg != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == d.itl) {
                        a.this.gAi.showEmptyView(l.getDimens(a.this.ipg, R.dimen.tbds152));
                    }
                    a.this.ipu.setNextPage(a.this.gAi);
                    a.this.gAi.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gAi.showLoading();
                        a.this.ipg.cqN();
                        return;
                    }
                    a.this.gAi.setText(a.this.ipg.getResources().getString(R.string.list_has_no_more));
                    a.this.gAi.endLoadData();
                    return;
                }
                a.this.ipu.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        e crp;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.crp() != null && (crp = fVar.crp()) != null) {
                this.status = crp.getStatus();
                if (this.status == d.itl) {
                    this.ipD.setVisibility(8);
                    this.ipG.setVisibility(8);
                    this.ipz.setVisibility(8);
                }
                NoticeContent crm = crp.crm();
                if (crm != null && !TextUtils.isEmpty(crm.public_notice)) {
                    IF(crm.public_notice + "占");
                } else {
                    IF(this.ipg.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.ipv.setData(fVar);
            if (this.ipE != null) {
                this.mVoteData = fVar;
                this.ipE.a(fVar);
            }
            if (this.status == d.itl) {
                this.ipF.setVisibility(0);
                this.ipF.setData(fVar);
                this.ipw.setVisibility(0);
                this.ipA.setVisibility(8);
            } else if (this.status == d.itk) {
                this.ipz.setData(VoteCandidateCard.itx, fVar);
                this.ipF.setVisibility(8);
                this.ipw.setVisibility(8);
                this.ipD.setRank(fVar.crp().crg());
                if (fVar.crq() != null) {
                    ManagerElection crq = fVar.crq();
                    if (!y.isEmpty(crq.vote_condition_pic) || !y.isEmpty(crq.vote_condition_title) || !y.isEmpty(crq.vote_condition)) {
                        this.ipA.setVisibility(0);
                        this.ipC.setData(crq.vote_condition_pic, crq.vote_condition_title, crq.vote_condition);
                    } else {
                        this.ipA.setVisibility(8);
                    }
                } else {
                    this.ipA.setVisibility(8);
                }
            } else {
                this.ipF.setVisibility(8);
                this.ipw.setVisibility(8);
                this.ipA.setVisibility(8);
            }
            cqW();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void IF(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        b bVar = new b(drawable, 0);
        bVar.aM(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.ipx.setText(spannableString);
    }

    public void uu(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ipg = barVoteActivity;
        this.bMd = (RelativeLayout) LayoutInflater.from(this.ipg.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ipg.addContentView(this.bMd, new FrameLayout.LayoutParams(-1, -1));
        this.ipg.showLoadingView(this.bMd, false, l.getDimens(this.ipg, R.dimen.ds400));
        this.mListContainer = this.bMd.findViewById(R.id.list_container);
        this.ipI = (ViewGroup) this.bMd.findViewById(R.id.no_data_container);
        this.ipr = this.bMd.findViewById(R.id.nav_bar_container);
        this.ips = this.bMd.findViewById(R.id.nav_bar_shadow);
        this.ips.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bMd.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ipg.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ipm = l.getDimens(this.ipg, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ipt = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ipg).findViewById(R.id.right_textview);
        this.ipt.setText(R.string.bar_election_rule);
        this.ipt.setOnClickListener(this.ipg);
        this.ipu = (BdRecyclerView) this.bMd.findViewById(R.id.vote_list);
        this.eqM = new LinearLayoutManager(this.ipg);
        this.ipu.setLayoutManager(this.eqM);
        this.ipE = new VoteAdapter(barVoteActivity.getPageContext());
        this.ipu.setAdapter(this.ipE);
        this.ipp = (ViewGroup) LayoutInflater.from(this.ipg).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ipp.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ipq = (TbImageView) this.ipp.findViewById(R.id.head_main_iv);
        this.ipq.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ipg) * 884) / 1076));
        this.ipu.addHeaderView(this.ipp);
        this.ipu.addOnScrollListener(this.ipL);
        this.ipu.setOnSrollToBottomListener(this.gVR);
        this.ipH = this.ipg.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bMM = new View(this.ipg);
        this.bMM.setLayoutParams(new AbsListView.LayoutParams(-1, this.ipH));
        this.bMM.setVisibility(4);
        this.ipu.addFooterView(this.bMM);
        this.ipv = (VoteStatusCard) this.ipp.findViewById(R.id.vote_status_card);
        this.ipw = this.ipp.findViewById(R.id.vote_ueg_tip_container);
        this.ipw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ipg);
                View inflate = LayoutInflater.from(a.this.ipg.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ipg.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ipg.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.bn(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ipg.getPageContext());
                ap.d(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.bqx();
            }
        });
        this.ipx = (TextView) this.ipp.findViewById(R.id.vote_ueg_tip_tv);
        this.ipy = (TextView) this.ipp.findViewById(R.id.vote_ueg_tip_img);
        this.ipv.setOnRefreshListener(this.ipK);
        this.ipA = this.ipp.findViewById(R.id.bar_select_rule_bg);
        this.ipB = (TextView) this.ipp.findViewById(R.id.bar_select_rule_main_title);
        this.ipC = (SelectRuleView) this.ipp.findViewById(R.id.bar_select_rule_container);
        this.ipC.setType(1);
        this.ipz = (VoteCandidateCard) this.ipp.findViewById(R.id.vote_for_mine);
        this.ipD = (SearchView) this.ipp.findViewById(R.id.vote_search_view);
        this.ipD.w(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ipg, a.this.ipg.fid + "")));
            }
        });
        this.ipF = (FloatMyRecordCard) this.bMd.findViewById(R.id.float_my_record_card);
        this.ipG = (TextView) this.ipp.findViewById(R.id.vote_tip);
        this.gAi = new PbListView(this.ipg);
        this.gAi.getView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAi.setHeight(l.getDimens(this.ipg, R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.bud();
        this.gAh = (NoNetworkView) this.bMd.findViewById(R.id.no_network_view);
    }

    public void cqW() {
        if (this.status == d.itl) {
            this.gAi.showEmptyView(l.getDimens(this.ipg, R.dimen.tbds152));
        }
        this.gAi.setOnClickListener(this.ipg);
        this.ipu.setNextPage(this.gAi);
        if (this.hasMore) {
            this.gAi.showEndLoadData();
            return;
        }
        this.gAi.setText(this.ipg.getResources().getString(R.string.list_has_no_more));
        this.gAi.endLoadData();
    }

    public View getRootView() {
        return this.bMd;
    }

    public BdRecyclerView getListView() {
        return this.ipu;
    }

    public PbListView cqX() {
        return this.gAi;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eHG = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void IG(String str) {
        if (this.gBT != null) {
            this.gBT.dettachView(this.mListContainer);
            this.gBT = null;
        }
        this.ipg.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ipg, this.ipI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.BB(str), null);
            this.mNoDataView.setOnClickListener(this.eHG);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.BB(str));
        this.mNoDataView.onChangeSkinType(this.ipg.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bRu() {
        if (this.ipu != null) {
            this.ipu.setVisibility(8);
        }
        this.ipg.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gBT == null) {
            this.gBT = new h(this.ipg, this.ipJ);
        }
        this.gBT.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gBT.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gBT.attachView(this.mListContainer, true);
        this.gBT.showRefreshButton();
        this.gBT.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.ajU != i) {
            this.ajU = i;
            if (this.gBT != null) {
                this.gBT.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bMd, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.ipu, R.color.CAM_X0204, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
                if (this.ipo > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.ipt, R.color.CAM_X0105, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (this.ipo <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.crp() == null || this.mVoteData.crp().getStatus() > 2 || this.mVoteData.crp().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.ipt, R.color.CAM_X0105, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.ipt, R.color.CAM_X0101, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, i);
                    }
                }
                ap.setBackgroundResource(this.ips, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.ipq, R.drawable.pic_bg_recruit, i);
            this.ipv.uu(i);
            this.ipz.uu(i);
            this.ipD.uu(i);
            ap.setBackgroundResource(this.ipA, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.ipB, R.color.CAM_X0105);
            if (this.ipC != null) {
                this.ipC.rH(i);
            }
            ap.setViewTextColor(this.ipG, R.color.CAM_X0109, 1, i);
            ap.setViewTextColor(this.ipx, R.color.CAM_X0108, 1, i);
            ap.setBackgroundResource(this.ipy, R.drawable.icon_common_explain12_gray66, i);
            this.ipF.uu(i);
            if (this.gAi != null) {
                this.gAi.setTextColor(ap.getColor(i, R.color.CAM_X0107));
                this.gAi.changeSkin(i);
            }
            this.gAh.onChangeSkinType(this.ipg.getPageContext(), i);
            if (this.ipE != null) {
                this.ipE.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.ipv != null) {
            this.ipv.onDestroy();
        }
    }
}
