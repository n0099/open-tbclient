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
public class au {
    private PbListView aZY;
    private CommonTipView bNy;
    private View bVA;
    private View bVD;
    private com.baidu.tieba.frs.entelechy.b.e bVE;
    private com.baidu.tieba.frs.entelechy.b.c bVF;
    private GifView bVG;
    private TbImageView bVH;
    private HashSet<String> bVI;
    private com.baidu.tieba.play.ac bVJ;
    private ObservedChangeLinearLayout bVK;
    private View bVL;
    private r bVm;
    private View bVo;
    private ImageView bVp;
    private ImageView bVq;
    private ViewStub bVr;
    private com.baidu.tieba.frs.entelechy.a.al bVw;
    private View.OnClickListener bVy;
    private View bVz;
    private NoNetworkView byr;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ah mPullView;
    private boolean bVl = false;
    private NoPressedRelativeLayout bVn = null;
    private FrameLayout bVs = null;
    private TbImageView bVt = null;
    private TbImageView bVu = null;
    private BdExpandListView bVv = null;
    private com.baidu.tbadk.core.dialog.c bVx = null;
    private NoNetworkView.a byu = null;
    private boolean mHasMore = true;
    private int bVB = 0;
    private boolean bVC = false;
    private int bVc = 0;
    private int bVd = 0;
    private View bOo = null;
    private boolean boq = true;
    private Runnable bVM = new av(this);

    public ObservedChangeLinearLayout aaz() {
        return this.bVK;
    }

    public View aaA() {
        return this.bOo;
    }

    public au(r rVar, View.OnClickListener onClickListener, a aVar, boolean z) {
        this.bVm = null;
        this.bVy = null;
        this.bVm = rVar;
        this.bVy = onClickListener;
        a(aVar, z);
        this.bVI = new HashSet<>();
    }

