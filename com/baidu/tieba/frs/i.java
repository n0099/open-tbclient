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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.a.r;
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
    private PbListView bgb;
    private NoNetworkView ccR;
    private CommonTipView cen;
    private f crI;
    private View crK;
    private ImageView crL;
    private ImageView crM;
    private ViewStub crN;
    private r crS;
    private View.OnClickListener crU;
    private View crV;
    private View crW;
    private int crX;
    private View crZ;
    private com.baidu.tieba.frs.entelechy.b.e csa;
    private com.baidu.tieba.frs.entelechy.b.c csb;
    private GifView csc;
    private TbImageView csd;
    private HashSet<String> cse;
    private com.baidu.tieba.play.m csf;
    private ObservedChangeLinearLayout csh;
    private com.baidu.tieba.frs.entelechy.b.a csi;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean crH = false;
    private NoPressedRelativeLayout crJ = null;
    private FrameLayout crO = null;
    private TbImageView crP = null;
    private TbImageView crQ = null;
    private BdExpandListView crR = null;
    private com.baidu.tbadk.core.dialog.b crT = null;
    private NoNetworkView.a coJ = null;
    private boolean mHasMore = true;
    private boolean crY = false;
    private int crz = 0;
    private int beI = 0;
    private View csg = null;
    private boolean bBD = true;
    private boolean csj = true;
    private Runnable csk = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.crN != null) {
                i.this.crO.setVisibility(0);
                i.this.crQ.setVisibility(0);
                i.this.crP.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout ahp() {
        return this.csh;
    }

    public View ahq() {
        return this.csg;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.crI = null;
        this.crU = null;
        this.crX = 0;
        this.crI = fVar;
        this.crU = onClickListener;
        a(aVar, z);
        this.cse = new HashSet<>();
        this.crX = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.csi = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.crI.getPageContext());
        }
        this.mPullView.setTag(this.crI.getUniqueId());
        if (this.crJ == null) {
            this.crJ = (NoPressedRelativeLayout) this.crI.mRootView.findViewById(d.h.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.crJ, d.e.cp_bg_line_d);
        if (this.crW == null) {
            this.crW = this.crI.mRootView.findViewById(d.h.frs_list_content);
        }
        if (this.csh == null) {
            this.csh = (ObservedChangeLinearLayout) this.crI.mRootView.findViewById(d.h.navigation_bar_wrapperLayout);
            this.csh.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.crI.mRootView.findViewById(d.h.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.crI.ahn()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.crV == null) {
            this.crV = this.crI.mRootView.findViewById(d.h.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aiI = aVar.aiI();
            if (aiI != null) {
                aiI.ar(this.crV);
            }
        }
        if (this.crK == null) {
            this.crK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.crK.setOnClickListener(this.crU);
            this.mBackImageView = (ImageView) this.crK.findViewById(d.h.widget_navi_back_button);
        }
        if (this.crL == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.f(this.crI.getPageContext().getPageActivity(), d.f.ds24), 0);
            this.crL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.crL.setLayoutParams(layoutParams);
            this.crL.setOnClickListener(this.crU);
            this.crM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.crM.setLayoutParams(layoutParams);
            this.crM.setOnClickListener(this.crU);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.crI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.crR == null) {
            this.crR = (BdExpandListView) this.crI.mRootView.findViewById(d.h.frs_lv_thread);
        }
        this.crR.setScrollable(this.crI);
        this.crR.setFadingEdgeLength(0);
        this.crR.setOverScrollMode(2);
        this.crJ.setBottomOrderView(this.crR);
        this.crR.setOnTouchListener(this.crI.aLZ);
        this.crR.setDivider(null);
        this.crR.setPullRefresh(this.mPullView);
        if (z && this.crZ == null) {
            this.crZ = BdListViewHelper.a(this.crI.getActivity(), this.crR, BdListViewHelper.HeadType.DEFAULT);
        }
        this.crR.setDividerHeight(0);
        this.crR.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.csf != null) {
                    i.this.csf.aU(view);
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
        if (this.bgb == null) {
            this.bgb = new PbListView(this.crI.getPageContext().getPageActivity());
            this.bgb.getView();
        }
        this.bgb.dy(d.e.cp_bg_line_d);
        this.bgb.setHeight(com.baidu.adp.lib.util.l.f(this.crI.getActivity(), d.f.ds140));
        this.bgb.wq();
        this.bgb.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_d));
        this.bgb.dx(d.e.cp_cont_e);
        this.crR.setOnSrollToBottomListener(this.crI);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.q(new q.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ahT() {
                i.this.crI.ahi();
            }

            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ahU() {
                if (i.this.crR != null) {
                    i.this.crR.setSelection(0);
                    if (i.this.csf != null) {
                        i.this.csf.a(i.this.crz, i.this.beI, false, true);
                    }
                }
            }
        }));
        boolean vu = com.baidu.tbadk.core.util.an.vs().vu();
        if (this.crS == null) {
            this.crS = aVar.a(this.crI, this.crR, vu);
        }
        ck(false);
        if (!z) {
            if (this.ccR == null) {
                this.ccR = new NoNetworkView(this.crI.getActivity());
                this.ccR.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.csh.addView(this.ccR);
            }
            if (com.baidu.adp.lib.util.j.gV()) {
                this.ccR.setVisibility(8);
            } else {
                this.ccR.setVisibility(0);
            }
            this.ccR.onChangeSkinType(this.crI.xH(), TbadkCoreApplication.getInst().getSkinType());
        }
        ahx();
        if (this.csa == null) {
            this.csa = aVar.c(this.crI, this.crJ);
        }
        if (this.csb == null) {
            this.csb = aVar.b(this.crI, this.crJ);
        }
        if (this.csg == null) {
            this.csg = this.crI.mRootView.findViewById(d.h.statebar_view);
        }
        if (this.csf == null) {
            this.csf = new com.baidu.tieba.play.m(this.crI.getPageContext(), this.crR);
        }
        this.csf.setUniqueId(this.crI.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.crZ != null && this.crZ.getLayoutParams() != null) {
            this.crZ.getLayoutParams().height = i;
            this.crZ.setLayoutParams(this.crZ.getLayoutParams());
        }
    }

    public View ahr() {
        return this.crZ;
    }

    public com.baidu.tieba.play.m ahs() {
        return this.csf;
    }

    public com.baidu.tieba.frs.entelechy.b.c aht() {
        return this.csb;
    }

    public void eA(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.u(this.crI.ahk().bqg());
        if (this.csa != null) {
            this.csa.eA(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e ahu() {
        return this.csa;
    }

    public void u(boolean z, boolean z2) {
        if (this.csj && this.csb != null) {
            this.csb.u(z, z2);
        }
    }

    public void eB(boolean z) {
        this.csj = z;
        if (!this.csj && this.csb != null) {
            this.csb.u(false, false);
        }
    }

    public void ahv() {
        if (this.csj && this.csb != null) {
            this.csb.u(false, false);
        }
        this.crL.setVisibility(8);
        this.crM.setVisibility(8);
        eA(false);
        this.crR.setVisibility(8);
    }

    public void ahw() {
        if (this.csj && this.csb != null) {
            this.csb.u(true, false);
        }
        this.crL.setVisibility(0);
        this.crM.setVisibility(0);
        eA(true);
        this.crR.setVisibility(0);
    }

    public void eC(boolean z) {
        if (this.csb != null) {
            this.csb.eU(z);
        }
    }

    private void ahx() {
        if (this.csc == null) {
            this.csc = (GifView) this.crI.mRootView.findViewById(d.h.gif_real_time);
            this.csd = (TbImageView) this.crI.mRootView.findViewById(d.h.tbimg_real_time);
            this.csd.setPageId(this.crI.getUniqueId());
            this.csc.setLayerType(1, null);
            this.csd.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ahy() {
        return this.crK;
    }

    public void h(NoNetworkView.a aVar) {
        this.coJ = aVar;
        if (this.ccR != null) {
            this.ccR.a(this.coJ);
        }
    }

    public void ck(boolean z) {
        this.crH = z;
        if (z) {
            if (this.csb != null) {
                this.csb.ajp();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.crR.getAdapter()).notifyDataSetChanged();
        if (this.csb != null) {
            this.csb.ajq();
        }
    }

    public void eD(boolean z) {
        if (this.csb != null) {
            if (z) {
                u(true, true);
            } else {
                u(true, false);
            }
        }
    }

    public void eE(boolean z) {
        if (this.csb != null) {
            if (z) {
                u(false, true);
            } else {
                u(false, false);
            }
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(g.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(g.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.crR.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.crS.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.crS.setForumName(str);
        this.mForumName = str;
    }

    public void cJ(boolean z) {
        this.crS.cJ(z);
    }

    public void onDestroy() {
        if (this.csf != null) {
            this.csf.destroy();
        }
        this.crS.onDestory();
        this.crR.setOnSrollToBottomListener(null);
        this.crR.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.csk);
        if (this.cen != null) {
            this.cen.onDestroy();
        }
        this.cse.clear();
        if (this.csa != null) {
            this.csa.aju();
        }
        if (this.csg != null) {
            this.csg.setBackgroundDrawable(null);
        }
    }

    public boolean ahz() {
        if (this.csa != null) {
            return this.csa.ahz();
        }
        return false;
    }

    public boolean ahl() {
        return this.crH;
    }

    public void Od() {
        this.crR.setVisibility(0);
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
            com.baidu.tbadk.core.h.oT().cn(str);
        }
    }

    public void ahA() {
        if (this.crS != null) {
            this.crS.notifyDataSetChanged();
        }
    }

    public void YV() {
        if (this.crS instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.crS).YV();
        }
    }

    private void ahB() {
        if (this.crT == null && this.crI.getPageContext() != null) {
            String[] strArr = {this.crI.getPageContext().getPageActivity().getString(d.l.take_photo), this.crI.getPageContext().getPageActivity().getString(d.l.album)};
            this.crT = new com.baidu.tbadk.core.dialog.b(this.crI.getPageContext().getPageActivity());
            this.crT.cN(this.crI.getPageContext().getPageActivity().getString(d.l.operation));
            this.crT.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.crI.ahm();
                    } else if (i == 1 && i.this.crI.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.q(i.this.crI.getPageContext().getPageActivity());
                    }
                }
            });
            this.crT.d(this.crI.getPageContext());
        }
    }

    public void ahC() {
        ahB();
        if (this.crT != null) {
            this.crT.tl();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tbadk.core.util.v.u(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.crI != null && this.crI.agP() != null && this.crI.agP().akV() == 0) {
                kVar.jg(this.crI.agP().ald());
            }
        }
        if (com.baidu.tbadk.core.util.v.t(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = arrayList.get(i2);
                if (fVar instanceof bh) {
                    ((bh) fVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.crS.b(arrayList, iVar);
        if (this.csf != null) {
            this.csf.a(this.crz, this.beI, this.crY, true);
        }
    }

    public BdTypeListView getListView() {
        return this.crR;
    }

    public void ahD() {
        this.crS.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.crI.getPageContext(), 1);
        aVar.a(this.crR);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.crI.getForumName());
        hashMap.put("forum_id", this.crI.getForumId());
        aVar.setParams(hashMap);
        aVar.H(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.csa != null) {
            this.csa.ajv();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.csa != null) {
            this.csa.ajw();
        }
    }

    public void release() {
        if (this.ccR != null && this.coJ != null) {
            this.ccR.b(this.coJ);
        }
    }

    public ImageView ahE() {
        return this.crM;
    }

    public ImageView ahF() {
        return this.crL;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.crI, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.crI.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.csd != null) {
            this.csd.invalidate();
        }
        if (this.crS != null) {
            this.crS.aje();
            this.crS.notifyDataSetChanged();
        }
        this.crI.xH().getLayoutMode().ai(i == 1);
        this.crI.xH().getLayoutMode().t(this.crJ);
        if (this.crJ != null) {
            com.baidu.tbadk.core.util.aj.e(this.crJ, d.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.crI.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cS(d.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.crV, d.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.ccR != null) {
            this.ccR.onChangeSkinType(this.crI.getPageContext(), i);
        }
        if (this.bgb != null) {
            this.bgb.dz(i);
        }
        eH(false);
        if (this.csb != null) {
            this.csb.onChangeSkinType(i);
        }
        if (this.csa != null) {
            this.csa.onChangeSkinType(i);
        }
        if (this.csg != null) {
            UtilHelper.setStatusBarBackground(this.csg, i);
        }
        if (this.csf != null) {
            this.csf.a(this.crz, this.beI, this.crY, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public void startPullRefresh() {
        this.crR.startPullRefresh();
    }

    public void ahG() {
        this.crR.completePullRefreshPostDelayed(2000L);
    }

    public boolean ahH() {
        return this.crN != null && this.crQ.getVisibility() == 0;
    }

    public void ahI() {
        if (this.crN != null) {
            this.crO.setVisibility(0);
            this.crQ.setVisibility(8);
            this.crP.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.csk, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bo boVar) {
        if (this.crN == null) {
            this.crN = (ViewStub) this.crI.mRootView.findViewById(d.h.yule_game_egg_view_stub);
            this.crN.setVisibility(0);
            this.crO = (FrameLayout) this.crI.mRootView.findViewById(d.h.game_activity_egg_layout);
            this.crP = (TbImageView) this.crI.mRootView.findViewById(d.h.game_activity_egg);
            this.crQ = (TbImageView) this.crI.mRootView.findViewById(d.h.game_activity_egg_s);
            this.crP.setPageId(this.crI.getUniqueId());
            this.crQ.setPageId(this.crI.getUniqueId());
            this.crP.setDefaultBgResource(d.e.common_color_10022);
            this.crP.setDefaultResource(0);
            this.crQ.setDefaultBgResource(d.e.common_color_10022);
            this.crQ.setDefaultResource(0);
            this.crO.setOnClickListener(this.crU);
        }
        this.crO.setVisibility(0);
        String sY = boVar.sY();
        String sZ = boVar.sZ();
        this.crP.c(sY, 10, false);
        this.crQ.c(sZ, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.csk, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void ahJ() {
        if (this.crN != null) {
            this.crO.setVisibility(8);
        }
    }

    public r ahK() {
        return this.crS;
    }

    public ViewGroup ahL() {
        return this.crJ;
    }

    public View ahM() {
        return this.crW;
    }

    public void ahN() {
        if (com.baidu.tbadk.k.r.Gc().Gd()) {
            int lastVisiblePosition = this.crR.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.crR.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.csz != null) {
                        com.baidu.tbadk.k.l perfLog = mVar.csz.getPerfLog();
                        perfLog.ft(1000);
                        perfLog.aJd = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.csz.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.csz.wd();
                    }
                    if (mVar.csx != null && (mVar.csx instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.csx;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.ft(1000);
                                perfLog2.aJd = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wd();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar ahj() {
        return this.mNavigationBar;
    }

    public void ahO() {
        this.mHasMore = true;
        this.crR.setNextPage(this.bgb);
        if (this.crX > 0) {
            this.bgb.dB(d.e.cp_bg_line_d);
            this.bgb.dA(this.crX);
        }
        this.bgb.wt();
    }

    public void ahP() {
        this.mHasMore = false;
        this.crR.setNextPage(this.bgb);
        if (this.crX > 0) {
            this.bgb.dB(d.e.cp_bg_line_d);
            this.bgb.dA(this.crX);
        }
        this.bgb.wu();
        this.bgb.setText(this.crI.getResources().getString(d.l.list_no_more));
    }

    public void YW() {
        this.mHasMore = false;
        this.crR.setNextPage(null);
    }

    public boolean YM() {
        return this.bgb.getView().getParent() != null && this.mHasMore;
    }

    public void jc(int i) {
        this.crX = i;
    }

    public void jd(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cen == null) {
                    this.cen = new CommonTipView(this.crI.getActivity());
                }
                this.cen.setText(d.l.frs_login_tip);
                this.cen.a((FrameLayout) ahM(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eF(boolean z) {
        if (this.csf != null) {
            if (z) {
                this.csf.ht(false);
                this.csf.ard();
                return;
            }
            this.csf.ht(true);
            this.csf.a(this.crz, this.beI, this.crY, true);
        }
    }

    public void aw(int i, int i2) {
        if (this.csf != null) {
            this.csf.a(i, i2, this.crY, 1);
        }
    }

    public void ax(int i, int i2) {
        this.crz = i;
        this.beI = i2;
    }

    public void eG(boolean z) {
        this.crY = z;
    }

    public void ahQ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.g.frs_star_navigation_bg);
        }
    }

    private void ahR() {
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

    private void eH(boolean z) {
        boolean i = com.baidu.tieba.frs.h.f.i(this.crI.ahk());
        boolean h = com.baidu.tieba.frs.h.f.h(this.crI.ahk());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bBD) {
                    this.bBD = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.crL, d.g.icon_sml_search_bg, d.g.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.crM, d.g.btn_sml_more_bg, d.g.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bBD) {
                this.bBD = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.g.icon_return_bg_s, d.g.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.crL, d.g.icon_search_bg_s, d.g.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.crM, d.g.btn_more_selector_s, d.g.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        ahR();
    }

    public void eI(boolean z) {
        if (!this.crR.bqC()) {
            this.crR.setStarForum(true);
            if (z && !this.crI.ahn()) {
                this.mPullView = new com.baidu.tbadk.core.view.h(this.crI.getPageContext());
                this.mPullView.setTag(this.crI.getUniqueId());
                this.crR.setPullRefresh(this.mPullView);
            }
        }
    }

    public void je(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void jf(int i) {
        if (this.crR != null && this.crR.getChildCount() >= 0) {
            if (this.crR.getFirstVisiblePosition() > 8) {
                this.crR.setSelection(8);
            }
            this.crR.smoothScrollToPosition(i);
        }
    }

    public void ahS() {
        a(this.csi, this.crI.ahn());
        if (this.crS != null) {
            this.crS.ajj();
        }
    }
}
