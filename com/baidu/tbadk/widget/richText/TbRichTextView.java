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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int akf = 174;
    private BdUniqueId aar;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> ajy;
    private boolean akA;
    private int akB;
    private boolean akC;
    private boolean akD;
    private Runnable akE;
    private boolean akF;
    private r akG;
    private a akH;
    private String akI;
    private boolean akJ;
    private boolean akK;
    private Drawable akL;
    private com.baidu.adp.lib.e.b<ImageView> akg;
    private com.baidu.adp.lib.e.b<TextView> akh;
    private com.baidu.adp.lib.e.b<View> aki;
    private com.baidu.adp.lib.e.b<LinearLayout> akj;
    private com.baidu.adp.lib.e.b<GifView> akk;
    private float akl;
    private int akm;
    private int akn;
    private float ako;
    private int akp;
    private int akq;
    private int akr;
    private int aks;
    private int akt;
    private ImageView.ScaleType aku;
    private int akv;
    private int akw;
    private boolean akx;
    private t aky;
    private s akz;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    public boolean Av() {
        return this.akF;
    }

    public String getBackgroundImageUrl() {
        return this.akI;
    }

    public void setBackgroundImageUrl(String str) {
        this.akI = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public static a a(Context context, JSONArray jSONArray, int i) {
        return new a(context, jSONArray, i);
    }

    public static a a(Context context, List<PbContent> list, boolean z) {
        return new a(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> h(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new m(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.akg = null;
        this.akh = null;
        this.aki = null;
        this.akj = null;
        this.akk = null;
        this.akl = 0.0f;
        this.akm = 0;
        this.akn = 0;
        this.ako = 15.0f;
        this.akp = -1;
        this.akq = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.akr = -9989158;
        this.aks = 200;
        this.akt = 200;
        this.aku = null;
        this.akv = 0;
        this.akw = 0;
        this.akx = false;
        this.aky = null;
        this.akz = null;
        this.akA = true;
        this.mIsFromCDN = true;
        this.akB = -1;
        this.akC = false;
        this.akD = false;
        this.akE = null;
        this.akF = false;
        this.akI = null;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.ajy = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akg = null;
        this.akh = null;
        this.aki = null;
        this.akj = null;
        this.akk = null;
        this.akl = 0.0f;
        this.akm = 0;
        this.akn = 0;
        this.ako = 15.0f;
        this.akp = -1;
        this.akq = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.akr = -9989158;
        this.aks = 200;
        this.akt = 200;
        this.aku = null;
        this.akv = 0;
        this.akw = 0;
        this.akx = false;
        this.aky = null;
        this.akz = null;
        this.akA = true;
        this.mIsFromCDN = true;
        this.akB = -1;
        this.akC = false;
        this.akD = false;
        this.akE = null;
        this.akF = false;
        this.akI = null;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.ajy = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ab.TbRichTextView);
        this.akn = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.akm = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.akl = obtainStyledAttributes.getFloat(5, 1.2f);
        this.ako = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.ako);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aks = obtainStyledAttributes.getDimensionPixelSize(6, this.aks);
        this.akt = obtainStyledAttributes.getDimensionPixelSize(7, this.akt);
        this.akv = obtainStyledAttributes.getResourceId(8, 0);
        this.akp = obtainStyledAttributes.getDimensionPixelSize(9, this.akp);
        this.akq = obtainStyledAttributes.getDimensionPixelSize(10, this.akq);
        this.akw = obtainStyledAttributes.getResourceId(11, 0);
        this.akx = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        akf = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.u.adk_default_image_height);
        j jVar = null;
        if (getContext() instanceof j) {
            jVar = (j) getContext();
        } else {
            com.baidu.adp.base.j<?> D = com.baidu.adp.base.m.D(getContext());
            if (D != null && (D.getOrignalPage() instanceof j)) {
                jVar = (j) D.getOrignalPage();
            }
        }
        if (jVar != null) {
            this.akg = jVar.getImageViewPool();
            this.akh = jVar.getTextViewPool();
            this.aki = jVar.getVoiceViewPool();
            this.akj = jVar.getTextVoiceViewPool();
            this.akk = jVar.getGifViewPool();
            if (jVar.getListView() != null && this.aky == null) {
                this.aky = new t(jVar.getRichTextViewId());
                jVar.getListView().setRecyclerListener(this.aky);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new n(this));
    }

    public void setText(a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0018 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0018 */
    public void a(a aVar, boolean z) {
        ArrayList<c> Af;
        int i;
        boolean z2;
        SpannableStringBuilder Al;
        this.akH = aVar;
        removeAllViews();
        if (aVar != null && (Af = aVar.Af()) != null) {
            Iterator<c> it = Af.iterator();
            int i2 = 0;
            View view = null;
            View view2 = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        TextView ah = ah(getContext());
                        boolean a = a(next, ah, true);
                        if (z && !this.akF && (Al = next.Al()) != null) {
                            this.akF = Al.length() >= 200;
                        }
                        i = i2;
                        view2 = ah;
                        z2 = a;
                    } else if (next.getType() == 8) {
                        if (i2 < 10) {
                            ImageView ag = ag(getContext());
                            z2 = a(next, ag, (this.aks - getPaddingLeft()) - getPaddingRight(), this.akt);
                            i = i2 + 1;
                            view2 = ag;
                        }
                    } else if (next.getType() == 32) {
                        LinearLayout a2 = a(next);
                        z2 = true;
                        i = i2;
                        view2 = a2;
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
                layoutParams.bottomMargin = this.akn;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.akw <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.akn;
        linearLayout.setClickable(true);
        Bitmap ce = bc.ce(this.akw);
        if (ce != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), ce));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.akw;
    }

    public void setVideoImageId(int i) {
        this.akw = i;
    }

    private ImageView ag(Context context) {
        ImageView ea = this.akg != null ? this.akg.ea() : null;
        if (ea == null || ea.getParent() != null) {
            return null;
        }
        return ea;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        g Ak;
        if (cVar == null || imageView == null || (Ak = cVar.Ak()) == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).d(Ak.As(), this.mIsFromCDN ? 17 : 18, false);
            if (!Ak.At()) {
                ((TbImageView) imageView).setAdjustViewBounds(false);
            }
        }
        int[] b = com.baidu.adp.lib.util.l.b(Ak.getWidth(), Ak.getHeight(), i, i2);
        if (b != null) {
            boolean z = !this.akA;
            int[] iArr = {b[0], b[1]};
            if (!this.akA && z) {
                iArr[0] = i;
                iArr[1] = akf;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.akv);
                if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setGifIconSupport(true);
                }
            }
            int i3 = iArr[0];
            int i4 = iArr[1];
            if (this.akJ && i > i3) {
                float O = com.baidu.adp.lib.util.l.O(getContext());
                if (O > 1.0f) {
                    if (i3 * O <= i) {
                        i = (int) (i3 * O);
                    }
                    if (iArr[0] > 0) {
                        i4 = (iArr[1] * i) / iArr[0];
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i4);
                    layoutParams.topMargin = this.akn;
                    if (!this.akJ) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else if (this.aku == null) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    } else {
                        imageView.setScaleType(this.aku);
                    }
                    imageView.setClickable(true);
                    imageView.setFocusable(false);
                    imageView.setOnClickListener(this.mOnClickListener);
                    imageView.setLayoutParams(layoutParams);
                    return true;
                }
            }
            i = i3;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i4);
            layoutParams2.topMargin = this.akn;
            if (!this.akJ) {
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            imageView.setOnClickListener(this.mOnClickListener);
            imageView.setLayoutParams(layoutParams2);
            return true;
        }
        return false;
    }

    public void setImageViewStretch(boolean z) {
        this.akJ = z;
    }

    private TextView ah(Context context) {
        TextView textView = null;
        if (this.akh != null) {
            textView = this.akh.ea();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.q(context);
        }
        textView.setPadding(this.akm, 0, this.akm, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        CharSequence Al;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.akn;
        textView.setLineSpacing(0.0f, this.akl);
        textView.setTextSize(0, this.ako);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.akr);
        textView.setSingleLine(this.akx);
        if (cVar == null || (Al = cVar.Al()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.akq > 0 && this.akp > 0) {
            cVar.F(this.akp, this.akq);
        }
        if (textSize > 0) {
            cVar.E(lineHeight, textSize);
        }
        try {
            textView.setText(Al);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.An() != null) {
            cVar.An().ajW = this.akK;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.akk != null) {
            gifView = this.akk.ea();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.Ao().aap.ZT || layoutParams.height != cVar.Ao().aap.ZU) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Ao().aap.ZT, cVar.Ao().aap.ZU);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.Ao().aap);
        return true;
    }

    private View getVoiceView() {
        View ea = this.aki != null ? this.aki.ea() : null;
        if ((ea == null || ea.getParent() != null) && this.akB != -1) {
            ea = com.baidu.adp.lib.g.b.ei().inflate(getContext(), this.akB, null);
        }
        if (ea != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.akn;
            layoutParams.bottomMargin = this.akn;
            ea.setLayoutParams(layoutParams);
            return ea;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.Am());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ea = this.akj.ea();
        if (ea != null) {
            TextView ah = ah(getContext());
            if (ah == null) {
                this.akj.j(ea);
                return null;
            }
            ea.addView(ah);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.akh.j(ah);
                this.akj.j(ea);
                return null;
            }
            ea.addView(voiceView);
            return ea;
        }
        return ea;
    }

    private boolean a(c cVar, LinearLayout linearLayout) {
        boolean a;
        boolean z = true;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt == null) {
                a = z;
            } else if (childAt instanceof TextView) {
                a = a(cVar, (TextView) childAt, false) & z;
            } else {
                a = childAt.getClass().getSimpleName().equals("PlayVoiceBnt") ? a(cVar, childAt) & z : z;
            }
            i++;
            z = a;
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
        if (applyDimension != this.ako) {
            this.ako = applyDimension;
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
        if (this.akm != i) {
            this.akm = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.akm, 0, 0, this.akm);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.akr) {
            this.akr = i;
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
        return this.aks;
    }

    public void setMaxImageWidth(int i) {
        this.aks = i;
    }

    public int getMaxImageHeight() {
        return this.akt;
    }

    public void setMaxImageHeight(int i) {
        this.akt = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aku;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aku = scaleType;
    }

    public int getDefaultImageId() {
        return this.akv;
    }

    public void setDefaultImageId(int i) {
        this.akv = i;
    }

    public s getOnImageClickListener() {
        return this.akz;
    }

    public void setOnImageClickListener(s sVar) {
        this.akz = sVar;
    }

    public void setOnEmotionClickListener(r rVar) {
        this.akG = rVar;
    }

    public void c(boolean z, boolean z2) {
        if (this.akA != z) {
            this.akA = z;
            if (z2) {
                requestLayout();
            }
            if (!this.akA && this.akg != null) {
                this.akg.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.akC = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.akD) {
                    Ax();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.akC) {
                    Aw();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.akC = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Aw() {
        this.akD = false;
        if (this.akE == null) {
            this.akE = new q(this);
        }
        postDelayed(this.akE, ViewConfiguration.getLongPressTimeout());
    }

    private void Ax() {
        if (this.akE != null) {
            removeCallbacks(this.akE);
        }
    }

    public void setVoiceViewRes(int i) {
        this.akB = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.akI = null;
        if (this.akL != drawable) {
            this.akK = true;
            this.akL = drawable;
        }
        setText(this.akH);
        this.akK = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vW();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        vW();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            vW();
        } else {
            refresh();
        }
    }

    public void eM(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.aar == bdUniqueId)) {
            vW();
        }
        this.mUrl = str;
        this.aar = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.ec().W(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.d.ec().a(this.mUrl, 19, this.ajy, 0, 0, this.aar, new Object[0]);
        }
    }

    public void vW() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.ec().a(this.mUrl, 19, this.ajy);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.jj(), aVar.jj().getNinePatchChunk(), aVar.jn(), null);
                if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        eM(this.mUrl);
    }
}
