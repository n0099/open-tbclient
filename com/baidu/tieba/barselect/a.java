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
/* loaded from: classes20.dex */
public class a {
    private RelativeLayout bsG;
    private View btr;
    private LinearLayoutManager dEH;
    private View.OnClickListener dUW;
    private NoNetworkView fHl;
    private PbListView fHm;
    private h fIP;
    private boolean hasMore;
    private BarVoteActivity hiX;
    private int hjd;
    private ViewGroup hjg;
    private TbImageView hjh;
    private View hji;
    private View hjj;
    private TextView hjk;
    private BdRecyclerView hjl;
    private VoteStatusCard hjm;
    private View hjn;
    private TextView hjo;
    private TextView hjp;
    private VoteCandidateCard hjq;
    private View hjr;
    private TextView hjs;
    private SelectRuleView hjt;
    private SearchView hju;
    private d hjv;
    private FloatMyRecordCard hjw;
    private TextView hjx;
    private int hjy;
    private ViewGroup hjz;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int aiX = 3;
    private int status = -1;
    private int hje = 0;
    private float hjf = 0.0f;
    private View.OnClickListener hjA = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.fIP != null) {
                    a.this.fIP.dettachView(a.this.mListContainer);
                    a.this.fIP = null;
                }
                a.this.hiX.reload();
                if (a.this.hjl != null) {
                    a.this.hjl.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a hjB = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.hiX != null) {
                a.this.hiX.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.hjg != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.hjf = Math.abs(a.this.hjg.getTop()) / a.this.hjd;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.hjf);
                a.this.hjj.setAlpha(a.this.hjf);
                if (a.this.hjf > 0.5d) {
                    if (a.this.hje == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.aiX);
                        ap.setViewTextColor(a.this.hjk, R.color.cp_cont_b, 1, a.this.aiX);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.aiX);
                        a.this.hje = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.hjf * 2.0f) - 1.0f);
                    a.this.hjk.setAlpha((a.this.hjf * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.hjf * 2.0f) - 1.0f);
                } else if (a.this.hjf <= 0.5d) {
                    if (a.this.hje == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.aiX);
                        ap.setViewTextColor(a.this.hjk, R.color.cp_cont_a, 1, a.this.aiX);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.aiX);
                        a.this.hje = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.hjf * 2.0f));
                    a.this.hjk.setAlpha(1.0f - (a.this.hjf * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.hjf * 2.0f));
                }
            }
        }
    };
    private BdListView.e gbl = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hjl != null) {
                a.this.hjl.stopScroll();
            }
            if (a.this.fHm != null && a.this.hiX != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.hnh) {
                        a.this.fHm.showEmptyView(l.getDimens(a.this.hiX, R.dimen.tbds152));
                    }
                    a.this.hjl.setNextPage(a.this.fHm);
                    a.this.fHm.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fHm.showLoading();
                        a.this.hiX.cdG();
                        return;
                    }
                    a.this.fHm.setText(a.this.hiX.getResources().getString(R.string.list_has_no_more));
                    a.this.fHm.endLoadData();
                    return;
                }
                a.this.hjl.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e cei;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.cei() != null && (cei = fVar.cei()) != null) {
                this.status = cei.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.hnh) {
                    this.hju.setVisibility(8);
                    this.hjx.setVisibility(8);
                    this.hjq.setVisibility(8);
                }
                NoticeContent cef = cei.cef();
                if (cef != null && !TextUtils.isEmpty(cef.public_notice)) {
                    Hp(cef.public_notice + "占");
                } else {
                    Hp(this.hiX.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.hjm.setData(fVar);
            if (this.hjv != null) {
                this.mVoteData = fVar;
                this.hjv.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.hnh) {
                this.hjw.setVisibility(0);
                this.hjw.setData(fVar);
                this.hjn.setVisibility(0);
                this.hjr.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.hng) {
                this.hjq.setData(VoteCandidateCard.hnt, fVar);
                this.hjw.setVisibility(8);
                this.hjn.setVisibility(8);
                this.hju.setRank(fVar.cei().cdZ());
                if (fVar.cej() != null) {
                    ManagerElection cej = fVar.cej();
                    if (!y.isEmpty(cej.vote_condition_pic) || !y.isEmpty(cej.vote_condition_title) || !y.isEmpty(cej.vote_condition)) {
                        this.hjr.setVisibility(0);
                        this.hjt.setData(cej.vote_condition_pic, cej.vote_condition_title, cej.vote_condition);
                    } else {
                        this.hjr.setVisibility(8);
                    }
                } else {
                    this.hjr.setVisibility(8);
                }
            } else {
                this.hjw.setVisibility(8);
                this.hjn.setVisibility(8);
                this.hjr.setVisibility(8);
            }
            cdP();
            L(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void Hp(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable, 0);
        bVar.aG(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.hjo.setText(spannableString);
    }

    public void tE(int i) {
        L(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.hiX = barVoteActivity;
        this.bsG = (RelativeLayout) LayoutInflater.from(this.hiX.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.hiX.addContentView(this.bsG, new FrameLayout.LayoutParams(-1, -1));
        this.hiX.showLoadingView(this.bsG, false, l.getDimens(this.hiX, R.dimen.ds400));
        this.mListContainer = this.bsG.findViewById(R.id.list_container);
        this.hjz = (ViewGroup) this.bsG.findViewById(R.id.no_data_container);
        this.hji = this.bsG.findViewById(R.id.nav_bar_container);
        this.hjj = this.bsG.findViewById(R.id.nav_bar_shadow);
        this.hjj.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bsG.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hiX.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.hjd = l.getDimens(this.hiX, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hjk = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hiX).findViewById(R.id.right_textview);
        this.hjk.setText(R.string.bar_election_rule);
        this.hjk.setOnClickListener(this.hiX);
        this.hjl = (BdRecyclerView) this.bsG.findViewById(R.id.vote_list);
        this.dEH = new LinearLayoutManager(this.hiX);
        this.hjl.setLayoutManager(this.dEH);
        this.hjv = new d(barVoteActivity.getPageContext());
        this.hjl.setAdapter(this.hjv);
        this.hjg = (ViewGroup) LayoutInflater.from(this.hiX).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.hjg.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hjh = (TbImageView) this.hjg.findViewById(R.id.head_main_iv);
        this.hjh.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.hiX) * 884) / 1076));
        this.hjl.addHeaderView(this.hjg);
        this.hjl.addOnScrollListener(this.hjC);
        this.hjl.setOnSrollToBottomListener(this.gbl);
        this.hjy = this.hiX.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.btr = new View(this.hiX);
        this.btr.setLayoutParams(new AbsListView.LayoutParams(-1, this.hjy));
        this.btr.setVisibility(4);
        this.hjl.addFooterView(this.btr);
        this.hjm = (VoteStatusCard) this.hjg.findViewById(R.id.vote_status_card);
        this.hjn = this.hjg.findViewById(R.id.vote_ueg_tip_container);
        this.hjn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.hiX);
                View inflate = LayoutInflater.from(a.this.hiX.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.hiX.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.hiX.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.aZ(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.hiX.getPageContext());
                ap.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.bia();
            }
        });
        this.hjo = (TextView) this.hjg.findViewById(R.id.vote_ueg_tip_tv);
        this.hjp = (TextView) this.hjg.findViewById(R.id.vote_ueg_tip_img);
        this.hjm.setOnRefreshListener(this.hjB);
        this.hjr = this.hjg.findViewById(R.id.bar_select_rule_bg);
        this.hjs = (TextView) this.hjg.findViewById(R.id.bar_select_rule_main_title);
        this.hjt = (SelectRuleView) this.hjg.findViewById(R.id.bar_select_rule_container);
        this.hjt.setType(1);
        this.hjq = (VoteCandidateCard) this.hjg.findViewById(R.id.vote_for_mine);
        this.hju = (SearchView) this.hjg.findViewById(R.id.vote_search_view);
        this.hju.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.hiX, a.this.hiX.fid + "")));
            }
        });
        this.hjw = (FloatMyRecordCard) this.bsG.findViewById(R.id.float_my_record_card);
        this.hjx = (TextView) this.hjg.findViewById(R.id.vote_tip);
        this.fHm = new PbListView(this.hiX);
        this.fHm.getView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fHm.setHeight(l.getDimens(this.hiX, R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.blq();
        this.fHl = (NoNetworkView) this.bsG.findViewById(R.id.no_network_view);
    }

    public void cdP() {
        if (this.status == com.baidu.tieba.barselect.a.d.hnh) {
            this.fHm.showEmptyView(l.getDimens(this.hiX, R.dimen.tbds152));
        }
        this.fHm.setOnClickListener(this.hiX);
        this.hjl.setNextPage(this.fHm);
        if (this.hasMore) {
            this.fHm.showEndLoadData();
            return;
        }
        this.fHm.setText(this.hiX.getResources().getString(R.string.list_has_no_more));
        this.fHm.endLoadData();
    }

    public View getRootView() {
        return this.bsG;
    }

    public BdRecyclerView getListView() {
        return this.hjl;
    }

    public PbListView cdQ() {
        return this.fHm;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dUW = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Hq(String str) {
        if (this.fIP != null) {
            this.fIP.dettachView(this.mListContainer);
            this.fIP = null;
        }
        this.hiX.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hiX, this.hjz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.AY(str), null);
            this.mNoDataView.setOnClickListener(this.dUW);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.AY(str));
        this.mNoDataView.onChangeSkinType(this.hiX.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bHm() {
        if (this.hjl != null) {
            this.hjl.setVisibility(8);
        }
        this.hiX.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.fIP == null) {
            this.fIP = new h(this.hiX, this.hjA);
        }
        this.fIP.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.fIP.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.fIP.attachView(this.mListContainer, true);
        this.fIP.showRefreshButton();
        this.fIP.onChangeSkinType();
    }

    public void L(int i, boolean z) {
        if (z || this.aiX != i) {
            this.aiX = i;
            if (this.fIP != null) {
                this.fIP.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bsG, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hjl, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.hjf > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.hjk, R.color.cp_cont_b, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.hjf <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.cei() == null || this.mVoteData.cei().getStatus() > 2 || this.mVoteData.cei().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.hjk, R.color.cp_cont_b, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.hjk, R.color.cp_cont_a, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                ap.setBackgroundResource(this.hjj, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.hjh, R.drawable.pic_bg_recruit, i);
            this.hjm.tE(i);
            this.hjq.tE(i);
            this.hju.tE(i);
            ap.setBackgroundResource(this.hjr, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hjs, R.color.cp_cont_b);
            if (this.hjt != null) {
                this.hjt.rd(i);
            }
            ap.setViewTextColor(this.hjx, R.color.cp_cont_d, 1, i);
            ap.setViewTextColor(this.hjo, R.color.cp_cont_c, 1, i);
            ap.setBackgroundResource(this.hjp, R.drawable.icon_common_explain12_gray66, i);
            this.hjw.tE(i);
            if (this.fHm != null) {
                this.fHm.setTextColor(ap.getColor(i, R.color.cp_cont_j));
                this.fHm.changeSkin(i);
            }
            this.fHl.onChangeSkinType(this.hiX.getPageContext(), i);
            if (this.hjv != null) {
                this.hjv.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.hjm != null) {
            this.hjm.onDestroy();
        }
    }
}
