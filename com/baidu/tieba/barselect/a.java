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
    private RelativeLayout bpu;
    private View bqe;
    private LinearLayoutManager dCC;
    private View.OnClickListener dSI;
    private NoNetworkView fDV;
    private PbListView fDW;
    private h fFz;
    private boolean hasMore;
    private BarVoteActivity hbU;
    private int hca;
    private ViewGroup hcd;
    private TbImageView hce;
    private View hcf;
    private View hcg;
    private TextView hch;
    private BdRecyclerView hci;
    private VoteStatusCard hcj;
    private View hck;
    private TextView hcl;
    private TextView hcm;
    private VoteCandidateCard hcn;
    private View hco;
    private TextView hcp;
    private SelectRuleView hcq;
    private SearchView hcr;
    private d hcs;
    private FloatMyRecordCard hct;
    private TextView hcu;
    private int hcv;
    private ViewGroup hcw;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int aiB = 3;
    private int status = -1;
    private int hcb = 0;
    private float hcc = 0.0f;
    private View.OnClickListener hcx = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.fFz != null) {
                    a.this.fFz.dettachView(a.this.mListContainer);
                    a.this.fFz = null;
                }
                a.this.hbU.reload();
                if (a.this.hci != null) {
                    a.this.hci.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a hcy = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.hbU != null) {
                a.this.hbU.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener hcz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.hcd != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.hcc = Math.abs(a.this.hcd.getTop()) / a.this.hca;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.hcc);
                a.this.hcg.setAlpha(a.this.hcc);
                if (a.this.hcc > 0.5d) {
                    if (a.this.hcb == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.aiB);
                        ap.setViewTextColor(a.this.hch, R.color.cp_cont_b, 1, a.this.aiB);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.aiB);
                        a.this.hcb = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.hcc * 2.0f) - 1.0f);
                    a.this.hch.setAlpha((a.this.hcc * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.hcc * 2.0f) - 1.0f);
                } else if (a.this.hcc <= 0.5d) {
                    if (a.this.hcb == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.aiB);
                        ap.setViewTextColor(a.this.hch, R.color.cp_cont_a, 1, a.this.aiB);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.aiB);
                        a.this.hcb = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.hcc * 2.0f));
                    a.this.hch.setAlpha(1.0f - (a.this.hcc * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.hcc * 2.0f));
                }
            }
        }
    };
    private BdListView.e fXT = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hci != null) {
                a.this.hci.stopScroll();
            }
            if (a.this.fDW != null && a.this.hbU != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.hgc) {
                        a.this.fDW.showEmptyView(l.getDimens(a.this.hbU, R.dimen.tbds152));
                    }
                    a.this.hci.setNextPage(a.this.fDW);
                    a.this.fDW.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fDW.showLoading();
                        a.this.hbU.cat();
                        return;
                    }
                    a.this.fDW.setText(a.this.hbU.getResources().getString(R.string.list_has_no_more));
                    a.this.fDW.endLoadData();
                    return;
                }
                a.this.hci.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e caS;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.caS() != null && (caS = fVar.caS()) != null) {
                this.status = caS.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.hgc) {
                    this.hcr.setVisibility(8);
                    this.hcu.setVisibility(8);
                    this.hcn.setVisibility(8);
                }
            }
            this.hcj.setData(fVar);
            if (this.hcs != null) {
                this.mVoteData = fVar;
                this.hcs.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.hgc) {
                this.hct.setVisibility(0);
                this.hct.setData(fVar);
                this.hck.setVisibility(0);
                this.hco.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.hgb) {
                this.hcn.setData(VoteCandidateCard.hgo, fVar);
                this.hct.setVisibility(8);
                this.hck.setVisibility(8);
                this.hcr.setRank(fVar.caS().caK());
                if (fVar.caT() != null) {
                    ManagerElection caT = fVar.caT();
                    if (!y.isEmpty(caT.vote_condition_pic) || !y.isEmpty(caT.vote_condition_title) || !y.isEmpty(caT.vote_condition)) {
                        this.hco.setVisibility(0);
                        this.hcq.setData(caT.vote_condition_pic, caT.vote_condition_title, caT.vote_condition);
                    } else {
                        this.hco.setVisibility(8);
                    }
                } else {
                    this.hco.setVisibility(8);
                }
            } else {
                this.hct.setVisibility(8);
                this.hck.setVisibility(8);
                this.hco.setVisibility(8);
            }
            caC();
            L(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    public void tl(int i) {
        L(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.hbU = barVoteActivity;
        this.bpu = (RelativeLayout) LayoutInflater.from(this.hbU.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.hbU.addContentView(this.bpu, new FrameLayout.LayoutParams(-1, -1));
        this.hbU.showLoadingView(this.bpu, false, l.getDimens(this.hbU, R.dimen.ds400));
        this.mListContainer = this.bpu.findViewById(R.id.list_container);
        this.hcw = (ViewGroup) this.bpu.findViewById(R.id.no_data_container);
        this.hcf = this.bpu.findViewById(R.id.nav_bar_container);
        this.hcg = this.bpu.findViewById(R.id.nav_bar_shadow);
        this.hcg.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bpu.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hbU.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.hca = l.getDimens(this.hbU, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hch = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hbU).findViewById(R.id.right_textview);
        this.hch.setText(R.string.bar_election_rule);
        this.hch.setOnClickListener(this.hbU);
        this.hci = (BdRecyclerView) this.bpu.findViewById(R.id.vote_list);
        this.dCC = new LinearLayoutManager(this.hbU);
        this.hci.setLayoutManager(this.dCC);
        this.hcs = new d(barVoteActivity.getPageContext());
        this.hci.setAdapter(this.hcs);
        this.hcd = (ViewGroup) LayoutInflater.from(this.hbU).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.hcd.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hce = (TbImageView) this.hcd.findViewById(R.id.head_main_iv);
        this.hce.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.hbU) * 884) / 1076));
        this.hci.addHeaderView(this.hcd);
        this.hci.addOnScrollListener(this.hcz);
        this.hci.setOnSrollToBottomListener(this.fXT);
        this.hcv = this.hbU.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bqe = new View(this.hbU);
        this.bqe.setLayoutParams(new AbsListView.LayoutParams(-1, this.hcv));
        this.bqe.setVisibility(4);
        this.hci.addFooterView(this.bqe);
        this.hcj = (VoteStatusCard) this.hcd.findViewById(R.id.vote_status_card);
        this.hck = this.hcd.findViewById(R.id.vote_ueg_tip_container);
        this.hck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.hbU);
                View inflate = LayoutInflater.from(a.this.hbU.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.hbU.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.hbU.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aX(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.hbU.getPageContext());
                ap.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.bhg();
            }
        });
        this.hcl = (TextView) this.hcd.findViewById(R.id.vote_ueg_tip_tv);
        this.hcm = (TextView) this.hcd.findViewById(R.id.vote_ueg_tip_img);
        this.hcj.setOnRefreshListener(this.hcy);
        this.hco = this.hcd.findViewById(R.id.bar_select_rule_bg);
        this.hcp = (TextView) this.hcd.findViewById(R.id.bar_select_rule_main_title);
        this.hcq = (SelectRuleView) this.hcd.findViewById(R.id.bar_select_rule_container);
        this.hcq.setType(1);
        this.hcn = (VoteCandidateCard) this.hcd.findViewById(R.id.vote_for_mine);
        this.hcr = (SearchView) this.hcd.findViewById(R.id.vote_search_view);
        this.hcr.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.hbU, a.this.hbU.fid + "")));
            }
        });
        this.hct = (FloatMyRecordCard) this.bpu.findViewById(R.id.float_my_record_card);
        this.hcu = (TextView) this.hcd.findViewById(R.id.vote_tip);
        this.fDW = new PbListView(this.hbU);
        this.fDW.getView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.hbU, R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.bkv();
        this.fDV = (NoNetworkView) this.bpu.findViewById(R.id.no_network_view);
    }

    public void caC() {
        if (this.status == com.baidu.tieba.barselect.a.d.hgc) {
            this.fDW.showEmptyView(l.getDimens(this.hbU, R.dimen.tbds152));
        }
        this.fDW.setOnClickListener(this.hbU);
        this.hci.setNextPage(this.fDW);
        if (this.hasMore) {
            this.fDW.showEndLoadData();
            return;
        }
        this.fDW.setText(this.hbU.getResources().getString(R.string.list_has_no_more));
        this.fDW.endLoadData();
    }

    public View getRootView() {
        return this.bpu;
    }

    public BdRecyclerView getListView() {
        return this.hci;
    }

    public PbListView caD() {
        return this.fDW;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSI = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void GS(String str) {
        if (this.fFz != null) {
            this.fFz.dettachView(this.mListContainer);
            this.fFz = null;
        }
        this.hbU.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hbU, this.hcw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.AB(str), null);
            this.mNoDataView.setOnClickListener(this.dSI);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.AB(str));
        this.mNoDataView.onChangeSkinType(this.hbU.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bFV() {
        if (this.hci != null) {
            this.hci.setVisibility(8);
        }
        this.hbU.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.fFz == null) {
            this.fFz = new h(this.hbU, this.hcx);
        }
        this.fFz.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.fFz.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.fFz.attachView(this.mListContainer, true);
        this.fFz.showRefreshButton();
        this.fFz.onChangeSkinType();
    }

    public void L(int i, boolean z) {
        if (z || this.aiB != i) {
            this.aiB = i;
            if (this.fFz != null) {
                this.fFz.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bpu, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hci, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.hcc > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.hch, R.color.cp_cont_b, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.hcc <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.caS() == null || this.mVoteData.caS().getStatus() > 2 || this.mVoteData.caS().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.hch, R.color.cp_cont_b, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.hch, R.color.cp_cont_a, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                ap.setBackgroundResource(this.hcg, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.hce, R.drawable.pic_bg_recruit, i);
            this.hcj.tl(i);
            this.hcn.tl(i);
            this.hcr.tl(i);
            ap.setBackgroundResource(this.hco, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hcp, R.color.cp_cont_b);
            if (this.hcq != null) {
                this.hcq.qM(i);
            }
            ap.setViewTextColor(this.hcu, R.color.cp_cont_d, 1, i);
            ap.setViewTextColor(this.hcl, R.color.cp_cont_c, 1, i);
            ap.setBackgroundResource(this.hcm, R.drawable.icon_common_explain12_gray66, i);
            this.hct.tl(i);
            if (this.fDW != null) {
                this.fDW.setTextColor(ap.getColor(i, R.color.cp_cont_j));
                this.fDW.changeSkin(i);
            }
            this.fDV.onChangeSkinType(this.hbU.getPageContext(), i);
            if (this.hcs != null) {
                this.hcs.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.hcj != null) {
            this.hcj.onDestroy();
        }
    }
}
