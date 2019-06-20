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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bf;
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
import com.baidu.tieba.R;
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
    private FrameLayout bnL;
    private x ckG;
    private PbListView dlY;
    private BdSwipeRefreshLayout dni;
    private FrsNewAreaFragment fHW;
    private f fIc;
    private RelativeLayout fId;
    private com.baidu.tieba.frs.entelechy.c.a.a fIe;
    private RelativeLayout cUH = null;
    private BdTypeRecyclerView fqV = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fFT = null;
    private boolean fFV = false;
    private boolean frd = true;
    private BannerView.a fFZ = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aoZ() {
            g.this.boD();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void apa() {
            g.this.boF();
        }
    };
    private CustomMessageListener fqu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.fIc.getDataList();
            if (!v.aa(dataList)) {
                if (!v.aa(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bf) {
                            bf bfVar = (bf) mVar;
                            if (bfVar.bIg != 0 && bfVar.threadData != null) {
                                int[] afo = bfVar.threadData.afo();
                                bfVar.bIg = afo[0];
                                bfVar.bIh = afo[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fIc.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener fGa = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.wP(str);
                g.this.wO(str);
                g.this.fIc.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.fHW = null;
        this.fHW = frsNewAreaFragment;
        bK(view);
    }

    public void refreshView() {
        this.fIc.notifyDataSetChanged();
    }

    public void jQ(boolean z) {
        this.dni.setEnabled(z);
    }

    public void jR(boolean z) {
        this.frd = z;
        if (z) {
            this.dlY.setText(this.fHW.getResources().getString(R.string.load_more));
            if (this.fqV.getChildAt(this.fqV.getChildCount() - 1) == this.dlY.getView()) {
                this.dlY.ajy();
                this.fHW.aHt();
                return;
            }
            this.dlY.ajz();
            return;
        }
        this.dlY.setText(this.fHW.getResources().getString(R.string.load_more_must_after_delete));
        this.dlY.ajz();
    }

    public boolean bkY() {
        if (this.frd) {
            return false;
        }
        this.dlY.setText(this.fHW.getResources().getString(R.string.load_more_must_after_delete));
        this.dlY.ajz();
        return true;
    }

    private void bK(View view) {
        this.cUH = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.fqV = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fqV.setLayoutManager(new LinearLayoutManager(this.fqV.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.fHW.getPageContext());
        this.fqV.setFadingEdgeLength(0);
        this.fqV.setOverScrollMode(2);
        this.fqV.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.dlY = new PbListView(this.fHW.getPageContext().getPageActivity());
        this.dlY.nG();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.setHeight(com.baidu.adp.lib.util.l.g(this.fHW.getActivity(), R.dimen.tbds182));
        this.dlY.ajv();
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.iN(R.color.cp_cont_e);
        this.fqV.setOnSrollToBottomListener(this.fHW);
        if (this.dni == null) {
            this.dni = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dni.setProgressView(this.mPullView);
            al.l(this.dni, R.color.cp_bg_line_e);
        }
        this.bnL = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fIc = new f(this.fHW, this.fqV);
        fY(false);
        this.fId = new RelativeLayout(this.fHW.getContext());
        this.fId.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fIe = new com.baidu.tieba.frs.entelechy.c.a.a(this.fHW, this.fId);
        this.fqV.addHeaderView(this.fId, 0);
        this.fHW.registerListener(this.fqu);
        this.fHW.registerListener(this.fGa);
    }

    private void b(x xVar) {
        if (this.fFT == null) {
            this.fFT = new BannerView(this.fHW.getPageContext().getPageActivity());
            this.fFT.setLayoutParams(new AbsListView.LayoutParams(-1, this.fHW.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fFT.setVisibility(8);
            this.fFT.setBannerViewClickListener(this.fFZ);
            this.fFT.setBannerData(xVar);
            this.fFT.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void O(String str, boolean z) {
                    if (z && g.this.fFT.aoX() && !g.this.fFV && g.this.fqV != null) {
                        g.this.fFV = true;
                        g.this.fqV.addHeaderView(g.this.fFT, 1);
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
    public void boD() {
        if (this.ckG != null) {
            String value = this.ckG.getValue();
            if (this.ckG.abT() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fHW.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ckG.abT() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fHW.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fHW.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ckG.abT() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bTu != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bTu) {
                        case FRS:
                            this.fHW.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fHW.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fHW.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fHW.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aiz().c(this.fHW.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fHW.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.ckG.abT() == 4) {
                this.fHW.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fHW.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fqV.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fIc.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fIc.onDestory();
        this.fqV.setOnSrollToBottomListener(null);
    }

    public void fY(boolean z) {
        if (!z) {
            this.dni.setRefreshing(false);
        }
    }

    public void aUH() {
        this.fqV.setVisibility(0);
    }

    public void bkQ() {
        if (this.fIc != null) {
            this.fIc.notifyDataSetChanged();
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
                if (frsViewData != null && this.fHW.bpr() != null && frsTabInfo != null) {
                    this.fHW.bpr().sg(frsTabInfo.tab_id.intValue());
                }
            } else if (this.fIe != null && frsViewData.getForum() != null) {
                this.fIe.setData(f, this.fHW.bpr().bpl());
                this.fIe.setFid(frsViewData.getForum().getId());
            }
        }
        this.fIc.b(arrayList2, frsViewData);
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
        return this.fqV;
    }

    public void boE() {
        this.fIc.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fqV.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fFV && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ckG = forumData.getFrsBannerData();
            b(this.ckG);
            this.fFT.reset();
            this.fqV.removeHeaderView(this.fFT);
            if (this.ckG.getType() == 1 && !TextUtils.isEmpty(this.ckG.abU())) {
                this.fFT.setData(this.fHW.getPageContext(), this.ckG.abU());
                if (this.ckG.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fHW.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void boF() {
        if (this.fFT != null) {
            this.fFV = false;
            this.fqV.removeHeaderView(this.fFT);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.fIc != null) {
            this.fIc.bmZ();
            this.fIc.notifyDataSetChanged();
            this.fIc.onChangeSkinType(i);
        }
        this.fHW.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fHW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cUH);
        if (this.fFT != null) {
            this.fFT.aoY();
        }
        if (this.dlY != null) {
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlY.iP(i);
        }
        al.l(this.dni, R.color.cp_bg_line_e);
        this.fIe.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.dni.setRefreshing(true);
    }

    public f bpt() {
        return this.fIc;
    }

    public RelativeLayout bld() {
        return this.cUH;
    }

    public View bmd() {
        return this.dni;
    }

    public void blf() {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            int lastVisiblePosition = this.fqV.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fqV.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.frV != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.frV.getPerfLog();
                        perfLog.kK(1000);
                        perfLog.cyw = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.frV.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.frV.startLogPerf();
                    }
                    if (oVar.frU != null && (oVar.frU instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.frU;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kK(1000);
                                perfLog2.cyw = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
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
    public void aIH() {
        this.fqV.setNextPage(this.dlY);
        this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlY.ajy();
    }

    public void aII() {
        this.fqV.setNextPage(this.dlY);
        this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlY.ajz();
        this.dlY.setText(this.fHW.getResources().getString(R.string.list_has_no_more));
    }

    public void aIJ() {
        this.fqV.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bnL.setVisibility(z ? 0 : 8);
    }

    public void bjy() {
        this.fqV.smoothScrollToPosition(0);
    }

    public void wO(String str) {
        if (this.fHW.boA() != null) {
            this.fHW.boA().wQ(str);
        }
    }

    public void wP(String str) {
        if (!StringUtils.isNull(str) && !v.aa(this.fIc.getDataList())) {
            Iterator<m> it = this.fIc.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.azj() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.azj()).bDT)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
