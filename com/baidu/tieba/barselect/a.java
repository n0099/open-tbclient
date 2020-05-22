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
    private NoNetworkView fbX;
    private PbListView fbY;
    private h fdA;
    private int gwF;
    private ViewGroup gwI;
    private TbImageView gwJ;
    private View gwK;
    private View gwL;
    private TextView gwM;
    private BdRecyclerView gwN;
    private VoteStatusCard gwO;
    private View gwP;
    private TextView gwQ;
    private TextView gwR;
    private VoteCandidateCard gwS;
    private View gwT;
    private TextView gwU;
    private SelectRuleView gwV;
    private SearchView gwW;
    private d gwX;
    private FloatMyRecordCard gwY;
    private TextView gwZ;
    private BarVoteActivity gwz;
    private int gxa;
    private ViewGroup gxb;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int agt = 3;
    private int status = -1;
    private int gwG = 0;
    private float gwH = 0.0f;
    private View.OnClickListener gxc = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.fdA != null) {
                    a.this.fdA.dettachView(a.this.mListContainer);
                    a.this.fdA = null;
                }
                a.this.gwz.reload();
                if (a.this.gwN != null) {
                    a.this.gwN.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a gxd = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.gwz != null) {
                a.this.gwz.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener gxe = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.gwI != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.gwH = Math.abs(a.this.gwI.getTop()) / a.this.gwF;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.gwH);
                a.this.gwL.setAlpha(a.this.gwH);
                if (a.this.gwH > 0.5d) {
                    if (a.this.gwG == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.agt);
                        am.setViewTextColor(a.this.gwM, R.color.cp_cont_b, 1, a.this.agt);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.agt);
                        a.this.gwG = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.gwH * 2.0f) - 1.0f);
                    a.this.gwM.setAlpha((a.this.gwH * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.gwH * 2.0f) - 1.0f);
                } else if (a.this.gwH <= 0.5d) {
                    if (a.this.gwG == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.agt);
                        am.setViewTextColor(a.this.gwM, R.color.cp_cont_a, 1, a.this.agt);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.agt);
                        a.this.gwG = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.gwH * 2.0f));
                    a.this.gwM.setAlpha(1.0f - (a.this.gwH * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.gwH * 2.0f));
                }
            }
        }
    };
    private BdListView.e fvf = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.gwN != null) {
                a.this.gwN.stopScroll();
            }
            if (a.this.fbY != null && a.this.gwz != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.gAH) {
                        a.this.fbY.showEmptyView(l.getDimens(a.this.gwz, R.dimen.tbds152));
                    }
                    a.this.gwN.setNextPage(a.this.fbY);
                    a.this.fbY.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fbY.showLoading();
                        a.this.gwz.bJP();
                        return;
                    }
                    a.this.fbY.setText(a.this.gwz.getResources().getString(R.string.list_has_no_more));
                    a.this.fbY.endLoadData();
                    return;
                }
                a.this.gwN.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bKo;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bKo() != null && (bKo = fVar.bKo()) != null) {
                this.status = bKo.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.gAH) {
                    this.gwW.setVisibility(8);
                    this.gwZ.setVisibility(8);
                    this.gwS.setVisibility(8);
                }
            }
            this.gwO.setData(fVar);
            if (this.gwX != null) {
                this.mVoteData = fVar;
                this.gwX.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.gAH) {
                this.gwY.setVisibility(0);
                this.gwY.setData(fVar);
                this.gwP.setVisibility(0);
                this.gwT.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.gAG) {
                this.gwS.setData(VoteCandidateCard.gAT, fVar);
                this.gwY.setVisibility(8);
                this.gwP.setVisibility(8);
                this.gwW.setRank(fVar.bKo().bKg());
                if (fVar.bKp() != null) {
                    ManagerElection bKp = fVar.bKp();
                    if (!v.isEmpty(bKp.vote_condition_pic) || !v.isEmpty(bKp.vote_condition_title) || !v.isEmpty(bKp.vote_condition)) {
                        this.gwT.setVisibility(0);
                        this.gwV.setData(bKp.vote_condition_pic, bKp.vote_condition_title, bKp.vote_condition);
                    } else {
                        this.gwT.setVisibility(8);
                    }
                } else {
                    this.gwT.setVisibility(8);
                }
            } else {
                this.gwY.setVisibility(8);
                this.gwP.setVisibility(8);
                this.gwT.setVisibility(8);
            }
            bJY();
            H(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void qi(int i) {
        H(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.gwz = barVoteActivity;
        this.bej = (RelativeLayout) LayoutInflater.from(this.gwz.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.gwz.addContentView(this.bej, new FrameLayout.LayoutParams(-1, -1));
        this.gwz.showLoadingView(this.bej, false, l.getDimens(this.gwz, R.dimen.ds400));
        this.mListContainer = this.bej.findViewById(R.id.list_container);
        this.gxb = (ViewGroup) this.bej.findViewById(R.id.no_data_container);
        this.gwK = this.bej.findViewById(R.id.nav_bar_container);
        this.gwL = this.bej.findViewById(R.id.nav_bar_shadow);
        this.gwL.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bej.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gwz.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.gwF = l.getDimens(this.gwz, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gwM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.gwz).findViewById(R.id.right_textview);
        this.gwM.setText(R.string.bar_election_rule);
        this.gwM.setOnClickListener(this.gwz);
        this.gwN = (BdRecyclerView) this.bej.findViewById(R.id.vote_list);
        this.dhU = new LinearLayoutManager(this.gwz);
        this.gwN.setLayoutManager(this.dhU);
        this.gwX = new d(barVoteActivity.getPageContext());
        this.gwN.setAdapter(this.gwX);
        this.gwI = (ViewGroup) LayoutInflater.from(this.gwz).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.gwI.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gwJ = (TbImageView) this.gwI.findViewById(R.id.head_main_iv);
        this.gwJ.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.gwz) * 884) / 1076));
        this.gwN.addHeaderView(this.gwI);
        this.gwN.addOnScrollListener(this.gxe);
        this.gwN.setOnSrollToBottomListener(this.fvf);
        this.gxa = this.gwz.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.beU = new View(this.gwz);
        this.beU.setLayoutParams(new AbsListView.LayoutParams(-1, this.gxa));
        this.beU.setVisibility(4);
        this.gwN.addFooterView(this.beU);
        this.gwO = (VoteStatusCard) this.gwI.findViewById(R.id.vote_status_card);
        this.gwP = this.gwI.findViewById(R.id.vote_ueg_tip_container);
        this.gwP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.gwz);
                View inflate = LayoutInflater.from(a.this.gwz.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.gwz.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.gwz.getResources().getString(R.string.vote_ueg_tip_detail_2));
                am.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aP(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.gwz.getPageContext());
                am.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.aST();
            }
        });
        this.gwQ = (TextView) this.gwI.findViewById(R.id.vote_ueg_tip_tv);
        this.gwR = (TextView) this.gwI.findViewById(R.id.vote_ueg_tip_img);
        this.gwO.setOnRefreshListener(this.gxd);
        this.gwT = this.gwI.findViewById(R.id.bar_select_rule_bg);
        this.gwU = (TextView) this.gwI.findViewById(R.id.bar_select_rule_main_title);
        this.gwV = (SelectRuleView) this.gwI.findViewById(R.id.bar_select_rule_container);
        this.gwV.setType(1);
        this.gwS = (VoteCandidateCard) this.gwI.findViewById(R.id.vote_for_mine);
        this.gwW = (SearchView) this.gwI.findViewById(R.id.vote_search_view);
        this.gwW.t(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.gwz, a.this.gwz.fid + "")));
            }
        });
        this.gwY = (FloatMyRecordCard) this.bej.findViewById(R.id.float_my_record_card);
        this.gwZ = (TextView) this.gwI.findViewById(R.id.vote_tip);
        this.fbY = new PbListView(this.gwz);
        this.fbY.getView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.gwz, R.dimen.tbds182));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.aWe();
        this.fbX = (NoNetworkView) this.bej.findViewById(R.id.no_network_view);
    }

    public void bJY() {
        if (this.status == com.baidu.tieba.barselect.a.d.gAH) {
            this.fbY.showEmptyView(l.getDimens(this.gwz, R.dimen.tbds152));
        }
        this.fbY.setOnClickListener(this.gwz);
        this.gwN.setNextPage(this.fbY);
        if (this.hasMore) {
            this.fbY.showEndLoadData();
            return;
        }
        this.fbY.setText(this.gwz.getResources().getString(R.string.list_has_no_more));
        this.fbY.endLoadData();
    }

    public View getRootView() {
        return this.bej;
    }

    public BdRecyclerView getListView() {
        return this.gwN;
    }

    public PbListView bJZ() {
        return this.fbY;
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
        if (this.fdA != null) {
            this.fdA.dettachView(this.mListContainer);
            this.fdA = null;
        }
        this.gwz.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gwz, this.gxb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.wR(str), null);
            this.mNoDataView.setOnClickListener(this.dyx);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.wR(str));
        this.mNoDataView.onChangeSkinType(this.gwz.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bqN() {
        if (this.gwN != null) {
            this.gwN.setVisibility(8);
        }
        this.gwz.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.fdA == null) {
            this.fdA = new h(this.gwz, this.gxc);
        }
        this.fdA.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.fdA.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.fdA.attachView(this.mListContainer, true);
        this.fdA.showRefreshButton();
        this.fdA.onChangeSkinType();
    }

    public void H(int i, boolean z) {
        if (z || this.agt != i) {
            this.agt = i;
            if (this.fdA != null) {
                this.fdA.onChangeSkinType();
            }
            am.setBackgroundColor(this.bej, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.gwN, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.gwH > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.gwM, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.gwH <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bKo() == null || this.mVoteData.bKo().getStatus() > 2 || this.mVoteData.bKo().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.gwM, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.gwM, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.gwL, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.gwJ, R.drawable.pic_bg_recruit, i);
            this.gwO.qi(i);
            this.gwS.qi(i);
            this.gwW.qi(i);
            am.setBackgroundResource(this.gwT, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.gwU, (int) R.color.cp_cont_b);
            if (this.gwV != null) {
                this.gwV.nJ(i);
            }
            am.setViewTextColor(this.gwZ, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.gwQ, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.gwR, R.drawable.icon_common_explain12_gray66, i);
            this.gwY.qi(i);
            if (this.fbY != null) {
                this.fbY.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.fbY.changeSkin(i);
            }
            this.fbX.onChangeSkinType(this.gwz.getPageContext(), i);
            if (this.gwX != null) {
                this.gwX.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.gwO != null) {
            this.gwO.onDestroy();
        }
    }
}
