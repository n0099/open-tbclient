package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d.a;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class ax {
    private PbListView aLK;
    private com.baidu.tieba.play.ac aLe;
    private View bHB;
    private View bHC;
    private View bHE;
    private com.baidu.tieba.frs.entelechy.b.e bHF;
    private com.baidu.tieba.frs.entelechy.b.c bHG;
    private GifView bHH;
    private TbImageView bHI;
    private HashSet<String> bHJ;
    private com.baidu.tieba.frs.view.v bHK;
    private int bHL;
    private int bHM;
    private a bHN;
    private ObservedChangeLinearLayout bHO;
    private FrsActivity bHh;
    private View bHj;
    private ViewStub bHk;
    private com.baidu.tieba.frs.entelechy.a.am bHp;
    private View bHr;
    private ImageView bHs;
    private TextView bHt;
    private View bHv;
    private View.OnClickListener bHz;
    private NoNetworkView bxs;
    private CommonTipView byN;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ad mPullView;
    private boolean bHg = false;
    private NoPressedRelativeLayout bHi = null;
    private FrameLayout bHl = null;
    private TbImageView bHm = null;
    private TbImageView bHn = null;
    private BdExpandListView bHo = null;
    private com.baidu.tbadk.core.dialog.c bHq = null;
    private boolean bHu = false;
    private TextView bHw = null;
    private ImageView bHx = null;
    private com.baidu.tbadk.core.dialog.c bHy = null;
    private c.b bHA = null;
    private NoNetworkView.a bEW = null;
    private boolean mHasMore = true;
    private int bHD = 0;
    private boolean aLg = false;
    private int aLi = 0;
    private int aLh = 0;
    private View bAe = null;
    private boolean bdP = true;
    private Runnable bHP = new ay(this);

    public ObservedChangeLinearLayout Yl() {
        return this.bHO;
    }

    public View Ym() {
        return this.bAe;
    }

    public ax(FrsActivity frsActivity, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.bHh = null;
        this.bHz = null;
        this.bHh = frsActivity;
        this.bHz = onClickListener;
        a(aVar);
        this.bHJ = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.mPullView = new com.baidu.tbadk.core.view.ad(this.bHh.getPageContext());
        this.bHi = (NoPressedRelativeLayout) this.bHh.findViewById(r.h.frs);
        this.bHC = this.bHh.findViewById(r.h.frs_list_content);
        this.mNavigationBar = (NavigationBar) this.bHh.findViewById(r.h.view_navigation_bar);
        this.bHB = this.bHh.findViewById(r.h.frs_navi_line);
        b ZE = aVar.ZE();
        if (ZE != null) {
            ZE.ai(this.bHB);
        }
        this.bHj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bHj.setOnClickListener(this.bHz);
        this.mBackImageView = (ImageView) this.bHj.findViewById(r.h.widget_navi_back_button);
        this.bHr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.frs_item_drifting_bottle_layout, (View.OnClickListener) null);
        this.bHs = (ImageView) this.bHr.findViewById(r.h.frs_top_drifting_bottle);
        this.bHt = (TextView) this.bHr.findViewById(r.h.frs_drifting_bottle_mes_text);
        this.bHt.setText("1");
        this.bHr.setVisibility(8);
        this.bHs.setOnClickListener(this.bHz);
        this.bHv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.nb_item_frs_more, (View.OnClickListener) null);
        this.bHx = (ImageView) this.bHv.findViewById(r.h.frs_top_more);
        this.bHx.setContentDescription(this.bHh.getResources().getString(r.l.more));
        this.bHL = r.g.btn_more_selector_s;
        this.bHM = r.g.btn_more_selector;
        this.bHw = (TextView) this.bHv.findViewById(r.h.frs_more_mes_text);
        this.bHx.setOnClickListener(this.bHz);
        dJ(false);
        this.bHo = (BdExpandListView) this.bHh.findViewById(r.h.frs_lv_thread);
        this.bHo.setFadingEdgeLength(0);
        this.bHo.setOverScrollMode(2);
        this.bHi.setBottomOrderView(this.bHo);
        this.bHo.setOnTouchListener(this.bHh.aIu);
        this.bHo.setDivider(null);
        if (ZE != null) {
            this.bHE = ZE.b(this.bHh.getActivity(), this.bHo);
        }
        this.bHo.setDividerHeight(0);
        this.bHo.setRecyclerListener(new az(this));
        this.aLK = new PbListView(this.bHh.getPageContext().getPageActivity());
        this.aLK.kg();
        this.aLK.dk(r.e.cp_bg_line_c);
        this.bHo.setOnSrollToBottomListener(this.bHh);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.y(new ba(this)));
        this.bHp = aVar.a(this.bHh, this.bHo, com.baidu.tbadk.core.util.au.vg().vi());
        cf(false);
        this.bxs = (NoNetworkView) this.bHh.findViewById(r.h.view_no_network);
        Yo();
        this.bHF = aVar.c(this.bHh, this.bHi);
        this.bHG = aVar.b(this.bHh, this.bHi);
        this.bHO = (ObservedChangeLinearLayout) this.bHh.findViewById(r.h.navigation_bar_wrapperLayout);
        this.bHO.setOnSizeChangeListener(new bb(this));
        this.bAe = this.bHh.findViewById(r.h.statebar_view);
        this.aLe = new com.baidu.tieba.play.ac(this.bHh.getPageContext(), this.bHo);
        this.bHo.setPullRefresh(this.mPullView);
    }

    public com.baidu.tieba.play.ac JX() {
        return this.aLe;
    }

    public com.baidu.tieba.frs.entelechy.b.c Yn() {
        return this.bHG;
    }

    public void dB(boolean z) {
        if (this.bHF != null) {
            this.bHF.dB(z);
        }
    }

    public void o(boolean z, boolean z2) {
        if (this.bHG != null) {
            this.bHG.o(z, z2);
        }
    }

    public void dC(boolean z) {
        if (this.bHG != null) {
            this.bHG.dU(z);
        }
    }

    private void Yo() {
        this.bHH = (GifView) this.bHh.findViewById(r.h.gif_real_time);
        this.bHI = (TbImageView) this.bHh.findViewById(r.h.tbimg_real_time);
        this.bHH.setLayerType(1, null);
        this.bHI.setLayerType(1, null);
    }

    public com.baidu.tieba.frs.view.v Yp() {
        return this.bHK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Yq() {
        return this.bHx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Yr() {
        return this.bHv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Ys() {
        return this.bHs;
    }

    public TextView Yt() {
        return this.bHt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Yu() {
        return this.bHr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Yv() {
        return this.bHj;
    }

    public void h(NoNetworkView.a aVar) {
        this.bEW = aVar;
        if (this.bxs != null) {
            this.bxs.a(this.bEW);
        }
    }

    public void cf(boolean z) {
        this.bHg = z;
        if (z) {
            if (this.bHG != null) {
                this.bHG.aad();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bHo.getAdapter()).notifyDataSetChanged();
        if (this.bHG != null) {
            this.bHG.aae();
        }
    }

    public void dD(boolean z) {
        if (this.bHG != null) {
            if (z) {
                o(true, true);
            } else {
                o(true, false);
            }
        }
    }

    public void dE(boolean z) {
        if (this.bHG != null) {
            if (z) {
                o(false, true);
            } else {
                o(false, false);
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.bh bhVar, boolean z) {
        String string = this.bHh.getPageContext().getPageActivity().getString(r.l.view);
        String string2 = this.bHh.getPageContext().getPageActivity().getString(r.l.view_host);
        String string3 = this.bHh.getPageContext().getPageActivity().getString(r.l.view_reverse);
        this.bHy = new com.baidu.tbadk.core.dialog.c(this.bHh.getPageContext().getPageActivity());
        this.bHy.cd(r.l.operation);
        if (z) {
            this.bHy.a(new String[]{string, string3}, this.bHA);
        } else {
            this.bHy.a(new String[]{string, string2, string3}, this.bHA);
        }
        this.bHy.d(this.bHh.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bHo instanceof BdExpandListView) {
            this.bHo.setPersonListRefreshListener(aVar);
        }
    }

    public void a(aa.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(aa.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(aa.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bHo.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.w wVar) {
        this.bHp.setOnAdapterItemClickListener(wVar);
    }

    public void setOnAdapterItemLongClickListener(com.baidu.adp.widget.ListView.x xVar) {
        this.bHp.setOnAdapterItemLongClickListener(xVar);
    }

    public void setForumName(String str) {
        this.bHp.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bHA = bVar;
    }

    public void Yw() {
        if (this.bHy != null) {
            this.bHy.sY();
        }
    }

    public void onDestroy() {
        if (this.aLe != null) {
            this.aLe.destroy();
        }
        this.bHp.onDestory();
        this.bHo.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bHP);
        if (this.byN != null) {
            this.byN.onDestroy();
        }
        this.bHJ.clear();
        if (this.bHF != null) {
            this.bHF.aai();
        }
        if (this.bAe != null) {
            this.bAe.setBackgroundDrawable(null);
        }
        if (this.bHN != null) {
            this.bHN.Tg();
        }
    }

    public boolean Yx() {
        if (this.bHF != null) {
            return this.bHF.Yx();
        }
        return false;
    }

    public boolean XX() {
        return this.bHg;
    }

    public void JU() {
        this.bHo.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bHh.getActivity().getString(r.l.forum));
        com.baidu.tbadk.core.l.oC().cd(str);
    }

    public void Yy() {
        if (this.bHp != null) {
            this.bHp.notifyDataSetChanged();
        }
    }

    private void Yz() {
        if (this.bHq == null) {
            String[] strArr = {this.bHh.getPageContext().getPageActivity().getString(r.l.take_photo), this.bHh.getPageContext().getPageActivity().getString(r.l.album)};
            this.bHq = new com.baidu.tbadk.core.dialog.c(this.bHh.getPageContext().getPageActivity());
            this.bHq.cF(this.bHh.getPageContext().getPageActivity().getString(r.l.operation));
            this.bHq.a(strArr, new bc(this));
            this.bHq.d(this.bHh.getPageContext());
        }
    }

    public void YA() {
        Yz();
        if (this.bHq != null) {
            this.bHq.sY();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tbadk.core.util.w.s(arrayList)) {
            be beVar = new be();
            arrayList = new ArrayList<>();
            arrayList.add(beVar);
            if (this.bHh != null && this.bHh.Xy() != null && this.bHh.Xy().abS() == 0) {
                beVar.hU(this.bHh.Xy().aca());
            }
        }
        this.bHp.b(arrayList, nVar);
        if (this.aLe != null) {
            this.aLe.a(this.aLi, this.aLh, this.aLg, true);
        }
    }

    public BdTypeListView Iv() {
        return this.bHo;
    }

    public void YB() {
        this.bHp.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bHh.getPageContext(), 1);
        aVar.a(this.bHo);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.bHh.getForumName());
        hashMap.put("forum_id", this.bHh.getForumId());
        aVar.setParams(hashMap);
        aVar.J(wVar);
        aVar.cd(this.bHh.XM());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.bHF != null) {
            this.bHF.aaj();
        }
    }

    public void onResume() {
        if (this.bHF != null) {
            this.bHF.aak();
        }
    }

    public void release() {
        if (this.bxs != null && this.bEW != null) {
            this.bxs.b(this.bEW);
        }
    }

    public void YC() {
        this.bHw.setVisibility(8);
    }

    public void a(bo boVar) {
        long j;
        if (!FrsActivityStatic.bGR || boVar == null) {
            this.bHw.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bGS) {
            j = boVar.Zb() - boVar.Zc();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yQ().zk()) {
                j -= boVar.Zd();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bHx.getVisibility() == 0) {
            this.bHw.setVisibility(0);
            if (j < 10) {
                this.bHw.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.ap.j((View) this.bHw, r.g.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bHw.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.ap.j((View) this.bHw, r.g.icon_news_head_prompt_two);
                return;
            } else {
                this.bHw.setText("   ");
                com.baidu.tbadk.core.util.ap.j((View) this.bHw, r.g.icon_news_head_prompt_more);
                return;
            }
        }
        this.bHw.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bHh.getPageContext(), 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bHh.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.bHI != null) {
            this.bHI.invalidate();
        }
        if (this.bHp != null) {
            this.bHp.ZV();
            this.bHp.notifyDataSetChanged();
        }
        this.bHh.XN();
        this.bHh.getLayoutMode().ai(i == 1);
        this.bHh.getLayoutMode().v(this.bHi);
        if (this.bHi != null) {
            com.baidu.tbadk.core.util.ap.e(this.bHi, r.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bHh.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ap.cQ(r.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.ap.e(this.bHB, r.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ap.k(this.mNavigationBar.getBottomLine(), r.e.cp_bg_line_b);
        }
        if (this.bxs != null) {
            this.bxs.onChangeSkinType(this.bHh.getPageContext(), i);
        }
        if (this.aLK != null) {
            this.aLK.dl(i);
        }
        dJ(false);
        if (this.bHG != null) {
            this.bHG.onChangeSkinType(i);
        }
        if (this.bHF != null) {
            this.bHF.onChangeSkinType(i);
        }
        if (this.bAe != null) {
            UtilHelper.setStatusBarBackground(this.bAe, i);
        }
        if (this.aLe != null) {
            this.aLe.a(this.aLi, this.aLh, this.aLg, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
        if (this.bHt != null) {
            com.baidu.tbadk.core.util.ap.j((View) this.bHt, r.g.icon_news_head_prompt_one);
        }
    }

    public void startPullRefresh() {
        this.bHo.startPullRefresh();
    }

    public void YD() {
        this.bHo.completePullRefreshPostDelayed(2000L);
    }

    public boolean YE() {
        return this.bHk != null && this.bHn.getVisibility() == 0;
    }

    public void YF() {
        if (this.bHk != null) {
            this.bHl.setVisibility(0);
            this.bHn.setVisibility(8);
            this.bHm.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bHP, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bp bpVar) {
        if (this.bHk == null) {
            this.bHk = (ViewStub) this.bHh.findViewById(r.h.yule_game_egg_view_stub);
            this.bHk.setVisibility(0);
            this.bHl = (FrameLayout) this.bHh.findViewById(r.h.game_activity_egg_layout);
            this.bHm = (TbImageView) this.bHh.findViewById(r.h.game_activity_egg);
            this.bHn = (TbImageView) this.bHh.findViewById(r.h.game_activity_egg_s);
            this.bHm.setDefaultBgResource(r.e.common_color_10022);
            this.bHm.setDefaultResource(0);
            this.bHn.setDefaultBgResource(r.e.common_color_10022);
            this.bHn.setDefaultResource(0);
            this.bHl.setOnClickListener(this.bHz);
        }
        this.bHl.setVisibility(0);
        String sL = bpVar.sL();
        String sM = bpVar.sM();
        this.bHm.c(sL, 10, false);
        this.bHn.c(sM, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bHP, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void YG() {
        if (this.bHk != null) {
            this.bHl.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.am YH() {
        return this.bHp;
    }

    public ViewGroup YI() {
        return this.bHi;
    }

    public View YJ() {
        return this.bHC;
    }

    public void dF(boolean z) {
        this.bHv.setVisibility(z ? 0 : 8);
    }

    public void dG(boolean z) {
        if (this.bHG != null) {
            this.bHG.dV(z);
        }
    }

    public void YK() {
        if (com.baidu.tbadk.performanceLog.aa.FO().FP()) {
            int lastVisiblePosition = this.bHo.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bHo.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof bg)) {
                    bg bgVar = (bg) childAt.getTag();
                    if (bgVar.bIe != null) {
                        com.baidu.tbadk.performanceLog.u perfLog = bgVar.bIe.getPerfLog();
                        perfLog.fh(1000);
                        perfLog.aAO = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            bgVar.bIe.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        bgVar.bIe.vQ();
                    }
                    if (bgVar.bIc != null && (bgVar.bIc instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = bgVar.bIc;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fh(1000);
                                perfLog2.aAO = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.vQ();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar Jo() {
        return this.mNavigationBar;
    }

    public void YL() {
        this.mHasMore = true;
        this.bHo.setNextPage(this.aLK);
        this.aLK.wk();
    }

    public void Jv() {
        this.mHasMore = false;
        if (this.bHD > 0) {
            this.aLK.dm(this.bHD);
        }
        this.bHo.setNextPage(this.aLK);
        this.aLK.wl();
        this.aLK.setText(this.bHh.getResources().getString(r.l.list_no_more));
    }

    public void SI() {
        this.mHasMore = false;
        this.bHo.setNextPage(null);
        this.aLK.wo();
    }

    public void YM() {
        this.aLK.wo();
    }

    public boolean Sx() {
        return this.aLK.getView().getParent() != null && this.mHasMore;
    }

    public void hR(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("frs_login_tip", true)) {
                if (this.byN == null) {
                    this.byN = new CommonTipView(this.bHh.getActivity());
                }
                this.byN.setText(r.l.frs_login_tip);
                this.byN.a((FrameLayout) YJ(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void dH(boolean z) {
        if (this.aLe != null) {
            if (z) {
                this.aLe.gY(false);
                this.aLe.amY();
                return;
            }
            this.aLe.gY(true);
            this.aLe.a(this.aLi, this.aLh, this.aLg, true);
        }
    }

    public void ab(int i, int i2) {
        if (this.aLe != null) {
            this.aLe.a(i, i2, this.aLg, 1);
        }
    }

    public void ac(int i, int i2) {
        this.aLi = i;
        this.aLh = i2;
    }

    public void dI(boolean z) {
        this.aLg = z;
    }

    public void YN() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(r.g.btn_sml_back_selector_s, r.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.ap.j(this.mBackImageView, r.g.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.ap.j(this.bHs, r.g.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.ap.j(this.bHx, r.g.frs_star_navigation_bg);
        }
        int i = r.g.btn_sml_more_selector_s;
        this.bHM = i;
        this.bHL = i;
        com.baidu.tbadk.core.util.ap.b(this.bHx, this.bHL, this.bHM);
        if (this.bHu) {
            com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.d_btn_newbottle_selector, r.g.d_btn_newbottle_selector);
        } else {
            com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.d_btn_bottle_selector, r.g.d_btn_bottle_selector);
        }
    }

    public void YO() {
        dJ(true);
    }

    private void YP() {
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
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.bHx != null) {
                    this.bHx.setAlpha(f);
                }
                if (this.bHs != null) {
                    this.bHs.setAlpha(f);
                }
            }
        }
    }

    private void dJ(boolean z) {
        boolean l = com.baidu.tieba.frs.f.u.l(this.bHh.XW());
        boolean k = com.baidu.tieba.frs.f.u.k(this.bHh.XW());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bdP) {
                    this.bdP = true;
                    com.baidu.tbadk.core.util.ap.b(this.mBackImageView, r.g.btn_sml_back_selector_s, r.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.ap.b(this.bHx, r.g.btn_sml_more_selector_s, r.g.btn_sml_more_selector_s);
                    if (this.bHu) {
                        com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.d_btn_newbottle_selector, r.g.d_btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.d_btn_bottle_selector, r.g.d_btn_bottle_selector);
                    }
                    if (l && !k) {
                        com.baidu.tbadk.core.util.ap.j(this.mBackImageView, r.g.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.ap.j(this.bHx, r.g.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.ap.j(this.bHs, r.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bdP) {
                this.bdP = false;
                com.baidu.tbadk.core.util.ap.b(this.mBackImageView, r.g.icon_return_bg_s, r.g.icon_return_bg);
                if (l) {
                    com.baidu.tbadk.core.util.ap.b(this.bHx, r.g.btn_more_selector_s, r.g.btn_more_selector);
                    if (this.bHu) {
                        com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.btn_newbottle_selector, r.g.btn_newbottle_selector_w);
                    } else {
                        com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.btn_bottle_selector, r.g.btn_bottle_selector_w);
                    }
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bHx.setBackgroundDrawable(null);
                    this.bHs.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.ap.b(this.bHx, this.bHL, this.bHM);
                    if (this.bHu) {
                        com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.btn_newbottle_selector, r.g.btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.btn_bottle_selector, r.g.btn_bottle_selector);
                    }
                }
            }
        }
        YP();
    }

    public void YQ() {
        if (!this.bHo.bgS()) {
            this.bHo.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.ad(this.bHh.getPageContext());
            this.mPullView.setTag(this.bHh.getUniqueId());
            this.bHo.setPullRefresh(this.mPullView);
        }
    }

    public void YR() {
        this.bHo.setStarForum(false);
        this.bHo.setPullRefresh(null);
    }

    public void dK(boolean z) {
        this.bHu = z;
    }

    public boolean YS() {
        return this.bHu;
    }

    public void YT() {
        if (this.bHN != null) {
            this.bHN.Tg();
        }
    }

    public void YU() {
        if (this.bHh == null || this.bHh.XW() == null || !this.bHh.XW().isShowDriftingBottle() || com.baidu.adp.lib.b.e.dL().ac("android_bottle_enable") == 0 || !TbadkCoreApplication.isLogin()) {
            this.bHr.setVisibility(8);
            return;
        }
        if (this.bHN == null) {
            this.bHN = new a(this.bHh.getPageContext(), this.bHs);
        }
        this.bHN.aC(this.bHh.getPageContext().getString(r.l.frs_bottle_tip), "frs_show_bottle_guide_tips");
        this.bHr.setVisibility(0);
        long j = com.baidu.tbadk.core.sharedPref.b.tQ().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L);
        long bgt = this.bHh.XW().bgt();
        this.bHu = j != bgt;
        if (bgt == 0) {
            this.bHu = false;
        }
        if (this.bHu) {
            String str = "";
            if (this.bHh.XW().getUserData() != null && !StringUtils.isNull(this.bHh.XW().getUserData().getUserId())) {
                str = this.bHh.XW().getUserData().getUserId();
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11945").ab(SapiAccountManager.SESSION_UID, str).g("tid", this.bHh.XW().bgt()));
            if (this.bHh.XM()) {
                com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.btn_newbottle_selector, r.g.btn_newbottle_selector);
            } else {
                com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.d_btn_newbottle_selector, r.g.d_btn_newbottle_selector);
            }
            com.baidu.tbadk.core.util.ap.j((View) this.bHt, r.g.icon_news_head_prompt_one);
            this.bHt.setVisibility(0);
            return;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11943"));
        if (this.bHh.XM()) {
            com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.btn_bottle_selector, r.g.btn_bottle_selector);
        } else {
            com.baidu.tbadk.core.util.ap.b(this.bHs, r.g.d_btn_bottle_selector, r.g.d_btn_bottle_selector);
        }
        this.bHt.setVisibility(4);
    }

    public void hS(int i) {
        if (Iv() != null && Iv().getChildAt(0) != null) {
            Iv().setSelectionFromTop(Iv().getFirstVisiblePosition(), Iv().getChildAt(0).getTop() - i);
        }
    }

    public void hT(int i) {
        if (this.bHo != null && this.bHo.getChildCount() >= 0) {
            if (this.bHo.getFirstVisiblePosition() > 8) {
                this.bHo.setSelection(8);
            }
            this.bHo.smoothScrollToPosition(i);
        }
    }
}
