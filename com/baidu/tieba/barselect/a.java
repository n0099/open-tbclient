package com.baidu.tieba.barselect;

import android.graphics.drawable.Drawable;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.b;
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
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
import tbclient.ElectionInfo.NoticeContent;
import tbclient.ManagerElection;
/* loaded from: classes7.dex */
public class a {
    private RelativeLayout bND;
    private View bOm;
    private View.OnClickListener eJh;
    private LinearLayoutManager eso;
    private NoNetworkView gCe;
    private PbListView gCf;
    private h gDQ;
    private boolean hasMore;
    private SearchView irA;
    private VoteAdapter irB;
    private FloatMyRecordCard irC;
    private TextView irD;
    private int irE;
    private ViewGroup irF;
    private BarVoteActivity ird;
    private int irj;
    private ViewGroup irm;
    private TbImageView irn;
    private View iro;
    private View irp;
    private TextView irq;
    private BdRecyclerView irr;
    private VoteStatusCard irs;
    private View irt;
    private TextView iru;
    private TextView irv;
    private VoteCandidateCard irw;
    private View irx;
    private TextView iry;
    private SelectRuleView irz;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int aln = 3;
    private int status = -1;
    private int irk = 0;
    private float irl = 0.0f;
    private View.OnClickListener irG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gDQ != null) {
                    a.this.gDQ.dettachView(a.this.mListContainer);
                    a.this.gDQ = null;
                }
                a.this.ird.reload();
                if (a.this.irr != null) {
                    a.this.irr.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a irH = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ird != null) {
                a.this.ird.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener irI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.irm != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.irl = Math.abs(a.this.irm.getTop()) / a.this.irj;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.irl);
                a.this.irp.setAlpha(a.this.irl);
                if (a.this.irl > 0.5d) {
                    if (a.this.irk == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.aln);
                        ap.setViewTextColor(a.this.irq, R.color.CAM_X0105, 1, a.this.aln);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, a.this.aln);
                        a.this.irk = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.irl * 2.0f) - 1.0f);
                    a.this.irq.setAlpha((a.this.irl * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.irl * 2.0f) - 1.0f);
                } else if (a.this.irl <= 0.5d) {
                    if (a.this.irk == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.aln);
                        ap.setViewTextColor(a.this.irq, R.color.CAM_X0101, 1, a.this.aln);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, a.this.aln);
                        a.this.irk = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.irl * 2.0f));
                    a.this.irq.setAlpha(1.0f - (a.this.irl * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.irl * 2.0f));
                }
            }
        }
    };
    private BdListView.e gXO = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.irr != null) {
                a.this.irr.stopScroll();
            }
            if (a.this.gCf != null && a.this.ird != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == d.ivi) {
                        a.this.gCf.showEmptyView(l.getDimens(a.this.ird, R.dimen.tbds152));
                    }
                    a.this.irr.setNextPage(a.this.gCf);
                    a.this.gCf.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gCf.showLoading();
                        a.this.ird.cra();
                        return;
                    }
                    a.this.gCf.setText(a.this.ird.getResources().getString(R.string.list_has_no_more));
                    a.this.gCf.endLoadData();
                    return;
                }
                a.this.irr.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        e crC;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.crC() != null && (crC = fVar.crC()) != null) {
                this.status = crC.getStatus();
                if (this.status == d.ivi) {
                    this.irA.setVisibility(8);
                    this.irD.setVisibility(8);
                    this.irw.setVisibility(8);
                }
                NoticeContent crz = crC.crz();
                if (crz != null && !TextUtils.isEmpty(crz.public_notice)) {
                    IP(crz.public_notice + "占");
                } else {
                    IP(this.ird.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.irs.setData(fVar);
            if (this.irB != null) {
                this.mVoteData = fVar;
                this.irB.a(fVar);
            }
            if (this.status == d.ivi) {
                this.irC.setVisibility(0);
                this.irC.setData(fVar);
                this.irt.setVisibility(0);
                this.irx.setVisibility(8);
            } else if (this.status == d.ivh) {
                this.irw.setData(VoteCandidateCard.ivu, fVar);
                this.irC.setVisibility(8);
                this.irt.setVisibility(8);
                this.irA.setRank(fVar.crC().crt());
                if (fVar.crD() != null) {
                    ManagerElection crD = fVar.crD();
                    if (!y.isEmpty(crD.vote_condition_pic) || !y.isEmpty(crD.vote_condition_title) || !y.isEmpty(crD.vote_condition)) {
                        this.irx.setVisibility(0);
                        this.irz.setData(crD.vote_condition_pic, crD.vote_condition_title, crD.vote_condition);
                    } else {
                        this.irx.setVisibility(8);
                    }
                } else {
                    this.irx.setVisibility(8);
                }
            } else {
                this.irC.setVisibility(8);
                this.irt.setVisibility(8);
                this.irx.setVisibility(8);
            }
            crj();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void IP(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        b bVar = new b(drawable, 0);
        bVar.aM(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.iru.setText(spannableString);
    }

    public void uw(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ird = barVoteActivity;
        this.bND = (RelativeLayout) LayoutInflater.from(this.ird.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ird.addContentView(this.bND, new FrameLayout.LayoutParams(-1, -1));
        this.ird.showLoadingView(this.bND, false, l.getDimens(this.ird, R.dimen.ds400));
        this.mListContainer = this.bND.findViewById(R.id.list_container);
        this.irF = (ViewGroup) this.bND.findViewById(R.id.no_data_container);
        this.iro = this.bND.findViewById(R.id.nav_bar_container);
        this.irp = this.bND.findViewById(R.id.nav_bar_shadow);
        this.irp.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bND.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ird.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.irj = l.getDimens(this.ird, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.irq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ird).findViewById(R.id.right_textview);
        this.irq.setText(R.string.bar_election_rule);
        this.irq.setOnClickListener(this.ird);
        this.irr = (BdRecyclerView) this.bND.findViewById(R.id.vote_list);
        this.eso = new LinearLayoutManager(this.ird);
        this.irr.setLayoutManager(this.eso);
        this.irB = new VoteAdapter(barVoteActivity.getPageContext());
        this.irr.setAdapter(this.irB);
        this.irm = (ViewGroup) LayoutInflater.from(this.ird).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.irm.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.irn = (TbImageView) this.irm.findViewById(R.id.head_main_iv);
        this.irn.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ird) * 884) / 1076));
        this.irr.addHeaderView(this.irm);
        this.irr.addOnScrollListener(this.irI);
        this.irr.setOnSrollToBottomListener(this.gXO);
        this.irE = this.ird.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bOm = new View(this.ird);
        this.bOm.setLayoutParams(new AbsListView.LayoutParams(-1, this.irE));
        this.bOm.setVisibility(4);
        this.irr.addFooterView(this.bOm);
        this.irs = (VoteStatusCard) this.irm.findViewById(R.id.vote_status_card);
        this.irt = this.irm.findViewById(R.id.vote_ueg_tip_container);
        this.irt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ird);
                View inflate = LayoutInflater.from(a.this.ird.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ird.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ird.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.bn(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ird.getPageContext());
                ap.d(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.bqz();
            }
        });
        this.iru = (TextView) this.irm.findViewById(R.id.vote_ueg_tip_tv);
        this.irv = (TextView) this.irm.findViewById(R.id.vote_ueg_tip_img);
        this.irs.setOnRefreshListener(this.irH);
        this.irx = this.irm.findViewById(R.id.bar_select_rule_bg);
        this.iry = (TextView) this.irm.findViewById(R.id.bar_select_rule_main_title);
        this.irz = (SelectRuleView) this.irm.findViewById(R.id.bar_select_rule_container);
        this.irz.setType(1);
        this.irw = (VoteCandidateCard) this.irm.findViewById(R.id.vote_for_mine);
        this.irA = (SearchView) this.irm.findViewById(R.id.vote_search_view);
        this.irA.w(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ird, a.this.ird.fid + "")));
            }
        });
        this.irC = (FloatMyRecordCard) this.bND.findViewById(R.id.float_my_record_card);
        this.irD = (TextView) this.irm.findViewById(R.id.vote_tip);
        this.gCf = new PbListView(this.ird);
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setHeight(l.getDimens(this.ird, R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bug();
        this.gCe = (NoNetworkView) this.bND.findViewById(R.id.no_network_view);
    }

    public void crj() {
        if (this.status == d.ivi) {
            this.gCf.showEmptyView(l.getDimens(this.ird, R.dimen.tbds152));
        }
        this.gCf.setOnClickListener(this.ird);
        this.irr.setNextPage(this.gCf);
        if (this.hasMore) {
            this.gCf.showEndLoadData();
            return;
        }
        this.gCf.setText(this.ird.getResources().getString(R.string.list_has_no_more));
        this.gCf.endLoadData();
    }

    public View getRootView() {
        return this.bND;
    }

    public BdRecyclerView getListView() {
        return this.irr;
    }

    public PbListView crk() {
        return this.gCf;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eJh = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void IQ(String str) {
        if (this.gDQ != null) {
            this.gDQ.dettachView(this.mListContainer);
            this.gDQ = null;
        }
        this.ird.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ird, this.irF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.BI(str), null);
            this.mNoDataView.setOnClickListener(this.eJh);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.BI(str));
        this.mNoDataView.onChangeSkinType(this.ird.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bRH() {
        if (this.irr != null) {
            this.irr.setVisibility(8);
        }
        this.ird.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gDQ == null) {
            this.gDQ = new h(this.ird, this.irG);
        }
        this.gDQ.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gDQ.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gDQ.attachView(this.mListContainer, true);
        this.gDQ.showRefreshButton();
        this.gDQ.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.aln != i) {
            this.aln = i;
            if (this.gDQ != null) {
                this.gDQ.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bND, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.irr, R.color.CAM_X0204, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
                if (this.irl > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.irq, R.color.CAM_X0105, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (this.irl <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.crC() == null || this.mVoteData.crC().getStatus() > 2 || this.mVoteData.crC().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.irq, R.color.CAM_X0105, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.irq, R.color.CAM_X0101, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, i);
                    }
                }
                ap.setBackgroundResource(this.irp, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.irn, R.drawable.pic_bg_recruit, i);
            this.irs.uw(i);
            this.irw.uw(i);
            this.irA.uw(i);
            ap.setBackgroundResource(this.irx, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.iry, R.color.CAM_X0105);
            if (this.irz != null) {
                this.irz.rJ(i);
            }
            ap.setViewTextColor(this.irD, R.color.CAM_X0109, 1, i);
            ap.setViewTextColor(this.iru, R.color.CAM_X0108, 1, i);
            ap.setBackgroundResource(this.irv, R.drawable.icon_common_explain12_gray66, i);
            this.irC.uw(i);
            if (this.gCf != null) {
                this.gCf.setTextColor(ap.getColor(i, R.color.CAM_X0107));
                this.gCf.changeSkin(i);
            }
            this.gCe.onChangeSkinType(this.ird.getPageContext(), i);
            if (this.irB != null) {
                this.irB.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.irs != null) {
            this.irs.onDestroy();
        }
    }
}
