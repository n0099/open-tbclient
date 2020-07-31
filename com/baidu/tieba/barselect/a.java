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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes15.dex */
public class a {
    private RelativeLayout bjP;
    private View bkz;
    private View.OnClickListener dJA;
    private LinearLayoutManager dsC;
    private NoNetworkView fsB;
    private PbListView fsC;
    private h fug;
    private SelectRuleView gPA;
    private SearchView gPB;
    private d gPC;
    private FloatMyRecordCard gPD;
    private TextView gPE;
    private int gPF;
    private ViewGroup gPG;
    private BarVoteActivity gPe;
    private int gPk;
    private ViewGroup gPn;
    private TbImageView gPo;
    private View gPp;
    private View gPq;
    private TextView gPr;
    private BdRecyclerView gPs;
    private VoteStatusCard gPt;
    private View gPu;
    private TextView gPv;
    private TextView gPw;
    private VoteCandidateCard gPx;
    private View gPy;
    private TextView gPz;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int aho = 3;
    private int status = -1;
    private int gPl = 0;
    private float gPm = 0.0f;
    private View.OnClickListener gPH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.fug != null) {
                    a.this.fug.dettachView(a.this.mListContainer);
                    a.this.fug = null;
                }
                a.this.gPe.reload();
                if (a.this.gPs != null) {
                    a.this.gPs.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a gPI = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.gPe != null) {
                a.this.gPe.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener gPJ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.gPn != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.gPm = Math.abs(a.this.gPn.getTop()) / a.this.gPk;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.gPm);
                a.this.gPq.setAlpha(a.this.gPm);
                if (a.this.gPm > 0.5d) {
                    if (a.this.gPl == 0) {
                        ao.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.aho);
                        ao.setViewTextColor(a.this.gPr, R.color.cp_cont_b, 1, a.this.aho);
                        ao.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.aho);
                        a.this.gPl = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.gPm * 2.0f) - 1.0f);
                    a.this.gPr.setAlpha((a.this.gPm * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.gPm * 2.0f) - 1.0f);
                } else if (a.this.gPm <= 0.5d) {
                    if (a.this.gPl == 1) {
                        ao.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.aho);
                        ao.setViewTextColor(a.this.gPr, R.color.cp_cont_a, 1, a.this.aho);
                        ao.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.aho);
                        a.this.gPl = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.gPm * 2.0f));
                    a.this.gPr.setAlpha(1.0f - (a.this.gPm * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.gPm * 2.0f));
                }
            }
        }
    };
    private BdListView.e fLV = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.gPs != null) {
                a.this.gPs.stopScroll();
            }
            if (a.this.fsC != null && a.this.gPe != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.gTj) {
                        a.this.fsC.showEmptyView(l.getDimens(a.this.gPe, R.dimen.tbds152));
                    }
                    a.this.gPs.setNextPage(a.this.fsC);
                    a.this.fsC.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fsC.showLoading();
                        a.this.gPe.bQi();
                        return;
                    }
                    a.this.fsC.setText(a.this.gPe.getResources().getString(R.string.list_has_no_more));
                    a.this.fsC.endLoadData();
                    return;
                }
                a.this.gPs.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bQH;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bQH() != null && (bQH = fVar.bQH()) != null) {
                this.status = bQH.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.gTj) {
                    this.gPB.setVisibility(8);
                    this.gPE.setVisibility(8);
                    this.gPx.setVisibility(8);
                }
            }
            this.gPt.setData(fVar);
            if (this.gPC != null) {
                this.mVoteData = fVar;
                this.gPC.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.gTj) {
                this.gPD.setVisibility(0);
                this.gPD.setData(fVar);
                this.gPu.setVisibility(0);
                this.gPy.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.gTi) {
                this.gPx.setData(VoteCandidateCard.gTv, fVar);
                this.gPD.setVisibility(8);
                this.gPu.setVisibility(8);
                this.gPB.setRank(fVar.bQH().bQz());
                if (fVar.bQI() != null) {
                    ManagerElection bQI = fVar.bQI();
                    if (!x.isEmpty(bQI.vote_condition_pic) || !x.isEmpty(bQI.vote_condition_title) || !x.isEmpty(bQI.vote_condition)) {
                        this.gPy.setVisibility(0);
                        this.gPA.setData(bQI.vote_condition_pic, bQI.vote_condition_title, bQI.vote_condition);
                    } else {
                        this.gPy.setVisibility(8);
                    }
                } else {
                    this.gPy.setVisibility(8);
                }
            } else {
                this.gPD.setVisibility(8);
                this.gPu.setVisibility(8);
                this.gPy.setVisibility(8);
            }
            bQr();
            J(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void qZ(int i) {
        J(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.gPe = barVoteActivity;
        this.bjP = (RelativeLayout) LayoutInflater.from(this.gPe.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.gPe.addContentView(this.bjP, new FrameLayout.LayoutParams(-1, -1));
        this.gPe.showLoadingView(this.bjP, false, l.getDimens(this.gPe, R.dimen.ds400));
        this.mListContainer = this.bjP.findViewById(R.id.list_container);
        this.gPG = (ViewGroup) this.bjP.findViewById(R.id.no_data_container);
        this.gPp = this.bjP.findViewById(R.id.nav_bar_container);
        this.gPq = this.bjP.findViewById(R.id.nav_bar_shadow);
        this.gPq.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bjP.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gPe.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.gPk = l.getDimens(this.gPe, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gPr = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.gPe).findViewById(R.id.right_textview);
        this.gPr.setText(R.string.bar_election_rule);
        this.gPr.setOnClickListener(this.gPe);
        this.gPs = (BdRecyclerView) this.bjP.findViewById(R.id.vote_list);
        this.dsC = new LinearLayoutManager(this.gPe);
        this.gPs.setLayoutManager(this.dsC);
        this.gPC = new d(barVoteActivity.getPageContext());
        this.gPs.setAdapter(this.gPC);
        this.gPn = (ViewGroup) LayoutInflater.from(this.gPe).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.gPn.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gPo = (TbImageView) this.gPn.findViewById(R.id.head_main_iv);
        this.gPo.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.gPe) * 884) / 1076));
        this.gPs.addHeaderView(this.gPn);
        this.gPs.addOnScrollListener(this.gPJ);
        this.gPs.setOnSrollToBottomListener(this.fLV);
        this.gPF = this.gPe.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bkz = new View(this.gPe);
        this.bkz.setLayoutParams(new AbsListView.LayoutParams(-1, this.gPF));
        this.bkz.setVisibility(4);
        this.gPs.addFooterView(this.bkz);
        this.gPt = (VoteStatusCard) this.gPn.findViewById(R.id.vote_status_card);
        this.gPu = this.gPn.findViewById(R.id.vote_ueg_tip_container);
        this.gPu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.gPe);
                View inflate = LayoutInflater.from(a.this.gPe.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.gPe.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.gPe.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ao.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aV(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.gPe.getPageContext());
                ao.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.aYL();
            }
        });
        this.gPv = (TextView) this.gPn.findViewById(R.id.vote_ueg_tip_tv);
        this.gPw = (TextView) this.gPn.findViewById(R.id.vote_ueg_tip_img);
        this.gPt.setOnRefreshListener(this.gPI);
        this.gPy = this.gPn.findViewById(R.id.bar_select_rule_bg);
        this.gPz = (TextView) this.gPn.findViewById(R.id.bar_select_rule_main_title);
        this.gPA = (SelectRuleView) this.gPn.findViewById(R.id.bar_select_rule_container);
        this.gPA.setType(1);
        this.gPx = (VoteCandidateCard) this.gPn.findViewById(R.id.vote_for_mine);
        this.gPB = (SearchView) this.gPn.findViewById(R.id.vote_search_view);
        this.gPB.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.gPe, a.this.gPe.fid + "")));
            }
        });
        this.gPD = (FloatMyRecordCard) this.bjP.findViewById(R.id.float_my_record_card);
        this.gPE = (TextView) this.gPn.findViewById(R.id.vote_tip);
        this.fsC = new PbListView(this.gPe);
        this.fsC.getView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.gPe, R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.bbZ();
        this.fsB = (NoNetworkView) this.bjP.findViewById(R.id.no_network_view);
    }

    public void bQr() {
        if (this.status == com.baidu.tieba.barselect.a.d.gTj) {
            this.fsC.showEmptyView(l.getDimens(this.gPe, R.dimen.tbds152));
        }
        this.fsC.setOnClickListener(this.gPe);
        this.gPs.setNextPage(this.fsC);
        if (this.hasMore) {
            this.fsC.showEndLoadData();
            return;
        }
        this.fsC.setText(this.gPe.getResources().getString(R.string.list_has_no_more));
        this.fsC.endLoadData();
    }

    public View getRootView() {
        return this.bjP;
    }

    public BdRecyclerView getListView() {
        return this.gPs;
    }

    public PbListView bQs() {
        return this.fsC;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dJA = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Et(String str) {
        if (this.fug != null) {
            this.fug.dettachView(this.mListContainer);
            this.fug = null;
        }
        this.gPe.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gPe, this.gPG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.yn(str), null);
            this.mNoDataView.setOnClickListener(this.dJA);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.yn(str));
        this.mNoDataView.onChangeSkinType(this.gPe.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bwW() {
        if (this.gPs != null) {
            this.gPs.setVisibility(8);
        }
        this.gPe.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.fug == null) {
            this.fug = new h(this.gPe, this.gPH);
        }
        this.fug.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.fug.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.fug.attachView(this.mListContainer, true);
        this.fug.showRefreshButton();
        this.fug.onChangeSkinType();
    }

    public void J(int i, boolean z) {
        if (z || this.aho != i) {
            this.aho = i;
            if (this.fug != null) {
                this.fug.onChangeSkinType();
            }
            ao.setBackgroundColor(this.bjP, R.color.cp_bg_line_d, i);
            ao.setBackgroundColor(this.gPs, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.gPm > 0.5d) {
                    ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ao.setViewTextColor(this.gPr, R.color.cp_cont_b, 1, i);
                    ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.gPm <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bQH() == null || this.mVoteData.bQH().getStatus() > 2 || this.mVoteData.bQH().getStatus() < 1) {
                        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ao.setViewTextColor(this.gPr, R.color.cp_cont_b, 1, i);
                        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ao.setViewTextColor(this.gPr, R.color.cp_cont_a, 1, i);
                        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                ao.setBackgroundResource(this.gPq, R.drawable.top_view_shadow, i);
            }
            ao.setImageResource(this.gPo, R.drawable.pic_bg_recruit, i);
            this.gPt.qZ(i);
            this.gPx.qZ(i);
            this.gPB.qZ(i);
            ao.setBackgroundResource(this.gPy, R.drawable.bar_select_bg_shadow_and_radius, i);
            ao.setViewTextColor(this.gPz, R.color.cp_cont_b);
            if (this.gPA != null) {
                this.gPA.oA(i);
            }
            ao.setViewTextColor(this.gPE, R.color.cp_cont_d, 1, i);
            ao.setViewTextColor(this.gPv, R.color.cp_cont_c, 1, i);
            ao.setBackgroundResource(this.gPw, R.drawable.icon_common_explain12_gray66, i);
            this.gPD.qZ(i);
            if (this.fsC != null) {
                this.fsC.setTextColor(ao.getColor(i, R.color.cp_cont_j));
                this.fsC.changeSkin(i);
            }
            this.fsB.onChangeSkinType(this.gPe.getPageContext(), i);
            if (this.gPC != null) {
                this.gPC.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.gPt != null) {
            this.gPt.onDestroy();
        }
    }
}
