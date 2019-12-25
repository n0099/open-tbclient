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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout csh;
    private y dmI;
    private PbListView egU;
    private BdSwipeRefreshLayout eiv;
    private FrsNewAreaFragment gCo;
    private f gCu;
    private RelativeLayout gCv;
    private com.baidu.tieba.frs.entelechy.c.a.a gCw;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gkZ = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private BannerView gAl = null;
    private boolean gAn = false;
    private boolean glh = true;
    private BannerView.a gAp = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aJK() {
            g.this.bGb();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aJL() {
            g.this.bGd();
        }
    };
    private CustomMessageListener gkx = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.gCu.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bi) {
                            bi biVar = (bi) mVar;
                            if (biVar.cMS != 0 && biVar.cMR != null) {
                                int[] imageWidthAndHeight = biVar.cMR.getImageWidthAndHeight();
                                biVar.cMS = imageWidthAndHeight[0];
                                biVar.cMT = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gCu.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener gAq = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Bb(str);
                g.this.Ba(str);
                g.this.gCu.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.gCo = null;
        this.gCo = frsNewAreaFragment;
        bE(view);
    }

    public void refreshView() {
        this.gCu.notifyDataSetChanged();
    }

    public void ld(boolean z) {
        this.eiv.setEnabled(z);
    }

    public void le(boolean z) {
        this.glh = z;
        if (z) {
            this.egU.setText(this.gCo.getResources().getString(R.string.load_more));
            if (this.gkZ.getChildAt(this.gkZ.getChildCount() - 1) == this.egU.getView()) {
                this.egU.startLoadData();
                this.gCo.aZs();
                return;
            }
            this.egU.endLoadData();
            return;
        }
        this.egU.setText(this.gCo.getResources().getString(R.string.load_more_must_after_delete));
        this.egU.endLoadData();
    }

    public boolean bCu() {
        if (this.glh) {
            return false;
        }
        this.egU.setText(this.gCo.getResources().getString(R.string.load_more_must_after_delete));
        this.egU.endLoadData();
        return true;
    }

    private void bE(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.gkZ = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gkZ.setLayoutManager(new LinearLayoutManager(this.gkZ.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.h(this.gCo.getPageContext());
        this.gkZ.setFadingEdgeLength(0);
        this.gkZ.setOverScrollMode(2);
        this.gkZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.egU = new PbListView(this.gCo.getPageContext().getPageActivity());
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gCo.getActivity(), R.dimen.tbds182));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gkZ.setOnSrollToBottomListener(this.gCo);
        if (this.eiv == null) {
            this.eiv = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.eiv.setProgressView(this.mPullView);
            am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
        }
        this.csh = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gCu = new f(this.gCo, this.gkZ);
        hi(false);
        this.gCv = new RelativeLayout(this.gCo.getContext());
        this.gCv.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gCw = new com.baidu.tieba.frs.entelechy.c.a.a(this.gCo, this.gCv);
        this.gkZ.addHeaderView(this.gCv, 0);
        this.gCo.registerListener(this.gkx);
        this.gCo.registerListener(this.gAq);
    }

    private void b(y yVar) {
        if (this.gAl == null) {
            this.gAl = new BannerView(this.gCo.getPageContext().getPageActivity());
            this.gAl.setLayoutParams(new AbsListView.LayoutParams(-1, this.gCo.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gAl.setVisibility(8);
            this.gAl.setBannerViewClickListener(this.gAp);
            this.gAl.setBannerData(yVar);
            this.gAl.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.gAl.aJI() && !g.this.gAn && g.this.gkZ != null) {
                        g.this.gAn = true;
                        g.this.gkZ.addHeaderView(g.this.gAl, 1);
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
    public void bGb() {
        if (this.dmI != null) {
            String value = this.dmI.getValue();
            if (this.dmI.axY() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gCo.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dmI.axY() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gCo.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gCo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dmI.axY() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cWt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cWt) {
                        case FRS:
                            this.gCo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gCo.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gCo.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gCo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aEa().b(this.gCo.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gCo.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dmI.axY() == 4) {
                this.gCo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gCo.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.gkZ.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gCu.a(sVar);
    }

    public void onDestroy() {
        this.gCu.onDestory();
        this.gkZ.setOnSrollToBottomListener(null);
    }

    public void hi(boolean z) {
        if (!z) {
            this.eiv.setRefreshing(false);
        }
    }

    public void bdR() {
        this.gkZ.setVisibility(0);
    }

    public void bCm() {
        if (this.gCu != null) {
            this.gCu.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<m> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<m> arrayList2;
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            n nVar = new n();
            ArrayList<m> arrayList3 = new ArrayList<>();
            arrayList3.add(nVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) v.getItem(f, 0);
                if (frsViewData != null && this.gCo.bGQ() != null && frsTabInfo != null) {
                    this.gCo.bGQ().tC(frsTabInfo.tab_id.intValue());
                }
            } else if (this.gCw != null && frsViewData.getForum() != null) {
                this.gCw.setData(f, this.gCo.bGQ().bGJ());
                this.gCw.setFid(frsViewData.getForum().getId());
            }
        }
        this.gCu.b(arrayList2, frsViewData);
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
        return this.gkZ;
    }

    public void bGc() {
        this.gCu.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gkZ.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gAn && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dmI = forumData.getFrsBannerData();
            b(this.dmI);
            this.gAl.reset();
            this.gkZ.removeHeaderView(this.gAl);
            if (this.dmI.getType() == 1 && !TextUtils.isEmpty(this.dmI.axZ())) {
                this.gAl.setData(this.gCo.getPageContext(), this.dmI.axZ());
                if (this.dmI.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gCo.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bGd() {
        if (this.gAl != null) {
            this.gAn = false;
            this.gkZ.removeHeaderView(this.gAl);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCu != null) {
            this.gCu.bEz();
            this.gCu.notifyDataSetChanged();
            this.gCu.onChangeSkinType(i);
        }
        this.gCo.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gCo.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gAl != null) {
            this.gAl.aJJ();
        }
        if (this.egU != null) {
            this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
            this.egU.changeSkin(i);
        }
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
        this.gCw.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.eiv.setRefreshing(true);
    }

    public f bGS() {
        return this.gCu;
    }

    public RelativeLayout bpX() {
        return this.mContainer;
    }

    public View bDz() {
        return this.eiv;
    }

    public void bCA() {
        if (com.baidu.tbadk.n.m.aOA().aOB()) {
            int lastVisiblePosition = this.gkZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gkZ.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.glX != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.glX.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dzk = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.glX.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.glX.startLogPerf();
                    }
                    if (pVar.glW != null && (pVar.glW instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.glW;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dzk = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
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
    public void baF() {
        this.gkZ.setNextPage(this.egU);
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.startLoadData();
    }

    public void baG() {
        this.gkZ.setNextPage(this.egU);
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.endLoadData();
        this.egU.setText(this.gCo.getResources().getString(R.string.list_has_no_more));
    }

    public void baH() {
        this.gkZ.setNextPage(null);
    }

    public void lr(boolean z) {
        this.csh.setVisibility(z ? 0 : 8);
    }

    public void scrollToTop() {
        this.gkZ.smoothScrollToPosition(0);
    }

    public void Ba(String str) {
        if (this.gCo.bFY() != null) {
            this.gCo.bFY().Bc(str);
        }
    }

    public void Bb(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gCu.getDataList())) {
            Iterator<m> it = this.gCu.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aSJ() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aSJ()).cIG)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
