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
    private FrameLayout cwu;
    private y drf;
    private PbListView eli;
    private BdSwipeRefreshLayout ens;
    private FrsNewAreaFragment gHC;
    private f gHI;
    private RelativeLayout gHJ;
    private com.baidu.tieba.frs.entelechy.c.a.a gHK;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gqj = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private BannerView gFu = null;
    private boolean gFw = false;
    private boolean gqr = true;
    private BannerView.a gFy = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMA() {
            g.this.bIE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMB() {
            g.this.bIG();
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.gHI.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bi) {
                            bi biVar = (bi) mVar;
                            if (biVar.cRf != 0 && biVar.cRe != null) {
                                int[] imageWidthAndHeight = biVar.cRe.getImageWidthAndHeight();
                                biVar.cRf = imageWidthAndHeight[0];
                                biVar.cRg = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gHI.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener gFz = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.BB(str);
                g.this.BA(str);
                g.this.gHI.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.gHC = null;
        this.gHC = frsNewAreaFragment;
        bJ(view);
    }

    public void refreshView() {
        this.gHI.notifyDataSetChanged();
    }

    public void lr(boolean z) {
        this.ens.setEnabled(z);
    }

    public void ls(boolean z) {
        this.gqr = z;
        if (z) {
            this.eli.setText(this.gHC.getResources().getString(R.string.load_more));
            if (this.gqj.getChildAt(this.gqj.getChildCount() - 1) == this.eli.getView()) {
                this.eli.startLoadData();
                this.gHC.bcd();
                return;
            }
            this.eli.endLoadData();
            return;
        }
        this.eli.setText(this.gHC.getResources().getString(R.string.load_more_must_after_delete));
        this.eli.endLoadData();
    }

    public boolean bEZ() {
        if (this.gqr) {
            return false;
        }
        this.eli.setText(this.gHC.getResources().getString(R.string.load_more_must_after_delete));
        this.eli.endLoadData();
        return true;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.gqj = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gqj.setLayoutManager(new LinearLayoutManager(this.gqj.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.h(this.gHC.getPageContext());
        this.gqj.setFadingEdgeLength(0);
        this.gqj.setOverScrollMode(2);
        this.gqj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.eli = new PbListView(this.gHC.getPageContext().getPageActivity());
        this.eli.createView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gHC.getActivity(), R.dimen.tbds182));
        this.eli.setLineGone();
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gqj.setOnSrollToBottomListener(this.gHC);
        if (this.ens == null) {
            this.ens = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.ens.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
        }
        this.cwu = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gHI = new f(this.gHC, this.gqj);
        hu(false);
        this.gHJ = new RelativeLayout(this.gHC.getContext());
        this.gHJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gHK = new com.baidu.tieba.frs.entelechy.c.a.a(this.gHC, this.gHJ);
        this.gqj.addHeaderView(this.gHJ, 0);
        this.gHC.registerListener(this.gpH);
        this.gHC.registerListener(this.gFz);
    }

    private void b(y yVar) {
        if (this.gFu == null) {
            this.gFu = new BannerView(this.gHC.getPageContext().getPageActivity());
            this.gFu.setLayoutParams(new AbsListView.LayoutParams(-1, this.gHC.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gFu.setVisibility(8);
            this.gFu.setBannerViewClickListener(this.gFy);
            this.gFu.setBannerData(yVar);
            this.gFu.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.gFu.aMy() && !g.this.gFw && g.this.gqj != null) {
                        g.this.gFw = true;
                        g.this.gqj.addHeaderView(g.this.gFu, 1);
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
    public void bIE() {
        if (this.drf != null) {
            String value = this.drf.getValue();
            if (this.drf.aAF() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gHC.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.drf.aAF() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gHC.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gHC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drf.aAF() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daG != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daG) {
                        case FRS:
                            this.gHC.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gHC.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gHC.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gHC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aGE().b(this.gHC.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gHC.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.drf.aAF() == 4) {
                this.gHC.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gHC.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.gqj.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gHI.a(sVar);
    }

    public void onDestroy() {
        this.gHI.onDestory();
        this.gqj.setOnSrollToBottomListener(null);
    }

    public void hu(boolean z) {
        if (!z) {
            this.ens.setRefreshing(false);
        }
    }

    public void bgw() {
        this.gqj.setVisibility(0);
    }

    public void bER() {
        if (this.gHI != null) {
            this.gHI.notifyDataSetChanged();
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
                if (frsViewData != null && this.gHC.bJu() != null && frsTabInfo != null) {
                    this.gHC.bJu().tN(frsTabInfo.tab_id.intValue());
                }
            } else if (this.gHK != null && frsViewData.getForum() != null) {
                this.gHK.setData(f, this.gHC.bJu().bJn());
                this.gHK.setFid(frsViewData.getForum().getId());
            }
        }
        this.gHI.b(arrayList2, frsViewData);
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
        return this.gqj;
    }

    public void bIF() {
        this.gHI.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gqj.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gFw && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.drf = forumData.getFrsBannerData();
            b(this.drf);
            this.gFu.reset();
            this.gqj.removeHeaderView(this.gFu);
            if (this.drf.getType() == 1 && !TextUtils.isEmpty(this.drf.aAG())) {
                this.gFu.setData(this.gHC.getPageContext(), this.drf.aAG());
                if (this.drf.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gHC.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bIG() {
        if (this.gFu != null) {
            this.gFw = false;
            this.gqj.removeHeaderView(this.gFu);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gHI != null) {
            this.gHI.bHd();
            this.gHI.notifyDataSetChanged();
            this.gHI.onChangeSkinType(i);
        }
        this.gHC.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gHC.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gFu != null) {
            this.gFu.aMz();
        }
        if (this.eli != null) {
            this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
            this.eli.changeSkin(i);
        }
        am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
        this.gHK.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.ens.setRefreshing(true);
    }

    public f bJw() {
        return this.gHI;
    }

    public RelativeLayout bsC() {
        return this.mContainer;
    }

    public View bGd() {
        return this.ens;
    }

    public void bFf() {
        if (com.baidu.tbadk.n.m.aRj().aRk()) {
            int lastVisiblePosition = this.gqj.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gqj.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grh != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grh.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDu = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grh.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grh.startLogPerf();
                    }
                    if (pVar.grg != null && (pVar.grg instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.grg;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDu = true;
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
    public void bdp() {
        this.gqj.setNextPage(this.eli);
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.startLoadData();
    }

    public void bdq() {
        this.gqj.setNextPage(this.eli);
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.endLoadData();
        this.eli.setText(this.gHC.getResources().getString(R.string.list_has_no_more));
    }

    public void bdr() {
        this.gqj.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cwu.setVisibility(z ? 0 : 8);
    }

    public void scrollToTop() {
        this.gqj.smoothScrollToPosition(0);
    }

    public void BA(String str) {
        if (this.gHC.bIB() != null) {
            this.gHC.bIB().BC(str);
        }
    }

    public void BB(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gHI.getDataList())) {
            Iterator<m> it = this.gHI.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aVu() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVu()).cMV)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
