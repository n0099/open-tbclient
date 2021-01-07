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
    private FrameLayout esi;
    private ae fyw;
    private PbListView gCf;
    private FrsNewAreaFragment jED;
    private f jEJ;
    private RelativeLayout joq;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jor;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jhR = null;
    private BannerView jCy = null;
    private boolean jCA = false;
    private boolean jhY = true;
    private BannerView.a jCE = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bCQ() {
            g.this.cLz();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bCR() {
            g.this.cLB();
        }
    };
    private CustomMessageListener jgY = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.n> dataList = g.this.jEJ.getDataList();
            if (!x.isEmpty(dataList)) {
                if (!x.isEmpty(dataList)) {
                    for (com.baidu.adp.widget.ListView.n nVar : dataList) {
                        if (nVar instanceof by) {
                            by byVar = (by) nVar;
                            if (byVar.eSI != 0 && byVar.eMv != null) {
                                int[] imageWidthAndHeight = byVar.eMv.getImageWidthAndHeight();
                                byVar.eSI = imageWidthAndHeight[0];
                                byVar.eSJ = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jEJ.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Lw(str);
                g.this.Lv(str);
                g.this.jEJ.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jED = null;
        this.jED = frsNewAreaFragment;
        cR(view);
    }

    public void refreshView() {
        this.jEJ.notifyDataSetChanged();
    }

    public void qO(boolean z) {
        z zVar = new z();
        zVar.tabId = 503;
        zVar.fln = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    public void qC(boolean z) {
        this.jhY = z;
        if (z) {
            this.gCf.setText(this.jED.getResources().getString(R.string.load_more));
            if (this.jhR.getChildAt(this.jhR.getChildCount() - 1) == this.gCf.getView()) {
                this.gCf.startLoadData();
                this.jED.bUq();
                return;
            }
            this.gCf.endLoadData();
            return;
        }
        this.gCf.setText(this.jED.getResources().getString(R.string.load_more_must_after_delete));
        this.gCf.endLoadData();
    }

    public boolean cGw() {
        if (this.jhY) {
            return false;
        }
        this.gCf.setText(this.jED.getResources().getString(R.string.load_more_must_after_delete));
        this.gCf.endLoadData();
        return true;
    }

    private void cR(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.jhR = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jhR.setLayoutManager(new LinearLayoutManager(this.jhR.getContext()));
        this.jhR.setFadingEdgeLength(0);
        this.jhR.setOverScrollMode(2);
        this.jhR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.jhR.setPadding(dimenPixelSize, this.jhR.getPaddingTop(), dimenPixelSize, this.jhR.getPaddingBottom());
        this.gCf = new PbListView(this.jED.getPageContext().getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jED.getActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jhR.setOnSrollToBottomListener(this.jED);
        this.esi = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jEJ = new f(this.jED, this.jhR);
        lU(false);
        this.joq = new RelativeLayout(this.jED.getContext());
        this.joq.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jor = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jED, this.joq);
        this.jED.registerListener(this.jgY);
        this.jED.registerListener(this.jom);
    }

    private void b(ae aeVar) {
        if (this.jCy == null) {
            this.jCy = new BannerView(this.jED.getPageContext().getPageActivity());
            this.jCy.setLayoutParams(new AbsListView.LayoutParams(-1, this.jED.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jCy.setVisibility(8);
            this.jCy.setBannerViewClickListener(this.jCE);
            this.jCy.setBannerData(aeVar);
            this.jCy.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jCy.bCO() && !g.this.jCA && g.this.jhR != null) {
                        g.this.jCA = true;
                        g.this.jhR.addHeaderView(g.this.jCy, 1);
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
    public void cLz() {
        if (this.fyw != null) {
            String value = this.fyw.getValue();
            if (this.fyw.bpB() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jED.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fyw.bpB() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jED.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jED.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fyw.bpB() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fdR != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fdR) {
                        case FRS:
                            this.jED.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jED.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jED.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jED.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bwv().b(this.jED.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jED.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fyw.bpB() == 4) {
                this.jED.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jED.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jhR.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jEJ.a(wVar);
    }

    public void onDestroy() {
        this.jEJ.onDestory();
        this.jhR.setOnSrollToBottomListener(null);
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 503;
            tVar.geO = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cHO() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.geO = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void caZ() {
        this.jhR.setVisibility(0);
    }

    public void cGn() {
        if (this.jEJ != null) {
            this.jEJ.notifyDataSetChanged();
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
                if (this.joq != null) {
                    this.jhR.removeHeaderView(this.joq);
                }
            } else if (this.joq != null) {
                this.jhR.post(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.jhR.removeHeaderView(g.this.joq);
                        g.this.jhR.addHeaderView(g.this.joq, 0);
                    }
                });
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) x.getItem(f, 0);
                if (frsViewData != null && this.jED.cMw() != null && frsTabInfo != null) {
                    this.jED.cMw().By(frsTabInfo.tab_id.intValue());
                }
            } else if (this.jor != null && frsViewData.getForum() != null) {
                this.jor.setData(f);
                this.jor.setFid(frsViewData.getForum().getId());
                if (com.baidu.tbadk.a.d.bmZ() && com.baidu.tbadk.a.b.a.eIU != com.baidu.tbadk.a.b.a.bnj()) {
                    this.jor.ki(com.baidu.tieba.frs.d.j.BP(com.baidu.tbadk.a.b.a.bnj()));
                }
            }
        }
        this.jEJ.b(arrayList2, frsViewData);
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
        return this.jhR;
    }

    public void cLA() {
        this.jEJ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jhR.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jCA && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fyw = forumData.getFrsBannerData();
            b(this.fyw);
            this.jCy.reset();
            this.jhR.removeHeaderView(this.jCy);
            if (this.fyw.getType() == 1 && !TextUtils.isEmpty(this.fyw.bpC())) {
                this.jCy.setData(this.jED.getPageContext(), this.fyw.bpC());
                if (this.fyw.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jED.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cLB() {
        if (this.jCy != null) {
            this.jCA = false;
            this.jhR.removeHeaderView(this.jCy);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jEJ != null) {
            this.jEJ.cJc();
            this.jEJ.notifyDataSetChanged();
            this.jEJ.onChangeSkinType(i);
        }
        this.jED.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jED.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jCy != null) {
            this.jCy.bCP();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        this.jor.onChangeSkinType();
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 503;
        tVar.geO = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public f cMy() {
        return this.jEJ;
    }

    public RelativeLayout cqh() {
        return this.mContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zh() {
        this.jhR.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.startLoadData();
    }

    public void Zi() {
        this.jhR.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.endLoadData();
        this.gCf.setText(this.jED.getResources().getString(R.string.list_has_no_more));
    }

    public void bVG() {
        this.jhR.setNextPage(null);
    }

    public void qP(boolean z) {
        this.esi.setVisibility(z ? 0 : 8);
    }

    public void Lv(String str) {
        if (this.jED.cLw() != null) {
            this.jED.cLw().Lx(str);
        }
    }

    public void Lw(String str) {
        if (!StringUtils.isNull(str) && !x.isEmpty(this.jEJ.getDataList())) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jEJ.getDataList().iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bMO() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bMO()).eNT)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
