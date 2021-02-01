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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ca;
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
    private FrameLayout epC;
    private af fwe;
    private PbListView gAi;
    private FrsNewAreaFragment jFB;
    private f jFH;
    private RelativeLayout jpq;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jpr;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jiR = null;
    private BannerView jDy = null;
    private boolean isAddBanner = false;
    private boolean jiY = true;
    private BannerView.a jDD = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzo() {
            g.this.cIU();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzp() {
            g.this.cIW();
        }
    };
    private CustomMessageListener jhX = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.n> dataList = g.this.jFH.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (com.baidu.adp.widget.ListView.n nVar : dataList) {
                        if (nVar instanceof ca) {
                            ca caVar = (ca) nVar;
                            if (caVar.eQj != 0 && caVar.eJQ != null) {
                                int[] imageWidthAndHeight = caVar.eJQ.getImageWidthAndHeight();
                                caVar.eQj = imageWidthAndHeight[0];
                                caVar.eQk = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jFH.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.KX(str);
                g.this.KW(str);
                g.this.jFH.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jFB = null;
        this.jFB = frsNewAreaFragment;
        cP(view);
    }

    public void refreshView() {
        this.jFH.notifyDataSetChanged();
    }

    public void qU(boolean z) {
        z zVar = new z();
        zVar.tabId = 503;
        zVar.fiV = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    public void qI(boolean z) {
        this.jiY = z;
        if (z) {
            this.gAi.setText(this.jFB.getResources().getString(R.string.load_more));
            if (this.jiR.getChildAt(this.jiR.getChildCount() - 1) == this.gAi.getView()) {
                this.gAi.startLoadData();
                this.jFB.bRc();
                return;
            }
            this.gAi.endLoadData();
            return;
        }
        this.gAi.setText(this.jFB.getResources().getString(R.string.load_more_must_after_delete));
        this.gAi.endLoadData();
    }

    public boolean cDQ() {
        if (this.jiY) {
            return false;
        }
        this.gAi.setText(this.jFB.getResources().getString(R.string.load_more_must_after_delete));
        this.gAi.endLoadData();
        return true;
    }

    private void cP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.jiR = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jiR.setLayoutManager(new LinearLayoutManager(this.jiR.getContext()));
        this.jiR.setFadingEdgeLength(0);
        this.jiR.setOverScrollMode(2);
        this.jiR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.jiR.setPadding(dimenPixelSize, this.jiR.getPaddingTop(), dimenPixelSize, this.jiR.getPaddingBottom());
        this.gAi = new PbListView(this.jFB.getPageContext().getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jFB.getActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jiR.setOnSrollToBottomListener(this.jFB);
        this.epC = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jFH = new f(this.jFB, this.jiR);
        lU(false);
        this.jpq = new RelativeLayout(this.jFB.getContext());
        this.jpq.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jpr = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jFB, this.jpq);
        this.jFB.registerListener(this.jhX);
        this.jFB.registerListener(this.jpm);
    }

    private void b(af afVar) {
        if (this.jDy == null) {
            this.jDy = new BannerView(this.jFB.getPageContext().getPageActivity());
            this.jDy.setLayoutParams(new AbsListView.LayoutParams(-1, this.jFB.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jDy.setVisibility(8);
            this.jDy.setBannerViewClickListener(this.jDD);
            this.jDy.setBannerData(afVar);
            this.jDy.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jDy.bzm() && !g.this.isAddBanner && g.this.jiR != null) {
                        g.this.isAddBanner = true;
                        g.this.jiR.addHeaderView(g.this.jDy, 1);
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
    public void cIU() {
        if (this.fwe != null) {
            String value = this.fwe.getValue();
            if (this.fwe.blZ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jFB.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fwe.blZ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jFB.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jFB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fwe.blZ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fbx != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fbx) {
                        case FRS:
                            this.jFB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jFB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jFB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jFB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bsV().b(this.jFB.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jFB.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fwe.blZ() == 4) {
                this.jFB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jFB.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jiR.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jFH.a(wVar);
    }

    public void onDestroy() {
        this.jFH.onDestory();
        this.jiR.setOnSrollToBottomListener(null);
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 503;
            tVar.gcx = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFi() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.gcx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bYh() {
        this.jiR.setVisibility(0);
    }

    public void cDH() {
        if (this.jFH != null) {
            this.jFH.notifyDataSetChanged();
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
            if (y.isEmpty(f)) {
                if (this.jpq != null) {
                    this.jiR.removeHeaderView(this.jpq);
                }
            } else if (this.jpq != null) {
                this.jiR.post(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jiR.removeHeaderView(g.this.jpq);
                        g.this.jiR.addHeaderView(g.this.jpq, 0);
                    }
                });
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.jFB.cJR() != null && frsTabInfo != null) {
                    this.jFB.cJR().Ac(frsTabInfo.tab_id.intValue());
                }
            } else if (this.jpr != null && frsViewData.getForum() != null) {
                this.jpr.setData(f);
                this.jpr.setFid(frsViewData.getForum().getId());
                if (com.baidu.tbadk.a.d.bjr() && com.baidu.tbadk.a.b.a.eGq != com.baidu.tbadk.a.b.a.bjK()) {
                    this.jpr.iF(com.baidu.tieba.frs.d.j.At(com.baidu.tbadk.a.b.a.bjK()));
                }
            }
        }
        this.jFH.b(arrayList2, frsViewData);
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
        return this.jiR;
    }

    public void cIV() {
        this.jFH.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jiR.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.isAddBanner && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fwe = forumData.getFrsBannerData();
            b(this.fwe);
            this.jDy.reset();
            this.jiR.removeHeaderView(this.jDy);
            if (this.fwe.getType() == 1 && !TextUtils.isEmpty(this.fwe.bma())) {
                this.jDy.setData(this.jFB.getPageContext(), this.fwe.bma());
                if (this.fwe.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jFB.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cIW() {
        if (this.jDy != null) {
            this.isAddBanner = false;
            this.jiR.removeHeaderView(this.jDy);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jFH != null) {
            this.jFH.cGx();
            this.jFH.notifyDataSetChanged();
            this.jFH.onChangeSkinType(i);
        }
        this.jFB.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jFB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jDy != null) {
            this.jDy.bzn();
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
        this.jpr.onChangeSkinType();
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.gcx = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public f cJT() {
        return this.jFH;
    }

    public RelativeLayout cnn() {
        return this.mContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void WX() {
        this.jiR.setNextPage(this.gAi);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.startLoadData();
    }

    public void WY() {
        this.jiR.setNextPage(this.gAi);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.endLoadData();
        this.gAi.setText(this.jFB.getResources().getString(R.string.list_has_no_more));
    }

    public void bSr() {
        this.jiR.setNextPage(null);
    }

    public void qV(boolean z) {
        this.epC.setVisibility(z ? 0 : 8);
    }

    public void KW(String str) {
        if (this.jFB.cIR() != null) {
            this.jFB.cIR().KY(str);
        }
    }

    public void KX(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jFH.getDataList())) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jFH.getDataList().iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bJq() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bJq()).eLu)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
