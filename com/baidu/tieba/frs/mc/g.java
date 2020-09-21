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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
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
    private FrameLayout dDw;
    private ad eHL;
    private PbListView fHm;
    private RelativeLayout ijc;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a ijd;
    private FrsNewAreaFragment iwE;
    private f iwK;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView icD = null;
    private BannerView iuy = null;
    private boolean iuA = false;
    private boolean icK = true;
    private BannerView.a iuD = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bqD() {
            g.this.cuB();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bqE() {
            g.this.cuD();
        }
    };
    private CustomMessageListener ibK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.iwK.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bv) {
                            bv bvVar = (bv) qVar;
                            if (bvVar.edd != 0 && bvVar.dXg != null) {
                                int[] imageWidthAndHeight = bvVar.dXg.getImageWidthAndHeight();
                                bvVar.edd = imageWidthAndHeight[0];
                                bvVar.ede = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.iwK.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener iuE = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Jm(str);
                g.this.Jl(str);
                g.this.iwK.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.iwE = null;
        this.iwE = frsNewAreaFragment;
        cj(view);
    }

    public void refreshView() {
        this.iwK.notifyDataSetChanged();
    }

    public void oK(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 503;
        adVar.euE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void oy(boolean z) {
        this.icK = z;
        if (z) {
            this.fHm.setText(this.iwE.getResources().getString(R.string.load_more));
            if (this.icD.getChildAt(this.icD.getChildCount() - 1) == this.fHm.getView()) {
                this.fHm.startLoadData();
                this.iwE.bGU();
                return;
            }
            this.fHm.endLoadData();
            return;
        }
        this.fHm.setText(this.iwE.getResources().getString(R.string.load_more_must_after_delete));
        this.fHm.endLoadData();
    }

    public boolean cqA() {
        if (this.icK) {
            return false;
        }
        this.fHm.setText(this.iwE.getResources().getString(R.string.load_more_must_after_delete));
        this.fHm.endLoadData();
        return true;
    }

    private void cj(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.icD = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.icD.setLayoutManager(new LinearLayoutManager(this.icD.getContext()));
        this.icD.setFadingEdgeLength(0);
        this.icD.setOverScrollMode(2);
        this.icD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.fHm = new PbListView(this.iwE.getPageContext().getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iwE.getActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.icD.setOnSrollToBottomListener(this.iwE);
        this.dDw = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.iwK = new f(this.iwE, this.icD);
        ki(false);
        this.ijc = new RelativeLayout(this.iwE.getContext());
        this.ijc.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ijd = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.iwE, this.ijc);
        this.iwE.registerListener(this.ibK);
        this.iwE.registerListener(this.iuE);
    }

    private void b(ad adVar) {
        if (this.iuy == null) {
            this.iuy = new BannerView(this.iwE.getPageContext().getPageActivity());
            this.iuy.setLayoutParams(new AbsListView.LayoutParams(-1, this.iwE.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.iuy.setVisibility(8);
            this.iuy.setBannerViewClickListener(this.iuD);
            this.iuy.setBannerData(adVar);
            this.iuy.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.iuy.bqB() && !g.this.iuA && g.this.icD != null) {
                        g.this.iuA = true;
                        g.this.icD.addHeaderView(g.this.iuy, 1);
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
    public void cuB() {
        if (this.eHL != null) {
            String value = this.eHL.getValue();
            if (this.eHL.bdK() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.iwE.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eHL.bdK() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.iwE.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.iwE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eHL.bdK() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.enL != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.enL) {
                        case FRS:
                            this.iwE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iwE.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.iwE.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.iwE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bkp().b(this.iwE.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iwE.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eHL.bdK() == 4) {
                this.iwE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iwE.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.icD.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.iwK.a(abVar);
    }

    public void onDestroy() {
        this.iwK.onDestory();
        this.icD.setOnSrollToBottomListener(null);
    }

    public void ki(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 503;
            vVar.fnv = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void crS() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fnv = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bMD() {
        this.icD.setVisibility(0);
    }

    public void cqr() {
        if (this.iwK != null) {
            this.iwK.notifyDataSetChanged();
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
                if (this.ijc != null) {
                    this.icD.removeHeaderView(this.ijc);
                }
            } else if (this.ijc != null) {
                this.icD.removeHeaderView(this.ijc);
                this.icD.addHeaderView(this.ijc, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.iwE.cvy() != null && frsTabInfo != null) {
                    this.iwE.cvy().yO(frsTabInfo.tab_id.intValue());
                }
            } else if (this.ijd != null && frsViewData.getForum() != null) {
                this.ijd.setData(f);
                this.ijd.setFid(frsViewData.getForum().getId());
            }
        }
        this.iwK.b(arrayList2, frsViewData);
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
        return this.icD;
    }

    public void cuC() {
        this.iwK.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.icD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.iuA && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eHL = forumData.getFrsBannerData();
            b(this.eHL);
            this.iuy.reset();
            this.icD.removeHeaderView(this.iuy);
            if (this.eHL.getType() == 1 && !TextUtils.isEmpty(this.eHL.bdL())) {
                this.iuy.setData(this.iwE.getPageContext(), this.eHL.bdL());
                if (this.eHL.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iwE.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cuD() {
        if (this.iuy != null) {
            this.iuA = false;
            this.icD.removeHeaderView(this.iuy);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwK != null) {
            this.iwK.cta();
            this.iwK.notifyDataSetChanged();
            this.iwK.onChangeSkinType(i);
        }
        this.iwE.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iwE.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.iuy != null) {
            this.iuy.bqC();
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        this.ijd.onChangeSkinType();
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 503;
        vVar.fnv = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public f cvA() {
        return this.iwK;
    }

    public RelativeLayout caY() {
        return this.mContainer;
    }

    public void cqG() {
        if (com.baidu.tbadk.n.m.bvs().bvt()) {
            int lastVisiblePosition = this.icD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.icD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.idE != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.idE.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eUD = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.idE.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.idE.startLogPerf();
                    }
                    if (uVar.idD != null && (uVar.idD instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.idD;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eUD = true;
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
    public void bIi() {
        this.icD.setNextPage(this.fHm);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.startLoadData();
    }

    public void bIj() {
        this.icD.setNextPage(this.fHm);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.endLoadData();
        this.fHm.setText(this.iwE.getResources().getString(R.string.list_has_no_more));
    }

    public void bIk() {
        this.icD.setNextPage(null);
    }

    public void oL(boolean z) {
        this.dDw.setVisibility(z ? 0 : 8);
    }

    public void coM() {
        this.icD.smoothScrollToPosition(0);
    }

    public void Jl(String str) {
        if (this.iwE.cuy() != null) {
            this.iwE.cuy().Jn(str);
        }
    }

    public void Jm(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.iwK.getDataList())) {
            Iterator<q> it = this.iwK.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bAy() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bAy()).dYt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
