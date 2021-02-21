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
    private PbListView gAw;
    private FrsNewAreaFragment jFP;
    private f jFV;
    private RelativeLayout jpE;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jpF;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jjf = null;
    private BannerView jDM = null;
    private boolean isAddBanner = false;
    private boolean jjm = true;
    private BannerView.a jDR = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzo() {
            g.this.cJb();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzp() {
            g.this.cJd();
        }
    };
    private CustomMessageListener jim = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.n> dataList = g.this.jFV.getDataList();
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
                        g.this.jFV.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.KY(str);
                g.this.KX(str);
                g.this.jFV.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jFP = null;
        this.jFP = frsNewAreaFragment;
        cP(view);
    }

    public void refreshView() {
        this.jFV.notifyDataSetChanged();
    }

    public void qU(boolean z) {
        z zVar = new z();
        zVar.tabId = 503;
        zVar.fiV = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    public void qI(boolean z) {
        this.jjm = z;
        if (z) {
            this.gAw.setText(this.jFP.getResources().getString(R.string.load_more));
            if (this.jjf.getChildAt(this.jjf.getChildCount() - 1) == this.gAw.getView()) {
                this.gAw.startLoadData();
                this.jFP.bRj();
                return;
            }
            this.gAw.endLoadData();
            return;
        }
        this.gAw.setText(this.jFP.getResources().getString(R.string.load_more_must_after_delete));
        this.gAw.endLoadData();
    }

    public boolean cDX() {
        if (this.jjm) {
            return false;
        }
        this.gAw.setText(this.jFP.getResources().getString(R.string.load_more_must_after_delete));
        this.gAw.endLoadData();
        return true;
    }

    private void cP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.jjf = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jjf.setLayoutManager(new LinearLayoutManager(this.jjf.getContext()));
        this.jjf.setFadingEdgeLength(0);
        this.jjf.setOverScrollMode(2);
        this.jjf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.jjf.setPadding(dimenPixelSize, this.jjf.getPaddingTop(), dimenPixelSize, this.jjf.getPaddingBottom());
        this.gAw = new PbListView(this.jFP.getPageContext().getPageActivity());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jFP.getActivity(), R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jjf.setOnSrollToBottomListener(this.jFP);
        this.epC = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jFV = new f(this.jFP, this.jjf);
        lU(false);
        this.jpE = new RelativeLayout(this.jFP.getContext());
        this.jpE.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jpF = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jFP, this.jpE);
        this.jFP.registerListener(this.jim);
        this.jFP.registerListener(this.jpA);
    }

    private void b(af afVar) {
        if (this.jDM == null) {
            this.jDM = new BannerView(this.jFP.getPageContext().getPageActivity());
            this.jDM.setLayoutParams(new AbsListView.LayoutParams(-1, this.jFP.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jDM.setVisibility(8);
            this.jDM.setBannerViewClickListener(this.jDR);
            this.jDM.setBannerData(afVar);
            this.jDM.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jDM.bzm() && !g.this.isAddBanner && g.this.jjf != null) {
                        g.this.isAddBanner = true;
                        g.this.jjf.addHeaderView(g.this.jDM, 1);
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
    public void cJb() {
        if (this.fwe != null) {
            String value = this.fwe.getValue();
            if (this.fwe.blZ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jFP.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fwe.blZ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jFP.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jFP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
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
                            this.jFP.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jFP.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jFP.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jFP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bsV().b(this.jFP.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jFP.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fwe.blZ() == 4) {
                this.jFP.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jFP.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jjf.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jFV.a(wVar);
    }

    public void onDestroy() {
        this.jFV.onDestory();
        this.jjf.setOnSrollToBottomListener(null);
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 503;
            tVar.gcC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFp() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.gcC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bYo() {
        this.jjf.setVisibility(0);
    }

    public void cDO() {
        if (this.jFV != null) {
            this.jFV.notifyDataSetChanged();
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
                if (this.jpE != null) {
                    this.jjf.removeHeaderView(this.jpE);
                }
            } else if (this.jpE != null) {
                this.jjf.post(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jjf.removeHeaderView(g.this.jpE);
                        g.this.jjf.addHeaderView(g.this.jpE, 0);
                    }
                });
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.jFP.cJY() != null && frsTabInfo != null) {
                    this.jFP.cJY().Ac(frsTabInfo.tab_id.intValue());
                }
            } else if (this.jpF != null && frsViewData.getForum() != null) {
                this.jpF.setData(f);
                this.jpF.setFid(frsViewData.getForum().getId());
                if (com.baidu.tbadk.a.d.bjr() && com.baidu.tbadk.a.b.a.eGq != com.baidu.tbadk.a.b.a.bjK()) {
                    this.jpF.iF(com.baidu.tieba.frs.d.j.At(com.baidu.tbadk.a.b.a.bjK()));
                }
            }
        }
        this.jFV.b(arrayList2, frsViewData);
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
        return this.jjf;
    }

    public void cJc() {
        this.jFV.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jjf.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.isAddBanner && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fwe = forumData.getFrsBannerData();
            b(this.fwe);
            this.jDM.reset();
            this.jjf.removeHeaderView(this.jDM);
            if (this.fwe.getType() == 1 && !TextUtils.isEmpty(this.fwe.bma())) {
                this.jDM.setData(this.jFP.getPageContext(), this.fwe.bma());
                if (this.fwe.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jFP.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cJd() {
        if (this.jDM != null) {
            this.isAddBanner = false;
            this.jjf.removeHeaderView(this.jDM);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jFV != null) {
            this.jFV.cGE();
            this.jFV.notifyDataSetChanged();
            this.jFV.onChangeSkinType(i);
        }
        this.jFP.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jFP.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jDM != null) {
            this.jDM.bzn();
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        this.jpF.onChangeSkinType();
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.gcC = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public f cKa() {
        return this.jFV;
    }

    public RelativeLayout cnu() {
        return this.mContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void WX() {
        this.jjf.setNextPage(this.gAw);
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.startLoadData();
    }

    public void WY() {
        this.jjf.setNextPage(this.gAw);
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.endLoadData();
        this.gAw.setText(this.jFP.getResources().getString(R.string.list_has_no_more));
    }

    public void bSy() {
        this.jjf.setNextPage(null);
    }

    public void qV(boolean z) {
        this.epC.setVisibility(z ? 0 : 8);
    }

    public void KX(String str) {
        if (this.jFP.cIY() != null) {
            this.jFP.cIY().KZ(str);
        }
    }

    public void KY(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jFV.getDataList())) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jFV.getDataList().iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bJv() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bJv()).eLt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
