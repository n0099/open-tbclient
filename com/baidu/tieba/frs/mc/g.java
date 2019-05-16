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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
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
    private FrameLayout bnL;
    private x ckF;
    private PbListView dlX;
    private BdSwipeRefreshLayout dnh;
    private FrsNewAreaFragment fHT;
    private f fHZ;
    private RelativeLayout fIa;
    private com.baidu.tieba.frs.entelechy.c.a.a fIb;
    private RelativeLayout cUF = null;
    private BdTypeRecyclerView fqU = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private BannerView fFS = null;
    private boolean fFU = false;
    private boolean frc = true;
    private BannerView.a fFY = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aoZ() {
            g.this.boz();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void apa() {
            g.this.boB();
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<m> dataList = g.this.fHZ.getDataList();
            if (!v.aa(dataList)) {
                if (!v.aa(dataList)) {
                    for (m mVar : dataList) {
                        if (mVar instanceof bf) {
                            bf bfVar = (bf) mVar;
                            if (bfVar.bIf != 0 && bfVar.threadData != null) {
                                int[] afo = bfVar.threadData.afo();
                                bfVar.bIf = afo[0];
                                bfVar.bIg = afo[1];
                            }
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fHZ.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.fHT = null;
        this.fHT = frsNewAreaFragment;
        bK(view);
    }

    public void refreshView() {
        this.fHZ.notifyDataSetChanged();
    }

    public void jQ(boolean z) {
        this.dnh.setEnabled(z);
    }

    public void jR(boolean z) {
        this.frc = z;
        if (z) {
            this.dlX.setText(this.fHT.getResources().getString(R.string.load_more));
            if (this.fqU.getChildAt(this.fqU.getChildCount() - 1) == this.dlX.getView()) {
                this.dlX.ajy();
                this.fHT.aHq();
                return;
            }
            this.dlX.ajz();
            return;
        }
        this.dlX.setText(this.fHT.getResources().getString(R.string.load_more_must_after_delete));
        this.dlX.ajz();
    }

    public boolean bkV() {
        if (this.frc) {
            return false;
        }
        this.dlX.setText(this.fHT.getResources().getString(R.string.load_more_must_after_delete));
        this.dlX.ajz();
        return true;
    }

    private void bK(View view) {
        this.cUF = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.fqU = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fqU.setLayoutManager(new LinearLayoutManager(this.fqU.getContext()));
        this.mPullView = new com.baidu.tbadk.core.view.i(this.fHT.getPageContext());
        this.fqU.setFadingEdgeLength(0);
        this.fqU.setOverScrollMode(2);
        this.fqU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
        this.dlX = new PbListView(this.fHT.getPageContext().getPageActivity());
        this.dlX.nG();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.setHeight(com.baidu.adp.lib.util.l.g(this.fHT.getActivity(), R.dimen.tbds182));
        this.dlX.ajv();
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.iN(R.color.cp_cont_e);
        this.fqU.setOnSrollToBottomListener(this.fHT);
        if (this.dnh == null) {
            this.dnh = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dnh.setProgressView(this.mPullView);
            al.l(this.dnh, R.color.cp_bg_line_e);
        }
        this.bnL = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fHZ = new f(this.fHT, this.fqU);
        fY(false);
        this.fIa = new RelativeLayout(this.fHT.getContext());
        this.fIa.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fIb = new com.baidu.tieba.frs.entelechy.c.a.a(this.fHT, this.fIa);
        this.fqU.addHeaderView(this.fIa, 0);
        this.fHT.registerListener(this.fqt);
    }

    private void b(x xVar) {
        if (this.fFS == null) {
            this.fFS = new BannerView(this.fHT.getPageContext().getPageActivity());
            this.fFS.setLayoutParams(new AbsListView.LayoutParams(-1, this.fHT.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fFS.setVisibility(8);
            this.fFS.setBannerViewClickListener(this.fFY);
            this.fFS.setBannerData(xVar);
            this.fFS.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void O(String str, boolean z) {
                    if (z && g.this.fFS.aoX() && !g.this.fFU && g.this.fqU != null) {
                        g.this.fFU = true;
                        g.this.fqU.addHeaderView(g.this.fFS, 1);
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
    public void boz() {
        if (this.ckF != null) {
            String value = this.ckF.getValue();
            if (this.ckF.abT() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fHT.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ckF.abT() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fHT.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fHT.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ckF.abT() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bTt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bTt) {
                        case FRS:
                            this.fHT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fHT.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fHT.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fHT.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aiz().c(this.fHT.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fHT.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.ckF.abT() == 4) {
                this.fHT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fHT.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fqU.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fHZ.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fHZ.onDestory();
        this.fqU.setOnSrollToBottomListener(null);
    }

    public void fY(boolean z) {
        if (!z) {
            this.dnh.setRefreshing(false);
        }
    }

    public void aUE() {
        this.fqU.setVisibility(0);
    }

    public void bkN() {
        if (this.fHZ != null) {
            this.fHZ.notifyDataSetChanged();
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
                if (frsViewData != null && this.fHT.bpm() != null && frsTabInfo != null) {
                    this.fHT.bpm().sg(frsTabInfo.tab_id.intValue());
                }
            } else if (this.fIb != null && frsViewData.getForum() != null) {
                this.fIb.setData(f, this.fHT.bpm().bpg());
                this.fIb.setFid(frsViewData.getForum().getId());
            }
        }
        this.fHZ.b(arrayList2, frsViewData);
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
        return this.fqU;
    }

    public void boA() {
        this.fHZ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fqU.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fFU && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ckF = forumData.getFrsBannerData();
            b(this.ckF);
            this.fFS.reset();
            this.fqU.removeHeaderView(this.fFS);
            if (this.ckF.getType() == 1 && !TextUtils.isEmpty(this.ckF.abU())) {
                this.fFS.setData(this.fHT.getPageContext(), this.ckF.abU());
                if (this.ckF.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fHT.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void boB() {
        if (this.fFS != null) {
            this.fFU = false;
            this.fqU.removeHeaderView(this.fFS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.fHZ != null) {
            this.fHZ.bmW();
            this.fHZ.notifyDataSetChanged();
            this.fHZ.onChangeSkinType(i);
        }
        this.fHT.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fHT.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cUF);
        if (this.fFS != null) {
            this.fFS.aoY();
        }
        if (this.dlX != null) {
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlX.iP(i);
        }
        al.l(this.dnh, R.color.cp_bg_line_e);
        this.fIb.onChangeSkinType();
    }

    public void startPullRefresh() {
        this.dnh.setRefreshing(true);
    }

    public f bpo() {
        return this.fHZ;
    }

    public RelativeLayout bla() {
        return this.cUF;
    }

    public View bma() {
        return this.dnh;
    }

    public void blc() {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            int lastVisiblePosition = this.fqU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fqU.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.frU != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.frU.getPerfLog();
                        perfLog.kK(1000);
                        perfLog.cyv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.frU.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.frU.startLogPerf();
                    }
                    if (oVar.frT != null && (oVar.frT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.frT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kK(1000);
                                perfLog2.cyv = true;
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
    public void aIE() {
        this.fqU.setNextPage(this.dlX);
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.ajy();
    }

    public void aIF() {
        this.fqU.setNextPage(this.dlX);
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.ajz();
        this.dlX.setText(this.fHT.getResources().getString(R.string.list_has_no_more));
    }

    public void aIG() {
        this.fqU.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bnL.setVisibility(z ? 0 : 8);
    }

    public void bjv() {
        this.fqU.smoothScrollToPosition(0);
    }
}
