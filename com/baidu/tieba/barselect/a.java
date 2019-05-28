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
import com.baidu.tbadk.core.util.al;
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
    private View.OnClickListener bBp;
    private LinearLayoutManager boW;
    private NoNetworkView dlX;
    private PbListView dlY;
    private h dmO;
    private BarVoteActivity epN;
    private int epT;
    private RelativeLayout epW;
    private ViewGroup epX;
    private TbImageView epY;
    private View epZ;
    private View eqa;
    private View eqb;
    private TextView eqc;
    private BdRecyclerView eqd;
    private VoteStatusCard eqe;
    private View eqf;
    private TextView eqg;
    private TextView eqh;
    private VoteCountDownCard eqi;
    private VoteCandidateCard eqj;
    private SearchView eqk;
    private d eql;
    private FloatMyRecordCard eqm;
    private TextView eqn;
    private int eqo;
    private ViewGroup eqp;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ccI = 3;
    private int status = -1;
    private int epU = 0;
    private float epV = 0.0f;
    private View.OnClickListener eqq = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.jG()) {
                if (a.this.dmO != null) {
                    a.this.dmO.dettachView(a.this.mListContainer);
                    a.this.dmO = null;
                }
                a.this.epN.reload();
                if (a.this.eqd != null) {
                    a.this.eqd.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener eqr = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.epX != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.epV = Math.abs(a.this.epX.getTop()) / a.this.epT;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.epV);
                a.this.eqb.setAlpha(a.this.epV);
                if (a.this.epV > 0.5d) {
                    if (a.this.epU == 0) {
                        al.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, a.this.ccI);
                        al.c(a.this.eqc, R.color.cp_cont_b, 1, a.this.ccI);
                        al.c(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.ccI);
                        a.this.epU = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.epV * 2.0f) - 1.0f);
                    a.this.eqc.setAlpha((a.this.epV * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.epV * 2.0f) - 1.0f);
                } else if (a.this.epV <= 0.5d) {
                    if (a.this.epU == 1) {
                        al.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, a.this.ccI);
                        al.c(a.this.eqc, R.color.cp_btn_a, 1, a.this.ccI);
                        al.c(a.this.mNavigationBar.mCenterText, R.color.cp_btn_a, 1, a.this.ccI);
                        a.this.epU = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.epV * 2.0f));
                    a.this.eqc.setAlpha(1.0f - (a.this.epV * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.epV * 2.0f));
                }
            }
        }
    };
    private BdListView.e dvS = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.eqd != null) {
                a.this.eqd.stopScroll();
            }
            if (a.this.dlY != null && a.this.epN != null) {
                if (j.jS()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.etY) {
                        a.this.dlY.iQ(l.g(a.this.epN, R.dimen.tbds152));
                    }
                    a.this.eqd.setNextPage(a.this.dlY);
                    a.this.dlY.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.dlY.showLoading();
                        a.this.epN.aWs();
                        return;
                    }
                    a.this.dlY.setText(a.this.epN.getResources().getString(R.string.list_has_no_more));
                    a.this.dlY.ajz();
                    return;
                }
                a.this.eqd.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a eqs = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.epN != null) {
                a.this.epN.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.epN = barVoteActivity;
        this.epW = (RelativeLayout) LayoutInflater.from(this.epN.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.epN.addContentView(this.epW, new FrameLayout.LayoutParams(-1, -1));
        this.epN.showLoadingView(this.epW, false, l.g(this.epN, R.dimen.ds400));
        this.mListContainer = this.epW.findViewById(R.id.list_container);
        this.eqp = (ViewGroup) this.epW.findViewById(R.id.no_data_container);
        this.eqa = this.epW.findViewById(R.id.nav_bar_container);
        this.eqb = this.epW.findViewById(R.id.nav_bar_shadow);
        this.eqb.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.epW.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.epN.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.epT = l.g(this.epN, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eqc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.epN).findViewById(R.id.right_textview);
        this.eqc.setText(R.string.bar_election_rule);
        this.eqc.setOnClickListener(this.epN);
        this.eqd = (BdRecyclerView) this.epW.findViewById(R.id.vote_list);
        this.boW = new LinearLayoutManager(this.epN);
        this.eqd.setLayoutManager(this.boW);
        this.eql = new d(barVoteActivity.getPageContext());
        this.eqd.setAdapter(this.eql);
        this.epX = (ViewGroup) LayoutInflater.from(this.epN).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.epX.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.epY = (TbImageView) this.epX.findViewById(R.id.head_main_iv);
        this.epY.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.af(this.epN) * 884) / 1076));
        this.eqd.addHeaderView(this.epX);
        this.eqd.addOnScrollListener(this.eqr);
        this.eqd.setOnSrollToBottomListener(this.dvS);
        this.eqo = this.epN.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.epZ = new View(this.epN);
        this.epZ.setLayoutParams(new AbsListView.LayoutParams(-1, this.eqo));
        this.epZ.setVisibility(4);
        this.eqd.addFooterView(this.epZ);
        this.eqe = (VoteStatusCard) this.epX.findViewById(R.id.vote_status_card);
        this.eqf = this.epX.findViewById(R.id.vote_ueg_tip_container);
        this.eqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.epN);
                View inflate = LayoutInflater.from(a.this.epN.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.epN.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.epN.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aF(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.epN.getPageContext()).afG();
            }
        });
        this.eqg = (TextView) this.epX.findViewById(R.id.vote_ueg_tip_tv);
        this.eqh = (TextView) this.epX.findViewById(R.id.vote_ueg_tip_img);
        this.eqi = (VoteCountDownCard) this.epX.findViewById(R.id.vote_count_down_card);
        this.eqi.setOnRefreshListener(this.eqs);
        this.eqj = (VoteCandidateCard) this.epX.findViewById(R.id.vote_for_mine);
        this.eqk = (SearchView) this.epX.findViewById(R.id.vote_search_view);
        this.eqk.p(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(a.this.epN, a.this.epN.fid + "")));
            }
        });
        this.eqm = (FloatMyRecordCard) this.epW.findViewById(R.id.float_my_record_card);
        this.eqn = (TextView) this.epX.findViewById(R.id.vote_tip);
        this.dlY = new PbListView(this.epN);
        this.dlY.getView();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.setHeight(l.g(this.epN, R.dimen.tbds182));
        this.dlY.ajv();
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.ajC();
        this.dlX = (NoNetworkView) this.epW.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e aWT;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.aWT() != null && (aWT = fVar.aWT()) != null) {
                this.status = aWT.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.etY) {
                    this.eqk.setVisibility(8);
                    this.eqn.setVisibility(8);
                    this.eqj.setVisibility(8);
                }
            }
            this.eqe.setData(fVar);
            this.eqi.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.etX) {
                this.eqj.setData(VoteCandidateCard.euh, fVar);
            }
            if (this.eql != null) {
                this.mVoteData = fVar;
                this.eql.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.etY) {
                this.eqm.setVisibility(0);
                this.eqm.setData(fVar);
                this.eqf.setVisibility(0);
            } else {
                this.eqm.setVisibility(8);
                this.eqf.setVisibility(8);
            }
            aWB();
            z(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void nq(int i) {
        z(i, false);
    }

    public void z(int i, boolean z) {
        if (z || this.ccI != i) {
            this.ccI = i;
            if (this.dmO != null) {
                this.dmO.onChangeSkinType();
            }
            al.h(this.epW, R.color.cp_bg_line_d, i);
            al.h(this.eqd, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                al.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d, i);
                if (this.epV > 0.5d) {
                    al.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                    al.c(this.eqc, R.color.cp_cont_b, 1, i);
                    al.c(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.epV <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.aWT() == null || this.mVoteData.aWT().getStatus() > 2 || this.mVoteData.aWT().getStatus() < 1) {
                        al.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                        al.c(this.eqc, R.color.cp_cont_b, 1, i);
                        al.c(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        al.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, i);
                        al.c(this.eqc, R.color.cp_btn_a, 1, i);
                        al.c(this.mNavigationBar.mCenterText, R.color.cp_btn_a, 1, i);
                    }
                }
                al.g(this.eqb, R.drawable.top_view_shadow, i);
            }
            al.b(this.epY, (int) R.drawable.pic_bg_recruit, i);
            this.eqe.nq(i);
            this.eqi.nq(i);
            this.eqj.nq(i);
            this.eqk.nq(i);
            al.c(this.eqn, R.color.cp_cont_d, 1, i);
            al.c(this.eqg, R.color.cp_cont_c, 1, i);
            al.g(this.eqh, R.drawable.icon_common_explain12_gray66, i);
            this.eqm.nq(i);
            if (this.dlY != null) {
                this.dlY.setTextColor(al.getColor(i, R.color.cp_cont_j));
                this.dlY.iP(i);
            }
            this.dlX.onChangeSkinType(this.epN.getPageContext(), i);
            if (this.eql != null) {
                this.eql.notifyDataSetChanged();
            }
        }
    }

    public void aWB() {
        if (this.status == com.baidu.tieba.barselect.a.d.etY) {
            this.dlY.iQ(l.g(this.epN, R.dimen.tbds152));
        }
        this.dlY.setOnClickListener(this.epN);
        this.eqd.setNextPage(this.dlY);
        if (this.hasMore) {
            this.dlY.ajB();
            return;
        }
        this.dlY.setText(this.epN.getResources().getString(R.string.list_has_no_more));
        this.dlY.ajz();
    }

    public View getRootView() {
        return this.epW;
    }

    public BdRecyclerView getListView() {
        return this.eqd;
    }

    public PbListView aWC() {
        return this.dlY;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBp = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void uL(String str) {
        if (this.dmO != null) {
            this.dmO.dettachView(this.mListContainer);
            this.dmO = null;
        }
        this.epN.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.epN, this.eqp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.oz(str), null);
            this.mNoDataView.setOnClickListener(this.bBp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oz(str));
        this.mNoDataView.onChangeSkinType(this.epN.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aHJ() {
        if (this.eqd != null) {
            this.eqd.setVisibility(8);
        }
        this.epN.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.dmO == null) {
            this.dmO = new h(this.epN, this.eqq);
        }
        this.dmO.kE(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.dmO.qx(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.dmO.attachView(this.mListContainer, true);
        this.dmO.asB();
        this.dmO.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.eqi != null) {
            this.eqi.onDestroy();
        }
    }
}
