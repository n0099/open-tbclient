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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class a {
    private View beU;
    private RelativeLayout bej;
    private LinearLayoutManager dhU;
    private View.OnClickListener dyx;
    private NoNetworkView fci;
    private PbListView fcj;
    private h fdL;
    private BarVoteActivity gwK;
    private int gwQ;
    private ViewGroup gwT;
    private TbImageView gwU;
    private View gwV;
    private View gwW;
    private TextView gwX;
    private BdRecyclerView gwY;
    private VoteStatusCard gwZ;
    private View gxa;
    private TextView gxb;
    private TextView gxc;
    private VoteCandidateCard gxd;
    private View gxe;
    private TextView gxf;
    private SelectRuleView gxg;
    private SearchView gxh;
    private d gxi;
    private FloatMyRecordCard gxj;
    private TextView gxk;
    private int gxl;
    private ViewGroup gxm;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int agt = 3;
    private int status = -1;
    private int gwR = 0;
    private float gwS = 0.0f;
    private View.OnClickListener gxn = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.fdL != null) {
                    a.this.fdL.dettachView(a.this.mListContainer);
                    a.this.fdL = null;
                }
                a.this.gwK.reload();
                if (a.this.gwY != null) {
                    a.this.gwY.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a gxo = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.gwK != null) {
                a.this.gwK.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener gxp = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.gwT != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.gwS = Math.abs(a.this.gwT.getTop()) / a.this.gwQ;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.gwS);
                a.this.gwW.setAlpha(a.this.gwS);
                if (a.this.gwS > 0.5d) {
                    if (a.this.gwR == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.agt);
                        am.setViewTextColor(a.this.gwX, R.color.cp_cont_b, 1, a.this.agt);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.agt);
                        a.this.gwR = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.gwS * 2.0f) - 1.0f);
                    a.this.gwX.setAlpha((a.this.gwS * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.gwS * 2.0f) - 1.0f);
                } else if (a.this.gwS <= 0.5d) {
                    if (a.this.gwR == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.agt);
                        am.setViewTextColor(a.this.gwX, R.color.cp_cont_a, 1, a.this.agt);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.agt);
                        a.this.gwR = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.gwS * 2.0f));
                    a.this.gwX.setAlpha(1.0f - (a.this.gwS * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.gwS * 2.0f));
                }
            }
        }
    };
    private BdListView.e fvq = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.gwY != null) {
                a.this.gwY.stopScroll();
            }
            if (a.this.fcj != null && a.this.gwK != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.gAS) {
                        a.this.fcj.showEmptyView(l.getDimens(a.this.gwK, R.dimen.tbds152));
                    }
                    a.this.gwY.setNextPage(a.this.fcj);
                    a.this.fcj.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fcj.showLoading();
                        a.this.gwK.bJR();
                        return;
                    }
                    a.this.fcj.setText(a.this.gwK.getResources().getString(R.string.list_has_no_more));
                    a.this.fcj.endLoadData();
                    return;
                }
                a.this.gwY.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bKq;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bKq() != null && (bKq = fVar.bKq()) != null) {
                this.status = bKq.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.gAS) {
                    this.gxh.setVisibility(8);
                    this.gxk.setVisibility(8);
                    this.gxd.setVisibility(8);
                }
            }
            this.gwZ.setData(fVar);
            if (this.gxi != null) {
                this.mVoteData = fVar;
                this.gxi.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.gAS) {
                this.gxj.setVisibility(0);
                this.gxj.setData(fVar);
                this.gxa.setVisibility(0);
                this.gxe.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.gAR) {
                this.gxd.setData(VoteCandidateCard.gBe, fVar);
                this.gxj.setVisibility(8);
                this.gxa.setVisibility(8);
                this.gxh.setRank(fVar.bKq().bKi());
                if (fVar.bKr() != null) {
                    ManagerElection bKr = fVar.bKr();
                    if (!v.isEmpty(bKr.vote_condition_pic) || !v.isEmpty(bKr.vote_condition_title) || !v.isEmpty(bKr.vote_condition)) {
                        this.gxe.setVisibility(0);
                        this.gxg.setData(bKr.vote_condition_pic, bKr.vote_condition_title, bKr.vote_condition);
                    } else {
                        this.gxe.setVisibility(8);
                    }
                } else {
                    this.gxe.setVisibility(8);
                }
            } else {
                this.gxj.setVisibility(8);
                this.gxa.setVisibility(8);
                this.gxe.setVisibility(8);
            }
            bKa();
            H(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void qk(int i) {
        H(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.gwK = barVoteActivity;
        this.bej = (RelativeLayout) LayoutInflater.from(this.gwK.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.gwK.addContentView(this.bej, new FrameLayout.LayoutParams(-1, -1));
        this.gwK.showLoadingView(this.bej, false, l.getDimens(this.gwK, R.dimen.ds400));
        this.mListContainer = this.bej.findViewById(R.id.list_container);
        this.gxm = (ViewGroup) this.bej.findViewById(R.id.no_data_container);
        this.gwV = this.bej.findViewById(R.id.nav_bar_container);
        this.gwW = this.bej.findViewById(R.id.nav_bar_shadow);
        this.gwW.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bej.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gwK.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.gwQ = l.getDimens(this.gwK, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gwX = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.gwK).findViewById(R.id.right_textview);
        this.gwX.setText(R.string.bar_election_rule);
        this.gwX.setOnClickListener(this.gwK);
        this.gwY = (BdRecyclerView) this.bej.findViewById(R.id.vote_list);
        this.dhU = new LinearLayoutManager(this.gwK);
        this.gwY.setLayoutManager(this.dhU);
        this.gxi = new d(barVoteActivity.getPageContext());
        this.gwY.setAdapter(this.gxi);
        this.gwT = (ViewGroup) LayoutInflater.from(this.gwK).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.gwT.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gwU = (TbImageView) this.gwT.findViewById(R.id.head_main_iv);
        this.gwU.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.gwK) * 884) / 1076));
        this.gwY.addHeaderView(this.gwT);
        this.gwY.addOnScrollListener(this.gxp);
        this.gwY.setOnSrollToBottomListener(this.fvq);
        this.gxl = this.gwK.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.beU = new View(this.gwK);
        this.beU.setLayoutParams(new AbsListView.LayoutParams(-1, this.gxl));
        this.beU.setVisibility(4);
        this.gwY.addFooterView(this.beU);
        this.gwZ = (VoteStatusCard) this.gwT.findViewById(R.id.vote_status_card);
        this.gxa = this.gwT.findViewById(R.id.vote_ueg_tip_container);
        this.gxa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.gwK);
                View inflate = LayoutInflater.from(a.this.gwK.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.gwK.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.gwK.getResources().getString(R.string.vote_ueg_tip_detail_2));
                am.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aP(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.gwK.getPageContext());
                am.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.aST();
            }
        });
        this.gxb = (TextView) this.gwT.findViewById(R.id.vote_ueg_tip_tv);
        this.gxc = (TextView) this.gwT.findViewById(R.id.vote_ueg_tip_img);
        this.gwZ.setOnRefreshListener(this.gxo);
        this.gxe = this.gwT.findViewById(R.id.bar_select_rule_bg);
        this.gxf = (TextView) this.gwT.findViewById(R.id.bar_select_rule_main_title);
        this.gxg = (SelectRuleView) this.gwT.findViewById(R.id.bar_select_rule_container);
        this.gxg.setType(1);
        this.gxd = (VoteCandidateCard) this.gwT.findViewById(R.id.vote_for_mine);
        this.gxh = (SearchView) this.gwT.findViewById(R.id.vote_search_view);
        this.gxh.t(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.gwK, a.this.gwK.fid + "")));
            }
        });
        this.gxj = (FloatMyRecordCard) this.bej.findViewById(R.id.float_my_record_card);
        this.gxk = (TextView) this.gwT.findViewById(R.id.vote_tip);
        this.fcj = new PbListView(this.gwK);
        this.fcj.getView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.gwK, R.dimen.tbds182));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.aWf();
        this.fci = (NoNetworkView) this.bej.findViewById(R.id.no_network_view);
    }

    public void bKa() {
        if (this.status == com.baidu.tieba.barselect.a.d.gAS) {
            this.fcj.showEmptyView(l.getDimens(this.gwK, R.dimen.tbds152));
        }
        this.fcj.setOnClickListener(this.gwK);
        this.gwY.setNextPage(this.fcj);
        if (this.hasMore) {
            this.fcj.showEndLoadData();
            return;
        }
        this.fcj.setText(this.gwK.getResources().getString(R.string.list_has_no_more));
        this.fcj.endLoadData();
    }

    public View getRootView() {
        return this.bej;
    }

    public BdRecyclerView getListView() {
        return this.gwY;
    }

    public PbListView bKb() {
        return this.fcj;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dyx = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Dh(String str) {
        if (this.fdL != null) {
            this.fdL.dettachView(this.mListContainer);
            this.fdL = null;
        }
        this.gwK.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gwK, this.gxm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.wR(str), null);
            this.mNoDataView.setOnClickListener(this.dyx);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.wR(str));
        this.mNoDataView.onChangeSkinType(this.gwK.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bqP() {
        if (this.gwY != null) {
            this.gwY.setVisibility(8);
        }
        this.gwK.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.fdL == null) {
            this.fdL = new h(this.gwK, this.gxn);
        }
        this.fdL.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.fdL.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.fdL.attachView(this.mListContainer, true);
        this.fdL.showRefreshButton();
        this.fdL.onChangeSkinType();
    }

    public void H(int i, boolean z) {
        if (z || this.agt != i) {
            this.agt = i;
            if (this.fdL != null) {
                this.fdL.onChangeSkinType();
            }
            am.setBackgroundColor(this.bej, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.gwY, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.gwS > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.gwX, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.gwS <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bKq() == null || this.mVoteData.bKq().getStatus() > 2 || this.mVoteData.bKq().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.gwX, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.gwX, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.gwW, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.gwU, R.drawable.pic_bg_recruit, i);
            this.gwZ.qk(i);
            this.gxd.qk(i);
            this.gxh.qk(i);
            am.setBackgroundResource(this.gxe, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.gxf, (int) R.color.cp_cont_b);
            if (this.gxg != null) {
                this.gxg.nL(i);
            }
            am.setViewTextColor(this.gxk, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.gxb, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.gxc, R.drawable.icon_common_explain12_gray66, i);
            this.gxj.qk(i);
            if (this.fcj != null) {
                this.fcj.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.fcj.changeSkin(i);
            }
            this.fci.onChangeSkinType(this.gwK.getPageContext(), i);
            if (this.gxi != null) {
                this.gxi.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.gwZ != null) {
            this.gwZ.onDestroy();
        }
    }
}
