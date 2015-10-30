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
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bs {
    private static /* synthetic */ int[] aXc;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aMQ;
    private FrsActivity aVf;
    private bb aWE;
    private View aWH;
    private View aWK;
    private View aWL;
    private View aWM;
    private View.OnClickListener aWQ;
    private com.baidu.tbadk.core.data.j aWS;
    private View aWU;
    private PbListView aWW;
    private TextView aWy;
    private View aWz;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private boolean aWv = false;
    private NoPressedRelativeLayout aWw = null;
    private ImageView aWx = null;
    private FrameLayout aWA = null;
    private ImageView aWB = null;
    private ImageView aWC = null;
    private BdTypeListView aWD = null;
    private TextView aWF = null;
    private com.baidu.tbadk.core.dialog.c aWG = null;
    private TextView aWI = null;
    private ImageView aWJ = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private com.baidu.tieba.tbadkCore.t aWN = null;
    com.baidu.tbadk.core.dialog.c aWO = null;
    Animation aWP = null;
    private c.b aWR = null;
    private NoNetworkView.a aSa = null;
    private BannerView aKs = null;
    private boolean aWT = false;
    private boolean aWV = false;
    private boolean mHasMore = true;
    private int aWX = 0;
    BannerView.a aWY = new bt(this);
    BannerView.a aWZ = new bu(this);
    View aXa = null;
    private View.OnTouchListener aXb = new bv(this);

    static /* synthetic */ int[] Md() {
        int[] iArr = aXc;
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
            aXc = iArr;
        }
        return iArr;
    }

    public bs(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aVf = null;
        this.aWQ = null;
        this.aVf = frsActivity;
        this.aWQ = onClickListener;
        initUI();
    }

    private void initUI() {
        this.aWw = (NoPressedRelativeLayout) this.aVf.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aVf.findViewById(i.f.view_navigation_bar);
        this.aWz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aWz.setOnClickListener(this.aWQ);
        this.aWU = this.aVf.findViewById(i.f.frs_list_content);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_more, (View.OnClickListener) null);
        this.aWx = (ImageView) addCustomView.findViewById(i.f.frs_top_more);
        com.baidu.tbadk.core.util.an.a(this.aWx, i.e.btn_more_selector_s, i.e.icon_edit_selector);
        this.aWx.setOnClickListener(this.aWQ);
        this.aWy = (TextView) addCustomView.findViewById(i.f.frs_more_mes_text);
        LB();
        this.aWH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_more, (View.OnClickListener) null);
        this.aWJ = (ImageView) this.aWH.findViewById(i.f.frs_top_more);
        com.baidu.tbadk.core.util.an.a(this.aWJ, i.e.btn_more_selector_s, i.e.btn_more_selector);
        this.aWJ.setOnClickListener(this.aWQ);
        this.aWI = (TextView) this.aWH.findViewById(i.f.frs_more_mes_text);
        this.aWA = (FrameLayout) this.aVf.findViewById(i.f.refresh_layout);
        this.aWB = (ImageView) this.aVf.findViewById(i.f.refresh_bg);
        this.aWC = (ImageView) this.aVf.findViewById(i.f.refresh_icon);
        this.aWD = (BdTypeListView) this.aVf.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aVf.getPageContext());
        this.aWD.setDivider(null);
        this.aWD.setPullRefresh(this.mPullView);
        this.aWD.setDividerHeight(0);
        this.aWD.setRecyclerListener(new bw(this));
        this.aWW = new PbListView(this.aVf.getPageContext().getPageActivity());
        this.aWW.no();
        this.aWW.cM(i.c.cp_bg_line_c);
        this.aWD.setOnSrollToBottomListener(this.aVf);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new bx(this)));
        this.aWE = new bb(this.aVf, this.aWD, com.baidu.tbadk.core.util.at.uG().uI());
        this.aWF = (TextView) this.aVf.findViewById(i.f.frs_noexist_post);
        this.aWF.setVisibility(8);
        this.aWA.setOnClickListener(this.aWQ);
        this.aWA.setOnTouchListener(this.aXb);
        this.aMQ = (NoNetworkView) this.aVf.findViewById(i.f.view_no_network);
        cc(false);
    }

    public void LB() {
        if (this.aWy != null) {
            if (com.baidu.tbadk.core.sharedPref.b.tr().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", false)) {
                this.aWy.setVisibility(8);
                return;
            }
            this.aWy.setVisibility(0);
            this.aWy.setText("N");
            com.baidu.tbadk.core.util.an.i((View) this.aWy, i.e.icon_news_head_prompt_one);
        }
    }

    private void Hy() {
        if (this.aKs == null) {
            this.aKs = new BannerView(this.aVf.getPageContext().getPageActivity());
            this.aKs.setLayoutParams(new AbsListView.LayoutParams(-1, this.aVf.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aKs.setVisibility(8);
            this.aKs.setBannerViewClickListener(this.aWZ);
            this.aKs.setBannerViewEvent(new by(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LC() {
        if (this.aWS != null) {
            String value = this.aWS.getValue();
            if (this.aWS.ry() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aVf.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aWS.ry() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aVf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVf.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aWS.ry() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.abA != UtilHelper.NativePageType.NONE) {
                    switch (Md()[isNativeAddress.abA.ordinal()]) {
                        case 2:
                            this.aVf.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVf.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aVf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVf.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.az.uT().b(this.aVf.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aVf.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aWS.ry() == 4) {
                this.aVf.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVf.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void LD() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aVf.getPageContext().getPageActivity());
    }

    public View LE() {
        return this.aWK;
    }

    public View LF() {
        return this.aWL;
    }

    public View LG() {
        return this.aWM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView LH() {
        return this.aWx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aWJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View LI() {
        return this.aWz;
    }

    public void g(NoNetworkView.a aVar) {
        this.aSa = aVar;
        if (this.aMQ != null) {
            this.aMQ.a(this.aSa);
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aVf.getPageContext().getPageActivity().getString(i.h.view);
        String string2 = this.aVf.getPageContext().getPageActivity().getString(i.h.view_host);
        String string3 = this.aVf.getPageContext().getPageActivity().getString(i.h.view_reverse);
        this.aWO = new com.baidu.tbadk.core.dialog.c(this.aVf.getPageContext().getPageActivity());
        this.aWO.bI(i.h.operation);
        if (z) {
            this.aWO.a(new String[]{string, string3}, this.aWR);
        } else {
            this.aWO.a(new String[]{string, string2, string3}, this.aWR);
        }
        this.aWO.d(this.aVf.getPageContext());
    }

    public void a(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.aVf.getPageContext().getPageActivity());
        cVar.bI(i.h.publish_thread_type);
        String string = this.aVf.getPageContext().getPageActivity().getString(i.h.publish_topic_thread);
        String string2 = this.aVf.getPageContext().getPageActivity().getString(i.h.publish_live_thread);
        cVar.a(new CharSequence[]{string, w(string2, i.e.icon_news_head_new), this.aVf.getPageContext().getPageActivity().getString(i.h.publish_vote_thread)}, bVar);
        cVar.d(this.aVf.getPageContext());
        cVar.sR();
    }

    public void b(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.aVf.getPageContext().getPageActivity());
        cVar.bI(i.h.publish_thread_type);
        cVar.a(new CharSequence[]{this.aVf.getPageContext().getPageActivity().getString(i.h.publish_topic_thread), this.aVf.getPageContext().getPageActivity().getString(i.h.publish_vote_thread)}, bVar);
        cVar.d(this.aVf.getPageContext());
        cVar.sR();
    }

    private CharSequence w(String str, int i) {
        ImageSpan[] imageSpanArr;
        if (!com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), false)) {
            Spanned fromHtml = Html.fromHtml(String.valueOf(str) + "<img src=\"" + i + "\">", new bz(this), null);
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
            canvas.translate(bs.this.aVf.getActivity().getResources().getDimensionPixelSize(i.d.ds24) + f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
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

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aWD.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.aWE.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.aWE.a(wVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aWE.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aWE.k(onClickListener);
    }

    public void c(c.b bVar) {
        this.aWR = bVar;
    }

    public void a(BdListView.g gVar) {
        this.aWD.setOnScrollToPullListener(gVar);
    }

    public void LJ() {
        if (this.aWO != null) {
            this.aWO.sR();
        }
    }

    public void onDestroy() {
        this.aWE.onDestory();
        this.aWD.setOnSrollToBottomListener(null);
    }

    private Animation LK() {
        if (this.aWP == null) {
            this.aWP = AnimationUtils.loadAnimation(this.aVf.getPageContext().getPageActivity(), i.a.refresh_rotate);
            this.aWP.setInterpolator(new LinearInterpolator());
            this.aWP.setFillAfter(true);
        }
        return this.aWP;
    }

    public void cc(boolean z) {
        this.aWv = z;
        if (z) {
            this.aWA.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aVf, this.aWC, LK(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.an.c(this.aWB, i.e.pic_fresh_s);
            return;
        }
        this.aWA.setOnTouchListener(this.aXb);
        this.aWD.completePullRefresh();
        this.aWC.clearAnimation();
        com.baidu.tbadk.core.util.an.c(this.aWB, i.e.pic_fresh_n);
    }

    public boolean Le() {
        return this.aWv;
    }

    public void LL() {
        this.aWD.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
        } else {
            this.mNavigationBar.setTitleText(String.valueOf(str) + this.aVf.getPageContext().getPageActivity().getString(i.h.forum));
        }
    }

    public void LM() {
        if (this.aWE != null) {
            this.aWE.notifyDataSetChanged();
        }
    }

    public void cd(boolean z) {
        this.aWE.ca(z);
    }

    public void ce(boolean z) {
        this.aWE.cb(z);
    }

    private void LN() {
        if (this.aWG == null) {
            String[] strArr = {this.aVf.getPageContext().getPageActivity().getString(i.h.take_photo), this.aVf.getPageContext().getPageActivity().getString(i.h.album)};
            this.aWG = new com.baidu.tbadk.core.dialog.c(this.aVf.getPageContext().getPageActivity());
            this.aWG.cv(this.aVf.getPageContext().getPageActivity().getString(i.h.operation));
            this.aWG.a(strArr, new ca(this));
            this.aWG.d(this.aVf.getPageContext());
        }
    }

    public void LO() {
        LN();
        if (this.aWG != null) {
            this.aWG.sR();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cd cdVar = new cd();
            arrayList = new ArrayList<>();
            arrayList.add(cdVar);
            this.aWF.setText(i.h.frs_nodata);
            this.aWF.setVisibility(8);
        } else {
            this.aWF.setVisibility(8);
        }
        this.aWE.a(arrayList, oVar, fx(i), fy(i2));
    }

    public BdListView getListView() {
        return this.aWD;
    }

    private boolean fx(int i) {
        return i > 1;
    }

    private boolean fy(int i) {
        return i == 1;
    }

    public void LP() {
        this.aWE.ca(false);
        this.aWE.cb(false);
        this.aWE.notifyDataSetChanged();
    }

    public void fz(int i) {
        this.aWD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aWT && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aWS = forumData.getFrsBannerData();
            Hy();
            this.aKs.reset();
            this.aWD.removeHeaderView(this.aKs);
            if (this.aWS.getType() == 1 && !TextUtils.isEmpty(this.aWS.rz())) {
                this.aKs.b(this.aVf.getPageContext(), this.aWS.rz());
                if (this.aWS.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aVf.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void LQ() {
        if (this.aKs != null) {
            this.aWT = false;
            this.aWD.removeHeaderView(this.aKs);
        }
    }

    public void onPause() {
        if (this.aWN != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aVf.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aMQ != null && this.aSa != null) {
            this.aMQ.b(this.aSa);
        }
    }

    public void LR() {
        this.aWI.setVisibility(8);
    }

    public void a(dg dgVar) {
        if (!FrsActivityStatic.aVa || dgVar == null) {
            this.aWI.setVisibility(8);
            return;
        }
        long Mq = FrsActivityStatic.aVb ? dgVar.Mq() + 0 : 0L;
        if (FrsActivityStatic.aVc) {
            Mq += dgVar.Mp();
        }
        if (Mq > 0 && this.aWJ.getVisibility() == 0) {
            this.aWI.setVisibility(0);
            if (Mq < 10) {
                this.aWI.setText(String.valueOf(Mq));
                com.baidu.tbadk.core.util.an.i((View) this.aWI, i.e.icon_news_head_prompt_one);
                return;
            } else if (Mq < 100) {
                this.aWI.setText(String.valueOf(Mq));
                com.baidu.tbadk.core.util.an.i((View) this.aWI, i.e.icon_news_head_prompt_two);
                return;
            } else {
                this.aWI.setText("   ");
                com.baidu.tbadk.core.util.an.i((View) this.aWI, i.e.icon_news_head_prompt_more);
                return;
            }
        }
        this.aWI.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aWE != null) {
            this.aWE.Lr();
            this.aWE.notifyDataSetChanged();
            this.aWE.onChangeSkinType(i);
        }
        this.aVf.KN();
        this.aVf.getLayoutMode().ad(i == 1);
        this.aVf.getLayoutMode().k(this.aWw);
        this.mNavigationBar.onChangeSkinType(this.aVf.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aVf, i, com.baidu.tbadk.core.util.an.getDrawable(i.e.bg_pull_down_n));
        }
        if (this.aMQ != null) {
            this.aMQ.onChangeSkinType(this.aVf.getPageContext(), i);
        }
        if (this.aKs != null) {
            this.aKs.oO();
        }
        if (this.aWW != null) {
            this.aWW.cN(i);
        }
        com.baidu.tbadk.core.util.an.a(this.aWx, i.e.icon_edit_selector_s, i.e.icon_edit_selector);
        com.baidu.tbadk.core.util.an.a(this.aWJ, i.e.btn_more_selector_s, i.e.btn_more_selector);
        if (this.aWy != null) {
            com.baidu.tbadk.core.util.an.i((View) this.aWy, i.e.icon_news_head_prompt_one);
        }
    }

    public void cf(boolean z) {
        if (z) {
            this.aWB.setAlpha(128);
            this.aWC.setAlpha(128);
            return;
        }
        this.aWB.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aWC.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void nw() {
        this.aWD.nw();
    }

    public int LS() {
        return 0;
    }

    public void LT() {
        this.aWA.setVisibility(0);
    }

    public void LU() {
        this.aWA.setVisibility(8);
    }

    public bb LV() {
        return this.aWE;
    }

    public View getRootView() {
        return this.aWw;
    }

    public View LW() {
        return this.aWU;
    }

    public void fA(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aVf.findViewById(i.f.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void LX() {
        this.aWH.setVisibility(8);
    }

    public void LY() {
        this.aWH.setVisibility(0);
    }

    public void LZ() {
        if (com.baidu.tbadk.performanceLog.y.DY().DZ()) {
            int lastVisiblePosition = this.aWD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cl) {
                        cl clVar = (cl) childAt.getTag();
                        if (clVar.aTj != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = clVar.aTj.getPerfLog();
                            perfLog.ez(1000);
                            perfLog.axr = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                clVar.aTj.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            clVar.aTj.vo();
                        }
                        if (clVar.aTf != null && (clVar.aTf instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = clVar.aTf;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.ez(1000);
                                    perfLog2.axr = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vo();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bm) {
                        bm bmVar = (bm) childAt.getTag();
                        if (bmVar.aVN != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bmVar.aVN.getPerfLog();
                            perfLog3.ez(1000);
                            perfLog3.axr = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bmVar.aVN.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bmVar.aVN.vo();
                        }
                        if (bmVar.aWe != null && (bmVar.aWe instanceof TbImageView)) {
                            TbImageView tbImageView2 = bmVar.aWe;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.ez(1000);
                            perfLog4.axr = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vo();
                        }
                    }
                    if (childAt.getTag() instanceof br) {
                        br brVar = (br) childAt.getTag();
                        if (brVar.aWt != null && brVar.aWt.aHW != null && (brVar.aWt.aHW instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = brVar.aWt.aHW.getPerfLog();
                            perfLog5.ez(1000);
                            perfLog5.axr = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                brVar.aWt.aHW.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            brVar.aWt.aHW.vo();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (brVar.aHR != null) {
                            arrayList.add(brVar.aHR);
                        }
                        if (brVar.aHS != null) {
                            arrayList.add(brVar.aHS);
                        }
                        if (brVar.aHT != null) {
                            arrayList.add(brVar.aHT);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.ez(1000);
                                perfLog6.axr = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vo();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Ma() {
        this.mHasMore = true;
        this.aWD.setNextPage(this.aWW);
        this.aWW.startLoadData();
    }

    public void Mb() {
        this.mHasMore = false;
        if (this.aWX > 0) {
            this.aWW.cO(this.aWX);
        }
        this.aWD.setNextPage(this.aWW);
        this.aWW.vv();
        this.aWW.setText(this.aVf.getResources().getString(i.h.list_no_more));
    }

    public void Mc() {
        this.mHasMore = false;
        this.aWD.setNextPage(null);
        this.aWW.vw();
    }

    public boolean KJ() {
        return this.aWW.getView().getParent() != null && this.mHasMore;
    }

    public void fB(int i) {
        this.aWX = i;
    }
}
