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
    private FrameLayout cwv;
    private y drg;
    private PbListView elj;
    private BdSwipeRefreshLayout ent;
    private FrsNewAreaFragment gHE;
    private f gHK;
    private RelativeLayout gHL;
    private com.baidu.tieba.frs.entelechy.c.a.a gHM;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gql = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private BannerView gFw = null;
    private boolean gFy = false;
    private boolean gqt = true;
    private BannerView.a gFA = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMC() {
            g.this.bIG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMD() {
            g.this.bII();
        }
    };
    private CustomMessageListener gpJ = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.gHK.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bi) {
                            bi biVar = (bi) mVar;
                            if (biVar.cRg != 0 && biVar.cRf != null) {
                                int[] imageWidthAndHeight = biVar.cRf.getImageWidthAndHeight();
                                biVar.cRg = imageWidthAndHeight[0];
                                biVar.cRh = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gHK.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener gFB = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.BB(str);
                g.this.BA(str);
                g.this.gHK.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.gHE = null;
        this.gHE = frsNewAreaFragment;
        bJ(view);
    }

    public void refreshView() {
        this.gHK.notifyDataSetChanged();
    }

    public void lr(boolean z) {
        this.ent.setEnabled(z);
    }

    public void ls(boolean z) {
        this.gqt = z;
        if (z) {
            this.elj.setText(this.gHE.getResources().getString(R.string.load_more));
            if (this.gql.getChildAt(this.gql.getChildCount() - 1) == this.elj.getView()) {
                this.elj.startLoadData();
                this.gHE.bcf();
                return;
            }
            this.elj.endLoadData();
            return;
        }
        this.elj.setText(this.gHE.getResources().getString(R.string.load_more_must_after_delete));
        this.elj.endLoadData();
    }

    public boolean bFb() {
        if (this.gqt) {
            return false;
        }
        this.elj.setText(this.gHE.getResources().getString(R.string.load_more_must_after_delete));
        this.elj.endLoadData();
        return true;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.gql = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gql.setLayoutManager(new LinearLayoutManager(this.gql.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.h(this.gHE.getPageContext());
        this.gql.setFadingEdgeLength(0);
        this.gql.setOverScrollMode(2);
        this.gql.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.elj = new PbListView(this.gHE.getPageContext().getPageActivity());
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gHE.getActivity(), R.dimen.tbds182));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gql.setOnSrollToBottomListener(this.gHE);
        if (this.ent == null) {
            this.ent = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.ent.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
        }
        this.cwv = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gHK = new f(this.gHE, this.gql);
        hu(false);
        this.gHL = new RelativeLayout(this.gHE.getContext());
        this.gHL.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gHM = new com.baidu.tieba.frs.entelechy.c.a.a(this.gHE, this.gHL);
        this.gql.addHeaderView(this.gHL, 0);
        this.gHE.registerListener(this.gpJ);
        this.gHE.registerListener(this.gFB);
    }

    private void b(y yVar) {
        if (this.gFw == null) {
            this.gFw = new BannerView(this.gHE.getPageContext().getPageActivity());
            this.gFw.setLayoutParams(new AbsListView.LayoutParams(-1, this.gHE.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gFw.setVisibility(8);
            this.gFw.setBannerViewClickListener(this.gFA);
            this.gFw.setBannerData(yVar);
            this.gFw.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.gFw.aMA() && !g.this.gFy && g.this.gql != null) {
                        g.this.gFy = true;
                        g.this.gql.addHeaderView(g.this.gFw, 1);
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
    public void bIG() {
        if (this.drg != null) {
            String value = this.drg.getValue();
            if (this.drg.aAH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gHE.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.drg.aAH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gHE.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gHE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drg.aAH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daH != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daH) {
                        case FRS:
                            this.gHE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gHE.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gHE.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gHE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aGG().b(this.gHE.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gHE.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.drg.aAH() == 4) {
                this.gHE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gHE.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.gql.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gHK.a(sVar);
    }

    public void onDestroy() {
        this.gHK.onDestory();
        this.gql.setOnSrollToBottomListener(null);
    }

    public void hu(boolean z) {
        if (!z) {
            this.ent.setRefreshing(false);
        }
    }

    public void bgy() {
        this.gql.setVisibility(0);
    }

    public void bET() {
        if (this.gHK != null) {
            this.gHK.notifyDataSetChanged();
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
                if (frsViewData != null && this.gHE.bJw() != null && frsTabInfo != null) {
                    this.gHE.bJw().tN(frsTabInfo.tab_id.intValue());
                }
            } else if (this.gHM != null && frsViewData.getForum() != null) {
                this.gHM.setData(f, this.gHE.bJw().bJp());
                this.gHM.setFid(frsViewData.getForum().getId());
            }
        }
        this.gHK.b(arrayList2, frsViewData);
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
        return this.gql;
    }

    public void bIH() {
        this.gHK.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gql.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gFy && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.drg = forumData.getFrsBannerData();
            b(this.drg);
            this.gFw.reset();
            this.gql.removeHeaderView(this.gFw);
            if (this.drg.getType() == 1 && !TextUtils.isEmpty(this.drg.aAI())) {
                this.gFw.setData(this.gHE.getPageContext(), this.drg.aAI());
                if (this.drg.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gHE.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bII() {
        if (this.gFw != null) {
            this.gFy = false;
            this.gql.removeHeaderView(this.gFw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gHK != null) {
            this.gHK.bHf();
            this.gHK.notifyDataSetChanged();
            this.gHK.onChangeSkinType(i);
        }
        this.gHE.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gHE.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gFw != null) {
            this.gFw.aMB();
        }
        if (this.elj != null) {
            this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elj.changeSkin(i);
        }
        am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
        this.gHM.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.ent.setRefreshing(true);
    }

    public f bJy() {
        return this.gHK;
    }

    public RelativeLayout bsE() {
        return this.mContainer;
    }

    public View bGf() {
        return this.ent;
    }

    public void bFh() {
        if (com.baidu.tbadk.n.m.aRl().aRm()) {
            int lastVisiblePosition = this.gql.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gql.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grj != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grj.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grj.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grj.startLogPerf();
                    }
                    if (pVar.gri != null && (pVar.gri instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.gri;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDv = true;
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
    public void bdr() {
        this.gql.setNextPage(this.elj);
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.startLoadData();
    }

    public void bds() {
        this.gql.setNextPage(this.elj);
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.endLoadData();
        this.elj.setText(this.gHE.getResources().getString(R.string.list_has_no_more));
    }

    public void bdt() {
        this.gql.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cwv.setVisibility(z ? 0 : 8);
    }

    public void scrollToTop() {
        this.gql.smoothScrollToPosition(0);
    }

    public void BA(String str) {
        if (this.gHE.bID() != null) {
            this.gHE.bID().BC(str);
        }
    }

    public void BB(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gHK.getDataList())) {
            Iterator<m> it = this.gHK.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aVw() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVw()).cMW)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
