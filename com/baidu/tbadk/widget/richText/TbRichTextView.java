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
    static int asB = 174;
    private BdUniqueId akM;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> arU;
    private com.baidu.adp.lib.e.b<ImageView> asC;
    private com.baidu.adp.lib.e.b<TextView> asD;
    private com.baidu.adp.lib.e.b<View> asE;
    private com.baidu.adp.lib.e.b<LinearLayout> asF;
    private com.baidu.adp.lib.e.b<GifView> asG;
    private float asH;
    private int asI;
    private int asJ;
    private float asK;
    private int asL;
    private int asM;
    private int asN;
    private int asO;
    private int asP;
    private ImageView.ScaleType asQ;
    private int asR;
    private int asS;
    private boolean asT;
    private t asU;
    private s asV;
    private boolean asW;
    private int asX;
    private boolean asY;
    private boolean asZ;
    private Runnable ata;
    private boolean atb;
    private r atc;
    private a atd;
    private String ate;
    private boolean atf;
    private boolean atg;
    private boolean ath;
    private Drawable ati;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    public boolean DL() {
        return this.atb;
    }

    public void DM() {
        this.atf = true;
    }

    public String getBackgroundImageUrl() {
        return this.ate;
    }

    public void setBackgroundImageUrl(String str) {
        this.ate = str;
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
        this.asC = null;
        this.asD = null;
        this.asE = null;
        this.asF = null;
        this.asG = null;
        this.asH = 0.0f;
        this.asI = 0;
        this.asJ = 0;
        this.asK = 15.0f;
        this.asL = -1;
        this.asM = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.asN = -9989158;
        this.asO = 200;
        this.asP = 200;
        this.asQ = null;
        this.asR = 0;
        this.asS = 0;
        this.asT = false;
        this.asU = null;
        this.asV = null;
        this.asW = true;
        this.mIsFromCDN = true;
        this.asX = -1;
        this.asY = false;
        this.asZ = false;
        this.ata = null;
        this.atb = false;
        this.ate = null;
        this.atf = false;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.arU = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asC = null;
        this.asD = null;
        this.asE = null;
        this.asF = null;
        this.asG = null;
        this.asH = 0.0f;
        this.asI = 0;
        this.asJ = 0;
        this.asK = 15.0f;
        this.asL = -1;
        this.asM = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.asN = -9989158;
        this.asO = 200;
        this.asP = 200;
        this.asQ = null;
        this.asR = 0;
        this.asS = 0;
        this.asT = false;
        this.asU = null;
        this.asV = null;
        this.asW = true;
        this.mIsFromCDN = true;
        this.asX = -1;
        this.asY = false;
        this.asZ = false;
        this.ata = null;
        this.atb = false;
        this.ate = null;
        this.atf = false;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.arU = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.TbRichTextView);
        this.asJ = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.asI = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.asH = obtainStyledAttributes.getFloat(5, 1.2f);
        this.asK = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.asK);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.asO = obtainStyledAttributes.getDimensionPixelSize(6, this.asO);
        this.asP = obtainStyledAttributes.getDimensionPixelSize(7, this.asP);
        this.asR = obtainStyledAttributes.getResourceId(8, 0);
        this.asL = obtainStyledAttributes.getDimensionPixelSize(9, this.asL);
        this.asM = obtainStyledAttributes.getDimensionPixelSize(10, this.asM);
        this.asS = obtainStyledAttributes.getResourceId(11, 0);
        this.asT = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f) {
        this.asH = f;
    }

    private void init() {
        asB = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.adk_default_image_height);
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
            this.asC = jVar.getImageViewPool();
            this.asD = jVar.getTextViewPool();
            this.asE = jVar.getVoiceViewPool();
            this.asF = jVar.getTextVoiceViewPool();
            this.asG = jVar.getGifViewPool();
            if (jVar.getListView() != null && this.asU == null) {
                this.asU = new t(jVar.getRichTextViewId());
                jVar.getListView().setRecyclerListener(this.asU);
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
        ArrayList<c> Dv;
        int i;
        boolean z2;
        SpannableStringBuilder DB;
        this.atd = aVar;
        removeAllViews();
        if (aVar != null && (Dv = aVar.Dv()) != null) {
            Iterator<c> it = Dv.iterator();
            int i2 = 0;
            View view = null;
            View view2 = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        TextView ak = ak(getContext());
                        boolean a = a(next, ak, true);
                        if (z && !this.atb && (DB = next.DB()) != null) {
                            this.atb = DB.length() >= 200;
                        }
                        i = i2;
                        view2 = ak;
                        z2 = a;
                    } else if (next.getType() == 8) {
                        if (i2 < 10) {
                            ImageView aj = aj(getContext());
                            z2 = a(next, aj, (this.asO - getPaddingLeft()) - getPaddingRight(), this.asP);
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
                layoutParams.bottomMargin = this.asJ;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.asS <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.asJ;
        linearLayout.setClickable(true);
        Bitmap cg = ba.cg(this.asS);
        if (cg != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cg));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.asS;
    }

    public void setVideoImageId(int i) {
        this.asS = i;
    }

    private ImageView aj(Context context) {
        ImageView hz = this.asC != null ? this.asC.hz() : null;
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
        g DA;
        if (cVar == null || imageView == null || (DA = cVar.DA()) == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.atf) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(DA.DI(), this.mIsFromCDN ? 17 : 18, false);
            if (!DA.DJ()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        int[] b = com.baidu.adp.lib.util.n.b(DA.getWidth(), DA.getHeight(), i, i2);
        if (b != null) {
            boolean z = !this.asW;
            int[] iArr = {b[0], b[1]};
            if (!this.asW && z) {
                iArr[0] = i;
                iArr[1] = asB;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView2 = (TbImageView) imageView;
                tbImageView2.setDefaultResource(this.asR);
                if (tbImageView2.getGifIconWidth() >= iArr[0] || tbImageView2.getGifIconHeight() >= iArr[1]) {
                    tbImageView2.setGifIconSupport(false);
                } else {
                    tbImageView2.setGifIconSupport(true);
                }
            }
            int i3 = iArr[0];
            int i4 = iArr[1];
            if (this.atg && i > i3) {
                float O = com.baidu.adp.lib.util.n.O(getContext());
                if (O > 1.0f) {
                    if (i3 * O <= i) {
                        i = (int) (i3 * O);
                    }
                    if (iArr[0] > 0) {
                        i4 = (iArr[1] * i) / iArr[0];
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i4);
                    layoutParams.topMargin = this.asJ;
                    if (!this.atg) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else if (this.asQ == null) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    } else {
                        imageView.setScaleType(this.asQ);
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
            layoutParams2.topMargin = this.asJ;
            if (!this.atg) {
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
        this.atg = z;
    }

    private TextView ak(Context context) {
        TextView textView = null;
        if (this.asD != null) {
            textView = this.asD.hz();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.o(context);
        }
        textView.setPadding(this.asI, 0, this.asI, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        CharSequence DB;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.asJ;
        textView.setLineSpacing(0.0f, this.asH);
        textView.setTextSize(0, this.asK);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.asN);
        textView.setSingleLine(this.asT);
        if (cVar == null || (DB = cVar.DB()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.asM > 0 && this.asL > 0) {
            cVar.D(this.asL, this.asM);
        }
        if (textSize > 0) {
            cVar.C(lineHeight, textSize);
        }
        try {
            textView.setText(DB);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.DD() != null) {
            cVar.DD().ass = this.ath;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.asG != null) {
            gifView = this.asG.hz();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.DE().akK.ako || layoutParams.height != cVar.DE().akK.akp) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.DE().akK.ako, cVar.DE().akK.akp);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.DE().akK);
        return true;
    }

    private View getVoiceView() {
        View hz = this.asE != null ? this.asE.hz() : null;
        if ((hz == null || hz.getParent() != null) && this.asX != -1) {
            hz = com.baidu.adp.lib.g.b.hH().inflate(getContext(), this.asX, null);
        }
        if (hz != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.asJ;
            layoutParams.bottomMargin = this.asJ;
            hz.setLayoutParams(layoutParams);
            return hz;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.DC());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout hz = this.asF.hz();
        if (hz != null) {
            TextView ak = ak(getContext());
            if (ak == null) {
                this.asF.j(hz);
                return null;
            }
            hz.addView(ak);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.asD.j(ak);
                this.asF.j(hz);
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
        if (applyDimension != this.asK) {
            this.asK = applyDimension;
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
        if (this.asI != i) {
            this.asI = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.asI, 0, 0, this.asI);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.asN) {
            this.asN = i;
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
        return this.asO;
    }

    public void setMaxImageWidth(int i) {
        this.asO = i;
    }

    public int getMaxImageHeight() {
        return this.asP;
    }

    public void setMaxImageHeight(int i) {
        this.asP = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.asQ;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.asQ = scaleType;
    }

    public int getDefaultImageId() {
        return this.asR;
    }

    public void setDefaultImageId(int i) {
        this.asR = i;
    }

    public s getOnImageClickListener() {
        return this.asV;
    }

    public void setOnImageClickListener(s sVar) {
        this.asV = sVar;
    }

    public void setOnEmotionClickListener(r rVar) {
        this.atc = rVar;
    }

    public void b(boolean z, boolean z2) {
        if (this.asW != z) {
            this.asW = z;
            if (z2) {
                requestLayout();
            }
            if (!this.asW && this.asC != null) {
                this.asC.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.asY = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.asZ) {
                    DO();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.asY) {
                    DN();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.asY = true;
        return super.onTouchEvent(motionEvent);
    }

    private void DN() {
        this.asZ = false;
        if (this.ata == null) {
            this.ata = new q(this);
        }
        postDelayed(this.ata, ViewConfiguration.getLongPressTimeout());
    }

    private void DO() {
        if (this.ata != null) {
            removeCallbacks(this.ata);
        }
    }

    public void setVoiceViewRes(int i) {
        this.asX = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.ate = null;
        if (this.ati != drawable) {
            this.ath = true;
            this.ati = drawable;
        }
        setText(this.atd);
        this.ath = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zq();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        zq();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            zq();
        } else {
            refresh();
        }
    }

    public void eO(String str) {
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
        if (!(str.equals(this.mUrl) && this.akM == bdUniqueId)) {
            zq();
        }
        this.mUrl = str;
        this.akM = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.hB().X(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, 19, this.arU, 0, 0, this.akM, new Object[0]);
        }
    }

    public void zq() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, 19, this.arU);
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
        eO(this.mUrl);
    }
}