    private void a(a aVar, boolean z) {
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.bVm.getPageContext());
        this.mPullView.setTag(this.bVm.getUniqueId());
        this.bVn = (NoPressedRelativeLayout) this.bVm.mRootView.findViewById(w.h.frs);
        com.baidu.tbadk.core.util.aq.k(this.bVn, w.e.cp_bg_line_d);
        this.bVA = this.bVm.mRootView.findViewById(w.h.frs_list_content);
        this.bVK = (ObservedChangeLinearLayout) this.bVm.mRootView.findViewById(w.h.navigation_bar_wrapperLayout);
        this.bVK.setOnSizeChangeListener(new aw(this));
        this.mNavigationBar = (NavigationBar) this.bVm.mRootView.findViewById(w.h.view_navigation_bar);
        if (this.bVm.aaw()) {
            this.mNavigationBar.setVisibility(8);
        }
        this.bVz = this.bVm.mRootView.findViewById(w.h.frs_navi_line);
        b abn = aVar.abn();
        if (abn != null) {
            abn.ae(this.bVz);
        }
        this.bVo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bVo.setOnClickListener(this.bVy);
        this.mBackImageView = (ImageView) this.bVo.findViewById(w.h.widget_navi_back_button);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.bVm.getPageContext().getPageActivity(), w.f.ds24), 0);
        this.bVp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
        this.bVp.setLayoutParams(layoutParams);
        this.bVp.setOnClickListener(this.bVy);
        this.bVq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.bVq.setLayoutParams(layoutParams);
        this.bVq.setOnClickListener(this.bVy);
        this.mNavigationBar.onChangeSkinType(this.bVm.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        com.baidu.tbadk.core.util.aq.k(this.bVL, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        this.bVv = (BdExpandListView) this.bVm.mRootView.findViewById(w.h.frs_lv_thread);
        this.bVv.setScrollable(this.bVm);
        this.bVv.setFadingEdgeLength(0);
        this.bVv.setOverScrollMode(2);
        this.bVn.setBottomOrderView(this.bVv);
        this.bVv.setOnTouchListener(this.bVm.aJg);
        this.bVv.setDivider(null);
        this.bVv.setPullRefresh(this.mPullView);
        if (z) {
            this.bVD = BdListViewHelper.a(this.bVm.getActivity(), this.bVv, BdListViewHelper.HeadType.DEFAULT);
        }
        this.bVv.setDividerHeight(0);
        this.bVv.setRecyclerListener(new ax(this));
        this.aZY = new PbListView(this.bVm.getPageContext().getPageActivity());
        this.aZY.le();
        this.aZY.di(w.e.cp_bg_line_c);
        this.bVv.setOnSrollToBottomListener(this.bVm);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.v(new ay(this)));
        this.bVw = aVar.a(this.bVm, this.bVv, com.baidu.tbadk.core.util.av.vl().vn());
        cf(false);
        if (!z) {
            this.byr = new NoNetworkView(this.bVm.getActivity());
            this.byr.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.bVK.addView(this.byr);
            if (com.baidu.adp.lib.util.i.gY()) {
                this.byr.setVisibility(8);
            } else {
                this.byr.setVisibility(0);
            }
            this.byr.onChangeSkinType(this.bVm.xw(), TbadkCoreApplication.m9getInst().getSkinType());
        }
        aaE();
        this.bVE = aVar.c(this.bVm, this.bVn);
        this.bVF = aVar.b(this.bVm, this.bVn);
        this.bOo = this.bVm.mRootView.findViewById(w.h.statebar_view);
        this.bVJ = new com.baidu.tieba.play.ac(this.bVm.getPageContext(), this.bVv);
        this.bVJ.setUniqueId(this.bVm.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.bVD != null && this.bVD.getLayoutParams() != null) {
            this.bVD.getLayoutParams().height = i;
            this.bVD.setLayoutParams(this.bVD.getLayoutParams());
        }
    }

    public View aaB() {
        return this.bVD;
    }

    public com.baidu.tieba.play.ac aaC() {
        return this.bVJ;
    }

    public com.baidu.tieba.frs.entelechy.b.c aaD() {
        return this.bVF;
    }

    public void ec(boolean z) {
        if (this.bVE != null) {
            this.bVE.ec(z);
        }
    }

    public void q(boolean z, boolean z2) {
        if (this.bVF != null) {
            this.bVF.q(z, z2);
        }
    }

    public void ed(boolean z) {
        if (this.bVF != null) {
            this.bVF.en(z);
        }
    }

    private void aaE() {
        this.bVG = (GifView) this.bVm.mRootView.findViewById(w.h.gif_real_time);
        this.bVH = (TbImageView) this.bVm.mRootView.findViewById(w.h.tbimg_real_time);
        this.bVH.setPageId(this.bVm.getUniqueId());
        this.bVG.setLayerType(1, null);
        this.bVH.setLayerType(1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aaF() {
        return this.bVo;
    }

    public void c(NoNetworkView.a aVar) {
        this.byu = aVar;
        if (this.byr != null) {
            this.byr.a(this.byu);
        }
    }

    public void cf(boolean z) {
        this.bVl = z;
        if (z) {
            if (this.bVF != null) {
                this.bVF.abP();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bVv.getAdapter()).notifyDataSetChanged();
        if (this.bVF != null) {
            this.bVF.abQ();
        }
    }

    public void ee(boolean z) {
        if (this.bVF != null) {
            if (z) {
                q(true, true);
            } else {
                q(true, false);
            }
        }
    }

    public void ef(boolean z) {
        if (this.bVF != null) {
            if (z) {
                q(false, true);
            } else {
                q(false, false);
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
        this.bVv.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.x xVar) {
        this.bVw.setOnAdapterItemClickListener(xVar);
    }

    public void setForumName(String str) {
        this.bVw.setForumName(str);
        this.mForumName = str;
    }

    public void cv(boolean z) {
        this.bVw.cv(z);
    }

    public void onDestroy() {
        if (this.bVJ != null) {
            this.bVJ.destroy();
        }
        this.bVw.onDestory();
        this.bVv.setOnSrollToBottomListener(null);
        this.bVv.setScrollable(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bVM);
        if (this.bNy != null) {
            this.bNy.onDestroy();
        }
        this.bVI.clear();
        if (this.bVE != null) {
            this.bVE.abU();
        }
        if (this.bOo != null) {
            this.bOo.setBackgroundDrawable(null);
        }
    }

    public boolean aaG() {
        if (this.bVE != null) {
            return this.bVE.aaG();
        }
        return false;
    }

    public boolean aav() {
        return this.bVl;
    }

    public void My() {
        this.bVv.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setCenterTextTitle("");
            return;
        }
        this.mNavigationBar.setCenterTextTitle(String.valueOf(UtilHelper.getFixedBarText(str, 7, true, false)) + this.bVm.getActivity().getString(w.l.forum));
        com.baidu.tbadk.core.r.oN().cd(str);
    }

    public void aaH() {
        if (this.bVw != null) {
            this.bVw.notifyDataSetChanged();
        }
    }

    public void VC() {
        if (this.bVw instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.bVw).VC();
        }
    }

    private void aaI() {
        if (this.bVx == null) {
            String[] strArr = {this.bVm.getPageContext().getPageActivity().getString(w.l.take_photo), this.bVm.getPageContext().getPageActivity().getString(w.l.album)};
            this.bVx = new com.baidu.tbadk.core.dialog.c(this.bVm.getPageContext().getPageActivity());
            this.bVx.cC(this.bVm.getPageContext().getPageActivity().getString(w.l.operation));
            this.bVx.a(strArr, new az(this));
            this.bVx.d(this.bVm.getPageContext());
        }
    }

    public void aaJ() {
        aaI();
        if (this.bVx != null) {
            this.bVx.tf();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tbadk.core.util.x.r(arrayList)) {
            bb bbVar = new bb();
            arrayList = new ArrayList<>();
            arrayList.add(bbVar);
            if (this.bVm != null && this.bVm.ZY() != null && this.bVm.ZY().acS() == 0) {
                bbVar.in(this.bVm.ZY().ada());
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
                if (vVar instanceof com.baidu.tbadk.core.data.bl) {
                    ((com.baidu.tbadk.core.data.bl) vVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.bVw.b(arrayList, nVar);
        if (this.bVJ != null) {
            this.bVJ.a(this.bVc, this.bVd, this.bVC, true);
        }
    }

    public BdTypeListView getListView() {
        return this.bVv;
    }

    public void aaK() {
        this.bVw.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bVm.getPageContext(), 1);
        aVar.a(this.bVv);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.bVm.getForumName());
        hashMap.put("forum_id", this.bVm.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.bVE != null) {
            this.bVE.abV();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.bVE != null) {
            this.bVE.abW();
        }
    }

    public void release() {
        if (this.byr != null && this.byu != null) {
            this.byr.b(this.byu);
        }
    }

    public ImageView aaL() {
        return this.bVq;
    }

    public ImageView aaM() {
        return this.bVp;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bVm, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bVm.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        com.baidu.tbadk.core.util.aq.b(this.bVp, w.g.icon_search_bg_s, w.g.icon_search_bg);
        com.baidu.tbadk.core.util.aq.b(this.bVq, w.g.btn_more_selector_s, w.g.btn_more_selector);
        if (this.bVH != null) {
            this.bVH.invalidate();
        }
        if (this.bVw != null) {
            this.bVw.abG();
            this.bVw.notifyDataSetChanged();
        }
        this.bVm.xw().getLayoutMode().ah(i == 1);
        this.bVm.xw().getLayoutMode().t(this.bVn);
        if (this.bVn != null) {
            com.baidu.tbadk.core.util.aq.e(this.bVn, w.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bVm.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cN(w.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aq.e(this.bVz, w.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aq.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        }
        if (this.byr != null) {
            this.byr.onChangeSkinType(this.bVm.getPageContext(), i);
        }
        if (this.aZY != null) {
            this.aZY.dj(i);
        }
        ei(false);
        if (this.bVF != null) {
            this.bVF.onChangeSkinType(i);
        }
        if (this.bVE != null) {
            this.bVE.onChangeSkinType(i);
        }
        if (this.bOo != null) {
            UtilHelper.setStatusBarBackground(this.bOo, i);
        }
        if (this.bVJ != null) {
            this.bVJ.a(this.bVc, this.bVd, this.bVC, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
    }

    public void startPullRefresh() {
        this.bVv.startPullRefresh();
    }

    public void aaN() {
        this.bVv.completePullRefreshPostDelayed(2000L);
    }

    public boolean aaO() {
        return this.bVr != null && this.bVu.getVisibility() == 0;
    }

    public void aaP() {
        if (this.bVr != null) {
            this.bVs.setVisibility(0);
            this.bVu.setVisibility(8);
            this.bVt.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bVM, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bt btVar) {
        if (this.bVr == null) {
            this.bVr = (ViewStub) this.bVm.mRootView.findViewById(w.h.yule_game_egg_view_stub);
            this.bVr.setVisibility(0);
            this.bVs = (FrameLayout) this.bVm.mRootView.findViewById(w.h.game_activity_egg_layout);
            this.bVt = (TbImageView) this.bVm.mRootView.findViewById(w.h.game_activity_egg);
            this.bVu = (TbImageView) this.bVm.mRootView.findViewById(w.h.game_activity_egg_s);
            this.bVt.setPageId(this.bVm.getUniqueId());
            this.bVu.setPageId(this.bVm.getUniqueId());
            this.bVt.setDefaultBgResource(w.e.common_color_10022);
            this.bVt.setDefaultResource(0);
            this.bVu.setDefaultBgResource(w.e.common_color_10022);
            this.bVu.setDefaultResource(0);
            this.bVs.setOnClickListener(this.bVy);
        }
        this.bVs.setVisibility(0);
        String sS = btVar.sS();
        String sT = btVar.sT();
        this.bVt.c(sS, 10, false);
        this.bVu.c(sT, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bVM, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void aaQ() {
        if (this.bVr != null) {
            this.bVs.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al aaR() {
        return this.bVw;
    }

    public ViewGroup TK() {
        return this.bVn;
    }

    public View aaS() {
        return this.bVA;
    }

    public void aaT() {
        if (com.baidu.tbadk.j.aa.FE().FF()) {
            int lastVisiblePosition = this.bVv.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bVv.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof bd)) {
                    bd bdVar = (bd) childAt.getTag();
                    if (bdVar.bWb != null) {
                        com.baidu.tbadk.j.u perfLog = bdVar.bWb.getPerfLog();
                        perfLog.fb(1000);
                        perfLog.aGo = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            bdVar.bWb.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        bdVar.bWb.vT();
                    }
                    if (bdVar.bVZ != null && (bdVar.bVZ instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = bdVar.bVZ;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.j.u perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fb(1000);
                                perfLog2.aGo = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.vT();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar aaU() {
        return this.mNavigationBar;
    }

    public void TW() {
        this.mHasMore = true;
        this.bVv.setNextPage(this.aZY);
        if (this.bVB > 0) {
            this.aZY.dk(this.bVB);
        }
        this.aZY.wl();
    }

    public void TY() {
        this.mHasMore = false;
        this.bVv.setNextPage(this.aZY);
        if (this.bVB > 0) {
            this.aZY.dk(this.bVB);
        }
        this.aZY.wm();
        this.aZY.setText(this.bVm.getResources().getString(w.l.list_no_more));
    }

    public void VD() {
        this.mHasMore = false;
        this.bVv.setNextPage(null);
    }

    public boolean Vs() {
        return this.aZY.getView().getParent() != null && this.mHasMore;
    }

    public void ij(int i) {
        this.bVB = i;
    }

    public void ik(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.bNy == null) {
                    this.bNy = new CommonTipView(this.bVm.getActivity());
                }
                this.bNy.setText(w.l.frs_login_tip);
                this.bNy.a((FrameLayout) aaS(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eg(boolean z) {
        if (this.bVJ != null) {
            if (z) {
                this.bVJ.gM(false);
                this.bVJ.akv();
                return;
            }
            this.bVJ.gM(true);
            this.bVJ.a(this.bVc, this.bVd, this.bVC, true);
        }
    }

    public void ai(int i, int i2) {
        if (this.bVJ != null) {
            this.bVJ.a(i, i2, this.bVC, 1);
        }
    }

    public void aj(int i, int i2) {
        this.bVc = i;
        this.bVd = i2;
    }

    public void eh(boolean z) {
        this.bVC = z;
    }

    public void aaV() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
        }
    }

    private void aaW() {
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

    private void ei(boolean z) {
        boolean i = com.baidu.tieba.frs.f.u.i(this.bVm.aau());
        boolean h = com.baidu.tieba.frs.f.u.h(this.bVm.aau());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.boq) {
                    this.boq = true;
                    com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.boq) {
                this.boq = false;
                com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.icon_return_bg_s, w.g.icon_return_bg);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        aaW();
    }

    public void ej(boolean z) {
        if (!this.bVv.bhm()) {
            this.bVv.setStarForum(true);
            if (z && !this.bVm.aaw()) {
                this.mPullView = new com.baidu.tbadk.core.view.ah(this.bVm.getPageContext());
                this.mPullView.setTag(this.bVm.getUniqueId());
                this.bVv.setPullRefresh(this.mPullView);
            }
        }
    }

    public void il(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void im(int i) {
        if (this.bVv != null && this.bVv.getChildCount() >= 0) {
            if (this.bVv.getFirstVisiblePosition() > 8) {
                this.bVv.setSelection(8);
            }
            this.bVv.smoothScrollToPosition(i);
        }
    }
}
