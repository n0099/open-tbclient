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
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d.a;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class ax {
    private com.baidu.tieba.play.ac aQP;
    private PbListView aRw;
    private NoNetworkView bEy;
    private CommonTipView bFT;
    private View bOA;
    private ImageView bOB;
    private TextView bOC;
    private View bOE;
    private View.OnClickListener bOI;
    private View bOK;
    private View bOL;
    private View bON;
    private com.baidu.tieba.frs.entelechy.b.e bOO;
    private com.baidu.tieba.frs.entelechy.b.c bOP;
    private GifView bOQ;
    private TbImageView bOR;
    private HashSet<String> bOS;
    private com.baidu.tieba.frs.view.v bOT;
    private int bOU;
    private int bOV;
    private a bOW;
    private ObservedChangeLinearLayout bOX;
    private FrsActivity bOq;
    private View bOs;
    private ViewStub bOt;
    private com.baidu.tieba.frs.entelechy.a.am bOy;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ae mPullView;
    private boolean bOp = false;
    private NoPressedRelativeLayout bOr = null;
    private FrameLayout bOu = null;
    private TbImageView bOv = null;
    private TbImageView bOw = null;
    private BdExpandListView bOx = null;
    private com.baidu.tbadk.core.dialog.c bOz = null;
    private boolean bOD = false;
    private TextView bOF = null;
    private ImageView bOG = null;
    private com.baidu.tbadk.core.dialog.c bOH = null;
    private c.b bOJ = null;
    private NoNetworkView.a bMe = null;
    private boolean mHasMore = true;
    private int bOM = 0;
    private boolean aQR = false;
    private int aQT = 0;
    private int aQS = 0;
    private View bHk = null;
    private boolean bkC = true;
    private Runnable bOY = new ay(this);

    public ObservedChangeLinearLayout Zk() {
        return this.bOX;
    }

    public View Zl() {
        return this.bHk;
    }

    public ax(FrsActivity frsActivity, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.bOq = null;
        this.bOI = null;
        this.bOq = frsActivity;
        this.bOI = onClickListener;
        a(aVar);
        this.bOS = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.bOq.getPageContext());
        this.bOr = (NoPressedRelativeLayout) this.bOq.findViewById(w.h.frs);
        this.bOL = this.bOq.findViewById(w.h.frs_list_content);
        this.mNavigationBar = (NavigationBar) this.bOq.findViewById(w.h.view_navigation_bar);
        this.bOK = this.bOq.findViewById(w.h.frs_navi_line);
        b aaB = aVar.aaB();
        if (aaB != null) {
            aaB.ag(this.bOK);
        }
        this.bOs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bOs.setOnClickListener(this.bOI);
        this.mBackImageView = (ImageView) this.bOs.findViewById(w.h.widget_navi_back_button);
        this.bOA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.frs_item_drifting_bottle_layout, (View.OnClickListener) null);
        this.bOB = (ImageView) this.bOA.findViewById(w.h.frs_top_drifting_bottle);
        this.bOC = (TextView) this.bOA.findViewById(w.h.frs_drifting_bottle_mes_text);
        this.bOC.setText("1");
        this.bOA.setVisibility(8);
        this.bOB.setOnClickListener(this.bOI);
        this.bOE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_frs_more, (View.OnClickListener) null);
        this.bOG = (ImageView) this.bOE.findViewById(w.h.frs_top_more);
        this.bOG.setContentDescription(this.bOq.getResources().getString(w.l.more));
        this.bOU = w.g.btn_more_selector_s;
        this.bOV = w.g.btn_more_selector;
        this.bOF = (TextView) this.bOE.findViewById(w.h.frs_more_mes_text);
        this.bOG.setOnClickListener(this.bOI);
        dJ(false);
        this.bOx = (BdExpandListView) this.bOq.findViewById(w.h.frs_lv_thread);
        this.bOx.setFadingEdgeLength(0);
        this.bOx.setOverScrollMode(2);
        this.bOr.setBottomOrderView(this.bOx);
        this.bOx.setOnTouchListener(this.bOq.aNR);
        this.bOx.setDivider(null);
        if (aaB != null) {
            this.bON = aaB.b(this.bOq.getActivity(), this.bOx);
        }
        this.bOx.setDividerHeight(0);
        this.bOx.setRecyclerListener(new az(this));
        this.aRw = new PbListView(this.bOq.getPageContext().getPageActivity());
        this.aRw.la();
        this.aRw.dg(w.e.cp_bg_line_c);
        this.bOx.setOnSrollToBottomListener(this.bOq);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.x(new ba(this)));
        this.bOy = aVar.a(this.bOq, this.bOx, com.baidu.tbadk.core.util.av.vD().vF());
        ce(false);
        this.bEy = (NoNetworkView) this.bOq.findViewById(w.h.view_no_network);
        Zn();
        this.bOO = aVar.c(this.bOq, this.bOr);
        this.bOP = aVar.b(this.bOq, this.bOr);
        this.bOX = (ObservedChangeLinearLayout) this.bOq.findViewById(w.h.navigation_bar_wrapperLayout);
        this.bOX.setOnSizeChangeListener(new bb(this));
        this.bHk = this.bOq.findViewById(w.h.statebar_view);
        this.aQP = new com.baidu.tieba.play.ac(this.bOq.getPageContext(), this.bOx);
        this.bOx.setPullRefresh(this.mPullView);
    }

    public com.baidu.tieba.play.ac KC() {
        return this.aQP;
    }

    public com.baidu.tieba.frs.entelechy.b.c Zm() {
        return this.bOP;
    }

    public void dB(boolean z) {
        if (this.bOO != null) {
            this.bOO.dB(z);
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.bOP != null) {
            this.bOP.n(z, z2);
        }
    }

    public void dC(boolean z) {
        if (this.bOP != null) {
            this.bOP.dU(z);
        }
    }

    private void Zn() {
        this.bOQ = (GifView) this.bOq.findViewById(w.h.gif_real_time);
        this.bOR = (TbImageView) this.bOq.findViewById(w.h.tbimg_real_time);
        this.bOQ.setLayerType(1, null);
        this.bOR.setLayerType(1, null);
    }

    public com.baidu.tieba.frs.view.v Zo() {
        return this.bOT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Zp() {
        return this.bOG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Zq() {
        return this.bOE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Zr() {
        return this.bOB;
    }

    public TextView Zs() {
        return this.bOC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Zt() {
        return this.bOA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Zu() {
        return this.bOs;
    }

    public void h(NoNetworkView.a aVar) {
        this.bMe = aVar;
        if (this.bEy != null) {
            this.bEy.a(this.bMe);
        }
    }

    public void ce(boolean z) {
        this.bOp = z;
        if (z) {
            if (this.bOP != null) {
                this.bOP.aba();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bOx.getAdapter()).notifyDataSetChanged();
        if (this.bOP != null) {
            this.bOP.abb();
        }
    }

    public void dD(boolean z) {
        if (this.bOP != null) {
            if (z) {
                n(true, true);
            } else {
                n(true, false);
            }
        }
    }

    public void dE(boolean z) {
        if (this.bOP != null) {
            if (z) {
                n(false, true);
            } else {
                n(false, false);
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.bj bjVar, boolean z) {
        String string = this.bOq.getPageContext().getPageActivity().getString(w.l.view);
        String string2 = this.bOq.getPageContext().getPageActivity().getString(w.l.view_host);
        String string3 = this.bOq.getPageContext().getPageActivity().getString(w.l.view_reverse);
        this.bOH = new com.baidu.tbadk.core.dialog.c(this.bOq.getPageContext().getPageActivity());
        this.bOH.bZ(w.l.operation);
        if (z) {
            this.bOH.a(new String[]{string, string3}, this.bOJ);
        } else {
            this.bOH.a(new String[]{string, string2, string3}, this.bOJ);
        }
        this.bOH.d(this.bOq.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bOx instanceof BdExpandListView) {
            this.bOx.setPersonListRefreshListener(aVar);
        }
    }

    public void a(ab.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(ab.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(ab.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bOx.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.w wVar) {
        this.bOy.setOnAdapterItemClickListener(wVar);
    }

    public void setOnAdapterItemLongClickListener(com.baidu.adp.widget.ListView.x xVar) {
        this.bOy.setOnAdapterItemLongClickListener(xVar);
    }

    public void setForumName(String str) {
        this.bOy.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bOJ = bVar;
    }

    public void Zv() {
        if (this.bOH != null) {
            this.bOH.tv();
        }
    }

    public void onDestroy() {
        if (this.aQP != null) {
            this.aQP.destroy();
        }
        this.bOy.onDestory();
        this.bOx.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bOY);
        if (this.bFT != null) {
            this.bFT.onDestroy();
        }
        this.bOS.clear();
        if (this.bOO != null) {
            this.bOO.abf();
        }
        if (this.bHk != null) {
            this.bHk.setBackgroundDrawable(null);
        }
        if (this.bOW != null) {
            this.bOW.Uj();
        }
    }

    public boolean Zw() {
        if (this.bOO != null) {
            return this.bOO.Zw();
        }
        return false;
    }

    public boolean YW() {
        return this.bOp;
    }

    public void Kz() {
        this.bOx.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bOq.getActivity().getString(w.l.forum));
        com.baidu.tbadk.core.l.oQ().bW(str);
    }

    public void Zx() {
        if (this.bOy != null) {
            this.bOy.notifyDataSetChanged();
        }
    }

    private void Zy() {
        if (this.bOz == null) {
            String[] strArr = {this.bOq.getPageContext().getPageActivity().getString(w.l.take_photo), this.bOq.getPageContext().getPageActivity().getString(w.l.album)};
            this.bOz = new com.baidu.tbadk.core.dialog.c(this.bOq.getPageContext().getPageActivity());
            this.bOz.cy(this.bOq.getPageContext().getPageActivity().getString(w.l.operation));
            this.bOz.a(strArr, new bc(this));
            this.bOz.d(this.bOq.getPageContext());
        }
    }

    public void Zz() {
        Zy();
        if (this.bOz != null) {
            this.bOz.tv();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tbadk.core.util.x.q(arrayList)) {
            be beVar = new be();
            arrayList = new ArrayList<>();
            arrayList.add(beVar);
            if (this.bOq != null && this.bOq.Yx() != null && this.bOq.Yx().acP() == 0) {
                beVar.hQ(this.bOq.Yx().acX());
            }
        }
        if (com.baidu.tbadk.core.util.x.p(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
                if (vVar instanceof com.baidu.tbadk.core.data.bj) {
                    ((com.baidu.tbadk.core.data.bj) vVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.bOy.b(arrayList, nVar);
        if (this.aQP != null) {
            this.aQP.a(this.aQT, this.aQS, this.aQR, true);
        }
    }

    public BdTypeListView getListView() {
        return this.bOx;
    }

    public void ZA() {
        this.bOy.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bOq.getPageContext(), 1);
        aVar.a(this.bOx);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.bOq.getForumName());
        hashMap.put("forum_id", this.bOq.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        aVar.cc(this.bOq.YL());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.bOO != null) {
            this.bOO.abg();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.bOO != null) {
            this.bOO.abh();
        }
    }

    public void release() {
        if (this.bEy != null && this.bMe != null) {
            this.bEy.b(this.bMe);
        }
    }

    public void ZB() {
        this.bOF.setVisibility(8);
    }

    public void a(bo boVar) {
        long j;
        if (!FrsActivityStatic.bOa || boVar == null) {
            this.bOF.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bOb) {
            j = boVar.aaa() - boVar.aab();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zB()) {
                j -= boVar.aac();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bOG.getVisibility() == 0) {
            this.bOF.setVisibility(0);
            if (j < 10) {
                this.bOF.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.aq.j(this.bOF, w.g.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bOF.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.aq.j(this.bOF, w.g.icon_news_head_prompt_two);
                return;
            } else {
                this.bOF.setText("   ");
                com.baidu.tbadk.core.util.aq.j(this.bOF, w.g.icon_news_head_prompt_more);
                return;
            }
        }
        this.bOF.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bOq.getPageContext(), 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bOq.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.bOR != null) {
            this.bOR.invalidate();
        }
        if (this.bOy != null) {
            this.bOy.aaS();
            this.bOy.notifyDataSetChanged();
        }
        this.bOq.YM();
        this.bOq.getLayoutMode().ah(i == 1);
        this.bOq.getLayoutMode().t(this.bOr);
        if (this.bOr != null) {
            com.baidu.tbadk.core.util.aq.e(this.bOr, w.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bOq.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cM(w.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aq.e(this.bOK, w.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aq.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        }
        if (this.bEy != null) {
            this.bEy.onChangeSkinType(this.bOq.getPageContext(), i);
        }
        if (this.aRw != null) {
            this.aRw.dh(i);
        }
        dJ(false);
        if (this.bOP != null) {
            this.bOP.onChangeSkinType(i);
        }
        if (this.bOO != null) {
            this.bOO.onChangeSkinType(i);
        }
        if (this.bHk != null) {
            UtilHelper.setStatusBarBackground(this.bHk, i);
        }
        if (this.aQP != null) {
            this.aQP.a(this.aQT, this.aQS, this.aQR, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.bOC != null) {
            com.baidu.tbadk.core.util.aq.j(this.bOC, w.g.icon_news_head_prompt_one);
        }
    }

    public void startPullRefresh() {
        this.bOx.startPullRefresh();
    }

    public void ZC() {
        this.bOx.completePullRefreshPostDelayed(2000L);
    }

    public boolean ZD() {
        return this.bOt != null && this.bOw.getVisibility() == 0;
    }

    public void ZE() {
        if (this.bOt != null) {
            this.bOu.setVisibility(0);
            this.bOw.setVisibility(8);
            this.bOv.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bOY, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.br brVar) {
        if (this.bOt == null) {
            this.bOt = (ViewStub) this.bOq.findViewById(w.h.yule_game_egg_view_stub);
            this.bOt.setVisibility(0);
            this.bOu = (FrameLayout) this.bOq.findViewById(w.h.game_activity_egg_layout);
            this.bOv = (TbImageView) this.bOq.findViewById(w.h.game_activity_egg);
            this.bOw = (TbImageView) this.bOq.findViewById(w.h.game_activity_egg_s);
            this.bOv.setDefaultBgResource(w.e.common_color_10022);
            this.bOv.setDefaultResource(0);
            this.bOw.setDefaultBgResource(w.e.common_color_10022);
            this.bOw.setDefaultResource(0);
            this.bOu.setOnClickListener(this.bOI);
        }
        this.bOu.setVisibility(0);
        String ti = brVar.ti();
        String tj = brVar.tj();
        this.bOv.c(ti, 10, false);
        this.bOw.c(tj, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bOY, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void ZF() {
        if (this.bOt != null) {
            this.bOu.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.am ZG() {
        return this.bOy;
    }

    public ViewGroup ZH() {
        return this.bOr;
    }

    public View ZI() {
        return this.bOL;
    }

    public void dF(boolean z) {
        this.bOE.setVisibility(z ? 0 : 8);
    }

    public void dG(boolean z) {
        if (this.bOP != null) {
            this.bOP.dV(z);
        }
    }

    public void ZJ() {
        if (com.baidu.tbadk.performanceLog.aa.Gi().Gj()) {
            int lastVisiblePosition = this.bOx.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bOx.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof bg)) {
                    bg bgVar = (bg) childAt.getTag();
                    if (bgVar.bPn != null) {
                        com.baidu.tbadk.performanceLog.u perfLog = bgVar.bPn.getPerfLog();
                        perfLog.fb(1000);
                        perfLog.aGg = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            bgVar.bPn.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        bgVar.bPn.wn();
                    }
                    if (bgVar.bPl != null && (bgVar.bPl instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = bgVar.bPl;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fb(1000);
                                perfLog2.aGg = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.wn();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar JT() {
        return this.mNavigationBar;
    }

    public void ZK() {
        this.mHasMore = true;
        this.bOx.setNextPage(this.aRw);
        this.aRw.wH();
    }

    public void Ka() {
        this.mHasMore = false;
        if (this.bOM > 0) {
            this.aRw.di(this.bOM);
        }
        this.bOx.setNextPage(this.aRw);
        this.aRw.wI();
        this.aRw.setText(this.bOq.getResources().getString(w.l.list_no_more));
    }

    public void TI() {
        this.mHasMore = false;
        this.bOx.setNextPage(null);
        this.aRw.wL();
    }

    public void ZL() {
        this.aRw.wL();
    }

    public boolean Tx() {
        return this.aRw.getView().getParent() != null && this.mHasMore;
    }

    public void hN(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("frs_login_tip", true)) {
                if (this.bFT == null) {
                    this.bFT = new CommonTipView(this.bOq.getActivity());
                }
                this.bFT.setText(w.l.frs_login_tip);
                this.bFT.a((FrameLayout) ZI(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void dH(boolean z) {
        if (this.aQP != null) {
            if (z) {
                this.aQP.gP(false);
                this.aQP.alL();
                return;
            }
            this.aQP.gP(true);
            this.aQP.a(this.aQT, this.aQS, this.aQR, true);
        }
    }

    public void ah(int i, int i2) {
        if (this.aQP != null) {
            this.aQP.a(i, i2, this.aQR, 1);
        }
    }

    public void ai(int i, int i2) {
        this.aQT = i;
        this.aQS = i2;
    }

    public void dI(boolean z) {
        this.aQR = z;
    }

    public void ZM() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.aq.j(this.bOB, w.g.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.aq.j(this.bOG, w.g.frs_star_navigation_bg);
        }
        int i = w.g.btn_sml_more_selector_s;
        this.bOV = i;
        this.bOU = i;
        com.baidu.tbadk.core.util.aq.b(this.bOG, this.bOU, this.bOV);
        if (this.bOD) {
            com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
        } else {
            com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
        }
    }

    public void ZN() {
        dJ(true);
    }

    private void ZO() {
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
                if (this.bOG != null) {
                    this.bOG.setAlpha(f);
                }
                if (this.bOB != null) {
                    this.bOB.setAlpha(f);
                }
            }
        }
    }

    private void dJ(boolean z) {
        boolean l = com.baidu.tieba.frs.f.u.l(this.bOq.YV());
        boolean k = com.baidu.tieba.frs.f.u.k(this.bOq.YV());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bkC) {
                    this.bkC = true;
                    com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aq.b(this.bOG, w.g.btn_sml_more_selector_s, w.g.btn_sml_more_selector_s);
                    if (this.bOD) {
                        com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
                    }
                    if (l && !k) {
                        com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.aq.j(this.bOG, w.g.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.aq.j(this.bOB, w.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bkC) {
                this.bkC = false;
                com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.icon_return_bg_s, w.g.icon_return_bg);
                if (l) {
                    com.baidu.tbadk.core.util.aq.b(this.bOG, w.g.btn_more_selector_s, w.g.btn_more_selector);
                    if (this.bOD) {
                        com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector_w);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.btn_bottle_selector, w.g.btn_bottle_selector_w);
                    }
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bOG.setBackgroundDrawable(null);
                    this.bOB.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.aq.b(this.bOG, this.bOU, this.bOV);
                    if (this.bOD) {
                        com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
                    }
                }
            }
        }
        ZO();
    }

    public void ZP() {
        if (!this.bOx.bgF()) {
            this.bOx.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.ae(this.bOq.getPageContext());
            this.mPullView.setTag(this.bOq.getUniqueId());
            this.bOx.setPullRefresh(this.mPullView);
        }
    }

    public void ZQ() {
        this.bOx.setStarForum(false);
        this.bOx.setPullRefresh(null);
    }

    public void dK(boolean z) {
        this.bOD = z;
    }

    public boolean ZR() {
        return this.bOD;
    }

    public void ZS() {
        if (this.bOW != null) {
            this.bOW.Uj();
        }
    }

    public void ZT() {
        if (this.bOq == null || this.bOq.YV() == null || !this.bOq.YV().isShowDriftingBottle() || com.baidu.adp.lib.b.e.eT().ab("android_bottle_enable") == 0 || !TbadkCoreApplication.isLogin() || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BigImgPbActivityConfig.class)) {
            this.bOA.setVisibility(8);
            return;
        }
        if (this.bOW == null) {
            this.bOW = new a(this.bOq.getPageContext(), this.bOB);
        }
        this.bOW.aA(this.bOq.getPageContext().getString(w.l.frs_bottle_tip), "frs_show_bottle_guide_tips");
        this.bOA.setVisibility(0);
        long j = com.baidu.tbadk.core.sharedPref.b.uo().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L);
        long bgg = this.bOq.YV().bgg();
        this.bOD = j != bgg;
        if (bgg == 0) {
            this.bOD = false;
        }
        if (this.bOD) {
            String str = "";
            if (this.bOq.YV().getUserData() != null && !StringUtils.isNull(this.bOq.YV().getUserData().getUserId())) {
                str = this.bOq.YV().getUserData().getUserId();
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11945").Z(SapiAccountManager.SESSION_UID, str).g("tid", this.bOq.YV().bgg()));
            if (this.bOq.YL()) {
                com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector);
            } else {
                com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
            }
            com.baidu.tbadk.core.util.aq.j(this.bOC, w.g.icon_news_head_prompt_one);
            this.bOC.setVisibility(0);
            return;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11943"));
        if (this.bOq.YL()) {
            com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
        } else {
            com.baidu.tbadk.core.util.aq.b(this.bOB, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
        }
        this.bOC.setVisibility(4);
    }

    public void hO(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void hP(int i) {
        if (this.bOx != null && this.bOx.getChildCount() >= 0) {
            if (this.bOx.getFirstVisiblePosition() > 8) {
                this.bOx.setSelection(8);
            }
            this.bOx.smoothScrollToPosition(i);
        }
    }
}
