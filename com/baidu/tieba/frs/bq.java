package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.entelechy.b.a;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.u;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bq {
    private static /* synthetic */ int[] bFH;
    private com.baidu.tieba.play.f aIG;
    private FrsActivity bET;
    private View bEV;
    private ViewStub bEW;
    private ObservedChangeLinearLayout bFB;
    private com.baidu.tieba.frs.entelechy.a.ad bFb;
    private View bFd;
    private View.OnClickListener bFi;
    private View bFl;
    private com.baidu.tbadk.core.data.r bFm;
    private View bFo;
    private View bFq;
    private com.baidu.tieba.frs.entelechy.b.e bFr;
    private com.baidu.tieba.frs.entelechy.b.c bFs;
    private GifView bFt;
    private TbImageView bFu;
    private HashSet<String> bFv;
    private com.baidu.tieba.frs.view.t bFw;
    private int bFx;
    private int bFy;
    private PbListView biC;
    private NoNetworkView bkT;
    private CommonTipView buA;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mPullView;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    public static int bFA = 3;
    private boolean bES = false;
    private NoPressedRelativeLayout bEU = null;
    private FrameLayout bEX = null;
    private TbImageView bEY = null;
    private TbImageView bEZ = null;
    private BdExpandListView bFa = null;
    private com.baidu.tbadk.core.dialog.c bFc = null;
    private TextView bFe = null;
    private ImageView bFf = null;
    com.baidu.tbadk.core.dialog.c bFg = null;
    Animation bFh = null;
    private c.b bFj = null;
    private NoNetworkView.a bAH = null;
    private BannerView bFk = null;
    private boolean bFn = false;
    private boolean mHasMore = true;
    private int bFp = 0;
    private boolean aKt = false;
    private int aKy = 0;
    private int aKx = 0;
    private View bFz = null;
    private boolean bFC = true;
    BannerView.a bFD = new br(this);
    private Runnable bFE = new bs(this);
    private com.baidu.adp.lib.guide.d EF = null;
    private Handler mHandler = null;
    private Runnable bFF = new bt(this);
    private Runnable bFG = new bv(this);

    static /* synthetic */ int[] WN() {
        int[] iArr = bFH;
        if (iArr == null) {
            iArr = new int[UtilHelper.NativePageType.valuesCustom().length];
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UtilHelper.NativePageType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UtilHelper.NativePageType.PB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            bFH = iArr;
        }
        return iArr;
    }

    public ObservedChangeLinearLayout VY() {
        return this.bFB;
    }

    public View VZ() {
        return this.bFz;
    }

    public bq(FrsActivity frsActivity, View.OnClickListener onClickListener, a aVar) {
        this.bET = null;
        this.bFi = null;
        this.bET = frsActivity;
        this.bFi = onClickListener;
        a(aVar);
        this.bFv = new HashSet<>();
    }

    private void a(a aVar) {
        this.bEU = (NoPressedRelativeLayout) this.bET.findViewById(u.g.frs);
        this.mNavigationBar = (NavigationBar) this.bET.findViewById(u.g.view_navigation_bar);
        this.bFl = this.bET.findViewById(u.g.frs_navi_line);
        b XA = aVar.XA();
        if (XA != null) {
            XA.af(this.bFl);
        }
        this.bEV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bEV.setOnClickListener(this.bFi);
        this.mBackImageView = (ImageView) this.bEV.findViewById(u.g.widget_navi_back_button);
        this.bFo = this.bET.findViewById(u.g.frs_list_content);
        this.bFd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bFf = (ImageView) this.bFd.findViewById(u.g.frs_top_more);
        this.bFf.setContentDescription(this.bET.getResources().getString(u.j.more));
        this.bFx = u.f.btn_more_selector_s;
        this.bFy = u.f.btn_more_selector;
        ds(false);
        this.bFf.setOnClickListener(this.bFi);
        this.bFe = (TextView) this.bFd.findViewById(u.g.frs_more_mes_text);
        this.bFa = (BdExpandListView) this.bET.findViewById(u.g.frs_lv_thread);
        this.bEU.setBottomOrderView(this.bFa);
        this.bFa.setOnTouchListener(this.bET.aGb);
        this.bFa.setDivider(null);
        if (XA != null) {
            this.bFq = XA.a(this.bET.getActivity(), this.bFa);
        }
        this.bFa.setDividerHeight(0);
        this.bFa.setRecyclerListener(new bw(this));
        this.biC = new PbListView(this.bET.getPageContext().getPageActivity());
        this.biC.jq();
        this.biC.cS(u.d.cp_bg_line_c);
        this.bFa.setOnSrollToBottomListener(this.bET);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ac(new bx(this)));
        this.bFb = aVar.a(this.bET, this.bFa, com.baidu.tbadk.core.util.bb.uf().uh());
        dm(false);
        this.bkT = (NoNetworkView) this.bET.findViewById(u.g.view_no_network);
        Wb();
        this.bFr = aVar.c(this.bET, this.bEU);
        this.bFs = aVar.b(this.bET, this.bEU);
        this.bFB = (ObservedChangeLinearLayout) this.bET.findViewById(u.g.navigation_bar_wrapperLayout);
        this.bFB.setOnSizeChangeListener(new by(this));
        this.bFz = this.bET.findViewById(u.g.statebar_view);
        this.aIG = new com.baidu.tieba.play.f(this.bET.getPageContext(), this.bFa);
    }

    public com.baidu.tieba.play.f Il() {
        return this.aIG;
    }

    public com.baidu.tieba.frs.entelechy.b.c Wa() {
        return this.bFs;
    }

    public void dk(boolean z) {
        if (this.bFr != null) {
            this.bFr.dk(z);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.bFs != null) {
            this.bFs.j(z, z2);
        }
    }

    public void dl(boolean z) {
        if (this.bFs != null) {
            this.bFs.dA(z);
        }
    }

    private void Wb() {
        this.bFt = (GifView) this.bET.findViewById(u.g.gif_real_time);
        this.bFu = (TbImageView) this.bET.findViewById(u.g.tbimg_real_time);
        this.bFt.setLayerType(1, null);
        this.bFu.setLayerType(1, null);
    }

    public void Wc() {
        com.baidu.tbadk.core.data.am realTimeData;
        if (this.bET.VC().aDN() != null && this.bET.VC().aDN().getRealTimeData() != null && (realTimeData = this.bET.VC().aDN().getRealTimeData()) != null && !StringUtils.isNull(realTimeData.getIcon()) && this.bFw == null) {
            this.bFw = new com.baidu.tieba.frs.view.t(realTimeData, this, this.bET.getPageContext());
            this.bFw.show();
        }
    }

    public com.baidu.tieba.frs.view.t Wd() {
        return this.bFw;
    }

    private void We() {
        if (this.bFk == null && this.bET != null && this.bET.VP() != null) {
            this.bFk = this.bET.VP().at(this.bET.getPageContext().getPageActivity());
            this.bFk.setVisibility(8);
            this.bFk.setBannerViewClickListener(this.bFD);
            this.bFk.setBannerViewEvent(new bz(this));
        }
    }

    private void aH(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.bET.getForumId(), this.bET.getForumName(), null);
            a.bM("obj_url", str2);
            a.save();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Wf() {
        if (this.bFm != null) {
            String value = this.bFm.getValue();
            String oL = this.bFm.oL();
            if (this.bFm.oO() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.bET.getPageContext().getPageActivity(), value, false, "frs_banner")));
                aH(oL, value);
            } else if (this.bFm.oO() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.bET.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.bET.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            aH(oL, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bFm.oO() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.YD != UtilHelper.NativePageType.NONE) {
                    switch (WN()[isNativeAddress.YD.ordinal()]) {
                        case 2:
                            this.bET.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bET.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case 3:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.bET.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.bET.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            break;
                    }
                } else {
                    com.baidu.tbadk.core.util.bi.us().c(this.bET.getPageContext(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.bET.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                aH(oL, value);
            } else if (this.bFm.oO() == 4) {
                this.bET.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bET.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                aH(oL, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Wg() {
        return this.bFf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Wh() {
        return this.bFd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Wi() {
        return this.bEV;
    }

    public void g(NoNetworkView.a aVar) {
        this.bAH = aVar;
        if (this.bkT != null) {
            this.bkT.a(this.bAH);
        }
    }

    public void dm(boolean z) {
        this.bES = z;
        if (z) {
            if (this.bFs != null) {
                this.bFs.XZ();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bFa.getAdapter()).notifyDataSetChanged();
        if (this.bFs != null) {
            this.bFs.Ya();
        }
    }

    public void dn(boolean z) {
        if (this.bFs != null) {
            if (z) {
                j(true, true);
            } else {
                j(true, false);
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m12do(boolean z) {
        if (this.bFs != null) {
            if (z) {
                j(false, true);
            } else {
                j(false, false);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.az azVar, boolean z) {
        String string = this.bET.getPageContext().getPageActivity().getString(u.j.view);
        String string2 = this.bET.getPageContext().getPageActivity().getString(u.j.view_host);
        String string3 = this.bET.getPageContext().getPageActivity().getString(u.j.view_reverse);
        this.bFg = new com.baidu.tbadk.core.dialog.c(this.bET.getPageContext().getPageActivity());
        this.bFg.bP(u.j.operation);
        if (z) {
            this.bFg.a(new String[]{string, string3}, this.bFj);
        } else {
            this.bFg.a(new String[]{string, string2, string3}, this.bFj);
        }
        this.bFg.d(this.bET.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bFa instanceof BdExpandListView) {
            this.bFa.setPersonListRefreshListener(aVar);
        }
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(t.d dVar) {
        this.mPullView.a(dVar);
    }

    public void a(t.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bFa.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bFb.a(wVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bFb.a(xVar);
    }

    public void setForumName(String str) {
        this.bFb.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bFj = bVar;
    }

    public void Wj() {
        if (this.bFg != null) {
            this.bFg.rW();
        }
    }

    public void onDestroy() {
        this.bFb.onDestory();
        this.bFa.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bFE);
        if (this.buA != null) {
            this.buA.onDestroy();
        }
        this.bFv.clear();
        if (this.bFr != null) {
            this.bFr.Yd();
        }
        if (this.bFz != null) {
            this.bFz.setBackgroundDrawable(null);
        }
    }

    public boolean Wk() {
        if (this.bFr != null) {
            return this.bFr.Wk();
        }
        return false;
    }

    public boolean VD() {
        return this.bES;
    }

    public void Mc() {
        this.bFa.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bET.getActivity().getString(u.j.forum));
        com.baidu.tbadk.core.l.nW().cb(str);
    }

    public void Wl() {
        if (this.bFb != null) {
            this.bFb.notifyDataSetChanged();
        }
    }

    private void Wm() {
        if (this.bFc == null) {
            String[] strArr = {this.bET.getPageContext().getPageActivity().getString(u.j.take_photo), this.bET.getPageContext().getPageActivity().getString(u.j.album)};
            this.bFc = new com.baidu.tbadk.core.dialog.c(this.bET.getPageContext().getPageActivity());
            this.bFc.cA(this.bET.getPageContext().getPageActivity().getString(u.j.operation));
            this.bFc.a(strArr, new ca(this));
            this.bFc.d(this.bET.getPageContext());
        }
    }

    public void Wn() {
        Wm();
        if (this.bFc != null) {
            this.bFc.rW();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, int i, com.baidu.tieba.tbadkCore.p pVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cc ccVar = new cc();
            arrayList = new ArrayList<>();
            arrayList.add(ccVar);
            if (this.bET != null && this.bET.VG() != null && this.bET.VG().ZD() == 0) {
                ccVar.hs(this.bET.VG().WQ());
            }
        }
        this.bFb.a(arrayList, pVar);
        if (this.aIG != null) {
            this.aIG.a(this.aKy, this.aKx, this.aKt, true);
        }
    }

    public BdTypeListView getListView() {
        return this.bFa;
    }

    public void Wo() {
        this.bFb.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData == null || forumData.getFrsBannerData() == null) {
            Wp();
        } else if (!forumData.getFrsBannerData().isValid()) {
            Wp();
        } else {
            this.bFm = forumData.getFrsBannerData();
            if (!this.bFn) {
                We();
                this.bFa.removeHeaderView(this.bFk);
                if (this.bFm.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bET.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bET.VP() != null) {
                this.bET.VP().b(this.bFa, this.bFk);
            }
            this.bFk.reset();
            if (this.bFm.getType() == 1 && !TextUtils.isEmpty(this.bFm.oP())) {
                this.bFk.c(this.bET.getPageContext(), this.bFm.oP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iX(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.bET.getForumId(), this.bET.getForumName(), null);
            a.bM("obj_url", this.bFm.oP());
            a.save();
        }
    }

    public void Wp() {
        if (this.bFk != null) {
            this.bFn = false;
            this.bFa.removeHeaderView(this.bFk);
            this.bFk = null;
        }
    }

    public void onPause() {
        if (this.bFr != null) {
            this.bFr.Ye();
        }
    }

    public void release() {
        if (this.bkT != null && this.bAH != null) {
            this.bkT.b(this.bAH);
        }
    }

    public void Wq() {
        this.bFe.setVisibility(8);
    }

    public void a(cx cxVar) {
        long j;
        if (!FrsActivityStatic.bDN || cxVar == null) {
            this.bFe.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bDO) {
            j = cxVar.WT() - cxVar.WU();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().yf()) {
                j -= cxVar.WV();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bFf.getVisibility() == 0) {
            this.bFe.setVisibility(0);
            if (j < 10) {
                this.bFe.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.av.k(this.bFe, u.f.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bFe.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.av.k(this.bFe, u.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bFe.setText("   ");
                com.baidu.tbadk.core.util.av.k(this.bFe, u.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bFe.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.bFu != null) {
            this.bFu.invalidate();
        }
        if (this.bFb != null) {
            this.bFb.XT();
            this.bFb.notifyDataSetChanged();
        }
        this.bET.Vq();
        this.bET.getLayoutMode().ad(i == 1);
        this.bET.getLayoutMode().w(this.bEU);
        if (this.bEU != null) {
            com.baidu.tbadk.core.util.av.e(this.bEU, u.d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bET.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.av.cB(u.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.av.e(this.bFl, u.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.av.l(this.mNavigationBar.getBottomLine(), u.d.cp_bg_line_b);
        }
        if (this.bkT != null) {
            this.bkT.onChangeSkinType(this.bET.getPageContext(), i);
        }
        if (this.bFk != null) {
            this.bFk.kX();
        }
        if (this.biC != null) {
            this.biC.cT(i);
        }
        ds(false);
        if (this.bFs != null) {
            this.bFs.onChangeSkinType(i);
        }
        if (this.bFr != null) {
            this.bFr.onChangeSkinType(i);
        }
        if (this.bFz != null) {
            UtilHelper.setStatusBarBackground(this.bFz, i);
        }
    }

    public void jB() {
        this.bFa.jB();
    }

    public void Wr() {
        this.bFa.k(2000L);
    }

    public int Ws() {
        return 0;
    }

    public boolean Wt() {
        return this.bEW != null && this.bEZ.getVisibility() == 0;
    }

    public void Wu() {
        if (this.bEW != null) {
            this.bEX.setVisibility(0);
            this.bEZ.setVisibility(8);
            this.bEY.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bFE, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bf bfVar) {
        if (this.bEW == null) {
            this.bEW = (ViewStub) this.bET.findViewById(u.g.yule_game_egg_view_stub);
            this.bEW.setVisibility(0);
            this.bEX = (FrameLayout) this.bET.findViewById(u.g.game_activity_egg_layout);
            this.bEY = (TbImageView) this.bET.findViewById(u.g.game_activity_egg);
            this.bEZ = (TbImageView) this.bET.findViewById(u.g.game_activity_egg_s);
            this.bEY.setDefaultBgResource(u.d.common_color_10022);
            this.bEY.setDefaultResource(0);
            this.bEZ.setDefaultBgResource(u.d.common_color_10022);
            this.bEZ.setDefaultResource(0);
            this.bEX.setOnClickListener(this.bFi);
        }
        this.bEX.setVisibility(0);
        String rJ = bfVar.rJ();
        String rK = bfVar.rK();
        this.bEY.c(rJ, 10, false);
        this.bEZ.c(rK, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bFE, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void Wv() {
        if (this.bEW != null) {
            this.bEX.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.ad Ww() {
        return this.bFb;
    }

    public View getRootView() {
        return this.bEU;
    }

    public View Wx() {
        return this.bFo;
    }

    public void dp(boolean z) {
        this.bFd.setVisibility(z ? 0 : 8);
    }

    public void Wy() {
        if (com.baidu.tbadk.performanceLog.aa.EW().EX()) {
            int lastVisiblePosition = this.bFa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bFa.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof ce) {
                        ce ceVar = (ce) childAt.getTag();
                        if (ceVar.bBS != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = ceVar.bBS.getPerfLog();
                            perfLog.eQ(1000);
                            perfLog.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                ceVar.bBS.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            ceVar.bBS.uS();
                        }
                        if (ceVar.bBQ != null && (ceVar.bBQ instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = ceVar.bBQ;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eQ(1000);
                                    perfLog2.ayl = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.uS();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bh) {
                        bh bhVar = (bh) childAt.getTag();
                        if (bhVar.bEk != null) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = bhVar.bEk.getPerfLog();
                            perfLog3.eQ(1000);
                            perfLog3.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bhVar.bEk.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            bhVar.bEk.uS();
                        }
                        if (bhVar.bEp != null && (bhVar.bEp instanceof TbImageView)) {
                            TbImageView tbImageView2 = bhVar.bEp;
                            com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eQ(1000);
                            perfLog4.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            tbImageView2.uS();
                        }
                    }
                    if (childAt.getTag() instanceof bp) {
                        bp bpVar = (bp) childAt.getTag();
                        if (bpVar.bEQ != null && bpVar.bEQ.aOV != null && (bpVar.bEQ.aOV instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog5 = bpVar.bEQ.aOV.getPerfLog();
                            perfLog5.eQ(1000);
                            perfLog5.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                bpVar.bEQ.aOV.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            bpVar.bEQ.aOV.uS();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (bpVar.aOQ != null) {
                            arrayList.add(bpVar.aOQ);
                        }
                        if (bpVar.aOR != null) {
                            arrayList.add(bpVar.aOR);
                        }
                        if (bpVar.aOS != null) {
                            arrayList.add(bpVar.aOS);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eQ(1000);
                                perfLog6.ayl = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView3.uS();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar Wz() {
        return this.mNavigationBar;
    }

    public void WA() {
        this.mHasMore = true;
        this.bFa.setNextPage(this.biC);
        this.biC.vh();
    }

    public void WB() {
        this.mHasMore = false;
        if (this.bFp > 0) {
            this.biC.cU(this.bFp);
        }
        this.bFa.setNextPage(this.biC);
        this.biC.vi();
        this.biC.setText(this.bET.getResources().getString(u.j.list_no_more));
    }

    public void WC() {
        this.mHasMore = false;
        this.bFa.setNextPage(null);
        this.biC.vk();
    }

    public void WD() {
        this.biC.vk();
    }

    public boolean Vf() {
        return this.biC.getView().getParent() != null && this.mHasMore;
    }

    public void hp(int i) {
        this.bFp = i;
    }

    public void hq(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("frs_login_tip", true)) {
                if (this.buA == null) {
                    this.buA = new CommonTipView(this.bET.getActivity());
                }
                this.buA.setText(u.j.frs_login_tip);
                this.buA.a((FrameLayout) Wx(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("frs_login_tip", false);
            }
        }
    }

    public TbImageView WE() {
        return this.bFu;
    }

    public GifView WF() {
        return this.bFt;
    }

    public void dq(boolean z) {
        if (this.aIG != null) {
            if (z) {
                this.aIG.aTy();
            } else {
                this.aIG.a(this.aKy, this.aKx, this.aKt, true);
            }
        }
    }

    public void Z(int i, int i2) {
        if (this.aIG != null) {
            this.aIG.a(i, i2, this.aKt, 1);
        }
    }

    public void aa(int i, int i2) {
        this.aKy = i;
        this.aKx = i2;
    }

    public void dr(boolean z) {
        this.aKt = z;
    }

    public void WG() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setmBackImageViewBg(u.f.btn_sml_back_selector_s, u.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.av.k(this.mBackImageView, u.f.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.av.k(this.bFf, u.f.frs_star_navigation_bg);
        }
        int i = u.f.btn_sml_more_selector_s;
        this.bFy = i;
        this.bFx = i;
        com.baidu.tbadk.core.util.av.a(this.bFf, this.bFx, this.bFy);
    }

    public void WH() {
        ds(true);
    }

    private void WI() {
        float f;
        if (this.mNavigationBar != null && this.mNavigationBar.mTextTitle != null && this.mNavigationBar.getBarBgView() != null && this.bFf != null && this.mBackImageView != null) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            this.mNavigationBar.mTextTitle.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.bFf.setAlpha(f);
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void ds(boolean z) {
        boolean h = com.baidu.tieba.frs.i.p.h(this.bET.VC());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bFC) {
                    this.bFC = true;
                    if (h) {
                        com.baidu.tbadk.core.util.av.a(this.mBackImageView, u.f.btn_sml_back_selector_s, u.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.av.a(this.bFf, u.f.btn_sml_more_selector_s, u.f.btn_sml_more_selector_s);
                        com.baidu.tbadk.core.util.av.k(this.mBackImageView, u.f.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.av.k(this.bFf, u.f.frs_star_navigation_bg);
                    } else {
                        com.baidu.tbadk.core.util.av.a(this.mBackImageView, u.f.btn_sml_back_selector_s, u.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.av.a(this.bFf, u.f.btn_sml_more_selector_s, u.f.btn_sml_more_selector_s);
                    }
                }
            } else if (!z || this.bFC) {
                this.bFC = false;
                if (h) {
                    com.baidu.tbadk.core.util.av.a(this.mBackImageView, u.f.icon_return_bg_s, u.f.icon_return_bg);
                    com.baidu.tbadk.core.util.av.a(this.bFf, u.f.btn_more_selector_s, u.f.btn_more_selector);
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bFf.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.av.a(this.mBackImageView, u.f.icon_return_bg_s, u.f.icon_return_bg);
                    com.baidu.tbadk.core.util.av.a(this.bFf, this.bFx, this.bFy);
                }
            }
        }
        WI();
    }

    public void WJ() {
        if (!this.bFa.bjn()) {
            this.bFa.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.w(this.bET.getPageContext());
            this.mPullView.setTag(this.bET.getUniqueId());
            this.bFa.setPullRefresh(this.mPullView);
        }
    }

    public void hr(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void WK() {
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.sO().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", 0) < bFA && !com.baidu.tbadk.core.sharedPref.b.sO().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "forum_has_show_frequently_forum_tips" + this.mForumName, false)) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bFF, 2000L);
        }
    }

    public void WL() {
        com.baidu.tbadk.core.sharedPref.b.sO().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", com.baidu.tbadk.core.sharedPref.b.sO().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", 0) + 1);
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "forum_has_show_frequently_forum_tips" + this.mForumName, true);
    }

    public void WM() {
        if (this.EF != null) {
            this.EF.dismiss();
        }
    }
}
