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
/* loaded from: classes8.dex */
public class a {
    private RelativeLayout aCQ;
    private View aDx;
    private View.OnClickListener cKZ;
    private LinearLayoutManager cxF;
    private NoNetworkView eli;
    private PbListView elj;
    private h emJ;
    private VoteCandidateCard fCA;
    private SearchView fCB;
    private d fCC;
    private FloatMyRecordCard fCD;
    private TextView fCE;
    private int fCF;
    private ViewGroup fCG;
    private BarVoteActivity fCg;
    private int fCm;
    private ViewGroup fCp;
    private TbImageView fCq;
    private View fCr;
    private View fCs;
    private TextView fCt;
    private BdRecyclerView fCu;
    private VoteStatusCard fCv;
    private View fCw;
    private TextView fCx;
    private TextView fCy;
    private VoteCountDownCard fCz;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int Ni = 3;
    private int status = -1;
    private int fCn = 0;
    private float fCo = 0.0f;
    private View.OnClickListener fCH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.emJ != null) {
                    a.this.emJ.dettachView(a.this.mListContainer);
                    a.this.emJ = null;
                }
                a.this.fCg.reload();
                if (a.this.fCu != null) {
                    a.this.fCu.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener fCI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.fCp != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.fCo = Math.abs(a.this.fCp.getTop()) / a.this.fCm;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.fCo);
                a.this.fCs.setAlpha(a.this.fCo);
                if (a.this.fCo > 0.5d) {
                    if (a.this.fCn == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.Ni);
                        am.setViewTextColor(a.this.fCt, R.color.cp_cont_b, 1, a.this.Ni);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.Ni);
                        a.this.fCn = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.fCo * 2.0f) - 1.0f);
                    a.this.fCt.setAlpha((a.this.fCo * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.fCo * 2.0f) - 1.0f);
                } else if (a.this.fCo <= 0.5d) {
                    if (a.this.fCn == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.Ni);
                        am.setViewTextColor(a.this.fCt, R.color.cp_cont_a, 1, a.this.Ni);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.Ni);
                        a.this.fCn = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.fCo * 2.0f));
                    a.this.fCt.setAlpha(1.0f - (a.this.fCo * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.fCo * 2.0f));
                }
            }
        }
    };
    private BdListView.e eCp = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.fCu != null) {
                a.this.fCu.stopScroll();
            }
            if (a.this.elj != null && a.this.fCg != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.fGl) {
                        a.this.elj.showEmptyView(l.getDimens(a.this.fCg, R.dimen.tbds152));
                    }
                    a.this.fCu.setNextPage(a.this.elj);
                    a.this.elj.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.elj.showLoading();
                        a.this.fCg.btI();
                        return;
                    }
                    a.this.elj.setText(a.this.fCg.getResources().getString(R.string.list_has_no_more));
                    a.this.elj.endLoadData();
                    return;
                }
                a.this.fCu.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a fCJ = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.fCg != null) {
                a.this.fCg.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.fCg = barVoteActivity;
        this.aCQ = (RelativeLayout) LayoutInflater.from(this.fCg.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.fCg.addContentView(this.aCQ, new FrameLayout.LayoutParams(-1, -1));
        this.fCg.showLoadingView(this.aCQ, false, l.getDimens(this.fCg, R.dimen.ds400));
        this.mListContainer = this.aCQ.findViewById(R.id.list_container);
        this.fCG = (ViewGroup) this.aCQ.findViewById(R.id.no_data_container);
        this.fCr = this.aCQ.findViewById(R.id.nav_bar_container);
        this.fCs = this.aCQ.findViewById(R.id.nav_bar_shadow);
        this.fCs.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.aCQ.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fCg.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.fCm = l.getDimens(this.fCg, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fCt = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.fCg).findViewById(R.id.right_textview);
        this.fCt.setText(R.string.bar_election_rule);
        this.fCt.setOnClickListener(this.fCg);
        this.fCu = (BdRecyclerView) this.aCQ.findViewById(R.id.vote_list);
        this.cxF = new LinearLayoutManager(this.fCg);
        this.fCu.setLayoutManager(this.cxF);
        this.fCC = new d(barVoteActivity.getPageContext());
        this.fCu.setAdapter(this.fCC);
        this.fCp = (ViewGroup) LayoutInflater.from(this.fCg).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.fCp.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fCq = (TbImageView) this.fCp.findViewById(R.id.head_main_iv);
        this.fCq.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.fCg) * 884) / 1076));
        this.fCu.addHeaderView(this.fCp);
        this.fCu.addOnScrollListener(this.fCI);
        this.fCu.setOnSrollToBottomListener(this.eCp);
        this.fCF = this.fCg.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aDx = new View(this.fCg);
        this.aDx.setLayoutParams(new AbsListView.LayoutParams(-1, this.fCF));
        this.aDx.setVisibility(4);
        this.fCu.addFooterView(this.aDx);
        this.fCv = (VoteStatusCard) this.fCp.findViewById(R.id.vote_status_card);
        this.fCw = this.fCp.findViewById(R.id.vote_ueg_tip_container);
        this.fCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.fCg);
                View inflate = LayoutInflater.from(a.this.fCg.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.fCg.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.fCg.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aO(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.fCg.getPageContext()).aEC();
            }
        });
        this.fCx = (TextView) this.fCp.findViewById(R.id.vote_ueg_tip_tv);
        this.fCy = (TextView) this.fCp.findViewById(R.id.vote_ueg_tip_img);
        this.fCz = (VoteCountDownCard) this.fCp.findViewById(R.id.vote_count_down_card);
        this.fCz.setOnRefreshListener(this.fCJ);
        this.fCA = (VoteCandidateCard) this.fCp.findViewById(R.id.vote_for_mine);
        this.fCB = (SearchView) this.fCp.findViewById(R.id.vote_search_view);
        this.fCB.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.fCg, a.this.fCg.fid + "")));
            }
        });
        this.fCD = (FloatMyRecordCard) this.aCQ.findViewById(R.id.float_my_record_card);
        this.fCE = (TextView) this.fCp.findViewById(R.id.vote_tip);
        this.elj = new PbListView(this.fCg);
        this.elj.getView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(l.getDimens(this.fCg, R.dimen.tbds182));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.aHG();
        this.eli = (NoNetworkView) this.aCQ.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bui;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bui() != null && (bui = fVar.bui()) != null) {
                this.status = bui.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.fGl) {
                    this.fCB.setVisibility(8);
                    this.fCE.setVisibility(8);
                    this.fCA.setVisibility(8);
                }
            }
            this.fCv.setData(fVar);
            this.fCz.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.fGk) {
                this.fCA.setData(VoteCandidateCard.fGu, fVar);
            }
            if (this.fCC != null) {
                this.mVoteData = fVar;
                this.fCC.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.fGl) {
                this.fCD.setVisibility(0);
                this.fCD.setData(fVar);
                this.fCw.setVisibility(0);
            } else {
                this.fCD.setVisibility(8);
                this.fCw.setVisibility(8);
            }
            btR();
            B(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void pk(int i) {
        B(i, false);
    }

    public void B(int i, boolean z) {
        if (z || this.Ni != i) {
            this.Ni = i;
            if (this.emJ != null) {
                this.emJ.onChangeSkinType();
            }
            am.setBackgroundColor(this.aCQ, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.fCu, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.fCo > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.fCt, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.fCo <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bui() == null || this.mVoteData.bui().getStatus() > 2 || this.mVoteData.bui().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.fCt, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.fCt, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.fCs, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.fCq, R.drawable.pic_bg_recruit, i);
            this.fCv.pk(i);
            this.fCz.pk(i);
            this.fCA.pk(i);
            this.fCB.pk(i);
            am.setViewTextColor(this.fCE, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.fCx, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.fCy, R.drawable.icon_common_explain12_gray66, i);
            this.fCD.pk(i);
            if (this.elj != null) {
                this.elj.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.elj.changeSkin(i);
            }
            this.eli.onChangeSkinType(this.fCg.getPageContext(), i);
            if (this.fCC != null) {
                this.fCC.notifyDataSetChanged();
            }
        }
    }

    public void btR() {
        if (this.status == com.baidu.tieba.barselect.a.d.fGl) {
            this.elj.showEmptyView(l.getDimens(this.fCg, R.dimen.tbds152));
        }
        this.elj.setOnClickListener(this.fCg);
        this.fCu.setNextPage(this.elj);
        if (this.hasMore) {
            this.elj.showEndLoadData();
            return;
        }
        this.elj.setText(this.fCg.getResources().getString(R.string.list_has_no_more));
        this.elj.endLoadData();
    }

    public View getRootView() {
        return this.aCQ;
    }

    public BdRecyclerView getListView() {
        return this.fCu;
    }

    public PbListView btS() {
        return this.elj;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKZ = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void zM(String str) {
        if (this.emJ != null) {
            this.emJ.dettachView(this.mListContainer);
            this.emJ = null;
        }
        this.fCg.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fCg, this.fCG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.tU(str), null);
            this.mNoDataView.setOnClickListener(this.cKZ);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.tU(str));
        this.mNoDataView.onChangeSkinType(this.fCg.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bcw() {
        if (this.fCu != null) {
            this.fCu.setVisibility(8);
        }
        this.fCg.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.emJ == null) {
            this.emJ = new h(this.fCg, this.fCH);
        }
        this.emJ.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.emJ.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.emJ.attachView(this.mListContainer, true);
        this.emJ.showRefreshButton();
        this.emJ.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.fCz != null) {
            this.fCz.onDestroy();
        }
    }
}
