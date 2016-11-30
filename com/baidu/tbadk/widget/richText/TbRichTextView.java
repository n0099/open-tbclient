package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.r;
import com.baidu.tieba.togetherhi.TogetherHiLivingView;
import com.baidu.tieba.togetherhi.ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    private static final float aJB;
    static int aJC;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEL;
    private com.baidu.adp.lib.f.b<ImageView> aJD;
    private com.baidu.adp.lib.f.b<TextView> aJE;
    private com.baidu.adp.lib.f.b<View> aJF;
    private com.baidu.adp.lib.f.b<View> aJG;
    private com.baidu.adp.lib.f.b<LinearLayout> aJH;
    private com.baidu.adp.lib.f.b<GifView> aJI;
    private com.baidu.adp.lib.f.b<View> aJJ;
    private float aJK;
    private int aJL;
    private int aJM;
    private float aJN;
    private int aJO;
    private int aJP;
    private int aJQ;
    private int aJR;
    private int aJS;
    private ImageView.ScaleType aJT;
    private int aJU;
    private int aJV;
    private boolean aJW;
    private TextUtils.TruncateAt aJX;
    private g aJY;
    private e aJZ;
    private f aKa;
    private View.OnClickListener aKb;
    private boolean aKc;
    private int aKd;
    private boolean aKe;
    private boolean aKf;
    private Runnable aKg;
    private boolean aKh;
    private d aKi;
    private com.baidu.tbadk.widget.richText.a aKj;
    private String aKk;
    private boolean aKl;
    private boolean aKm;
    private boolean aKn;
    private int aKo;
    private boolean aKp;
    private boolean aKq;
    private boolean aKr;
    private int aKs;
    private boolean aKt;
    private boolean aKu;
    public final View.OnClickListener aKv;
    private final View.OnTouchListener aKw;
    private boolean aKx;
    private Drawable aKy;
    private CustomMessageListener aKz;
    private BdUniqueId ayG;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private int vj;
    private static final int aJz = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32);
    private static final float aJA = com.baidu.adp.lib.util.k.M(TbadkCoreApplication.m9getInst());

    /* loaded from: classes.dex */
    public interface b {
        void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(View view, String str, int i);
    }

    /* loaded from: classes.dex */
    public interface f {
        void b(View view, String str);
    }

    static {
        aJB = aJA > 0.0f ? 1.0f / aJA : 0.3f;
        aJC = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aKt = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aKu = z;
    }

    public boolean IQ() {
        return this.aKh;
    }

    public void IR() {
        this.aKl = true;
    }

    public String getBackgroundImageUrl() {
        return this.aKk;
    }

    public void setBackgroundImageUrl(String str) {
        this.aKk = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.vj = i;
    }

    public void setMaxLines(int i) {
        this.aKo = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aJX = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aKr = z;
    }

    public boolean getIsSupportVitality() {
        return this.aKr;
    }

    public float getLineSpacing() {
        return this.aJK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        public String url;

        public c(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q(View view) {
        if ((view instanceof ImageView) && !(view instanceof GifView)) {
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof c) {
                    return false;
                }
                if ((view.getTag() instanceof String) && TextUtils.equals("VideoView", (String) view.getTag())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, int i) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, i);
    }

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, z);
    }

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.f.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new v(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aJD = null;
        this.aJE = null;
        this.aJF = null;
        this.aJG = null;
        this.aJH = null;
        this.aJI = null;
        this.aJJ = null;
        this.aJK = 0.0f;
        this.aJL = 0;
        this.aJM = 0;
        this.aJN = 15.0f;
        this.aJO = -1;
        this.aJP = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aJQ = -9989158;
        this.aJR = 200;
        this.aJS = 200;
        this.aJT = null;
        this.aJU = 0;
        this.aJV = 0;
        this.aJW = false;
        this.aJX = null;
        this.aJY = null;
        this.aJZ = null;
        this.aKa = null;
        this.aKb = null;
        this.aKc = true;
        this.mIsFromCDN = true;
        this.aKd = -1;
        this.aKe = false;
        this.aKf = false;
        this.aKg = null;
        this.aKh = false;
        this.aKk = null;
        this.aKl = false;
        this.aKm = false;
        this.vj = -1;
        this.aKo = -1;
        this.aKp = true;
        this.aKq = false;
        this.aKr = false;
        this.aKt = false;
        this.aKu = true;
        this.mOnClickListener = new p(this);
        this.aKv = new r(this);
        this.aKw = new s(this);
        this.mType = 19;
        this.aEL = new t(this);
        this.aKz = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJD = null;
        this.aJE = null;
        this.aJF = null;
        this.aJG = null;
        this.aJH = null;
        this.aJI = null;
        this.aJJ = null;
        this.aJK = 0.0f;
        this.aJL = 0;
        this.aJM = 0;
        this.aJN = 15.0f;
        this.aJO = -1;
        this.aJP = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aJQ = -9989158;
        this.aJR = 200;
        this.aJS = 200;
        this.aJT = null;
        this.aJU = 0;
        this.aJV = 0;
        this.aJW = false;
        this.aJX = null;
        this.aJY = null;
        this.aJZ = null;
        this.aKa = null;
        this.aKb = null;
        this.aKc = true;
        this.mIsFromCDN = true;
        this.aKd = -1;
        this.aKe = false;
        this.aKf = false;
        this.aKg = null;
        this.aKh = false;
        this.aKk = null;
        this.aKl = false;
        this.aKm = false;
        this.vj = -1;
        this.aKo = -1;
        this.aKp = true;
        this.aKq = false;
        this.aKr = false;
        this.aKt = false;
        this.aKu = true;
        this.mOnClickListener = new p(this);
        this.aKv = new r(this);
        this.aKw = new s(this);
        this.mType = 19;
        this.aEL = new t(this);
        this.aKz = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.TbRichTextView);
        this.aJM = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aJL = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aJK = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aJN = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aJN);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aJR = obtainStyledAttributes.getDimensionPixelSize(6, this.aJR);
        this.aJS = obtainStyledAttributes.getDimensionPixelSize(7, this.aJS);
        this.aJU = obtainStyledAttributes.getResourceId(8, 0);
        this.aJO = obtainStyledAttributes.getDimensionPixelSize(9, this.aJO);
        this.aJP = obtainStyledAttributes.getDimensionPixelSize(10, this.aJP);
        this.aJV = obtainStyledAttributes.getResourceId(11, 0);
        this.aJW = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aJK = f2;
    }

    private void init() {
        aJC = getContext().getResources().getDimensionPixelSize(r.e.ds348);
        m mVar = null;
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
        if (getContext() instanceof m) {
            mVar = (m) getContext();
        } else if (C != null && (C.getOrignalPage() instanceof m)) {
            mVar = (m) C.getOrignalPage();
        }
        if (C != null) {
            C.registerListener(this.aKz);
        }
        if (mVar != null) {
            this.aJD = mVar.IG();
            this.aJE = mVar.IH();
            this.aJG = mVar.IJ();
            this.aJH = mVar.IK();
            this.aJI = mVar.II();
            this.aJF = mVar.IL();
            if (mVar.getListView() != null && this.aJY == null) {
                this.aJY = new g(mVar.IF());
                mVar.getListView().setRecyclerListener(this.aJY);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new w(this));
        this.aKs = com.baidu.adp.lib.util.k.K(getContext());
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        a(aVar, z, (b) null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:100:0x0027 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x0027 */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z, b bVar) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ic;
        boolean z2;
        SpannableStringBuilder Ii;
        View view;
        View a2;
        n Ir;
        View view2 = null;
        if (this.aKj != aVar || (aVar != null && aVar.aIM)) {
            if (aVar != null) {
                aVar.aIM = false;
            }
            this.aKj = aVar;
            removeAllViews();
            if (aVar != null && (Ic = aVar.Ic()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = Ic.iterator();
                int i = 0;
                View view3 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView as = as(getContext());
                            boolean a3 = a(next, as, true, bVar);
                            if (z && !this.aKh && (Ii = next.Ii()) != null) {
                                this.aKh = Ii.length() >= 200;
                            }
                            as.setOnClickListener(this.aKb);
                            z2 = a3;
                            view3 = as;
                        } else if (next.getType() == 8) {
                            if (i < 10) {
                                i++;
                                ImageView ar = ar(getContext());
                                z2 = b(next, ar, this.aJR, this.aJS);
                                view3 = ar;
                            }
                        } else if (next.getType() == 32) {
                            o Il = next.Il();
                            if (Il != null && Il.IN()) {
                                a2 = b(Il);
                            } else {
                                a2 = a(next);
                            }
                            view3 = a2;
                            z2 = true;
                        } else if (next.getType() == 512) {
                            view3 = getVoiceView();
                            if (view3 != null) {
                                z2 = a(next, view3);
                                view3 = view3;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z2 = a(next, (LinearLayout) textVoiceView, bVar);
                            view3 = textVoiceView;
                        } else if (next.getType() == 17) {
                            View gifView = getGifView();
                            z2 = a(next, (GifView) gifView);
                            view3 = gifView;
                        } else if (next.getType() == 1280) {
                            ImageView ar2 = ar(getContext());
                            i++;
                            z2 = a(next, ar2, (this.aJR - getPaddingLeft()) - getPaddingRight(), this.aJS);
                            view3 = ar2;
                        } else if (next.getType() == 1536) {
                            com.baidu.tbadk.widget.richText.f Iq = next.Iq();
                            Iq.fx(aVar.Ib());
                            if (Iq != null) {
                                View a4 = a(Iq, aVar.Ib(), aVar.getAuthorId());
                                z2 = true;
                                view3 = a4;
                            }
                            z2 = false;
                            view3 = view3;
                        } else {
                            if (next.getType() == 1792 && (Ir = next.Ir()) != null) {
                                View b2 = b(Ir);
                                z2 = true;
                                view3 = b2;
                            }
                            z2 = false;
                            view3 = view3;
                        }
                        if (!z2 || view3 == null) {
                            view = view2;
                        } else {
                            addView(view3);
                            view = view3;
                        }
                        if ((view3 instanceof ImageView) && next.getType() == 8) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view3.getLayoutParams();
                            view.setLayoutParams(layoutParams);
                            if (i == 1) {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20);
                            } else if (i > 1) {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds4);
                            }
                            view3.setLayoutParams(layoutParams);
                        }
                        view2 = view;
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams2.bottomMargin = this.aJM;
                    view2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aKb = onClickListener;
    }

    private View b(o oVar) {
        if (oVar == null || !oVar.isAvaliable()) {
            return null;
        }
        ImageView ey = this.aJD.ey();
        if (ey instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) ey;
            foreDrawableImageView.setForegroundDrawable(r.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(r.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, oVar.getWidth(), oVar.getHeight(), (this.aJR - getPaddingLeft()) - getPaddingRight(), this.aJS, new x(this, oVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aKl);
            if (com.baidu.tbadk.core.l.oJ().oP()) {
                foreDrawableImageView.setDefaultBgResource(r.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(r.d.cp_bg_line_c);
            }
            foreDrawableImageView.c(oVar.qg(), 17, false);
            return ey;
        }
        return ey;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aKr && M(i, i2) && this.aKs > 0) {
            i3 = this.aKs;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aJU);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aKn || i3 <= i5 || aJA <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aJA <= i3) {
                if (i5 * aJA > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aJA);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
        if (this.aKn) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aJT == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aJT);
        }
        if (this.aKr) {
            if (M(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aJz;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aJV <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aJM;
        linearLayout.setClickable(true);
        Bitmap cO = at.cO(this.aJV);
        if (cO != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cO));
        }
        linearLayout.setFocusable(false);
        if (this.aKr) {
            layoutParams.leftMargin = aJz;
            layoutParams.rightMargin = aJz;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new y(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aJV;
    }

    public void setVideoImageId(int i) {
        this.aJV = i;
    }

    private ImageView ar(Context context) {
        ImageView ey = this.aJD != null ? this.aJD.ey() : null;
        if (ey == null || ey.getParent() != null) {
            ey = null;
        }
        if (ey != null) {
            ey.setContentDescription(context.getString(r.j.log_msg_pic));
        }
        return ey;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        l Io = cVar.Io();
        if (Io != null && Io.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aKl) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(Io.IE(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(Io.getLink()));
                if (!Io.Ix()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, Io.getWidth(), Io.getHeight(), i, i2, this.aKv);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.g Ih = cVar.Ih();
        if (Ih == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aKl) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(Ih.Iw(), this.mIsFromCDN ? 17 : 18, false);
            if (!Ih.Ix()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, Ih.getWidth(), Ih.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aKn = z;
    }

    private TextView as(Context context) {
        TextView textView = null;
        if (this.aJE != null) {
            textView = this.aJE.ey();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aJL, 0, this.aJL, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aKm) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aJM;
        }
        textView.setLineSpacing(0.0f, this.aJK);
        textView.setTextSize(0, this.aJN);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(at.getColor(r.d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(r.d.transparent));
        textView.setSingleLine(this.aJW);
        if (this.aJX != null) {
            textView.setEllipsize(this.aJX);
        }
        if (this.vj > 0) {
            textView.setMaxWidth(this.vj);
        }
        if (this.aKo > 0) {
            textView.setMaxLines(this.aKo);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder Ii = cVar.Ii();
        if (Ii == null || Ii.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aJP > 0 && this.aJO > 0) {
            cVar.K(this.aJO, this.aJP);
        }
        if (textSize > 0) {
            cVar.J(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(Ii, textView, this);
        }
        try {
            textView.setText(Ii);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aKp) {
            if (cVar.Is()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bti());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aKr) {
            layoutParams.leftMargin = aJz;
            layoutParams.rightMargin = aJz;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.Ik() != null) {
            cVar.Ik().aJg = this.aKx;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aJI != null) {
            gifView = this.aJI.ey();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aKr) {
                layoutParams.leftMargin = aJz;
                layoutParams.rightMargin = aJz;
            } else {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
            }
            gifView2.setLayoutParams(layoutParams);
        }
        return gifView2;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.Im().ayE.ayi || layoutParams.height != cVar.Im().ayE.ayj) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Im().ayE.ayi, cVar.Im().ayE.ayj);
            layoutParams2.gravity = 3;
            if (this.aKr) {
                layoutParams2.leftMargin = aJz;
                layoutParams2.rightMargin = aJz;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.Im().ayE);
        return true;
    }

    private View getVoiceView() {
        View ey = this.aJG != null ? this.aJG.ey() : null;
        if ((ey == null || ey.getParent() != null) && this.aKd != -1) {
            ey = LayoutInflater.from(getContext()).inflate(this.aKd, (ViewGroup) null);
        }
        if (ey != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aJM;
            layoutParams.bottomMargin = this.aJM;
            ey.setLayoutParams(layoutParams);
            return ey;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(com.baidu.tbadk.widget.richText.f fVar, int i, String str) {
        com.baidu.tieba.graffiti.e eVar = null;
        if (this.aJF != null) {
            eVar = this.aJF.ey();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new com.baidu.tieba.graffiti.e(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aJM;
        layoutParams.bottomMargin = this.aJM;
        if (this.aKr) {
            layoutParams.leftMargin = aJz;
            layoutParams.rightMargin = aJz;
        }
        eVar.setLayoutParams(layoutParams);
        if (eVar instanceof com.baidu.tieba.graffiti.e) {
            com.baidu.tieba.graffiti.e eVar2 = eVar;
            eVar2.j(this.aKc, false);
            if (eVar2.getGraffitiImageView() != null) {
                eVar2.getGraffitiImageView().setSupportNoImage(this.aKl);
                eVar2.getGraffitiImageView().setDefaultResource(this.aJU);
            }
            if (eVar2.getSaveBtn() != null) {
                eVar2.getSaveBtn().setOnTouchListener(this.aKw);
            }
            eVar2.a(fVar, i, str, this.aJR - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aKu);
        }
        return eVar;
    }

    private View b(n nVar) {
        m mVar;
        if (this.aJJ == null) {
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
            if (getContext() instanceof m) {
                mVar = (m) getContext();
            } else {
                mVar = (C == null || !(C.getOrignalPage() instanceof m)) ? null : (m) C.getOrignalPage();
            }
            this.aJJ = mVar.fB(nVar.VD);
        }
        View ey = this.aJJ != null ? this.aJJ.ey() : null;
        if (ey == null || ey.getParent() != null) {
            if (nVar.VD == 1) {
                ey = new ds(getContext());
            } else {
                ey = new TogetherHiLivingView(getContext());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aJM;
        ey.setLayoutParams(layoutParams);
        if (ey instanceof ds) {
            ey.setData(nVar);
        }
        if (ey instanceof TogetherHiLivingView) {
            ey.setData(nVar);
        }
        return ey;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.Ij());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aKr) {
            layoutParams.leftMargin = aJz;
            layoutParams.rightMargin = aJz;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ey = this.aJH.ey();
        if (ey != null) {
            TextView as = as(getContext());
            if (as == null) {
                this.aJH.n(ey);
                return null;
            }
            ey.addView(as);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aJE.n(as);
                this.aJH.n(ey);
                return null;
            }
            ey.addView(voiceView);
            return ey;
        }
        return ey;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, LinearLayout linearLayout, b bVar) {
        boolean a2;
        boolean z = true;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt == null) {
                a2 = z;
            } else if (childAt instanceof TextView) {
                a2 = a(cVar, (TextView) childAt, false, bVar) & z;
            } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                a2 = a(cVar, childAt) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBntNew") ? a(cVar, childAt) & z : z;
            }
            i++;
            z = a2;
        }
        return z;
    }

    public void setTextSize(float f2) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f2, resources.getDisplayMetrics());
        if (applyDimension != this.aJN) {
            this.aJN = applyDimension;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, applyDimension);
                }
            }
        }
    }

    public void setTextColor(int i) {
        if (i != this.mTextColor) {
            this.mTextColor = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setTextColor(i);
                }
            }
        }
    }

    public void setTextPadding(int i) {
        if (this.aJL != i) {
            this.aJL = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aJL, 0, 0, this.aJL);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aJQ) {
            this.aJQ = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean M(int i, int i2) {
        if (this.aKs <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aKs)) > aJB ? 1 : ((((float) i) / ((float) this.aKs)) == aJB ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aJR;
    }

    public void setMaxImageWidth(int i) {
        this.aJR = i;
    }

    public int getMaxImageHeight() {
        return this.aJS;
    }

    public void setMaxImageHeight(int i) {
        this.aJS = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aJT;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aJT = scaleType;
    }

    public int getDefaultImageId() {
        return this.aJU;
    }

    public void setDefaultImageId(int i) {
        this.aJU = i;
    }

    public e getOnImageClickListener() {
        return this.aJZ;
    }

    public void setOnImageClickListener(e eVar) {
        this.aJZ = eVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aKi = dVar;
    }

    public void j(boolean z, boolean z2) {
        if (this.aKc != z) {
            this.aKc = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aKc && this.aJD != null) {
                this.aJD.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g implements AbsListView.RecyclerListener {
        private int mId;

        public g(int i) {
            this.mId = 0;
            this.mId = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.mId);
            if (findViewById != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.aKe = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aKf) {
                    IT();
                    break;
                } else if (!this.aKq) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aKe) {
                    IS();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aKe = true;
        return super.onTouchEvent(motionEvent);
    }

    private void IS() {
        this.aKf = false;
        if (this.aKg == null) {
            this.aKg = new a();
        }
        postDelayed(this.aKg, ViewConfiguration.getLongPressTimeout());
    }

    private void IT() {
        if (this.aKg != null) {
            removeCallbacks(this.aKg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aKq && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aKf = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aKd = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aKk = null;
        if (this.aKy != drawable) {
            this.aKx = true;
            this.aKy = drawable;
        }
        setText(this.aKj);
        this.aKx = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Em();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Em();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Em();
        } else {
            refresh();
        }
    }

    public void gI(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.ayG == bdUniqueId)) {
            Em();
        }
        this.mUrl = str;
        this.ayG = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.eA().al(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, this.aEL, 0, 0, this.ayG, new Object[0]);
        }
    }

    public void Em() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, this.aEL);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.jV(), aVar.jV().getNinePatchChunk(), aVar.jZ(), null);
                if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        gI(this.mUrl);
    }

    public void setTextViewOnClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnClickListener(onClickListener);
            }
        }
    }

    public void setTextViewCheckSelection(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setCheckSelection(z);
            }
        }
    }

    public void setTextViewOnTouchListener(View.OnTouchListener onTouchListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnTouchListener(onTouchListener);
            }
        }
    }

    public TextView getTextView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                return (TbListTextView) childAt;
            }
        }
        return null;
    }

    public f getOnLinkImageClickListener() {
        return this.aKa;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aKa = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aKp = z;
    }

    public void setTextCenter(boolean z) {
        this.aKm = z;
    }
}
