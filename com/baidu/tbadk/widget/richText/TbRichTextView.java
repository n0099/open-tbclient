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
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
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
    static int ajC = 174;
    private BdUniqueId ZQ;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> aiV;
    private com.baidu.adp.lib.e.b<ImageView> ajD;
    private com.baidu.adp.lib.e.b<TextView> ajE;
    private com.baidu.adp.lib.e.b<View> ajF;
    private com.baidu.adp.lib.e.b<LinearLayout> ajG;
    private com.baidu.adp.lib.e.b<GifView> ajH;
    private float ajI;
    private int ajJ;
    private int ajK;
    private float ajL;
    private int ajM;
    private int ajN;
    private int ajO;
    private int ajP;
    private int ajQ;
    private ImageView.ScaleType ajR;
    private int ajS;
    private int ajT;
    private boolean ajU;
    private t ajV;
    private s ajW;
    private boolean ajX;
    private int ajY;
    private boolean ajZ;
    private boolean aka;
    private Runnable akb;
    private boolean akc;
    private r akd;
    private a ake;
    private String akf;
    private boolean akg;
    private Drawable akh;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    public boolean Ab() {
        return this.akc;
    }

    public String getBackgroundImageUrl() {
        return this.akf;
    }

    public void setBackgroundImageUrl(String str) {
        this.akf = str;
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

    public static com.baidu.adp.lib.e.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new m(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.ajD = null;
        this.ajE = null;
        this.ajF = null;
        this.ajG = null;
        this.ajH = null;
        this.ajI = 0.0f;
        this.ajJ = 0;
        this.ajK = 0;
        this.ajL = 15.0f;
        this.ajM = -1;
        this.ajN = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.ajO = -9989158;
        this.ajP = Constants.MEDIA_INFO;
        this.ajQ = Constants.MEDIA_INFO;
        this.ajR = null;
        this.ajS = 0;
        this.ajT = 0;
        this.ajU = false;
        this.ajV = null;
        this.ajW = null;
        this.ajX = true;
        this.mIsFromCDN = true;
        this.ajY = -1;
        this.ajZ = false;
        this.aka = false;
        this.akb = null;
        this.akc = false;
        this.akf = null;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.aiV = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajD = null;
        this.ajE = null;
        this.ajF = null;
        this.ajG = null;
        this.ajH = null;
        this.ajI = 0.0f;
        this.ajJ = 0;
        this.ajK = 0;
        this.ajL = 15.0f;
        this.ajM = -1;
        this.ajN = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.ajO = -9989158;
        this.ajP = Constants.MEDIA_INFO;
        this.ajQ = Constants.MEDIA_INFO;
        this.ajR = null;
        this.ajS = 0;
        this.ajT = 0;
        this.ajU = false;
        this.ajV = null;
        this.ajW = null;
        this.ajX = true;
        this.mIsFromCDN = true;
        this.ajY = -1;
        this.ajZ = false;
        this.aka = false;
        this.akb = null;
        this.akc = false;
        this.akf = null;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.aiV = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ab.TbRichTextView);
        this.ajK = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.ajJ = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.ajI = obtainStyledAttributes.getFloat(5, 1.2f);
        this.ajL = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.ajL);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.ajP = obtainStyledAttributes.getDimensionPixelSize(6, this.ajP);
        this.ajQ = obtainStyledAttributes.getDimensionPixelSize(7, this.ajQ);
        this.ajS = obtainStyledAttributes.getResourceId(8, 0);
        this.ajM = obtainStyledAttributes.getDimensionPixelSize(9, this.ajM);
        this.ajN = obtainStyledAttributes.getDimensionPixelSize(10, this.ajN);
        this.ajT = obtainStyledAttributes.getResourceId(11, 0);
        this.ajU = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        ajC = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.u.adk_default_image_height);
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
            this.ajD = jVar.getImageViewPool();
            this.ajE = jVar.getTextViewPool();
            this.ajF = jVar.getVoiceViewPool();
            this.ajG = jVar.getTextVoiceViewPool();
            this.ajH = jVar.getGifViewPool();
            if (jVar.getListView() != null && this.ajV == null) {
                this.ajV = new t(jVar.getRichTextViewId());
                jVar.getListView().setRecyclerListener(this.ajV);
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
        ArrayList<c> zL;
        int i;
        boolean z2;
        SpannableStringBuilder zR;
        this.ake = aVar;
        removeAllViews();
        if (aVar != null && (zL = aVar.zL()) != null) {
            Iterator<c> it = zL.iterator();
            int i2 = 0;
            View view = null;
            View view2 = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        TextView ah = ah(getContext());
                        boolean a = a(next, ah, true);
                        if (z && !this.akc && (zR = next.zR()) != null) {
                            this.akc = zR.length() >= 200;
                        }
                        i = i2;
                        view2 = ah;
                        z2 = a;
                    } else if (next.getType() == 8) {
                        if (i2 < 10) {
                            ImageView ag = ag(getContext());
                            z2 = a(next, ag, (this.ajP - getPaddingLeft()) - getPaddingRight(), this.ajQ);
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
                layoutParams.bottomMargin = this.ajK;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.ajT <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.ajK;
        linearLayout.setClickable(true);
        Bitmap bX = ax.bX(this.ajT);
        if (bX != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bX));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.ajT;
    }

    public void setVideoImageId(int i) {
        this.ajT = i;
    }

    private ImageView ag(Context context) {
        ImageView ec = this.ajD != null ? this.ajD.ec() : null;
        if (ec == null || ec.getParent() != null) {
            return null;
        }
        return ec;
    }

    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        g zQ;
        if (cVar == null || imageView == null || (zQ = cVar.zQ()) == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).d(zQ.zY(), this.mIsFromCDN ? 17 : 18, false);
            if (!zQ.zZ()) {
                ((TbImageView) imageView).setAdjustViewBounds(false);
            }
        }
        int[] b = com.baidu.adp.lib.util.l.b(zQ.getWidth(), zQ.getHeight(), i, i2);
        if (b != null) {
            boolean z = !this.ajX;
            int[] iArr = {b[0], b[1]};
            if (!this.ajX && z) {
                iArr[0] = i;
                iArr[1] = ajC;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iArr[0], iArr[1]);
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.ajS);
                if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                    tbImageView.setGifIconSupport(false);
                }
            }
            layoutParams.topMargin = this.ajK;
            if (this.ajR == null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                imageView.setScaleType(this.ajR);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            imageView.setOnClickListener(this.mOnClickListener);
            imageView.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    private TextView ah(Context context) {
        TextView textView = null;
        if (this.ajE != null) {
            textView = this.ajE.ec();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.q(context);
        }
        textView.setPadding(this.ajJ, 0, this.ajJ, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        CharSequence zR;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.ajK;
        textView.setLineSpacing(0.0f, this.ajI);
        textView.setTextSize(0, this.ajL);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.ajO);
        textView.setSingleLine(this.ajU);
        if (cVar == null || (zR = cVar.zR()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.ajN > 0 && this.ajM > 0) {
            cVar.F(this.ajM, this.ajN);
        }
        if (textSize > 0) {
            cVar.E(lineHeight, textSize);
        }
        try {
            textView.setText(zR);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.zT() != null) {
            cVar.zT().ajt = this.akg;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.ajH != null) {
            gifView = this.ajH.ec();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.zU().ZO.Zs || layoutParams.height != cVar.zU().ZO.Zt) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.zU().ZO.Zs, cVar.zU().ZO.Zt);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.zU().ZO);
        return true;
    }

    private View getVoiceView() {
        View ec = this.ajF != null ? this.ajF.ec() : null;
        if ((ec == null || ec.getParent() != null) && this.ajY != -1) {
            ec = com.baidu.adp.lib.g.b.ek().inflate(getContext(), this.ajY, null);
        }
        if (ec != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.ajK;
            layoutParams.bottomMargin = this.ajK;
            ec.setLayoutParams(layoutParams);
            return ec;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.zS());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ec = this.ajG.ec();
        if (ec != null) {
            TextView ah = ah(getContext());
            if (ah == null) {
                this.ajG.j(ec);
                return null;
            }
            ec.addView(ah);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.ajE.j(ah);
                this.ajG.j(ec);
                return null;
            }
            ec.addView(voiceView);
            return ec;
        }
        return ec;
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
        if (applyDimension != this.ajL) {
            this.ajL = applyDimension;
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
        if (this.ajJ != i) {
            this.ajJ = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.ajJ, 0, 0, this.ajJ);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.ajO) {
            this.ajO = i;
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
        return this.ajP;
    }

    public void setMaxImageWidth(int i) {
        this.ajP = i;
    }

    public int getMaxImageHeight() {
        return this.ajQ;
    }

    public void setMaxImageHeight(int i) {
        this.ajQ = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.ajR;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.ajR = scaleType;
    }

    public int getDefaultImageId() {
        return this.ajS;
    }

    public void setDefaultImageId(int i) {
        this.ajS = i;
    }

    public s getOnImageClickListener() {
        return this.ajW;
    }

    public void setOnImageClickListener(s sVar) {
        this.ajW = sVar;
    }

    public void setOnEmotionClickListener(r rVar) {
        this.akd = rVar;
    }

    public void c(boolean z, boolean z2) {
        if (this.ajX != z) {
            this.ajX = z;
            if (z2) {
                requestLayout();
            }
            if (!this.ajX && this.ajD != null) {
                this.ajD.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.ajZ = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aka) {
                    Ad();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.ajZ) {
                    Ac();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.ajZ = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Ac() {
        this.aka = false;
        if (this.akb == null) {
            this.akb = new q(this);
        }
        postDelayed(this.akb, ViewConfiguration.getLongPressTimeout());
    }

    private void Ad() {
        if (this.akb != null) {
            removeCallbacks(this.akb);
        }
    }

    public void setVoiceViewRes(int i) {
        this.ajY = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.akf = null;
        if (this.akh != drawable) {
            this.akg = true;
            this.akh = drawable;
        }
        setText(this.ake);
        this.akg = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vE();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        vE();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            vE();
        } else {
            refresh();
        }
    }

    public void eL(String str) {
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
        if (!(str.equals(this.mUrl) && this.ZQ == bdUniqueId)) {
            vE();
        }
        this.mUrl = str;
        this.ZQ = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ee().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.ee().R(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.d.ee().a(this.mUrl, 19, this.aiV, 0, 0, this.ZQ, new Object[0]);
        }
    }

    public void vE() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.ee().a(this.mUrl, 19, this.aiV);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.ji(), aVar.ji().getNinePatchChunk(), aVar.jm(), null);
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
        eL(this.mUrl);
    }
}
