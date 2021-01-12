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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private RelativeLayout bIt;
    private View bJc;
    private View.OnClickListener eFA;
    private LinearLayoutManager eoG;
    private NoNetworkView gxx;
    private PbListView gxy;
    private h gzj;
    private boolean hasMore;
    private int ijE;
    private ViewGroup ijH;
    private TbImageView ijI;
    private View ijJ;
    private View ijK;
    private TextView ijL;
    private BdRecyclerView ijM;
    private VoteStatusCard ijN;
    private View ijO;
    private TextView ijP;
    private TextView ijQ;
    private VoteCandidateCard ijR;
    private View ijS;
    private TextView ijT;
    private SelectRuleView ijU;
    private SearchView ijV;
    private VoteAdapter ijW;
    private FloatMyRecordCard ijX;
    private TextView ijY;
    private int ijZ;
    private BarVoteActivity ijy;
    private ViewGroup ika;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int akf = 3;
    private int status = -1;
    private int ijF = 0;
    private float ijG = 0.0f;
    private View.OnClickListener ikb = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gzj != null) {
                    a.this.gzj.dettachView(a.this.mListContainer);
                    a.this.gzj = null;
                }
                a.this.ijy.reload();
                if (a.this.ijM != null) {
                    a.this.ijM.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a ikc = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ijy != null) {
                a.this.ijy.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ijH != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.ijG = Math.abs(a.this.ijH.getTop()) / a.this.ijE;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.ijG);
                a.this.ijK.setAlpha(a.this.ijG);
                if (a.this.ijG > 0.5d) {
                    if (a.this.ijF == 0) {
                        ao.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.akf);
                        ao.setViewTextColor(a.this.ijL, R.color.CAM_X0105, 1, a.this.akf);
                        ao.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, a.this.akf);
                        a.this.ijF = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.ijG * 2.0f) - 1.0f);
                    a.this.ijL.setAlpha((a.this.ijG * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.ijG * 2.0f) - 1.0f);
                } else if (a.this.ijG <= 0.5d) {
                    if (a.this.ijF == 1) {
                        ao.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.akf);
                        ao.setViewTextColor(a.this.ijL, R.color.CAM_X0101, 1, a.this.akf);
                        ao.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, a.this.akf);
                        a.this.ijF = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.ijG * 2.0f));
                    a.this.ijL.setAlpha(1.0f - (a.this.ijG * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.ijG * 2.0f));
                }
            }
        }
    };
    private BdListView.e gTh = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ijM != null) {
                a.this.ijM.stopScroll();
            }
            if (a.this.gxy != null && a.this.ijy != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == d.inH) {
                        a.this.gxy.showEmptyView(l.getDimens(a.this.ijy, R.dimen.tbds152));
                    }
                    a.this.ijM.setNextPage(a.this.gxy);
                    a.this.gxy.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gxy.showLoading();
                        a.this.ijy.cpD();
                        return;
                    }
                    a.this.gxy.setText(a.this.ijy.getResources().getString(R.string.list_has_no_more));
                    a.this.gxy.endLoadData();
                    return;
                }
                a.this.ijM.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        e cqf;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.cqf() != null && (cqf = fVar.cqf()) != null) {
                this.status = cqf.getStatus();
                if (this.status == d.inH) {
                    this.ijV.setVisibility(8);
                    this.ijY.setVisibility(8);
                    this.ijR.setVisibility(8);
                }
                NoticeContent cqc = cqf.cqc();
                if (cqc != null && !TextUtils.isEmpty(cqc.public_notice)) {
                    HV(cqc.public_notice + "占");
                } else {
                    HV(this.ijy.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.ijN.setData(fVar);
            if (this.ijW != null) {
                this.mVoteData = fVar;
                this.ijW.a(fVar);
            }
            if (this.status == d.inH) {
                this.ijX.setVisibility(0);
                this.ijX.setData(fVar);
                this.ijO.setVisibility(0);
                this.ijS.setVisibility(8);
            } else if (this.status == d.inG) {
                this.ijR.setData(VoteCandidateCard.inT, fVar);
                this.ijX.setVisibility(8);
                this.ijO.setVisibility(8);
                this.ijV.setRank(fVar.cqf().cpW());
                if (fVar.cqg() != null) {
                    ManagerElection cqg = fVar.cqg();
                    if (!x.isEmpty(cqg.vote_condition_pic) || !x.isEmpty(cqg.vote_condition_title) || !x.isEmpty(cqg.vote_condition)) {
                        this.ijS.setVisibility(0);
                        this.ijU.setData(cqg.vote_condition_pic, cqg.vote_condition_title, cqg.vote_condition);
                    } else {
                        this.ijS.setVisibility(8);
                    }
                } else {
                    this.ijS.setVisibility(8);
                }
            } else {
                this.ijX.setVisibility(8);
                this.ijO.setVisibility(8);
                this.ijS.setVisibility(8);
            }
            cpM();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void HV(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ao.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        b bVar = new b(drawable, 0);
        bVar.aM(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.ijP.setText(spannableString);
    }

    public void uo(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ijy = barVoteActivity;
        this.bIt = (RelativeLayout) LayoutInflater.from(this.ijy.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ijy.addContentView(this.bIt, new FrameLayout.LayoutParams(-1, -1));
        this.ijy.showLoadingView(this.bIt, false, l.getDimens(this.ijy, R.dimen.ds400));
        this.mListContainer = this.bIt.findViewById(R.id.list_container);
        this.ika = (ViewGroup) this.bIt.findViewById(R.id.no_data_container);
        this.ijJ = this.bIt.findViewById(R.id.nav_bar_container);
        this.ijK = this.bIt.findViewById(R.id.nav_bar_shadow);
        this.ijK.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bIt.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ijy.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ijE = l.getDimens(this.ijy, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ijL = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ijy).findViewById(R.id.right_textview);
        this.ijL.setText(R.string.bar_election_rule);
        this.ijL.setOnClickListener(this.ijy);
        this.ijM = (BdRecyclerView) this.bIt.findViewById(R.id.vote_list);
        this.eoG = new LinearLayoutManager(this.ijy);
        this.ijM.setLayoutManager(this.eoG);
        this.ijW = new VoteAdapter(barVoteActivity.getPageContext());
        this.ijM.setAdapter(this.ijW);
        this.ijH = (ViewGroup) LayoutInflater.from(this.ijy).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ijH.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ijI = (TbImageView) this.ijH.findViewById(R.id.head_main_iv);
        this.ijI.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ijy) * 884) / 1076));
        this.ijM.addHeaderView(this.ijH);
        this.ijM.addOnScrollListener(this.ikd);
        this.ijM.setOnSrollToBottomListener(this.gTh);
        this.ijZ = this.ijy.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bJc = new View(this.ijy);
        this.bJc.setLayoutParams(new AbsListView.LayoutParams(-1, this.ijZ));
        this.bJc.setVisibility(4);
        this.ijM.addFooterView(this.bJc);
        this.ijN = (VoteStatusCard) this.ijH.findViewById(R.id.vote_status_card);
        this.ijO = this.ijH.findViewById(R.id.vote_ueg_tip_container);
        this.ijO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ijy);
                View inflate = LayoutInflater.from(a.this.ijy.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ijy.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ijy.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.br(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ijy.getPageContext());
                ao.d(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.bqe();
            }
        });
        this.ijP = (TextView) this.ijH.findViewById(R.id.vote_ueg_tip_tv);
        this.ijQ = (TextView) this.ijH.findViewById(R.id.vote_ueg_tip_img);
        this.ijN.setOnRefreshListener(this.ikc);
        this.ijS = this.ijH.findViewById(R.id.bar_select_rule_bg);
        this.ijT = (TextView) this.ijH.findViewById(R.id.bar_select_rule_main_title);
        this.ijU = (SelectRuleView) this.ijH.findViewById(R.id.bar_select_rule_container);
        this.ijU.setType(1);
        this.ijR = (VoteCandidateCard) this.ijH.findViewById(R.id.vote_for_mine);
        this.ijV = (SearchView) this.ijH.findViewById(R.id.vote_search_view);
        this.ijV.w(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ijy, a.this.ijy.fid + "")));
            }
        });
        this.ijX = (FloatMyRecordCard) this.bIt.findViewById(R.id.float_my_record_card);
        this.ijY = (TextView) this.ijH.findViewById(R.id.vote_tip);
        this.gxy = new PbListView(this.ijy);
        this.gxy.getView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gxy.setHeight(l.getDimens(this.ijy, R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.btJ();
        this.gxx = (NoNetworkView) this.bIt.findViewById(R.id.no_network_view);
    }

    public void cpM() {
        if (this.status == d.inH) {
            this.gxy.showEmptyView(l.getDimens(this.ijy, R.dimen.tbds152));
        }
        this.gxy.setOnClickListener(this.ijy);
        this.ijM.setNextPage(this.gxy);
        if (this.hasMore) {
            this.gxy.showEndLoadData();
            return;
        }
        this.gxy.setText(this.ijy.getResources().getString(R.string.list_has_no_more));
        this.gxy.endLoadData();
    }

    public View getRootView() {
        return this.bIt;
    }

    public BdRecyclerView getListView() {
        return this.ijM;
    }

    public PbListView cpN() {
        return this.gxy;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eFA = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void HW(String str) {
        if (this.gzj != null) {
            this.gzj.dettachView(this.mListContainer);
            this.gzj = null;
        }
        this.ijy.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ijy, this.ika, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.Bk(str), null);
            this.mNoDataView.setOnClickListener(this.eFA);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.Bk(str));
        this.mNoDataView.onChangeSkinType(this.ijy.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bQQ() {
        if (this.ijM != null) {
            this.ijM.setVisibility(8);
        }
        this.ijy.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gzj == null) {
            this.gzj = new h(this.ijy, this.ikb);
        }
        this.gzj.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gzj.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gzj.attachView(this.mListContainer, true);
        this.gzj.showRefreshButton();
        this.gzj.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.akf != i) {
            this.akf = i;
            if (this.gzj != null) {
                this.gzj.onChangeSkinType();
            }
            ao.setBackgroundColor(this.bIt, R.color.CAM_X0201, i);
            ao.setBackgroundColor(this.ijM, R.color.CAM_X0204, i);
            if (this.mNavigationBar != null) {
                ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
                if (this.ijG > 0.5d) {
                    ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ao.setViewTextColor(this.ijL, R.color.CAM_X0105, 1, i);
                    ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (this.ijG <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.cqf() == null || this.mVoteData.cqf().getStatus() > 2 || this.mVoteData.cqf().getStatus() < 1) {
                        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ao.setViewTextColor(this.ijL, R.color.CAM_X0105, 1, i);
                        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                    } else {
                        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ao.setViewTextColor(this.ijL, R.color.CAM_X0101, 1, i);
                        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, i);
                    }
                }
                ao.setBackgroundResource(this.ijK, R.drawable.top_view_shadow, i);
            }
            ao.setImageResource(this.ijI, R.drawable.pic_bg_recruit, i);
            this.ijN.uo(i);
            this.ijR.uo(i);
            this.ijV.uo(i);
            ao.setBackgroundResource(this.ijS, R.drawable.bar_select_bg_shadow_and_radius, i);
            ao.setViewTextColor(this.ijT, R.color.CAM_X0105);
            if (this.ijU != null) {
                this.ijU.rC(i);
            }
            ao.setViewTextColor(this.ijY, R.color.CAM_X0109, 1, i);
            ao.setViewTextColor(this.ijP, R.color.CAM_X0108, 1, i);
            ao.setBackgroundResource(this.ijQ, R.drawable.icon_common_explain12_gray66, i);
            this.ijX.uo(i);
            if (this.gxy != null) {
                this.gxy.setTextColor(ao.getColor(i, R.color.CAM_X0107));
                this.gxy.changeSkin(i);
            }
            this.gxx.onChangeSkinType(this.ijy.getPageContext(), i);
            if (this.ijW != null) {
                this.ijW.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.ijN != null) {
            this.ijN.onDestroy();
        }
    }
}
