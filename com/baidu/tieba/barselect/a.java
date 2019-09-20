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
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteCountDownCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener bCL;
    private LinearLayoutManager bqh;
    private NoNetworkView dpy;
    private PbListView dpz;
    private h dqr;
    private BarVoteActivity ewC;
    private int ewI;
    private RelativeLayout ewL;
    private ViewGroup ewM;
    private TbImageView ewN;
    private View ewO;
    private View ewP;
    private View ewQ;
    private TextView ewR;
    private BdRecyclerView ewS;
    private VoteStatusCard ewT;
    private View ewU;
    private TextView ewV;
    private TextView ewW;
    private VoteCountDownCard ewX;
    private VoteCandidateCard ewY;
    private SearchView ewZ;
    private d exa;
    private FloatMyRecordCard exb;
    private TextView exc;
    private int exd;
    private ViewGroup exe;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ceL = 3;
    private int status = -1;
    private int ewJ = 0;
    private float ewK = 0.0f;
    private View.OnClickListener exf = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.jQ()) {
                if (a.this.dqr != null) {
                    a.this.dqr.dettachView(a.this.mListContainer);
                    a.this.dqr = null;
                }
                a.this.ewC.reload();
                if (a.this.ewS != null) {
                    a.this.ewS.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener exg = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ewM != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.ewK = Math.abs(a.this.ewM.getTop()) / a.this.ewI;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.ewK);
                a.this.ewQ.setAlpha(a.this.ewK);
                if (a.this.ewK > 0.5d) {
                    if (a.this.ewJ == 0) {
                        am.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, a.this.ceL);
                        am.d(a.this.ewR, R.color.cp_cont_b, 1, a.this.ceL);
                        am.d(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.ceL);
                        a.this.ewJ = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.ewK * 2.0f) - 1.0f);
                    a.this.ewR.setAlpha((a.this.ewK * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.ewK * 2.0f) - 1.0f);
                } else if (a.this.ewK <= 0.5d) {
                    if (a.this.ewJ == 1) {
                        am.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, a.this.ceL);
                        am.d(a.this.ewR, R.color.cp_cont_a, 1, a.this.ceL);
                        am.d(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.ceL);
                        a.this.ewJ = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.ewK * 2.0f));
                    a.this.ewR.setAlpha(1.0f - (a.this.ewK * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.ewK * 2.0f));
                }
            }
        }
    };
    private BdListView.e dAJ = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ewS != null) {
                a.this.ewS.stopScroll();
            }
            if (a.this.dpz != null && a.this.ewC != null) {
                if (j.kc()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.eAN) {
                        a.this.dpz.iZ(l.g(a.this.ewC, R.dimen.tbds152));
                    }
                    a.this.ewS.setNextPage(a.this.dpz);
                    a.this.dpz.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.dpz.showLoading();
                        a.this.ewC.aYU();
                        return;
                    }
                    a.this.dpz.setText(a.this.ewC.getResources().getString(R.string.list_has_no_more));
                    a.this.dpz.akS();
                    return;
                }
                a.this.ewS.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a exh = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.ewC != null) {
                a.this.ewC.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.ewC = barVoteActivity;
        this.ewL = (RelativeLayout) LayoutInflater.from(this.ewC.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ewC.addContentView(this.ewL, new FrameLayout.LayoutParams(-1, -1));
        this.ewC.showLoadingView(this.ewL, false, l.g(this.ewC, R.dimen.ds400));
        this.mListContainer = this.ewL.findViewById(R.id.list_container);
        this.exe = (ViewGroup) this.ewL.findViewById(R.id.no_data_container);
        this.ewP = this.ewL.findViewById(R.id.nav_bar_container);
        this.ewQ = this.ewL.findViewById(R.id.nav_bar_shadow);
        this.ewQ.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.ewL.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ewC.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ewI = l.g(this.ewC, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ewR = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ewC).findViewById(R.id.right_textview);
        this.ewR.setText(R.string.bar_election_rule);
        this.ewR.setOnClickListener(this.ewC);
        this.ewS = (BdRecyclerView) this.ewL.findViewById(R.id.vote_list);
        this.bqh = new LinearLayoutManager(this.ewC);
        this.ewS.setLayoutManager(this.bqh);
        this.exa = new d(barVoteActivity.getPageContext());
        this.ewS.setAdapter(this.exa);
        this.ewM = (ViewGroup) LayoutInflater.from(this.ewC).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ewM.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ewN = (TbImageView) this.ewM.findViewById(R.id.head_main_iv);
        this.ewN.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.af(this.ewC) * 884) / 1076));
        this.ewS.addHeaderView(this.ewM);
        this.ewS.addOnScrollListener(this.exg);
        this.ewS.setOnSrollToBottomListener(this.dAJ);
        this.exd = this.ewC.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.ewO = new View(this.ewC);
        this.ewO.setLayoutParams(new AbsListView.LayoutParams(-1, this.exd));
        this.ewO.setVisibility(4);
        this.ewS.addFooterView(this.ewO);
        this.ewT = (VoteStatusCard) this.ewM.findViewById(R.id.vote_status_card);
        this.ewU = this.ewM.findViewById(R.id.vote_ueg_tip_container);
        this.ewU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ewC);
                View inflate = LayoutInflater.from(a.this.ewC.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.ewC.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ewC.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aH(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ewC.getPageContext()).agO();
            }
        });
        this.ewV = (TextView) this.ewM.findViewById(R.id.vote_ueg_tip_tv);
        this.ewW = (TextView) this.ewM.findViewById(R.id.vote_ueg_tip_img);
        this.ewX = (VoteCountDownCard) this.ewM.findViewById(R.id.vote_count_down_card);
        this.ewX.setOnRefreshListener(this.exh);
        this.ewY = (VoteCandidateCard) this.ewM.findViewById(R.id.vote_for_mine);
        this.ewZ = (SearchView) this.ewM.findViewById(R.id.vote_search_view);
        this.ewZ.p(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(a.this.ewC, a.this.ewC.fid + "")));
            }
        });
        this.exb = (FloatMyRecordCard) this.ewL.findViewById(R.id.float_my_record_card);
        this.exc = (TextView) this.ewM.findViewById(R.id.vote_tip);
        this.dpz = new PbListView(this.ewC);
        this.dpz.getView();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.setHeight(l.g(this.ewC, R.dimen.tbds182));
        this.dpz.akO();
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.iW(R.color.cp_cont_e);
        this.dpz.akV();
        this.dpy = (NoNetworkView) this.ewL.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e aZv;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.aZv() != null && (aZv = fVar.aZv()) != null) {
                this.status = aZv.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.eAN) {
                    this.ewZ.setVisibility(8);
                    this.exc.setVisibility(8);
                    this.ewY.setVisibility(8);
                }
            }
            this.ewT.setData(fVar);
            this.ewX.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.eAM) {
                this.ewY.setData(VoteCandidateCard.eAW, fVar);
            }
            if (this.exa != null) {
                this.mVoteData = fVar;
                this.exa.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.eAN) {
                this.exb.setVisibility(0);
                this.exb.setData(fVar);
                this.ewU.setVisibility(0);
            } else {
                this.exb.setVisibility(8);
                this.ewU.setVisibility(8);
            }
            aZd();
            C(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void nE(int i) {
        C(i, false);
    }

    public void C(int i, boolean z) {
        if (z || this.ceL != i) {
            this.ceL = i;
            if (this.dqr != null) {
                this.dqr.onChangeSkinType();
            }
            am.h(this.ewL, R.color.cp_bg_line_d, i);
            am.h(this.ewS, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.ewK > 0.5d) {
                    am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                    am.d(this.ewR, R.color.cp_cont_b, 1, i);
                    am.d(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.ewK <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.aZv() == null || this.mVoteData.aZv().getStatus() > 2 || this.mVoteData.aZv().getStatus() < 1) {
                        am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                        am.d(this.ewR, R.color.cp_cont_b, 1, i);
                        am.d(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, i);
                        am.d(this.ewR, R.color.cp_cont_a, 1, i);
                        am.d(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.g(this.ewQ, R.drawable.top_view_shadow, i);
            }
            am.b(this.ewN, (int) R.drawable.pic_bg_recruit, i);
            this.ewT.nE(i);
            this.ewX.nE(i);
            this.ewY.nE(i);
            this.ewZ.nE(i);
            am.d(this.exc, R.color.cp_cont_d, 1, i);
            am.d(this.ewV, R.color.cp_cont_c, 1, i);
            am.g(this.ewW, R.drawable.icon_common_explain12_gray66, i);
            this.exb.nE(i);
            if (this.dpz != null) {
                this.dpz.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.dpz.iY(i);
            }
            this.dpy.onChangeSkinType(this.ewC.getPageContext(), i);
            if (this.exa != null) {
                this.exa.notifyDataSetChanged();
            }
        }
    }

    public void aZd() {
        if (this.status == com.baidu.tieba.barselect.a.d.eAN) {
            this.dpz.iZ(l.g(this.ewC, R.dimen.tbds152));
        }
        this.dpz.setOnClickListener(this.ewC);
        this.ewS.setNextPage(this.dpz);
        if (this.hasMore) {
            this.dpz.akU();
            return;
        }
        this.dpz.setText(this.ewC.getResources().getString(R.string.list_has_no_more));
        this.dpz.akS();
    }

    public View getRootView() {
        return this.ewL;
    }

    public BdRecyclerView getListView() {
        return this.ewS;
    }

    public PbListView aZe() {
        return this.dpz;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCL = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void vP(String str) {
        if (this.dqr != null) {
            this.dqr.dettachView(this.mListContainer);
            this.dqr = null;
        }
        this.ewC.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ewC, this.exe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.oX(str), null);
            this.mNoDataView.setOnClickListener(this.bCL);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oX(str));
        this.mNoDataView.onChangeSkinType(this.ewC.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aJM() {
        if (this.ewS != null) {
            this.ewS.setVisibility(8);
        }
        this.ewC.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.dqr == null) {
            this.dqr = new h(this.ewC, this.exf);
        }
        this.dqr.kO(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.dqr.qY(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.dqr.attachView(this.mListContainer, true);
        this.dqr.atW();
        this.dqr.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.ewX != null) {
            this.ewX.onDestroy();
        }
    }
}
