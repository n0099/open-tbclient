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
    private RelativeLayout bET;
    private View bFD;
    private LinearLayoutManager eeV;
    private View.OnClickListener evp;
    private NoNetworkView gjn;
    private PbListView gjo;
    private h gkZ;
    private VoteStatusCard hQA;
    private View hQB;
    private TextView hQC;
    private TextView hQD;
    private VoteCandidateCard hQE;
    private View hQF;
    private TextView hQG;
    private SelectRuleView hQH;
    private SearchView hQI;
    private d hQJ;
    private FloatMyRecordCard hQK;
    private TextView hQL;
    private int hQM;
    private ViewGroup hQN;
    private BarVoteActivity hQl;
    private int hQr;
    private ViewGroup hQu;
    private TbImageView hQv;
    private View hQw;
    private View hQx;
    private TextView hQy;
    private BdRecyclerView hQz;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ajq = 3;
    private int status = -1;
    private int hQs = 0;
    private float hQt = 0.0f;
    private View.OnClickListener hQO = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gkZ != null) {
                    a.this.gkZ.dettachView(a.this.mListContainer);
                    a.this.gkZ = null;
                }
                a.this.hQl.reload();
                if (a.this.hQz != null) {
                    a.this.hQz.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a hQP = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.hQl != null) {
                a.this.hQl.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.hQu != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.hQt = Math.abs(a.this.hQu.getTop()) / a.this.hQr;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.hQt);
                a.this.hQx.setAlpha(a.this.hQt);
                if (a.this.hQt > 0.5d) {
                    if (a.this.hQs == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.ajq);
                        ap.setViewTextColor(a.this.hQy, R.color.cp_cont_b, 1, a.this.ajq);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.ajq);
                        a.this.hQs = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.hQt * 2.0f) - 1.0f);
                    a.this.hQy.setAlpha((a.this.hQt * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.hQt * 2.0f) - 1.0f);
                } else if (a.this.hQt <= 0.5d) {
                    if (a.this.hQs == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.ajq);
                        ap.setViewTextColor(a.this.hQy, R.color.cp_cont_a, 1, a.this.ajq);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.ajq);
                        a.this.hQs = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.hQt * 2.0f));
                    a.this.hQy.setAlpha(1.0f - (a.this.hQt * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.hQt * 2.0f));
                }
            }
        }
    };
    private BdListView.e gDv = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hQz != null) {
                a.this.hQz.stopScroll();
            }
            if (a.this.gjo != null && a.this.hQl != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.hUu) {
                        a.this.gjo.showEmptyView(l.getDimens(a.this.hQl, R.dimen.tbds152));
                    }
                    a.this.hQz.setNextPage(a.this.gjo);
                    a.this.gjo.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gjo.showLoading();
                        a.this.hQl.cmL();
                        return;
                    }
                    a.this.gjo.setText(a.this.hQl.getResources().getString(R.string.list_has_no_more));
                    a.this.gjo.endLoadData();
                    return;
                }
                a.this.hQz.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e cnn;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.cnn() != null && (cnn = fVar.cnn()) != null) {
                this.status = cnn.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.hUu) {
                    this.hQI.setVisibility(8);
                    this.hQL.setVisibility(8);
                    this.hQE.setVisibility(8);
                }
                NoticeContent cnk = cnn.cnk();
                if (cnk != null && !TextUtils.isEmpty(cnk.public_notice)) {
                    IS(cnk.public_notice + "占");
                } else {
                    IS(this.hQl.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.hQA.setData(fVar);
            if (this.hQJ != null) {
                this.mVoteData = fVar;
                this.hQJ.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.hUu) {
                this.hQK.setVisibility(0);
                this.hQK.setData(fVar);
                this.hQB.setVisibility(0);
                this.hQF.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.hUt) {
                this.hQE.setData(VoteCandidateCard.hUG, fVar);
                this.hQK.setVisibility(8);
                this.hQB.setVisibility(8);
                this.hQI.setRank(fVar.cnn().cne());
                if (fVar.cno() != null) {
                    ManagerElection cno = fVar.cno();
                    if (!y.isEmpty(cno.vote_condition_pic) || !y.isEmpty(cno.vote_condition_title) || !y.isEmpty(cno.vote_condition)) {
                        this.hQF.setVisibility(0);
                        this.hQH.setData(cno.vote_condition_pic, cno.vote_condition_title, cno.vote_condition);
                    } else {
                        this.hQF.setVisibility(8);
                    }
                } else {
                    this.hQF.setVisibility(8);
                }
            } else {
                this.hQK.setVisibility(8);
                this.hQB.setVisibility(8);
                this.hQF.setVisibility(8);
            }
            cmU();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void IS(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable, 0);
        bVar.aG(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.hQC.setText(spannableString);
    }

    public void uE(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.hQl = barVoteActivity;
        this.bET = (RelativeLayout) LayoutInflater.from(this.hQl.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.hQl.addContentView(this.bET, new FrameLayout.LayoutParams(-1, -1));
        this.hQl.showLoadingView(this.bET, false, l.getDimens(this.hQl, R.dimen.ds400));
        this.mListContainer = this.bET.findViewById(R.id.list_container);
        this.hQN = (ViewGroup) this.bET.findViewById(R.id.no_data_container);
        this.hQw = this.bET.findViewById(R.id.nav_bar_container);
        this.hQx = this.bET.findViewById(R.id.nav_bar_shadow);
        this.hQx.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bET.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hQl.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.hQr = l.getDimens(this.hQl, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hQy = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hQl).findViewById(R.id.right_textview);
        this.hQy.setText(R.string.bar_election_rule);
        this.hQy.setOnClickListener(this.hQl);
        this.hQz = (BdRecyclerView) this.bET.findViewById(R.id.vote_list);
        this.eeV = new LinearLayoutManager(this.hQl);
        this.hQz.setLayoutManager(this.eeV);
        this.hQJ = new d(barVoteActivity.getPageContext());
        this.hQz.setAdapter(this.hQJ);
        this.hQu = (ViewGroup) LayoutInflater.from(this.hQl).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.hQu.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hQv = (TbImageView) this.hQu.findViewById(R.id.head_main_iv);
        this.hQv.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.hQl) * 884) / 1076));
        this.hQz.addHeaderView(this.hQu);
        this.hQz.addOnScrollListener(this.hQQ);
        this.hQz.setOnSrollToBottomListener(this.gDv);
        this.hQM = this.hQl.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bFD = new View(this.hQl);
        this.bFD.setLayoutParams(new AbsListView.LayoutParams(-1, this.hQM));
        this.bFD.setVisibility(4);
        this.hQz.addFooterView(this.bFD);
        this.hQA = (VoteStatusCard) this.hQu.findViewById(R.id.vote_status_card);
        this.hQB = this.hQu.findViewById(R.id.vote_ueg_tip_container);
        this.hQB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.hQl);
                View inflate = LayoutInflater.from(a.this.hQl.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.hQl.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.hQl.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.bf(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.hQl.getPageContext());
                ap.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.bpc();
            }
        });
        this.hQC = (TextView) this.hQu.findViewById(R.id.vote_ueg_tip_tv);
        this.hQD = (TextView) this.hQu.findViewById(R.id.vote_ueg_tip_img);
        this.hQA.setOnRefreshListener(this.hQP);
        this.hQF = this.hQu.findViewById(R.id.bar_select_rule_bg);
        this.hQG = (TextView) this.hQu.findViewById(R.id.bar_select_rule_main_title);
        this.hQH = (SelectRuleView) this.hQu.findViewById(R.id.bar_select_rule_container);
        this.hQH.setType(1);
        this.hQE = (VoteCandidateCard) this.hQu.findViewById(R.id.vote_for_mine);
        this.hQI = (SearchView) this.hQu.findViewById(R.id.vote_search_view);
        this.hQI.v(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.hQl, a.this.hQl.fid + "")));
            }
        });
        this.hQK = (FloatMyRecordCard) this.bET.findViewById(R.id.float_my_record_card);
        this.hQL = (TextView) this.hQu.findViewById(R.id.vote_tip);
        this.gjo = new PbListView(this.hQl);
        this.gjo.getView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.gjo.setHeight(l.getDimens(this.hQl, R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.bst();
        this.gjn = (NoNetworkView) this.bET.findViewById(R.id.no_network_view);
    }

    public void cmU() {
        if (this.status == com.baidu.tieba.barselect.a.d.hUu) {
            this.gjo.showEmptyView(l.getDimens(this.hQl, R.dimen.tbds152));
        }
        this.gjo.setOnClickListener(this.hQl);
        this.hQz.setNextPage(this.gjo);
        if (this.hasMore) {
            this.gjo.showEndLoadData();
            return;
        }
        this.gjo.setText(this.hQl.getResources().getString(R.string.list_has_no_more));
        this.gjo.endLoadData();
    }

    public View getRootView() {
        return this.bET;
    }

    public BdRecyclerView getListView() {
        return this.hQz;
    }

    public PbListView cmV() {
        return this.gjo;
    }

    public void g(View.OnClickListener onClickListener) {
        this.evp = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void IT(String str) {
        if (this.gkZ != null) {
            this.gkZ.dettachView(this.mListContainer);
            this.gkZ = null;
        }
        this.hQl.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hQl, this.hQN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.Cr(str), null);
            this.mNoDataView.setOnClickListener(this.evp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.Cr(str));
        this.mNoDataView.onChangeSkinType(this.hQl.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bPa() {
        if (this.hQz != null) {
            this.hQz.setVisibility(8);
        }
        this.hQl.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gkZ == null) {
            this.gkZ = new h(this.hQl, this.hQO);
        }
        this.gkZ.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gkZ.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gkZ.attachView(this.mListContainer, true);
        this.gkZ.showRefreshButton();
        this.gkZ.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.ajq != i) {
            this.ajq = i;
            if (this.gkZ != null) {
                this.gkZ.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bET, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hQz, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.hQt > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.hQy, R.color.cp_cont_b, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.hQt <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.cnn() == null || this.mVoteData.cnn().getStatus() > 2 || this.mVoteData.cnn().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.hQy, R.color.cp_cont_b, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.hQy, R.color.cp_cont_a, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                ap.setBackgroundResource(this.hQx, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.hQv, R.drawable.pic_bg_recruit, i);
            this.hQA.uE(i);
            this.hQE.uE(i);
            this.hQI.uE(i);
            ap.setBackgroundResource(this.hQF, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hQG, R.color.cp_cont_b);
            if (this.hQH != null) {
                this.hQH.rW(i);
            }
            ap.setViewTextColor(this.hQL, R.color.cp_cont_d, 1, i);
            ap.setViewTextColor(this.hQC, R.color.cp_cont_c, 1, i);
            ap.setBackgroundResource(this.hQD, R.drawable.icon_common_explain12_gray66, i);
            this.hQK.uE(i);
            if (this.gjo != null) {
                this.gjo.setTextColor(ap.getColor(i, R.color.cp_cont_j));
                this.gjo.changeSkin(i);
            }
            this.gjn.onChangeSkinType(this.hQl.getPageContext(), i);
            if (this.hQJ != null) {
                this.hQJ.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.hQA != null) {
            this.hQA.onDestroy();
        }
    }
}
