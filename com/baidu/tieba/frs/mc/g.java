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
    private PbListView grg;
    private RelativeLayout jbZ;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jca;
    private FrsNewAreaFragment jsi;
    private f jso;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView iVF = null;
    private BannerView jqb = null;
    private boolean jqd = false;
    private boolean iVM = true;
    private BannerView.a jqh = new BannerView.a() { // from class: com.baidu.tieba.frs.mc.g.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bAv() {
            g.this.cIy();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bAw() {
            g.this.cIA();
        }
    };
    private CustomMessageListener iUM = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.mc.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = g.this.jso.getDataList();
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
                        g.this.jso.notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    };
    private CustomMessageListener jqi = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                g.this.Lx(str);
                g.this.Lw(str);
                g.this.jso.refreshData();
            }
        }
    };

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.jsi = null;
        this.jsi = frsNewAreaFragment;
        cH(view);
    }

    public void refreshView() {
        this.jso.notifyDataSetChanged();
    }

    public void qq(boolean z) {
        ac acVar = new ac();
        acVar.tabId = 503;
        acVar.fbE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, acVar));
    }

    public void qe(boolean z) {
        this.iVM = z;
        if (z) {
            this.grg.setText(this.jsi.getResources().getString(R.string.load_more));
            if (this.iVF.getChildAt(this.iVF.getChildCount() - 1) == this.grg.getView()) {
                this.grg.startLoadData();
                this.jsi.bRN();
                return;
            }
            this.grg.endLoadData();
            return;
        }
        this.grg.setText(this.jsi.getResources().getString(R.string.load_more_must_after_delete));
        this.grg.endLoadData();
    }

    public boolean cDB() {
        if (this.iVM) {
            return false;
        }
        this.grg.setText(this.jsi.getResources().getString(R.string.load_more_must_after_delete));
        this.grg.endLoadData();
        return true;
    }

    private void cH(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        this.iVF = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.iVF.setLayoutManager(new LinearLayoutManager(this.iVF.getContext()));
        this.iVF.setFadingEdgeLength(0);
        this.iVF.setOverScrollMode(2);
        this.iVF.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.mc.g.1
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
            this.iVF.setPadding(dimenPixelSize, this.iVF.getPaddingTop(), dimenPixelSize, this.iVF.getPaddingBottom());
        }
        this.grg = new PbListView(this.jsi.getPageContext().getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jsi.getActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iVF.setOnSrollToBottomListener(this.jsi);
        this.eje = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jso = new f(this.jsi, this.iVF);
        lx(false);
        this.jbZ = new RelativeLayout(this.jsi.getContext());
        this.jbZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jca = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jsi, this.jbZ);
        this.jsi.registerListener(this.iUM);
        this.jsi.registerListener(this.jqi);
    }

    private void b(ae aeVar) {
        if (this.jqb == null) {
            this.jqb = new BannerView(this.jsi.getPageContext().getPageActivity());
            this.jqb.setLayoutParams(new AbsListView.LayoutParams(-1, this.jsi.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jqb.setVisibility(8);
            this.jqb.setBannerViewClickListener(this.jqh);
            this.jqb.setBannerData(aeVar);
            this.jqb.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.mc.g.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && g.this.jqb.bAt() && !g.this.jqd && g.this.iVF != null) {
                        g.this.jqd = true;
                        g.this.iVF.addHeaderView(g.this.jqb, 1);
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
    public void cIy() {
        if (this.foN != null) {
            String value = this.foN.getValue();
            if (this.foN.bnb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jsi.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.foN.bnb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jsi.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jsi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
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
                            this.jsi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jsi.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jsi.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jsi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bua().b(this.jsi.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jsi.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.foN.bnb() == 4) {
                this.jsi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jsi.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iVF.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.jso.a(abVar);
    }

    public void onDestroy() {
        this.jso.onDestory();
        this.iVF.setOnSrollToBottomListener(null);
    }

    public void lx(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 503;
            uVar.fVi = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void cES() {
        u uVar = new u();
        uVar.tabId = 503;
        uVar.fVi = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void bYt() {
        this.iVF.setVisibility(0);
    }

    public void cDs() {
        if (this.jso != null) {
            this.jso.notifyDataSetChanged();
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
                if (this.jbZ != null) {
                    this.iVF.removeHeaderView(this.jbZ);
                }
            } else if (this.jbZ != null) {
                this.iVF.post(new Runnable() { // from class: com.baidu.tieba.frs.mc.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.iVF.removeHeaderView(g.this.jbZ);
                        g.this.iVF.addHeaderView(g.this.jbZ, 0);
                    }
                });
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(f, 0);
                if (frsViewData != null && this.jsi.cJv() != null && frsTabInfo != null) {
                    this.jsi.cJv().Bm(frsTabInfo.tab_id.intValue());
                }
            } else if (this.jca != null && frsViewData.getForum() != null) {
                this.jca.setData(f);
                this.jca.setFid(frsViewData.getForum().getId());
            }
        }
        this.jso.b(arrayList2, frsViewData);
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
        return this.iVF;
    }

    public void cIz() {
        this.jso.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.iVF.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jqd && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.foN = forumData.getFrsBannerData();
            b(this.foN);
            this.jqb.reset();
            this.iVF.removeHeaderView(this.jqb);
            if (this.foN.getType() == 1 && !TextUtils.isEmpty(this.foN.bnc())) {
                this.jqb.setData(this.jsi.getPageContext(), this.foN.bnc());
                if (this.foN.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jsi.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cIA() {
        if (this.jqb != null) {
            this.jqd = false;
            this.iVF.removeHeaderView(this.jqb);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jso != null) {
            this.jso.cGc();
            this.jso.notifyDataSetChanged();
            this.jso.onChangeSkinType(i);
        }
        this.jsi.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jsi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jqb != null) {
            this.jqb.bAu();
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        this.jca.onChangeSkinType();
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 503;
        uVar.fVi = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public f cJx() {
        return this.jso;
    }

    public RelativeLayout cno() {
        return this.mContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XZ() {
        this.iVF.setNextPage(this.grg);
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.startLoadData();
    }

    public void Ya() {
        this.iVF.setNextPage(this.grg);
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.endLoadData();
        this.grg.setText(this.jsi.getResources().getString(R.string.list_has_no_more));
    }

    public void bTb() {
        this.iVF.setNextPage(null);
    }

    public void qr(boolean z) {
        this.eje.setVisibility(z ? 0 : 8);
    }

    public void cBM() {
        this.iVF.smoothScrollToPosition(0);
    }

    public void Lw(String str) {
        if (this.jsi.cIv() != null) {
            this.jsi.cIv().Ly(str);
        }
    }

    public void Lx(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jso.getDataList())) {
            Iterator<q> it = this.jso.getDataList().iterator();
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
