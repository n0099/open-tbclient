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
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class cs {
    private static /* synthetic */ int[] bpd;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private MorePopupWindow PS;
    private NoNetworkView baT;
    private PbListView bcf;
    private CommonTipView bde;
    private FrsActivity blH;
    private bh boE;
    private View boH;
    private View boK;
    private View boL;
    private View boM;
    private View.OnClickListener boQ;
    private com.baidu.tbadk.core.data.p boT;
    private View boV;
    private TextView bov;
    private View bow;
    private NavigationBar mNavigationBar;
    private boolean bos = false;
    private NoPressedRelativeLayout bot = null;
    private ImageView bou = null;
    private FrameLayout box = null;
    private FrameLayout boy = null;
    private TbImageView boz = null;
    private TbImageView boA = null;
    private ImageView boB = null;
    private ImageView boC = null;
    private BdTypeListView boD = null;
    private TextView boF = null;
    private com.baidu.tbadk.core.dialog.c boG = null;
    private TextView boI = null;
    private ImageView boJ = null;
    private com.baidu.tbadk.core.view.u mPullView = null;
    private com.baidu.tieba.tbadkCore.t boN = null;
    com.baidu.tbadk.core.dialog.c boO = null;
    Animation boP = null;
    private c.b boR = null;
    private NoNetworkView.a bit = null;
    private BannerView boS = null;
    private boolean boU = false;
    private boolean boW = false;
    private boolean mHasMore = true;
    private int boX = 0;
    private int boY = 0;
    BannerView.a boZ = new ct(this);
    BannerView.a bpa = new cu(this);
    View bpb = null;
    private View.OnTouchListener aJt = new cv(this);
    private Runnable bpc = new cw(this);

    static /* synthetic */ int[] Sk() {
        int[] iArr = bpd;
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
            bpd = iArr;
        }
        return iArr;
    }

    public cs(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.blH = null;
        this.boQ = null;
        this.blH = frsActivity;
        this.boQ = onClickListener;
        pU();
    }

    private void pU() {
        this.bot = (NoPressedRelativeLayout) this.blH.findViewById(t.g.frs);
        this.mNavigationBar = (NavigationBar) this.blH.findViewById(t.g.view_navigation_bar);
        this.bow = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bow.setOnClickListener(this.boQ);
        this.boV = this.blH.findViewById(t.g.frs_list_content);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bou = (ImageView) addCustomView.findViewById(t.g.frs_top_more);
        this.bou.setContentDescription(this.blH.getResources().getString(t.j.publish_thread));
        com.baidu.tbadk.core.util.at.a(this.bou, t.f.icon_edit_selector_s, t.f.icon_edit_selector);
        this.bou.setOnClickListener(this.boQ);
        this.bov = (TextView) addCustomView.findViewById(t.g.frs_more_mes_text);
        RD();
        this.boH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_frs_more, (View.OnClickListener) null);
        this.boJ = (ImageView) this.boH.findViewById(t.g.frs_top_more);
        this.boJ.setContentDescription(this.blH.getResources().getString(t.j.more));
        com.baidu.tbadk.core.util.at.a(this.boJ, t.f.btn_more_selector_s, t.f.btn_more_selector);
        this.boJ.setOnClickListener(this.boQ);
        this.boI = (TextView) this.boH.findViewById(t.g.frs_more_mes_text);
        this.box = (FrameLayout) this.blH.findViewById(t.g.refresh_layout);
        this.boB = (ImageView) this.blH.findViewById(t.g.refresh_bg);
        this.boC = (ImageView) this.blH.findViewById(t.g.refresh_icon);
        this.boy = (FrameLayout) this.blH.findViewById(t.g.game_activity_egg_layout);
        this.boz = (TbImageView) this.blH.findViewById(t.g.game_activity_egg);
        this.boA = (TbImageView) this.blH.findViewById(t.g.game_activity_egg_s);
        this.boz.setDefaultBgResource(t.d.transparent);
        this.boz.setDefaultResource(0);
        this.boA.setDefaultBgResource(t.d.transparent);
        this.boA.setDefaultResource(0);
        this.boD = (BdTypeListView) this.blH.findViewById(t.g.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.u(this.blH.getPageContext());
        this.boD.setDivider(null);
        this.boD.setPullRefresh(this.mPullView);
        this.boD.setDividerHeight(0);
        this.boD.setRecyclerListener(new cx(this));
        this.bcf = new PbListView(this.blH.getPageContext().getPageActivity());
        this.bcf.mZ();
        this.bcf.di(t.d.cp_bg_line_c);
        this.boD.setOnSrollToBottomListener(this.blH);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new cy(this)));
        this.boE = new bh(this.blH, this.boD, com.baidu.tbadk.core.util.az.wz().wB());
        this.boF = (TextView) this.blH.findViewById(t.g.frs_noexist_post);
        this.boF.setVisibility(8);
        this.box.setOnClickListener(this.boQ);
        this.boy.setOnClickListener(this.boQ);
        this.box.setOnTouchListener(this.aJt);
        this.baT = (NoNetworkView) this.blH.findViewById(t.g.view_no_network);
        cE(false);
    }

    public void RD() {
        if (this.bov != null && this.bov.isShown()) {
            this.bov.setVisibility(8);
        }
    }

    private void RE() {
        if (this.boS == null) {
            this.boS = new BannerView(this.blH.getPageContext().getPageActivity());
            this.boS.setLayoutParams(new AbsListView.LayoutParams(-1, this.blH.getResources().getDimensionPixelSize(t.e.frs_header_banner_height)));
            this.boS.setVisibility(8);
            this.boS.setBannerViewClickListener(this.bpa);
            this.boS.setBannerViewEvent(new cz(this));
        }
    }

    private void t(int i, String str) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "CLICK", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", "fid", this.blH.QZ().avu().getId(), ImageViewerConfig.FORUM_NAME, this.blH.QZ().avu().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void RF() {
        if (this.boT != null) {
            String value = this.boT.getValue();
            int rF = this.boT.rF();
            if (this.boT.rD() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.blH.getPageContext().getPageActivity(), value, false, "frs_banner")));
                t(rF, value);
            } else if (this.boT.rD() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.blH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.blH.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                            t(rF, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.boT.rD() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.acN != UtilHelper.NativePageType.NONE) {
                    switch (Sk()[isNativeAddress.acN.ordinal()]) {
                        case 2:
                            this.blH.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.blH.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            t(rF, value);
                            return;
                        case 3:
                            this.blH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.blH.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            t(rF, value);
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bg.wM().c(this.blH.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.blH.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.boT.rD() == 4) {
                this.blH.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.blH.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                t(rF, value);
            }
        }
    }

    public void RG() {
        com.baidu.adp.lib.h.j.a(this.PS, this.blH.getPageContext().getPageActivity());
    }

    public View RH() {
        return this.boK;
    }

    public View RI() {
        return this.boL;
    }

    public View RJ() {
        return this.boM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView RK() {
        return this.bou;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View RL() {
        return this.boJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View RM() {
        return this.bow;
    }

    public void f(NoNetworkView.a aVar) {
        this.bit = aVar;
        if (this.baT != null) {
            this.baT.a(this.bit);
        }
    }

    public void a(com.baidu.tbadk.core.data.as asVar, boolean z) {
        String string = this.blH.getPageContext().getPageActivity().getString(t.j.view);
        String string2 = this.blH.getPageContext().getPageActivity().getString(t.j.view_host);
        String string3 = this.blH.getPageContext().getPageActivity().getString(t.j.view_reverse);
        this.boO = new com.baidu.tbadk.core.dialog.c(this.blH.getPageContext().getPageActivity());
        this.boO.cd(t.j.operation);
        if (z) {
            this.boO.a(new String[]{string, string3}, this.boR);
        } else {
            this.boO.a(new String[]{string, string2, string3}, this.boR);
        }
        this.boO.d(this.blH.getPageContext());
    }

    public void a(s.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.boD.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.boE.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.boE.a(wVar);
    }

    public void o(View.OnClickListener onClickListener) {
        this.boE.o(onClickListener);
    }

    public void q(View.OnClickListener onClickListener) {
        this.boE.p(onClickListener);
    }

    public void a(c.b bVar) {
        this.boR = bVar;
    }

    public void a(BdListView.g gVar) {
        this.boD.setOnScrollToPullListener(gVar);
    }

    public void RN() {
        if (this.boO != null) {
            this.boO.us();
        }
    }

    public void onDestroy() {
        this.boE.onDestory();
        this.boD.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.bpc);
        if (this.bde != null) {
            this.bde.onDestroy();
        }
    }

    private Animation RO() {
        if (this.boP == null) {
            this.boP = AnimationUtils.loadAnimation(this.blH.getPageContext().getPageActivity(), t.a.refresh_rotate);
            this.boP.setInterpolator(new LinearInterpolator());
            this.boP.setFillAfter(true);
        }
        return this.boP;
    }

    public void cE(boolean z) {
        this.bos = z;
        if (z) {
            this.box.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.blH, this.boC, RO(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.at.c(this.boB, t.f.pic_fresh_s);
            return;
        }
        this.box.setOnTouchListener(this.aJt);
        this.boD.nj();
        ((com.baidu.adp.widget.ListView.e) this.boD.getAdapter()).notifyDataSetChanged();
        this.boC.clearAnimation();
        com.baidu.tbadk.core.util.at.c(this.boB, t.f.pic_fresh_n);
    }

    public boolean Ra() {
        return this.bos;
    }

    public void Mu() {
        this.boD.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.blH.getPageContext().getPageActivity().getString(t.j.forum));
        com.baidu.tbadk.core.l.qE().ce(str);
    }

    public void RP() {
        if (this.boE != null) {
            this.boE.notifyDataSetChanged();
        }
    }

    public void cF(boolean z) {
        this.boE.cC(z);
    }

    public void cG(boolean z) {
        this.boE.cD(z);
    }

    private void RQ() {
        if (this.boG == null) {
            String[] strArr = {this.blH.getPageContext().getPageActivity().getString(t.j.take_photo), this.blH.getPageContext().getPageActivity().getString(t.j.album)};
            this.boG = new com.baidu.tbadk.core.dialog.c(this.blH.getPageContext().getPageActivity());
            this.boG.cD(this.blH.getPageContext().getPageActivity().getString(t.j.operation));
            this.boG.a(strArr, new da(this));
            this.boG.d(this.blH.getPageContext());
        }
    }

    public void RR() {
        RQ();
        if (this.boG != null) {
            this.boG.us();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            di diVar = new di();
            arrayList = new ArrayList<>();
            arrayList.add(diVar);
            this.boF.setText(t.j.frs_nodata);
            this.boF.setVisibility(8);
        } else {
            this.boF.setVisibility(8);
        }
        this.boE.a(arrayList, oVar, gL(i), gM(i2));
    }

    public BdListView Mg() {
        return this.boD;
    }

    private boolean gL(int i) {
        return i > 1;
    }

    private boolean gM(int i) {
        return i == 1;
    }

    public void RS() {
        this.boE.cC(false);
        this.boE.cD(false);
        this.boE.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData == null || forumData.getFrsBannerData() == null) {
            RT();
        } else if (!forumData.getFrsBannerData().isValid()) {
            RT();
        } else {
            this.boT = forumData.getFrsBannerData();
            int rF = this.boT.rF();
            if (!this.boU) {
                RE();
                this.boD.removeHeaderView(this.boS);
                if (this.boT.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.blH.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            this.boS.reset();
            if (this.boT.getType() == 1 && !TextUtils.isEmpty(this.boT.rE())) {
                this.boS.c(this.blH.getPageContext(), this.boT.rE());
            }
            U(i, rF);
        }
    }

    private void U(int i, int i2) {
        if (com.baidu.adp.lib.util.i.jf()) {
            if (i == 0) {
                gN(i2);
                this.boY = i2;
            }
            if (i == 1 && i2 != this.boY) {
                gN(i2);
                this.boY = i2;
            }
        }
    }

    private void gN(int i) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", "fid", this.blH.getForumId(), ImageViewerConfig.FORUM_NAME, this.blH.QZ().avu().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    public void RT() {
        if (this.boS != null) {
            this.boU = false;
            this.boD.removeHeaderView(this.boS);
            this.boS = null;
        }
    }

    public void onPause() {
        if (this.boN != null) {
            com.baidu.adp.lib.h.j.a(this.PS, this.blH.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.baT != null && this.bit != null) {
            this.baT.b(this.bit);
        }
    }

    public void RU() {
        this.boI.setVisibility(8);
    }

    public void a(ei eiVar) {
        long j;
        if (!FrsActivityStatic.blC || eiVar == null) {
            this.boI.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.blD) {
            j = eiVar.Sq() - eiVar.Sr();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ah()) {
                j -= eiVar.Ss();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.boJ.getVisibility() == 0) {
            this.boI.setVisibility(0);
            if (j < 10) {
                this.boI.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.at.k(this.boI, t.f.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.boI.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.at.k(this.boI, t.f.icon_news_head_prompt_two);
                return;
            } else {
                this.boI.setText("   ");
                com.baidu.tbadk.core.util.at.k(this.boI, t.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.boI.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.boE != null) {
            this.boE.Rn();
            this.boE.notifyDataSetChanged();
            this.boE.onChangeSkinType(i);
        }
        this.blH.QH();
        this.blH.getLayoutMode().ab(i == 1);
        this.blH.getLayoutMode().x(this.bot);
        this.mNavigationBar.onChangeSkinType(this.blH.getPageContext(), i);
        if (this.PS != null) {
            this.PS.onChangeSkinType(this.blH, i, com.baidu.tbadk.core.util.at.getDrawable(t.f.bg_pull_down_n));
        }
        if (this.baT != null) {
            this.baT.onChangeSkinType(this.blH.getPageContext(), i);
        }
        if (this.boS != null) {
            this.boS.oH();
        }
        if (this.bcf != null) {
            this.bcf.dj(i);
        }
        com.baidu.tbadk.core.util.at.a(this.bou, t.f.icon_edit_selector_s, t.f.icon_edit_selector);
        com.baidu.tbadk.core.util.at.a(this.boJ, t.f.btn_more_selector_s, t.f.btn_more_selector);
        if (this.bov != null) {
            com.baidu.tbadk.core.util.at.k(this.bov, t.f.icon_news_head_prompt_one);
        }
    }

    public void cH(boolean z) {
        if (z) {
            this.boB.setAlpha(128);
            this.boC.setAlpha(128);
            return;
        }
        this.boB.setAlpha(MotionEventCompat.ACTION_MASK);
        this.boC.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void nk() {
        this.boD.nk();
    }

    public int RV() {
        return 0;
    }

    public void RW() {
        this.box.setVisibility(0);
    }

    public void RX() {
        this.box.setVisibility(8);
    }

    public boolean RY() {
        return this.boA.getVisibility() == 0;
    }

    public void RZ() {
        this.boy.setVisibility(0);
        this.boA.setVisibility(8);
        this.boz.setVisibility(0);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.bpc, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void a(com.baidu.tbadk.core.data.ax axVar) {
        this.boy.setVisibility(0);
        String ug = axVar.ug();
        String uh = axVar.uh();
        this.boz.c(ug, 10, false);
        this.boA.c(uh, 10, false);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.bpc, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void Sa() {
        this.boy.setVisibility(8);
    }

    public bh Sb() {
        return this.boE;
    }

    public View getRootView() {
        return this.bot;
    }

    public View Sc() {
        return this.boV;
    }

    public void gO(int i) {
        LinearLayout linearLayout = (LinearLayout) this.blH.findViewById(t.g.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Sd() {
        this.boH.setVisibility(8);
    }

    public void Se() {
        this.boH.setVisibility(0);
    }

    public void Sf() {
        if (com.baidu.tbadk.performanceLog.aa.GU().GV()) {
            int lastVisiblePosition = this.boD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.boD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof dp) {
                        dp dpVar = (dp) childAt.getTag();
                        if (dpVar.bjG != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = dpVar.bjG.getPerfLog();
                            perfLog.fh(1000);
                            perfLog.aBs = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                dpVar.bjG.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            dpVar.bjG.xi();
                        }
                        if (dpVar.bjE != null && (dpVar.bjE instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = dpVar.bjE;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.fh(1000);
                                    perfLog2.aBs = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.xi();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bv) {
                        bv bvVar = (bv) childAt.getTag();
                        if (bvVar.bmz != null) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = bvVar.bmz.getPerfLog();
                            perfLog3.fh(1000);
                            perfLog3.aBs = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bvVar.bmz.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bvVar.bmz.xi();
                        }
                        if (bvVar.bmU != null && (bvVar.bmU instanceof TbImageView)) {
                            TbImageView tbImageView2 = bvVar.bmU;
                            com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.fh(1000);
                            perfLog4.aBs = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.xi();
                        }
                    }
                    if (childAt.getTag() instanceof co) {
                        co coVar = (co) childAt.getTag();
                        if (coVar.bnR != null && coVar.bnR.aPn != null && (coVar.bnR.aPn instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog5 = coVar.bnR.aPn.getPerfLog();
                            perfLog5.fh(1000);
                            perfLog5.aBs = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                coVar.bnR.aPn.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            coVar.bnR.aPn.xi();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (coVar.aPi != null) {
                            arrayList.add(coVar.aPi);
                        }
                        if (coVar.aPj != null) {
                            arrayList.add(coVar.aPj);
                        }
                        if (coVar.aPk != null) {
                            arrayList.add(coVar.aPk);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.fh(1000);
                                perfLog6.aBs = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.xi();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Sg() {
        this.mHasMore = true;
        this.boD.setNextPage(this.bcf);
        this.bcf.xu();
    }

    public void Sh() {
        this.mHasMore = false;
        if (this.boX > 0) {
            this.bcf.dk(this.boX);
        }
        this.boD.setNextPage(this.bcf);
        this.bcf.xv();
        this.bcf.setText(this.blH.getResources().getString(t.j.list_no_more));
    }

    public void Si() {
        this.mHasMore = false;
        this.boD.setNextPage(null);
        this.bcf.xw();
    }

    public void Sj() {
        this.bcf.xw();
    }

    public boolean QB() {
        return this.bcf.getView().getParent() != null && this.mHasMore;
    }

    public void gP(int i) {
        this.boX = i;
    }

    public void gQ(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("frs_login_tip", true)) {
                if (this.bde == null) {
                    this.bde = new CommonTipView(this.blH.getActivity());
                }
                this.bde.setText(t.j.frs_login_tip);
                this.bde.a((FrameLayout) Sc(), TbadkCoreApplication.m411getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("frs_login_tip", false);
            }
        }
    }
}
