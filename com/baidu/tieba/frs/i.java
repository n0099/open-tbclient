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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bq;
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
    private NoNetworkView bIw;
    private PbListView beq;
    private CommonTipView cdu;
    private q cqD;
    private View.OnClickListener cqF;
    private View cqG;
    private View cqH;
    private int cqI;
    private View cqK;
    private com.baidu.tieba.frs.entelechy.b.e cqL;
    private com.baidu.tieba.frs.entelechy.b.c cqM;
    private GifView cqN;
    private TbImageView cqO;
    private HashSet<String> cqP;
    private com.baidu.tieba.play.l cqQ;
    private ObservedChangeLinearLayout cqR;
    private com.baidu.tieba.frs.entelechy.b.a cqS;
    private f cqt;
    private View cqv;
    private ImageView cqw;
    private ImageView cqx;
    private ViewStub cqy;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.l mPullView;
    private boolean cqs = false;
    private NoPressedRelativeLayout cqu = null;
    private FrameLayout cqz = null;
    private TbImageView cqA = null;
    private TbImageView cqB = null;
    private BdExpandListView cqC = null;
    private com.baidu.tbadk.core.dialog.b cqE = null;
    private NoNetworkView.a bIz = null;
    private boolean mHasMore = true;
    private boolean cqJ = false;
    private int cqk = 0;
    private int bcY = 0;
    private View ceh = null;
    private boolean bzb = true;
    private boolean cqT = true;
    private Runnable cqU = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cqy != null) {
                i.this.cqz.setVisibility(0);
                i.this.cqB.setVisibility(0);
                i.this.cqA.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout ahl() {
        return this.cqR;
    }

    public View ahm() {
        return this.ceh;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.cqt = null;
        this.cqF = null;
        this.cqI = 0;
        this.cqt = fVar;
        this.cqF = onClickListener;
        a(aVar, z);
        this.cqP = new HashSet<>();
        this.cqI = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.cqS = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.l(this.cqt.getPageContext());
        }
        this.mPullView.setTag(this.cqt.getUniqueId());
        if (this.cqu == null) {
            this.cqu = (NoPressedRelativeLayout) this.cqt.mRootView.findViewById(d.h.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.cqu, d.e.cp_bg_line_d);
        if (this.cqH == null) {
            this.cqH = this.cqt.mRootView.findViewById(d.h.frs_list_content);
        }
        if (this.cqR == null) {
            this.cqR = (ObservedChangeLinearLayout) this.cqt.mRootView.findViewById(d.h.navigation_bar_wrapperLayout);
            this.cqR.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cqt.mRootView.findViewById(d.h.view_navigation_bar);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cqt.ahi()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cqG == null) {
            this.cqG = this.cqt.mRootView.findViewById(d.h.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b ait = aVar.ait();
            if (ait != null) {
                ait.ar(this.cqG);
            }
        }
        if (this.cqv == null) {
            this.cqv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cqv.setOnClickListener(this.cqF);
            this.mBackImageView = (ImageView) this.cqv.findViewById(d.h.widget_navi_back_button);
        }
        if (this.cqw == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.cqt.getPageContext().getPageActivity(), d.f.ds24), 0);
            this.cqw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.cqw.setLayoutParams(layoutParams);
            this.cqw.setOnClickListener(this.cqF);
            this.cqx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.cqx.setLayoutParams(layoutParams);
            this.cqx.setOnClickListener(this.cqF);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cqt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.cqC == null) {
            this.cqC = (BdExpandListView) this.cqt.mRootView.findViewById(d.h.frs_lv_thread);
        }
        this.cqC.setScrollable(this.cqt);
        this.cqC.setFadingEdgeLength(0);
        this.cqC.setOverScrollMode(2);
        this.cqu.setBottomOrderView(this.cqC);
        this.cqC.setOnTouchListener(this.cqt.aMA);
        this.cqC.setDivider(null);
        this.cqC.setPullRefresh(this.mPullView);
        if (z && this.cqK == null) {
            this.cqK = BdListViewHelper.a(this.cqt.getActivity(), this.cqC, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cqC.setDividerHeight(0);
        this.cqC.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.cqQ != null) {
                    i.this.cqQ.aZ(view);
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
        if (this.beq == null) {
            this.beq = new PbListView(this.cqt.getPageContext().getPageActivity());
            this.beq.lb();
        }
        this.beq.dp(d.e.cp_bg_line_c);
        this.cqC.setOnSrollToBottomListener(this.cqt);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.q(new q.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ahM() {
                i.this.cqt.ahd();
            }

            @Override // com.baidu.tieba.tbadkCore.q.a
            public void ahN() {
                if (i.this.cqC != null) {
                    i.this.cqC.setSelection(0);
                    if (i.this.cqQ != null) {
                        i.this.cqQ.a(i.this.cqk, i.this.bcY, false, true);
                    }
                }
            }
        }));
        boolean vQ = com.baidu.tbadk.core.util.an.vO().vQ();
        if (this.cqD == null) {
            this.cqD = aVar.a(this.cqt, this.cqC, vQ);
        }
        cl(false);
        if (!z) {
            if (this.bIw == null) {
                this.bIw = new NoNetworkView(this.cqt.getActivity());
                this.bIw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.cqR.addView(this.bIw);
            }
            if (com.baidu.adp.lib.util.i.gW()) {
                this.bIw.setVisibility(8);
            } else {
                this.bIw.setVisibility(0);
            }
            this.bIw.onChangeSkinType(this.cqt.yi(), TbadkCoreApplication.getInst().getSkinType());
        }
        aht();
        if (this.cqL == null) {
            this.cqL = aVar.c(this.cqt, this.cqu);
        }
        if (this.cqM == null) {
            this.cqM = aVar.b(this.cqt, this.cqu);
        }
        if (this.ceh == null) {
            this.ceh = this.cqt.mRootView.findViewById(d.h.statebar_view);
        }
        if (this.cqQ == null) {
            this.cqQ = new com.baidu.tieba.play.l(this.cqt.getPageContext(), this.cqC);
        }
        this.cqQ.setUniqueId(this.cqt.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cqK != null && this.cqK.getLayoutParams() != null) {
            this.cqK.getLayoutParams().height = i;
            this.cqK.setLayoutParams(this.cqK.getLayoutParams());
        }
    }

    public View ahn() {
        return this.cqK;
    }

    public com.baidu.tieba.play.l aho() {
        return this.cqQ;
    }

    public com.baidu.tieba.frs.entelechy.b.c ahp() {
        return this.cqM;
    }

    public void eJ(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.v(this.cqt.ahf().bra());
        if (this.cqL != null) {
            this.cqL.eJ(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e ahq() {
        return this.cqL;
    }

    public void u(boolean z, boolean z2) {
        if (this.cqT && this.cqM != null) {
            this.cqM.u(z, z2);
        }
    }

    public void eK(boolean z) {
        this.cqT = z;
        if (!this.cqT && this.cqM != null) {
            this.cqM.u(false, false);
        }
    }

    public void ahr() {
        if (this.cqT && this.cqM != null) {
            this.cqM.u(false, false);
        }
        this.cqw.setVisibility(8);
        this.cqx.setVisibility(8);
        eJ(false);
        this.cqC.setVisibility(8);
    }

    public void ahs() {
        if (this.cqT && this.cqM != null) {
            this.cqM.u(true, false);
        }
        this.cqw.setVisibility(0);
        this.cqx.setVisibility(0);
        eJ(true);
        this.cqC.setVisibility(0);
    }

    public void eL(boolean z) {
        if (this.cqM != null) {
            this.cqM.fa(z);
        }
    }

    private void aht() {
        if (this.cqN == null) {
            this.cqN = (GifView) this.cqt.mRootView.findViewById(d.h.gif_real_time);
            this.cqO = (TbImageView) this.cqt.mRootView.findViewById(d.h.tbimg_real_time);
            this.cqO.setPageId(this.cqt.getUniqueId());
            this.cqN.setLayerType(1, null);
            this.cqO.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ahu() {
        return this.cqv;
    }

    public void c(NoNetworkView.a aVar) {
        this.bIz = aVar;
        if (this.bIw != null) {
            this.bIw.a(this.bIz);
        }
    }

    public void cl(boolean z) {
        this.cqs = z;
        if (z) {
            if (this.cqM != null) {
                this.cqM.aiZ();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.cqC.getAdapter()).notifyDataSetChanged();
        if (this.cqM != null) {
            this.cqM.aja();
        }
    }

    public void eM(boolean z) {
        if (this.cqM != null) {
            if (z) {
                u(true, true);
            } else {
                u(true, false);
            }
        }
    }

    public void eN(boolean z) {
        if (this.cqM != null) {
            if (z) {
                u(false, true);
            } else {
                u(false, false);
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
        this.cqC.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.cqD.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.cqD.setForumName(str);
        this.mForumName = str;
    }

    public void cK(boolean z) {
        this.cqD.cK(z);
    }

    public void onDestroy() {
        if (this.cqQ != null) {
            this.cqQ.destroy();
        }
        this.cqD.onDestory();
        this.cqC.setOnSrollToBottomListener(null);
        this.cqC.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cqU);
        if (this.cdu != null) {
            this.cdu.onDestroy();
        }
        this.cqP.clear();
        if (this.cqL != null) {
            this.cqL.aje();
        }
        if (this.ceh != null) {
            this.ceh.setBackgroundDrawable(null);
        }
    }

    public boolean ahv() {
        if (this.cqL != null) {
            return this.cqL.ahv();
        }
        return false;
    }

    public boolean ahg() {
        return this.cqs;
    }

    public void NH() {
        this.cqC.setVisibility(0);
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
            com.baidu.tbadk.core.h.oS().cn(str);
        }
    }

    public void ahw() {
        if (this.cqD != null) {
            this.cqD.notifyDataSetChanged();
        }
    }

    public void Zb() {
        if (this.cqD instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cqD).Zb();
        }
    }

    private void ahx() {
        if (this.cqE == null && this.cqt.getPageContext() != null) {
            String[] strArr = {this.cqt.getPageContext().getPageActivity().getString(d.l.take_photo), this.cqt.getPageContext().getPageActivity().getString(d.l.album)};
            this.cqE = new com.baidu.tbadk.core.dialog.b(this.cqt.getPageContext().getPageActivity());
            this.cqE.cN(this.cqt.getPageContext().getPageActivity().getString(d.l.operation));
            this.cqE.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.cqt.ahh();
                    } else if (i == 1 && i.this.cqt.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.q(i.this.cqt.getPageContext().getPageActivity());
                    }
                }
            });
            this.cqE.d(this.cqt.getPageContext());
        }
    }

    public void ahy() {
        ahx();
        if (this.cqE != null) {
            this.cqE.tr();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tbadk.core.util.v.v(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.cqt != null && this.cqt.agI() != null && this.cqt.agI().akG() == 0) {
                kVar.iW(this.cqt.agI().akO());
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
                if (fVar instanceof bj) {
                    ((bj) fVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.cqD.b(arrayList, iVar);
        if (this.cqQ != null) {
            this.cqQ.a(this.cqk, this.bcY, this.cqJ, true);
        }
    }

    public BdTypeListView getListView() {
        return this.cqC;
    }

    public void ahz() {
        this.cqD.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cqt.getPageContext(), 1);
        aVar.a(this.cqC);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cqt.getForumName());
        hashMap.put("forum_id", this.cqt.getForumId());
        aVar.setParams(hashMap);
        aVar.I(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.cqL != null) {
            this.cqL.ajf();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.cqL != null) {
            this.cqL.ajg();
        }
    }

    public void release() {
        if (this.bIw != null && this.bIz != null) {
            this.bIw.b(this.bIz);
        }
    }

    public ImageView ahA() {
        return this.cqx;
    }

    public ImageView ahB() {
        return this.cqw;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cqt, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cqt.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.cqO != null) {
            this.cqO.invalidate();
        }
        if (this.cqD != null) {
            this.cqD.aiP();
            this.cqD.notifyDataSetChanged();
        }
        this.cqt.yi().getLayoutMode().ah(i == 1);
        this.cqt.yi().getLayoutMode().t(this.cqu);
        if (this.cqu != null) {
            com.baidu.tbadk.core.util.aj.e(this.cqu, d.e.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cqt.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cU(d.g.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.cqG, d.e.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.bIw != null) {
            this.bIw.onChangeSkinType(this.cqt.getPageContext(), i);
        }
        if (this.beq != null) {
            this.beq.dq(i);
        }
        eQ(false);
        if (this.cqM != null) {
            this.cqM.onChangeSkinType(i);
        }
        if (this.cqL != null) {
            this.cqL.onChangeSkinType(i);
        }
        if (this.ceh != null) {
            UtilHelper.setStatusBarBackground(this.ceh, i);
        }
        if (this.cqQ != null) {
            this.cqQ.a(this.cqk, this.bcY, this.cqJ, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
    }

    public void startPullRefresh() {
        this.cqC.startPullRefresh();
    }

    public void ahC() {
        this.cqC.completePullRefreshPostDelayed(2000L);
    }

    public boolean ahD() {
        return this.cqy != null && this.cqB.getVisibility() == 0;
    }

    public void ahE() {
        if (this.cqy != null) {
            this.cqz.setVisibility(0);
            this.cqB.setVisibility(8);
            this.cqA.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.cqU, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bq bqVar) {
        if (this.cqy == null) {
            this.cqy = (ViewStub) this.cqt.mRootView.findViewById(d.h.yule_game_egg_view_stub);
            this.cqy.setVisibility(0);
            this.cqz = (FrameLayout) this.cqt.mRootView.findViewById(d.h.game_activity_egg_layout);
            this.cqA = (TbImageView) this.cqt.mRootView.findViewById(d.h.game_activity_egg);
            this.cqB = (TbImageView) this.cqt.mRootView.findViewById(d.h.game_activity_egg_s);
            this.cqA.setPageId(this.cqt.getUniqueId());
            this.cqB.setPageId(this.cqt.getUniqueId());
            this.cqA.setDefaultBgResource(d.e.common_color_10022);
            this.cqA.setDefaultResource(0);
            this.cqB.setDefaultBgResource(d.e.common_color_10022);
            this.cqB.setDefaultResource(0);
            this.cqz.setOnClickListener(this.cqF);
        }
        this.cqz.setVisibility(0);
        String te = bqVar.te();
        String tf = bqVar.tf();
        this.cqA.c(te, 10, false);
        this.cqB.c(tf, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cqU, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void ahF() {
        if (this.cqy != null) {
            this.cqz.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q ahG() {
        return this.cqD;
    }

    public ViewGroup Xn() {
        return this.cqu;
    }

    public View ahH() {
        return this.cqH;
    }

    public void ahI() {
        if (r.Gx().Gy()) {
            int lastVisiblePosition = this.cqC.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cqC.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.crk != null) {
                        com.baidu.tbadk.l.l perfLog = mVar.crk.getPerfLog();
                        perfLog.fi(1000);
                        perfLog.aJF = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.crk.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.crk.wy();
                    }
                    if (mVar.cri != null && (mVar.cri instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.cri;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fi(1000);
                                perfLog2.aJF = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wy();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar ahe() {
        return this.mNavigationBar;
    }

    public void Xt() {
        this.mHasMore = true;
        this.cqC.setNextPage(this.beq);
        if (this.cqI > 0) {
            this.beq.dr(this.cqI);
        }
        this.beq.wV();
    }

    public void Xv() {
        this.mHasMore = false;
        this.cqC.setNextPage(this.beq);
        if (this.cqI > 0) {
            this.beq.dr(this.cqI);
        }
        this.beq.wW();
        this.beq.setText(this.cqt.getResources().getString(d.l.list_no_more));
    }

    public void Zc() {
        this.mHasMore = false;
        this.cqC.setNextPage(null);
    }

    public boolean YS() {
        return this.beq.getView().getParent() != null && this.mHasMore;
    }

    public void iS(int i) {
        this.cqI = i;
    }

    public void iT(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cdu == null) {
                    this.cdu = new CommonTipView(this.cqt.getActivity());
                }
                this.cdu.setText(d.l.frs_login_tip);
                this.cdu.a((FrameLayout) ahH(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eO(boolean z) {
        if (this.cqQ != null) {
            if (z) {
                this.cqQ.hF(false);
                this.cqQ.asj();
                return;
            }
            this.cqQ.hF(true);
            this.cqQ.a(this.cqk, this.bcY, this.cqJ, true);
        }
    }

    public void an(int i, int i2) {
        if (this.cqQ != null) {
            this.cqQ.a(i, i2, this.cqJ, 1);
        }
    }

    public void ao(int i, int i2) {
        this.cqk = i;
        this.bcY = i2;
    }

    public void eP(boolean z) {
        this.cqJ = z;
    }

    public void ahJ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.g.frs_star_navigation_bg);
        }
    }

    private void ahK() {
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

    private void eQ(boolean z) {
        boolean i = com.baidu.tieba.frs.h.f.i(this.cqt.ahf());
        boolean h = com.baidu.tieba.frs.h.f.h(this.cqt.ahf());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bzb) {
                    this.bzb = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.cqw, d.g.icon_sml_search_bg, d.g.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.cqx, d.g.btn_sml_more_bg, d.g.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.g.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bzb) {
                this.bzb = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.g.icon_return_bg_s, d.g.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.cqw, d.g.icon_search_bg_s, d.g.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.cqx, d.g.btn_more_selector_s, d.g.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        ahK();
    }

    public void eR(boolean z) {
        if (!this.cqC.bru()) {
            this.cqC.setStarForum(true);
            if (z && !this.cqt.ahi()) {
                this.mPullView = new com.baidu.tbadk.core.view.l(this.cqt.getPageContext());
                this.mPullView.setTag(this.cqt.getUniqueId());
                this.cqC.setPullRefresh(this.mPullView);
            }
        }
    }

    public void iU(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void iV(int i) {
        if (this.cqC != null && this.cqC.getChildCount() >= 0) {
            if (this.cqC.getFirstVisiblePosition() > 8) {
                this.cqC.setSelection(8);
            }
            this.cqC.smoothScrollToPosition(i);
        }
    }

    public void ahL() {
        a(this.cqS, this.cqt.ahi());
        if (this.cqD != null) {
            this.cqD.aiU();
        }
    }
}
