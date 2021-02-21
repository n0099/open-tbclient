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
/* loaded from: classes8.dex */
public class a {
    private View bMM;
    private RelativeLayout bMd;
    private View.OnClickListener eHG;
    private LinearLayoutManager eqM;
    private NoNetworkView gAv;
    private PbListView gAw;
    private h gCh;
    private boolean hasMore;
    private int ipA;
    private ViewGroup ipD;
    private TbImageView ipE;
    private View ipF;
    private View ipG;
    private TextView ipH;
    private BdRecyclerView ipI;
    private VoteStatusCard ipJ;
    private View ipK;
    private TextView ipL;
    private TextView ipM;
    private VoteCandidateCard ipN;
    private View ipO;
    private TextView ipP;
    private SelectRuleView ipQ;
    private SearchView ipR;
    private VoteAdapter ipS;
    private FloatMyRecordCard ipT;
    private TextView ipU;
    private int ipV;
    private ViewGroup ipW;
    private BarVoteActivity ipu;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int ajU = 3;
    private int status = -1;
    private int ipB = 0;
    private float ipC = 0.0f;
    private View.OnClickListener ipX = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gCh != null) {
                    a.this.gCh.dettachView(a.this.mListContainer);
                    a.this.gCh = null;
                }
                a.this.ipu.reload();
                if (a.this.ipI != null) {
                    a.this.ipI.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a ipY = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ipu != null) {
                a.this.ipu.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ipD != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.ipC = Math.abs(a.this.ipD.getTop()) / a.this.ipA;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.ipC);
                a.this.ipG.setAlpha(a.this.ipC);
                if (a.this.ipC > 0.5d) {
                    if (a.this.ipB == 0) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.ajU);
                        ap.setViewTextColor(a.this.ipH, R.color.CAM_X0105, 1, a.this.ajU);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, a.this.ajU);
                        a.this.ipB = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.ipC * 2.0f) - 1.0f);
                    a.this.ipH.setAlpha((a.this.ipC * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.ipC * 2.0f) - 1.0f);
                } else if (a.this.ipC <= 0.5d) {
                    if (a.this.ipB == 1) {
                        ap.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.ajU);
                        ap.setViewTextColor(a.this.ipH, R.color.CAM_X0101, 1, a.this.ajU);
                        ap.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, a.this.ajU);
                        a.this.ipB = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.ipC * 2.0f));
                    a.this.ipH.setAlpha(1.0f - (a.this.ipC * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.ipC * 2.0f));
                }
            }
        }
    };
    private BdListView.e gWf = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ipI != null) {
                a.this.ipI.stopScroll();
            }
            if (a.this.gAw != null && a.this.ipu != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == d.itz) {
                        a.this.gAw.showEmptyView(l.getDimens(a.this.ipu, R.dimen.tbds152));
                    }
                    a.this.ipI.setNextPage(a.this.gAw);
                    a.this.gAw.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gAw.showLoading();
                        a.this.ipu.cqU();
                        return;
                    }
                    a.this.gAw.setText(a.this.ipu.getResources().getString(R.string.list_has_no_more));
                    a.this.gAw.endLoadData();
                    return;
                }
                a.this.ipI.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        e crw;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.crw() != null && (crw = fVar.crw()) != null) {
                this.status = crw.getStatus();
                if (this.status == d.itz) {
                    this.ipR.setVisibility(8);
                    this.ipU.setVisibility(8);
                    this.ipN.setVisibility(8);
                }
                NoticeContent crt = crw.crt();
                if (crt != null && !TextUtils.isEmpty(crt.public_notice)) {
                    IG(crt.public_notice + "占");
                } else {
                    IG(this.ipu.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.ipJ.setData(fVar);
            if (this.ipS != null) {
                this.mVoteData = fVar;
                this.ipS.a(fVar);
            }
            if (this.status == d.itz) {
                this.ipT.setVisibility(0);
                this.ipT.setData(fVar);
                this.ipK.setVisibility(0);
                this.ipO.setVisibility(8);
            } else if (this.status == d.ity) {
                this.ipN.setData(VoteCandidateCard.itL, fVar);
                this.ipT.setVisibility(8);
                this.ipK.setVisibility(8);
                this.ipR.setRank(fVar.crw().crn());
                if (fVar.crx() != null) {
                    ManagerElection crx = fVar.crx();
                    if (!y.isEmpty(crx.vote_condition_pic) || !y.isEmpty(crx.vote_condition_title) || !y.isEmpty(crx.vote_condition)) {
                        this.ipO.setVisibility(0);
                        this.ipQ.setData(crx.vote_condition_pic, crx.vote_condition_title, crx.vote_condition);
                    } else {
                        this.ipO.setVisibility(8);
                    }
                } else {
                    this.ipO.setVisibility(8);
                }
            } else {
                this.ipT.setVisibility(8);
                this.ipK.setVisibility(8);
                this.ipO.setVisibility(8);
            }
            crd();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void IG(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ap.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        b bVar = new b(drawable, 0);
        bVar.aM(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.ipL.setText(spannableString);
    }

    public void uu(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ipu = barVoteActivity;
        this.bMd = (RelativeLayout) LayoutInflater.from(this.ipu.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ipu.addContentView(this.bMd, new FrameLayout.LayoutParams(-1, -1));
        this.ipu.showLoadingView(this.bMd, false, l.getDimens(this.ipu, R.dimen.ds400));
        this.mListContainer = this.bMd.findViewById(R.id.list_container);
        this.ipW = (ViewGroup) this.bMd.findViewById(R.id.no_data_container);
        this.ipF = this.bMd.findViewById(R.id.nav_bar_container);
        this.ipG = this.bMd.findViewById(R.id.nav_bar_shadow);
        this.ipG.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bMd.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ipu.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ipA = l.getDimens(this.ipu, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ipH = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ipu).findViewById(R.id.right_textview);
        this.ipH.setText(R.string.bar_election_rule);
        this.ipH.setOnClickListener(this.ipu);
        this.ipI = (BdRecyclerView) this.bMd.findViewById(R.id.vote_list);
        this.eqM = new LinearLayoutManager(this.ipu);
        this.ipI.setLayoutManager(this.eqM);
        this.ipS = new VoteAdapter(barVoteActivity.getPageContext());
        this.ipI.setAdapter(this.ipS);
        this.ipD = (ViewGroup) LayoutInflater.from(this.ipu).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ipD.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ipE = (TbImageView) this.ipD.findViewById(R.id.head_main_iv);
        this.ipE.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ipu) * 884) / 1076));
        this.ipI.addHeaderView(this.ipD);
        this.ipI.addOnScrollListener(this.ipZ);
        this.ipI.setOnSrollToBottomListener(this.gWf);
        this.ipV = this.ipu.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bMM = new View(this.ipu);
        this.bMM.setLayoutParams(new AbsListView.LayoutParams(-1, this.ipV));
        this.bMM.setVisibility(4);
        this.ipI.addFooterView(this.bMM);
        this.ipJ = (VoteStatusCard) this.ipD.findViewById(R.id.vote_status_card);
        this.ipK = this.ipD.findViewById(R.id.vote_ueg_tip_container);
        this.ipK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ipu);
                View inflate = LayoutInflater.from(a.this.ipu.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ipu.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ipu.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.bn(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ipu.getPageContext());
                ap.d(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.bqx();
            }
        });
        this.ipL = (TextView) this.ipD.findViewById(R.id.vote_ueg_tip_tv);
        this.ipM = (TextView) this.ipD.findViewById(R.id.vote_ueg_tip_img);
        this.ipJ.setOnRefreshListener(this.ipY);
        this.ipO = this.ipD.findViewById(R.id.bar_select_rule_bg);
        this.ipP = (TextView) this.ipD.findViewById(R.id.bar_select_rule_main_title);
        this.ipQ = (SelectRuleView) this.ipD.findViewById(R.id.bar_select_rule_container);
        this.ipQ.setType(1);
        this.ipN = (VoteCandidateCard) this.ipD.findViewById(R.id.vote_for_mine);
        this.ipR = (SearchView) this.ipD.findViewById(R.id.vote_search_view);
        this.ipR.w(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ipu, a.this.ipu.fid + "")));
            }
        });
        this.ipT = (FloatMyRecordCard) this.bMd.findViewById(R.id.float_my_record_card);
        this.ipU = (TextView) this.ipD.findViewById(R.id.vote_tip);
        this.gAw = new PbListView(this.ipu);
        this.gAw.getView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAw.setHeight(l.getDimens(this.ipu, R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.bud();
        this.gAv = (NoNetworkView) this.bMd.findViewById(R.id.no_network_view);
    }

    public void crd() {
        if (this.status == d.itz) {
            this.gAw.showEmptyView(l.getDimens(this.ipu, R.dimen.tbds152));
        }
        this.gAw.setOnClickListener(this.ipu);
        this.ipI.setNextPage(this.gAw);
        if (this.hasMore) {
            this.gAw.showEndLoadData();
            return;
        }
        this.gAw.setText(this.ipu.getResources().getString(R.string.list_has_no_more));
        this.gAw.endLoadData();
    }

    public View getRootView() {
        return this.bMd;
    }

    public BdRecyclerView getListView() {
        return this.ipI;
    }

    public PbListView cre() {
        return this.gAw;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eHG = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void IH(String str) {
        if (this.gCh != null) {
            this.gCh.dettachView(this.mListContainer);
            this.gCh = null;
        }
        this.ipu.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ipu, this.ipW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.BB(str), null);
            this.mNoDataView.setOnClickListener(this.eHG);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.BB(str));
        this.mNoDataView.onChangeSkinType(this.ipu.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bRB() {
        if (this.ipI != null) {
            this.ipI.setVisibility(8);
        }
        this.ipu.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gCh == null) {
            this.gCh = new h(this.ipu, this.ipX);
        }
        this.gCh.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gCh.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gCh.attachView(this.mListContainer, true);
        this.gCh.showRefreshButton();
        this.gCh.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.ajU != i) {
            this.ajU = i;
            if (this.gCh != null) {
                this.gCh.onChangeSkinType();
            }
            ap.setBackgroundColor(this.bMd, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.ipI, R.color.CAM_X0204, i);
            if (this.mNavigationBar != null) {
                ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
                if (this.ipC > 0.5d) {
                    ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ap.setViewTextColor(this.ipH, R.color.CAM_X0105, 1, i);
                    ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (this.ipC <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.crw() == null || this.mVoteData.crw().getStatus() > 2 || this.mVoteData.crw().getStatus() < 1) {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ap.setViewTextColor(this.ipH, R.color.CAM_X0105, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                    } else {
                        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ap.setViewTextColor(this.ipH, R.color.CAM_X0101, 1, i);
                        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, i);
                    }
                }
                ap.setBackgroundResource(this.ipG, R.drawable.top_view_shadow, i);
            }
            ap.setImageResource(this.ipE, R.drawable.pic_bg_recruit, i);
            this.ipJ.uu(i);
            this.ipN.uu(i);
            this.ipR.uu(i);
            ap.setBackgroundResource(this.ipO, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.ipP, R.color.CAM_X0105);
            if (this.ipQ != null) {
                this.ipQ.rH(i);
            }
            ap.setViewTextColor(this.ipU, R.color.CAM_X0109, 1, i);
            ap.setViewTextColor(this.ipL, R.color.CAM_X0108, 1, i);
            ap.setBackgroundResource(this.ipM, R.drawable.icon_common_explain12_gray66, i);
            this.ipT.uu(i);
            if (this.gAw != null) {
                this.gAw.setTextColor(ap.getColor(i, R.color.CAM_X0107));
                this.gAw.changeSkin(i);
            }
            this.gAv.onChangeSkinType(this.ipu.getPageContext(), i);
            if (this.ipS != null) {
                this.ipS.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.ipJ != null) {
            this.ipJ.onDestroy();
        }
    }
}
