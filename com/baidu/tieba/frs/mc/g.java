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
/* loaded from: classes16.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout dBr;
    private ad eFA;
    private PbListView fDW;
    private RelativeLayout ibS;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a ibT;
    private FrsNewAreaFragment ipi;
    private f ipo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hVx = null;
    private BannerView inb = null;
    private boolean ind = false;
    private boolean hVE = true;
    private BannerView.a ing = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpI() {
            g.this.crl();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpJ() {
            g.this.crn();
        }
    };
    private CustomMessageListener hUE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.ipo.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bv) {
                            bv bvVar = (bv) qVar;
                            if (bvVar.eaP != 0 && bvVar.dUS != null) {
                                int[] imageWidthAndHeight = bvVar.dUS.getImageWidthAndHeight();
                                bvVar.eaP = imageWidthAndHeight[0];
                                bvVar.eaQ = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.ipo.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener inh = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.IN(str);
                g.this.IM(str);
                g.this.ipo.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.ipi = null;
        this.ipi = frsNewAreaFragment;
        ca(view);
    }

    public void refreshView() {
        this.ipo.notifyDataSetChanged();
    }

    public void oC(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 503;
        adVar.esv = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void oq(boolean z) {
        this.hVE = z;
        if (z) {
            this.fDW.setText(this.ipi.getResources().getString(R.string.load_more));
            if (this.hVx.getChildAt(this.hVx.getChildCount() - 1) == this.fDW.getView()) {
                this.fDW.startLoadData();
                this.ipi.bFD();
                return;
            }
            this.fDW.endLoadData();
            return;
        }
        this.fDW.setText(this.ipi.getResources().getString(R.string.load_more_must_after_delete));
        this.fDW.endLoadData();
    }

    public boolean cnn() {
        if (this.hVE) {
            return false;
        }
        this.fDW.setText(this.ipi.getResources().getString(R.string.load_more_must_after_delete));
        this.fDW.endLoadData();
        return true;
    }

    private void ca(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.hVx = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hVx.setLayoutManager(new LinearLayoutManager(this.hVx.getContext()));
        this.hVx.setFadingEdgeLength(0);
        this.hVx.setOverScrollMode(2);
        this.hVx.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.fDW = new PbListView(this.ipi.getPageContext().getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(com.baidu.adp.lib.util.l.getDimens(this.ipi.getActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hVx.setOnSrollToBottomListener(this.ipi);
        this.dBr = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.ipo = new f(this.ipi, this.hVx);
        kf(false);
        this.ibS = new RelativeLayout(this.ipi.getContext());
        this.ibS.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ibT = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.ipi, this.ibS);
        this.ipi.registerListener(this.hUE);
        this.ipi.registerListener(this.inh);
    }

    private void b(ad adVar) {
        if (this.inb == null) {
            this.inb = new BannerView(this.ipi.getPageContext().getPageActivity());
            this.inb.setLayoutParams(new AbsListView.LayoutParams(-1, this.ipi.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.inb.setVisibility(8);
            this.inb.setBannerViewClickListener(this.ing);
            this.inb.setBannerData(adVar);
            this.inb.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.inb.bpG() && !g.this.ind && g.this.hVx != null) {
                        g.this.ind = true;
                        g.this.hVx.addHeaderView(g.this.inb, 1);
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
    public void crl() {
        if (this.eFA != null) {
            String value = this.eFA.getValue();
            if (this.eFA.bcQ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.ipi.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eFA.bcQ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.ipi.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.ipi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eFA.bcQ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.elp != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.elp) {
                        case FRS:
                            this.ipi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ipi.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.ipi.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.ipi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bju().b(this.ipi.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.ipi.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eFA.bcQ() == 4) {
                this.ipi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ipi.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hVx.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.ipo.a(abVar);
    }

    public void onDestroy() {
        this.ipo.onDestory();
        this.hVx.setOnSrollToBottomListener(null);
    }

    public void kf(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 503;
            vVar.fky = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void coE() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fky = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bLs() {
        this.hVx.setVisibility(0);
    }

    public void cne() {
        if (this.ipo != null) {
            this.ipo.notifyDataSetChanged();
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
                if (this.ibS != null) {
                    this.hVx.removeHeaderView(this.ibS);
                }
            } else if (this.ibS != null) {
                this.hVx.removeHeaderView(this.ibS);
                this.hVx.addHeaderView(this.ibS, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.ipi.csi() != null && frsTabInfo != null) {
                    this.ipi.csi().yp(frsTabInfo.tab_id.intValue());
                }
            } else if (this.ibT != null && frsViewData.getForum() != null) {
                this.ibT.setData(f);
                this.ibT.setFid(frsViewData.getForum().getId());
            }
        }
        this.ipo.b(arrayList2, frsViewData);
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
        return this.hVx;
    }

    public void crm() {
        this.ipo.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hVx.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.ind && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eFA = forumData.getFrsBannerData();
            b(this.eFA);
            this.inb.reset();
            this.hVx.removeHeaderView(this.inb);
            if (this.eFA.getType() == 1 && !TextUtils.isEmpty(this.eFA.bcR())) {
                this.inb.setData(this.ipi.getPageContext(), this.eFA.bcR());
                if (this.eFA.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.ipi.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void crn() {
        if (this.inb != null) {
            this.ind = false;
            this.hVx.removeHeaderView(this.inb);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ipo != null) {
            this.ipo.cpM();
            this.ipo.notifyDataSetChanged();
            this.ipo.onChangeSkinType(i);
        }
        this.ipi.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ipi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.inb != null) {
            this.inb.bpH();
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        this.ibT.onChangeSkinType();
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fky = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public f csk() {
        return this.ipo;
    }

    public RelativeLayout bZb() {
        return this.mContainer;
    }

    public void cnt() {
        if (com.baidu.tbadk.n.m.bun().buo()) {
            int lastVisiblePosition = this.hVx.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hVx.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.hWu != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.hWu.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eRI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.hWu.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.hWu.startLogPerf();
                    }
                    if (uVar.hWt != null && (uVar.hWt instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.hWt;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eRI = true;
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
    public void bGR() {
        this.hVx.setNextPage(this.fDW);
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.startLoadData();
    }

    public void bGS() {
        this.hVx.setNextPage(this.fDW);
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.endLoadData();
        this.fDW.setText(this.ipi.getResources().getString(R.string.list_has_no_more));
    }

    public void bGT() {
        this.hVx.setNextPage(null);
    }

    public void oD(boolean z) {
        this.dBr.setVisibility(z ? 0 : 8);
    }

    public void clz() {
        this.hVx.smoothScrollToPosition(0);
    }

    public void IM(String str) {
        if (this.ipi.cri() != null) {
            this.ipi.cri().IO(str);
        }
    }

    public void IN(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.ipo.getDataList())) {
            Iterator<q> it = this.ipo.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bzo() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bzo()).dWf)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
