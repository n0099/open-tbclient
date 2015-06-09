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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int aup = 174;
    private BdUniqueId alV;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> arO;
    private int auA;
    private int auB;
    private int auC;
    private int auD;
    private ImageView.ScaleType auE;
    private int auF;
    private int auG;
    private boolean auH;
    private t auI;
    private s auJ;
    private boolean auK;
    private int auL;
    private boolean auM;
    private boolean auN;
    private Runnable auO;
    private boolean auP;
    private r auQ;
    private a auR;
    private String auS;
    private boolean auT;
    private boolean auU;
    private boolean auV;
    private Drawable auW;
    private com.baidu.adp.lib.e.b<ImageView> auq;
    private com.baidu.adp.lib.e.b<TextView> aur;
    private com.baidu.adp.lib.e.b<View> aus;
    private com.baidu.adp.lib.e.b<LinearLayout> aut;
    private com.baidu.adp.lib.e.b<GifView> auu;
    private float auv;
    private int auw;
    private int aux;
    private float auy;
    private int auz;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    public boolean EC() {
        return this.auP;
    }

    public void ED() {
        this.auT = true;
    }

    public String getBackgroundImageUrl() {
        return this.auS;
    }

    public void setBackgroundImageUrl(String str) {
        this.auS = str;
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
        this.auq = null;
        this.aur = null;
        this.aus = null;
        this.aut = null;
        this.auu = null;
        this.auv = 0.0f;
        this.auw = 0;
        this.aux = 0;
        this.auy = 15.0f;
        this.auz = -1;
        this.auA = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.auB = -9989158;
        this.auC = 200;
        this.auD = 200;
        this.auE = null;
        this.auF = 0;
        this.auG = 0;
        this.auH = false;
        this.auI = null;
        this.auJ = null;
        this.auK = true;
        this.mIsFromCDN = true;
        this.auL = -1;
        this.auM = false;
        this.auN = false;
        this.auO = null;
        this.auP = false;
        this.auS = null;
        this.auT = false;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.arO = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auq = null;
        this.aur = null;
        this.aus = null;
        this.aut = null;
        this.auu = null;
        this.auv = 0.0f;
        this.auw = 0;
        this.aux = 0;
        this.auy = 15.0f;
        this.auz = -1;
        this.auA = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.auB = -9989158;
        this.auC = 200;
        this.auD = 200;
        this.auE = null;
        this.auF = 0;
        this.auG = 0;
        this.auH = false;
        this.auI = null;
        this.auJ = null;
        this.auK = true;
        this.mIsFromCDN = true;
        this.auL = -1;
        this.auM = false;
        this.auN = false;
        this.auO = null;
        this.auP = false;
        this.auS = null;
        this.auT = false;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.arO = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.TbRichTextView);
        this.aux = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.auw = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.auv = obtainStyledAttributes.getFloat(5, 1.2f);
        this.auy = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.auy);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.auC = obtainStyledAttributes.getDimensionPixelSize(6, this.auC);
        this.auD = obtainStyledAttributes.getDimensionPixelSize(7, this.auD);
        this.auF = obtainStyledAttributes.getResourceId(8, 0);
        this.auz = obtainStyledAttributes.getDimensionPixelSize(9, this.auz);
        this.auA = obtainStyledAttributes.getDimensionPixelSize(10, this.auA);
        this.auG = obtainStyledAttributes.getResourceId(11, 0);
        this.auH = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f) {
        this.auv = f;
    }

    private void init() {
        aup = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.adk_default_image_height);
        j jVar = null;
        if (getContext() instanceof j) {
            jVar = (j) getContext();
        } else {
            com.baidu.adp.base.j<?> D = com.baidu.adp.base.n.D(getContext());
            if (D != null && (D.getOrignalPage() instanceof j)) {
                jVar = (j) D.getOrignalPage();
            }
        }
        if (jVar != null) {
            this.auq = jVar.getImageViewPool();
            this.aur = jVar.getTextViewPool();
            this.aus = jVar.getVoiceViewPool();
            this.aut = jVar.getTextVoiceViewPool();
            this.auu = jVar.getGifViewPool();
            if (jVar.getListView() != null && this.auI == null) {
                this.auI = new t(jVar.getRichTextViewId());
                jVar.getListView().setRecyclerListener(this.auI);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new n(this));
    }

    public void setText(a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x001c */
    public void a(a aVar, boolean z) {
        ArrayList<c> Em;
        int i;
        boolean z2;
        SpannableStringBuilder Es;
        if (this.auR != aVar) {
            this.auR = aVar;
            removeAllViews();
            if (aVar != null && (Em = aVar.Em()) != null) {
                Iterator<c> it = Em.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ap = ap(getContext());
                            boolean a = a(next, ap, true);
                            if (z && !this.auP && (Es = next.Es()) != null) {
                                this.auP = Es.length() >= 200;
                            }
                            i = i2;
                            view2 = ap;
                            z2 = a;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView ao = ao(getContext());
                                z2 = a(next, ao, (this.auC - getPaddingLeft()) - getPaddingRight(), this.auD);
                                i = i2 + 1;
                                view2 = ao;
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
                    layoutParams.bottomMargin = this.aux;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.auG <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aux;
        linearLayout.setClickable(true);
        Bitmap ck = ay.ck(this.auG);
        if (ck != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), ck));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.auG;
    }

    public void setVideoImageId(int i) {
        this.auG = i;
    }

    private ImageView ao(Context context) {
        ImageView hj = this.auq != null ? this.auq.hj() : null;
        if (hj == null || hj.getParent() != null) {
            return null;
        }
        return hj;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        g Er;
        if (cVar == null || imageView == null || (Er = cVar.Er()) == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.auT) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(Er.Ez(), this.mIsFromCDN ? 17 : 18, false);
            if (!Er.EA()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        int[] b = com.baidu.adp.lib.util.n.b(Er.getWidth(), Er.getHeight(), i, i2);
        if (b != null) {
            boolean z = !this.auK;
            int[] iArr = {b[0], b[1]};
            if (!this.auK && z) {
                iArr[0] = i;
                iArr[1] = aup;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView2 = (TbImageView) imageView;
                tbImageView2.setDefaultResource(this.auF);
                if (tbImageView2.getGifIconWidth() >= iArr[0] || tbImageView2.getGifIconHeight() >= iArr[1]) {
                    tbImageView2.setGifIconSupport(false);
                } else {
                    tbImageView2.setGifIconSupport(true);
                }
            }
            int i3 = iArr[0];
            int i4 = iArr[1];
            if (this.auU && i > i3) {
                float O = com.baidu.adp.lib.util.n.O(getContext());
                if (O > 1.0f) {
                    if (i3 * O <= i) {
                        i = (int) (i3 * O);
                    }
                    if (iArr[0] > 0) {
                        i4 = (iArr[1] * i) / iArr[0];
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i4);
                    layoutParams.topMargin = this.aux;
                    if (!this.auU) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else if (this.auE == null) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    } else {
                        imageView.setScaleType(this.auE);
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
            layoutParams2.topMargin = this.aux;
            if (!this.auU) {
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
        this.auU = z;
    }

    private TextView ap(Context context) {
        TextView textView = null;
        if (this.aur != null) {
            textView = this.aur.hj();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.o(context);
        }
        textView.setPadding(this.auw, 0, this.auw, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        CharSequence Es;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aux;
        textView.setLineSpacing(0.0f, this.auv);
        textView.setTextSize(0, this.auy);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.auB);
        textView.setSingleLine(this.auH);
        if (cVar == null || (Es = cVar.Es()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.auA > 0 && this.auz > 0) {
            cVar.E(this.auz, this.auA);
        }
        if (textSize > 0) {
            cVar.D(lineHeight, textSize);
        }
        try {
            textView.setText(Es);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.Eu() != null) {
            cVar.Eu().aug = this.auV;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.auu != null) {
            gifView = this.auu.hj();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.Ev().alT.alx || layoutParams.height != cVar.Ev().alT.aly) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Ev().alT.alx, cVar.Ev().alT.aly);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.Ev().alT);
        return true;
    }

    private View getVoiceView() {
        View hj = this.aus != null ? this.aus.hj() : null;
        if ((hj == null || hj.getParent() != null) && this.auL != -1) {
            hj = com.baidu.adp.lib.g.b.hr().inflate(getContext(), this.auL, null);
        }
        if (hj != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aux;
            layoutParams.bottomMargin = this.aux;
            hj.setLayoutParams(layoutParams);
            return hj;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.Et());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout hj = this.aut.hj();
        if (hj != null) {
            TextView ap = ap(getContext());
            if (ap == null) {
                this.aut.j(hj);
                return null;
            }
            hj.addView(ap);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aur.j(ap);
                this.aut.j(hj);
                return null;
            }
            hj.addView(voiceView);
            return hj;
        }
        return hj;
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
        if (applyDimension != this.auy) {
            this.auy = applyDimension;
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
        if (this.auw != i) {
            this.auw = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.auw, 0, 0, this.auw);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.auB) {
            this.auB = i;
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
        return this.auC;
    }

    public void setMaxImageWidth(int i) {
        this.auC = i;
    }

    public int getMaxImageHeight() {
        return this.auD;
    }

    public void setMaxImageHeight(int i) {
        this.auD = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.auE;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.auE = scaleType;
    }

    public int getDefaultImageId() {
        return this.auF;
    }

    public void setDefaultImageId(int i) {
        this.auF = i;
    }

    public s getOnImageClickListener() {
        return this.auJ;
    }

    public void setOnImageClickListener(s sVar) {
        this.auJ = sVar;
    }

    public void setOnEmotionClickListener(r rVar) {
        this.auQ = rVar;
    }

    public void c(boolean z, boolean z2) {
        if (this.auK != z) {
            this.auK = z;
            if (z2) {
                requestLayout();
            }
            if (!this.auK && this.auq != null) {
                this.auq.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.auM = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.auN) {
                    EF();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.auM) {
                    EE();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.auM = true;
        return super.onTouchEvent(motionEvent);
    }

    private void EE() {
        this.auN = false;
        if (this.auO == null) {
            this.auO = new q(this);
        }
        postDelayed(this.auO, ViewConfiguration.getLongPressTimeout());
    }

    private void EF() {
        if (this.auO != null) {
            removeCallbacks(this.auO);
        }
    }

    public void setVoiceViewRes(int i) {
        this.auL = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.auS = null;
        if (this.auW != drawable) {
            this.auV = true;
            this.auW = drawable;
        }
        setText(this.auR);
        this.auV = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ak();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Ak();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Ak();
        } else {
            refresh();
        }
    }

    public void fm(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.m B = com.baidu.adp.base.n.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.alV == bdUniqueId)) {
            Ak();
        }
        this.mUrl = str;
        this.alV = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hl().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.hl().V(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.d.hl().a(this.mUrl, 19, this.arO, 0, 0, this.alV, new Object[0]);
        }
    }

    public void Ak() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.hl().a(this.mUrl, 19, this.arO);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.mS(), aVar.mS().getNinePatchChunk(), aVar.mW(), null);
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
        fm(this.mUrl);
    }
}
