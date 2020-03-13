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
/* loaded from: classes9.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout cww;
    private y dru;
    private PbListView elw;
    private BdSwipeRefreshLayout enH;
    private FrsNewAreaFragment gHQ;
    private f gHW;
    private RelativeLayout gHX;
    private com.baidu.tieba.frs.entelechy.c.a.a gHY;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gqy = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private BannerView gFI = null;
    private boolean gFK = false;
    private boolean gqG = true;
    private BannerView.a gFM = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMD() {
            g.this.bIH();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aME() {
            g.this.bIJ();
        }
    };
    private CustomMessageListener gpW = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.gHW.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bi) {
                            bi biVar = (bi) mVar;
                            if (biVar.cRh != 0 && biVar.cRg != null) {
                                int[] imageWidthAndHeight = biVar.cRg.getImageWidthAndHeight();
                                biVar.cRh = imageWidthAndHeight[0];
                                biVar.cRi = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gHW.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener gFN = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.BC(str);
                g.this.BB(str);
                g.this.gHW.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.gHQ = null;
        this.gHQ = frsNewAreaFragment;
        bJ(view);
    }

    public void refreshView() {
        this.gHW.notifyDataSetChanged();
    }

    public void lr(boolean z) {
        this.enH.setEnabled(z);
    }

    public void ls(boolean z) {
        this.gqG = z;
        if (z) {
            this.elw.setText(this.gHQ.getResources().getString(R.string.load_more));
            if (this.gqy.getChildAt(this.gqy.getChildCount() - 1) == this.elw.getView()) {
                this.elw.startLoadData();
                this.gHQ.bcg();
                return;
            }
            this.elw.endLoadData();
            return;
        }
        this.elw.setText(this.gHQ.getResources().getString(R.string.load_more_must_after_delete));
        this.elw.endLoadData();
    }

    public boolean bFc() {
        if (this.gqG) {
            return false;
        }
        this.elw.setText(this.gHQ.getResources().getString(R.string.load_more_must_after_delete));
        this.elw.endLoadData();
        return true;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.gqy = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gqy.setLayoutManager(new LinearLayoutManager(this.gqy.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.h(this.gHQ.getPageContext());
        this.gqy.setFadingEdgeLength(0);
        this.gqy.setOverScrollMode(2);
        this.gqy.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.elw = new PbListView(this.gHQ.getPageContext().getPageActivity());
        this.elw.createView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gHQ.getActivity(), R.dimen.tbds182));
        this.elw.setLineGone();
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gqy.setOnSrollToBottomListener(this.gHQ);
        if (this.enH == null) {
            this.enH = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.enH.setProgressView(this.mPullView);
            am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
        }
        this.cww = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gHW = new f(this.gHQ, this.gqy);
        hu(false);
        this.gHX = new RelativeLayout(this.gHQ.getContext());
        this.gHX.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gHY = new com.baidu.tieba.frs.entelechy.c.a.a(this.gHQ, this.gHX);
        this.gqy.addHeaderView(this.gHX, 0);
        this.gHQ.registerListener(this.gpW);
        this.gHQ.registerListener(this.gFN);
    }

    private void b(y yVar) {
        if (this.gFI == null) {
            this.gFI = new BannerView(this.gHQ.getPageContext().getPageActivity());
            this.gFI.setLayoutParams(new AbsListView.LayoutParams(-1, this.gHQ.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gFI.setVisibility(8);
            this.gFI.setBannerViewClickListener(this.gFM);
            this.gFI.setBannerData(yVar);
            this.gFI.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.gFI.aMB() && !g.this.gFK && g.this.gqy != null) {
                        g.this.gFK = true;
                        g.this.gqy.addHeaderView(g.this.gFI, 1);
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
    public void bIH() {
        if (this.dru != null) {
            String value = this.dru.getValue();
            if (this.dru.aAH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gHQ.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dru.aAH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gHQ.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gHQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dru.aAH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daI) {
                        case FRS:
                            this.gHQ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gHQ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gHQ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gHQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aGG().b(this.gHQ.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gHQ.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dru.aAH() == 4) {
                this.gHQ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gHQ.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.gqy.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gHW.a(sVar);
    }

    public void onDestroy() {
        this.gHW.onDestory();
        this.gqy.setOnSrollToBottomListener(null);
    }

    public void hu(boolean z) {
        if (!z) {
            this.enH.setRefreshing(false);
        }
    }

    public void bgz() {
        this.gqy.setVisibility(0);
    }

    public void bEU() {
        if (this.gHW != null) {
            this.gHW.notifyDataSetChanged();
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
                if (frsViewData != null && this.gHQ.bJx() != null && frsTabInfo != null) {
                    this.gHQ.bJx().tN(frsTabInfo.tab_id.intValue());
                }
            } else if (this.gHY != null && frsViewData.getForum() != null) {
                this.gHY.setData(f, this.gHQ.bJx().bJq());
                this.gHY.setFid(frsViewData.getForum().getId());
            }
        }
        this.gHW.b(arrayList2, frsViewData);
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
        return this.gqy;
    }

    public void bII() {
        this.gHW.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gqy.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gFK && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dru = forumData.getFrsBannerData();
            b(this.dru);
            this.gFI.reset();
            this.gqy.removeHeaderView(this.gFI);
            if (this.dru.getType() == 1 && !TextUtils.isEmpty(this.dru.aAI())) {
                this.gFI.setData(this.gHQ.getPageContext(), this.dru.aAI());
                if (this.dru.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gHQ.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bIJ() {
        if (this.gFI != null) {
            this.gFK = false;
            this.gqy.removeHeaderView(this.gFI);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gHW != null) {
            this.gHW.bHg();
            this.gHW.notifyDataSetChanged();
            this.gHW.onChangeSkinType(i);
        }
        this.gHQ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gHQ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gFI != null) {
            this.gFI.aMC();
        }
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.changeSkin(i);
        }
        am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
        this.gHY.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.enH.setRefreshing(true);
    }

    public f bJz() {
        return this.gHW;
    }

    public RelativeLayout bsF() {
        return this.mContainer;
    }

    public View bGg() {
        return this.enH;
    }

    public void bFi() {
        if (com.baidu.tbadk.n.m.aRm().aRn()) {
            int lastVisiblePosition = this.gqy.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gqy.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grw != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grw.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grw.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grw.startLogPerf();
                    }
                    if (pVar.grv != null && (pVar.grv instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.grv;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDI = true;
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
    public void bds() {
        this.gqy.setNextPage(this.elw);
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.startLoadData();
    }

    public void bdt() {
        this.gqy.setNextPage(this.elw);
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.endLoadData();
        this.elw.setText(this.gHQ.getResources().getString(R.string.list_has_no_more));
    }

    public void bdu() {
        this.gqy.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cww.setVisibility(z ? 0 : 8);
    }

    public void scrollToTop() {
        this.gqy.smoothScrollToPosition(0);
    }

    public void BB(String str) {
        if (this.gHQ.bIE() != null) {
            this.gHQ.bIE().BD(str);
        }
    }

    public void BC(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gHW.getDataList())) {
            Iterator<m> it = this.gHW.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aVx() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVx()).cMX)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
