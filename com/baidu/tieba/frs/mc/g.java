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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad;
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
/* loaded from: classes21.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout ecd;
    private ae fhn;
    private PbListView giV;
    private RelativeLayout iRf;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a iRg;
    private FrsNewAreaFragment jeD;
    private f jeJ;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView iKK = null;
    private BannerView jcw = null;
    private boolean jcy = false;
    private boolean iKR = true;
    private BannerView.a jcC = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bwV() {
            g.this.cDk();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bwW() {
            g.this.cDm();
        }
    };
    private CustomMessageListener iJS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.jeJ.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bw) {
                            bw bwVar = (bw) qVar;
                            if (bwVar.eBO != 0 && bwVar.evQ != null) {
                                int[] imageWidthAndHeight = bwVar.evQ.getImageWidthAndHeight();
                                bwVar.eBO = imageWidthAndHeight[0];
                                bwVar.eBP = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jeJ.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jcD = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Kq(str);
                g.this.Kp(str);
                g.this.jeJ.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jeD = null;
        this.jeD = frsNewAreaFragment;
        cA(view);
    }

    public void refreshView() {
        this.jeJ.notifyDataSetChanged();
    }

    public void pT(boolean z) {
        ad adVar = new ad();
        adVar.tabId = 503;
        adVar.eUh = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void pH(boolean z) {
        this.iKR = z;
        if (z) {
            this.giV.setText(this.jeD.getResources().getString(R.string.load_more));
            if (this.iKK.getChildAt(this.iKK.getChildCount() - 1) == this.giV.getView()) {
                this.giV.startLoadData();
                this.jeD.bOb();
                return;
            }
            this.giV.endLoadData();
            return;
        }
        this.giV.setText(this.jeD.getResources().getString(R.string.load_more_must_after_delete));
        this.giV.endLoadData();
    }

    public boolean czj() {
        if (this.iKR) {
            return false;
        }
        this.giV.setText(this.jeD.getResources().getString(R.string.load_more_must_after_delete));
        this.giV.endLoadData();
        return true;
    }

    private void cA(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.iKK = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.iKK.setLayoutManager(new LinearLayoutManager(this.iKK.getContext()));
        this.iKK.setFadingEdgeLength(0);
        this.iKK.setOverScrollMode(2);
        this.iKK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        if (!com.baidu.tbadk.a.d.bhw()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.iKK.setPadding(dimenPixelSize, this.iKK.getTop(), dimenPixelSize, this.iKK.getBottom());
        }
        this.giV = new PbListView(this.jeD.getPageContext().getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jeD.getActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iKK.setOnSrollToBottomListener(this.jeD);
        this.ecd = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jeJ = new f(this.jeD, this.iKK);
        ld(false);
        this.iRf = new RelativeLayout(this.jeD.getContext());
        this.iRf.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iRg = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jeD, this.iRf);
        this.jeD.registerListener(this.iJS);
        this.jeD.registerListener(this.jcD);
    }

    private void b(ae aeVar) {
        if (this.jcw == null) {
            this.jcw = new BannerView(this.jeD.getPageContext().getPageActivity());
            this.jcw.setLayoutParams(new AbsListView.LayoutParams(-1, this.jeD.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jcw.setVisibility(8);
            this.jcw.setBannerViewClickListener(this.jcC);
            this.jcw.setBannerData(aeVar);
            this.jcw.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jcw.bwT() && !g.this.jcy && g.this.iKK != null) {
                        g.this.jcy = true;
                        g.this.iKK.addHeaderView(g.this.jcw, 1);
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
    public void cDk() {
        if (this.fhn != null) {
            String value = this.fhn.getValue();
            if (this.fhn.bjO() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jeD.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fhn.bjO() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jeD.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jeD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fhn.bjO() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eNi != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eNi) {
                        case FRS:
                            this.jeD.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jeD.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jeD.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jeD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bqF().b(this.jeD.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jeD.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fhn.bjO() == 4) {
                this.jeD.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jeD.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iKK.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.jeJ.a(abVar);
    }

    public void onDestroy() {
        this.jeJ.onDestory();
        this.iKK.setOnSrollToBottomListener(null);
    }

    public void ld(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 503;
            vVar.fNx = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cAB() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fNx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bUJ() {
        this.iKK.setVisibility(0);
    }

    public void cza() {
        if (this.jeJ != null) {
            this.jeJ.notifyDataSetChanged();
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
                if (this.iRf != null) {
                    this.iKK.removeHeaderView(this.iRf);
                }
            } else if (this.iRf != null) {
                this.iKK.post(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.iKK.removeHeaderView(g.this.iRf);
                        g.this.iKK.addHeaderView(g.this.iRf, 0);
                    }
                });
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.jeD.cEh() != null && frsTabInfo != null) {
                    this.jeD.cEh().Ay(frsTabInfo.tab_id.intValue());
                }
            } else if (this.iRg != null && frsViewData.getForum() != null) {
                this.iRg.setData(f);
                this.iRg.setFid(frsViewData.getForum().getId());
            }
        }
        this.jeJ.b(arrayList2, frsViewData);
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
        return this.iKK;
    }

    public void cDl() {
        this.jeJ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.iKK.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jcy && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fhn = forumData.getFrsBannerData();
            b(this.fhn);
            this.jcw.reset();
            this.iKK.removeHeaderView(this.jcw);
            if (this.fhn.getType() == 1 && !TextUtils.isEmpty(this.fhn.bjP())) {
                this.jcw.setData(this.jeD.getPageContext(), this.fhn.bjP());
                if (this.fhn.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jeD.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cDm() {
        if (this.jcw != null) {
            this.jcy = false;
            this.iKK.removeHeaderView(this.jcw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jeJ != null) {
            this.jeJ.cBI();
            this.jeJ.notifyDataSetChanged();
            this.jeJ.onChangeSkinType(i);
        }
        this.jeD.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jeD.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jcw != null) {
            this.jcw.bwU();
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
        this.iRg.onChangeSkinType();
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fNx = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public f cEj() {
        return this.jeJ;
    }

    public RelativeLayout cjt() {
        return this.mContainer;
    }

    public void czp() {
        if (com.baidu.tbadk.n.m.bBK().isSmallFlow()) {
            int lastVisiblePosition = this.iKK.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iKK.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.iLH != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.iLH.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fup = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.iLH.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.iLH.startLogPerf();
                    }
                    if (uVar.iLG != null && (uVar.iLG instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.iLG;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fup = true;
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
    public void Vz() {
        this.iKK.setNextPage(this.giV);
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.startLoadData();
    }

    public void VA() {
        this.iKK.setNextPage(this.giV);
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.endLoadData();
        this.giV.setText(this.jeD.getResources().getString(R.string.list_has_no_more));
    }

    public void bPp() {
        this.iKK.setNextPage(null);
    }

    public void pU(boolean z) {
        this.ecd.setVisibility(z ? 0 : 8);
    }

    public void cxv() {
        this.iKK.smoothScrollToPosition(0);
    }

    public void Kp(String str) {
        if (this.jeD.cDh() != null) {
            this.jeD.cDh().Kr(str);
        }
    }

    public void Kq(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jeJ.getDataList())) {
            Iterator<q> it = this.jeJ.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bGV() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bGV()).exc)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
