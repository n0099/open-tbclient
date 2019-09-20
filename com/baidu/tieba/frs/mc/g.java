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
import com.baidu.tbadk.core.util.ba;
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
    private FrameLayout boW;
    private x cmV;
    private PbListView dpz;
    private BdSwipeRefreshLayout dra;
    private f fPE;
    private RelativeLayout fPF;
    private com.baidu.tieba.frs.entelechy.c.a.a fPG;
    private FrsNewAreaFragment fPy;
    private RelativeLayout cXd = null;
    private BdTypeRecyclerView fyf = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fNu = null;
    private boolean fNw = false;
    private boolean fyn = true;
    private BannerView.a fNA = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqt() {
            g.this.brC();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqu() {
            g.this.brE();
        }
    };
    private CustomMessageListener fxE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.fPE.getDataList();
            if (!v.aa(dataList)) {
                if (!v.aa(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bg) {
                            bg bgVar = (bg) mVar;
                            if (bgVar.bJJ != 0 && bgVar.threadData != null) {
                                int[] agv = bgVar.threadData.agv();
                                bgVar.bJJ = agv[0];
                                bgVar.bJK = agv[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fPE.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener fNB = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.xU(str);
                g.this.xT(str);
                g.this.fPE.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.fPy = null;
        this.fPy = frsNewAreaFragment;
        bM(view);
    }

    public void refreshView() {
        this.fPE.notifyDataSetChanged();
    }

    public void kd(boolean z) {
        this.dra.setEnabled(z);
    }

    public void ke(boolean z) {
        this.fyn = z;
        if (z) {
            this.dpz.setText(this.fPy.getResources().getString(R.string.load_more));
            if (this.fyf.getChildAt(this.fyf.getChildCount() - 1) == this.dpz.getView()) {
                this.dpz.akR();
                this.fPy.aJw();
                return;
            }
            this.dpz.akS();
            return;
        }
        this.dpz.setText(this.fPy.getResources().getString(R.string.load_more_must_after_delete));
        this.dpz.akS();
    }

    public boolean bnV() {
        if (this.fyn) {
            return false;
        }
        this.dpz.setText(this.fPy.getResources().getString(R.string.load_more_must_after_delete));
        this.dpz.akS();
        return true;
    }

    private void bM(View view) {
        this.cXd = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.fyf = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fyf.setLayoutManager(new LinearLayoutManager(this.fyf.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.fPy.getPageContext());
        this.fyf.setFadingEdgeLength(0);
        this.fyf.setOverScrollMode(2);
        this.fyf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.dpz = new PbListView(this.fPy.getPageContext().getPageActivity());
        this.dpz.nZ();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.setHeight(com.baidu.adp.lib.util.l.g(this.fPy.getActivity(), R.dimen.tbds182));
        this.dpz.akO();
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.iW(R.color.cp_cont_e);
        this.fyf.setOnSrollToBottomListener(this.fPy);
        if (this.dra == null) {
            this.dra = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dra.setProgressView(this.mPullView);
            am.l(this.dra, R.color.cp_bg_line_e);
        }
        this.boW = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fPE = new f(this.fPy, this.fyf);
        gf(false);
        this.fPF = new RelativeLayout(this.fPy.getContext());
        this.fPF.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fPG = new com.baidu.tieba.frs.entelechy.c.a.a(this.fPy, this.fPF);
        this.fyf.addHeaderView(this.fPF, 0);
        this.fPy.registerListener(this.fxE);
        this.fPy.registerListener(this.fNB);
    }

    private void b(x xVar) {
        if (this.fNu == null) {
            this.fNu = new BannerView(this.fPy.getPageContext().getPageActivity());
            this.fNu.setLayoutParams(new AbsListView.LayoutParams(-1, this.fPy.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fNu.setVisibility(8);
            this.fNu.setBannerViewClickListener(this.fNA);
            this.fNu.setBannerData(xVar);
            this.fNu.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str, boolean z) {
                    if (z && g.this.fNu.aqr() && !g.this.fNw && g.this.fyf != null) {
                        g.this.fNw = true;
                        g.this.fyf.addHeaderView(g.this.fNu, 1);
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
    public void brC() {
        if (this.cmV != null) {
            String value = this.cmV.getValue();
            if (this.cmV.ada() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fPy.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.cmV.ada() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fPy.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fPy.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.cmV.ada() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bVe != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bVe) {
                        case FRS:
                            this.fPy.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fPy.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fPy.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fPy.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.ajK().c(this.fPy.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fPy.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.cmV.ada() == 4) {
                this.fPy.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fPy.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fyf.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fPE.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fPE.onDestory();
        this.fyf.setOnSrollToBottomListener(null);
    }

    public void gf(boolean z) {
        if (!z) {
            this.dra.setRefreshing(false);
        }
    }

    public void aWv() {
        this.fyf.setVisibility(0);
    }

    public void bnN() {
        if (this.fPE != null) {
            this.fPE.notifyDataSetChanged();
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
                if (frsViewData != null && this.fPy.bss() != null && frsTabInfo != null) {
                    this.fPy.bss().sE(frsTabInfo.tab_id.intValue());
                }
            } else if (this.fPG != null && frsViewData.getForum() != null) {
                this.fPG.setData(f, this.fPy.bss().bsl());
                this.fPG.setFid(frsViewData.getForum().getId());
            }
        }
        this.fPE.b(arrayList2, frsViewData);
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
        return this.fyf;
    }

    public void brD() {
        this.fPE.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fyf.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fNw && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.cmV = forumData.getFrsBannerData();
            b(this.cmV);
            this.fNu.reset();
            this.fyf.removeHeaderView(this.fNu);
            if (this.cmV.getType() == 1 && !TextUtils.isEmpty(this.cmV.adb())) {
                this.fNu.setData(this.fPy.getPageContext(), this.cmV.adb());
                if (this.cmV.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fPy.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void brE() {
        if (this.fNu != null) {
            this.fNw = false;
            this.fyf.removeHeaderView(this.fNu);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.fPE != null) {
            this.fPE.bpY();
            this.fPE.notifyDataSetChanged();
            this.fPE.onChangeSkinType(i);
        }
        this.fPy.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fPy.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cXd);
        if (this.fNu != null) {
            this.fNu.aqs();
        }
        if (this.dpz != null) {
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dpz.iY(i);
        }
        am.l(this.dra, R.color.cp_bg_line_e);
        this.fPG.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.dra.setRefreshing(true);
    }

    public f bsu() {
        return this.fPE;
    }

    public RelativeLayout aYe() {
        return this.cXd;
    }

    public View bpa() {
        return this.dra;
    }

    public void bob() {
        if (com.baidu.tbadk.p.m.avH().avI()) {
            int lastVisiblePosition = this.fyf.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fyf.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.efW != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.efW.getPerfLog();
                        perfLog.kU(1000);
                        perfLog.cAP = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.efW.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.efW.startLogPerf();
                    }
                    if (oVar.fzd != null && (oVar.fzd instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fzd;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kU(1000);
                                perfLog2.cAP = true;
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
    public void aKO() {
        this.fyf.setNextPage(this.dpz);
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.akR();
    }

    public void aKP() {
        this.fyf.setNextPage(this.dpz);
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.akS();
        this.dpz.setText(this.fPy.getResources().getString(R.string.list_has_no_more));
    }

    public void aKQ() {
        this.fyf.setNextPage(null);
    }

    public void ks(boolean z) {
        this.boW.setVisibility(z ? 0 : 8);
    }

    public void bms() {
        this.fyf.smoothScrollToPosition(0);
    }

    public void xT(String str) {
        if (this.fPy.brz() != null) {
            this.fPy.brz().xV(str);
        }
    }

    public void xU(String str) {
        if (!StringUtils.isNull(str) && !v.aa(this.fPE.getDataList())) {
            Iterator<m> it = this.fPE.getDataList().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAN() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAN()).bFs)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
