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
    private View aqJ;
    private RelativeLayout aqa;
    private LinearLayoutManager bIc;
    private View.OnClickListener bUp;
    private NoNetworkView dvR;
    private PbListView dvS;
    private h dwK;
    private int eED;
    private ViewGroup eEG;
    private TbImageView eEH;
    private View eEI;
    private View eEJ;
    private TextView eEK;
    private BdRecyclerView eEL;
    private VoteStatusCard eEM;
    private View eEN;
    private TextView eEO;
    private TextView eEP;
    private VoteCountDownCard eEQ;
    private VoteCandidateCard eER;
    private SearchView eES;
    private d eET;
    private FloatMyRecordCard eEU;
    private TextView eEV;
    private int eEW;
    private ViewGroup eEX;
    private BarVoteActivity eEx;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int csg = 3;
    private int status = -1;
    private int eEE = 0;
    private float eEF = 0.0f;
    private View.OnClickListener eEY = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.dwK != null) {
                    a.this.dwK.dettachView(a.this.mListContainer);
                    a.this.dwK = null;
                }
                a.this.eEx.reload();
                if (a.this.eEL != null) {
                    a.this.eEL.setVisibility(0);
                }
            }
        }
    };
    RecyclerView.OnScrollListener eEZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.eEG != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.eEF = Math.abs(a.this.eEG.getTop()) / a.this.eED;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.eEF);
                a.this.eEJ.setAlpha(a.this.eEF);
                if (a.this.eEF > 0.5d) {
                    if (a.this.eEE == 0) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.csg);
                        am.setViewTextColor(a.this.eEK, R.color.cp_cont_b, 1, a.this.csg);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.csg);
                        a.this.eEE = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.eEF * 2.0f) - 1.0f);
                    a.this.eEK.setAlpha((a.this.eEF * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.eEF * 2.0f) - 1.0f);
                } else if (a.this.eEF <= 0.5d) {
                    if (a.this.eEE == 1) {
                        am.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.csg);
                        am.setViewTextColor(a.this.eEK, R.color.cp_cont_a, 1, a.this.csg);
                        am.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.csg);
                        a.this.eEE = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.eEF * 2.0f));
                    a.this.eEK.setAlpha(1.0f - (a.this.eEF * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.eEF * 2.0f));
                }
            }
        }
    };
    private BdListView.e dIG = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.eEL != null) {
                a.this.eEL.stopScroll();
            }
            if (a.this.dvS != null && a.this.eEx != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.eIE) {
                        a.this.dvS.showEmptyView(l.getDimens(a.this.eEx, R.dimen.tbds152));
                    }
                    a.this.eEL.setNextPage(a.this.dvS);
                    a.this.dvS.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.dvS.showLoading();
                        a.this.eEx.aYW();
                        return;
                    }
                    a.this.dvS.setText(a.this.eEx.getResources().getString(R.string.list_has_no_more));
                    a.this.dvS.endLoadData();
                    return;
                }
                a.this.eEL.setNextPage(null);
            }
        }
    };
    private VoteCountDownCard.a eFa = new VoteCountDownCard.a() { // from class: com.baidu.tieba.barselect.a.6
        @Override // com.baidu.tieba.barselect.view.VoteCountDownCard.a
        public void onRefresh() {
            if (a.this.eEx != null) {
                a.this.eEx.refresh();
            }
        }
    };

    public a(BarVoteActivity barVoteActivity) {
        this.eEx = barVoteActivity;
        this.aqa = (RelativeLayout) LayoutInflater.from(this.eEx.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.eEx.addContentView(this.aqa, new FrameLayout.LayoutParams(-1, -1));
        this.eEx.showLoadingView(this.aqa, false, l.getDimens(this.eEx, R.dimen.ds400));
        this.mListContainer = this.aqa.findViewById(R.id.list_container);
        this.eEX = (ViewGroup) this.aqa.findViewById(R.id.no_data_container);
        this.eEI = this.aqa.findViewById(R.id.nav_bar_container);
        this.eEJ = this.aqa.findViewById(R.id.nav_bar_shadow);
        this.eEJ.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.aqa.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eEx.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.eED = l.getDimens(this.eEx, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEK = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.eEx).findViewById(R.id.right_textview);
        this.eEK.setText(R.string.bar_election_rule);
        this.eEK.setOnClickListener(this.eEx);
        this.eEL = (BdRecyclerView) this.aqa.findViewById(R.id.vote_list);
        this.bIc = new LinearLayoutManager(this.eEx);
        this.eEL.setLayoutManager(this.bIc);
        this.eET = new d(barVoteActivity.getPageContext());
        this.eEL.setAdapter(this.eET);
        this.eEG = (ViewGroup) LayoutInflater.from(this.eEx).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.eEG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.eEH = (TbImageView) this.eEG.findViewById(R.id.head_main_iv);
        this.eEH.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.eEx) * 884) / 1076));
        this.eEL.addHeaderView(this.eEG);
        this.eEL.addOnScrollListener(this.eEZ);
        this.eEL.setOnSrollToBottomListener(this.dIG);
        this.eEW = this.eEx.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aqJ = new View(this.eEx);
        this.aqJ.setLayoutParams(new AbsListView.LayoutParams(-1, this.eEW));
        this.aqJ.setVisibility(4);
        this.eEL.addFooterView(this.aqJ);
        this.eEM = (VoteStatusCard) this.eEG.findViewById(R.id.vote_status_card);
        this.eEN = this.eEG.findViewById(R.id.vote_ueg_tip_container);
        this.eEN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.eEx);
                View inflate = LayoutInflater.from(a.this.eEx.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.bdalert_content)).setText(a.this.eEx.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.eEx.getResources().getString(R.string.vote_ueg_tip_detail_2));
                aVar.aM(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.eEx.getPageContext()).akM();
            }
        });
        this.eEO = (TextView) this.eEG.findViewById(R.id.vote_ueg_tip_tv);
        this.eEP = (TextView) this.eEG.findViewById(R.id.vote_ueg_tip_img);
        this.eEQ = (VoteCountDownCard) this.eEG.findViewById(R.id.vote_count_down_card);
        this.eEQ.setOnRefreshListener(this.eFa);
        this.eER = (VoteCandidateCard) this.eEG.findViewById(R.id.vote_for_mine);
        this.eES = (SearchView) this.eEG.findViewById(R.id.vote_search_view);
        this.eES.s(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.eEx, a.this.eEx.fid + "")));
            }
        });
        this.eEU = (FloatMyRecordCard) this.aqa.findViewById(R.id.float_my_record_card);
        this.eEV = (TextView) this.eEG.findViewById(R.id.vote_tip);
        this.dvS = new PbListView(this.eEx);
        this.dvS.getView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setHeight(l.getDimens(this.eEx, R.dimen.tbds182));
        this.dvS.setLineGone();
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.anJ();
        this.dvR = (NoNetworkView) this.aqa.findViewById(R.id.no_network_view);
    }

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e aZw;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.aZw() != null && (aZw = fVar.aZw()) != null) {
                this.status = aZw.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.eIE) {
                    this.eES.setVisibility(8);
                    this.eEV.setVisibility(8);
                    this.eER.setVisibility(8);
                }
            }
            this.eEM.setData(fVar);
            this.eEQ.setData(fVar);
            if (this.status == com.baidu.tieba.barselect.a.d.eID) {
                this.eER.setData(VoteCandidateCard.eIN, fVar);
            }
            if (this.eET != null) {
                this.mVoteData = fVar;
                this.eET.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.eIE) {
                this.eEU.setVisibility(0);
                this.eEU.setData(fVar);
                this.eEN.setVisibility(0);
            } else {
                this.eEU.setVisibility(8);
                this.eEN.setVisibility(8);
            }
            aZf();
            A(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void mD(int i) {
        A(i, false);
    }

    public void A(int i, boolean z) {
        if (z || this.csg != i) {
            this.csg = i;
            if (this.dwK != null) {
                this.dwK.onChangeSkinType();
            }
            am.setBackgroundColor(this.aqa, R.color.cp_bg_line_d, i);
            am.setBackgroundColor(this.eEL, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.eEF > 0.5d) {
                    am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    am.setViewTextColor(this.eEK, R.color.cp_cont_b, 1, i);
                    am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.eEF <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.aZw() == null || this.mVoteData.aZw().getStatus() > 2 || this.mVoteData.aZw().getStatus() < 1) {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        am.setViewTextColor(this.eEK, R.color.cp_cont_b, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        am.setViewTextColor(this.eEK, R.color.cp_cont_a, 1, i);
                        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                am.setBackgroundResource(this.eEJ, R.drawable.top_view_shadow, i);
            }
            am.setImageResource(this.eEH, R.drawable.pic_bg_recruit, i);
            this.eEM.mD(i);
            this.eEQ.mD(i);
            this.eER.mD(i);
            this.eES.mD(i);
            am.setViewTextColor(this.eEV, R.color.cp_cont_d, 1, i);
            am.setViewTextColor(this.eEO, R.color.cp_cont_c, 1, i);
            am.setBackgroundResource(this.eEP, R.drawable.icon_common_explain12_gray66, i);
            this.eEU.mD(i);
            if (this.dvS != null) {
                this.dvS.setTextColor(am.getColor(i, R.color.cp_cont_j));
                this.dvS.changeSkin(i);
            }
            this.dvR.onChangeSkinType(this.eEx.getPageContext(), i);
            if (this.eET != null) {
                this.eET.notifyDataSetChanged();
            }
        }
    }

    public void aZf() {
        if (this.status == com.baidu.tieba.barselect.a.d.eIE) {
            this.dvS.showEmptyView(l.getDimens(this.eEx, R.dimen.tbds152));
        }
        this.dvS.setOnClickListener(this.eEx);
        this.eEL.setNextPage(this.dvS);
        if (this.hasMore) {
            this.dvS.showEndLoadData();
            return;
        }
        this.dvS.setText(this.eEx.getResources().getString(R.string.list_has_no_more));
        this.dvS.endLoadData();
    }

    public View getRootView() {
        return this.aqa;
    }

    public BdRecyclerView getListView() {
        return this.eEL;
    }

    public PbListView aZg() {
        return this.dvS;
    }

    public void e(View.OnClickListener onClickListener) {
        this.bUp = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void us(String str) {
        if (this.dwK != null) {
            this.dwK.dettachView(this.mListContainer);
            this.dwK = null;
        }
        this.eEx.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eEx, this.eEX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.ow(str), null);
            this.mNoDataView.setOnClickListener(this.bUp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ow(str));
        this.mNoDataView.onChangeSkinType(this.eEx.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aJl() {
        if (this.eEL != null) {
            this.eEL.setVisibility(8);
        }
        this.eEx.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.dwK == null) {
            this.dwK = new h(this.eEx, this.eEY);
        }
        this.dwK.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.dwK.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.dwK.attachView(this.mListContainer, true);
        this.dwK.showRefreshButton();
        this.dwK.onChangeSkinType();
    }

    public void onDestroy() {
        if (this.eEQ != null) {
            this.eEQ.onDestroy();
        }
    }
}
