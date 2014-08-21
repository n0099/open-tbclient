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
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int a = 174;
    private boolean A;
    private Runnable B;
    private boolean C;
    private r D;
    private a E;
    private String F;
    private final View.OnClickListener G;
    private boolean H;
    private Drawable I;
    private String J;
    private final int K;
    private BdUniqueId L;
    private final com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> M;
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
    private boolean z;

    public boolean a() {
        return this.C;
    }

    public String getBackgroundImageUrl() {
        return this.F;
    }

    public void setBackgroundImageUrl(String str) {
        this.F = str;
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

    public static a a(Context context, List<PbContent> list, boolean z) {
        return new a(context, list, z);
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
        this.z = false;
        this.A = false;
        this.B = null;
        this.C = false;
        this.F = null;
        this.G = new k(this);
        this.K = 19;
        this.M = new l(this);
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
        this.z = false;
        this.A = false;
        this.B = null;
        this.C = false;
        this.F = null;
        this.G = new k(this);
        this.K = 19;
        this.M = new l(this);
        d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.TbRichTextView);
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
        a = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.adk_default_image_height);
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
    }

    public void setText(a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0018 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0018 */
    public void a(a aVar, boolean z) {
        ArrayList<c> a2;
        int i;
        boolean z2;
        SpannableStringBuilder d;
        this.E = aVar;
        removeAllViews();
        if (aVar != null && (a2 = aVar.a()) != null) {
            Iterator<c> it = a2.iterator();
            int i2 = 0;
            View view = null;
            View view2 = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    if (next.a() == 1) {
                        TextView b = b(getContext());
                        boolean a3 = a(next, b, true);
                        if (z && !this.C && (d = next.d()) != null) {
                            this.C = d.length() >= 200;
                        }
                        i = i2;
                        view2 = b;
                        z2 = a3;
                    } else if (next.a() == 8) {
                        if (i2 < 10) {
                            ImageView a4 = a(getContext());
                            z2 = a(next, a4, (this.o - getPaddingLeft()) - getPaddingRight(), this.p);
                            i = i2 + 1;
                            view2 = a4;
                        }
                    } else if (next.a() == 32) {
                        LinearLayout a5 = a(next);
                        z2 = true;
                        i = i2;
                        view2 = a5;
                    } else if (next.a() == 512) {
                        view2 = getVoiceView();
                        if (view2 != null) {
                            z2 = a(next, view2);
                            i = i2;
                            view2 = view2;
                        }
                    } else if (next.a() == 768) {
                        View textVoiceView = getTextVoiceView();
                        view2 = textVoiceView;
                        z2 = a(next, (LinearLayout) textVoiceView);
                        i = i2;
                    } else if (next.a() == 17) {
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
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.i;
        linearLayout.setClickable(true);
        Bitmap a2 = com.baidu.tbadk.core.util.d.a(this.s);
        if (a2 != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), a2));
        }
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
        int[] a2 = com.baidu.adp.lib.util.j.a(c.c(), c.b(), i, i2);
        if (a2 != null) {
            boolean z = !this.w;
            int[] iArr = {a2[0], a2[1]};
            if (!this.w && z) {
                iArr[0] = i;
                iArr[1] = a;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iArr[0], iArr[1]);
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.r);
                if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                    tbImageView.setGifIconSupport(false);
                }
            }
            layoutParams.topMargin = this.i;
            if (this.q == null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                imageView.setScaleType(this.q);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            imageView.setOnClickListener(this.G);
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
            cVar.f().d = this.H;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.f != null) {
            gifView = this.f.a();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(c cVar, GifView gifView) {
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
        if ((a2 == null || a2.getParent() != null) && this.y != -1) {
            a2 = com.baidu.adp.lib.e.b.a().a(getContext(), this.y, null);
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
        this.D = rVar;
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
        this.z = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.A) {
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
                if (!this.z) {
                    e();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.z = true;
        return super.onTouchEvent(motionEvent);
    }

    private void e() {
        this.A = false;
        if (this.B == null) {
            this.B = new q(this);
        }
        postDelayed(this.B, ViewConfiguration.getLongPressTimeout());
    }

    private void f() {
        if (this.B != null) {
            removeCallbacks(this.B);
        }
    }

    public void setVoiceViewRes(int i) {
        this.y = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.F = null;
        if (this.I != drawable) {
            this.H = true;
            this.I = drawable;
        }
        setText(this.E);
        this.H = false;
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
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.J = str;
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
        if (!(str.equals(this.J) && this.L == bdUniqueId)) {
            c();
        }
        this.J = str;
        this.L = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.J, 19, new Object[0]);
        if (aVar != null) {
            a(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.resourceLoader.d.a().a(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.J, 19, this.M, 0, 0, this.L, new Object[0]);
        }
    }

    public void c() {
        if (!TextUtils.isEmpty(this.J)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.J, 19, this.M);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.h(), aVar.h().getNinePatchChunk(), aVar.l(), null);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void b() {
        a(this.J);
    }
}
