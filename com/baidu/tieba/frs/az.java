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
public class az {
    private PbListView aRM;
    private com.baidu.tieba.play.ac aRf;
    private NoNetworkView bEr;
    private CommonTipView bFM;
    private View bOA;
    private View bOC;
    private com.baidu.tieba.frs.entelechy.b.e bOD;
    private com.baidu.tieba.frs.entelechy.b.c bOE;
    private GifView bOF;
    private TbImageView bOG;
    private HashSet<String> bOH;
    private com.baidu.tieba.frs.view.v bOI;
    private int bOJ;
    private int bOK;
    private a bOL;
    private ObservedChangeLinearLayout bOM;
    private FrsActivity bOf;
    private View bOh;
    private ViewStub bOi;
    private com.baidu.tieba.frs.entelechy.a.am bOn;
    private View bOp;
    private ImageView bOq;
    private TextView bOr;
    private View bOt;
    private View.OnClickListener bOx;
    private View bOz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ae mPullView;
    private boolean bOe = false;
    private NoPressedRelativeLayout bOg = null;
    private FrameLayout bOj = null;
    private TbImageView bOk = null;
    private TbImageView bOl = null;
    private BdExpandListView bOm = null;
    private com.baidu.tbadk.core.dialog.c bOo = null;
    private boolean bOs = false;
    private TextView bOu = null;
    private ImageView bOv = null;
    private com.baidu.tbadk.core.dialog.c bOw = null;
    private c.b bOy = null;
    private NoNetworkView.a bLW = null;
    private boolean mHasMore = true;
    private int bOB = 0;
    private boolean aRh = false;
    private int aRj = 0;
    private int aRi = 0;
    private View bHd = null;
    private boolean bkv = true;
    private Runnable bON = new ba(this);

    public ObservedChangeLinearLayout ZI() {
        return this.bOM;
    }

    public View ZJ() {
        return this.bHd;
    }

