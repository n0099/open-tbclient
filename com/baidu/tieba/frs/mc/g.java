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
    private FrameLayout bhF;
    private x ccA;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private f frF;
    private RelativeLayout frG;
    private com.baidu.tieba.frs.entelechy.c.a.a frH;
    private FrsNewAreaFragment frz;
    private RelativeLayout cMt = null;
    private BdTypeRecyclerView faG = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fpw = null;
    private boolean fpy = false;
    private boolean faO = true;
    private BannerView.a fpC = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void ajY() {
            g.this.bhg();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void ajZ() {
            g.this.bhi();
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.frz = null;
        this.frz = frsNewAreaFragment;
        bD(view);
    }

    public void refreshView() {
        this.frF.notifyDataSetChanged();
    }

    public void jg(boolean z) {
        this.dcE.setEnabled(z);
    }

    public void jh(boolean z) {
        this.faO = z;
        if (z) {
            this.dbr.setText(this.frz.getResources().getString(d.j.load_more));
            if (this.faG.getChildAt(this.faG.getChildCount() - 1) == this.dbr.getView()) {
                this.dbr.aez();
                this.frz.aAZ();
                return;
            }
            this.dbr.aeA();
            return;
        }
        this.dbr.setText(this.frz.getResources().getString(d.j.load_more_must_after_delete));
        this.dbr.aeA();
    }

    public boolean bdE() {
        if (this.faO) {
            return false;
        }
        this.dbr.setText(this.frz.getResources().getString(d.j.load_more_must_after_delete));
        this.dbr.aeA();
        return true;
    }

    private void bD(View view) {
        this.cMt = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        this.faG = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.faG.setLayoutManager(new LinearLayoutManager(this.faG.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.frz.getPageContext());
        this.faG.setFadingEdgeLength(0);
        this.faG.setOverScrollMode(2);
        this.faG.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.dbr = new PbListView(this.frz.getPageContext().getPageActivity());
        this.dbr.oM();
        this.dbr.ia(d.C0277d.cp_bg_line_e);
        this.dbr.setHeight(com.baidu.adp.lib.util.l.h(this.frz.getActivity(), d.e.tbds182));
        this.dbr.aew();
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbr.hZ(d.C0277d.cp_cont_e);
        this.faG.setOnSrollToBottomListener(this.frz);
        if (this.dcE == null) {
            this.dcE = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.dcE.setProgressView(this.mPullView);
            al.l(this.dcE, d.C0277d.cp_bg_line_e);
        }
        this.bhF = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.frF = new f(this.frz, this.faG);
        fB(false);
        this.frG = new RelativeLayout(this.frz.getContext());
        this.frG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.frH = new com.baidu.tieba.frs.entelechy.c.a.a(this.frz, this.frG);
        this.faG.addHeaderView(this.frG, 0);
    }

    private void b(x xVar) {
        if (this.fpw == null) {
            this.fpw = new BannerView(this.frz.getPageContext().getPageActivity());
            this.fpw.setLayoutParams(new AbsListView.LayoutParams(-1, this.frz.getResources().getDimensionPixelSize(d.e.ds100)));
            this.fpw.setVisibility(8);
            this.fpw.setBannerViewClickListener(this.fpC);
            this.fpw.setBannerData(xVar);
            this.fpw.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void L(String str, boolean z) {
                    if (z && g.this.fpw.ajW() && !g.this.fpy && g.this.faG != null) {
                        g.this.fpy = true;
                        g.this.faG.addHeaderView(g.this.fpw, 1);
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
    public void bhg() {
        if (this.ccA != null) {
            String value = this.ccA.getValue();
            if (this.ccA.Xl() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.frz.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ccA.Xl() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.frz.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.frz.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ccA.Xl() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bLH != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bLH) {
                        case FRS:
                            this.frz.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.frz.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.frz.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.frz.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.adA().c(this.frz.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.frz.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.ccA.Xl() == 4) {
                this.frz.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.frz.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.faG.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.frF.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.frF.onDestory();
        this.faG.setOnSrollToBottomListener(null);
    }

    public void fB(boolean z) {
        if (!z) {
            this.dcE.setRefreshing(false);
        }
    }

    public void aOs() {
        this.faG.setVisibility(0);
    }

    public void bdv() {
        if (this.frF != null) {
            this.frF.notifyDataSetChanged();
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
                if (frsViewData != null && this.frz.bhT() != null && frsTabInfo != null) {
                    this.frz.bhT().qY(frsTabInfo.tab_id.intValue());
                }
            } else if (this.frH != null && frsViewData.getForum() != null) {
                this.frH.setData(f, this.frz.bhT().bhN());
                this.frH.setFid(frsViewData.getForum().getId());
            }
        }
        this.frF.b(arrayList2, frsViewData);
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
        return this.faG;
    }

    public void bhh() {
        this.frF.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.faG.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fpy && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ccA = forumData.getFrsBannerData();
            b(this.ccA);
            this.fpw.reset();
            this.faG.removeHeaderView(this.fpw);
            if (this.ccA.getType() == 1 && !TextUtils.isEmpty(this.ccA.Xm())) {
                this.fpw.setData(this.frz.getPageContext(), this.ccA.Xm());
                if (this.ccA.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.frz.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bhi() {
        if (this.fpw != null) {
            this.fpy = false;
            this.faG.removeHeaderView(this.fpw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.frF != null) {
            this.frF.bfD();
            this.frF.notifyDataSetChanged();
            this.frF.onChangeSkinType(i);
        }
        this.frz.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.frz.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMt);
        if (this.fpw != null) {
            this.fpw.ajX();
        }
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbr.ib(i);
        }
        al.l(this.dcE, d.C0277d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        this.dcE.setRefreshing(true);
    }

    public f bhV() {
        return this.frF;
    }

    public RelativeLayout bdJ() {
        return this.cMt;
    }

    public View beI() {
        return this.dcE;
    }

    public void bdL() {
        if (com.baidu.tbadk.o.m.apg().aph()) {
            int lastVisiblePosition = this.faG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faG.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fbF != null) {
                        com.baidu.tbadk.o.h perfLog = oVar.fbF.getPerfLog();
                        perfLog.jW(1000);
                        perfLog.cqo = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fbF.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fbF.startLogPerf();
                    }
                    if (oVar.fbE != null && (oVar.fbE instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fbE;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.jW(1000);
                                perfLog2.cqo = true;
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
    public void aCr() {
        this.faG.setNextPage(this.dbr);
        this.dbr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aez();
    }

    public void aCs() {
        this.faG.setNextPage(this.dbr);
        this.dbr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeA();
        this.dbr.setText(this.frz.getResources().getString(d.j.list_has_no_more));
    }

    public void aCt() {
        this.faG.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhF.setVisibility(z ? 0 : 8);
    }

    public void bcb() {
        this.faG.smoothScrollToPosition(0);
    }
}
