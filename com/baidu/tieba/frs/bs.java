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
    private static /* synthetic */ int[] aWR;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aMF;
    private FrsActivity aUU;
    private View aWA;
    private View aWB;
    private View.OnClickListener aWF;
    private com.baidu.tbadk.core.data.i aWH;
    private View aWJ;
    private PbListView aWL;
    private TextView aWn;
    private View aWo;
    private bb aWt;
    private View aWw;
    private View aWz;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private boolean aWk = false;
    private NoPressedRelativeLayout aWl = null;
    private ImageView aWm = null;
    private FrameLayout aWp = null;
    private ImageView aWq = null;
    private ImageView aWr = null;
    private BdTypeListView aWs = null;
    private TextView aWu = null;
    private com.baidu.tbadk.core.dialog.c aWv = null;
    private TextView aWx = null;
    private ImageView aWy = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private com.baidu.tieba.tbadkCore.t aWC = null;
    com.baidu.tbadk.core.dialog.c aWD = null;
    Animation aWE = null;
    private c.b aWG = null;
    private NoNetworkView.a aRP = null;
    private BannerView aKh = null;
    private boolean aWI = false;
    private boolean aWK = false;
    private boolean mHasMore = true;
    private int aWM = 0;
    BannerView.a aWN = new bt(this);
    BannerView.a aWO = new bu(this);
    View aWP = null;
    private View.OnTouchListener aWQ = new bv(this);

    static /* synthetic */ int[] Mh() {
        int[] iArr = aWR;
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
            aWR = iArr;
        }
        return iArr;
    }

    public bs(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aUU = null;
        this.aWF = null;
        this.aUU = frsActivity;
        this.aWF = onClickListener;
        initUI();
    }

    private void initUI() {
        this.aWl = (NoPressedRelativeLayout) this.aUU.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aUU.findViewById(i.f.view_navigation_bar);
        this.aWo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aWo.setOnClickListener(this.aWF);
        this.aWJ = this.aUU.findViewById(i.f.frs_list_content);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_more, (View.OnClickListener) null);
        this.aWm = (ImageView) addCustomView.findViewById(i.f.frs_top_more);
        com.baidu.tbadk.core.util.am.a(this.aWm, i.e.btn_more_selector_s, i.e.icon_edit_selector);
        this.aWm.setOnClickListener(this.aWF);
        this.aWn = (TextView) addCustomView.findViewById(i.f.frs_more_mes_text);
        LF();
        this.aWw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_more, (View.OnClickListener) null);
        this.aWy = (ImageView) this.aWw.findViewById(i.f.frs_top_more);
        com.baidu.tbadk.core.util.am.a(this.aWy, i.e.btn_more_selector_s, i.e.btn_more_selector);
        this.aWy.setOnClickListener(this.aWF);
        this.aWx = (TextView) this.aWw.findViewById(i.f.frs_more_mes_text);
        this.aWp = (FrameLayout) this.aUU.findViewById(i.f.refresh_layout);
        this.aWq = (ImageView) this.aUU.findViewById(i.f.refresh_bg);
        this.aWr = (ImageView) this.aUU.findViewById(i.f.refresh_icon);
        this.aWs = (BdTypeListView) this.aUU.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aUU.getPageContext());
        this.aWs.setDivider(null);
        this.aWs.setPullRefresh(this.mPullView);
        this.aWs.setDividerHeight(0);
        this.aWs.setRecyclerListener(new bw(this));
        this.aWL = new PbListView(this.aUU.getPageContext().getPageActivity());
        this.aWL.no();
        this.aWL.cM(i.c.cp_bg_line_c);
        this.aWs.setOnSrollToBottomListener(this.aUU);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new bx(this)));
        this.aWt = new bb(this.aUU, this.aWs, com.baidu.tbadk.core.util.as.uI().uK());
        this.aWu = (TextView) this.aUU.findViewById(i.f.frs_noexist_post);
        this.aWu.setVisibility(8);
        this.aWp.setOnClickListener(this.aWF);
        this.aWp.setOnTouchListener(this.aWQ);
        this.aMF = (NoNetworkView) this.aUU.findViewById(i.f.view_no_network);
        cc(false);
    }

    public void LF() {
        if (this.aWn != null) {
            if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", false)) {
                this.aWn.setVisibility(8);
                return;
            }
            this.aWn.setVisibility(0);
            this.aWn.setText("N");
            com.baidu.tbadk.core.util.am.i((View) this.aWn, i.e.icon_news_head_prompt_one);
        }
    }

    private void HC() {
        if (this.aKh == null) {
            this.aKh = new BannerView(this.aUU.getPageContext().getPageActivity());
            this.aKh.setLayoutParams(new AbsListView.LayoutParams(-1, this.aUU.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aKh.setVisibility(8);
            this.aKh.setBannerViewClickListener(this.aWO);
            this.aKh.setBannerViewEvent(new by(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LG() {
        if (this.aWH != null) {
            String value = this.aWH.getValue();
            if (this.aWH.rB() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aUU.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aWH.rB() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aUU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aUU.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aWH.rB() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.abx != UtilHelper.NativePageType.NONE) {
                    switch (Mh()[isNativeAddress.abx.ordinal()]) {
                        case 2:
                            this.aUU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aUU.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aUU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aUU.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.ay.uV().b(this.aUU.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aUU.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aWH.rB() == 4) {
                this.aUU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aUU.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void LH() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aUU.getPageContext().getPageActivity());
    }

    public View LI() {
        return this.aWz;
    }

    public View LJ() {
        return this.aWA;
    }

    public View LK() {
        return this.aWB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView LL() {
        return this.aWm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aWy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View LM() {
        return this.aWo;
    }

    public void g(NoNetworkView.a aVar) {
        this.aRP = aVar;
        if (this.aMF != null) {
            this.aMF.a(this.aRP);
        }
    }

    public void a(com.baidu.tbadk.core.data.v vVar, boolean z) {
        String string = this.aUU.getPageContext().getPageActivity().getString(i.h.view);
        String string2 = this.aUU.getPageContext().getPageActivity().getString(i.h.view_host);
        String string3 = this.aUU.getPageContext().getPageActivity().getString(i.h.view_reverse);
        this.aWD = new com.baidu.tbadk.core.dialog.c(this.aUU.getPageContext().getPageActivity());
        this.aWD.bI(i.h.operation);
        if (z) {
            this.aWD.a(new String[]{string, string3}, this.aWG);
        } else {
            this.aWD.a(new String[]{string, string2, string3}, this.aWG);
        }
        this.aWD.d(this.aUU.getPageContext());
    }

    public void a(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.aUU.getPageContext().getPageActivity());
        cVar.bI(i.h.publish_thread_type);
        String string = this.aUU.getPageContext().getPageActivity().getString(i.h.publish_topic_thread);
        String string2 = this.aUU.getPageContext().getPageActivity().getString(i.h.publish_live_thread);
        cVar.a(new CharSequence[]{string, w(string2, i.e.icon_news_head_new), this.aUU.getPageContext().getPageActivity().getString(i.h.publish_vote_thread)}, bVar);
        cVar.d(this.aUU.getPageContext());
        cVar.sU();
    }

    public void b(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.aUU.getPageContext().getPageActivity());
        cVar.bI(i.h.publish_thread_type);
        cVar.a(new CharSequence[]{this.aUU.getPageContext().getPageActivity().getString(i.h.publish_topic_thread), this.aUU.getPageContext().getPageActivity().getString(i.h.publish_vote_thread)}, bVar);
        cVar.d(this.aUU.getPageContext());
        cVar.sU();
    }

    private CharSequence w(String str, int i) {
        ImageSpan[] imageSpanArr;
        if (!com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), false)) {
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
            canvas.translate(bs.this.aUU.getActivity().getResources().getDimensionPixelSize(i.d.ds24) + f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
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
        this.aWs.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.aWt.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.aWt.a(wVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aWt.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aWt.k(onClickListener);
    }

    public void c(c.b bVar) {
        this.aWG = bVar;
    }

    public void a(BdListView.g gVar) {
        this.aWs.setOnScrollToPullListener(gVar);
    }

    public void LN() {
        if (this.aWD != null) {
            this.aWD.sU();
        }
    }

    public void onDestroy() {
        this.aWt.onDestory();
        this.aWs.setOnSrollToBottomListener(null);
    }

    private Animation LO() {
        if (this.aWE == null) {
            this.aWE = AnimationUtils.loadAnimation(this.aUU.getPageContext().getPageActivity(), i.a.refresh_rotate);
            this.aWE.setInterpolator(new LinearInterpolator());
            this.aWE.setFillAfter(true);
        }
        return this.aWE;
    }

    public void cc(boolean z) {
        this.aWk = z;
        if (z) {
            this.aWp.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aUU, this.aWr, LO(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.am.c(this.aWq, i.e.pic_fresh_s);
            return;
        }
        this.aWp.setOnTouchListener(this.aWQ);
        this.aWs.completePullRefresh();
        this.aWr.clearAnimation();
        com.baidu.tbadk.core.util.am.c(this.aWq, i.e.pic_fresh_n);
    }

    public boolean Li() {
        return this.aWk;
    }

    public void LP() {
        this.aWs.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
        } else {
            this.mNavigationBar.setTitleText(String.valueOf(str) + this.aUU.getPageContext().getPageActivity().getString(i.h.forum));
        }
    }

    public void LQ() {
        if (this.aWt != null) {
            this.aWt.notifyDataSetChanged();
        }
    }

    public void cd(boolean z) {
        this.aWt.ca(z);
    }

    public void ce(boolean z) {
        this.aWt.cb(z);
    }

    private void LR() {
        if (this.aWv == null) {
            String[] strArr = {this.aUU.getPageContext().getPageActivity().getString(i.h.take_photo), this.aUU.getPageContext().getPageActivity().getString(i.h.album)};
            this.aWv = new com.baidu.tbadk.core.dialog.c(this.aUU.getPageContext().getPageActivity());
            this.aWv.cu(this.aUU.getPageContext().getPageActivity().getString(i.h.operation));
            this.aWv.a(strArr, new ca(this));
            this.aWv.d(this.aUU.getPageContext());
        }
    }

    public void LS() {
        LR();
        if (this.aWv != null) {
            this.aWv.sU();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cd cdVar = new cd();
            arrayList = new ArrayList<>();
            arrayList.add(cdVar);
            this.aWu.setText(i.h.frs_nodata);
            this.aWu.setVisibility(8);
        } else {
            this.aWu.setVisibility(8);
        }
        this.aWt.a(arrayList, oVar, fx(i), fy(i2));
    }

    public BdListView getListView() {
        return this.aWs;
    }

    private boolean fx(int i) {
        return i > 1;
    }

    private boolean fy(int i) {
        return i == 1;
    }

    public void LT() {
        this.aWt.ca(false);
        this.aWt.cb(false);
        this.aWt.notifyDataSetChanged();
    }

    public void fz(int i) {
        this.aWs.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aWI && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aWH = forumData.getFrsBannerData();
            HC();
            this.aKh.reset();
            this.aWs.removeHeaderView(this.aKh);
            if (this.aWH.getType() == 1 && !TextUtils.isEmpty(this.aWH.rC())) {
                this.aKh.b(this.aUU.getPageContext(), this.aWH.rC());
                if (this.aWH.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aUU.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void LU() {
        if (this.aKh != null) {
            this.aWI = false;
            this.aWs.removeHeaderView(this.aKh);
        }
    }

    public void onPause() {
        if (this.aWC != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aUU.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aMF != null && this.aRP != null) {
            this.aMF.b(this.aRP);
        }
    }

    public void LV() {
        this.aWx.setVisibility(8);
    }

    public void a(dg dgVar) {
        if (!FrsActivityStatic.aUP || dgVar == null) {
            this.aWx.setVisibility(8);
            return;
        }
        long Mu = FrsActivityStatic.aUQ ? dgVar.Mu() + 0 : 0L;
        if (FrsActivityStatic.aUR) {
            Mu += dgVar.Mt();
        }
        if (Mu > 0 && this.aWy.getVisibility() == 0) {
            this.aWx.setVisibility(0);
            if (Mu < 10) {
                this.aWx.setText(String.valueOf(Mu));
                com.baidu.tbadk.core.util.am.i((View) this.aWx, i.e.icon_news_head_prompt_one);
                return;
            } else if (Mu < 100) {
                this.aWx.setText(String.valueOf(Mu));
                com.baidu.tbadk.core.util.am.i((View) this.aWx, i.e.icon_news_head_prompt_two);
                return;
            } else {
                this.aWx.setText("   ");
                com.baidu.tbadk.core.util.am.i((View) this.aWx, i.e.icon_news_head_prompt_more);
                return;
            }
        }
        this.aWx.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aWt != null) {
            this.aWt.Lv();
            this.aWt.notifyDataSetChanged();
            this.aWt.onChangeSkinType(i);
        }
        this.aUU.KR();
        this.aUU.getLayoutMode().ad(i == 1);
        this.aUU.getLayoutMode().k(this.aWl);
        this.mNavigationBar.onChangeSkinType(this.aUU.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aUU, i, com.baidu.tbadk.core.util.am.getDrawable(i.e.bg_pull_down_n));
        }
        if (this.aMF != null) {
            this.aMF.onChangeSkinType(this.aUU.getPageContext(), i);
        }
        if (this.aKh != null) {
            this.aKh.oO();
        }
        if (this.aWL != null) {
            this.aWL.cN(i);
        }
        com.baidu.tbadk.core.util.am.a(this.aWm, i.e.icon_edit_selector_s, i.e.icon_edit_selector);
        com.baidu.tbadk.core.util.am.a(this.aWy, i.e.btn_more_selector_s, i.e.btn_more_selector);
        if (this.aWn != null) {
            com.baidu.tbadk.core.util.am.i((View) this.aWn, i.e.icon_news_head_prompt_one);
        }
    }

    public void cf(boolean z) {
        if (z) {
            this.aWq.setAlpha(128);
            this.aWr.setAlpha(128);
            return;
        }
        this.aWq.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aWr.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void nw() {
        this.aWs.nw();
    }

    public int LW() {
        return 0;
    }

    public void LX() {
        this.aWp.setVisibility(0);
    }

    public void LY() {
        this.aWp.setVisibility(8);
    }

    public bb LZ() {
        return this.aWt;
    }

    public View getRootView() {
        return this.aWl;
    }

    public View Ma() {
        return this.aWJ;
    }

    public void fA(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aUU.findViewById(i.f.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Mb() {
        this.aWw.setVisibility(8);
    }

    public void Mc() {
        this.aWw.setVisibility(0);
    }

    public void Md() {
        if (com.baidu.tbadk.performanceLog.y.Eb().Ec()) {
            int lastVisiblePosition = this.aWs.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWs.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cl) {
                        cl clVar = (cl) childAt.getTag();
                        if (clVar.aSY != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = clVar.aSY.getPerfLog();
                            perfLog.ez(1000);
                            perfLog.axq = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                clVar.aSY.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            clVar.aSY.vr();
                        }
                        if (clVar.aSU != null && (clVar.aSU instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = clVar.aSU;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.ez(1000);
                                    perfLog2.axq = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vr();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bm) {
                        bm bmVar = (bm) childAt.getTag();
                        if (bmVar.aVC != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bmVar.aVC.getPerfLog();
                            perfLog3.ez(1000);
                            perfLog3.axq = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bmVar.aVC.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bmVar.aVC.vr();
                        }
                        if (bmVar.aVT != null && (bmVar.aVT instanceof TbImageView)) {
                            TbImageView tbImageView2 = bmVar.aVT;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.ez(1000);
                            perfLog4.axq = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vr();
                        }
                    }
                    if (childAt.getTag() instanceof br) {
                        br brVar = (br) childAt.getTag();
                        if (brVar.aWi != null && brVar.aWi.aHL != null && (brVar.aWi.aHL instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = brVar.aWi.aHL.getPerfLog();
                            perfLog5.ez(1000);
                            perfLog5.axq = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                brVar.aWi.aHL.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            brVar.aWi.aHL.vr();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (brVar.aHG != null) {
                            arrayList.add(brVar.aHG);
                        }
                        if (brVar.aHH != null) {
                            arrayList.add(brVar.aHH);
                        }
                        if (brVar.aHI != null) {
                            arrayList.add(brVar.aHI);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.ez(1000);
                                perfLog6.axq = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vr();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Me() {
        this.mHasMore = true;
        this.aWs.setNextPage(this.aWL);
        this.aWL.startLoadData();
    }

    public void Mf() {
        this.mHasMore = false;
        if (this.aWM > 0) {
            this.aWL.cO(this.aWM);
        }
        this.aWs.setNextPage(this.aWL);
        this.aWL.vy();
        this.aWL.setText(this.aUU.getResources().getString(i.h.list_no_more));
    }

    public void Mg() {
        this.mHasMore = false;
        this.aWs.setNextPage(null);
        this.aWL.vz();
    }

    public boolean KN() {
        return this.aWL.getView().getParent() != null && this.mHasMore;
    }

    public void fB(int i) {
        this.aWM = i;
    }
}
