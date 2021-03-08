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
    private FrameLayout erd;
    private af fxD;
    private PbListView gCf;
    private f jHE;
    private FrsNewAreaFragment jHy;
    private RelativeLayout jrn;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jro;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jkO = null;
    private BannerView jFv = null;
    private boolean isAddBanner = false;
    private boolean jkV = true;
    private BannerView.a jFA = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzr() {
            g.this.cJh();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzs() {
            g.this.cJj();
        }
    };
    private CustomMessageListener jjV = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.n> dataList = g.this.jHE.getDataList();
            if (!y.isEmpty(dataList)) {
                if (!y.isEmpty(dataList)) {
                    for (com.baidu.adp.widget.ListView.n nVar : dataList) {
                        if (nVar instanceof ca) {
                            ca caVar = (ca) nVar;
                            if (caVar.eRK != 0 && caVar.eLr != null) {
                                int[] imageWidthAndHeight = caVar.eLr.getImageWidthAndHeight();
                                caVar.eRK = imageWidthAndHeight[0];
                                caVar.eRL = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jHE.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jrj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Lh(str);
                g.this.Lg(str);
                g.this.jHE.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jHy = null;
        this.jHy = frsNewAreaFragment;
        cP(view);
    }

    public void refreshView() {
        this.jHE.notifyDataSetChanged();
    }

    public void qU(boolean z) {
        z zVar = new z();
        zVar.tabId = 503;
        zVar.fku = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    public void qI(boolean z) {
        this.jkV = z;
        if (z) {
            this.gCf.setText(this.jHy.getResources().getString(R.string.load_more));
            if (this.jkO.getChildAt(this.jkO.getChildCount() - 1) == this.gCf.getView()) {
                this.gCf.startLoadData();
                this.jHy.bRp();
                return;
            }
            this.gCf.endLoadData();
            return;
        }
        this.gCf.setText(this.jHy.getResources().getString(R.string.load_more_must_after_delete));
        this.gCf.endLoadData();
    }

    public boolean cEd() {
        if (this.jkV) {
            return false;
        }
        this.gCf.setText(this.jHy.getResources().getString(R.string.load_more_must_after_delete));
        this.gCf.endLoadData();
        return true;
    }

    private void cP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.jkO = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jkO.setLayoutManager(new LinearLayoutManager(this.jkO.getContext()));
        this.jkO.setFadingEdgeLength(0);
        this.jkO.setOverScrollMode(2);
        this.jkO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.jkO.setPadding(dimenPixelSize, this.jkO.getPaddingTop(), dimenPixelSize, this.jkO.getPaddingBottom());
        this.gCf = new PbListView(this.jHy.getPageContext().getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jHy.getActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jkO.setOnSrollToBottomListener(this.jHy);
        this.erd = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jHE = new f(this.jHy, this.jkO);
        lU(false);
        this.jrn = new RelativeLayout(this.jHy.getContext());
        this.jrn.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jro = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jHy, this.jrn);
        this.jHy.registerListener(this.jjV);
        this.jHy.registerListener(this.jrj);
    }

    private void b(af afVar) {
        if (this.jFv == null) {
            this.jFv = new BannerView(this.jHy.getPageContext().getPageActivity());
            this.jFv.setLayoutParams(new AbsListView.LayoutParams(-1, this.jHy.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jFv.setVisibility(8);
            this.jFv.setBannerViewClickListener(this.jFA);
            this.jFv.setBannerData(afVar);
            this.jFv.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jFv.bzp() && !g.this.isAddBanner && g.this.jkO != null) {
                        g.this.isAddBanner = true;
                        g.this.jkO.addHeaderView(g.this.jFv, 1);
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
    public void cJh() {
        if (this.fxD != null) {
            String value = this.fxD.getValue();
            if (this.fxD.bmb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jHy.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fxD.bmb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jHy.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jHy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fxD.bmb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fcX != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fcX) {
                        case FRS:
                            this.jHy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jHy.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jHy.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jHy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bsY().b(this.jHy.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jHy.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fxD.bmb() == 4) {
                this.jHy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jHy.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jkO.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jHE.a(wVar);
    }

    public void onDestroy() {
        this.jHE.onDestory();
        this.jkO.setOnSrollToBottomListener(null);
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 503;
            tVar.gec = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFv() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.gec = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bYu() {
        this.jkO.setVisibility(0);
    }

    public void cDU() {
        if (this.jHE != null) {
            this.jHE.notifyDataSetChanged();
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
                if (this.jrn != null) {
                    this.jkO.removeHeaderView(this.jrn);
                }
            } else if (this.jrn != null) {
                this.jkO.post(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jkO.removeHeaderView(g.this.jrn);
                        g.this.jkO.addHeaderView(g.this.jrn, 0);
                    }
                });
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.jHy.cKe() != null && frsTabInfo != null) {
                    this.jHy.cKe().Ad(frsTabInfo.tab_id.intValue());
                }
            } else if (this.jro != null && frsViewData.getForum() != null) {
                this.jro.setData(f);
                this.jro.setFid(frsViewData.getForum().getId());
                if (com.baidu.tbadk.a.d.bjt() && com.baidu.tbadk.a.b.a.eHR != com.baidu.tbadk.a.b.a.bjM()) {
                    this.jro.iG(com.baidu.tieba.frs.d.j.Au(com.baidu.tbadk.a.b.a.bjM()));
                }
            }
        }
        this.jHE.b(arrayList2, frsViewData);
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
        return this.jkO;
    }

    public void cJi() {
        this.jHE.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jkO.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.isAddBanner && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fxD = forumData.getFrsBannerData();
            b(this.fxD);
            this.jFv.reset();
            this.jkO.removeHeaderView(this.jFv);
            if (this.fxD.getType() == 1 && !TextUtils.isEmpty(this.fxD.bmc())) {
                this.jFv.setData(this.jHy.getPageContext(), this.fxD.bmc());
                if (this.fxD.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jHy.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cJj() {
        if (this.jFv != null) {
            this.isAddBanner = false;
            this.jkO.removeHeaderView(this.jFv);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jHE != null) {
            this.jHE.cGK();
            this.jHE.notifyDataSetChanged();
            this.jHE.onChangeSkinType(i);
        }
        this.jHy.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jHy.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jFv != null) {
            this.jFv.bzq();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        this.jro.onChangeSkinType();
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.gec = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public f cKg() {
        return this.jHE;
    }

    public RelativeLayout cnA() {
        return this.mContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xa() {
        this.jkO.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.startLoadData();
    }

    public void Xb() {
        this.jkO.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.endLoadData();
        this.gCf.setText(this.jHy.getResources().getString(R.string.list_has_no_more));
    }

    public void bSE() {
        this.jkO.setNextPage(null);
    }

    public void qV(boolean z) {
        this.erd.setVisibility(z ? 0 : 8);
    }

    public void Lg(String str) {
        if (this.jHy.cJe() != null) {
            this.jHy.cJe().Li(str);
        }
    }

    public void Lh(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jHE.getDataList())) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jHE.getDataList().iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bJz() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bJz()).eMU)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
