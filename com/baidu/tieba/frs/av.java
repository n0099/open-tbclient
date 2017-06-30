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
public class av {
    private CommonTipView bUu;
    private PbListView bbP;
    private NoNetworkView bzB;
    private ViewStub cdA;
    private com.baidu.tieba.frs.entelechy.a.al cdF;
    private View.OnClickListener cdH;
    private View cdI;
    private View cdJ;
    private View cdM;
    private com.baidu.tieba.frs.entelechy.b.e cdN;
    private com.baidu.tieba.frs.entelechy.b.c cdO;
    private GifView cdP;
    private TbImageView cdQ;
    private HashSet<String> cdR;
    private com.baidu.tieba.play.ac cdS;
    private ObservedChangeLinearLayout cdT;
    private r cdv;
    private View cdx;
    private ImageView cdy;
    private ImageView cdz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ah mPullView;
    private boolean cdu = false;
    private NoPressedRelativeLayout cdw = null;
    private FrameLayout cdB = null;
    private TbImageView cdC = null;
    private TbImageView cdD = null;
    private BdExpandListView cdE = null;
    private com.baidu.tbadk.core.dialog.c cdG = null;
    private NoNetworkView.a bzE = null;
    private boolean mHasMore = true;
    private int cdK = 0;
    private boolean cdL = false;
    private int cdm = 0;
    private int baJ = 0;
    private View bVj = null;
    private boolean bsg = true;
    private Runnable cdU = new aw(this);

    public ObservedChangeLinearLayout aep() {
        return this.cdT;
    }

    public View aeq() {
        return this.bVj;
    }

    public av(r rVar, View.OnClickListener onClickListener, a aVar, boolean z) {
        this.cdv = null;
        this.cdH = null;
        this.cdv = rVar;
        this.cdH = onClickListener;
        a(aVar, z);
        this.cdR = new HashSet<>();
    }

