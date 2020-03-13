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
    private RelativeLayout aCR;
    private View aDy;
    private View.OnClickListener cLa;
    private LinearLayoutManager cxG;
    private NoNetworkView elv;
    private PbListView elw;
    private h emW;
    private ViewGroup fCC;
    private TbImageView fCD;
    private View fCE;
    private View fCF;
    private TextView fCG;
    private BdRecyclerView fCH;
    private VoteStatusCard fCI;
    private View fCJ;
    private TextView fCK;
    private TextView fCL;
    private VoteCountDownCard fCM;
    private VoteCandidateCard fCN;
    private SearchView fCO;
    private d fCP;
    private FloatMyRecordCard fCQ;
    private TextView fCR;
    private int fCS;
    private ViewGroup fCT;
    private BarVoteActivity fCt;
    private int fCz;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int Ni = 3;
    private int status = -1;
    private int fCA = 0;
    private float fCB = 0.0f;
    private View.OnClickListener fCU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.emW != null) {
                    a.this.emW.dettachView(a.this.mListContainer);
                    a.this.emW = null;
                }
                a.this.fCt.reload();
                if (a.this.fCH != null) {
                    a.this.fCH.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener fCV = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.fCC != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.fCB = Math.abs(a.this.fCC.getTop()) / a.this.fCz;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.fCB);
                a.this.fCF.setAlpha(a.this.fCB);
                if (a.this.fCB > 0.5d) {
                    if (a.this.fCA == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.Ni);
                        am.setViewTextColor(a.this.fCG, R.color.cp_cont_b, 1, a.this.Ni);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.Ni);
                        a.this.fCA = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.fCB * 2.0f) - 1.0f);
                    a.this.fCG.setAlpha((a.this.fCB * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.fCB * 2.0f) - 1.0f);
                } else if (a.this.fCB <= 0.5d) {
                    if (a.this.fCA == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.Ni);
                        am.setViewTextColor(a.this.fCG, R.color.cp_cont_a, 1, a.this.Ni);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.Ni);
                        a.this.fCA = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.fCB * 2.0f));
                    a.this.fCG.setAlpha(1.0f - (a.this.fCB * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.fCB * 2.0f));
                }
            }
        }
    };
    private BdListView.e eCC = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.fCH != null) {
                a.this.fCH.stopScroll();
            }
            if (a.this.elw != null && a.this.fCt != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.fGy) {
                        a.this.elw.showEmptyView(l.getDimens(a.this.fCt, R.dimen.tbds152));
                    }
                    a.this.fCH.setNextPage(a.this.elw);
                    a.this.elw.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.elw.showLoading();
                        a.this.fCt.btJ();
                        return;
                    }
                    a.this.elw.setText(a.this.fCt.getResources().getString(R.string.list_has_no_more));
                    a.this.elw.endLoadData();
                    return;
                }
                a.this.fCH.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a fCW = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.fCt != null) {
                a.this.fCt.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.fCt = barVoteActivity;
        this.aCR = (RelativeLayout) LayoutInflater.from(this.fCt.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.fCt.addContentView(this.aCR, new FrameLayout.LayoutParams(-1, -1));
        this.fCt.showLoadingView(this.aCR, false, l.getDimens(this.fCt, R.dimen.ds400));
        this.mListContainer = this.aCR.findViewById(R.id.list_container);
        this.fCT = (ViewGroup) this.aCR.findViewById(R.id.no_data_container);
        this.fCE = this.aCR.findViewById(R.id.nav_bar_container);
        this.fCF = this.aCR.findViewById(R.id.nav_bar_shadow);
        this.fCF.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.aCR.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fCt.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.fCz = l.getDimens(this.fCt, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fCG = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.fCt).findViewById(R.id.right_textview);
        this.fCG.setText(R.string.bar_election_rule);
        this.fCG.setOnClickListener(this.fCt);
        this.fCH = (BdRecyclerView) this.aCR.findViewById(R.id.vote_list);
        this.cxG = new LinearLayoutManager(this.fCt);
        this.fCH.setLayoutManager(this.cxG);
        this.fCP = new d(barVoteActivity.getPageContext());
        this.fCH.setAdapter(this.fCP);
        this.fCC = (ViewGroup) LayoutInflater.from(this.fCt).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.fCC.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fCD = (TbImageView) this.fCC.findViewById(R.id.head_main_iv);
        this.fCD.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.fCt) * 884) / 1076));
        this.fCH.addHeaderView(this.fCC);
        this.fCH.addOnScrollListener(this.fCV);
        this.fCH.setOnSrollToBottomListener(this.eCC);
        this.fCS = this.fCt.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aDy = new View(this.fCt);
        this.aDy.setLayoutParams(new AbsListView.LayoutParams(-1, this.fCS));
        this.aDy.setVisibility(4);
        this.fCH.addFooterView(this.aDy);
        this.fCI = (VoteStatusCard) this.fCC.findViewById(R.id.vote_status_card);
        this.fCJ = this.fCC.findViewById(R.id.vote_ueg_tip_container);
        this.fCJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.fCt);
                View inflate = LayoutInflater.from(a.this.fCt.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.fCt.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.fCt.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aO(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.fCt.getPageContext()).aEC();
            }
        });
        this.fCK = (TextView) this.fCC.findViewById(R.id.vote_ueg_tip_tv);
        this.fCL = (TextView) this.fCC.findViewById(R.id.vote_ueg_tip_img);
        this.fCM = (VoteCountDownCard) this.fCC.findViewById(R.id.vote_count_down_card);
        this.fCM.setOnRefreshListener(this.fCW);
        this.fCN = (VoteCandidateCard) this.fCC.findViewById(R.id.vote_for_mine);
        this.fCO = (SearchView) this.fCC.findViewById(R.id.vote_search_view);
        this.fCO.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.fCt, a.this.fCt.fid + "")));
            }
        });
        this.fCQ = (FloatMyRecordCard) this.aCR.findViewById(R.id.float_my_record_card);
        this.fCR = (TextView) this.fCC.findViewById(R.id.vote_tip);
        this.elw = new PbListView(this.fCt);
        this.elw.getView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setHeight(l.getDimens(this.fCt, R.dimen.tbds182));
        this.elw.setLineGone();
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elw.aHH();
        this.elv = (NoNetworkView) this.aCR.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e buj;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.buj() != null && (buj = fVar.buj()) != null) {
                this.status = buj.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.fGy) {
                    this.fCO.setVisibility(8);
                    this.fCR.setVisibility(8);
                    this.fCN.setVisibility(8);
                }
            }
            this.fCI.setData(fVar);
            this.fCM.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.fGx) {
                this.fCN.setData(VoteCandidateCard.fGH, fVar);
            }
            if (this.fCP != null) {
                this.mVoteData = fVar;
                this.fCP.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.fGy) {
                this.fCQ.setVisibility(0);
                this.fCQ.setData(fVar);
                this.fCJ.setVisibility(0);
            } else {
                this.fCQ.setVisibility(8);
                this.fCJ.setVisibility(8);
            }
            btS();
            B(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void pk(int i) {
        B(i, false);
    }

    public void B(int i, boolean z) {
        if (z || this.Ni != i) {
            this.Ni = i;
            if (this.emW != null) {
                this.emW.onChangeSkinType();
            }
            am.setBackgroundColor(this.aCR, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.fCH, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.fCB > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.fCG, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.fCB <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.buj() == null || this.mVoteData.buj().getStatus() > 2 || this.mVoteData.buj().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.fCG, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.fCG, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.fCF, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.fCD, R.drawable.pic_bg_recruit, i);
            this.fCI.pk(i);
            this.fCM.pk(i);
            this.fCN.pk(i);
            this.fCO.pk(i);
            am.setViewTextColor(this.fCR, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.fCK, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.fCL, R.drawable.icon_common_explain12_gray66, i);
            this.fCQ.pk(i);
            if (this.elw != null) {
                this.elw.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.elw.changeSkin(i);
            }
            this.elv.onChangeSkinType(this.fCt.getPageContext(), i);
            if (this.fCP != null) {
                this.fCP.notifyDataSetChanged();
            }
        }
    }

    public void btS() {
        if (this.status == com.baidu.tieba.barselect.a.d.fGy) {
            this.elw.showEmptyView(l.getDimens(this.fCt, R.dimen.tbds152));
        }
        this.elw.setOnClickListener(this.fCt);
        this.fCH.setNextPage(this.elw);
        if (this.hasMore) {
            this.elw.showEndLoadData();
            return;
        }
        this.elw.setText(this.fCt.getResources().getString(R.string.list_has_no_more));
        this.elw.endLoadData();
    }

    public View getRootView() {
        return this.aCR;
    }

    public BdRecyclerView getListView() {
        return this.fCH;
    }

    public PbListView btT() {
        return this.elw;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLa = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void zN(String str) {
        if (this.emW != null) {
            this.emW.dettachView(this.mListContainer);
            this.emW = null;
        }
        this.fCt.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fCt, this.fCT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.tV(str), null);
            this.mNoDataView.setOnClickListener(this.cLa);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.tV(str));
        this.mNoDataView.onChangeSkinType(this.fCt.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bcx() {
        if (this.fCH != null) {
            this.fCH.setVisibility(8);
        }
        this.fCt.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.emW == null) {
            this.emW = new h(this.fCt, this.fCU);
        }
        this.emW.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.emW.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.emW.attachView(this.mListContainer, true);
        this.emW.showRefreshButton();
        this.emW.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.fCM != null) {
            this.fCM.onDestroy();
        }
    }
}
