package com.baidu.tieba.frs;

import android.os.Build;
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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class cn {
    private static /* synthetic */ int[] bjU;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private MorePopupWindow Su;
    private NoNetworkView aWk;
    private PbListView aXw;
    private FrsActivity bgW;
    private View bjA;
    private View bjB;
    private View bjC;
    private View.OnClickListener bjG;
    private com.baidu.tbadk.core.data.m bjJ;
    private View bjL;
    private TextView bjl;
    private View bjm;
    private bf bju;
    private View bjx;
    private NavigationBar mNavigationBar;
    private boolean bji = false;
    private NoPressedRelativeLayout bjj = null;
    private ImageView bjk = null;
    private FrameLayout bjn = null;
    private FrameLayout bjo = null;
    private TbImageView bjp = null;
    private TbImageView bjq = null;
    private ImageView bjr = null;
    private ImageView bjs = null;
    private BdTypeListView bjt = null;
    private TextView bjv = null;
    private com.baidu.tbadk.core.dialog.c bjw = null;
    private TextView bjy = null;
    private ImageView bjz = null;
    private com.baidu.tbadk.core.view.t mPullView = null;
    private com.baidu.tieba.tbadkCore.t bjD = null;
    com.baidu.tbadk.core.dialog.c bjE = null;
    Animation bjF = null;
    private c.b bjH = null;
    private NoNetworkView.a bdG = null;
    private BannerView bjI = null;
    private boolean bjK = false;
    private boolean bjM = false;
    private boolean mHasMore = true;
    private int bjN = 0;
    private int bjO = 0;
    BannerView.a bjP = new co(this);
    BannerView.a bjQ = new cp(this);
    View bjR = null;
    private View.OnTouchListener bjS = new cq(this);
    private Runnable bjT = new cr(this);

    static /* synthetic */ int[] Qr() {
        int[] iArr = bjU;
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
            bjU = iArr;
        }
        return iArr;
    }

    public cn(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.bgW = null;
        this.bjG = null;
        this.bgW = frsActivity;
        this.bjG = onClickListener;
        qD();
    }

    private void qD() {
        this.bjj = (NoPressedRelativeLayout) this.bgW.findViewById(t.g.frs);
        this.mNavigationBar = (NavigationBar) this.bgW.findViewById(t.g.view_navigation_bar);
        this.bjm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bjm.setOnClickListener(this.bjG);
        this.bjL = this.bgW.findViewById(t.g.frs_list_content);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bjk = (ImageView) addCustomView.findViewById(t.g.frs_top_more);
        com.baidu.tbadk.core.util.ar.a(this.bjk, t.f.icon_edit_selector_s, t.f.icon_edit_selector);
        this.bjk.setOnClickListener(this.bjG);
        this.bjl = (TextView) addCustomView.findViewById(t.g.frs_more_mes_text);
        PK();
        this.bjx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bjz = (ImageView) this.bjx.findViewById(t.g.frs_top_more);
        com.baidu.tbadk.core.util.ar.a(this.bjz, t.f.btn_more_selector_s, t.f.btn_more_selector);
        this.bjz.setOnClickListener(this.bjG);
        this.bjy = (TextView) this.bjx.findViewById(t.g.frs_more_mes_text);
        this.bjn = (FrameLayout) this.bgW.findViewById(t.g.refresh_layout);
        this.bjr = (ImageView) this.bgW.findViewById(t.g.refresh_bg);
        this.bjs = (ImageView) this.bgW.findViewById(t.g.refresh_icon);
        this.bjo = (FrameLayout) this.bgW.findViewById(t.g.game_activity_egg_layout);
        this.bjp = (TbImageView) this.bgW.findViewById(t.g.game_activity_egg);
        this.bjq = (TbImageView) this.bgW.findViewById(t.g.game_activity_egg_s);
        this.bjp.setDefaultBgResource(t.d.transparent);
        this.bjp.setDefaultResource(0);
        this.bjq.setDefaultBgResource(t.d.transparent);
        this.bjq.setDefaultResource(0);
        this.bjt = (BdTypeListView) this.bgW.findViewById(t.g.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.bgW.getPageContext());
        this.bjt.setDivider(null);
        this.bjt.setPullRefresh(this.mPullView);
        this.bjt.setDividerHeight(0);
        this.bjt.setRecyclerListener(new cs(this));
        this.aXw = new PbListView(this.bgW.getPageContext().getPageActivity());
        this.aXw.ni();
        this.aXw.df(t.d.cp_bg_line_c);
        this.bjt.setOnSrollToBottomListener(this.bgW);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new ct(this)));
        this.bju = new bf(this.bgW, this.bjt, com.baidu.tbadk.core.util.ax.wg().wi());
        this.bjv = (TextView) this.bgW.findViewById(t.g.frs_noexist_post);
        this.bjv.setVisibility(8);
        this.bjn.setOnClickListener(this.bjG);
        this.bjo.setOnClickListener(this.bjG);
        this.bjn.setOnTouchListener(this.bjS);
        this.aWk = (NoNetworkView) this.bgW.findViewById(t.g.view_no_network);
        cs(false);
    }

    public void PK() {
        if (this.bjl != null && this.bjl.isShown()) {
            this.bjl.setVisibility(8);
        }
    }

    private void PL() {
        if (this.bjI == null) {
            this.bjI = new BannerView(this.bgW.getPageContext().getPageActivity());
            this.bjI.setLayoutParams(new AbsListView.LayoutParams(-1, this.bgW.getResources().getDimensionPixelSize(t.e.frs_header_banner_height)));
            this.bjI.setVisibility(8);
            this.bjI.setBannerViewClickListener(this.bjQ);
            this.bjI.setBannerViewEvent(new cu(this));
        }
    }

    private void B(int i, String str) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "CLICK", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.bgW.Pk().aoE().getId(), ImageViewerConfig.FORUM_NAME, this.bgW.Pk().aoE().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void PM() {
        if (this.bjJ != null) {
            String value = this.bjJ.getValue();
            int sc = this.bjJ.sc();
            if (this.bjJ.sa() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.bgW.getPageContext().getPageActivity(), value, false, "frs_banner")));
                B(sc, value);
            } else if (this.bjJ.sa() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.bgW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bgW.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                            B(sc, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bjJ.sa() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ady != UtilHelper.NativePageType.NONE) {
                    switch (Qr()[isNativeAddress.ady.ordinal()]) {
                        case 2:
                            this.bgW.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bgW.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            B(sc, value);
                            return;
                        case 3:
                            this.bgW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bgW.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            B(sc, value);
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.be.wt().c(this.bgW.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bgW.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bjJ.sa() == 4) {
                this.bgW.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bgW.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                B(sc, value);
            }
        }
    }

    public void PN() {
        com.baidu.adp.lib.h.j.a(this.Su, this.bgW.getPageContext().getPageActivity());
    }

    public View PO() {
        return this.bjA;
    }

    public View PP() {
        return this.bjB;
    }

    public View PQ() {
        return this.bjC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView PR() {
        return this.bjk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View PS() {
        return this.bjz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View PT() {
        return this.bjm;
    }

    public void f(NoNetworkView.a aVar) {
        this.bdG = aVar;
        if (this.aWk != null) {
            this.aWk.a(this.bdG);
        }
    }

    public void a(com.baidu.tbadk.core.data.ah ahVar, boolean z) {
        String string = this.bgW.getPageContext().getPageActivity().getString(t.j.view);
        String string2 = this.bgW.getPageContext().getPageActivity().getString(t.j.view_host);
        String string3 = this.bgW.getPageContext().getPageActivity().getString(t.j.view_reverse);
        this.bjE = new com.baidu.tbadk.core.dialog.c(this.bgW.getPageContext().getPageActivity());
        this.bjE.cb(t.j.operation);
        if (z) {
            this.bjE.a(new String[]{string, string3}, this.bjH);
        } else {
            this.bjE.a(new String[]{string, string2, string3}, this.bjH);
        }
        this.bjE.d(this.bgW.getPageContext());
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bjt.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.bju.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bju.a(wVar);
    }

    public void o(View.OnClickListener onClickListener) {
        this.bju.o(onClickListener);
    }

    public void q(View.OnClickListener onClickListener) {
        this.bju.p(onClickListener);
    }

    public void a(c.b bVar) {
        this.bjH = bVar;
    }

    public void a(BdListView.g gVar) {
        this.bjt.setOnScrollToPullListener(gVar);
    }

    public void PU() {
        if (this.bjE != null) {
            this.bjE.un();
        }
    }

    public void onDestroy() {
        this.bju.onDestory();
        this.bjt.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.bjT);
    }

    private Animation PV() {
        if (this.bjF == null) {
            this.bjF = AnimationUtils.loadAnimation(this.bgW.getPageContext().getPageActivity(), t.a.refresh_rotate);
            this.bjF.setInterpolator(new LinearInterpolator());
            this.bjF.setFillAfter(true);
        }
        return this.bjF;
    }

    public void cs(boolean z) {
        this.bji = z;
        if (z) {
            this.bjn.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.bgW, this.bjs, PV(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.ar.c(this.bjr, t.f.pic_fresh_s);
            return;
        }
        this.bjn.setOnTouchListener(this.bjS);
        this.bjt.nr();
        ((com.baidu.adp.widget.ListView.e) this.bjt.getAdapter()).notifyDataSetChanged();
        this.bjs.clearAnimation();
        com.baidu.tbadk.core.util.ar.c(this.bjr, t.f.pic_fresh_n);
    }

    public boolean Pl() {
        return this.bji;
    }

    public void KZ() {
        this.bjt.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bgW.getPageContext().getPageActivity().getString(t.j.forum));
        com.baidu.tbadk.core.l.rn().ch(str);
    }

    public void PW() {
        if (this.bju != null) {
            this.bju.notifyDataSetChanged();
        }
    }

    public void ct(boolean z) {
        this.bju.cq(z);
    }

    public void cu(boolean z) {
        this.bju.cr(z);
    }

    private void PX() {
        if (this.bjw == null) {
            String[] strArr = {this.bgW.getPageContext().getPageActivity().getString(t.j.take_photo), this.bgW.getPageContext().getPageActivity().getString(t.j.album)};
            this.bjw = new com.baidu.tbadk.core.dialog.c(this.bgW.getPageContext().getPageActivity());
            this.bjw.cF(this.bgW.getPageContext().getPageActivity().getString(t.j.operation));
            this.bjw.a(strArr, new cv(this));
            this.bjw.d(this.bgW.getPageContext());
        }
    }

    public void PY() {
        PX();
        if (this.bjw != null) {
            this.bjw.un();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            dd ddVar = new dd();
            arrayList = new ArrayList<>();
            arrayList.add(ddVar);
            this.bjv.setText(t.j.frs_nodata);
            this.bjv.setVisibility(8);
        } else {
            this.bjv.setVisibility(8);
        }
        this.bju.a(arrayList, oVar, gu(i), gv(i2));
    }

    public BdListView KM() {
        return this.bjt;
    }

    private boolean gu(int i) {
        return i > 1;
    }

    private boolean gv(int i) {
        return i == 1;
    }

    public void PZ() {
        this.bju.cq(false);
        this.bju.cr(false);
        this.bju.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bjJ = forumData.getFrsBannerData();
            int sc = this.bjJ.sc();
            if (!this.bjK) {
                PL();
                this.bjt.removeHeaderView(this.bjI);
                if (this.bjJ.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bgW.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            this.bjI.reset();
            if (this.bjJ.getType() == 1 && !TextUtils.isEmpty(this.bjJ.sb())) {
                this.bjI.c(this.bgW.getPageContext(), this.bjJ.sb());
            }
            W(i, sc);
        }
    }

    private void W(int i, int i2) {
        if (com.baidu.adp.lib.util.i.iZ()) {
            if (i == 0) {
                gw(i2);
                this.bjO = i2;
            }
            if (i == 1 && i2 != this.bjO) {
                gw(i2);
                this.bjO = i2;
            }
        }
    }

    private void gw(int i) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.bgW.getForumId(), ImageViewerConfig.FORUM_NAME, this.bgW.Pk().aoE().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    public void Qa() {
        if (this.bjI != null) {
            this.bjK = false;
            this.bjt.removeHeaderView(this.bjI);
        }
    }

    public void onPause() {
        if (this.bjD != null) {
            com.baidu.adp.lib.h.j.a(this.Su, this.bgW.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aWk != null && this.bdG != null) {
            this.aWk.b(this.bdG);
        }
    }

    public void Qb() {
        this.bjy.setVisibility(8);
    }

    public void a(eb ebVar) {
        if (!FrsActivityStatic.bgR || ebVar == null) {
            this.bjy.setVisibility(8);
            return;
        }
        long Qx = FrsActivityStatic.bgS ? ebVar.Qx() - ebVar.Qy() : 0L;
        if (Qx > 0 && this.bjz.getVisibility() == 0) {
            this.bjy.setVisibility(0);
            if (Qx < 10) {
                this.bjy.setText(String.valueOf(Qx));
                com.baidu.tbadk.core.util.ar.k(this.bjy, t.f.icon_news_head_prompt_one);
                return;
            } else if (Qx < 100) {
                this.bjy.setText(String.valueOf(Qx));
                com.baidu.tbadk.core.util.ar.k(this.bjy, t.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bjy.setText("   ");
                com.baidu.tbadk.core.util.ar.k(this.bjy, t.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bjy.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.bju != null) {
            this.bju.Py();
            this.bju.notifyDataSetChanged();
            this.bju.onChangeSkinType(i);
        }
        this.bgW.OS();
        this.bgW.getLayoutMode().ac(i == 1);
        this.bgW.getLayoutMode().x(this.bjj);
        this.mNavigationBar.onChangeSkinType(this.bgW.getPageContext(), i);
        if (this.Su != null) {
            this.Su.onChangeSkinType(this.bgW, i, com.baidu.tbadk.core.util.ar.getDrawable(t.f.bg_pull_down_n));
        }
        if (this.aWk != null) {
            this.aWk.onChangeSkinType(this.bgW.getPageContext(), i);
        }
        if (this.bjI != null) {
            this.bjI.oO();
        }
        if (this.aXw != null) {
            this.aXw.dg(i);
        }
        com.baidu.tbadk.core.util.ar.a(this.bjk, t.f.icon_edit_selector_s, t.f.icon_edit_selector);
        com.baidu.tbadk.core.util.ar.a(this.bjz, t.f.btn_more_selector_s, t.f.btn_more_selector);
        if (this.bjl != null) {
            com.baidu.tbadk.core.util.ar.k(this.bjl, t.f.icon_news_head_prompt_one);
        }
    }

    public void cv(boolean z) {
        if (z) {
            this.bjr.setAlpha(128);
            this.bjs.setAlpha(128);
            return;
        }
        this.bjr.setAlpha(MotionEventCompat.ACTION_MASK);
        this.bjs.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void ns() {
        this.bjt.ns();
    }

    public int Qc() {
        return 0;
    }

    public void Qd() {
        this.bjn.setVisibility(0);
    }

    public void Qe() {
        this.bjn.setVisibility(8);
    }

    public boolean Qf() {
        return this.bjq.getVisibility() == 0;
    }

    public void Qg() {
        this.bjo.setVisibility(0);
        this.bjq.setVisibility(8);
        this.bjp.setVisibility(0);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.bjT, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        this.bjo.setVisibility(0);
        String ua = amVar.ua();
        String ub = amVar.ub();
        this.bjp.d(ua, 10, false);
        this.bjq.d(ub, 10, false);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.bjT, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void Qh() {
        this.bjo.setVisibility(8);
    }

    public bf Qi() {
        return this.bju;
    }

    public View getRootView() {
        return this.bjj;
    }

    public View Qj() {
        return this.bjL;
    }

    public void gx(int i) {
        LinearLayout linearLayout = (LinearLayout) this.bgW.findViewById(t.g.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Qk() {
        this.bjx.setVisibility(8);
    }

    public void Ql() {
        this.bjx.setVisibility(0);
    }

    public void Qm() {
        if (com.baidu.tbadk.performanceLog.aa.FY().FZ()) {
            int lastVisiblePosition = this.bjt.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bjt.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof dj) {
                        dj djVar = (dj) childAt.getTag();
                        if (djVar.beU != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = djVar.beU.getPerfLog();
                            perfLog.eZ(1000);
                            perfLog.aAD = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                djVar.beU.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            djVar.beU.wQ();
                        }
                        if (djVar.beS != null && (djVar.beS instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = djVar.beS;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eZ(1000);
                                    perfLog2.aAD = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.wQ();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bt) {
                        bt btVar = (bt) childAt.getTag();
                        if (btVar.bhM != null) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = btVar.bhM.getPerfLog();
                            perfLog3.eZ(1000);
                            perfLog3.aAD = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                btVar.bhM.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            btVar.bhM.wQ();
                        }
                        if (btVar.bij != null && (btVar.bij instanceof TbImageView)) {
                            TbImageView tbImageView2 = btVar.bij;
                            com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eZ(1000);
                            perfLog4.aAD = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.wQ();
                        }
                    }
                    if (childAt.getTag() instanceof cm) {
                        cm cmVar = (cm) childAt.getTag();
                        if (cmVar.bjg != null && cmVar.bjg.aMs != null && (cmVar.bjg.aMs instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog5 = cmVar.bjg.aMs.getPerfLog();
                            perfLog5.eZ(1000);
                            perfLog5.aAD = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                cmVar.bjg.aMs.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            cmVar.bjg.aMs.wQ();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (cmVar.aMn != null) {
                            arrayList.add(cmVar.aMn);
                        }
                        if (cmVar.aMo != null) {
                            arrayList.add(cmVar.aMo);
                        }
                        if (cmVar.aMp != null) {
                            arrayList.add(cmVar.aMp);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eZ(1000);
                                perfLog6.aAD = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.wQ();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Qn() {
        this.mHasMore = true;
        this.bjt.setNextPage(this.aXw);
        this.aXw.xb();
    }

    public void Qo() {
        this.mHasMore = false;
        if (this.bjN > 0) {
            this.aXw.dh(this.bjN);
        }
        this.bjt.setNextPage(this.aXw);
        this.aXw.xc();
        this.aXw.setText(this.bgW.getResources().getString(t.j.list_no_more));
    }

    public void Qp() {
        this.mHasMore = false;
        this.bjt.setNextPage(null);
        this.aXw.xd();
    }

    public void Qq() {
        this.aXw.xd();
    }

    public boolean OM() {
        return this.aXw.getView().getParent() != null && this.mHasMore;
    }

    public void gy(int i) {
        this.bjN = i;
    }
}
