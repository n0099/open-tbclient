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
    private NoNetworkView dnM;
    private PbListView dnN;
    private h doG;
    private BarVoteActivity euS;
    private int euY;
    private RelativeLayout evb;
    private ViewGroup evc;
    private TbImageView evd;
    private View eve;
    private View evf;
    private View evg;
    private TextView evh;
    private BdRecyclerView evi;
    private VoteStatusCard evj;
    private View evk;
    private TextView evl;
    private TextView evm;
    private VoteCountDownCard evn;
    private VoteCandidateCard evo;
    private SearchView evp;
    private d evq;
    private FloatMyRecordCard evr;
    private TextView evs;
    private int evt;
    private ViewGroup evu;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int cdS = 3;
    private int status = -1;
    private int euZ = 0;
    private float eva = 0.0f;
    private View.OnClickListener evv = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.jQ()) {
                if (a.this.doG != null) {
                    a.this.doG.dettachView(a.this.mListContainer);
                    a.this.doG = null;
                }
                a.this.euS.reload();
                if (a.this.evi != null) {
                    a.this.evi.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener evw = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.evc != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.eva = Math.abs(a.this.evc.getTop()) / a.this.euY;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.eva);
                a.this.evg.setAlpha(a.this.eva);
                if (a.this.eva > 0.5d) {
                    if (a.this.euZ == 0) {
                        am.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, a.this.cdS);
                        am.d(a.this.evh, R.color.cp_cont_b, 1, a.this.cdS);
                        am.d(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.cdS);
                        a.this.euZ = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.eva * 2.0f) - 1.0f);
                    a.this.evh.setAlpha((a.this.eva * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.eva * 2.0f) - 1.0f);
                } else if (a.this.eva <= 0.5d) {
                    if (a.this.euZ == 1) {
                        am.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, a.this.cdS);
                        am.d(a.this.evh, R.color.cp_btn_a, 1, a.this.cdS);
                        am.d(a.this.mNavigationBar.mCenterText, R.color.cp_btn_a, 1, a.this.cdS);
                        a.this.euZ = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.eva * 2.0f));
                    a.this.evh.setAlpha(1.0f - (a.this.eva * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.eva * 2.0f));
                }
            }
        }
    };
    private BdListView.e dyY = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.evi != null) {
                a.this.evi.stopScroll();
            }
            if (a.this.dnN != null && a.this.euS != null) {
                if (j.kc()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.eze) {
                        a.this.dnN.iW(l.g(a.this.euS, R.dimen.tbds152));
                    }
                    a.this.evi.setNextPage(a.this.dnN);
                    a.this.dnN.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.dnN.showLoading();
                        a.this.euS.aYq();
                        return;
                    }
                    a.this.dnN.setText(a.this.euS.getResources().getString(R.string.list_has_no_more));
                    a.this.dnN.akG();
                    return;
                }
                a.this.evi.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a evx = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.euS != null) {
                a.this.euS.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.euS = barVoteActivity;
        this.evb = (RelativeLayout) LayoutInflater.from(this.euS.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.euS.addContentView(this.evb, new FrameLayout.LayoutParams(-1, -1));
        this.euS.showLoadingView(this.evb, false, l.g(this.euS, R.dimen.ds400));
        this.mListContainer = this.evb.findViewById(R.id.list_container);
        this.evu = (ViewGroup) this.evb.findViewById(R.id.no_data_container);
        this.evf = this.evb.findViewById(R.id.nav_bar_container);
        this.evg = this.evb.findViewById(R.id.nav_bar_shadow);
        this.evg.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.evb.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.euS.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.euY = l.g(this.euS, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.evh = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.euS).findViewById(R.id.right_textview);
        this.evh.setText(R.string.bar_election_rule);
        this.evh.setOnClickListener(this.euS);
        this.evi = (BdRecyclerView) this.evb.findViewById(R.id.vote_list);
        this.bpJ = new LinearLayoutManager(this.euS);
        this.evi.setLayoutManager(this.bpJ);
        this.evq = new d(barVoteActivity.getPageContext());
        this.evi.setAdapter(this.evq);
        this.evc = (ViewGroup) LayoutInflater.from(this.euS).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.evc.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.evd = (TbImageView) this.evc.findViewById(R.id.head_main_iv);
        this.evd.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.af(this.euS) * 884) / 1076));
        this.evi.addHeaderView(this.evc);
        this.evi.addOnScrollListener(this.evw);
        this.evi.setOnSrollToBottomListener(this.dyY);
        this.evt = this.euS.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.eve = new View(this.euS);
        this.eve.setLayoutParams(new AbsListView.LayoutParams(-1, this.evt));
        this.eve.setVisibility(4);
        this.evi.addFooterView(this.eve);
        this.evj = (VoteStatusCard) this.evc.findViewById(R.id.vote_status_card);
        this.evk = this.evc.findViewById(R.id.vote_ueg_tip_container);
        this.evk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.euS);
                View inflate = LayoutInflater.from(a.this.euS.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.euS.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.euS.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aH(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.euS.getPageContext()).agK();
            }
        });
        this.evl = (TextView) this.evc.findViewById(R.id.vote_ueg_tip_tv);
        this.evm = (TextView) this.evc.findViewById(R.id.vote_ueg_tip_img);
        this.evn = (VoteCountDownCard) this.evc.findViewById(R.id.vote_count_down_card);
        this.evn.setOnRefreshListener(this.evx);
        this.evo = (VoteCandidateCard) this.evc.findViewById(R.id.vote_for_mine);
        this.evp = (SearchView) this.evc.findViewById(R.id.vote_search_view);
        this.evp.p(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(a.this.euS, a.this.euS.fid + "")));
            }
        });
        this.evr = (FloatMyRecordCard) this.evb.findViewById(R.id.float_my_record_card);
        this.evs = (TextView) this.evc.findViewById(R.id.vote_tip);
        this.dnN = new PbListView(this.euS);
        this.dnN.getView();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.setHeight(l.g(this.euS, R.dimen.tbds182));
        this.dnN.akC();
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.iT(R.color.cp_cont_e);
        this.dnN.akJ();
        this.dnM = (NoNetworkView) this.evb.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e aYR;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.aYR() != null && (aYR = fVar.aYR()) != null) {
                this.status = aYR.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.eze) {
                    this.evp.setVisibility(8);
                    this.evs.setVisibility(8);
                    this.evo.setVisibility(8);
                }
            }
            this.evj.setData(fVar);
            this.evn.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.ezd) {
                this.evo.setData(VoteCandidateCard.ezn, fVar);
            }
            if (this.evq != null) {
                this.mVoteData = fVar;
                this.evq.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.eze) {
                this.evr.setVisibility(0);
                this.evr.setData(fVar);
                this.evk.setVisibility(0);
            } else {
                this.evr.setVisibility(8);
                this.evk.setVisibility(8);
            }
            aYz();
            B(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void nA(int i) {
        B(i, false);
    }

    public void B(int i, boolean z) {
        if (z || this.cdS != i) {
            this.cdS = i;
            if (this.doG != null) {
                this.doG.onChangeSkinType();
            }
            am.h(this.evb, R.color.cp_bg_line_d, i);
            am.h(this.evi, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d, i);
                if (this.eva > 0.5d) {
                    am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                    am.d(this.evh, R.color.cp_cont_b, 1, i);
                    am.d(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.eva <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.aYR() == null || this.mVoteData.aYR().getStatus() > 2 || this.mVoteData.aYR().getStatus() < 1) {
                        am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                        am.d(this.evh, R.color.cp_cont_b, 1, i);
                        am.d(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, i);
                        am.d(this.evh, R.color.cp_btn_a, 1, i);
                        am.d(this.mNavigationBar.mCenterText, R.color.cp_btn_a, 1, i);
                    }
                }
                am.g(this.evg, R.drawable.top_view_shadow, i);
            }
            am.b(this.evd, (int) R.drawable.pic_bg_recruit, i);
            this.evj.nA(i);
            this.evn.nA(i);
            this.evo.nA(i);
            this.evp.nA(i);
            am.d(this.evs, R.color.cp_cont_d, 1, i);
            am.d(this.evl, R.color.cp_cont_c, 1, i);
            am.g(this.evm, R.drawable.icon_common_explain12_gray66, i);
            this.evr.nA(i);
            if (this.dnN != null) {
                this.dnN.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.dnN.iV(i);
            }
            this.dnM.onChangeSkinType(this.euS.getPageContext(), i);
            if (this.evq != null) {
                this.evq.notifyDataSetChanged();
            }
        }
    }

    public void aYz() {
        if (this.status == com.baidu.tieba.barselect.a.d.eze) {
            this.dnN.iW(l.g(this.euS, R.dimen.tbds152));
        }
        this.dnN.setOnClickListener(this.euS);
        this.evi.setNextPage(this.dnN);
        if (this.hasMore) {
            this.dnN.akI();
            return;
        }
        this.dnN.setText(this.euS.getResources().getString(R.string.list_has_no_more));
        this.dnN.akG();
    }

    public View getRootView() {
        return this.evb;
    }

    public BdRecyclerView getListView() {
        return this.evi;
    }

    public PbListView aYA() {
        return this.dnN;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCn = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void vq(String str) {
        if (this.doG != null) {
            this.doG.dettachView(this.mListContainer);
            this.doG = null;
        }
        this.euS.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.euS, this.evu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.oP(str), null);
            this.mNoDataView.setOnClickListener(this.bCn);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oP(str));
        this.mNoDataView.onChangeSkinType(this.euS.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aJi() {
        if (this.evi != null) {
            this.evi.setVisibility(8);
        }
        this.euS.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.doG == null) {
            this.doG = new h(this.euS, this.evv);
        }
        this.doG.kL(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.doG.qN(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.doG.attachView(this.mListContainer, true);
        this.doG.atK();
        this.doG.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.evn != null) {
            this.evn.onDestroy();
        }
    }
}
