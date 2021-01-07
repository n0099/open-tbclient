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
/* loaded from: classes8.dex */
public class a {
    private View bNO;
    private RelativeLayout bNf;
    private View.OnClickListener eKl;
    private LinearLayoutManager etu;
    private NoNetworkView gCe;
    private PbListView gCf;
    private h gDQ;
    private boolean hasMore;
    private VoteCandidateCard ioA;
    private View ioB;
    private TextView ioC;
    private SelectRuleView ioD;
    private SearchView ioE;
    private VoteAdapter ioF;
    private FloatMyRecordCard ioG;
    private TextView ioH;
    private int ioI;
    private ViewGroup ioJ;
    private BarVoteActivity ioh;
    private int ion;
    private ViewGroup ioq;
    private TbImageView ior;
    private View ios;
    private View iot;
    private TextView iou;
    private BdRecyclerView iov;
    private VoteStatusCard iow;
    private View iox;
    private TextView ioy;
    private TextView ioz;
    private View mListContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mScrollState;
    private f mVoteData;
    private int akW = 3;
    private int status = -1;
    private int ioo = 0;
    private float iop = 0.0f;
    private View.OnClickListener ioK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (a.this.gDQ != null) {
                    a.this.gDQ.dettachView(a.this.mListContainer);
                    a.this.gDQ = null;
                }
                a.this.ioh.reload();
                if (a.this.iov != null) {
                    a.this.iov.setVisibility(0);
                }
            }
        }
    };
    private VoteStatusCard.a ioL = new VoteStatusCard.a() { // from class: com.baidu.tieba.barselect.a.2
        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.a
        public void onRefresh() {
            if (a.this.ioh != null) {
                a.this.ioh.refresh();
            }
        }
    };
    RecyclerView.OnScrollListener ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.barselect.a.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.mScrollState = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.mScrollState == 1 || a.this.mScrollState == 2) && a.this.ioq != null && a.this.mNavigationBar != null && a.this.mNavigationBar.getBarBgView() != null && a.this.mNavigationBar.getBackImageView() != null) {
                a.this.iop = Math.abs(a.this.ioq.getTop()) / a.this.ion;
                a.this.mNavigationBar.getBarBgView().setAlpha(a.this.iop);
                a.this.iot.setAlpha(a.this.iop);
                if (a.this.iop > 0.5d) {
                    if (a.this.ioo == 0) {
                        ao.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, a.this.akW);
                        ao.setViewTextColor(a.this.iou, R.color.CAM_X0105, 1, a.this.akW);
                        ao.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, a.this.akW);
                        a.this.ioo = 1;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha((a.this.iop * 2.0f) - 1.0f);
                    a.this.iou.setAlpha((a.this.iop * 2.0f) - 1.0f);
                    a.this.mNavigationBar.mCenterText.setAlpha((a.this.iop * 2.0f) - 1.0f);
                } else if (a.this.iop <= 0.5d) {
                    if (a.this.ioo == 1) {
                        ao.setImageResource(a.this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, a.this.akW);
                        ao.setViewTextColor(a.this.iou, R.color.CAM_X0101, 1, a.this.akW);
                        ao.setViewTextColor(a.this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, a.this.akW);
                        a.this.ioo = 0;
                    }
                    a.this.mNavigationBar.getBackImageView().setAlpha(1.0f - (a.this.iop * 2.0f));
                    a.this.iou.setAlpha(1.0f - (a.this.iop * 2.0f));
                    a.this.mNavigationBar.mCenterText.setAlpha(1.0f - (a.this.iop * 2.0f));
                }
            }
        }
    };
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.barselect.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iov != null) {
                a.this.iov.stopScroll();
            }
            if (a.this.gCf != null && a.this.ioh != null) {
                if (j.isNetWorkAvailable()) {
                    if (a.this.status == d.iso) {
                        a.this.gCf.showEmptyView(l.getDimens(a.this.ioh, R.dimen.tbds152));
                    }
                    a.this.iov.setNextPage(a.this.gCf);
                    a.this.gCf.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gCf.showLoading();
                        a.this.ioh.ctv();
                        return;
                    }
                    a.this.gCf.setText(a.this.ioh.getResources().getString(R.string.list_has_no_more));
                    a.this.gCf.endLoadData();
                    return;
                }
                a.this.iov.setNextPage(null);
            }
        }
    };

    public void setData(f fVar) {
        e ctX;
        if (fVar != null) {
            this.hasMore = fVar.getHasMore();
            if (fVar.ctX() != null && (ctX = fVar.ctX()) != null) {
                this.status = ctX.getStatus();
                if (this.status == d.iso) {
                    this.ioE.setVisibility(8);
                    this.ioH.setVisibility(8);
                    this.ioA.setVisibility(8);
                }
                NoticeContent ctU = ctX.ctU();
                if (ctU != null && !TextUtils.isEmpty(ctU.public_notice)) {
                    Jg(ctU.public_notice + "占");
                } else {
                    Jg(this.ioh.getResources().getString(R.string.vote_ueg_tip) + "占");
                }
            }
            this.iow.setData(fVar);
            if (this.ioF != null) {
                this.mVoteData = fVar;
                this.ioF.a(fVar);
            }
            if (this.status == d.iso) {
                this.ioG.setVisibility(0);
                this.ioG.setData(fVar);
                this.iox.setVisibility(0);
                this.ioB.setVisibility(8);
            } else if (this.status == d.isn) {
                this.ioA.setData(VoteCandidateCard.isA, fVar);
                this.ioG.setVisibility(8);
                this.iox.setVisibility(8);
                this.ioE.setRank(fVar.ctX().ctO());
                if (fVar.ctY() != null) {
                    ManagerElection ctY = fVar.ctY();
                    if (!x.isEmpty(ctY.vote_condition_pic) || !x.isEmpty(ctY.vote_condition_title) || !x.isEmpty(ctY.vote_condition)) {
                        this.ioB.setVisibility(0);
                        this.ioD.setData(ctY.vote_condition_pic, ctY.vote_condition_title, ctY.vote_condition);
                    } else {
                        this.ioB.setVisibility(8);
                    }
                } else {
                    this.ioB.setVisibility(8);
                }
            } else {
                this.ioG.setVisibility(8);
                this.iox.setVisibility(8);
                this.ioB.setVisibility(8);
            }
            ctE();
            N(TbadkCoreApplication.getInst().getSkinType(), true);
        }
    }

    private void Jg(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ao.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        b bVar = new b(drawable, 0);
        bVar.aM(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.ioy.setText(spannableString);
    }

    public void vU(int i) {
        N(i, false);
    }

    public a(BarVoteActivity barVoteActivity) {
        this.ioh = barVoteActivity;
        this.bNf = (RelativeLayout) LayoutInflater.from(this.ioh.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.ioh.addContentView(this.bNf, new FrameLayout.LayoutParams(-1, -1));
        this.ioh.showLoadingView(this.bNf, false, l.getDimens(this.ioh, R.dimen.ds400));
        this.mListContainer = this.bNf.findViewById(R.id.list_container);
        this.ioJ = (ViewGroup) this.bNf.findViewById(R.id.no_data_container);
        this.ios = this.bNf.findViewById(R.id.nav_bar_container);
        this.iot = this.bNf.findViewById(R.id.nav_bar_shadow);
        this.iot.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) this.bNf.findViewById(R.id.vote_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ioh.getResources().getString(R.string.bar_manager_recruit));
        if (this.mNavigationBar.getBarBgView() != null) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        this.ion = l.getDimens(this.ioh, R.dimen.tbds402);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iou = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.ioh).findViewById(R.id.right_textview);
        this.iou.setText(R.string.bar_election_rule);
        this.iou.setOnClickListener(this.ioh);
        this.iov = (BdRecyclerView) this.bNf.findViewById(R.id.vote_list);
        this.etu = new LinearLayoutManager(this.ioh);
        this.iov.setLayoutManager(this.etu);
        this.ioF = new VoteAdapter(barVoteActivity.getPageContext());
        this.iov.setAdapter(this.ioF);
        this.ioq = (ViewGroup) LayoutInflater.from(this.ioh).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.ioq.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ior = (TbImageView) this.ioq.findViewById(R.id.head_main_iv);
        this.ior.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.getEquipmentWidth(this.ioh) * 884) / 1076));
        this.iov.addHeaderView(this.ioq);
        this.iov.addOnScrollListener(this.ioM);
        this.iov.setOnSrollToBottomListener(this.gXN);
        this.ioI = this.ioh.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bNO = new View(this.ioh);
        this.bNO.setLayoutParams(new AbsListView.LayoutParams(-1, this.ioI));
        this.bNO.setVisibility(4);
        this.iov.addFooterView(this.bNO);
        this.iow = (VoteStatusCard) this.ioq.findViewById(R.id.vote_status_card);
        this.iox = this.ioq.findViewById(R.id.vote_ueg_tip_container);
        this.iox.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.ioh);
                View inflate = LayoutInflater.from(a.this.ioh.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(a.this.ioh.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.ioh.getResources().getString(R.string.vote_ueg_tip_detail_2));
                ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.br(inflate);
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.barselect.a.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(a.this.ioh.getPageContext());
                ao.d(aVar.getRealView(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.btY();
            }
        });
        this.ioy = (TextView) this.ioq.findViewById(R.id.vote_ueg_tip_tv);
        this.ioz = (TextView) this.ioq.findViewById(R.id.vote_ueg_tip_img);
        this.iow.setOnRefreshListener(this.ioL);
        this.ioB = this.ioq.findViewById(R.id.bar_select_rule_bg);
        this.ioC = (TextView) this.ioq.findViewById(R.id.bar_select_rule_main_title);
        this.ioD = (SelectRuleView) this.ioq.findViewById(R.id.bar_select_rule_container);
        this.ioD.setType(1);
        this.ioA = (VoteCandidateCard) this.ioq.findViewById(R.id.vote_for_mine);
        this.ioE = (SearchView) this.ioq.findViewById(R.id.vote_search_view);
        this.ioE.w(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CandidateSearchActivityConfig(a.this.ioh, a.this.ioh.fid + "")));
            }
        });
        this.ioG = (FloatMyRecordCard) this.bNf.findViewById(R.id.float_my_record_card);
        this.ioH = (TextView) this.ioq.findViewById(R.id.vote_tip);
        this.gCf = new PbListView(this.ioh);
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setHeight(l.getDimens(this.ioh, R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bxD();
        this.gCe = (NoNetworkView) this.bNf.findViewById(R.id.no_network_view);
    }

    public void ctE() {
        if (this.status == d.iso) {
            this.gCf.showEmptyView(l.getDimens(this.ioh, R.dimen.tbds152));
        }
        this.gCf.setOnClickListener(this.ioh);
        this.iov.setNextPage(this.gCf);
        if (this.hasMore) {
            this.gCf.showEndLoadData();
            return;
        }
        this.gCf.setText(this.ioh.getResources().getString(R.string.list_has_no_more));
        this.gCf.endLoadData();
    }

    public View getRootView() {
        return this.bNf;
    }

    public BdRecyclerView getListView() {
        return this.iov;
    }

    public PbListView ctF() {
        return this.gCf;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eKl = onClickListener;
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Jh(String str) {
        if (this.gDQ != null) {
            this.gDQ.dettachView(this.mListContainer);
            this.gDQ = null;
        }
        this.ioh.hideLoadingView(getRootView());
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ioh, this.ioJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.d.Cv(str), null);
            this.mNoDataView.setOnClickListener(this.eKl);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.Cv(str));
        this.mNoDataView.onChangeSkinType(this.ioh.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bUI() {
        if (this.iov != null) {
            this.iov.setVisibility(8);
        }
        this.ioh.hideLoadingView(getRootView());
        if (this.mNoDataView != null) {
            hideNoDataView();
        }
        if (this.gDQ == null) {
            this.gDQ = new h(this.ioh, this.ioK);
        }
        this.gDQ.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.gDQ.setSubText(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.gDQ.attachView(this.mListContainer, true);
        this.gDQ.showRefreshButton();
        this.gDQ.onChangeSkinType();
    }

    public void N(int i, boolean z) {
        if (z || this.akW != i) {
            this.akW = i;
            if (this.gDQ != null) {
                this.gDQ.onChangeSkinType();
            }
            ao.setBackgroundColor(this.bNf, R.color.CAM_X0201, i);
            ao.setBackgroundColor(this.iov, R.color.CAM_X0204, i);
            if (this.mNavigationBar != null) {
                ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
                if (this.iop > 0.5d) {
                    ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    ao.setViewTextColor(this.iou, R.color.CAM_X0105, 1, i);
                    ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (this.iop <= 0.5d) {
                    if (this.mVoteData == null || this.mVoteData.ctX() == null || this.mVoteData.ctX().getStatus() > 2 || this.mVoteData.ctX().getStatus() < 1) {
                        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        ao.setViewTextColor(this.iou, R.color.CAM_X0105, 1, i);
                        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1, i);
                    } else {
                        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg, i);
                        ao.setViewTextColor(this.iou, R.color.CAM_X0101, 1, i);
                        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101, 1, i);
                    }
                }
                ao.setBackgroundResource(this.iot, R.drawable.top_view_shadow, i);
            }
            ao.setImageResource(this.ior, R.drawable.pic_bg_recruit, i);
            this.iow.vU(i);
            this.ioA.vU(i);
            this.ioE.vU(i);
            ao.setBackgroundResource(this.ioB, R.drawable.bar_select_bg_shadow_and_radius, i);
            ao.setViewTextColor(this.ioC, R.color.CAM_X0105);
            if (this.ioD != null) {
                this.ioD.ti(i);
            }
            ao.setViewTextColor(this.ioH, R.color.CAM_X0109, 1, i);
            ao.setViewTextColor(this.ioy, R.color.CAM_X0108, 1, i);
            ao.setBackgroundResource(this.ioz, R.drawable.icon_common_explain12_gray66, i);
            this.ioG.vU(i);
            if (this.gCf != null) {
                this.gCf.setTextColor(ao.getColor(i, R.color.CAM_X0107));
                this.gCf.changeSkin(i);
            }
            this.gCe.onChangeSkinType(this.ioh.getPageContext(), i);
            if (this.ioF != null) {
                this.ioF.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.iow != null) {
            this.iow.onDestroy();
        }
    }
}
