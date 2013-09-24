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
    private com.baidu.adp.lib.b.b<ImageView> f837a;
    private com.baidu.adp.lib.b.b<TextView> b;
    private com.baidu.adp.lib.b.b<View> c;
    private a d;
    private float e;
    private int f;
    private int g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private ImageView.ScaleType o;
    private int p;
    private int q;
    private n r;
    private m s;
    private boolean t;
    private int u;
    private LayoutInflater v;
    private View.OnClickListener w;

    public static a a(Context context, String str) {
        return new a(context, str);
    }

    public static a a(Context context, JSONArray jSONArray, boolean z) {
        return new a(context, jSONArray, z);
    }

    public static com.baidu.adp.lib.b.b<TextView> a(Context context, int i) {
        return new com.baidu.adp.lib.b.b<>(new j(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.f837a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0.0f;
        this.f = 0;
        this.g = 0;
        this.h = 15.0f;
        this.i = -1;
        this.j = -1;
        this.k = -16777216;
        this.l = -9989158;
        this.m = 200;
        this.n = 200;
        this.o = null;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = true;
        this.u = -1;
        this.w = new i(this);
        b();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f837a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0.0f;
        this.f = 0;
        this.g = 0;
        this.h = 15.0f;
        this.i = -1;
        this.j = -1;
        this.k = -16777216;
        this.l = -9989158;
        this.m = 200;
        this.n = 200;
        this.o = null;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = true;
        this.u = -1;
        this.w = new i(this);
        b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tbadk.c.TbRichTextView);
        this.g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.e = obtainStyledAttributes.getFloat(5, 1.2f);
        this.h = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.h);
        this.k = obtainStyledAttributes.getColor(3, this.k);
        this.m = obtainStyledAttributes.getDimensionPixelSize(6, this.m);
        this.n = obtainStyledAttributes.getDimensionPixelSize(7, this.n);
        this.p = obtainStyledAttributes.getResourceId(8, 0);
        this.i = obtainStyledAttributes.getDimensionPixelSize(9, this.i);
        this.j = obtainStyledAttributes.getDimensionPixelSize(10, this.j);
        this.q = obtainStyledAttributes.getResourceId(11, 0);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        if (getContext() instanceof h) {
            h hVar = (h) getContext();
            this.f837a = hVar.c();
            this.b = hVar.d();
            this.c = hVar.e();
            if (hVar.a() != null && this.r == null) {
                this.r = new n(hVar.b());
                hVar.a().setRecyclerListener(this.r);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new k(this));
        this.v = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    public a getText() {
        return this.d;
    }

    public void setText(a aVar) {
        ArrayList<c> a2;
        LinearLayout linearLayout;
        boolean z;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3 = null;
        this.d = aVar;
        removeAllViews();
        if (aVar != null && (a2 = aVar.a()) != null) {
            int size = a2.size();
            int i = 0;
            LinearLayout linearLayout4 = null;
            while (i < size) {
                c cVar = a2.get(i);
                if (cVar == null) {
                    linearLayout = linearLayout3;
                    linearLayout2 = linearLayout4;
                } else {
                    if (cVar.a() == 1) {
                        TextView b = b(getContext());
                        boolean a3 = a(cVar, b);
                        linearLayout = b;
                        z = a3;
                    } else if (cVar.a() == 8 && this.t) {
                        ImageView a4 = a(getContext());
                        boolean a5 = a(cVar, a4, this.m, this.n);
                        linearLayout = a4;
                        z = a5;
                    } else if (cVar.a() == 32) {
                        linearLayout = a(cVar);
                        z = true;
                    } else if (cVar.a() == 512) {
                        View voiceView = getVoiceView();
                        if (voiceView == null) {
                            linearLayout = linearLayout3;
                            linearLayout2 = voiceView;
                        } else {
                            boolean a6 = a(cVar, voiceView);
                            linearLayout = voiceView;
                            z = a6;
                        }
                    } else {
                        linearLayout = linearLayout4;
                        z = false;
                    }
                    if (!z || linearLayout == null) {
                        LinearLayout linearLayout5 = linearLayout3;
                        linearLayout2 = linearLayout;
                        linearLayout = linearLayout5;
                    } else {
                        addView(linearLayout);
                        linearLayout2 = linearLayout;
                    }
                }
                i++;
                linearLayout4 = linearLayout2;
                linearLayout3 = linearLayout;
            }
            if (linearLayout3 != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                layoutParams.bottomMargin = this.g;
                linearLayout3.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.q <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.g;
        linearLayout.setClickable(true);
        linearLayout.setBackgroundResource(this.q);
        linearLayout.setFocusable(false);
        linearLayout.setOnClickListener(this.w);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new l(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.q;
    }

    public void setVideoImageId(int i) {
        this.q = i;
    }

    private ImageView a(Context context) {
        ImageView imageView = null;
        if (this.f837a != null) {
            imageView = this.f837a.a();
        }
        if (imageView == null || imageView.getParent() != null) {
            return new com.baidu.adp.widget.a.a(context);
        }
        return imageView;
    }

    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        e c;
        int[] a2;
        if (cVar == null || imageView == null || (c = cVar.c()) == null || (a2 = com.baidu.adp.lib.f.f.a(c.b(), c.a(), i, i2)) == null) {
            return false;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2[0], a2[1]);
        layoutParams.topMargin = this.g;
        if (this.o == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.o);
        }
        imageView.setTag(c.e());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.w);
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof com.baidu.adp.widget.a.a) {
            ((com.baidu.adp.widget.a.a) imageView).setDefaultResource(this.p);
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
        textView.setPadding(this.f, 0, this.f, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView) {
        CharSequence d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.g;
        textView.setLineSpacing(0.0f, this.e);
        textView.setTextSize(0, this.h);
        textView.setTextColor(this.k);
        textView.setLinkTextColor(this.l);
        if (cVar == null || (d = cVar.d()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.j > 0 && this.i > 0) {
            cVar.b(this.i, this.j);
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
            com.baidu.adp.lib.f.d.c("voice view is null");
            if (this.u != -1) {
                a2 = this.v.inflate(this.u, (ViewGroup) null);
            }
        }
        if (a2 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.g;
            a2.setLayoutParams(layoutParams);
            return a2;
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        view.setTag(cVar.e());
        return true;
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
        if (applyDimension != this.h) {
            this.h = applyDimension;
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
        if (i != this.k) {
            this.k = i;
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
        if (this.f != i) {
            this.f = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.f, 0, 0, this.f);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.l) {
            this.l = i;
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
        return this.m;
    }

    public void setMaxImageWidth(int i) {
        this.m = i;
    }

    public int getMaxImageHeight() {
        return this.n;
    }

    public void setMaxImageHeight(int i) {
        this.n = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.o;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.o = scaleType;
    }

    public int getDefaultImageId() {
        return this.p;
    }

    public void setDefaultImageId(int i) {
        this.p = i;
    }

    public m getOnImageClickListener() {
        return this.s;
    }

    public void setOnImageClickListener(m mVar) {
        this.s = mVar;
    }

    public void setDisplayImage(boolean z) {
        if (this.t != z) {
            this.t = z;
            setText(this.d);
            if (!this.t && this.f837a != null) {
                this.f837a.b();
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
        this.u = i;
    }
}
