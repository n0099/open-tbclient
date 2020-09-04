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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
    private RelativeLayout bpx;
    private View bqh;
    private LinearLayoutManager dCG;
    private View.OnClickListener dSM;
    private NoNetworkView fDZ;
    private PbListView fEa;
    private h fFD;
    private boolean hasMore;
    private BarVoteActivity hbY;
    private ViewGroup hcA;
    private int hce;
    private ViewGroup hch;
    private TbImageView hci;
    private View hcj;
    private View hck;
    private TextView hcl;
    private BdRecyclerView hcm;
    private VoteStatusCard hcn;
    private View hco;
    private TextView hcp;
    private TextView hcq;
    private VoteCandidateCard hcr;
    private View hcs;
    private TextView hct;
    private SelectRuleView hcu;
    private SearchView hcv;
    private d hcw;
    private FloatMyRecordCard hcx;
    private TextView hcy;
    private int hcz;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int aiD = 3;
    private int status = -1;
    private int hcf = 0;
    private float hcg = 0.0f;
    private View.OnClickListener hcB = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.fFD != null) {
                    a.this.fFD.dettachView(a.this.mListContainer);
                    a.this.fFD = null;
                }
                a.this.hbY.reload();
                if (a.this.hcm != null) {
                    a.this.hcm.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a hcC = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.hbY != null) {
                a.this.hbY.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.hch != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.hcg = Math.abs(a.this.hch.getTop()) / a.this.hce;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.hcg);
                a.this.hck.setAlpha(a.this.hcg);
                if (a.this.hcg > 0.5d) {
                    if (a.this.hcf == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.aiD);
                        ap.setViewTextColor(a.this.hcl, R.color.cp_cont_b, 1, a.this.aiD);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.aiD);
                        a.this.hcf = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.hcg * 2.0f) - 1.0f);
                    a.this.hcl.setAlpha((a.this.hcg * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.hcg * 2.0f) - 1.0f);
                } else if (a.this.hcg <= 0.5d) {
                    if (a.this.hcf == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.aiD);
                        ap.setViewTextColor(a.this.hcl, R.color.cp_cont_a, 1, a.this.aiD);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.aiD);
                        a.this.hcf = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.hcg * 2.0f));
                    a.this.hcl.setAlpha(1.0f - (a.this.hcg * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.hcg * 2.0f));
                }
            }
        }
    };
    private BdListView.e fXX = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hcm != null) {
                a.this.hcm.stopScroll();
            }
            if (a.this.fEa != null && a.this.hbY != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.hgg) {
                        a.this.fEa.showEmptyView(l.getDimens(a.this.hbY, R.dimen.tbds152));
                    }
                    a.this.hcm.setNextPage(a.this.fEa);
                    a.this.fEa.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fEa.showLoading();
                        a.this.hbY.cau();
                        return;
                    }
                    a.this.fEa.setText(a.this.hbY.getResources().getString(R.string.list_has_no_more));
                    a.this.fEa.endLoadData();
                    return;
                }
                a.this.hcm.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e caT;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.caT() != null && (caT = fVar.caT()) != null) {
                this.status = caT.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.hgg) {
                    this.hcv.setVisibility(8);
                    this.hcy.setVisibility(8);
                    this.hcr.setVisibility(8);
                }
            }
            this.hcn.setData(fVar);
            if (this.hcw != null) {
                this.mVoteData = fVar;
                this.hcw.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.hgg) {
                this.hcx.setVisibility(0);
                this.hcx.setData(fVar);
                this.hco.setVisibility(0);
                this.hcs.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.hgf) {
                this.hcr.setData(VoteCandidateCard.hgs, fVar);
                this.hcx.setVisibility(8);
                this.hco.setVisibility(8);
                this.hcv.setRank(fVar.caT().caL());
                if (fVar.caU() != null) {
                    ManagerElection caU = fVar.caU();
                    if (!y.isEmpty(caU.vote_condition_pic) || !y.isEmpty(caU.vote_condition_title) || !y.isEmpty(caU.vote_condition)) {
                        this.hcs.setVisibility(0);
                        this.hcu.setData(caU.vote_condition_pic, caU.vote_condition_title, caU.vote_condition);
                    } else {
                        this.hcs.setVisibility(8);
                    }
                } else {
                    this.hcs.setVisibility(8);
                }
            } else {
                this.hcx.setVisibility(8);
                this.hco.setVisibility(8);
                this.hcs.setVisibility(8);
            }
            caD();
            L(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void tl(int i) {
        L(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.hbY = barVoteActivity;
        this.bpx = (RelativeLayout) LayoutInflater.from(this.hbY.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.hbY.addContentView(this.bpx, new FrameLayout.LayoutParams(-1, -1));
        this.hbY.showLoadingView(this.bpx, false, l.getDimens(this.hbY, R.dimen.ds400));
        this.mListContainer = this.bpx.findViewById(R.id.list_container);
        this.hcA = (ViewGroup) this.bpx.findViewById(R.id.no_data_container);
        this.hcj = this.bpx.findViewById(R.id.nav_bar_container);
        this.hck = this.bpx.findViewById(R.id.nav_bar_shadow);
        this.hck.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bpx.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hbY.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.hce = l.getDimens(this.hbY, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hcl = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hbY).findViewById(R.id.right_textview);
        this.hcl.setText(R.string.bar_election_rule);
        this.hcl.setOnClickListener(this.hbY);
        this.hcm = (BdRecyclerView) this.bpx.findViewById(R.id.vote_list);
        this.dCG = new LinearLayoutManager(this.hbY);
        this.hcm.setLayoutManager(this.dCG);
        this.hcw = new d(barVoteActivity.getPageContext());
        this.hcm.setAdapter(this.hcw);
        this.hch = (ViewGroup) LayoutInflater.from(this.hbY).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.hch.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hci = (TbImageView) this.hch.findViewById(R.id.head_main_iv);
        this.hci.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.hbY) * 884) / 1076));
        this.hcm.addHeaderView(this.hch);
        this.hcm.addOnScrollListener(this.hcD);
        this.hcm.setOnSrollToBottomListener(this.fXX);
        this.hcz = this.hbY.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bqh = new View(this.hbY);
        this.bqh.setLayoutParams(new AbsListView.LayoutParams(-1, this.hcz));
        this.bqh.setVisibility(4);
        this.hcm.addFooterView(this.bqh);
        this.hcn = (VoteStatusCard) this.hch.findViewById(R.id.vote_status_card);
        this.hco = this.hch.findViewById(R.id.vote_ueg_tip_container);
        this.hco.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.hbY);
                View inflate = LayoutInflater.from(a.this.hbY.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.hbY.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.hbY.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aX(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.hbY.getPageContext());
                ap.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.bhg();
            }
        });
        this.hcp = (TextView) this.hch.findViewById(R.id.vote_ueg_tip_tv);
        this.hcq = (TextView) this.hch.findViewById(R.id.vote_ueg_tip_img);
        this.hcn.setOnRefreshListener(this.hcC);
        this.hcs = this.hch.findViewById(R.id.bar_select_rule_bg);
        this.hct = (TextView) this.hch.findViewById(R.id.bar_select_rule_main_title);
        this.hcu = (SelectRuleView) this.hch.findViewById(R.id.bar_select_rule_container);
        this.hcu.setType(1);
        this.hcr = (VoteCandidateCard) this.hch.findViewById(R.id.vote_for_mine);
        this.hcv = (SearchView) this.hch.findViewById(R.id.vote_search_view);
        this.hcv.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.hbY, a.this.hbY.fid + "")));
            }
        });
        this.hcx = (FloatMyRecordCard) this.bpx.findViewById(R.id.float_my_record_card);
        this.hcy = (TextView) this.hch.findViewById(R.id.vote_tip);
        this.fEa = new PbListView(this.hbY);
        this.fEa.getView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.hbY, R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.bkv();
        this.fDZ = (NoNetworkView) this.bpx.findViewById(R.id.no_network_view);
    }

    public void caD() {
        if (this.status == com.baidu.tieba.barselect.a.d.hgg) {
            this.fEa.showEmptyView(l.getDimens(this.hbY, R.dimen.tbds152));
        }
        this.fEa.setOnClickListener(this.hbY);
        this.hcm.setNextPage(this.fEa);
        if (this.hasMore) {
            this.fEa.showEndLoadData();
            return;
        }
        this.fEa.setText(this.hbY.getResources().getString(R.string.list_has_no_more));
        this.fEa.endLoadData();
    }

    public View getRootView() {
        return this.bpx;
    }

    public BdRecyclerView getListView() {
        return this.hcm;
    }

    public PbListView caE() {
        return this.fEa;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSM = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void GT(String str) {
        if (this.fFD != null) {
            this.fFD.dettachView(this.mListContainer);
            this.fFD = null;
        }
        this.hbY.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hbY, this.hcA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.AC(str), null);
            this.mNoDataView.setOnClickListener(this.dSM);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.AC(str));
        this.mNoDataView.onChangeSkinType(this.hbY.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bFW() {
        if (this.hcm != null) {
            this.hcm.setVisibility(8);
        }
        this.hbY.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.fFD == null) {
            this.fFD = new h(this.hbY, this.hcB);
        }
        this.fFD.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.fFD.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.fFD.attachView(this.mListContainer, true);
        this.fFD.showRefreshButton();
        this.fFD.onChangeSkinType();
    }

    public void L(int i, boolean z) {
        if (z || this.aiD != i) {
            this.aiD = i;
            if (this.fFD != null) {
                this.fFD.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bpx, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hcm, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.hcg > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.hcl, R.color.cp_cont_b, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.hcg <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.caT() == null || this.mVoteData.caT().getStatus() > 2 || this.mVoteData.caT().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.hcl, R.color.cp_cont_b, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.hcl, R.color.cp_cont_a, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                ap.setBackgroundResource(this.hck, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.hci, R.drawable.pic_bg_recruit, i);
            this.hcn.tl(i);
            this.hcr.tl(i);
            this.hcv.tl(i);
            ap.setBackgroundResource(this.hcs, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hct, R.color.cp_cont_b);
            if (this.hcu != null) {
                this.hcu.qM(i);
            }
            ap.setViewTextColor(this.hcy, R.color.cp_cont_d, 1, i);
            ap.setViewTextColor(this.hcp, R.color.cp_cont_c, 1, i);
            ap.setBackgroundResource(this.hcq, R.drawable.icon_common_explain12_gray66, i);
            this.hcx.tl(i);
            if (this.fEa != null) {
                this.fEa.setTextColor(ap.getColor(i, R.color.cp_cont_j));
                this.fEa.changeSkin(i);
            }
            this.fDZ.onChangeSkinType(this.hbY.getPageContext(), i);
            if (this.hcw != null) {
                this.hcw.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.hcn != null) {
            this.hcn.onDestroy();
        }
    }
}
