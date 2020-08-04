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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ab;
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
/* loaded from: classes16.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout drp;
    private ac evc;
    private PbListView fsC;
    private RelativeLayout hNN;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a hNO;
    private FrsNewAreaFragment ibb;
    private f ibh;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hIh = null;
    private BannerView hYT = null;
    private boolean hYV = false;
    private boolean hIo = true;
    private BannerView.a hYY = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bgW() {
            g.this.cgG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bgX() {
            g.this.cgI();
        }
    };
    private CustomMessageListener hHo = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.ibh.getDataList();
            if (!x.isEmpty(dataList)) {
                if (!x.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bu) {
                            bu buVar = (bu) qVar;
                            if (buVar.dRu != 0 && buVar.dLK != null) {
                                int[] imageWidthAndHeight = buVar.dLK.getImageWidthAndHeight();
                                buVar.dRu = imageWidthAndHeight[0];
                                buVar.dRv = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.ibh.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener hYZ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Gl(str);
                g.this.Gk(str);
                g.this.ibh.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.ibb = null;
        this.ibb = frsNewAreaFragment;
        bY(view);
    }

    public void refreshView() {
        this.ibh.notifyDataSetChanged();
    }

    public void nY(boolean z) {
        ab abVar = new ab();
        abVar.tabId = 503;
        abVar.eiE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, abVar));
    }

    public void nM(boolean z) {
        this.hIo = z;
        if (z) {
            this.fsC.setText(this.ibb.getResources().getString(R.string.load_more));
            if (this.hIh.getChildAt(this.hIh.getChildCount() - 1) == this.fsC.getView()) {
                this.fsC.startLoadData();
                this.ibb.bwE();
                return;
            }
            this.fsC.endLoadData();
            return;
        }
        this.fsC.setText(this.ibb.getResources().getString(R.string.load_more_must_after_delete));
        this.fsC.endLoadData();
    }

    public boolean ccQ() {
        if (this.hIo) {
            return false;
        }
        this.fsC.setText(this.ibb.getResources().getString(R.string.load_more_must_after_delete));
        this.fsC.endLoadData();
        return true;
    }

    private void bY(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.hIh = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hIh.setLayoutManager(new LinearLayoutManager(this.hIh.getContext()));
        this.hIh.setFadingEdgeLength(0);
        this.hIh.setOverScrollMode(2);
        this.hIh.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.fsC = new PbListView(this.ibb.getPageContext().getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(com.baidu.adp.lib.util.l.getDimens(this.ibb.getActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hIh.setOnSrollToBottomListener(this.ibb);
        this.drp = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.ibh = new f(this.ibb, this.hIh);
        jH(false);
        this.hNN = new RelativeLayout(this.ibb.getContext());
        this.hNN.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hNO = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.ibb, this.hNN);
        this.ibb.registerListener(this.hHo);
        this.ibb.registerListener(this.hYZ);
    }

    private void b(ac acVar) {
        if (this.hYT == null) {
            this.hYT = new BannerView(this.ibb.getPageContext().getPageActivity());
            this.hYT.setLayoutParams(new AbsListView.LayoutParams(-1, this.ibb.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hYT.setVisibility(8);
            this.hYT.setBannerViewClickListener(this.hYY);
            this.hYT.setBannerData(acVar);
            this.hYT.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.hYT.bgU() && !g.this.hYV && g.this.hIh != null) {
                        g.this.hYV = true;
                        g.this.hIh.addHeaderView(g.this.hYT, 1);
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
    public void cgG() {
        if (this.evc != null) {
            String value = this.evc.getValue();
            if (this.evc.aUx() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.ibb.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.evc.aUx() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.ibb.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.ibb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.evc.aUx() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ebG != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ebG) {
                        case FRS:
                            this.ibb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ibb.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.ibb.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.ibb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bd.baV().b(this.ibb.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.ibb.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.evc.aUx() == 4) {
                this.ibb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ibb.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hIh.setOnScrollListener(onScrollListener);
    }

    public void a(z zVar) {
        this.ibh.a(zVar);
    }

    public void onDestroy() {
        this.ibh.onDestory();
        this.hIh.setOnSrollToBottomListener(null);
    }

    public void jH(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 503;
            uVar.eZg = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void cea() {
        u uVar = new u();
        uVar.tabId = 503;
        uVar.eZg = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void bBY() {
        this.hIh.setVisibility(0);
    }

    public void ccH() {
        if (this.ibh != null) {
            this.ibh.notifyDataSetChanged();
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
            if (x.isEmpty(f)) {
                if (this.hNN != null) {
                    this.hIh.removeHeaderView(this.hNN);
                }
            } else if (this.hNN != null) {
                this.hIh.removeHeaderView(this.hNN);
                this.hIh.addHeaderView(this.hNN, 0);
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) x.getItem(f, 0);
                if (frsViewData != null && this.ibb.chE() != null && frsTabInfo != null) {
                    this.ibb.chE().vW(frsTabInfo.tab_id.intValue());
                }
            } else if (this.hNO != null && frsViewData.getForum() != null) {
                this.hNO.setData(f);
                this.hNO.setFid(frsViewData.getForum().getId());
            }
        }
        this.ibh.b(arrayList2, frsViewData);
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
        return this.hIh;
    }

    public void cgH() {
        this.ibh.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hIh.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hYV && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.evc = forumData.getFrsBannerData();
            b(this.evc);
            this.hYT.reset();
            this.hIh.removeHeaderView(this.hYT);
            if (this.evc.getType() == 1 && !TextUtils.isEmpty(this.evc.aUy())) {
                this.hYT.setData(this.ibb.getPageContext(), this.evc.aUy());
                if (this.evc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.ibb.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cgI() {
        if (this.hYT != null) {
            this.hYV = false;
            this.hIh.removeHeaderView(this.hYT);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ibh != null) {
            this.ibh.cfh();
            this.ibh.notifyDataSetChanged();
            this.ibh.onChangeSkinType(i);
        }
        this.ibb.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ibb.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hYT != null) {
            this.hYT.bgV();
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        this.hNO.onChangeSkinType();
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 503;
        uVar.eZg = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public f chG() {
        return this.ibh;
    }

    public RelativeLayout bPb() {
        return this.mContainer;
    }

    public void ccW() {
        if (com.baidu.tbadk.n.m.blA().blB()) {
            int lastVisiblePosition = this.hIh.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hIh.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof t)) {
                    t tVar = (t) childAt.getTag();
                    if (tVar.hJe != null) {
                        com.baidu.tbadk.n.h perfLog = tVar.hJe.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eHc = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            tVar.hJe.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        tVar.hJe.startLogPerf();
                    }
                    if (tVar.hJd != null && (tVar.hJd instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = tVar.hJd;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eHc = true;
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
    public void bxS() {
        this.hIh.setNextPage(this.fsC);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.startLoadData();
    }

    public void bxT() {
        this.hIh.setNextPage(this.fsC);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.endLoadData();
        this.fsC.setText(this.ibb.getResources().getString(R.string.list_has_no_more));
    }

    public void bxU() {
        this.hIh.setNextPage(null);
    }

    public void nZ(boolean z) {
        this.drp.setVisibility(z ? 0 : 8);
    }

    public void cbd() {
        this.hIh.smoothScrollToPosition(0);
    }

    public void Gk(String str) {
        if (this.ibb.cgD() != null) {
            this.ibb.cgD().Gm(str);
        }
    }

    public void Gl(String str) {
        if (!StringUtils.isNull(str) && !x.isEmpty(this.ibh.getDataList())) {
            Iterator<q> it = this.ibh.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bqq() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bqq()).dMW)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
