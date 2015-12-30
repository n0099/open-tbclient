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
    static int aEV = 174;
    private int Bx;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBQ;
    private com.baidu.adp.lib.f.b<ImageView> aEW;
    private com.baidu.adp.lib.f.b<TextView> aEX;
    private com.baidu.adp.lib.f.b<View> aEY;
    private com.baidu.adp.lib.f.b<LinearLayout> aEZ;
    private String aFA;
    private boolean aFB;
    private boolean aFC;
    private int aFD;
    private boolean aFE;
    public final View.OnClickListener aFF;
    private boolean aFG;
    private Drawable aFH;
    private com.baidu.adp.lib.f.b<GifView> aFa;
    private float aFb;
    private int aFc;
    private int aFd;
    private float aFe;
    private int aFf;
    private int aFg;
    private int aFh;
    private int aFi;
    private int aFj;
    private ImageView.ScaleType aFk;
    private int aFl;
    private int aFm;
    private boolean aFn;
    private TextUtils.TruncateAt aFo;
    private f aFp;
    private d aFq;
    private e aFr;
    private boolean aFs;
    private int aFt;
    private boolean aFu;
    private boolean aFv;
    private Runnable aFw;
    private boolean aFx;
    private c aFy;
    private com.baidu.tbadk.widget.richText.a aFz;
    private BdUniqueId awb;
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

    public boolean Gc() {
        return this.aFx;
    }

    public void Gd() {
        this.aFB = true;
    }

    public String getBackgroundImageUrl() {
        return this.aFA;
    }

    public void setBackgroundImageUrl(String str) {
        this.aFA = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bx = i;
    }

    public void setMaxLines(int i) {
        this.aFD = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aFo = truncateAt;
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
    public boolean x(View view) {
        if ((view instanceof ImageView) && !(view instanceof GifView)) {
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof b) {
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

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.f.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new q(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aEW = null;
        this.aEX = null;
        this.aEY = null;
        this.aEZ = null;
        this.aFa = null;
        this.aFb = 0.0f;
        this.aFc = 0;
        this.aFd = 0;
        this.aFe = 15.0f;
        this.aFf = -1;
        this.aFg = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aFh = -9989158;
        this.aFi = 200;
        this.aFj = 200;
        this.aFk = null;
        this.aFl = 0;
        this.aFm = 0;
        this.aFn = false;
        this.aFo = null;
        this.aFp = null;
        this.aFq = null;
        this.aFr = null;
        this.aFs = true;
        this.mIsFromCDN = true;
        this.aFt = -1;
        this.aFu = false;
        this.aFv = false;
        this.aFw = null;
        this.aFx = false;
        this.aFA = null;
        this.aFB = false;
        this.Bx = -1;
        this.aFD = -1;
        this.aFE = true;
        this.mOnClickListener = new n(this);
        this.aFF = new o(this);
        this.mType = 19;
        this.aBQ = new p(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEW = null;
        this.aEX = null;
        this.aEY = null;
        this.aEZ = null;
        this.aFa = null;
        this.aFb = 0.0f;
        this.aFc = 0;
        this.aFd = 0;
        this.aFe = 15.0f;
        this.aFf = -1;
        this.aFg = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aFh = -9989158;
        this.aFi = 200;
        this.aFj = 200;
        this.aFk = null;
        this.aFl = 0;
        this.aFm = 0;
        this.aFn = false;
        this.aFo = null;
        this.aFp = null;
        this.aFq = null;
        this.aFr = null;
        this.aFs = true;
        this.mIsFromCDN = true;
        this.aFt = -1;
        this.aFu = false;
        this.aFv = false;
        this.aFw = null;
        this.aFx = false;
        this.aFA = null;
        this.aFB = false;
        this.Bx = -1;
        this.aFD = -1;
        this.aFE = true;
        this.mOnClickListener = new n(this);
        this.aFF = new o(this);
        this.mType = 19;
        this.aBQ = new p(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.l.TbRichTextView);
        this.aFd = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aFc = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aFb = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aFe = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aFe);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aFi = obtainStyledAttributes.getDimensionPixelSize(6, this.aFi);
        this.aFj = obtainStyledAttributes.getDimensionPixelSize(7, this.aFj);
        this.aFl = obtainStyledAttributes.getResourceId(8, 0);
        this.aFf = obtainStyledAttributes.getDimensionPixelSize(9, this.aFf);
        this.aFg = obtainStyledAttributes.getDimensionPixelSize(10, this.aFg);
        this.aFm = obtainStyledAttributes.getResourceId(11, 0);
        this.aFn = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aFb = f2;
    }

    private void init() {
        aEV = getContext().getResources().getDimensionPixelSize(n.e.adk_default_image_height);
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
            this.aEW = lVar.getImageViewPool();
            this.aEX = lVar.getTextViewPool();
            this.aEY = lVar.getVoiceViewPool();
            this.aEZ = lVar.getTextVoiceViewPool();
            this.aFa = lVar.getGifViewPool();
            if (lVar.getListView() != null && this.aFp == null) {
                this.aFp = new f(lVar.getRichTextViewId());
                lVar.getListView().setRecyclerListener(this.aFp);
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
        ArrayList<com.baidu.tbadk.widget.richText.c> FA;
        int i;
        boolean z2;
        SpannableStringBuilder FG;
        View a2;
        if (this.aFz != aVar) {
            this.aFz = aVar;
            removeAllViews();
            if (aVar != null && (FA = aVar.FA()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = FA.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ap = ap(getContext());
                            boolean a3 = a(next, ap, true);
                            if (z && !this.aFx && (FG = next.FG()) != null) {
                                this.aFx = FG.length() >= 200;
                            }
                            i = i2;
                            view2 = ap;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView ao = ao(getContext());
                                z2 = b(next, ao, (this.aFi - getPaddingLeft()) - getPaddingRight(), this.aFj);
                                i = i2 + 1;
                                view2 = ao;
                            }
                        } else if (next.getType() == 32) {
                            m FJ = next.FJ();
                            if (FJ != null && FJ.Gb()) {
                                a2 = b(FJ);
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
                            z2 = a(next, ao2, (this.aFi - getPaddingLeft()) - getPaddingRight(), this.aFj);
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
                    layoutParams.bottomMargin = this.aFd;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(m mVar) {
        if (mVar == null || !mVar.isAvaliable()) {
            return null;
        }
        ImageView hb = this.aEW.hb();
        if (hb instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) hb;
            foreDrawableImageView.setForegroundDrawable(n.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(n.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m411getInst().getResources().getDimension(n.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, mVar.getWidth(), mVar.getHeight(), (this.aFi - getPaddingLeft()) - getPaddingRight(), this.aFj, new s(this, mVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aFB);
            if (com.baidu.tbadk.core.m.qQ().qW()) {
                foreDrawableImageView.setDefaultBgResource(n.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(n.d.cp_bg_line_c);
            }
            foreDrawableImageView.d(mVar.FZ(), 17, false);
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
        if (!this.aFs) {
            iArr[0] = i3;
            iArr[1] = aEV;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aFl);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aFC && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aFd;
                if (!this.aFC) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aFk == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aFk);
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
        layoutParams2.topMargin = this.aFd;
        if (!this.aFC) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aFm <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aFd;
        linearLayout.setClickable(true);
        Bitmap cx = as.cx(this.aFm);
        if (cx != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cx));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new t(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aFm;
    }

    public void setVideoImageId(int i) {
        this.aFm = i;
    }

    private ImageView ao(Context context) {
        ImageView hb = this.aEW != null ? this.aEW.hb() : null;
        if (hb == null || hb.getParent() != null) {
            return null;
        }
        return hb;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        k FM = cVar.FM();
        if (FM != null && FM.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aFB) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.d(FM.FY(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(FM.getLink()));
                if (!FM.FR()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, FM.getWidth(), FM.getHeight(), i, i2, this.aFF);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.f FF = cVar.FF();
        if (FF == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aFB) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.d(FF.FQ(), this.mIsFromCDN ? 17 : 18, false);
            if (!FF.FR()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, FF.getWidth(), FF.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aFC = z;
    }

    private TextView ap(Context context) {
        TextView textView = null;
        if (this.aEX != null) {
            textView = this.aEX.hb();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aFc, 0, this.aFc, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aFd;
        textView.setLineSpacing(0.0f, this.aFb);
        textView.setTextSize(0, this.aFe);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aFh);
        textView.setSingleLine(this.aFn);
        if (this.aFo != null) {
            textView.setEllipsize(this.aFo);
        }
        if (this.Bx > 0) {
            textView.setMaxWidth(this.Bx);
        }
        if (this.aFD > 0) {
            textView.setMaxLines(this.aFD);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder FG = cVar.FG();
        if (FG == null || FG.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aFg > 0 && this.aFf > 0) {
            cVar.P(this.aFf, this.aFg);
        }
        if (textSize > 0) {
            cVar.O(lineHeight, textSize);
        }
        try {
            textView.setText(FG);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aFE) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.FI() != null) {
            cVar.FI().aEG = this.aFG;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aFa != null) {
            gifView = this.aFa.hb();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.FK().avZ.avC || layoutParams.height != cVar.FK().avZ.avD) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.FK().avZ.avC, cVar.FK().avZ.avD);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new u(this, cVar));
        gifView.a(cVar.FK().avZ);
        return true;
    }

    private View getVoiceView() {
        View hb = this.aEY != null ? this.aEY.hb() : null;
        if ((hb == null || hb.getParent() != null) && this.aFt != -1) {
            hb = LayoutInflater.from(getContext()).inflate(this.aFt, (ViewGroup) null);
        }
        if (hb != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aFd;
            layoutParams.bottomMargin = this.aFd;
            hb.setLayoutParams(layoutParams);
            return hb;
        }
        return null;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.FH());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout hb = this.aEZ.hb();
        if (hb != null) {
            TextView ap = ap(getContext());
            if (ap == null) {
                this.aEZ.k(hb);
                return null;
            }
            hb.addView(ap);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aEX.k(ap);
                this.aEZ.k(hb);
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
        if (applyDimension != this.aFe) {
            this.aFe = applyDimension;
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
        if (this.aFc != i) {
            this.aFc = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aFc, 0, 0, this.aFc);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aFh) {
            this.aFh = i;
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
        return this.aFi;
    }

    public void setMaxImageWidth(int i) {
        this.aFi = i;
    }

    public int getMaxImageHeight() {
        return this.aFj;
    }

    public void setMaxImageHeight(int i) {
        this.aFj = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aFk;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aFk = scaleType;
    }

    public int getDefaultImageId() {
        return this.aFl;
    }

    public void setDefaultImageId(int i) {
        this.aFl = i;
    }

    public d getOnImageClickListener() {
        return this.aFq;
    }

    public void setOnImageClickListener(d dVar) {
        this.aFq = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aFy = cVar;
    }

    public void g(boolean z, boolean z2) {
        if (this.aFs != z) {
            this.aFs = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aFs && this.aEW != null) {
                this.aEW.clear();
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
        this.aFu = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aFv) {
                    Gf();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aFu) {
                    Ge();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aFu = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Ge() {
        this.aFv = false;
        if (this.aFw == null) {
            this.aFw = new a();
        }
        postDelayed(this.aFw, ViewConfiguration.getLongPressTimeout());
    }

    private void Gf() {
        if (this.aFw != null) {
            removeCallbacks(this.aFw);
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
                TbRichTextView.this.aFv = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aFt = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aFA = null;
        if (this.aFH != drawable) {
            this.aFG = true;
            this.aFH = drawable;
        }
        setText(this.aFz);
        this.aFG = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CJ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CJ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CJ();
        } else {
            refresh();
        }
    }

    public void gl(String str) {
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
        if (!(str.equals(this.mUrl) && this.awb == bdUniqueId)) {
            CJ();
        }
        this.mUrl = str;
        this.awb = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.hd().X(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, 19, this.aBQ, 0, 0, this.awb, new Object[0]);
        }
    }

    public void CJ() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, 19, this.aBQ);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.mE(), aVar.mE().getNinePatchChunk(), aVar.mI(), null);
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
        gl(this.mUrl);
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
        return this.aFr;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aFr = eVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aFE = z;
    }
}
