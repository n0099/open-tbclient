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
    static int abL = 174;
    private BdUniqueId TH;
    private com.baidu.adp.lib.e.b<ImageView> abM;
    private com.baidu.adp.lib.e.b<TextView> abN;
    private com.baidu.adp.lib.e.b<View> abO;
    private com.baidu.adp.lib.e.b<LinearLayout> abP;
    private com.baidu.adp.lib.e.b<GifView> abQ;
    private float abR;
    private int abS;
    private int abT;
    private float abU;
    private int abV;
    private int abW;
    private int abX;
    private int abY;
    private int abZ;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> abe;
    private ImageView.ScaleType aca;
    private int acb;
    private int acc;
    private boolean acd;
    private t ace;
    private s acf;
    private boolean acg;
    private int ach;
    private boolean aci;
    private boolean acj;
    private Runnable ack;
    private boolean acl;
    private r acm;
    private a acn;
    private String aco;
    private boolean acp;
    private Drawable acq;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    public boolean vT() {
        return this.acl;
    }

    public String getBackgroundImageUrl() {
        return this.aco;
    }

    public void setBackgroundImageUrl(String str) {
        this.aco = str;
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
        this.abM = null;
        this.abN = null;
        this.abO = null;
        this.abP = null;
        this.abQ = null;
        this.abR = 0.0f;
        this.abS = 0;
        this.abT = 0;
        this.abU = 15.0f;
        this.abV = -1;
        this.abW = -1;
        this.mTextColor = -16777216;
        this.abX = -9989158;
        this.abY = Constants.MEDIA_INFO;
        this.abZ = Constants.MEDIA_INFO;
        this.aca = null;
        this.acb = 0;
        this.acc = 0;
        this.acd = false;
        this.ace = null;
        this.acf = null;
        this.acg = true;
        this.mIsFromCDN = true;
        this.ach = -1;
        this.aci = false;
        this.acj = false;
        this.ack = null;
        this.acl = false;
        this.aco = null;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.abe = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abM = null;
        this.abN = null;
        this.abO = null;
        this.abP = null;
        this.abQ = null;
        this.abR = 0.0f;
        this.abS = 0;
        this.abT = 0;
        this.abU = 15.0f;
        this.abV = -1;
        this.abW = -1;
        this.mTextColor = -16777216;
        this.abX = -9989158;
        this.abY = Constants.MEDIA_INFO;
        this.abZ = Constants.MEDIA_INFO;
        this.aca = null;
        this.acb = 0;
        this.acc = 0;
        this.acd = false;
        this.ace = null;
        this.acf = null;
        this.acg = true;
        this.mIsFromCDN = true;
        this.ach = -1;
        this.aci = false;
        this.acj = false;
        this.ack = null;
        this.acl = false;
        this.aco = null;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.abe = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.TbRichTextView);
        this.abT = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.abS = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.abR = obtainStyledAttributes.getFloat(5, 1.2f);
        this.abU = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.abU);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.abY = obtainStyledAttributes.getDimensionPixelSize(6, this.abY);
        this.abZ = obtainStyledAttributes.getDimensionPixelSize(7, this.abZ);
        this.acb = obtainStyledAttributes.getResourceId(8, 0);
        this.abV = obtainStyledAttributes.getDimensionPixelSize(9, this.abV);
        this.abW = obtainStyledAttributes.getDimensionPixelSize(10, this.abW);
        this.acc = obtainStyledAttributes.getResourceId(11, 0);
        this.acd = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        abL = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.adk_default_image_height);
        if (getContext() instanceof j) {
            j jVar = (j) getContext();
            this.abM = jVar.vO();
            this.abN = jVar.vP();
            this.abO = jVar.vR();
            this.abP = jVar.vS();
            this.abQ = jVar.vQ();
            if (jVar.getListView() != null && this.ace == null) {
                this.ace = new t(jVar.vN());
                jVar.getListView().setRecyclerListener(this.ace);
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
        ArrayList<c> vy;
        int i;
        boolean z2;
        SpannableStringBuilder vE;
        this.acn = aVar;
        removeAllViews();
        if (aVar != null && (vy = aVar.vy()) != null) {
            Iterator<c> it = vy.iterator();
            int i2 = 0;
            View view = null;
            View view2 = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        TextView K = K(getContext());
                        boolean a = a(next, K, true);
                        if (z && !this.acl && (vE = next.vE()) != null) {
                            this.acl = vE.length() >= 200;
                        }
                        i = i2;
                        view2 = K;
                        z2 = a;
                    } else if (next.getType() == 8) {
                        if (i2 < 10) {
                            ImageView J = J(getContext());
                            z2 = a(next, J, (this.abY - getPaddingLeft()) - getPaddingRight(), this.abZ);
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
                layoutParams.bottomMargin = this.abT;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.acc <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.abT;
        linearLayout.setClickable(true);
        Bitmap bA = aw.bA(this.acc);
        if (bA != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bA));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.acc;
    }

    public void setVideoImageId(int i) {
        this.acc = i;
    }

    private ImageView J(Context context) {
        ImageView ed = this.abM != null ? this.abM.ed() : null;
        if (ed == null || ed.getParent() != null) {
            return null;
        }
        return ed;
    }

    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        g vD;
        if (cVar == null || imageView == null || (vD = cVar.vD()) == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).c(vD.vL(), this.mIsFromCDN ? 17 : 18, false);
        }
        int[] a = com.baidu.adp.lib.util.m.a(vD.getWidth(), vD.getHeight(), i, i2);
        if (a != null) {
            boolean z = !this.acg;
            int[] iArr = {a[0], a[1]};
            if (!this.acg && z) {
                iArr[0] = i;
                iArr[1] = abL;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iArr[0], iArr[1]);
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.acb);
                if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                    tbImageView.setGifIconSupport(false);
                }
            }
            layoutParams.topMargin = this.abT;
            if (this.aca == null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                imageView.setScaleType(this.aca);
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
        if (this.abN != null) {
            textView = this.abN.ed();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.q(context);
        }
        textView.setPadding(this.abS, 0, this.abS, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        CharSequence vE;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.abT;
        textView.setLineSpacing(0.0f, this.abR);
        textView.setTextSize(0, this.abU);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.abX);
        textView.setSingleLine(this.acd);
        if (cVar == null || (vE = cVar.vE()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.abW > 0 && this.abV > 0) {
            cVar.B(this.abV, this.abW);
        }
        if (textSize > 0) {
            cVar.A(lineHeight, textSize);
        }
        try {
            textView.setText(vE);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.vG() != null) {
            cVar.vG().abD = this.acp;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.abQ != null) {
            gifView = this.abQ.ed();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.vH().TF.Tj || layoutParams.height != cVar.vH().TF.Tk) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.vH().TF.Tj, cVar.vH().TF.Tk);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.vH().TF);
        return true;
    }

    private View getVoiceView() {
        View ed = this.abO != null ? this.abO.ed() : null;
        if ((ed == null || ed.getParent() != null) && this.ach != -1) {
            ed = com.baidu.adp.lib.g.b.ek().inflate(getContext(), this.ach, null);
        }
        if (ed != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.abT;
            layoutParams.bottomMargin = this.abT;
            ed.setLayoutParams(layoutParams);
            return ed;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.vF());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ed = this.abP.ed();
        if (ed != null) {
            TextView K = K(getContext());
            if (K == null) {
                this.abP.h(ed);
                return null;
            }
            ed.addView(K);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.abN.h(K);
                this.abP.h(ed);
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
        if (applyDimension != this.abU) {
            this.abU = applyDimension;
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
        if (this.abS != i) {
            this.abS = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.abS, 0, 0, this.abS);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.abX) {
            this.abX = i;
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
        return this.abY;
    }

    public void setMaxImageWidth(int i) {
        this.abY = i;
    }

    public int getMaxImageHeight() {
        return this.abZ;
    }

    public void setMaxImageHeight(int i) {
        this.abZ = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aca;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aca = scaleType;
    }

    public int getDefaultImageId() {
        return this.acb;
    }

    public void setDefaultImageId(int i) {
        this.acb = i;
    }

    public s getOnImageClickListener() {
        return this.acf;
    }

    public void setOnImageClickListener(s sVar) {
        this.acf = sVar;
    }

    public void setOnEmotionClickListener(r rVar) {
        this.acm = rVar;
    }

    public void b(boolean z, boolean z2) {
        if (this.acg != z) {
            this.acg = z;
            if (z2) {
                requestLayout();
            }
            if (!this.acg && this.abM != null) {
                this.abM.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.aci = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.acj) {
                    vV();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aci) {
                    vU();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aci = true;
        return super.onTouchEvent(motionEvent);
    }

    private void vU() {
        this.acj = false;
        if (this.ack == null) {
            this.ack = new q(this);
        }
        postDelayed(this.ack, ViewConfiguration.getLongPressTimeout());
    }

    private void vV() {
        if (this.ack != null) {
            removeCallbacks(this.ack);
        }
    }

    public void setVoiceViewRes(int i) {
        this.ach = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aco = null;
        if (this.acq != drawable) {
            this.acp = true;
            this.acq = drawable;
        }
        setText(this.acn);
        this.acp = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rX();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        rX();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            rX();
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
        if (!(str.equals(this.mUrl) && this.TH == bdUniqueId)) {
            rX();
        }
        this.mUrl = str;
        this.TH = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.ef().J(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.d.ef().a(this.mUrl, 19, this.abe, 0, 0, this.TH, new Object[0]);
        }
    }

    public void rX() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.ef().a(this.mUrl, 19, this.abe);
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
