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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int aDw = 174;
    private int Bv;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAj;
    private com.baidu.adp.lib.f.b<LinearLayout> aDA;
    private com.baidu.adp.lib.f.b<GifView> aDB;
    private float aDC;
    private int aDD;
    private int aDE;
    private float aDF;
    private int aDG;
    private int aDH;
    private int aDI;
    private int aDJ;
    private int aDK;
    private ImageView.ScaleType aDL;
    private int aDM;
    private int aDN;
    private boolean aDO;
    private TextUtils.TruncateAt aDP;
    private f aDQ;
    private d aDR;
    private e aDS;
    private boolean aDT;
    private int aDU;
    private boolean aDV;
    private boolean aDW;
    private Runnable aDX;
    private boolean aDY;
    private c aDZ;
    private com.baidu.adp.lib.f.b<ImageView> aDx;
    private com.baidu.adp.lib.f.b<TextView> aDy;
    private com.baidu.adp.lib.f.b<View> aDz;
    private com.baidu.tbadk.widget.richText.a aEa;
    private String aEb;
    private boolean aEc;
    private boolean aEd;
    private int aEe;
    public final View.OnClickListener aEf;
    private boolean aEg;
    private Drawable aEh;
    private BdUniqueId aux;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(View view, String str, int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void b(View view, String str);
    }

    public boolean Gn() {
        return this.aDY;
    }

    public void Go() {
        this.aEc = true;
    }

    public String getBackgroundImageUrl() {
        return this.aEb;
    }

    public void setBackgroundImageUrl(String str) {
        this.aEb = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bv = i;
    }

    public void setMaxLines(int i) {
        this.aEe = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aDP = truncateAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public String url;

        public b(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y(View view) {
        if ((view instanceof ImageView) && !(view instanceof GifView)) {
            return ((view instanceof TbImageView) && view.getTag() != null && (view.getTag() instanceof b)) ? false : true;
        }
        return false;
    }

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, int i) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, i);
    }

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.f.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new q(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aDx = null;
        this.aDy = null;
        this.aDz = null;
        this.aDA = null;
        this.aDB = null;
        this.aDC = 0.0f;
        this.aDD = 0;
        this.aDE = 0;
        this.aDF = 15.0f;
        this.aDG = -1;
        this.aDH = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aDI = -9989158;
        this.aDJ = 200;
        this.aDK = 200;
        this.aDL = null;
        this.aDM = 0;
        this.aDN = 0;
        this.aDO = false;
        this.aDP = null;
        this.aDQ = null;
        this.aDR = null;
        this.aDS = null;
        this.aDT = true;
        this.mIsFromCDN = true;
        this.aDU = -1;
        this.aDV = false;
        this.aDW = false;
        this.aDX = null;
        this.aDY = false;
        this.aEb = null;
        this.aEc = false;
        this.Bv = -1;
        this.aEe = -1;
        this.mOnClickListener = new n(this);
        this.aEf = new o(this);
        this.mType = 19;
        this.aAj = new p(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDx = null;
        this.aDy = null;
        this.aDz = null;
        this.aDA = null;
        this.aDB = null;
        this.aDC = 0.0f;
        this.aDD = 0;
        this.aDE = 0;
        this.aDF = 15.0f;
        this.aDG = -1;
        this.aDH = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aDI = -9989158;
        this.aDJ = 200;
        this.aDK = 200;
        this.aDL = null;
        this.aDM = 0;
        this.aDN = 0;
        this.aDO = false;
        this.aDP = null;
        this.aDQ = null;
        this.aDR = null;
        this.aDS = null;
        this.aDT = true;
        this.mIsFromCDN = true;
        this.aDU = -1;
        this.aDV = false;
        this.aDW = false;
        this.aDX = null;
        this.aDY = false;
        this.aEb = null;
        this.aEc = false;
        this.Bv = -1;
        this.aEe = -1;
        this.mOnClickListener = new n(this);
        this.aEf = new o(this);
        this.mType = 19;
        this.aAj = new p(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.k.TbRichTextView);
        this.aDE = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aDD = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aDC = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aDF = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aDF);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aDJ = obtainStyledAttributes.getDimensionPixelSize(6, this.aDJ);
        this.aDK = obtainStyledAttributes.getDimensionPixelSize(7, this.aDK);
        this.aDM = obtainStyledAttributes.getResourceId(8, 0);
        this.aDG = obtainStyledAttributes.getDimensionPixelSize(9, this.aDG);
        this.aDH = obtainStyledAttributes.getDimensionPixelSize(10, this.aDH);
        this.aDN = obtainStyledAttributes.getResourceId(11, 0);
        this.aDO = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aDC = f2;
    }

    private void init() {
        aDw = getContext().getResources().getDimensionPixelSize(n.d.adk_default_image_height);
        l lVar = null;
        if (getContext() instanceof l) {
            lVar = (l) getContext();
        } else {
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
            if (C != null && (C.getOrignalPage() instanceof l)) {
                lVar = (l) C.getOrignalPage();
            }
        }
        if (lVar != null) {
            this.aDx = lVar.getImageViewPool();
            this.aDy = lVar.getTextViewPool();
            this.aDz = lVar.getVoiceViewPool();
            this.aDA = lVar.getTextVoiceViewPool();
            this.aDB = lVar.getGifViewPool();
            if (lVar.getListView() != null && this.aDQ == null) {
                this.aDQ = new f(lVar.getRichTextViewId());
                lVar.getListView().setRecyclerListener(this.aDQ);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new r(this));
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x001c */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> FL;
        int i;
        boolean z2;
        SpannableStringBuilder FR;
        View a2;
        if (this.aEa != aVar) {
            this.aEa = aVar;
            removeAllViews();
            if (aVar != null && (FL = aVar.FL()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = FL.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ap = ap(getContext());
                            boolean a3 = a(next, ap, true);
                            if (z && !this.aDY && (FR = next.FR()) != null) {
                                this.aDY = FR.length() >= 200;
                            }
                            i = i2;
                            view2 = ap;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView ao = ao(getContext());
                                z2 = b(next, ao, (this.aDJ - getPaddingLeft()) - getPaddingRight(), this.aDK);
                                i = i2 + 1;
                                view2 = ao;
                            }
                        } else if (next.getType() == 32) {
                            m FU = next.FU();
                            if (FU != null && FU.Gm()) {
                                a2 = b(FU);
                            } else {
                                a2 = a(next);
                            }
                            z2 = true;
                            view2 = a2;
                            i = i2;
                        } else if (next.getType() == 512) {
                            view2 = getVoiceView();
                            if (view2 != null) {
                                z2 = a(next, view2);
                                i = i2;
                                view2 = view2;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            view2 = textVoiceView;
                            z2 = a(next, (LinearLayout) textVoiceView);
                            i = i2;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            view2 = gifView;
                            z2 = a(next, gifView);
                            i = i2;
                        } else if (next.getType() == 1280) {
                            ImageView ao2 = ao(getContext());
                            z2 = a(next, ao2, (this.aDJ - getPaddingLeft()) - getPaddingRight(), this.aDK);
                            i = i2 + 1;
                            view2 = ao2;
                        } else {
                            z2 = false;
                            i = i2;
                            view2 = view2;
                        }
                        if (!z2 || view2 == null) {
                            i2 = i;
                        } else {
                            addView(view2);
                            i2 = i;
                            view = view2;
                        }
                    }
                }
                if (view != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.bottomMargin = this.aDE;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(m mVar) {
        if (mVar == null || !mVar.isAvaliable()) {
            return null;
        }
        ImageView hb = this.aDx.hb();
        if (hb instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) hb;
            foreDrawableImageView.setForegroundDrawable(n.e.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(n.c.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m411getInst().getResources().getDimension(n.d.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            a(foreDrawableImageView, mVar.getWidth(), mVar.getHeight(), (this.aDJ - getPaddingLeft()) - getPaddingRight(), this.aDK, new s(this, mVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aEc);
            if (com.baidu.tbadk.core.m.rh().rn()) {
                foreDrawableImageView.setDefaultBgResource(n.e.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(n.c.cp_bg_line_c);
            }
            foreDrawableImageView.d(mVar.Gk(), 17, false);
            return hb;
        }
        return hb;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int[] b2 = com.baidu.adp.lib.util.k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        if (!this.aDT) {
            iArr[0] = i3;
            iArr[1] = aDw;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aDM);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aEd && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aDE;
                if (!this.aEd) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aDL == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aDL);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(onClickListener);
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aDE;
        if (!this.aEd) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aDN <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aDE;
        linearLayout.setClickable(true);
        Bitmap cE = as.cE(this.aDN);
        if (cE != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cE));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new t(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aDN;
    }

    public void setVideoImageId(int i) {
        this.aDN = i;
    }

    private ImageView ao(Context context) {
        ImageView hb = this.aDx != null ? this.aDx.hb() : null;
        if (hb == null || hb.getParent() != null) {
            return null;
        }
        return hb;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        k FX = cVar.FX();
        if (FX != null && FX.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aEc) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.d(FX.Gj(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(FX.getLink()));
                if (!FX.Gc()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, FX.getWidth(), FX.getHeight(), i, i2, this.aEf);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.f FQ = cVar.FQ();
        if (FQ == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aEc) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.d(FQ.Gb(), this.mIsFromCDN ? 17 : 18, false);
            if (!FQ.Gc()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, FQ.getWidth(), FQ.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aEd = z;
    }

    private TextView ap(Context context) {
        TextView textView = null;
        if (this.aDy != null) {
            textView = this.aDy.hb();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aDD, 0, this.aDD, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aDE;
        textView.setLineSpacing(0.0f, this.aDC);
        textView.setTextSize(0, this.aDF);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aDI);
        textView.setSingleLine(this.aDO);
        if (this.aDP != null) {
            textView.setEllipsize(this.aDP);
        }
        if (this.Bv > 0) {
            textView.setMaxWidth(this.Bv);
        }
        if (this.aEe > 0) {
            textView.setMaxLines(this.aEe);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder FR = cVar.FR();
        if (FR == null || FR.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aDH > 0 && this.aDG > 0) {
            cVar.P(this.aDG, this.aDH);
        }
        if (textSize > 0) {
            cVar.O(lineHeight, textSize);
        }
        try {
            textView.setText(FR);
        } catch (Exception e2) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.FT() != null) {
            cVar.FT().aDh = this.aEg;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aDB != null) {
            gifView = this.aDB.hb();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.FV().auv.atY || layoutParams.height != cVar.FV().auv.atZ) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.FV().auv.atY, cVar.FV().auv.atZ);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new u(this, cVar));
        gifView.a(cVar.FV().auv);
        return true;
    }

    private View getVoiceView() {
        View hb = this.aDz != null ? this.aDz.hb() : null;
        if ((hb == null || hb.getParent() != null) && this.aDU != -1) {
            hb = LayoutInflater.from(getContext()).inflate(this.aDU, (ViewGroup) null);
        }
        if (hb != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aDE;
            layoutParams.bottomMargin = this.aDE;
            hb.setLayoutParams(layoutParams);
            return hb;
        }
        return null;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.FS());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout hb = this.aDA.hb();
        if (hb != null) {
            TextView ap = ap(getContext());
            if (ap == null) {
                this.aDA.k(hb);
                return null;
            }
            hb.addView(ap);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aDy.k(ap);
                this.aDA.k(hb);
                return null;
            }
            hb.addView(voiceView);
            return hb;
        }
        return hb;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, LinearLayout linearLayout) {
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
                a2 = a(cVar, (TextView) childAt, false) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBnt") ? a(cVar, childAt) & z : z;
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
        if (applyDimension != this.aDF) {
            this.aDF = applyDimension;
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
        if (this.aDD != i) {
            this.aDD = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aDD, 0, 0, this.aDD);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aDI) {
            this.aDI = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    public int getMaxImageWidth() {
        return this.aDJ;
    }

    public void setMaxImageWidth(int i) {
        this.aDJ = i;
    }

    public int getMaxImageHeight() {
        return this.aDK;
    }

    public void setMaxImageHeight(int i) {
        this.aDK = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aDL;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aDL = scaleType;
    }

    public int getDefaultImageId() {
        return this.aDM;
    }

    public void setDefaultImageId(int i) {
        this.aDM = i;
    }

    public d getOnImageClickListener() {
        return this.aDR;
    }

    public void setOnImageClickListener(d dVar) {
        this.aDR = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aDZ = cVar;
    }

    public void f(boolean z, boolean z2) {
        if (this.aDT != z) {
            this.aDT = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aDT && this.aDx != null) {
                this.aDx.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f implements AbsListView.RecyclerListener {
        private int mId;

        public f(int i) {
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
        this.aDV = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aDW) {
                    Gq();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aDV) {
                    Gp();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aDV = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Gp() {
        this.aDW = false;
        if (this.aDX == null) {
            this.aDX = new a();
        }
        postDelayed(this.aDX, ViewConfiguration.getLongPressTimeout());
    }

    private void Gq() {
        if (this.aDX != null) {
            removeCallbacks(this.aDX);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aDW = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aDU = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aEb = null;
        if (this.aEh != drawable) {
            this.aEg = true;
            this.aEh = drawable;
        }
        setText(this.aEa);
        this.aEg = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CU();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CU();
        } else {
            refresh();
        }
    }

    public void gh(String str) {
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
        if (!(str.equals(this.mUrl) && this.aux == bdUniqueId)) {
            CU();
        }
        this.mUrl = str;
        this.aux = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.hd().X(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, 19, this.aAj, 0, 0, this.aux, new Object[0]);
        }
    }

    public void CU() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, 19, this.aAj);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.ng(), aVar.ng().getNinePatchChunk(), aVar.nk(), null);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        gh(this.mUrl);
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

    public e getOnLinkImageClickListener() {
        return this.aDS;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aDS = eVar;
    }
}