    public az(FrsActivity frsActivity, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.bOf = null;
        this.bOx = null;
        this.bOf = frsActivity;
        this.bOx = onClickListener;
        a(aVar);
        this.bOH = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.bOf.getPageContext());
        this.bOg = (NoPressedRelativeLayout) this.bOf.findViewById(w.h.frs);
        this.bOA = this.bOf.findViewById(w.h.frs_list_content);
        this.mNavigationBar = (NavigationBar) this.bOf.findViewById(w.h.view_navigation_bar);
        this.bOz = this.bOf.findViewById(w.h.frs_navi_line);
        b aaZ = aVar.aaZ();
        if (aaZ != null) {
            aaZ.ag(this.bOz);
        }
        this.bOh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bOh.setOnClickListener(this.bOx);
        this.mBackImageView = (ImageView) this.bOh.findViewById(w.h.widget_navi_back_button);
        this.bOp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.frs_item_drifting_bottle_layout, (View.OnClickListener) null);
        this.bOq = (ImageView) this.bOp.findViewById(w.h.frs_top_drifting_bottle);
        this.bOr = (TextView) this.bOp.findViewById(w.h.frs_drifting_bottle_mes_text);
        this.bOr.setText("1");
        this.bOp.setVisibility(8);
        this.bOq.setOnClickListener(this.bOx);
        this.bOt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_frs_more, (View.OnClickListener) null);
        this.bOv = (ImageView) this.bOt.findViewById(w.h.frs_top_more);
        this.bOv.setContentDescription(this.bOf.getResources().getString(w.l.more));
        this.bOJ = w.g.btn_more_selector_s;
        this.bOK = w.g.btn_more_selector;
        this.bOu = (TextView) this.bOt.findViewById(w.h.frs_more_mes_text);
        this.bOv.setOnClickListener(this.bOx);
        dL(false);
        this.bOm = (BdExpandListView) this.bOf.findViewById(w.h.frs_lv_thread);
        this.bOm.setFadingEdgeLength(0);
        this.bOm.setOverScrollMode(2);
        this.bOg.setBottomOrderView(this.bOm);
        this.bOm.setOnTouchListener(this.bOf.aOh);
        this.bOm.setDivider(null);
        if (aaZ != null) {
            this.bOC = aaZ.b(this.bOf.getActivity(), this.bOm);
        }
        this.bOm.setDividerHeight(0);
        this.bOm.setRecyclerListener(new bb(this));
        this.aRM = new PbListView(this.bOf.getPageContext().getPageActivity());
        this.aRM.le();
        this.aRM.dj(w.e.cp_bg_line_c);
        this.bOm.setOnSrollToBottomListener(this.bOf);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.x(new bc(this)));
        this.bOn = aVar.a(this.bOf, this.bOm, com.baidu.tbadk.core.util.av.wa().wc());
        cg(false);
        this.bEr = (NoNetworkView) this.bOf.findViewById(w.h.view_no_network);
        ZL();
        this.bOD = aVar.c(this.bOf, this.bOg);
        this.bOE = aVar.b(this.bOf, this.bOg);
        this.bOM = (ObservedChangeLinearLayout) this.bOf.findViewById(w.h.navigation_bar_wrapperLayout);
        this.bOM.setOnSizeChangeListener(new bd(this));
        this.bHd = this.bOf.findViewById(w.h.statebar_view);
        this.aRf = new com.baidu.tieba.play.ac(this.bOf.getPageContext(), this.bOm);
        this.bOm.setPullRefresh(this.mPullView);
    }

    public com.baidu.tieba.play.ac Lc() {
        return this.aRf;
    }

    public com.baidu.tieba.frs.entelechy.b.c ZK() {
        return this.bOE;
    }

    public void dD(boolean z) {
        if (this.bOD != null) {
            this.bOD.dD(z);
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.bOE != null) {
            this.bOE.n(z, z2);
        }
    }

    public void dE(boolean z) {
        if (this.bOE != null) {
            this.bOE.dW(z);
        }
    }

    private void ZL() {
        this.bOF = (GifView) this.bOf.findViewById(w.h.gif_real_time);
        this.bOG = (TbImageView) this.bOf.findViewById(w.h.tbimg_real_time);
        this.bOF.setLayerType(1, null);
        this.bOG.setLayerType(1, null);
    }

    public com.baidu.tieba.frs.view.v ZM() {
        return this.bOI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ZN() {
        return this.bOv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ZO() {
        return this.bOt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ZP() {
        return this.bOq;
    }

    public TextView ZQ() {
        return this.bOr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ZR() {
        return this.bOp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ZS() {
        return this.bOh;
    }

    public void h(NoNetworkView.a aVar) {
        this.bLW = aVar;
        if (this.bEr != null) {
            this.bEr.a(this.bLW);
        }
    }

    public void cg(boolean z) {
        this.bOe = z;
        if (z) {
            if (this.bOE != null) {
                this.bOE.abx();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bOm.getAdapter()).notifyDataSetChanged();
        if (this.bOE != null) {
            this.bOE.aby();
        }
    }

    public void dF(boolean z) {
        if (this.bOE != null) {
            if (z) {
                n(true, true);
            } else {
                n(true, false);
            }
        }
    }

    public void dG(boolean z) {
        if (this.bOE != null) {
            if (z) {
                n(false, true);
            } else {
                n(false, false);
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.bi biVar, boolean z) {
        String string = this.bOf.getPageContext().getPageActivity().getString(w.l.view);
        String string2 = this.bOf.getPageContext().getPageActivity().getString(w.l.view_host);
        String string3 = this.bOf.getPageContext().getPageActivity().getString(w.l.view_reverse);
        this.bOw = new com.baidu.tbadk.core.dialog.c(this.bOf.getPageContext().getPageActivity());
        this.bOw.cc(w.l.operation);
        if (z) {
            this.bOw.a(new String[]{string, string3}, this.bOy);
        } else {
            this.bOw.a(new String[]{string, string2, string3}, this.bOy);
        }
        this.bOw.d(this.bOf.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bOm instanceof BdExpandListView) {
            this.bOm.setPersonListRefreshListener(aVar);
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
        this.bOm.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.w wVar) {
        this.bOn.setOnAdapterItemClickListener(wVar);
    }

    public void setOnAdapterItemLongClickListener(com.baidu.adp.widget.ListView.x xVar) {
        this.bOn.setOnAdapterItemLongClickListener(xVar);
    }

    public void setForumName(String str) {
        this.bOn.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bOy = bVar;
    }

    public void ZT() {
        if (this.bOw != null) {
            this.bOw.tT();
        }
    }

    public void onDestroy() {
        if (this.aRf != null) {
            this.aRf.destroy();
        }
        this.bOn.onDestory();
        this.bOm.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bON);
        if (this.bFM != null) {
            this.bFM.onDestroy();
        }
        this.bOH.clear();
        if (this.bOD != null) {
            this.bOD.abC();
        }
        if (this.bHd != null) {
            this.bHd.setBackgroundDrawable(null);
        }
        if (this.bOL != null) {
            this.bOL.UH();
        }
    }

    public boolean ZU() {
        if (this.bOD != null) {
            return this.bOD.ZU();
        }
        return false;
    }

    public boolean Zs() {
        return this.bOe;
    }

    public void KZ() {
        this.bOm.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bOf.getActivity().getString(w.l.forum));
        com.baidu.tbadk.core.q.po().cd(str);
    }

    public void ZV() {
        if (this.bOn != null) {
            this.bOn.notifyDataSetChanged();
        }
    }

    private void ZW() {
        if (this.bOo == null) {
            String[] strArr = {this.bOf.getPageContext().getPageActivity().getString(w.l.take_photo), this.bOf.getPageContext().getPageActivity().getString(w.l.album)};
            this.bOo = new com.baidu.tbadk.core.dialog.c(this.bOf.getPageContext().getPageActivity());
            this.bOo.cF(this.bOf.getPageContext().getPageActivity().getString(w.l.operation));
            this.bOo.a(strArr, new be(this));
            this.bOo.d(this.bOf.getPageContext());
        }
    }

    public void ZX() {
        ZW();
        if (this.bOo != null) {
            this.bOo.tT();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tbadk.core.util.x.q(arrayList)) {
            bg bgVar = new bg();
            arrayList = new ArrayList<>();
            arrayList.add(bgVar);
            if (this.bOf != null && this.bOf.YT() != null && this.bOf.YT().acJ() == 0) {
                bgVar.hT(this.bOf.YT().acR());
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
                if (vVar instanceof com.baidu.tbadk.core.data.bi) {
                    ((com.baidu.tbadk.core.data.bi) vVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.bOn.b(arrayList, nVar);
        if (this.aRf != null) {
            this.aRf.a(this.aRj, this.aRi, this.aRh, true);
        }
    }

    public BdTypeListView getListView() {
        return this.bOm;
    }

    public void ZY() {
        this.bOn.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bOf.getPageContext(), 1);
        aVar.a(this.bOm);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.bOf.getForumName());
        hashMap.put("forum_id", this.bOf.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        aVar.ce(this.bOf.Zh());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.bOD != null) {
            this.bOD.abD();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.bOD != null) {
            this.bOD.abE();
        }
    }

    public void release() {
        if (this.bEr != null && this.bLW != null) {
            this.bEr.b(this.bLW);
        }
    }

    public void ZZ() {
        this.bOu.setVisibility(8);
    }

    public void a(bq bqVar) {
        long j;
        if (!FrsActivityStatic.bNP || bqVar == null) {
            this.bOu.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bNQ) {
            j = bqVar.aay() - bqVar.aaz();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().Aa()) {
                j -= bqVar.aaA();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bOv.getVisibility() == 0) {
            this.bOu.setVisibility(0);
            if (j < 10) {
                this.bOu.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.aq.j(this.bOu, w.g.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bOu.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.aq.j(this.bOu, w.g.icon_news_head_prompt_two);
                return;
            } else {
                this.bOu.setText("   ");
                com.baidu.tbadk.core.util.aq.j(this.bOu, w.g.icon_news_head_prompt_more);
                return;
            }
        }
        this.bOu.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bOf.getPageContext(), 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bOf.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.bOG != null) {
            this.bOG.invalidate();
        }
        if (this.bOn != null) {
            this.bOn.abq();
            this.bOn.notifyDataSetChanged();
        }
        this.bOf.Zi();
        this.bOf.getLayoutMode().aj(i == 1);
        this.bOf.getLayoutMode().t(this.bOg);
        if (this.bOg != null) {
            com.baidu.tbadk.core.util.aq.e(this.bOg, w.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bOf.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cP(w.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aq.e(this.bOz, w.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aq.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        }
        if (this.bEr != null) {
            this.bEr.onChangeSkinType(this.bOf.getPageContext(), i);
        }
        if (this.aRM != null) {
            this.aRM.dk(i);
        }
        dL(false);
        if (this.bOE != null) {
            this.bOE.onChangeSkinType(i);
        }
        if (this.bOD != null) {
            this.bOD.onChangeSkinType(i);
        }
        if (this.bHd != null) {
            UtilHelper.setStatusBarBackground(this.bHd, i);
        }
        if (this.aRf != null) {
            this.aRf.a(this.aRj, this.aRi, this.aRh, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.bOr != null) {
            com.baidu.tbadk.core.util.aq.j(this.bOr, w.g.icon_news_head_prompt_one);
        }
    }

    public void startPullRefresh() {
        this.bOm.startPullRefresh();
    }

    public void aaa() {
        this.bOm.completePullRefreshPostDelayed(2000L);
    }

    public boolean aab() {
        return this.bOi != null && this.bOl.getVisibility() == 0;
    }

    public void aac() {
        if (this.bOi != null) {
            this.bOj.setVisibility(0);
            this.bOl.setVisibility(8);
            this.bOk.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bON, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bq bqVar) {
        if (this.bOi == null) {
            this.bOi = (ViewStub) this.bOf.findViewById(w.h.yule_game_egg_view_stub);
            this.bOi.setVisibility(0);
            this.bOj = (FrameLayout) this.bOf.findViewById(w.h.game_activity_egg_layout);
            this.bOk = (TbImageView) this.bOf.findViewById(w.h.game_activity_egg);
            this.bOl = (TbImageView) this.bOf.findViewById(w.h.game_activity_egg_s);
            this.bOk.setDefaultBgResource(w.e.common_color_10022);
            this.bOk.setDefaultResource(0);
            this.bOl.setDefaultBgResource(w.e.common_color_10022);
            this.bOl.setDefaultResource(0);
            this.bOj.setOnClickListener(this.bOx);
        }
        this.bOj.setVisibility(0);
        String tG = bqVar.tG();
        String tH = bqVar.tH();
        this.bOk.c(tG, 10, false);
        this.bOl.c(tH, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bON, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void aad() {
        if (this.bOi != null) {
            this.bOj.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.am aae() {
        return this.bOn;
    }

    public ViewGroup aaf() {
        return this.bOg;
    }

    public View aag() {
        return this.bOA;
    }

    public void dH(boolean z) {
        this.bOt.setVisibility(z ? 0 : 8);
    }

    public void dI(boolean z) {
        if (this.bOE != null) {
            this.bOE.dX(z);
        }
    }

    public void aah() {
        if (com.baidu.tbadk.j.aa.GG().GH()) {
            int lastVisiblePosition = this.bOm.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bOm.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof bi)) {
                    bi biVar = (bi) childAt.getTag();
                    if (biVar.bPc != null) {
                        com.baidu.tbadk.j.u perfLog = biVar.bPc.getPerfLog();
                        perfLog.fe(1000);
                        perfLog.aGv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            biVar.bPc.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        biVar.bPc.wJ();
                    }
                    if (biVar.bPa != null && (biVar.bPa instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = biVar.bPa;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.j.u perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fe(1000);
                                perfLog2.aGv = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.wJ();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar Kt() {
        return this.mNavigationBar;
    }

    public void aai() {
        this.mHasMore = true;
        this.bOm.setNextPage(this.aRM);
        this.aRM.xd();
    }

    public void KA() {
        this.mHasMore = false;
        if (this.bOB > 0) {
            this.aRM.dl(this.bOB);
        }
        this.bOm.setNextPage(this.aRM);
        this.aRM.xe();
        this.aRM.setText(this.bOf.getResources().getString(w.l.list_no_more));
    }

    public void Ug() {
        this.mHasMore = false;
        this.bOm.setNextPage(null);
        this.aRM.xh();
    }

    public void aaj() {
        this.aRM.xh();
    }

    public boolean TV() {
        return this.aRM.getView().getParent() != null && this.mHasMore;
    }

    public void hQ(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("frs_login_tip", true)) {
                if (this.bFM == null) {
                    this.bFM = new CommonTipView(this.bOf.getActivity());
                }
                this.bFM.setText(w.l.frs_login_tip);
                this.bFM.a((FrameLayout) aag(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void dJ(boolean z) {
        if (this.aRf != null) {
            if (z) {
                this.aRf.gO(false);
                this.aRf.alF();
                return;
            }
            this.aRf.gO(true);
            this.aRf.a(this.aRj, this.aRi, this.aRh, true);
        }
    }

    public void ah(int i, int i2) {
        if (this.aRf != null) {
            this.aRf.a(i, i2, this.aRh, 1);
        }
    }

    public void ai(int i, int i2) {
        this.aRj = i;
        this.aRi = i2;
    }

    public void dK(boolean z) {
        this.aRh = z;
    }

    public void aak() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.aq.j(this.bOq, w.g.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.aq.j(this.bOv, w.g.frs_star_navigation_bg);
        }
        int i = w.g.btn_sml_more_selector_s;
        this.bOK = i;
        this.bOJ = i;
        com.baidu.tbadk.core.util.aq.b(this.bOv, this.bOJ, this.bOK);
        if (this.bOs) {
            com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
        } else {
            com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
        }
    }

    public void aal() {
        dL(true);
    }

    private void aam() {
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
                if (this.bOv != null) {
                    this.bOv.setAlpha(f);
                }
                if (this.bOq != null) {
                    this.bOq.setAlpha(f);
                }
            }
        }
    }

    private void dL(boolean z) {
        boolean l = com.baidu.tieba.frs.g.u.l(this.bOf.Zr());
        boolean k = com.baidu.tieba.frs.g.u.k(this.bOf.Zr());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bkv) {
                    this.bkv = true;
                    com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aq.b(this.bOv, w.g.btn_sml_more_selector_s, w.g.btn_sml_more_selector_s);
                    if (this.bOs) {
                        com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
                    }
                    if (l && !k) {
                        com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.aq.j(this.bOv, w.g.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.aq.j(this.bOq, w.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bkv) {
                this.bkv = false;
                com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.icon_return_bg_s, w.g.icon_return_bg);
                if (l) {
                    com.baidu.tbadk.core.util.aq.b(this.bOv, w.g.btn_more_selector_s, w.g.btn_more_selector);
                    if (this.bOs) {
                        com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector_w);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.btn_bottle_selector, w.g.btn_bottle_selector_w);
                    }
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bOv.setBackgroundDrawable(null);
                    this.bOq.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.aq.b(this.bOv, this.bOJ, this.bOK);
                    if (this.bOs) {
                        com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
                    }
                }
            }
        }
        aam();
    }

    public void aan() {
        if (!this.bOm.bhq()) {
            this.bOm.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.ae(this.bOf.getPageContext());
            this.mPullView.setTag(this.bOf.getUniqueId());
            this.bOm.setPullRefresh(this.mPullView);
        }
    }

    public void aao() {
        this.bOm.setStarForum(false);
        this.bOm.setPullRefresh(null);
    }

    public void dM(boolean z) {
        this.bOs = z;
    }

    public boolean aap() {
        return this.bOs;
    }

    public void aaq() {
        if (this.bOL != null) {
            this.bOL.UH();
        }
    }

    public void aar() {
        if (this.bOf == null || this.bOf.Zr() == null || !this.bOf.Zr().isShowDriftingBottle() || com.baidu.adp.lib.b.e.eY().Y("android_bottle_enable") == 0 || !TbadkCoreApplication.isLogin() || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BigImgPbActivityConfig.class)) {
            this.bOp.setVisibility(8);
            return;
        }
        if (this.bOL == null) {
            this.bOL = new a(this.bOf.getPageContext(), this.bOq);
        }
        this.bOL.aE(this.bOf.getPageContext().getString(w.l.frs_bottle_tip), "frs_show_bottle_guide_tips");
        this.bOp.setVisibility(0);
        long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L);
        long bgT = this.bOf.Zr().bgT();
        this.bOs = j != bgT;
        if (bgT == 0) {
            this.bOs = false;
        }
        if (this.bOs) {
            String str = "";
            if (this.bOf.Zr().getUserData() != null && !StringUtils.isNull(this.bOf.Zr().getUserData().getUserId())) {
                str = this.bOf.Zr().getUserData().getUserId();
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11945").aa(SapiAccountManager.SESSION_UID, str).g("tid", this.bOf.Zr().bgT()));
            if (this.bOf.Zh()) {
                com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector);
            } else {
                com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
            }
            com.baidu.tbadk.core.util.aq.j(this.bOr, w.g.icon_news_head_prompt_one);
            this.bOr.setVisibility(0);
            return;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11943"));
        if (this.bOf.Zh()) {
            com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
        } else {
            com.baidu.tbadk.core.util.aq.b(this.bOq, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
        }
        this.bOr.setVisibility(4);
    }

    public void hR(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void hS(int i) {
        if (this.bOm != null && this.bOm.getChildCount() >= 0) {
            if (this.bOm.getFirstVisiblePosition() > 8) {
                this.bOm.setSelection(8);
            }
            this.bOm.smoothScrollToPosition(i);
        }
    }
}
