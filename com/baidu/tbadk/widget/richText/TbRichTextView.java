package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout {
    private Runnable A;
    private boolean B;
    private q C;
    private boolean D;
    private View.OnClickListener F;
    private boolean G;
    private int H;
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
    private s t;
    private r u;
    private boolean v;
    private int w;
    private LayoutInflater x;
    private boolean y;
    private boolean z;
    static int a = 174;
    private static Pattern E = Pattern.compile("(#\\([^#\\)\\(]+\\))");

    public final boolean a() {
        return this.B;
    }

    public static a a(Context context, JSONArray jSONArray, int i) {
        return new a(context, jSONArray, 5);
    }

    public static a a(Context context, JSONArray jSONArray, boolean z) {
        return new a(context, jSONArray, true);
    }

    public static com.baidu.adp.lib.d.b<TextView> a(Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new l(context), 8, 0);
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
        this.o = 200;
        this.p = 200;
        this.q = null;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = null;
        this.v = true;
        this.w = -1;
        this.y = false;
        this.z = false;
        this.A = null;
        this.B = false;
        this.F = new k(this);
        this.G = true;
        b();
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
        this.o = 200;
        this.p = 200;
        this.q = null;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = null;
        this.v = true;
        this.w = -1;
        this.y = false;
        this.z = false;
        this.A = null;
        this.B = false;
        this.F = new k(this);
        this.G = true;
        b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tbadk.d.TbRichTextView);
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
        obtainStyledAttributes.recycle();
    }

    private void b() {
        a = getContext().getResources().getDimensionPixelSize(com.baidu.tbadk.b.adk_default_image_height);
        if (getContext() instanceof j) {
            j jVar = (j) getContext();
            this.b = jVar.e();
            this.c = jVar.f();
            this.d = jVar.h();
            this.e = jVar.i();
            this.f = jVar.g();
            if (jVar.c() != null && this.t == null) {
                this.t = new s(jVar.d());
                jVar.c().setRecyclerListener(this.t);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new m(this));
        this.x = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    public void setText(a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:132:0x0019 */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
        if (r2 != null) goto L117;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(a aVar, boolean z) {
        ArrayList<c> a2;
        boolean a3;
        TbImageView tbImageView;
        SpannableStringBuilder d;
        TbImageView tbImageView2;
        boolean z2;
        GifView gifView;
        GifView gifView2;
        this.D = com.baidu.adp.gif.f.a();
        removeAllViews();
        if (aVar != null && (a2 = aVar.a()) != null) {
            View view = null;
            Iterator<c> it = a2.iterator();
            TextView textView = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.a() == 1) {
                        TextView a4 = a(getContext());
                        a3 = a(next, a4, true);
                        if (z && !this.B && (d = next.d()) != null) {
                            this.B = d.length() >= 200;
                        }
                        tbImageView = a4;
                    } else if (next.a() == 8) {
                        getContext();
                        TbImageView a5 = this.b != null ? this.b.a() : null;
                        if (a5 != null) {
                            ViewParent parent = a5.getParent();
                            tbImageView2 = a5;
                        }
                        tbImageView2 = null;
                        int i = this.o;
                        int i2 = this.p;
                        if (next == null || tbImageView2 == null) {
                            z2 = false;
                        } else {
                            g c = next.c();
                            if (c == null) {
                                z2 = false;
                            } else {
                                tbImageView2.setTag(c.f());
                                int[] a6 = BdUtilHelper.a(c.c(), c.b(), i, i2);
                                if (a6 == null) {
                                    z2 = false;
                                } else {
                                    boolean z3 = !this.v;
                                    if (z3 && (tbImageView2 instanceof TbImageView)) {
                                        z3 = !tbImageView2.c();
                                    }
                                    int[] iArr = {a6[0], a6[1]};
                                    if (!this.v && z3) {
                                        iArr[0] = i;
                                        iArr[1] = a;
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iArr[0], iArr[1]);
                                    if (tbImageView2 instanceof TbImageView) {
                                        TbImageView tbImageView3 = tbImageView2;
                                        tbImageView3.setDefaultResource(this.r);
                                        if (!this.v) {
                                            tbImageView3.setRealShowSize(a6);
                                        }
                                        tbImageView3.setCurrShowSize(iArr);
                                    }
                                    layoutParams.topMargin = this.i;
                                    if (this.q == null) {
                                        tbImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                    } else {
                                        tbImageView2.setScaleType(this.q);
                                    }
                                    tbImageView2.setClickable(true);
                                    tbImageView2.setFocusable(false);
                                    tbImageView2.setOnClickListener(this.F);
                                    tbImageView2.setLayoutParams(layoutParams);
                                    z2 = true;
                                }
                            }
                        }
                        boolean z4 = z2;
                        tbImageView = tbImageView2;
                        a3 = z4;
                    } else {
                        if (next.a() == 32) {
                            if (this.s <= 0 || next == null) {
                                gifView = null;
                            } else {
                                ?? linearLayout = new LinearLayout(getContext());
                                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                                layoutParams2.topMargin = this.i;
                                linearLayout.setClickable(true);
                                linearLayout.setBackgroundResource(this.s);
                                linearLayout.setFocusable(false);
                                linearLayout.setLayoutParams(layoutParams2);
                                linearLayout.setOnClickListener(new n(this, next));
                                gifView = linearLayout;
                            }
                            gifView2 = gifView;
                        } else if (next.a() == 512) {
                            view = getVoiceView();
                            if (view != null) {
                                boolean a7 = a(next, view);
                                tbImageView = view;
                                a3 = a7;
                            }
                        } else if (next.a() == 768) {
                            View textVoiceView = getTextVoiceView();
                            a3 = a(next, (LinearLayout) textVoiceView);
                            tbImageView = textVoiceView;
                        } else if (next.a() != 17) {
                            tbImageView = view;
                            a3 = false;
                        } else {
                            gifView2 = getGifView();
                            GifView gifView3 = gifView2;
                            gifView3.setTag(next.g().c);
                            gifView3.setTbRichTextEmotionInfo(next.g());
                            if (this.G) {
                                next.g().k = false;
                            }
                            gifView3.a(next.g().k, this.H);
                            com.baidu.adp.lib.util.e.e("TbRichTextView", "initGifView", "c:" + next.g());
                            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) gifView3.getLayoutParams();
                            if (layoutParams3 != null && layoutParams3.width == next.g().f && layoutParams3.height == next.g().g) {
                                layoutParams3.bottomMargin = 0;
                            } else {
                                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(next.g().f, next.g().g);
                                layoutParams4.gravity = 3;
                                gifView3.setLayoutParams(layoutParams4);
                            }
                            gifView3.setOnClickListener(new o(this, next));
                            com.baidu.adp.widget.ImageView.b c2 = this.D ? com.baidu.tbadk.imageManager.e.a().c("#@" + next.g().c) : com.baidu.tbadk.imageManager.e.a().c(next.g().c);
                            if (c2 != null || next.g().k) {
                                if (c2 != null) {
                                    next.g().k = false;
                                    gifView3.setGif(c2);
                                }
                            } else if (next.g().j) {
                                gifView3.setGif(null);
                            } else {
                                gifView3.setIsLoading(true);
                            }
                        }
                        a3 = true;
                        tbImageView = gifView2;
                    }
                    if (!a3 || tbImageView == null) {
                        view = tbImageView;
                    } else {
                        addView(tbImageView);
                        textView = tbImageView;
                        view = tbImageView;
                    }
                }
            }
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams5.bottomMargin = this.i;
                textView.setLayoutParams(layoutParams5);
            }
        }
    }

    public int getVideoImageId() {
        return this.s;
    }

    public void setVideoImageId(int i) {
        this.s = i;
    }

    private ImageView getImageView$18c04703() {
        ImageView a2 = this.b != null ? this.b.a() : null;
        if (a2 == null || a2.getParent() != null) {
            return null;
        }
        return a2;
    }

    private TextView a(Context context) {
        TextView textView = null;
        if (this.c != null) {
            textView = this.c.a();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.c(context);
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
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.f != null) {
            gifView = this.f.a();
        }
        if (gifView == null || gifView.getParent() != null) {
            com.baidu.adp.lib.util.e.c("TbRichTextView", "getGifView", "Pool's full, create new one.");
            return new GifView(getContext());
        }
        return gifView;
    }

    private View getVoiceView() {
        View a2 = this.d != null ? this.d.a() : null;
        if (a2 == null || a2.getParent() != null) {
            com.baidu.adp.lib.util.e.e("voice view is null");
            if (this.w != -1) {
                a2 = this.x.inflate(this.w, (ViewGroup) null);
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

    private static boolean a(c cVar, View view) {
        view.setTag(cVar.e());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout a2 = this.e.a();
        if (a2 != null) {
            TextView a3 = a(getContext());
            if (a3 == null) {
                this.e.a((com.baidu.adp.lib.d.b<LinearLayout>) a2);
                return null;
            }
            a2.addView(a3);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.c.a((com.baidu.adp.lib.d.b<TextView>) a3);
                this.e.a((com.baidu.adp.lib.d.b<LinearLayout>) a2);
                return null;
            }
            a2.addView(voiceView);
            return a2;
        }
        return a2;
    }

    private boolean a(c cVar, LinearLayout linearLayout) {
        boolean z;
        boolean z2 = true;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt != null) {
                if (childAt instanceof TextView) {
                    z = a(cVar, (TextView) childAt, false) & z2;
                } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                    z = a(cVar, childAt) & z2;
                }
                i++;
                z2 = z;
            }
            z = z2;
            i++;
            z2 = z;
        }
        return z2;
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

    public r getOnImageClickListener() {
        return this.u;
    }

    public void setOnImageClickListener(r rVar) {
        this.u = rVar;
    }

    public void setOnEmotionClickListener(q qVar) {
        this.C = qVar;
    }

    public final void a(boolean z, boolean z2) {
        if (this.v != z) {
            this.v = z;
            if (!this.v && this.b != null) {
                this.b.b();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.y = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.z) {
                    if (this.A != null) {
                        removeCallbacks(this.A);
                        break;
                    }
                } else {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.y) {
                    this.z = false;
                    if (this.A == null) {
                        this.A = new p(this);
                    }
                    postDelayed(this.A, ViewConfiguration.getLongPressTimeout());
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.y = true;
        return super.onTouchEvent(motionEvent);
    }

    public void setVoiceViewRes(int i) {
        this.w = i;
    }

    public void setShowEmotion(boolean z) {
        this.G = z;
    }

    public void setDefaultGifId(int i) {
        this.H = i;
    }
}
