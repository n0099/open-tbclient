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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout edL;
    private ad fig;
    private PbListView gjo;
    private RelativeLayout iQs;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a iQt;
    private FrsNewAreaFragment jdQ;
    private f jdW;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView iJX = null;
    private BannerView jbK = null;
    private boolean jbM = false;
    private boolean iKe = true;
    private BannerView.a jbP = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bxF() {
            g.this.cDG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bxG() {
            g.this.cDI();
        }
    };
    private CustomMessageListener iJe = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.jdW.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bv) {
                            bv bvVar = (bv) qVar;
                            if (bvVar.eDx != 0 && bvVar.exA != null) {
                                int[] imageWidthAndHeight = bvVar.exA.getImageWidthAndHeight();
                                bvVar.eDx = imageWidthAndHeight[0];
                                bvVar.eDy = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jdW.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jbQ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.KP(str);
                g.this.KO(str);
                g.this.jdW.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jdQ = null;
        this.jdQ = frsNewAreaFragment;
        cw(view);
    }

    public void refreshView() {
        this.jdW.notifyDataSetChanged();
    }

    public void pQ(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 503;
        adVar.eUZ = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void pE(boolean z) {
        this.iKe = z;
        if (z) {
            this.gjo.setText(this.jdQ.getResources().getString(R.string.load_more));
            if (this.iJX.getChildAt(this.iJX.getChildCount() - 1) == this.gjo.getView()) {
                this.gjo.startLoadData();
                this.jdQ.bOI();
                return;
            }
            this.gjo.endLoadData();
            return;
        }
        this.gjo.setText(this.jdQ.getResources().getString(R.string.load_more_must_after_delete));
        this.gjo.endLoadData();
    }

    public boolean czG() {
        if (this.iKe) {
            return false;
        }
        this.gjo.setText(this.jdQ.getResources().getString(R.string.load_more_must_after_delete));
        this.gjo.endLoadData();
        return true;
    }

    private void cw(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.iJX = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.iJX.setLayoutManager(new LinearLayoutManager(this.iJX.getContext()));
        this.iJX.setFadingEdgeLength(0);
        this.iJX.setOverScrollMode(2);
        this.iJX.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.gjo = new PbListView(this.jdQ.getPageContext().getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jdQ.getActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iJX.setOnSrollToBottomListener(this.jdQ);
        this.edL = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jdW = new f(this.jdQ, this.iJX);
        lc(false);
        this.iQs = new RelativeLayout(this.jdQ.getContext());
        this.iQs.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iQt = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jdQ, this.iQs);
        this.jdQ.registerListener(this.iJe);
        this.jdQ.registerListener(this.jbQ);
    }

    private void b(ad adVar) {
        if (this.jbK == null) {
            this.jbK = new BannerView(this.jdQ.getPageContext().getPageActivity());
            this.jbK.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdQ.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jbK.setVisibility(8);
            this.jbK.setBannerViewClickListener(this.jbP);
            this.jbK.setBannerData(adVar);
            this.jbK.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jbK.bxD() && !g.this.jbM && g.this.iJX != null) {
                        g.this.jbM = true;
                        g.this.iJX.addHeaderView(g.this.jbK, 1);
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
    public void cDG() {
        if (this.fig != null) {
            String value = this.fig.getValue();
            if (this.fig.bkM() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jdQ.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fig.bkM() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jdQ.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jdQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fig.bkM() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eOe != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eOe) {
                        case FRS:
                            this.jdQ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jdQ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jdQ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jdQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.brr().b(this.jdQ.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jdQ.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fig.bkM() == 4) {
                this.jdQ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jdQ.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iJX.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.jdW.a(abVar);
    }

    public void onDestroy() {
        this.jdW.onDestory();
        this.iJX.setOnSrollToBottomListener(null);
    }

    public void lc(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 503;
            vVar.fNU = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cAY() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fNU = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bVq() {
        this.iJX.setVisibility(0);
    }

    public void czx() {
        if (this.jdW != null) {
            this.jdW.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<q> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<q> arrayList2;
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            s sVar = new s();
            ArrayList<q> arrayList3 = new ArrayList<>();
            arrayList3.add(sVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (y.isEmpty(f)) {
                if (this.iQs != null) {
                    this.iJX.removeHeaderView(this.iQs);
                }
            } else if (this.iQs != null) {
                this.iJX.removeHeaderView(this.iQs);
                this.iJX.addHeaderView(this.iQs, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.jdQ.cED() != null && frsTabInfo != null) {
                    this.jdQ.cED().Aa(frsTabInfo.tab_id.intValue());
                }
            } else if (this.iQt != null && frsViewData.getForum() != null) {
                this.iQt.setData(f);
                this.iQt.setFid(frsViewData.getForum().getId());
            }
        }
        this.jdW.b(arrayList2, frsViewData);
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
        return this.iJX;
    }

    public void cDH() {
        this.jdW.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.iJX.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jbM && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fig = forumData.getFrsBannerData();
            b(this.fig);
            this.jbK.reset();
            this.iJX.removeHeaderView(this.jbK);
            if (this.fig.getType() == 1 && !TextUtils.isEmpty(this.fig.bkN())) {
                this.jbK.setData(this.jdQ.getPageContext(), this.fig.bkN());
                if (this.fig.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jdQ.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cDI() {
        if (this.jbK != null) {
            this.jbM = false;
            this.iJX.removeHeaderView(this.jbK);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jdW != null) {
            this.jdW.cCf();
            this.jdW.notifyDataSetChanged();
            this.jdW.onChangeSkinType(i);
        }
        this.jdQ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jdQ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jbK != null) {
            this.jbK.bxE();
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        this.iQt.onChangeSkinType();
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fNU = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public f cEF() {
        return this.jdW;
    }

    public RelativeLayout cka() {
        return this.mContainer;
    }

    public void czM() {
        if (com.baidu.tbadk.n.m.bCu().bCv()) {
            int lastVisiblePosition = this.iJX.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iJX.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.iKU != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.iKU.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fvf = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.iKU.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.iKU.startLogPerf();
                    }
                    if (uVar.iKT != null && (uVar.iKT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.iKT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fvf = true;
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
    public void Wi() {
        this.iJX.setNextPage(this.gjo);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.startLoadData();
    }

    public void Wj() {
        this.iJX.setNextPage(this.gjo);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.endLoadData();
        this.gjo.setText(this.jdQ.getResources().getString(R.string.list_has_no_more));
    }

    public void bPW() {
        this.iJX.setNextPage(null);
    }

    public void pR(boolean z) {
        this.edL.setVisibility(z ? 0 : 8);
    }

    public void cxS() {
        this.iJX.smoothScrollToPosition(0);
    }

    public void KO(String str) {
        if (this.jdQ.cDD() != null) {
            this.jdQ.cDD().KQ(str);
        }
    }

    public void KP(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jdW.getDataList())) {
            Iterator<q> it = this.jdW.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bHC() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bHC()).eyO)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
