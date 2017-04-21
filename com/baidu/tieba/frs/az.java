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
    private PbListView aRO;
    private com.baidu.tieba.play.ac aRh;
    private NoNetworkView bGI;
    private CommonTipView bId;
    private com.baidu.tieba.frs.entelechy.a.am bQE;
    private View bQG;
    private ImageView bQH;
    private TextView bQI;
    private View bQK;
    private View.OnClickListener bQO;
    private View bQQ;
    private View bQR;
    private View bQT;
    private com.baidu.tieba.frs.entelechy.b.e bQU;
    private com.baidu.tieba.frs.entelechy.b.c bQV;
    private GifView bQW;
    private TbImageView bQX;
    private HashSet<String> bQY;
    private com.baidu.tieba.frs.view.v bQZ;
    private FrsActivity bQw;
    private View bQy;
    private ViewStub bQz;
    private int bRa;
    private int bRb;
    private a bRc;
    private ObservedChangeLinearLayout bRd;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ae mPullView;
    private boolean bQv = false;
    private NoPressedRelativeLayout bQx = null;
    private FrameLayout bQA = null;
    private TbImageView bQB = null;
    private TbImageView bQC = null;
    private BdExpandListView bQD = null;
    private com.baidu.tbadk.core.dialog.c bQF = null;
    private boolean bQJ = false;
    private TextView bQL = null;
    private ImageView bQM = null;
    private com.baidu.tbadk.core.dialog.c bQN = null;
    private c.b bQP = null;
    private NoNetworkView.a bOn = null;
    private boolean mHasMore = true;
    private int bQS = 0;
    private boolean aRj = false;
    private int aRl = 0;
    private int aRk = 0;
    private View bJu = null;
    private boolean bmM = true;
    private Runnable bRe = new ba(this);

    public ObservedChangeLinearLayout aaJ() {
        return this.bRd;
    }

    public View aaK() {
        return this.bJu;
    }

    public az(FrsActivity frsActivity, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.bQw = null;
        this.bQO = null;
        this.bQw = frsActivity;
        this.bQO = onClickListener;
        a(aVar);
        this.bQY = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.bQw.getPageContext());
        this.bQx = (NoPressedRelativeLayout) this.bQw.findViewById(w.h.frs);
        this.bQR = this.bQw.findViewById(w.h.frs_list_content);
        this.mNavigationBar = (NavigationBar) this.bQw.findViewById(w.h.view_navigation_bar);
        this.bQQ = this.bQw.findViewById(w.h.frs_navi_line);
        b aca = aVar.aca();
        if (aca != null) {
            aca.ag(this.bQQ);
        }
        this.bQy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bQy.setOnClickListener(this.bQO);
        this.mBackImageView = (ImageView) this.bQy.findViewById(w.h.widget_navi_back_button);
        this.bQG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.frs_item_drifting_bottle_layout, (View.OnClickListener) null);
        this.bQH = (ImageView) this.bQG.findViewById(w.h.frs_top_drifting_bottle);
        this.bQI = (TextView) this.bQG.findViewById(w.h.frs_drifting_bottle_mes_text);
        this.bQI.setText("1");
        this.bQG.setVisibility(8);
        this.bQH.setOnClickListener(this.bQO);
        this.bQK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_frs_more, (View.OnClickListener) null);
        this.bQM = (ImageView) this.bQK.findViewById(w.h.frs_top_more);
        this.bQM.setContentDescription(this.bQw.getResources().getString(w.l.more));
        this.bRa = w.g.btn_more_selector_s;
        this.bRb = w.g.btn_more_selector;
        this.bQL = (TextView) this.bQK.findViewById(w.h.frs_more_mes_text);
        this.bQM.setOnClickListener(this.bQO);
        dV(false);
        this.bQD = (BdExpandListView) this.bQw.findViewById(w.h.frs_lv_thread);
        this.bQD.setFadingEdgeLength(0);
        this.bQD.setOverScrollMode(2);
        this.bQx.setBottomOrderView(this.bQD);
        this.bQD.setOnTouchListener(this.bQw.aOj);
        this.bQD.setDivider(null);
        if (aca != null) {
            this.bQT = aca.b(this.bQw.getActivity(), this.bQD);
        }
        this.bQD.setDividerHeight(0);
        this.bQD.setRecyclerListener(new bb(this));
        this.aRO = new PbListView(this.bQw.getPageContext().getPageActivity());
        this.aRO.lf();
        this.aRO.dj(w.e.cp_bg_line_c);
        this.bQD.setOnSrollToBottomListener(this.bQw);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.x(new bc(this)));
        this.bQE = aVar.a(this.bQw, this.bQD, com.baidu.tbadk.core.util.av.wa().wc());
        cg(false);
        this.bGI = (NoNetworkView) this.bQw.findViewById(w.h.view_no_network);
        aaM();
        this.bQU = aVar.c(this.bQw, this.bQx);
        this.bQV = aVar.b(this.bQw, this.bQx);
        this.bRd = (ObservedChangeLinearLayout) this.bQw.findViewById(w.h.navigation_bar_wrapperLayout);
        this.bRd.setOnSizeChangeListener(new bd(this));
        this.bJu = this.bQw.findViewById(w.h.statebar_view);
        this.aRh = new com.baidu.tieba.play.ac(this.bQw.getPageContext(), this.bQD);
        this.bQD.setPullRefresh(this.mPullView);
    }

    public com.baidu.tieba.play.ac Lc() {
        return this.aRh;
    }

    public com.baidu.tieba.frs.entelechy.b.c aaL() {
        return this.bQV;
    }

    public void dN(boolean z) {
        if (this.bQU != null) {
            this.bQU.dN(z);
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.bQV != null) {
            this.bQV.n(z, z2);
        }
    }

    public void dO(boolean z) {
        if (this.bQV != null) {
            this.bQV.eg(z);
        }
    }

    private void aaM() {
        this.bQW = (GifView) this.bQw.findViewById(w.h.gif_real_time);
        this.bQX = (TbImageView) this.bQw.findViewById(w.h.tbimg_real_time);
        this.bQW.setLayerType(1, null);
        this.bQX.setLayerType(1, null);
    }

    public com.baidu.tieba.frs.view.v aaN() {
        return this.bQZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aaO() {
        return this.bQM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aaP() {
        return this.bQK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aaQ() {
        return this.bQH;
    }

    public TextView aaR() {
        return this.bQI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aaS() {
        return this.bQG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aaT() {
        return this.bQy;
    }

    public void h(NoNetworkView.a aVar) {
        this.bOn = aVar;
        if (this.bGI != null) {
            this.bGI.a(this.bOn);
        }
    }

    public void cg(boolean z) {
        this.bQv = z;
        if (z) {
            if (this.bQV != null) {
                this.bQV.acy();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bQD.getAdapter()).notifyDataSetChanged();
        if (this.bQV != null) {
            this.bQV.acz();
        }
    }

    public void dP(boolean z) {
        if (this.bQV != null) {
            if (z) {
                n(true, true);
            } else {
                n(true, false);
            }
        }
    }

    public void dQ(boolean z) {
        if (this.bQV != null) {
            if (z) {
                n(false, true);
            } else {
                n(false, false);
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.bi biVar, boolean z) {
        String string = this.bQw.getPageContext().getPageActivity().getString(w.l.view);
        String string2 = this.bQw.getPageContext().getPageActivity().getString(w.l.view_host);
        String string3 = this.bQw.getPageContext().getPageActivity().getString(w.l.view_reverse);
        this.bQN = new com.baidu.tbadk.core.dialog.c(this.bQw.getPageContext().getPageActivity());
        this.bQN.cc(w.l.operation);
        if (z) {
            this.bQN.a(new String[]{string, string3}, this.bQP);
        } else {
            this.bQN.a(new String[]{string, string2, string3}, this.bQP);
        }
        this.bQN.d(this.bQw.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bQD instanceof BdExpandListView) {
            this.bQD.setPersonListRefreshListener(aVar);
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
        this.bQD.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.w wVar) {
        this.bQE.setOnAdapterItemClickListener(wVar);
    }

    public void setOnAdapterItemLongClickListener(com.baidu.adp.widget.ListView.x xVar) {
        this.bQE.setOnAdapterItemLongClickListener(xVar);
    }

    public void setForumName(String str) {
        this.bQE.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bQP = bVar;
    }

    public void aaU() {
        if (this.bQN != null) {
            this.bQN.tT();
        }
    }

    public void onDestroy() {
        if (this.aRh != null) {
            this.aRh.destroy();
        }
        this.bQE.onDestory();
        this.bQD.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bRe);
        if (this.bId != null) {
            this.bId.onDestroy();
        }
        this.bQY.clear();
        if (this.bQU != null) {
            this.bQU.acD();
        }
        if (this.bJu != null) {
            this.bJu.setBackgroundDrawable(null);
        }
        if (this.bRc != null) {
            this.bRc.VI();
        }
    }

    public boolean aaV() {
        if (this.bQU != null) {
            return this.bQU.aaV();
        }
        return false;
    }

    public boolean aat() {
        return this.bQv;
    }

    public void KZ() {
        this.bQD.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bQw.getActivity().getString(w.l.forum));
        com.baidu.tbadk.core.q.po().cd(str);
    }

    public void aaW() {
        if (this.bQE != null) {
            this.bQE.notifyDataSetChanged();
        }
    }

    private void aaX() {
        if (this.bQF == null) {
            String[] strArr = {this.bQw.getPageContext().getPageActivity().getString(w.l.take_photo), this.bQw.getPageContext().getPageActivity().getString(w.l.album)};
            this.bQF = new com.baidu.tbadk.core.dialog.c(this.bQw.getPageContext().getPageActivity());
            this.bQF.cF(this.bQw.getPageContext().getPageActivity().getString(w.l.operation));
            this.bQF.a(strArr, new be(this));
            this.bQF.d(this.bQw.getPageContext());
        }
    }

    public void aaY() {
        aaX();
        if (this.bQF != null) {
            this.bQF.tT();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tbadk.core.util.x.q(arrayList)) {
            bg bgVar = new bg();
            arrayList = new ArrayList<>();
            arrayList.add(bgVar);
            if (this.bQw != null && this.bQw.ZU() != null && this.bQw.ZU().adK() == 0) {
                bgVar.hZ(this.bQw.ZU().adS());
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
        this.bQE.b(arrayList, nVar);
        if (this.aRh != null) {
            this.aRh.a(this.aRl, this.aRk, this.aRj, true);
        }
    }

    public BdTypeListView getListView() {
        return this.bQD;
    }

    public void aaZ() {
        this.bQE.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bQw.getPageContext(), 1);
        aVar.a(this.bQD);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.bQw.getForumName());
        hashMap.put("forum_id", this.bQw.getForumId());
        aVar.setParams(hashMap);
        aVar.J(xVar);
        aVar.ce(this.bQw.aai());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.bQU != null) {
            this.bQU.acE();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.bQU != null) {
            this.bQU.acF();
        }
    }

    public void release() {
        if (this.bGI != null && this.bOn != null) {
            this.bGI.b(this.bOn);
        }
    }

    public void aba() {
        this.bQL.setVisibility(8);
    }

    public void a(bq bqVar) {
        long j;
        if (!FrsActivityStatic.bQg || bqVar == null) {
            this.bQL.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bQh) {
            j = bqVar.abz() - bqVar.abA();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().Aa()) {
                j -= bqVar.abB();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bQM.getVisibility() == 0) {
            this.bQL.setVisibility(0);
            if (j < 10) {
                this.bQL.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.aq.j(this.bQL, w.g.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bQL.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.aq.j(this.bQL, w.g.icon_news_head_prompt_two);
                return;
            } else {
                this.bQL.setText("   ");
                com.baidu.tbadk.core.util.aq.j(this.bQL, w.g.icon_news_head_prompt_more);
                return;
            }
        }
        this.bQL.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bQw.getPageContext(), 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bQw.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.bQX != null) {
            this.bQX.invalidate();
        }
        if (this.bQE != null) {
            this.bQE.acr();
            this.bQE.notifyDataSetChanged();
        }
        this.bQw.aaj();
        this.bQw.getLayoutMode().aj(i == 1);
        this.bQw.getLayoutMode().t(this.bQx);
        if (this.bQx != null) {
            com.baidu.tbadk.core.util.aq.e(this.bQx, w.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bQw.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cP(w.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aq.e(this.bQQ, w.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aq.k(this.mNavigationBar.getBottomLine(), w.e.cp_bg_line_b);
        }
        if (this.bGI != null) {
            this.bGI.onChangeSkinType(this.bQw.getPageContext(), i);
        }
        if (this.aRO != null) {
            this.aRO.dk(i);
        }
        dV(false);
        if (this.bQV != null) {
            this.bQV.onChangeSkinType(i);
        }
        if (this.bQU != null) {
            this.bQU.onChangeSkinType(i);
        }
        if (this.bJu != null) {
            UtilHelper.setStatusBarBackground(this.bJu, i);
        }
        if (this.aRh != null) {
            this.aRh.a(this.aRl, this.aRk, this.aRj, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.bQI != null) {
            com.baidu.tbadk.core.util.aq.j(this.bQI, w.g.icon_news_head_prompt_one);
        }
    }

    public void startPullRefresh() {
        this.bQD.startPullRefresh();
    }

    public void abb() {
        this.bQD.completePullRefreshPostDelayed(2000L);
    }

    public boolean abc() {
        return this.bQz != null && this.bQC.getVisibility() == 0;
    }

    public void abd() {
        if (this.bQz != null) {
            this.bQA.setVisibility(0);
            this.bQC.setVisibility(8);
            this.bQB.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bRe, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bq bqVar) {
        if (this.bQz == null) {
            this.bQz = (ViewStub) this.bQw.findViewById(w.h.yule_game_egg_view_stub);
            this.bQz.setVisibility(0);
            this.bQA = (FrameLayout) this.bQw.findViewById(w.h.game_activity_egg_layout);
            this.bQB = (TbImageView) this.bQw.findViewById(w.h.game_activity_egg);
            this.bQC = (TbImageView) this.bQw.findViewById(w.h.game_activity_egg_s);
            this.bQB.setDefaultBgResource(w.e.common_color_10022);
            this.bQB.setDefaultResource(0);
            this.bQC.setDefaultBgResource(w.e.common_color_10022);
            this.bQC.setDefaultResource(0);
            this.bQA.setOnClickListener(this.bQO);
        }
        this.bQA.setVisibility(0);
        String tG = bqVar.tG();
        String tH = bqVar.tH();
        this.bQB.c(tG, 10, false);
        this.bQC.c(tH, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bRe, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void abe() {
        if (this.bQz != null) {
            this.bQA.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.am abf() {
        return this.bQE;
    }

    public ViewGroup abg() {
        return this.bQx;
    }

    public View abh() {
        return this.bQR;
    }

    public void dR(boolean z) {
        this.bQK.setVisibility(z ? 0 : 8);
    }

    public void dS(boolean z) {
        if (this.bQV != null) {
            this.bQV.eh(z);
        }
    }

    public void abi() {
        if (com.baidu.tbadk.j.aa.GG().GH()) {
            int lastVisiblePosition = this.bQD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bQD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof bi)) {
                    bi biVar = (bi) childAt.getTag();
                    if (biVar.bRt != null) {
                        com.baidu.tbadk.j.u perfLog = biVar.bRt.getPerfLog();
                        perfLog.fe(1000);
                        perfLog.aGx = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            biVar.bRt.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        biVar.bRt.wJ();
                    }
                    if (biVar.bRr != null && (biVar.bRr instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = biVar.bRr;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.j.u perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fe(1000);
                                perfLog2.aGx = true;
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

    public void abj() {
        this.mHasMore = true;
        this.bQD.setNextPage(this.aRO);
        this.aRO.xd();
    }

    public void KA() {
        this.mHasMore = false;
        if (this.bQS > 0) {
            this.aRO.dl(this.bQS);
        }
        this.bQD.setNextPage(this.aRO);
        this.aRO.xe();
        this.aRO.setText(this.bQw.getResources().getString(w.l.list_no_more));
    }

    public void Vh() {
        this.mHasMore = false;
        this.bQD.setNextPage(null);
        this.aRO.xh();
    }

    public void abk() {
        this.aRO.xh();
    }

    public boolean UW() {
        return this.aRO.getView().getParent() != null && this.mHasMore;
    }

    public void hW(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("frs_login_tip", true)) {
                if (this.bId == null) {
                    this.bId = new CommonTipView(this.bQw.getActivity());
                }
                this.bId.setText(w.l.frs_login_tip);
                this.bId.a((FrameLayout) abh(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void dT(boolean z) {
        if (this.aRh != null) {
            if (z) {
                this.aRh.gY(false);
                this.aRh.amG();
                return;
            }
            this.aRh.gY(true);
            this.aRh.a(this.aRl, this.aRk, this.aRj, true);
        }
    }

    public void ah(int i, int i2) {
        if (this.aRh != null) {
            this.aRh.a(i, i2, this.aRj, 1);
        }
    }

    public void ai(int i, int i2) {
        this.aRl = i;
        this.aRk = i2;
    }

    public void dU(boolean z) {
        this.aRj = z;
    }

    public void abl() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.aq.j(this.bQH, w.g.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.aq.j(this.bQM, w.g.frs_star_navigation_bg);
        }
        int i = w.g.btn_sml_more_selector_s;
        this.bRb = i;
        this.bRa = i;
        com.baidu.tbadk.core.util.aq.b(this.bQM, this.bRa, this.bRb);
        if (this.bQJ) {
            com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
        } else {
            com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
        }
    }

    public void abm() {
        dV(true);
    }

    private void abn() {
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
                if (this.bQM != null) {
                    this.bQM.setAlpha(f);
                }
                if (this.bQH != null) {
                    this.bQH.setAlpha(f);
                }
            }
        }
    }

    private void dV(boolean z) {
        boolean l = com.baidu.tieba.frs.g.u.l(this.bQw.aas());
        boolean k = com.baidu.tieba.frs.g.u.k(this.bQw.aas());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bmM) {
                    this.bmM = true;
                    com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aq.b(this.bQM, w.g.btn_sml_more_selector_s, w.g.btn_sml_more_selector_s);
                    if (this.bQJ) {
                        com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
                    }
                    if (l && !k) {
                        com.baidu.tbadk.core.util.aq.j(this.mBackImageView, w.g.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.aq.j(this.bQM, w.g.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.aq.j(this.bQH, w.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bmM) {
                this.bmM = false;
                com.baidu.tbadk.core.util.aq.b(this.mBackImageView, w.g.icon_return_bg_s, w.g.icon_return_bg);
                if (l) {
                    com.baidu.tbadk.core.util.aq.b(this.bQM, w.g.btn_more_selector_s, w.g.btn_more_selector);
                    if (this.bQJ) {
                        com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector_w);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.btn_bottle_selector, w.g.btn_bottle_selector_w);
                    }
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bQM.setBackgroundDrawable(null);
                    this.bQH.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.aq.b(this.bQM, this.bRa, this.bRb);
                    if (this.bQJ) {
                        com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
                    }
                }
            }
        }
        abn();
    }

    public void abo() {
        if (!this.bQD.bir()) {
            this.bQD.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.ae(this.bQw.getPageContext());
            this.mPullView.setTag(this.bQw.getUniqueId());
            this.bQD.setPullRefresh(this.mPullView);
        }
    }

    public void abp() {
        this.bQD.setStarForum(false);
        this.bQD.setPullRefresh(null);
    }

    public void dW(boolean z) {
        this.bQJ = z;
    }

    public boolean abq() {
        return this.bQJ;
    }

    public void abr() {
        if (this.bRc != null) {
            this.bRc.VI();
        }
    }

    public void abs() {
        if (this.bQw == null || this.bQw.aas() == null || !this.bQw.aas().isShowDriftingBottle() || com.baidu.adp.lib.b.e.eZ().Y("android_bottle_enable") == 0 || !TbadkCoreApplication.isLogin() || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BigImgPbActivityConfig.class)) {
            this.bQG.setVisibility(8);
            return;
        }
        if (this.bRc == null) {
            this.bRc = new a(this.bQw.getPageContext(), this.bQH);
        }
        this.bRc.aD(this.bQw.getPageContext().getString(w.l.frs_bottle_tip), "frs_show_bottle_guide_tips");
        this.bQG.setVisibility(0);
        long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L);
        long bhU = this.bQw.aas().bhU();
        this.bQJ = j != bhU;
        if (bhU == 0) {
            this.bQJ = false;
        }
        if (this.bQJ) {
            String str = "";
            if (this.bQw.aas().getUserData() != null && !StringUtils.isNull(this.bQw.aas().getUserData().getUserId())) {
                str = this.bQw.aas().getUserData().getUserId();
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11945").aa(SapiAccountManager.SESSION_UID, str).g("tid", this.bQw.aas().bhU()));
            if (this.bQw.aai()) {
                com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.btn_newbottle_selector, w.g.btn_newbottle_selector);
            } else {
                com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.d_btn_newbottle_selector, w.g.d_btn_newbottle_selector);
            }
            com.baidu.tbadk.core.util.aq.j(this.bQI, w.g.icon_news_head_prompt_one);
            this.bQI.setVisibility(0);
            return;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11943"));
        if (this.bQw.aai()) {
            com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
        } else {
            com.baidu.tbadk.core.util.aq.b(this.bQH, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
        }
        this.bQI.setVisibility(4);
    }

    public void hX(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void hY(int i) {
        if (this.bQD != null && this.bQD.getChildCount() >= 0) {
            if (this.bQD.getFirstVisiblePosition() > 8) {
                this.bQD.setSelection(8);
            }
            this.bQD.smoothScrollToPosition(i);
        }
    }
}
