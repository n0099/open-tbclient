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
    private FrameLayout dPx;
    private ad eTS;
    private PbListView fTv;
    private f iLD;
    private FrsNewAreaFragment iLx;
    private RelativeLayout ixZ;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a iya;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView irE = null;
    private BannerView iJr = null;
    private boolean iJt = false;
    private boolean irL = true;
    private BannerView.a iJw = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void btn() {
            g.this.cxY();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bto() {
            g.this.cya();
        }
    };
    private CustomMessageListener iqL = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.iLD.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bv) {
                            bv bvVar = (bv) qVar;
                            if (bvVar.epi != 0 && bvVar.eji != null) {
                                int[] imageWidthAndHeight = bvVar.eji.getImageWidthAndHeight();
                                bvVar.epi = imageWidthAndHeight[0];
                                bvVar.epj = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.iLD.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener iJx = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.JZ(str);
                g.this.JY(str);
                g.this.iLD.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.iLx = null;
        this.iLx = frsNewAreaFragment;
        cn(view);
    }

    public void refreshView() {
        this.iLD.notifyDataSetChanged();
    }

    public void pp(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 503;
        adVar.eGO = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void pd(boolean z) {
        this.irL = z;
        if (z) {
            this.fTv.setText(this.iLx.getResources().getString(R.string.load_more));
            if (this.irE.getChildAt(this.irE.getChildCount() - 1) == this.fTv.getView()) {
                this.fTv.startLoadData();
                this.iLx.bJG();
                return;
            }
            this.fTv.endLoadData();
            return;
        }
        this.fTv.setText(this.iLx.getResources().getString(R.string.load_more_must_after_delete));
        this.fTv.endLoadData();
    }

    public boolean ctY() {
        if (this.irL) {
            return false;
        }
        this.fTv.setText(this.iLx.getResources().getString(R.string.load_more_must_after_delete));
        this.fTv.endLoadData();
        return true;
    }

    private void cn(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.irE = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.irE.setLayoutManager(new LinearLayoutManager(this.irE.getContext()));
        this.irE.setFadingEdgeLength(0);
        this.irE.setOverScrollMode(2);
        this.irE.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.fTv = new PbListView(this.iLx.getPageContext().getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iLx.getActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.irE.setOnSrollToBottomListener(this.iLx);
        this.dPx = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.iLD = new f(this.iLx, this.irE);
        kG(false);
        this.ixZ = new RelativeLayout(this.iLx.getContext());
        this.ixZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iya = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.iLx, this.ixZ);
        this.iLx.registerListener(this.iqL);
        this.iLx.registerListener(this.iJx);
    }

    private void b(ad adVar) {
        if (this.iJr == null) {
            this.iJr = new BannerView(this.iLx.getPageContext().getPageActivity());
            this.iJr.setLayoutParams(new AbsListView.LayoutParams(-1, this.iLx.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.iJr.setVisibility(8);
            this.iJr.setBannerViewClickListener(this.iJw);
            this.iJr.setBannerData(adVar);
            this.iJr.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.iJr.btl() && !g.this.iJt && g.this.irE != null) {
                        g.this.iJt = true;
                        g.this.irE.addHeaderView(g.this.iJr, 1);
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
    public void cxY() {
        if (this.eTS != null) {
            String value = this.eTS.getValue();
            if (this.eTS.bgt() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.iLx.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eTS.bgt() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.iLx.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.iLx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eTS.bgt() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ezT != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ezT) {
                        case FRS:
                            this.iLx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iLx.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.iLx.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.iLx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bmY().b(this.iLx.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iLx.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eTS.bgt() == 4) {
                this.iLx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iLx.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.irE.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.iLD.a(abVar);
    }

    public void onDestroy() {
        this.iLD.onDestory();
        this.irE.setOnSrollToBottomListener(null);
    }

    public void kG(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 503;
            vVar.fzJ = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cvq() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fzJ = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bPU() {
        this.irE.setVisibility(0);
    }

    public void ctP() {
        if (this.iLD != null) {
            this.iLD.notifyDataSetChanged();
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
                if (this.ixZ != null) {
                    this.irE.removeHeaderView(this.ixZ);
                }
            } else if (this.ixZ != null) {
                this.irE.removeHeaderView(this.ixZ);
                this.irE.addHeaderView(this.ixZ, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.iLx.cyV() != null && frsTabInfo != null) {
                    this.iLx.cyV().zu(frsTabInfo.tab_id.intValue());
                }
            } else if (this.iya != null && frsViewData.getForum() != null) {
                this.iya.setData(f);
                this.iya.setFid(frsViewData.getForum().getId());
            }
        }
        this.iLD.b(arrayList2, frsViewData);
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
        return this.irE;
    }

    public void cxZ() {
        this.iLD.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.irE.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.iJt && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eTS = forumData.getFrsBannerData();
            b(this.eTS);
            this.iJr.reset();
            this.irE.removeHeaderView(this.iJr);
            if (this.eTS.getType() == 1 && !TextUtils.isEmpty(this.eTS.bgu())) {
                this.iJr.setData(this.iLx.getPageContext(), this.eTS.bgu());
                if (this.eTS.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iLx.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cya() {
        if (this.iJr != null) {
            this.iJt = false;
            this.irE.removeHeaderView(this.iJr);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLD != null) {
            this.iLD.cwx();
            this.iLD.notifyDataSetChanged();
            this.iLD.onChangeSkinType(i);
        }
        this.iLx.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iLx.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.iJr != null) {
            this.iJr.btm();
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
        this.iya.onChangeSkinType();
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fzJ = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public f cyX() {
        return this.iLD;
    }

    public RelativeLayout cew() {
        return this.mContainer;
    }

    public void cue() {
        if (com.baidu.tbadk.n.m.byc().byd()) {
            int lastVisiblePosition = this.irE.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.irE.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isB != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.isB.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fgL = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.isB.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.isB.startLogPerf();
                    }
                    if (uVar.isA != null && (uVar.isA instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.isA;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fgL = true;
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
    public void SI() {
        this.irE.setNextPage(this.fTv);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.startLoadData();
    }

    public void SJ() {
        this.irE.setNextPage(this.fTv);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.endLoadData();
        this.fTv.setText(this.iLx.getResources().getString(R.string.list_has_no_more));
    }

    public void bKU() {
        this.irE.setNextPage(null);
    }

    public void pq(boolean z) {
        this.dPx.setVisibility(z ? 0 : 8);
    }

    public void csk() {
        this.irE.smoothScrollToPosition(0);
    }

    public void JY(String str) {
        if (this.iLx.cxV() != null) {
            this.iLx.cxV().Ka(str);
        }
    }

    public void JZ(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.iLD.getDataList())) {
            Iterator<q> it = this.iLD.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bDk() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bDk()).ekv)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
