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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class cd {
    private static /* synthetic */ int[] bdf;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aQl;
    private PbListView aRt;
    private FrsActivity baC;
    private TextView bcB;
    private View bcC;
    private ba bcH;
    private View bcK;
    private View bcN;
    private View bcO;
    private View bcP;
    private View.OnClickListener bcT;
    private com.baidu.tbadk.core.data.j bcV;
    private View bcX;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private boolean bcy = false;
    private NoPressedRelativeLayout bcz = null;
    private ImageView bcA = null;
    private FrameLayout bcD = null;
    private ImageView bcE = null;
    private ImageView bcF = null;
    private BdTypeListView bcG = null;
    private TextView bcI = null;
    private com.baidu.tbadk.core.dialog.c bcJ = null;
    private TextView bcL = null;
    private ImageView bcM = null;
    private com.baidu.tbadk.core.view.s mPullView = null;
    private com.baidu.tieba.tbadkCore.u bcQ = null;
    com.baidu.tbadk.core.dialog.c bcR = null;
    Animation bcS = null;
    private c.b bcU = null;
    private NoNetworkView.a aXw = null;
    private BannerView aNN = null;
    private boolean bcW = false;
    private boolean bcY = false;
    private boolean mHasMore = true;
    private int bcZ = 0;
    private int bda = 0;
    BannerView.a bdb = new ce(this);
    BannerView.a bdc = new cf(this);
    View bdd = null;
    private View.OnTouchListener bde = new cg(this);

    static /* synthetic */ int[] NV() {
        int[] iArr = bdf;
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
            bdf = iArr;
        }
        return iArr;
    }

    public cd(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.baC = null;
        this.bcT = null;
        this.baC = frsActivity;
        this.bcT = onClickListener;
        initUI();
    }

    private void initUI() {
        this.bcz = (NoPressedRelativeLayout) this.baC.findViewById(n.f.frs);
        this.mNavigationBar = (NavigationBar) this.baC.findViewById(n.f.view_navigation_bar);
        this.bcC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bcC.setOnClickListener(this.bcT);
        this.bcX = this.baC.findViewById(n.f.frs_list_content);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.nb_item_frs_more, (View.OnClickListener) null);
        this.bcA = (ImageView) addCustomView.findViewById(n.f.frs_top_more);
        com.baidu.tbadk.core.util.as.a(this.bcA, n.e.icon_edit_selector_s, n.e.icon_edit_selector);
        this.bcA.setOnClickListener(this.bcT);
        this.bcB = (TextView) addCustomView.findViewById(n.f.frs_more_mes_text);
        Ns();
        this.bcK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.nb_item_frs_more, (View.OnClickListener) null);
        this.bcM = (ImageView) this.bcK.findViewById(n.f.frs_top_more);
        com.baidu.tbadk.core.util.as.a(this.bcM, n.e.btn_more_selector_s, n.e.btn_more_selector);
        this.bcM.setOnClickListener(this.bcT);
        this.bcL = (TextView) this.bcK.findViewById(n.f.frs_more_mes_text);
        this.bcD = (FrameLayout) this.baC.findViewById(n.f.refresh_layout);
        this.bcE = (ImageView) this.baC.findViewById(n.f.refresh_bg);
        this.bcF = (ImageView) this.baC.findViewById(n.f.refresh_icon);
        this.bcG = (BdTypeListView) this.baC.findViewById(n.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.s(this.baC.getPageContext());
        this.bcG.setDivider(null);
        this.bcG.setPullRefresh(this.mPullView);
        this.bcG.setDividerHeight(0);
        this.bcG.setRecyclerListener(new ch(this));
        this.aRt = new PbListView(this.baC.getPageContext().getPageActivity());
        this.aRt.nv();
        this.aRt.cU(n.c.cp_bg_line_c);
        this.bcG.setOnSrollToBottomListener(this.baC);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ab(new ci(this)));
        this.bcH = new ba(this.baC, this.bcG, com.baidu.tbadk.core.util.ay.vq().vs());
        this.bcI = (TextView) this.baC.findViewById(n.f.frs_noexist_post);
        this.bcI.setVisibility(8);
        this.bcD.setOnClickListener(this.bcT);
        this.bcD.setOnTouchListener(this.bde);
        this.aQl = (NoNetworkView) this.baC.findViewById(n.f.view_no_network);
        cr(false);
    }

    public void Ns() {
        if (this.bcB != null && this.bcB.isShown()) {
            this.bcB.setVisibility(8);
        }
    }

    private void IO() {
        if (this.aNN == null) {
            this.aNN = new BannerView(this.baC.getPageContext().getPageActivity());
            this.aNN.setLayoutParams(new AbsListView.LayoutParams(-1, this.baC.getResources().getDimensionPixelSize(n.d.frs_header_banner_height)));
            this.aNN.setVisibility(8);
            this.aNN.setBannerViewClickListener(this.bdc);
            this.aNN.setBannerViewEvent(new cj(this));
        }
    }

    private void B(int i, String str) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "CLICK", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.baC.MT().ajy().getId(), ImageViewerConfig.FORUM_NAME, this.baC.MT().ajy().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Nt() {
        if (this.bcV != null) {
            String value = this.bcV.getValue();
            int rP = this.bcV.rP();
            if (this.bcV.rN() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.baC.getPageContext().getPageActivity(), value, false, "frs_banner")));
                B(rP, value);
            } else if (this.bcV.rN() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.baC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.baC.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                            B(rP, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bcV.rN() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.acx != UtilHelper.NativePageType.NONE) {
                    switch (NV()[isNativeAddress.acx.ordinal()]) {
                        case 2:
                            this.baC.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.baC.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            B(rP, value);
                            return;
                        case 3:
                            this.baC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.baC.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            B(rP, value);
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bf.vD().b(this.baC.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.baC.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bcV.rN() == 4) {
                this.baC.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.baC.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                B(rP, value);
            }
        }
    }

    public void Nu() {
        com.baidu.adp.lib.h.j.a(this.mPopWindow, this.baC.getPageContext().getPageActivity());
    }

    public View Nv() {
        return this.bcN;
    }

    public View Nw() {
        return this.bcO;
    }

    public View Nx() {
        return this.bcP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView Ny() {
        return this.bcA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.bcM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Nz() {
        return this.bcC;
    }

    public void f(NoNetworkView.a aVar) {
        this.aXw = aVar;
        if (this.aQl != null) {
            this.aQl.a(this.aXw);
        }
    }

    public void a(com.baidu.tbadk.core.data.z zVar, boolean z) {
        String string = this.baC.getPageContext().getPageActivity().getString(n.i.view);
        String string2 = this.baC.getPageContext().getPageActivity().getString(n.i.view_host);
        String string3 = this.baC.getPageContext().getPageActivity().getString(n.i.view_reverse);
        this.bcR = new com.baidu.tbadk.core.dialog.c(this.baC.getPageContext().getPageActivity());
        this.bcR.bQ(n.i.operation);
        if (z) {
            this.bcR.a(new String[]{string, string3}, this.bcU);
        } else {
            this.bcR.a(new String[]{string, string2, string3}, this.bcU);
        }
        this.bcR.d(this.baC.getPageContext());
    }

    public void a(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.baC.getPageContext().getPageActivity());
        cVar.bQ(n.i.publish_thread_type);
        String string = this.baC.getPageContext().getPageActivity().getString(n.i.publish_topic_thread);
        String string2 = this.baC.getPageContext().getPageActivity().getString(n.i.publish_live_thread);
        cVar.a(new CharSequence[]{string, x(string2, n.e.icon_news_head_new), this.baC.getPageContext().getPageActivity().getString(n.i.publish_vote_thread)}, bVar);
        cVar.d(this.baC.getPageContext());
        cVar.tz();
    }

    public void b(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.baC.getPageContext().getPageActivity());
        cVar.bQ(n.i.publish_thread_type);
        cVar.a(new CharSequence[]{this.baC.getPageContext().getPageActivity().getString(n.i.publish_topic_thread), this.baC.getPageContext().getPageActivity().getString(n.i.publish_vote_thread)}, bVar);
        cVar.d(this.baC.getPageContext());
        cVar.tz();
    }

    private CharSequence x(String str, int i) {
        ImageSpan[] imageSpanArr;
        if (!com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), false)) {
            Spanned fromHtml = Html.fromHtml(String.valueOf(str) + "<img src=\"" + i + "\">", new ck(this), null);
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
            canvas.translate(cd.this.baC.getActivity().getResources().getDimensionPixelSize(n.d.ds24) + f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
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

    public void a(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bcG.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.bcH.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bcH.a(wVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.bcH.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.bcH.k(onClickListener);
    }

    public void c(c.b bVar) {
        this.bcU = bVar;
    }

    public void a(BdListView.g gVar) {
        this.bcG.setOnScrollToPullListener(gVar);
    }

    public void NA() {
        if (this.bcR != null) {
            this.bcR.tz();
        }
    }

    public void onDestroy() {
        this.bcH.onDestory();
        this.bcG.setOnSrollToBottomListener(null);
    }

    private Animation NB() {
        if (this.bcS == null) {
            this.bcS = AnimationUtils.loadAnimation(this.baC.getPageContext().getPageActivity(), n.a.refresh_rotate);
            this.bcS.setInterpolator(new LinearInterpolator());
            this.bcS.setFillAfter(true);
        }
        return this.bcS;
    }

    public void cr(boolean z) {
        this.bcy = z;
        if (z) {
            this.bcD.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.baC, this.bcF, NB(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.as.c(this.bcE, n.e.pic_fresh_s);
            return;
        }
        this.bcD.setOnTouchListener(this.bde);
        this.bcG.completePullRefresh();
        ((com.baidu.adp.widget.ListView.e) this.bcG.getAdapter()).notifyDataSetChanged();
        this.bcF.clearAnimation();
        com.baidu.tbadk.core.util.as.c(this.bcE, n.e.pic_fresh_n);
    }

    public boolean MU() {
        return this.bcy;
    }

    public void NC() {
        this.bcG.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.baC.getPageContext().getPageActivity().getString(n.i.forum));
        com.baidu.tbadk.core.m.rh().cg(str);
    }

    public void ND() {
        if (this.bcH != null) {
            this.bcH.notifyDataSetChanged();
        }
    }

    public void cs(boolean z) {
        this.bcH.cp(z);
    }

    public void ct(boolean z) {
        this.bcH.cq(z);
    }

    private void NE() {
        if (this.bcJ == null) {
            String[] strArr = {this.baC.getPageContext().getPageActivity().getString(n.i.take_photo), this.baC.getPageContext().getPageActivity().getString(n.i.album)};
            this.bcJ = new com.baidu.tbadk.core.dialog.c(this.baC.getPageContext().getPageActivity());
            this.bcJ.cD(this.baC.getPageContext().getPageActivity().getString(n.i.operation));
            this.bcJ.a(strArr, new cl(this));
            this.bcJ.d(this.baC.getPageContext());
        }
    }

    public void NF() {
        NE();
        if (this.bcJ != null) {
            this.bcJ.tz();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.p pVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            ct ctVar = new ct();
            arrayList = new ArrayList<>();
            arrayList.add(ctVar);
            this.bcI.setText(n.i.frs_nodata);
            this.bcI.setVisibility(8);
        } else {
            this.bcI.setVisibility(8);
        }
        this.bcH.a(arrayList, pVar, gc(i), gd(i2));
    }

    public BdListView getListView() {
        return this.bcG;
    }

    private boolean gc(int i) {
        return i > 1;
    }

    private boolean gd(int i) {
        return i == 1;
    }

    public void NG() {
        this.bcH.cp(false);
        this.bcH.cq(false);
        this.bcH.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bcV = forumData.getFrsBannerData();
            int rP = this.bcV.rP();
            if (!this.bcW) {
                IO();
                this.bcG.removeHeaderView(this.aNN);
                if (this.bcV.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.baC.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            this.aNN.reset();
            if (this.bcV.getType() == 1 && !TextUtils.isEmpty(this.bcV.rO())) {
                this.aNN.c(this.baC.getPageContext(), this.bcV.rO());
            }
            W(i, rP);
        }
    }

    private void W(int i, int i2) {
        if (com.baidu.adp.lib.util.i.iP()) {
            if (i == 0) {
                ge(i2);
                this.bda = i2;
            }
            if (i == 1 && i2 != this.bda) {
                ge(i2);
                this.bda = i2;
            }
        }
    }

    private void ge(int i) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.baC.getForumId(), ImageViewerConfig.FORUM_NAME, this.baC.MT().ajy().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    public void NH() {
        if (this.aNN != null) {
            this.bcW = false;
            this.bcG.removeHeaderView(this.aNN);
        }
    }

    public void onPause() {
        if (this.bcQ != null) {
            com.baidu.adp.lib.h.j.a(this.mPopWindow, this.baC.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aQl != null && this.aXw != null) {
            this.aQl.b(this.aXw);
        }
    }

    public void NI() {
        this.bcL.setVisibility(8);
    }

    public void a(dw dwVar) {
        if (!FrsActivityStatic.bay || dwVar == null) {
            this.bcL.setVisibility(8);
            return;
        }
        long Oc = FrsActivityStatic.baz ? dwVar.Oc() - dwVar.Od() : 0L;
        if (Oc > 0 && this.bcM.getVisibility() == 0) {
            this.bcL.setVisibility(0);
            if (Oc < 10) {
                this.bcL.setText(String.valueOf(Oc));
                com.baidu.tbadk.core.util.as.i((View) this.bcL, n.e.icon_news_head_prompt_one);
                return;
            } else if (Oc < 100) {
                this.bcL.setText(String.valueOf(Oc));
                com.baidu.tbadk.core.util.as.i((View) this.bcL, n.e.icon_news_head_prompt_two);
                return;
            } else {
                this.bcL.setText("   ");
                com.baidu.tbadk.core.util.as.i((View) this.bcL, n.e.icon_news_head_prompt_more);
                return;
            }
        }
        this.bcL.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.bcH != null) {
            this.bcH.Nf();
            this.bcH.notifyDataSetChanged();
            this.bcH.onChangeSkinType(i);
        }
        this.baC.MD();
        this.baC.getLayoutMode().af(i == 1);
        this.baC.getLayoutMode().k(this.bcz);
        this.mNavigationBar.onChangeSkinType(this.baC.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.baC, i, com.baidu.tbadk.core.util.as.getDrawable(n.e.bg_pull_down_n));
        }
        if (this.aQl != null) {
            this.aQl.onChangeSkinType(this.baC.getPageContext(), i);
        }
        if (this.aNN != null) {
            this.aNN.oV();
        }
        if (this.aRt != null) {
            this.aRt.cV(i);
        }
        com.baidu.tbadk.core.util.as.a(this.bcA, n.e.icon_edit_selector_s, n.e.icon_edit_selector);
        com.baidu.tbadk.core.util.as.a(this.bcM, n.e.btn_more_selector_s, n.e.btn_more_selector);
        if (this.bcB != null) {
            com.baidu.tbadk.core.util.as.i((View) this.bcB, n.e.icon_news_head_prompt_one);
        }
    }

    public void cu(boolean z) {
        if (z) {
            this.bcE.setAlpha(128);
            this.bcF.setAlpha(128);
            return;
        }
        this.bcE.setAlpha(MotionEventCompat.ACTION_MASK);
        this.bcF.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void nD() {
        this.bcG.nD();
    }

    public int NJ() {
        return 0;
    }

    public void NK() {
        this.bcD.setVisibility(0);
    }

    public void NL() {
        this.bcD.setVisibility(8);
    }

    public ba NM() {
        return this.bcH;
    }

    public View getRootView() {
        return this.bcz;
    }

    public View NN() {
        return this.bcX;
    }

    public void gf(int i) {
        LinearLayout linearLayout = (LinearLayout) this.baC.findViewById(n.f.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void NO() {
        this.bcK.setVisibility(8);
    }

    public void NP() {
        this.bcK.setVisibility(0);
    }

    public void NQ() {
        if (com.baidu.tbadk.performanceLog.y.ES().ET()) {
            int lastVisiblePosition = this.bcG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bcG.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof db) {
                        db dbVar = (db) childAt.getTag();
                        if (dbVar.aYF != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = dbVar.aYF.getPerfLog();
                            perfLog.eL(1000);
                            perfLog.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                dbVar.aYF.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            dbVar.aYF.vY();
                        }
                        if (dbVar.aYB != null && (dbVar.aYB instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = dbVar.aYB;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eL(1000);
                                    perfLog2.ayl = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vY();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bl) {
                        bl blVar = (bl) childAt.getTag();
                        if (blVar.bbl != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = blVar.bbl.getPerfLog();
                            perfLog3.eL(1000);
                            perfLog3.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                blVar.bbl.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            blVar.bbl.vY();
                        }
                        if (blVar.bbD != null && (blVar.bbD instanceof TbImageView)) {
                            TbImageView tbImageView2 = blVar.bbD;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eL(1000);
                            perfLog4.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vY();
                        }
                    }
                    if (childAt.getTag() instanceof cc) {
                        cc ccVar = (cc) childAt.getTag();
                        if (ccVar.bcw != null && ccVar.bcw.aJP != null && (ccVar.bcw.aJP instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = ccVar.bcw.aJP.getPerfLog();
                            perfLog5.eL(1000);
                            perfLog5.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                ccVar.bcw.aJP.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            ccVar.bcw.aJP.vY();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (ccVar.aJK != null) {
                            arrayList.add(ccVar.aJK);
                        }
                        if (ccVar.aJL != null) {
                            arrayList.add(ccVar.aJL);
                        }
                        if (ccVar.aJM != null) {
                            arrayList.add(ccVar.aJM);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eL(1000);
                                perfLog6.ayl = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vY();
                            }
                        }
                    }
                }
            }
        }
    }

    public void NR() {
        this.mHasMore = true;
        this.bcG.setNextPage(this.aRt);
        this.aRt.startLoadData();
    }

    public void NS() {
        this.mHasMore = false;
        if (this.bcZ > 0) {
            this.aRt.cW(this.bcZ);
        }
        this.bcG.setNextPage(this.aRt);
        this.aRt.wf();
        this.aRt.setText(this.baC.getResources().getString(n.i.list_no_more));
    }

    public void NT() {
        this.mHasMore = false;
        this.bcG.setNextPage(null);
        this.aRt.wg();
    }

    public void NU() {
        this.aRt.wg();
    }

    public boolean My() {
        return this.aRt.getView().getParent() != null && this.mHasMore;
    }

    public void gg(int i) {
        this.bcZ = i;
    }
}
