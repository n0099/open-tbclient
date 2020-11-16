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
    private View bDS;
    private RelativeLayout bDi;
    private LinearLayoutManager edo;
    private View.OnClickListener etG;
    private NoNetworkView giU;
    private PbListView giV;
    private h gkG;
    private BarVoteActivity hQL;
    private int hQR;
    private ViewGroup hQU;
    private TbImageView hQV;
    private View hQW;
    private View hQX;
    private TextView hQY;
    private BdRecyclerView hQZ;
    private VoteStatusCard hRa;
    private View hRb;
    private TextView hRc;
    private TextView hRd;
    private VoteCandidateCard hRe;
    private View hRf;
    private TextView hRg;
    private SelectRuleView hRh;
    private SearchView hRi;
    private d hRj;
    private FloatMyRecordCard hRk;
    private TextView hRl;
    private int hRm;
    private ViewGroup hRn;
    private boolean hasMore;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ajv = 3;
    private int status = -1;
    private int hQS = 0;
    private float hQT = 0.0f;
    private View.OnClickListener hRo = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gkG != null) {
                    a.this.gkG.dettachView(a.this.mListContainer);
                    a.this.gkG = null;
                }
                a.this.hQL.reload();
                if (a.this.hQZ != null) {
                    a.this.hQZ.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a hRp = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.hQL != null) {
                a.this.hQL.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.hQU != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.hQT = Math.abs(a.this.hQU.getTop()) / a.this.hQR;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.hQT);
                a.this.hQX.setAlpha(a.this.hQT);
                if (a.this.hQT > 0.5d) {
                    if (a.this.hQS == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.ajv);
                        ap.setViewTextColor(a.this.hQY, R.color.CAM_X0105, 1, a.this.ajv);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, a.this.ajv);
                        a.this.hQS = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.hQT * 2.0f) - 1.0f);
                    a.this.hQY.setAlpha((a.this.hQT * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.hQT * 2.0f) - 1.0f);
                } else if (a.this.hQT <= 0.5d) {
                    if (a.this.hQS == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.ajv);
                        ap.setViewTextColor(a.this.hQY, R.color.CAM_X0101, 1, a.this.ajv);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, a.this.ajv);
                        a.this.hQS = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.hQT * 2.0f));
                    a.this.hQY.setAlpha(1.0f - (a.this.hQT * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.hQT * 2.0f));
                }
            }
        }
    };
    private BdListView.e gDc = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hQZ != null) {
                a.this.hQZ.stopScroll();
            }
            if (a.this.giV != null && a.this.hQL != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.hUU) {
                        a.this.giV.showEmptyView(l.getDimens(a.this.hQL, R.dimen.tbds152));
                    }
                    a.this.hQZ.setNextPage(a.this.giV);
                    a.this.giV.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.giV.showLoading();
                        a.this.hQL.cmn();
                        return;
                    }
                    a.this.giV.setText(a.this.hQL.getResources().getString(R.string.list_has_no_more));
                    a.this.giV.endLoadData();
                    return;
                }
                a.this.hQZ.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e cmP;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.cmP() != null && (cmP = fVar.cmP()) != null) {
                this.status = cmP.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.hUU) {
                    this.hRi.setVisibility(8);
                    this.hRl.setVisibility(8);
                    this.hRe.setVisibility(8);
                }
                NoticeContent cmM = cmP.cmM();
                if (cmM != null && !TextUtils.isEmpty(cmM.public_notice)) {
                    It(cmM.public_notice + "占");
                } else {
                    It(this.hQL.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.hRa.setData(fVar);
            if (this.hRj != null) {
                this.mVoteData = fVar;
                this.hRj.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.hUU) {
                this.hRk.setVisibility(0);
                this.hRk.setData(fVar);
                this.hRb.setVisibility(0);
                this.hRf.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.hUT) {
                this.hRe.setData(VoteCandidateCard.hVg, fVar);
                this.hRk.setVisibility(8);
                this.hRb.setVisibility(8);
                this.hRi.setRank(fVar.cmP().cmG());
                if (fVar.cmQ() != null) {
                    ManagerElection cmQ = fVar.cmQ();
                    if (!y.isEmpty(cmQ.vote_condition_pic) || !y.isEmpty(cmQ.vote_condition_title) || !y.isEmpty(cmQ.vote_condition)) {
                        this.hRf.setVisibility(0);
                        this.hRh.setData(cmQ.vote_condition_pic, cmQ.vote_condition_title, cmQ.vote_condition);
                    } else {
                        this.hRf.setVisibility(8);
                    }
                } else {
                    this.hRf.setVisibility(8);
                }
            } else {
                this.hRk.setVisibility(8);
                this.hRb.setVisibility(8);
                this.hRf.setVisibility(8);
            }
            cmw();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void It(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable, 0);
        bVar.aH(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.hRc.setText(spannableString);
    }

    public void vc(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.hQL = barVoteActivity;
        this.bDi = (RelativeLayout) LayoutInflater.from(this.hQL.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.hQL.addContentView(this.bDi, new FrameLayout.LayoutParams(-1, -1));
        this.hQL.showLoadingView(this.bDi, false, l.getDimens(this.hQL, R.dimen.ds400));
        this.mListContainer = this.bDi.findViewById(R.id.list_container);
        this.hRn = (ViewGroup) this.bDi.findViewById(R.id.no_data_container);
        this.hQW = this.bDi.findViewById(R.id.nav_bar_container);
        this.hQX = this.bDi.findViewById(R.id.nav_bar_shadow);
        this.hQX.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bDi.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hQL.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.hQR = l.getDimens(this.hQL, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hQY = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hQL).findViewById(R.id.right_textview);
        this.hQY.setText(R.string.bar_election_rule);
        this.hQY.setOnClickListener(this.hQL);
        this.hQZ = (BdRecyclerView) this.bDi.findViewById(R.id.vote_list);
        this.edo = new LinearLayoutManager(this.hQL);
        this.hQZ.setLayoutManager(this.edo);
        this.hRj = new d(barVoteActivity.getPageContext());
        this.hQZ.setAdapter(this.hRj);
        this.hQU = (ViewGroup) LayoutInflater.from(this.hQL).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.hQU.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hQV = (TbImageView) this.hQU.findViewById(R.id.head_main_iv);
        this.hQV.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.hQL) * 884) / 1076));
        this.hQZ.addHeaderView(this.hQU);
        this.hQZ.addOnScrollListener(this.hRq);
        this.hQZ.setOnSrollToBottomListener(this.gDc);
        this.hRm = this.hQL.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bDS = new View(this.hQL);
        this.bDS.setLayoutParams(new AbsListView.LayoutParams(-1, this.hRm));
        this.bDS.setVisibility(4);
        this.hQZ.addFooterView(this.bDS);
        this.hRa = (VoteStatusCard) this.hQU.findViewById(R.id.vote_status_card);
        this.hRb = this.hQU.findViewById(R.id.vote_ueg_tip_container);
        this.hRb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.hQL);
                View inflate = LayoutInflater.from(a.this.hQL.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.hQL.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.hQL.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.bg(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.hQL.getPageContext());
                ap.c(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.bog();
            }
        });
        this.hRc = (TextView) this.hQU.findViewById(R.id.vote_ueg_tip_tv);
        this.hRd = (TextView) this.hQU.findViewById(R.id.vote_ueg_tip_img);
        this.hRa.setOnRefreshListener(this.hRp);
        this.hRf = this.hQU.findViewById(R.id.bar_select_rule_bg);
        this.hRg = (TextView) this.hQU.findViewById(R.id.bar_select_rule_main_title);
        this.hRh = (SelectRuleView) this.hQU.findViewById(R.id.bar_select_rule_container);
        this.hRh.setType(1);
        this.hRe = (VoteCandidateCard) this.hQU.findViewById(R.id.vote_for_mine);
        this.hRi = (SearchView) this.hQU.findViewById(R.id.vote_search_view);
        this.hRi.v(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.hQL, a.this.hQL.fid + "")));
            }
        });
        this.hRk = (FloatMyRecordCard) this.bDi.findViewById(R.id.float_my_record_card);
        this.hRl = (TextView) this.hQU.findViewById(R.id.vote_tip);
        this.giV = new PbListView(this.hQL);
        this.giV.getView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.giV.setHeight(l.getDimens(this.hQL, R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.brI();
        this.giU = (NoNetworkView) this.bDi.findViewById(R.id.no_network_view);
    }

    public void cmw() {
        if (this.status == com.baidu.tieba.barselect.a.d.hUU) {
            this.giV.showEmptyView(l.getDimens(this.hQL, R.dimen.tbds152));
        }
        this.giV.setOnClickListener(this.hQL);
        this.hQZ.setNextPage(this.giV);
        if (this.hasMore) {
            this.giV.showEndLoadData();
            return;
        }
        this.giV.setText(this.hQL.getResources().getString(R.string.list_has_no_more));
        this.giV.endLoadData();
    }

    public View getRootView() {
        return this.bDi;
    }

    public BdRecyclerView getListView() {
        return this.hQZ;
    }

    public PbListView cmx() {
        return this.giV;
    }

    public void g(View.OnClickListener onClickListener) {
        this.etG = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Iu(String str) {
        if (this.gkG != null) {
            this.gkG.dettachView(this.mListContainer);
            this.gkG = null;
        }
        this.hQL.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hQL, this.hRn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.BQ(str), null);
            this.mNoDataView.setOnClickListener(this.etG);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.BQ(str));
        this.mNoDataView.onChangeSkinType(this.hQL.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bOt() {
        if (this.hQZ != null) {
            this.hQZ.setVisibility(8);
        }
        this.hQL.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gkG == null) {
            this.gkG = new h(this.hQL, this.hRo);
        }
        this.gkG.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gkG.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gkG.attachView(this.mListContainer, true);
        this.gkG.showRefreshButton();
        this.gkG.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.ajv != i) {
            this.ajv = i;
            if (this.gkG != null) {
                this.gkG.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bDi, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.hQZ, R.color.CAM_X0204, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
                if (this.hQT > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.hQY, R.color.CAM_X0105, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (this.hQT <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.cmP() == null || this.mVoteData.cmP().getStatus() > 2 || this.mVoteData.cmP().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.hQY, R.color.CAM_X0105, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.hQY, R.color.CAM_X0101, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, i);
                    }
                }
                ap.setBackgroundResource(this.hQX, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.hQV, R.drawable.pic_bg_recruit, i);
            this.hRa.vc(i);
            this.hRe.vc(i);
            this.hRi.vc(i);
            ap.setBackgroundResource(this.hRf, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hRg, R.color.CAM_X0105);
            if (this.hRh != null) {
                this.hRh.su(i);
            }
            ap.setViewTextColor(this.hRl, R.color.CAM_X0109, 1, i);
            ap.setViewTextColor(this.hRc, R.color.CAM_X0108, 1, i);
            ap.setBackgroundResource(this.hRd, R.drawable.icon_common_explain12_gray66, i);
            this.hRk.vc(i);
            if (this.giV != null) {
                this.giV.setTextColor(ap.getColor(i, R.color.CAM_X0107));
                this.giV.changeSkin(i);
            }
            this.giU.onChangeSkinType(this.hQL.getPageContext(), i);
            if (this.hRj != null) {
                this.hRj.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.hRa != null) {
            this.hRa.onDestroy();
        }
    }
}
