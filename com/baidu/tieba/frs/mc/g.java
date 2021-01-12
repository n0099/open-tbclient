package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.w;
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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout ent;
    private ae ftO;
    private PbListView gxy;
    private f jAd;
    private RelativeLayout jjJ;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jjK;
    private FrsNewAreaFragment jzX;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jdk = null;
    private BannerView jxS = null;
    private boolean jxU = false;
    private boolean jdr = true;
    private BannerView.a jxY = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void byW() {
            g.this.cHH();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void byX() {
            g.this.cHJ();
        }
    };
    private CustomMessageListener jcr = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.n> dataList = g.this.jAd.getDataList();
            if (!x.isEmpty(dataList)) {
                if (!x.isEmpty(dataList)) {
                    for (com.baidu.adp.widget.ListView.n nVar : dataList) {
                        if (nVar instanceof by) {
                            by byVar = (by) nVar;
                            if (byVar.eNX != 0 && byVar.eHK != null) {
                                int[] imageWidthAndHeight = byVar.eHK.getImageWidthAndHeight();
                                byVar.eNX = imageWidthAndHeight[0];
                                byVar.eNY = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jAd.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Km(str);
                g.this.Kl(str);
                g.this.jAd.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jzX = null;
        this.jzX = frsNewAreaFragment;
        cR(view);
    }

    public void refreshView() {
        this.jAd.notifyDataSetChanged();
    }

    public void qK(boolean z) {
        z zVar = new z();
        zVar.tabId = 503;
        zVar.fgC = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    public void qy(boolean z) {
        this.jdr = z;
        if (z) {
            this.gxy.setText(this.jzX.getResources().getString(R.string.load_more));
            if (this.jdk.getChildAt(this.jdk.getChildCount() - 1) == this.gxy.getView()) {
                this.gxy.startLoadData();
                this.jzX.bQy();
                return;
            }
            this.gxy.endLoadData();
            return;
        }
        this.gxy.setText(this.jzX.getResources().getString(R.string.load_more_must_after_delete));
        this.gxy.endLoadData();
    }

    public boolean cCE() {
        if (this.jdr) {
            return false;
        }
        this.gxy.setText(this.jzX.getResources().getString(R.string.load_more_must_after_delete));
        this.gxy.endLoadData();
        return true;
    }

    private void cR(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.jdk = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jdk.setLayoutManager(new LinearLayoutManager(this.jdk.getContext()));
        this.jdk.setFadingEdgeLength(0);
        this.jdk.setOverScrollMode(2);
        this.jdk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
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
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jdk.setPadding(dimenPixelSize, this.jdk.getPaddingTop(), dimenPixelSize, this.jdk.getPaddingBottom());
        this.gxy = new PbListView(this.jzX.getPageContext().getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jzX.getActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jdk.setOnSrollToBottomListener(this.jzX);
        this.ent = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jAd = new f(this.jzX, this.jdk);
        lQ(false);
        this.jjJ = new RelativeLayout(this.jzX.getContext());
        this.jjJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jjK = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jzX, this.jjJ);
        this.jzX.registerListener(this.jcr);
        this.jzX.registerListener(this.jjF);
    }

    private void b(ae aeVar) {
        if (this.jxS == null) {
            this.jxS = new BannerView(this.jzX.getPageContext().getPageActivity());
            this.jxS.setLayoutParams(new AbsListView.LayoutParams(-1, this.jzX.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jxS.setVisibility(8);
            this.jxS.setBannerViewClickListener(this.jxY);
            this.jxS.setBannerData(aeVar);
            this.jxS.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jxS.byU() && !g.this.jxU && g.this.jdk != null) {
                        g.this.jxU = true;
                        g.this.jdk.addHeaderView(g.this.jxS, 1);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cHH() {
        if (this.ftO != null) {
            String value = this.ftO.getValue();
            if (this.ftO.blH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jzX.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ftO.blH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jzX.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jzX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ftO.blH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eZi != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eZi) {
                        case FRS:
                            this.jzX.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jzX.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jzX.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jzX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bsB().b(this.jzX.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jzX.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.ftO.blH() == 4) {
                this.jzX.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jzX.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jdk.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jAd.a(wVar);
    }

    public void onDestroy() {
        this.jAd.onDestory();
        this.jdk.setOnSrollToBottomListener(null);
    }

    public void lQ(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 503;
            tVar.gae = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cDW() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.gae = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bXh() {
        this.jdk.setVisibility(0);
    }

    public void cCv() {
        if (this.jAd != null) {
            this.jAd.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            s sVar = new s();
            ArrayList<com.baidu.adp.widget.ListView.n> arrayList3 = new ArrayList<>();
            arrayList3.add(sVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (x.isEmpty(f)) {
                if (this.jjJ != null) {
                    this.jdk.removeHeaderView(this.jjJ);
                }
            } else if (this.jjJ != null) {
                this.jdk.post(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jdk.removeHeaderView(g.this.jjJ);
                        g.this.jdk.addHeaderView(g.this.jjJ, 0);
                    }
                });
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) x.getItem(f, 0);
                if (frsViewData != null && this.jzX.cIE() != null && frsTabInfo != null) {
                    this.jzX.cIE().zS(frsTabInfo.tab_id.intValue());
                }
            } else if (this.jjK != null && frsViewData.getForum() != null) {
                this.jjK.setData(f);
                this.jjK.setFid(frsViewData.getForum().getId());
                if (com.baidu.tbadk.a.d.bjf() && com.baidu.tbadk.a.b.a.eEj != com.baidu.tbadk.a.b.a.bjp()) {
                    this.jjK.iC(com.baidu.tieba.frs.d.j.Aj(com.baidu.tbadk.a.b.a.bjp()));
                }
            }
        }
        this.jAd.b(arrayList2, frsViewData);
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
        return this.jdk;
    }

    public void cHI() {
        this.jAd.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jdk.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jxU && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ftO = forumData.getFrsBannerData();
            b(this.ftO);
            this.jxS.reset();
            this.jdk.removeHeaderView(this.jxS);
            if (this.ftO.getType() == 1 && !TextUtils.isEmpty(this.ftO.blI())) {
                this.jxS.setData(this.jzX.getPageContext(), this.ftO.blI());
                if (this.ftO.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jzX.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cHJ() {
        if (this.jxS != null) {
            this.jxU = false;
            this.jdk.removeHeaderView(this.jxS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jAd != null) {
            this.jAd.cFk();
            this.jAd.notifyDataSetChanged();
            this.jAd.onChangeSkinType(i);
        }
        this.jzX.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jzX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jxS != null) {
            this.jxS.byV();
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        this.jjK.onChangeSkinType();
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.gae = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public f cIG() {
        return this.jAd;
    }

    public RelativeLayout cmp() {
        return this.mContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vo() {
        this.jdk.setNextPage(this.gxy);
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.startLoadData();
    }

    public void Vp() {
        this.jdk.setNextPage(this.gxy);
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.endLoadData();
        this.gxy.setText(this.jzX.getResources().getString(R.string.list_has_no_more));
    }

    public void bRO() {
        this.jdk.setNextPage(null);
    }

    public void qL(boolean z) {
        this.ent.setVisibility(z ? 0 : 8);
    }

    public void Kl(String str) {
        if (this.jzX.cHE() != null) {
            this.jzX.cHE().Kn(str);
        }
    }

    public void Km(String str) {
        if (!StringUtils.isNull(str) && !x.isEmpty(this.jAd.getDataList())) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jAd.getDataList().iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bIW() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bIW()).eJi)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
