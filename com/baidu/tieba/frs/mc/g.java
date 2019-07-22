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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout boy;
    private x clS;
    private PbListView dnG;
    private BdSwipeRefreshLayout dpi;
    private FrsNewAreaFragment fMU;
    private f fNa;
    private RelativeLayout fNb;
    private com.baidu.tieba.frs.entelechy.c.a.a fNc;
    private RelativeLayout cWd = null;
    private BdTypeRecyclerView fvT = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fKR = null;
    private boolean fKT = false;
    private boolean fwb = true;
    private BannerView.a fKX = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqf() {
            g.this.bqE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqg() {
            g.this.bqG();
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.fNa.getDataList();
            if (!v.aa(dataList)) {
                if (!v.aa(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bf) {
                            bf bfVar = (bf) mVar;
                            if (bfVar.bJg != 0 && bfVar.threadData != null) {
                                int[] agq = bfVar.threadData.agq();
                                bfVar.bJg = agq[0];
                                bfVar.bJh = agq[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fNa.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener fKY = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.xu(str);
                g.this.xt(str);
                g.this.fNa.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.fMU = null;
        this.fMU = frsNewAreaFragment;
        bM(view);
    }

    public void refreshView() {
        this.fNa.notifyDataSetChanged();
    }

    public void ka(boolean z) {
        this.dpi.setEnabled(z);
    }

    public void kb(boolean z) {
        this.fwb = z;
        if (z) {
            this.dnG.setText(this.fMU.getResources().getString(R.string.load_more));
            if (this.fvT.getChildAt(this.fvT.getChildCount() - 1) == this.dnG.getView()) {
                this.dnG.akD();
                this.fMU.aIQ();
                return;
            }
            this.dnG.akE();
            return;
        }
        this.dnG.setText(this.fMU.getResources().getString(R.string.load_more_must_after_delete));
        this.dnG.akE();
    }

    public boolean bna() {
        if (this.fwb) {
            return false;
        }
        this.dnG.setText(this.fMU.getResources().getString(R.string.load_more_must_after_delete));
        this.dnG.akE();
        return true;
    }

    private void bM(View view) {
        this.cWd = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.fvT = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fvT.setLayoutManager(new LinearLayoutManager(this.fvT.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.fMU.getPageContext());
        this.fvT.setFadingEdgeLength(0);
        this.fvT.setOverScrollMode(2);
        this.fvT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.dnG = new PbListView(this.fMU.getPageContext().getPageActivity());
        this.dnG.nZ();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.setHeight(com.baidu.adp.lib.util.l.g(this.fMU.getActivity(), R.dimen.tbds182));
        this.dnG.akA();
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.iT(R.color.cp_cont_e);
        this.fvT.setOnSrollToBottomListener(this.fMU);
        if (this.dpi == null) {
            this.dpi = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dpi.setProgressView(this.mPullView);
            am.l(this.dpi, R.color.cp_bg_line_e);
        }
        this.boy = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fNa = new f(this.fMU, this.fvT);
        gc(false);
        this.fNb = new RelativeLayout(this.fMU.getContext());
        this.fNb.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fNc = new com.baidu.tieba.frs.entelechy.c.a.a(this.fMU, this.fNb);
        this.fvT.addHeaderView(this.fNb, 0);
        this.fMU.registerListener(this.fvs);
        this.fMU.registerListener(this.fKY);
    }

    private void b(x xVar) {
        if (this.fKR == null) {
            this.fKR = new BannerView(this.fMU.getPageContext().getPageActivity());
            this.fKR.setLayoutParams(new AbsListView.LayoutParams(-1, this.fMU.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fKR.setVisibility(8);
            this.fKR.setBannerViewClickListener(this.fKX);
            this.fKR.setBannerData(xVar);
            this.fKR.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str, boolean z) {
                    if (z && g.this.fKR.aqd() && !g.this.fKT && g.this.fvT != null) {
                        g.this.fKT = true;
                        g.this.fvT.addHeaderView(g.this.fKR, 1);
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
    public void bqE() {
        if (this.clS != null) {
            String value = this.clS.getValue();
            if (this.clS.acV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fMU.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.clS.acV() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fMU.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fMU.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.clS.acV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bUv != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bUv) {
                        case FRS:
                            this.fMU.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fMU.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fMU.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fMU.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bb.ajC().c(this.fMU.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fMU.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.clS.acV() == 4) {
                this.fMU.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fMU.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.fvT.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fNa.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fNa.onDestory();
        this.fvT.setOnSrollToBottomListener(null);
    }

    public void gc(boolean z) {
        if (!z) {
            this.dpi.setRefreshing(false);
        }
    }

    public void aVP() {
        this.fvT.setVisibility(0);
    }

    public void bmS() {
        if (this.fNa != null) {
            this.fNa.notifyDataSetChanged();
        }
    }

    public void a(ArrayList<m> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<m> arrayList2;
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
            ArrayList<m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> f = f(frsViewData);
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(f, 0);
                if (frsViewData != null && this.fMU.brs() != null && frsTabInfo != null) {
                    this.fMU.brs().sy(frsTabInfo.tab_id.intValue());
                }
            } else if (this.fNc != null && frsViewData.getForum() != null) {
                this.fNc.setData(f, this.fMU.brs().brm());
                this.fNc.setFid(frsViewData.getForum().getId());
            }
        }
        this.fNa.b(arrayList2, frsViewData);
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
        return this.fvT;
    }

    public void bqF() {
        this.fNa.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fvT.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fKT && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.clS = forumData.getFrsBannerData();
            b(this.clS);
            this.fKR.reset();
            this.fvT.removeHeaderView(this.fKR);
            if (this.clS.getType() == 1 && !TextUtils.isEmpty(this.clS.acW())) {
                this.fKR.setData(this.fMU.getPageContext(), this.clS.acW());
                if (this.clS.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fMU.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bqG() {
        if (this.fKR != null) {
            this.fKT = false;
            this.fvT.removeHeaderView(this.fKR);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fNa != null) {
            this.fNa.bpa();
            this.fNa.notifyDataSetChanged();
            this.fNa.onChangeSkinType(i);
        }
        this.fMU.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fMU.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cWd);
        if (this.fKR != null) {
            this.fKR.aqe();
        }
        if (this.dnG != null) {
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnG.iV(i);
        }
        am.l(this.dpi, R.color.cp_bg_line_e);
        this.fNc.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.dpi.setRefreshing(true);
    }

    public f bru() {
        return this.fNa;
    }

    public RelativeLayout aXy() {
        return this.cWd;
    }

    public View boe() {
        return this.dpi;
    }

    public void bng() {
        if (com.baidu.tbadk.p.m.avt().avu()) {
            int lastVisiblePosition = this.fvT.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fvT.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.eef != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.eef.getPerfLog();
                        perfLog.kQ(1000);
                        perfLog.czM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.eef.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.eef.startLogPerf();
                    }
                    if (oVar.fwR != null && (oVar.fwR instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fwR;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kQ(1000);
                                perfLog2.czM = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
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
    public void aKi() {
        this.fvT.setNextPage(this.dnG);
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.akD();
    }

    public void aKj() {
        this.fvT.setNextPage(this.dnG);
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.akE();
        this.dnG.setText(this.fMU.getResources().getString(R.string.list_has_no_more));
    }

    public void aKk() {
        this.fvT.setNextPage(null);
    }

    public void kp(boolean z) {
        this.boy.setVisibility(z ? 0 : 8);
    }

    public void blA() {
        this.fvT.smoothScrollToPosition(0);
    }

    public void xt(String str) {
        if (this.fMU.bqB() != null) {
            this.fMU.bqB().xv(str);
        }
    }

    public void xu(String str) {
        if (!StringUtils.isNull(str) && !v.aa(this.fNa.getDataList())) {
            Iterator<m> it = this.fNa.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAx() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAx()).bET)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
