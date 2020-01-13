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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteCountDownCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
/* loaded from: classes6.dex */
public class a {
    private RelativeLayout ayz;
    private View azg;
    private View.OnClickListener cGV;
    private LinearLayoutManager ctD;
    private NoNetworkView ehd;
    private PbListView ehe;
    private h eiA;
    private VoteCandidateCard fAa;
    private SearchView fAb;
    private d fAc;
    private FloatMyRecordCard fAd;
    private TextView fAe;
    private int fAf;
    private ViewGroup fAg;
    private BarVoteActivity fzG;
    private int fzM;
    private ViewGroup fzP;
    private TbImageView fzQ;
    private View fzR;
    private View fzS;
    private TextView fzT;
    private BdRecyclerView fzU;
    private VoteStatusCard fzV;
    private View fzW;
    private TextView fzX;
    private TextView fzY;
    private VoteCountDownCard fzZ;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int MH = 3;
    private int status = -1;
    private int fzN = 0;
    private float fzO = 0.0f;
    private View.OnClickListener fAh = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.eiA != null) {
                    a.this.eiA.dettachView(a.this.mListContainer);
                    a.this.eiA = null;
                }
                a.this.fzG.reload();
                if (a.this.fzU != null) {
                    a.this.fzU.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener fAi = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.fzP != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.fzO = Math.abs(a.this.fzP.getTop()) / a.this.fzM;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.fzO);
                a.this.fzS.setAlpha(a.this.fzO);
                if (a.this.fzO > 0.5d) {
                    if (a.this.fzN == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.MH);
                        am.setViewTextColor(a.this.fzT, R.color.cp_cont_b, 1, a.this.MH);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.MH);
                        a.this.fzN = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.fzO * 2.0f) - 1.0f);
                    a.this.fzT.setAlpha((a.this.fzO * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.fzO * 2.0f) - 1.0f);
                } else if (a.this.fzO <= 0.5d) {
                    if (a.this.fzN == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.MH);
                        am.setViewTextColor(a.this.fzT, R.color.cp_cont_a, 1, a.this.MH);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.MH);
                        a.this.fzN = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.fzO * 2.0f));
                    a.this.fzT.setAlpha(1.0f - (a.this.fzO * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.fzO * 2.0f));
                }
            }
        }
    };
    private BdListView.e eyg = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.fzU != null) {
                a.this.fzU.stopScroll();
            }
            if (a.this.ehe != null && a.this.fzG != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.fDM) {
                        a.this.ehe.showEmptyView(l.getDimens(a.this.fzG, R.dimen.tbds152));
                    }
                    a.this.fzU.setNextPage(a.this.ehe);
                    a.this.ehe.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.ehe.showLoading();
                        a.this.fzG.bsc();
                        return;
                    }
                    a.this.ehe.setText(a.this.fzG.getResources().getString(R.string.list_has_no_more));
                    a.this.ehe.endLoadData();
                    return;
                }
                a.this.fzU.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a fAj = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.fzG != null) {
                a.this.fzG.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.fzG = barVoteActivity;
        this.ayz = (RelativeLayout) LayoutInflater.from(this.fzG.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.fzG.addContentView(this.ayz, new FrameLayout.LayoutParams(-1, -1));
        this.fzG.showLoadingView(this.ayz, false, l.getDimens(this.fzG, R.dimen.ds400));
        this.mListContainer = this.ayz.findViewById(R.id.list_container);
        this.fAg = (ViewGroup) this.ayz.findViewById(R.id.no_data_container);
        this.fzR = this.ayz.findViewById(R.id.nav_bar_container);
        this.fzS = this.ayz.findViewById(R.id.nav_bar_shadow);
        this.fzS.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.ayz.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fzG.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.fzM = l.getDimens(this.fzG, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fzT = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.fzG).findViewById(R.id.right_textview);
        this.fzT.setText(R.string.bar_election_rule);
        this.fzT.setOnClickListener(this.fzG);
        this.fzU = (BdRecyclerView) this.ayz.findViewById(R.id.vote_list);
        this.ctD = new LinearLayoutManager(this.fzG);
        this.fzU.setLayoutManager(this.ctD);
        this.fAc = new d(barVoteActivity.getPageContext());
        this.fzU.setAdapter(this.fAc);
        this.fzP = (ViewGroup) LayoutInflater.from(this.fzG).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.fzP.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fzQ = (TbImageView) this.fzP.findViewById(R.id.head_main_iv);
        this.fzQ.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.fzG) * 884) / 1076));
        this.fzU.addHeaderView(this.fzP);
        this.fzU.addOnScrollListener(this.fAi);
        this.fzU.setOnSrollToBottomListener(this.eyg);
        this.fAf = this.fzG.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.azg = new View(this.fzG);
        this.azg.setLayoutParams(new AbsListView.LayoutParams(-1, this.fAf));
        this.azg.setVisibility(4);
        this.fzU.addFooterView(this.azg);
        this.fzV = (VoteStatusCard) this.fzP.findViewById(R.id.vote_status_card);
        this.fzW = this.fzP.findViewById(R.id.vote_ueg_tip_container);
        this.fzW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.fzG);
                View inflate = LayoutInflater.from(a.this.fzG.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.fzG.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.fzG.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aO(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.fzG.getPageContext()).aCp();
            }
        });
        this.fzX = (TextView) this.fzP.findViewById(R.id.vote_ueg_tip_tv);
        this.fzY = (TextView) this.fzP.findViewById(R.id.vote_ueg_tip_img);
        this.fzZ = (VoteCountDownCard) this.fzP.findViewById(R.id.vote_count_down_card);
        this.fzZ.setOnRefreshListener(this.fAj);
        this.fAa = (VoteCandidateCard) this.fzP.findViewById(R.id.vote_for_mine);
        this.fAb = (SearchView) this.fzP.findViewById(R.id.vote_search_view);
        this.fAb.t(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.fzG, a.this.fzG.fid + "")));
            }
        });
        this.fAd = (FloatMyRecordCard) this.ayz.findViewById(R.id.float_my_record_card);
        this.fAe = (TextView) this.fzP.findViewById(R.id.vote_tip);
        this.ehe = new PbListView(this.fzG);
        this.ehe.getView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(l.getDimens(this.fzG, R.dimen.tbds182));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.aFs();
        this.ehd = (NoNetworkView) this.ayz.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bsC;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bsC() != null && (bsC = fVar.bsC()) != null) {
                this.status = bsC.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.fDM) {
                    this.fAb.setVisibility(8);
                    this.fAe.setVisibility(8);
                    this.fAa.setVisibility(8);
                }
            }
            this.fzV.setData(fVar);
            this.fzZ.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.fDL) {
                this.fAa.setData(VoteCandidateCard.fDV, fVar);
            }
            if (this.fAc != null) {
                this.mVoteData = fVar;
                this.fAc.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.fDM) {
                this.fAd.setVisibility(0);
                this.fAd.setData(fVar);
                this.fzW.setVisibility(0);
            } else {
                this.fAd.setVisibility(8);
                this.fzW.setVisibility(8);
            }
            bsl();
            C(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void oU(int i) {
        C(i, false);
    }

    public void C(int i, boolean z) {
        if (z || this.MH != i) {
            this.MH = i;
            if (this.eiA != null) {
                this.eiA.onChangeSkinType();
            }
            am.setBackgroundColor(this.ayz, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.fzU, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.fzO > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.fzT, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.fzO <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bsC() == null || this.mVoteData.bsC().getStatus() > 2 || this.mVoteData.bsC().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.fzT, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.fzT, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.fzS, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.fzQ, R.drawable.pic_bg_recruit, i);
            this.fzV.oU(i);
            this.fzZ.oU(i);
            this.fAa.oU(i);
            this.fAb.oU(i);
            am.setViewTextColor(this.fAe, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.fzX, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.fzY, R.drawable.icon_common_explain12_gray66, i);
            this.fAd.oU(i);
            if (this.ehe != null) {
                this.ehe.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.ehe.changeSkin(i);
            }
            this.ehd.onChangeSkinType(this.fzG.getPageContext(), i);
            if (this.fAc != null) {
                this.fAc.notifyDataSetChanged();
            }
        }
    }

    public void bsl() {
        if (this.status == com.baidu.tieba.barselect.a.d.fDM) {
            this.ehe.showEmptyView(l.getDimens(this.fzG, R.dimen.tbds152));
        }
        this.ehe.setOnClickListener(this.fzG);
        this.fzU.setNextPage(this.ehe);
        if (this.hasMore) {
            this.ehe.showEndLoadData();
            return;
        }
        this.ehe.setText(this.fzG.getResources().getString(R.string.list_has_no_more));
        this.ehe.endLoadData();
    }

    public View getRootView() {
        return this.ayz;
    }

    public BdRecyclerView getListView() {
        return this.fzU;
    }

    public PbListView bsm() {
        return this.ehe;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cGV = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void zw(String str) {
        if (this.eiA != null) {
            this.eiA.dettachView(this.mListContainer);
            this.eiA = null;
        }
        this.fzG.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fzG, this.fAg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.tE(str), null);
            this.mNoDataView.setOnClickListener(this.cGV);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.tE(str));
        this.mNoDataView.onChangeSkinType(this.fzG.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bae() {
        if (this.fzU != null) {
            this.fzU.setVisibility(8);
        }
        this.fzG.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.eiA == null) {
            this.eiA = new h(this.fzG, this.fAh);
        }
        this.eiA.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.eiA.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.eiA.attachView(this.mListContainer, true);
        this.eiA.showRefreshButton();
        this.eiA.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.fzZ != null) {
            this.fzZ.onDestroy();
        }
    }
}
