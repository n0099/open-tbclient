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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout bGR;
    private x czc;
    private PbListView dvS;
    private BdSwipeRefreshLayout dxt;
    private FrsNewAreaFragment fOb;
    private f fOh;
    private RelativeLayout fOi;
    private com.baidu.tieba.frs.entelechy.c.a.a fOj;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView fwC = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fLW = null;
    private boolean fLY = false;
    private boolean fwK = true;
    private BannerView.a fMc = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asl() {
            g.this.boE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asm() {
            g.this.boG();
        }
    };
    private CustomMessageListener fwb = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.fOh.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bg) {
                            bg bgVar = (bg) mVar;
                            if (bgVar.caA != 0 && bgVar.caz != null) {
                                int[] imageWidthAndHeight = bgVar.caz.getImageWidthAndHeight();
                                bgVar.caA = imageWidthAndHeight[0];
                                bgVar.caB = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fOh.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.wm(str);
                g.this.wl(str);
                g.this.fOh.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.fOb = null;
        this.fOb = frsNewAreaFragment;
        bJ(view);
    }

    public void refreshView() {
        this.fOh.notifyDataSetChanged();
    }

    public void jR(boolean z) {
        this.dxt.setEnabled(z);
    }

    public void jS(boolean z) {
        this.fwK = z;
        if (z) {
            this.dvS.setText(this.fOb.getResources().getString(R.string.load_more));
            if (this.fwC.getChildAt(this.fwC.getChildCount() - 1) == this.dvS.getView()) {
                this.dvS.startLoadData();
                this.fOb.aIU();
                return;
            }
            this.dvS.endLoadData();
            return;
        }
        this.dvS.setText(this.fOb.getResources().getString(R.string.load_more_must_after_delete));
        this.dvS.endLoadData();
    }

    public boolean bkY() {
        if (this.fwK) {
            return false;
        }
        this.dvS.setText(this.fOb.getResources().getString(R.string.load_more_must_after_delete));
        this.dvS.endLoadData();
        return true;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.fwC = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fwC.setLayoutManager(new LinearLayoutManager(this.fwC.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.fOb.getPageContext());
        this.fwC.setFadingEdgeLength(0);
        this.fwC.setOverScrollMode(2);
        this.fwC.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.dvS = new PbListView(this.fOb.getPageContext().getPageActivity());
        this.dvS.createView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setHeight(com.baidu.adp.lib.util.l.getDimens(this.fOb.getActivity(), R.dimen.tbds182));
        this.dvS.setLineGone();
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fwC.setOnSrollToBottomListener(this.fOb);
        if (this.dxt == null) {
            this.dxt = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dxt.setProgressView(this.mPullView);
            am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
        }
        this.bGR = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fOh = new f(this.fOb, this.fwC);
        fU(false);
        this.fOi = new RelativeLayout(this.fOb.getContext());
        this.fOi.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fOj = new com.baidu.tieba.frs.entelechy.c.a.a(this.fOb, this.fOi);
        this.fwC.addHeaderView(this.fOi, 0);
        this.fOb.registerListener(this.fwb);
        this.fOb.registerListener(this.fMd);
    }

    private void b(x xVar) {
        if (this.fLW == null) {
            this.fLW = new BannerView(this.fOb.getPageContext().getPageActivity());
            this.fLW.setLayoutParams(new AbsListView.LayoutParams(-1, this.fOb.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fLW.setVisibility(8);
            this.fLW.setBannerViewClickListener(this.fMc);
            this.fLW.setBannerData(xVar);
            this.fLW.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.fLW.asj() && !g.this.fLY && g.this.fwC != null) {
                        g.this.fLY = true;
                        g.this.fwC.addHeaderView(g.this.fLW, 1);
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
    public void boE() {
        if (this.czc != null) {
            String value = this.czc.getValue();
            if (this.czc.ahe() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.fOb.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.czc.ahe() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fOb.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fOb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.czc.ahe() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cjI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cjI) {
                        case FRS:
                            this.fOb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fOb.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fOb.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fOb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.amO().b(this.fOb.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.fOb.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.czc.ahe() == 4) {
                this.fOb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fOb.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.fwC.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.fOh.a(sVar);
    }

    public void onDestroy() {
        this.fOh.onDestory();
        this.fwC.setOnSrollToBottomListener(null);
    }

    public void fU(boolean z) {
        if (!z) {
            this.dxt.setRefreshing(false);
        }
    }

    public void aMo() {
        this.fwC.setVisibility(0);
    }

    public void bkQ() {
        if (this.fOh != null) {
            this.fOh.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<m> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<m> arrayList2;
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
            ArrayList<m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) v.getItem(f, 0);
                if (frsViewData != null && this.fOb.bpu() != null && frsTabInfo != null) {
                    this.fOb.bpu().rw(frsTabInfo.tab_id.intValue());
                }
            } else if (this.fOj != null && frsViewData.getForum() != null) {
                this.fOj.setData(f, this.fOb.bpu().bpn());
                this.fOj.setFid(frsViewData.getForum().getId());
            }
        }
        this.fOh.b(arrayList2, frsViewData);
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
        return this.fwC;
    }

    public void boF() {
        this.fOh.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fwC.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fLY && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.czc = forumData.getFrsBannerData();
            b(this.czc);
            this.fLW.reset();
            this.fwC.removeHeaderView(this.fLW);
            if (this.czc.getType() == 1 && !TextUtils.isEmpty(this.czc.ahf())) {
                this.fLW.setData(this.fOb.getPageContext(), this.czc.ahf());
                if (this.czc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.fOb.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void boG() {
        if (this.fLW != null) {
            this.fLY = false;
            this.fwC.removeHeaderView(this.fLW);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fOh != null) {
            this.fOh.bnb();
            this.fOh.notifyDataSetChanged();
            this.fOh.onChangeSkinType(i);
        }
        this.fOb.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fOb.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fLW != null) {
            this.fLW.ask();
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.changeSkin(i);
        }
        am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
        this.fOj.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.dxt.setRefreshing(true);
    }

    public f bpw() {
        return this.fOh;
    }

    public RelativeLayout aYb() {
        return this.mContainer;
    }

    public View bmc() {
        return this.dxt;
    }

    public void ble() {
        if (com.baidu.tbadk.p.m.awL().awM()) {
            int lastVisiblePosition = this.fwC.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fwC.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fxA != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.fxA.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.cLh = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fxA.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fxA.startLogPerf();
                    }
                    if (oVar.fxz != null && (oVar.fxz instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fxz;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.cLh = true;
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
    public void aKg() {
        this.fwC.setNextPage(this.dvS);
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.startLoadData();
    }

    public void aKh() {
        this.fwC.setNextPage(this.dvS);
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.endLoadData();
        this.dvS.setText(this.fOb.getResources().getString(R.string.list_has_no_more));
    }

    public void aKi() {
        this.fwC.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bGR.setVisibility(z ? 0 : 8);
    }

    public void bjw() {
        this.fwC.smoothScrollToPosition(0);
    }

    public void wl(String str) {
        if (this.fOb.boB() != null) {
            this.fOb.boB().wn(str);
        }
    }

    public void wm(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.fOh.getDataList())) {
            Iterator<m> it = this.fOh.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAV() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAV()).bWt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
