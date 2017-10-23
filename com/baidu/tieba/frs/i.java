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
    private PbListView bfN;
    private NoNetworkView ccF;
    private CommonTipView ceb;
    private ImageView crA;
    private ViewStub crB;
    private r crG;
    private View.OnClickListener crI;
    private View crJ;
    private View crK;
    private int crL;
    private View crN;
    private com.baidu.tieba.frs.entelechy.b.e crO;
    private com.baidu.tieba.frs.entelechy.b.c crP;
    private GifView crQ;
    private TbImageView crR;
    private HashSet<String> crS;
    private com.baidu.tieba.play.m crT;
    private ObservedChangeLinearLayout crV;
    private com.baidu.tieba.frs.entelechy.b.a crW;
    private f crw;
    private View cry;
    private ImageView crz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean crv = false;
    private NoPressedRelativeLayout crx = null;
    private FrameLayout crC = null;
    private TbImageView crD = null;
    private TbImageView crE = null;
    private BdExpandListView crF = null;
    private com.baidu.tbadk.core.dialog.b crH = null;
    private NoNetworkView.a cow = null;
    private boolean mHasMore = true;
    private boolean crM = false;
    private int crn = 0;
    private int beu = 0;
    private View crU = null;
    private boolean bBr = true;
    private boolean crX = true;
    private Runnable crY = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.crB != null) {
                i.this.crC.setVisibility(0);
                i.this.crE.setVisibility(0);
                i.this.crD.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout ahk() {
        return this.crV;
    }

    public View ahl() {
        return this.crU;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.crw = null;
        this.crI = null;
        this.crL = 0;
        this.crw = fVar;
        this.crI = onClickListener;
        a(aVar, z);
        this.crS = new HashSet<>();
        this.crL = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.crW = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.crw.getPageContext());
        }
        this.mPullView.setTag(this.crw.getUniqueId());
        if (this.crx == null) {
            this.crx = (NoPressedRelativeLayout) this.crw.mRootView.findViewById(d.h.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.crx, d.e.cp_bg_line_d);
        if (this.crK == null) {
            this.crK = this.crw.mRootView.findViewById(d.h.frs_list_content);
        }
        if (this.crV == null) {
            this.crV = (ObservedChangeLinearLayout) this.crw.mRootView.findViewById(d.h.navigation_bar_wrapperLayout);
            this.crV.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.crw.mRootView.findViewById(d.h.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.crw.ahi()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.crJ == null) {
            this.crJ = this.crw.mRootView.findViewById(d.h.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aiD = aVar.aiD();
            if (aiD != null) {
                aiD.ar(this.crJ);
            }
        }
        if (this.cry == null) {
            this.cry = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cry.setOnClickListener(this.crI);
            this.mBackImageView = (ImageView) this.cry.findViewById(d.h.widget_navi_back_button);
        }
        if (this.crz == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.f(this.crw.getPageContext().getPageActivity(), d.f.ds24), 0);
            this.crz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.crz.setLayoutParams(layoutParams);
            this.crz.setOnClickListener(this.crI);
            this.crA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.crA.setLayoutParams(layoutParams);
            this.crA.setOnClickListener(this.crI);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.crw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.crF == null) {
            this.crF = (BdExpandListView) this.crw.mRootView.findViewById(d.h.frs_lv_thread);
        }
        this.crF.setScrollable(this.crw);
        this.crF.setFadingEdgeLength(0);
        this.crF.setOverScrollMode(2);
        this.crx.setBottomOrderView(this.crF);
        this.crF.setOnTouchListener(this.crw.aLM);
        this.crF.setDivider(null);
        this.crF.setPullRefresh(this.mPullView);
        if (z && this.crN == null) {
            this.crN = BdListViewHelper.a(this.crw.getActivity(), this.crF, BdListViewHelper.HeadType.DEFAULT);
        }
        this.crF.setDividerHeight(0);
        this.crF.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.crT != null) {
                    i.this.crT.aU(view);
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
        if (this.bfN == null) {
            this.bfN = new PbListView(this.crw.getPageContext().getPageActivity());
            this.bfN.getView();
        }
        this.bfN.dx(d.e.cp_bg_line_d);
        this.bfN.setHeight(com.baidu.adp.lib.util.l.f(this.crw.getActivity(), d.f.ds140));
        this.bfN.wj();
        this.bfN.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_d));
        this.bfN.dw(d.e.cp_cont_e);
        this.crF.setOnSrollToBottomListener(this.crw);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.q(new q.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ahO() {
                i.this.crw.ahd();
            }

            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ahP() {
                if (i.this.crF != null) {
                    i.this.crF.setSelection(0);
                    if (i.this.crT != null) {
                        i.this.crT.a(i.this.crn, i.this.beu, false, true);
                    }
                }
            }
        }));
        boolean vn = com.baidu.tbadk.core.util.an.vl().vn();
        if (this.crG == null) {
            this.crG = aVar.a(this.crw, this.crF, vn);
        }
        cj(false);
        if (!z) {
            if (this.ccF == null) {
                this.ccF = new NoNetworkView(this.crw.getActivity());
                this.ccF.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.crV.addView(this.ccF);
            }
            if (com.baidu.adp.lib.util.j.gV()) {
                this.ccF.setVisibility(8);
            } else {
                this.ccF.setVisibility(0);
            }
            this.ccF.onChangeSkinType(this.crw.xA(), TbadkCoreApplication.getInst().getSkinType());
        }
        ahs();
        if (this.crO == null) {
            this.crO = aVar.c(this.crw, this.crx);
        }
        if (this.crP == null) {
            this.crP = aVar.b(this.crw, this.crx);
        }
        if (this.crU == null) {
            this.crU = this.crw.mRootView.findViewById(d.h.statebar_view);
        }
        if (this.crT == null) {
            this.crT = new com.baidu.tieba.play.m(this.crw.getPageContext(), this.crF);
        }
        this.crT.setUniqueId(this.crw.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.crN != null && this.crN.getLayoutParams() != null) {
            this.crN.getLayoutParams().height = i;
            this.crN.setLayoutParams(this.crN.getLayoutParams());
        }
    }

    public View ahm() {
        return this.crN;
    }

    public com.baidu.tieba.play.m ahn() {
        return this.crT;
    }

    public com.baidu.tieba.frs.entelechy.b.c aho() {
        return this.crP;
    }

    public void ez(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.u(this.crw.ahf().bpZ());
        if (this.crO != null) {
            this.crO.ez(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e ahp() {
        return this.crO;
    }

    public void u(boolean z, boolean z2) {
        if (this.crX && this.crP != null) {
            this.crP.u(z, z2);
        }
    }

    public void eA(boolean z) {
        this.crX = z;
        if (!this.crX && this.crP != null) {
            this.crP.u(false, false);
        }
    }

    public void ahq() {
        if (this.crX && this.crP != null) {
            this.crP.u(false, false);
        }
        this.crz.setVisibility(8);
        this.crA.setVisibility(8);
        ez(false);
        this.crF.setVisibility(8);
    }

    public void ahr() {
        if (this.crX && this.crP != null) {
            this.crP.u(true, false);
        }
        this.crz.setVisibility(0);
        this.crA.setVisibility(0);
        ez(true);
        this.crF.setVisibility(0);
    }

    public void eB(boolean z) {
        if (this.crP != null) {
            this.crP.eT(z);
        }
    }

    private void ahs() {
        if (this.crQ == null) {
            this.crQ = (GifView) this.crw.mRootView.findViewById(d.h.gif_real_time);
            this.crR = (TbImageView) this.crw.mRootView.findViewById(d.h.tbimg_real_time);
            this.crR.setPageId(this.crw.getUniqueId());
            this.crQ.setLayerType(1, null);
            this.crR.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aht() {
        return this.cry;
    }

    public void h(NoNetworkView.a aVar) {
        this.cow = aVar;
        if (this.ccF != null) {
            this.ccF.a(this.cow);
        }
    }

    public void cj(boolean z) {
        this.crv = z;
        if (z) {
            if (this.crP != null) {
                this.crP.ajk();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.crF.getAdapter()).notifyDataSetChanged();
        if (this.crP != null) {
            this.crP.ajl();
        }
    }

    public void eC(boolean z) {
        if (this.crP != null) {
            if (z) {
                u(true, true);
            } else {
                u(true, false);
            }
        }
    }

    public void eD(boolean z) {
        if (this.crP != null) {
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
        this.crF.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.crG.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.crG.setForumName(str);
        this.mForumName = str;
    }

    public void cI(boolean z) {
        this.crG.cI(z);
    }

    public void onDestroy() {
        if (this.crT != null) {
            this.crT.destroy();
        }
        this.crG.onDestory();
        this.crF.setOnSrollToBottomListener(null);
        this.crF.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.crY);
        if (this.ceb != null) {
            this.ceb.onDestroy();
        }
        this.crS.clear();
        if (this.crO != null) {
            this.crO.ajp();
        }
        if (this.crU != null) {
            this.crU.setBackgroundDrawable(null);
        }
    }

    public boolean ahu() {
        if (this.crO != null) {
            return this.crO.ahu();
        }
        return false;
    }

    public boolean ahg() {
        return this.crv;
    }

    public void NX() {
        this.crF.setVisibility(0);
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
            com.baidu.tbadk.core.h.oM().cm(str);
        }
    }

    public void ahv() {
        if (this.crG != null) {
            this.crG.notifyDataSetChanged();
        }
    }

    public void YR() {
        if (this.crG instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.crG).YR();
        }
    }

    private void ahw() {
        if (this.crH == null && this.crw.getPageContext() != null) {
            String[] strArr = {this.crw.getPageContext().getPageActivity().getString(d.l.take_photo), this.crw.getPageContext().getPageActivity().getString(d.l.album)};
            this.crH = new com.baidu.tbadk.core.dialog.b(this.crw.getPageContext().getPageActivity());
            this.crH.cM(this.crw.getPageContext().getPageActivity().getString(d.l.operation));
            this.crH.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.crw.ahh();
                    } else if (i == 1 && i.this.crw.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(i.this.crw.getPageContext().getPageActivity());
                    }
                }
            });
            this.crH.d(this.crw.getPageContext());
        }
    }

    public void ahx() {
        ahw();
        if (this.crH != null) {
            this.crH.te();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tbadk.core.util.v.u(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.crw != null && this.crw.agK() != null && this.crw.agK().akQ() == 0) {
                kVar.jf(this.crw.agK().akY());
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
        this.crG.b(arrayList, iVar);
        if (this.crT != null) {
            this.crT.a(this.crn, this.beu, this.crM, true);
        }
    }

    public BdTypeListView getListView() {
        return this.crF;
    }

    public void ahy() {
        this.crG.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.crw.getPageContext(), 1);
        aVar.a(this.crF);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.crw.getForumName());
        hashMap.put("forum_id", this.crw.getForumId());
        aVar.setParams(hashMap);
        aVar.H(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.crO != null) {
            this.crO.ajq();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.crO != null) {
            this.crO.ajr();
        }
    }

    public void release() {
        if (this.ccF != null && this.cow != null) {
            this.ccF.b(this.cow);
        }
    }

    public ImageView ahz() {
        return this.crA;
    }

    public ImageView ahA() {
        return this.crz;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.crw, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.crw.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.crR != null) {
            this.crR.invalidate();
        }
        if (this.crG != null) {
            this.crG.aiZ();
            this.crG.notifyDataSetChanged();
        }
        this.crw.xA().getLayoutMode().ah(i == 1);
        this.crw.xA().getLayoutMode().t(this.crx);
        if (this.crx != null) {
            com.baidu.tbadk.core.util.aj.e(this.crx, d.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.crw.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cR(d.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.crJ, d.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.ccF != null) {
            this.ccF.onChangeSkinType(this.crw.getPageContext(), i);
        }
        if (this.bfN != null) {
            this.bfN.dy(i);
        }
        eG(false);
        if (this.crP != null) {
            this.crP.onChangeSkinType(i);
        }
        if (this.crO != null) {
            this.crO.onChangeSkinType(i);
        }
        if (this.crU != null) {
            UtilHelper.setStatusBarBackground(this.crU, i);
        }
        if (this.crT != null) {
            this.crT.a(this.crn, this.beu, this.crM, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
    }

    public void startPullRefresh() {
        this.crF.startPullRefresh();
    }

    public void ahB() {
        this.crF.completePullRefreshPostDelayed(2000L);
    }

    public boolean ahC() {
        return this.crB != null && this.crE.getVisibility() == 0;
    }

    public void ahD() {
        if (this.crB != null) {
            this.crC.setVisibility(0);
            this.crE.setVisibility(8);
            this.crD.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.crY, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bo boVar) {
        if (this.crB == null) {
            this.crB = (ViewStub) this.crw.mRootView.findViewById(d.h.yule_game_egg_view_stub);
            this.crB.setVisibility(0);
            this.crC = (FrameLayout) this.crw.mRootView.findViewById(d.h.game_activity_egg_layout);
            this.crD = (TbImageView) this.crw.mRootView.findViewById(d.h.game_activity_egg);
            this.crE = (TbImageView) this.crw.mRootView.findViewById(d.h.game_activity_egg_s);
            this.crD.setPageId(this.crw.getUniqueId());
            this.crE.setPageId(this.crw.getUniqueId());
            this.crD.setDefaultBgResource(d.e.common_color_10022);
            this.crD.setDefaultResource(0);
            this.crE.setDefaultBgResource(d.e.common_color_10022);
            this.crE.setDefaultResource(0);
            this.crC.setOnClickListener(this.crI);
        }
        this.crC.setVisibility(0);
        String sR = boVar.sR();
        String sS = boVar.sS();
        this.crD.c(sR, 10, false);
        this.crE.c(sS, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.crY, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void ahE() {
        if (this.crB != null) {
            this.crC.setVisibility(8);
        }
    }

    public r ahF() {
        return this.crG;
    }

    public ViewGroup ahG() {
        return this.crx;
    }

    public View ahH() {
        return this.crK;
    }

    public void ahI() {
        if (com.baidu.tbadk.k.r.FW().FX()) {
            int lastVisiblePosition = this.crF.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.crF.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.csn != null) {
                        com.baidu.tbadk.k.l perfLog = mVar.csn.getPerfLog();
                        perfLog.fs(1000);
                        perfLog.aIQ = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.csn.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.csn.vW();
                    }
                    if (mVar.csl != null && (mVar.csl instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.csl;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fs(1000);
                                perfLog2.aIQ = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.vW();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar ahe() {
        return this.mNavigationBar;
    }

    public void ahJ() {
        this.mHasMore = true;
        this.crF.setNextPage(this.bfN);
        if (this.crL > 0) {
            this.bfN.dA(d.e.cp_bg_line_d);
            this.bfN.dz(this.crL);
        }
        this.bfN.wm();
    }

    public void ahK() {
        this.mHasMore = false;
        this.crF.setNextPage(this.bfN);
        if (this.crL > 0) {
            this.bfN.dA(d.e.cp_bg_line_d);
            this.bfN.dz(this.crL);
        }
        this.bfN.wn();
        this.bfN.setText(this.crw.getResources().getString(d.l.list_no_more));
    }

    public void YS() {
        this.mHasMore = false;
        this.crF.setNextPage(null);
    }

    public boolean YI() {
        return this.bfN.getView().getParent() != null && this.mHasMore;
    }

    public void jb(int i) {
        this.crL = i;
    }

    public void jc(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.ceb == null) {
                    this.ceb = new CommonTipView(this.crw.getActivity());
                }
                this.ceb.setText(d.l.frs_login_tip);
                this.ceb.a((FrameLayout) ahH(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eE(boolean z) {
        if (this.crT != null) {
            if (z) {
                this.crT.hs(false);
                this.crT.aqY();
                return;
            }
            this.crT.hs(true);
            this.crT.a(this.crn, this.beu, this.crM, true);
        }
    }

    public void aw(int i, int i2) {
        if (this.crT != null) {
            this.crT.a(i, i2, this.crM, 1);
        }
    }

    public void ax(int i, int i2) {
        this.crn = i;
        this.beu = i2;
    }

    public void eF(boolean z) {
        this.crM = z;
    }

    public void ahL() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.g.frs_star_navigation_bg);
        }
    }

    private void ahM() {
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

    private void eG(boolean z) {
        boolean i = com.baidu.tieba.frs.h.f.i(this.crw.ahf());
        boolean h = com.baidu.tieba.frs.h.f.h(this.crw.ahf());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bBr) {
                    this.bBr = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.crz, d.g.icon_sml_search_bg, d.g.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.crA, d.g.btn_sml_more_bg, d.g.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bBr) {
                this.bBr = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.g.icon_return_bg_s, d.g.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.crz, d.g.icon_search_bg_s, d.g.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.crA, d.g.btn_more_selector_s, d.g.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        ahM();
    }

    public void eH(boolean z) {
        if (!this.crF.bqv()) {
            this.crF.setStarForum(true);
            if (z && !this.crw.ahi()) {
                this.mPullView = new com.baidu.tbadk.core.view.h(this.crw.getPageContext());
                this.mPullView.setTag(this.crw.getUniqueId());
                this.crF.setPullRefresh(this.mPullView);
            }
        }
    }

    public void jd(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void je(int i) {
        if (this.crF != null && this.crF.getChildCount() >= 0) {
            if (this.crF.getFirstVisiblePosition() > 8) {
                this.crF.setSelection(8);
            }
            this.crF.smoothScrollToPosition(i);
        }
    }

    public void ahN() {
        a(this.crW, this.crw.ahi());
        if (this.crG != null) {
            this.crG.aje();
        }
    }
}
