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
    private FrameLayout dXU;
    private ad fco;
    private PbListView gdy;
    private RelativeLayout iKv;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a iKw;
    private FrsNewAreaFragment iXT;
    private f iXZ;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView iEa = null;
    private BannerView iVN = null;
    private boolean iVP = false;
    private boolean iEh = true;
    private BannerView.a iVS = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bvg() {
            g.this.cBf();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bvh() {
            g.this.cBh();
        }
    };
    private CustomMessageListener iDh = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.iXZ.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bv) {
                            bv bvVar = (bv) qVar;
                            if (bvVar.exG != 0 && bvVar.erH != null) {
                                int[] imageWidthAndHeight = bvVar.erH.getImageWidthAndHeight();
                                bvVar.exG = imageWidthAndHeight[0];
                                bvVar.exH = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.iXZ.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener iVT = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Ky(str);
                g.this.Kx(str);
                g.this.iXZ.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.iXT = null;
        this.iXT = frsNewAreaFragment;
        cr(view);
    }

    public void refreshView() {
        this.iXZ.notifyDataSetChanged();
    }

    public void pH(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 503;
        adVar.ePk = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void pv(boolean z) {
        this.iEh = z;
        if (z) {
            this.gdy.setText(this.iXT.getResources().getString(R.string.load_more));
            if (this.iEa.getChildAt(this.iEa.getChildCount() - 1) == this.gdy.getView()) {
                this.gdy.startLoadData();
                this.iXT.bMi();
                return;
            }
            this.gdy.endLoadData();
            return;
        }
        this.gdy.setText(this.iXT.getResources().getString(R.string.load_more_must_after_delete));
        this.gdy.endLoadData();
    }

    public boolean cxf() {
        if (this.iEh) {
            return false;
        }
        this.gdy.setText(this.iXT.getResources().getString(R.string.load_more_must_after_delete));
        this.gdy.endLoadData();
        return true;
    }

    private void cr(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.iEa = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.iEa.setLayoutManager(new LinearLayoutManager(this.iEa.getContext()));
        this.iEa.setFadingEdgeLength(0);
        this.iEa.setOverScrollMode(2);
        this.iEa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.gdy = new PbListView(this.iXT.getPageContext().getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iXT.getActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iEa.setOnSrollToBottomListener(this.iXT);
        this.dXU = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.iXZ = new f(this.iXT, this.iEa);
        kT(false);
        this.iKv = new RelativeLayout(this.iXT.getContext());
        this.iKv.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iKw = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.iXT, this.iKv);
        this.iXT.registerListener(this.iDh);
        this.iXT.registerListener(this.iVT);
    }

    private void b(ad adVar) {
        if (this.iVN == null) {
            this.iVN = new BannerView(this.iXT.getPageContext().getPageActivity());
            this.iVN.setLayoutParams(new AbsListView.LayoutParams(-1, this.iXT.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.iVN.setVisibility(8);
            this.iVN.setBannerViewClickListener(this.iVS);
            this.iVN.setBannerData(adVar);
            this.iVN.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.iVN.bve() && !g.this.iVP && g.this.iEa != null) {
                        g.this.iVP = true;
                        g.this.iEa.addHeaderView(g.this.iVN, 1);
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
    public void cBf() {
        if (this.fco != null) {
            String value = this.fco.getValue();
            if (this.fco.bim() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.iXT.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fco.bim() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.iXT.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.iXT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fco.bim() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eIp != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eIp) {
                        case FRS:
                            this.iXT.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iXT.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.iXT.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.iXT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.boR().b(this.iXT.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iXT.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fco.bim() == 4) {
                this.iXT.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iXT.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iEa.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.iXZ.a(abVar);
    }

    public void onDestroy() {
        this.iXZ.onDestory();
        this.iEa.setOnSrollToBottomListener(null);
    }

    public void kT(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 503;
            vVar.fIe = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cyx() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fIe = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bSR() {
        this.iEa.setVisibility(0);
    }

    public void cwW() {
        if (this.iXZ != null) {
            this.iXZ.notifyDataSetChanged();
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
                if (this.iKv != null) {
                    this.iEa.removeHeaderView(this.iKv);
                }
            } else if (this.iKv != null) {
                this.iEa.removeHeaderView(this.iKv);
                this.iEa.addHeaderView(this.iKv, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.iXT.cCc() != null && frsTabInfo != null) {
                    this.iXT.cCc().zN(frsTabInfo.tab_id.intValue());
                }
            } else if (this.iKw != null && frsViewData.getForum() != null) {
                this.iKw.setData(f);
                this.iKw.setFid(frsViewData.getForum().getId());
            }
        }
        this.iXZ.b(arrayList2, frsViewData);
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
        return this.iEa;
    }

    public void cBg() {
        this.iXZ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.iEa.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.iVP && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fco = forumData.getFrsBannerData();
            b(this.fco);
            this.iVN.reset();
            this.iEa.removeHeaderView(this.iVN);
            if (this.fco.getType() == 1 && !TextUtils.isEmpty(this.fco.bin())) {
                this.iVN.setData(this.iXT.getPageContext(), this.fco.bin());
                if (this.fco.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iXT.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cBh() {
        if (this.iVN != null) {
            this.iVP = false;
            this.iEa.removeHeaderView(this.iVN);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iXZ != null) {
            this.iXZ.czE();
            this.iXZ.notifyDataSetChanged();
            this.iXZ.onChangeSkinType(i);
        }
        this.iXT.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iXT.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.iVN != null) {
            this.iVN.bvf();
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        this.iKw.onChangeSkinType();
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fIe = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public f cCe() {
        return this.iXZ;
    }

    public RelativeLayout chy() {
        return this.mContainer;
    }

    public void cxl() {
        if (com.baidu.tbadk.n.m.bzV().bzW()) {
            int lastVisiblePosition = this.iEa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iEa.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.iEX != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.iEX.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fpk = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.iEX.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.iEX.startLogPerf();
                    }
                    if (uVar.iEW != null && (uVar.iEW instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.iEW;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fpk = true;
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
    public void TI() {
        this.iEa.setNextPage(this.gdy);
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.startLoadData();
    }

    public void TJ() {
        this.iEa.setNextPage(this.gdy);
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.endLoadData();
        this.gdy.setText(this.iXT.getResources().getString(R.string.list_has_no_more));
    }

    public void bNw() {
        this.iEa.setNextPage(null);
    }

    public void pI(boolean z) {
        this.dXU.setVisibility(z ? 0 : 8);
    }

    public void cvr() {
        this.iEa.smoothScrollToPosition(0);
    }

    public void Kx(String str) {
        if (this.iXT.cBc() != null) {
            this.iXT.cBc().Kz(str);
        }
    }

    public void Ky(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.iXZ.getDataList())) {
            Iterator<q> it = this.iXZ.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bFd() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bFd()).esU)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
