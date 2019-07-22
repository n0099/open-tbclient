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
    private View.OnClickListener bCn;
    private LinearLayoutManager bpJ;
    private NoNetworkView dnF;
    private PbListView dnG;
    private h doz;
    private BarVoteActivity euL;
    private int euR;
    private RelativeLayout euU;
    private ViewGroup euV;
    private TbImageView euW;
    private View euX;
    private View euY;
    private View euZ;
    private TextView eva;
    private BdRecyclerView evb;
    private VoteStatusCard evc;
    private View evd;
    private TextView eve;
    private TextView evf;
    private VoteCountDownCard evg;
    private VoteCandidateCard evh;
    private SearchView evi;
    private d evj;
    private FloatMyRecordCard evk;
    private TextView evl;
    private int evm;
    private ViewGroup evn;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int cdL = 3;
    private int status = -1;
    private int euS = 0;
    private float euT = 0.0f;
    private View.OnClickListener evo = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.jQ()) {
                if (a.this.doz != null) {
                    a.this.doz.dettachView(a.this.mListContainer);
                    a.this.doz = null;
                }
                a.this.euL.reload();
                if (a.this.evb != null) {
                    a.this.evb.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener evp = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.euV != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.euT = Math.abs(a.this.euV.getTop()) / a.this.euR;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.euT);
                a.this.euZ.setAlpha(a.this.euT);
                if (a.this.euT > 0.5d) {
                    if (a.this.euS == 0) {
                        am.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, a.this.cdL);
                        am.d(a.this.eva, R.color.cp_cont_b, 1, a.this.cdL);
                        am.d(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.cdL);
                        a.this.euS = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.euT * 2.0f) - 1.0f);
                    a.this.eva.setAlpha((a.this.euT * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.euT * 2.0f) - 1.0f);
                } else if (a.this.euT <= 0.5d) {
                    if (a.this.euS == 1) {
                        am.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, a.this.cdL);
                        am.d(a.this.eva, R.color.cp_btn_a, 1, a.this.cdL);
                        am.d(a.this.mNavigationBar.mCenterText, R.color.cp_btn_a, 1, a.this.cdL);
                        a.this.euS = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.euT * 2.0f));
                    a.this.eva.setAlpha(1.0f - (a.this.euT * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.euT * 2.0f));
                }
            }
        }
    };
    private BdListView.e dyR = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.evb != null) {
                a.this.evb.stopScroll();
            }
            if (a.this.dnG != null && a.this.euL != null) {
                if (j.kc()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.eyX) {
                        a.this.dnG.iW(l.g(a.this.euL, R.dimen.tbds152));
                    }
                    a.this.evb.setNextPage(a.this.dnG);
                    a.this.dnG.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.dnG.showLoading();
                        a.this.euL.aYo();
                        return;
                    }
                    a.this.dnG.setText(a.this.euL.getResources().getString(R.string.list_has_no_more));
                    a.this.dnG.akE();
                    return;
                }
                a.this.evb.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a evq = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.euL != null) {
                a.this.euL.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.euL = barVoteActivity;
        this.euU = (RelativeLayout) LayoutInflater.from(this.euL.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.euL.addContentView(this.euU, new FrameLayout.LayoutParams(-1, -1));
        this.euL.showLoadingView(this.euU, false, l.g(this.euL, R.dimen.ds400));
        this.mListContainer = this.euU.findViewById(R.id.list_container);
        this.evn = (ViewGroup) this.euU.findViewById(R.id.no_data_container);
        this.euY = this.euU.findViewById(R.id.nav_bar_container);
        this.euZ = this.euU.findViewById(R.id.nav_bar_shadow);
        this.euZ.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.euU.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.euL.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.euR = l.g(this.euL, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eva = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.euL).findViewById(R.id.right_textview);
        this.eva.setText(R.string.bar_election_rule);
        this.eva.setOnClickListener(this.euL);
        this.evb = (BdRecyclerView) this.euU.findViewById(R.id.vote_list);
        this.bpJ = new LinearLayoutManager(this.euL);
        this.evb.setLayoutManager(this.bpJ);
        this.evj = new d(barVoteActivity.getPageContext());
        this.evb.setAdapter(this.evj);
        this.euV = (ViewGroup) LayoutInflater.from(this.euL).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.euV.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.euW = (TbImageView) this.euV.findViewById(R.id.head_main_iv);
        this.euW.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.af(this.euL) * 884) / 1076));
        this.evb.addHeaderView(this.euV);
        this.evb.addOnScrollListener(this.evp);
        this.evb.setOnSrollToBottomListener(this.dyR);
        this.evm = this.euL.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.euX = new View(this.euL);
        this.euX.setLayoutParams(new AbsListView.LayoutParams(-1, this.evm));
        this.euX.setVisibility(4);
        this.evb.addFooterView(this.euX);
        this.evc = (VoteStatusCard) this.euV.findViewById(R.id.vote_status_card);
        this.evd = this.euV.findViewById(R.id.vote_ueg_tip_container);
        this.evd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.euL);
                View inflate = LayoutInflater.from(a.this.euL.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.euL.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.euL.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aH(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.euL.getPageContext()).agI();
            }
        });
        this.eve = (TextView) this.euV.findViewById(R.id.vote_ueg_tip_tv);
        this.evf = (TextView) this.euV.findViewById(R.id.vote_ueg_tip_img);
        this.evg = (VoteCountDownCard) this.euV.findViewById(R.id.vote_count_down_card);
        this.evg.setOnRefreshListener(this.evq);
        this.evh = (VoteCandidateCard) this.euV.findViewById(R.id.vote_for_mine);
        this.evi = (SearchView) this.euV.findViewById(R.id.vote_search_view);
        this.evi.p(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(a.this.euL, a.this.euL.fid + "")));
            }
        });
        this.evk = (FloatMyRecordCard) this.euU.findViewById(R.id.float_my_record_card);
        this.evl = (TextView) this.euV.findViewById(R.id.vote_tip);
        this.dnG = new PbListView(this.euL);
        this.dnG.getView();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.setHeight(l.g(this.euL, R.dimen.tbds182));
        this.dnG.akA();
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.iT(R.color.cp_cont_e);
        this.dnG.akH();
        this.dnF = (NoNetworkView) this.euU.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e aYP;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.aYP() != null && (aYP = fVar.aYP()) != null) {
                this.status = aYP.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.eyX) {
                    this.evi.setVisibility(8);
                    this.evl.setVisibility(8);
                    this.evh.setVisibility(8);
                }
            }
            this.evc.setData(fVar);
            this.evg.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.eyW) {
                this.evh.setData(VoteCandidateCard.ezg, fVar);
            }
            if (this.evj != null) {
                this.mVoteData = fVar;
                this.evj.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.eyX) {
                this.evk.setVisibility(0);
                this.evk.setData(fVar);
                this.evd.setVisibility(0);
            } else {
                this.evk.setVisibility(8);
                this.evd.setVisibility(8);
            }
            aYx();
            B(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void nz(int i) {
        B(i, false);
    }

    public void B(int i, boolean z) {
        if (z || this.cdL != i) {
            this.cdL = i;
            if (this.doz != null) {
                this.doz.onChangeSkinType();
            }
            am.h(this.euU, R.color.cp_bg_line_d, i);
            am.h(this.evb, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d, i);
                if (this.euT > 0.5d) {
                    am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                    am.d(this.eva, R.color.cp_cont_b, 1, i);
                    am.d(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.euT <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.aYP() == null || this.mVoteData.aYP().getStatus() > 2 || this.mVoteData.aYP().getStatus() < 1) {
                        am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                        am.d(this.eva, R.color.cp_cont_b, 1, i);
                        am.d(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, i);
                        am.d(this.eva, R.color.cp_btn_a, 1, i);
                        am.d(this.mNavigationBar.mCenterText, R.color.cp_btn_a, 1, i);
                    }
                }
                am.g(this.euZ, R.drawable.top_view_shadow, i);
            }
            am.b(this.euW, (int) R.drawable.pic_bg_recruit, i);
            this.evc.nz(i);
            this.evg.nz(i);
            this.evh.nz(i);
            this.evi.nz(i);
            am.d(this.evl, R.color.cp_cont_d, 1, i);
            am.d(this.eve, R.color.cp_cont_c, 1, i);
            am.g(this.evf, R.drawable.icon_common_explain12_gray66, i);
            this.evk.nz(i);
            if (this.dnG != null) {
                this.dnG.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.dnG.iV(i);
            }
            this.dnF.onChangeSkinType(this.euL.getPageContext(), i);
            if (this.evj != null) {
                this.evj.notifyDataSetChanged();
            }
        }
    }

    public void aYx() {
        if (this.status == com.baidu.tieba.barselect.a.d.eyX) {
            this.dnG.iW(l.g(this.euL, R.dimen.tbds152));
        }
        this.dnG.setOnClickListener(this.euL);
        this.evb.setNextPage(this.dnG);
        if (this.hasMore) {
            this.dnG.akG();
            return;
        }
        this.dnG.setText(this.euL.getResources().getString(R.string.list_has_no_more));
        this.dnG.akE();
    }

    public View getRootView() {
        return this.euU;
    }

    public BdRecyclerView getListView() {
        return this.evb;
    }

    public PbListView aYy() {
        return this.dnG;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCn = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void vp(String str) {
        if (this.doz != null) {
            this.doz.dettachView(this.mListContainer);
            this.doz = null;
        }
        this.euL.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.euL, this.evn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.oP(str), null);
            this.mNoDataView.setOnClickListener(this.bCn);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oP(str));
        this.mNoDataView.onChangeSkinType(this.euL.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aJg() {
        if (this.evb != null) {
            this.evb.setVisibility(8);
        }
        this.euL.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.doz == null) {
            this.doz = new h(this.euL, this.evo);
        }
        this.doz.kK(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.doz.qN(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.doz.attachView(this.mListContainer, true);
        this.doz.atI();
        this.doz.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.evg != null) {
            this.evg.onDestroy();
        }
    }
}
