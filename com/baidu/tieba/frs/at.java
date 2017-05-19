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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.entelechy.b.a;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class at {
    private com.baidu.tieba.play.ac aRC;
    private PbListView aSj;
    private NoNetworkView bGF;
    private CommonTipView bHK;
    private ImageView bPA;
    private ViewStub bPB;
    private com.baidu.tieba.frs.entelechy.a.am bPG;
    private View.OnClickListener bPI;
    private View bPJ;
    private View bPK;
    private View bPM;
    private com.baidu.tieba.frs.entelechy.b.e bPN;
    private com.baidu.tieba.frs.entelechy.b.c bPO;
    private GifView bPP;
    private TbImageView bPQ;
    private HashSet<String> bPR;
    private com.baidu.tieba.frs.view.p bPS;
    private ObservedChangeLinearLayout bPT;
    private View bPU;
    private r bPw;
    private View bPy;
    private ImageView bPz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ah mPullView;
    private boolean bPv = false;
    private NoPressedRelativeLayout bPx = null;
    private FrameLayout bPC = null;
    private TbImageView bPD = null;
    private TbImageView bPE = null;
    private BdExpandListView bPF = null;
    private com.baidu.tbadk.core.dialog.c bPH = null;
    private NoNetworkView.a bNr = null;
    private boolean mHasMore = true;
    private int bPL = 0;
    private boolean aRE = false;
    private int aRG = 0;
    private int aRF = 0;
    private View bIA = null;
    private boolean bnj = true;
    private Runnable bPV = new au(this);

    public ObservedChangeLinearLayout Zw() {
        return this.bPT;
    }

    public View Zx() {
        return this.bIA;
    }

    public at(r rVar, View.OnClickListener onClickListener, a aVar, boolean z) {
        this.bPw = null;
        this.bPI = null;
        this.bPw = rVar;
        this.bPI = onClickListener;
        a(aVar, z);
        this.bPR = new HashSet<>();
    }

    private void a(a aVar, boolean z) {
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.bPw.getPageContext());
        this.mPullView.setTag(this.bPw.getUniqueId());
        this.bPx = (NoPressedRelativeLayout) this.bPw.mRootView.findViewById(w.h.frs);
        com.baidu.tbadk.core.util.aq.k(this.bPx, w.e.cp_bg_line_d);
        this.bPK = this.bPw.mRootView.findViewById(w.h.frs_list_content);
        this.bPT = (ObservedChangeLinearLayout) this.bPw.mRootView.findViewById(w.h.navigation_bar_wrapperLayout);
        this.bPT.setOnSizeChangeListener(new av(this));
        this.mNavigationBar = (NavigationBar) this.bPw.mRootView.findViewById(w.h.view_navigation_bar);
        if (this.bPw.Zt()) {
            this.mNavigationBar.setVisibility(8);
        }
        this.bPJ = this.bPw.mRootView.findViewById(w.h.frs_navi_line);
        b aal = aVar.aal();
        if (aal != null) {
            aal.ae(this.bPJ);
        }
        this.bPy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bPy.setOnClickListener(this.bPI);
        this.mBackImageView = (ImageView) this.bPy.findViewById(w.h.widget_navi_back_button);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.bPw.getPageContext().getPageActivity(), w.f.ds24), 0);
        this.bPz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
        this.bPz.setLayoutParams(layoutParams);
        this.bPz.setOnClickListener(this.bPI);
        this.bPA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.bPA.setLayoutParams(layoutParams);
        this.bPA.setOnClickListener(this.bPI);
        this.mNavigationBar.onChangeSkinType(this.bPw.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        com.baidu.tbadk.core.util.aq.k(this.bPU, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        this.bPF = (BdExpandListView) this.bPw.mRootView.findViewById(w.h.frs_lv_thread);
        this.bPF.setScrollable(this.bPw);
        this.bPF.setFadingEdgeLength(0);
        this.bPF.setOverScrollMode(2);
        this.bPx.setBottomOrderView(this.bPF);
        this.bPF.setOnTouchListener(this.bPw.aJt);
        this.bPF.setDivider(null);
        this.bPF.setPullRefresh(this.mPullView);
        if (z) {
            this.bPM = BdListViewHelper.a(this.bPw.getActivity(), this.bPF, BdListViewHelper.HeadType.DEFAULT);
        }
        this.bPF.setDividerHeight(0);
        this.bPF.setRecyclerListener(new aw(this));
        this.aSj = new PbListView(this.bPw.getPageContext().getPageActivity());
        this.aSj.le();
        this.aSj.dh(w.e.cp_bg_line_c);
        this.bPF.setOnSrollToBottomListener(this.bPw);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.v(new ax(this)));
        this.bPG = aVar.a(this.bPw, this.bPF, com.baidu.tbadk.core.util.av.vo().vq());
        ci(false);
        this.bGF = new NoNetworkView(this.bPw.getActivity());
        if (!z) {
            this.bGF.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.bGF.setVisibility(8);
            this.bPT.addView(this.bGF);
        }
        this.bGF.onChangeSkinType(this.bPw.xD(), TbadkCoreApplication.m9getInst().getSkinType());
        ZA();
        this.bPN = aVar.c(this.bPw, this.bPx);
        this.bPO = aVar.b(this.bPw, this.bPx);
        this.bIA = this.bPw.mRootView.findViewById(w.h.statebar_view);
        this.aRC = new com.baidu.tieba.play.ac(this.bPw.getPageContext(), this.bPF);
        this.aRC.setUniqueId(this.bPw.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.bPM != null && this.bPM.getLayoutParams() != null) {
            this.bPM.getLayoutParams().height = i;
            this.bPM.setLayoutParams(this.bPM.getLayoutParams());
        }
    }

    public View Zy() {
        return this.bPM;
    }

    public com.baidu.tieba.play.ac Kq() {
        return this.aRC;
    }

    public com.baidu.tieba.frs.entelechy.b.c Zz() {
        return this.bPO;
    }

    public void dM(boolean z) {
        if (this.bPN != null) {
            this.bPN.dM(z);
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.bPO != null) {
            this.bPO.n(z, z2);
        }
    }

    public void dN(boolean z) {
        if (this.bPO != null) {
            this.bPO.dX(z);
        }
    }

    private void ZA() {
        this.bPP = (GifView) this.bPw.mRootView.findViewById(w.h.gif_real_time);
        this.bPQ = (TbImageView) this.bPw.mRootView.findViewById(w.h.tbimg_real_time);
        this.bPQ.setPageId(this.bPw.getUniqueId());
        this.bPP.setLayerType(1, null);
        this.bPQ.setLayerType(1, null);
    }

    public com.baidu.tieba.frs.view.p ZB() {
        return this.bPS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ZC() {
        return this.bPy;
    }

    public void h(NoNetworkView.a aVar) {
        this.bNr = aVar;
        if (this.bGF != null) {
            this.bGF.a(this.bNr);
        }
    }

    public void ci(boolean z) {
        this.bPv = z;
        if (z) {
            if (this.bPO != null) {
                this.bPO.aaL();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bPF.getAdapter()).notifyDataSetChanged();
        if (this.bPO != null) {
            this.bPO.aaM();
        }
    }

    public void dO(boolean z) {
        if (this.bPO != null) {
            if (z) {
                n(true, true);
            } else {
                n(true, false);
            }
        }
    }

    public void dP(boolean z) {
        if (this.bPO != null) {
            if (z) {
                n(false, true);
            } else {
                n(false, false);
            }
        }
    }

    public void a(ae.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(ae.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(ae.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bPF.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.w wVar) {
        this.bPG.setOnAdapterItemClickListener(wVar);
    }

    public void setForumName(String str) {
        this.bPG.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.aRC != null) {
            this.aRC.destroy();
        }
        this.bPG.onDestory();
        this.bPF.setOnSrollToBottomListener(null);
        this.bPF.setScrollable(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bPV);
        if (this.bHK != null) {
            this.bHK.onDestroy();
        }
        this.bPR.clear();
        if (this.bPN != null) {
            this.bPN.aaQ();
        }
        if (this.bIA != null) {
            this.bIA.setBackgroundDrawable(null);
        }
    }

    public boolean ZD() {
        if (this.bPN != null) {
            return this.bPN.ZD();
        }
        return false;
    }

    public boolean Zr() {
        return this.bPv;
    }

    public void Kn() {
        this.bPF.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setCenterTextTitle("");
            return;
        }
        this.mNavigationBar.setCenterTextTitle(String.valueOf(UtilHelper.getFixedBarText(str, 7, true, false)) + this.bPw.getActivity().getString(w.l.forum));
        com.baidu.tbadk.core.r.oV().cd(str);
    }

    public void ZE() {
        if (this.bPG != null) {
            this.bPG.notifyDataSetChanged();
        }
    }

    private void ZF() {
        if (this.bPH == null) {
            String[] strArr = {this.bPw.getPageContext().getPageActivity().getString(w.l.take_photo), this.bPw.getPageContext().getPageActivity().getString(w.l.album)};
            this.bPH = new com.baidu.tbadk.core.dialog.c(this.bPw.getPageContext().getPageActivity());
            this.bPH.cD(this.bPw.getPageContext().getPageActivity().getString(w.l.operation));
            this.bPH.a(strArr, new ay(this));
            this.bPH.d(this.bPw.getPageContext());
        }
    }

    public void ZG() {
        ZF();
        if (this.bPH != null) {
            this.bPH.tg();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tbadk.core.util.x.r(arrayList)) {
            ba baVar = new ba();
            arrayList = new ArrayList<>();
            arrayList.add(baVar);
            if (this.bPw != null && this.bPw.YU() != null && this.bPw.YU().abO() == 0) {
                baVar.hP(this.bPw.YU().abW());
            }
        }
        if (com.baidu.tbadk.core.util.x.q(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
                if (vVar instanceof com.baidu.tbadk.core.data.bk) {
                    ((com.baidu.tbadk.core.data.bk) vVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.bPG.b(arrayList, nVar);
        if (this.aRC != null) {
            this.aRC.a(this.aRG, this.aRF, this.aRE, true);
        }
    }

    public BdTypeListView getListView() {
        return this.bPF;
    }

    public void ZH() {
        this.bPG.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bPw.getPageContext(), 1);
        aVar.a(this.bPF);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.bPw.getForumName());
        hashMap.put("forum_id", this.bPw.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.bPN != null) {
            this.bPN.aaR();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.bPN != null) {
            this.bPN.aaS();
        }
    }

    public void release() {
        if (this.bGF != null && this.bNr != null) {
            this.bGF.b(this.bNr);
        }
    }

    public ImageView ZI() {
        return this.bPA;
    }

    public ImageView ZJ() {
        return this.bPz;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bPw.getPageContext(), 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bPw.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        com.baidu.tbadk.core.util.aq.b(this.bPz, w.g.icon_search_bg_s, w.g.icon_search_bg);
        com.baidu.tbadk.core.util.aq.b(this.bPA, w.g.btn_more_selector_s, w.g.btn_more_selector);
        if (this.bPQ != null) {
            this.bPQ.invalidate();
        }
        if (this.bPG != null) {
            this.bPG.aaD();
            this.bPG.notifyDataSetChanged();
        }
        this.bPw.xD().getLayoutMode().ai(i == 1);
        this.bPw.xD().getLayoutMode().t(this.bPx);
        if (this.bPx != null) {
            com.baidu.tbadk.core.util.aq.e(this.bPx, w.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bPw.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cM(w.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aq.e(this.bPJ, w.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aq.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        }
        if (this.bGF != null) {
            this.bGF.onChangeSkinType(this.bPw.getPageContext(), i);
        }
        if (this.aSj != null) {
            this.aSj.di(i);
        }
        dS(false);
        if (this.bPO != null) {
            this.bPO.onChangeSkinType(i);
        }
        if (this.bPN != null) {
            this.bPN.onChangeSkinType(i);
        }
        if (this.bIA != null) {
            UtilHelper.setStatusBarBackground(this.bIA, i);
        }
        if (this.aRC != null) {
            this.aRC.a(this.aRG, this.aRF, this.aRE, true);
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
    }

    public void startPullRefresh() {
        this.bPF.startPullRefresh();
    }

    public void ZK() {
        this.bPF.completePullRefreshPostDelayed(2000L);
    }

    public boolean ZL() {
        return this.bPB != null && this.bPE.getVisibility() == 0;
    }

    public void ZM() {
        if (this.bPB != null) {
            this.bPC.setVisibility(0);
            this.bPE.setVisibility(8);
            this.bPD.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bPV, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bs bsVar) {
        if (this.bPB == null) {
            this.bPB = (ViewStub) this.bPw.mRootView.findViewById(w.h.yule_game_egg_view_stub);
            this.bPB.setVisibility(0);
            this.bPC = (FrameLayout) this.bPw.mRootView.findViewById(w.h.game_activity_egg_layout);
            this.bPD = (TbImageView) this.bPw.mRootView.findViewById(w.h.game_activity_egg);
            this.bPE = (TbImageView) this.bPw.mRootView.findViewById(w.h.game_activity_egg_s);
            this.bPD.setPageId(this.bPw.getUniqueId());
            this.bPE.setPageId(this.bPw.getUniqueId());
            this.bPD.setDefaultBgResource(w.e.common_color_10022);
            this.bPD.setDefaultResource(0);
            this.bPE.setDefaultBgResource(w.e.common_color_10022);
            this.bPE.setDefaultResource(0);
            this.bPC.setOnClickListener(this.bPI);
        }
        this.bPC.setVisibility(0);
        String sT = bsVar.sT();
        String sU = bsVar.sU();
        this.bPD.c(sT, 10, false);
        this.bPE.c(sU, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bPV, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void ZN() {
        if (this.bPB != null) {
            this.bPC.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.am ZO() {
        return this.bPG;
    }

    public ViewGroup ZP() {
        return this.bPx;
    }

    public View ZQ() {
        return this.bPK;
    }

    public void ZR() {
        if (com.baidu.tbadk.j.aa.FK().FL()) {
            int lastVisiblePosition = this.bPF.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bPF.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof bc)) {
                    bc bcVar = (bc) childAt.getTag();
                    if (bcVar.bQk != null) {
                        com.baidu.tbadk.j.u perfLog = bcVar.bQk.getPerfLog();
                        perfLog.fa(1000);
                        perfLog.aGB = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            bcVar.bQk.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        bcVar.bQk.vW();
                    }
                    if (bcVar.bQi != null && (bcVar.bQi instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = bcVar.bQi;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.j.u perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fa(1000);
                                perfLog2.aGB = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
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

    public NavigationBar JH() {
        return this.mNavigationBar;
    }

    public void ZS() {
        this.mHasMore = true;
        this.bPF.setNextPage(this.aSj);
        if (this.bPL > 0) {
            this.aSj.dj(this.bPL);
        }
        this.aSj.wo();
    }

    public void JO() {
        this.mHasMore = false;
        this.bPF.setNextPage(this.aSj);
        if (this.bPL > 0) {
            this.aSj.dj(this.bPL);
        }
        this.aSj.wp();
        this.aSj.setText(this.bPw.getResources().getString(w.l.list_no_more));
    }

    public void UA() {
        this.mHasMore = false;
        this.bPF.setNextPage(null);
    }

    public boolean Up() {
        return this.aSj.getView().getParent() != null && this.mHasMore;
    }

    public void hL(int i) {
        this.bPL = i;
    }

    public void hM(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("frs_login_tip", true)) {
                if (this.bHK == null) {
                    this.bHK = new CommonTipView(this.bPw.getActivity());
                }
                this.bHK.setText(w.l.frs_login_tip);
                this.bHK.a((FrameLayout) ZQ(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void dQ(boolean z) {
        if (this.aRC != null) {
            if (z) {
                this.aRC.gz(false);
                this.aRC.ajv();
                return;
            }
            this.aRC.gz(true);
            this.aRC.a(this.aRG, this.aRF, this.aRE, true);
        }
    }

    public void ai(int i, int i2) {
        if (this.aRC != null) {
            this.aRC.a(i, i2, this.aRE, 1);
        }
    }

    public void aj(int i, int i2) {
        this.aRG = i;
        this.aRF = i2;
    }

    public void dR(boolean z) {
        this.aRE = z;
    }

    public void ZT() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
        }
    }

    private void ZU() {
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

    private void dS(boolean z) {
        boolean i = com.baidu.tieba.frs.e.u.i(this.bPw.Zq());
        boolean h = com.baidu.tieba.frs.e.u.h(this.bPw.Zq());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bnj) {
                    this.bnj = true;
                    com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bnj) {
                this.bnj = false;
                com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.icon_return_bg_s, w.g.icon_return_bg);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        ZU();
    }

    public void dT(boolean z) {
        if (!this.bPF.bfP()) {
            this.bPF.setStarForum(true);
            if (z && !this.bPw.Zt()) {
                this.mPullView = new com.baidu.tbadk.core.view.ah(this.bPw.getPageContext());
                this.mPullView.setTag(this.bPw.getUniqueId());
                this.bPF.setPullRefresh(this.mPullView);
            }
        }
    }

    public void hN(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void hO(int i) {
        if (this.bPF != null && this.bPF.getChildCount() >= 0) {
            if (this.bPF.getFirstVisiblePosition() > 8) {
                this.bPF.setSelection(8);
            }
            this.bPF.smoothScrollToPosition(i);
        }
    }
}
