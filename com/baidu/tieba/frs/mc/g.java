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
import com.baidu.tbadk.core.data.bx;
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
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.s;
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
/* loaded from: classes22.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout eje;
    private ae foN;
    private PbListView gre;
    private RelativeLayout jbX;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jbY;
    private FrsNewAreaFragment jsg;
    private f jsm;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView iVD = null;
    private BannerView jpZ = null;
    private boolean jqb = false;
    private boolean iVK = true;
    private BannerView.a jqf = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bAv() {
            g.this.cIx();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bAw() {
            g.this.cIz();
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.jsm.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (q qVar : dataList) {
                        if (qVar instanceof bx) {
                            bx bxVar = (bx) qVar;
                            if (bxVar.eIP != 0 && bxVar.eCR != null) {
                                int[] imageWidthAndHeight = bxVar.eCR.getImageWidthAndHeight();
                                bxVar.eIP = imageWidthAndHeight[0];
                                bxVar.eIQ = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jsm.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jqg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Lx(str);
                g.this.Lw(str);
                g.this.jsm.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jsg = null;
        this.jsg = frsNewAreaFragment;
        cH(view);
    }

    public void refreshView() {
        this.jsm.notifyDataSetChanged();
    }

    public void qq(boolean z) {
        ac acVar = new ac();
        acVar.tabId = 503;
        acVar.fbE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, acVar));
    }

    public void qe(boolean z) {
        this.iVK = z;
        if (z) {
            this.gre.setText(this.jsg.getResources().getString(R.string.load_more));
            if (this.iVD.getChildAt(this.iVD.getChildCount() - 1) == this.gre.getView()) {
                this.gre.startLoadData();
                this.jsg.bRM();
                return;
            }
            this.gre.endLoadData();
            return;
        }
        this.gre.setText(this.jsg.getResources().getString(R.string.load_more_must_after_delete));
        this.gre.endLoadData();
    }

    public boolean cDA() {
        if (this.iVK) {
            return false;
        }
        this.gre.setText(this.jsg.getResources().getString(R.string.load_more_must_after_delete));
        this.gre.endLoadData();
        return true;
    }

    private void cH(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.iVD = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.iVD.setLayoutManager(new LinearLayoutManager(this.iVD.getContext()));
        this.iVD.setFadingEdgeLength(0);
        this.iVD.setOverScrollMode(2);
        this.iVD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        if (!com.baidu.tbadk.a.d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.iVD.setPadding(dimenPixelSize, this.iVD.getPaddingTop(), dimenPixelSize, this.iVD.getPaddingBottom());
        }
        this.gre = new PbListView(this.jsg.getPageContext().getPageActivity());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jsg.getActivity(), R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iVD.setOnSrollToBottomListener(this.jsg);
        this.eje = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jsm = new f(this.jsg, this.iVD);
        lx(false);
        this.jbX = new RelativeLayout(this.jsg.getContext());
        this.jbX.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jbY = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jsg, this.jbX);
        this.jsg.registerListener(this.iUK);
        this.jsg.registerListener(this.jqg);
    }

    private void b(ae aeVar) {
        if (this.jpZ == null) {
            this.jpZ = new BannerView(this.jsg.getPageContext().getPageActivity());
            this.jpZ.setLayoutParams(new AbsListView.LayoutParams(-1, this.jsg.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jpZ.setVisibility(8);
            this.jpZ.setBannerViewClickListener(this.jqf);
            this.jpZ.setBannerData(aeVar);
            this.jpZ.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jpZ.bAt() && !g.this.jqb && g.this.iVD != null) {
                        g.this.jqb = true;
                        g.this.iVD.addHeaderView(g.this.jpZ, 1);
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
    public void cIx() {
        if (this.foN != null) {
            String value = this.foN.getValue();
            if (this.foN.bnb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jsg.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.foN.bnb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jsg.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jsg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.foN.bnb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eUu != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eUu) {
                        case FRS:
                            this.jsg.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jsg.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jsg.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jsg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bua().b(this.jsg.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jsg.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.foN.bnb() == 4) {
                this.jsg.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jsg.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iVD.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.jsm.a(abVar);
    }

    public void onDestroy() {
        this.jsm.onDestory();
        this.iVD.setOnSrollToBottomListener(null);
    }

    public void lx(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 503;
            uVar.fVi = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void cER() {
        u uVar = new u();
        uVar.tabId = 503;
        uVar.fVi = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void bYs() {
        this.iVD.setVisibility(0);
    }

    public void cDr() {
        if (this.jsm != null) {
            this.jsm.notifyDataSetChanged();
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
                if (this.jbX != null) {
                    this.iVD.removeHeaderView(this.jbX);
                }
            } else if (this.jbX != null) {
                this.iVD.post(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.iVD.removeHeaderView(g.this.jbX);
                        g.this.iVD.addHeaderView(g.this.jbX, 0);
                    }
                });
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.jsg.cJu() != null && frsTabInfo != null) {
                    this.jsg.cJu().Bm(frsTabInfo.tab_id.intValue());
                }
            } else if (this.jbY != null && frsViewData.getForum() != null) {
                this.jbY.setData(f);
                this.jbY.setFid(frsViewData.getForum().getId());
            }
        }
        this.jsm.b(arrayList2, frsViewData);
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
        return this.iVD;
    }

    public void cIy() {
        this.jsm.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.iVD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jqb && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.foN = forumData.getFrsBannerData();
            b(this.foN);
            this.jpZ.reset();
            this.iVD.removeHeaderView(this.jpZ);
            if (this.foN.getType() == 1 && !TextUtils.isEmpty(this.foN.bnc())) {
                this.jpZ.setData(this.jsg.getPageContext(), this.foN.bnc());
                if (this.foN.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jsg.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cIz() {
        if (this.jpZ != null) {
            this.jqb = false;
            this.iVD.removeHeaderView(this.jpZ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jsm != null) {
            this.jsm.cGb();
            this.jsm.notifyDataSetChanged();
            this.jsm.onChangeSkinType(i);
        }
        this.jsg.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jsg.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jpZ != null) {
            this.jpZ.bAu();
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        this.jbY.onChangeSkinType();
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 503;
        uVar.fVi = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public f cJw() {
        return this.jsm;
    }

    public RelativeLayout cnn() {
        return this.mContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XZ() {
        this.iVD.setNextPage(this.gre);
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.startLoadData();
    }

    public void Ya() {
        this.iVD.setNextPage(this.gre);
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.endLoadData();
        this.gre.setText(this.jsg.getResources().getString(R.string.list_has_no_more));
    }

    public void bTa() {
        this.iVD.setNextPage(null);
    }

    public void qr(boolean z) {
        this.eje.setVisibility(z ? 0 : 8);
    }

    public void cBL() {
        this.iVD.smoothScrollToPosition(0);
    }

    public void Lw(String str) {
        if (this.jsg.cIu() != null) {
            this.jsg.cIu().Ly(str);
        }
    }

    public void Lx(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jsm.getDataList())) {
            Iterator<q> it = this.jsm.getDataList().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bKv() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bKv()).eEd)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
