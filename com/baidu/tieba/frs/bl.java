package com.baidu.tieba.frs;

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
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bl {
    private static /* synthetic */ int[] aXB;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aNx;
    private com.baidu.tieba.tbadkCore.n aUy;
    private FrsActivity aVx;
    private View aWU;
    private as aWZ;
    private View aXc;
    private View aXf;
    private View aXg;
    private View aXh;
    private View.OnClickListener aXl;
    private ImageView aXn;
    private com.baidu.tbadk.coreExtra.view.j aXo;
    private LinearLayout aXp;
    private com.baidu.tbadk.core.data.j aXq;
    private View aXs;
    private PbListView aXu;
    private CustomMessageListener aXw;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private boolean aWR = false;
    private NoPressedRelativeLayout aWS = null;
    private ImageView aWT = null;
    private FrameLayout aWV = null;
    private ImageView aWW = null;
    private ImageView aWX = null;
    private BdTypeListView aWY = null;
    private TextView aXa = null;
    private com.baidu.tbadk.core.dialog.c aXb = null;
    private TextView aXd = null;
    private View aXe = null;
    private com.baidu.tbadk.core.view.z mPullView = null;
    private com.baidu.tieba.tbadkCore.s aXi = null;
    com.baidu.tbadk.core.dialog.c aXj = null;
    Animation aXk = null;
    private c.b aXm = null;
    private NoNetworkView.a aSF = null;
    private BannerView aLc = null;
    private boolean aXr = false;
    private boolean aXt = false;
    private boolean mHasMore = true;
    private int aXv = 0;
    BannerView.a aXx = new bm(this);
    BannerView.a aXy = new bn(this);
    View aXz = null;
    private View.OnTouchListener aXA = new bo(this);

    static /* synthetic */ int[] Mr() {
        int[] iArr = aXB;
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
            aXB = iArr;
        }
        return iArr;
    }

    public bl(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aVx = null;
        this.aXl = null;
        this.aVx = frsActivity;
        this.aXl = onClickListener;
        initUI();
    }

    public void b(com.baidu.tieba.tbadkCore.n nVar) {
        this.aUy = nVar;
        this.aXn.setVisibility(8);
        if (this.aXo != null && this.aXo.getVisibility() != 0 && nVar != null && nVar.acG() != null && nVar.acG().getAnchorPower() != null && nVar.acG().getAnchorPower().have_power.intValue() != 0 && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aXn.setVisibility(0);
        }
    }

    private void initUI() {
        this.aWS = (NoPressedRelativeLayout) this.aVx.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aVx.findViewById(i.f.view_navigation_bar);
        this.aWU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aWU.setOnClickListener(this.aXl);
        this.aXp = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_live, (View.OnClickListener) null);
        this.aXn = (ImageView) this.aXp.findViewById(i.f.nb_item_live_text_btn);
        this.aXn.setOnClickListener(this.aXl);
        if (this.aXw == null) {
            this.aXw = new bp(this, 0);
            this.aVx.registerListener(CmdConfigCustom.CMD_GET_LIVE_PLAY_IMAGE, this.aXw);
        }
        this.aVx.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GET_LIVE_PLAY_IMAGE, this.aVx.getPageContext().getPageActivity()));
        this.aXs = this.aVx.findViewById(i.f.frs_list_content);
        this.aWT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_edit, this.aXl);
        this.aXc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_more, (View.OnClickListener) null);
        this.aXe = this.aXc.findViewById(i.f.frs_top_more);
        this.aXe.setOnClickListener(this.aXl);
        this.aXd = (TextView) this.aXc.findViewById(i.f.frs_more_mes_text);
        this.aWV = (FrameLayout) this.aVx.findViewById(i.f.refresh_layout);
        this.aWW = (ImageView) this.aVx.findViewById(i.f.refresh_bg);
        this.aWX = (ImageView) this.aVx.findViewById(i.f.refresh_icon);
        this.aWY = (BdTypeListView) this.aVx.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.z(this.aVx.getPageContext());
        this.aWY.setDivider(null);
        this.aWY.setPullRefresh(this.mPullView);
        this.aWY.setDividerHeight(0);
        this.aWY.setRecyclerListener(new br(this));
        this.aXu = new PbListView(this.aVx.getPageContext().getPageActivity());
        this.aXu.nq();
        this.aXu.cF(i.c.cp_bg_line_c);
        this.aWY.setOnSrollToBottomListener(this.aVx);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.z(new bs(this)));
        this.aWZ = new as(this.aVx, this.aWY, com.baidu.tbadk.core.util.ar.uE().uG());
        this.aXa = (TextView) this.aVx.findViewById(i.f.frs_noexist_post);
        this.aXa.setVisibility(8);
        this.aWV.setOnClickListener(this.aXl);
        this.aWV.setOnTouchListener(this.aXA);
        this.aNx = (NoNetworkView) this.aVx.findViewById(i.f.view_no_network);
        ca(false);
    }

    private void HU() {
        if (this.aLc == null) {
            this.aLc = new BannerView(this.aVx.getPageContext().getPageActivity());
            this.aLc.setLayoutParams(new AbsListView.LayoutParams(-1, this.aVx.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aLc.setVisibility(8);
            this.aLc.setBannerViewClickListener(this.aXy);
            this.aLc.setBannerViewEvent(new bt(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LQ() {
        if (this.aXq != null) {
            String value = this.aXq.getValue();
            if (this.aXq.rH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aVx.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aXq.rH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aVx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVx.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aXq.rH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.abo != UtilHelper.NativePageType.NONE) {
                    switch (Mr()[isNativeAddress.abo.ordinal()]) {
                        case 2:
                            this.aVx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVx.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aVx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVx.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.ax.uR().b(this.aVx.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aVx.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aXq.rH() == 4) {
                this.aVx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVx.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void LR() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aVx.getPageContext().getPageActivity());
    }

    public View LS() {
        return this.aXf;
    }

    public View LT() {
        return this.aXg;
    }

    public View LU() {
        return this.aXh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView LV() {
        return this.aWT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aXe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View LW() {
        return this.aWU;
    }

    public void g(NoNetworkView.a aVar) {
        this.aSF = aVar;
        if (this.aNx != null) {
            this.aNx.a(this.aSF);
        }
    }

    public void a(com.baidu.tbadk.core.data.v vVar, boolean z) {
        String string = this.aVx.getPageContext().getPageActivity().getString(i.C0057i.view);
        String string2 = this.aVx.getPageContext().getPageActivity().getString(i.C0057i.view_host);
        String string3 = this.aVx.getPageContext().getPageActivity().getString(i.C0057i.view_reverse);
        this.aXj = new com.baidu.tbadk.core.dialog.c(this.aVx.getPageContext().getPageActivity());
        this.aXj.bF(i.C0057i.operation);
        if (z) {
            this.aXj.a(new String[]{string, string3}, this.aXm);
        } else {
            this.aXj.a(new String[]{string, string2, string3}, this.aXm);
        }
        this.aXj.d(this.aVx.getPageContext());
    }

    public void a(x.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aWY.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.aWZ.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.aWZ.a(wVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aWZ.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aWZ.k(onClickListener);
    }

    public void a(c.b bVar) {
        this.aXm = bVar;
    }

    public void a(BdListView.g gVar) {
        this.aWY.setOnScrollToPullListener(gVar);
    }

    public void LX() {
        if (this.aXj != null) {
            this.aXj.sS();
        }
    }

    public void onDestroy() {
        if (this.aXw != null) {
            this.aXw = null;
        }
        this.aWZ.onDestory();
        this.aWY.setOnSrollToBottomListener(null);
    }

    private Animation LY() {
        if (this.aXk == null) {
            this.aXk = AnimationUtils.loadAnimation(this.aVx.getPageContext().getPageActivity(), i.a.refresh_rotate);
            this.aXk.setInterpolator(new LinearInterpolator());
            this.aXk.setFillAfter(true);
        }
        return this.aXk;
    }

    public void ca(boolean z) {
        this.aWR = z;
        if (z) {
            this.aWV.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aVx, this.aWX, LY(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.al.c(this.aWW, i.e.pic_fresh_s);
            return;
        }
        this.aWV.setOnTouchListener(this.aXA);
        this.aWY.completePullRefresh();
        this.aWX.clearAnimation();
        com.baidu.tbadk.core.util.al.c(this.aWW, i.e.pic_fresh_n);
    }

    public boolean Lv() {
        return this.aWR;
    }

    public void LZ() {
        this.aWY.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
        } else {
            this.mNavigationBar.setTitleText(String.valueOf(str) + this.aVx.getPageContext().getPageActivity().getString(i.C0057i.forum));
        }
    }

    public void Ma() {
        if (this.aWZ != null) {
            this.aWZ.notifyDataSetChanged();
        }
    }

    public void cb(boolean z) {
        this.aWZ.bY(z);
    }

    public void cc(boolean z) {
        this.aWZ.bZ(z);
    }

    private void Mb() {
        if (this.aXb == null) {
            String[] strArr = {this.aVx.getPageContext().getPageActivity().getString(i.C0057i.take_photo), this.aVx.getPageContext().getPageActivity().getString(i.C0057i.album)};
            this.aXb = new com.baidu.tbadk.core.dialog.c(this.aVx.getPageContext().getPageActivity());
            this.aXb.co(this.aVx.getPageContext().getPageActivity().getString(i.C0057i.operation));
            this.aXb.a(strArr, new bu(this));
            this.aXb.d(this.aVx.getPageContext());
        }
    }

    public void Mc() {
        Mb();
        if (this.aXb != null) {
            this.aXb.sS();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.n nVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            bx bxVar = new bx();
            arrayList = new ArrayList<>();
            arrayList.add(bxVar);
            this.aXa.setText(i.C0057i.frs_nodata);
            this.aXa.setVisibility(8);
        } else {
            this.aXa.setVisibility(8);
        }
        this.aWZ.a(arrayList, nVar, fn(i), fo(i2));
    }

    public BdListView getListView() {
        return this.aWY;
    }

    private boolean fn(int i) {
        return i > 1;
    }

    private boolean fo(int i) {
        return i == 1;
    }

    public void Md() {
        this.aWZ.bY(false);
        this.aWZ.bZ(false);
        this.aWZ.notifyDataSetInvalidated();
    }

    public void fp(int i) {
        this.aWY.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aXr && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aXq = forumData.getFrsBannerData();
            HU();
            this.aLc.reset();
            this.aWY.removeHeaderView(this.aLc);
            if (this.aXq.getType() == 1 && !TextUtils.isEmpty(this.aXq.rI())) {
                this.aLc.b(this.aVx.getPageContext(), this.aXq.rI());
                if (this.aXq.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aVx.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Me() {
        if (this.aLc != null) {
            this.aXr = false;
            this.aWY.removeHeaderView(this.aLc);
        }
    }

    public void onPause() {
        if (this.aXi != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aVx.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aNx != null && this.aSF != null) {
            this.aNx.b(this.aSF);
        }
    }

    public void Mf() {
        this.aXd.setVisibility(8);
    }

    public void a(cn cnVar) {
        if (!FrsActivityStatic.aVs || cnVar == null) {
            this.aXd.setVisibility(8);
            return;
        }
        long Mw = FrsActivityStatic.aVt ? cnVar.Mw() + 0 : 0L;
        if (FrsActivityStatic.aVu) {
            Mw += cnVar.Mv();
        }
        if (Mw > 0 && this.aXe.getVisibility() == 0) {
            this.aXd.setVisibility(0);
            if (Mw < 10) {
                this.aXd.setText(String.valueOf(Mw));
                com.baidu.tbadk.core.util.al.i((View) this.aXd, i.e.icon_news_head_prompt_one);
                return;
            } else if (Mw < 100) {
                this.aXd.setText(String.valueOf(Mw));
                com.baidu.tbadk.core.util.al.i((View) this.aXd, i.e.icon_news_head_prompt_two);
                return;
            } else {
                this.aXd.setText("   ");
                com.baidu.tbadk.core.util.al.i((View) this.aXd, i.e.icon_news_head_prompt_more);
                return;
            }
        }
        this.aXd.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cG(i);
        }
        if (this.aWZ != null) {
            this.aWZ.LG();
            this.aWZ.notifyDataSetChanged();
            this.aWZ.onChangeSkinType(i);
        }
        this.aVx.Lj();
        this.aVx.getLayoutMode().ad(i == 1);
        this.aVx.getLayoutMode().k(this.aWS);
        this.mNavigationBar.onChangeSkinType(this.aVx.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aVx, i, com.baidu.tbadk.core.util.al.getDrawable(i.e.bg_pull_down_n));
        }
        if (this.aNx != null) {
            this.aNx.onChangeSkinType(this.aVx.getPageContext(), i);
        }
        if (this.aLc != null) {
            this.aLc.oQ();
        }
        if (this.aXo != null) {
            this.aXo.onChangeSkinType(this.aVx.getPageContext(), i);
        }
        if (this.aXu != null) {
            this.aXu.cG(i);
        }
    }

    public void cd(boolean z) {
        if (z) {
            this.aWW.setAlpha(128);
            this.aWX.setAlpha(128);
            return;
        }
        this.aWW.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aWX.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void ny() {
        this.aWY.ny();
    }

    public int Mg() {
        return 0;
    }

    public void Mh() {
        this.aWV.setVisibility(0);
    }

    public void Mi() {
        this.aWV.setVisibility(8);
    }

    public as Mj() {
        return this.aWZ;
    }

    public View getRootView() {
        return this.aWS;
    }

    public View Mk() {
        return this.aXs;
    }

    public void fq(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aVx.findViewById(i.f.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Ml() {
        this.aXc.setVisibility(8);
    }

    public void Mm() {
        this.aXc.setVisibility(0);
    }

    public void Mn() {
        if (com.baidu.tbadk.performanceLog.y.Ee().Ef()) {
            int lastVisiblePosition = this.aWY.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWY.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cf) {
                        cf cfVar = (cf) childAt.getTag();
                        if (cfVar.aTO != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = cfVar.aTO.getPerfLog();
                            perfLog.eq(1000);
                            perfLog.axj = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                cfVar.aTO.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            cfVar.aTO.vu();
                        }
                        if (cfVar.aTK != null && (cfVar.aTK instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = cfVar.aTK;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eq(1000);
                                    perfLog2.axj = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vu();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bb) {
                        bb bbVar = (bb) childAt.getTag();
                        if (bbVar.aWe != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bbVar.aWe.getPerfLog();
                            perfLog3.eq(1000);
                            perfLog3.axj = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bbVar.aWe.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bbVar.aWe.vu();
                        }
                        if (bbVar.aWi != null && (bbVar.aWi instanceof TbImageView)) {
                            TbImageView tbImageView2 = bbVar.aWi;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eq(1000);
                            perfLog4.axj = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vu();
                        }
                    }
                    if (childAt.getTag() instanceof bg) {
                        bg bgVar = (bg) childAt.getTag();
                        if (bgVar.aWx != null && bgVar.aWx.aIG != null && (bgVar.aWx.aIG instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = bgVar.aWx.aIG.getPerfLog();
                            perfLog5.eq(1000);
                            perfLog5.axj = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                bgVar.aWx.aIG.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bgVar.aWx.aIG.vu();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (bgVar.aIB != null) {
                            arrayList.add(bgVar.aIB);
                        }
                        if (bgVar.aIC != null) {
                            arrayList.add(bgVar.aIC);
                        }
                        if (bgVar.aID != null) {
                            arrayList.add(bgVar.aID);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eq(1000);
                                perfLog6.axj = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vu();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Mo() {
        this.mHasMore = true;
        this.aWY.setNextPage(this.aXu);
        this.aXu.startLoadData();
    }

    public void Mp() {
        this.mHasMore = false;
        if (this.aXv > 0) {
            this.aXu.cH(this.aXv);
        }
        this.aWY.setNextPage(this.aXu);
        this.aXu.vB();
        this.aXu.setText(this.aVx.getResources().getString(i.C0057i.list_no_more));
    }

    public void Mq() {
        this.mHasMore = false;
        this.aWY.setNextPage(null);
        this.aXu.vC();
    }

    public boolean Le() {
        return this.aXu.getView().getParent() != null && this.mHasMore;
    }

    public void fr(int i) {
        this.aXv = i;
    }
}
