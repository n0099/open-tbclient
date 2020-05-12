package com.baidu.tieba.barselect;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CandidateSearchActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class a {
    private RelativeLayout aWR;
    private View aXA;
    private LinearLayoutManager cWT;
    private View.OnClickListener dkx;
    private NoNetworkView ePq;
    private PbListView ePr;
    private h eQS;
    private BarVoteActivity ghI;
    private int ghO;
    private ViewGroup ghR;
    private TbImageView ghS;
    private View ghT;
    private View ghU;
    private TextView ghV;
    private BdRecyclerView ghW;
    private VoteStatusCard ghX;
    private View ghY;
    private TextView ghZ;
    private TextView gia;
    private VoteCandidateCard gib;
    private View gic;
    private TextView gie;
    private SelectRuleView gif;
    private SearchView gig;
    private d gih;
    private FloatMyRecordCard gii;
    private TextView gij;
    private int gik;
    private ViewGroup gil;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int afW = 3;
    private int status = -1;
    private int ghP = 0;
    private float ghQ = 0.0f;
    private View.OnClickListener gim = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.eQS != null) {
                    a.this.eQS.dettachView(a.this.mListContainer);
                    a.this.eQS = null;
                }
                a.this.ghI.reload();
                if (a.this.ghW != null) {
                    a.this.ghW.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a gin = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ghI != null) {
                a.this.ghI.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener gio = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ghR != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.ghQ = Math.abs(a.this.ghR.getTop()) / a.this.ghO;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.ghQ);
                a.this.ghU.setAlpha(a.this.ghQ);
                if (a.this.ghQ > 0.5d) {
                    if (a.this.ghP == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.afW);
                        am.setViewTextColor(a.this.ghV, R.color.cp_cont_b, 1, a.this.afW);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.afW);
                        a.this.ghP = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.ghQ * 2.0f) - 1.0f);
                    a.this.ghV.setAlpha((a.this.ghQ * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.ghQ * 2.0f) - 1.0f);
                } else if (a.this.ghQ <= 0.5d) {
                    if (a.this.ghP == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.afW);
                        am.setViewTextColor(a.this.ghV, R.color.cp_cont_a, 1, a.this.afW);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.afW);
                        a.this.ghP = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.ghQ * 2.0f));
                    a.this.ghV.setAlpha(1.0f - (a.this.ghQ * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.ghQ * 2.0f));
                }
            }
        }
    };
    private BdListView.e fhw = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ghW != null) {
                a.this.ghW.stopScroll();
            }
            if (a.this.ePr != null && a.this.ghI != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.glR) {
                        a.this.ePr.showEmptyView(l.getDimens(a.this.ghI, R.dimen.tbds152));
                    }
                    a.this.ghW.setNextPage(a.this.ePr);
                    a.this.ePr.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.ePr.showLoading();
                        a.this.ghI.bDy();
                        return;
                    }
                    a.this.ePr.setText(a.this.ghI.getResources().getString(R.string.list_has_no_more));
                    a.this.ePr.endLoadData();
                    return;
                }
                a.this.ghW.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bDX;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bDX() != null && (bDX = fVar.bDX()) != null) {
                this.status = bDX.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.glR) {
                    this.gig.setVisibility(8);
                    this.gij.setVisibility(8);
                    this.gib.setVisibility(8);
                }
            }
            this.ghX.setData(fVar);
            if (this.gih != null) {
                this.mVoteData = fVar;
                this.gih.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.glR) {
                this.gii.setVisibility(0);
                this.gii.setData(fVar);
                this.ghY.setVisibility(0);
                this.gic.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.glQ) {
                this.gib.setData(VoteCandidateCard.gmd, fVar);
                this.gii.setVisibility(8);
                this.ghY.setVisibility(8);
                this.gig.setRank(fVar.bDX().bDP());
                if (fVar.bDY() != null) {
                    ManagerElection bDY = fVar.bDY();
                    if (!v.isEmpty(bDY.vote_condition_pic) || !v.isEmpty(bDY.vote_condition_title) || !v.isEmpty(bDY.vote_condition)) {
                        this.gic.setVisibility(0);
                        this.gif.setData(bDY.vote_condition_pic, bDY.vote_condition_title, bDY.vote_condition);
                    } else {
                        this.gic.setVisibility(8);
                    }
                } else {
                    this.gic.setVisibility(8);
                }
            } else {
                this.gii.setVisibility(8);
                this.ghY.setVisibility(8);
                this.gic.setVisibility(8);
            }
            bDH();
            E(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void pH(int i) {
        E(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ghI = barVoteActivity;
        this.aWR = (RelativeLayout) LayoutInflater.from(this.ghI.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ghI.addContentView(this.aWR, new FrameLayout.LayoutParams(-1, -1));
        this.ghI.showLoadingView(this.aWR, false, l.getDimens(this.ghI, R.dimen.ds400));
        this.mListContainer = this.aWR.findViewById(R.id.list_container);
        this.gil = (ViewGroup) this.aWR.findViewById(R.id.no_data_container);
        this.ghT = this.aWR.findViewById(R.id.nav_bar_container);
        this.ghU = this.aWR.findViewById(R.id.nav_bar_shadow);
        this.ghU.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.aWR.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ghI.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ghO = l.getDimens(this.ghI, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghV = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ghI).findViewById(R.id.right_textview);
        this.ghV.setText(R.string.bar_election_rule);
        this.ghV.setOnClickListener(this.ghI);
        this.ghW = (BdRecyclerView) this.aWR.findViewById(R.id.vote_list);
        this.cWT = new LinearLayoutManager(this.ghI);
        this.ghW.setLayoutManager(this.cWT);
        this.gih = new d(barVoteActivity.getPageContext());
        this.ghW.setAdapter(this.gih);
        this.ghR = (ViewGroup) LayoutInflater.from(this.ghI).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ghR.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ghS = (TbImageView) this.ghR.findViewById(R.id.head_main_iv);
        this.ghS.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ghI) * 884) / 1076));
        this.ghW.addHeaderView(this.ghR);
        this.ghW.addOnScrollListener(this.gio);
        this.ghW.setOnSrollToBottomListener(this.fhw);
        this.gik = this.ghI.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aXA = new View(this.ghI);
        this.aXA.setLayoutParams(new AbsListView.LayoutParams(-1, this.gik));
        this.aXA.setVisibility(4);
        this.ghW.addFooterView(this.aXA);
        this.ghX = (VoteStatusCard) this.ghR.findViewById(R.id.vote_status_card);
        this.ghY = this.ghR.findViewById(R.id.vote_ueg_tip_container);
        this.ghY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ghI);
                View inflate = LayoutInflater.from(a.this.ghI.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ghI.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ghI.getResources().getString(R.string.vote_ueg_tip_detail_2));
                am.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aP(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ghI.getPageContext());
                am.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.aMS();
            }
        });
        this.ghZ = (TextView) this.ghR.findViewById(R.id.vote_ueg_tip_tv);
        this.gia = (TextView) this.ghR.findViewById(R.id.vote_ueg_tip_img);
        this.ghX.setOnRefreshListener(this.gin);
        this.gic = this.ghR.findViewById(R.id.bar_select_rule_bg);
        this.gie = (TextView) this.ghR.findViewById(R.id.bar_select_rule_main_title);
        this.gif = (SelectRuleView) this.ghR.findViewById(R.id.bar_select_rule_container);
        this.gif.setType(1);
        this.gib = (VoteCandidateCard) this.ghR.findViewById(R.id.vote_for_mine);
        this.gig = (SearchView) this.ghR.findViewById(R.id.vote_search_view);
        this.gig.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ghI, a.this.ghI.fid + "")));
            }
        });
        this.gii = (FloatMyRecordCard) this.aWR.findViewById(R.id.float_my_record_card);
        this.gij = (TextView) this.ghR.findViewById(R.id.vote_tip);
        this.ePr = new PbListView(this.ghI);
        this.ePr.getView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.ghI, R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.aQa();
        this.ePq = (NoNetworkView) this.aWR.findViewById(R.id.no_network_view);
    }

    public void bDH() {
        if (this.status == com.baidu.tieba.barselect.a.d.glR) {
            this.ePr.showEmptyView(l.getDimens(this.ghI, R.dimen.tbds152));
        }
        this.ePr.setOnClickListener(this.ghI);
        this.ghW.setNextPage(this.ePr);
        if (this.hasMore) {
            this.ePr.showEndLoadData();
            return;
        }
        this.ePr.setText(this.ghI.getResources().getString(R.string.list_has_no_more));
        this.ePr.endLoadData();
    }

    public View getRootView() {
        return this.aWR;
    }

    public BdRecyclerView getListView() {
        return this.ghW;
    }

    public PbListView bDI() {
        return this.ePr;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkx = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void By(String str) {
        if (this.eQS != null) {
            this.eQS.dettachView(this.mListContainer);
            this.eQS = null;
        }
        this.ghI.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ghI, this.gil, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.vl(str), null);
            this.mNoDataView.setOnClickListener(this.dkx);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.vl(str));
        this.mNoDataView.onChangeSkinType(this.ghI.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void blq() {
        if (this.ghW != null) {
            this.ghW.setVisibility(8);
        }
        this.ghI.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.eQS == null) {
            this.eQS = new h(this.ghI, this.gim);
        }
        this.eQS.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.eQS.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.eQS.attachView(this.mListContainer, true);
        this.eQS.showRefreshButton();
        this.eQS.onChangeSkinType();
    }

    public void E(int i, boolean z) {
        if (z || this.afW != i) {
            this.afW = i;
            if (this.eQS != null) {
                this.eQS.onChangeSkinType();
            }
            am.setBackgroundColor(this.aWR, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.ghW, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.ghQ > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.ghV, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.ghQ <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bDX() == null || this.mVoteData.bDX().getStatus() > 2 || this.mVoteData.bDX().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.ghV, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.ghV, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.ghU, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.ghS, R.drawable.pic_bg_recruit, i);
            this.ghX.pH(i);
            this.gib.pH(i);
            this.gig.pH(i);
            am.setBackgroundResource(this.gic, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.gie, (int) R.color.cp_cont_b);
            if (this.gif != null) {
                this.gif.nh(i);
            }
            am.setViewTextColor(this.gij, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.ghZ, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.gia, R.drawable.icon_common_explain12_gray66, i);
            this.gii.pH(i);
            if (this.ePr != null) {
                this.ePr.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.ePr.changeSkin(i);
            }
            this.ePq.onChangeSkinType(this.ghI.getPageContext(), i);
            if (this.gih != null) {
                this.gih.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.ghX != null) {
            this.ghX.onDestroy();
        }
    }
}
