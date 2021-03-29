package com.baidu.tieba.aiapps.apps.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.g0.a.i2.h0;
import d.b.g0.a.q1.b.e.a;
import d.b.g0.a.q1.b.e.b;
/* loaded from: classes4.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    public static final int[] f0 = {8, 0, 4};
    public View A;
    public ImageView B;
    public int C;
    public View D;
    public View E;
    public View F;
    public String G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public Drawable M;
    public Drawable N;
    public d.b.g0.a.q1.a.a O;
    public TextView P;
    public b.a Q;
    public boolean R;
    public View S;
    public View T;
    public d U;
    public int V;
    public View W;
    public TextView a0;
    public String b0;
    public int c0;
    public ProgressBar d0;

    /* renamed from: e  reason: collision with root package name */
    public View f14698e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f14699f;

    /* renamed from: g  reason: collision with root package name */
    public View f14700g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f14701h;
    public int i;
    public String j;
    public String k;
    public int l;
    public float m;
    public float n;
    public float o;
    public int p;
    public TextView q;
    public TextView r;
    public TextView s;
    public int t;
    public View u;
    public TextView v;
    public ProgressBar w;
    public ImageView x;
    public int y;
    public ImageView z;

    /* loaded from: classes4.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetector f14702e;

        public b(GestureDetector gestureDetector) {
            this.f14702e = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f14702e.onTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.U != null) {
                SwanAppBdActionBar.this.U.a(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.e0;
        }

        public /* synthetic */ c(SwanAppBdActionBar swanAppBdActionBar, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.H = -1;
        this.c0 = -1;
        d();
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public final Drawable c(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.d0 = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        TextView textView = (TextView) findViewById(R.id.left_first_view);
        this.q = textView;
        textView.setCompoundDrawables(c(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.q.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color));
        this.r = (TextView) findViewById(R.id.title_text_center);
        TextView textView2 = (TextView) findViewById(R.id.subtitle_text_center);
        this.s = textView2;
        textView2.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        TextView textView3 = (TextView) findViewById(R.id.left_second_view);
        this.P = textView3;
        textView3.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        float f2 = this.m;
        if (f2 != -1.0f) {
            float f3 = this.n;
            if (f3 != -1.0f) {
                float f4 = this.o;
                if (f4 != -1.0f) {
                    this.q.setShadowLayer(f4, f2, f3, this.l);
                }
            }
        }
        View findViewById = findViewById(R.id.titlebar_right_txtzone2);
        this.W = findViewById;
        findViewById.setVisibility(f0[this.V]);
        TextView textView4 = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        this.a0 = textView4;
        String str = this.b0;
        if (str != null) {
            textView4.setText(str);
        }
        int i = this.c0;
        if (i != -1) {
            this.a0.setTextColor(i);
        } else {
            this.a0.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        View findViewById2 = findViewById(R.id.titlebar_right_txtzone1);
        this.u = findViewById2;
        findViewById2.setVisibility(f0[this.J]);
        TextView textView5 = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        this.v = textView5;
        String str2 = this.G;
        if (str2 != null) {
            textView5.setText(str2);
        }
        int i2 = this.H;
        if (i2 != -1) {
            this.v.setTextColor(i2);
        } else {
            this.v.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.w = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.x = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.z = (ImageView) findViewById(R.id.new_tip_img);
        View findViewById3 = findViewById(R.id.titlebar_right_imgzone2);
        this.A = findViewById3;
        findViewById3.setVisibility(f0[this.L]);
        this.B = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        View findViewById4 = findViewById(R.id.titlebar_right_imgzone1);
        this.D = findViewById4;
        findViewById4.setVisibility(f0[this.K]);
        View findViewById5 = findViewById(R.id.titlebar_right_zones);
        this.F = findViewById5;
        findViewById5.setVisibility(f0[this.I]);
        this.S = findViewById(R.id.titlebar_left_zones);
        this.E = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.T = findViewById(R.id.titlebar_center_zones);
        this.f14698e = findViewById(R.id.titlebar_right_menu);
        this.f14699f = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.f14700g = findViewById(R.id.titlebar_right_menu_line);
        this.f14701h = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.j);
        setTitleColor(R.color.aiapps_black_text);
        setRightMenuImageSrc(R.drawable.aiapps_action_bar_menu_normal_selector);
        setRightImgZone2Src(R.drawable.aiapps_action_bar_add_2_selector);
        setRightImgZone1Src(R.drawable.aiapps_action_bar_add_selector);
        setOnTouchListener(new b(new GestureDetector(getContext(), new c(this, null))));
    }

    public final void e(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SwanAppBdActionBar, 0, 0);
        try {
            this.j = obtainStyledAttributes.getString(R$styleable.SwanAppBdActionBar_titleText);
            this.l = obtainStyledAttributes.getColor(R$styleable.SwanAppBdActionBar_titleTxtShadowColor, -16777216);
            this.m = obtainStyledAttributes.getFloat(R$styleable.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
            this.n = obtainStyledAttributes.getFloat(R$styleable.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
            this.o = obtainStyledAttributes.getFloat(R$styleable.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
            this.V = obtainStyledAttributes.getInt(R$styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
            this.b0 = obtainStyledAttributes.getString(R$styleable.SwanAppBdActionBar_rightTxtZone1Text);
            this.J = obtainStyledAttributes.getInt(R$styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
            this.G = obtainStyledAttributes.getString(R$styleable.SwanAppBdActionBar_rightTxtZone1Text);
            this.M = obtainStyledAttributes.getDrawable(R$styleable.SwanAppBdActionBar_rightImgZone2ImageSrc);
            this.I = obtainStyledAttributes.getInt(R$styleable.SwanAppBdActionBar_rightZonesVisibility, 0);
            this.N = obtainStyledAttributes.getDrawable(R$styleable.SwanAppBdActionBar_rightImgZone1ImageSrc);
            this.K = obtainStyledAttributes.getInt(R$styleable.SwanAppBdActionBar_rightImgZone1Visibility, 0);
            this.L = obtainStyledAttributes.getInt(R$styleable.SwanAppBdActionBar_rightImgZone2Visibility, 0);
            this.H = obtainStyledAttributes.getColor(R$styleable.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
            obtainStyledAttributes.getDimension(R$styleable.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
            obtainStyledAttributes.getColor(R$styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, -16777216);
            obtainStyledAttributes.getFloat(R$styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
            obtainStyledAttributes.getFloat(R$styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
            obtainStyledAttributes.getFloat(R$styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
            this.t = obtainStyledAttributes.getInt(R$styleable.SwanAppBdActionBar_titleAlignment, 1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void f(String str) {
    }

    public int getRightImgZone1ImageSrcId() {
        return this.C;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.y;
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.E.getVisibility();
    }

    public View getRightMenu() {
        return this.f14698e;
    }

    public int getRightMenuImageViewSrcId() {
        return this.i;
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.w.getVisibility();
    }

    public int getRightTxtZone1Visibility() {
        return this.u.getVisibility();
    }

    public int getRightTxtZone2Visibility() {
        return this.W.getVisibility();
    }

    public String getSubTitle() {
        return this.k;
    }

    public String getTitle() {
        return this.j;
    }

    public int getTitleColorId() {
        return this.p;
    }

    public TextView getTitleViewCenter() {
        return this.r;
    }

    public void setActionBarCustom(boolean z) {
        this.e0 = z;
        int i = z ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.T.setVisibility(i);
    }

    @TargetApi(16)
    public void setImgZoneBackgroundResource(int i) {
        this.q.setBackground(getResources().getDrawable(i));
        this.D.setBackground(getResources().getDrawable(i));
        this.A.setBackground(getResources().getDrawable(i));
        this.P.setBackground(getResources().getDrawable(i));
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        TextView textView = this.q;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setLeftFirstViewVisibility(boolean z) {
        TextView textView = this.q;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.P.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.P.setCompoundDrawables(drawable, null, null, null);
        this.P.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.P.setCompoundDrawablePadding(i);
    }

    public void setLeftSecondViewText(String str) {
        if (this.P.getVisibility() == 0) {
            this.P.setText(str);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.P.getVisibility() == 0) {
            this.P.setTextSize(i);
        }
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.P.getVisibility() == i) {
            return;
        }
        this.P.setVisibility(i);
        f(this.j);
    }

    public void setLeftTitle(String str) {
        this.q.setText(str);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.R = z;
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.q.setSelected(z);
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.q.setCompoundDrawables(drawable, null, null, null);
        this.q.setSelected(false);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.q.setMinimumWidth(i);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.q.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.q.setOnClickListener(onClickListener);
    }

    public void setLeftZonesVisibility(int i) {
        this.S.setVisibility(i);
    }

    public void setOnDoubleClickListener(d dVar) {
        this.U = dVar;
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.Q = aVar;
        d.b.g0.a.q1.a.a aVar2 = this.O;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0766a interfaceC0766a) {
    }

    public void setRightExitImageSrc(int i) {
        this.f14701h.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.f14701h.setOnClickListener(onClickListener);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.f14701h.setVisibility(0);
            this.f14700g.setVisibility(0);
            return;
        }
        this.f14701h.setVisibility(8);
        this.f14700g.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.f14698e.getLayoutParams()).setMargins(0, 0, h0.e(getContext(), 4.6f), 0);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.D.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.D.setEnabled(z);
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.B.setScaleType(scaleType);
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.C = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.D.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Src(int i) {
        this.C = i;
        this.B.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1Visibility(int i) {
        this.D.setVisibility(i);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.x.setEnabled(z);
        this.A.setEnabled(z);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.x.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.M = drawable;
        this.x.setImageDrawable(drawable);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.x.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.E.setVisibility(i);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.A.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.x.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Src(int i) {
        this.y = i;
        this.x.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2Visibility(int i) {
        this.A.setVisibility(i);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.A.setLayoutParams(layoutParams);
    }

    public void setRightMenuBgSrc(int i) {
        this.f14698e.setBackgroundResource(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.f14698e.setOnClickListener(onClickListener);
    }

    public void setRightMenuImageSrc(int i) {
        this.i = i;
        this.f14699f.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.f14700g.setBackgroundResource(i);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.f14699f.setOnClickListener(onClickListener);
    }

    public void setRightMenuVisibility(boolean z) {
        this.f14698e.setVisibility(z ? 0 : 8);
    }

    public void setRightTipsStatus(boolean z) {
        this.z.setVisibility(z ? 0 : 8);
    }

    public void setRightTxtZone1Background(int i) {
        this.u.setBackgroundResource(i);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.u.setClickable(z);
        this.v.setEnabled(z);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.u.setEnabled(z);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.u.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Text(int i) {
        this.v.setText(i);
    }

    public void setRightTxtZone1TextColor(int i) {
        this.v.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.v.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        TextView textView = this.v;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.v.setTextSize(0, i);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.F.setVisibility(0);
        }
        this.u.setVisibility(i);
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.W.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.a0.setText(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.F.setVisibility(0);
        }
        this.W.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.F.setVisibility(i);
    }

    public void setSubTitle(String str) {
        this.k = str;
        if (TextUtils.isEmpty(str)) {
            this.s.setVisibility(8);
        } else {
            this.s.setVisibility(0);
        }
        int i = this.t;
        if (1 == i) {
            this.s.setText(str);
        } else if (i == 0) {
            this.s.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitleColor(int i) {
        this.s.setTextColor(i);
    }

    public void setTitle(String str) {
        this.j = str;
        int i = this.t;
        if (1 == i) {
            this.r.setText(str);
            if (this.R) {
                f(str);
            } else {
                this.q.setText((CharSequence) null);
            }
        } else if (i == 0) {
            this.q.setText(str);
            this.r.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitleAlignment(int i) {
        this.t = i;
        setTitle(this.j);
    }

    public void setTitleBarTitleSize(float f2) {
        this.r.setTextSize(0, f2);
    }

    public void setTitleColor(int i) {
        this.p = i;
        this.r.setTextColor(getResources().getColor(i));
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.q.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i) {
        this.q.setShadowLayer(f2, f3, f4, i);
        this.r.setShadowLayer(f2, f3, f4, i);
    }

    public void setTitleSize(int i) {
        this.q.setTextSize(0, i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.u.setMinimumHeight(i);
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.u.setMinimumWidth(i);
    }

    @TargetApi(16)
    public void setTxtZoneBackgroundResource(int i) {
        this.u.setBackground(getResources().getDrawable(i));
        this.W.setBackground(getResources().getDrawable(i));
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.v.setText(charSequence);
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.N = drawable;
        this.B.setImageDrawable(drawable);
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = -1;
        this.c0 = -1;
        e(context, attributeSet);
        d();
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.P.setCompoundDrawables(drawable, null, null, null);
        this.P.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.q.setCompoundDrawables(drawable, null, null, null);
        this.q.setSelected(false);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.D.setLayoutParams(layoutParams);
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.H = -1;
        this.c0 = -1;
        e(context, attributeSet);
        d();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }
}
