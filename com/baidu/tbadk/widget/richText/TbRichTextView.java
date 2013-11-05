package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.adp.lib.d.b<ImageView> f966a;
    private com.baidu.adp.lib.d.b<TextView> b;
    private com.baidu.adp.lib.d.b<View> c;
    private com.baidu.adp.lib.d.b<LinearLayout> d;
    private a e;
    private float f;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private ImageView.ScaleType p;
    private int q;
    private int r;
    private n s;
    private m t;
    private boolean u;
    private int v;
    private LayoutInflater w;
    private View.OnClickListener x;

    public static a a(Context context, String str) {
        return new a(context, str);
    }

    public static a a(Context context, JSONArray jSONArray, int i) {
        return new a(context, jSONArray, i);
    }

    public static a a(Context context, JSONArray jSONArray, boolean z) {
        return new a(context, jSONArray, z);
    }

    public static com.baidu.adp.lib.d.b<TextView> a(Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new j(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.f966a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0.0f;
        this.g = 0;
        this.h = 0;
        this.i = 15.0f;
        this.j = -1;
        this.k = -1;
        this.l = -16777216;
        this.m = -9989158;
        this.n = 200;
        this.o = 200;
        this.p = null;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = true;
        this.v = -1;
        this.x = new i(this);
        b();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f966a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0.0f;
        this.g = 0;
        this.h = 0;
        this.i = 15.0f;
        this.j = -1;
        this.k = -1;
        this.l = -16777216;
        this.m = -9989158;
        this.n = 200;
        this.o = 200;
        this.p = null;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = true;
        this.v = -1;
        this.x = new i(this);
        b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tbadk.c.TbRichTextView);
        this.h = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.g = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f = obtainStyledAttributes.getFloat(5, 1.2f);
        this.i = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.i);
        this.l = obtainStyledAttributes.getColor(3, this.l);
        this.n = obtainStyledAttributes.getDimensionPixelSize(6, this.n);
        this.o = obtainStyledAttributes.getDimensionPixelSize(7, this.o);
        this.q = obtainStyledAttributes.getResourceId(8, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(9, this.j);
        this.k = obtainStyledAttributes.getDimensionPixelSize(10, this.k);
        this.r = obtainStyledAttributes.getResourceId(11, 0);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        if (getContext() instanceof h) {
            h hVar = (h) getContext();
            this.f966a = hVar.c();
            this.b = hVar.d();
            this.c = hVar.e();
            this.d = hVar.f();
            if (hVar.a() != null && this.s == null) {
                this.s = new n(hVar.b());
                hVar.a().setRecyclerListener(this.s);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new k(this));
        this.w = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    public a getText() {
        return this.e;
    }

    public void setText(a aVar) {
        ArrayList<c> a2;
        LinearLayout linearLayout;
        boolean z;
        View view = null;
        this.e = aVar;
        removeAllViews();
        if (aVar != null && (a2 = aVar.a()) != null) {
            int size = a2.size();
            int i = 0;
            View view2 = null;
            while (i < size) {
                c cVar = a2.get(i);
                if (cVar == null) {
                    linearLayout = view;
                } else {
                    if (cVar.a() == 1) {
                        TextView b = b(getContext());
                        boolean a3 = a(cVar, b, true);
                        linearLayout = b;
                        z = a3;
                    } else if (cVar.a() == 8 && this.u) {
                        ImageView a4 = a(getContext());
                        boolean a5 = a(cVar, a4, this.n, this.o);
                        linearLayout = a4;
                        z = a5;
                    } else if (cVar.a() == 32) {
                        linearLayout = a(cVar);
                        z = true;
                    } else if (cVar.a() == 512) {
                        view2 = getVoiceView();
                        if (view2 == null) {
                            linearLayout = view;
                        } else {
                            boolean a6 = a(cVar, view2);
                            linearLayout = view2;
                            z = a6;
                        }
                    } else if (cVar.a() == 768) {
                        View textVoiceView = getTextVoiceView();
                        z = a(cVar, (LinearLayout) textVoiceView);
                        linearLayout = textVoiceView;
                    } else {
                        linearLayout = view2;
                        z = false;
                    }
                    if (!z || linearLayout == null) {
                        view2 = linearLayout;
                        linearLayout = view;
                    } else {
                        addView(linearLayout);
                        view2 = linearLayout;
                    }
                }
                i++;
                view = linearLayout;
            }
            if (view != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.bottomMargin = this.h;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.r <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.h;
        linearLayout.setClickable(true);
        linearLayout.setBackgroundResource(this.r);
        linearLayout.setFocusable(false);
        linearLayout.setOnClickListener(this.x);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new l(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.r;
    }

    public void setVideoImageId(int i) {
        this.r = i;
    }

    private ImageView a(Context context) {
        ImageView imageView = null;
        if (this.f966a != null) {
            imageView = this.f966a.a();
        }
        if (imageView == null || imageView.getParent() != null) {
            return new com.baidu.adp.widget.ImageView.a(context);
        }
        return imageView;
    }

    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        e c;
        int[] a2;
        if (cVar == null || imageView == null || (c = cVar.c()) == null || (a2 = com.baidu.adp.lib.h.f.a(c.b(), c.a(), i, i2)) == null) {
            return false;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2[0], a2[1]);
        layoutParams.topMargin = this.h;
        if (this.p == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.p);
        }
        imageView.setTag(c.e());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.x);
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof com.baidu.adp.widget.ImageView.a) {
            ((com.baidu.adp.widget.ImageView.a) imageView).setDefaultResource(this.q);
        }
        return true;
    }

    private TextView b(Context context) {
        TextView textView = null;
        if (this.b != null) {
            textView = this.b.a();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.a(context);
        }
        textView.setPadding(this.g, 0, this.g, 0);
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
        layoutParams.topMargin = this.h;
        textView.setLineSpacing(0.0f, this.f);
        textView.setTextSize(0, this.i);
        textView.setTextColor(this.l);
        textView.setLinkTextColor(this.m);
        if (cVar == null || (d = cVar.d()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.k > 0 && this.j > 0) {
            cVar.b(this.j, this.k);
        }
        if (textSize > 0) {
            cVar.a(lineHeight, textSize);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setText(d);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        return true;
    }

    private View getVoiceView() {
        View a2 = this.c != null ? this.c.a() : null;
        if (a2 == null || a2.getParent() != null) {
            com.baidu.adp.lib.h.d.d("voice view is null");
            if (this.v != -1) {
                a2 = this.w.inflate(this.v, (ViewGroup) null);
            }
        }
        if (a2 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.h;
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
        LinearLayout a2 = this.d != null ? this.d.a() : null;
        if (a2 != null) {
            TextView b = b(getContext());
            View voiceView = getVoiceView();
            if (voiceView == null) {
                return null;
            }
            a2.addView(b);
            a2.addView(voiceView);
            return a2;
        }
        return a2;
    }

    private boolean a(c cVar, LinearLayout linearLayout) {
        boolean z = true;
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt != null && (childAt instanceof TextView)) {
                z &= a(cVar, (TextView) childAt, false);
            } else if (childAt != null && childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                z &= a(cVar, childAt);
            }
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
        if (applyDimension != this.i) {
            this.i = applyDimension;
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
        if (i != this.l) {
            this.l = i;
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
        if (this.g != i) {
            this.g = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.g, 0, 0, this.g);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.m) {
            this.m = i;
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
        return this.n;
    }

    public void setMaxImageWidth(int i) {
        this.n = i;
    }

    public int getMaxImageHeight() {
        return this.o;
    }

    public void setMaxImageHeight(int i) {
        this.o = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.p;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.p = scaleType;
    }

    public int getDefaultImageId() {
        return this.q;
    }

    public void setDefaultImageId(int i) {
        this.q = i;
    }

    public m getOnImageClickListener() {
        return this.t;
    }

    public void setOnImageClickListener(m mVar) {
        this.t = mVar;
    }

    public void setDisplayImage(boolean z) {
        if (this.u != z) {
            this.u = z;
            setText(this.e);
            if (!this.u && this.f966a != null) {
                this.f966a.b();
            }
        }
    }

    public void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof ImageView)) {
                ((ImageView) childAt).invalidate();
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.v = i;
    }
}
