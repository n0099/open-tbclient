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
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
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
    private FrameLayout cVI;
    private y dRI;
    private PbListView ePr;
    private RelativeLayout hfX;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a hfY;
    private FrsNewAreaFragment hsn;
    private f hst;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView haA = null;
    private BannerView hqe = null;
    private boolean hqg = false;
    private boolean haJ = true;
    private BannerView.a hqj = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVc() {
            g.this.bTp();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVd() {
            g.this.bTr();
        }
    };
    private CustomMessageListener gZU = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.m> dataList = g.this.hst.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                        if (mVar instanceof bi) {
                            bi biVar = (bi) mVar;
                            if (biVar.dqF != 0 && biVar.dqE != null) {
                                int[] imageWidthAndHeight = biVar.dqE.getImageWidthAndHeight();
                                biVar.dqF = imageWidthAndHeight[0];
                                biVar.dqG = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.hst.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener hqk = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Dp(str);
                g.this.Do(str);
                g.this.hst.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.hsn = null;
        this.hsn = frsNewAreaFragment;
        bP(view);
    }

    public void refreshView() {
        this.hst.notifyDataSetChanged();
    }

    public void mN(boolean z) {
        com.baidu.tieba.frs.y yVar = new com.baidu.tieba.frs.y();
        yVar.tabId = 503;
        yVar.dGR = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    public void mB(boolean z) {
        this.haJ = z;
        if (z) {
            this.ePr.setText(this.hsn.getResources().getString(R.string.load_more));
            if (this.haA.getChildAt(this.haA.getChildCount() - 1) == this.ePr.getView()) {
                this.ePr.startLoadData();
                this.hsn.bkZ();
                return;
            }
            this.ePr.endLoadData();
            return;
        }
        this.ePr.setText(this.hsn.getResources().getString(R.string.load_more_must_after_delete));
        this.ePr.endLoadData();
    }

    public boolean bPM() {
        if (this.haJ) {
            return false;
        }
        this.ePr.setText(this.hsn.getResources().getString(R.string.load_more_must_after_delete));
        this.ePr.endLoadData();
        return true;
    }

    private void bP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.haA = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.haA.setLayoutManager(new LinearLayoutManager(this.haA.getContext()));
        this.haA.setFadingEdgeLength(0);
        this.haA.setOverScrollMode(2);
        this.haA.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.ePr = new PbListView(this.hsn.getPageContext().getPageActivity());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hsn.getActivity(), R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.haA.setOnSrollToBottomListener(this.hsn);
        this.cVI = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hst = new f(this.hsn, this.haA);
        it(false);
        this.hfX = new RelativeLayout(this.hsn.getContext());
        this.hfX.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hfY = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hsn, this.hfX);
        this.hsn.registerListener(this.gZU);
        this.hsn.registerListener(this.hqk);
    }

    private void b(y yVar) {
        if (this.hqe == null) {
            this.hqe = new BannerView(this.hsn.getPageContext().getPageActivity());
            this.hqe.setLayoutParams(new AbsListView.LayoutParams(-1, this.hsn.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hqe.setVisibility(8);
            this.hqe.setBannerViewClickListener(this.hqj);
            this.hqe.setBannerData(yVar);
            this.hqe.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.hqe.aVa() && !g.this.hqg && g.this.haA != null) {
                        g.this.hqg = true;
                        g.this.haA.addHeaderView(g.this.hqe, 1);
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
    public void bTp() {
        if (this.dRI != null) {
            String value = this.dRI.getValue();
            if (this.dRI.aIV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hsn.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dRI.aIV() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hsn.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hsn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dRI.aIV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dAn != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dAn) {
                        case FRS:
                            this.hsn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hsn.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hsn.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hsn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aOV().b(this.hsn.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hsn.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dRI.aIV() == 4) {
                this.hsn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hsn.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.haA.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.hst.a(vVar);
    }

    public void onDestroy() {
        this.hst.onDestory();
        this.haA.setOnSrollToBottomListener(null);
    }

    public void it(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 503;
            sVar.etP = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bQS() {
        s sVar = new s();
        sVar.tabId = 503;
        sVar.etP = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bpT() {
        this.haA.setVisibility(0);
    }

    public void bPD() {
        if (this.hst != null) {
            this.hst.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            p pVar = new p();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(pVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (v.isEmpty(f)) {
                if (this.hfX != null) {
                    this.haA.removeHeaderView(this.hfX);
                }
            } else if (this.hfX != null) {
                this.haA.removeHeaderView(this.hfX);
                this.haA.addHeaderView(this.hfX, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) v.getItem(f, 0);
                if (frsViewData != null && this.hsn.bUg() != null && frsTabInfo != null) {
                    this.hsn.bUg().ur(frsTabInfo.tab_id.intValue());
                }
            } else if (this.hfY != null && frsViewData.getForum() != null) {
                this.hfY.setData(f);
                this.hfY.setFid(frsViewData.getForum().getId());
            }
        }
        this.hst.b(arrayList2, frsViewData);
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
        return this.haA;
    }

    public void bTq() {
        this.hst.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.haA.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hqg && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dRI = forumData.getFrsBannerData();
            b(this.dRI);
            this.hqe.reset();
            this.haA.removeHeaderView(this.hqe);
            if (this.dRI.getType() == 1 && !TextUtils.isEmpty(this.dRI.aIW())) {
                this.hqe.setData(this.hsn.getPageContext(), this.dRI.aIW());
                if (this.dRI.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hsn.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bTr() {
        if (this.hqe != null) {
            this.hqg = false;
            this.haA.removeHeaderView(this.hqe);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hst != null) {
            this.hst.bRV();
            this.hst.notifyDataSetChanged();
            this.hst.onChangeSkinType(i);
        }
        this.hsn.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hsn.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hqe != null) {
            this.hqe.aVb();
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.changeSkin(i);
        }
        this.hfY.onChangeSkinType();
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 503;
        sVar.etP = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public f bUi() {
        return this.hst;
    }

    public RelativeLayout bCr() {
        return this.mContainer;
    }

    public void bPS() {
        if (com.baidu.tbadk.n.m.aZy().aZz()) {
            int lastVisiblePosition = this.haA.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.haA.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hby != null) {
                        com.baidu.tbadk.n.h perfLog = rVar.hby.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.edI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hby.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hby.startLogPerf();
                    }
                    if (rVar.hbx != null && (rVar.hbx instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hbx;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.edI = true;
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
    public void bmm() {
        this.haA.setNextPage(this.ePr);
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.startLoadData();
    }

    public void bmn() {
        this.haA.setNextPage(this.ePr);
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.endLoadData();
        this.ePr.setText(this.hsn.getResources().getString(R.string.list_has_no_more));
    }

    public void bmo() {
        this.haA.setNextPage(null);
    }

    public void mO(boolean z) {
        this.cVI.setVisibility(z ? 0 : 8);
    }

    public void bOd() {
        this.haA.smoothScrollToPosition(0);
    }

    public void Do(String str) {
        if (this.hsn.bTm() != null) {
            this.hsn.bTm().Dq(str);
        }
    }

    public void Dp(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.hst.getDataList())) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hst.getDataList().iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bdJ() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bdJ()).dms)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
