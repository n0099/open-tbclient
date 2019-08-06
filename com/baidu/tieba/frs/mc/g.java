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
import com.baidu.tbadk.core.data.bg;
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
    private x clZ;
    private PbListView dnN;
    private BdSwipeRefreshLayout dpp;
    private FrsNewAreaFragment fNI;
    private f fNO;
    private RelativeLayout fNP;
    private com.baidu.tieba.frs.entelechy.c.a.a fNQ;
    private RelativeLayout cWk = null;
    private BdTypeRecyclerView fws = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fLF = null;
    private boolean fLH = false;
    private boolean fwA = true;
    private BannerView.a fLL = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqh() {
            g.this.bqR();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqi() {
            g.this.bqT();
        }
    };
    private CustomMessageListener fvR = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.fNO.getDataList();
            if (!v.aa(dataList)) {
                if (!v.aa(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bg) {
                            bg bgVar = (bg) mVar;
                            if (bgVar.bJl != 0 && bgVar.threadData != null) {
                                int[] agr = bgVar.threadData.agr();
                                bgVar.bJl = agr[0];
                                bgVar.bJm = agr[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fNO.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener fLM = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.xv(str);
                g.this.xu(str);
                g.this.fNO.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.fNI = null;
        this.fNI = frsNewAreaFragment;
        bN(view);
    }

    public void refreshView() {
        this.fNO.notifyDataSetChanged();
    }

    public void ka(boolean z) {
        this.dpp.setEnabled(z);
    }

    public void kb(boolean z) {
        this.fwA = z;
        if (z) {
            this.dnN.setText(this.fNI.getResources().getString(R.string.load_more));
            if (this.fws.getChildAt(this.fws.getChildCount() - 1) == this.dnN.getView()) {
                this.dnN.akF();
                this.fNI.aIS();
                return;
            }
            this.dnN.akG();
            return;
        }
        this.dnN.setText(this.fNI.getResources().getString(R.string.load_more_must_after_delete));
        this.dnN.akG();
    }

    public boolean bnk() {
        if (this.fwA) {
            return false;
        }
        this.dnN.setText(this.fNI.getResources().getString(R.string.load_more_must_after_delete));
        this.dnN.akG();
        return true;
    }

    private void bN(View view) {
        this.cWk = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.fws = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fws.setLayoutManager(new LinearLayoutManager(this.fws.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.fNI.getPageContext());
        this.fws.setFadingEdgeLength(0);
        this.fws.setOverScrollMode(2);
        this.fws.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.dnN = new PbListView(this.fNI.getPageContext().getPageActivity());
        this.dnN.nZ();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.setHeight(com.baidu.adp.lib.util.l.g(this.fNI.getActivity(), R.dimen.tbds182));
        this.dnN.akC();
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.iT(R.color.cp_cont_e);
        this.fws.setOnSrollToBottomListener(this.fNI);
        if (this.dpp == null) {
            this.dpp = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dpp.setProgressView(this.mPullView);
            am.l(this.dpp, R.color.cp_bg_line_e);
        }
        this.boy = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fNO = new f(this.fNI, this.fws);
        gc(false);
        this.fNP = new RelativeLayout(this.fNI.getContext());
        this.fNP.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fNQ = new com.baidu.tieba.frs.entelechy.c.a.a(this.fNI, this.fNP);
        this.fws.addHeaderView(this.fNP, 0);
        this.fNI.registerListener(this.fvR);
        this.fNI.registerListener(this.fLM);
    }

    private void b(x xVar) {
        if (this.fLF == null) {
            this.fLF = new BannerView(this.fNI.getPageContext().getPageActivity());
            this.fLF.setLayoutParams(new AbsListView.LayoutParams(-1, this.fNI.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fLF.setVisibility(8);
            this.fLF.setBannerViewClickListener(this.fLL);
            this.fLF.setBannerData(xVar);
            this.fLF.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str, boolean z) {
                    if (z && g.this.fLF.aqf() && !g.this.fLH && g.this.fws != null) {
                        g.this.fLH = true;
                        g.this.fws.addHeaderView(g.this.fLF, 1);
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
    public void bqR() {
        if (this.clZ != null) {
            String value = this.clZ.getValue();
            if (this.clZ.acW() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fNI.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.clZ.acW() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fNI.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fNI.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.clZ.acW() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bUB != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bUB) {
                        case FRS:
                            this.fNI.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fNI.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fNI.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fNI.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bb.ajE().c(this.fNI.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fNI.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.clZ.acW() == 4) {
                this.fNI.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fNI.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fws.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fNO.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fNO.onDestory();
        this.fws.setOnSrollToBottomListener(null);
    }

    public void gc(boolean z) {
        if (!z) {
            this.dpp.setRefreshing(false);
        }
    }

    public void aVR() {
        this.fws.setVisibility(0);
    }

    public void bnc() {
        if (this.fNO != null) {
            this.fNO.notifyDataSetChanged();
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
                if (frsViewData != null && this.fNI.brF() != null && frsTabInfo != null) {
                    this.fNI.brF().sA(frsTabInfo.tab_id.intValue());
                }
            } else if (this.fNQ != null && frsViewData.getForum() != null) {
                this.fNQ.setData(f, this.fNI.brF().brz());
                this.fNQ.setFid(frsViewData.getForum().getId());
            }
        }
        this.fNO.b(arrayList2, frsViewData);
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
        return this.fws;
    }

    public void bqS() {
        this.fNO.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fws.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fLH && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.clZ = forumData.getFrsBannerData();
            b(this.clZ);
            this.fLF.reset();
            this.fws.removeHeaderView(this.fLF);
            if (this.clZ.getType() == 1 && !TextUtils.isEmpty(this.clZ.acX())) {
                this.fLF.setData(this.fNI.getPageContext(), this.clZ.acX());
                if (this.clZ.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fNI.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bqT() {
        if (this.fLF != null) {
            this.fLH = false;
            this.fws.removeHeaderView(this.fLF);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fNO != null) {
            this.fNO.bpn();
            this.fNO.notifyDataSetChanged();
            this.fNO.onChangeSkinType(i);
        }
        this.fNI.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fNI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cWk);
        if (this.fLF != null) {
            this.fLF.aqg();
        }
        if (this.dnN != null) {
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnN.iV(i);
        }
        am.l(this.dpp, R.color.cp_bg_line_e);
        this.fNQ.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.dpp.setRefreshing(true);
    }

    public f brH() {
        return this.fNO;
    }

    public RelativeLayout aXA() {
        return this.cWk;
    }

    public View bop() {
        return this.dpp;
    }

    public void bnq() {
        if (com.baidu.tbadk.p.m.avv().avw()) {
            int lastVisiblePosition = this.fws.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fws.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.eem != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.eem.getPerfLog();
                        perfLog.kR(1000);
                        perfLog.czT = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.eem.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.eem.startLogPerf();
                    }
                    if (oVar.fxq != null && (oVar.fxq instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fxq;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kR(1000);
                                perfLog2.czT = true;
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
    public void aKk() {
        this.fws.setNextPage(this.dnN);
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.akF();
    }

    public void aKl() {
        this.fws.setNextPage(this.dnN);
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.akG();
        this.dnN.setText(this.fNI.getResources().getString(R.string.list_has_no_more));
    }

    public void aKm() {
        this.fws.setNextPage(null);
    }

    public void kp(boolean z) {
        this.boy.setVisibility(z ? 0 : 8);
    }

    public void blH() {
        this.fws.smoothScrollToPosition(0);
    }

    public void xu(String str) {
        if (this.fNI.bqO() != null) {
            this.fNI.bqO().xw(str);
        }
    }

    public void xv(String str) {
        if (!StringUtils.isNull(str) && !v.aa(this.fNO.getDataList())) {
            Iterator<m> it = this.fNO.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAz() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAz()).bEU)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
