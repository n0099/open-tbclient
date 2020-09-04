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
    private FrameLayout dBv;
    private ad eFE;
    private PbListView fEa;
    private RelativeLayout ibY;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a ibZ;
    private FrsNewAreaFragment ipo;
    private f ipu;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hVD = null;
    private BannerView inh = null;
    private boolean inj = false;
    private boolean hVK = true;
    private BannerView.a inm = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpJ() {
            g.this.crm();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpK() {
            g.this.cro();
        }
    };
    private CustomMessageListener hUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.ipu.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bv) {
                            bv bvVar = (bv) qVar;
                            if (bvVar.eaT != 0 && bvVar.dUW != null) {
                                int[] imageWidthAndHeight = bvVar.dUW.getImageWidthAndHeight();
                                bvVar.eaT = imageWidthAndHeight[0];
                                bvVar.eaU = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.ipu.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener inn = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.IO(str);
                g.this.IN(str);
                g.this.ipu.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.ipo = null;
        this.ipo = frsNewAreaFragment;
        ca(view);
    }

    public void refreshView() {
        this.ipu.notifyDataSetChanged();
    }

    public void oE(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 503;
        adVar.esz = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void os(boolean z) {
        this.hVK = z;
        if (z) {
            this.fEa.setText(this.ipo.getResources().getString(R.string.load_more));
            if (this.hVD.getChildAt(this.hVD.getChildCount() - 1) == this.fEa.getView()) {
                this.fEa.startLoadData();
                this.ipo.bFE();
                return;
            }
            this.fEa.endLoadData();
            return;
        }
        this.fEa.setText(this.ipo.getResources().getString(R.string.load_more_must_after_delete));
        this.fEa.endLoadData();
    }

    public boolean cno() {
        if (this.hVK) {
            return false;
        }
        this.fEa.setText(this.ipo.getResources().getString(R.string.load_more_must_after_delete));
        this.fEa.endLoadData();
        return true;
    }

    private void ca(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.hVD = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hVD.setLayoutManager(new LinearLayoutManager(this.hVD.getContext()));
        this.hVD.setFadingEdgeLength(0);
        this.hVD.setOverScrollMode(2);
        this.hVD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.fEa = new PbListView(this.ipo.getPageContext().getPageActivity());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(com.baidu.adp.lib.util.l.getDimens(this.ipo.getActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hVD.setOnSrollToBottomListener(this.ipo);
        this.dBv = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.ipu = new f(this.ipo, this.hVD);
        kh(false);
        this.ibY = new RelativeLayout(this.ipo.getContext());
        this.ibY.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ibZ = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.ipo, this.ibY);
        this.ipo.registerListener(this.hUK);
        this.ipo.registerListener(this.inn);
    }

    private void b(ad adVar) {
        if (this.inh == null) {
            this.inh = new BannerView(this.ipo.getPageContext().getPageActivity());
            this.inh.setLayoutParams(new AbsListView.LayoutParams(-1, this.ipo.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.inh.setVisibility(8);
            this.inh.setBannerViewClickListener(this.inm);
            this.inh.setBannerData(adVar);
            this.inh.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.inh.bpH() && !g.this.inj && g.this.hVD != null) {
                        g.this.inj = true;
                        g.this.hVD.addHeaderView(g.this.inh, 1);
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
    public void crm() {
        if (this.eFE != null) {
            String value = this.eFE.getValue();
            if (this.eFE.bcQ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.ipo.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eFE.bcQ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.ipo.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.ipo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eFE.bcQ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.elt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.elt) {
                        case FRS:
                            this.ipo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ipo.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.ipo.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.ipo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bju().b(this.ipo.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.ipo.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eFE.bcQ() == 4) {
                this.ipo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ipo.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hVD.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.ipu.a(abVar);
    }

    public void onDestroy() {
        this.ipu.onDestory();
        this.hVD.setOnSrollToBottomListener(null);
    }

    public void kh(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 503;
            vVar.fkC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void coF() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fkC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bLt() {
        this.hVD.setVisibility(0);
    }

    public void cnf() {
        if (this.ipu != null) {
            this.ipu.notifyDataSetChanged();
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
                if (this.ibY != null) {
                    this.hVD.removeHeaderView(this.ibY);
                }
            } else if (this.ibY != null) {
                this.hVD.removeHeaderView(this.ibY);
                this.hVD.addHeaderView(this.ibY, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.ipo.csj() != null && frsTabInfo != null) {
                    this.ipo.csj().yp(frsTabInfo.tab_id.intValue());
                }
            } else if (this.ibZ != null && frsViewData.getForum() != null) {
                this.ibZ.setData(f);
                this.ibZ.setFid(frsViewData.getForum().getId());
            }
        }
        this.ipu.b(arrayList2, frsViewData);
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
        return this.hVD;
    }

    public void crn() {
        this.ipu.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hVD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.inj && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eFE = forumData.getFrsBannerData();
            b(this.eFE);
            this.inh.reset();
            this.hVD.removeHeaderView(this.inh);
            if (this.eFE.getType() == 1 && !TextUtils.isEmpty(this.eFE.bcR())) {
                this.inh.setData(this.ipo.getPageContext(), this.eFE.bcR());
                if (this.eFE.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.ipo.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cro() {
        if (this.inh != null) {
            this.inj = false;
            this.hVD.removeHeaderView(this.inh);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ipu != null) {
            this.ipu.cpN();
            this.ipu.notifyDataSetChanged();
            this.ipu.onChangeSkinType(i);
        }
        this.ipo.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ipo.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.inh != null) {
            this.inh.bpI();
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
        this.ibZ.onChangeSkinType();
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fkC = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public f csl() {
        return this.ipu;
    }

    public RelativeLayout bZc() {
        return this.mContainer;
    }

    public void cnu() {
        if (com.baidu.tbadk.n.m.buo().bup()) {
            int lastVisiblePosition = this.hVD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hVD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.hWA != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.hWA.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eRM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.hWA.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.hWA.startLogPerf();
                    }
                    if (uVar.hWz != null && (uVar.hWz instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.hWz;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eRM = true;
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
    public void bGS() {
        this.hVD.setNextPage(this.fEa);
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.startLoadData();
    }

    public void bGT() {
        this.hVD.setNextPage(this.fEa);
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.endLoadData();
        this.fEa.setText(this.ipo.getResources().getString(R.string.list_has_no_more));
    }

    public void bGU() {
        this.hVD.setNextPage(null);
    }

    public void oF(boolean z) {
        this.dBv.setVisibility(z ? 0 : 8);
    }

    public void clA() {
        this.hVD.smoothScrollToPosition(0);
    }

    public void IN(String str) {
        if (this.ipo.crj() != null) {
            this.ipo.crj().IP(str);
        }
    }

    public void IO(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.ipu.getDataList())) {
            Iterator<q> it = this.ipu.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bzp() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bzp()).dWj)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
