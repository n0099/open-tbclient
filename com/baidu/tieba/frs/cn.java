package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.entelechy.b.a;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class cn {
    private static /* synthetic */ int[] bkw;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aWZ;
    private CommonTipView aYI;
    private FrsActivity bjB;
    private TextView bjE;
    private View bjF;
    private com.baidu.tieba.frs.entelechy.a.v bjN;
    private View bjQ;
    private View.OnClickListener bjV;
    private View bjY;
    private com.baidu.tbadk.core.data.p bjZ;
    private View bkb;
    private PbListView bkd;
    private View bkg;
    private com.baidu.tieba.frs.entelechy.b.e bkh;
    private com.baidu.tieba.frs.entelechy.b.c bki;
    private GifView bkj;
    private TbImageView bkk;
    private HashSet<String> bkl;
    private com.baidu.tieba.frs.view.ab bkm;
    private int bkn;
    private int bko;
    private ObservedChangeLinearLayout bkq;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean bjA = false;
    private NoPressedRelativeLayout bjC = null;
    private ImageView bjD = null;
    private FrameLayout bjG = null;
    private FrameLayout bjH = null;
    private TbImageView bjI = null;
    private TbImageView bjJ = null;
    private ImageView bjK = null;
    private ImageView bjL = null;
    private BdExpandListView bjM = null;
    private TextView bjO = null;
    private com.baidu.tbadk.core.dialog.c bjP = null;
    private TextView bjR = null;
    private ImageView bjS = null;
    com.baidu.tbadk.core.dialog.c bjT = null;
    Animation bjU = null;
    private c.b bjW = null;
    private NoNetworkView.a bes = null;
    private BannerView bjX = null;
    private boolean bka = false;
    private boolean bkc = false;
    private boolean mHasMore = true;
    private int bke = 0;
    private boolean bkf = false;
    private View bkp = null;
    private boolean bkr = true;
    private boolean bks = true;
    BannerView.a bkt = new co(this);
    BannerView.a bku = new cp(this);
    private View.OnTouchListener aFz = new cq(this);
    private Runnable bkv = new cr(this);

    static /* synthetic */ int[] Rq() {
        int[] iArr = bkw;
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
            bkw = iArr;
        }
        return iArr;
    }

    public ObservedChangeLinearLayout QA() {
        return this.bkq;
    }

    public View QB() {
        return this.bkp;
    }

    public cn(FrsActivity frsActivity, View.OnClickListener onClickListener, a aVar) {
        this.bjB = null;
        this.bjV = null;
        this.bjB = frsActivity;
        this.bjV = onClickListener;
        a(aVar);
        this.bkl = new HashSet<>();
    }

    private void a(a aVar) {
        this.bjC = (NoPressedRelativeLayout) this.bjB.findViewById(t.g.frs);
        this.mNavigationBar = (NavigationBar) this.bjB.findViewById(t.g.view_navigation_bar);
        this.bjY = this.bjB.findViewById(t.g.frs_navi_line);
        b Sh = aVar.Sh();
        if (Sh != null) {
            Sh.ad(this.bjY);
        }
        this.bjF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bjF.setOnClickListener(this.bjV);
        this.mBackImageView = (ImageView) this.bjF.findViewById(t.g.widget_navi_back_button);
        this.bkb = this.bjB.findViewById(t.g.frs_list_content);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bjD = (ImageView) addCustomView.findViewById(t.g.frs_top_more);
        this.bjD.setContentDescription(this.bjB.getResources().getString(t.j.publish_thread));
        com.baidu.tbadk.core.util.at.a(this.bjD, t.f.icon_edit_selector_s, t.f.icon_edit_selector);
        this.bjD.setOnClickListener(this.bjV);
        this.bjE = (TextView) addCustomView.findViewById(t.g.frs_more_mes_text);
        QF();
        this.bjQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bjS = (ImageView) this.bjQ.findViewById(t.g.frs_top_more);
        this.bjS.setContentDescription(this.bjB.getResources().getString(t.j.more));
        this.bkn = t.f.btn_more_selector_s;
        this.bko = t.f.btn_more_selector;
        cW(false);
        this.bjS.setOnClickListener(this.bjV);
        this.bjR = (TextView) this.bjQ.findViewById(t.g.frs_more_mes_text);
        this.bjG = (FrameLayout) this.bjB.findViewById(t.g.refresh_layout);
        this.bjK = (ImageView) this.bjB.findViewById(t.g.refresh_bg);
        this.bjL = (ImageView) this.bjB.findViewById(t.g.refresh_icon);
        this.bjH = (FrameLayout) this.bjB.findViewById(t.g.game_activity_egg_layout);
        this.bjI = (TbImageView) this.bjB.findViewById(t.g.game_activity_egg);
        this.bjJ = (TbImageView) this.bjB.findViewById(t.g.game_activity_egg_s);
        this.bjI.setDefaultBgResource(t.d.transparent);
        this.bjI.setDefaultResource(0);
        this.bjJ.setDefaultBgResource(t.d.transparent);
        this.bjJ.setDefaultResource(0);
        this.bjM = (BdExpandListView) this.bjB.findViewById(t.g.frs_lv_thread);
        this.bjC.setBottomOrderView(this.bjM);
        this.bjM.setOnTouchListener(this.bjB.aFz);
        this.bjM.setDivider(null);
        if (Sh != null) {
            this.bkg = Sh.a(this.bjB.getActivity(), this.bjM);
        }
        this.bjM.setDividerHeight(0);
        this.bjM.setRecyclerListener(new cs(this));
        this.bkd = new PbListView(this.bjB.getPageContext().getPageActivity());
        this.bkd.jn();
        this.bkd.cR(t.d.cp_bg_line_c);
        this.bjM.setOnSrollToBottomListener(this.bjB);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ab(new ct(this)));
        this.bjN = aVar.a(this.bjB, this.bjM, com.baidu.tbadk.core.util.az.uf().uh());
        this.bjO = (TextView) this.bjB.findViewById(t.g.frs_noexist_post);
        this.bjO.setVisibility(8);
        this.bjG.setOnClickListener(this.bjV);
        this.bjH.setOnClickListener(this.bjV);
        this.bjG.setOnTouchListener(this.aFz);
        cQ(false);
        this.aWZ = (NoNetworkView) this.bjB.findViewById(t.g.view_no_network);
        QD();
        if (aVar != null) {
            this.bkh = aVar.c(this.bjB, this.bjC);
            if (this.bkh != null) {
                this.bjD.setVisibility(4);
                this.bjE.setVisibility(4);
            }
            this.bki = aVar.b(this.bjB, this.bjC);
            if (this.bki != null) {
                this.bjG.setVisibility(8);
            }
        }
        this.bkq = (ObservedChangeLinearLayout) this.bjB.findViewById(t.g.navigation_bar_wrapperLayout);
        this.bkq.setOnSizeChangeListener(new cu(this));
        this.bkp = this.bjB.findViewById(t.g.statebar_view);
    }

    public com.baidu.tieba.frs.entelechy.b.c QC() {
        return this.bki;
    }

    public void cO(boolean z) {
        if (this.bkh != null) {
            this.bkh.cO(z);
        }
    }

    public void i(boolean z, boolean z2) {
        if (this.bki != null) {
            this.bki.i(z, z2);
        }
    }

    public void cP(boolean z) {
        if (this.bki != null) {
            this.bki.dd(z);
        }
    }

    private void QD() {
        this.bkj = (GifView) this.bjB.findViewById(t.g.gif_real_time);
        this.bkk = (TbImageView) this.bjB.findViewById(t.g.tbimg_real_time);
        this.bkj.setLayerType(1, null);
        this.bkk.setLayerType(1, null);
    }

    public void QE() {
        com.baidu.tbadk.core.data.ak realTimeData;
        if (this.bjB.PZ().avA() != null && this.bjB.PZ().avA().getRealTimeData() != null && (realTimeData = this.bjB.PZ().avA().getRealTimeData()) != null && !StringUtils.isNull(realTimeData.getIcon()) && this.bkm == null) {
            this.bkm = new com.baidu.tieba.frs.view.ab(realTimeData, this, this.bjB.getPageContext());
            this.bkm.show();
        }
    }

    public void QF() {
        if (this.bjE != null && this.bjE.isShown()) {
            this.bjE.setVisibility(8);
        }
    }

    private void QG() {
        if (this.bjX == null && this.bjB != null && this.bjB.Qm() != null) {
            this.bjX = this.bjB.Qm().aq(this.bjB.getPageContext().getPageActivity());
            this.bjX.setVisibility(8);
            this.bjX.setBannerViewClickListener(this.bku);
            this.bjX.setBannerViewEvent(new cv(this));
        }
    }

    private void aF(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.bjB.getForumId(), this.bjB.getForumName(), null);
            a.bK("obj_url", str2);
            a.save();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void QH() {
        if (this.bjZ != null) {
            String value = this.bjZ.getValue();
            String oT = this.bjZ.oT();
            if (this.bjZ.oX() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.bjB.getPageContext().getPageActivity(), value, false, "frs_banner")));
                aF(oT, value);
            } else if (this.bjZ.oX() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.bjB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bjB.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                            aF(oT, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bjZ.oX() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.Ym != UtilHelper.NativePageType.NONE) {
                    switch (Rq()[isNativeAddress.Ym.ordinal()]) {
                        case 2:
                            this.bjB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bjB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case 3:
                            this.bjB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bjB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            break;
                    }
                } else {
                    com.baidu.tbadk.core.util.bg.us().c(this.bjB.getPageContext(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.bjB.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                aF(oT, value);
            } else if (this.bjZ.oX() == 4) {
                this.bjB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bjB.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                aF(oT, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView QI() {
        return this.bjD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View QJ() {
        return this.bjS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View QK() {
        return this.bjF;
    }

    public void g(NoNetworkView.a aVar) {
        this.bes = aVar;
        if (this.aWZ != null) {
            this.aWZ.a(this.bes);
        }
    }

    public void cQ(boolean z) {
        this.bjA = z;
        if (z) {
            this.bjG.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.bjB, this.bjL, QN(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.at.c(this.bjK, t.f.pic_fresh_s);
            if (this.bki != null) {
                this.bki.SB();
                return;
            }
            return;
        }
        this.bjG.setOnTouchListener(this.aFz);
        ((com.baidu.adp.widget.ListView.e) this.bjM.getAdapter()).notifyDataSetChanged();
        this.bjL.clearAnimation();
        com.baidu.tbadk.core.util.at.c(this.bjK, t.f.pic_fresh_n);
        if (this.bki != null) {
            this.bki.SC();
        }
    }

    public void cR(boolean z) {
        if (z) {
            this.bjK.setAlpha(128);
            this.bjL.setAlpha(128);
            return;
        }
        this.bjK.setAlpha(MotionEventCompat.ACTION_MASK);
        this.bjL.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void cS(boolean z) {
        if (this.bki != null) {
            if (z) {
                i(true, true);
                return;
            } else {
                i(true, false);
                return;
            }
        }
        this.bjG.setVisibility(0);
    }

    public void cT(boolean z) {
        if (this.bki != null) {
            if (z) {
                i(false, true);
                return;
            } else {
                i(false, false);
                return;
            }
        }
        this.bjG.setVisibility(8);
    }

    public void gq(int i) {
        LinearLayout linearLayout = (LinearLayout) this.bjB.findViewById(t.g.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void a(com.baidu.tbadk.core.data.ax axVar, boolean z) {
        String string = this.bjB.getPageContext().getPageActivity().getString(t.j.view);
        String string2 = this.bjB.getPageContext().getPageActivity().getString(t.j.view_host);
        String string3 = this.bjB.getPageContext().getPageActivity().getString(t.j.view_reverse);
        this.bjT = new com.baidu.tbadk.core.dialog.c(this.bjB.getPageContext().getPageActivity());
        this.bjT.bP(t.j.operation);
        if (z) {
            this.bjT.a(new String[]{string, string3}, this.bjW);
        } else {
            this.bjT.a(new String[]{string, string2, string3}, this.bjW);
        }
        this.bjT.d(this.bjB.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        this.bjM.setPersonListRefreshListener(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bjM.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bjN.a(wVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bjN.a(xVar);
    }

    public void a(c.b bVar) {
        this.bjW = bVar;
    }

    public void QL() {
        if (this.bjT != null) {
            this.bjT.rX();
        }
    }

    public void onDestroy() {
        this.bjN.onDestory();
        this.bjM.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m11getInst().handler.removeCallbacks(this.bkv);
        if (this.aYI != null) {
            this.aYI.onDestroy();
        }
        this.bkl.clear();
        if (this.bkh != null) {
            this.bkh.SE();
        }
        if (this.bkp != null) {
            this.bkp.setBackgroundDrawable(null);
        }
    }

    public boolean QM() {
        if (this.bkh != null) {
            return this.bkh.QM();
        }
        return false;
    }

    private Animation QN() {
        if (this.bjU == null) {
            this.bjU = AnimationUtils.loadAnimation(this.bjB.getPageContext().getPageActivity(), t.a.refresh_rotate);
            this.bjU.setInterpolator(new LinearInterpolator());
            this.bjU.setFillAfter(true);
        }
        return this.bjU;
    }

    public boolean Qa() {
        return this.bjA;
    }

    public void Ld() {
        this.bjM.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bjB.getActivity().getString(t.j.forum));
        com.baidu.tbadk.core.l.ob().cc(str);
    }

    public void QO() {
        if (this.bjN != null) {
            this.bjN.notifyDataSetChanged();
        }
    }

    private void QP() {
        if (this.bjP == null) {
            String[] strArr = {this.bjB.getPageContext().getPageActivity().getString(t.j.take_photo), this.bjB.getPageContext().getPageActivity().getString(t.j.album)};
            this.bjP = new com.baidu.tbadk.core.dialog.c(this.bjB.getPageContext().getPageActivity());
            this.bjP.cB(this.bjB.getPageContext().getPageActivity().getString(t.j.operation));
            this.bjP.a(strArr, new cw(this));
            this.bjP.d(this.bjB.getPageContext());
        }
    }

    public void QQ() {
        QP();
        if (this.bjP != null) {
            this.bjP.rX();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            dd ddVar = new dd();
            arrayList = new ArrayList<>();
            arrayList.add(ddVar);
            this.bjO.setText(t.j.frs_nodata);
            this.bjO.setVisibility(8);
        } else {
            this.bjO.setVisibility(8);
        }
        this.bjN.a(arrayList, oVar);
    }

    public BdExpandListView QR() {
        return this.bjM;
    }

    public void QS() {
        this.bjN.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData == null || forumData.getFrsBannerData() == null) {
            QT();
        } else if (!forumData.getFrsBannerData().isValid()) {
            QT();
        } else {
            this.bjZ = forumData.getFrsBannerData();
            if (!this.bka) {
                QG();
                this.bjM.removeHeaderView(this.bjX);
                if (this.bjZ.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bjB.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bjB.Qm() != null) {
                this.bjB.Qm().b(this.bjM, this.bjX);
            }
            this.bjX.reset();
            if (this.bjZ.getType() == 1 && !TextUtils.isEmpty(this.bjZ.oY())) {
                this.bjX.c(this.bjB.getPageContext(), this.bjZ.oY());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hM(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.bjB.getForumId(), this.bjB.getForumName(), null);
            a.bK("obj_url", this.bjZ.oY());
            a.save();
        }
    }

    public void QT() {
        if (this.bjX != null) {
            this.bka = false;
            this.bjM.removeHeaderView(this.bjX);
            this.bjX = null;
        }
    }

    public void onPause() {
        if (this.bkh != null) {
            this.bkh.SF();
        }
    }

    public void release() {
        if (this.aWZ != null && this.bes != null) {
            this.aWZ.b(this.bes);
        }
    }

    public void QU() {
        this.bjR.setVisibility(8);
    }

    public void a(ed edVar) {
        long j;
        if (!FrsActivityStatic.bhF || edVar == null) {
            this.bjR.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bhG) {
            j = edVar.Rz() - edVar.RA();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().ya()) {
                j -= edVar.RB();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bjS.getVisibility() == 0) {
            this.bjR.setVisibility(0);
            if (j < 10) {
                this.bjR.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.at.k(this.bjR, t.f.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bjR.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.at.k(this.bjR, t.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bjR.setText("   ");
                com.baidu.tbadk.core.util.at.k(this.bjR, t.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bjR.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.bkk != null) {
            this.bkk.invalidate();
        }
        if (this.bjN != null) {
            this.bjN.Sw();
            this.bjN.notifyDataSetChanged();
        }
        this.bjB.PF();
        this.bjB.getLayoutMode().ae(i == 1);
        this.bjB.getLayoutMode().x(this.bjC);
        if (this.bjC != null) {
            com.baidu.tbadk.core.util.at.e(this.bjC, t.d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bjB.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.at.cB(t.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.at.e(this.bjY, t.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.at.l(this.mNavigationBar.getBottomLine(), t.d.cp_bg_line_b);
        }
        if (this.aWZ != null) {
            this.aWZ.onChangeSkinType(this.bjB.getPageContext(), i);
        }
        if (this.bjX != null) {
            this.bjX.kU();
        }
        if (this.bkd != null) {
            this.bkd.cS(i);
        }
        com.baidu.tbadk.core.util.at.a(this.bjD, t.f.icon_edit_selector_s, t.f.icon_edit_selector);
        cW(false);
        if (this.bjE != null) {
            com.baidu.tbadk.core.util.at.k(this.bjE, t.f.icon_news_head_prompt_one);
        }
        if (this.bki != null) {
            this.bki.onChangeSkinType(i);
        }
        if (this.bkh != null) {
            this.bkh.onChangeSkinType(i);
        }
        if (this.bkp != null) {
            UtilHelper.setStatusBarBackground(this.bkp, i);
        }
    }

    public void jy() {
        this.bjM.jy();
    }

    public void QV() {
        this.bjM.k(2000L);
    }

    public int QW() {
        return 0;
    }

    public boolean QX() {
        return this.bjJ.getVisibility() == 0;
    }

    public void QY() {
        this.bjH.setVisibility(0);
        this.bjJ.setVisibility(8);
        this.bjI.setVisibility(0);
        TbadkCoreApplication.m11getInst().handler.postDelayed(this.bkv, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void a(com.baidu.tbadk.core.data.bd bdVar) {
        this.bjH.setVisibility(0);
        String rL = bdVar.rL();
        String rM = bdVar.rM();
        this.bjI.c(rL, 10, false);
        this.bjJ.c(rM, 10, false);
        TbadkCoreApplication.m11getInst().handler.postDelayed(this.bkv, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void QZ() {
        this.bjH.setVisibility(8);
    }

    public com.baidu.tieba.frs.entelechy.a.v Ra() {
        return this.bjN;
    }

    public View getRootView() {
        return this.bjC;
    }

    public View Rb() {
        return this.bkb;
    }

    public void Rc() {
        this.bjQ.setVisibility(8);
    }

    public void Rd() {
        this.bjQ.setVisibility(0);
    }

    public void Re() {
        if (com.baidu.tbadk.performanceLog.aa.EM().EN()) {
            int lastVisiblePosition = this.bjM.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bjM.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof dk) {
                        dk dkVar = (dk) childAt.getTag();
                        if (dkVar.bfG != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = dkVar.bfG.getPerfLog();
                            perfLog.eM(1000);
                            perfLog.axv = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                dkVar.bfG.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getContext())) {
                                }
                            }
                            dkVar.bfG.uR();
                        }
                        if (dkVar.bfE != null && (dkVar.bfE instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = dkVar.bfE;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eM(1000);
                                    perfLog2.axv = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.uR();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bu) {
                        bu buVar = (bu) childAt.getTag();
                        if (buVar.bhW != null) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = buVar.bhW.getPerfLog();
                            perfLog3.eM(1000);
                            perfLog3.axv = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                buVar.bhW.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getContext())) {
                                }
                            }
                            buVar.bhW.uR();
                        }
                        if (buVar.bit != null && (buVar.bit instanceof TbImageView)) {
                            TbImageView tbImageView2 = buVar.bit;
                            com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eM(1000);
                            perfLog4.axv = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getContext())) {
                                }
                            }
                            tbImageView2.uR();
                        }
                    }
                    if (childAt.getTag() instanceof cl) {
                        cl clVar = (cl) childAt.getTag();
                        if (clVar.bjl != null && clVar.bjl.aLx != null && (clVar.bjl.aLx instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog5 = clVar.bjl.aLx.getPerfLog();
                            perfLog5.eM(1000);
                            perfLog5.axv = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                clVar.bjl.aLx.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getContext())) {
                                }
                            }
                            clVar.bjl.aLx.uR();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (clVar.aLs != null) {
                            arrayList.add(clVar.aLs);
                        }
                        if (clVar.aLt != null) {
                            arrayList.add(clVar.aLt);
                        }
                        if (clVar.aLu != null) {
                            arrayList.add(clVar.aLu);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eM(1000);
                                perfLog6.axv = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getContext())) {
                                    }
                                }
                                tbImageView3.uR();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar Rf() {
        return this.mNavigationBar;
    }

    public void Rg() {
        this.mHasMore = true;
        this.bjM.setNextPage(this.bkd);
        this.bkd.vg();
    }

    public void Rh() {
        this.mHasMore = false;
        if (this.bke > 0) {
            this.bkd.cT(this.bke);
        }
        this.bjM.setNextPage(this.bkd);
        this.bkd.vh();
        this.bkd.setText(this.bjB.getResources().getString(t.j.list_no_more));
    }

    public void Ri() {
        this.mHasMore = false;
        this.bjM.setNextPage(null);
        this.bkd.vi();
    }

    public void Rj() {
        this.bkd.vi();
    }

    public boolean Py() {
        return this.bkd.getView().getParent() != null && this.mHasMore;
    }

    public void gr(int i) {
        this.bke = i;
    }

    public void gs(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("frs_login_tip", true)) {
                if (this.aYI == null) {
                    this.aYI = new CommonTipView(this.bjB.getActivity());
                }
                this.aYI.setText(t.j.frs_login_tip);
                this.aYI.a((FrameLayout) Rb(), TbadkCoreApplication.m11getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("frs_login_tip", false);
            }
        }
    }

    public TbImageView Rk() {
        return this.bkk;
    }

    public GifView Rl() {
        return this.bkj;
    }

    public void cU(boolean z) {
        if (this.bjM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bjM.getChildCount()) {
                    View childAt = this.bjM.getChildAt(this.bkf ? (this.bjM.getChildCount() - 1) - i2 : i2);
                    if (childAt.getTag() instanceof fh) {
                        if (z) {
                            ((fh) childAt.getTag()).RG();
                        } else {
                            ((fh) childAt.getTag()).RH();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void Rm() {
        if (this.bjM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bjM.getChildCount()) {
                    View childAt = this.bjM.getChildAt(this.bkf ? (this.bjM.getChildCount() - 1) - i2 : i2);
                    if (childAt.getTag() instanceof fh) {
                        ((fh) childAt.getTag()).JZ();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void cV(boolean z) {
        this.bkf = z;
    }

    public void Rn() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setmBackImageViewBg(t.f.btn_sml_back_selector_s, t.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.at.k(this.mBackImageView, t.f.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.at.k(this.bjS, t.f.frs_star_navigation_bg);
        }
        int i = t.f.btn_sml_more_selector_s;
        this.bko = i;
        this.bkn = i;
        com.baidu.tbadk.core.util.at.a(this.bjS, this.bkn, this.bko);
    }

    public void Ro() {
        cW(true);
    }

    private void Rp() {
        float f;
        if (this.mNavigationBar != null && this.mNavigationBar.mTextTitle != null && this.mNavigationBar.getBarBgView() != null && this.bjS != null && this.mBackImageView != null) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            this.mNavigationBar.mTextTitle.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.bjS.setAlpha(f);
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void cW(boolean z) {
        boolean g = com.baidu.tieba.frs.h.m.g(this.bjB.PZ());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bks) {
                    this.bks = true;
                    if (g) {
                        com.baidu.tbadk.core.util.at.a(this.mBackImageView, t.f.btn_sml_back_selector_s, t.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.at.a(this.bjS, t.f.btn_sml_more_selector_s, t.f.btn_sml_more_selector_s);
                        com.baidu.tbadk.core.util.at.k(this.mBackImageView, t.f.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.at.k(this.bjS, t.f.frs_star_navigation_bg);
                    } else {
                        com.baidu.tbadk.core.util.at.a(this.mBackImageView, t.f.btn_sml_back_selector_s, t.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.at.a(this.bjS, t.f.btn_sml_more_selector_s, t.f.btn_sml_more_selector_s);
                    }
                }
            } else if (!z || this.bks) {
                this.bks = false;
                if (g) {
                    com.baidu.tbadk.core.util.at.a(this.mBackImageView, t.f.icon_return_bg_s, t.f.icon_return_bg);
                    com.baidu.tbadk.core.util.at.a(this.bjS, t.f.btn_more_selector_s, t.f.btn_more_selector);
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bjS.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.at.a(this.mBackImageView, t.f.icon_return_bg_s, t.f.icon_return_bg);
                    com.baidu.tbadk.core.util.at.a(this.bjS, this.bkn, this.bko);
                }
            }
        }
        Rp();
    }
}
