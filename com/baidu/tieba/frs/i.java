package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
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
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class i {
    private PbListView bgN;
    private ImageView bnb;
    private NoNetworkView cks;
    private CommonTipView clO;
    private View czA;
    private com.baidu.tieba.frs.entelechy.b.e czB;
    private com.baidu.tieba.frs.entelechy.b.c czC;
    private GifView czD;
    private TbImageView czE;
    private HashSet<String> czF;
    private com.baidu.tieba.play.m czG;
    private ObservedChangeLinearLayout czI;
    private com.baidu.tieba.frs.entelechy.b.a czJ;
    private com.baidu.tieba.video.d czL;
    private boolean czN;
    private f czk;
    private View czm;
    private ImageView czn;
    private ViewStub czo;
    private t czt;
    private View.OnClickListener czv;
    private View czw;
    private View czx;
    private int czy;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean czj = false;
    private NoPressedRelativeLayout czl = null;
    private FrameLayout czp = null;
    private TbImageView czq = null;
    private TbImageView czr = null;
    private BdExpandListView czs = null;
    private com.baidu.tbadk.core.dialog.b czu = null;
    private NoNetworkView.a cwk = null;
    private boolean mHasMore = true;
    private boolean czz = false;
    private int czb = 0;
    private int bfu = 0;
    private View czH = null;
    private boolean bIB = true;
    private boolean czK = true;
    private Runnable czM = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.czo != null) {
                i.this.czp.setVisibility(0);
                i.this.czr.setVisibility(0);
                i.this.czq.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout ajG() {
        return this.czI;
    }

    public View ajH() {
        return this.czH;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.czk = null;
        this.czv = null;
        this.czy = 0;
        this.czk = fVar;
        this.czv = onClickListener;
        a(aVar, z);
        this.czF = new HashSet<>();
        this.czy = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.czJ = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.czk.getPageContext());
        }
        this.mPullView.setTag(this.czk.getUniqueId());
        if (this.czl == null) {
            this.czl = (NoPressedRelativeLayout) this.czk.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.czl, d.C0080d.cp_bg_line_d);
        if (this.czx == null) {
            this.czx = this.czk.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.czI == null) {
            this.czI = (ObservedChangeLinearLayout) this.czk.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.czI.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.czk.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.czk.ajE()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.czw == null) {
            this.czw = this.czk.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b ald = aVar.ald();
            if (ald != null) {
                ald.av(this.czw);
            }
        }
        if (this.czm == null) {
            this.czm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.czm.setOnClickListener(this.czv);
            this.mBackImageView = (ImageView) this.czm.findViewById(d.g.widget_navi_back_button);
        }
        if (this.czn == null) {
            this.czn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.czn.setOnClickListener(this.czv);
            this.bnb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.bnb.setOnClickListener(this.czv);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.czk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0080d.cp_bg_line_b);
        }
        if (this.czs == null) {
            this.czs = (BdExpandListView) this.czk.mRootView.findViewById(d.g.frs_lv_thread);
        }
        this.czs.setScrollable(this.czk);
        this.czs.setFadingEdgeLength(0);
        this.czs.setOverScrollMode(2);
        this.czl.setBottomOrderView(this.czs);
        this.czs.setOnTouchListener(this.czk.aMI);
        this.czs.setDivider(null);
        this.czs.setPullRefresh(this.mPullView);
        if (z && this.czA == null) {
            this.czA = BdListViewHelper.a(this.czk.getActivity(), this.czs, BdListViewHelper.HeadType.DEFAULT);
        }
        this.czs.setDividerHeight(0);
        this.czs.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.czG != null) {
                    i.this.czG.aZ(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        });
        if (this.bgN == null) {
            this.bgN = new PbListView(this.czk.getPageContext().getPageActivity());
            this.bgN.getView();
        }
        this.bgN.dx(d.C0080d.cp_bg_line_d);
        this.bgN.setHeight(com.baidu.adp.lib.util.l.f(this.czk.getActivity(), d.e.ds140));
        this.bgN.wq();
        this.bgN.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_cont_d));
        this.bgN.dw(d.C0080d.cp_cont_e);
        this.czs.setOnSrollToBottomListener(this.czk);
        this.mNavigationBar.setOnTouchListener(new r(new r.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.r.a
            public void akk() {
                i.this.czk.ajz();
            }

            @Override // com.baidu.tieba.tbadkCore.r.a
            public void akl() {
                if (i.this.czs != null) {
                    i.this.czs.setSelection(0);
                    if (i.this.czG != null) {
                        i.this.czG.a(i.this.czb, i.this.bfu, false, true);
                    }
                }
            }
        }));
        boolean vu = com.baidu.tbadk.core.util.an.vs().vu();
        if (this.czt == null) {
            this.czt = aVar.a(this.czk, this.czs, vu);
        }
        cg(false);
        if (!z) {
            if (this.cks == null) {
                this.cks = new NoNetworkView(this.czk.getActivity());
                this.cks.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.czI.addView(this.cks);
            }
            if (com.baidu.adp.lib.util.j.gV()) {
                this.cks.setVisibility(8);
            } else {
                this.cks.setVisibility(0);
            }
            this.cks.onChangeSkinType(this.czk.xP(), TbadkCoreApplication.getInst().getSkinType());
        }
        ajO();
        if (this.czB == null) {
            this.czB = aVar.c(this.czk, this.czl);
        }
        if (this.czC == null) {
            this.czC = aVar.b(this.czk, this.czl);
        }
        if (this.czH == null) {
            this.czH = this.czk.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.czG == null) {
            this.czG = new com.baidu.tieba.play.m(this.czk.getPageContext(), this.czs);
        }
        this.czG.setUniqueId(this.czk.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.czA != null && this.czA.getLayoutParams() != null) {
            this.czA.getLayoutParams().height = i;
            this.czA.setLayoutParams(this.czA.getLayoutParams());
        }
    }

    public View ajI() {
        return this.czA;
    }

    public com.baidu.tieba.play.m ajJ() {
        return this.czG;
    }

    public com.baidu.tieba.frs.entelechy.b.c ajK() {
        return this.czC;
    }

    public void eA(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.v(this.czk.ajB().bto());
        if (this.czB != null) {
            this.czB.eA(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e ajL() {
        return this.czB;
    }

    public void v(boolean z, boolean z2) {
        if (this.czK && this.czC != null) {
            this.czC.v(z, z2);
        }
    }

    public void eB(boolean z) {
        this.czK = z;
        if (!this.czK && this.czC != null) {
            this.czC.v(false, false);
        }
    }

    public void ajM() {
        if (this.czK && this.czC != null) {
            this.czC.v(false, false);
        }
        this.czn.setVisibility(8);
        this.bnb.setVisibility(8);
        eA(false);
        this.czs.setVisibility(8);
    }

    public void ajN() {
        if (this.czK && this.czC != null) {
            this.czC.v(true, false);
        }
        this.czn.setVisibility(0);
        this.bnb.setVisibility(0);
        eA(true);
        this.czs.setVisibility(0);
    }

    public void eC(boolean z) {
        if (this.czC != null) {
            this.czC.eT(z);
        }
    }

    private void ajO() {
        if (this.czD == null) {
            this.czD = (GifView) this.czk.mRootView.findViewById(d.g.gif_real_time);
            this.czE = (TbImageView) this.czk.mRootView.findViewById(d.g.tbimg_real_time);
            this.czE.setPageId(this.czk.getUniqueId());
            this.czD.setLayerType(1, null);
            this.czE.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ajP() {
        return this.czm;
    }

    public void h(NoNetworkView.a aVar) {
        this.cwk = aVar;
        if (this.cks != null) {
            this.cks.a(this.cwk);
        }
    }

    public void cg(boolean z) {
        this.czj = z;
        if (z) {
            if (this.czC != null) {
                this.czC.alL();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.czs.getAdapter()).notifyDataSetChanged();
        if (this.czC != null) {
            this.czC.alM();
        }
    }

    public void eD(boolean z) {
        if (this.czC != null) {
            if (z) {
                v(true, true);
            } else {
                v(true, false);
            }
        }
    }

    public void eE(boolean z) {
        if (this.czC != null) {
            if (z) {
                v(false, true);
            } else {
                v(false, false);
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
        this.czs.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.czt.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.czt.setForumName(str);
        this.mForumName = str;
    }

    public void cE(boolean z) {
        this.czt.cE(z);
    }

    public void onDestroy() {
        if (this.czG != null) {
            this.czG.destroy();
        }
        this.czt.onDestory();
        this.czs.setOnSrollToBottomListener(null);
        this.czs.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.czM);
        if (this.clO != null) {
            this.clO.onDestroy();
        }
        this.czF.clear();
        if (this.czB != null) {
            this.czB.alQ();
        }
        if (this.czH != null) {
            this.czH.setBackgroundDrawable(null);
        }
    }

    public boolean ajQ() {
        if (this.czB != null) {
            return this.czB.ajQ();
        }
        return false;
    }

    public boolean ajC() {
        return this.czj;
    }

    public void Oo() {
        this.czs.setVisibility(0);
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
            com.baidu.tbadk.core.h.oT().cs(str);
        }
    }

    public void ajR() {
        if (this.czt != null) {
            this.czt.notifyDataSetChanged();
        }
    }

    public void abn() {
        if (this.czt instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.czt).abn();
        }
    }

    private void ajS() {
        if (this.czu == null && this.czk.getPageContext() != null) {
            String[] strArr = {this.czk.getPageContext().getPageActivity().getString(d.j.take_photo), this.czk.getPageContext().getPageActivity().getString(d.j.album)};
            this.czu = new com.baidu.tbadk.core.dialog.b(this.czk.getPageContext().getPageActivity());
            this.czu.cT(this.czk.getPageContext().getPageActivity().getString(d.j.operation));
            this.czu.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.czk.ajD();
                    } else if (i == 1 && i.this.czk.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(i.this.czk.getPageContext().getPageActivity());
                    }
                }
            });
            this.czu.d(this.czk.getPageContext());
        }
    }

    public void ajT() {
        ajS();
        if (this.czu != null) {
            this.czu.tl();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.j jVar) {
        if (com.baidu.tbadk.core.util.v.v(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.czk != null && this.czk.ajf() != null && this.czk.ajf().anQ() == 0) {
                kVar.ju(this.czk.ajf().anY());
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
                if (fVar instanceof bh) {
                    ((bh) fVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.czt.b(arrayList, jVar);
        if (this.czG != null) {
            this.czG.a(this.czb, this.bfu, this.czz, true);
        }
    }

    public BdTypeListView getListView() {
        return this.czs;
    }

    public void ajU() {
        this.czt.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.czk.getPageContext(), 1);
        aVar.a(this.czs);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.czk.getForumName());
        hashMap.put("forum_id", this.czk.getForumId());
        aVar.setParams(hashMap);
        aVar.H(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.czB != null) {
            this.czB.alR();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.czB != null) {
            this.czB.alS();
        }
    }

    public void release() {
        if (this.cks != null && this.cwk != null) {
            this.cks.b(this.cwk);
        }
    }

    public ImageView ajV() {
        return this.bnb;
    }

    public ImageView ajW() {
        return this.czn;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.czk, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.czk.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.czE != null) {
            this.czE.invalidate();
        }
        if (this.czt != null) {
            this.czt.alA();
            this.czt.notifyDataSetChanged();
        }
        this.czk.xP().getLayoutMode().ag(i == 1);
        this.czk.xP().getLayoutMode().t(this.czl);
        if (this.czl != null) {
            com.baidu.tbadk.core.util.aj.e(this.czl, d.C0080d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.czk.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cR(d.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.czw, d.C0080d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0080d.cp_bg_line_b);
        }
        if (this.cks != null) {
            this.cks.onChangeSkinType(this.czk.getPageContext(), i);
        }
        if (this.bgN != null) {
            this.bgN.dy(i);
        }
        eH(false);
        if (this.czC != null) {
            this.czC.onChangeSkinType(i);
        }
        if (this.czB != null) {
            this.czB.onChangeSkinType(i);
        }
        if (this.czH != null) {
            UtilHelper.setStatusBarBackground(this.czH, i);
        }
        if (this.czG != null) {
            this.czG.a(this.czb, this.bfu, this.czz, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
    }

    public void startPullRefresh() {
        this.czs.startPullRefresh();
    }

    public void ajX() {
        this.czs.completePullRefreshPostDelayed(2000L);
    }

    public boolean ajY() {
        return this.czo != null && this.czr.getVisibility() == 0;
    }

    public void ajZ() {
        if (this.czo != null) {
            this.czp.setVisibility(0);
            this.czr.setVisibility(8);
            this.czq.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.czM, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bo boVar) {
        if (this.czo == null) {
            this.czo = (ViewStub) this.czk.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.czo.setVisibility(0);
            this.czp = (FrameLayout) this.czk.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.czq = (TbImageView) this.czk.mRootView.findViewById(d.g.game_activity_egg);
            this.czr = (TbImageView) this.czk.mRootView.findViewById(d.g.game_activity_egg_s);
            this.czq.setPageId(this.czk.getUniqueId());
            this.czr.setPageId(this.czk.getUniqueId());
            this.czq.setDefaultBgResource(d.C0080d.common_color_10022);
            this.czq.setDefaultResource(0);
            this.czr.setDefaultBgResource(d.C0080d.common_color_10022);
            this.czr.setDefaultResource(0);
            this.czp.setOnClickListener(this.czv);
        }
        this.czp.setVisibility(0);
        String sX = boVar.sX();
        String sY = boVar.sY();
        this.czq.startLoad(sX, 10, false);
        this.czr.startLoad(sY, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.czM, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void aka() {
        if (this.czo != null) {
            this.czp.setVisibility(8);
        }
    }

    public t akb() {
        return this.czt;
    }

    public ViewGroup VB() {
        return this.czl;
    }

    public View akc() {
        return this.czx;
    }

    public void akd() {
        if (com.baidu.tbadk.l.r.Gt().Gu()) {
            int lastVisiblePosition = this.czs.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.czs.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.cAd != null) {
                        com.baidu.tbadk.l.l perfLog = mVar.cAd.getPerfLog();
                        perfLog.fs(1000);
                        perfLog.aJI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.cAd.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.cAd.startLogPerf();
                    }
                    if (mVar.cAb != null && (mVar.cAb instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.cAb;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fs(1000);
                                perfLog2.aJI = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar ajA() {
        return this.mNavigationBar;
    }

    public void ake() {
        this.mHasMore = true;
        this.czs.setNextPage(this.bgN);
        if (this.czy > 0) {
            this.bgN.dA(d.C0080d.cp_bg_line_d);
            this.bgN.dz(this.czy);
        }
        this.bgN.wt();
    }

    public void akf() {
        this.mHasMore = false;
        this.czs.setNextPage(this.bgN);
        if (this.czy > 0) {
            this.bgN.dA(d.C0080d.cp_bg_line_d);
            this.bgN.dz(this.czy);
        }
        this.bgN.wu();
        this.bgN.setText(this.czk.getResources().getString(d.j.list_no_more));
    }

    public void abo() {
        this.mHasMore = false;
        this.czs.setNextPage(null);
    }

    public boolean abe() {
        return this.bgN.getView().getParent() != null && this.mHasMore;
    }

    public void jq(int i) {
        this.czy = i;
    }

    public void jr(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.clO == null) {
                    this.clO = new CommonTipView(this.czk.getActivity());
                }
                this.clO.setText(d.j.frs_login_tip);
                this.clO.show((FrameLayout) akc(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eF(boolean z) {
        if (this.czG != null) {
            if (z) {
                this.czG.hu(false);
                this.czG.atL();
                return;
            }
            this.czG.hu(true);
            this.czG.a(this.czb, this.bfu, this.czz, true);
        }
    }

    public void ax(int i, int i2) {
        if (this.czG != null) {
            this.czG.a(i, i2, this.czz, 1);
        }
    }

    public void ay(int i, int i2) {
        this.czb = i;
        this.bfu = i2;
    }

    public void eG(boolean z) {
        this.czz = z;
    }

    public void akg() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
        }
    }

    private void akh() {
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
        boolean i = com.baidu.tieba.frs.g.f.i(this.czk.ajB());
        boolean h = com.baidu.tieba.frs.g.f.h(this.czk.ajB());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bIB) {
                    this.bIB = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.czn, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.bnb, d.f.btn_sml_more_bg, d.f.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bIB) {
                this.bIB = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.czn, d.f.icon_search_bg_s, d.f.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.bnb, d.f.btn_more_selector_s, d.f.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        akh();
    }

    public void eI(boolean z) {
        if (!this.czs.btN()) {
            this.czs.setStarForum(true);
            if (z && !this.czk.ajE()) {
                this.mPullView = new com.baidu.tbadk.core.view.h(this.czk.getPageContext());
                this.mPullView.setTag(this.czk.getUniqueId());
                this.czs.setPullRefresh(this.mPullView);
            }
        }
    }

    public void js(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void jt(int i) {
        if (this.czs != null && this.czs.getChildCount() >= 0) {
            if (this.czs.getFirstVisiblePosition() > 8) {
                this.czs.setSelection(8);
            }
            this.czs.smoothScrollToPosition(i);
        }
    }

    public void aki() {
        a(this.czJ, this.czk.ajE());
        if (this.czt != null) {
            this.czt.alF();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.czL == null) {
                this.czL = new com.baidu.tieba.video.d(this.czk.getActivity(), this.czl);
            }
            this.czL.f(postWriteCallBackData);
        }
    }

    public void akj() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.czN && this.czk.getActivity() != null && this.czk.getPageContext() != null) {
            View view = null;
            if (this.czs != null && (headerViewsCount = this.czs.getHeaderViewsCount()) < this.czs.getChildCount()) {
                view = this.czs.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).ad(0).A(true).B(false).z(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.i.6
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        i.this.czk.getPageContext().getLayoutMode().t(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eW() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eX() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.f(i.this.czk.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.f(i.this.czk.getActivity(), d.e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.i.7
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void eZ() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c eY = dVar.eY();
                eY.y(false);
                eY.j(this.czk.getActivity());
                com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eY != null) {
                            eY.dismiss();
                        }
                    }
                }, 4000L);
                this.czN = true;
            }
        }
    }
}
