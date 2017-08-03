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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bs;
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
    private NoNetworkView bDI;
    private CommonTipView bYI;
    private PbListView bdh;
    private GifView cjA;
    private TbImageView cjB;
    private HashSet<String> cjC;
    private com.baidu.tieba.play.l cjD;
    private ObservedChangeLinearLayout cjE;
    private com.baidu.tieba.frs.entelechy.b.a cjF;
    private f cjg;
    private View cji;
    private ImageView cjj;
    private ImageView cjk;
    private ViewStub cjl;
    private q cjq;
    private View.OnClickListener cjs;
    private View cjt;
    private View cju;
    private View cjx;
    private com.baidu.tieba.frs.entelechy.b.e cjy;
    private com.baidu.tieba.frs.entelechy.b.c cjz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.l mPullView;
    private boolean cjf = false;
    private NoPressedRelativeLayout cjh = null;
    private FrameLayout cjm = null;
    private TbImageView cjn = null;
    private TbImageView cjo = null;
    private BdExpandListView cjp = null;
    private com.baidu.tbadk.core.dialog.b cjr = null;
    private NoNetworkView.a bDL = null;
    private boolean mHasMore = true;
    private int cjv = 0;
    private boolean cjw = false;
    private int ciX = 0;
    private int bbP = 0;
    private View bZx = null;
    private boolean bwp = true;
    private Runnable cjG = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cjl != null) {
                i.this.cjm.setVisibility(0);
                i.this.cjo.setVisibility(0);
                i.this.cjn.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout afr() {
        return this.cjE;
    }

    public View afs() {
        return this.bZx;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.cjg = null;
        this.cjs = null;
        this.cjg = fVar;
        this.cjs = onClickListener;
        a(aVar, z);
        this.cjC = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.cjF = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.l(this.cjg.getPageContext());
        }
        this.mPullView.setTag(this.cjg.getUniqueId());
        if (this.cjh == null) {
            this.cjh = (NoPressedRelativeLayout) this.cjg.mRootView.findViewById(d.h.frs);
        }
        com.baidu.tbadk.core.util.ai.k(this.cjh, d.e.cp_bg_line_d);
        if (this.cju == null) {
            this.cju = this.cjg.mRootView.findViewById(d.h.frs_list_content);
        }
        if (this.cjE == null) {
            this.cjE = (ObservedChangeLinearLayout) this.cjg.mRootView.findViewById(d.h.navigation_bar_wrapperLayout);
            this.cjE.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cjg.mRootView.findViewById(d.h.view_navigation_bar);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cjg.afo()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cjt == null) {
            this.cjt = this.cjg.mRootView.findViewById(d.h.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b agl = aVar.agl();
            if (agl != null) {
                agl.ak(this.cjt);
            }
        }
        if (this.cji == null) {
            this.cji = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cji.setOnClickListener(this.cjs);
            this.mBackImageView = (ImageView) this.cji.findViewById(d.h.widget_navi_back_button);
        }
        if (this.cjj == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.cjg.getPageContext().getPageActivity(), d.f.ds24), 0);
            this.cjj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.cjj.setLayoutParams(layoutParams);
            this.cjj.setOnClickListener(this.cjs);
            this.cjk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.cjk.setLayoutParams(layoutParams);
            this.cjk.setOnClickListener(this.cjs);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cjg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.cjp == null) {
            this.cjp = (BdExpandListView) this.cjg.mRootView.findViewById(d.h.frs_lv_thread);
        }
        this.cjp.setScrollable(this.cjg);
        this.cjp.setFadingEdgeLength(0);
        this.cjp.setOverScrollMode(2);
        this.cjh.setBottomOrderView(this.cjp);
        this.cjp.setOnTouchListener(this.cjg.aLD);
        this.cjp.setDivider(null);
        this.cjp.setPullRefresh(this.mPullView);
        if (z && this.cjx == null) {
            this.cjx = BdListViewHelper.a(this.cjg.getActivity(), this.cjp, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cjp.setDividerHeight(0);
        this.cjp.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.cjD != null) {
                    i.this.cjD.aQ(view);
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
        if (this.bdh == null) {
            this.bdh = new PbListView(this.cjg.getPageContext().getPageActivity());
            this.bdh.la();
        }
        this.bdh.dm(d.e.cp_bg_line_c);
        this.cjp.setOnSrollToBottomListener(this.cjg);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.q(new q.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.q.a
            public void afS() {
                i.this.cjg.afk();
            }

            @Override // com.baidu.tieba.tbadkCore.q.a
            public void afT() {
                if (i.this.cjp != null) {
                    i.this.cjp.setSelection(0);
                    if (i.this.cjD != null) {
                        i.this.cjD.a(i.this.ciX, i.this.bbP, false, true);
                    }
                }
            }
        }));
        boolean vI = com.baidu.tbadk.core.util.am.vG().vI();
        if (this.cjq == null) {
            this.cjq = aVar.a(this.cjg, this.cjp, vI);
        }
        ck(false);
        if (!z) {
            if (this.bDI == null) {
                this.bDI = new NoNetworkView(this.cjg.getActivity());
                this.bDI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.cjE.addView(this.bDI);
            }
            if (com.baidu.adp.lib.util.i.gV()) {
                this.bDI.setVisibility(8);
            } else {
                this.bDI.setVisibility(0);
            }
            this.bDI.onChangeSkinType(this.cjg.xY(), TbadkCoreApplication.getInst().getSkinType());
        }
        afz();
        if (this.cjy == null) {
            this.cjy = aVar.c(this.cjg, this.cjh);
        }
        if (this.cjz == null) {
            this.cjz = aVar.b(this.cjg, this.cjh);
        }
        if (this.bZx == null) {
            this.bZx = this.cjg.mRootView.findViewById(d.h.statebar_view);
        }
        if (this.cjD == null) {
            this.cjD = new com.baidu.tieba.play.l(this.cjg.getPageContext(), this.cjp);
        }
        this.cjD.setUniqueId(this.cjg.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cjx != null && this.cjx.getLayoutParams() != null) {
            this.cjx.getLayoutParams().height = i;
            this.cjx.setLayoutParams(this.cjx.getLayoutParams());
        }
    }

    public View aft() {
        return this.cjx;
    }

    public com.baidu.tieba.play.l afu() {
        return this.cjD;
    }

    public com.baidu.tieba.frs.entelechy.b.c afv() {
        return this.cjz;
    }

    public void eF(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.u.v(this.cjg.afm().brd());
        if (this.cjy != null) {
            this.cjy.eF(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e afw() {
        return this.cjy;
    }

    public void s(boolean z, boolean z2) {
        if (this.cjz != null) {
            this.cjz.s(z, z2);
        }
        if (this.cjg.isAdded()) {
            if (z) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB);
                customMessage.setTag(this.cjg.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, Boolean.valueOf(z2));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            CustomMessage customMessage2 = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB);
            customMessage2.setTag(this.cjg.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, Boolean.valueOf(z2));
            customResponsedMessage2.setOrginalMessage(customMessage2);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
        }
    }

    public void afx() {
        if (this.cjz != null) {
            this.cjz.s(false, false);
        }
        this.cjj.setVisibility(8);
        this.cjk.setVisibility(8);
        eF(false);
        this.cjp.setVisibility(8);
    }

    public void afy() {
        if (this.cjz != null) {
            this.cjz.s(true, false);
        }
        this.cjj.setVisibility(0);
        this.cjk.setVisibility(0);
        eF(true);
        this.cjp.setVisibility(0);
    }

    public void eG(boolean z) {
        if (this.cjz != null) {
            this.cjz.eQ(z);
        }
    }

    private void afz() {
        if (this.cjA == null) {
            this.cjA = (GifView) this.cjg.mRootView.findViewById(d.h.gif_real_time);
            this.cjB = (TbImageView) this.cjg.mRootView.findViewById(d.h.tbimg_real_time);
            this.cjB.setPageId(this.cjg.getUniqueId());
            this.cjA.setLayerType(1, null);
            this.cjB.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View afA() {
        return this.cji;
    }

    public void c(NoNetworkView.a aVar) {
        this.bDL = aVar;
        if (this.bDI != null) {
            this.bDI.a(this.bDL);
        }
    }

    public void ck(boolean z) {
        this.cjf = z;
        if (z) {
            if (this.cjz != null) {
                this.cjz.agQ();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.cjp.getAdapter()).notifyDataSetChanged();
        if (this.cjz != null) {
            this.cjz.agR();
        }
    }

    public void eH(boolean z) {
        if (this.cjz != null) {
            if (z) {
                s(true, true);
            } else {
                s(true, false);
            }
        }
    }

    public void eI(boolean z) {
        if (this.cjz != null) {
            if (z) {
                s(false, true);
            } else {
                s(false, false);
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
        this.cjp.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.cjq.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.cjq.setForumName(str);
        this.mForumName = str;
    }

    public void cH(boolean z) {
        this.cjq.cH(z);
    }

    public void onDestroy() {
        if (this.cjD != null) {
            this.cjD.destroy();
        }
        this.cjq.onDestory();
        this.cjp.setOnSrollToBottomListener(null);
        this.cjp.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cjG);
        if (this.bYI != null) {
            this.bYI.onDestroy();
        }
        this.cjC.clear();
        if (this.cjy != null) {
            this.cjy.agV();
        }
        if (this.bZx != null) {
            this.bZx.setBackgroundDrawable(null);
        }
    }

    public boolean afB() {
        if (this.cjy != null) {
            return this.cjy.afB();
        }
        return false;
    }

    public boolean afn() {
        return this.cjf;
    }

    public void Nm() {
        this.cjp.setVisibility(0);
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
            com.baidu.tbadk.core.h.oN().co(str);
        }
    }

    public void afC() {
        if (this.cjq != null) {
            this.cjq.notifyDataSetChanged();
        }
    }

    public void XB() {
        if (this.cjq instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cjq).XB();
        }
    }

    private void afD() {
        if (this.cjr == null && this.cjg.getPageContext() != null) {
            String[] strArr = {this.cjg.getPageContext().getPageActivity().getString(d.l.take_photo), this.cjg.getPageContext().getPageActivity().getString(d.l.album)};
            this.cjr = new com.baidu.tbadk.core.dialog.b(this.cjg.getPageContext().getPageActivity());
            this.cjr.cO(this.cjg.getPageContext().getPageActivity().getString(d.l.operation));
            this.cjr.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.cjg.Sz();
                    } else if (i == 1 && i.this.cjg.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ah.q(i.this.cjg.getPageContext().getPageActivity());
                    }
                }
            });
            this.cjr.d(this.cjg.getPageContext());
        }
    }

    public void afE() {
        afD();
        if (this.cjr != null) {
            this.cjr.tk();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tbadk.core.util.u.v(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.cjg != null && this.cjg.aeP() != null && this.cjg.aeP().aik() == 0) {
                kVar.iI(this.cjg.aeP().ais());
            }
        }
        if (com.baidu.tbadk.core.util.u.u(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = arrayList.get(i2);
                if (fVar instanceof bl) {
                    ((bl) fVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.cjq.b(arrayList, iVar);
        if (this.cjD != null) {
            this.cjD.a(this.ciX, this.bbP, this.cjw, true);
        }
    }

    public BdTypeListView getListView() {
        return this.cjp;
    }

    public void afF() {
        this.cjq.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cjg.getPageContext(), 1);
        aVar.a(this.cjp);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cjg.getForumName());
        hashMap.put("forum_id", this.cjg.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.cjy != null) {
            this.cjy.agW();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.cjy != null) {
            this.cjy.agX();
        }
    }

    public void release() {
        if (this.bDI != null && this.bDL != null) {
            this.bDI.b(this.bDL);
        }
    }

    public ImageView afG() {
        return this.cjk;
    }

    public ImageView afH() {
        return this.cjj;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cjg, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cjg.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.cjB != null) {
            this.cjB.invalidate();
        }
        if (this.cjq != null) {
            this.cjq.agH();
            this.cjq.notifyDataSetChanged();
        }
        this.cjg.xY().getLayoutMode().ah(i == 1);
        this.cjg.xY().getLayoutMode().t(this.cjh);
        if (this.cjh != null) {
            com.baidu.tbadk.core.util.ai.e(this.cjh, d.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cjg.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ai.cR(d.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.ai.e(this.cjt, d.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.bDI != null) {
            this.bDI.onChangeSkinType(this.cjg.getPageContext(), i);
        }
        if (this.bdh != null) {
            this.bdh.dn(i);
        }
        eL(false);
        if (this.cjz != null) {
            this.cjz.onChangeSkinType(i);
        }
        if (this.cjy != null) {
            this.cjy.onChangeSkinType(i);
        }
        if (this.bZx != null) {
            UtilHelper.setStatusBarBackground(this.bZx, i);
        }
        if (this.cjD != null) {
            this.cjD.a(this.ciX, this.bbP, this.cjw, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dn(i);
        }
    }

    public void startPullRefresh() {
        this.cjp.startPullRefresh();
    }

    public void afI() {
        this.cjp.completePullRefreshPostDelayed(2000L);
    }

    public boolean afJ() {
        return this.cjl != null && this.cjo.getVisibility() == 0;
    }

    public void afK() {
        if (this.cjl != null) {
            this.cjm.setVisibility(0);
            this.cjo.setVisibility(8);
            this.cjn.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.cjG, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bs bsVar) {
        if (this.cjl == null) {
            this.cjl = (ViewStub) this.cjg.mRootView.findViewById(d.h.yule_game_egg_view_stub);
            this.cjl.setVisibility(0);
            this.cjm = (FrameLayout) this.cjg.mRootView.findViewById(d.h.game_activity_egg_layout);
            this.cjn = (TbImageView) this.cjg.mRootView.findViewById(d.h.game_activity_egg);
            this.cjo = (TbImageView) this.cjg.mRootView.findViewById(d.h.game_activity_egg_s);
            this.cjn.setPageId(this.cjg.getUniqueId());
            this.cjo.setPageId(this.cjg.getUniqueId());
            this.cjn.setDefaultBgResource(d.e.common_color_10022);
            this.cjn.setDefaultResource(0);
            this.cjo.setDefaultBgResource(d.e.common_color_10022);
            this.cjo.setDefaultResource(0);
            this.cjm.setOnClickListener(this.cjs);
        }
        this.cjm.setVisibility(0);
        String sX = bsVar.sX();
        String sY = bsVar.sY();
        this.cjn.c(sX, 10, false);
        this.cjo.c(sY, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cjG, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void afL() {
        if (this.cjl != null) {
            this.cjm.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q afM() {
        return this.cjq;
    }

    public ViewGroup VM() {
        return this.cjh;
    }

    public View afN() {
        return this.cju;
    }

    public void afO() {
        if (r.Gr().Gs()) {
            int lastVisiblePosition = this.cjp.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cjp.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.cjV != null) {
                        com.baidu.tbadk.l.l perfLog = mVar.cjV.getPerfLog();
                        perfLog.fg(1000);
                        perfLog.aIK = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.cjV.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.cjV.wq();
                    }
                    if (mVar.cjT != null && (mVar.cjT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.cjT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fg(1000);
                                perfLog2.aIK = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wq();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar afl() {
        return this.mNavigationBar;
    }

    public void VS() {
        this.mHasMore = true;
        this.cjp.setNextPage(this.bdh);
        if (this.cjv > 0) {
            this.bdh.m10do(this.cjv);
        }
        this.bdh.wN();
    }

    public void VU() {
        this.mHasMore = false;
        this.cjp.setNextPage(this.bdh);
        if (this.cjv > 0) {
            this.bdh.m10do(this.cjv);
        }
        this.bdh.wO();
        this.bdh.setText(this.cjg.getResources().getString(d.l.list_no_more));
    }

    public void XC() {
        this.mHasMore = false;
        this.cjp.setNextPage(null);
    }

    public boolean Xr() {
        return this.bdh.getView().getParent() != null && this.mHasMore;
    }

    public void iE(int i) {
        this.cjv = i;
    }

    public void iF(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.bYI == null) {
                    this.bYI = new CommonTipView(this.cjg.getActivity());
                }
                this.bYI.setText(d.l.frs_login_tip);
                this.bYI.a((FrameLayout) afN(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eJ(boolean z) {
        if (this.cjD != null) {
            if (z) {
                this.cjD.hu(false);
                this.cjD.apM();
                return;
            }
            this.cjD.hu(true);
            this.cjD.a(this.ciX, this.bbP, this.cjw, true);
        }
    }

    public void an(int i, int i2) {
        if (this.cjD != null) {
            this.cjD.a(i, i2, this.cjw, 1);
        }
    }

    public void ao(int i, int i2) {
        this.ciX = i;
        this.bbP = i2;
    }

    public void eK(boolean z) {
        this.cjw = z;
    }

    public void afP() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.ai.j(this.mBackImageView, d.g.frs_star_navigation_bg);
        }
    }

    private void afQ() {
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

    private void eL(boolean z) {
        boolean i = com.baidu.tieba.frs.h.f.i(this.cjg.afm());
        boolean h = com.baidu.tieba.frs.h.f.h(this.cjg.afm());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bwp) {
                    this.bwp = true;
                    com.baidu.tbadk.core.util.ai.b(this.mBackImageView, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.ai.b(this.cjj, d.g.icon_sml_search_bg, d.g.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.ai.b(this.cjk, d.g.btn_sml_more_bg, d.g.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.ai.j(this.mBackImageView, d.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bwp) {
                this.bwp = false;
                com.baidu.tbadk.core.util.ai.b(this.mBackImageView, d.g.icon_return_bg_s, d.g.icon_return_bg);
                com.baidu.tbadk.core.util.ai.b(this.cjj, d.g.icon_search_bg_s, d.g.icon_search_bg);
                com.baidu.tbadk.core.util.ai.b(this.cjk, d.g.btn_more_selector_s, d.g.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        afQ();
    }

    public void eM(boolean z) {
        if (!this.cjp.brx()) {
            this.cjp.setStarForum(true);
            if (z && !this.cjg.afo()) {
                this.mPullView = new com.baidu.tbadk.core.view.l(this.cjg.getPageContext());
                this.mPullView.setTag(this.cjg.getUniqueId());
                this.cjp.setPullRefresh(this.mPullView);
            }
        }
    }

    public void iG(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void iH(int i) {
        if (this.cjp != null && this.cjp.getChildCount() >= 0) {
            if (this.cjp.getFirstVisiblePosition() > 8) {
                this.cjp.setSelection(8);
            }
            this.cjp.smoothScrollToPosition(i);
        }
    }

    public void afR() {
        a(this.cjF, this.cjg.afo());
        if (this.cjq != null) {
            this.cjq.reInit();
        }
    }
}
