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
import com.baidu.tbadk.core.view.PbListView;
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
    private static /* synthetic */ int[] aMb;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aDW;
    private com.baidu.tieba.tbadkCore.w aJd;
    private FrsActivity aKd;
    private View aLA;
    private View aLB;
    private View aLC;
    private ImageView aLD;
    private ImageView aLE;
    private ImageView aLF;
    private View.OnClickListener aLK;
    private ImageView aLM;
    private com.baidu.tbadk.coreExtra.view.q aLN;
    private LinearLayout aLO;
    private com.baidu.tbadk.core.data.k aLP;
    private View aLQ;
    private FrsOfficalBanner aLS;
    private View aLT;
    private PbListView aLV;
    private CustomMessageListener aLW;
    private View aLq;
    private am aLv;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private TextView mTitle;
    private boolean aLo = false;
    private RelativeLayout aux = null;
    private ImageView aLp = null;
    private FrameLayout aLr = null;
    private ImageView aLs = null;
    private ImageView aLt = null;
    private BdTypeListView aLu = null;
    private TextView aLw = null;
    private com.baidu.tbadk.core.dialog.e aLx = null;
    private TextView aLy = null;
    private View aLz = null;
    private com.baidu.tbadk.core.view.ag mPullView = null;
    private com.baidu.tieba.tbadkCore.ac aLG = null;
    private String aLH = null;
    com.baidu.tbadk.core.dialog.e aLI = null;
    Animation aLJ = null;
    private com.baidu.tbadk.core.dialog.h aLL = null;
    private com.baidu.tbadk.core.view.y aJH = null;
    private BannerView aBI = null;
    private boolean aLR = false;
    private boolean aLU = false;
    com.baidu.tbadk.coreExtra.view.b aLX = new bg(this);
    com.baidu.tbadk.coreExtra.view.b aLY = new bi(this);
    View aLZ = null;
    private View.OnTouchListener aMa = new bj(this);

    static /* synthetic */ int[] Kz() {
        int[] iArr = aMb;
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
            aMb = iArr;
        }
        return iArr;
    }

    public bf(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aKd = null;
        this.aLK = null;
        this.aKd = frsActivity;
        this.aLK = onClickListener;
        initUI();
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.aJd = wVar;
        this.aLM.setVisibility(8);
        if (this.aLN != null && this.aLN.getVisibility() != 0 && wVar != null && wVar.Za() != null && wVar.Za().getAnchorPower() != null && wVar.Za().getAnchorPower().have_power.intValue() != 0 && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aLM.setVisibility(0);
        }
    }

    private void initUI() {
        this.aux = (RelativeLayout) this.aKd.findViewById(com.baidu.tieba.v.frs);
        this.mNavigationBar = (NavigationBar) this.aKd.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aLS = (FrsOfficalBanner) this.aKd.findViewById(com.baidu.tieba.v.frs_offical_banner);
        this.aLS.setBannerViewClickListener(this.aLY);
        this.aLq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aLq.setOnClickListener(this.aLK);
        this.aLQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.frs_icon_bottom_title, (View.OnClickListener) null);
        this.mTitle = (TextView) this.aLQ.findViewById(com.baidu.tieba.v.navigationTitle_frs);
        this.aLF = (ImageView) this.aLQ.findViewById(com.baidu.tieba.v.icon_bottom_title_image);
        this.aLQ.setOnClickListener(this.aLK);
        this.aLO = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_live, (View.OnClickListener) null);
        this.aLM = (ImageView) this.aLO.findViewById(com.baidu.tieba.v.nb_item_live_text_btn);
        this.aLM.setOnClickListener(this.aLK);
        if (this.aLW == null) {
            this.aLW = new bk(this, 0);
            this.aKd.registerListener(2001269, this.aLW);
        }
        this.aKd.sendMessage(new CustomMessage(2001269, this.aKd.getPageContext().getPageActivity()));
        this.aLT = this.aKd.findViewById(com.baidu.tieba.v.frs_list_content);
        this.aLp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_edit, this.aLK);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_more, (View.OnClickListener) null);
        this.aLz = addCustomView.findViewById(com.baidu.tieba.v.frs_top_more);
        this.aLz.setOnClickListener(this.aLK);
        this.aLy = (TextView) addCustomView.findViewById(com.baidu.tieba.v.frs_more_mes_text);
        this.aLr = (FrameLayout) this.aKd.findViewById(com.baidu.tieba.v.refresh_layout);
        this.aLs = (ImageView) this.aKd.findViewById(com.baidu.tieba.v.refresh_bg);
        this.aLt = (ImageView) this.aKd.findViewById(com.baidu.tieba.v.refresh_icon);
        this.aLu = (BdTypeListView) this.aKd.findViewById(com.baidu.tieba.v.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.ag(this.aKd.getPageContext());
        this.aLu.setDivider(null);
        this.aLu.setPullRefresh(this.mPullView);
        this.aLu.setDividerHeight(0);
        this.aLu.setRecyclerListener(new bm(this));
        this.aLV = new PbListView(this.aKd.getPageContext().getPageActivity());
        this.aLV.mN();
        this.aLV.cs(com.baidu.tieba.s.cp_bg_line_c);
        this.aLu.setOnSrollToBottomListener(this.aKd);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ak(new bn(this)));
        this.aLv = new am(this.aKd, this.aLu, com.baidu.tbadk.core.util.be.sY().ta());
        this.aLw = (TextView) this.aKd.findViewById(com.baidu.tieba.v.frs_noexist_post);
        this.aLw.setVisibility(8);
        this.aLr.setOnClickListener(this.aLK);
        this.aLr.setOnTouchListener(this.aMa);
        this.aDW = (NoNetworkView) this.aKd.findViewById(com.baidu.tieba.v.view_no_network);
        bP(false);
    }

    private void FZ() {
        if (this.aBI == null) {
            this.aBI = new BannerView(this.aKd.getPageContext().getPageActivity());
            this.aBI.setLayoutParams(new AbsListView.LayoutParams(-1, this.aKd.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_banner_height)));
            this.aBI.setVisibility(8);
            this.aBI.setBannerViewClickListener(this.aLY);
            this.aBI.setBannerViewEvent(new bo(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void JW() {
        if (TextUtils.equals(this.aLH, "frs_page")) {
            TiebaStatic.eventStat(this.aKd.getPageContext().getPageActivity(), "top_banner_ck", "click");
        }
        if (this.aLP != null) {
            String value = this.aLP.getValue();
            if (this.aLP.pY() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.aKd.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aLP.pY() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aKd.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aKd.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aLP.pY() == 3) {
                new com.baidu.tbadk.core.util.br();
                com.baidu.tbadk.core.util.br isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.VI != UtilHelper.NativePageType.NONE) {
                    switch (Kz()[isNativeAddress.VI.ordinal()]) {
                        case 2:
                            this.aKd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aKd.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aKd.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aKd.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bk.tl().b(this.aKd.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aKd.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aLP.pY() == 4) {
                this.aKd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aKd.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void JX() {
        this.aLZ = com.baidu.adp.lib.g.b.hH().inflate(this.aKd.getPageContext().getPageActivity(), com.baidu.tieba.w.frs_pop_more_window, null);
        this.aLA = this.aLZ.findViewById(com.baidu.tieba.v.frs_pop_more_window_all_threads_layout);
        this.aLA.setOnClickListener(this.aLK);
        this.aLD = (ImageView) this.aLZ.findViewById(com.baidu.tieba.v.choose_all_threads);
        this.aLD.setVisibility(0);
        this.aLB = this.aLZ.findViewById(com.baidu.tieba.v.frs_pop_more_window_good_threads_layout);
        this.aLB.setOnClickListener(this.aLK);
        this.aLE = (ImageView) this.aLZ.findViewById(com.baidu.tieba.v.choose_good_threads);
        this.aLC = this.aLZ.findViewById(com.baidu.tieba.v.frs_pop_more_window_add_shortcut_layout);
        this.aLC.setOnClickListener(this.aLK);
        if ("M351".equals(Build.MODEL)) {
            this.aLC.setVisibility(8);
        } else {
            this.aLC.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aKd.getPageContext().getPageActivity(), this.aLZ, this.mNavigationBar, this.aKd.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), null);
    }

    public void bO(boolean z) {
        if (this.mPopWindow == null) {
            JX();
        }
        bS(z);
        this.aKd.getLayoutMode().h(this.aLZ);
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void JY() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aKd.getPageContext().getPageActivity());
    }

    public View JZ() {
        return this.aLQ;
    }

    public View Ka() {
        return this.aLA;
    }

    public View Kb() {
        return this.aLB;
    }

    public View Kc() {
        return this.aLC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView Kd() {
        return this.aLp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aLz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Ke() {
        return this.aLq;
    }

    public void f(com.baidu.tbadk.core.view.y yVar) {
        this.aJH = yVar;
        if (this.aDW != null) {
            this.aDW.a(this.aJH);
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aKd.getPageContext().getPageActivity().getString(com.baidu.tieba.y.view);
        String string2 = this.aKd.getPageContext().getPageActivity().getString(com.baidu.tieba.y.view_host);
        String string3 = this.aKd.getPageContext().getPageActivity().getString(com.baidu.tieba.y.view_reverse);
        this.aLI = new com.baidu.tbadk.core.dialog.e(this.aKd.getPageContext().getPageActivity());
        this.aLI.by(com.baidu.tieba.y.operation);
        if (z) {
            this.aLI.a(new String[]{string, string3}, this.aLL);
        } else {
            this.aLI.a(new String[]{string, string2, string3}, this.aLL);
        }
        this.aLI.d(this.aKd.getPageContext());
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.mPullView.a(aeVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aLu.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.aj ajVar) {
        this.aLv.a(ajVar);
    }

    public void a(com.baidu.adp.widget.ListView.ak akVar) {
        this.aLv.a(akVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aLv.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aLv.k(onClickListener);
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar) {
        this.aLL = hVar;
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.aLu.setOnScrollToPullListener(zVar);
    }

    public void Kf() {
        if (this.aLI != null) {
            this.aLI.rg();
        }
    }

    public void onDestroy() {
        if (this.aLW != null) {
            this.aLW = null;
        }
    }

    private Animation Kg() {
        if (this.aLJ == null) {
            this.aLJ = AnimationUtils.loadAnimation(this.aKd.getPageContext().getPageActivity(), com.baidu.tieba.p.refresh_rotate);
            this.aLJ.setInterpolator(new LinearInterpolator());
            this.aLJ.setFillAfter(true);
        }
        return this.aLJ;
    }

    public void bP(boolean z) {
        this.aLo = z;
        if (z) {
            this.aLr.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aKd, this.aLt, Kg(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.ba.c(this.aLs, com.baidu.tieba.u.pic_fresh_s);
            return;
        }
        this.aLr.setOnTouchListener(this.aMa);
        this.aLu.mW();
        this.aLt.clearAnimation();
        com.baidu.tbadk.core.util.ba.c(this.aLs, com.baidu.tieba.u.pic_fresh_n);
    }

    public boolean JB() {
        return this.aLo;
    }

    public void Kh() {
        this.aLu.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setText("");
            this.aLF.setVisibility(4);
            return;
        }
        this.mTitle.setText(String.valueOf(str) + this.aKd.getPageContext().getPageActivity().getString(com.baidu.tieba.y.forum));
        this.aLF.setVisibility(0);
    }

    public void Ki() {
        if (this.aLv != null) {
            this.aLv.notifyDataSetChanged();
        }
    }

    public void bQ(boolean z) {
        this.aLv.bM(z);
    }

    public void bR(boolean z) {
        this.aLv.bN(z);
    }

    private void Kj() {
        if (this.aLx == null) {
            String[] strArr = {this.aKd.getPageContext().getPageActivity().getString(com.baidu.tieba.y.take_photo), this.aKd.getPageContext().getPageActivity().getString(com.baidu.tieba.y.album)};
            this.aLx = new com.baidu.tbadk.core.dialog.e(this.aKd.getPageContext().getPageActivity());
            this.aLx.cb(this.aKd.getPageContext().getPageActivity().getString(com.baidu.tieba.y.operation));
            this.aLx.a(strArr, new bp(this));
            this.aLx.d(this.aKd.getPageContext());
        }
    }

    public void Kk() {
        Kj();
        if (this.aLx != null) {
            this.aLx.rg();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, int i, com.baidu.tieba.tbadkCore.w wVar, int i2) {
        this.aLv.a(arrayList, wVar, eM(i), eN(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aLw.setText(com.baidu.tieba.y.frs_nodata);
            this.aLw.setVisibility(0);
            return;
        }
        this.aLw.setVisibility(8);
    }

    public BdListView getListView() {
        return this.aLu;
    }

    private boolean eM(int i) {
        return i > 1;
    }

    private boolean eN(int i) {
        return i == 1;
    }

    public void Kl() {
        this.aLv.bM(false);
        this.aLv.bN(false);
        this.aLv.notifyDataSetInvalidated();
    }

    public void eO(int i) {
        this.aLu.setSelection(i);
    }

    private void bS(boolean z) {
        if (this.aLD != null && this.aLE != null) {
            if (z) {
                this.aLD.setVisibility(4);
                this.aLE.setVisibility(0);
                return;
            }
            this.aLD.setVisibility(0);
            this.aLE.setVisibility(4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData) {
        if (!this.aLR && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aLP = forumData.getFrsBannerData();
            FZ();
            this.aBI.reset();
            this.aLu.removeHeaderView(this.aBI);
            if (this.aLP.getType() == 2) {
                this.aLS.setText(this.aLP.qa());
                this.aLS.setVisibility(0);
            } else if (this.aLP.getType() == 1 && !TextUtils.isEmpty(this.aLP.pZ())) {
                this.aBI.b(this.aKd.getPageContext(), this.aLP.pZ());
                if (this.aLP.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aKd.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Km() {
        if (this.aBI != null) {
            this.aLR = false;
            this.aLu.removeHeaderView(this.aBI);
        }
    }

    public void onPause() {
        if (this.aLG != null) {
            com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aKd.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aDW != null && this.aJH != null) {
            this.aDW.b(this.aJH);
        }
    }

    public void Kn() {
        this.aLy.setVisibility(8);
    }

    public void a(cf cfVar) {
        if (!FrsActivityStatic.aJY || cfVar == null) {
            this.aLy.setVisibility(8);
            return;
        }
        long KE = FrsActivityStatic.aJZ ? cfVar.KE() + 0 : 0L;
        if (FrsActivityStatic.aKa) {
            KE += cfVar.KD();
        }
        if (KE > 0 && this.aLz.getVisibility() == 0) {
            this.aLy.setVisibility(0);
            if (KE < 10) {
                this.aLy.setText(String.valueOf(KE));
                com.baidu.tbadk.core.util.ba.i((View) this.aLy, com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            } else if (KE < 100) {
                this.aLy.setText(String.valueOf(KE));
                com.baidu.tbadk.core.util.ba.i((View) this.aLy, com.baidu.tieba.u.icon_news_head_prompt_two);
                return;
            } else {
                this.aLy.setText("   ");
                com.baidu.tbadk.core.util.ba.i((View) this.aLy, com.baidu.tieba.u.icon_news_head_prompt_more);
                return;
            }
        }
        this.aLy.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ct(i);
        }
        if (this.aLv != null) {
            this.aLv.JO();
            this.aLv.notifyDataSetChanged();
            this.aLv.onChangeSkinType(i);
        }
        this.aKd.Jq();
        this.aKd.getLayoutMode().X(i == 1);
        this.aKd.getLayoutMode().h(this.aux);
        this.mNavigationBar.onChangeSkinType(this.aKd.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aKd, i, com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.bg_pull_down_n));
        }
        if (this.aDW != null) {
            this.aDW.onChangeSkinType(this.aKd.getPageContext(), i);
        }
        if (this.aBI != null) {
            this.aBI.oq();
        }
        if (this.aLN != null) {
            this.aLN.onChangeSkinType(this.aKd.getPageContext(), i);
        }
        if (this.aLV != null) {
            this.aLV.ct(i);
        }
    }

    public void bT(boolean z) {
        if (z) {
            this.aLs.setAlpha(128);
            this.aLt.setAlpha(128);
            return;
        }
        this.aLs.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aLt.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void mX() {
        this.aLu.mX();
    }

    public int Ko() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public void Kp() {
        this.aLr.setVisibility(0);
    }

    public void Kq() {
        this.aLr.setVisibility(8);
    }

    public am Kr() {
        return this.aLv;
    }

    public View getRootView() {
        return this.aux;
    }

    public View Ks() {
        return this.aLT;
    }

    public void eP(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aKd.findViewById(com.baidu.tieba.v.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Kt() {
        if (com.baidu.tbadk.performanceLog.ah.CQ().CR()) {
            int lastVisiblePosition = this.aLu.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aLu.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof bw) {
                        bw bwVar = (bw) childAt.getTag();
                        if (bwVar.aIq != null) {
                            com.baidu.tbadk.performanceLog.z perfLog = bwVar.aIq.getPerfLog();
                            perfLog.eb(1000);
                            perfLog.apu = true;
                            perfLog.apt = this.aKd.aJq;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                bwVar.aIq.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bwVar.aIq.tK();
                        }
                        if (bwVar.aIm != null && (bwVar.aIm instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = bwVar.aIm;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.z perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eb(1000);
                                    perfLog2.apu = true;
                                    perfLog2.apt = this.aKd.aJq;
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
                        if (auVar.aKG != null) {
                            com.baidu.tbadk.performanceLog.z perfLog3 = auVar.aKG.getPerfLog();
                            perfLog3.eb(1000);
                            perfLog3.apu = true;
                            perfLog3.apt = this.aKd.aJq;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                auVar.aKG.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            auVar.aKG.tK();
                        }
                        if (auVar.aKK != null && (auVar.aKK instanceof TbImageView)) {
                            TbImageView tbImageView2 = auVar.aKK;
                            com.baidu.tbadk.performanceLog.z perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eb(1000);
                            perfLog4.apu = true;
                            perfLog4.apt = this.aKd.aJq;
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
                        if (ayVar.aKV != null && ayVar.aKV.azz != null && (ayVar.aKV.azz instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.z perfLog5 = ayVar.aKV.azz.getPerfLog();
                            perfLog5.eb(1000);
                            perfLog5.apu = true;
                            perfLog5.apt = this.aKd.aJq;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                ayVar.aKV.azz.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            ayVar.aKV.azz.tK();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (ayVar.azu != null) {
                            arrayList.add(ayVar.azu);
                        }
                        if (ayVar.azv != null) {
                            arrayList.add(ayVar.azv);
                        }
                        if (ayVar.azw != null) {
                            arrayList.add(ayVar.azw);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.z perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eb(1000);
                                perfLog6.apu = true;
                                perfLog6.apt = this.aKd.aJq;
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

    public FrsOfficalBanner Ku() {
        return this.aLS;
    }

    public void Kv() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(this.mNavigationBar).O(200).v(false).w(false);
        gVar.b(new bq(this));
        gVar.a(new bh(this));
        com.baidu.adp.lib.guide.d gV = gVar.gV();
        gV.t(false);
        gV.i(this.aKd.getPageContext().getPageActivity());
    }

    public void Kw() {
        this.aLu.setNextPage(this.aLV);
        this.aLV.startLoadData();
    }

    public void Kx() {
        this.aLu.setNextPage(this.aLV);
        this.aLV.tO();
        this.aLV.setText(this.aKd.getResources().getString(com.baidu.tieba.y.list_no_more));
    }

    public void Ky() {
        this.aLu.setNextPage(null);
    }
}
