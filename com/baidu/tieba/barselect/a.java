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
    private NoNetworkView dlW;
    private PbListView dlX;
    private h dmN;
    private BarVoteActivity epM;
    private int epS;
    private RelativeLayout epV;
    private ViewGroup epW;
    private TbImageView epX;
    private View epY;
    private View epZ;
    private View eqa;
    private TextView eqb;
    private BdRecyclerView eqc;
    private VoteStatusCard eqd;
    private View eqe;
    private TextView eqf;
    private TextView eqg;
    private VoteCountDownCard eqh;
    private VoteCandidateCard eqi;
    private SearchView eqj;
    private d eqk;
    private FloatMyRecordCard eql;
    private TextView eqm;
    private int eqn;
    private ViewGroup eqo;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ccI = 3;
    private int status = -1;
    private int epT = 0;
    private float epU = 0.0f;
    private View.OnClickListener eqp = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.jG()) {
                if (a.this.dmN != null) {
                    a.this.dmN.dettachView(a.this.mListContainer);
                    a.this.dmN = null;
                }
                a.this.epM.reload();
                if (a.this.eqc != null) {
                    a.this.eqc.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener eqq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.epW != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.epU = Math.abs(a.this.epW.getTop()) / a.this.epS;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.epU);
                a.this.eqa.setAlpha(a.this.epU);
                if (a.this.epU > 0.5d) {
                    if (a.this.epT == 0) {
                        al.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, a.this.ccI);
                        al.c(a.this.eqb, R.color.cp_cont_b, 1, a.this.ccI);
                        al.c(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.ccI);
                        a.this.epT = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.epU * 2.0f) - 1.0f);
                    a.this.eqb.setAlpha((a.this.epU * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.epU * 2.0f) - 1.0f);
                } else if (a.this.epU <= 0.5d) {
                    if (a.this.epT == 1) {
                        al.b(a.this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, a.this.ccI);
                        al.c(a.this.eqb, R.color.cp_btn_a, 1, a.this.ccI);
                        al.c(a.this.mNavigationBar.mCenterText, R.color.cp_btn_a, 1, a.this.ccI);
                        a.this.epT = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.epU * 2.0f));
                    a.this.eqb.setAlpha(1.0f - (a.this.epU * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.epU * 2.0f));
                }
            }
        }
    };
    private BdListView.e dvR = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.eqc != null) {
                a.this.eqc.stopScroll();
            }
            if (a.this.dlX != null && a.this.epM != null) {
                if (j.jS()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.etX) {
                        a.this.dlX.iQ(l.g(a.this.epM, R.dimen.tbds152));
                    }
                    a.this.eqc.setNextPage(a.this.dlX);
                    a.this.dlX.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.dlX.showLoading();
                        a.this.epM.aWp();
                        return;
                    }
                    a.this.dlX.setText(a.this.epM.getResources().getString(R.string.list_has_no_more));
                    a.this.dlX.ajz();
                    return;
                }
                a.this.eqc.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a eqr = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.epM != null) {
                a.this.epM.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.epM = barVoteActivity;
        this.epV = (RelativeLayout) LayoutInflater.from(this.epM.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.epM.addContentView(this.epV, new FrameLayout.LayoutParams(-1, -1));
        this.epM.showLoadingView(this.epV, false, l.g(this.epM, R.dimen.ds400));
        this.mListContainer = this.epV.findViewById(R.id.list_container);
        this.eqo = (ViewGroup) this.epV.findViewById(R.id.no_data_container);
        this.epZ = this.epV.findViewById(R.id.nav_bar_container);
        this.eqa = this.epV.findViewById(R.id.nav_bar_shadow);
        this.eqa.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.epV.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.epM.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.epS = l.g(this.epM, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eqb = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.epM).findViewById(R.id.right_textview);
        this.eqb.setText(R.string.bar_election_rule);
        this.eqb.setOnClickListener(this.epM);
        this.eqc = (BdRecyclerView) this.epV.findViewById(R.id.vote_list);
        this.boW = new LinearLayoutManager(this.epM);
        this.eqc.setLayoutManager(this.boW);
        this.eqk = new d(barVoteActivity.getPageContext());
        this.eqc.setAdapter(this.eqk);
        this.epW = (ViewGroup) LayoutInflater.from(this.epM).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.epW.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.epX = (TbImageView) this.epW.findViewById(R.id.head_main_iv);
        this.epX.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.af(this.epM) * 884) / 1076));
        this.eqc.addHeaderView(this.epW);
        this.eqc.addOnScrollListener(this.eqq);
        this.eqc.setOnSrollToBottomListener(this.dvR);
        this.eqn = this.epM.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.epY = new View(this.epM);
        this.epY.setLayoutParams(new AbsListView.LayoutParams(-1, this.eqn));
        this.epY.setVisibility(4);
        this.eqc.addFooterView(this.epY);
        this.eqd = (VoteStatusCard) this.epW.findViewById(R.id.vote_status_card);
        this.eqe = this.epW.findViewById(R.id.vote_ueg_tip_container);
        this.eqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.epM);
                View inflate = LayoutInflater.from(a.this.epM.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.epM.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.epM.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aF(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.epM.getPageContext()).afG();
            }
        });
        this.eqf = (TextView) this.epW.findViewById(R.id.vote_ueg_tip_tv);
        this.eqg = (TextView) this.epW.findViewById(R.id.vote_ueg_tip_img);
        this.eqh = (VoteCountDownCard) this.epW.findViewById(R.id.vote_count_down_card);
        this.eqh.setOnRefreshListener(this.eqr);
        this.eqi = (VoteCandidateCard) this.epW.findViewById(R.id.vote_for_mine);
        this.eqj = (SearchView) this.epW.findViewById(R.id.vote_search_view);
        this.eqj.p(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(a.this.epM, a.this.epM.fid + "")));
            }
        });
        this.eql = (FloatMyRecordCard) this.epV.findViewById(R.id.float_my_record_card);
        this.eqm = (TextView) this.epW.findViewById(R.id.vote_tip);
        this.dlX = new PbListView(this.epM);
        this.dlX.getView();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.setHeight(l.g(this.epM, R.dimen.tbds182));
        this.dlX.ajv();
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.iN(R.color.cp_cont_e);
        this.dlX.ajC();
        this.dlW = (NoNetworkView) this.epV.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e aWQ;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.aWQ() != null && (aWQ = fVar.aWQ()) != null) {
                this.status = aWQ.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.etX) {
                    this.eqj.setVisibility(8);
                    this.eqm.setVisibility(8);
                    this.eqi.setVisibility(8);
                }
            }
            this.eqd.setData(fVar);
            this.eqh.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.etW) {
                this.eqi.setData(VoteCandidateCard.eug, fVar);
            }
            if (this.eqk != null) {
                this.mVoteData = fVar;
                this.eqk.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.etX) {
                this.eql.setVisibility(0);
                this.eql.setData(fVar);
                this.eqe.setVisibility(0);
            } else {
                this.eql.setVisibility(8);
                this.eqe.setVisibility(8);
            }
            aWy();
            z(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void nq(int i) {
        z(i, false);
    }

    public void z(int i, boolean z) {
        if (z || this.ccI != i) {
            this.ccI = i;
            if (this.dmN != null) {
                this.dmN.onChangeSkinType();
            }
            al.h(this.epV, R.color.cp_bg_line_d, i);
            al.h(this.eqc, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                al.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d, i);
                if (this.epU > 0.5d) {
                    al.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                    al.c(this.eqb, R.color.cp_cont_b, 1, i);
                    al.c(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.epU <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.aWQ() == null || this.mVoteData.aWQ().getStatus() > 2 || this.mVoteData.aWQ().getStatus() < 1) {
                        al.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, i);
                        al.c(this.eqb, R.color.cp_cont_b, 1, i);
                        al.c(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        al.b(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg, i);
                        al.c(this.eqb, R.color.cp_btn_a, 1, i);
                        al.c(this.mNavigationBar.mCenterText, R.color.cp_btn_a, 1, i);
                    }
                }
                al.g(this.eqa, R.drawable.top_view_shadow, i);
            }
            al.b(this.epX, (int) R.drawable.pic_bg_recruit, i);
            this.eqd.nq(i);
            this.eqh.nq(i);
            this.eqi.nq(i);
            this.eqj.nq(i);
            al.c(this.eqm, R.color.cp_cont_d, 1, i);
            al.c(this.eqf, R.color.cp_cont_c, 1, i);
            al.g(this.eqg, R.drawable.icon_common_explain12_gray66, i);
            this.eql.nq(i);
            if (this.dlX != null) {
                this.dlX.setTextColor(al.getColor(i, R.color.cp_cont_j));
                this.dlX.iP(i);
            }
            this.dlW.onChangeSkinType(this.epM.getPageContext(), i);
            if (this.eqk != null) {
                this.eqk.notifyDataSetChanged();
            }
        }
    }

    public void aWy() {
        if (this.status == com.baidu.tieba.barselect.a.d.etX) {
            this.dlX.iQ(l.g(this.epM, R.dimen.tbds152));
        }
        this.dlX.setOnClickListener(this.epM);
        this.eqc.setNextPage(this.dlX);
        if (this.hasMore) {
            this.dlX.ajB();
            return;
        }
        this.dlX.setText(this.epM.getResources().getString(R.string.list_has_no_more));
        this.dlX.ajz();
    }

    public View getRootView() {
        return this.epV;
    }

    public BdRecyclerView getListView() {
        return this.eqc;
    }

    public PbListView aWz() {
        return this.dlX;
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
        if (this.dmN != null) {
            this.dmN.dettachView(this.mListContainer);
            this.dmN = null;
        }
        this.epM.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.epM, this.eqo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.oz(str), null);
            this.mNoDataView.setOnClickListener(this.bBp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oz(str));
        this.mNoDataView.onChangeSkinType(this.epM.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aHG() {
        if (this.eqc != null) {
            this.eqc.setVisibility(8);
        }
        this.epM.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.dmN == null) {
            this.dmN = new h(this.epM, this.eqp);
        }
        this.dmN.kE(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.dmN.qx(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.dmN.attachView(this.mListContainer, true);
        this.dmN.asB();
        this.dmN.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.eqh != null) {
            this.eqh.onDestroy();
        }
    }
}
