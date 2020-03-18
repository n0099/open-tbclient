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
    private View aDM;
    private RelativeLayout aDf;
    private View.OnClickListener cLl;
    private LinearLayoutManager cxR;
    private NoNetworkView elL;
    private PbListView elM;
    private h eno;
    private int fDA;
    private ViewGroup fDB;
    private BarVoteActivity fDb;
    private int fDh;
    private ViewGroup fDk;
    private TbImageView fDl;
    private View fDm;
    private View fDn;
    private TextView fDo;
    private BdRecyclerView fDp;
    private VoteStatusCard fDq;
    private View fDr;
    private TextView fDs;
    private TextView fDt;
    private VoteCountDownCard fDu;
    private VoteCandidateCard fDv;
    private SearchView fDw;
    private d fDx;
    private FloatMyRecordCard fDy;
    private TextView fDz;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int Nj = 3;
    private int status = -1;
    private int fDi = 0;
    private float fDj = 0.0f;
    private View.OnClickListener fDC = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.eno != null) {
                    a.this.eno.dettachView(a.this.mListContainer);
                    a.this.eno = null;
                }
                a.this.fDb.reload();
                if (a.this.fDp != null) {
                    a.this.fDp.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener fDD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.fDk != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.fDj = Math.abs(a.this.fDk.getTop()) / a.this.fDh;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.fDj);
                a.this.fDn.setAlpha(a.this.fDj);
                if (a.this.fDj > 0.5d) {
                    if (a.this.fDi == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.Nj);
                        am.setViewTextColor(a.this.fDo, R.color.cp_cont_b, 1, a.this.Nj);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.Nj);
                        a.this.fDi = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.fDj * 2.0f) - 1.0f);
                    a.this.fDo.setAlpha((a.this.fDj * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.fDj * 2.0f) - 1.0f);
                } else if (a.this.fDj <= 0.5d) {
                    if (a.this.fDi == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.Nj);
                        am.setViewTextColor(a.this.fDo, R.color.cp_cont_a, 1, a.this.Nj);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.Nj);
                        a.this.fDi = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.fDj * 2.0f));
                    a.this.fDo.setAlpha(1.0f - (a.this.fDj * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.fDj * 2.0f));
                }
            }
        }
    };
    private BdListView.e eCY = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.fDp != null) {
                a.this.fDp.stopScroll();
            }
            if (a.this.elM != null && a.this.fDb != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.fHg) {
                        a.this.elM.showEmptyView(l.getDimens(a.this.fDb, R.dimen.tbds152));
                    }
                    a.this.fDp.setNextPage(a.this.elM);
                    a.this.elM.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.elM.showLoading();
                        a.this.fDb.btO();
                        return;
                    }
                    a.this.elM.setText(a.this.fDb.getResources().getString(R.string.list_has_no_more));
                    a.this.elM.endLoadData();
                    return;
                }
                a.this.fDp.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a fDE = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.fDb != null) {
                a.this.fDb.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.fDb = barVoteActivity;
        this.aDf = (RelativeLayout) LayoutInflater.from(this.fDb.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.fDb.addContentView(this.aDf, new FrameLayout.LayoutParams(-1, -1));
        this.fDb.showLoadingView(this.aDf, false, l.getDimens(this.fDb, R.dimen.ds400));
        this.mListContainer = this.aDf.findViewById(R.id.list_container);
        this.fDB = (ViewGroup) this.aDf.findViewById(R.id.no_data_container);
        this.fDm = this.aDf.findViewById(R.id.nav_bar_container);
        this.fDn = this.aDf.findViewById(R.id.nav_bar_shadow);
        this.fDn.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.aDf.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fDb.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.fDh = l.getDimens(this.fDb, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fDo = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.fDb).findViewById(R.id.right_textview);
        this.fDo.setText(R.string.bar_election_rule);
        this.fDo.setOnClickListener(this.fDb);
        this.fDp = (BdRecyclerView) this.aDf.findViewById(R.id.vote_list);
        this.cxR = new LinearLayoutManager(this.fDb);
        this.fDp.setLayoutManager(this.cxR);
        this.fDx = new d(barVoteActivity.getPageContext());
        this.fDp.setAdapter(this.fDx);
        this.fDk = (ViewGroup) LayoutInflater.from(this.fDb).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.fDk.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fDl = (TbImageView) this.fDk.findViewById(R.id.head_main_iv);
        this.fDl.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.fDb) * 884) / 1076));
        this.fDp.addHeaderView(this.fDk);
        this.fDp.addOnScrollListener(this.fDD);
        this.fDp.setOnSrollToBottomListener(this.eCY);
        this.fDA = this.fDb.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aDM = new View(this.fDb);
        this.aDM.setLayoutParams(new AbsListView.LayoutParams(-1, this.fDA));
        this.aDM.setVisibility(4);
        this.fDp.addFooterView(this.aDM);
        this.fDq = (VoteStatusCard) this.fDk.findViewById(R.id.vote_status_card);
        this.fDr = this.fDk.findViewById(R.id.vote_ueg_tip_container);
        this.fDr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.fDb);
                View inflate = LayoutInflater.from(a.this.fDb.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.fDb.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.fDb.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aO(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.fDb.getPageContext()).aEG();
            }
        });
        this.fDs = (TextView) this.fDk.findViewById(R.id.vote_ueg_tip_tv);
        this.fDt = (TextView) this.fDk.findViewById(R.id.vote_ueg_tip_img);
        this.fDu = (VoteCountDownCard) this.fDk.findViewById(R.id.vote_count_down_card);
        this.fDu.setOnRefreshListener(this.fDE);
        this.fDv = (VoteCandidateCard) this.fDk.findViewById(R.id.vote_for_mine);
        this.fDw = (SearchView) this.fDk.findViewById(R.id.vote_search_view);
        this.fDw.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.fDb, a.this.fDb.fid + "")));
            }
        });
        this.fDy = (FloatMyRecordCard) this.aDf.findViewById(R.id.float_my_record_card);
        this.fDz = (TextView) this.fDk.findViewById(R.id.vote_tip);
        this.elM = new PbListView(this.fDb);
        this.elM.getView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(l.getDimens(this.fDb, R.dimen.tbds182));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elM.aHL();
        this.elL = (NoNetworkView) this.aDf.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e buo;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.buo() != null && (buo = fVar.buo()) != null) {
                this.status = buo.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.fHg) {
                    this.fDw.setVisibility(8);
                    this.fDz.setVisibility(8);
                    this.fDv.setVisibility(8);
                }
            }
            this.fDq.setData(fVar);
            this.fDu.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.fHf) {
                this.fDv.setData(VoteCandidateCard.fHp, fVar);
            }
            if (this.fDx != null) {
                this.mVoteData = fVar;
                this.fDx.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.fHg) {
                this.fDy.setVisibility(0);
                this.fDy.setData(fVar);
                this.fDr.setVisibility(0);
            } else {
                this.fDy.setVisibility(8);
                this.fDr.setVisibility(8);
            }
            btX();
            B(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void pm(int i) {
        B(i, false);
    }

    public void B(int i, boolean z) {
        if (z || this.Nj != i) {
            this.Nj = i;
            if (this.eno != null) {
                this.eno.onChangeSkinType();
            }
            am.setBackgroundColor(this.aDf, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.fDp, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.fDj > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.fDo, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.fDj <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.buo() == null || this.mVoteData.buo().getStatus() > 2 || this.mVoteData.buo().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.fDo, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.fDo, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.fDn, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.fDl, R.drawable.pic_bg_recruit, i);
            this.fDq.pm(i);
            this.fDu.pm(i);
            this.fDv.pm(i);
            this.fDw.pm(i);
            am.setViewTextColor(this.fDz, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.fDs, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.fDt, R.drawable.icon_common_explain12_gray66, i);
            this.fDy.pm(i);
            if (this.elM != null) {
                this.elM.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.elM.changeSkin(i);
            }
            this.elL.onChangeSkinType(this.fDb.getPageContext(), i);
            if (this.fDx != null) {
                this.fDx.notifyDataSetChanged();
            }
        }
    }

    public void btX() {
        if (this.status == com.baidu.tieba.barselect.a.d.fHg) {
            this.elM.showEmptyView(l.getDimens(this.fDb, R.dimen.tbds152));
        }
        this.elM.setOnClickListener(this.fDb);
        this.fDp.setNextPage(this.elM);
        if (this.hasMore) {
            this.elM.showEndLoadData();
            return;
        }
        this.elM.setText(this.fDb.getResources().getString(R.string.list_has_no_more));
        this.elM.endLoadData();
    }

    public View getRootView() {
        return this.aDf;
    }

    public BdRecyclerView getListView() {
        return this.fDp;
    }

    public PbListView btY() {
        return this.elM;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLl = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void zO(String str) {
        if (this.eno != null) {
            this.eno.dettachView(this.mListContainer);
            this.eno = null;
        }
        this.fDb.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fDb, this.fDB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.tU(str), null);
            this.mNoDataView.setOnClickListener(this.cLl);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.tU(str));
        this.mNoDataView.onChangeSkinType(this.fDb.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bcB() {
        if (this.fDp != null) {
            this.fDp.setVisibility(8);
        }
        this.fDb.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.eno == null) {
            this.eno = new h(this.fDb, this.fDC);
        }
        this.eno.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.eno.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.eno.attachView(this.mListContainer, true);
        this.eno.showRefreshButton();
        this.eno.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.fDu != null) {
            this.fDu.onDestroy();
        }
    }
}
