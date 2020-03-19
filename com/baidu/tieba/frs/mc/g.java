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
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.q;
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
    private FrameLayout cwH;
    private y drH;
    private PbListView elM;
    private BdSwipeRefreshLayout enY;
    private FrsNewAreaFragment gIR;
    private f gIX;
    private RelativeLayout gwG;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a gwH;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gri = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private BannerView gGG = null;
    private boolean gGI = false;
    private boolean grq = true;
    private BannerView.a gGK = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMH() {
            g.this.bIT();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMI() {
            g.this.bIV();
        }
    };
    private CustomMessageListener gqG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.m> dataList = g.this.gIX.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                        if (mVar instanceof bi) {
                            bi biVar = (bi) mVar;
                            if (biVar.cRu != 0 && biVar.cRt != null) {
                                int[] imageWidthAndHeight = biVar.cRt.getImageWidthAndHeight();
                                biVar.cRu = imageWidthAndHeight[0];
                                biVar.cRv = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gIX.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener gGL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.BC(str);
                g.this.BB(str);
                g.this.gIX.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.gIR = null;
        this.gIR = frsNewAreaFragment;
        bJ(view);
    }

    public void refreshView() {
        this.gIX.notifyDataSetChanged();
    }

    public void lx(boolean z) {
        this.enY.setEnabled(z);
    }

    public void ly(boolean z) {
        this.grq = z;
        if (z) {
            this.elM.setText(this.gIR.getResources().getString(R.string.load_more));
            if (this.gri.getChildAt(this.gri.getChildCount() - 1) == this.elM.getView()) {
                this.elM.startLoadData();
                this.gIR.bck();
                return;
            }
            this.elM.endLoadData();
            return;
        }
        this.elM.setText(this.gIR.getResources().getString(R.string.load_more_must_after_delete));
        this.elM.endLoadData();
    }

    public boolean bFm() {
        if (this.grq) {
            return false;
        }
        this.elM.setText(this.gIR.getResources().getString(R.string.load_more_must_after_delete));
        this.elM.endLoadData();
        return true;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.gri = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gri.setLayoutManager(new LinearLayoutManager(this.gri.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.h(this.gIR.getPageContext());
        this.gri.setFadingEdgeLength(0);
        this.gri.setOverScrollMode(2);
        this.gri.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.elM = new PbListView(this.gIR.getPageContext().getPageActivity());
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gIR.getActivity(), R.dimen.tbds182));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gri.setOnSrollToBottomListener(this.gIR);
        if (this.enY == null) {
            this.enY = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.enY.setProgressView(this.mPullView);
            am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
        }
        this.cwH = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gIX = new f(this.gIR, this.gri);
        hv(false);
        this.gwG = new RelativeLayout(this.gIR.getContext());
        this.gwG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gwH = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.gIR, this.gwG);
        this.gIR.registerListener(this.gqG);
        this.gIR.registerListener(this.gGL);
    }

    private void b(y yVar) {
        if (this.gGG == null) {
            this.gGG = new BannerView(this.gIR.getPageContext().getPageActivity());
            this.gGG.setLayoutParams(new AbsListView.LayoutParams(-1, this.gIR.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gGG.setVisibility(8);
            this.gGG.setBannerViewClickListener(this.gGK);
            this.gGG.setBannerData(yVar);
            this.gGG.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.gGG.aMF() && !g.this.gGI && g.this.gri != null) {
                        g.this.gGI = true;
                        g.this.gri.addHeaderView(g.this.gGG, 1);
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
    public void bIT() {
        if (this.drH != null) {
            String value = this.drH.getValue();
            if (this.drH.aAK() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gIR.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.drH.aAK() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gIR.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gIR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drH.aAK() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daV != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daV) {
                        case FRS:
                            this.gIR.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gIR.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gIR.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gIR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aGK().b(this.gIR.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gIR.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.drH.aAK() == 4) {
                this.gIR.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gIR.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.gri.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gIX.a(sVar);
    }

    public void onDestroy() {
        this.gIX.onDestory();
        this.gri.setOnSrollToBottomListener(null);
    }

    public void hv(boolean z) {
        if (!z) {
            this.enY.setRefreshing(false);
        }
    }

    public void bGr() {
        if (this.enY != null) {
            this.enY.interruptRefresh();
        }
    }

    public void bgE() {
        this.gri.setVisibility(0);
    }

    public void bFe() {
        if (this.gIX != null) {
            this.gIX.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            o oVar = new o();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(oVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (v.isEmpty(f)) {
                if (this.gwG != null) {
                    this.gri.removeHeaderView(this.gwG);
                }
            } else if (this.gwG != null) {
                this.gri.removeHeaderView(this.gwG);
                this.gri.addHeaderView(this.gwG, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) v.getItem(f, 0);
                if (frsViewData != null && this.gIR.bJK() != null && frsTabInfo != null) {
                    this.gIR.bJK().tT(frsTabInfo.tab_id.intValue());
                }
            } else if (this.gwH != null && frsViewData.getForum() != null) {
                this.gwH.setData(f);
                this.gwH.setFid(frsViewData.getForum().getId());
            }
        }
        this.gIX.b(arrayList2, frsViewData);
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
        return this.gri;
    }

    public void bIU() {
        this.gIX.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gri.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gGI && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.drH = forumData.getFrsBannerData();
            b(this.drH);
            this.gGG.reset();
            this.gri.removeHeaderView(this.gGG);
            if (this.drH.getType() == 1 && !TextUtils.isEmpty(this.drH.aAL())) {
                this.gGG.setData(this.gIR.getPageContext(), this.drH.aAL());
                if (this.drH.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gIR.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bIV() {
        if (this.gGG != null) {
            this.gGI = false;
            this.gri.removeHeaderView(this.gGG);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gIX != null) {
            this.gIX.bHv();
            this.gIX.notifyDataSetChanged();
            this.gIX.onChangeSkinType(i);
        }
        this.gIR.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gIR.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gGG != null) {
            this.gGG.aMG();
        }
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.changeSkin(i);
        }
        am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
        this.gwH.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.enY.setRefreshing(true);
    }

    public f bJM() {
        return this.gIX;
    }

    public RelativeLayout bsL() {
        return this.mContainer;
    }

    public View bGs() {
        return this.enY;
    }

    public void bFs() {
        if (com.baidu.tbadk.n.m.aRq().aRr()) {
            int lastVisiblePosition = this.gri.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gri.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof q)) {
                    q qVar = (q) childAt.getTag();
                    if (qVar.gsg != null) {
                        com.baidu.tbadk.n.h perfLog = qVar.gsg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDW = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            qVar.gsg.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        qVar.gsg.startLogPerf();
                    }
                    if (qVar.gsf != null && (qVar.gsf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = qVar.gsf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDW = true;
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
    public void bdx() {
        this.gri.setNextPage(this.elM);
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.startLoadData();
    }

    public void bdy() {
        this.gri.setNextPage(this.elM);
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.endLoadData();
        this.elM.setText(this.gIR.getResources().getString(R.string.list_has_no_more));
    }

    public void bdz() {
        this.gri.setNextPage(null);
    }

    public void lK(boolean z) {
        this.cwH.setVisibility(z ? 0 : 8);
    }

    public void scrollToTop() {
        this.gri.smoothScrollToPosition(0);
    }

    public void BB(String str) {
        if (this.gIR.bIQ() != null) {
            this.gIR.bIQ().BD(str);
        }
    }

    public void BC(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gIX.getDataList())) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gIX.getDataList().iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aVB() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVB()).cNk)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
