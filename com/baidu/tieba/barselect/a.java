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
    private RelativeLayout aqs;
    private View arb;
    private LinearLayoutManager bIT;
    private View.OnClickListener bVg;
    private NoNetworkView dwI;
    private PbListView dwJ;
    private h dxB;
    private View eFA;
    private TextView eFB;
    private BdRecyclerView eFC;
    private VoteStatusCard eFD;
    private View eFE;
    private TextView eFF;
    private TextView eFG;
    private VoteCountDownCard eFH;
    private VoteCandidateCard eFI;
    private SearchView eFJ;
    private d eFK;
    private FloatMyRecordCard eFL;
    private TextView eFM;
    private int eFN;
    private ViewGroup eFO;
    private BarVoteActivity eFo;
    private int eFu;
    private ViewGroup eFx;
    private TbImageView eFy;
    private View eFz;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int csX = 3;
    private int status = -1;
    private int eFv = 0;
    private float eFw = 0.0f;
    private View.OnClickListener eFP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.dxB != null) {
                    a.this.dxB.dettachView(a.this.mListContainer);
                    a.this.dxB = null;
                }
                a.this.eFo.reload();
                if (a.this.eFC != null) {
                    a.this.eFC.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener eFQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.eFx != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.eFw = Math.abs(a.this.eFx.getTop()) / a.this.eFu;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.eFw);
                a.this.eFA.setAlpha(a.this.eFw);
                if (a.this.eFw > 0.5d) {
                    if (a.this.eFv == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.csX);
                        am.setViewTextColor(a.this.eFB, R.color.cp_cont_b, 1, a.this.csX);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.csX);
                        a.this.eFv = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.eFw * 2.0f) - 1.0f);
                    a.this.eFB.setAlpha((a.this.eFw * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.eFw * 2.0f) - 1.0f);
                } else if (a.this.eFw <= 0.5d) {
                    if (a.this.eFv == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.csX);
                        am.setViewTextColor(a.this.eFB, R.color.cp_cont_a, 1, a.this.csX);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.csX);
                        a.this.eFv = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.eFw * 2.0f));
                    a.this.eFB.setAlpha(1.0f - (a.this.eFw * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.eFw * 2.0f));
                }
            }
        }
    };
    private BdListView.e dJx = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.eFC != null) {
                a.this.eFC.stopScroll();
            }
            if (a.this.dwJ != null && a.this.eFo != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.eJv) {
                        a.this.dwJ.showEmptyView(l.getDimens(a.this.eFo, R.dimen.tbds152));
                    }
                    a.this.eFC.setNextPage(a.this.dwJ);
                    a.this.dwJ.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.dwJ.showLoading();
                        a.this.eFo.aYY();
                        return;
                    }
                    a.this.dwJ.setText(a.this.eFo.getResources().getString(R.string.list_has_no_more));
                    a.this.dwJ.endLoadData();
                    return;
                }
                a.this.eFC.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a eFR = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.eFo != null) {
                a.this.eFo.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.eFo = barVoteActivity;
        this.aqs = (RelativeLayout) LayoutInflater.from(this.eFo.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.eFo.addContentView(this.aqs, new FrameLayout.LayoutParams(-1, -1));
        this.eFo.showLoadingView(this.aqs, false, l.getDimens(this.eFo, R.dimen.ds400));
        this.mListContainer = this.aqs.findViewById(R.id.list_container);
        this.eFO = (ViewGroup) this.aqs.findViewById(R.id.no_data_container);
        this.eFz = this.aqs.findViewById(R.id.nav_bar_container);
        this.eFA = this.aqs.findViewById(R.id.nav_bar_shadow);
        this.eFA.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.aqs.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eFo.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.eFu = l.getDimens(this.eFo, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eFB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.eFo).findViewById(R.id.right_textview);
        this.eFB.setText(R.string.bar_election_rule);
        this.eFB.setOnClickListener(this.eFo);
        this.eFC = (BdRecyclerView) this.aqs.findViewById(R.id.vote_list);
        this.bIT = new LinearLayoutManager(this.eFo);
        this.eFC.setLayoutManager(this.bIT);
        this.eFK = new d(barVoteActivity.getPageContext());
        this.eFC.setAdapter(this.eFK);
        this.eFx = (ViewGroup) LayoutInflater.from(this.eFo).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.eFx.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.eFy = (TbImageView) this.eFx.findViewById(R.id.head_main_iv);
        this.eFy.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.eFo) * 884) / 1076));
        this.eFC.addHeaderView(this.eFx);
        this.eFC.addOnScrollListener(this.eFQ);
        this.eFC.setOnSrollToBottomListener(this.dJx);
        this.eFN = this.eFo.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.arb = new View(this.eFo);
        this.arb.setLayoutParams(new AbsListView.LayoutParams(-1, this.eFN));
        this.arb.setVisibility(4);
        this.eFC.addFooterView(this.arb);
        this.eFD = (VoteStatusCard) this.eFx.findViewById(R.id.vote_status_card);
        this.eFE = this.eFx.findViewById(R.id.vote_ueg_tip_container);
        this.eFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.eFo);
                View inflate = LayoutInflater.from(a.this.eFo.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.eFo.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.eFo.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aM(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.eFo.getPageContext()).akO();
            }
        });
        this.eFF = (TextView) this.eFx.findViewById(R.id.vote_ueg_tip_tv);
        this.eFG = (TextView) this.eFx.findViewById(R.id.vote_ueg_tip_img);
        this.eFH = (VoteCountDownCard) this.eFx.findViewById(R.id.vote_count_down_card);
        this.eFH.setOnRefreshListener(this.eFR);
        this.eFI = (VoteCandidateCard) this.eFx.findViewById(R.id.vote_for_mine);
        this.eFJ = (SearchView) this.eFx.findViewById(R.id.vote_search_view);
        this.eFJ.s(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.eFo, a.this.eFo.fid + "")));
            }
        });
        this.eFL = (FloatMyRecordCard) this.aqs.findViewById(R.id.float_my_record_card);
        this.eFM = (TextView) this.eFx.findViewById(R.id.vote_tip);
        this.dwJ = new PbListView(this.eFo);
        this.dwJ.getView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setHeight(l.getDimens(this.eFo, R.dimen.tbds182));
        this.dwJ.setLineGone();
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dwJ.anL();
        this.dwI = (NoNetworkView) this.aqs.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e aZy;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.aZy() != null && (aZy = fVar.aZy()) != null) {
                this.status = aZy.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.eJv) {
                    this.eFJ.setVisibility(8);
                    this.eFM.setVisibility(8);
                    this.eFI.setVisibility(8);
                }
            }
            this.eFD.setData(fVar);
            this.eFH.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.eJu) {
                this.eFI.setData(VoteCandidateCard.eJE, fVar);
            }
            if (this.eFK != null) {
                this.mVoteData = fVar;
                this.eFK.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.eJv) {
                this.eFL.setVisibility(0);
                this.eFL.setData(fVar);
                this.eFE.setVisibility(0);
            } else {
                this.eFL.setVisibility(8);
                this.eFE.setVisibility(8);
            }
            aZh();
            A(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void mE(int i) {
        A(i, false);
    }

    public void A(int i, boolean z) {
        if (z || this.csX != i) {
            this.csX = i;
            if (this.dxB != null) {
                this.dxB.onChangeSkinType();
            }
            am.setBackgroundColor(this.aqs, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.eFC, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.eFw > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.eFB, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.eFw <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.aZy() == null || this.mVoteData.aZy().getStatus() > 2 || this.mVoteData.aZy().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.eFB, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.eFB, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.eFA, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.eFy, R.drawable.pic_bg_recruit, i);
            this.eFD.mE(i);
            this.eFH.mE(i);
            this.eFI.mE(i);
            this.eFJ.mE(i);
            am.setViewTextColor(this.eFM, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.eFF, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.eFG, R.drawable.icon_common_explain12_gray66, i);
            this.eFL.mE(i);
            if (this.dwJ != null) {
                this.dwJ.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.dwJ.changeSkin(i);
            }
            this.dwI.onChangeSkinType(this.eFo.getPageContext(), i);
            if (this.eFK != null) {
                this.eFK.notifyDataSetChanged();
            }
        }
    }

    public void aZh() {
        if (this.status == com.baidu.tieba.barselect.a.d.eJv) {
            this.dwJ.showEmptyView(l.getDimens(this.eFo, R.dimen.tbds152));
        }
        this.dwJ.setOnClickListener(this.eFo);
        this.eFC.setNextPage(this.dwJ);
        if (this.hasMore) {
            this.dwJ.showEndLoadData();
            return;
        }
        this.dwJ.setText(this.eFo.getResources().getString(R.string.list_has_no_more));
        this.dwJ.endLoadData();
    }

    public View getRootView() {
        return this.aqs;
    }

    public BdRecyclerView getListView() {
        return this.eFC;
    }

    public PbListView aZi() {
        return this.dwJ;
    }

    public void e(View.OnClickListener onClickListener) {
        this.bVg = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void us(String str) {
        if (this.dxB != null) {
            this.dxB.dettachView(this.mListContainer);
            this.dxB = null;
        }
        this.eFo.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eFo, this.eFO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.ow(str), null);
            this.mNoDataView.setOnClickListener(this.bVg);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ow(str));
        this.mNoDataView.onChangeSkinType(this.eFo.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aJn() {
        if (this.eFC != null) {
            this.eFC.setVisibility(8);
        }
        this.eFo.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.dxB == null) {
            this.dxB = new h(this.eFo, this.eFP);
        }
        this.dxB.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.dxB.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.dxB.attachView(this.mListContainer, true);
        this.dxB.showRefreshButton();
        this.dxB.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.eFH != null) {
            this.eFH.onDestroy();
        }
    }
}
