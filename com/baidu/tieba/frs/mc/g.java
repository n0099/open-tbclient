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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.u;
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
    private FrameLayout dlv;
    private ab eoN;
    private PbListView fnt;
    private RelativeLayout hHM;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a hHN;
    private FrsNewAreaFragment hVa;
    private f hVg;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hCj = null;
    private BannerView hSS = null;
    private boolean hSU = false;
    private boolean hCq = true;
    private BannerView.a hSX = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bdp() {
            g.this.cdh();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bdq() {
            g.this.cdj();
        }
    };
    private CustomMessageListener hBt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.hVg.getDataList();
            if (!w.isEmpty(dataList)) {
                if (!w.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bt) {
                            bt btVar = (bt) qVar;
                            if (btVar.dLj != 0 && btVar.dLi != null) {
                                int[] imageWidthAndHeight = btVar.dLi.getImageWidthAndHeight();
                                btVar.dLj = imageWidthAndHeight[0];
                                btVar.dLk = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.hVg.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener hSY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Fz(str);
                g.this.Fy(str);
                g.this.hVg.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.hVa = null;
        this.hVa = frsNewAreaFragment;
        bS(view);
    }

    public void refreshView() {
        this.hVg.notifyDataSetChanged();
    }

    public void nt(boolean z) {
        com.baidu.tieba.frs.ab abVar = new com.baidu.tieba.frs.ab();
        abVar.tabId = 503;
        abVar.ecu = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, abVar));
    }

    public void nh(boolean z) {
        this.hCq = z;
        if (z) {
            this.fnt.setText(this.hVa.getResources().getString(R.string.load_more));
            if (this.hCj.getChildAt(this.hCj.getChildCount() - 1) == this.fnt.getView()) {
                this.fnt.startLoadData();
                this.hVa.btv();
                return;
            }
            this.fnt.endLoadData();
            return;
        }
        this.fnt.setText(this.hVa.getResources().getString(R.string.load_more_must_after_delete));
        this.fnt.endLoadData();
    }

    public boolean bZt() {
        if (this.hCq) {
            return false;
        }
        this.fnt.setText(this.hVa.getResources().getString(R.string.load_more_must_after_delete));
        this.fnt.endLoadData();
        return true;
    }

    private void bS(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.hCj = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hCj.setLayoutManager(new LinearLayoutManager(this.hCj.getContext()));
        this.hCj.setFadingEdgeLength(0);
        this.hCj.setOverScrollMode(2);
        this.hCj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.fnt = new PbListView(this.hVa.getPageContext().getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hVa.getActivity(), R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hCj.setOnSrollToBottomListener(this.hVa);
        this.dlv = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hVg = new f(this.hVa, this.hCj);
        jc(false);
        this.hHM = new RelativeLayout(this.hVa.getContext());
        this.hHM.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hHN = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hVa, this.hHM);
        this.hVa.registerListener(this.hBt);
        this.hVa.registerListener(this.hSY);
    }

    private void b(ab abVar) {
        if (this.hSS == null) {
            this.hSS = new BannerView(this.hVa.getPageContext().getPageActivity());
            this.hSS.setLayoutParams(new AbsListView.LayoutParams(-1, this.hVa.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hSS.setVisibility(8);
            this.hSS.setBannerViewClickListener(this.hSX);
            this.hSS.setBannerData(abVar);
            this.hSS.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.hSS.bdn() && !g.this.hSU && g.this.hCj != null) {
                        g.this.hSU = true;
                        g.this.hCj.addHeaderView(g.this.hSS, 1);
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
    public void cdh() {
        if (this.eoN != null) {
            String value = this.eoN.getValue();
            if (this.eoN.aQB() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hVa.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eoN.aQB() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hVa.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hVa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eoN.aQB() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dVl != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dVl) {
                        case FRS:
                            this.hVa.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hVa.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hVa.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hVa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bc.aWU().b(this.hVa.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hVa.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eoN.aQB() == 4) {
                this.hVa.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hVa.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hCj.setOnScrollListener(onScrollListener);
    }

    public void a(z zVar) {
        this.hVg.a(zVar);
    }

    public void onDestroy() {
        this.hVg.onDestory();
        this.hCj.setOnSrollToBottomListener(null);
    }

    public void jc(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 503;
            uVar.eSL = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void caC() {
        u uVar = new u();
        uVar.tabId = 503;
        uVar.eSL = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void byK() {
        this.hCj.setVisibility(0);
    }

    public void bZk() {
        if (this.hVg != null) {
            this.hVg.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<q> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<q> arrayList2;
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            r rVar = new r();
            ArrayList<q> arrayList3 = new ArrayList<>();
            arrayList3.add(rVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (w.isEmpty(f)) {
                if (this.hHM != null) {
                    this.hCj.removeHeaderView(this.hHM);
                }
            } else if (this.hHM != null) {
                this.hCj.removeHeaderView(this.hHM);
                this.hCj.addHeaderView(this.hHM, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) w.getItem(f, 0);
                if (frsViewData != null && this.hVa.cef() != null && frsTabInfo != null) {
                    this.hVa.cef().vE(frsTabInfo.tab_id.intValue());
                }
            } else if (this.hHN != null && frsViewData.getForum() != null) {
                this.hHN.setData(f);
                this.hHN.setFid(frsViewData.getForum().getId());
            }
        }
        this.hVg.b(arrayList2, frsViewData);
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
        return this.hCj;
    }

    public void cdi() {
        this.hVg.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hCj.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hSU && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eoN = forumData.getFrsBannerData();
            b(this.eoN);
            this.hSS.reset();
            this.hCj.removeHeaderView(this.hSS);
            if (this.eoN.getType() == 1 && !TextUtils.isEmpty(this.eoN.aQC())) {
                this.hSS.setData(this.hVa.getPageContext(), this.eoN.aQC());
                if (this.eoN.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hVa.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cdj() {
        if (this.hSS != null) {
            this.hSU = false;
            this.hCj.removeHeaderView(this.hSS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hVg != null) {
            this.hVg.cbJ();
            this.hVg.notifyDataSetChanged();
            this.hVg.onChangeSkinType(i);
        }
        this.hVa.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hVa.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hSS != null) {
            this.hSS.bdo();
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
        this.hHN.onChangeSkinType();
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 503;
        uVar.eSL = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public f ceh() {
        return this.hVg;
    }

    public RelativeLayout bLT() {
        return this.mContainer;
    }

    public void bZz() {
        if (com.baidu.tbadk.n.m.bhP().bhQ()) {
            int lastVisiblePosition = this.hCj.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hCj.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof t)) {
                    t tVar = (t) childAt.getTag();
                    if (tVar.hDg != null) {
                        com.baidu.tbadk.n.h perfLog = tVar.hDg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eAN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            tVar.hDg.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        tVar.hDg.startLogPerf();
                    }
                    if (tVar.hDf != null && (tVar.hDf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = tVar.hDf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eAN = true;
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
    public void buJ() {
        this.hCj.setNextPage(this.fnt);
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.startLoadData();
    }

    public void buK() {
        this.hCj.setNextPage(this.fnt);
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.endLoadData();
        this.fnt.setText(this.hVa.getResources().getString(R.string.list_has_no_more));
    }

    public void buL() {
        this.hCj.setNextPage(null);
    }

    public void nu(boolean z) {
        this.dlv.setVisibility(z ? 0 : 8);
    }

    public void bXH() {
        this.hCj.smoothScrollToPosition(0);
    }

    public void Fy(String str) {
        if (this.hVa.cde() != null) {
            this.hVa.cde().FA(str);
        }
    }

    public void Fz(String str) {
        if (!StringUtils.isNull(str) && !w.isEmpty(this.hVg.getDataList())) {
            Iterator<q> it = this.hVg.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bmw() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bmw()).dGL)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
