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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class j {
    private PbListView blz;
    private ImageView btK;
    private g cIC;
    private View cIE;
    private ImageView cIF;
    private ViewStub cIG;
    private u cIL;
    private View.OnClickListener cIN;
    private View cIO;
    private View cIP;
    private int cIQ;
    private View cIS;
    private com.baidu.tieba.frs.entelechy.b.e cIT;
    private com.baidu.tieba.frs.entelechy.b.c cIU;
    private com.baidu.tieba.frs.g.i cIV;
    private GifView cIW;
    private TbImageView cIX;
    private HashSet<String> cIY;
    private com.baidu.tieba.play.m cIZ;
    private ObservedChangeLinearLayout cJb;
    private com.baidu.tieba.frs.entelechy.b.a cJc;
    private com.baidu.tieba.video.e cJe;
    private boolean cJg;
    private NoNetworkView ctj;
    private CommonTipView cuI;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean cIB = false;
    private NoPressedRelativeLayout cID = null;
    private FrameLayout cIH = null;
    private TbImageView cII = null;
    private TbImageView cIJ = null;
    private BdExpandListView cIK = null;
    private com.baidu.tbadk.core.dialog.b cIM = null;
    private NoNetworkView.a cFA = null;
    private boolean mHasMore = true;
    private boolean cIR = false;
    private int cIt = 0;
    private int bjZ = 0;
    private View cJa = null;
    private boolean bQI = true;
    private boolean cJd = true;
    private Runnable cJf = new Runnable() { // from class: com.baidu.tieba.frs.j.5
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.cIG != null) {
                j.this.cIH.setVisibility(0);
                j.this.cIJ.setVisibility(0);
                j.this.cII.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout alJ() {
        return this.cJb;
    }

    public View alK() {
        return this.cJa;
    }

    public j(g gVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.cIC = null;
        this.cIN = null;
        this.cIQ = 0;
        this.cIC = gVar;
        this.cIN = onClickListener;
        a(aVar, z);
        this.cIY = new HashSet<>();
        this.cIQ = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.cJc = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.cIC.getPageContext());
        }
        this.mPullView.setTag(this.cIC.getUniqueId());
        if (this.cID == null) {
            this.cID = (NoPressedRelativeLayout) this.cIC.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.cID, d.C0095d.cp_bg_line_d);
        if (this.cIP == null) {
            this.cIP = this.cIC.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.cJb == null) {
            this.cJb = (ObservedChangeLinearLayout) this.cIC.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.cJb.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.j.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        j.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cIC.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cIC.alH()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cIO == null) {
            this.cIO = this.cIC.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b ani = aVar.ani();
            if (ani != null) {
                ani.ay(this.cIO);
            }
        }
        if (this.cIE == null) {
            this.cIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cIE.setOnClickListener(this.cIN);
            this.mBackImageView = (ImageView) this.cIE.findViewById(d.g.widget_navi_back_button);
        }
        if (this.cIF == null) {
            this.cIF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.cIF.setOnClickListener(this.cIN);
            this.btK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.btK.setOnClickListener(this.cIN);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cIC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0095d.cp_bg_line_b);
        }
        if (this.cIK == null) {
            this.cIK = (BdExpandListView) this.cIC.mRootView.findViewById(d.g.frs_lv_thread);
        }
        this.cIK.setScrollable(this.cIC);
        this.cIK.setFadingEdgeLength(0);
        this.cIK.setOverScrollMode(2);
        this.cID.setBottomOrderView(this.cIK);
        this.cIK.setOnTouchListener(this.cIC.aNp);
        this.cIK.setDivider(null);
        this.cIK.setPullRefresh(this.mPullView);
        if (z && this.cIS == null) {
            this.cIS = BdListViewHelper.a(this.cIC.getActivity(), this.cIK, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cIK.setDividerHeight(0);
        this.cIK.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.j.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (j.this.cIZ != null) {
                    j.this.cIZ.aU(view);
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
        if (this.blz == null) {
            this.blz = new PbListView(this.cIC.getPageContext().getPageActivity());
            this.blz.getView();
        }
        this.blz.dy(d.C0095d.cp_bg_line_e);
        this.blz.setHeight(com.baidu.adp.lib.util.l.f(this.cIC.getActivity(), d.e.tbds182));
        this.blz.ws();
        this.blz.setTextSize(d.e.tbds30);
        this.blz.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_cont_j));
        this.blz.dx(d.C0095d.cp_cont_e);
        this.cIK.setOnSrollToBottomListener(this.cIC);
        this.mNavigationBar.setOnTouchListener(new s(new s.a() { // from class: com.baidu.tieba.frs.j.3
            @Override // com.baidu.tieba.tbadkCore.s.a
            public void amp() {
                j.this.cIC.alC();
            }

            @Override // com.baidu.tieba.tbadkCore.s.a
            public void amq() {
                if (j.this.cIK != null) {
                    j.this.cIK.setSelection(0);
                    if (j.this.cIZ != null) {
                        j.this.cIZ.a(j.this.cIt, j.this.bjZ, false, true);
                    }
                }
            }
        }));
        boolean vu = com.baidu.tbadk.core.util.an.vs().vu();
        if (this.cIL == null) {
            this.cIL = aVar.a(this.cIC, this.cIK, vu);
        }
        ck(false);
        if (!z) {
            if (this.ctj == null) {
                this.ctj = new NoNetworkView(this.cIC.getActivity());
                this.ctj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.cJb.addView(this.ctj);
            }
            if (com.baidu.adp.lib.util.j.gV()) {
                this.ctj.setVisibility(8);
            } else {
                this.ctj.setVisibility(0);
            }
            this.ctj.onChangeSkinType(this.cIC.xR(), TbadkCoreApplication.getInst().getSkinType());
        }
        alR();
        if (this.cIT == null) {
            this.cIT = aVar.c(this.cIC, this.cID);
        }
        if (this.cIU == null) {
            this.cIU = aVar.b(this.cIC, this.cID);
        }
        if (this.cJa == null) {
            this.cJa = this.cIC.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.cIZ == null) {
            this.cIZ = new com.baidu.tieba.play.m(this.cIC.getPageContext(), this.cIK);
        }
        this.cIZ.setUniqueId(this.cIC.getUniqueId());
        if (this.cIV == null) {
            this.cIV = new com.baidu.tieba.frs.g.i(this.cIC, (NavigationBarCoverTip) this.cIC.mRootView.findViewById(d.g.navigation_cover_tip));
        }
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIS != null && this.cIS.getLayoutParams() != null) {
            this.cIS.getLayoutParams().height = i;
            this.cIS.setLayoutParams(this.cIS.getLayoutParams());
        }
    }

    public void lc(String str) {
        if (this.cIV != null) {
            this.cIV.lc(str);
        }
    }

    public View alL() {
        return this.cIS;
    }

    public com.baidu.tieba.play.m alM() {
        return this.cIZ;
    }

    public com.baidu.tieba.frs.entelechy.b.c alN() {
        return this.cIU;
    }

    public void eS(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.w(this.cIC.alE().bvB());
        if (this.cIT != null) {
            this.cIT.eS(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e alO() {
        return this.cIT;
    }

    public void v(boolean z, boolean z2) {
        if (this.cJd && this.cIU != null) {
            this.cIU.v(z, z2);
        }
    }

    public void eT(boolean z) {
        this.cJd = z;
        if (!this.cJd && this.cIU != null) {
            this.cIU.v(false, false);
        }
    }

    public void alP() {
        if (this.cJd && this.cIU != null) {
            this.cIU.v(false, false);
        }
        this.cIF.setVisibility(8);
        this.btK.setVisibility(8);
        eS(false);
        this.cIK.setVisibility(8);
    }

    public void alQ() {
        if (this.cJd && this.cIU != null) {
            this.cIU.v(true, false);
        }
        this.cIF.setVisibility(0);
        this.btK.setVisibility(0);
        eS(true);
        this.cIK.setVisibility(0);
    }

    public void eU(boolean z) {
        if (this.cIU != null) {
            this.cIU.fl(z);
        }
    }

    private void alR() {
        if (this.cIW == null) {
            this.cIW = (GifView) this.cIC.mRootView.findViewById(d.g.gif_real_time);
            this.cIX = (TbImageView) this.cIC.mRootView.findViewById(d.g.tbimg_real_time);
            this.cIX.setPageId(this.cIC.getUniqueId());
            this.cIW.setLayerType(1, null);
            this.cIX.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View alS() {
        return this.cIE;
    }

    public void h(NoNetworkView.a aVar) {
        this.cFA = aVar;
        if (this.ctj != null) {
            this.ctj.a(this.cFA);
        }
    }

    public void ck(boolean z) {
        this.cIB = z;
        if (z) {
            if (this.cIU != null) {
                this.cIU.anP();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.cIK.getAdapter()).notifyDataSetChanged();
        if (this.cIU != null) {
            this.cIU.anQ();
        }
    }

    public void eV(boolean z) {
        if (this.cIU != null) {
            if (z) {
                v(true, true);
            } else {
                v(true, false);
            }
        }
    }

    public void eW(boolean z) {
        if (this.cIU != null) {
            if (z) {
                v(false, true);
            } else {
                v(false, false);
            }
        }
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(h.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(h.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.cIK.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.cIL.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.cIL.setForumName(str);
        this.mForumName = str;
    }

    public void cN(boolean z) {
        this.cIL.cN(z);
    }

    public void onDestroy() {
        if (this.cIZ != null) {
            this.cIZ.destroy();
        }
        if (this.cIV != null) {
            this.cIV.onDestory();
        }
        this.cIL.onDestory();
        this.cIK.setOnSrollToBottomListener(null);
        this.cIK.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cJf);
        if (this.cuI != null) {
            this.cuI.onDestroy();
        }
        this.cIY.clear();
        if (this.cIT != null) {
            this.cIT.anU();
        }
        if (this.cJa != null) {
            this.cJa.setBackgroundDrawable(null);
        }
        if (this.cJe != null) {
            this.cJe.and();
        }
    }

    public boolean alT() {
        if (this.cIT != null) {
            return this.cIT.alT();
        }
        return false;
    }

    public boolean alF() {
        return this.cIB;
    }

    public void PB() {
        this.cIK.setVisibility(0);
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
            com.baidu.tbadk.core.h.oY().cs(str);
        }
    }

    public void alU() {
        if (this.cIL != null) {
            this.cIL.notifyDataSetChanged();
        }
    }

    public void adf() {
        if (this.cIL instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cIL).adf();
        }
    }

    private void alV() {
        if (this.cIM == null && this.cIC.getPageContext() != null) {
            String[] strArr = {this.cIC.getPageContext().getPageActivity().getString(d.j.take_photo), this.cIC.getPageContext().getPageActivity().getString(d.j.album)};
            this.cIM = new com.baidu.tbadk.core.dialog.b(this.cIC.getPageContext().getPageActivity());
            this.cIM.cT(this.cIC.getPageContext().getPageActivity().getString(d.j.operation));
            this.cIM.a(strArr, new b.InterfaceC0060b() { // from class: com.baidu.tieba.frs.j.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        j.this.cIC.alG();
                    } else if (i == 1 && j.this.cIC.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(j.this.cIC.getPageContext().getPageActivity());
                    }
                }
            });
            this.cIM.d(this.cIC.getPageContext());
        }
    }

    public void alW() {
        alV();
        if (this.cIM != null) {
            this.cIM.tl();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.k kVar) {
        if (com.baidu.tbadk.core.util.v.w(arrayList)) {
            l lVar = new l();
            arrayList = new ArrayList<>();
            arrayList.add(lVar);
            if (this.cIC != null && this.cIC.ali() != null && this.cIC.ali().apT() == 0) {
                lVar.jU(this.cIC.ali().aqb());
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
        this.cIL.b(arrayList, kVar);
        if (this.cIZ != null) {
            this.cIZ.a(this.cIt, this.bjZ, this.cIR, true);
        }
    }

    public BdTypeListView getListView() {
        return this.cIK;
    }

    public void alX() {
        this.cIL.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cIC.getPageContext(), 1);
        aVar.a(this.cIK);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cIC.getForumName());
        hashMap.put("forum_id", this.cIC.getForumId());
        aVar.setParams(hashMap);
        aVar.H(uVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.cIT != null) {
            this.cIT.anV();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.cIT != null) {
            this.cIT.anW();
        }
    }

    public void release() {
        if (this.ctj != null && this.cFA != null) {
            this.ctj.b(this.cFA);
        }
    }

    public ImageView alY() {
        return this.btK;
    }

    public ImageView alZ() {
        return this.cIF;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cIC, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cIC.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.cIX != null) {
            this.cIX.invalidate();
        }
        if (this.cIL != null) {
            this.cIL.anE();
            this.cIL.notifyDataSetChanged();
        }
        this.cIC.xR().getLayoutMode().ag(i == 1);
        this.cIC.xR().getLayoutMode().t(this.cID);
        if (this.cID != null) {
            com.baidu.tbadk.core.util.aj.e(this.cID, d.C0095d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cIC.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cS(d.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.cIO, d.C0095d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0095d.cp_bg_line_b);
        }
        if (this.ctj != null) {
            this.ctj.onChangeSkinType(this.cIC.getPageContext(), i);
        }
        if (this.blz != null) {
            this.blz.dz(i);
        }
        eZ(false);
        if (this.cIU != null) {
            this.cIU.onChangeSkinType(i);
        }
        if (this.cIT != null) {
            this.cIT.onChangeSkinType(i);
        }
        if (this.cJa != null) {
            UtilHelper.setStatusBarBackground(this.cJa, i);
        }
        if (this.cIZ != null) {
            this.cIZ.a(this.cIt, this.bjZ, this.cIR, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public void startPullRefresh() {
        this.cIK.startPullRefresh();
    }

    public void ama() {
        this.cIK.completePullRefreshPostDelayed(2000L);
    }

    public boolean amb() {
        return this.cIG != null && this.cIJ.getVisibility() == 0;
    }

    public void amc() {
        if (this.cIG != null) {
            this.cIH.setVisibility(0);
            this.cIJ.setVisibility(8);
            this.cII.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.cJf, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bl blVar) {
        if (this.cIG == null) {
            this.cIG = (ViewStub) this.cIC.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.cIG.setVisibility(0);
            this.cIH = (FrameLayout) this.cIC.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.cII = (TbImageView) this.cIC.mRootView.findViewById(d.g.game_activity_egg);
            this.cIJ = (TbImageView) this.cIC.mRootView.findViewById(d.g.game_activity_egg_s);
            this.cII.setPageId(this.cIC.getUniqueId());
            this.cIJ.setPageId(this.cIC.getUniqueId());
            this.cII.setDefaultBgResource(d.C0095d.common_color_10022);
            this.cII.setDefaultResource(0);
            this.cIJ.setDefaultBgResource(d.C0095d.common_color_10022);
            this.cIJ.setDefaultResource(0);
            this.cIH.setOnClickListener(this.cIN);
        }
        this.cIH.setVisibility(0);
        String sX = blVar.sX();
        String sY = blVar.sY();
        this.cII.startLoad(sX, 10, false);
        this.cIJ.startLoad(sY, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cJf, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void amd() {
        if (this.cIG != null) {
            this.cIH.setVisibility(8);
        }
    }

    public u ame() {
        return this.cIL;
    }

    public ViewGroup WQ() {
        return this.cID;
    }

    public View amf() {
        return this.cIP;
    }

    public void amg() {
        if (com.baidu.tbadk.k.r.GB().GC()) {
            int lastVisiblePosition = this.cIK.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cIK.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof n)) {
                    n nVar = (n) childAt.getTag();
                    if (nVar.cJv != null) {
                        com.baidu.tbadk.k.l perfLog = nVar.cJv.getPerfLog();
                        perfLog.fr(1000);
                        perfLog.aKq = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            nVar.cJv.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        nVar.cJv.startLogPerf();
                    }
                    if (nVar.cJt != null && (nVar.cJt instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = nVar.cJt;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fr(1000);
                                perfLog2.aKq = true;
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

    public NavigationBar alD() {
        return this.mNavigationBar;
    }

    public void amh() {
        this.mHasMore = true;
        this.cIK.setNextPage(this.blz);
        if (this.cIQ > 0) {
            this.blz.dB(d.C0095d.cp_bg_line_d);
            this.blz.dA(this.cIQ);
        }
        this.blz.setOnClickListener(null);
        this.blz.wv();
    }

    public void ami() {
        this.mHasMore = false;
        this.cIK.setNextPage(this.blz);
        if (this.cIQ > 0) {
            this.blz.dB(d.C0095d.cp_bg_line_d);
            this.blz.dA(this.cIQ);
        }
        this.blz.setOnClickListener(null);
        this.blz.ww();
        this.blz.setText(this.cIC.getResources().getString(d.j.list_no_more));
    }

    public void amj() {
        this.mHasMore = true;
        this.cIK.setNextPage(this.blz);
        this.blz.setOnClickListener(this.cIN);
        if (this.cIQ > 0) {
            this.blz.dB(d.C0095d.cp_bg_line_d);
            this.blz.dA(this.cIQ);
        }
        this.blz.ww();
        this.blz.setText(this.cIC.getResources().getString(d.j.list_click_load_more));
    }

    public View amk() {
        if (this.blz == null) {
            return null;
        }
        return this.blz.getView();
    }

    public void adg() {
        this.mHasMore = false;
        this.cIK.setNextPage(null);
    }

    public boolean acW() {
        return this.blz.getView().getParent() != null && this.mHasMore;
    }

    public void jQ(int i) {
        this.cIQ = i;
    }

    public void jR(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cuI == null) {
                    this.cuI = new CommonTipView(this.cIC.getActivity());
                }
                this.cuI.setText(d.j.frs_login_tip);
                this.cuI.show((FrameLayout) amf(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eX(boolean z) {
        if (this.cIZ != null) {
            if (z) {
                this.cIZ.hJ(false);
                this.cIZ.avu();
                return;
            }
            this.cIZ.hJ(true);
            this.cIZ.a(this.cIt, this.bjZ, this.cIR, true);
        }
    }

    public void ay(int i, int i2) {
        if (this.cIZ != null) {
            this.cIZ.a(i, i2, this.cIR, 1);
        }
    }

    public void az(int i, int i2) {
        this.cIt = i;
        this.bjZ = i2;
    }

    public void eY(boolean z) {
        this.cIR = z;
    }

    public void aml() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
        }
    }

    private void amm() {
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

    private void eZ(boolean z) {
        boolean j = com.baidu.tieba.frs.g.f.j(this.cIC.alE());
        boolean i = com.baidu.tieba.frs.g.f.i(this.cIC.alE());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bQI) {
                    this.bQI = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.cIF, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.btK, d.f.btn_sml_more_bg, d.f.btn_sml_more_bg);
                    if (j && !i) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bQI) {
                this.bQI = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.cIF, d.f.icon_search_bg_s, d.f.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.btK, d.f.btn_more_selector_s, d.f.btn_more_selector);
                if (j) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        amm();
    }

    public void fa(boolean z) {
        if (!this.cIK.bwc()) {
            this.cIK.setStarForum(true);
            if (z && !this.cIC.alH()) {
                this.mPullView = new com.baidu.tbadk.core.view.i(this.cIC.getPageContext());
                this.mPullView.setTag(this.cIC.getUniqueId());
                this.cIK.setPullRefresh(this.mPullView);
            }
        }
    }

    public void jS(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void jT(int i) {
        if (this.cIK != null && this.cIK.getChildCount() >= 0) {
            if (this.cIK.getFirstVisiblePosition() > 8) {
                this.cIK.setSelection(8);
            }
            this.cIK.smoothScrollToPosition(i);
        }
    }

    public void amn() {
        a(this.cJc, this.cIC.alH());
        if (this.cIL != null) {
            this.cIL.anJ();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.cJe == null) {
                this.cJe = new com.baidu.tieba.video.e(this.cIC.getActivity(), this.cID);
            }
            this.cJe.g(postWriteCallBackData);
        }
    }

    public void amo() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.cJg && this.cIC.getActivity() != null && this.cIC.getPageContext() != null) {
            View view = null;
            if (this.cIK != null && (headerViewsCount = this.cIK.getHeaderViewsCount()) < this.cIK.getChildCount()) {
                view = this.cIK.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).ac(0).A(true).B(false).z(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.j.6
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        j.this.cIC.getPageContext().getLayoutMode().t(inflate);
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
                        return com.baidu.adp.lib.util.l.f(j.this.cIC.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.f(j.this.cIC.getActivity(), d.e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.j.7
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
                eY.j(this.cIC.getActivity());
                com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eY != null) {
                            eY.dismiss();
                        }
                    }
                }, 4000L);
                this.cJg = true;
            }
        }
    }
}
