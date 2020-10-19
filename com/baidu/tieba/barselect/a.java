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
    private RelativeLayout bwu;
    private View bxe;
    private LinearLayoutManager dQI;
    private View.OnClickListener egY;
    private NoNetworkView fTu;
    private PbListView fTv;
    private h fVg;
    private boolean hasMore;
    private BarVoteActivity hxS;
    private int hxY;
    private ViewGroup hyb;
    private TbImageView hyc;
    private View hyd;
    private View hye;
    private TextView hyf;
    private BdRecyclerView hyg;
    private VoteStatusCard hyh;
    private View hyi;
    private TextView hyj;
    private TextView hyk;
    private VoteCandidateCard hyl;
    private View hym;
    private TextView hyn;
    private SelectRuleView hyo;
    private SearchView hyp;
    private d hyq;
    private FloatMyRecordCard hyr;
    private TextView hys;
    private int hyt;
    private ViewGroup hyu;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ajp = 3;
    private int status = -1;
    private int hxZ = 0;
    private float hya = 0.0f;
    private View.OnClickListener hyv = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.fVg != null) {
                    a.this.fVg.dettachView(a.this.mListContainer);
                    a.this.fVg = null;
                }
                a.this.hxS.reload();
                if (a.this.hyg != null) {
                    a.this.hyg.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a hyw = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.hxS != null) {
                a.this.hxS.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.hyb != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.hya = Math.abs(a.this.hyb.getTop()) / a.this.hxY;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.hya);
                a.this.hye.setAlpha(a.this.hya);
                if (a.this.hya > 0.5d) {
                    if (a.this.hxZ == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.ajp);
                        ap.setViewTextColor(a.this.hyf, R.color.cp_cont_b, 1, a.this.ajp);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, a.this.ajp);
                        a.this.hxZ = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.hya * 2.0f) - 1.0f);
                    a.this.hyf.setAlpha((a.this.hya * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.hya * 2.0f) - 1.0f);
                } else if (a.this.hya <= 0.5d) {
                    if (a.this.hxZ == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.ajp);
                        ap.setViewTextColor(a.this.hyf, R.color.cp_cont_a, 1, a.this.ajp);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, a.this.ajp);
                        a.this.hxZ = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.hya * 2.0f));
                    a.this.hyf.setAlpha(1.0f - (a.this.hya * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.hya * 2.0f));
                }
            }
        }
    };
    private BdListView.e gnC = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hyg != null) {
                a.this.hyg.stopScroll();
            }
            if (a.this.fTv != null && a.this.hxS != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.hCb) {
                        a.this.fTv.showEmptyView(l.getDimens(a.this.hxS, R.dimen.tbds152));
                    }
                    a.this.hyg.setNextPage(a.this.fTv);
                    a.this.fTv.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fTv.showLoading();
                        a.this.hxS.chc();
                        return;
                    }
                    a.this.fTv.setText(a.this.hxS.getResources().getString(R.string.list_has_no_more));
                    a.this.fTv.endLoadData();
                    return;
                }
                a.this.hyg.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e chE;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.chE() != null && (chE = fVar.chE()) != null) {
                this.status = chE.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.hCb) {
                    this.hyp.setVisibility(8);
                    this.hys.setVisibility(8);
                    this.hyl.setVisibility(8);
                }
                NoticeContent chB = chE.chB();
                if (chB != null && !TextUtils.isEmpty(chB.public_notice)) {
                    Ic(chB.public_notice + "占");
                } else {
                    Ic(this.hxS.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.hyh.setData(fVar);
            if (this.hyq != null) {
                this.mVoteData = fVar;
                this.hyq.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.hCb) {
                this.hyr.setVisibility(0);
                this.hyr.setData(fVar);
                this.hyi.setVisibility(0);
                this.hym.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.hCa) {
                this.hyl.setData(VoteCandidateCard.hCn, fVar);
                this.hyr.setVisibility(8);
                this.hyi.setVisibility(8);
                this.hyp.setRank(fVar.chE().chv());
                if (fVar.chF() != null) {
                    ManagerElection chF = fVar.chF();
                    if (!y.isEmpty(chF.vote_condition_pic) || !y.isEmpty(chF.vote_condition_title) || !y.isEmpty(chF.vote_condition)) {
                        this.hym.setVisibility(0);
                        this.hyo.setData(chF.vote_condition_pic, chF.vote_condition_title, chF.vote_condition);
                    } else {
                        this.hym.setVisibility(8);
                    }
                } else {
                    this.hym.setVisibility(8);
                }
            } else {
                this.hyr.setVisibility(8);
                this.hyi.setVisibility(8);
                this.hym.setVisibility(8);
            }
            chl();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void Ic(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable, 0);
        bVar.aG(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.hyj.setText(spannableString);
    }

    public void uc(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.hxS = barVoteActivity;
        this.bwu = (RelativeLayout) LayoutInflater.from(this.hxS.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.hxS.addContentView(this.bwu, new FrameLayout.LayoutParams(-1, -1));
        this.hxS.showLoadingView(this.bwu, false, l.getDimens(this.hxS, R.dimen.ds400));
        this.mListContainer = this.bwu.findViewById(R.id.list_container);
        this.hyu = (ViewGroup) this.bwu.findViewById(R.id.no_data_container);
        this.hyd = this.bwu.findViewById(R.id.nav_bar_container);
        this.hye = this.bwu.findViewById(R.id.nav_bar_shadow);
        this.hye.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bwu.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hxS.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.hxY = l.getDimens(this.hxS, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hyf = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hxS).findViewById(R.id.right_textview);
        this.hyf.setText(R.string.bar_election_rule);
        this.hyf.setOnClickListener(this.hxS);
        this.hyg = (BdRecyclerView) this.bwu.findViewById(R.id.vote_list);
        this.dQI = new LinearLayoutManager(this.hxS);
        this.hyg.setLayoutManager(this.dQI);
        this.hyq = new d(barVoteActivity.getPageContext());
        this.hyg.setAdapter(this.hyq);
        this.hyb = (ViewGroup) LayoutInflater.from(this.hxS).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.hyb.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hyc = (TbImageView) this.hyb.findViewById(R.id.head_main_iv);
        this.hyc.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.hxS) * 884) / 1076));
        this.hyg.addHeaderView(this.hyb);
        this.hyg.addOnScrollListener(this.hyx);
        this.hyg.setOnSrollToBottomListener(this.gnC);
        this.hyt = this.hxS.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bxe = new View(this.hxS);
        this.bxe.setLayoutParams(new AbsListView.LayoutParams(-1, this.hyt));
        this.bxe.setVisibility(4);
        this.hyg.addFooterView(this.bxe);
        this.hyh = (VoteStatusCard) this.hyb.findViewById(R.id.vote_status_card);
        this.hyi = this.hyb.findViewById(R.id.vote_ueg_tip_container);
        this.hyi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.hxS);
                View inflate = LayoutInflater.from(a.this.hxS.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.hxS.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.hxS.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
                aVar.ba(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.hxS.getPageContext());
                ap.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.cp_bg_line_d, R.color.cp_bg_line_d);
                aVar.bkJ();
            }
        });
        this.hyj = (TextView) this.hyb.findViewById(R.id.vote_ueg_tip_tv);
        this.hyk = (TextView) this.hyb.findViewById(R.id.vote_ueg_tip_img);
        this.hyh.setOnRefreshListener(this.hyw);
        this.hym = this.hyb.findViewById(R.id.bar_select_rule_bg);
        this.hyn = (TextView) this.hyb.findViewById(R.id.bar_select_rule_main_title);
        this.hyo = (SelectRuleView) this.hyb.findViewById(R.id.bar_select_rule_container);
        this.hyo.setType(1);
        this.hyl = (VoteCandidateCard) this.hyb.findViewById(R.id.vote_for_mine);
        this.hyp = (SearchView) this.hyb.findViewById(R.id.vote_search_view);
        this.hyp.u(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.hxS, a.this.hxS.fid + "")));
            }
        });
        this.hyr = (FloatMyRecordCard) this.bwu.findViewById(R.id.float_my_record_card);
        this.hys = (TextView) this.hyb.findViewById(R.id.vote_tip);
        this.fTv = new PbListView(this.hxS);
        this.fTv.getView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fTv.setHeight(l.getDimens(this.hxS, R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.boa();
        this.fTu = (NoNetworkView) this.bwu.findViewById(R.id.no_network_view);
    }

    public void chl() {
        if (this.status == com.baidu.tieba.barselect.a.d.hCb) {
            this.fTv.showEmptyView(l.getDimens(this.hxS, R.dimen.tbds152));
        }
        this.fTv.setOnClickListener(this.hxS);
        this.hyg.setNextPage(this.fTv);
        if (this.hasMore) {
            this.fTv.showEndLoadData();
            return;
        }
        this.fTv.setText(this.hxS.getResources().getString(R.string.list_has_no_more));
        this.fTv.endLoadData();
    }

    public View getRootView() {
        return this.bwu;
    }

    public BdRecyclerView getListView() {
        return this.hyg;
    }

    public PbListView chm() {
        return this.fTv;
    }

    public void f(View.OnClickListener onClickListener) {
        this.egY = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Id(String str) {
        if (this.fVg != null) {
            this.fVg.dettachView(this.mListContainer);
            this.fVg = null;
        }
        this.hxS.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hxS, this.hyu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.BK(str), null);
            this.mNoDataView.setOnClickListener(this.egY);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.BK(str));
        this.mNoDataView.onChangeSkinType(this.hxS.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bJY() {
        if (this.hyg != null) {
            this.hyg.setVisibility(8);
        }
        this.hxS.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.fVg == null) {
            this.fVg = new h(this.hxS, this.hyv);
        }
        this.fVg.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.fVg.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.fVg.attachView(this.mListContainer, true);
        this.fVg.showRefreshButton();
        this.fVg.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.ajp != i) {
            this.ajp = i;
            if (this.fVg != null) {
                this.fVg.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bwu, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hyg, R.color.cp_bg_line_c, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
                if (this.hya > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.hyf, R.color.cp_cont_b, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                } else if (this.hya <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.chE() == null || this.mVoteData.chE().getStatus() > 2 || this.mVoteData.chE().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.hyf, R.color.cp_cont_b, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.hyf, R.color.cp_cont_a, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a, 1, i);
                    }
                }
                ap.setBackgroundResource(this.hye, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.hyc, R.drawable.pic_bg_recruit, i);
            this.hyh.uc(i);
            this.hyl.uc(i);
            this.hyp.uc(i);
            ap.setBackgroundResource(this.hym, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hyn, R.color.cp_cont_b);
            if (this.hyo != null) {
                this.hyo.rB(i);
            }
            ap.setViewTextColor(this.hys, R.color.cp_cont_d, 1, i);
            ap.setViewTextColor(this.hyj, R.color.cp_cont_c, 1, i);
            ap.setBackgroundResource(this.hyk, R.drawable.icon_common_explain12_gray66, i);
            this.hyr.uc(i);
            if (this.fTv != null) {
                this.fTv.setTextColor(ap.getColor(i, R.color.cp_cont_j));
                this.fTv.changeSkin(i);
            }
            this.fTu.onChangeSkinType(this.hxS.getPageContext(), i);
            if (this.hyq != null) {
                this.hyq.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.hyh != null) {
            this.hyh.onDestroy();
        }
    }
}
