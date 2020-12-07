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
    private NoNetworkView grd;
    private PbListView gre;
    private h gsP;
    private boolean hasMore;
    private BarVoteActivity ibF;
    private int ibL;
    private ViewGroup ibO;
    private TbImageView ibP;
    private View ibQ;
    private View ibR;
    private TextView ibS;
    private BdRecyclerView ibT;
    private VoteStatusCard ibU;
    private View ibV;
    private TextView ibW;
    private TextView ibX;
    private VoteCandidateCard ibY;
    private View ibZ;
    private TextView ica;
    private SelectRuleView icb;
    private SearchView icc;
    private d icd;
    private FloatMyRecordCard ice;
    private TextView icf;
    private int icg;
    private ViewGroup ich;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int aku = 3;
    private int status = -1;
    private int ibM = 0;
    private float ibN = 0.0f;
    private View.OnClickListener ici = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gsP != null) {
                    a.this.gsP.dettachView(a.this.mListContainer);
                    a.this.gsP = null;
                }
                a.this.ibF.reload();
                if (a.this.ibT != null) {
                    a.this.ibT.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a icj = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ibF != null) {
                a.this.ibF.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener ick = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ibO != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.ibN = Math.abs(a.this.ibO.getTop()) / a.this.ibL;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.ibN);
                a.this.ibR.setAlpha(a.this.ibN);
                if (a.this.ibN > 0.5d) {
                    if (a.this.ibM == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.aku);
                        ap.setViewTextColor(a.this.ibS, R.color.CAM_X0105, 1, a.this.aku);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, a.this.aku);
                        a.this.ibM = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.ibN * 2.0f) - 1.0f);
                    a.this.ibS.setAlpha((a.this.ibN * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.ibN * 2.0f) - 1.0f);
                } else if (a.this.ibN <= 0.5d) {
                    if (a.this.ibM == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.aku);
                        ap.setViewTextColor(a.this.ibS, R.color.CAM_X0101, 1, a.this.aku);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, a.this.aku);
                        a.this.ibM = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.ibN * 2.0f));
                    a.this.ibS.setAlpha(1.0f - (a.this.ibN * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.ibN * 2.0f));
                }
            }
        }
    };
    private BdListView.e gLZ = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ibT != null) {
                a.this.ibT.stopScroll();
            }
            if (a.this.gre != null && a.this.ibF != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == com.baidu.tieba.barselect.a.d.ifR) {
                        a.this.gre.showEmptyView(l.getDimens(a.this.ibF, R.dimen.tbds152));
                    }
                    a.this.ibT.setNextPage(a.this.gre);
                    a.this.gre.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gre.showLoading();
                        a.this.ibF.cqA();
                        return;
                    }
                    a.this.gre.setText(a.this.ibF.getResources().getString(R.string.list_has_no_more));
                    a.this.gre.endLoadData();
                    return;
                }
                a.this.ibT.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        com.baidu.tieba.barselect.data.e crc;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.crc() != null && (crc = fVar.crc()) != null) {
                this.status = crc.getStatus();
                if (this.status == com.baidu.tieba.barselect.a.d.ifR) {
                    this.icc.setVisibility(8);
                    this.icf.setVisibility(8);
                    this.ibY.setVisibility(8);
                }
                NoticeContent cqZ = crc.cqZ();
                if (cqZ != null && !TextUtils.isEmpty(cqZ.public_notice)) {
                    Jj(cqZ.public_notice + "占");
                } else {
                    Jj(this.ibF.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.ibU.setData(fVar);
            if (this.icd != null) {
                this.mVoteData = fVar;
                this.icd.a(fVar);
            }
            if (this.status == com.baidu.tieba.barselect.a.d.ifR) {
                this.ice.setVisibility(0);
                this.ice.setData(fVar);
                this.ibV.setVisibility(0);
                this.ibZ.setVisibility(8);
            } else if (this.status == com.baidu.tieba.barselect.a.d.ifQ) {
                this.ibY.setData(VoteCandidateCard.igd, fVar);
                this.ice.setVisibility(8);
                this.ibV.setVisibility(8);
                this.icc.setRank(fVar.crc().cqT());
                if (fVar.crd() != null) {
                    ManagerElection crd = fVar.crd();
                    if (!y.isEmpty(crd.vote_condition_pic) || !y.isEmpty(crd.vote_condition_title) || !y.isEmpty(crd.vote_condition)) {
                        this.ibZ.setVisibility(0);
                        this.icb.setData(crd.vote_condition_pic, crd.vote_condition_title, crd.vote_condition);
                    } else {
                        this.ibZ.setVisibility(8);
                    }
                } else {
                    this.ibZ.setVisibility(8);
                }
            } else {
                this.ice.setVisibility(8);
                this.ibV.setVisibility(8);
                this.ibZ.setVisibility(8);
            }
            cqJ();
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
        this.ibW.setText(spannableString);
    }

    public void vJ(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ibF = barVoteActivity;
        this.bIq = (RelativeLayout) LayoutInflater.from(this.ibF.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ibF.addContentView(this.bIq, new FrameLayout.LayoutParams(-1, -1));
        this.ibF.showLoadingView(this.bIq, false, l.getDimens(this.ibF, R.dimen.ds400));
        this.mListContainer = this.bIq.findViewById(R.id.list_container);
        this.ich = (ViewGroup) this.bIq.findViewById(R.id.no_data_container);
        this.ibQ = this.bIq.findViewById(R.id.nav_bar_container);
        this.ibR = this.bIq.findViewById(R.id.nav_bar_shadow);
        this.ibR.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bIq.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ibF.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ibL = l.getDimens(this.ibF, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ibS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ibF).findViewById(R.id.right_textview);
        this.ibS.setText(R.string.bar_election_rule);
        this.ibS.setOnClickListener(this.ibF);
        this.ibT = (BdRecyclerView) this.bIq.findViewById(R.id.vote_list);
        this.ekp = new LinearLayoutManager(this.ibF);
        this.ibT.setLayoutManager(this.ekp);
        this.icd = new d(barVoteActivity.getPageContext());
        this.ibT.setAdapter(this.icd);
        this.ibO = (ViewGroup) LayoutInflater.from(this.ibF).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ibO.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ibP = (TbImageView) this.ibO.findViewById(R.id.head_main_iv);
        this.ibP.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ibF) * 884) / 1076));
        this.ibT.addHeaderView(this.ibO);
        this.ibT.addOnScrollListener(this.ick);
        this.ibT.setOnSrollToBottomListener(this.gLZ);
        this.icg = this.ibF.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bJa = new View(this.ibF);
        this.bJa.setLayoutParams(new AbsListView.LayoutParams(-1, this.icg));
        this.bJa.setVisibility(4);
        this.ibT.addFooterView(this.bJa);
        this.ibU = (VoteStatusCard) this.ibO.findViewById(R.id.vote_status_card);
        this.ibV = this.ibO.findViewById(R.id.vote_ueg_tip_container);
        this.ibV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ibF);
                View inflate = LayoutInflater.from(a.this.ibF.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ibF.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ibF.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.bi(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ibF.getPageContext());
                ap.d(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.brv();
            }
        });
        this.ibW = (TextView) this.ibO.findViewById(R.id.vote_ueg_tip_tv);
        this.ibX = (TextView) this.ibO.findViewById(R.id.vote_ueg_tip_img);
        this.ibU.setOnRefreshListener(this.icj);
        this.ibZ = this.ibO.findViewById(R.id.bar_select_rule_bg);
        this.ica = (TextView) this.ibO.findViewById(R.id.bar_select_rule_main_title);
        this.icb = (SelectRuleView) this.ibO.findViewById(R.id.bar_select_rule_container);
        this.icb.setType(1);
        this.ibY = (VoteCandidateCard) this.ibO.findViewById(R.id.vote_for_mine);
        this.icc = (SearchView) this.ibO.findViewById(R.id.vote_search_view);
        this.icc.v(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ibF, a.this.ibF.fid + "")));
            }
        });
        this.ice = (FloatMyRecordCard) this.bIq.findViewById(R.id.float_my_record_card);
        this.icf = (TextView) this.ibO.findViewById(R.id.vote_tip);
        this.gre = new PbListView(this.ibF);
        this.gre.getView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gre.setHeight(l.getDimens(this.ibF, R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.bvh();
        this.grd = (NoNetworkView) this.bIq.findViewById(R.id.no_network_view);
    }

    public void cqJ() {
        if (this.status == com.baidu.tieba.barselect.a.d.ifR) {
            this.gre.showEmptyView(l.getDimens(this.ibF, R.dimen.tbds152));
        }
        this.gre.setOnClickListener(this.ibF);
        this.ibT.setNextPage(this.gre);
        if (this.hasMore) {
            this.gre.showEndLoadData();
            return;
        }
        this.gre.setText(this.ibF.getResources().getString(R.string.list_has_no_more));
        this.gre.endLoadData();
    }

    public View getRootView() {
        return this.bIq;
    }

    public BdRecyclerView getListView() {
        return this.ibT;
    }

    public PbListView cqK() {
        return this.gre;
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
        if (this.gsP != null) {
            this.gsP.dettachView(this.mListContainer);
            this.gsP = null;
        }
        this.ibF.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ibF, this.ich, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.Cy(str), null);
            this.mNoDataView.setOnClickListener(this.eAI);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.Cy(str));
        this.mNoDataView.onChangeSkinType(this.ibF.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bSe() {
        if (this.ibT != null) {
            this.ibT.setVisibility(8);
        }
        this.ibF.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gsP == null) {
            this.gsP = new h(this.ibF, this.ici);
        }
        this.gsP.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gsP.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gsP.attachView(this.mListContainer, true);
        this.gsP.showRefreshButton();
        this.gsP.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.aku != i) {
            this.aku = i;
            if (this.gsP != null) {
                this.gsP.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bIq, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.ibT, R.color.CAM_X0204, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
                if (this.ibN > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.ibS, R.color.CAM_X0105, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (this.ibN <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.crc() == null || this.mVoteData.crc().getStatus() > 2 || this.mVoteData.crc().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.ibS, R.color.CAM_X0105, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.ibS, R.color.CAM_X0101, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, i);
                    }
                }
                ap.setBackgroundResource(this.ibR, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.ibP, R.drawable.pic_bg_recruit, i);
            this.ibU.vJ(i);
            this.ibY.vJ(i);
            this.icc.vJ(i);
            ap.setBackgroundResource(this.ibZ, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.ica, R.color.CAM_X0105);
            if (this.icb != null) {
                this.icb.sX(i);
            }
            ap.setViewTextColor(this.icf, R.color.CAM_X0109, 1, i);
            ap.setViewTextColor(this.ibW, R.color.CAM_X0108, 1, i);
            ap.setBackgroundResource(this.ibX, R.drawable.icon_common_explain12_gray66, i);
            this.ice.vJ(i);
            if (this.gre != null) {
                this.gre.setTextColor(ap.getColor(i, R.color.CAM_X0107));
                this.gre.changeSkin(i);
            }
            this.grd.onChangeSkinType(this.ibF.getPageContext(), i);
            if (this.icd != null) {
                this.icd.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.ibU != null) {
            this.ibU.onDestroy();
        }
    }
}
