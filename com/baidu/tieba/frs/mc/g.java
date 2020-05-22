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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.x;
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
import com.baidu.tieba.frs.y;
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
    private FrameLayout dgJ;
    private x egc;
    private PbListView fbY;
    private FrsNewAreaFragment hHb;
    private f hHh;
    private RelativeLayout huL;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a huM;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hpo = null;
    private BannerView hES = null;
    private boolean hEU = false;
    private boolean hpx = true;
    private BannerView.a hEX = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bbm() {
            g.this.bZK();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bbn() {
            g.this.bZM();
        }
    };
    private CustomMessageListener hoI = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<o> dataList = g.this.hHh.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (o oVar : dataList) {
                        if (oVar instanceof bj) {
                            bj bjVar = (bj) oVar;
                            if (bjVar.dEB != 0 && bjVar.dEA != null) {
                                int[] imageWidthAndHeight = bjVar.dEA.getImageWidthAndHeight();
                                bjVar.dEB = imageWidthAndHeight[0];
                                bjVar.dEC = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.hHh.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener hEY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.EY(str);
                g.this.EX(str);
                g.this.hHh.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.hHb = null;
        this.hHb = frsNewAreaFragment;
        bP(view);
    }

    public void refreshView() {
        this.hHh.notifyDataSetChanged();
    }

    public void ni(boolean z) {
        y yVar = new y();
        yVar.tabId = 503;
        yVar.dVd = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    public void mW(boolean z) {
        this.hpx = z;
        if (z) {
            this.fbY.setText(this.hHb.getResources().getString(R.string.load_more));
            if (this.hpo.getChildAt(this.hpo.getChildCount() - 1) == this.fbY.getView()) {
                this.fbY.startLoadData();
                this.hHb.bqv();
                return;
            }
            this.fbY.endLoadData();
            return;
        }
        this.fbY.setText(this.hHb.getResources().getString(R.string.load_more_must_after_delete));
        this.fbY.endLoadData();
    }

    public boolean bWi() {
        if (this.hpx) {
            return false;
        }
        this.fbY.setText(this.hHb.getResources().getString(R.string.load_more_must_after_delete));
        this.fbY.endLoadData();
        return true;
    }

    private void bP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.hpo = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hpo.setLayoutManager(new LinearLayoutManager(this.hpo.getContext()));
        this.hpo.setFadingEdgeLength(0);
        this.hpo.setOverScrollMode(2);
        this.hpo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.fbY = new PbListView(this.hHb.getPageContext().getPageActivity());
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hHb.getActivity(), R.dimen.tbds182));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hpo.setOnSrollToBottomListener(this.hHb);
        this.dgJ = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hHh = new f(this.hHb, this.hpo);
        iQ(false);
        this.huL = new RelativeLayout(this.hHb.getContext());
        this.huL.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.huM = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hHb, this.huL);
        this.hHb.registerListener(this.hoI);
        this.hHb.registerListener(this.hEY);
    }

    private void b(x xVar) {
        if (this.hES == null) {
            this.hES = new BannerView(this.hHb.getPageContext().getPageActivity());
            this.hES.setLayoutParams(new AbsListView.LayoutParams(-1, this.hHb.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hES.setVisibility(8);
            this.hES.setBannerViewClickListener(this.hEX);
            this.hES.setBannerData(xVar);
            this.hES.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.hES.bbk() && !g.this.hEU && g.this.hpo != null) {
                        g.this.hEU = true;
                        g.this.hpo.addHeaderView(g.this.hES, 1);
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
    public void bZK() {
        if (this.egc != null) {
            String value = this.egc.getValue();
            if (this.egc.aOQ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hHb.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.egc.aOQ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hHb.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hHb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.egc.aOQ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dOt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dOt) {
                        case FRS:
                            this.hHb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hHb.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hHb.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hHb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aUZ().b(this.hHb.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hHb.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.egc.aOQ() == 4) {
                this.hHb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hHb.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hpo.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.hHh.a(xVar);
    }

    public void onDestroy() {
        this.hHh.onDestory();
        this.hpo.setOnSrollToBottomListener(null);
    }

    public void iQ(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 503;
            sVar.eIo = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bXo() {
        s sVar = new s();
        sVar.tabId = 503;
        sVar.eIo = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bvM() {
        this.hpo.setVisibility(0);
    }

    public void bVZ() {
        if (this.hHh != null) {
            this.hHh.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<o> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<o> arrayList2;
        ArrayList<o> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            p pVar = new p();
            ArrayList<o> arrayList3 = new ArrayList<>();
            arrayList3.add(pVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (v.isEmpty(f)) {
                if (this.huL != null) {
                    this.hpo.removeHeaderView(this.huL);
                }
            } else if (this.huL != null) {
                this.hpo.removeHeaderView(this.huL);
                this.hpo.addHeaderView(this.huL, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) v.getItem(f, 0);
                if (frsViewData != null && this.hHb.caD() != null && frsTabInfo != null) {
                    this.hHb.caD().uX(frsTabInfo.tab_id.intValue());
                }
            } else if (this.huM != null && frsViewData.getForum() != null) {
                this.huM.setData(f);
                this.huM.setFid(frsViewData.getForum().getId());
            }
        }
        this.hHh.b(arrayList2, frsViewData);
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
        return this.hpo;
    }

    public void bZL() {
        this.hHh.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hpo.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hEU && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.egc = forumData.getFrsBannerData();
            b(this.egc);
            this.hES.reset();
            this.hpo.removeHeaderView(this.hES);
            if (this.egc.getType() == 1 && !TextUtils.isEmpty(this.egc.aOR())) {
                this.hES.setData(this.hHb.getPageContext(), this.egc.aOR());
                if (this.egc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hHb.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bZM() {
        if (this.hES != null) {
            this.hEU = false;
            this.hpo.removeHeaderView(this.hES);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hHh != null) {
            this.hHh.bYr();
            this.hHh.notifyDataSetChanged();
            this.hHh.onChangeSkinType(i);
        }
        this.hHb.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hHb.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hES != null) {
            this.hES.bbl();
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.changeSkin(i);
        }
        this.huM.onChangeSkinType();
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 503;
        sVar.eIo = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public f caF() {
        return this.hHh;
    }

    public RelativeLayout bIL() {
        return this.mContainer;
    }

    public void bWo() {
        if (com.baidu.tbadk.n.m.bfI().bfJ()) {
            int lastVisiblePosition = this.hpo.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hpo.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hqm != null) {
                        com.baidu.tbadk.n.h perfLog = rVar.hqm.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.erV = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hqm.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hqm.startLogPerf();
                    }
                    if (rVar.hql != null && (rVar.hql instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hql;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.erV = true;
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
    public void brK() {
        this.hpo.setNextPage(this.fbY);
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.startLoadData();
    }

    public void brL() {
        this.hpo.setNextPage(this.fbY);
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.endLoadData();
        this.fbY.setText(this.hHb.getResources().getString(R.string.list_has_no_more));
    }

    public void brM() {
        this.hpo.setNextPage(null);
    }

    public void nj(boolean z) {
        this.dgJ.setVisibility(z ? 0 : 8);
    }

    public void bUy() {
        this.hpo.smoothScrollToPosition(0);
    }

    public void EX(String str) {
        if (this.hHb.bZH() != null) {
            this.hHb.bZH().EZ(str);
        }
    }

    public void EY(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.hHh.getDataList())) {
            Iterator<o> it = this.hHh.getDataList().iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bjU() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bjU()).dAu)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
