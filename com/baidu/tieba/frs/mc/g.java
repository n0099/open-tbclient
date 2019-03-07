package com.baidu.tieba.frs.mc;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout bhB;
    private x ccy;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private FrsNewAreaFragment frO;
    private f frU;
    private RelativeLayout frV;
    private com.baidu.tieba.frs.entelechy.c.a.a frW;
    private RelativeLayout cMu = null;
    private BdTypeRecyclerView faU = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fpL = null;
    private boolean fpN = false;
    private boolean fbc = true;
    private BannerView.a fpR = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void akc() {
            g.this.bhi();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void akd() {
            g.this.bhk();
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.frO = null;
        this.frO = frsNewAreaFragment;
        bD(view);
    }

    public void refreshView() {
        this.frU.notifyDataSetChanged();
    }

    public void jg(boolean z) {
        this.dcE.setEnabled(z);
    }

    public void jh(boolean z) {
        this.fbc = z;
        if (z) {
            this.dbr.setText(this.frO.getResources().getString(d.j.load_more));
            if (this.faU.getChildAt(this.faU.getChildCount() - 1) == this.dbr.getView()) {
                this.dbr.aeC();
                this.frO.aBc();
                return;
            }
            this.dbr.aeD();
            return;
        }
        this.dbr.setText(this.frO.getResources().getString(d.j.load_more_must_after_delete));
        this.dbr.aeD();
    }

    public boolean bdG() {
        if (this.fbc) {
            return false;
        }
        this.dbr.setText(this.frO.getResources().getString(d.j.load_more_must_after_delete));
        this.dbr.aeD();
        return true;
    }

    private void bD(View view) {
        this.cMu = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        this.faU = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.faU.setLayoutManager(new LinearLayoutManager(this.faU.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.frO.getPageContext());
        this.faU.setFadingEdgeLength(0);
        this.faU.setOverScrollMode(2);
        this.faU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(d.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(d.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.dbr = new PbListView(this.frO.getPageContext().getPageActivity());
        this.dbr.oM();
        this.dbr.ib(d.C0236d.cp_bg_line_e);
        this.dbr.setHeight(com.baidu.adp.lib.util.l.h(this.frO.getActivity(), d.e.tbds182));
        this.dbr.aez();
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
        this.dbr.ia(d.C0236d.cp_cont_e);
        this.faU.setOnSrollToBottomListener(this.frO);
        if (this.dcE == null) {
            this.dcE = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.dcE.setProgressView(this.mPullView);
            al.l(this.dcE, d.C0236d.cp_bg_line_e);
        }
        this.bhB = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.frU = new f(this.frO, this.faU);
        fB(false);
        this.frV = new RelativeLayout(this.frO.getContext());
        this.frV.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.frW = new com.baidu.tieba.frs.entelechy.c.a.a(this.frO, this.frV);
        this.faU.addHeaderView(this.frV, 0);
    }

    private void b(x xVar) {
        if (this.fpL == null) {
            this.fpL = new BannerView(this.frO.getPageContext().getPageActivity());
            this.fpL.setLayoutParams(new AbsListView.LayoutParams(-1, this.frO.getResources().getDimensionPixelSize(d.e.ds100)));
            this.fpL.setVisibility(8);
            this.fpL.setBannerViewClickListener(this.fpR);
            this.fpL.setBannerData(xVar);
            this.fpL.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void L(String str, boolean z) {
                    if (z && g.this.fpL.aka() && !g.this.fpN && g.this.faU != null) {
                        g.this.fpN = true;
                        g.this.faU.addHeaderView(g.this.fpL, 1);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bhi() {
        if (this.ccy != null) {
            String value = this.ccy.getValue();
            if (this.ccy.Xo() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.frO.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ccy.Xo() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.frO.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.frO.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ccy.Xo() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bLE != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bLE) {
                        case FRS:
                            this.frO.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.frO.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.frO.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.frO.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.adD().c(this.frO.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.frO.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.ccy.Xo() == 4) {
                this.frO.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.frO.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.faU.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.frU.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.frU.onDestory();
        this.faU.setOnSrollToBottomListener(null);
    }

    public void fB(boolean z) {
        if (!z) {
            this.dcE.setRefreshing(false);
        }
    }

    public void aOA() {
        this.faU.setVisibility(0);
    }

    public void bdx() {
        if (this.frU != null) {
            this.frU.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<m> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<m> arrayList2;
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
            ArrayList<m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(f, 0);
                if (frsViewData != null && this.frO.bhV() != null && frsTabInfo != null) {
                    this.frO.bhV().rc(frsTabInfo.tab_id.intValue());
                }
            } else if (this.frW != null && frsViewData.getForum() != null) {
                this.frW.setData(f, this.frO.bhV().bhP());
                this.frW.setFid(frsViewData.getForum().getId());
            }
        }
        this.frU.b(arrayList2, frsViewData);
    }

    private List<FrsTabInfo> f(FrsViewData frsViewData) {
        int i;
        Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            FrsTabInfo next = it.next();
            if (next.tab_id.intValue() == 503) {
                i = next.tab_type.intValue();
                break;
            }
        }
        if (i == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().menu) {
            if (frsTabInfo.tab_type.intValue() == i) {
                arrayList.add(frsTabInfo);
            }
        }
        return arrayList;
    }

    public BdTypeRecyclerView getListView() {
        return this.faU;
    }

    public void bhj() {
        this.frU.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.faU.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fpN && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ccy = forumData.getFrsBannerData();
            b(this.ccy);
            this.fpL.reset();
            this.faU.removeHeaderView(this.fpL);
            if (this.ccy.getType() == 1 && !TextUtils.isEmpty(this.ccy.Xp())) {
                this.fpL.setData(this.frO.getPageContext(), this.ccy.Xp());
                if (this.ccy.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.frO.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bhk() {
        if (this.fpL != null) {
            this.fpN = false;
            this.faU.removeHeaderView(this.fpL);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.frU != null) {
            this.frU.bfF();
            this.frU.notifyDataSetChanged();
            this.frU.onChangeSkinType(i);
        }
        this.frO.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.frO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMu);
        if (this.fpL != null) {
            this.fpL.akb();
        }
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
            this.dbr.ic(i);
        }
        al.l(this.dcE, d.C0236d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        this.dcE.setRefreshing(true);
    }

    public f bhX() {
        return this.frU;
    }

    public RelativeLayout bdL() {
        return this.cMu;
    }

    public View beK() {
        return this.dcE;
    }

    public void bdN() {
        if (com.baidu.tbadk.o.m.apl().apm()) {
            int lastVisiblePosition = this.faU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faU.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fbT != null) {
                        com.baidu.tbadk.o.h perfLog = oVar.fbT.getPerfLog();
                        perfLog.jX(1000);
                        perfLog.cqm = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fbT.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fbT.startLogPerf();
                    }
                    if (oVar.fbS != null && (oVar.fbS instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fbS;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.jX(1000);
                                perfLog2.cqm = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCu() {
        this.faU.setNextPage(this.dbr);
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeC();
    }

    public void aCv() {
        this.faU.setNextPage(this.dbr);
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeD();
        this.dbr.setText(this.frO.getResources().getString(d.j.list_has_no_more));
    }

    public void aCw() {
        this.faU.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhB.setVisibility(z ? 0 : 8);
    }

    public void bcd() {
        this.faU.smoothScrollToPosition(0);
    }
}
