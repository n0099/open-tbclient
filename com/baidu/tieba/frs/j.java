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
    private PbListView blv;
    private ImageView btG;
    private View cIA;
    private ImageView cIB;
    private ViewStub cIC;
    private u cIH;
    private View.OnClickListener cIJ;
    private View cIK;
    private View cIL;
    private int cIM;
    private View cIO;
    private com.baidu.tieba.frs.entelechy.b.e cIP;
    private com.baidu.tieba.frs.entelechy.b.c cIQ;
    private com.baidu.tieba.frs.g.i cIR;
    private GifView cIS;
    private TbImageView cIT;
    private HashSet<String> cIU;
    private com.baidu.tieba.play.m cIV;
    private ObservedChangeLinearLayout cIX;
    private com.baidu.tieba.frs.entelechy.b.a cIY;
    private g cIy;
    private com.baidu.tieba.video.e cJa;
    private boolean cJc;
    private NoNetworkView ctf;
    private CommonTipView cuE;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean cIx = false;
    private NoPressedRelativeLayout cIz = null;
    private FrameLayout cID = null;
    private TbImageView cIE = null;
    private TbImageView cIF = null;
    private BdExpandListView cIG = null;
    private com.baidu.tbadk.core.dialog.b cII = null;
    private NoNetworkView.a cFw = null;
    private boolean mHasMore = true;
    private boolean cIN = false;
    private int cIp = 0;
    private int bjV = 0;
    private View cIW = null;
    private boolean bQE = true;
    private boolean cIZ = true;
    private Runnable cJb = new Runnable() { // from class: com.baidu.tieba.frs.j.5
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.cIC != null) {
                j.this.cID.setVisibility(0);
                j.this.cIF.setVisibility(0);
                j.this.cIE.setVisibility(8);
            }
        }
    };

    public ObservedChangeLinearLayout alI() {
        return this.cIX;
    }

    public View alJ() {
        return this.cIW;
    }

    public j(g gVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.cIy = null;
        this.cIJ = null;
        this.cIM = 0;
        this.cIy = gVar;
        this.cIJ = onClickListener;
        a(aVar, z);
        this.cIU = new HashSet<>();
        this.cIM = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.cIY = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.cIy.getPageContext());
        }
        this.mPullView.setTag(this.cIy.getUniqueId());
        if (this.cIz == null) {
            this.cIz = (NoPressedRelativeLayout) this.cIy.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.k(this.cIz, d.C0096d.cp_bg_line_d);
        if (this.cIL == null) {
            this.cIL = this.cIy.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.cIX == null) {
            this.cIX = (ObservedChangeLinearLayout) this.cIy.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.cIX.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.j.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        j.this.setHeaderViewHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cIy.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cIy.alG()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cIK == null) {
            this.cIK = this.cIy.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b anh = aVar.anh();
            if (anh != null) {
                anh.ay(this.cIK);
            }
        }
        if (this.cIA == null) {
            this.cIA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cIA.setOnClickListener(this.cIJ);
            this.mBackImageView = (ImageView) this.cIA.findViewById(d.g.widget_navi_back_button);
        }
        if (this.cIB == null) {
            this.cIB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.cIB.setOnClickListener(this.cIJ);
            this.btG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.btG.setOnClickListener(this.cIJ);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cIy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0096d.cp_bg_line_b);
        }
        if (this.cIG == null) {
            this.cIG = (BdExpandListView) this.cIy.mRootView.findViewById(d.g.frs_lv_thread);
        }
        this.cIG.setScrollable(this.cIy);
        this.cIG.setFadingEdgeLength(0);
        this.cIG.setOverScrollMode(2);
        this.cIz.setBottomOrderView(this.cIG);
        this.cIG.setOnTouchListener(this.cIy.aNm);
        this.cIG.setDivider(null);
        this.cIG.setPullRefresh(this.mPullView);
        if (z && this.cIO == null) {
            this.cIO = BdListViewHelper.a(this.cIy.getActivity(), this.cIG, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cIG.setDividerHeight(0);
        this.cIG.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.frs.j.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (j.this.cIV != null) {
                    j.this.cIV.aU(view);
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
        if (this.blv == null) {
            this.blv = new PbListView(this.cIy.getPageContext().getPageActivity());
            this.blv.getView();
        }
        this.blv.dy(d.C0096d.cp_bg_line_e);
        this.blv.setHeight(com.baidu.adp.lib.util.l.f(this.cIy.getActivity(), d.e.tbds182));
        this.blv.ws();
        this.blv.setTextSize(d.e.tbds30);
        this.blv.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_cont_j));
        this.blv.dx(d.C0096d.cp_cont_e);
        this.cIG.setOnSrollToBottomListener(this.cIy);
        this.mNavigationBar.setOnTouchListener(new s(new s.a() { // from class: com.baidu.tieba.frs.j.3
            @Override // com.baidu.tieba.tbadkCore.s.a
            public void amo() {
                j.this.cIy.alC();
            }

            @Override // com.baidu.tieba.tbadkCore.s.a
            public void amp() {
                if (j.this.cIG != null) {
                    j.this.cIG.setSelection(0);
                    if (j.this.cIV != null) {
                        j.this.cIV.a(j.this.cIp, j.this.bjV, false, true);
                    }
                }
            }
        }));
        boolean vu = com.baidu.tbadk.core.util.an.vs().vu();
        if (this.cIH == null) {
            this.cIH = aVar.a(this.cIy, this.cIG, vu);
        }
        ck(false);
        if (!z) {
            if (this.ctf == null) {
                this.ctf = new NoNetworkView(this.cIy.getActivity());
                this.ctf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.cIX.addView(this.ctf);
            }
            if (com.baidu.adp.lib.util.j.gV()) {
                this.ctf.setVisibility(8);
            } else {
                this.ctf.setVisibility(0);
            }
            this.ctf.onChangeSkinType(this.cIy.xR(), TbadkCoreApplication.getInst().getSkinType());
        }
        alQ();
        if (this.cIP == null) {
            this.cIP = aVar.c(this.cIy, this.cIz);
        }
        if (this.cIQ == null) {
            this.cIQ = aVar.b(this.cIy, this.cIz);
        }
        if (this.cIW == null) {
            this.cIW = this.cIy.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.cIV == null) {
            this.cIV = new com.baidu.tieba.play.m(this.cIy.getPageContext(), this.cIG);
        }
        this.cIV.setUniqueId(this.cIy.getUniqueId());
        if (this.cIR == null) {
            this.cIR = new com.baidu.tieba.frs.g.i(this.cIy, (NavigationBarCoverTip) this.cIy.mRootView.findViewById(d.g.navigation_cover_tip));
        }
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIO != null && this.cIO.getLayoutParams() != null) {
            this.cIO.getLayoutParams().height = i;
            this.cIO.setLayoutParams(this.cIO.getLayoutParams());
        }
    }

    public void lc(String str) {
        if (this.cIR != null) {
            this.cIR.lc(str);
        }
    }

    public View alK() {
        return this.cIO;
    }

    public com.baidu.tieba.play.m alL() {
        return this.cIV;
    }

    public com.baidu.tieba.frs.entelechy.b.c alM() {
        return this.cIQ;
    }

    public void eS(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.w(this.cIy.alE().bvA());
        if (this.cIP != null) {
            this.cIP.eS(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.e alN() {
        return this.cIP;
    }

    public void v(boolean z, boolean z2) {
        if (this.cIZ && this.cIQ != null) {
            this.cIQ.v(z, z2);
        }
    }

    public void eT(boolean z) {
        this.cIZ = z;
        if (!this.cIZ && this.cIQ != null) {
            this.cIQ.v(false, false);
        }
    }

    public void alO() {
        if (this.cIZ && this.cIQ != null) {
            this.cIQ.v(false, false);
        }
        this.cIB.setVisibility(8);
        this.btG.setVisibility(8);
        eS(false);
        this.cIG.setVisibility(8);
    }

    public void alP() {
        if (this.cIZ && this.cIQ != null) {
            this.cIQ.v(true, false);
        }
        this.cIB.setVisibility(0);
        this.btG.setVisibility(0);
        eS(true);
        this.cIG.setVisibility(0);
    }

    public void eU(boolean z) {
        if (this.cIQ != null) {
            this.cIQ.fl(z);
        }
    }

    private void alQ() {
        if (this.cIS == null) {
            this.cIS = (GifView) this.cIy.mRootView.findViewById(d.g.gif_real_time);
            this.cIT = (TbImageView) this.cIy.mRootView.findViewById(d.g.tbimg_real_time);
            this.cIT.setPageId(this.cIy.getUniqueId());
            this.cIS.setLayerType(1, null);
            this.cIT.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View alR() {
        return this.cIA;
    }

    public void h(NoNetworkView.a aVar) {
        this.cFw = aVar;
        if (this.ctf != null) {
            this.ctf.a(this.cFw);
        }
    }

    public void ck(boolean z) {
        this.cIx = z;
        if (z) {
            if (this.cIQ != null) {
                this.cIQ.anO();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.d) this.cIG.getAdapter()).notifyDataSetChanged();
        if (this.cIQ != null) {
            this.cIQ.anP();
        }
    }

    public void eV(boolean z) {
        if (this.cIQ != null) {
            if (z) {
                v(true, true);
            } else {
                v(true, false);
            }
        }
    }

    public void eW(boolean z) {
        if (this.cIQ != null) {
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
        this.cIG.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        this.cIH.setOnAdapterItemClickListener(hVar);
    }

    public void setForumName(String str) {
        this.cIH.setForumName(str);
        this.mForumName = str;
    }

    public void cN(boolean z) {
        this.cIH.cN(z);
    }

    public void onDestroy() {
        if (this.cIV != null) {
            this.cIV.destroy();
        }
        if (this.cIR != null) {
            this.cIR.onDestory();
        }
        this.cIH.onDestory();
        this.cIG.setOnSrollToBottomListener(null);
        this.cIG.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cJb);
        if (this.cuE != null) {
            this.cuE.onDestroy();
        }
        this.cIU.clear();
        if (this.cIP != null) {
            this.cIP.anT();
        }
        if (this.cIW != null) {
            this.cIW.setBackgroundDrawable(null);
        }
        if (this.cJa != null) {
            this.cJa.anc();
        }
    }

    public boolean alS() {
        if (this.cIP != null) {
            return this.cIP.alS();
        }
        return false;
    }

    public boolean alF() {
        return this.cIx;
    }

    public void PB() {
        this.cIG.setVisibility(0);
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

    public void alT() {
        if (this.cIH != null) {
            this.cIH.notifyDataSetChanged();
        }
    }

    public void adf() {
        if (this.cIH instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cIH).adf();
        }
    }

    private void alU() {
        if (this.cII == null && this.cIy.getPageContext() != null) {
            String[] strArr = {this.cIy.getPageContext().getPageActivity().getString(d.j.take_photo), this.cIy.getPageContext().getPageActivity().getString(d.j.album)};
            this.cII = new com.baidu.tbadk.core.dialog.b(this.cIy.getPageContext().getPageActivity());
            this.cII.cT(this.cIy.getPageContext().getPageActivity().getString(d.j.operation));
            this.cII.a(strArr, new b.InterfaceC0061b() { // from class: com.baidu.tieba.frs.j.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        j.this.cIy.takePhoto();
                    } else if (i == 1 && j.this.cIy.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(j.this.cIy.getPageContext().getPageActivity());
                    }
                }
            });
            this.cII.d(this.cIy.getPageContext());
        }
    }

    public void alV() {
        alU();
        if (this.cII != null) {
            this.cII.tl();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.k kVar) {
        if (com.baidu.tbadk.core.util.v.w(arrayList)) {
            l lVar = new l();
            arrayList = new ArrayList<>();
            arrayList.add(lVar);
            if (this.cIy != null && this.cIy.ali() != null && this.cIy.ali().apS() == 0) {
                lVar.jU(this.cIy.ali().aqa());
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
        this.cIH.b(arrayList, kVar);
        if (this.cIV != null) {
            this.cIV.a(this.cIp, this.bjV, this.cIN, true);
        }
    }

    public BdTypeListView getListView() {
        return this.cIG;
    }

    public void alW() {
        this.cIH.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cIy.getPageContext(), 1);
        aVar.a(this.cIG);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cIy.getForumName());
        hashMap.put("forum_id", this.cIy.getForumId());
        aVar.setParams(hashMap);
        aVar.H(uVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.cIP != null) {
            this.cIP.anU();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.cIP != null) {
            this.cIP.anV();
        }
    }

    public void release() {
        if (this.ctf != null && this.cFw != null) {
            this.ctf.b(this.cFw);
        }
    }

    public ImageView alX() {
        return this.btG;
    }

    public ImageView alY() {
        return this.cIB;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cIy, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cIy.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.cIT != null) {
            this.cIT.invalidate();
        }
        if (this.cIH != null) {
            this.cIH.anD();
            this.cIH.notifyDataSetChanged();
        }
        this.cIy.xR().getLayoutMode().ag(i == 1);
        this.cIy.xR().getLayoutMode().t(this.cIz);
        if (this.cIz != null) {
            com.baidu.tbadk.core.util.aj.e(this.cIz, d.C0096d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cIy.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.cS(d.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.e(this.cIK, d.C0096d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.k(this.mNavigationBar.getBottomLine(), d.C0096d.cp_bg_line_b);
        }
        if (this.ctf != null) {
            this.ctf.onChangeSkinType(this.cIy.getPageContext(), i);
        }
        if (this.blv != null) {
            this.blv.dz(i);
        }
        eZ(false);
        if (this.cIQ != null) {
            this.cIQ.onChangeSkinType(i);
        }
        if (this.cIP != null) {
            this.cIP.onChangeSkinType(i);
        }
        if (this.cIW != null) {
            UtilHelper.setStatusBarBackground(this.cIW, i);
        }
        if (this.cIV != null) {
            this.cIV.a(this.cIp, this.bjV, this.cIN, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public void startPullRefresh() {
        this.cIG.startPullRefresh();
    }

    public void alZ() {
        this.cIG.completePullRefreshPostDelayed(2000L);
    }

    public boolean ama() {
        return this.cIC != null && this.cIF.getVisibility() == 0;
    }

    public void amb() {
        if (this.cIC != null) {
            this.cID.setVisibility(0);
            this.cIF.setVisibility(8);
            this.cIE.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.cJb, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bl blVar) {
        if (this.cIC == null) {
            this.cIC = (ViewStub) this.cIy.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.cIC.setVisibility(0);
            this.cID = (FrameLayout) this.cIy.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.cIE = (TbImageView) this.cIy.mRootView.findViewById(d.g.game_activity_egg);
            this.cIF = (TbImageView) this.cIy.mRootView.findViewById(d.g.game_activity_egg_s);
            this.cIE.setPageId(this.cIy.getUniqueId());
            this.cIF.setPageId(this.cIy.getUniqueId());
            this.cIE.setDefaultBgResource(d.C0096d.common_color_10022);
            this.cIE.setDefaultResource(0);
            this.cIF.setDefaultBgResource(d.C0096d.common_color_10022);
            this.cIF.setDefaultResource(0);
            this.cID.setOnClickListener(this.cIJ);
        }
        this.cID.setVisibility(0);
        String sX = blVar.sX();
        String sY = blVar.sY();
        this.cIE.startLoad(sX, 10, false);
        this.cIF.startLoad(sY, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cJb, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void amc() {
        if (this.cIC != null) {
            this.cID.setVisibility(8);
        }
    }

    public u amd() {
        return this.cIH;
    }

    public ViewGroup WQ() {
        return this.cIz;
    }

    public View ame() {
        return this.cIL;
    }

    public void amf() {
        if (com.baidu.tbadk.k.r.GB().GC()) {
            int lastVisiblePosition = this.cIG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cIG.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof n)) {
                    n nVar = (n) childAt.getTag();
                    if (nVar.cJr != null) {
                        com.baidu.tbadk.k.l perfLog = nVar.cJr.getPerfLog();
                        perfLog.fr(1000);
                        perfLog.aKn = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            nVar.cJr.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        nVar.cJr.startLogPerf();
                    }
                    if (nVar.cJp != null && (nVar.cJp instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = nVar.cJp;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fr(1000);
                                perfLog2.aKn = true;
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

    public void amg() {
        this.mHasMore = true;
        this.cIG.setNextPage(this.blv);
        if (this.cIM > 0) {
            this.blv.dB(d.C0096d.cp_bg_line_d);
            this.blv.dA(this.cIM);
        }
        this.blv.setOnClickListener(null);
        this.blv.wv();
    }

    public void amh() {
        this.mHasMore = false;
        this.cIG.setNextPage(this.blv);
        if (this.cIM > 0) {
            this.blv.dB(d.C0096d.cp_bg_line_d);
            this.blv.dA(this.cIM);
        }
        this.blv.setOnClickListener(null);
        this.blv.ww();
        this.blv.setText(this.cIy.getResources().getString(d.j.list_no_more));
    }

    public void ami() {
        this.mHasMore = true;
        this.cIG.setNextPage(this.blv);
        this.blv.setOnClickListener(this.cIJ);
        if (this.cIM > 0) {
            this.blv.dB(d.C0096d.cp_bg_line_d);
            this.blv.dA(this.cIM);
        }
        this.blv.ww();
        this.blv.setText(this.cIy.getResources().getString(d.j.list_click_load_more));
    }

    public View amj() {
        if (this.blv == null) {
            return null;
        }
        return this.blv.getView();
    }

    public void adg() {
        this.mHasMore = false;
        this.cIG.setNextPage(null);
    }

    public boolean acW() {
        return this.blv.getView().getParent() != null && this.mHasMore;
    }

    public void jQ(int i) {
        this.cIM = i;
    }

    public void jR(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cuE == null) {
                    this.cuE = new CommonTipView(this.cIy.getActivity());
                }
                this.cuE.setText(d.j.frs_login_tip);
                this.cuE.show((FrameLayout) ame(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void eX(boolean z) {
        if (this.cIV != null) {
            if (z) {
                this.cIV.hJ(false);
                this.cIV.avt();
                return;
            }
            this.cIV.hJ(true);
            this.cIV.a(this.cIp, this.bjV, this.cIN, true);
        }
    }

    public void ay(int i, int i2) {
        if (this.cIV != null) {
            this.cIV.a(i, i2, this.cIN, 1);
        }
    }

    public void az(int i, int i2) {
        this.cIp = i;
        this.bjV = i2;
    }

    public void eY(boolean z) {
        this.cIN = z;
    }

    public void amk() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
        }
    }

    private void aml() {
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
        boolean j = com.baidu.tieba.frs.g.f.j(this.cIy.alE());
        boolean i = com.baidu.tieba.frs.g.f.i(this.cIy.alE());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bQE) {
                    this.bQE = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.cIB, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                    com.baidu.tbadk.core.util.aj.a(this.btG, d.f.btn_sml_more_bg, d.f.btn_sml_more_bg);
                    if (j && !i) {
                        com.baidu.tbadk.core.util.aj.j(this.mBackImageView, d.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bQE) {
                this.bQE = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.cIB, d.f.icon_search_bg_s, d.f.icon_search_bg);
                com.baidu.tbadk.core.util.aj.a(this.btG, d.f.btn_more_selector_s, d.f.btn_more_selector);
                if (j) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        aml();
    }

    public void fa(boolean z) {
        if (!this.cIG.bwb()) {
            this.cIG.setStarForum(true);
            if (z && !this.cIy.alG()) {
                this.mPullView = new com.baidu.tbadk.core.view.i(this.cIy.getPageContext());
                this.mPullView.setTag(this.cIy.getUniqueId());
                this.cIG.setPullRefresh(this.mPullView);
            }
        }
    }

    public void jS(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void jT(int i) {
        if (this.cIG != null && this.cIG.getChildCount() >= 0) {
            if (this.cIG.getFirstVisiblePosition() > 8) {
                this.cIG.setSelection(8);
            }
            this.cIG.smoothScrollToPosition(i);
        }
    }

    public void amm() {
        a(this.cIY, this.cIy.alG());
        if (this.cIH != null) {
            this.cIH.anI();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.cJa == null) {
                this.cJa = new com.baidu.tieba.video.e(this.cIy.getActivity(), this.cIz);
            }
            this.cJa.g(postWriteCallBackData);
        }
    }

    public void amn() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.cJc && this.cIy.getActivity() != null && this.cIy.getPageContext() != null) {
            View view = null;
            if (this.cIG != null && (headerViewsCount = this.cIG.getHeaderViewsCount()) < this.cIG.getChildCount()) {
                view = this.cIG.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).ac(0).A(true).B(false).z(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.j.6
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        j.this.cIy.getPageContext().getLayoutMode().t(inflate);
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
                        return com.baidu.adp.lib.util.l.f(j.this.cIy.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.f(j.this.cIy.getActivity(), d.e.ds6);
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
                eY.j(this.cIy.getActivity());
                com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.j.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eY != null) {
                            eY.dismiss();
                        }
                    }
                }, 4000L);
                this.cJc = true;
            }
        }
    }
}
