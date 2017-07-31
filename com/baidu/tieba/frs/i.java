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
    private NoNetworkView bES;
    private CommonTipView bZO;
    private PbListView ber;
    private View ckA;
    private View ckB;
    private FrameLayout ckC;
    private View ckF;
    private com.baidu.tieba.frs.entelechy.b.e ckG;
    private com.baidu.tieba.frs.entelechy.b.c ckH;
    private GifView ckI;
    private TbImageView ckJ;
    private HashSet<String> ckK;
    private com.baidu.tieba.play.l ckL;
    private ObservedChangeLinearLayout ckM;
    private com.baidu.tieba.frs.entelechy.b.a ckN;
    private f ckn;
    private View ckp;
    private ImageView ckq;
    private ImageView ckr;
    private ViewStub cks;
    private q ckx;
    private View.OnClickListener ckz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.l mPullView;
    private boolean ckm = false;
    private NoPressedRelativeLayout cko = null;
    private FrameLayout ckt = null;
    private TbImageView cku = null;
    private TbImageView ckv = null;
    private BdExpandListView ckw = null;
    private com.baidu.tbadk.core.dialog.b cky = null;
    private NoNetworkView.a bEV = null;
    private boolean mHasMore = true;
    private int ckD = 0;
    private boolean ckE = false;
    private int cke = 0;
    private int bcZ = 0;
    private View caD = null;
    private boolean bxz = true;
    private Runnable ckO = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cks != null) {
                i.this.ckt.setVisibility(0);
                i.this.ckv.setVisibility(0);
                i.this.cku.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout afw() {
        return this.ckM;
    }

    public View afx() {
        return this.caD;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.ckn = null;
        this.ckz = null;
        this.ckn = fVar;
        this.ckz = onClickListener;
        a(aVar, z);
        this.ckK = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.ckN = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.l(this.ckn.getPageContext());
        }
        this.mPullView.setTag(this.ckn.getUniqueId());
        if (this.cko == null) {
            this.cko = (NoPressedRelativeLayout) this.ckn.mRootView.findViewById(d.h.frs);
        }
        com.baidu.tbadk.core.util.ai.k(this.cko, d.e.cp_bg_line_d);
        if (this.ckB == null) {
            this.ckB = this.ckn.mRootView.findViewById(d.h.frs_list_content);
        }
        if (this.ckC == null) {
            this.ckC = (FrameLayout) this.ckn.mRootView.findViewById(d.h.tip_container);
        }
        if (this.ckM == null) {
            this.ckM = (ObservedChangeLinearLayout) this.ckn.mRootView.findViewById(d.h.navigation_bar_wrapperLayout);
            this.ckM.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.ckn.mRootView.findViewById(d.h.view_navigation_bar);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.ckn.aft()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.ckA == null) {
            this.ckA = this.ckn.mRootView.findViewById(d.h.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b ags = aVar.ags();
            if (ags != null) {
                ags.ak(this.ckA);
            }
        }
        if (this.ckp == null) {
            this.ckp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.ckp.setOnClickListener(this.ckz);
            this.mBackImageView = (ImageView) this.ckp.findViewById(d.h.widget_navi_back_button);
        }
        if (this.ckq == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.ckn.getPageContext().getPageActivity(), d.f.ds24), 0);
            this.ckq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.ckq.setLayoutParams(layoutParams);
            this.ckq.setOnClickListener(this.ckz);
            this.ckr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.ckr.setLayoutParams(layoutParams);
            this.ckr.setOnClickListener(this.ckz);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.ckn.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.ckw == null) {
            this.ckw = (BdExpandListView) this.ckn.mRootView.findViewById(d.h.frs_lv_thread);
        }
        this.ckw.setScrollable(this.ckn);
        this.ckw.setFadingEdgeLength(0);
        this.ckw.setOverScrollMode(2);
        this.cko.setBottomOrderView(this.ckw);
        this.ckw.setOnTouchListener(this.ckn.aMS);
        this.ckw.setDivider(null);
        this.ckw.setPullRefresh(this.mPullView);
        if (z && this.ckF == null) {
            this.ckF = BdListViewHelper.a(this.ckn.getActivity(), this.ckw, BdListViewHelper.HeadType.DEFAULT);
        }
        this.ckw.setDividerHeight(0);
        this.ckw.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.ckL != null) {
                    i.this.ckL.aQ(view);
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
        if (this.ber == null) {
            this.ber = new PbListView(this.ckn.getPageContext().getPageActivity());
            this.ber.lk();
        }
        this.ber.m10do(d.e.cp_bg_line_c);
        this.ckw.setOnSrollToBottomListener(this.ckn);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.q(new q.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.q.a
            public void afZ() {
                i.this.ckn.afp();
            }

            @Override // com.baidu.tieba.tbadkCore.q.a
            public void aga() {
                if (i.this.ckw != null) {
                    i.this.ckw.setSelection(0);
                    if (i.this.ckL != null) {
                        i.this.ckL.a(i.this.cke, i.this.bcZ, false, true);
                    }
                }
            }
        }));
        boolean vS = com.baidu.tbadk.core.util.am.vQ().vS();
        if (this.ckx == null) {
            this.ckx = aVar.a(this.ckn, this.ckw, vS);
        }
        ck(false);
        if (!z) {
            if (this.bES == null) {
                this.bES = new NoNetworkView(this.ckn.getActivity());
                this.bES.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.ckM.addView(this.bES);
            }
            if (com.baidu.adp.lib.util.i.hf()) {
                this.bES.setVisibility(8);
            } else {
                this.bES.setVisibility(0);
            }
            this.bES.onChangeSkinType(this.ckn.yg(), TbadkCoreApplication.getInst().getSkinType());
        }
        afE();
        if (this.ckG == null) {
            this.ckG = aVar.c(this.ckn, this.cko);
        }
        if (this.ckH == null) {
            this.ckH = aVar.b(this.ckn, this.cko);
        }
        if (this.caD == null) {
            this.caD = this.ckn.mRootView.findViewById(d.h.statebar_view);
        }
        if (this.ckL == null) {
            this.ckL = new com.baidu.tieba.play.l(this.ckn.getPageContext(), this.ckw);
        }
        this.ckL.setUniqueId(this.ckn.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.ckF != null && this.ckF.getLayoutParams() != null) {
            this.ckF.getLayoutParams().height = i;
            this.ckF.setLayoutParams(this.ckF.getLayoutParams());
        }
    }

    public View afy() {
        return this.ckF;
    }

    public com.baidu.tieba.play.l afz() {
        return this.ckL;
    }

    public com.baidu.tieba.frs.entelechy.b.c afA() {
        return this.ckH;
    }

    public void eF(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.u.v(this.ckn.afr().brk());
        if (this.ckG != null) {
            this.ckG.eF(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e afB() {
        return this.ckG;
    }

    public void s(boolean z, boolean z2) {
        if (this.ckH != null) {
            this.ckH.s(z, z2);
        }
        if (this.ckn.isAdded()) {
            if (z) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB);
                customMessage.setTag(this.ckn.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, Boolean.valueOf(z2));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            CustomMessage customMessage2 = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB);
            customMessage2.setTag(this.ckn.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, Boolean.valueOf(z2));
            customResponsedMessage2.setOrginalMessage(customMessage2);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
        }
    }

    public void afC() {
        if (this.ckH != null) {
            this.ckH.s(false, false);
        }
        this.ckq.setVisibility(8);
        this.ckr.setVisibility(8);
        eF(false);
        this.ckw.setVisibility(8);
    }

    public void afD() {
        if (this.ckH != null) {
            this.ckH.s(true, false);
        }
        this.ckq.setVisibility(0);
        this.ckr.setVisibility(0);
        eF(true);
        this.ckw.setVisibility(0);
    }

    public void eG(boolean z) {
        if (this.ckH != null) {
            this.ckH.eQ(z);
        }
    }

    private void afE() {
        if (this.ckI == null) {
            this.ckI = (GifView) this.ckn.mRootView.findViewById(d.h.gif_real_time);
            this.ckJ = (TbImageView) this.ckn.mRootView.findViewById(d.h.tbimg_real_time);
            this.ckJ.setPageId(this.ckn.getUniqueId());
            this.ckI.setLayerType(1, null);
            this.ckJ.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View afF() {
        return this.ckp;
    }

    public void c(NoNetworkView.a aVar) {
        this.bEV = aVar;
        if (this.bES != null) {
            this.bES.a(this.bEV);
        }
    }

    public void ck(boolean z) {
        this.ckm = z;
        if (z) {
            if (this.ckH != null) {
                this.ckH.agX();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.ckw.getAdapter()).notifyDataSetChanged();
        if (this.ckH != null) {
            this.ckH.agY();
        }
    }

    public void eH(boolean z) {
        if (this.ckH != null) {
            if (z) {
                s(true, true);
            } else {
                s(true, false);
            }
        }
    }

    public void eI(boolean z) {
        if (this.ckH != null) {
            if (z) {
                s(false, true);
            } else {
                s(false, false);
            }
        }
    }

    public void a(BdExpandListView.a aVar) {
        if (this.ckw instanceof BdExpandListView) {
            this.ckw.setPersonListRefreshListener(aVar);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ckw.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.ckx.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.ckx.setForumName(str);
        this.mForumName = str;
    }

    public void cH(boolean z) {
        this.ckx.cH(z);
    }

    public void onDestroy() {
        if (this.ckL != null) {
            this.ckL.destroy();
        }
        this.ckx.onDestory();
        this.ckw.setOnSrollToBottomListener(null);
        this.ckw.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.ckO);
        if (this.bZO != null) {
            this.bZO.onDestroy();
        }
        this.ckK.clear();
        if (this.ckG != null) {
            this.ckG.ahc();
        }
        if (this.caD != null) {
            this.caD.setBackgroundDrawable(null);
        }
    }

    public boolean afG() {
        if (this.ckG != null) {
            return this.ckG.afG();
        }
        return false;
    }

    public boolean afs() {
        return this.ckm;
    }

    public void Nr() {
        this.ckw.setVisibility(0);
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
            com.baidu.tbadk.core.h.oX().cu(str);
        }
    }

    public void afH() {
        if (this.ckx != null) {
            this.ckx.notifyDataSetChanged();
        }
    }

    public void XG() {
        if (this.ckx instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.ckx).XG();
        }
    }

    private void afI() {
        if (this.cky == null) {
            String[] strArr = {this.ckn.getPageContext().getPageActivity().getString(d.l.take_photo), this.ckn.getPageContext().getPageActivity().getString(d.l.album)};
            this.cky = new com.baidu.tbadk.core.dialog.b(this.ckn.getPageContext().getPageActivity());
            this.cky.cU(this.ckn.getPageContext().getPageActivity().getString(d.l.operation));
            this.cky.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.ckn.SE();
                    } else if (i == 1) {
                        com.baidu.tbadk.core.util.ah.q(i.this.ckn.getPageContext().getPageActivity());
                    }
                }
            });
            this.cky.d(this.ckn.getPageContext());
        }
    }

    public void afJ() {
        afI();
        if (this.cky != null) {
            this.cky.tu();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tbadk.core.util.u.v(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.ckn != null && this.ckn.aeU() != null && this.ckn.aeU().aiw() == 0) {
                kVar.iI(this.ckn.aeU().aiE());
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
        this.ckx.b(arrayList, iVar);
        if (this.ckL != null) {
            this.ckL.a(this.cke, this.bcZ, this.ckE, true);
        }
    }

    public BdTypeListView getListView() {
        return this.ckw;
    }

    public void afK() {
        this.ckx.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.ckn.getPageContext(), 1);
        aVar.a(this.ckw);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.ckn.getForumName());
        hashMap.put("forum_id", this.ckn.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.ckG != null) {
            this.ckG.ahd();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.ckG != null) {
            this.ckG.ahe();
        }
    }

    public void release() {
        if (this.bES != null && this.bEV != null) {
            this.bES.b(this.bEV);
        }
    }

    public ImageView afL() {
        return this.ckr;
    }

    public ImageView afM() {
        return this.ckq;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.ckn, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.ckn.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.ckJ != null) {
            this.ckJ.invalidate();
        }
        if (this.ckx != null) {
            this.ckx.agO();
            this.ckx.notifyDataSetChanged();
        }
        this.ckn.yg().getLayoutMode().ah(i == 1);
        this.ckn.yg().getLayoutMode().t(this.cko);
        if (this.cko != null) {
            com.baidu.tbadk.core.util.ai.e(this.cko, d.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ckn.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ai.cT(d.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.ai.e(this.ckA, d.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.bES != null) {
            this.bES.onChangeSkinType(this.ckn.getPageContext(), i);
        }
        if (this.ber != null) {
            this.ber.dp(i);
        }
        eL(false);
        if (this.ckH != null) {
            this.ckH.onChangeSkinType(i);
        }
        if (this.ckG != null) {
            this.ckG.onChangeSkinType(i);
        }
        if (this.caD != null) {
            UtilHelper.setStatusBarBackground(this.caD, i);
        }
        if (this.ckL != null) {
            this.ckL.a(this.cke, this.bcZ, this.ckE, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
    }

    public void startPullRefresh() {
        this.ckw.startPullRefresh();
    }

    public void afN() {
        this.ckw.completePullRefreshPostDelayed(2000L);
    }

    public boolean afO() {
        return this.cks != null && this.ckv.getVisibility() == 0;
    }

    public void afP() {
        if (this.cks != null) {
            this.ckt.setVisibility(0);
            this.ckv.setVisibility(8);
            this.cku.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.ckO, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bs bsVar) {
        if (this.cks == null) {
            this.cks = (ViewStub) this.ckn.mRootView.findViewById(d.h.yule_game_egg_view_stub);
            this.cks.setVisibility(0);
            this.ckt = (FrameLayout) this.ckn.mRootView.findViewById(d.h.game_activity_egg_layout);
            this.cku = (TbImageView) this.ckn.mRootView.findViewById(d.h.game_activity_egg);
            this.ckv = (TbImageView) this.ckn.mRootView.findViewById(d.h.game_activity_egg_s);
            this.cku.setPageId(this.ckn.getUniqueId());
            this.ckv.setPageId(this.ckn.getUniqueId());
            this.cku.setDefaultBgResource(d.e.common_color_10022);
            this.cku.setDefaultResource(0);
            this.ckv.setDefaultBgResource(d.e.common_color_10022);
            this.ckv.setDefaultResource(0);
            this.ckt.setOnClickListener(this.ckz);
        }
        this.ckt.setVisibility(0);
        String th = bsVar.th();
        String ti = bsVar.ti();
        this.cku.c(th, 10, false);
        this.ckv.c(ti, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.ckO, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void afQ() {
        if (this.cks != null) {
            this.ckt.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q afR() {
        return this.ckx;
    }

    public ViewGroup VR() {
        return this.cko;
    }

    public void afS() {
        if (r.Gz().GA()) {
            int lastVisiblePosition = this.ckw.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.ckw.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.cld != null) {
                        com.baidu.tbadk.l.l perfLog = mVar.cld.getPerfLog();
                        perfLog.fi(1000);
                        perfLog.aJZ = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.cld.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.cld.wA();
                    }
                    if (mVar.clb != null && (mVar.clb instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.clb;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fi(1000);
                                perfLog2.aJZ = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wA();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar afq() {
        return this.mNavigationBar;
    }

    public void VX() {
        this.mHasMore = true;
        this.ckw.setNextPage(this.ber);
        if (this.ckD > 0) {
            this.ber.dq(this.ckD);
        }
        this.ber.wW();
    }

    public void VZ() {
        this.mHasMore = false;
        this.ckw.setNextPage(this.ber);
        if (this.ckD > 0) {
            this.ber.dq(this.ckD);
        }
        this.ber.wX();
        this.ber.setText(this.ckn.getResources().getString(d.l.list_no_more));
    }

    public void XH() {
        this.mHasMore = false;
        this.ckw.setNextPage(null);
    }

    public boolean Xw() {
        return this.ber.getView().getParent() != null && this.mHasMore;
    }

    public void iE(int i) {
        this.ckD = i;
    }

    public void iF(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.bZO == null) {
                    this.bZO = new CommonTipView(this.ckn.getActivity());
                }
                this.bZO.setText(d.l.frs_login_tip);
                this.bZO.a(this.ckC, TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eJ(boolean z) {
        if (this.ckL != null) {
            if (z) {
                this.ckL.hu(false);
                this.ckL.apY();
                return;
            }
            this.ckL.hu(true);
            this.ckL.a(this.cke, this.bcZ, this.ckE, true);
        }
    }

    public void ao(int i, int i2) {
        if (this.ckL != null) {
            this.ckL.a(i, i2, this.ckE, 1);
        }
    }

    public void ap(int i, int i2) {
        this.cke = i;
        this.bcZ = i2;
    }

    public void eK(boolean z) {
        this.ckE = z;
    }

    public void afT() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
        }
    }

    private void afU() {
        float f;
        if (this.mNavigationBar != null) {
            float alpha = this.mNavigationBar.getBarBgView() != null ? this.mNavigationBar.getBarBgView().getAlpha() : 0.0f;
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(alpha);
            }
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.ckq != null) {
                    this.ckq.setAlpha(f);
                }
                if (this.ckr != null) {
                    this.ckr.setAlpha(f);
                }
            }
        }
    }

    private void eL(boolean z) {
        com.baidu.tieba.frs.g.f.i(this.ckn.afr());
        com.baidu.tieba.frs.g.f.h(this.ckn.afr());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bxz) {
                    this.bxz = true;
                    com.baidu.tbadk.core.util.ai.b(this.mBackImageView, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.ai.b(this.ckq, d.g.icon_sml_search_bg, d.g.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.ai.b(this.ckr, d.g.btn_sml_more_bg, d.g.btn_sml_more_bg);
                }
            } else if (!z || this.bxz) {
                this.bxz = false;
                com.baidu.tbadk.core.util.ai.b(this.mBackImageView, d.g.icon_return_bg_s, d.g.icon_return_bg);
                com.baidu.tbadk.core.util.ai.b(this.ckq, d.g.icon_search_bg_s, d.g.icon_search_bg);
                com.baidu.tbadk.core.util.ai.b(this.ckr, d.g.btn_more_selector_s, d.g.btn_more_selector);
            }
        }
        afU();
    }

    public void afV() {
        this.ckw.setStarForum(false);
        this.ckw.setPullRefresh(null);
    }

    public void iG(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void iH(int i) {
        if (this.ckw != null && this.ckw.getChildCount() >= 0) {
            if (this.ckw.getFirstVisiblePosition() > 8) {
                this.ckw.setSelection(8);
            }
            this.ckw.smoothScrollToPosition(i);
        }
    }

    public void afW() {
        eL(true);
    }

    public void afX() {
        a(this.ckN, this.ckn.aft());
        if (this.ckx != null) {
            this.ckx.reInit();
        }
    }

    public FrameLayout afY() {
        return this.ckC;
    }
}
