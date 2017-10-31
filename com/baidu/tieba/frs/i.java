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
    private PbListView bgE;
    private ImageView bmS;
    private NoNetworkView ckb;
    private CommonTipView clv;
    private f cyR;
    private View cyT;
    private ImageView cyU;
    private ViewStub cyV;
    private t cza;
    private View.OnClickListener czc;
    private View czd;
    private View cze;
    private int czf;
    private View czh;
    private com.baidu.tieba.frs.entelechy.b.e czi;
    private com.baidu.tieba.frs.entelechy.b.c czj;
    private GifView czk;
    private TbImageView czl;
    private HashSet<String> czm;
    private com.baidu.tieba.play.m czn;
    private ObservedChangeLinearLayout czp;
    private com.baidu.tieba.frs.entelechy.b.a czq;
    private com.baidu.tieba.video.d czs;
    private boolean czu;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean cyQ = false;
    private NoPressedRelativeLayout cyS = null;
    private FrameLayout cyW = null;
    private TbImageView cyX = null;
    private TbImageView cyY = null;
    private BdExpandListView cyZ = null;
    private com.baidu.tbadk.core.dialog.b czb = null;
    private NoNetworkView.a cvR = null;
    private boolean mHasMore = true;
    private boolean czg = false;
    private int cyI = 0;
    private int bfl = 0;
    private View czo = null;
    private boolean bIo = true;
    private boolean czr = true;
    private Runnable czt = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cyV != null) {
                i.this.cyW.setVisibility(0);
                i.this.cyY.setVisibility(0);
                i.this.cyX.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout ajs() {
        return this.czp;
    }

    public View ajt() {
        return this.czo;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.cyR = null;
        this.czc = null;
        this.czf = 0;
        this.cyR = fVar;
        this.czc = onClickListener;
        a(aVar, z);
        this.czm = new HashSet<>();
        this.czf = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.czq = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.cyR.getPageContext());
        }
        this.mPullView.setTag(this.cyR.getUniqueId());
        if (this.cyS == null) {
            this.cyS = (NoPressedRelativeLayout) this.cyR.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.cyS, d.C0080d.cp_bg_line_d);
        if (this.cze == null) {
            this.cze = this.cyR.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.czp == null) {
            this.czp = (ObservedChangeLinearLayout) this.cyR.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.czp.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cyR.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cyR.ajq()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.czd == null) {
            this.czd = this.cyR.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b akP = aVar.akP();
            if (akP != null) {
                akP.au(this.czd);
            }
        }
        if (this.cyT == null) {
            this.cyT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cyT.setOnClickListener(this.czc);
            this.mBackImageView = (ImageView) this.cyT.findViewById(d.g.widget_navi_back_button);
        }
        if (this.cyU == null) {
            this.cyU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.cyU.setOnClickListener(this.czc);
            this.bmS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.bmS.setOnClickListener(this.czc);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cyR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0080d.cp_bg_line_b);
        }
        if (this.cyZ == null) {
            this.cyZ = (BdExpandListView) this.cyR.mRootView.findViewById(d.g.frs_lv_thread);
        }
        this.cyZ.setScrollable(this.cyR);
        this.cyZ.setFadingEdgeLength(0);
        this.cyZ.setOverScrollMode(2);
        this.cyS.setBottomOrderView(this.cyZ);
        this.cyZ.setOnTouchListener(this.cyR.aMA);
        this.cyZ.setDivider(null);
        this.cyZ.setPullRefresh(this.mPullView);
        if (z && this.czh == null) {
            this.czh = BdListViewHelper.a(this.cyR.getActivity(), this.cyZ, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cyZ.setDividerHeight(0);
        this.cyZ.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.czn != null) {
                    i.this.czn.aY(view);
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
        if (this.bgE == null) {
            this.bgE = new PbListView(this.cyR.getPageContext().getPageActivity());
            this.bgE.getView();
        }
        this.bgE.dy(d.C0080d.cp_bg_line_d);
        this.bgE.setHeight(com.baidu.adp.lib.util.l.f(this.cyR.getActivity(), d.e.ds140));
        this.bgE.wq();
        this.bgE.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_cont_d));
        this.bgE.dx(d.C0080d.cp_cont_e);
        this.cyZ.setOnSrollToBottomListener(this.cyR);
        this.mNavigationBar.setOnTouchListener(new r(new r.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.r.a
            public void ajW() {
                i.this.cyR.ajl();
            }

            @Override // com.baidu.tieba.tbadkCore.r.a
            public void ajX() {
                if (i.this.cyZ != null) {
                    i.this.cyZ.setSelection(0);
                    if (i.this.czn != null) {
                        i.this.czn.a(i.this.cyI, i.this.bfl, false, true);
                    }
                }
            }
        }));
        boolean vu = com.baidu.tbadk.core.util.an.vs().vu();
        if (this.cza == null) {
            this.cza = aVar.a(this.cyR, this.cyZ, vu);
        }
        cf(false);
        if (!z) {
            if (this.ckb == null) {
                this.ckb = new NoNetworkView(this.cyR.getActivity());
                this.ckb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.czp.addView(this.ckb);
            }
            if (com.baidu.adp.lib.util.j.gV()) {
                this.ckb.setVisibility(8);
            } else {
                this.ckb.setVisibility(0);
            }
            this.ckb.onChangeSkinType(this.cyR.xH(), TbadkCoreApplication.getInst().getSkinType());
        }
        ajA();
        if (this.czi == null) {
            this.czi = aVar.c(this.cyR, this.cyS);
        }
        if (this.czj == null) {
            this.czj = aVar.b(this.cyR, this.cyS);
        }
        if (this.czo == null) {
            this.czo = this.cyR.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.czn == null) {
            this.czn = new com.baidu.tieba.play.m(this.cyR.getPageContext(), this.cyZ);
        }
        this.czn.setUniqueId(this.cyR.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.czh != null && this.czh.getLayoutParams() != null) {
            this.czh.getLayoutParams().height = i;
            this.czh.setLayoutParams(this.czh.getLayoutParams());
        }
    }

    public View aju() {
        return this.czh;
    }

    public com.baidu.tieba.play.m ajv() {
        return this.czn;
    }

    public com.baidu.tieba.frs.entelechy.b.c ajw() {
        return this.czj;
    }

    public void ev(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.v(this.cyR.ajn().btd());
        if (this.czi != null) {
            this.czi.ev(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e ajx() {
        return this.czi;
    }

    public void v(boolean z, boolean z2) {
        if (this.czr && this.czj != null) {
            this.czj.v(z, z2);
        }
    }

    public void ew(boolean z) {
        this.czr = z;
        if (!this.czr && this.czj != null) {
            this.czj.v(false, false);
        }
    }

    public void ajy() {
        if (this.czr && this.czj != null) {
            this.czj.v(false, false);
        }
        this.cyU.setVisibility(8);
        this.bmS.setVisibility(8);
        ev(false);
        this.cyZ.setVisibility(8);
    }

    public void ajz() {
        if (this.czr && this.czj != null) {
            this.czj.v(true, false);
        }
        this.cyU.setVisibility(0);
        this.bmS.setVisibility(0);
        ev(true);
        this.cyZ.setVisibility(0);
    }

    public void ex(boolean z) {
        if (this.czj != null) {
            this.czj.eO(z);
        }
    }

    private void ajA() {
        if (this.czk == null) {
            this.czk = (GifView) this.cyR.mRootView.findViewById(d.g.gif_real_time);
            this.czl = (TbImageView) this.cyR.mRootView.findViewById(d.g.tbimg_real_time);
            this.czl.setPageId(this.cyR.getUniqueId());
            this.czk.setLayerType(1, null);
            this.czl.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ajB() {
        return this.cyT;
    }

    public void h(NoNetworkView.a aVar) {
        this.cvR = aVar;
        if (this.ckb != null) {
            this.ckb.a(this.cvR);
        }
    }

    public void cf(boolean z) {
        this.cyQ = z;
        if (z) {
            if (this.czj != null) {
                this.czj.alx();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.cyZ.getAdapter()).notifyDataSetChanged();
        if (this.czj != null) {
            this.czj.aly();
        }
    }

    public void ey(boolean z) {
        if (this.czj != null) {
            if (z) {
                v(true, true);
            } else {
                v(true, false);
            }
        }
    }

    public void ez(boolean z) {
        if (this.czj != null) {
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
        this.cyZ.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.cza.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.cza.setForumName(str);
        this.mForumName = str;
    }

    public void cD(boolean z) {
        this.cza.cD(z);
    }

    public void onDestroy() {
        if (this.czn != null) {
            this.czn.destroy();
        }
        this.cza.onDestory();
        this.cyZ.setOnSrollToBottomListener(null);
        this.cyZ.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.czt);
        if (this.clv != null) {
            this.clv.onDestroy();
        }
        this.czm.clear();
        if (this.czi != null) {
            this.czi.alC();
        }
        if (this.czo != null) {
            this.czo.setBackgroundDrawable(null);
        }
    }

    public boolean ajC() {
        if (this.czi != null) {
            return this.czi.ajC();
        }
        return false;
    }

    public boolean ajo() {
        return this.cyQ;
    }

    public void Od() {
        this.cyZ.setVisibility(0);
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

    public void ajD() {
        if (this.cza != null) {
            this.cza.notifyDataSetChanged();
        }
    }

    public void abb() {
        if (this.cza instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cza).abb();
        }
    }

    private void ajE() {
        if (this.czb == null && this.cyR.getPageContext() != null) {
            String[] strArr = {this.cyR.getPageContext().getPageActivity().getString(d.j.take_photo), this.cyR.getPageContext().getPageActivity().getString(d.j.album)};
            this.czb = new com.baidu.tbadk.core.dialog.b(this.cyR.getPageContext().getPageActivity());
            this.czb.cT(this.cyR.getPageContext().getPageActivity().getString(d.j.operation));
            this.czb.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.cyR.ajp();
                    } else if (i == 1 && i.this.cyR.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(i.this.cyR.getPageContext().getPageActivity());
                    }
                }
            });
            this.czb.d(this.cyR.getPageContext());
        }
    }

    public void ajF() {
        ajE();
        if (this.czb != null) {
            this.czb.tl();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.j jVar) {
        if (com.baidu.tbadk.core.util.v.v(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.cyR != null && this.cyR.aiR() != null && this.cyR.aiR().anB() == 0) {
                kVar.jv(this.cyR.aiR().anJ());
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
        this.cza.b(arrayList, jVar);
        if (this.czn != null) {
            this.czn.a(this.cyI, this.bfl, this.czg, true);
        }
    }

    public BdTypeListView getListView() {
        return this.cyZ;
    }

    public void ajG() {
        this.cza.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cyR.getPageContext(), 1);
        aVar.a(this.cyZ);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cyR.getForumName());
        hashMap.put("forum_id", this.cyR.getForumId());
        aVar.setParams(hashMap);
        aVar.H(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.czi != null) {
            this.czi.alD();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.czi != null) {
            this.czi.alE();
        }
    }

    public void release() {
        if (this.ckb != null && this.cvR != null) {
            this.ckb.b(this.cvR);
        }
    }

    public ImageView ajH() {
        return this.bmS;
    }

    public ImageView ajI() {
        return this.cyU;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cyR, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cyR.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.czl != null) {
            this.czl.invalidate();
        }
        if (this.cza != null) {
            this.cza.alm();
            this.cza.notifyDataSetChanged();
        }
        this.cyR.xH().getLayoutMode().ag(i == 1);
        this.cyR.xH().getLayoutMode().t(this.cyS);
        if (this.cyS != null) {
            com.baidu.tbadk.core.util.aj.e(this.cyS, d.C0080d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cyR.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cS(d.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.czd, d.C0080d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0080d.cp_bg_line_b);
        }
        if (this.ckb != null) {
            this.ckb.onChangeSkinType(this.cyR.getPageContext(), i);
        }
        if (this.bgE != null) {
            this.bgE.dz(i);
        }
        eC(false);
        if (this.czj != null) {
            this.czj.onChangeSkinType(i);
        }
        if (this.czi != null) {
            this.czi.onChangeSkinType(i);
        }
        if (this.czo != null) {
            UtilHelper.setStatusBarBackground(this.czo, i);
        }
        if (this.czn != null) {
            this.czn.a(this.cyI, this.bfl, this.czg, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public void startPullRefresh() {
        this.cyZ.startPullRefresh();
    }

    public void ajJ() {
        this.cyZ.completePullRefreshPostDelayed(2000L);
    }

    public boolean ajK() {
        return this.cyV != null && this.cyY.getVisibility() == 0;
    }

    public void ajL() {
        if (this.cyV != null) {
            this.cyW.setVisibility(0);
            this.cyY.setVisibility(8);
            this.cyX.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.czt, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bo boVar) {
        if (this.cyV == null) {
            this.cyV = (ViewStub) this.cyR.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.cyV.setVisibility(0);
            this.cyW = (FrameLayout) this.cyR.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.cyX = (TbImageView) this.cyR.mRootView.findViewById(d.g.game_activity_egg);
            this.cyY = (TbImageView) this.cyR.mRootView.findViewById(d.g.game_activity_egg_s);
            this.cyX.setPageId(this.cyR.getUniqueId());
            this.cyY.setPageId(this.cyR.getUniqueId());
            this.cyX.setDefaultBgResource(d.C0080d.common_color_10022);
            this.cyX.setDefaultResource(0);
            this.cyY.setDefaultBgResource(d.C0080d.common_color_10022);
            this.cyY.setDefaultResource(0);
            this.cyW.setOnClickListener(this.czc);
        }
        this.cyW.setVisibility(0);
        String sX = boVar.sX();
        String sY = boVar.sY();
        this.cyX.startLoad(sX, 10, false);
        this.cyY.startLoad(sY, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.czt, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void ajM() {
        if (this.cyV != null) {
            this.cyW.setVisibility(8);
        }
    }

    public t ajN() {
        return this.cza;
    }

    public ViewGroup Vq() {
        return this.cyS;
    }

    public View ajO() {
        return this.cze;
    }

    public void ajP() {
        if (com.baidu.tbadk.l.r.Gi().Gj()) {
            int lastVisiblePosition = this.cyZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cyZ.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.czK != null) {
                        com.baidu.tbadk.l.l perfLog = mVar.czK.getPerfLog();
                        perfLog.ft(1000);
                        perfLog.aJA = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.czK.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.czK.startLogPerf();
                    }
                    if (mVar.czI != null && (mVar.czI instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.czI;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.ft(1000);
                                perfLog2.aJA = true;
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

    public NavigationBar ajm() {
        return this.mNavigationBar;
    }

    public void ajQ() {
        this.mHasMore = true;
        this.cyZ.setNextPage(this.bgE);
        if (this.czf > 0) {
            this.bgE.dB(d.C0080d.cp_bg_line_d);
            this.bgE.dA(this.czf);
        }
        this.bgE.wt();
    }

    public void ajR() {
        this.mHasMore = false;
        this.cyZ.setNextPage(this.bgE);
        if (this.czf > 0) {
            this.bgE.dB(d.C0080d.cp_bg_line_d);
            this.bgE.dA(this.czf);
        }
        this.bgE.wu();
        this.bgE.setText(this.cyR.getResources().getString(d.j.list_no_more));
    }

    public void abc() {
        this.mHasMore = false;
        this.cyZ.setNextPage(null);
    }

    public boolean aaS() {
        return this.bgE.getView().getParent() != null && this.mHasMore;
    }

    public void jr(int i) {
        this.czf = i;
    }

    public void js(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.clv == null) {
                    this.clv = new CommonTipView(this.cyR.getActivity());
                }
                this.clv.setText(d.j.frs_login_tip);
                this.clv.show((FrameLayout) ajO(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eA(boolean z) {
        if (this.czn != null) {
            if (z) {
                this.czn.ho(false);
                this.czn.atu();
                return;
            }
            this.czn.ho(true);
            this.czn.a(this.cyI, this.bfl, this.czg, true);
        }
    }

    public void ax(int i, int i2) {
        if (this.czn != null) {
            this.czn.a(i, i2, this.czg, 1);
        }
    }

    public void ay(int i, int i2) {
        this.cyI = i;
        this.bfl = i2;
    }

    public void eB(boolean z) {
        this.czg = z;
    }

    public void ajS() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
        }
    }

    private void ajT() {
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

    private void eC(boolean z) {
        boolean i = com.baidu.tieba.frs.g.f.i(this.cyR.ajn());
        boolean h = com.baidu.tieba.frs.g.f.h(this.cyR.ajn());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bIo) {
                    this.bIo = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.cyU, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.bmS, d.f.btn_sml_more_bg, d.f.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bIo) {
                this.bIo = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.cyU, d.f.icon_search_bg_s, d.f.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.bmS, d.f.btn_more_selector_s, d.f.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        ajT();
    }

    public void eD(boolean z) {
        if (!this.cyZ.btB()) {
            this.cyZ.setStarForum(true);
            if (z && !this.cyR.ajq()) {
                this.mPullView = new com.baidu.tbadk.core.view.h(this.cyR.getPageContext());
                this.mPullView.setTag(this.cyR.getUniqueId());
                this.cyZ.setPullRefresh(this.mPullView);
            }
        }
    }

    public void jt(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void ju(int i) {
        if (this.cyZ != null && this.cyZ.getChildCount() >= 0) {
            if (this.cyZ.getFirstVisiblePosition() > 8) {
                this.cyZ.setSelection(8);
            }
            this.cyZ.smoothScrollToPosition(i);
        }
    }

    public void ajU() {
        a(this.czq, this.cyR.ajq());
        if (this.cza != null) {
            this.cza.alr();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.czs == null) {
                this.czs = new com.baidu.tieba.video.d(this.cyR.getActivity(), this.cyS);
            }
            this.czs.f(postWriteCallBackData);
        }
    }

    public void ajV() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.czu) {
            View view = null;
            if (this.cyZ != null && (headerViewsCount = this.cyZ.getHeaderViewsCount()) < this.cyZ.getChildCount()) {
                view = this.cyZ.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).ad(0).A(true).B(false).z(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.i.6
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        i.this.cyR.getPageContext().getLayoutMode().t(inflate);
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
                        return com.baidu.adp.lib.util.l.f(i.this.cyR.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.f(i.this.cyR.getActivity(), d.e.ds6);
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
                eY.j(this.cyR.getActivity());
                com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eY != null) {
                            eY.dismiss();
                        }
                    }
                }, 4000L);
                this.czu = true;
            }
        }
    }
}
