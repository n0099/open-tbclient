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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int asJ = 174;
    private BdUniqueId akU;
    private com.baidu.adp.lib.e.b<ImageView> asK;
    private com.baidu.adp.lib.e.b<TextView> asL;
    private com.baidu.adp.lib.e.b<View> asM;
    private com.baidu.adp.lib.e.b<LinearLayout> asN;
    private com.baidu.adp.lib.e.b<GifView> asO;
    private float asP;
    private int asQ;
    private int asR;
    private float asS;
    private int asT;
    private int asU;
    private int asV;
    private int asW;
    private int asX;
    private ImageView.ScaleType asY;
    private int asZ;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> asc;
    private int ata;
    private boolean atb;
    private t atc;
    private s atd;
    private boolean ate;
    private int atf;
    private boolean atg;
    private boolean ath;
    private Runnable ati;
    private boolean atj;
    private r atk;
    private a atl;
    private String atm;
    private boolean atn;
    private boolean ato;
    private boolean atp;
    private Drawable atq;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    public boolean DR() {
        return this.atj;
    }

    public void DS() {
        this.atn = true;
    }

    public String getBackgroundImageUrl() {
        return this.atm;
    }

    public void setBackgroundImageUrl(String str) {
        this.atm = str;
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
        this.asK = null;
        this.asL = null;
        this.asM = null;
        this.asN = null;
        this.asO = null;
        this.asP = 0.0f;
        this.asQ = 0;
        this.asR = 0;
        this.asS = 15.0f;
        this.asT = -1;
        this.asU = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.asV = -9989158;
        this.asW = 200;
        this.asX = 200;
        this.asY = null;
        this.asZ = 0;
        this.ata = 0;
        this.atb = false;
        this.atc = null;
        this.atd = null;
        this.ate = true;
        this.mIsFromCDN = true;
        this.atf = -1;
        this.atg = false;
        this.ath = false;
        this.ati = null;
        this.atj = false;
        this.atm = null;
        this.atn = false;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.asc = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asK = null;
        this.asL = null;
        this.asM = null;
        this.asN = null;
        this.asO = null;
        this.asP = 0.0f;
        this.asQ = 0;
        this.asR = 0;
        this.asS = 15.0f;
        this.asT = -1;
        this.asU = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.asV = -9989158;
        this.asW = 200;
        this.asX = 200;
        this.asY = null;
        this.asZ = 0;
        this.ata = 0;
        this.atb = false;
        this.atc = null;
        this.atd = null;
        this.ate = true;
        this.mIsFromCDN = true;
        this.atf = -1;
        this.atg = false;
        this.ath = false;
        this.ati = null;
        this.atj = false;
        this.atm = null;
        this.atn = false;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.asc = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.TbRichTextView);
        this.asR = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.asQ = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.asP = obtainStyledAttributes.getFloat(5, 1.2f);
        this.asS = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.asS);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.asW = obtainStyledAttributes.getDimensionPixelSize(6, this.asW);
        this.asX = obtainStyledAttributes.getDimensionPixelSize(7, this.asX);
        this.asZ = obtainStyledAttributes.getResourceId(8, 0);
        this.asT = obtainStyledAttributes.getDimensionPixelSize(9, this.asT);
        this.asU = obtainStyledAttributes.getDimensionPixelSize(10, this.asU);
        this.ata = obtainStyledAttributes.getResourceId(11, 0);
        this.atb = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f) {
        this.asP = f;
    }

    private void init() {
        asJ = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.adk_default_image_height);
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
            this.asK = jVar.getImageViewPool();
            this.asL = jVar.getTextViewPool();
            this.asM = jVar.getVoiceViewPool();
            this.asN = jVar.getTextVoiceViewPool();
            this.asO = jVar.getGifViewPool();
            if (jVar.getListView() != null && this.atc == null) {
                this.atc = new t(jVar.getRichTextViewId());
                jVar.getListView().setRecyclerListener(this.atc);
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
        ArrayList<c> DB;
        int i;
        boolean z2;
        SpannableStringBuilder DH;
        this.atl = aVar;
        removeAllViews();
        if (aVar != null && (DB = aVar.DB()) != null) {
            Iterator<c> it = DB.iterator();
            int i2 = 0;
            View view = null;
            View view2 = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        TextView ak = ak(getContext());
                        boolean a = a(next, ak, true);
                        if (z && !this.atj && (DH = next.DH()) != null) {
                            this.atj = DH.length() >= 200;
                        }
                        i = i2;
                        view2 = ak;
                        z2 = a;
                    } else if (next.getType() == 8) {
                        if (i2 < 10) {
                            ImageView aj = aj(getContext());
                            z2 = a(next, aj, (this.asW - getPaddingLeft()) - getPaddingRight(), this.asX);
                            i = i2 + 1;
                            view2 = aj;
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
                layoutParams.bottomMargin = this.asR;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.ata <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.asR;
        linearLayout.setClickable(true);
        Bitmap cg = ba.cg(this.ata);
        if (cg != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cg));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.ata;
    }

    public void setVideoImageId(int i) {
        this.ata = i;
    }

    private ImageView aj(Context context) {
        ImageView hz = this.asK != null ? this.asK.hz() : null;
        if (hz == null || hz.getParent() != null) {
            return null;
        }
        return hz;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        g DG;
        if (cVar == null || imageView == null || (DG = cVar.DG()) == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.atn) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(DG.DO(), this.mIsFromCDN ? 17 : 18, false);
            if (!DG.DP()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        int[] b = com.baidu.adp.lib.util.n.b(DG.getWidth(), DG.getHeight(), i, i2);
        if (b != null) {
            boolean z = !this.ate;
            int[] iArr = {b[0], b[1]};
            if (!this.ate && z) {
                iArr[0] = i;
                iArr[1] = asJ;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView2 = (TbImageView) imageView;
                tbImageView2.setDefaultResource(this.asZ);
                if (tbImageView2.getGifIconWidth() >= iArr[0] || tbImageView2.getGifIconHeight() >= iArr[1]) {
                    tbImageView2.setGifIconSupport(false);
                } else {
                    tbImageView2.setGifIconSupport(true);
                }
            }
            int i3 = iArr[0];
            int i4 = iArr[1];
            if (this.ato && i > i3) {
                float O = com.baidu.adp.lib.util.n.O(getContext());
                if (O > 1.0f) {
                    if (i3 * O <= i) {
                        i = (int) (i3 * O);
                    }
                    if (iArr[0] > 0) {
                        i4 = (iArr[1] * i) / iArr[0];
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i4);
                    layoutParams.topMargin = this.asR;
                    if (!this.ato) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else if (this.asY == null) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    } else {
                        imageView.setScaleType(this.asY);
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
            layoutParams2.topMargin = this.asR;
            if (!this.ato) {
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
        this.ato = z;
    }

    private TextView ak(Context context) {
        TextView textView = null;
        if (this.asL != null) {
            textView = this.asL.hz();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.o(context);
        }
        textView.setPadding(this.asQ, 0, this.asQ, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        CharSequence DH;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.asR;
        textView.setLineSpacing(0.0f, this.asP);
        textView.setTextSize(0, this.asS);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.asV);
        textView.setSingleLine(this.atb);
        if (cVar == null || (DH = cVar.DH()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.asU > 0 && this.asT > 0) {
            cVar.D(this.asT, this.asU);
        }
        if (textSize > 0) {
            cVar.C(lineHeight, textSize);
        }
        try {
            textView.setText(DH);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.DJ() != null) {
            cVar.DJ().asA = this.atp;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.asO != null) {
            gifView = this.asO.hz();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.DK().akS.akw || layoutParams.height != cVar.DK().akS.akx) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.DK().akS.akw, cVar.DK().akS.akx);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.DK().akS);
        return true;
    }

    private View getVoiceView() {
        View hz = this.asM != null ? this.asM.hz() : null;
        if ((hz == null || hz.getParent() != null) && this.atf != -1) {
            hz = com.baidu.adp.lib.g.b.hH().inflate(getContext(), this.atf, null);
        }
        if (hz != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.asR;
            layoutParams.bottomMargin = this.asR;
            hz.setLayoutParams(layoutParams);
            return hz;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.DI());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout hz = this.asN.hz();
        if (hz != null) {
            TextView ak = ak(getContext());
            if (ak == null) {
                this.asN.j(hz);
                return null;
            }
            hz.addView(ak);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.asL.j(ak);
                this.asN.j(hz);
                return null;
            }
            hz.addView(voiceView);
            return hz;
        }
        return hz;
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
        if (applyDimension != this.asS) {
            this.asS = applyDimension;
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
        if (this.asQ != i) {
            this.asQ = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.asQ, 0, 0, this.asQ);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.asV) {
            this.asV = i;
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
        return this.asW;
    }

    public void setMaxImageWidth(int i) {
        this.asW = i;
    }

    public int getMaxImageHeight() {
        return this.asX;
    }

    public void setMaxImageHeight(int i) {
        this.asX = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.asY;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.asY = scaleType;
    }

    public int getDefaultImageId() {
        return this.asZ;
    }

    public void setDefaultImageId(int i) {
        this.asZ = i;
    }

    public s getOnImageClickListener() {
        return this.atd;
    }

    public void setOnImageClickListener(s sVar) {
        this.atd = sVar;
    }

    public void setOnEmotionClickListener(r rVar) {
        this.atk = rVar;
    }

    public void b(boolean z, boolean z2) {
        if (this.ate != z) {
            this.ate = z;
            if (z2) {
                requestLayout();
            }
            if (!this.ate && this.asK != null) {
                this.asK.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.atg = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.ath) {
                    DU();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.atg) {
                    DT();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.atg = true;
        return super.onTouchEvent(motionEvent);
    }

    private void DT() {
        this.ath = false;
        if (this.ati == null) {
            this.ati = new q(this);
        }
        postDelayed(this.ati, ViewConfiguration.getLongPressTimeout());
    }

    private void DU() {
        if (this.ati != null) {
            removeCallbacks(this.ati);
        }
    }

    public void setVoiceViewRes(int i) {
        this.atf = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.atm = null;
        if (this.atq != drawable) {
            this.atp = true;
            this.atq = drawable;
        }
        setText(this.atl);
        this.atp = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zw();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        zw();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            zw();
        } else {
            refresh();
        }
    }

    public void eR(String str) {
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
        if (!(str.equals(this.mUrl) && this.akU == bdUniqueId)) {
            zw();
        }
        this.mUrl = str;
        this.akU = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.hB().X(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, 19, this.asc, 0, 0, this.akU, new Object[0]);
        }
    }

    public void zw() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, 19, this.asc);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.mz(), aVar.mz().getNinePatchChunk(), aVar.mD(), null);
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
        eR(this.mUrl);
    }
}
