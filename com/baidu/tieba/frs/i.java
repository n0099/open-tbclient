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
    private NoNetworkView bFB;
    private PbListView bes;
    private CommonTipView caA;
    private f ckZ;
    private View clb;
    private ImageView clc;
    private ImageView cld;
    private ViewStub cle;
    private q clj;
    private View.OnClickListener cll;
    private View clm;
    private View cln;
    private View clq;
    private com.baidu.tieba.frs.entelechy.b.e clr;
    private com.baidu.tieba.frs.entelechy.b.c cls;
    private GifView clt;
    private TbImageView clu;
    private HashSet<String> clv;
    private com.baidu.tieba.play.l clw;
    private ObservedChangeLinearLayout clx;
    private com.baidu.tieba.frs.entelechy.b.a cly;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.l mPullView;
    private boolean ckY = false;
    private NoPressedRelativeLayout cla = null;
    private FrameLayout clf = null;
    private TbImageView clg = null;
    private TbImageView clh = null;
    private BdExpandListView cli = null;
    private com.baidu.tbadk.core.dialog.b clk = null;
    private NoNetworkView.a bFE = null;
    private boolean mHasMore = true;
    private int clo = 0;
    private boolean clp = false;
    private int ckQ = 0;
    private int bda = 0;
    private View cbp = null;
    private boolean byi = true;
    private Runnable clz = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cle != null) {
                i.this.clf.setVisibility(0);
                i.this.clh.setVisibility(0);
                i.this.clg.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout afT() {
        return this.clx;
    }

    public View afU() {
        return this.cbp;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.ckZ = null;
        this.cll = null;
        this.ckZ = fVar;
        this.cll = onClickListener;
        a(aVar, z);
        this.clv = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.cly = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.l(this.ckZ.getPageContext());
        }
        this.mPullView.setTag(this.ckZ.getUniqueId());
        if (this.cla == null) {
            this.cla = (NoPressedRelativeLayout) this.ckZ.mRootView.findViewById(d.h.frs);
        }
        com.baidu.tbadk.core.util.ai.k(this.cla, d.e.cp_bg_line_d);
        if (this.cln == null) {
            this.cln = this.ckZ.mRootView.findViewById(d.h.frs_list_content);
        }
        if (this.clx == null) {
            this.clx = (ObservedChangeLinearLayout) this.ckZ.mRootView.findViewById(d.h.navigation_bar_wrapperLayout);
            this.clx.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.ckZ.mRootView.findViewById(d.h.view_navigation_bar);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.ckZ.afQ()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.clm == null) {
            this.clm = this.ckZ.mRootView.findViewById(d.h.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b agN = aVar.agN();
            if (agN != null) {
                agN.ak(this.clm);
            }
        }
        if (this.clb == null) {
            this.clb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.clb.setOnClickListener(this.cll);
            this.mBackImageView = (ImageView) this.clb.findViewById(d.h.widget_navi_back_button);
        }
        if (this.clc == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.ckZ.getPageContext().getPageActivity(), d.f.ds24), 0);
            this.clc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.clc.setLayoutParams(layoutParams);
            this.clc.setOnClickListener(this.cll);
            this.cld = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.cld.setLayoutParams(layoutParams);
            this.cld.setOnClickListener(this.cll);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.ckZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.cli == null) {
            this.cli = (BdExpandListView) this.ckZ.mRootView.findViewById(d.h.frs_lv_thread);
        }
        this.cli.setScrollable(this.ckZ);
        this.cli.setFadingEdgeLength(0);
        this.cli.setOverScrollMode(2);
        this.cla.setBottomOrderView(this.cli);
        this.cli.setOnTouchListener(this.ckZ.aMT);
        this.cli.setDivider(null);
        this.cli.setPullRefresh(this.mPullView);
        if (z && this.clq == null) {
            this.clq = BdListViewHelper.a(this.ckZ.getActivity(), this.cli, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cli.setDividerHeight(0);
        this.cli.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.clw != null) {
                    i.this.clw.aS(view);
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
        if (this.bes == null) {
            this.bes = new PbListView(this.ckZ.getPageContext().getPageActivity());
            this.bes.lk();
        }
        this.bes.m10do(d.e.cp_bg_line_c);
        this.cli.setOnSrollToBottomListener(this.ckZ);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.q(new q.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.q.a
            public void agu() {
                i.this.ckZ.afL();
            }

            @Override // com.baidu.tieba.tbadkCore.q.a
            public void agv() {
                if (i.this.cli != null) {
                    i.this.cli.setSelection(0);
                    if (i.this.clw != null) {
                        i.this.clw.a(i.this.ckQ, i.this.bda, false, true);
                    }
                }
            }
        }));
        boolean vS = com.baidu.tbadk.core.util.am.vQ().vS();
        if (this.clj == null) {
            this.clj = aVar.a(this.ckZ, this.cli, vS);
        }
        ck(false);
        if (!z) {
            if (this.bFB == null) {
                this.bFB = new NoNetworkView(this.ckZ.getActivity());
                this.bFB.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.clx.addView(this.bFB);
            }
            if (com.baidu.adp.lib.util.i.hf()) {
                this.bFB.setVisibility(8);
            } else {
                this.bFB.setVisibility(0);
            }
            this.bFB.onChangeSkinType(this.ckZ.yg(), TbadkCoreApplication.getInst().getSkinType());
        }
        agb();
        if (this.clr == null) {
            this.clr = aVar.c(this.ckZ, this.cla);
        }
        if (this.cls == null) {
            this.cls = aVar.b(this.ckZ, this.cla);
        }
        if (this.cbp == null) {
            this.cbp = this.ckZ.mRootView.findViewById(d.h.statebar_view);
        }
        if (this.clw == null) {
            this.clw = new com.baidu.tieba.play.l(this.ckZ.getPageContext(), this.cli);
        }
        this.clw.setUniqueId(this.ckZ.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.clq != null && this.clq.getLayoutParams() != null) {
            this.clq.getLayoutParams().height = i;
            this.clq.setLayoutParams(this.clq.getLayoutParams());
        }
    }

    public View afV() {
        return this.clq;
    }

    public com.baidu.tieba.play.l afW() {
        return this.clw;
    }

    public com.baidu.tieba.frs.entelechy.b.c afX() {
        return this.cls;
    }

    public void eH(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.u.v(this.ckZ.afN().brS());
        if (this.clr != null) {
            this.clr.eH(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e afY() {
        return this.clr;
    }

    public void t(boolean z, boolean z2) {
        if (this.cls != null) {
            this.cls.t(z, z2);
        }
        if (this.ckZ.isAdded()) {
            if (z) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB);
                customMessage.setTag(this.ckZ.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, Boolean.valueOf(z2));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            CustomMessage customMessage2 = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB);
            customMessage2.setTag(this.ckZ.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, Boolean.valueOf(z2));
            customResponsedMessage2.setOrginalMessage(customMessage2);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
        }
    }

    public void afZ() {
        if (this.cls != null) {
            this.cls.t(false, false);
        }
        this.clc.setVisibility(8);
        this.cld.setVisibility(8);
        eH(false);
        this.cli.setVisibility(8);
    }

    public void aga() {
        if (this.cls != null) {
            this.cls.t(true, false);
        }
        this.clc.setVisibility(0);
        this.cld.setVisibility(0);
        eH(true);
        this.cli.setVisibility(0);
    }

    public void eI(boolean z) {
        if (this.cls != null) {
            this.cls.eS(z);
        }
    }

    private void agb() {
        if (this.clt == null) {
            this.clt = (GifView) this.ckZ.mRootView.findViewById(d.h.gif_real_time);
            this.clu = (TbImageView) this.ckZ.mRootView.findViewById(d.h.tbimg_real_time);
            this.clu.setPageId(this.ckZ.getUniqueId());
            this.clt.setLayerType(1, null);
            this.clu.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View agc() {
        return this.clb;
    }

    public void c(NoNetworkView.a aVar) {
        this.bFE = aVar;
        if (this.bFB != null) {
            this.bFB.a(this.bFE);
        }
    }

    public void ck(boolean z) {
        this.ckY = z;
        if (z) {
            if (this.cls != null) {
                this.cls.ahs();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.cli.getAdapter()).notifyDataSetChanged();
        if (this.cls != null) {
            this.cls.aht();
        }
    }

    public void eJ(boolean z) {
        if (this.cls != null) {
            if (z) {
                t(true, true);
            } else {
                t(true, false);
            }
        }
    }

    public void eK(boolean z) {
        if (this.cls != null) {
            if (z) {
                t(false, true);
            } else {
                t(false, false);
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
        this.cli.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.clj.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.clj.setForumName(str);
        this.mForumName = str;
    }

    public void cH(boolean z) {
        this.clj.cH(z);
    }

    public void onDestroy() {
        if (this.clw != null) {
            this.clw.destroy();
        }
        this.clj.onDestory();
        this.cli.setOnSrollToBottomListener(null);
        this.cli.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.clz);
        if (this.caA != null) {
            this.caA.onDestroy();
        }
        this.clv.clear();
        if (this.clr != null) {
            this.clr.ahx();
        }
        if (this.cbp != null) {
            this.cbp.setBackgroundDrawable(null);
        }
    }

    public boolean agd() {
        if (this.clr != null) {
            return this.clr.agd();
        }
        return false;
    }

    public boolean afO() {
        return this.ckY;
    }

    public void Nr() {
        this.cli.setVisibility(0);
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

    public void age() {
        if (this.clj != null) {
            this.clj.notifyDataSetChanged();
        }
    }

    public void Yb() {
        if (this.clj instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.clj).Yb();
        }
    }

    private void agf() {
        if (this.clk == null && this.ckZ.getPageContext() != null) {
            String[] strArr = {this.ckZ.getPageContext().getPageActivity().getString(d.l.take_photo), this.ckZ.getPageContext().getPageActivity().getString(d.l.album)};
            this.clk = new com.baidu.tbadk.core.dialog.b(this.ckZ.getPageContext().getPageActivity());
            this.clk.cU(this.ckZ.getPageContext().getPageActivity().getString(d.l.operation));
            this.clk.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.ckZ.afP();
                    } else if (i == 1 && i.this.ckZ.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ah.q(i.this.ckZ.getPageContext().getPageActivity());
                    }
                }
            });
            this.clk.d(this.ckZ.getPageContext());
        }
    }

    public void agg() {
        agf();
        if (this.clk != null) {
            this.clk.tu();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tbadk.core.util.u.v(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.ckZ != null && this.ckZ.afq() != null && this.ckZ.afq().ajd() == 0) {
                kVar.iK(this.ckZ.afq().ajl());
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
        this.clj.b(arrayList, iVar);
        if (this.clw != null) {
            this.clw.a(this.ckQ, this.bda, this.clp, true);
        }
    }

    public BdTypeListView getListView() {
        return this.cli;
    }

    public void agh() {
        this.clj.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.ckZ.getPageContext(), 1);
        aVar.a(this.cli);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.ckZ.getForumName());
        hashMap.put("forum_id", this.ckZ.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.clr != null) {
            this.clr.ahy();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.clr != null) {
            this.clr.ahz();
        }
    }

    public void release() {
        if (this.bFB != null && this.bFE != null) {
            this.bFB.b(this.bFE);
        }
    }

    public ImageView agi() {
        return this.cld;
    }

    public ImageView agj() {
        return this.clc;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.ckZ, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.ckZ.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.clu != null) {
            this.clu.invalidate();
        }
        if (this.clj != null) {
            this.clj.ahj();
            this.clj.notifyDataSetChanged();
        }
        this.ckZ.yg().getLayoutMode().ah(i == 1);
        this.ckZ.yg().getLayoutMode().t(this.cla);
        if (this.cla != null) {
            com.baidu.tbadk.core.util.ai.e(this.cla, d.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ckZ.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ai.cT(d.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.ai.e(this.clm, d.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.bFB != null) {
            this.bFB.onChangeSkinType(this.ckZ.getPageContext(), i);
        }
        if (this.bes != null) {
            this.bes.dp(i);
        }
        eN(false);
        if (this.cls != null) {
            this.cls.onChangeSkinType(i);
        }
        if (this.clr != null) {
            this.clr.onChangeSkinType(i);
        }
        if (this.cbp != null) {
            UtilHelper.setStatusBarBackground(this.cbp, i);
        }
        if (this.clw != null) {
            this.clw.a(this.ckQ, this.bda, this.clp, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
    }

    public void startPullRefresh() {
        this.cli.startPullRefresh();
    }

    public void agk() {
        this.cli.completePullRefreshPostDelayed(2000L);
    }

    public boolean agl() {
        return this.cle != null && this.clh.getVisibility() == 0;
    }

    public void agm() {
        if (this.cle != null) {
            this.clf.setVisibility(0);
            this.clh.setVisibility(8);
            this.clg.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.clz, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bs bsVar) {
        if (this.cle == null) {
            this.cle = (ViewStub) this.ckZ.mRootView.findViewById(d.h.yule_game_egg_view_stub);
            this.cle.setVisibility(0);
            this.clf = (FrameLayout) this.ckZ.mRootView.findViewById(d.h.game_activity_egg_layout);
            this.clg = (TbImageView) this.ckZ.mRootView.findViewById(d.h.game_activity_egg);
            this.clh = (TbImageView) this.ckZ.mRootView.findViewById(d.h.game_activity_egg_s);
            this.clg.setPageId(this.ckZ.getUniqueId());
            this.clh.setPageId(this.ckZ.getUniqueId());
            this.clg.setDefaultBgResource(d.e.common_color_10022);
            this.clg.setDefaultResource(0);
            this.clh.setDefaultBgResource(d.e.common_color_10022);
            this.clh.setDefaultResource(0);
            this.clf.setOnClickListener(this.cll);
        }
        this.clf.setVisibility(0);
        String th = bsVar.th();
        String ti = bsVar.ti();
        this.clg.c(th, 10, false);
        this.clh.c(ti, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.clz, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void agn() {
        if (this.cle != null) {
            this.clf.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q ago() {
        return this.clj;
    }

    public ViewGroup Wn() {
        return this.cla;
    }

    public View agp() {
        return this.cln;
    }

    public void agq() {
        if (r.Gz().GA()) {
            int lastVisiblePosition = this.cli.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cli.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.clO != null) {
                        com.baidu.tbadk.l.l perfLog = mVar.clO.getPerfLog();
                        perfLog.fi(1000);
                        perfLog.aKa = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.clO.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.clO.wA();
                    }
                    if (mVar.clM != null && (mVar.clM instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.clM;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fi(1000);
                                perfLog2.aKa = true;
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

    public NavigationBar afM() {
        return this.mNavigationBar;
    }

    public void Wt() {
        this.mHasMore = true;
        this.cli.setNextPage(this.bes);
        if (this.clo > 0) {
            this.bes.dq(this.clo);
        }
        this.bes.wW();
    }

    public void Wv() {
        this.mHasMore = false;
        this.cli.setNextPage(this.bes);
        if (this.clo > 0) {
            this.bes.dq(this.clo);
        }
        this.bes.wX();
        this.bes.setText(this.ckZ.getResources().getString(d.l.list_no_more));
    }

    public void Yc() {
        this.mHasMore = false;
        this.cli.setNextPage(null);
    }

    public boolean XS() {
        return this.bes.getView().getParent() != null && this.mHasMore;
    }

    public void iG(int i) {
        this.clo = i;
    }

    public void iH(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.caA == null) {
                    this.caA = new CommonTipView(this.ckZ.getActivity());
                }
                this.caA.setText(d.l.frs_login_tip);
                this.caA.a((FrameLayout) agp(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eL(boolean z) {
        if (this.clw != null) {
            if (z) {
                this.clw.hx(false);
                this.clw.aqF();
                return;
            }
            this.clw.hx(true);
            this.clw.a(this.ckQ, this.bda, this.clp, true);
        }
    }

    public void ao(int i, int i2) {
        if (this.clw != null) {
            this.clw.a(i, i2, this.clp, 1);
        }
    }

    public void ap(int i, int i2) {
        this.ckQ = i;
        this.bda = i2;
    }

    public void eM(boolean z) {
        this.clp = z;
    }

    public void agr() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.ai.j(this.mBackImageView, d.g.frs_star_navigation_bg);
        }
    }

    private void ags() {
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

    private void eN(boolean z) {
        boolean i = com.baidu.tieba.frs.g.f.i(this.ckZ.afN());
        boolean h = com.baidu.tieba.frs.g.f.h(this.ckZ.afN());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.byi) {
                    this.byi = true;
                    com.baidu.tbadk.core.util.ai.b(this.mBackImageView, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.ai.b(this.clc, d.g.icon_sml_search_bg, d.g.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.ai.b(this.cld, d.g.btn_sml_more_bg, d.g.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.ai.j(this.mBackImageView, d.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.byi) {
                this.byi = false;
                com.baidu.tbadk.core.util.ai.b(this.mBackImageView, d.g.icon_return_bg_s, d.g.icon_return_bg);
                com.baidu.tbadk.core.util.ai.b(this.clc, d.g.icon_search_bg_s, d.g.icon_search_bg);
                com.baidu.tbadk.core.util.ai.b(this.cld, d.g.btn_more_selector_s, d.g.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        ags();
    }

    public void eO(boolean z) {
        if (!this.cli.bsm()) {
            this.cli.setStarForum(true);
            if (z && !this.ckZ.afQ()) {
                this.mPullView = new com.baidu.tbadk.core.view.l(this.ckZ.getPageContext());
                this.mPullView.setTag(this.ckZ.getUniqueId());
                this.cli.setPullRefresh(this.mPullView);
            }
        }
    }

    public void iI(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void iJ(int i) {
        if (this.cli != null && this.cli.getChildCount() >= 0) {
            if (this.cli.getFirstVisiblePosition() > 8) {
                this.cli.setSelection(8);
            }
            this.cli.smoothScrollToPosition(i);
        }
    }

    public void agt() {
        a(this.cly, this.ckZ.afQ());
        if (this.clj != null) {
            this.clj.reInit();
        }
    }
}
