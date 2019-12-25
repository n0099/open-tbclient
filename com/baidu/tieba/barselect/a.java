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
/* loaded from: classes5.dex */
public class a {
    private RelativeLayout axQ;
    private View ayx;
    private View.OnClickListener cGJ;
    private LinearLayoutManager ctr;
    private NoNetworkView egT;
    private PbListView egU;
    private h ehM;
    private int fwB;
    private ViewGroup fwE;
    private TbImageView fwF;
    private View fwG;
    private View fwH;
    private TextView fwI;
    private BdRecyclerView fwJ;
    private VoteStatusCard fwK;
    private View fwL;
    private TextView fwM;
    private TextView fwN;
    private VoteCountDownCard fwO;
    private VoteCandidateCard fwP;
    private SearchView fwQ;
    private d fwR;
    private FloatMyRecordCard fwS;
    private TextView fwT;
    private int fwU;
    private ViewGroup fwV;
    private BarVoteActivity fwv;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int MA = 3;
    private int status = -1;
    private int fwC = 0;
    private float fwD = 0.0f;
    private View.OnClickListener fwW = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.ehM != null) {
                    a.this.ehM.dettachView(a.this.mListContainer);
                    a.this.ehM = null;
                }
                a.this.fwv.reload();
                if (a.this.fwJ != null) {
                    a.this.fwJ.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener fwX = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.fwE != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.fwD = Math.abs(a.this.fwE.getTop()) / a.this.fwB;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.fwD);
                a.this.fwH.setAlpha(a.this.fwD);
                if (a.this.fwD > 0.5d) {
                    if (a.this.fwC == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.MA);
                        am.setViewTextColor(a.this.fwI, R.color.cp_cont_b, 1, a.this.MA);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.MA);
                        a.this.fwC = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.fwD * 2.0f) - 1.0f);
                    a.this.fwI.setAlpha((a.this.fwD * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.fwD * 2.0f) - 1.0f);
                } else if (a.this.fwD <= 0.5d) {
                    if (a.this.fwC == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.MA);
                        am.setViewTextColor(a.this.fwI, R.color.cp_cont_a, 1, a.this.MA);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.MA);
                        a.this.fwC = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.fwD * 2.0f));
                    a.this.fwI.setAlpha(1.0f - (a.this.fwD * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.fwD * 2.0f));
                }
            }
        }
    };
    private BdListView.e ewT = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.fwJ != null) {
                a.this.fwJ.stopScroll();
            }
            if (a.this.egU != null && a.this.fwv != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.fAB) {
                        a.this.egU.showEmptyView(l.getDimens(a.this.fwv, R.dimen.tbds152));
                    }
                    a.this.fwJ.setNextPage(a.this.egU);
                    a.this.egU.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.egU.showLoading();
                        a.this.fwv.bra();
                        return;
                    }
                    a.this.egU.setText(a.this.fwv.getResources().getString(R.string.list_has_no_more));
                    a.this.egU.endLoadData();
                    return;
                }
                a.this.fwJ.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a fwY = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.fwv != null) {
                a.this.fwv.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.fwv = barVoteActivity;
        this.axQ = (RelativeLayout) LayoutInflater.from(this.fwv.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.fwv.addContentView(this.axQ, new FrameLayout.LayoutParams(-1, -1));
        this.fwv.showLoadingView(this.axQ, false, l.getDimens(this.fwv, R.dimen.ds400));
        this.mListContainer = this.axQ.findViewById(R.id.list_container);
        this.fwV = (ViewGroup) this.axQ.findViewById(R.id.no_data_container);
        this.fwG = this.axQ.findViewById(R.id.nav_bar_container);
        this.fwH = this.axQ.findViewById(R.id.nav_bar_shadow);
        this.fwH.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.axQ.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fwv.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.fwB = l.getDimens(this.fwv, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fwI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.fwv).findViewById(R.id.right_textview);
        this.fwI.setText(R.string.bar_election_rule);
        this.fwI.setOnClickListener(this.fwv);
        this.fwJ = (BdRecyclerView) this.axQ.findViewById(R.id.vote_list);
        this.ctr = new LinearLayoutManager(this.fwv);
        this.fwJ.setLayoutManager(this.ctr);
        this.fwR = new d(barVoteActivity.getPageContext());
        this.fwJ.setAdapter(this.fwR);
        this.fwE = (ViewGroup) LayoutInflater.from(this.fwv).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.fwE.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fwF = (TbImageView) this.fwE.findViewById(R.id.head_main_iv);
        this.fwF.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.fwv) * 884) / 1076));
        this.fwJ.addHeaderView(this.fwE);
        this.fwJ.addOnScrollListener(this.fwX);
        this.fwJ.setOnSrollToBottomListener(this.ewT);
        this.fwU = this.fwv.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.ayx = new View(this.fwv);
        this.ayx.setLayoutParams(new AbsListView.LayoutParams(-1, this.fwU));
        this.ayx.setVisibility(4);
        this.fwJ.addFooterView(this.ayx);
        this.fwK = (VoteStatusCard) this.fwE.findViewById(R.id.vote_status_card);
        this.fwL = this.fwE.findViewById(R.id.vote_ueg_tip_container);
        this.fwL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.fwv);
                View inflate = LayoutInflater.from(a.this.fwv.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.fwv.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.fwv.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aK(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.fwv.getPageContext()).aBW();
            }
        });
        this.fwM = (TextView) this.fwE.findViewById(R.id.vote_ueg_tip_tv);
        this.fwN = (TextView) this.fwE.findViewById(R.id.vote_ueg_tip_img);
        this.fwO = (VoteCountDownCard) this.fwE.findViewById(R.id.vote_count_down_card);
        this.fwO.setOnRefreshListener(this.fwY);
        this.fwP = (VoteCandidateCard) this.fwE.findViewById(R.id.vote_for_mine);
        this.fwQ = (SearchView) this.fwE.findViewById(R.id.vote_search_view);
        this.fwQ.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.fwv, a.this.fwv.fid + "")));
            }
        });
        this.fwS = (FloatMyRecordCard) this.axQ.findViewById(R.id.float_my_record_card);
        this.fwT = (TextView) this.fwE.findViewById(R.id.vote_tip);
        this.egU = new PbListView(this.fwv);
        this.egU.getView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(l.getDimens(this.fwv, R.dimen.tbds182));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.aEZ();
        this.egT = (NoNetworkView) this.axQ.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e brA;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.brA() != null && (brA = fVar.brA()) != null) {
                this.status = brA.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.fAB) {
                    this.fwQ.setVisibility(8);
                    this.fwT.setVisibility(8);
                    this.fwP.setVisibility(8);
                }
            }
            this.fwK.setData(fVar);
            this.fwO.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.fAA) {
                this.fwP.setData(VoteCandidateCard.fAK, fVar);
            }
            if (this.fwR != null) {
                this.mVoteData = fVar;
                this.fwR.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.fAB) {
                this.fwS.setVisibility(0);
                this.fwS.setData(fVar);
                this.fwL.setVisibility(0);
            } else {
                this.fwS.setVisibility(8);
                this.fwL.setVisibility(8);
            }
            brj();
            C(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void oT(int i) {
        C(i, false);
    }

    public void C(int i, boolean z) {
        if (z || this.MA != i) {
            this.MA = i;
            if (this.ehM != null) {
                this.ehM.onChangeSkinType();
            }
            am.setBackgroundColor(this.axQ, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.fwJ, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.fwD > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.fwI, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.fwD <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.brA() == null || this.mVoteData.brA().getStatus() > 2 || this.mVoteData.brA().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.fwI, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.fwI, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.fwH, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.fwF, R.drawable.pic_bg_recruit, i);
            this.fwK.oT(i);
            this.fwO.oT(i);
            this.fwP.oT(i);
            this.fwQ.oT(i);
            am.setViewTextColor(this.fwT, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.fwM, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.fwN, R.drawable.icon_common_explain12_gray66, i);
            this.fwS.oT(i);
            if (this.egU != null) {
                this.egU.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.egU.changeSkin(i);
            }
            this.egT.onChangeSkinType(this.fwv.getPageContext(), i);
            if (this.fwR != null) {
                this.fwR.notifyDataSetChanged();
            }
        }
    }

    public void brj() {
        if (this.status == com.baidu.tieba.barselect.a.d.fAB) {
            this.egU.showEmptyView(l.getDimens(this.fwv, R.dimen.tbds152));
        }
        this.egU.setOnClickListener(this.fwv);
        this.fwJ.setNextPage(this.egU);
        if (this.hasMore) {
            this.egU.showEndLoadData();
            return;
        }
        this.egU.setText(this.fwv.getResources().getString(R.string.list_has_no_more));
        this.egU.endLoadData();
    }

    public View getRootView() {
        return this.axQ;
    }

    public BdRecyclerView getListView() {
        return this.fwJ;
    }

    public PbListView brk() {
        return this.egU;
    }

    public void g(View.OnClickListener onClickListener) {
        this.cGJ = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void zm(String str) {
        if (this.ehM != null) {
            this.ehM.dettachView(this.mListContainer);
            this.ehM = null;
        }
        this.fwv.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fwv, this.fwV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.tA(str), null);
            this.mNoDataView.setOnClickListener(this.cGJ);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.tA(str));
        this.mNoDataView.onChangeSkinType(this.fwv.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aZJ() {
        if (this.fwJ != null) {
            this.fwJ.setVisibility(8);
        }
        this.fwv.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.ehM == null) {
            this.ehM = new h(this.fwv, this.fwW);
        }
        this.ehM.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.ehM.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.ehM.attachView(this.mListContainer, true);
        this.ehM.showRefreshButton();
        this.ehM.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.fwO != null) {
            this.fwO.onDestroy();
        }
    }
}
