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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int aBE = 174;
    private int Bp;
    private com.baidu.adp.lib.e.b<ImageView> aBF;
    private com.baidu.adp.lib.e.b<TextView> aBG;
    private com.baidu.adp.lib.e.b<View> aBH;
    private com.baidu.adp.lib.e.b<LinearLayout> aBI;
    private com.baidu.adp.lib.e.b<GifView> aBJ;
    private float aBK;
    private int aBL;
    private int aBM;
    private float aBN;
    private int aBO;
    private int aBP;
    private int aBQ;
    private int aBR;
    private int aBS;
    private ImageView.ScaleType aBT;
    private int aBU;
    private int aBV;
    private boolean aBW;
    private d aBX;
    private c aBY;
    private boolean aBZ;
    private int aCa;
    private boolean aCb;
    private boolean aCc;
    private Runnable aCd;
    private boolean aCe;
    private b aCf;
    private com.baidu.tbadk.widget.richText.a aCg;
    private String aCh;
    private boolean aCi;
    private boolean aCj;
    private int aCk;
    private boolean aCl;
    private Drawable aCm;
    private BdUniqueId atz;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> ayW;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, String str, int i);
    }

    public boolean Fr() {
        return this.aCe;
    }

    public void Fs() {
        this.aCi = true;
    }

    public String getBackgroundImageUrl() {
        return this.aCh;
    }

    public void setBackgroundImageUrl(String str) {
        this.aCh = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bp = i;
    }

    public void setMaxLines(int i) {
        this.aCk = i;
    }

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, int i) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, i);
    }

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new m(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aBF = null;
        this.aBG = null;
        this.aBH = null;
        this.aBI = null;
        this.aBJ = null;
        this.aBK = 0.0f;
        this.aBL = 0;
        this.aBM = 0;
        this.aBN = 15.0f;
        this.aBO = -1;
        this.aBP = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aBQ = -9989158;
        this.aBR = 200;
        this.aBS = 200;
        this.aBT = null;
        this.aBU = 0;
        this.aBV = 0;
        this.aBW = false;
        this.aBX = null;
        this.aBY = null;
        this.aBZ = true;
        this.mIsFromCDN = true;
        this.aCa = -1;
        this.aCb = false;
        this.aCc = false;
        this.aCd = null;
        this.aCe = false;
        this.aCh = null;
        this.aCi = false;
        this.Bp = -1;
        this.aCk = -1;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.ayW = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBF = null;
        this.aBG = null;
        this.aBH = null;
        this.aBI = null;
        this.aBJ = null;
        this.aBK = 0.0f;
        this.aBL = 0;
        this.aBM = 0;
        this.aBN = 15.0f;
        this.aBO = -1;
        this.aBP = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aBQ = -9989158;
        this.aBR = 200;
        this.aBS = 200;
        this.aBT = null;
        this.aBU = 0;
        this.aBV = 0;
        this.aBW = false;
        this.aBX = null;
        this.aBY = null;
        this.aBZ = true;
        this.mIsFromCDN = true;
        this.aCa = -1;
        this.aCb = false;
        this.aCc = false;
        this.aCd = null;
        this.aCe = false;
        this.aCh = null;
        this.aCi = false;
        this.Bp = -1;
        this.aCk = -1;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.ayW = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.k.TbRichTextView);
        this.aBM = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aBL = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aBK = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aBN = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aBN);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aBR = obtainStyledAttributes.getDimensionPixelSize(6, this.aBR);
        this.aBS = obtainStyledAttributes.getDimensionPixelSize(7, this.aBS);
        this.aBU = obtainStyledAttributes.getResourceId(8, 0);
        this.aBO = obtainStyledAttributes.getDimensionPixelSize(9, this.aBO);
        this.aBP = obtainStyledAttributes.getDimensionPixelSize(10, this.aBP);
        this.aBV = obtainStyledAttributes.getResourceId(11, 0);
        this.aBW = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f) {
        this.aBK = f;
    }

    private void init() {
        aBE = getContext().getResources().getDimensionPixelSize(i.d.adk_default_image_height);
        i iVar = null;
        if (getContext() instanceof i) {
            iVar = (i) getContext();
        } else {
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
            if (C != null && (C.getOrignalPage() instanceof i)) {
                iVar = (i) C.getOrignalPage();
            }
        }
        if (iVar != null) {
            this.aBF = iVar.getImageViewPool();
            this.aBG = iVar.getTextViewPool();
            this.aBH = iVar.getVoiceViewPool();
            this.aBI = iVar.getTextVoiceViewPool();
            this.aBJ = iVar.getGifViewPool();
            if (iVar.getListView() != null && this.aBX == null) {
                this.aBX = new d(iVar.getRichTextViewId());
                iVar.getListView().setRecyclerListener(this.aBX);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new n(this));
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x001c */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> EW;
        int i;
        boolean z2;
        SpannableStringBuilder Fc;
        View a2;
        if (this.aCg != aVar) {
            this.aCg = aVar;
            removeAllViews();
            if (aVar != null && (EW = aVar.EW()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = EW.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aq = aq(getContext());
                            boolean a3 = a(next, aq, true);
                            if (z && !this.aCe && (Fc = next.Fc()) != null) {
                                this.aCe = Fc.length() >= 200;
                            }
                            i = i2;
                            view2 = aq;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView ap = ap(getContext());
                                z2 = a(next, ap, (this.aBR - getPaddingLeft()) - getPaddingRight(), this.aBS);
                                i = i2 + 1;
                                view2 = ap;
                            }
                        } else if (next.getType() == 32) {
                            j Ff = next.Ff();
                            if (Ff != null && Ff.Fq()) {
                                a2 = b(Ff);
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
                    layoutParams.bottomMargin = this.aBM;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(j jVar) {
        if (jVar == null || !jVar.isAvaliable()) {
            return null;
        }
        LinearLayout ha = this.aBI.ha();
        if (ha != null) {
            ha.setOrientation(1);
            ImageView ha2 = this.aBF.ha();
            if (ha2 instanceof com.baidu.tbadk.widget.d) {
                com.baidu.tbadk.widget.d dVar = (com.baidu.tbadk.widget.d) ha2;
                dVar.setForegroundDrawable(i.e.icon_play_video);
                if (this.aCi) {
                    dVar.setSupportNoImage(true);
                }
                dVar.d(jVar.getThumbUrl(), 17, false);
                a(dVar, jVar.getWidth(), jVar.getHeight(), this.aBR, this.aBS);
                ha2.setOnClickListener(new o(this, jVar));
                ha.addView(dVar);
            }
            TextView ha3 = this.aBG.ha();
            if (ha3 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                ha3.setGravity(16);
                ha3.setCompoundDrawablePadding(getResources().getDimensionPixelSize(i.d.ds12));
                al.b(ha3, i.c.cp_link_tip_c, 1);
                ha3.setTextSize(0, getResources().getDimension(i.d.fontsize24));
                ha3.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.xiaoying_logo), (Drawable) null, (Drawable) null, (Drawable) null);
                ha3.setText(jVar.fF(getResources().getString(i.C0057i.come_from_xiaoying)));
                ha3.setLayoutParams(layoutParams);
                ha.addView(ha3);
                return ha;
            }
            return ha;
        }
        return ha;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ImageView imageView, int i, int i2, int i3, int i4) {
        int[] b2 = com.baidu.adp.lib.util.k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        if (!this.aBZ) {
            iArr[0] = i3;
            iArr[1] = aBE;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aBU);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aCj && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aBM;
                if (!this.aCj) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aBT == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aBT);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(this.mOnClickListener);
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aBM;
        if (!this.aCj) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.mOnClickListener);
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aBV <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aBM;
        linearLayout.setClickable(true);
        Bitmap cq = al.cq(this.aBV);
        if (cq != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cq));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new p(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aBV;
    }

    public void setVideoImageId(int i) {
        this.aBV = i;
    }

    private ImageView ap(Context context) {
        ImageView ha = this.aBF != null ? this.aBF.ha() : null;
        if (ha == null || ha.getParent() != null) {
            return null;
        }
        return ha;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        f Fb = cVar.Fb();
        if (Fb == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aCi) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.d(Fb.Fk(), this.mIsFromCDN ? 17 : 18, false);
            if (!Fb.Fl()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, Fb.getWidth(), Fb.getHeight(), i, i2);
    }

    public void setImageViewStretch(boolean z) {
        this.aCj = z;
    }

    private TextView aq(Context context) {
        TextView textView = null;
        if (this.aBG != null) {
            textView = this.aBG.ha();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aBL, 0, this.aBL, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aBM;
        textView.setLineSpacing(0.0f, this.aBK);
        textView.setTextSize(0, this.aBN);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aBQ);
        textView.setSingleLine(this.aBW);
        if (this.Bp > 0) {
            textView.setMaxWidth(this.Bp);
        }
        if (this.aCk > 0) {
            textView.setMaxLines(this.aCk);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder Fc = cVar.Fc();
        if (Fc == null || Fc.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aBP > 0 && this.aBO > 0) {
            cVar.O(this.aBO, this.aBP);
        }
        if (textSize > 0) {
            cVar.N(lineHeight, textSize);
        }
        try {
            textView.setText(Fc);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.Fe() != null) {
            cVar.Fe().aBu = this.aCl;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aBJ != null) {
            gifView = this.aBJ.ha();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.Fg().atx.atb || layoutParams.height != cVar.Fg().atx.atc) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Fg().atx.atb, cVar.Fg().atx.atc);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.Fg().atx);
        return true;
    }

    private View getVoiceView() {
        View ha = this.aBH != null ? this.aBH.ha() : null;
        if ((ha == null || ha.getParent() != null) && this.aCa != -1) {
            ha = LayoutInflater.from(getContext()).inflate(this.aCa, (ViewGroup) null);
        }
        if (ha != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aBM;
            layoutParams.bottomMargin = this.aBM;
            ha.setLayoutParams(layoutParams);
            return ha;
        }
        return null;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.Fd());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ha = this.aBI.ha();
        if (ha != null) {
            TextView aq = aq(getContext());
            if (aq == null) {
                this.aBI.k(ha);
                return null;
            }
            ha.addView(aq);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aBG.k(aq);
                this.aBI.k(ha);
                return null;
            }
            ha.addView(voiceView);
            return ha;
        }
        return ha;
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

    public void setTextSize(float f) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f, resources.getDisplayMetrics());
        if (applyDimension != this.aBN) {
            this.aBN = applyDimension;
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
        if (this.aBL != i) {
            this.aBL = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aBL, 0, 0, this.aBL);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aBQ) {
            this.aBQ = i;
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
        return this.aBR;
    }

    public void setMaxImageWidth(int i) {
        this.aBR = i;
    }

    public int getMaxImageHeight() {
        return this.aBS;
    }

    public void setMaxImageHeight(int i) {
        this.aBS = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aBT;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aBT = scaleType;
    }

    public int getDefaultImageId() {
        return this.aBU;
    }

    public void setDefaultImageId(int i) {
        this.aBU = i;
    }

    public c getOnImageClickListener() {
        return this.aBY;
    }

    public void setOnImageClickListener(c cVar) {
        this.aBY = cVar;
    }

    public void setOnEmotionClickListener(b bVar) {
        this.aCf = bVar;
    }

    public void f(boolean z, boolean z2) {
        if (this.aBZ != z) {
            this.aBZ = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aBZ && this.aBF != null) {
                this.aBF.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements AbsListView.RecyclerListener {
        private int mId;

        public d(int i) {
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
        this.aCb = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aCc) {
                    Fu();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aCb) {
                    Ft();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aCb = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Ft() {
        this.aCc = false;
        if (this.aCd == null) {
            this.aCd = new a();
        }
        postDelayed(this.aCd, ViewConfiguration.getLongPressTimeout());
    }

    private void Fu() {
        if (this.aCd != null) {
            removeCallbacks(this.aCd);
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
                TbRichTextView.this.aCc = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aCa = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aCh = null;
        if (this.aCm != drawable) {
            this.aCl = true;
            this.aCm = drawable;
        }
        setText(this.aCg);
        this.aCl = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Cb();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Cb();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Cb();
        } else {
            refresh();
        }
    }

    public void fG(String str) {
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
        if (!(str.equals(this.mUrl) && this.atz == bdUniqueId)) {
            Cb();
        }
        this.mUrl = str;
        this.atz = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hc().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.hc().W(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.hc().a(this.mUrl, 19, this.ayW, 0, 0, this.atz, new Object[0]);
        }
    }

    public void Cb() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.hc().a(this.mUrl, 19, this.ayW);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.nc(), aVar.nc().getNinePatchChunk(), aVar.ng(), null);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        fG(this.mUrl);
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
}
