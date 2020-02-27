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
    private RelativeLayout aCP;
    private View aDw;
    private View.OnClickListener cKY;
    private LinearLayoutManager cxE;
    private NoNetworkView elh;
    private PbListView eli;
    private h emI;
    private d fCA;
    private FloatMyRecordCard fCB;
    private TextView fCC;
    private int fCD;
    private ViewGroup fCE;
    private BarVoteActivity fCe;
    private int fCk;
    private ViewGroup fCn;
    private TbImageView fCo;
    private View fCp;
    private View fCq;
    private TextView fCr;
    private BdRecyclerView fCs;
    private VoteStatusCard fCt;
    private View fCu;
    private TextView fCv;
    private TextView fCw;
    private VoteCountDownCard fCx;
    private VoteCandidateCard fCy;
    private SearchView fCz;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int Ni = 3;
    private int status = -1;
    private int fCl = 0;
    private float fCm = 0.0f;
    private View.OnClickListener fCF = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.emI != null) {
                    a.this.emI.dettachView(a.this.mListContainer);
                    a.this.emI = null;
                }
                a.this.fCe.reload();
                if (a.this.fCs != null) {
                    a.this.fCs.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener fCG = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.fCn != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.fCm = Math.abs(a.this.fCn.getTop()) / a.this.fCk;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.fCm);
                a.this.fCq.setAlpha(a.this.fCm);
                if (a.this.fCm > 0.5d) {
                    if (a.this.fCl == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.Ni);
                        am.setViewTextColor(a.this.fCr, R.color.cp_cont_b, 1, a.this.Ni);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.Ni);
                        a.this.fCl = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.fCm * 2.0f) - 1.0f);
                    a.this.fCr.setAlpha((a.this.fCm * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.fCm * 2.0f) - 1.0f);
                } else if (a.this.fCm <= 0.5d) {
                    if (a.this.fCl == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.Ni);
                        am.setViewTextColor(a.this.fCr, R.color.cp_cont_a, 1, a.this.Ni);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.Ni);
                        a.this.fCl = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.fCm * 2.0f));
                    a.this.fCr.setAlpha(1.0f - (a.this.fCm * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.fCm * 2.0f));
                }
            }
        }
    };
    private BdListView.e eCo = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.fCs != null) {
                a.this.fCs.stopScroll();
            }
            if (a.this.eli != null && a.this.fCe != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.fGj) {
                        a.this.eli.showEmptyView(l.getDimens(a.this.fCe, R.dimen.tbds152));
                    }
                    a.this.fCs.setNextPage(a.this.eli);
                    a.this.eli.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.eli.showLoading();
                        a.this.fCe.btG();
                        return;
                    }
                    a.this.eli.setText(a.this.fCe.getResources().getString(R.string.list_has_no_more));
                    a.this.eli.endLoadData();
                    return;
                }
                a.this.fCs.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a fCH = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.fCe != null) {
                a.this.fCe.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.fCe = barVoteActivity;
        this.aCP = (RelativeLayout) LayoutInflater.from(this.fCe.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.fCe.addContentView(this.aCP, new FrameLayout.LayoutParams(-1, -1));
        this.fCe.showLoadingView(this.aCP, false, l.getDimens(this.fCe, R.dimen.ds400));
        this.mListContainer = this.aCP.findViewById(R.id.list_container);
        this.fCE = (ViewGroup) this.aCP.findViewById(R.id.no_data_container);
        this.fCp = this.aCP.findViewById(R.id.nav_bar_container);
        this.fCq = this.aCP.findViewById(R.id.nav_bar_shadow);
        this.fCq.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.aCP.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fCe.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.fCk = l.getDimens(this.fCe, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fCr = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.fCe).findViewById(R.id.right_textview);
        this.fCr.setText(R.string.bar_election_rule);
        this.fCr.setOnClickListener(this.fCe);
        this.fCs = (BdRecyclerView) this.aCP.findViewById(R.id.vote_list);
        this.cxE = new LinearLayoutManager(this.fCe);
        this.fCs.setLayoutManager(this.cxE);
        this.fCA = new d(barVoteActivity.getPageContext());
        this.fCs.setAdapter(this.fCA);
        this.fCn = (ViewGroup) LayoutInflater.from(this.fCe).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.fCn.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fCo = (TbImageView) this.fCn.findViewById(R.id.head_main_iv);
        this.fCo.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.fCe) * 884) / 1076));
        this.fCs.addHeaderView(this.fCn);
        this.fCs.addOnScrollListener(this.fCG);
        this.fCs.setOnSrollToBottomListener(this.eCo);
        this.fCD = this.fCe.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aDw = new View(this.fCe);
        this.aDw.setLayoutParams(new AbsListView.LayoutParams(-1, this.fCD));
        this.aDw.setVisibility(4);
        this.fCs.addFooterView(this.aDw);
        this.fCt = (VoteStatusCard) this.fCn.findViewById(R.id.vote_status_card);
        this.fCu = this.fCn.findViewById(R.id.vote_ueg_tip_container);
        this.fCu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.fCe);
                View inflate = LayoutInflater.from(a.this.fCe.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.fCe.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.fCe.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aO(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.fCe.getPageContext()).aEA();
            }
        });
        this.fCv = (TextView) this.fCn.findViewById(R.id.vote_ueg_tip_tv);
        this.fCw = (TextView) this.fCn.findViewById(R.id.vote_ueg_tip_img);
        this.fCx = (VoteCountDownCard) this.fCn.findViewById(R.id.vote_count_down_card);
        this.fCx.setOnRefreshListener(this.fCH);
        this.fCy = (VoteCandidateCard) this.fCn.findViewById(R.id.vote_for_mine);
        this.fCz = (SearchView) this.fCn.findViewById(R.id.vote_search_view);
        this.fCz.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.fCe, a.this.fCe.fid + "")));
            }
        });
        this.fCB = (FloatMyRecordCard) this.aCP.findViewById(R.id.float_my_record_card);
        this.fCC = (TextView) this.fCn.findViewById(R.id.vote_tip);
        this.eli = new PbListView(this.fCe);
        this.eli.getView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setHeight(l.getDimens(this.fCe, R.dimen.tbds182));
        this.eli.setLineGone();
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.aHE();
        this.elh = (NoNetworkView) this.aCP.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bug;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bug() != null && (bug = fVar.bug()) != null) {
                this.status = bug.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.fGj) {
                    this.fCz.setVisibility(8);
                    this.fCC.setVisibility(8);
                    this.fCy.setVisibility(8);
                }
            }
            this.fCt.setData(fVar);
            this.fCx.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.fGi) {
                this.fCy.setData(VoteCandidateCard.fGs, fVar);
            }
            if (this.fCA != null) {
                this.mVoteData = fVar;
                this.fCA.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.fGj) {
                this.fCB.setVisibility(0);
                this.fCB.setData(fVar);
                this.fCu.setVisibility(0);
            } else {
                this.fCB.setVisibility(8);
                this.fCu.setVisibility(8);
            }
            btP();
            B(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void pk(int i) {
        B(i, false);
    }

    public void B(int i, boolean z) {
        if (z || this.Ni != i) {
            this.Ni = i;
            if (this.emI != null) {
                this.emI.onChangeSkinType();
            }
            am.setBackgroundColor(this.aCP, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.fCs, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.fCm > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.fCr, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.fCm <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bug() == null || this.mVoteData.bug().getStatus() > 2 || this.mVoteData.bug().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.fCr, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.fCr, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.fCq, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.fCo, R.drawable.pic_bg_recruit, i);
            this.fCt.pk(i);
            this.fCx.pk(i);
            this.fCy.pk(i);
            this.fCz.pk(i);
            am.setViewTextColor(this.fCC, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.fCv, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.fCw, R.drawable.icon_common_explain12_gray66, i);
            this.fCB.pk(i);
            if (this.eli != null) {
                this.eli.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.eli.changeSkin(i);
            }
            this.elh.onChangeSkinType(this.fCe.getPageContext(), i);
            if (this.fCA != null) {
                this.fCA.notifyDataSetChanged();
            }
        }
    }

    public void btP() {
        if (this.status == com.baidu.tieba.barselect.a.d.fGj) {
            this.eli.showEmptyView(l.getDimens(this.fCe, R.dimen.tbds152));
        }
        this.eli.setOnClickListener(this.fCe);
        this.fCs.setNextPage(this.eli);
        if (this.hasMore) {
            this.eli.showEndLoadData();
            return;
        }
        this.eli.setText(this.fCe.getResources().getString(R.string.list_has_no_more));
        this.eli.endLoadData();
    }

    public View getRootView() {
        return this.aCP;
    }

    public BdRecyclerView getListView() {
        return this.fCs;
    }

    public PbListView btQ() {
        return this.eli;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKY = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void zM(String str) {
        if (this.emI != null) {
            this.emI.dettachView(this.mListContainer);
            this.emI = null;
        }
        this.fCe.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fCe, this.fCE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.tU(str), null);
            this.mNoDataView.setOnClickListener(this.cKY);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.tU(str));
        this.mNoDataView.onChangeSkinType(this.fCe.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bcu() {
        if (this.fCs != null) {
            this.fCs.setVisibility(8);
        }
        this.fCe.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.emI == null) {
            this.emI = new h(this.fCe, this.fCF);
        }
        this.emI.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.emI.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.emI.attachView(this.mListContainer, true);
        this.emI.showRefreshButton();
        this.emI.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.fCx != null) {
            this.fCx.onDestroy();
        }
    }
}
