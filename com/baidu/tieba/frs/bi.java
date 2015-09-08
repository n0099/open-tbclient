package com.baidu.tieba.frs;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
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
public class bi {
    private static /* synthetic */ int[] aXx;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aNK;
    private FrsActivity aVM;
    private View aWU;
    private at aWZ;
    private View aXc;
    private View aXf;
    private View aXg;
    private View aXh;
    private View.OnClickListener aXl;
    private com.baidu.tbadk.core.data.j aXn;
    private View aXp;
    private PbListView aXr;
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
    private com.baidu.tieba.tbadkCore.t aXi = null;
    com.baidu.tbadk.core.dialog.c aXj = null;
    Animation aXk = null;
    private c.b aXm = null;
    private NoNetworkView.a aST = null;
    private BannerView aLp = null;
    private boolean aXo = false;
    private boolean aXq = false;
    private boolean mHasMore = true;
    private int aXs = 0;
    BannerView.a aXt = new bj(this);
    BannerView.a aXu = new bk(this);
    View aXv = null;
    private View.OnTouchListener aXw = new bl(this);

    static /* synthetic */ int[] Mi() {
        int[] iArr = aXx;
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
            aXx = iArr;
        }
        return iArr;
    }

    public bi(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aVM = null;
        this.aXl = null;
        this.aVM = frsActivity;
        this.aXl = onClickListener;
        initUI();
    }

    private void initUI() {
        this.aWS = (NoPressedRelativeLayout) this.aVM.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aVM.findViewById(i.f.view_navigation_bar);
        this.aWU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aWU.setOnClickListener(this.aXl);
        this.aXp = this.aVM.findViewById(i.f.frs_list_content);
        this.aWT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_edit, this.aXl);
        this.aXc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_more, (View.OnClickListener) null);
        this.aXe = this.aXc.findViewById(i.f.frs_top_more);
        this.aXe.setOnClickListener(this.aXl);
        this.aXd = (TextView) this.aXc.findViewById(i.f.frs_more_mes_text);
        this.aWV = (FrameLayout) this.aVM.findViewById(i.f.refresh_layout);
        this.aWW = (ImageView) this.aVM.findViewById(i.f.refresh_bg);
        this.aWX = (ImageView) this.aVM.findViewById(i.f.refresh_icon);
        this.aWY = (BdTypeListView) this.aVM.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.z(this.aVM.getPageContext());
        this.aWY.setDivider(null);
        this.aWY.setPullRefresh(this.mPullView);
        this.aWY.setDividerHeight(0);
        this.aWY.setRecyclerListener(new bm(this));
        this.aXr = new PbListView(this.aVM.getPageContext().getPageActivity());
        this.aXr.nn();
        this.aXr.cL(i.c.cp_bg_line_c);
        this.aWY.setOnSrollToBottomListener(this.aVM);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new bn(this)));
        this.aWZ = new at(this.aVM, this.aWY, com.baidu.tbadk.core.util.ar.uK().uM());
        this.aXa = (TextView) this.aVM.findViewById(i.f.frs_noexist_post);
        this.aXa.setVisibility(8);
        this.aWV.setOnClickListener(this.aXl);
        this.aWV.setOnTouchListener(this.aXw);
        this.aNK = (NoNetworkView) this.aVM.findViewById(i.f.view_no_network);
        cf(false);
    }

    private void HI() {
        if (this.aLp == null) {
            this.aLp = new BannerView(this.aVM.getPageContext().getPageActivity());
            this.aLp.setLayoutParams(new AbsListView.LayoutParams(-1, this.aVM.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aLp.setVisibility(8);
            this.aLp.setBannerViewClickListener(this.aXu);
            this.aLp.setBannerViewEvent(new bo(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LH() {
        if (this.aXn != null) {
            String value = this.aXn.getValue();
            if (this.aXn.rG() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aVM.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aXn.rG() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aVM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVM.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aXn.rG() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aby != UtilHelper.NativePageType.NONE) {
                    switch (Mi()[isNativeAddress.aby.ordinal()]) {
                        case 2:
                            this.aVM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVM.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aVM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVM.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.ax.uX().b(this.aVM.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aVM.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aXn.rG() == 4) {
                this.aVM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVM.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void LI() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aVM.getPageContext().getPageActivity());
    }

    public View LJ() {
        return this.aXf;
    }

    public View LK() {
        return this.aXg;
    }

    public View LL() {
        return this.aXh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView LM() {
        return this.aWT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aXe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View LN() {
        return this.aWU;
    }

    public void g(NoNetworkView.a aVar) {
        this.aST = aVar;
        if (this.aNK != null) {
            this.aNK.a(this.aST);
        }
    }

    public void a(com.baidu.tbadk.core.data.x xVar, boolean z) {
        String string = this.aVM.getPageContext().getPageActivity().getString(i.h.view);
        String string2 = this.aVM.getPageContext().getPageActivity().getString(i.h.view_host);
        String string3 = this.aVM.getPageContext().getPageActivity().getString(i.h.view_reverse);
        this.aXj = new com.baidu.tbadk.core.dialog.c(this.aVM.getPageContext().getPageActivity());
        this.aXj.bI(i.h.operation);
        if (z) {
            this.aXj.a(new String[]{string, string3}, this.aXm);
        } else {
            this.aXj.a(new String[]{string, string2, string3}, this.aXm);
        }
        this.aXj.d(this.aVM.getPageContext());
    }

    public void a(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.aVM.getPageContext().getPageActivity());
        cVar.bI(i.h.publish_thread);
        cVar.a(new CharSequence[]{this.aVM.getPageContext().getPageActivity().getString(i.h.publish_topic_thread), v(this.aVM.getPageContext().getPageActivity().getString(i.h.publish_live_thread), i.e.icon_news_head_new)}, bVar);
        cVar.d(this.aVM.getPageContext());
        cVar.sX();
    }

    private CharSequence v(String str, int i) {
        ImageSpan[] imageSpanArr;
        if (!com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), false)) {
            Spanned fromHtml = Html.fromHtml(String.valueOf(str) + "<img src=\"" + i + "\">", new bp(this), null);
            if (fromHtml instanceof SpannableStringBuilder) {
                for (ImageSpan imageSpan : (ImageSpan[]) fromHtml.getSpans(0, fromHtml.length(), ImageSpan.class)) {
                    ((SpannableStringBuilder) fromHtml).setSpan(new a(imageSpan.getDrawable(), 1), fromHtml.getSpanStart(imageSpan), fromHtml.getSpanEnd(imageSpan), 34);
                    ((SpannableStringBuilder) fromHtml).removeSpan(imageSpan);
                }
            }
            return fromHtml;
        }
        return str;
    }

    /* loaded from: classes.dex */
    public class a extends ImageSpan {
        public a(Drawable drawable, int i) {
            super(drawable, i);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            int i6 = i5 - drawable.getBounds().bottom;
            canvas.translate(bi.this.aVM.getActivity().getResources().getDimensionPixelSize(i.d.ds24) + f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i4 = bounds.bottom - bounds.top;
                int i5 = (i4 / 2) - (i3 / 4);
                int i6 = (i3 / 4) + (i4 / 2);
                fontMetricsInt.ascent = -i6;
                fontMetricsInt.top = -i6;
                fontMetricsInt.bottom = i5;
                fontMetricsInt.descent = i5;
            }
            return bounds.right;
        }
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

    public void b(c.b bVar) {
        this.aXm = bVar;
    }

    public void a(BdListView.g gVar) {
        this.aWY.setOnScrollToPullListener(gVar);
    }

    public void LO() {
        if (this.aXj != null) {
            this.aXj.sX();
        }
    }

    public void onDestroy() {
        this.aWZ.onDestory();
        this.aWY.setOnSrollToBottomListener(null);
    }

    private Animation LP() {
        if (this.aXk == null) {
            this.aXk = AnimationUtils.loadAnimation(this.aVM.getPageContext().getPageActivity(), i.a.refresh_rotate);
            this.aXk.setInterpolator(new LinearInterpolator());
            this.aXk.setFillAfter(true);
        }
        return this.aXk;
    }

    public void cf(boolean z) {
        this.aWR = z;
        if (z) {
            this.aWV.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aVM, this.aWX, LP(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.al.c(this.aWW, i.e.pic_fresh_s);
            return;
        }
        this.aWV.setOnTouchListener(this.aXw);
        this.aWY.completePullRefresh();
        this.aWX.clearAnimation();
        com.baidu.tbadk.core.util.al.c(this.aWW, i.e.pic_fresh_n);
    }

    public boolean Lm() {
        return this.aWR;
    }

    public void LQ() {
        this.aWY.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
        } else {
            this.mNavigationBar.setTitleText(String.valueOf(str) + this.aVM.getPageContext().getPageActivity().getString(i.h.forum));
        }
    }

    public void LR() {
        if (this.aWZ != null) {
            this.aWZ.notifyDataSetChanged();
        }
    }

    public void cg(boolean z) {
        this.aWZ.cd(z);
    }

    public void ch(boolean z) {
        this.aWZ.ce(z);
    }

    private void LS() {
        if (this.aXb == null) {
            String[] strArr = {this.aVM.getPageContext().getPageActivity().getString(i.h.take_photo), this.aVM.getPageContext().getPageActivity().getString(i.h.album)};
            this.aXb = new com.baidu.tbadk.core.dialog.c(this.aVM.getPageContext().getPageActivity());
            this.aXb.cu(this.aVM.getPageContext().getPageActivity().getString(i.h.operation));
            this.aXb.a(strArr, new bq(this));
            this.aXb.d(this.aVM.getPageContext());
        }
    }

    public void LT() {
        LS();
        if (this.aXb != null) {
            this.aXb.sX();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            bt btVar = new bt();
            arrayList = new ArrayList<>();
            arrayList.add(btVar);
            this.aXa.setText(i.h.frs_nodata);
            this.aXa.setVisibility(8);
        } else {
            this.aXa.setVisibility(8);
        }
        this.aWZ.a(arrayList, oVar, fs(i), ft(i2));
    }

    public BdListView getListView() {
        return this.aWY;
    }

    private boolean fs(int i) {
        return i > 1;
    }

    private boolean ft(int i) {
        return i == 1;
    }

    public void LU() {
        this.aWZ.cd(false);
        this.aWZ.ce(false);
        this.aWZ.notifyDataSetInvalidated();
    }

    public void fu(int i) {
        this.aWY.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aXo && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aXn = forumData.getFrsBannerData();
            HI();
            this.aLp.reset();
            this.aWY.removeHeaderView(this.aLp);
            if (this.aXn.getType() == 1 && !TextUtils.isEmpty(this.aXn.rH())) {
                this.aLp.b(this.aVM.getPageContext(), this.aXn.rH());
                if (this.aXn.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aVM.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void LV() {
        if (this.aLp != null) {
            this.aXo = false;
            this.aWY.removeHeaderView(this.aLp);
        }
    }

    public void onPause() {
        if (this.aXi != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aVM.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aNK != null && this.aST != null) {
            this.aNK.b(this.aST);
        }
    }

    public void LW() {
        this.aXd.setVisibility(8);
    }

    public void a(cr crVar) {
        if (!FrsActivityStatic.aVH || crVar == null) {
            this.aXd.setVisibility(8);
            return;
        }
        long Mv = FrsActivityStatic.aVI ? crVar.Mv() + 0 : 0L;
        if (FrsActivityStatic.aVJ) {
            Mv += crVar.Mu();
        }
        if (Mv > 0 && this.aXe.getVisibility() == 0) {
            this.aXd.setVisibility(0);
            if (Mv < 10) {
                this.aXd.setText(String.valueOf(Mv));
                com.baidu.tbadk.core.util.al.h((View) this.aXd, i.e.icon_news_head_prompt_one);
                return;
            } else if (Mv < 100) {
                this.aXd.setText(String.valueOf(Mv));
                com.baidu.tbadk.core.util.al.h((View) this.aXd, i.e.icon_news_head_prompt_two);
                return;
            } else {
                this.aXd.setText("   ");
                com.baidu.tbadk.core.util.al.h((View) this.aXd, i.e.icon_news_head_prompt_more);
                return;
            }
        }
        this.aXd.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cM(i);
        }
        if (this.aWZ != null) {
            this.aWZ.Lx();
            this.aWZ.notifyDataSetChanged();
            this.aWZ.onChangeSkinType(i);
        }
        this.aVM.KX();
        this.aVM.getLayoutMode().ad(i == 1);
        this.aVM.getLayoutMode().k(this.aWS);
        this.mNavigationBar.onChangeSkinType(this.aVM.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aVM, i, com.baidu.tbadk.core.util.al.getDrawable(i.e.bg_pull_down_n));
        }
        if (this.aNK != null) {
            this.aNK.onChangeSkinType(this.aVM.getPageContext(), i);
        }
        if (this.aLp != null) {
            this.aLp.oN();
        }
        if (this.aXr != null) {
            this.aXr.cM(i);
        }
    }

    public void ci(boolean z) {
        if (z) {
            this.aWW.setAlpha(128);
            this.aWX.setAlpha(128);
            return;
        }
        this.aWW.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aWX.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void nv() {
        this.aWY.nv();
    }

    public int LX() {
        return 0;
    }

    public void LY() {
        this.aWV.setVisibility(0);
    }

    public void LZ() {
        this.aWV.setVisibility(8);
    }

    public at Ma() {
        return this.aWZ;
    }

    public View getRootView() {
        return this.aWS;
    }

    public View Mb() {
        return this.aXp;
    }

    public void fv(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aVM.findViewById(i.f.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Mc() {
        this.aXc.setVisibility(8);
    }

    public void Md() {
        this.aXc.setVisibility(0);
    }

    public void Me() {
        if (com.baidu.tbadk.performanceLog.y.Eo().Ep()) {
            int lastVisiblePosition = this.aWY.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWY.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cb) {
                        cb cbVar = (cb) childAt.getTag();
                        if (cbVar.aUc != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = cbVar.aUc.getPerfLog();
                            perfLog.ey(1000);
                            perfLog.ayR = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                cbVar.aUc.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            cbVar.aUc.vz();
                        }
                        if (cbVar.aTY != null && (cbVar.aTY instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = cbVar.aTY;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.ey(1000);
                                    perfLog2.ayR = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vz();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bc) {
                        bc bcVar = (bc) childAt.getTag();
                        if (bcVar.aWv != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bcVar.aWv.getPerfLog();
                            perfLog3.ey(1000);
                            perfLog3.ayR = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bcVar.aWv.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bcVar.aWv.vz();
                        }
                        if (bcVar.aWz != null && (bcVar.aWz instanceof TbImageView)) {
                            TbImageView tbImageView2 = bcVar.aWz;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.ey(1000);
                            perfLog4.ayR = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vz();
                        }
                    }
                    if (childAt.getTag() instanceof bh) {
                        bh bhVar = (bh) childAt.getTag();
                        if (bhVar.aWP != null && bhVar.aWP.aIT != null && (bhVar.aWP.aIT instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = bhVar.aWP.aIT.getPerfLog();
                            perfLog5.ey(1000);
                            perfLog5.ayR = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                bhVar.aWP.aIT.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bhVar.aWP.aIT.vz();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (bhVar.aIO != null) {
                            arrayList.add(bhVar.aIO);
                        }
                        if (bhVar.aIP != null) {
                            arrayList.add(bhVar.aIP);
                        }
                        if (bhVar.aIQ != null) {
                            arrayList.add(bhVar.aIQ);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.ey(1000);
                                perfLog6.ayR = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vz();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Mf() {
        this.mHasMore = true;
        this.aWY.setNextPage(this.aXr);
        this.aXr.startLoadData();
    }

    public void Mg() {
        this.mHasMore = false;
        if (this.aXs > 0) {
            this.aXr.cN(this.aXs);
        }
        this.aWY.setNextPage(this.aXr);
        this.aXr.vG();
        this.aXr.setText(this.aVM.getResources().getString(i.h.list_no_more));
    }

    public void Mh() {
        this.mHasMore = false;
        this.aWY.setNextPage(null);
        this.aXr.vH();
    }

    public boolean KS() {
        return this.aXr.getView().getParent() != null && this.mHasMore;
    }

    public void fw(int i) {
        this.aXs = i;
    }
}
