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
    private NoNetworkView bFC;
    private PbListView beu;
    private CommonTipView caB;
    private f cla;
    private View clc;
    private ImageView cld;
    private ImageView cle;
    private ViewStub clf;
    private q clk;
    private View.OnClickListener clm;
    private View cln;
    private View clo;
    private View clr;
    private com.baidu.tieba.frs.entelechy.b.e cls;
    private com.baidu.tieba.frs.entelechy.b.c clt;
    private GifView clu;
    private TbImageView clv;
    private HashSet<String> clw;
    private com.baidu.tieba.play.l clx;
    private ObservedChangeLinearLayout cly;
    private com.baidu.tieba.frs.entelechy.b.a clz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.l mPullView;
    private boolean ckZ = false;
    private NoPressedRelativeLayout clb = null;
    private FrameLayout clg = null;
    private TbImageView clh = null;
    private TbImageView cli = null;
    private BdExpandListView clj = null;
    private com.baidu.tbadk.core.dialog.b cll = null;
    private NoNetworkView.a bFF = null;
    private boolean mHasMore = true;
    private int clp = 0;
    private boolean clq = false;
    private int ckR = 0;
    private int bdb = 0;
    private View cbq = null;
    private boolean byj = true;
    private Runnable clA = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.clf != null) {
                i.this.clg.setVisibility(0);
                i.this.cli.setVisibility(0);
                i.this.clh.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout afN() {
        return this.cly;
    }

    public View afO() {
        return this.cbq;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.cla = null;
        this.clm = null;
        this.cla = fVar;
        this.clm = onClickListener;
        a(aVar, z);
        this.clw = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.clz = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.l(this.cla.getPageContext());
        }
        this.mPullView.setTag(this.cla.getUniqueId());
        if (this.clb == null) {
            this.clb = (NoPressedRelativeLayout) this.cla.mRootView.findViewById(d.h.frs);
        }
        com.baidu.tbadk.core.util.ai.k(this.clb, d.e.cp_bg_line_d);
        if (this.clo == null) {
            this.clo = this.cla.mRootView.findViewById(d.h.frs_list_content);
        }
        if (this.cly == null) {
            this.cly = (ObservedChangeLinearLayout) this.cla.mRootView.findViewById(d.h.navigation_bar_wrapperLayout);
            this.cly.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cla.mRootView.findViewById(d.h.view_navigation_bar);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cla.afK()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cln == null) {
            this.cln = this.cla.mRootView.findViewById(d.h.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b agH = aVar.agH();
            if (agH != null) {
                agH.aj(this.cln);
            }
        }
        if (this.clc == null) {
            this.clc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.clc.setOnClickListener(this.clm);
            this.mBackImageView = (ImageView) this.clc.findViewById(d.h.widget_navi_back_button);
        }
        if (this.cld == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.cla.getPageContext().getPageActivity(), d.f.ds24), 0);
            this.cld = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.cld.setLayoutParams(layoutParams);
            this.cld.setOnClickListener(this.clm);
            this.cle = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.cle.setLayoutParams(layoutParams);
            this.cle.setOnClickListener(this.clm);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cla.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.clj == null) {
            this.clj = (BdExpandListView) this.cla.mRootView.findViewById(d.h.frs_lv_thread);
        }
        this.clj.setScrollable(this.cla);
        this.clj.setFadingEdgeLength(0);
        this.clj.setOverScrollMode(2);
        this.clb.setBottomOrderView(this.clj);
        this.clj.setOnTouchListener(this.cla.aMU);
        this.clj.setDivider(null);
        this.clj.setPullRefresh(this.mPullView);
        if (z && this.clr == null) {
            this.clr = BdListViewHelper.a(this.cla.getActivity(), this.clj, BdListViewHelper.HeadType.DEFAULT);
        }
        this.clj.setDividerHeight(0);
        this.clj.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.clx != null) {
                    i.this.clx.aR(view);
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
        if (this.beu == null) {
            this.beu = new PbListView(this.cla.getPageContext().getPageActivity());
            this.beu.lj();
        }
        this.beu.m10do(d.e.cp_bg_line_c);
        this.clj.setOnSrollToBottomListener(this.cla);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.q(new q.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ago() {
                i.this.cla.afF();
            }

            @Override // com.baidu.tieba.tbadkCore.q.a
            public void agp() {
                if (i.this.clj != null) {
                    i.this.clj.setSelection(0);
                    if (i.this.clx != null) {
                        i.this.clx.a(i.this.ckR, i.this.bdb, false, true);
                    }
                }
            }
        }));
        boolean vT = com.baidu.tbadk.core.util.am.vR().vT();
        if (this.clk == null) {
            this.clk = aVar.a(this.cla, this.clj, vT);
        }
        ck(false);
        if (!z) {
            if (this.bFC == null) {
                this.bFC = new NoNetworkView(this.cla.getActivity());
                this.bFC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.cly.addView(this.bFC);
            }
            if (com.baidu.adp.lib.util.i.hf()) {
                this.bFC.setVisibility(8);
            } else {
                this.bFC.setVisibility(0);
            }
            this.bFC.onChangeSkinType(this.cla.yg(), TbadkCoreApplication.getInst().getSkinType());
        }
        afV();
        if (this.cls == null) {
            this.cls = aVar.c(this.cla, this.clb);
        }
        if (this.clt == null) {
            this.clt = aVar.b(this.cla, this.clb);
        }
        if (this.cbq == null) {
            this.cbq = this.cla.mRootView.findViewById(d.h.statebar_view);
        }
        if (this.clx == null) {
            this.clx = new com.baidu.tieba.play.l(this.cla.getPageContext(), this.clj);
        }
        this.clx.setUniqueId(this.cla.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.clr != null && this.clr.getLayoutParams() != null) {
            this.clr.getLayoutParams().height = i;
            this.clr.setLayoutParams(this.clr.getLayoutParams());
        }
    }

    public View afP() {
        return this.clr;
    }

    public com.baidu.tieba.play.l afQ() {
        return this.clx;
    }

    public com.baidu.tieba.frs.entelechy.b.c afR() {
        return this.clt;
    }

    public void eH(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.u.v(this.cla.afH().brL());
        if (this.cls != null) {
            this.cls.eH(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e afS() {
        return this.cls;
    }

    public void t(boolean z, boolean z2) {
        if (this.clt != null) {
            this.clt.t(z, z2);
        }
        if (this.cla.isAdded()) {
            if (z) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB);
                customMessage.setTag(this.cla.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, Boolean.valueOf(z2));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            CustomMessage customMessage2 = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB);
            customMessage2.setTag(this.cla.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, Boolean.valueOf(z2));
            customResponsedMessage2.setOrginalMessage(customMessage2);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
        }
    }

    public void afT() {
        if (this.clt != null) {
            this.clt.t(false, false);
        }
        this.cld.setVisibility(8);
        this.cle.setVisibility(8);
        eH(false);
        this.clj.setVisibility(8);
    }

    public void afU() {
        if (this.clt != null) {
            this.clt.t(true, false);
        }
        this.cld.setVisibility(0);
        this.cle.setVisibility(0);
        eH(true);
        this.clj.setVisibility(0);
    }

    public void eI(boolean z) {
        if (this.clt != null) {
            this.clt.eS(z);
        }
    }

    private void afV() {
        if (this.clu == null) {
            this.clu = (GifView) this.cla.mRootView.findViewById(d.h.gif_real_time);
            this.clv = (TbImageView) this.cla.mRootView.findViewById(d.h.tbimg_real_time);
            this.clv.setPageId(this.cla.getUniqueId());
            this.clu.setLayerType(1, null);
            this.clv.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View afW() {
        return this.clc;
    }

    public void c(NoNetworkView.a aVar) {
        this.bFF = aVar;
        if (this.bFC != null) {
            this.bFC.a(this.bFF);
        }
    }

    public void ck(boolean z) {
        this.ckZ = z;
        if (z) {
            if (this.clt != null) {
                this.clt.ahm();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.clj.getAdapter()).notifyDataSetChanged();
        if (this.clt != null) {
            this.clt.ahn();
        }
    }

    public void eJ(boolean z) {
        if (this.clt != null) {
            if (z) {
                t(true, true);
            } else {
                t(true, false);
            }
        }
    }

    public void eK(boolean z) {
        if (this.clt != null) {
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
        this.clj.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.clk.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.clk.setForumName(str);
        this.mForumName = str;
    }

    public void cH(boolean z) {
        this.clk.cH(z);
    }

    public void onDestroy() {
        if (this.clx != null) {
            this.clx.destroy();
        }
        this.clk.onDestory();
        this.clj.setOnSrollToBottomListener(null);
        this.clj.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.clA);
        if (this.caB != null) {
            this.caB.onDestroy();
        }
        this.clw.clear();
        if (this.cls != null) {
            this.cls.ahr();
        }
        if (this.cbq != null) {
            this.cbq.setBackgroundDrawable(null);
        }
    }

    public boolean afX() {
        if (this.cls != null) {
            return this.cls.afX();
        }
        return false;
    }

    public boolean afI() {
        return this.ckZ;
    }

    public void Nr() {
        this.clj.setVisibility(0);
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
            com.baidu.tbadk.core.h.oY().cx(str);
        }
    }

    public void afY() {
        if (this.clk != null) {
            this.clk.notifyDataSetChanged();
        }
    }

    public void XY() {
        if (this.clk instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.clk).XY();
        }
    }

    private void afZ() {
        if (this.cll == null && this.cla.getPageContext() != null) {
            String[] strArr = {this.cla.getPageContext().getPageActivity().getString(d.l.take_photo), this.cla.getPageContext().getPageActivity().getString(d.l.album)};
            this.cll = new com.baidu.tbadk.core.dialog.b(this.cla.getPageContext().getPageActivity());
            this.cll.cX(this.cla.getPageContext().getPageActivity().getString(d.l.operation));
            this.cll.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.cla.afJ();
                    } else if (i == 1 && i.this.cla.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ah.q(i.this.cla.getPageContext().getPageActivity());
                    }
                }
            });
            this.cll.d(this.cla.getPageContext());
        }
    }

    public void aga() {
        afZ();
        if (this.cll != null) {
            this.cll.tv();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tbadk.core.util.u.v(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.cla != null && this.cla.afk() != null && this.cla.afk().aiX() == 0) {
                kVar.iK(this.cla.afk().ajf());
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
        this.clk.b(arrayList, iVar);
        if (this.clx != null) {
            this.clx.a(this.ckR, this.bdb, this.clq, true);
        }
    }

    public BdTypeListView getListView() {
        return this.clj;
    }

    public void agb() {
        this.clk.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cla.getPageContext(), 1);
        aVar.a(this.clj);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cla.getForumName());
        hashMap.put("forum_id", this.cla.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.cls != null) {
            this.cls.ahs();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.cls != null) {
            this.cls.aht();
        }
    }

    public void release() {
        if (this.bFC != null && this.bFF != null) {
            this.bFC.b(this.bFF);
        }
    }

    public ImageView agc() {
        return this.cle;
    }

    public ImageView agd() {
        return this.cld;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cla, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cla.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.clv != null) {
            this.clv.invalidate();
        }
        if (this.clk != null) {
            this.clk.ahd();
            this.clk.notifyDataSetChanged();
        }
        this.cla.yg().getLayoutMode().ah(i == 1);
        this.cla.yg().getLayoutMode().t(this.clb);
        if (this.clb != null) {
            com.baidu.tbadk.core.util.ai.e(this.clb, d.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cla.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ai.cT(d.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.ai.e(this.cln, d.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.bFC != null) {
            this.bFC.onChangeSkinType(this.cla.getPageContext(), i);
        }
        if (this.beu != null) {
            this.beu.dp(i);
        }
        eN(false);
        if (this.clt != null) {
            this.clt.onChangeSkinType(i);
        }
        if (this.cls != null) {
            this.cls.onChangeSkinType(i);
        }
        if (this.cbq != null) {
            UtilHelper.setStatusBarBackground(this.cbq, i);
        }
        if (this.clx != null) {
            this.clx.a(this.ckR, this.bdb, this.clq, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
    }

    public void startPullRefresh() {
        this.clj.startPullRefresh();
    }

    public void age() {
        this.clj.completePullRefreshPostDelayed(2000L);
    }

    public boolean agf() {
        return this.clf != null && this.cli.getVisibility() == 0;
    }

    public void agg() {
        if (this.clf != null) {
            this.clg.setVisibility(0);
            this.cli.setVisibility(8);
            this.clh.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.clA, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bs bsVar) {
        if (this.clf == null) {
            this.clf = (ViewStub) this.cla.mRootView.findViewById(d.h.yule_game_egg_view_stub);
            this.clf.setVisibility(0);
            this.clg = (FrameLayout) this.cla.mRootView.findViewById(d.h.game_activity_egg_layout);
            this.clh = (TbImageView) this.cla.mRootView.findViewById(d.h.game_activity_egg);
            this.cli = (TbImageView) this.cla.mRootView.findViewById(d.h.game_activity_egg_s);
            this.clh.setPageId(this.cla.getUniqueId());
            this.cli.setPageId(this.cla.getUniqueId());
            this.clh.setDefaultBgResource(d.e.common_color_10022);
            this.clh.setDefaultResource(0);
            this.cli.setDefaultBgResource(d.e.common_color_10022);
            this.cli.setDefaultResource(0);
            this.clg.setOnClickListener(this.clm);
        }
        this.clg.setVisibility(0);
        String ti = bsVar.ti();
        String tj = bsVar.tj();
        this.clh.c(ti, 10, false);
        this.cli.c(tj, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.clA, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void agh() {
        if (this.clf != null) {
            this.clg.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q agi() {
        return this.clk;
    }

    public ViewGroup Wk() {
        return this.clb;
    }

    public View agj() {
        return this.clo;
    }

    public void agk() {
        if (r.Gz().GA()) {
            int lastVisiblePosition = this.clj.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.clj.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.clP != null) {
                        com.baidu.tbadk.l.l perfLog = mVar.clP.getPerfLog();
                        perfLog.fi(1000);
                        perfLog.aKb = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.clP.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.clP.wB();
                    }
                    if (mVar.clN != null && (mVar.clN instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.clN;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fi(1000);
                                perfLog2.aKb = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wB();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar afG() {
        return this.mNavigationBar;
    }

    public void Wq() {
        this.mHasMore = true;
        this.clj.setNextPage(this.beu);
        if (this.clp > 0) {
            this.beu.dq(this.clp);
        }
        this.beu.wX();
    }

    public void Ws() {
        this.mHasMore = false;
        this.clj.setNextPage(this.beu);
        if (this.clp > 0) {
            this.beu.dq(this.clp);
        }
        this.beu.wY();
        this.beu.setText(this.cla.getResources().getString(d.l.list_no_more));
    }

    public void XZ() {
        this.mHasMore = false;
        this.clj.setNextPage(null);
    }

    public boolean XP() {
        return this.beu.getView().getParent() != null && this.mHasMore;
    }

    public void iG(int i) {
        this.clp = i;
    }

    public void iH(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.caB == null) {
                    this.caB = new CommonTipView(this.cla.getActivity());
                }
                this.caB.setText(d.l.frs_login_tip);
                this.caB.a((FrameLayout) agj(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eL(boolean z) {
        if (this.clx != null) {
            if (z) {
                this.clx.hx(false);
                this.clx.aqz();
                return;
            }
            this.clx.hx(true);
            this.clx.a(this.ckR, this.bdb, this.clq, true);
        }
    }

    public void ao(int i, int i2) {
        if (this.clx != null) {
            this.clx.a(i, i2, this.clq, 1);
        }
    }

    public void ap(int i, int i2) {
        this.ckR = i;
        this.bdb = i2;
    }

    public void eM(boolean z) {
        this.clq = z;
    }

    public void agl() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.ai.j(this.mBackImageView, d.g.frs_star_navigation_bg);
        }
    }

    private void agm() {
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
        boolean i = com.baidu.tieba.frs.g.f.i(this.cla.afH());
        boolean h = com.baidu.tieba.frs.g.f.h(this.cla.afH());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.byj) {
                    this.byj = true;
                    com.baidu.tbadk.core.util.ai.b(this.mBackImageView, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.ai.b(this.cld, d.g.icon_sml_search_bg, d.g.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.ai.b(this.cle, d.g.btn_sml_more_bg, d.g.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.ai.j(this.mBackImageView, d.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.byj) {
                this.byj = false;
                com.baidu.tbadk.core.util.ai.b(this.mBackImageView, d.g.icon_return_bg_s, d.g.icon_return_bg);
                com.baidu.tbadk.core.util.ai.b(this.cld, d.g.icon_search_bg_s, d.g.icon_search_bg);
                com.baidu.tbadk.core.util.ai.b(this.cle, d.g.btn_more_selector_s, d.g.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        agm();
    }

    public void eO(boolean z) {
        if (!this.clj.bsf()) {
            this.clj.setStarForum(true);
            if (z && !this.cla.afK()) {
                this.mPullView = new com.baidu.tbadk.core.view.l(this.cla.getPageContext());
                this.mPullView.setTag(this.cla.getUniqueId());
                this.clj.setPullRefresh(this.mPullView);
            }
        }
    }

    public void iI(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void iJ(int i) {
        if (this.clj != null && this.clj.getChildCount() >= 0) {
            if (this.clj.getFirstVisiblePosition() > 8) {
                this.clj.setSelection(8);
            }
            this.clj.smoothScrollToPosition(i);
        }
    }

    public void agn() {
        a(this.clz, this.cla.afK());
        if (this.clk != null) {
            this.clk.reInit();
        }
    }
}
