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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private RelativeLayout bjv;
    private View bkf;
    private View.OnClickListener dDD;
    private LinearLayoutManager dmG;
    private NoNetworkView fns;
    private PbListView fnt;
    private h foV;
    private int gJE;
    private ViewGroup gJH;
    private TbImageView gJI;
    private View gJJ;
    private View gJK;
    private TextView gJL;
    private BdRecyclerView gJM;
    private VoteStatusCard gJN;
    private View gJO;
    private TextView gJP;
    private TextView gJQ;
    private VoteCandidateCard gJR;
    private View gJS;
    private TextView gJT;
    private SelectRuleView gJU;
    private SearchView gJV;
    private d gJW;
    private FloatMyRecordCard gJX;
    private TextView gJY;
    private int gJZ;
    private BarVoteActivity gJy;
    private ViewGroup gKa;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ahx = 3;
    private int status = -1;
    private int gJF = 0;
    private float gJG = 0.0f;
    private View.OnClickListener gKb = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.foV != null) {
                    a.this.foV.dettachView(a.this.mListContainer);
                    a.this.foV = null;
                }
                a.this.gJy.reload();
                if (a.this.gJM != null) {
                    a.this.gJM.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a gKc = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.gJy != null) {
                a.this.gJy.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener gKd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.gJH != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.gJG = Math.abs(a.this.gJH.getTop()) / a.this.gJE;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.gJG);
                a.this.gJK.setAlpha(a.this.gJG);
                if (a.this.gJG > 0.5d) {
                    if (a.this.gJF == 0) {
                        an.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.ahx);
                        an.setViewTextColor(a.this.gJL, R.color.cp_cont_b, 1, a.this.ahx);
                        an.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.ahx);
                        a.this.gJF = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.gJG * 2.0f) - 1.0f);
                    a.this.gJL.setAlpha((a.this.gJG * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.gJG * 2.0f) - 1.0f);
                } else if (a.this.gJG <= 0.5d) {
                    if (a.this.gJF == 1) {
                        an.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.ahx);
                        an.setViewTextColor(a.this.gJL, R.color.cp_cont_a, 1, a.this.ahx);
                        an.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.ahx);
                        a.this.gJF = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.gJG * 2.0f));
                    a.this.gJL.setAlpha(1.0f - (a.this.gJG * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.gJG * 2.0f));
                }
            }
        }
    };
    private BdListView.e fGA = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.gJM != null) {
                a.this.gJM.stopScroll();
            }
            if (a.this.fnt != null && a.this.gJy != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.gND) {
                        a.this.fnt.showEmptyView(l.getDimens(a.this.gJy, R.dimen.tbds152));
                    }
                    a.this.gJM.setNextPage(a.this.fnt);
                    a.this.fnt.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fnt.showLoading();
                        a.this.gJy.bMX();
                        return;
                    }
                    a.this.fnt.setText(a.this.gJy.getResources().getString(R.string.list_has_no_more));
                    a.this.fnt.endLoadData();
                    return;
                }
                a.this.gJM.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e bNw;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.bNw() != null && (bNw = fVar.bNw()) != null) {
                this.status = bNw.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.gND) {
                    this.gJV.setVisibility(8);
                    this.gJY.setVisibility(8);
                    this.gJR.setVisibility(8);
                }
            }
            this.gJN.setData(fVar);
            if (this.gJW != null) {
                this.mVoteData = fVar;
                this.gJW.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.gND) {
                this.gJX.setVisibility(0);
                this.gJX.setData(fVar);
                this.gJO.setVisibility(0);
                this.gJS.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.gNC) {
                this.gJR.setData(VoteCandidateCard.gNP, fVar);
                this.gJX.setVisibility(8);
                this.gJO.setVisibility(8);
                this.gJV.setRank(fVar.bNw().bNo());
                if (fVar.bNx() != null) {
                    ManagerElection bNx = fVar.bNx();
                    if (!w.isEmpty(bNx.vote_condition_pic) || !w.isEmpty(bNx.vote_condition_title) || !w.isEmpty(bNx.vote_condition)) {
                        this.gJS.setVisibility(0);
                        this.gJU.setData(bNx.vote_condition_pic, bNx.vote_condition_title, bNx.vote_condition);
                    } else {
                        this.gJS.setVisibility(8);
                    }
                } else {
                    this.gJS.setVisibility(8);
                }
            } else {
                this.gJX.setVisibility(8);
                this.gJO.setVisibility(8);
                this.gJS.setVisibility(8);
            }
            bNg();
            J(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void qJ(int i) {
        J(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.gJy = barVoteActivity;
        this.bjv = (RelativeLayout) LayoutInflater.from(this.gJy.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.gJy.addContentView(this.bjv, new FrameLayout.LayoutParams(-1, -1));
        this.gJy.showLoadingView(this.bjv, false, l.getDimens(this.gJy, R.dimen.ds400));
        this.mListContainer = this.bjv.findViewById(R.id.list_container);
        this.gKa = (ViewGroup) this.bjv.findViewById(R.id.no_data_container);
        this.gJJ = this.bjv.findViewById(R.id.nav_bar_container);
        this.gJK = this.bjv.findViewById(R.id.nav_bar_shadow);
        this.gJK.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bjv.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gJy.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.gJE = l.getDimens(this.gJy, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gJL = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.gJy).findViewById(R.id.right_textview);
        this.gJL.setText(R.string.bar_election_rule);
        this.gJL.setOnClickListener(this.gJy);
        this.gJM = (BdRecyclerView) this.bjv.findViewById(R.id.vote_list);
        this.dmG = new LinearLayoutManager(this.gJy);
        this.gJM.setLayoutManager(this.dmG);
        this.gJW = new d(barVoteActivity.getPageContext());
        this.gJM.setAdapter(this.gJW);
        this.gJH = (ViewGroup) LayoutInflater.from(this.gJy).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.gJH.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gJI = (TbImageView) this.gJH.findViewById(R.id.head_main_iv);
        this.gJI.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.gJy) * 884) / 1076));
        this.gJM.addHeaderView(this.gJH);
        this.gJM.addOnScrollListener(this.gKd);
        this.gJM.setOnSrollToBottomListener(this.fGA);
        this.gJZ = this.gJy.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bkf = new View(this.gJy);
        this.bkf.setLayoutParams(new AbsListView.LayoutParams(-1, this.gJZ));
        this.bkf.setVisibility(4);
        this.gJM.addFooterView(this.bkf);
        this.gJN = (VoteStatusCard) this.gJH.findViewById(R.id.vote_status_card);
        this.gJO = this.gJH.findViewById(R.id.vote_ueg_tip_container);
        this.gJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.gJy);
                View inflate = LayoutInflater.from(a.this.gJy.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.gJy.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.gJy.getResources().getString(R.string.vote_ueg_tip_detail_2));
                an.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aP(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.gJy.getPageContext());
                an.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.aUN();
            }
        });
        this.gJP = (TextView) this.gJH.findViewById(R.id.vote_ueg_tip_tv);
        this.gJQ = (TextView) this.gJH.findViewById(R.id.vote_ueg_tip_img);
        this.gJN.setOnRefreshListener(this.gKc);
        this.gJS = this.gJH.findViewById(R.id.bar_select_rule_bg);
        this.gJT = (TextView) this.gJH.findViewById(R.id.bar_select_rule_main_title);
        this.gJU = (SelectRuleView) this.gJH.findViewById(R.id.bar_select_rule_container);
        this.gJU.setType(1);
        this.gJR = (VoteCandidateCard) this.gJH.findViewById(R.id.vote_for_mine);
        this.gJV = (SearchView) this.gJH.findViewById(R.id.vote_search_view);
        this.gJV.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.gJy, a.this.gJy.fid + "")));
            }
        });
        this.gJX = (FloatMyRecordCard) this.bjv.findViewById(R.id.float_my_record_card);
        this.gJY = (TextView) this.gJH.findViewById(R.id.vote_tip);
        this.fnt = new PbListView(this.gJy);
        this.fnt.getView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.gJy, R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.aXZ();
        this.fns = (NoNetworkView) this.bjv.findViewById(R.id.no_network_view);
    }

    public void bNg() {
        if (this.status == com.baidu.tieba.barselect.a.d.gND) {
            this.fnt.showEmptyView(l.getDimens(this.gJy, R.dimen.tbds152));
        }
        this.fnt.setOnClickListener(this.gJy);
        this.gJM.setNextPage(this.fnt);
        if (this.hasMore) {
            this.fnt.showEndLoadData();
            return;
        }
        this.fnt.setText(this.gJy.getResources().getString(R.string.list_has_no_more));
        this.fnt.endLoadData();
    }

    public View getRootView() {
        return this.bjv;
    }

    public BdRecyclerView getListView() {
        return this.gJM;
    }

    public PbListView bNh() {
        return this.fnt;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dDD = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void DI(String str) {
        if (this.foV != null) {
            this.foV.dettachView(this.mListContainer);
            this.foV = null;
        }
        this.gJy.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gJy, this.gKa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.xi(str), null);
            this.mNoDataView.setOnClickListener(this.dDD);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.xi(str));
        this.mNoDataView.onChangeSkinType(this.gJy.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void btN() {
        if (this.gJM != null) {
            this.gJM.setVisibility(8);
        }
        this.gJy.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.foV == null) {
            this.foV = new h(this.gJy, this.gKb);
        }
        this.foV.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.foV.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.foV.attachView(this.mListContainer, true);
        this.foV.showRefreshButton();
        this.foV.onChangeSkinType();
    }

    public void J(int i, boolean z) {
        if (z || this.ahx != i) {
            this.ahx = i;
            if (this.foV != null) {
                this.foV.onChangeSkinType();
            }
            an.setBackgroundColor(this.bjv, R.color.cp_bg_line_d, i);
            an.setBackgroundColor(this.gJM, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                an.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.gJG > 0.5d) {
                    an.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    an.setViewTextColor(this.gJL, R.color.cp_cont_b, 1, i);
                    an.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.gJG <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.bNw() == null || this.mVoteData.bNw().getStatus() > 2 || this.mVoteData.bNw().getStatus() < 1) {
                        an.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        an.setViewTextColor(this.gJL, R.color.cp_cont_b, 1, i);
                        an.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        an.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        an.setViewTextColor(this.gJL, R.color.cp_cont_a, 1, i);
                        an.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                an.setBackgroundResource(this.gJK, R.drawable.top_view_shadow, i);
            }
            an.setImageResource(this.gJI, R.drawable.pic_bg_recruit, i);
            this.gJN.qJ(i);
            this.gJR.qJ(i);
            this.gJV.qJ(i);
            an.setBackgroundResource(this.gJS, R.drawable.bar_select_bg_shadow_and_radius, i);
            an.setViewTextColor(this.gJT, (int) R.color.cp_cont_b);
            if (this.gJU != null) {
                this.gJU.oh(i);
            }
            an.setViewTextColor(this.gJY, R.color.cp_cont_d, 1, i);
            an.setViewTextColor(this.gJP, R.color.cp_cont_c, 1, i);
            an.setBackgroundResource(this.gJQ, R.drawable.icon_common_explain12_gray66, i);
            this.gJX.qJ(i);
            if (this.fnt != null) {
                this.fnt.setTextColor(an.getColor(i, R.color.cp_cont_j));
                this.fnt.changeSkin(i);
            }
            this.fns.onChangeSkinType(this.gJy.getPageContext(), i);
            if (this.gJW != null) {
                this.gJW.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.gJN != null) {
            this.gJN.onDestroy();
        }
    }
}
