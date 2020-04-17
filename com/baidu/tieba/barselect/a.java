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
    private RelativeLayout aWM;
    private View aXv;
    private LinearLayoutManager cWO;
    private View.OnClickListener dkt;
    private NoNetworkView ePl;
    private PbListView ePm;
    private h eQN;
    private BarVoteActivity ghC;
    private int ghI;
    private ViewGroup ghL;
    private TbImageView ghM;
    private View ghN;
    private View ghO;
    private TextView ghP;
    private BdRecyclerView ghQ;
    private VoteStatusCard ghR;
    private View ghS;
    private TextView ghT;
    private TextView ghU;
    private VoteCandidateCard ghV;
    private View ghW;
    private TextView ghX;
    private SelectRuleView ghY;
    private SearchView ghZ;
    private d gia;
    private FloatMyRecordCard gib;
    private TextView gic;
    private int gie;
    private ViewGroup gif;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int afT = 3;
    private int status = -1;
    private int ghJ = 0;
    private float ghK = 0.0f;
    private View.OnClickListener gig = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.eQN != null) {
                    a.this.eQN.dettachView(a.this.mListContainer);
                    a.this.eQN = null;
                }
                a.this.ghC.reload();
                if (a.this.ghQ != null) {
                    a.this.ghQ.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a gih = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ghC != null) {
                a.this.ghC.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener gii = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ghL != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.ghK = Math.abs(a.this.ghL.getTop()) / a.this.ghI;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.ghK);
                a.this.ghO.setAlpha(a.this.ghK);
                if (a.this.ghK > 0.5d) {
                    if (a.this.ghJ == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.afT);
                        am.setViewTextColor(a.this.ghP, R.color.cp_cont_b, 1, a.this.afT);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.afT);
                        a.this.ghJ = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.ghK * 2.0f) - 1.0f);
                    a.this.ghP.setAlpha((a.this.ghK * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.ghK * 2.0f) - 1.0f);
                } else if (a.this.ghK <= 0.5d) {
                    if (a.this.ghJ == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.afT);
                        am.setViewTextColor(a.this.ghP, R.color.cp_cont_a, 1, a.this.afT);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.afT);
                        a.this.ghJ = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.ghK * 2.0f));
                    a.this.ghP.setAlpha(1.0f - (a.this.ghK * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.ghK * 2.0f));
                }
            }
        }
    };
    private BdListView.e fhr = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ghQ != null) {
                a.this.ghQ.stopScroll();
            }
            if (a.this.ePm != null && a.this.ghC != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.glL) {
                        a.this.ePm.showEmptyView(l.getDimens(a.this.ghC, R.dimen.tbds152));
                    }
                    a.this.ghQ.setNextPage(a.this.ePm);
                    a.this.ePm.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.ePm.showLoading();
                        a.this.ghC.bDz();
                        return;
                    }
                    a.this.ePm.setText(a.this.ghC.getResources().getString(R.string.list_has_no_more));
                    a.this.ePm.endLoadData();
                    return;
                }
                a.this.ghQ.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bDY;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bDY() != null && (bDY = fVar.bDY()) != null) {
                this.status = bDY.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.glL) {
                    this.ghZ.setVisibility(8);
                    this.gic.setVisibility(8);
                    this.ghV.setVisibility(8);
                }
            }
            this.ghR.setData(fVar);
            if (this.gia != null) {
                this.mVoteData = fVar;
                this.gia.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.glL) {
                this.gib.setVisibility(0);
                this.gib.setData(fVar);
                this.ghS.setVisibility(0);
                this.ghW.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.glK) {
                this.ghV.setData(VoteCandidateCard.glX, fVar);
                this.gib.setVisibility(8);
                this.ghS.setVisibility(8);
                this.ghZ.setRank(fVar.bDY().bDQ());
                if (fVar.bDZ() != null) {
                    ManagerElection bDZ = fVar.bDZ();
                    if (!v.isEmpty(bDZ.vote_condition_pic) || !v.isEmpty(bDZ.vote_condition_title) || !v.isEmpty(bDZ.vote_condition)) {
                        this.ghW.setVisibility(0);
                        this.ghY.setData(bDZ.vote_condition_pic, bDZ.vote_condition_title, bDZ.vote_condition);
                    } else {
                        this.ghW.setVisibility(8);
                    }
                } else {
                    this.ghW.setVisibility(8);
                }
            } else {
                this.gib.setVisibility(8);
                this.ghS.setVisibility(8);
                this.ghW.setVisibility(8);
            }
            bDI();
            E(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void pH(int i) {
        E(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ghC = barVoteActivity;
        this.aWM = (RelativeLayout) LayoutInflater.from(this.ghC.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ghC.addContentView(this.aWM, new FrameLayout.LayoutParams(-1, -1));
        this.ghC.showLoadingView(this.aWM, false, l.getDimens(this.ghC, R.dimen.ds400));
        this.mListContainer = this.aWM.findViewById(R.id.list_container);
        this.gif = (ViewGroup) this.aWM.findViewById(R.id.no_data_container);
        this.ghN = this.aWM.findViewById(R.id.nav_bar_container);
        this.ghO = this.aWM.findViewById(R.id.nav_bar_shadow);
        this.ghO.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.aWM.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ghC.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ghI = l.getDimens(this.ghC, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ghC).findViewById(R.id.right_textview);
        this.ghP.setText(R.string.bar_election_rule);
        this.ghP.setOnClickListener(this.ghC);
        this.ghQ = (BdRecyclerView) this.aWM.findViewById(R.id.vote_list);
        this.cWO = new LinearLayoutManager(this.ghC);
        this.ghQ.setLayoutManager(this.cWO);
        this.gia = new d(barVoteActivity.getPageContext());
        this.ghQ.setAdapter(this.gia);
        this.ghL = (ViewGroup) LayoutInflater.from(this.ghC).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ghL.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ghM = (TbImageView) this.ghL.findViewById(R.id.head_main_iv);
        this.ghM.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ghC) * 884) / 1076));
        this.ghQ.addHeaderView(this.ghL);
        this.ghQ.addOnScrollListener(this.gii);
        this.ghQ.setOnSrollToBottomListener(this.fhr);
        this.gie = this.ghC.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aXv = new View(this.ghC);
        this.aXv.setLayoutParams(new AbsListView.LayoutParams(-1, this.gie));
        this.aXv.setVisibility(4);
        this.ghQ.addFooterView(this.aXv);
        this.ghR = (VoteStatusCard) this.ghL.findViewById(R.id.vote_status_card);
        this.ghS = this.ghL.findViewById(R.id.vote_ueg_tip_container);
        this.ghS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ghC);
                View inflate = LayoutInflater.from(a.this.ghC.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ghC.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ghC.getResources().getString(R.string.vote_ueg_tip_detail_2));
                am.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aP(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ghC.getPageContext());
                am.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.aMU();
            }
        });
        this.ghT = (TextView) this.ghL.findViewById(R.id.vote_ueg_tip_tv);
        this.ghU = (TextView) this.ghL.findViewById(R.id.vote_ueg_tip_img);
        this.ghR.setOnRefreshListener(this.gih);
        this.ghW = this.ghL.findViewById(R.id.bar_select_rule_bg);
        this.ghX = (TextView) this.ghL.findViewById(R.id.bar_select_rule_main_title);
        this.ghY = (SelectRuleView) this.ghL.findViewById(R.id.bar_select_rule_container);
        this.ghY.setType(1);
        this.ghV = (VoteCandidateCard) this.ghL.findViewById(R.id.vote_for_mine);
        this.ghZ = (SearchView) this.ghL.findViewById(R.id.vote_search_view);
        this.ghZ.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ghC, a.this.ghC.fid + "")));
            }
        });
        this.gib = (FloatMyRecordCard) this.aWM.findViewById(R.id.float_my_record_card);
        this.gic = (TextView) this.ghL.findViewById(R.id.vote_tip);
        this.ePm = new PbListView(this.ghC);
        this.ePm.getView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.ghC, R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.aQd();
        this.ePl = (NoNetworkView) this.aWM.findViewById(R.id.no_network_view);
    }

    public void bDI() {
        if (this.status == com.baidu.tieba.barselect.a.d.glL) {
            this.ePm.showEmptyView(l.getDimens(this.ghC, R.dimen.tbds152));
        }
        this.ePm.setOnClickListener(this.ghC);
        this.ghQ.setNextPage(this.ePm);
        if (this.hasMore) {
            this.ePm.showEndLoadData();
            return;
        }
        this.ePm.setText(this.ghC.getResources().getString(R.string.list_has_no_more));
        this.ePm.endLoadData();
    }

    public View getRootView() {
        return this.aWM;
    }

    public BdRecyclerView getListView() {
        return this.ghQ;
    }

    public PbListView bDJ() {
        return this.ePm;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkt = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Bv(String str) {
        if (this.eQN != null) {
            this.eQN.dettachView(this.mListContainer);
            this.eQN = null;
        }
        this.ghC.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ghC, this.gif, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.vi(str), null);
            this.mNoDataView.setOnClickListener(this.dkt);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.vi(str));
        this.mNoDataView.onChangeSkinType(this.ghC.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bls() {
        if (this.ghQ != null) {
            this.ghQ.setVisibility(8);
        }
        this.ghC.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.eQN == null) {
            this.eQN = new h(this.ghC, this.gig);
        }
        this.eQN.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.eQN.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.eQN.attachView(this.mListContainer, true);
        this.eQN.showRefreshButton();
        this.eQN.onChangeSkinType();
    }

    public void E(int i, boolean z) {
        if (z || this.afT != i) {
            this.afT = i;
            if (this.eQN != null) {
                this.eQN.onChangeSkinType();
            }
            am.setBackgroundColor(this.aWM, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.ghQ, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.ghK > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.ghP, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.ghK <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bDY() == null || this.mVoteData.bDY().getStatus() > 2 || this.mVoteData.bDY().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.ghP, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.ghP, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.ghO, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.ghM, R.drawable.pic_bg_recruit, i);
            this.ghR.pH(i);
            this.ghV.pH(i);
            this.ghZ.pH(i);
            am.setBackgroundResource(this.ghW, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.ghX, (int) R.color.cp_cont_b);
            if (this.ghY != null) {
                this.ghY.nh(i);
            }
            am.setViewTextColor(this.gic, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.ghT, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.ghU, R.drawable.icon_common_explain12_gray66, i);
            this.gib.pH(i);
            if (this.ePm != null) {
                this.ePm.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.ePm.changeSkin(i);
            }
            this.ePl.onChangeSkinType(this.ghC.getPageContext(), i);
            if (this.gia != null) {
                this.gia.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.ghR != null) {
            this.ghR.onDestroy();
        }
    }
}
