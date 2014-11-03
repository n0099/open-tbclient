package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
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
    static int abQ = 174;
    private BdUniqueId TL;
    private com.baidu.adp.lib.e.b<ImageView> abR;
    private com.baidu.adp.lib.e.b<TextView> abS;
    private com.baidu.adp.lib.e.b<View> abT;
    private com.baidu.adp.lib.e.b<LinearLayout> abU;
    private com.baidu.adp.lib.e.b<GifView> abV;
    private float abW;
    private int abX;
    private int abY;
    private float abZ;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> abj;
    private int aca;
    private int acb;
    private int acc;
    private int acd;
    private int ace;
    private ImageView.ScaleType acf;
    private int acg;
    private int ach;
    private boolean aci;
    private t acj;
    private s ack;
    private boolean acl;
    private int acm;
    private boolean acn;
    private boolean aco;
    private Runnable acp;
    private boolean acq;
    private r acr;
    private a acs;
    private String act;
    private boolean acu;
    private Drawable acv;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    public boolean vV() {
        return this.acq;
    }

    public String getBackgroundImageUrl() {
        return this.act;
    }

    public void setBackgroundImageUrl(String str) {
        this.act = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public static a a(Context context, JSONArray jSONArray, int i) {
        return new a(context, jSONArray, i);
    }

    public static a a(Context context, JSONArray jSONArray, boolean z) {
        return new a(context, jSONArray, z);
    }

    public static a a(Context context, List<PbContent> list, boolean z) {
        return new a(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new m(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.abR = null;
        this.abS = null;
        this.abT = null;
        this.abU = null;
        this.abV = null;
        this.abW = 0.0f;
        this.abX = 0;
        this.abY = 0;
        this.abZ = 15.0f;
        this.aca = -1;
        this.acb = -1;
        this.mTextColor = -16777216;
        this.acc = -9989158;
        this.acd = Constants.MEDIA_INFO;
        this.ace = Constants.MEDIA_INFO;
        this.acf = null;
        this.acg = 0;
        this.ach = 0;
        this.aci = false;
        this.acj = null;
        this.ack = null;
        this.acl = true;
        this.mIsFromCDN = true;
        this.acm = -1;
        this.acn = false;
        this.aco = false;
        this.acp = null;
        this.acq = false;
        this.act = null;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.abj = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abR = null;
        this.abS = null;
        this.abT = null;
        this.abU = null;
        this.abV = null;
        this.abW = 0.0f;
        this.abX = 0;
        this.abY = 0;
        this.abZ = 15.0f;
        this.aca = -1;
        this.acb = -1;
        this.mTextColor = -16777216;
        this.acc = -9989158;
        this.acd = Constants.MEDIA_INFO;
        this.ace = Constants.MEDIA_INFO;
        this.acf = null;
        this.acg = 0;
        this.ach = 0;
        this.aci = false;
        this.acj = null;
        this.ack = null;
        this.acl = true;
        this.mIsFromCDN = true;
        this.acm = -1;
        this.acn = false;
        this.aco = false;
        this.acp = null;
        this.acq = false;
        this.act = null;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.abj = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.TbRichTextView);
        this.abY = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.abX = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.abW = obtainStyledAttributes.getFloat(5, 1.2f);
        this.abZ = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.abZ);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.acd = obtainStyledAttributes.getDimensionPixelSize(6, this.acd);
        this.ace = obtainStyledAttributes.getDimensionPixelSize(7, this.ace);
        this.acg = obtainStyledAttributes.getResourceId(8, 0);
        this.aca = obtainStyledAttributes.getDimensionPixelSize(9, this.aca);
        this.acb = obtainStyledAttributes.getDimensionPixelSize(10, this.acb);
        this.ach = obtainStyledAttributes.getResourceId(11, 0);
        this.aci = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        abQ = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.adk_default_image_height);
        if (getContext() instanceof j) {
            j jVar = (j) getContext();
            this.abR = jVar.vQ();
            this.abS = jVar.vR();
            this.abT = jVar.vT();
            this.abU = jVar.vU();
            this.abV = jVar.vS();
            if (jVar.getListView() != null && this.acj == null) {
                this.acj = new t(jVar.vP());
                jVar.getListView().setRecyclerListener(this.acj);
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
        ArrayList<c> vA;
        int i;
        boolean z2;
        SpannableStringBuilder vG;
        this.acs = aVar;
        removeAllViews();
        if (aVar != null && (vA = aVar.vA()) != null) {
            Iterator<c> it = vA.iterator();
            int i2 = 0;
            View view = null;
            View view2 = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        TextView K = K(getContext());
                        boolean a = a(next, K, true);
                        if (z && !this.acq && (vG = next.vG()) != null) {
                            this.acq = vG.length() >= 200;
                        }
                        i = i2;
                        view2 = K;
                        z2 = a;
                    } else if (next.getType() == 8) {
                        if (i2 < 10) {
                            ImageView J = J(getContext());
                            z2 = a(next, J, (this.acd - getPaddingLeft()) - getPaddingRight(), this.ace);
                            i = i2 + 1;
                            view2 = J;
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
                layoutParams.bottomMargin = this.abY;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.ach <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.abY;
        linearLayout.setClickable(true);
        Bitmap bA = aw.bA(this.ach);
        if (bA != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bA));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.ach;
    }

    public void setVideoImageId(int i) {
        this.ach = i;
    }

    private ImageView J(Context context) {
        ImageView ed = this.abR != null ? this.abR.ed() : null;
        if (ed == null || ed.getParent() != null) {
            return null;
        }
        return ed;
    }

    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        g vF;
        if (cVar == null || imageView == null || (vF = cVar.vF()) == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).c(vF.vN(), this.mIsFromCDN ? 17 : 18, false);
        }
        int[] a = com.baidu.adp.lib.util.m.a(vF.getWidth(), vF.getHeight(), i, i2);
        if (a != null) {
            boolean z = !this.acl;
            int[] iArr = {a[0], a[1]};
            if (!this.acl && z) {
                iArr[0] = i;
                iArr[1] = abQ;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iArr[0], iArr[1]);
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.acg);
                if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                    tbImageView.setGifIconSupport(false);
                }
            }
            layoutParams.topMargin = this.abY;
            if (this.acf == null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                imageView.setScaleType(this.acf);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            imageView.setOnClickListener(this.mOnClickListener);
            imageView.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    private TextView K(Context context) {
        TextView textView = null;
        if (this.abS != null) {
            textView = this.abS.ed();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.q(context);
        }
        textView.setPadding(this.abX, 0, this.abX, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        CharSequence vG;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.abY;
        textView.setLineSpacing(0.0f, this.abW);
        textView.setTextSize(0, this.abZ);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.acc);
        textView.setSingleLine(this.aci);
        if (cVar == null || (vG = cVar.vG()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.acb > 0 && this.aca > 0) {
            cVar.B(this.aca, this.acb);
        }
        if (textSize > 0) {
            cVar.A(lineHeight, textSize);
        }
        try {
            textView.setText(vG);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.vI() != null) {
            cVar.vI().abI = this.acu;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.abV != null) {
            gifView = this.abV.ed();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.vJ().TJ.Tn || layoutParams.height != cVar.vJ().TJ.To) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.vJ().TJ.Tn, cVar.vJ().TJ.To);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.vJ().TJ);
        return true;
    }

    private View getVoiceView() {
        View ed = this.abT != null ? this.abT.ed() : null;
        if ((ed == null || ed.getParent() != null) && this.acm != -1) {
            ed = com.baidu.adp.lib.g.b.ek().inflate(getContext(), this.acm, null);
        }
        if (ed != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.abY;
            layoutParams.bottomMargin = this.abY;
            ed.setLayoutParams(layoutParams);
            return ed;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.vH());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ed = this.abU.ed();
        if (ed != null) {
            TextView K = K(getContext());
            if (K == null) {
                this.abU.h(ed);
                return null;
            }
            ed.addView(K);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.abS.h(K);
                this.abU.h(ed);
                return null;
            }
            ed.addView(voiceView);
            return ed;
        }
        return ed;
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
        if (applyDimension != this.abZ) {
            this.abZ = applyDimension;
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
        if (this.abX != i) {
            this.abX = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.abX, 0, 0, this.abX);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.acc) {
            this.acc = i;
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
        return this.acd;
    }

    public void setMaxImageWidth(int i) {
        this.acd = i;
    }

    public int getMaxImageHeight() {
        return this.ace;
    }

    public void setMaxImageHeight(int i) {
        this.ace = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.acf;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.acf = scaleType;
    }

    public int getDefaultImageId() {
        return this.acg;
    }

    public void setDefaultImageId(int i) {
        this.acg = i;
    }

    public s getOnImageClickListener() {
        return this.ack;
    }

    public void setOnImageClickListener(s sVar) {
        this.ack = sVar;
    }

    public void setOnEmotionClickListener(r rVar) {
        this.acr = rVar;
    }

    public void b(boolean z, boolean z2) {
        if (this.acl != z) {
            this.acl = z;
            if (z2) {
                requestLayout();
            }
            if (!this.acl && this.abR != null) {
                this.abR.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.acn = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aco) {
                    vX();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.acn) {
                    vW();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.acn = true;
        return super.onTouchEvent(motionEvent);
    }

    private void vW() {
        this.aco = false;
        if (this.acp == null) {
            this.acp = new q(this);
        }
        postDelayed(this.acp, ViewConfiguration.getLongPressTimeout());
    }

    private void vX() {
        if (this.acp != null) {
            removeCallbacks(this.acp);
        }
    }

    public void setVoiceViewRes(int i) {
        this.acm = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.act = null;
        if (this.acv != drawable) {
            this.acu = true;
            this.acv = drawable;
        }
        setText(this.acs);
        this.acu = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rZ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        rZ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            rZ();
        } else {
            refresh();
        }
    }

    public void dS(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        Context context = getContext();
        if (context == null || !(context instanceof com.baidu.adp.base.i)) {
            bdUniqueId = null;
            z = false;
        } else {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            BdUniqueId uniqueId = iVar.getUniqueId();
            z = iVar.isScroll();
            bdUniqueId = uniqueId;
        }
        if (!(str.equals(this.mUrl) && this.TL == bdUniqueId)) {
            rZ();
        }
        this.mUrl = str;
        this.TL = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.ef().J(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.d.ef().a(this.mUrl, 19, this.abj, 0, 0, this.TL, new Object[0]);
        }
    }

    public void rZ() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.ef().a(this.mUrl, 19, this.abj);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.hl(), aVar.hl().getNinePatchChunk(), aVar.hp(), null);
                if (TbadkApplication.m251getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        dS(this.mUrl);
    }
}