    private void a(a aVar, boolean z) {
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.cdv.getPageContext());
        this.mPullView.setTag(this.cdv.getUniqueId());
        this.cdw = (NoPressedRelativeLayout) this.cdv.mRootView.findViewById(w.h.frs);
        com.baidu.tbadk.core.util.as.k(this.cdw, w.e.cp_bg_line_d);
        this.cdJ = this.cdv.mRootView.findViewById(w.h.frs_list_content);
        this.cdT = (ObservedChangeLinearLayout) this.cdv.mRootView.findViewById(w.h.navigation_bar_wrapperLayout);
        this.cdT.setOnSizeChangeListener(new ax(this));
        this.mNavigationBar = (NavigationBar) this.cdv.mRootView.findViewById(w.h.view_navigation_bar);
        if (this.cdv.aem()) {
            this.mNavigationBar.setVisibility(8);
        }
        this.cdI = this.cdv.mRootView.findViewById(w.h.frs_navi_line);
        b afe = aVar.afe();
        if (afe != null) {
            afe.af(this.cdI);
        }
        this.cdx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cdx.setOnClickListener(this.cdH);
        this.mBackImageView = (ImageView) this.cdx.findViewById(w.h.widget_navi_back_button);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.cdv.getPageContext().getPageActivity(), w.f.ds24), 0);
        this.cdy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
        this.cdy.setLayoutParams(layoutParams);
        this.cdy.setOnClickListener(this.cdH);
        this.cdz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.cdz.setLayoutParams(layoutParams);
        this.cdz.setOnClickListener(this.cdH);
        this.mNavigationBar.onChangeSkinType(this.cdv.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        com.baidu.tbadk.core.util.as.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        this.cdE = (BdExpandListView) this.cdv.mRootView.findViewById(w.h.frs_lv_thread);
        this.cdE.setScrollable(this.cdv);
        this.cdE.setFadingEdgeLength(0);
        this.cdE.setOverScrollMode(2);
        this.cdw.setBottomOrderView(this.cdE);
        this.cdE.setOnTouchListener(this.cdv.aKv);
        this.cdE.setDivider(null);
        this.cdE.setPullRefresh(this.mPullView);
        if (z) {
            this.cdM = BdListViewHelper.a(this.cdv.getActivity(), this.cdE, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cdE.setDividerHeight(0);
        this.cdE.setRecyclerListener(new ay(this));
        this.bbP = new PbListView(this.cdv.getPageContext().getPageActivity());
        this.bbP.lc();
        this.bbP.dk(w.e.cp_bg_line_c);
        this.cdE.setOnSrollToBottomListener(this.cdv);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.v(new az(this)));
        this.cdF = aVar.a(this.cdv, this.cdE, com.baidu.tbadk.core.util.ax.vA().vC());
        ch(false);
        if (!z) {
            this.bzB = new NoNetworkView(this.cdv.getActivity());
            this.bzB.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.cdT.addView(this.bzB);
            if (com.baidu.adp.lib.util.i.gX()) {
                this.bzB.setVisibility(8);
            } else {
                this.bzB.setVisibility(0);
            }
            this.bzB.onChangeSkinType(this.cdv.xN(), TbadkCoreApplication.m9getInst().getSkinType());
        }
        aev();
        this.cdN = aVar.c(this.cdv, this.cdw);
        this.cdO = aVar.b(this.cdv, this.cdw);
        this.bVj = this.cdv.mRootView.findViewById(w.h.statebar_view);
        this.cdS = new com.baidu.tieba.play.ac(this.cdv.getPageContext(), this.cdE);
        this.cdS.setUniqueId(this.cdv.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cdM != null && this.cdM.getLayoutParams() != null) {
            this.cdM.getLayoutParams().height = i;
            this.cdM.setLayoutParams(this.cdM.getLayoutParams());
        }
    }

    public View aer() {
        return this.cdM;
    }

    public com.baidu.tieba.play.ac aes() {
        return this.cdS;
    }

    public com.baidu.tieba.frs.entelechy.b.c aet() {
        return this.cdO;
    }

    public void eu(boolean z) {
        if (this.cdN != null) {
            this.cdN.eu(z);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e aeu() {
        return this.cdN;
    }

    public void r(boolean z, boolean z2) {
        if (this.cdO != null) {
            this.cdO.r(z, z2);
        }
    }

    public void ev(boolean z) {
        if (this.cdO != null) {
            this.cdO.eF(z);
        }
    }

    private void aev() {
        this.cdP = (GifView) this.cdv.mRootView.findViewById(w.h.gif_real_time);
        this.cdQ = (TbImageView) this.cdv.mRootView.findViewById(w.h.tbimg_real_time);
        this.cdQ.setPageId(this.cdv.getUniqueId());
        this.cdP.setLayerType(1, null);
        this.cdQ.setLayerType(1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aew() {
        return this.cdx;
    }

    public void c(NoNetworkView.a aVar) {
        this.bzE = aVar;
        if (this.bzB != null) {
            this.bzB.a(this.bzE);
        }
    }

    public void ch(boolean z) {
        this.cdu = z;
        if (z) {
            if (this.cdO != null) {
                this.cdO.afG();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.cdE.getAdapter()).notifyDataSetChanged();
        if (this.cdO != null) {
            this.cdO.afH();
        }
    }

    public void ew(boolean z) {
        if (this.cdO != null) {
            if (z) {
                r(true, true);
            } else {
                r(true, false);
            }
        }
    }

    public void ex(boolean z) {
        if (this.cdO != null) {
            if (z) {
                r(false, true);
            } else {
                r(false, false);
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
        this.cdE.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.x xVar) {
        this.cdF.setOnAdapterItemClickListener(xVar);
    }

    public void setForumName(String str) {
        this.cdF.setForumName(str);
        this.mForumName = str;
    }

    public void cA(boolean z) {
        this.cdF.cA(z);
    }

    public void onDestroy() {
        if (this.cdS != null) {
            this.cdS.destroy();
        }
        this.cdF.onDestory();
        this.cdE.setOnSrollToBottomListener(null);
        this.cdE.setScrollable(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.cdU);
        if (this.bUu != null) {
            this.bUu.onDestroy();
        }
        this.cdR.clear();
        if (this.cdN != null) {
            this.cdN.afL();
        }
        if (this.bVj != null) {
            this.bVj.setBackgroundDrawable(null);
        }
    }

    public boolean aex() {
        if (this.cdN != null) {
            return this.cdN.aex();
        }
        return false;
    }

    public boolean ael() {
        return this.cdu;
    }

    public void Nq() {
        this.cdE.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setCenterTextTitle("");
            return;
        }
        this.mNavigationBar.setCenterTextTitle(String.valueOf(UtilHelper.getFixedBarText(str, 7, true, false)) + this.cdv.getActivity().getString(w.l.forum));
        com.baidu.tbadk.core.r.oK().cj(str);
    }

    public void aey() {
        if (this.cdF != null) {
            this.cdF.notifyDataSetChanged();
        }
    }

    public void WT() {
        if (this.cdF instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cdF).WT();
        }
    }

    private void aez() {
        if (this.cdG == null) {
            String[] strArr = {this.cdv.getPageContext().getPageActivity().getString(w.l.take_photo), this.cdv.getPageContext().getPageActivity().getString(w.l.album)};
            this.cdG = new com.baidu.tbadk.core.dialog.c(this.cdv.getPageContext().getPageActivity());
            this.cdG.cJ(this.cdv.getPageContext().getPageActivity().getString(w.l.operation));
            this.cdG.a(strArr, new ba(this));
            this.cdG.d(this.cdv.getPageContext());
        }
    }

    public void aeA() {
        aez();
        if (this.cdG != null) {
            this.cdG.td();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tbadk.core.util.z.t(arrayList)) {
            bc bcVar = new bc();
            arrayList = new ArrayList<>();
            arrayList.add(bcVar);
            if (this.cdv != null && this.cdv.adP() != null && this.cdv.adP().agL() == 0) {
                bcVar.iz(this.cdv.adP().agT());
            }
        }
        if (com.baidu.tbadk.core.util.z.s(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
                if (vVar instanceof com.baidu.tbadk.core.data.bm) {
                    ((com.baidu.tbadk.core.data.bm) vVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.cdF.b(arrayList, nVar);
        if (this.cdS != null) {
            this.cdS.a(this.cdm, this.baJ, this.cdL, true);
        }
    }

    public BdTypeListView getListView() {
        return this.cdE;
    }

    public void aeB() {
        this.cdF.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cdv.getPageContext(), 1);
        aVar.a(this.cdE);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cdv.getForumName());
        hashMap.put("forum_id", this.cdv.getForumId());
        aVar.setParams(hashMap);
        aVar.J(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.cdN != null) {
            this.cdN.afM();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.cdN != null) {
            this.cdN.afN();
        }
    }

    public void release() {
        if (this.bzB != null && this.bzE != null) {
            this.bzB.b(this.bzE);
        }
    }

    public ImageView aeC() {
        return this.cdz;
    }

    public ImageView aeD() {
        return this.cdy;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cdv, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cdv.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        com.baidu.tbadk.core.util.as.b(this.cdy, w.g.icon_search_bg_s, w.g.icon_search_bg);
        com.baidu.tbadk.core.util.as.b(this.cdz, w.g.btn_more_selector_s, w.g.btn_more_selector);
        if (this.cdQ != null) {
            this.cdQ.invalidate();
        }
        if (this.cdF != null) {
            this.cdF.afx();
            this.cdF.notifyDataSetChanged();
        }
        this.cdv.xN().getLayoutMode().ah(i == 1);
        this.cdv.xN().getLayoutMode().t(this.cdw);
        if (this.cdw != null) {
            com.baidu.tbadk.core.util.as.e(this.cdw, w.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cdv.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.as.cP(w.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.as.e(this.cdI, w.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.as.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        }
        if (this.bzB != null) {
            this.bzB.onChangeSkinType(this.cdv.getPageContext(), i);
        }
        if (this.bbP != null) {
            this.bbP.dl(i);
        }
        eA(false);
        if (this.cdO != null) {
            this.cdO.onChangeSkinType(i);
        }
        if (this.cdN != null) {
            this.cdN.onChangeSkinType(i);
        }
        if (this.bVj != null) {
            UtilHelper.setStatusBarBackground(this.bVj, i);
        }
        if (this.cdS != null) {
            this.cdS.a(this.cdm, this.baJ, this.cdL, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
    }

    public void startPullRefresh() {
        this.cdE.startPullRefresh();
    }

    public void aeE() {
        this.cdE.completePullRefreshPostDelayed(2000L);
    }

    public boolean aeF() {
        return this.cdA != null && this.cdD.getVisibility() == 0;
    }

    public void aeG() {
        if (this.cdA != null) {
            this.cdB.setVisibility(0);
            this.cdD.setVisibility(8);
            this.cdC.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.cdU, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bu buVar) {
        if (this.cdA == null) {
            this.cdA = (ViewStub) this.cdv.mRootView.findViewById(w.h.yule_game_egg_view_stub);
            this.cdA.setVisibility(0);
            this.cdB = (FrameLayout) this.cdv.mRootView.findViewById(w.h.game_activity_egg_layout);
            this.cdC = (TbImageView) this.cdv.mRootView.findViewById(w.h.game_activity_egg);
            this.cdD = (TbImageView) this.cdv.mRootView.findViewById(w.h.game_activity_egg_s);
            this.cdC.setPageId(this.cdv.getUniqueId());
            this.cdD.setPageId(this.cdv.getUniqueId());
            this.cdC.setDefaultBgResource(w.e.common_color_10022);
            this.cdC.setDefaultResource(0);
            this.cdD.setDefaultBgResource(w.e.common_color_10022);
            this.cdD.setDefaultResource(0);
            this.cdB.setOnClickListener(this.cdH);
        }
        this.cdB.setVisibility(0);
        String sQ = buVar.sQ();
        String sR = buVar.sR();
        this.cdC.c(sQ, 10, false);
        this.cdD.c(sR, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.cdU, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void aeH() {
        if (this.cdA != null) {
            this.cdB.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al aeI() {
        return this.cdF;
    }

    public ViewGroup Vf() {
        return this.cdw;
    }

    public View aeJ() {
        return this.cdJ;
    }

    public void aeK() {
        if (com.baidu.tbadk.j.aa.Gb().Gc()) {
            int lastVisiblePosition = this.cdE.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cdE.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof be)) {
                    be beVar = (be) childAt.getTag();
                    if (beVar.cej != null) {
                        com.baidu.tbadk.j.u perfLog = beVar.cej.getPerfLog();
                        perfLog.fd(1000);
                        perfLog.aHC = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            beVar.cej.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        beVar.cej.wk();
                    }
                    if (beVar.ceh != null && (beVar.ceh instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = beVar.ceh;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.j.u perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fd(1000);
                                perfLog2.aHC = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.wk();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar aeL() {
        return this.mNavigationBar;
    }

    public void Vl() {
        this.mHasMore = true;
        this.cdE.setNextPage(this.bbP);
        if (this.cdK > 0) {
            this.bbP.dm(this.cdK);
        }
        this.bbP.wD();
    }

    public void Vn() {
        this.mHasMore = false;
        this.cdE.setNextPage(this.bbP);
        if (this.cdK > 0) {
            this.bbP.dm(this.cdK);
        }
        this.bbP.wE();
        this.bbP.setText(this.cdv.getResources().getString(w.l.list_no_more));
    }

    public void WU() {
        this.mHasMore = false;
        this.cdE.setNextPage(null);
    }

    public boolean WJ() {
        return this.bbP.getView().getParent() != null && this.mHasMore;
    }

    public void iv(int i) {
        this.cdK = i;
    }

    public void iw(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.bUu == null) {
                    this.bUu = new CommonTipView(this.cdv.getActivity());
                }
                this.bUu.setText(w.l.frs_login_tip);
                this.bUu.a((FrameLayout) aeJ(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void ey(boolean z) {
        if (this.cdS != null) {
            if (z) {
                this.cdS.hg(false);
                this.cdS.aog();
                return;
            }
            this.cdS.hg(true);
            this.cdS.a(this.cdm, this.baJ, this.cdL, true);
        }
    }

    public void ao(int i, int i2) {
        if (this.cdS != null) {
            this.cdS.a(i, i2, this.cdL, 1);
        }
    }

    public void ap(int i, int i2) {
        this.cdm = i;
        this.baJ = i2;
    }

    public void ez(boolean z) {
        this.cdL = z;
    }

    public void aeM() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.as.j(this.mBackImageView, w.g.frs_star_navigation_bg);
        }
    }

    private void aeN() {
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

    private void eA(boolean z) {
        boolean i = com.baidu.tieba.frs.f.m.i(this.cdv.aek());
        boolean h = com.baidu.tieba.frs.f.m.h(this.cdv.aek());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bsg) {
                    this.bsg = true;
                    com.baidu.tbadk.core.util.as.b(this.mBackImageView, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.as.j(this.mBackImageView, w.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bsg) {
                this.bsg = false;
                com.baidu.tbadk.core.util.as.b(this.mBackImageView, w.g.icon_return_bg_s, w.g.icon_return_bg);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        aeN();
    }

    public void eB(boolean z) {
        if (!this.cdE.blA()) {
            this.cdE.setStarForum(true);
            if (z && !this.cdv.aem()) {
                this.mPullView = new com.baidu.tbadk.core.view.ah(this.cdv.getPageContext());
                this.mPullView.setTag(this.cdv.getUniqueId());
                this.cdE.setPullRefresh(this.mPullView);
            }
        }
    }

    public void ix(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void iy(int i) {
        if (this.cdE != null && this.cdE.getChildCount() >= 0) {
            if (this.cdE.getFirstVisiblePosition() > 8) {
                this.cdE.setSelection(8);
            }
            this.cdE.smoothScrollToPosition(i);
        }
    }
}
