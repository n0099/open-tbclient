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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bf {
    private static /* synthetic */ int[] aLQ;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aDO;
    private com.baidu.tieba.tbadkCore.w aIV;
    private FrsActivity aJT;
    private View.OnClickListener aLA;
    private ImageView aLC;
    private com.baidu.tbadk.coreExtra.view.q aLD;
    private LinearLayout aLE;
    private com.baidu.tbadk.core.data.k aLF;
    private View aLG;
    private FrsOfficalBanner aLI;
    private View aLJ;
    private CustomMessageListener aLL;
    private View aLg;
    private am aLl;
    private View aLq;
    private View aLr;
    private View aLs;
    private ImageView aLt;
    private ImageView aLu;
    private ImageView aLv;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private TextView mTitle;
    private boolean aLe = false;
    private RelativeLayout aup = null;
    private ImageView aLf = null;
    private FrameLayout aLh = null;
    private ImageView aLi = null;
    private ImageView aLj = null;
    private BdTypeListView aLk = null;
    private TextView aLm = null;
    private com.baidu.tbadk.core.dialog.e aLn = null;
    private TextView aLo = null;
    private View aLp = null;
    private com.baidu.tbadk.core.view.ag mPullView = null;
    private com.baidu.tieba.tbadkCore.ac aLw = null;
    private String aLx = null;
    com.baidu.tbadk.core.dialog.e aLy = null;
    Animation aLz = null;
    private com.baidu.tbadk.core.dialog.h aLB = null;
    private com.baidu.tbadk.core.view.y aJx = null;
    private BannerView aBA = null;
    private boolean aLH = false;
    private boolean aLK = false;
    com.baidu.tbadk.coreExtra.view.b aLM = new bg(this);
    com.baidu.tbadk.coreExtra.view.b aLN = new bi(this);
    View aLO = null;
    private View.OnTouchListener aLP = new bj(this);

    static /* synthetic */ int[] Kp() {
        int[] iArr = aLQ;
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
            aLQ = iArr;
        }
        return iArr;
    }

    public bf(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aJT = null;
        this.aLA = null;
        this.aJT = frsActivity;
        this.aLA = onClickListener;
        initUI();
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.aIV = wVar;
        this.aLC.setVisibility(8);
        if (this.aLD != null && this.aLD.getVisibility() != 0 && wVar != null && wVar.YO() != null && wVar.YO().getAnchorPower() != null && wVar.YO().getAnchorPower().have_power.intValue() != 0 && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aLC.setVisibility(0);
        }
    }

    private void initUI() {
        this.aup = (RelativeLayout) this.aJT.findViewById(com.baidu.tieba.v.frs);
        this.mNavigationBar = (NavigationBar) this.aJT.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aLI = (FrsOfficalBanner) this.aJT.findViewById(com.baidu.tieba.v.frs_offical_banner);
        this.aLI.setBannerViewClickListener(this.aLN);
        this.aLg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aLg.setOnClickListener(this.aLA);
        this.aLG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.frs_icon_bottom_title, (View.OnClickListener) null);
        this.mTitle = (TextView) this.aLG.findViewById(com.baidu.tieba.v.navigationTitle_frs);
        this.aLv = (ImageView) this.aLG.findViewById(com.baidu.tieba.v.icon_bottom_title_image);
        this.aLG.setOnClickListener(this.aLA);
        this.aLE = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_live, (View.OnClickListener) null);
        this.aLC = (ImageView) this.aLE.findViewById(com.baidu.tieba.v.nb_item_live_text_btn);
        this.aLC.setOnClickListener(this.aLA);
        if (this.aLL == null) {
            this.aLL = new bk(this, 0);
            this.aJT.registerListener(2001269, this.aLL);
        }
        this.aJT.sendMessage(new CustomMessage(2001269, this.aJT.getPageContext().getPageActivity()));
        this.aLJ = this.aJT.findViewById(com.baidu.tieba.v.frs_list_content);
        this.aLf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_edit, this.aLA);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_more, (View.OnClickListener) null);
        this.aLp = addCustomView.findViewById(com.baidu.tieba.v.frs_top_more);
        this.aLp.setOnClickListener(this.aLA);
        this.aLo = (TextView) addCustomView.findViewById(com.baidu.tieba.v.frs_more_mes_text);
        this.aLh = (FrameLayout) this.aJT.findViewById(com.baidu.tieba.v.refresh_layout);
        this.aLi = (ImageView) this.aJT.findViewById(com.baidu.tieba.v.refresh_bg);
        this.aLj = (ImageView) this.aJT.findViewById(com.baidu.tieba.v.refresh_icon);
        this.aLk = (BdTypeListView) this.aJT.findViewById(com.baidu.tieba.v.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.ag(this.aJT.getPageContext());
        this.aLk.setDivider(null);
        this.aLk.setPullRefresh(this.mPullView);
        this.aLk.setDividerHeight(0);
        this.aLk.setRecyclerListener(new bm(this));
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ak(new bn(this)));
        this.aLl = new am(this.aJT, this.aLk, com.baidu.tbadk.core.util.be.sY().ta());
        this.aLm = (TextView) this.aJT.findViewById(com.baidu.tieba.v.frs_noexist_post);
        this.aLm.setVisibility(8);
        this.aLh.setOnClickListener(this.aLA);
        this.aLh.setOnTouchListener(this.aLP);
        this.aDO = (NoNetworkView) this.aJT.findViewById(com.baidu.tieba.v.view_no_network);
        bR(false);
    }

    private void FT() {
        if (this.aBA == null) {
            this.aBA = new BannerView(this.aJT.getPageContext().getPageActivity());
            this.aBA.setLayoutParams(new AbsListView.LayoutParams(-1, this.aJT.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_banner_height)));
            this.aBA.setVisibility(8);
            this.aBA.setBannerViewClickListener(this.aLN);
            this.aBA.setBannerViewEvent(new bo(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void JP() {
        if (TextUtils.equals(this.aLx, "frs_page")) {
            TiebaStatic.eventStat(this.aJT.getPageContext().getPageActivity(), "top_banner_ck", "click");
        }
        if (this.aLF != null) {
            String value = this.aLF.getValue();
            if (this.aLF.pY() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.aJT.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aLF.pY() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aJT.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aJT.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aLF.pY() == 3) {
                new com.baidu.tbadk.core.util.br();
                com.baidu.tbadk.core.util.br isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.VG != UtilHelper.NativePageType.NONE) {
                    switch (Kp()[isNativeAddress.VG.ordinal()]) {
                        case 2:
                            this.aJT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aJT.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aJT.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aJT.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bk.tl().b(this.aJT.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aJT.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aLF.pY() == 4) {
                this.aJT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aJT.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void JQ() {
        this.aLO = com.baidu.adp.lib.g.b.hH().inflate(this.aJT.getPageContext().getPageActivity(), com.baidu.tieba.w.frs_pop_more_window, null);
        this.aLq = this.aLO.findViewById(com.baidu.tieba.v.frs_pop_more_window_all_threads_layout);
        this.aLq.setOnClickListener(this.aLA);
        this.aLt = (ImageView) this.aLO.findViewById(com.baidu.tieba.v.choose_all_threads);
        this.aLt.setVisibility(0);
        this.aLr = this.aLO.findViewById(com.baidu.tieba.v.frs_pop_more_window_good_threads_layout);
        this.aLr.setOnClickListener(this.aLA);
        this.aLu = (ImageView) this.aLO.findViewById(com.baidu.tieba.v.choose_good_threads);
        this.aLs = this.aLO.findViewById(com.baidu.tieba.v.frs_pop_more_window_add_shortcut_layout);
        this.aLs.setOnClickListener(this.aLA);
        if ("M351".equals(Build.MODEL)) {
            this.aLs.setVisibility(8);
        } else {
            this.aLs.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aJT.getPageContext().getPageActivity(), this.aLO, this.mNavigationBar, this.aJT.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), null);
    }

    public void bQ(boolean z) {
        if (this.mPopWindow == null) {
            JQ();
        }
        bU(z);
        this.aJT.getLayoutMode().h(this.aLO);
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void JR() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aJT.getPageContext().getPageActivity());
    }

    public View JS() {
        return this.aLG;
    }

    public View JT() {
        return this.aLq;
    }

    public View JU() {
        return this.aLr;
    }

    public View JV() {
        return this.aLs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView JW() {
        return this.aLf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aLp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View JX() {
        return this.aLg;
    }

    public void f(com.baidu.tbadk.core.view.y yVar) {
        this.aJx = yVar;
        if (this.aDO != null) {
            this.aDO.a(this.aJx);
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aJT.getPageContext().getPageActivity().getString(com.baidu.tieba.y.view);
        String string2 = this.aJT.getPageContext().getPageActivity().getString(com.baidu.tieba.y.view_host);
        String string3 = this.aJT.getPageContext().getPageActivity().getString(com.baidu.tieba.y.view_reverse);
        this.aLy = new com.baidu.tbadk.core.dialog.e(this.aJT.getPageContext().getPageActivity());
        this.aLy.by(com.baidu.tieba.y.operation);
        if (z) {
            this.aLy.a(new String[]{string, string3}, this.aLB);
        } else {
            this.aLy.a(new String[]{string, string2, string3}, this.aLB);
        }
        this.aLy.d(this.aJT.getPageContext());
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.mPullView.a(aeVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aLk.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.aj ajVar) {
        this.aLl.a(ajVar);
    }

    public void a(com.baidu.adp.widget.ListView.ak akVar) {
        this.aLl.a(akVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aLl.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aLl.k(onClickListener);
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar) {
        this.aLB = hVar;
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.aLk.setOnScrollToPullListener(zVar);
    }

    public void JY() {
        if (this.aLy != null) {
            this.aLy.rg();
        }
    }

    public void onDestroy() {
        if (this.aLL != null) {
            this.aLL = null;
        }
    }

    private Animation JZ() {
        if (this.aLz == null) {
            this.aLz = AnimationUtils.loadAnimation(this.aJT.getPageContext().getPageActivity(), com.baidu.tieba.p.refresh_rotate);
            this.aLz.setInterpolator(new LinearInterpolator());
            this.aLz.setFillAfter(true);
        }
        return this.aLz;
    }

    public void bR(boolean z) {
        this.aLe = z;
        if (z) {
            this.aLh.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aJT, this.aLj, JZ(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.ba.c(this.aLi, com.baidu.tieba.u.pic_fresh_s);
            return;
        }
        this.aLh.setOnTouchListener(this.aLP);
        this.aLk.mW();
        this.aLj.clearAnimation();
        com.baidu.tbadk.core.util.ba.c(this.aLi, com.baidu.tieba.u.pic_fresh_n);
    }

    public boolean Jv() {
        return this.aLe;
    }

    public void Ka() {
        this.aLk.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setText("");
            this.aLv.setVisibility(4);
            return;
        }
        this.mTitle.setText(String.valueOf(str) + this.aJT.getPageContext().getPageActivity().getString(com.baidu.tieba.y.forum));
        this.aLv.setVisibility(0);
    }

    public void Kb() {
        if (this.aLl != null) {
            this.aLl.notifyDataSetChanged();
        }
    }

    public void bS(boolean z) {
        this.aLl.bM(z);
    }

    public void bT(boolean z) {
        this.aLl.bN(z);
    }

    private void Kc() {
        if (this.aLn == null) {
            String[] strArr = {this.aJT.getPageContext().getPageActivity().getString(com.baidu.tieba.y.take_photo), this.aJT.getPageContext().getPageActivity().getString(com.baidu.tieba.y.album)};
            this.aLn = new com.baidu.tbadk.core.dialog.e(this.aJT.getPageContext().getPageActivity());
            this.aLn.cb(this.aJT.getPageContext().getPageActivity().getString(com.baidu.tieba.y.operation));
            this.aLn.a(strArr, new bp(this));
            this.aLn.d(this.aJT.getPageContext());
        }
    }

    public void Kd() {
        Kc();
        if (this.aLn != null) {
            this.aLn.rg();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, int i, com.baidu.tieba.tbadkCore.w wVar, int i2) {
        int i3;
        if (i > 1 && arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                com.baidu.adp.widget.ListView.ai aiVar = arrayList.get(i4);
                if (aiVar instanceof com.baidu.tbadk.core.data.m) {
                    arrayList.remove(aiVar);
                    i4--;
                    i3 = size - 1;
                } else {
                    i3 = size;
                }
                i4++;
                size = i3;
            }
        }
        this.aLl.a(arrayList, wVar, eM(i), eN(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aLm.setText(com.baidu.tieba.y.frs_nodata);
            this.aLm.setVisibility(0);
            return;
        }
        this.aLm.setVisibility(8);
    }

    public BdListView getListView() {
        return this.aLk;
    }

    private boolean eM(int i) {
        return i > 1;
    }

    private boolean eN(int i) {
        return i == 1;
    }

    public void Ke() {
        this.aLl.bM(false);
        this.aLl.bN(false);
        this.aLl.notifyDataSetInvalidated();
    }

    public void eO(int i) {
        this.aLk.setSelection(i);
    }

    private void bU(boolean z) {
        if (this.aLt != null && this.aLu != null) {
            if (z) {
                this.aLt.setVisibility(4);
                this.aLu.setVisibility(0);
                return;
            }
            this.aLt.setVisibility(0);
            this.aLu.setVisibility(4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData) {
        if (!this.aLH && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aLF = forumData.getFrsBannerData();
            FT();
            this.aBA.reset();
            this.aLk.removeHeaderView(this.aBA);
            if (this.aLF.getType() == 2) {
                this.aLI.setText(this.aLF.qa());
                this.aLI.setVisibility(0);
            } else if (this.aLF.getType() == 1 && !TextUtils.isEmpty(this.aLF.pZ())) {
                this.aBA.b(this.aJT.getPageContext(), this.aLF.pZ());
                if (this.aLF.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aJT.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Kf() {
        if (this.aBA != null) {
            this.aLH = false;
            this.aLk.removeHeaderView(this.aBA);
        }
    }

    public void onPause() {
        if (this.aLw != null) {
            com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aJT.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aDO != null && this.aJx != null) {
            this.aDO.b(this.aJx);
        }
    }

    public void Kg() {
        this.aLo.setVisibility(8);
    }

    public void a(cf cfVar) {
        if (!FrsActivityStatic.aJO || cfVar == null) {
            this.aLo.setVisibility(8);
            return;
        }
        long Ku = FrsActivityStatic.aJP ? cfVar.Ku() + 0 : 0L;
        if (FrsActivityStatic.aJQ) {
            Ku += cfVar.Kt();
        }
        if (Ku > 0 && this.aLp.getVisibility() == 0) {
            this.aLo.setVisibility(0);
            if (Ku < 10) {
                this.aLo.setText(String.valueOf(Ku));
                com.baidu.tbadk.core.util.ba.i((View) this.aLo, com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            } else if (Ku < 100) {
                this.aLo.setText(String.valueOf(Ku));
                com.baidu.tbadk.core.util.ba.i((View) this.aLo, com.baidu.tieba.u.icon_news_head_prompt_two);
                return;
            } else {
                this.aLo.setText("   ");
                com.baidu.tbadk.core.util.ba.i((View) this.aLo, com.baidu.tieba.u.icon_news_head_prompt_more);
                return;
            }
        }
        this.aLo.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ct(i);
        }
        if (this.aLl != null) {
            this.aLl.JH();
            this.aLl.notifyDataSetChanged();
            this.aLl.onChangeSkinType(i);
        }
        this.aJT.Jk();
        this.aJT.getLayoutMode().X(i == 1);
        this.aJT.getLayoutMode().h(this.aup);
        this.mNavigationBar.onChangeSkinType(this.aJT.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aJT, i, com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.bg_pull_down_n));
        }
        if (this.aDO != null) {
            this.aDO.onChangeSkinType(this.aJT.getPageContext(), i);
        }
        if (this.aBA != null) {
            this.aBA.oq();
        }
        if (this.aLD != null) {
            this.aLD.onChangeSkinType(this.aJT.getPageContext(), i);
        }
    }

    public void bV(boolean z) {
        if (z) {
            this.aLi.setAlpha(128);
            this.aLj.setAlpha(128);
            return;
        }
        this.aLi.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aLj.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void mX() {
        this.aLk.mX();
    }

    public int Kh() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public void Ki() {
        this.aLh.setVisibility(0);
    }

    public void Kj() {
        this.aLh.setVisibility(8);
    }

    public am Kk() {
        return this.aLl;
    }

    public View getRootView() {
        return this.aup;
    }

    public View Kl() {
        return this.aLJ;
    }

    public void eP(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aJT.findViewById(com.baidu.tieba.v.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Km() {
        if (com.baidu.tbadk.performanceLog.ah.CK().CL()) {
            int lastVisiblePosition = this.aLk.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aLk.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof bw) {
                        bw bwVar = (bw) childAt.getTag();
                        if (bwVar.aIi != null) {
                            com.baidu.tbadk.performanceLog.z perfLog = bwVar.aIi.getPerfLog();
                            perfLog.eb(1000);
                            perfLog.apl = true;
                            perfLog.apk = this.aJT.aJi;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                bwVar.aIi.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bwVar.aIi.tK();
                        }
                        if (bwVar.aIe != null && (bwVar.aIe instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = bwVar.aIe;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.z perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eb(1000);
                                    perfLog2.apl = true;
                                    perfLog2.apk = this.aJT.aJi;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.tK();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof au) {
                        au auVar = (au) childAt.getTag();
                        if (auVar.aKw != null) {
                            com.baidu.tbadk.performanceLog.z perfLog3 = auVar.aKw.getPerfLog();
                            perfLog3.eb(1000);
                            perfLog3.apl = true;
                            perfLog3.apk = this.aJT.aJi;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                auVar.aKw.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            auVar.aKw.tK();
                        }
                        if (auVar.aKA != null && (auVar.aKA instanceof TbImageView)) {
                            TbImageView tbImageView2 = auVar.aKA;
                            com.baidu.tbadk.performanceLog.z perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eb(1000);
                            perfLog4.apl = true;
                            perfLog4.apk = this.aJT.aJi;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.tK();
                        }
                    }
                    if (childAt.getTag() instanceof ay) {
                        ay ayVar = (ay) childAt.getTag();
                        if (ayVar.aKL != null && ayVar.aKL.azr != null && (ayVar.aKL.azr instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.z perfLog5 = ayVar.aKL.azr.getPerfLog();
                            perfLog5.eb(1000);
                            perfLog5.apl = true;
                            perfLog5.apk = this.aJT.aJi;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                ayVar.aKL.azr.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            ayVar.aKL.azr.tK();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (ayVar.azm != null) {
                            arrayList.add(ayVar.azm);
                        }
                        if (ayVar.azn != null) {
                            arrayList.add(ayVar.azn);
                        }
                        if (ayVar.azo != null) {
                            arrayList.add(ayVar.azo);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.z perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eb(1000);
                                perfLog6.apl = true;
                                perfLog6.apk = this.aJT.aJi;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.tK();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    public FrsOfficalBanner Kn() {
        return this.aLI;
    }

    public void Ko() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(this.mNavigationBar).O(200).v(false).w(false);
        gVar.b(new bq(this));
        gVar.a(new bh(this));
        com.baidu.adp.lib.guide.d gV = gVar.gV();
        gV.t(false);
        gV.i(this.aJT.getPageContext().getPageActivity());
    }
}
