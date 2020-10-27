package com.baidu.tieba.barselect;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.UtilHelper;
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
import tbclient.ElectionInfo.NoticeContent;
import tbclient.ManagerElection;
/* loaded from: classes21.dex */
public class a {
    private RelativeLayout byI;
    private View bzs;
    private LinearLayoutManager dZe;
    private View.OnClickListener epw;
    private NoNetworkView gdx;
    private PbListView gdy;
    private h gfk;
    private View hKA;
    private TextView hKB;
    private BdRecyclerView hKC;
    private VoteStatusCard hKD;
    private View hKE;
    private TextView hKF;
    private TextView hKG;
    private VoteCandidateCard hKH;
    private View hKI;
    private TextView hKJ;
    private SelectRuleView hKK;
    private SearchView hKL;
    private d hKM;
    private FloatMyRecordCard hKN;
    private TextView hKO;
    private int hKP;
    private ViewGroup hKQ;
    private BarVoteActivity hKo;
    private int hKu;
    private ViewGroup hKx;
    private TbImageView hKy;
    private View hKz;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ajq = 3;
    private int status = -1;
    private int hKv = 0;
    private float hKw = 0.0f;
    private View.OnClickListener hKR = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gfk != null) {
                    a.this.gfk.dettachView(a.this.mListContainer);
                    a.this.gfk = null;
                }
                a.this.hKo.reload();
                if (a.this.hKC != null) {
                    a.this.hKC.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a hKS = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.hKo != null) {
                a.this.hKo.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.hKx != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.hKw = Math.abs(a.this.hKx.getTop()) / a.this.hKu;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.hKw);
                a.this.hKA.setAlpha(a.this.hKw);
                if (a.this.hKw > 0.5d) {
                    if (a.this.hKv == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.ajq);
                        ap.setViewTextColor(a.this.hKB, R.color.cp_cont_b, 1, a.this.ajq);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.ajq);
                        a.this.hKv = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.hKw * 2.0f) - 1.0f);
                    a.this.hKB.setAlpha((a.this.hKw * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.hKw * 2.0f) - 1.0f);
                } else if (a.this.hKw <= 0.5d) {
                    if (a.this.hKv == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.ajq);
                        ap.setViewTextColor(a.this.hKB, R.color.cp_cont_a, 1, a.this.ajq);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.ajq);
                        a.this.hKv = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.hKw * 2.0f));
                    a.this.hKB.setAlpha(1.0f - (a.this.hKw * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.hKw * 2.0f));
                }
            }
        }
    };
    private BdListView.e gxH = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hKC != null) {
                a.this.hKC.stopScroll();
            }
            if (a.this.gdy != null && a.this.hKo != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.hOx) {
                        a.this.gdy.showEmptyView(l.getDimens(a.this.hKo, R.dimen.tbds152));
                    }
                    a.this.hKC.setNextPage(a.this.gdy);
                    a.this.gdy.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gdy.showLoading();
                        a.this.hKo.ckj();
                        return;
                    }
                    a.this.gdy.setText(a.this.hKo.getResources().getString(R.string.list_has_no_more));
                    a.this.gdy.endLoadData();
                    return;
                }
                a.this.hKC.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e ckL;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.ckL() != null && (ckL = fVar.ckL()) != null) {
                this.status = ckL.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.hOx) {
                    this.hKL.setVisibility(8);
                    this.hKO.setVisibility(8);
                    this.hKH.setVisibility(8);
                }
                NoticeContent ckI = ckL.ckI();
                if (ckI != null && !TextUtils.isEmpty(ckI.public_notice)) {
                    IB(ckI.public_notice + "占");
                } else {
                    IB(this.hKo.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.hKD.setData(fVar);
            if (this.hKM != null) {
                this.mVoteData = fVar;
                this.hKM.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.hOx) {
                this.hKN.setVisibility(0);
                this.hKN.setData(fVar);
                this.hKE.setVisibility(0);
                this.hKI.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.hOw) {
                this.hKH.setData(VoteCandidateCard.hOJ, fVar);
                this.hKN.setVisibility(8);
                this.hKE.setVisibility(8);
                this.hKL.setRank(fVar.ckL().ckC());
                if (fVar.ckM() != null) {
                    ManagerElection ckM = fVar.ckM();
                    if (!y.isEmpty(ckM.vote_condition_pic) || !y.isEmpty(ckM.vote_condition_title) || !y.isEmpty(ckM.vote_condition)) {
                        this.hKI.setVisibility(0);
                        this.hKK.setData(ckM.vote_condition_pic, ckM.vote_condition_title, ckM.vote_condition);
                    } else {
                        this.hKI.setVisibility(8);
                    }
                } else {
                    this.hKI.setVisibility(8);
                }
            } else {
                this.hKN.setVisibility(8);
                this.hKE.setVisibility(8);
                this.hKI.setVisibility(8);
            }
            cks();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void IB(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable, 0);
        bVar.aG(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.hKF.setText(spannableString);
    }

    public void uu(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.hKo = barVoteActivity;
        this.byI = (RelativeLayout) LayoutInflater.from(this.hKo.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.hKo.addContentView(this.byI, new FrameLayout.LayoutParams(-1, -1));
        this.hKo.showLoadingView(this.byI, false, l.getDimens(this.hKo, R.dimen.ds400));
        this.mListContainer = this.byI.findViewById(R.id.list_container);
        this.hKQ = (ViewGroup) this.byI.findViewById(R.id.no_data_container);
        this.hKz = this.byI.findViewById(R.id.nav_bar_container);
        this.hKA = this.byI.findViewById(R.id.nav_bar_shadow);
        this.hKA.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.byI.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hKo.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.hKu = l.getDimens(this.hKo, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hKB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hKo).findViewById(R.id.right_textview);
        this.hKB.setText(R.string.bar_election_rule);
        this.hKB.setOnClickListener(this.hKo);
        this.hKC = (BdRecyclerView) this.byI.findViewById(R.id.vote_list);
        this.dZe = new LinearLayoutManager(this.hKo);
        this.hKC.setLayoutManager(this.dZe);
        this.hKM = new d(barVoteActivity.getPageContext());
        this.hKC.setAdapter(this.hKM);
        this.hKx = (ViewGroup) LayoutInflater.from(this.hKo).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.hKx.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hKy = (TbImageView) this.hKx.findViewById(R.id.head_main_iv);
        this.hKy.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.hKo) * 884) / 1076));
        this.hKC.addHeaderView(this.hKx);
        this.hKC.addOnScrollListener(this.hKT);
        this.hKC.setOnSrollToBottomListener(this.gxH);
        this.hKP = this.hKo.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bzs = new View(this.hKo);
        this.bzs.setLayoutParams(new AbsListView.LayoutParams(-1, this.hKP));
        this.bzs.setVisibility(4);
        this.hKC.addFooterView(this.bzs);
        this.hKD = (VoteStatusCard) this.hKx.findViewById(R.id.vote_status_card);
        this.hKE = this.hKx.findViewById(R.id.vote_ueg_tip_container);
        this.hKE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.hKo);
                View inflate = LayoutInflater.from(a.this.hKo.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.hKo.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.hKo.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.bb(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.hKo.getPageContext());
                ap.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.bmC();
            }
        });
        this.hKF = (TextView) this.hKx.findViewById(R.id.vote_ueg_tip_tv);
        this.hKG = (TextView) this.hKx.findViewById(R.id.vote_ueg_tip_img);
        this.hKD.setOnRefreshListener(this.hKS);
        this.hKI = this.hKx.findViewById(R.id.bar_select_rule_bg);
        this.hKJ = (TextView) this.hKx.findViewById(R.id.bar_select_rule_main_title);
        this.hKK = (SelectRuleView) this.hKx.findViewById(R.id.bar_select_rule_container);
        this.hKK.setType(1);
        this.hKH = (VoteCandidateCard) this.hKx.findViewById(R.id.vote_for_mine);
        this.hKL = (SearchView) this.hKx.findViewById(R.id.vote_search_view);
        this.hKL.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.hKo, a.this.hKo.fid + "")));
            }
        });
        this.hKN = (FloatMyRecordCard) this.byI.findViewById(R.id.float_my_record_card);
        this.hKO = (TextView) this.hKx.findViewById(R.id.vote_tip);
        this.gdy = new PbListView(this.hKo);
        this.gdy.getView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.gdy.setHeight(l.getDimens(this.hKo, R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.bpT();
        this.gdx = (NoNetworkView) this.byI.findViewById(R.id.no_network_view);
    }

    public void cks() {
        if (this.status == com.baidu.tieba.barselect.a.d.hOx) {
            this.gdy.showEmptyView(l.getDimens(this.hKo, R.dimen.tbds152));
        }
        this.gdy.setOnClickListener(this.hKo);
        this.hKC.setNextPage(this.gdy);
        if (this.hasMore) {
            this.gdy.showEndLoadData();
            return;
        }
        this.gdy.setText(this.hKo.getResources().getString(R.string.list_has_no_more));
        this.gdy.endLoadData();
    }

    public View getRootView() {
        return this.byI;
    }

    public BdRecyclerView getListView() {
        return this.hKC;
    }

    public PbListView ckt() {
        return this.gdy;
    }

    public void f(View.OnClickListener onClickListener) {
        this.epw = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void IC(String str) {
        if (this.gfk != null) {
            this.gfk.dettachView(this.mListContainer);
            this.gfk = null;
        }
        this.hKo.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hKo, this.hKQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.Cd(str), null);
            this.mNoDataView.setOnClickListener(this.epw);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.Cd(str));
        this.mNoDataView.onChangeSkinType(this.hKo.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bMA() {
        if (this.hKC != null) {
            this.hKC.setVisibility(8);
        }
        this.hKo.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gfk == null) {
            this.gfk = new h(this.hKo, this.hKR);
        }
        this.gfk.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gfk.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gfk.attachView(this.mListContainer, true);
        this.gfk.showRefreshButton();
        this.gfk.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.ajq != i) {
            this.ajq = i;
            if (this.gfk != null) {
                this.gfk.onChangeSkinType();
            }
            ap.setBackgroundColor(this.byI, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hKC, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.hKw > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.hKB, R.color.cp_cont_b, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.hKw <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.ckL() == null || this.mVoteData.ckL().getStatus() > 2 || this.mVoteData.ckL().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.hKB, R.color.cp_cont_b, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.hKB, R.color.cp_cont_a, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                ap.setBackgroundResource(this.hKA, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.hKy, R.drawable.pic_bg_recruit, i);
            this.hKD.uu(i);
            this.hKH.uu(i);
            this.hKL.uu(i);
            ap.setBackgroundResource(this.hKI, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hKJ, R.color.cp_cont_b);
            if (this.hKK != null) {
                this.hKK.rM(i);
            }
            ap.setViewTextColor(this.hKO, R.color.cp_cont_d, 1, i);
            ap.setViewTextColor(this.hKF, R.color.cp_cont_c, 1, i);
            ap.setBackgroundResource(this.hKG, R.drawable.icon_common_explain12_gray66, i);
            this.hKN.uu(i);
            if (this.gdy != null) {
                this.gdy.setTextColor(ap.getColor(i, R.color.cp_cont_j));
                this.gdy.changeSkin(i);
            }
            this.gdx.onChangeSkinType(this.hKo.getPageContext(), i);
            if (this.hKM != null) {
                this.hKM.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.hKD != null) {
            this.hKD.onDestroy();
        }
    }
}
