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
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class cg {
    private static /* synthetic */ int[] bhf;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aUd;
    private PbListView aVj;
    private FrsActivity beB;
    private TextView bgB;
    private View bgC;
    private bd bgH;
    private View bgK;
    private View bgN;
    private View bgO;
    private View bgP;
    private View.OnClickListener bgT;
    private com.baidu.tbadk.core.data.j bgV;
    private View bgX;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private boolean bgy = false;
    private NoPressedRelativeLayout bgz = null;
    private ImageView bgA = null;
    private FrameLayout bgD = null;
    private ImageView bgE = null;
    private ImageView bgF = null;
    private BdTypeListView bgG = null;
    private TextView bgI = null;
    private com.baidu.tbadk.core.dialog.c bgJ = null;
    private TextView bgL = null;
    private ImageView bgM = null;
    private com.baidu.tbadk.core.view.t mPullView = null;
    private com.baidu.tieba.tbadkCore.u bgQ = null;
    com.baidu.tbadk.core.dialog.c bgR = null;
    Animation bgS = null;
    private c.b bgU = null;
    private NoNetworkView.a bbw = null;
    private BannerView aRF = null;
    private boolean bgW = false;
    private boolean bgY = false;
    private boolean mHasMore = true;
    private int bgZ = 0;
    private int bha = 0;
    BannerView.a bhb = new ch(this);
    BannerView.a bhc = new ci(this);
    View bhd = null;
    private View.OnTouchListener bhe = new cj(this);

    static /* synthetic */ int[] Oo() {
        int[] iArr = bhf;
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
            bhf = iArr;
        }
        return iArr;
    }

    public cg(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.beB = null;
        this.bgT = null;
        this.beB = frsActivity;
        this.bgT = onClickListener;
        initUI();
    }

    private void initUI() {
        this.bgz = (NoPressedRelativeLayout) this.beB.findViewById(n.g.frs);
        this.mNavigationBar = (NavigationBar) this.beB.findViewById(n.g.view_navigation_bar);
        this.bgC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bgC.setOnClickListener(this.bgT);
        this.bgX = this.beB.findViewById(n.g.frs_list_content);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bgA = (ImageView) addCustomView.findViewById(n.g.frs_top_more);
        com.baidu.tbadk.core.util.as.a(this.bgA, n.f.icon_edit_selector_s, n.f.icon_edit_selector);
        this.bgA.setOnClickListener(this.bgT);
        this.bgB = (TextView) addCustomView.findViewById(n.g.frs_more_mes_text);
        NL();
        this.bgK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bgM = (ImageView) this.bgK.findViewById(n.g.frs_top_more);
        com.baidu.tbadk.core.util.as.a(this.bgM, n.f.btn_more_selector_s, n.f.btn_more_selector);
        this.bgM.setOnClickListener(this.bgT);
        this.bgL = (TextView) this.bgK.findViewById(n.g.frs_more_mes_text);
        this.bgD = (FrameLayout) this.beB.findViewById(n.g.refresh_layout);
        this.bgE = (ImageView) this.beB.findViewById(n.g.refresh_bg);
        this.bgF = (ImageView) this.beB.findViewById(n.g.refresh_icon);
        this.bgG = (BdTypeListView) this.beB.findViewById(n.g.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.beB.getPageContext());
        this.bgG.setDivider(null);
        this.bgG.setPullRefresh(this.mPullView);
        this.bgG.setDividerHeight(0);
        this.bgG.setRecyclerListener(new ck(this));
        this.aVj = new PbListView(this.beB.getPageContext().getPageActivity());
        this.aVj.mT();
        this.aVj.cO(n.d.cp_bg_line_c);
        this.bgG.setOnSrollToBottomListener(this.beB);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ab(new cl(this)));
        this.bgH = new bd(this.beB, this.bgG, com.baidu.tbadk.core.util.ay.va().vc());
        this.bgI = (TextView) this.beB.findViewById(n.g.frs_noexist_post);
        this.bgI.setVisibility(8);
        this.bgD.setOnClickListener(this.bgT);
        this.bgD.setOnTouchListener(this.bhe);
        this.aUd = (NoNetworkView) this.beB.findViewById(n.g.view_no_network);
        cs(false);
    }

    public void NL() {
        if (this.bgB != null && this.bgB.isShown()) {
            this.bgB.setVisibility(8);
        }
    }

    private void Jf() {
        if (this.aRF == null) {
            this.aRF = new BannerView(this.beB.getPageContext().getPageActivity());
            this.aRF.setLayoutParams(new AbsListView.LayoutParams(-1, this.beB.getResources().getDimensionPixelSize(n.e.frs_header_banner_height)));
            this.aRF.setVisibility(8);
            this.aRF.setBannerViewClickListener(this.bhc);
            this.aRF.setBannerViewEvent(new cm(this));
        }
    }

    private void B(int i, String str) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "CLICK", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.beB.Nn().akG().getId(), ImageViewerConfig.FORUM_NAME, this.beB.Nn().akG().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void NM() {
        if (this.bgV != null) {
            String value = this.bgV.getValue();
            int ry = this.bgV.ry();
            if (this.bgV.rw() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.beB.getPageContext().getPageActivity(), value, false, "frs_banner")));
                B(ry, value);
            } else if (this.bgV.rw() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.beB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.beB.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                            B(ry, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bgV.rw() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.adb != UtilHelper.NativePageType.NONE) {
                    switch (Oo()[isNativeAddress.adb.ordinal()]) {
                        case 2:
                            this.beB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.beB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            B(ry, value);
                            return;
                        case 3:
                            this.beB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.beB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            B(ry, value);
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bf.vn().b(this.beB.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.beB.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bgV.rw() == 4) {
                this.beB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.beB.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                B(ry, value);
            }
        }
    }

    public void NN() {
        com.baidu.adp.lib.h.j.a(this.mPopWindow, this.beB.getPageContext().getPageActivity());
    }

    public View NO() {
        return this.bgN;
    }

    public View NP() {
        return this.bgO;
    }

    public View NQ() {
        return this.bgP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView NR() {
        return this.bgA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.bgM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View NS() {
        return this.bgC;
    }

    public void f(NoNetworkView.a aVar) {
        this.bbw = aVar;
        if (this.aUd != null) {
            this.aUd.a(this.bbw);
        }
    }

    public void a(com.baidu.tbadk.core.data.z zVar, boolean z) {
        String string = this.beB.getPageContext().getPageActivity().getString(n.j.view);
        String string2 = this.beB.getPageContext().getPageActivity().getString(n.j.view_host);
        String string3 = this.beB.getPageContext().getPageActivity().getString(n.j.view_reverse);
        this.bgR = new com.baidu.tbadk.core.dialog.c(this.beB.getPageContext().getPageActivity());
        this.bgR.bJ(n.j.operation);
        if (z) {
            this.bgR.a(new String[]{string, string3}, this.bgU);
        } else {
            this.bgR.a(new String[]{string, string2, string3}, this.bgU);
        }
        this.bgR.d(this.beB.getPageContext());
    }

    public void a(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.beB.getPageContext().getPageActivity());
        cVar.bJ(n.j.publish_thread_type);
        String string = this.beB.getPageContext().getPageActivity().getString(n.j.publish_topic_thread);
        String string2 = this.beB.getPageContext().getPageActivity().getString(n.j.publish_live_thread);
        cVar.a(new CharSequence[]{string, y(string2, n.f.icon_news_head_new), this.beB.getPageContext().getPageActivity().getString(n.j.publish_vote_thread)}, bVar);
        cVar.d(this.beB.getPageContext());
        cVar.tj();
    }

    public void b(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.beB.getPageContext().getPageActivity());
        cVar.bJ(n.j.publish_thread_type);
        cVar.a(new CharSequence[]{this.beB.getPageContext().getPageActivity().getString(n.j.publish_topic_thread), this.beB.getPageContext().getPageActivity().getString(n.j.publish_vote_thread)}, bVar);
        cVar.d(this.beB.getPageContext());
        cVar.tj();
    }

    private CharSequence y(String str, int i) {
        ImageSpan[] imageSpanArr;
        if (!com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), false)) {
            Spanned fromHtml = Html.fromHtml(String.valueOf(str) + "<img src=\"" + i + "\">", new cn(this), null);
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
            canvas.translate(cg.this.beB.getActivity().getResources().getDimensionPixelSize(n.e.ds24) + f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
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

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bgG.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.bgH.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bgH.a(wVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.bgH.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.bgH.k(onClickListener);
    }

    public void c(c.b bVar) {
        this.bgU = bVar;
    }

    public void a(BdListView.g gVar) {
        this.bgG.setOnScrollToPullListener(gVar);
    }

    public void NT() {
        if (this.bgR != null) {
            this.bgR.tj();
        }
    }

    public void onDestroy() {
        this.bgH.onDestory();
        this.bgG.setOnSrollToBottomListener(null);
    }

    private Animation NU() {
        if (this.bgS == null) {
            this.bgS = AnimationUtils.loadAnimation(this.beB.getPageContext().getPageActivity(), n.a.refresh_rotate);
            this.bgS.setInterpolator(new LinearInterpolator());
            this.bgS.setFillAfter(true);
        }
        return this.bgS;
    }

    public void cs(boolean z) {
        this.bgy = z;
        if (z) {
            this.bgD.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.beB, this.bgF, NU(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.as.c(this.bgE, n.f.pic_fresh_s);
            return;
        }
        this.bgD.setOnTouchListener(this.bhe);
        this.bgG.completePullRefresh();
        ((com.baidu.adp.widget.ListView.e) this.bgG.getAdapter()).notifyDataSetChanged();
        this.bgF.clearAnimation();
        com.baidu.tbadk.core.util.as.c(this.bgE, n.f.pic_fresh_n);
    }

    public boolean No() {
        return this.bgy;
    }

    public void NV() {
        this.bgG.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.beB.getPageContext().getPageActivity().getString(n.j.forum));
        com.baidu.tbadk.core.m.qQ().ci(str);
    }

    public void NW() {
        if (this.bgH != null) {
            this.bgH.notifyDataSetChanged();
        }
    }

    public void ct(boolean z) {
        this.bgH.cq(z);
    }

    public void cu(boolean z) {
        this.bgH.cr(z);
    }

    private void NX() {
        if (this.bgJ == null) {
            String[] strArr = {this.beB.getPageContext().getPageActivity().getString(n.j.take_photo), this.beB.getPageContext().getPageActivity().getString(n.j.album)};
            this.bgJ = new com.baidu.tbadk.core.dialog.c(this.beB.getPageContext().getPageActivity());
            this.bgJ.cG(this.beB.getPageContext().getPageActivity().getString(n.j.operation));
            this.bgJ.a(strArr, new co(this));
            this.bgJ.d(this.beB.getPageContext());
        }
    }

    public void NY() {
        NX();
        if (this.bgJ != null) {
            this.bgJ.tj();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.p pVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cw cwVar = new cw();
            arrayList = new ArrayList<>();
            arrayList.add(cwVar);
            this.bgI.setText(n.j.frs_nodata);
            this.bgI.setVisibility(8);
        } else {
            this.bgI.setVisibility(8);
        }
        this.bgH.a(arrayList, pVar, fX(i), fY(i2));
    }

    public BdListView getListView() {
        return this.bgG;
    }

    private boolean fX(int i) {
        return i > 1;
    }

    private boolean fY(int i) {
        return i == 1;
    }

    public void NZ() {
        this.bgH.cq(false);
        this.bgH.cr(false);
        this.bgH.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bgV = forumData.getFrsBannerData();
            int ry = this.bgV.ry();
            if (!this.bgW) {
                Jf();
                this.bgG.removeHeaderView(this.aRF);
                if (this.bgV.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.beB.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            this.aRF.reset();
            if (this.bgV.getType() == 1 && !TextUtils.isEmpty(this.bgV.rx())) {
                this.aRF.c(this.beB.getPageContext(), this.bgV.rx());
            }
            W(i, ry);
        }
    }

    private void W(int i, int i2) {
        if (com.baidu.adp.lib.util.i.iQ()) {
            if (i == 0) {
                fZ(i2);
                this.bha = i2;
            }
            if (i == 1 && i2 != this.bha) {
                fZ(i2);
                this.bha = i2;
            }
        }
    }

    private void fZ(int i) {
        if (i != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "FRS", "locate", "c0115", "action_type", "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(i), "obj_name", String.valueOf(i), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.beB.getForumId(), ImageViewerConfig.FORUM_NAME, this.beB.Nn().akG().getName(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
        }
    }

    public void Oa() {
        if (this.aRF != null) {
            this.bgW = false;
            this.bgG.removeHeaderView(this.aRF);
        }
    }

    public void onPause() {
        if (this.bgQ != null) {
            com.baidu.adp.lib.h.j.a(this.mPopWindow, this.beB.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aUd != null && this.bbw != null) {
            this.aUd.b(this.bbw);
        }
    }

    public void Ob() {
        this.bgL.setVisibility(8);
    }

    public void a(dw dwVar) {
        if (!FrsActivityStatic.bex || dwVar == null) {
            this.bgL.setVisibility(8);
            return;
        }
        long Ov = FrsActivityStatic.bey ? dwVar.Ov() - dwVar.Ow() : 0L;
        if (Ov > 0 && this.bgM.getVisibility() == 0) {
            this.bgL.setVisibility(0);
            if (Ov < 10) {
                this.bgL.setText(String.valueOf(Ov));
                com.baidu.tbadk.core.util.as.i((View) this.bgL, n.f.icon_news_head_prompt_one);
                return;
            } else if (Ov < 100) {
                this.bgL.setText(String.valueOf(Ov));
                com.baidu.tbadk.core.util.as.i((View) this.bgL, n.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bgL.setText("   ");
                com.baidu.tbadk.core.util.as.i((View) this.bgL, n.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bgL.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.bgH != null) {
            this.bgH.Ny();
            this.bgH.notifyDataSetChanged();
            this.bgH.onChangeSkinType(i);
        }
        this.beB.MW();
        this.beB.getLayoutMode().ac(i == 1);
        this.beB.getLayoutMode().k(this.bgz);
        this.mNavigationBar.onChangeSkinType(this.beB.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.beB, i, com.baidu.tbadk.core.util.as.getDrawable(n.f.bg_pull_down_n));
        }
        if (this.aUd != null) {
            this.aUd.onChangeSkinType(this.beB.getPageContext(), i);
        }
        if (this.aRF != null) {
            this.aRF.ot();
        }
        if (this.aVj != null) {
            this.aVj.cP(i);
        }
        com.baidu.tbadk.core.util.as.a(this.bgA, n.f.icon_edit_selector_s, n.f.icon_edit_selector);
        com.baidu.tbadk.core.util.as.a(this.bgM, n.f.btn_more_selector_s, n.f.btn_more_selector);
        if (this.bgB != null) {
            com.baidu.tbadk.core.util.as.i((View) this.bgB, n.f.icon_news_head_prompt_one);
        }
    }

    public void cv(boolean z) {
        if (z) {
            this.bgE.setAlpha(128);
            this.bgF.setAlpha(128);
            return;
        }
        this.bgE.setAlpha(MotionEventCompat.ACTION_MASK);
        this.bgF.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void nb() {
        this.bgG.nb();
    }

    public int Oc() {
        return 0;
    }

    public void Od() {
        this.bgD.setVisibility(0);
    }

    public void Oe() {
        this.bgD.setVisibility(8);
    }

    public bd Of() {
        return this.bgH;
    }

    public View getRootView() {
        return this.bgz;
    }

    public View Og() {
        return this.bgX;
    }

    public void ga(int i) {
        LinearLayout linearLayout = (LinearLayout) this.beB.findViewById(n.g.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Oh() {
        this.bgK.setVisibility(8);
    }

    public void Oi() {
        this.bgK.setVisibility(0);
    }

    public void Oj() {
        if (com.baidu.tbadk.performanceLog.y.EH().EI()) {
            int lastVisiblePosition = this.bgG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bgG.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof de) {
                        de deVar = (de) childAt.getTag();
                        if (deVar.bcC != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = deVar.bcC.getPerfLog();
                            perfLog.eF(1000);
                            perfLog.azO = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                deVar.bcC.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            deVar.bcC.vI();
                        }
                        if (deVar.bcA != null && (deVar.bcA instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = deVar.bcA;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eF(1000);
                                    perfLog2.azO = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vI();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bo) {
                        bo boVar = (bo) childAt.getTag();
                        if (boVar.bfk != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = boVar.bfk.getPerfLog();
                            perfLog3.eF(1000);
                            perfLog3.azO = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                boVar.bfk.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            boVar.bfk.vI();
                        }
                        if (boVar.bfC != null && (boVar.bfC instanceof TbImageView)) {
                            TbImageView tbImageView2 = boVar.bfC;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eF(1000);
                            perfLog4.azO = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vI();
                        }
                    }
                    if (childAt.getTag() instanceof cf) {
                        cf cfVar = (cf) childAt.getTag();
                        if (cfVar.bgw != null && cfVar.bgw.aLn != null && (cfVar.bgw.aLn instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = cfVar.bgw.aLn.getPerfLog();
                            perfLog5.eF(1000);
                            perfLog5.azO = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                cfVar.bgw.aLn.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            cfVar.bgw.aLn.vI();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (cfVar.aLi != null) {
                            arrayList.add(cfVar.aLi);
                        }
                        if (cfVar.aLj != null) {
                            arrayList.add(cfVar.aLj);
                        }
                        if (cfVar.aLk != null) {
                            arrayList.add(cfVar.aLk);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eF(1000);
                                perfLog6.azO = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vI();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Ok() {
        this.mHasMore = true;
        this.bgG.setNextPage(this.aVj);
        this.aVj.startLoadData();
    }

    public void Ol() {
        this.mHasMore = false;
        if (this.bgZ > 0) {
            this.aVj.cQ(this.bgZ);
        }
        this.bgG.setNextPage(this.aVj);
        this.aVj.vP();
        this.aVj.setText(this.beB.getResources().getString(n.j.list_no_more));
    }

    public void Om() {
        this.mHasMore = false;
        this.bgG.setNextPage(null);
        this.aVj.vQ();
    }

    public void On() {
        this.aVj.vQ();
    }

    public boolean MR() {
        return this.aVj.getView().getParent() != null && this.mHasMore;
    }

    public void gb(int i) {
        this.bgZ = i;
    }
}
