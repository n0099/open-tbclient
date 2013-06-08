package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout {
    private com.baidu.adp.lib.c.b a;
    private com.baidu.adp.lib.c.b b;
    private a c;
    private float d;
    private int e;
    private int f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private ImageView.ScaleType n;
    private int o;
    private int p;
    private n q;
    private m r;
    private boolean s;
    private View.OnClickListener t;

    public static a a(Context context, String str) {
        return new a(context, str);
    }

    public static a a(Context context, JSONArray jSONArray, boolean z) {
        return new a(context, jSONArray, z);
    }

    public static com.baidu.adp.lib.c.b a(Context context, int i) {
        return new com.baidu.adp.lib.c.b(new j(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0.0f;
        this.e = 0;
        this.f = 0;
        this.g = 15.0f;
        this.h = -1;
        this.i = -1;
        this.j = -16777216;
        this.k = -9989158;
        this.l = 200;
        this.m = 200;
        this.n = null;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = true;
        this.t = new i(this);
        b();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0.0f;
        this.e = 0;
        this.f = 0;
        this.g = 15.0f;
        this.h = -1;
        this.i = -1;
        this.j = -16777216;
        this.k = -9989158;
        this.l = 200;
        this.m = 200;
        this.n = null;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = true;
        this.t = new i(this);
        b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tbadk.b.TbRichTextView);
        this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.e = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.d = obtainStyledAttributes.getFloat(5, 1.2f);
        this.g = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.g);
        this.j = obtainStyledAttributes.getColor(3, this.j);
        this.l = obtainStyledAttributes.getDimensionPixelSize(6, this.l);
        this.m = obtainStyledAttributes.getDimensionPixelSize(7, this.m);
        this.o = obtainStyledAttributes.getResourceId(8, 0);
        this.h = obtainStyledAttributes.getDimensionPixelSize(9, this.h);
        this.i = obtainStyledAttributes.getDimensionPixelSize(10, this.i);
        this.p = obtainStyledAttributes.getResourceId(11, 0);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        if (getContext() instanceof h) {
            h hVar = (h) getContext();
            this.a = hVar.c();
            this.b = hVar.d();
            if (hVar.a() != null && this.q == null) {
                this.q = new n(hVar.b());
                hVar.a().setRecyclerListener(this.q);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new k(this));
    }

    public a getText() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    public void setText(a aVar) {
        ArrayList a;
        LinearLayout linearLayout;
        boolean z;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3 = 0;
        this.c = aVar;
        removeAllViews();
        if (aVar != null && (a = aVar.a()) != null) {
            int size = a.size();
            int i = 0;
            LinearLayout linearLayout4 = null;
            while (i < size) {
                c cVar = (c) a.get(i);
                if (cVar == null) {
                    linearLayout = linearLayout3;
                    linearLayout2 = linearLayout4;
                } else {
                    if (cVar.a() == 1) {
                        TextView b = b(getContext());
                        boolean a2 = a(cVar, b);
                        linearLayout = b;
                        z = a2;
                    } else if (cVar.a() == 8 && this.s) {
                        ImageView a3 = a(getContext());
                        boolean a4 = a(cVar, a3, this.l, this.m);
                        linearLayout = a3;
                        z = a4;
                    } else if (cVar.a() == 32) {
                        linearLayout = a(cVar);
                        z = true;
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
                layoutParams.bottomMargin = this.f;
                linearLayout3.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout a(c cVar) {
        if (this.p <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.f;
        linearLayout.setClickable(true);
        linearLayout.setBackgroundResource(this.p);
        linearLayout.setFocusable(false);
        linearLayout.setOnClickListener(this.t);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new l(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.p;
    }

    public void setVideoImageId(int i) {
        this.p = i;
    }

    private ImageView a(Context context) {
        ImageView imageView = null;
        if (this.a != null) {
            imageView = (ImageView) this.a.a();
        }
        if (imageView == null || imageView.getParent() != null) {
            return new com.baidu.adp.widget.a.a(context);
        }
        return imageView;
    }

    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        e c;
        int[] a;
        if (cVar == null || imageView == null || (c = cVar.c()) == null || (a = com.baidu.adp.lib.e.c.a(c.b(), c.a(), i, i2)) == null) {
            return false;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a[0], a[1]);
        layoutParams.topMargin = this.f;
        if (this.n == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.n);
        }
        imageView.setTag(c.d());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.t);
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof com.baidu.adp.widget.a.a) {
            ((com.baidu.adp.widget.a.a) imageView).setDefaultResource(this.o);
        }
        return true;
    }

    private TextView b(Context context) {
        TextView textView = null;
        if (this.b != null) {
            textView = (TextView) this.b.a();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new com.baidu.tbadk.widget.a(context);
        }
        textView.setPadding(this.e, 0, this.e, 0);
        return textView;
    }

    private boolean a(c cVar, TextView textView) {
        CharSequence d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f;
        textView.setLineSpacing(0.0f, this.d);
        textView.setTextSize(0, this.g);
        textView.setTextColor(this.j);
        textView.setLinkTextColor(this.k);
        if (cVar == null || (d = cVar.d()) == null) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.i > 0 && this.h > 0) {
            cVar.b(this.h, this.i);
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

    public void setTextSize(float f) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f, resources.getDisplayMetrics());
        if (applyDimension != this.g) {
            this.g = applyDimension;
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
        if (i != this.j) {
            this.j = i;
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
        if (this.e != i) {
            this.e = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.e, 0, 0, this.e);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.k) {
            this.k = i;
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
        return this.l;
    }

    public void setMaxImageWidth(int i) {
        this.l = i;
    }

    public int getMaxImageHeight() {
        return this.m;
    }

    public void setMaxImageHeight(int i) {
        this.m = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.n;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.n = scaleType;
    }

    public int getDefaultImageId() {
        return this.o;
    }

    public void setDefaultImageId(int i) {
        this.o = i;
    }

    public m getOnImageClickListener() {
        return this.r;
    }

    public void setOnImageClickListener(m mVar) {
        this.r = mVar;
    }

    public void setDisplayImage(boolean z) {
        if (this.s != z) {
            this.s = z;
            setText(this.c);
            if (!this.s && this.a != null) {
                this.a.b();
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
}
