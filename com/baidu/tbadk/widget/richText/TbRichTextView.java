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

    public boolean a() {
        return this.B;
    }

    public static a a(Context context, JSONArray jSONArray, int i) {
        return new a(context, jSONArray, i);
    }

    public static a a(Context context, JSONArray jSONArray, boolean z) {
        return new a(context, jSONArray, z);
    }

    public static com.baidu.adp.lib.d.b<TextView> a(Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new l(context), i, 0);
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
            this.d = jVar.c_();
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x001b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    public void a(a aVar, boolean z) {
        ArrayList<c> a2;
        boolean a3;
        TextView textView;
        SpannableStringBuilder d;
        this.D = com.baidu.adp.gif.f.a();
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
                        if (z && !this.B && (d = next.d()) != null) {
                            this.B = d.length() >= 200;
                        }
                        textView = b;
                    } else if (next.a() == 8) {
                        ImageView a4 = a(getContext());
                        boolean a5 = a(next, a4, this.o, this.p);
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
        linearLayout.setOnClickListener(new n(this, cVar));
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
        imageView.setTag(c.f());
        int[] a2 = BdUtilHelper.a(c.c(), c.b(), i, i2);
        if (a2 != null) {
            boolean z = !this.v;
            if (z && (imageView instanceof TbImageView)) {
                z = !((TbImageView) imageView).e();
            }
            int[] iArr = {a2[0], a2[1]};
            if (!this.v && z) {
                iArr[0] = i;
                iArr[1] = a;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iArr[0], iArr[1]);
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.r);
                if (!this.v) {
                    tbImageView.setRealShowSize(a2);
                }
                tbImageView.setCurrShowSize(iArr);
            }
            layoutParams.topMargin = this.i;
            if (this.q == null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                imageView.setScaleType(this.q);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            imageView.setOnClickListener(this.F);
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
            com.baidu.adp.lib.util.f.c("TbRichTextView", "getGifView", "Pool's full, create new one.");
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
        com.baidu.adp.widget.ImageView.b c;
        gifView.setTag(cVar.g().c);
        gifView.setTbRichTextEmotionInfo(cVar.g());
        if (this.G) {
            cVar.g().k = false;
        }
        gifView.a(cVar.g().k, this.H);
        com.baidu.adp.lib.util.f.e("TbRichTextView", "initGifView", "c:" + cVar.g());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.g().f || layoutParams.height != cVar.g().g) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.g().f, cVar.g().g);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new o(this, cVar));
        if (this.D) {
            c = com.baidu.tbadk.imageManager.e.a().c("#@" + cVar.g().c);
        } else {
            c = com.baidu.tbadk.imageManager.e.a().c(cVar.g().c);
        }
        if (c == null && !cVar.g().k) {
            if (cVar.g().j) {
                gifView.setGif(null);
            } else {
                gifView.setIsLoading(true);
            }
        } else if (c != null) {
            cVar.g().k = false;
            gifView.setGif(c);
        }
        return true;
    }

    private View getVoiceView() {
        View a2 = this.d != null ? this.d.a() : null;
        if (a2 == null || a2.getParent() != null) {
            com.baidu.adp.lib.util.f.e("voice view is null");
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

    public r getOnImageClickListener() {
        return this.u;
    }

    public void setOnImageClickListener(r rVar) {
        this.u = rVar;
    }

    public void setOnEmotionClickListener(q qVar) {
        this.C = qVar;
    }

    public void a(boolean z, boolean z2) {
        if (this.v != z) {
            this.v = z;
            if (z2) {
                requestLayout();
            }
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
                    d();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.y) {
                    c();
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

    private void c() {
        this.z = false;
        if (this.A == null) {
            this.A = new p(this);
        }
        postDelayed(this.A, ViewConfiguration.getLongPressTimeout());
    }

    private void d() {
        if (this.A != null) {
            removeCallbacks(this.A);
        }
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
