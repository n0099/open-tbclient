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
/* loaded from: classes7.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout css;
    private y dmW;
    private PbListView ehe;
    private BdSwipeRefreshLayout ejj;
    private FrsNewAreaFragment gFD;
    private f gFJ;
    private RelativeLayout gFK;
    private com.baidu.tieba.frs.entelechy.c.a.a gFL;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView goi = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private BannerView gDv = null;
    private boolean gDx = false;
    private boolean goq = true;
    private BannerView.a gDz = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aKe() {
            g.this.bHd();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aKf() {
            g.this.bHf();
        }
    };
    private CustomMessageListener gnG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.gFJ.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bi) {
                            bi biVar = (bi) mVar;
                            if (biVar.cNc != 0 && biVar.cNb != null) {
                                int[] imageWidthAndHeight = biVar.cNb.getImageWidthAndHeight();
                                biVar.cNc = imageWidthAndHeight[0];
                                biVar.cNd = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gFJ.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener gDA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Bl(str);
                g.this.Bk(str);
                g.this.gFJ.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.gFD = null;
        this.gFD = frsNewAreaFragment;
        bJ(view);
    }

    public void refreshView() {
        this.gFJ.notifyDataSetChanged();
    }

    public void lo(boolean z) {
        this.ejj.setEnabled(z);
    }

    public void lp(boolean z) {
        this.goq = z;
        if (z) {
            this.ehe.setText(this.gFD.getResources().getString(R.string.load_more));
            if (this.goi.getChildAt(this.goi.getChildCount() - 1) == this.ehe.getView()) {
                this.ehe.startLoadData();
                this.gFD.aZN();
                return;
            }
            this.ehe.endLoadData();
            return;
        }
        this.ehe.setText(this.gFD.getResources().getString(R.string.load_more_must_after_delete));
        this.ehe.endLoadData();
    }

    public boolean bDw() {
        if (this.goq) {
            return false;
        }
        this.ehe.setText(this.gFD.getResources().getString(R.string.load_more_must_after_delete));
        this.ehe.endLoadData();
        return true;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.goi = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.goi.setLayoutManager(new LinearLayoutManager(this.goi.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.h(this.gFD.getPageContext());
        this.goi.setFadingEdgeLength(0);
        this.goi.setOverScrollMode(2);
        this.goi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.ehe = new PbListView(this.gFD.getPageContext().getPageActivity());
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gFD.getActivity(), R.dimen.tbds182));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.goi.setOnSrollToBottomListener(this.gFD);
        if (this.ejj == null) {
            this.ejj = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.ejj.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
        }
        this.css = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gFJ = new f(this.gFD, this.goi);
        hn(false);
        this.gFK = new RelativeLayout(this.gFD.getContext());
        this.gFK.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gFL = new com.baidu.tieba.frs.entelechy.c.a.a(this.gFD, this.gFK);
        this.goi.addHeaderView(this.gFK, 0);
        this.gFD.registerListener(this.gnG);
        this.gFD.registerListener(this.gDA);
    }

    private void b(y yVar) {
        if (this.gDv == null) {
            this.gDv = new BannerView(this.gFD.getPageContext().getPageActivity());
            this.gDv.setLayoutParams(new AbsListView.LayoutParams(-1, this.gFD.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gDv.setVisibility(8);
            this.gDv.setBannerViewClickListener(this.gDz);
            this.gDv.setBannerData(yVar);
            this.gDv.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.gDv.aKc() && !g.this.gDx && g.this.goi != null) {
                        g.this.gDx = true;
                        g.this.goi.addHeaderView(g.this.gDv, 1);
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
    public void bHd() {
        if (this.dmW != null) {
            String value = this.dmW.getValue();
            if (this.dmW.ayr() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gFD.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dmW.ayr() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gFD.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gFD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dmW.ayr() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cWD != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cWD) {
                        case FRS:
                            this.gFD.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gFD.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gFD.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gFD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aEt().b(this.gFD.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gFD.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dmW.ayr() == 4) {
                this.gFD.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gFD.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.goi.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gFJ.a(sVar);
    }

    public void onDestroy() {
        this.gFJ.onDestory();
        this.goi.setOnSrollToBottomListener(null);
    }

    public void hn(boolean z) {
        if (!z) {
            this.ejj.setRefreshing(false);
        }
    }

    public void bem() {
        this.goi.setVisibility(0);
    }

    public void bDo() {
        if (this.gFJ != null) {
            this.gFJ.notifyDataSetChanged();
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
                if (frsViewData != null && this.gFD.bHS() != null && frsTabInfo != null) {
                    this.gFD.bHS().tH(frsTabInfo.tab_id.intValue());
                }
            } else if (this.gFL != null && frsViewData.getForum() != null) {
                this.gFL.setData(f, this.gFD.bHS().bHL());
                this.gFL.setFid(frsViewData.getForum().getId());
            }
        }
        this.gFJ.b(arrayList2, frsViewData);
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
        return this.goi;
    }

    public void bHe() {
        this.gFJ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.goi.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gDx && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dmW = forumData.getFrsBannerData();
            b(this.dmW);
            this.gDv.reset();
            this.goi.removeHeaderView(this.gDv);
            if (this.dmW.getType() == 1 && !TextUtils.isEmpty(this.dmW.ays())) {
                this.gDv.setData(this.gFD.getPageContext(), this.dmW.ays());
                if (this.dmW.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gFD.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bHf() {
        if (this.gDv != null) {
            this.gDx = false;
            this.goi.removeHeaderView(this.gDv);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gFJ != null) {
            this.gFJ.bFB();
            this.gFJ.notifyDataSetChanged();
            this.gFJ.onChangeSkinType(i);
        }
        this.gFD.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gFD.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gDv != null) {
            this.gDv.aKd();
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.changeSkin(i);
        }
        am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
        this.gFL.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.ejj.setRefreshing(true);
    }

    public f bHU() {
        return this.gFJ;
    }

    public RelativeLayout bqY() {
        return this.mContainer;
    }

    public View bEB() {
        return this.ejj;
    }

    public void bDC() {
        if (com.baidu.tbadk.n.m.aOT().aOU()) {
            int lastVisiblePosition = this.goi.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.goi.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.gpg != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.gpg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dzs = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.gpg.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.gpg.startLogPerf();
                    }
                    if (pVar.gpf != null && (pVar.gpf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.gpf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dzs = true;
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
    public void bba() {
        this.goi.setNextPage(this.ehe);
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.startLoadData();
    }

    public void bbb() {
        this.goi.setNextPage(this.ehe);
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.endLoadData();
        this.ehe.setText(this.gFD.getResources().getString(R.string.list_has_no_more));
    }

    public void bbc() {
        this.goi.setNextPage(null);
    }

    public void lC(boolean z) {
        this.css.setVisibility(z ? 0 : 8);
    }

    public void scrollToTop() {
        this.goi.smoothScrollToPosition(0);
    }

    public void Bk(String str) {
        if (this.gFD.bHa() != null) {
            this.gFD.bHa().Bm(str);
        }
    }

    public void Bl(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gFJ.getDataList())) {
            Iterator<m> it = this.gFJ.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aTd() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aTd()).cIS)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
