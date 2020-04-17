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
    private FrameLayout cVD;
    private y dRD;
    private PbListView ePm;
    private RelativeLayout hfR;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a hfS;
    private FrsNewAreaFragment hsh;
    private f hsn;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hau = null;
    private BannerView hpY = null;
    private boolean hqa = false;
    private boolean haD = true;
    private BannerView.a hqd = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVe() {
            g.this.bTq();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVf() {
            g.this.bTs();
        }
    };
    private CustomMessageListener gZO = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.m> dataList = g.this.hsn.getDataList();
            if (!v.isEmpty(dataList)) {
                if (!v.isEmpty(dataList)) {
                    for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                        if (mVar instanceof bi) {
                            bi biVar = (bi) mVar;
                            if (biVar.dqB != 0 && biVar.dqA != null) {
                                int[] imageWidthAndHeight = biVar.dqA.getImageWidthAndHeight();
                                biVar.dqB = imageWidthAndHeight[0];
                                biVar.dqC = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.hsn.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener hqe = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Dm(str);
                g.this.Dl(str);
                g.this.hsn.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.hsh = null;
        this.hsh = frsNewAreaFragment;
        bP(view);
    }

    public void refreshView() {
        this.hsn.notifyDataSetChanged();
    }

    public void mN(boolean z) {
        com.baidu.tieba.frs.y yVar = new com.baidu.tieba.frs.y();
        yVar.tabId = 503;
        yVar.dGN = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    public void mB(boolean z) {
        this.haD = z;
        if (z) {
            this.ePm.setText(this.hsh.getResources().getString(R.string.load_more));
            if (this.hau.getChildAt(this.hau.getChildCount() - 1) == this.ePm.getView()) {
                this.ePm.startLoadData();
                this.hsh.blb();
                return;
            }
            this.ePm.endLoadData();
            return;
        }
        this.ePm.setText(this.hsh.getResources().getString(R.string.load_more_must_after_delete));
        this.ePm.endLoadData();
    }

    public boolean bPN() {
        if (this.haD) {
            return false;
        }
        this.ePm.setText(this.hsh.getResources().getString(R.string.load_more_must_after_delete));
        this.ePm.endLoadData();
        return true;
    }

    private void bP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.hau = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hau.setLayoutManager(new LinearLayoutManager(this.hau.getContext()));
        this.hau.setFadingEdgeLength(0);
        this.hau.setOverScrollMode(2);
        this.hau.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.ePm = new PbListView(this.hsh.getPageContext().getPageActivity());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hsh.getActivity(), R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hau.setOnSrollToBottomListener(this.hsh);
        this.cVD = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hsn = new f(this.hsh, this.hau);
        it(false);
        this.hfR = new RelativeLayout(this.hsh.getContext());
        this.hfR.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hfS = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hsh, this.hfR);
        this.hsh.registerListener(this.gZO);
        this.hsh.registerListener(this.hqe);
    }

    private void b(y yVar) {
        if (this.hpY == null) {
            this.hpY = new BannerView(this.hsh.getPageContext().getPageActivity());
            this.hpY.setLayoutParams(new AbsListView.LayoutParams(-1, this.hsh.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hpY.setVisibility(8);
            this.hpY.setBannerViewClickListener(this.hqd);
            this.hpY.setBannerData(yVar);
            this.hpY.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.hpY.aVc() && !g.this.hqa && g.this.hau != null) {
                        g.this.hqa = true;
                        g.this.hau.addHeaderView(g.this.hpY, 1);
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
    public void bTq() {
        if (this.dRD != null) {
            String value = this.dRD.getValue();
            if (this.dRD.aIX() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hsh.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dRD.aIX() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hsh.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hsh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dRD.aIX() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dAj != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dAj) {
                        case FRS:
                            this.hsh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hsh.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hsh.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hsh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aOY().b(this.hsh.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hsh.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dRD.aIX() == 4) {
                this.hsh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hsh.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hau.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.hsn.a(vVar);
    }

    public void onDestroy() {
        this.hsn.onDestory();
        this.hau.setOnSrollToBottomListener(null);
    }

    public void it(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 503;
            sVar.etK = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bQT() {
        s sVar = new s();
        sVar.tabId = 503;
        sVar.etK = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bpV() {
        this.hau.setVisibility(0);
    }

    public void bPE() {
        if (this.hsn != null) {
            this.hsn.notifyDataSetChanged();
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
                if (this.hfR != null) {
                    this.hau.removeHeaderView(this.hfR);
                }
            } else if (this.hfR != null) {
                this.hau.removeHeaderView(this.hfR);
                this.hau.addHeaderView(this.hfR, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) v.getItem(f, 0);
                if (frsViewData != null && this.hsh.bUh() != null && frsTabInfo != null) {
                    this.hsh.bUh().ur(frsTabInfo.tab_id.intValue());
                }
            } else if (this.hfS != null && frsViewData.getForum() != null) {
                this.hfS.setData(f);
                this.hfS.setFid(frsViewData.getForum().getId());
            }
        }
        this.hsn.b(arrayList2, frsViewData);
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
        return this.hau;
    }

    public void bTr() {
        this.hsn.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hau.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hqa && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dRD = forumData.getFrsBannerData();
            b(this.dRD);
            this.hpY.reset();
            this.hau.removeHeaderView(this.hpY);
            if (this.dRD.getType() == 1 && !TextUtils.isEmpty(this.dRD.aIY())) {
                this.hpY.setData(this.hsh.getPageContext(), this.dRD.aIY());
                if (this.dRD.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hsh.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bTs() {
        if (this.hpY != null) {
            this.hqa = false;
            this.hau.removeHeaderView(this.hpY);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hsn != null) {
            this.hsn.bRW();
            this.hsn.notifyDataSetChanged();
            this.hsn.onChangeSkinType(i);
        }
        this.hsh.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hsh.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hpY != null) {
            this.hpY.aVd();
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        this.hfS.onChangeSkinType();
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 503;
        sVar.etK = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public f bUj() {
        return this.hsn;
    }

    public RelativeLayout bCt() {
        return this.mContainer;
    }

    public void bPT() {
        if (com.baidu.tbadk.n.m.aZA().aZB()) {
            int lastVisiblePosition = this.hau.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hau.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hbs != null) {
                        com.baidu.tbadk.n.h perfLog = rVar.hbs.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.edD = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hbs.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hbs.startLogPerf();
                    }
                    if (rVar.hbr != null && (rVar.hbr instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hbr;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.edD = true;
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
    public void bmo() {
        this.hau.setNextPage(this.ePm);
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.startLoadData();
    }

    public void bmp() {
        this.hau.setNextPage(this.ePm);
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.endLoadData();
        this.ePm.setText(this.hsh.getResources().getString(R.string.list_has_no_more));
    }

    public void bmq() {
        this.hau.setNextPage(null);
    }

    public void mO(boolean z) {
        this.cVD.setVisibility(z ? 0 : 8);
    }

    public void bOe() {
        this.hau.smoothScrollToPosition(0);
    }

    public void Dl(String str) {
        if (this.hsh.bTn() != null) {
            this.hsh.bTn().Dn(str);
        }
    }

    public void Dm(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.hsn.getDataList())) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hsn.getDataList().iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bdL() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bdL()).dmo)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
