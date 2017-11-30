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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bl;
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
import com.baidu.tbadk.k.r;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class i {
    private PbListView blu;
    private ImageView btF;
    private View.OnClickListener cIA;
    private View cIB;
    private View cIC;
    private int cID;
    private View cIF;
    private com.baidu.tieba.frs.entelechy.b.e cIG;
    private com.baidu.tieba.frs.entelechy.b.c cIH;
    private GifView cII;
    private TbImageView cIJ;
    private HashSet<String> cIK;
    private com.baidu.tieba.play.m cIL;
    private ObservedChangeLinearLayout cIN;
    private com.baidu.tieba.frs.entelechy.b.a cIO;
    private com.baidu.tieba.video.e cIQ;
    private boolean cIS;
    private f cIp;
    private View cIr;
    private ImageView cIs;
    private ViewStub cIt;
    private com.baidu.tieba.frs.entelechy.a.u cIy;
    private NoNetworkView csW;
    private CommonTipView cuv;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean cIo = false;
    private NoPressedRelativeLayout cIq = null;
    private FrameLayout cIu = null;
    private TbImageView cIv = null;
    private TbImageView cIw = null;
    private BdExpandListView cIx = null;
    private com.baidu.tbadk.core.dialog.b cIz = null;
    private NoNetworkView.a cFo = null;
    private boolean mHasMore = true;
    private boolean cIE = false;
    private int cIg = 0;
    private int bjU = 0;
    private View cIM = null;
    private boolean bQA = true;
    private boolean cIP = true;
    private Runnable cIR = new Runnable() { // from class: com.baidu.tieba.frs.i.5
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cIt != null) {
                i.this.cIu.setVisibility(0);
                i.this.cIw.setVisibility(0);
                i.this.cIv.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout alA() {
        return this.cIN;
    }

    public View alB() {
        return this.cIM;
    }

    public i(f fVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.cIp = null;
        this.cIA = null;
        this.cID = 0;
        this.cIp = fVar;
        this.cIA = onClickListener;
        a(aVar, z);
        this.cIK = new HashSet<>();
        this.cID = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.cIO = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.cIp.getPageContext());
        }
        this.mPullView.setTag(this.cIp.getUniqueId());
        if (this.cIq == null) {
            this.cIq = (NoPressedRelativeLayout) this.cIp.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.cIq, d.C0082d.cp_bg_line_d);
        if (this.cIC == null) {
            this.cIC = this.cIp.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.cIN == null) {
            this.cIN = (ObservedChangeLinearLayout) this.cIp.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.cIN.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.i.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cIp.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cIp.aly()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cIB == null) {
            this.cIB = this.cIp.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b amZ = aVar.amZ();
            if (amZ != null) {
                amZ.aw(this.cIB);
            }
        }
        if (this.cIr == null) {
            this.cIr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cIr.setOnClickListener(this.cIA);
            this.mBackImageView = (ImageView) this.cIr.findViewById(d.g.widget_navi_back_button);
        }
        if (this.cIs == null) {
            this.cIs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.cIs.setOnClickListener(this.cIA);
            this.btF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.btF.setOnClickListener(this.cIA);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cIp.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0082d.cp_bg_line_b);
        }
        if (this.cIx == null) {
            this.cIx = (BdExpandListView) this.cIp.mRootView.findViewById(d.g.frs_lv_thread);
        }
        this.cIx.setScrollable(this.cIp);
        this.cIx.setFadingEdgeLength(0);
        this.cIx.setOverScrollMode(2);
        this.cIq.setBottomOrderView(this.cIx);
        this.cIx.setOnTouchListener(this.cIp.aNj);
        this.cIx.setDivider(null);
        this.cIx.setPullRefresh(this.mPullView);
        if (z && this.cIF == null) {
            this.cIF = BdListViewHelper.a(this.cIp.getActivity(), this.cIx, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cIx.setDividerHeight(0);
        this.cIx.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (i.this.cIL != null) {
                    i.this.cIL.aQ(view);
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
        if (this.blu == null) {
            this.blu = new PbListView(this.cIp.getPageContext().getPageActivity());
            this.blu.getView();
        }
        this.blu.dy(d.C0082d.cp_bg_line_e);
        this.blu.setHeight(com.baidu.adp.lib.util.l.f(this.cIp.getActivity(), d.e.tbds182));
        this.blu.wu();
        this.blu.setTextSize(d.e.tbds30);
        this.blu.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_cont_j));
        this.blu.dx(d.C0082d.cp_cont_e);
        this.cIx.setOnSrollToBottomListener(this.cIp);
        this.mNavigationBar.setOnTouchListener(new s(new s.a() { // from class: com.baidu.tieba.frs.i.3
            @Override // com.baidu.tieba.tbadkCore.s.a
            public void amg() {
                i.this.cIp.alt();
            }

            @Override // com.baidu.tieba.tbadkCore.s.a
            public void amh() {
                if (i.this.cIx != null) {
                    i.this.cIx.setSelection(0);
                    if (i.this.cIL != null) {
                        i.this.cIL.a(i.this.cIg, i.this.bjU, false, true);
                    }
                }
            }
        }));
        boolean vx = com.baidu.tbadk.core.util.an.vv().vx();
        if (this.cIy == null) {
            this.cIy = aVar.a(this.cIp, this.cIx, vx);
        }
        cj(false);
        if (!z) {
            if (this.csW == null) {
                this.csW = new NoNetworkView(this.cIp.getActivity());
                this.csW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.cIN.addView(this.csW);
            }
            if (com.baidu.adp.lib.util.j.gV()) {
                this.csW.setVisibility(8);
            } else {
                this.csW.setVisibility(0);
            }
            this.csW.onChangeSkinType(this.cIp.xQ(), TbadkCoreApplication.getInst().getSkinType());
        }
        alI();
        if (this.cIG == null) {
            this.cIG = aVar.c(this.cIp, this.cIq);
        }
        if (this.cIH == null) {
            this.cIH = aVar.b(this.cIp, this.cIq);
        }
        if (this.cIM == null) {
            this.cIM = this.cIp.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.cIL == null) {
            this.cIL = new com.baidu.tieba.play.m(this.cIp.getPageContext(), this.cIx);
        }
        this.cIL.setUniqueId(this.cIp.getUniqueId());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIF != null && this.cIF.getLayoutParams() != null) {
            this.cIF.getLayoutParams().height = i;
            this.cIF.setLayoutParams(this.cIF.getLayoutParams());
        }
    }

    public View alC() {
        return this.cIF;
    }

    public com.baidu.tieba.play.m alD() {
        return this.cIL;
    }

    public com.baidu.tieba.frs.entelechy.b.c alE() {
        return this.cIH;
    }

    public void eR(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.w(this.cIp.alv().buU());
        if (this.cIG != null) {
            this.cIG.eR(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e alF() {
        return this.cIG;
    }

    public void v(boolean z, boolean z2) {
        if (this.cIP && this.cIH != null) {
            this.cIH.v(z, z2);
        }
    }

    public void eS(boolean z) {
        this.cIP = z;
        if (!this.cIP && this.cIH != null) {
            this.cIH.v(false, false);
        }
    }

    public void alG() {
        if (this.cIP && this.cIH != null) {
            this.cIH.v(false, false);
        }
        this.cIs.setVisibility(8);
        this.btF.setVisibility(8);
        eR(false);
        this.cIx.setVisibility(8);
    }

    public void alH() {
        if (this.cIP && this.cIH != null) {
            this.cIH.v(true, false);
        }
        this.cIs.setVisibility(0);
        this.btF.setVisibility(0);
        eR(true);
        this.cIx.setVisibility(0);
    }

    public void eT(boolean z) {
        if (this.cIH != null) {
            this.cIH.fk(z);
        }
    }

    private void alI() {
        if (this.cII == null) {
            this.cII = (GifView) this.cIp.mRootView.findViewById(d.g.gif_real_time);
            this.cIJ = (TbImageView) this.cIp.mRootView.findViewById(d.g.tbimg_real_time);
            this.cIJ.setPageId(this.cIp.getUniqueId());
            this.cII.setLayerType(1, null);
            this.cIJ.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View alJ() {
        return this.cIr;
    }

    public void h(NoNetworkView.a aVar) {
        this.cFo = aVar;
        if (this.csW != null) {
            this.csW.a(this.cFo);
        }
    }

    public void cj(boolean z) {
        this.cIo = z;
        if (z) {
            if (this.cIH != null) {
                this.cIH.anG();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.cIx.getAdapter()).notifyDataSetChanged();
        if (this.cIH != null) {
            this.cIH.anH();
        }
    }

    public void eU(boolean z) {
        if (this.cIH != null) {
            if (z) {
                v(true, true);
            } else {
                v(true, false);
            }
        }
    }

    public void eV(boolean z) {
        if (this.cIH != null) {
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
        this.cIx.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.cIy.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.cIy.setForumName(str);
        this.mForumName = str;
    }

    public void cM(boolean z) {
        this.cIy.cM(z);
    }

    public void onDestroy() {
        if (this.cIL != null) {
            this.cIL.destroy();
        }
        this.cIy.onDestory();
        this.cIx.setOnSrollToBottomListener(null);
        this.cIx.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cIR);
        if (this.cuv != null) {
            this.cuv.onDestroy();
        }
        this.cIK.clear();
        if (this.cIG != null) {
            this.cIG.anL();
        }
        if (this.cIM != null) {
            this.cIM.setBackgroundDrawable(null);
        }
        if (this.cIQ != null) {
            this.cIQ.amU();
        }
    }

    public boolean alK() {
        if (this.cIG != null) {
            return this.cIG.alK();
        }
        return false;
    }

    public boolean alw() {
        return this.cIo;
    }

    public void PB() {
        this.cIx.setVisibility(0);
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
            com.baidu.tbadk.core.h.pa().cs(str);
        }
    }

    public void alL() {
        if (this.cIy != null) {
            this.cIy.notifyDataSetChanged();
        }
    }

    public void acW() {
        if (this.cIy instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cIy).acW();
        }
    }

    private void alM() {
        if (this.cIz == null && this.cIp.getPageContext() != null) {
            String[] strArr = {this.cIp.getPageContext().getPageActivity().getString(d.j.take_photo), this.cIp.getPageContext().getPageActivity().getString(d.j.album)};
            this.cIz = new com.baidu.tbadk.core.dialog.b(this.cIp.getPageContext().getPageActivity());
            this.cIz.cT(this.cIp.getPageContext().getPageActivity().getString(d.j.operation));
            this.cIz.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.i.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.cIp.alx();
                    } else if (i == 1 && i.this.cIp.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(i.this.cIp.getPageContext().getPageActivity());
                    }
                }
            });
            this.cIz.d(this.cIp.getPageContext());
        }
    }

    public void alN() {
        alM();
        if (this.cIz != null) {
            this.cIz.to();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.k kVar) {
        if (com.baidu.tbadk.core.util.v.w(arrayList)) {
            k kVar2 = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar2);
            if (this.cIp != null && this.cIp.akZ() != null && this.cIp.akZ().apK() == 0) {
                kVar2.jS(this.cIp.akZ().apS());
            }
        }
        if (com.baidu.tbadk.core.util.v.v(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = arrayList.get(i2);
                if (fVar instanceof bd) {
                    ((bd) fVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.cIy.b(arrayList, kVar);
        if (this.cIL != null) {
            this.cIL.a(this.cIg, this.bjU, this.cIE, true);
        }
    }

    public BdTypeListView getListView() {
        return this.cIx;
    }

    public void alO() {
        this.cIy.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cIp.getPageContext(), 1);
        aVar.a(this.cIx);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cIp.getForumName());
        hashMap.put("forum_id", this.cIp.getForumId());
        aVar.setParams(hashMap);
        aVar.H(uVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.cIG != null) {
            this.cIG.anM();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.cIG != null) {
            this.cIG.anN();
        }
    }

    public void release() {
        if (this.csW != null && this.cFo != null) {
            this.csW.b(this.cFo);
        }
    }

    public ImageView alP() {
        return this.btF;
    }

    public ImageView alQ() {
        return this.cIs;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cIp, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cIp.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.cIJ != null) {
            this.cIJ.invalidate();
        }
        if (this.cIy != null) {
            this.cIy.anv();
            this.cIy.notifyDataSetChanged();
        }
        this.cIp.xQ().getLayoutMode().ag(i == 1);
        this.cIp.xQ().getLayoutMode().t(this.cIq);
        if (this.cIq != null) {
            com.baidu.tbadk.core.util.aj.e(this.cIq, d.C0082d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cIp.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cS(d.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.cIB, d.C0082d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0082d.cp_bg_line_b);
        }
        if (this.csW != null) {
            this.csW.onChangeSkinType(this.cIp.getPageContext(), i);
        }
        if (this.blu != null) {
            this.blu.dz(i);
        }
        eY(false);
        if (this.cIH != null) {
            this.cIH.onChangeSkinType(i);
        }
        if (this.cIG != null) {
            this.cIG.onChangeSkinType(i);
        }
        if (this.cIM != null) {
            UtilHelper.setStatusBarBackground(this.cIM, i);
        }
        if (this.cIL != null) {
            this.cIL.a(this.cIg, this.bjU, this.cIE, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public void startPullRefresh() {
        this.cIx.startPullRefresh();
    }

    public void alR() {
        this.cIx.completePullRefreshPostDelayed(2000L);
    }

    public boolean alS() {
        return this.cIt != null && this.cIw.getVisibility() == 0;
    }

    public void alT() {
        if (this.cIt != null) {
            this.cIu.setVisibility(0);
            this.cIw.setVisibility(8);
            this.cIv.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.cIR, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bl blVar) {
        if (this.cIt == null) {
            this.cIt = (ViewStub) this.cIp.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.cIt.setVisibility(0);
            this.cIu = (FrameLayout) this.cIp.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.cIv = (TbImageView) this.cIp.mRootView.findViewById(d.g.game_activity_egg);
            this.cIw = (TbImageView) this.cIp.mRootView.findViewById(d.g.game_activity_egg_s);
            this.cIv.setPageId(this.cIp.getUniqueId());
            this.cIw.setPageId(this.cIp.getUniqueId());
            this.cIv.setDefaultBgResource(d.C0082d.common_color_10022);
            this.cIv.setDefaultResource(0);
            this.cIw.setDefaultBgResource(d.C0082d.common_color_10022);
            this.cIw.setDefaultResource(0);
            this.cIu.setOnClickListener(this.cIA);
        }
        this.cIu.setVisibility(0);
        String ta = blVar.ta();
        String tb = blVar.tb();
        this.cIv.startLoad(ta, 10, false);
        this.cIw.startLoad(tb, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cIR, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void alU() {
        if (this.cIt != null) {
            this.cIu.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.u alV() {
        return this.cIy;
    }

    public ViewGroup WP() {
        return this.cIq;
    }

    public View alW() {
        return this.cIC;
    }

    public void alX() {
        if (r.GA().GB()) {
            int lastVisiblePosition = this.cIx.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cIx.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.cJh != null) {
                        com.baidu.tbadk.k.l perfLog = mVar.cJh.getPerfLog();
                        perfLog.fr(1000);
                        perfLog.aKj = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.cJh.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.cJh.startLogPerf();
                    }
                    if (mVar.cJf != null && (mVar.cJf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.cJf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fr(1000);
                                perfLog2.aKj = true;
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

    public NavigationBar alu() {
        return this.mNavigationBar;
    }

    public void alY() {
        this.mHasMore = true;
        this.cIx.setNextPage(this.blu);
        if (this.cID > 0) {
            this.blu.dB(d.C0082d.cp_bg_line_d);
            this.blu.dA(this.cID);
        }
        this.blu.setOnClickListener(null);
        this.blu.wx();
    }

    public void alZ() {
        this.mHasMore = false;
        this.cIx.setNextPage(this.blu);
        if (this.cID > 0) {
            this.blu.dB(d.C0082d.cp_bg_line_d);
            this.blu.dA(this.cID);
        }
        this.blu.setOnClickListener(null);
        this.blu.wy();
        this.blu.setText(this.cIp.getResources().getString(d.j.list_no_more));
    }

    public void ama() {
        this.mHasMore = true;
        this.cIx.setNextPage(this.blu);
        this.blu.setOnClickListener(this.cIA);
        if (this.cID > 0) {
            this.blu.dB(d.C0082d.cp_bg_line_d);
            this.blu.dA(this.cID);
        }
        this.blu.wy();
        this.blu.setText(this.cIp.getResources().getString(d.j.list_click_load_more));
    }

    public View amb() {
        if (this.blu == null) {
            return null;
        }
        return this.blu.getView();
    }

    public void acX() {
        this.mHasMore = false;
        this.cIx.setNextPage(null);
    }

    public boolean acN() {
        return this.blu.getView().getParent() != null && this.mHasMore;
    }

    public void jO(int i) {
        this.cID = i;
    }

    public void jP(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cuv == null) {
                    this.cuv = new CommonTipView(this.cIp.getActivity());
                }
                this.cuv.setText(d.j.frs_login_tip);
                this.cuv.show((FrameLayout) alW(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eW(boolean z) {
        if (this.cIL != null) {
            if (z) {
                this.cIL.hI(false);
                this.cIL.avl();
                return;
            }
            this.cIL.hI(true);
            this.cIL.a(this.cIg, this.bjU, this.cIE, true);
        }
    }

    public void ax(int i, int i2) {
        if (this.cIL != null) {
            this.cIL.a(i, i2, this.cIE, 1);
        }
    }

    public void ay(int i, int i2) {
        this.cIg = i;
        this.bjU = i2;
    }

    public void eX(boolean z) {
        this.cIE = z;
    }

    public void amc() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
        }
    }

    private void amd() {
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

    private void eY(boolean z) {
        boolean i = com.baidu.tieba.frs.g.f.i(this.cIp.alv());
        boolean h = com.baidu.tieba.frs.g.f.h(this.cIp.alv());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bQA) {
                    this.bQA = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.cIs, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.btF, d.f.btn_sml_more_bg, d.f.btn_sml_more_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bQA) {
                this.bQA = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.cIs, d.f.icon_search_bg_s, d.f.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.btF, d.f.btn_more_selector_s, d.f.btn_more_selector);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        amd();
    }

    public void eZ(boolean z) {
        if (!this.cIx.bvv()) {
            this.cIx.setStarForum(true);
            if (z && !this.cIp.aly()) {
                this.mPullView = new com.baidu.tbadk.core.view.h(this.cIp.getPageContext());
                this.mPullView.setTag(this.cIp.getUniqueId());
                this.cIx.setPullRefresh(this.mPullView);
            }
        }
    }

    public void jQ(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void jR(int i) {
        if (this.cIx != null && this.cIx.getChildCount() >= 0) {
            if (this.cIx.getFirstVisiblePosition() > 8) {
                this.cIx.setSelection(8);
            }
            this.cIx.smoothScrollToPosition(i);
        }
    }

    public void ame() {
        a(this.cIO, this.cIp.aly());
        if (this.cIy != null) {
            this.cIy.anA();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.cIQ == null) {
                this.cIQ = new com.baidu.tieba.video.e(this.cIp.getActivity(), this.cIq);
            }
            this.cIQ.g(postWriteCallBackData);
        }
    }

    public void amf() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.cIS && this.cIp.getActivity() != null && this.cIp.getPageContext() != null) {
            View view = null;
            if (this.cIx != null && (headerViewsCount = this.cIx.getHeaderViewsCount()) < this.cIx.getChildCount()) {
                view = this.cIx.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).ad(0).A(true).B(false).z(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.i.6
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        i.this.cIp.getPageContext().getLayoutMode().t(inflate);
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
                        return com.baidu.adp.lib.util.l.f(i.this.cIp.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.f(i.this.cIp.getActivity(), d.e.ds6);
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
                eY.j(this.cIp.getActivity());
                com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eY != null) {
                            eY.dismiss();
                        }
                    }
                }, 4000L);
                this.cIS = true;
            }
        }
    }
}
