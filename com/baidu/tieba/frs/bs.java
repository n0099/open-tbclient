package com.baidu.tieba.frs;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.baidu.cloudsdk.social.core.SocialConstants;
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
    private static /* synthetic */ int[] aXl;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aMY;
    private FrsActivity aVn;
    private TextView aWG;
    private View aWH;
    private bb aWM;
    private View aWP;
    private View aWS;
    private View aWT;
    private View aWU;
    private View.OnClickListener aWY;
    private com.baidu.tbadk.core.data.j aXa;
    private View aXc;
    private PbListView aXe;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private boolean aWD = false;
    private NoPressedRelativeLayout aWE = null;
    private ImageView aWF = null;
    private FrameLayout aWI = null;
    private ImageView aWJ = null;
    private ImageView aWK = null;
    private BdTypeListView aWL = null;
    private TextView aWN = null;
    private com.baidu.tbadk.core.dialog.c aWO = null;
    private TextView aWQ = null;
    private ImageView aWR = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private com.baidu.tieba.tbadkCore.t aWV = null;
    com.baidu.tbadk.core.dialog.c aWW = null;
    Animation aWX = null;
    private c.b aWZ = null;
    private NoNetworkView.a aSi = null;
    private BannerView aJm = null;
    private boolean aXb = false;
    private boolean aXd = false;
    private boolean mHasMore = true;
    private int aXf = 0;
    private int aXg = 0;
    BannerView.a aXh = new bt(this);
    BannerView.a aXi = new bu(this);
    View aXj = null;
    private View.OnTouchListener aXk = new bv(this);

    static /* synthetic */ int[] Mt() {
        int[] iArr = aXl;
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
            aXl = iArr;
        }
        return iArr;
    }

    public bs(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aVn = null;
        this.aWY = null;
        this.aVn = frsActivity;
        this.aWY = onClickListener;
        initUI();
    }

    private void initUI() {
        this.aWE = (NoPressedRelativeLayout) this.aVn.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aVn.findViewById(i.f.view_navigation_bar);
        this.aWH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aWH.setOnClickListener(this.aWY);
        this.aXc = this.aVn.findViewById(i.f.frs_list_content);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_more, (View.OnClickListener) null);
        this.aWF = (ImageView) addCustomView.findViewById(i.f.frs_top_more);
        com.baidu.tbadk.core.util.an.a(this.aWF, i.e.btn_more_selector_s, i.e.icon_edit_selector);
        this.aWF.setOnClickListener(this.aWY);
        this.aWG = (TextView) addCustomView.findViewById(i.f.frs_more_mes_text);
        LR();
        this.aWP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_frs_more, (View.OnClickListener) null);
        this.aWR = (ImageView) this.aWP.findViewById(i.f.frs_top_more);
        com.baidu.tbadk.core.util.an.a(this.aWR, i.e.btn_more_selector_s, i.e.btn_more_selector);
        this.aWR.setOnClickListener(this.aWY);
        this.aWQ = (TextView) this.aWP.findViewById(i.f.frs_more_mes_text);
        this.aWI = (FrameLayout) this.aVn.findViewById(i.f.refresh_layout);
        this.aWJ = (ImageView) this.aVn.findViewById(i.f.refresh_bg);
        this.aWK = (ImageView) this.aVn.findViewById(i.f.refresh_icon);
        this.aWL = (BdTypeListView) this.aVn.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aVn.getPageContext());
        this.aWL.setDivider(null);
        this.aWL.setPullRefresh(this.mPullView);
        this.aWL.setDividerHeight(0);
        this.aWL.setRecyclerListener(new bw(this));
        this.aXe = new PbListView(this.aVn.getPageContext().getPageActivity());
        this.aXe.np();
        this.aXe.cM(i.c.cp_bg_line_c);
        this.aWL.setOnSrollToBottomListener(this.aVn);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new bx(this)));
        this.aWM = new bb(this.aVn, this.aWL, com.baidu.tbadk.core.util.at.uK().uM());
        this.aWN = (TextView) this.aVn.findViewById(i.f.frs_noexist_post);
        this.aWN.setVisibility(8);
        this.aWI.setOnClickListener(this.aWY);
        this.aWI.setOnTouchListener(this.aXk);
        this.aMY = (NoNetworkView) this.aVn.findViewById(i.f.view_no_network);
        ce(false);
    }

    public void LR() {
        if (this.aWG != null) {
            if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", false)) {
                this.aWG.setVisibility(8);
                return;
            }
            this.aWG.setVisibility(0);
            this.aWG.setText("N");
            com.baidu.tbadk.core.util.an.i((View) this.aWG, i.e.icon_news_head_prompt_one);
        }
    }

    private void Hv() {
        if (this.aJm == null) {
            this.aJm = new BannerView(this.aVn.getPageContext().getPageActivity());
            this.aJm.setLayoutParams(new AbsListView.LayoutParams(-1, this.aVn.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aJm.setVisibility(8);
            this.aJm.setBannerViewClickListener(this.aXi);
            this.aJm.setBannerViewEvent(new by(this));
        }
    }

    private void A(int i, String str) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "CLICK", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.aVn.Lt().afg().getId(), ImageViewerConfig.FORUM_NAME, this.aVn.Lt().afg().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LS() {
        if (this.aXa != null) {
            String value = this.aXa.getValue();
            int rB = this.aXa.rB();
            if (this.aXa.rz() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aVn.getPageContext().getPageActivity(), value, false, "frs_banner")));
                A(rB, value);
            } else if (this.aXa.rz() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aVn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVn.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                            A(rB, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aXa.rz() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.abF != UtilHelper.NativePageType.NONE) {
                    switch (Mt()[isNativeAddress.abF.ordinal()]) {
                        case 2:
                            this.aVn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVn.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            A(rB, value);
                            return;
                        case 3:
                            this.aVn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVn.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            A(rB, value);
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.az.uX().b(this.aVn.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aVn.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aXa.rz() == 4) {
                this.aVn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVn.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                A(rB, value);
            }
        }
    }

    public void LT() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aVn.getPageContext().getPageActivity());
    }

    public View LU() {
        return this.aWS;
    }

    public View LV() {
        return this.aWT;
    }

    public View LW() {
        return this.aWU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView LX() {
        return this.aWF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aWR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View LY() {
        return this.aWH;
    }

    public void g(NoNetworkView.a aVar) {
        this.aSi = aVar;
        if (this.aMY != null) {
            this.aMY.a(this.aSi);
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aVn.getPageContext().getPageActivity().getString(i.h.view);
        String string2 = this.aVn.getPageContext().getPageActivity().getString(i.h.view_host);
        String string3 = this.aVn.getPageContext().getPageActivity().getString(i.h.view_reverse);
        this.aWW = new com.baidu.tbadk.core.dialog.c(this.aVn.getPageContext().getPageActivity());
        this.aWW.bI(i.h.operation);
        if (z) {
            this.aWW.a(new String[]{string, string3}, this.aWZ);
        } else {
            this.aWW.a(new String[]{string, string2, string3}, this.aWZ);
        }
        this.aWW.d(this.aVn.getPageContext());
    }

    public void a(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.aVn.getPageContext().getPageActivity());
        cVar.bI(i.h.publish_thread_type);
        String string = this.aVn.getPageContext().getPageActivity().getString(i.h.publish_topic_thread);
        String string2 = this.aVn.getPageContext().getPageActivity().getString(i.h.publish_live_thread);
        cVar.a(new CharSequence[]{string, w(string2, i.e.icon_news_head_new), this.aVn.getPageContext().getPageActivity().getString(i.h.publish_vote_thread)}, bVar);
        cVar.d(this.aVn.getPageContext());
        cVar.sU();
    }

    public void b(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.aVn.getPageContext().getPageActivity());
        cVar.bI(i.h.publish_thread_type);
        cVar.a(new CharSequence[]{this.aVn.getPageContext().getPageActivity().getString(i.h.publish_topic_thread), this.aVn.getPageContext().getPageActivity().getString(i.h.publish_vote_thread)}, bVar);
        cVar.d(this.aVn.getPageContext());
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
            canvas.translate(bs.this.aVn.getActivity().getResources().getDimensionPixelSize(i.d.ds24) + f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
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
        this.aWL.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.aWM.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.aWM.a(wVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aWM.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aWM.k(onClickListener);
    }

    public void c(c.b bVar) {
        this.aWZ = bVar;
    }

    public void a(BdListView.g gVar) {
        this.aWL.setOnScrollToPullListener(gVar);
    }

    public void LZ() {
        if (this.aWW != null) {
            this.aWW.sU();
        }
    }

    public void onDestroy() {
        this.aWM.onDestory();
        this.aWL.setOnSrollToBottomListener(null);
    }

    private Animation Ma() {
        if (this.aWX == null) {
            this.aWX = AnimationUtils.loadAnimation(this.aVn.getPageContext().getPageActivity(), i.a.refresh_rotate);
            this.aWX.setInterpolator(new LinearInterpolator());
            this.aWX.setFillAfter(true);
        }
        return this.aWX;
    }

    public void ce(boolean z) {
        this.aWD = z;
        if (z) {
            this.aWI.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aVn, this.aWK, Ma(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.an.c(this.aWJ, i.e.pic_fresh_s);
            return;
        }
        this.aWI.setOnTouchListener(this.aXk);
        this.aWL.completePullRefresh();
        this.aWK.clearAnimation();
        com.baidu.tbadk.core.util.an.c(this.aWJ, i.e.pic_fresh_n);
    }

    public boolean Lu() {
        return this.aWD;
    }

    public void Mb() {
        this.aWL.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
        } else {
            this.mNavigationBar.setTitleText(String.valueOf(str) + this.aVn.getPageContext().getPageActivity().getString(i.h.forum));
        }
    }

    public void Mc() {
        if (this.aWM != null) {
            this.aWM.notifyDataSetChanged();
        }
    }

    public void cf(boolean z) {
        this.aWM.cc(z);
    }

    public void cg(boolean z) {
        this.aWM.cd(z);
    }

    private void Md() {
        if (this.aWO == null) {
            String[] strArr = {this.aVn.getPageContext().getPageActivity().getString(i.h.take_photo), this.aVn.getPageContext().getPageActivity().getString(i.h.album)};
            this.aWO = new com.baidu.tbadk.core.dialog.c(this.aVn.getPageContext().getPageActivity());
            this.aWO.cv(this.aVn.getPageContext().getPageActivity().getString(i.h.operation));
            this.aWO.a(strArr, new ca(this));
            this.aWO.d(this.aVn.getPageContext());
        }
    }

    public void Me() {
        Md();
        if (this.aWO != null) {
            this.aWO.sU();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cd cdVar = new cd();
            arrayList = new ArrayList<>();
            arrayList.add(cdVar);
            this.aWN.setText(i.h.frs_nodata);
            this.aWN.setVisibility(8);
        } else {
            this.aWN.setVisibility(8);
        }
        this.aWM.a(arrayList, oVar, fF(i), fG(i2));
    }

    public BdListView getListView() {
        return this.aWL;
    }

    private boolean fF(int i) {
        return i > 1;
    }

    private boolean fG(int i) {
        return i == 1;
    }

    public void Mf() {
        this.aWM.cc(false);
        this.aWM.cd(false);
        this.aWM.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aXa = forumData.getFrsBannerData();
            int rB = this.aXa.rB();
            if (!this.aXb) {
                Hv();
                this.aWL.removeHeaderView(this.aJm);
                if (this.aXa.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aVn.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            this.aJm.reset();
            if (this.aXa.getType() == 1 && !TextUtils.isEmpty(this.aXa.rA())) {
                this.aJm.b(this.aVn.getPageContext(), this.aXa.rA());
            }
            V(i, rB);
        }
    }

    private void V(int i, int i2) {
        if (com.baidu.adp.lib.util.i.iN()) {
            if (i == 0) {
                fH(i2);
                this.aXg = i2;
            }
            if (i == 1 && i2 != this.aXg) {
                fH(i2);
                this.aXg = i2;
            }
        }
    }

    private void fH(int i) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.aVn.getForumId(), ImageViewerConfig.FORUM_NAME, this.aVn.Lt().afg().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    public void Mg() {
        if (this.aJm != null) {
            this.aXb = false;
            this.aWL.removeHeaderView(this.aJm);
        }
    }

    public void onPause() {
        if (this.aWV != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aVn.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aMY != null && this.aSi != null) {
            this.aMY.b(this.aSi);
        }
    }

    public void Mh() {
        this.aWQ.setVisibility(8);
    }

    public void a(dg dgVar) {
        if (!FrsActivityStatic.aVi || dgVar == null) {
            this.aWQ.setVisibility(8);
            return;
        }
        long MG = FrsActivityStatic.aVj ? dgVar.MG() + 0 : 0L;
        if (FrsActivityStatic.aVk) {
            MG += dgVar.MF();
        }
        if (MG > 0 && this.aWR.getVisibility() == 0) {
            this.aWQ.setVisibility(0);
            if (MG < 10) {
                this.aWQ.setText(String.valueOf(MG));
                com.baidu.tbadk.core.util.an.i((View) this.aWQ, i.e.icon_news_head_prompt_one);
                return;
            } else if (MG < 100) {
                this.aWQ.setText(String.valueOf(MG));
                com.baidu.tbadk.core.util.an.i((View) this.aWQ, i.e.icon_news_head_prompt_two);
                return;
            } else {
                this.aWQ.setText("   ");
                com.baidu.tbadk.core.util.an.i((View) this.aWQ, i.e.icon_news_head_prompt_more);
                return;
            }
        }
        this.aWQ.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aWM != null) {
            this.aWM.LH();
            this.aWM.notifyDataSetChanged();
            this.aWM.onChangeSkinType(i);
        }
        this.aVn.Ld();
        this.aVn.getLayoutMode().ad(i == 1);
        this.aVn.getLayoutMode().k(this.aWE);
        this.mNavigationBar.onChangeSkinType(this.aVn.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aVn, i, com.baidu.tbadk.core.util.an.getDrawable(i.e.bg_pull_down_n));
        }
        if (this.aMY != null) {
            this.aMY.onChangeSkinType(this.aVn.getPageContext(), i);
        }
        if (this.aJm != null) {
            this.aJm.oP();
        }
        if (this.aXe != null) {
            this.aXe.cN(i);
        }
        com.baidu.tbadk.core.util.an.a(this.aWF, i.e.icon_edit_selector_s, i.e.icon_edit_selector);
        com.baidu.tbadk.core.util.an.a(this.aWR, i.e.btn_more_selector_s, i.e.btn_more_selector);
        if (this.aWG != null) {
            com.baidu.tbadk.core.util.an.i((View) this.aWG, i.e.icon_news_head_prompt_one);
        }
    }

    public void ch(boolean z) {
        if (z) {
            this.aWJ.setAlpha(128);
            this.aWK.setAlpha(128);
            return;
        }
        this.aWJ.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aWK.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void nx() {
        this.aWL.nx();
    }

    public int Mi() {
        return 0;
    }

    public void Mj() {
        this.aWI.setVisibility(0);
    }

    public void Mk() {
        this.aWI.setVisibility(8);
    }

    public bb Ml() {
        return this.aWM;
    }

    public View getRootView() {
        return this.aWE;
    }

    public View Mm() {
        return this.aXc;
    }

    public void fI(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aVn.findViewById(i.f.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Mn() {
        this.aWP.setVisibility(8);
    }

    public void Mo() {
        this.aWP.setVisibility(0);
    }

    public void Mp() {
        if (com.baidu.tbadk.performanceLog.y.DR().DS()) {
            int lastVisiblePosition = this.aWL.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWL.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cl) {
                        cl clVar = (cl) childAt.getTag();
                        if (clVar.aTr != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = clVar.aTr.getPerfLog();
                            perfLog.ex(1000);
                            perfLog.awg = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                clVar.aTr.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            clVar.aTr.vs();
                        }
                        if (clVar.aTn != null && (clVar.aTn instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = clVar.aTn;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.ex(1000);
                                    perfLog2.awg = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vs();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bm) {
                        bm bmVar = (bm) childAt.getTag();
                        if (bmVar.aVV != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bmVar.aVV.getPerfLog();
                            perfLog3.ex(1000);
                            perfLog3.awg = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bmVar.aVV.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bmVar.aVV.vs();
                        }
                        if (bmVar.aWm != null && (bmVar.aWm instanceof TbImageView)) {
                            TbImageView tbImageView2 = bmVar.aWm;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.ex(1000);
                            perfLog4.awg = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vs();
                        }
                    }
                    if (childAt.getTag() instanceof br) {
                        br brVar = (br) childAt.getTag();
                        if (brVar.aWB != null && brVar.aWB.aGQ != null && (brVar.aWB.aGQ instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = brVar.aWB.aGQ.getPerfLog();
                            perfLog5.ex(1000);
                            perfLog5.awg = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                brVar.aWB.aGQ.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            brVar.aWB.aGQ.vs();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (brVar.aGL != null) {
                            arrayList.add(brVar.aGL);
                        }
                        if (brVar.aGM != null) {
                            arrayList.add(brVar.aGM);
                        }
                        if (brVar.aGN != null) {
                            arrayList.add(brVar.aGN);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.ex(1000);
                                perfLog6.awg = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vs();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Mq() {
        this.mHasMore = true;
        this.aWL.setNextPage(this.aXe);
        this.aXe.startLoadData();
    }

    public void Mr() {
        this.mHasMore = false;
        if (this.aXf > 0) {
            this.aXe.cO(this.aXf);
        }
        this.aWL.setNextPage(this.aXe);
        this.aXe.vz();
        this.aXe.setText(this.aVn.getResources().getString(i.h.list_no_more));
    }

    public void Ms() {
        this.mHasMore = false;
        this.aWL.setNextPage(null);
        this.aXe.vA();
    }

    public boolean KZ() {
        return this.aXe.getView().getParent() != null && this.mHasMore;
    }

    public void fJ(int i) {
        this.aXf = i;
    }
}
