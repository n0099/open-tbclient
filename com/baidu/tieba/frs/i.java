package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.l.r;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class i {
    private NoNetworkView bJn;
    private PbListView ben;
    private CommonTipView cem;
    private View crA;
    private int crB;
    private View crD;
    private com.baidu.tieba.frs.entelechy.b.e crE;
    private com.baidu.tieba.frs.entelechy.b.c crF;
    private GifView crG;
    private TbImageView crH;
    private HashSet<String> crI;
    private com.baidu.tieba.play.l crJ;
    private ObservedChangeLinearLayout crK;
    private com.baidu.tieba.frs.entelechy.b.a crL;
    private f crm;
    private View cro;
    private ImageView crp;
    private ImageView crq;
    private ViewStub crr;
    private q crw;
    private View.OnClickListener cry;
    private View crz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.l mPullView;
    private boolean crl = false;
    private NoPressedRelativeLayout crn = null;
    private FrameLayout crs = null;
    private TbImageView crt = null;
    private TbImageView cru = null;
    private BdExpandListView crv = null;
    private com.baidu.tbadk.core.dialog.b crx = null;
    private NoNetworkView.a bJq = null;
    private boolean mHasMore = true;
    private boolean crC = false;
    private int crd = 0;
    private int bcV = 0;
    private View ceZ = null;
    private boolean bzS = true;
    private boolean crM = true;
    private Runnable crN = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.crr != null) {
                i.this.crs.setVisibility(0);
                i.this.cru.setVisibility(0);
                i.this.crt.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout ahw() {
        return this.crK;
    }

    public View ahx() {
        return this.ceZ;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.crm = null;
        this.cry = null;
        this.crB = 0;
        this.crm = fVar;
        this.cry = onClickListener;
        a(aVar, z);
        this.crI = new HashSet<>();
        this.crB = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.crL = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.l(this.crm.getPageContext());
        }
        this.mPullView.setTag(this.crm.getUniqueId());
        if (this.crn == null) {
            this.crn = (NoPressedRelativeLayout) this.crm.mRootView.findViewById(d.h.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.crn, d.e.cp_bg_line_d);
        if (this.crA == null) {
            this.crA = this.crm.mRootView.findViewById(d.h.frs_list_content);
        }
        if (this.crK == null) {
            this.crK = (ObservedChangeLinearLayout) this.crm.mRootView.findViewById(d.h.navigation_bar_wrapperLayout);
            this.crK.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.crm.mRootView.findViewById(d.h.view_navigation_bar);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.crm.aht()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.crz == null) {
            this.crz = this.crm.mRootView.findViewById(d.h.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aiE = aVar.aiE();
            if (aiE != null) {
                aiE.ar(this.crz);
            }
        }
        if (this.cro == null) {
            this.cro = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cro.setOnClickListener(this.cry);
            this.mBackImageView = (ImageView) this.cro.findViewById(d.h.widget_navi_back_button);
        }
        if (this.crp == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.f(this.crm.getPageContext().getPageActivity(), d.f.ds24), 0);
            this.crp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.crp.setLayoutParams(layoutParams);
            this.crp.setOnClickListener(this.cry);
            this.crq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.crq.setLayoutParams(layoutParams);
            this.crq.setOnClickListener(this.cry);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.crm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.crv == null) {
            this.crv = (BdExpandListView) this.crm.mRootView.findViewById(d.h.frs_lv_thread);
        }
        this.crv.setScrollable(this.crm);
        this.crv.setFadingEdgeLength(0);
        this.crv.setOverScrollMode(2);
        this.crn.setBottomOrderView(this.crv);
        this.crv.setOnTouchListener(this.crm.aMx);
        this.crv.setDivider(null);
        this.crv.setPullRefresh(this.mPullView);
        if (z && this.crD == null) {
            this.crD = BdListViewHelper.a(this.crm.getActivity(), this.crv, BdListViewHelper.HeadType.DEFAULT);
        }
        this.crv.setDividerHeight(0);
        this.crv.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.crJ != null) {
                    i.this.crJ.aZ(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(d.h.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(d.h.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        });
        if (this.ben == null) {
            this.ben = new PbListView(this.crm.getPageContext().getPageActivity());
            this.ben.lb();
        }
        this.ben.dp(d.e.cp_bg_line_c);
        this.crv.setOnSrollToBottomListener(this.crm);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.q(new q.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ahX() {
                i.this.crm.aho();
            }

            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ahY() {
                if (i.this.crv != null) {
                    i.this.crv.setSelection(0);
                    if (i.this.crJ != null) {
                        i.this.crJ.a(i.this.crd, i.this.bcV, false, true);
                    }
                }
            }
        }));
        boolean vQ = com.baidu.tbadk.core.util.an.vO().vQ();
        if (this.crw == null) {
            this.crw = aVar.a(this.crm, this.crv, vQ);
        }
        cl(false);
        if (!z) {
            if (this.bJn == null) {
                this.bJn = new NoNetworkView(this.crm.getActivity());
                this.bJn.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.crK.addView(this.bJn);
            }
            if (com.baidu.adp.lib.util.i.gW()) {
                this.bJn.setVisibility(8);
            } else {
                this.bJn.setVisibility(0);
            }
            this.bJn.onChangeSkinType(this.crm.yi(), TbadkCoreApplication.getInst().getSkinType());
        }
        ahE();
        if (this.crE == null) {
            this.crE = aVar.c(this.crm, this.crn);
        }
        if (this.crF == null) {
            this.crF = aVar.b(this.crm, this.crn);
        }
        if (this.ceZ == null) {
            this.ceZ = this.crm.mRootView.findViewById(d.h.statebar_view);
        }
        if (this.crJ == null) {
            this.crJ = new com.baidu.tieba.play.l(this.crm.getPageContext(), this.crv);
        }
        this.crJ.setUniqueId(this.crm.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.crD != null && this.crD.getLayoutParams() != null) {
            this.crD.getLayoutParams().height = i;
            this.crD.setLayoutParams(this.crD.getLayoutParams());
        }
    }

    public View ahy() {
        return this.crD;
    }

    public com.baidu.tieba.play.l ahz() {
        return this.crJ;
    }

    public com.baidu.tieba.frs.entelechy.b.c ahA() {
        return this.crF;
    }

    public void eK(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.v(this.crm.ahq().brl());
        if (this.crE != null) {
            this.crE.eK(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e ahB() {
        return this.crE;
    }

    public void u(boolean z, boolean z2) {
        if (this.crM && this.crF != null) {
            this.crF.u(z, z2);
        }
    }

    public void eL(boolean z) {
        this.crM = z;
        if (!this.crM && this.crF != null) {
            this.crF.u(false, false);
        }
    }

    public void ahC() {
        if (this.crM && this.crF != null) {
            this.crF.u(false, false);
        }
        this.crp.setVisibility(8);
        this.crq.setVisibility(8);
        eK(false);
        this.crv.setVisibility(8);
    }

    public void ahD() {
        if (this.crM && this.crF != null) {
            this.crF.u(true, false);
        }
        this.crp.setVisibility(0);
        this.crq.setVisibility(0);
        eK(true);
        this.crv.setVisibility(0);
    }

    public void eM(boolean z) {
        if (this.crF != null) {
            this.crF.fb(z);
        }
    }

    private void ahE() {
        if (this.crG == null) {
            this.crG = (GifView) this.crm.mRootView.findViewById(d.h.gif_real_time);
            this.crH = (TbImageView) this.crm.mRootView.findViewById(d.h.tbimg_real_time);
            this.crH.setPageId(this.crm.getUniqueId());
            this.crG.setLayerType(1, null);
            this.crH.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ahF() {
        return this.cro;
    }

    public void c(NoNetworkView.a aVar) {
        this.bJq = aVar;
        if (this.bJn != null) {
            this.bJn.a(this.bJq);
        }
    }

    public void cl(boolean z) {
        this.crl = z;
        if (z) {
            if (this.crF != null) {
                this.crF.ajk();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.crv.getAdapter()).notifyDataSetChanged();
        if (this.crF != null) {
            this.crF.ajl();
        }
    }

    public void eN(boolean z) {
        if (this.crF != null) {
            if (z) {
                u(true, true);
            } else {
                u(true, false);
            }
        }
    }

    public void eO(boolean z) {
        if (this.crF != null) {
            if (z) {
                u(false, true);
            } else {
                u(false, false);
            }
        }
    }

    public void a(k.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(k.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(k.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.crv.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.crw.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.crw.setForumName(str);
        this.mForumName = str;
    }

    public void cK(boolean z) {
        this.crw.cK(z);
    }

    public void onDestroy() {
        if (this.crJ != null) {
            this.crJ.destroy();
        }
        this.crw.onDestory();
        this.crv.setOnSrollToBottomListener(null);
        this.crv.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.crN);
        if (this.cem != null) {
            this.cem.onDestroy();
        }
        this.crI.clear();
        if (this.crE != null) {
            this.crE.ajp();
        }
        if (this.ceZ != null) {
            this.ceZ.setBackgroundDrawable(null);
        }
    }

    public boolean ahG() {
        if (this.crE != null) {
            return this.crE.ahG();
        }
        return false;
    }

    public boolean ahr() {
        return this.crl;
    }

    public void NI() {
        this.crv.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.mNavigationBar.getCenterTextTitleText())) {
            if (TextUtils.isEmpty(str)) {
                this.mNavigationBar.setCenterTextTitle("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.mNavigationBar.setCenterTextTitle(str2);
            com.baidu.tbadk.core.h.oS().cn(str);
        }
    }

    public void ahH() {
        if (this.crw != null) {
            this.crw.notifyDataSetChanged();
        }
    }

    public void Zm() {
        if (this.crw instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.crw).Zm();
        }
    }

    private void ahI() {
        if (this.crx == null && this.crm.getPageContext() != null) {
            String[] strArr = {this.crm.getPageContext().getPageActivity().getString(d.l.take_photo), this.crm.getPageContext().getPageActivity().getString(d.l.album)};
            this.crx = new com.baidu.tbadk.core.dialog.b(this.crm.getPageContext().getPageActivity());
            this.crx.cN(this.crm.getPageContext().getPageActivity().getString(d.l.operation));
            this.crx.a(strArr, new b.InterfaceC0046b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.crm.ahs();
                    } else if (i == 1 && i.this.crm.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.q(i.this.crm.getPageContext().getPageActivity());
                    }
                }
            });
            this.crx.d(this.crm.getPageContext());
        }
    }

    public void ahJ() {
        ahI();
        if (this.crx != null) {
            this.crx.tr();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tbadk.core.util.v.v(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.crm != null && this.crm.agT() != null && this.crm.agT().akR() == 0) {
                kVar.iY(this.crm.agT().akZ());
            }
        }
        if (com.baidu.tbadk.core.util.v.u(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = arrayList.get(i2);
                if (fVar instanceof bj) {
                    ((bj) fVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.crw.b(arrayList, iVar);
        if (this.crJ != null) {
            this.crJ.a(this.crd, this.bcV, this.crC, true);
        }
    }

    public BdTypeListView getListView() {
        return this.crv;
    }

    public void ahK() {
        this.crw.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.crm.getPageContext(), 1);
        aVar.a(this.crv);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.crm.getForumName());
        hashMap.put("forum_id", this.crm.getForumId());
        aVar.setParams(hashMap);
        aVar.I(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.crE != null) {
            this.crE.ajq();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.crE != null) {
            this.crE.ajr();
        }
    }

    public void release() {
        if (this.bJn != null && this.bJq != null) {
            this.bJn.b(this.bJq);
        }
    }

    public ImageView ahL() {
        return this.crq;
    }

    public ImageView ahM() {
        return this.crp;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.crm, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.crm.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.crH != null) {
            this.crH.invalidate();
        }
        if (this.crw != null) {
            this.crw.aja();
            this.crw.notifyDataSetChanged();
        }
        this.crm.yi().getLayoutMode().ah(i == 1);
        this.crm.yi().getLayoutMode().t(this.crn);
        if (this.crn != null) {
            com.baidu.tbadk.core.util.aj.e(this.crn, d.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.crm.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cU(d.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.crz, d.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.bJn != null) {
            this.bJn.onChangeSkinType(this.crm.getPageContext(), i);
        }
        if (this.ben != null) {
            this.ben.dq(i);
        }
        eR(false);
        if (this.crF != null) {
            this.crF.onChangeSkinType(i);
        }
        if (this.crE != null) {
            this.crE.onChangeSkinType(i);
        }
        if (this.ceZ != null) {
            UtilHelper.setStatusBarBackground(this.ceZ, i);
        }
        if (this.crJ != null) {
            this.crJ.a(this.crd, this.bcV, this.crC, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
    }

    public void startPullRefresh() {
        this.crv.startPullRefresh();
    }

    public void ahN() {
        this.crv.completePullRefreshPostDelayed(2000L);
    }

    public boolean ahO() {
        return this.crr != null && this.cru.getVisibility() == 0;
    }

    public void ahP() {
        if (this.crr != null) {
            this.crs.setVisibility(0);
            this.cru.setVisibility(8);
            this.crt.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.crN, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bq bqVar) {
        if (this.crr == null) {
            this.crr = (ViewStub) this.crm.mRootView.findViewById(d.h.yule_game_egg_view_stub);
            this.crr.setVisibility(0);
            this.crs = (FrameLayout) this.crm.mRootView.findViewById(d.h.game_activity_egg_layout);
            this.crt = (TbImageView) this.crm.mRootView.findViewById(d.h.game_activity_egg);
            this.cru = (TbImageView) this.crm.mRootView.findViewById(d.h.game_activity_egg_s);
            this.crt.setPageId(this.crm.getUniqueId());
            this.cru.setPageId(this.crm.getUniqueId());
            this.crt.setDefaultBgResource(d.e.common_color_10022);
            this.crt.setDefaultResource(0);
            this.cru.setDefaultBgResource(d.e.common_color_10022);
            this.cru.setDefaultResource(0);
            this.crs.setOnClickListener(this.cry);
        }
        this.crs.setVisibility(0);
        String te = bqVar.te();
        String tf = bqVar.tf();
        this.crt.c(te, 10, false);
        this.cru.c(tf, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.crN, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void ahQ() {
        if (this.crr != null) {
            this.crs.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q ahR() {
        return this.crw;
    }

    public ViewGroup Xy() {
        return this.crn;
    }

    public View ahS() {
        return this.crA;
    }

    public void ahT() {
        if (r.Gx().Gy()) {
            int lastVisiblePosition = this.crv.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.crv.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.csc != null) {
                        com.baidu.tbadk.l.l perfLog = mVar.csc.getPerfLog();
                        perfLog.fi(1000);
                        perfLog.aJC = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.csc.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.csc.wy();
                    }
                    if (mVar.csa != null && (mVar.csa instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.csa;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fi(1000);
                                perfLog2.aJC = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wy();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar ahp() {
        return this.mNavigationBar;
    }

    public void XE() {
        this.mHasMore = true;
        this.crv.setNextPage(this.ben);
        if (this.crB > 0) {
            this.ben.dr(this.crB);
        }
        this.ben.wV();
    }

    public void XG() {
        this.mHasMore = false;
        this.crv.setNextPage(this.ben);
        if (this.crB > 0) {
            this.ben.dr(this.crB);
        }
        this.ben.wW();
        this.ben.setText(this.crm.getResources().getString(d.l.list_no_more));
    }

    public void Zn() {
        this.mHasMore = false;
        this.crv.setNextPage(null);
    }

    public boolean Zd() {
        return this.ben.getView().getParent() != null && this.mHasMore;
    }

    public void iU(int i) {
        this.crB = i;
    }

    public void iV(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cem == null) {
                    this.cem = new CommonTipView(this.crm.getActivity());
                }
                this.cem.setText(d.l.frs_login_tip);
                this.cem.a((FrameLayout) ahS(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eP(boolean z) {
        if (this.crJ != null) {
            if (z) {
                this.crJ.hG(false);
                this.crJ.asu();
                return;
            }
            this.crJ.hG(true);
            this.crJ.a(this.crd, this.bcV, this.crC, true);
        }
    }

    public void ar(int i, int i2) {
        if (this.crJ != null) {
            this.crJ.a(i, i2, this.crC, 1);
        }
    }

    public void as(int i, int i2) {
        this.crd = i;
        this.bcV = i2;
    }

    public void eQ(boolean z) {
        this.crC = z;
    }

    public void ahU() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.g.frs_star_navigation_bg);
        }
    }

    private void ahV() {
        float f;
        if (this.mNavigationBar != null) {
            float alpha = this.mNavigationBar.getBarBgView() != null ? this.mNavigationBar.getBarBgView().getAlpha() : 0.0f;
            if (this.mNavigationBar.mTextTitle != null) {
                this.mNavigationBar.mTextTitle.setAlpha(alpha);
            }
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f && this.mBackImageView != null) {
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void eR(boolean z) {
        boolean i = com.baidu.tieba.frs.h.f.i(this.crm.ahq());
        boolean h = com.baidu.tieba.frs.h.f.h(this.crm.ahq());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bzS) {
                    this.bzS = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.crp, d.g.icon_sml_search_bg, d.g.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.crq, d.g.btn_sml_more_bg, d.g.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bzS) {
                this.bzS = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.g.icon_return_bg_s, d.g.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.crp, d.g.icon_search_bg_s, d.g.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.crq, d.g.btn_more_selector_s, d.g.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        ahV();
    }

    public void eS(boolean z) {
        if (!this.crv.brF()) {
            this.crv.setStarForum(true);
            if (z && !this.crm.aht()) {
                this.mPullView = new com.baidu.tbadk.core.view.l(this.crm.getPageContext());
                this.mPullView.setTag(this.crm.getUniqueId());
                this.crv.setPullRefresh(this.mPullView);
            }
        }
    }

    public void iW(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void iX(int i) {
        if (this.crv != null && this.crv.getChildCount() >= 0) {
            if (this.crv.getFirstVisiblePosition() > 8) {
                this.crv.setSelection(8);
            }
            this.crv.smoothScrollToPosition(i);
        }
    }

    public void ahW() {
        a(this.crL, this.crm.aht());
        if (this.crw != null) {
            this.crw.ajf();
        }
    }
}
