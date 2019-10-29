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
    private FrameLayout bHI;
    private x czT;
    private PbListView dwJ;
    private BdSwipeRefreshLayout dyk;
    private FrsNewAreaFragment fOS;
    private f fOY;
    private RelativeLayout fOZ;
    private com.baidu.tieba.frs.entelechy.c.a.a fPa;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView fxt = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fMN = null;
    private boolean fMP = false;
    private boolean fxB = true;
    private BannerView.a fMT = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asn() {
            g.this.boG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aso() {
            g.this.boI();
        }
    };
    private CustomMessageListener fwS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.fOY.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bg) {
                            bg bgVar = (bg) mVar;
                            if (bgVar.cbr != 0 && bgVar.cbq != null) {
                                int[] imageWidthAndHeight = bgVar.cbq.getImageWidthAndHeight();
                                bgVar.cbr = imageWidthAndHeight[0];
                                bgVar.cbs = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fOY.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener fMU = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.wm(str);
                g.this.wl(str);
                g.this.fOY.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.fOS = null;
        this.fOS = frsNewAreaFragment;
        bJ(view);
    }

    public void refreshView() {
        this.fOY.notifyDataSetChanged();
    }

    public void jR(boolean z) {
        this.dyk.setEnabled(z);
    }

    public void jS(boolean z) {
        this.fxB = z;
        if (z) {
            this.dwJ.setText(this.fOS.getResources().getString(R.string.load_more));
            if (this.fxt.getChildAt(this.fxt.getChildCount() - 1) == this.dwJ.getView()) {
                this.dwJ.startLoadData();
                this.fOS.aIW();
                return;
            }
            this.dwJ.endLoadData();
            return;
        }
        this.dwJ.setText(this.fOS.getResources().getString(R.string.load_more_must_after_delete));
        this.dwJ.endLoadData();
    }

    public boolean bla() {
        if (this.fxB) {
            return false;
        }
        this.dwJ.setText(this.fOS.getResources().getString(R.string.load_more_must_after_delete));
        this.dwJ.endLoadData();
        return true;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.fxt = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fxt.setLayoutManager(new LinearLayoutManager(this.fxt.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.fOS.getPageContext());
        this.fxt.setFadingEdgeLength(0);
        this.fxt.setOverScrollMode(2);
        this.fxt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.dwJ = new PbListView(this.fOS.getPageContext().getPageActivity());
        this.dwJ.createView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setHeight(com.baidu.adp.lib.util.l.getDimens(this.fOS.getActivity(), R.dimen.tbds182));
        this.dwJ.setLineGone();
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fxt.setOnSrollToBottomListener(this.fOS);
        if (this.dyk == null) {
            this.dyk = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dyk.setProgressView(this.mPullView);
            am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
        }
        this.bHI = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fOY = new f(this.fOS, this.fxt);
        fU(false);
        this.fOZ = new RelativeLayout(this.fOS.getContext());
        this.fOZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fPa = new com.baidu.tieba.frs.entelechy.c.a.a(this.fOS, this.fOZ);
        this.fxt.addHeaderView(this.fOZ, 0);
        this.fOS.registerListener(this.fwS);
        this.fOS.registerListener(this.fMU);
    }

    private void b(x xVar) {
        if (this.fMN == null) {
            this.fMN = new BannerView(this.fOS.getPageContext().getPageActivity());
            this.fMN.setLayoutParams(new AbsListView.LayoutParams(-1, this.fOS.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fMN.setVisibility(8);
            this.fMN.setBannerViewClickListener(this.fMT);
            this.fMN.setBannerData(xVar);
            this.fMN.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.fMN.asl() && !g.this.fMP && g.this.fxt != null) {
                        g.this.fMP = true;
                        g.this.fxt.addHeaderView(g.this.fMN, 1);
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
    public void boG() {
        if (this.czT != null) {
            String value = this.czT.getValue();
            if (this.czT.ahg() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.fOS.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.czT.ahg() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fOS.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fOS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.czT.ahg() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ckz != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ckz) {
                        case FRS:
                            this.fOS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fOS.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fOS.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fOS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.amQ().b(this.fOS.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.fOS.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.czT.ahg() == 4) {
                this.fOS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fOS.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fxt.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.fOY.a(sVar);
    }

    public void onDestroy() {
        this.fOY.onDestory();
        this.fxt.setOnSrollToBottomListener(null);
    }

    public void fU(boolean z) {
        if (!z) {
            this.dyk.setRefreshing(false);
        }
    }

    public void aMq() {
        this.fxt.setVisibility(0);
    }

    public void bkS() {
        if (this.fOY != null) {
            this.fOY.notifyDataSetChanged();
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
                if (frsViewData != null && this.fOS.bpw() != null && frsTabInfo != null) {
                    this.fOS.bpw().rx(frsTabInfo.tab_id.intValue());
                }
            } else if (this.fPa != null && frsViewData.getForum() != null) {
                this.fPa.setData(f, this.fOS.bpw().bpp());
                this.fPa.setFid(frsViewData.getForum().getId());
            }
        }
        this.fOY.b(arrayList2, frsViewData);
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
        return this.fxt;
    }

    public void boH() {
        this.fOY.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fxt.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fMP && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.czT = forumData.getFrsBannerData();
            b(this.czT);
            this.fMN.reset();
            this.fxt.removeHeaderView(this.fMN);
            if (this.czT.getType() == 1 && !TextUtils.isEmpty(this.czT.ahh())) {
                this.fMN.setData(this.fOS.getPageContext(), this.czT.ahh());
                if (this.czT.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.fOS.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void boI() {
        if (this.fMN != null) {
            this.fMP = false;
            this.fxt.removeHeaderView(this.fMN);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fOY != null) {
            this.fOY.bnd();
            this.fOY.notifyDataSetChanged();
            this.fOY.onChangeSkinType(i);
        }
        this.fOS.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fOS.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fMN != null) {
            this.fMN.asm();
        }
        if (this.dwJ != null) {
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dwJ.changeSkin(i);
        }
        am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
        this.fPa.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.dyk.setRefreshing(true);
    }

    public f bpy() {
        return this.fOY;
    }

    public RelativeLayout aYd() {
        return this.mContainer;
    }

    public View bme() {
        return this.dyk;
    }

    public void blg() {
        if (com.baidu.tbadk.p.m.awN().awO()) {
            int lastVisiblePosition = this.fxt.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fxt.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fyr != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.fyr.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.cLY = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fyr.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fyr.startLogPerf();
                    }
                    if (oVar.fyq != null && (oVar.fyq instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fyq;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.cLY = true;
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
    public void aKi() {
        this.fxt.setNextPage(this.dwJ);
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.startLoadData();
    }

    public void aKj() {
        this.fxt.setNextPage(this.dwJ);
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.endLoadData();
        this.dwJ.setText(this.fOS.getResources().getString(R.string.list_has_no_more));
    }

    public void aKk() {
        this.fxt.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bHI.setVisibility(z ? 0 : 8);
    }

    public void bjy() {
        this.fxt.smoothScrollToPosition(0);
    }

    public void wl(String str) {
        if (this.fOS.boD() != null) {
            this.fOS.boD().wn(str);
        }
    }

    public void wm(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.fOY.getDataList())) {
            Iterator<m> it = this.fOY.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAX() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAX()).bXk)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
