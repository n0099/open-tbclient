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
import com.baidu.tbadk.l.h;
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
    private RelativeLayout bIq;
    private View bJa;
    private View.OnClickListener eAI;
    private LinearLayoutManager ekp;
    private NoNetworkView grf;
    private PbListView grg;
    private h gsR;
    private boolean hasMore;
    private BarVoteActivity ibH;
    private int ibN;
    private ViewGroup ibQ;
    private TbImageView ibR;
    private View ibS;
    private View ibT;
    private TextView ibU;
    private BdRecyclerView ibV;
    private VoteStatusCard ibW;
    private View ibX;
    private TextView ibY;
    private TextView ibZ;
    private VoteCandidateCard ica;
    private View icb;
    private TextView icc;
    private SelectRuleView icd;
    private SearchView ice;
    private d icf;
    private FloatMyRecordCard icg;
    private TextView ich;
    private int ici;
    private ViewGroup icj;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int aku = 3;
    private int status = -1;
    private int ibO = 0;
    private float ibP = 0.0f;
    private View.OnClickListener ick = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gsR != null) {
                    a.this.gsR.dettachView(a.this.mListContainer);
                    a.this.gsR = null;
                }
                a.this.ibH.reload();
                if (a.this.ibV != null) {
                    a.this.ibV.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a icl = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ibH != null) {
                a.this.ibH.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener icm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ibQ != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.ibP = Math.abs(a.this.ibQ.getTop()) / a.this.ibN;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.ibP);
                a.this.ibT.setAlpha(a.this.ibP);
                if (a.this.ibP > 0.5d) {
                    if (a.this.ibO == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.aku);
                        ap.setViewTextColor(a.this.ibU, R.color.CAM_X0105, 1, a.this.aku);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, a.this.aku);
                        a.this.ibO = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.ibP * 2.0f) - 1.0f);
                    a.this.ibU.setAlpha((a.this.ibP * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.ibP * 2.0f) - 1.0f);
                } else if (a.this.ibP <= 0.5d) {
                    if (a.this.ibO == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.aku);
                        ap.setViewTextColor(a.this.ibU, R.color.CAM_X0101, 1, a.this.aku);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, a.this.aku);
                        a.this.ibO = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.ibP * 2.0f));
                    a.this.ibU.setAlpha(1.0f - (a.this.ibP * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.ibP * 2.0f));
                }
            }
        }
    };
    private BdListView.e gMb = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ibV != null) {
                a.this.ibV.stopScroll();
            }
            if (a.this.grg != null && a.this.ibH != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.ifT) {
                        a.this.grg.showEmptyView(l.getDimens(a.this.ibH, R.dimen.tbds152));
                    }
                    a.this.ibV.setNextPage(a.this.grg);
                    a.this.grg.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.grg.showLoading();
                        a.this.ibH.cqB();
                        return;
                    }
                    a.this.grg.setText(a.this.ibH.getResources().getString(R.string.list_has_no_more));
                    a.this.grg.endLoadData();
                    return;
                }
                a.this.ibV.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e crd;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.crd() != null && (crd = fVar.crd()) != null) {
                this.status = crd.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.ifT) {
                    this.ice.setVisibility(8);
                    this.ich.setVisibility(8);
                    this.ica.setVisibility(8);
                }
                NoticeContent cra = crd.cra();
                if (cra != null && !TextUtils.isEmpty(cra.public_notice)) {
                    Jj(cra.public_notice + "占");
                } else {
                    Jj(this.ibH.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.ibW.setData(fVar);
            if (this.icf != null) {
                this.mVoteData = fVar;
                this.icf.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.ifT) {
                this.icg.setVisibility(0);
                this.icg.setData(fVar);
                this.ibX.setVisibility(0);
                this.icb.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.ifS) {
                this.ica.setData(VoteCandidateCard.igf, fVar);
                this.icg.setVisibility(8);
                this.ibX.setVisibility(8);
                this.ice.setRank(fVar.crd().cqU());
                if (fVar.cre() != null) {
                    ManagerElection cre = fVar.cre();
                    if (!y.isEmpty(cre.vote_condition_pic) || !y.isEmpty(cre.vote_condition_title) || !y.isEmpty(cre.vote_condition)) {
                        this.icb.setVisibility(0);
                        this.icd.setData(cre.vote_condition_pic, cre.vote_condition_title, cre.vote_condition);
                    } else {
                        this.icb.setVisibility(8);
                    }
                } else {
                    this.icb.setVisibility(8);
                }
            } else {
                this.icg.setVisibility(8);
                this.ibX.setVisibility(8);
                this.icb.setVisibility(8);
            }
            cqK();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void Jj(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable, 0);
        bVar.aL(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.ibY.setText(spannableString);
    }

    public void vJ(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ibH = barVoteActivity;
        this.bIq = (RelativeLayout) LayoutInflater.from(this.ibH.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ibH.addContentView(this.bIq, new FrameLayout.LayoutParams(-1, -1));
        this.ibH.showLoadingView(this.bIq, false, l.getDimens(this.ibH, R.dimen.ds400));
        this.mListContainer = this.bIq.findViewById(R.id.list_container);
        this.icj = (ViewGroup) this.bIq.findViewById(R.id.no_data_container);
        this.ibS = this.bIq.findViewById(R.id.nav_bar_container);
        this.ibT = this.bIq.findViewById(R.id.nav_bar_shadow);
        this.ibT.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bIq.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ibH.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ibN = l.getDimens(this.ibH, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ibU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ibH).findViewById(R.id.right_textview);
        this.ibU.setText(R.string.bar_election_rule);
        this.ibU.setOnClickListener(this.ibH);
        this.ibV = (BdRecyclerView) this.bIq.findViewById(R.id.vote_list);
        this.ekp = new LinearLayoutManager(this.ibH);
        this.ibV.setLayoutManager(this.ekp);
        this.icf = new d(barVoteActivity.getPageContext());
        this.ibV.setAdapter(this.icf);
        this.ibQ = (ViewGroup) LayoutInflater.from(this.ibH).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ibQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ibR = (TbImageView) this.ibQ.findViewById(R.id.head_main_iv);
        this.ibR.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ibH) * 884) / 1076));
        this.ibV.addHeaderView(this.ibQ);
        this.ibV.addOnScrollListener(this.icm);
        this.ibV.setOnSrollToBottomListener(this.gMb);
        this.ici = this.ibH.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bJa = new View(this.ibH);
        this.bJa.setLayoutParams(new AbsListView.LayoutParams(-1, this.ici));
        this.bJa.setVisibility(4);
        this.ibV.addFooterView(this.bJa);
        this.ibW = (VoteStatusCard) this.ibQ.findViewById(R.id.vote_status_card);
        this.ibX = this.ibQ.findViewById(R.id.vote_ueg_tip_container);
        this.ibX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ibH);
                View inflate = LayoutInflater.from(a.this.ibH.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ibH.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ibH.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.bi(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ibH.getPageContext());
                ap.d(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.brv();
            }
        });
        this.ibY = (TextView) this.ibQ.findViewById(R.id.vote_ueg_tip_tv);
        this.ibZ = (TextView) this.ibQ.findViewById(R.id.vote_ueg_tip_img);
        this.ibW.setOnRefreshListener(this.icl);
        this.icb = this.ibQ.findViewById(R.id.bar_select_rule_bg);
        this.icc = (TextView) this.ibQ.findViewById(R.id.bar_select_rule_main_title);
        this.icd = (SelectRuleView) this.ibQ.findViewById(R.id.bar_select_rule_container);
        this.icd.setType(1);
        this.ica = (VoteCandidateCard) this.ibQ.findViewById(R.id.vote_for_mine);
        this.ice = (SearchView) this.ibQ.findViewById(R.id.vote_search_view);
        this.ice.v(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ibH, a.this.ibH.fid + "")));
            }
        });
        this.icg = (FloatMyRecordCard) this.bIq.findViewById(R.id.float_my_record_card);
        this.ich = (TextView) this.ibQ.findViewById(R.id.vote_tip);
        this.grg = new PbListView(this.ibH);
        this.grg.getView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.grg.setHeight(l.getDimens(this.ibH, R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.bvh();
        this.grf = (NoNetworkView) this.bIq.findViewById(R.id.no_network_view);
    }

    public void cqK() {
        if (this.status == com.baidu.tieba.barselect.a.d.ifT) {
            this.grg.showEmptyView(l.getDimens(this.ibH, R.dimen.tbds152));
        }
        this.grg.setOnClickListener(this.ibH);
        this.ibV.setNextPage(this.grg);
        if (this.hasMore) {
            this.grg.showEndLoadData();
            return;
        }
        this.grg.setText(this.ibH.getResources().getString(R.string.list_has_no_more));
        this.grg.endLoadData();
    }

    public View getRootView() {
        return this.bIq;
    }

    public BdRecyclerView getListView() {
        return this.ibV;
    }

    public PbListView cqL() {
        return this.grg;
    }

    public void g(View.OnClickListener onClickListener) {
        this.eAI = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Jk(String str) {
        if (this.gsR != null) {
            this.gsR.dettachView(this.mListContainer);
            this.gsR = null;
        }
        this.ibH.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ibH, this.icj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.Cy(str), null);
            this.mNoDataView.setOnClickListener(this.eAI);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.Cy(str));
        this.mNoDataView.onChangeSkinType(this.ibH.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bSf() {
        if (this.ibV != null) {
            this.ibV.setVisibility(8);
        }
        this.ibH.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gsR == null) {
            this.gsR = new h(this.ibH, this.ick);
        }
        this.gsR.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gsR.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gsR.attachView(this.mListContainer, true);
        this.gsR.showRefreshButton();
        this.gsR.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.aku != i) {
            this.aku = i;
            if (this.gsR != null) {
                this.gsR.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bIq, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.ibV, R.color.CAM_X0204, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
                if (this.ibP > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.ibU, R.color.CAM_X0105, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (this.ibP <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.crd() == null || this.mVoteData.crd().getStatus() > 2 || this.mVoteData.crd().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.ibU, R.color.CAM_X0105, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.ibU, R.color.CAM_X0101, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, i);
                    }
                }
                ap.setBackgroundResource(this.ibT, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.ibR, R.drawable.pic_bg_recruit, i);
            this.ibW.vJ(i);
            this.ica.vJ(i);
            this.ice.vJ(i);
            ap.setBackgroundResource(this.icb, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.icc, R.color.CAM_X0105);
            if (this.icd != null) {
                this.icd.sX(i);
            }
            ap.setViewTextColor(this.ich, R.color.CAM_X0109, 1, i);
            ap.setViewTextColor(this.ibY, R.color.CAM_X0108, 1, i);
            ap.setBackgroundResource(this.ibZ, R.drawable.icon_common_explain12_gray66, i);
            this.icg.vJ(i);
            if (this.grg != null) {
                this.grg.setTextColor(ap.getColor(i, R.color.CAM_X0107));
                this.grg.changeSkin(i);
            }
            this.grf.onChangeSkinType(this.ibH.getPageContext(), i);
            if (this.icf != null) {
                this.icf.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.ibW != null) {
            this.ibW.onDestroy();
        }
    }
}
