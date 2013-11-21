package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public static int f981a = 174;
    private com.baidu.adp.lib.d.b<ImageView> b;
    private com.baidu.adp.lib.d.b<TextView> c;
    private com.baidu.adp.lib.d.b<View> d;
    private com.baidu.adp.lib.d.b<LinearLayout> e;
    private a f;
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
    private o t;
    private n u;
    private boolean v;
    private int w;
    private LayoutInflater x;
    private boolean y;
    private View.OnClickListener z;

    public boolean a() {
        return this.y;
    }

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
        return new com.baidu.adp.lib.d.b<>(new k(context), i, 0);
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
        this.z = new j(this);
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
        this.z = new j(this);
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
        f981a = getContext().getResources().getDimensionPixelSize(com.baidu.tbadk.b.adk_default_image_height);
        if (getContext() instanceof i) {
            i iVar = (i) getContext();
            this.b = iVar.e();
            this.c = iVar.f();
            this.d = iVar.d_();
            this.e = iVar.h();
            if (iVar.c() != null && this.t == null) {
                this.t = new o(iVar.d());
                iVar.c().setRecyclerListener(this.t);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new l(this));
        this.x = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    public void setText(a aVar) {
        a(aVar, false);
    }

    public void a(a aVar, boolean z) {
        ArrayList<c> a2;
        LinearLayout linearLayout;
        boolean z2;
        SpannableStringBuilder d;
        View view = null;
        this.f = aVar;
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
                        z2 = a(cVar, b, true);
                        if (z && !this.y && cVar != null && (d = cVar.d()) != null) {
                            this.y = d.length() >= 200;
                        }
                        linearLayout = b;
                    } else if (cVar.a() == 8) {
                        ImageView a3 = a(getContext());
                        boolean a4 = a(cVar, a3, this.o, this.p);
                        linearLayout = a3;
                        z2 = a4;
                    } else if (cVar.a() == 32) {
                        linearLayout = a(cVar);
                        z2 = true;
                    } else if (cVar.a() == 512) {
                        view2 = getVoiceView();
                        if (view2 == null) {
                            linearLayout = view;
                        } else {
                            boolean a5 = a(cVar, view2);
                            linearLayout = view2;
                            z2 = a5;
                        }
                    } else if (cVar.a() == 768) {
                        View textVoiceView = getTextVoiceView();
                        z2 = a(cVar, (LinearLayout) textVoiceView);
                        linearLayout = textVoiceView;
                    } else {
                        linearLayout = view2;
                        z2 = false;
                    }
                    if (!z2 || linearLayout == null) {
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
                layoutParams.bottomMargin = this.i;
                view.setLayoutParams(layoutParams);
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
        linearLayout.setOnClickListener(new m(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.s;
    }

    public void setVideoImageId(int i) {
        this.s = i;
    }

    private ImageView a(Context context) {
        ImageView imageView = null;
        if (this.b != null) {
            imageView = this.b.a();
        }
        if (imageView == null || imageView.getParent() != null) {
            return new com.baidu.adp.widget.ImageView.a(context);
        }
        return imageView;
    }

    private boolean a(c cVar, ImageView imageView, int i, int i2) {
        f c;
        if (cVar == null || imageView == null || (c = cVar.c()) == null) {
            return false;
        }
        imageView.setTag(c.f());
        int[] a2 = com.baidu.adp.lib.h.f.a(c.c(), c.b(), i, i2);
        if (a2 != null) {
            boolean z = !this.v;
            if (z && (imageView instanceof TbImageView)) {
                z = !((TbImageView) imageView).c();
            }
            int[] iArr = {a2[0], a2[1]};
            if (!this.v && z) {
                iArr[0] = i;
                iArr[1] = f981a;
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
            imageView.setOnClickListener(this.z);
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

    private View getVoiceView() {
        View a2 = this.d != null ? this.d.a() : null;
        if (a2 == null || a2.getParent() != null) {
            com.baidu.adp.lib.h.d.d("voice view is null");
            if (this.w != -1) {
                a2 = this.x.inflate(this.w, (ViewGroup) null);
            }
        }
        if (a2 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.i;
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
        LinearLayout a2 = this.e != null ? this.e.a() : null;
        if (a2 != null) {
            TextView b = b(getContext());
            if (b == null) {
                this.e.a((com.baidu.adp.lib.d.b<LinearLayout>) a2);
                return null;
            }
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.c.a((com.baidu.adp.lib.d.b<TextView>) b);
                this.e.a((com.baidu.adp.lib.d.b<LinearLayout>) a2);
                return null;
            }
            a2.addView(b);
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

    public n getOnImageClickListener() {
        return this.u;
    }

    public void setOnImageClickListener(n nVar) {
        this.u = nVar;
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

    public void setVoiceViewRes(int i) {
        this.w = i;
    }
}
