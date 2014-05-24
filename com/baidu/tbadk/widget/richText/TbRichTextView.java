package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.aa;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.g {
    static int a = 174;
    private boolean A;
    private boolean B;
    private Runnable C;
    private boolean D;
    private r E;
    private boolean F;
    private a G;
    private String H;
    private final View.OnClickListener I;
    private boolean J;
    private int K;
    private boolean L;
    private Drawable M;
    private String N;
    private int O;
    private int P;
    private com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> Q;
    private com.baidu.adp.lib.d.b<ImageView> b;
    private com.baidu.adp.lib.d.b<TextView> c;
    private com.baidu.adp.lib.d.b<View> d;
    private com.baidu.adp.lib.d.b<LinearLayout> e;
    private com.baidu.adp.lib.d.b<GifView> f;
    private float g;
    private int h;
    private int i;
    private float j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private ImageView.ScaleType q;
    private int r;
    private int s;
    private boolean t;
    private t u;
    private s v;
    private boolean w;
    private boolean x;
    private int y;
    private LayoutInflater z;

    public boolean a() {
        return this.D;
    }

    public String getBackgroundImageUrl() {
        return this.H;
    }

    public void setBackgroundImageUrl(String str) {
        this.H = str;
    }

    public void setIsFromCDN(boolean z) {
        this.x = z;
    }

    public static a a(Context context, JSONArray jSONArray, int i) {
        return new a(context, jSONArray, i);
    }

    public static a a(Context context, JSONArray jSONArray, boolean z) {
        return new a(context, jSONArray, z);
    }

    public static com.baidu.adp.lib.d.b<TextView> a(Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new m(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0.0f;
        this.h = 0;
        this.i = 0;
        this.j = 15.0f;
        this.k = -1;
        this.l = -1;
        this.m = -16777216;
        this.n = -9989158;
        this.o = Constants.MEDIA_INFO;
        this.p = Constants.MEDIA_INFO;
        this.q = null;
        this.r = 0;
        this.s = 0;
        this.t = false;
        this.u = null;
        this.v = null;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.A = false;
        this.B = false;
        this.C = null;
        this.D = false;
        this.H = null;
        this.I = new k(this);
        this.J = true;
        this.O = 19;
        this.Q = new l(this);
        d();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0.0f;
        this.h = 0;
        this.i = 0;
        this.j = 15.0f;
        this.k = -1;
        this.l = -1;
        this.m = -16777216;
        this.n = -9989158;
        this.o = Constants.MEDIA_INFO;
        this.p = Constants.MEDIA_INFO;
        this.q = null;
        this.r = 0;
        this.s = 0;
        this.t = false;
        this.u = null;
        this.v = null;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.A = false;
        this.B = false;
        this.C = null;
        this.D = false;
        this.H = null;
        this.I = new k(this);
        this.J = true;
        this.O = 19;
        this.Q = new l(this);
        d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.TbRichTextView);
        this.i = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.h = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.g = obtainStyledAttributes.getFloat(5, 1.2f);
        this.j = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.j);
        this.m = obtainStyledAttributes.getColor(3, this.m);
        this.o = obtainStyledAttributes.getDimensionPixelSize(6, this.o);
        this.p = obtainStyledAttributes.getDimensionPixelSize(7, this.p);
        this.r = obtainStyledAttributes.getResourceId(8, 0);
        this.k = obtainStyledAttributes.getDimensionPixelSize(9, this.k);
        this.l = obtainStyledAttributes.getDimensionPixelSize(10, this.l);
        this.s = obtainStyledAttributes.getResourceId(11, 0);
        this.t = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    private void d() {
        a = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.adk_default_image_height);
        if (getContext() instanceof j) {
            j jVar = (j) getContext();
            this.b = jVar.f();
            this.c = jVar.g();
            this.d = jVar.i();
            this.e = jVar.j();
            this.f = jVar.h();
            if (jVar.a() != null && this.u == null) {
                this.u = new t(jVar.e());
                jVar.a().setRecyclerListener(this.u);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new n(this));
        this.z = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    public void setText(a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x001d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    public void a(a aVar, boolean z) {
        ArrayList<c> a2;
        boolean a3;
        TextView textView;
        SpannableStringBuilder d;
        this.G = aVar;
        this.F = com.baidu.adp.gif.e.a();
        removeAllViews();
        if (aVar != null && (a2 = aVar.a()) != null) {
            Iterator<c> it = a2.iterator();
            TextView textView2 = null;
            View view = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.a() == 1) {
                        TextView b = b(getContext());
                        a3 = a(next, b, true);
                        if (z && !this.D && (d = next.d()) != null) {
                            this.D = d.length() >= 200;
                        }
                        textView = b;
                    } else if (next.a() == 8) {
                        ImageView a4 = a(getContext());
                        boolean a5 = a(next, a4, (this.o - getPaddingLeft()) - getPaddingRight(), this.p);
                        textView = a4;
                        a3 = a5;
                    } else if (next.a() == 32) {
                        textView = a(next);
                        a3 = true;
                    } else if (next.a() == 512) {
                        view = getVoiceView();
                        if (view != null) {
                            boolean a6 = a(next, view);
                            textView = view;
                            a3 = a6;
                        }
                    } else if (next.a() == 768) {
                        View textVoiceView = getTextVoiceView();
                        a3 = a(next, (LinearLayout) textVoiceView);
                        textView = textVoiceView;
                    } else if (next.a() == 17) {
                        GifView gifView = getGifView();
                        a3 = a(next, gifView);
                        textView = gifView;
                    } else {
                        textView = view;
                        a3 = false;
                    }
                    if (!a3 || textView == null) {
                        view = textView;
                    } else {
                        addView(textView);
                        textView2 = textView;
                        view = textView;
                    }
                }
            }
            if (textView2 != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams.bottomMargin = this.i;
                textView2.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.s <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.i;
        linearLayout.setClickable(true);
        linearLayout.setBackgroundResource(this.s);
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.s;
    }

    public void setVideoImageId(int i) {
        this.s = i;
    }

    private ImageView a(Context context) {
        ImageView a2 = this.b != null ? this.b.a() : null;
        if (a2 == null || a2.getParent() != null) {
            return null;
        }
        return a2;
    }

    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        g c;
        if (cVar == null || imageView == null || (c = cVar.c()) == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).a(c.f(), this.x ? 17 : 18, false);
        }
        int[] a2 = com.baidu.adp.lib.util.k.a(c.c(), c.b(), i, i2);
        if (a2 != null) {
            boolean z = !this.w;
            int[] iArr = {a2[0], a2[1]};
            if (!this.w && z) {
                iArr[0] = i;
                iArr[1] = a;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iArr[0], iArr[1]);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setDefaultResource(this.r);
            }
            layoutParams.topMargin = this.i;
            if (this.q == null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                imageView.setScaleType(this.q);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            imageView.setOnClickListener(this.I);
            imageView.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    private TextView b(Context context) {
        TextView textView = null;
        if (this.c != null) {
            textView = this.c.a();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.m(context);
        }
        textView.setPadding(this.h, 0, this.h, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        CharSequence d;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.i;
        textView.setLineSpacing(0.0f, this.g);
        textView.setTextSize(0, this.j);
        textView.setTextColor(this.m);
        textView.setLinkTextColor(this.n);
        textView.setSingleLine(this.t);
        if (cVar == null || (d = cVar.d()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.l > 0 && this.k > 0) {
            cVar.b(this.k, this.l);
        }
        if (textSize > 0) {
            cVar.a(lineHeight, textSize);
        }
        textView.setText(d);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.f() != null) {
            cVar.f().d = this.L;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.f != null) {
            gifView = this.f.a();
        }
        if (gifView == null || gifView.getParent() != null) {
            BdLog.w("TbRichTextView", "getGifView", "Pool's full, create new one.");
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        BdLog.d("TbRichTextView", "initGifView", "c:" + cVar.g());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.g().b.f || layoutParams.height != cVar.g().b.g) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.g().b.f, cVar.g().b.g);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.g().b);
        return true;
    }

    private View getVoiceView() {
        View a2 = this.d != null ? this.d.a() : null;
        if (a2 == null || a2.getParent() != null) {
            BdLog.d("voice view is null");
            if (this.y != -1) {
                a2 = this.z.inflate(this.y, (ViewGroup) null);
            }
        }
        if (a2 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.i;
            layoutParams.bottomMargin = this.i;
            a2.setLayoutParams(layoutParams);
            return a2;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.e());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout a2 = this.e.a();
        if (a2 != null) {
            TextView b = b(getContext());
            if (b == null) {
                this.e.a((com.baidu.adp.lib.d.b<LinearLayout>) a2);
                return null;
            }
            a2.addView(b);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.c.a((com.baidu.adp.lib.d.b<TextView>) b);
                this.e.a((com.baidu.adp.lib.d.b<LinearLayout>) a2);
                return null;
            }
            a2.addView(voiceView);
            return a2;
        }
        return a2;
    }

    private boolean a(c cVar, LinearLayout linearLayout) {
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
        if (applyDimension != this.j) {
            this.j = applyDimension;
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
        if (i != this.m) {
            this.m = i;
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
        if (this.h != i) {
            this.h = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.h, 0, 0, this.h);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.n) {
            this.n = i;
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
        return this.o;
    }

    public void setMaxImageWidth(int i) {
        this.o = i;
    }

    public int getMaxImageHeight() {
        return this.p;
    }

    public void setMaxImageHeight(int i) {
        this.p = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.q;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.q = scaleType;
    }

    public int getDefaultImageId() {
        return this.r;
    }

    public void setDefaultImageId(int i) {
        this.r = i;
    }

    public s getOnImageClickListener() {
        return this.v;
    }

    public void setOnImageClickListener(s sVar) {
        this.v = sVar;
    }

    public void setOnEmotionClickListener(r rVar) {
        this.E = rVar;
    }

    public void a(boolean z, boolean z2) {
        if (this.w != z) {
            this.w = z;
            if (z2) {
                requestLayout();
            }
            if (!this.w && this.b != null) {
                this.b.b();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.A = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.B) {
                    f();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.A) {
                    e();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.A = true;
        return super.onTouchEvent(motionEvent);
    }

    private void e() {
        this.B = false;
        if (this.C == null) {
            this.C = new q(this);
        }
        postDelayed(this.C, ViewConfiguration.getLongPressTimeout());
    }

    private void f() {
        if (this.C != null) {
            removeCallbacks(this.C);
        }
    }

    public void setVoiceViewRes(int i) {
        this.y = i;
    }

    public void setShowEmotion(boolean z) {
        this.J = z;
    }

    public void setDefaultGifId(int i) {
        this.K = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.H = null;
        if (this.M != drawable) {
            this.L = true;
            this.M = drawable;
        }
        setText(this.G);
        this.L = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            c();
        } else {
            b();
        }
    }

    public void a(String str) {
        int i;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.N = str;
            return;
        }
        Context context = getContext();
        if (context == null || !(context instanceof com.baidu.adp.base.g)) {
            i = 0;
            z = false;
        } else {
            com.baidu.adp.base.g gVar = (com.baidu.adp.base.g) context;
            int uniqueId = gVar.getUniqueId();
            z = gVar.isScroll();
            i = uniqueId;
        }
        if (!(str.equals(this.N) && this.P == i)) {
            c();
        }
        this.N = str;
        this.P = i;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.N, this.O, new Object[0]);
        if (aVar != null) {
            a(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.resourceLoader.d.a().c(this.O)) {
            invalidate();
        } else {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.N, this.O, this.Q, 0, 0, this.P, new Object[0]);
        }
    }

    public void c() {
        if (!TextUtils.isEmpty(this.N)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.N, this.O, this.Q);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.h(), aVar.h().getNinePatchChunk(), aVar.m(), null);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.g
    public void b() {
        a(this.N);
    }
}
