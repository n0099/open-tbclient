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
    private FrameLayout bhC;
    private x ccy;
    private PbListView dbn;
    private BdSwipeRefreshLayout dcA;
    private FrsNewAreaFragment frN;
    private f frT;
    private RelativeLayout frU;
    private com.baidu.tieba.frs.entelechy.c.a.a frV;
    private RelativeLayout cMr = null;
    private BdTypeRecyclerView faT = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fpK = null;
    private boolean fpM = false;
    private boolean fbb = true;
    private BannerView.a fpQ = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void akb() {
            g.this.bhi();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void akc() {
            g.this.bhk();
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.frN = null;
        this.frN = frsNewAreaFragment;
        bD(view);
    }

    public void refreshView() {
        this.frT.notifyDataSetChanged();
    }

    public void jg(boolean z) {
        this.dcA.setEnabled(z);
    }

    public void jh(boolean z) {
        this.fbb = z;
        if (z) {
            this.dbn.setText(this.frN.getResources().getString(d.j.load_more));
            if (this.faT.getChildAt(this.faT.getChildCount() - 1) == this.dbn.getView()) {
                this.dbn.aeC();
                this.frN.aBc();
                return;
            }
            this.dbn.aeD();
            return;
        }
        this.dbn.setText(this.frN.getResources().getString(d.j.load_more_must_after_delete));
        this.dbn.aeD();
    }

    public boolean bdG() {
        if (this.fbb) {
            return false;
        }
        this.dbn.setText(this.frN.getResources().getString(d.j.load_more_must_after_delete));
        this.dbn.aeD();
        return true;
    }

    private void bD(View view) {
        this.cMr = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        this.faT = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.faT.setLayoutManager(new LinearLayoutManager(this.faT.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.frN.getPageContext());
        this.faT.setFadingEdgeLength(0);
        this.faT.setOverScrollMode(2);
        this.faT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.dbn = new PbListView(this.frN.getPageContext().getPageActivity());
        this.dbn.oM();
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.setHeight(com.baidu.adp.lib.util.l.h(this.frN.getActivity(), d.e.tbds182));
        this.dbn.aez();
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.faT.setOnSrollToBottomListener(this.frN);
        if (this.dcA == null) {
            this.dcA = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.dcA.setProgressView(this.mPullView);
            al.l(this.dcA, d.C0277d.cp_bg_line_e);
        }
        this.bhC = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.frT = new f(this.frN, this.faT);
        fB(false);
        this.frU = new RelativeLayout(this.frN.getContext());
        this.frU.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.frV = new com.baidu.tieba.frs.entelechy.c.a.a(this.frN, this.frU);
        this.faT.addHeaderView(this.frU, 0);
    }

    private void b(x xVar) {
        if (this.fpK == null) {
            this.fpK = new BannerView(this.frN.getPageContext().getPageActivity());
            this.fpK.setLayoutParams(new AbsListView.LayoutParams(-1, this.frN.getResources().getDimensionPixelSize(d.e.ds100)));
            this.fpK.setVisibility(8);
            this.fpK.setBannerViewClickListener(this.fpQ);
            this.fpK.setBannerData(xVar);
            this.fpK.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void L(String str, boolean z) {
                    if (z && g.this.fpK.ajZ() && !g.this.fpM && g.this.faT != null) {
                        g.this.fpM = true;
                        g.this.faT.addHeaderView(g.this.fpK, 1);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.frN.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ccy.Xo() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.frN.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.frN.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ccy.Xo() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bLF != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bLF) {
                        case FRS:
                            this.frN.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.frN.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.frN.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.frN.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.adD().c(this.frN.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.frN.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.ccy.Xo() == 4) {
                this.frN.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.frN.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.faT.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.frT.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.frT.onDestory();
        this.faT.setOnSrollToBottomListener(null);
    }

    public void fB(boolean z) {
        if (!z) {
            this.dcA.setRefreshing(false);
        }
    }

    public void aOA() {
        this.faT.setVisibility(0);
    }

    public void bdx() {
        if (this.frT != null) {
            this.frT.notifyDataSetChanged();
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
                if (frsViewData != null && this.frN.bhV() != null && frsTabInfo != null) {
                    this.frN.bhV().rc(frsTabInfo.tab_id.intValue());
                }
            } else if (this.frV != null && frsViewData.getForum() != null) {
                this.frV.setData(f, this.frN.bhV().bhP());
                this.frV.setFid(frsViewData.getForum().getId());
            }
        }
        this.frT.b(arrayList2, frsViewData);
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
        return this.faT;
    }

    public void bhj() {
        this.frT.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.faT.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fpM && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ccy = forumData.getFrsBannerData();
            b(this.ccy);
            this.fpK.reset();
            this.faT.removeHeaderView(this.fpK);
            if (this.ccy.getType() == 1 && !TextUtils.isEmpty(this.ccy.Xp())) {
                this.fpK.setData(this.frN.getPageContext(), this.ccy.Xp());
                if (this.ccy.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.frN.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bhk() {
        if (this.fpK != null) {
            this.fpM = false;
            this.faT.removeHeaderView(this.fpK);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.frT != null) {
            this.frT.bfF();
            this.frT.notifyDataSetChanged();
            this.frT.onChangeSkinType(i);
        }
        this.frN.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.frN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMr);
        if (this.fpK != null) {
            this.fpK.aka();
        }
        if (this.dbn != null) {
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbn.ic(i);
        }
        al.l(this.dcA, d.C0277d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        this.dcA.setRefreshing(true);
    }

    public f bhX() {
        return this.frT;
    }

    public RelativeLayout bdL() {
        return this.cMr;
    }

    public View beK() {
        return this.dcA;
    }

    public void bdN() {
        if (com.baidu.tbadk.o.m.apk().apl()) {
            int lastVisiblePosition = this.faT.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faT.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fbS != null) {
                        com.baidu.tbadk.o.h perfLog = oVar.fbS.getPerfLog();
                        perfLog.jX(1000);
                        perfLog.cqm = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fbS.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fbS.startLogPerf();
                    }
                    if (oVar.fbR != null && (oVar.fbR instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fbR;
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
        this.faT.setNextPage(this.dbn);
        this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbn.aeC();
    }

    public void aCv() {
        this.faT.setNextPage(this.dbn);
        this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbn.aeD();
        this.dbn.setText(this.frN.getResources().getString(d.j.list_has_no_more));
    }

    public void aCw() {
        this.faT.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhC.setVisibility(z ? 0 : 8);
    }

    public void bcd() {
        this.faT.smoothScrollToPosition(0);
    }
}
