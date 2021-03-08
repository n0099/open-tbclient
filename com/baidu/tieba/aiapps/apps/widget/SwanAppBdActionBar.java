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
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    private static final int[] VISIBILITY_FLAGS = {8, 0, 4};
    private int anp;
    private a.InterfaceC0454a dEs;
    private boolean dTa;
    private ImageView dTj;
    private ImageView dTk;
    private View dTm;
    private View goP;
    private int goQ;
    private String goR;
    private String goS;
    private int goT;
    private float goU;
    private float goV;
    private float goW;
    private TextView goX;
    private TextView goY;
    private TextView goZ;
    private com.baidu.swan.apps.res.ui.a gpA;
    private TextView gpB;
    private b.a gpC;
    private boolean gpD;
    private View gpE;
    private View gpF;
    private b gpG;
    private int gpH;
    private View gpI;
    private TextView gpJ;
    private String gpK;
    private int gpL;
    private ProgressBar gpM;
    private int gpa;
    private View gpb;
    private TextView gpc;
    private ProgressBar gpd;
    private ImageView gpe;
    private int gpf;
    private ImageView gpg;
    private View gph;
    private ImageView gpi;
    private int gpj;
    private View gpk;
    private View gpl;
    private View gpm;
    private String gpn;
    private int gpo;
    private float gpp;
    private int gpq;
    private float gpr;
    private float gps;
    private float gpt;
    private int gpu;
    private int gpv;
    private int gpw;
    private int gpx;
    private Drawable gpy;
    private Drawable gpz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes8.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes8.dex */
    public interface b {
        void ax(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.gpo = -1;
        this.gpp = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bOc();
            }
        };
        this.gpL = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gpo = -1;
        this.gpp = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bOc();
            }
        };
        this.gpL = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gpo = -1;
        this.gpp = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bOc();
            }
        };
        this.gpL = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwanAppBdActionBar, 0, 0);
            try {
                this.goR = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_titleText);
                this.goT = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.goU = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.goV = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.goW = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.gpH = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gpK = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gpv = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gpn = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gpy = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.gpu = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.gpz = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.gpw = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.gpx = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.gpo = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.gpp = obtainStyledAttributes.getDimension(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.gpq = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.gpr = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.gps = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.gpt = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.gpa = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.dTm.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.gpC = aVar;
        if (this.gpA != null) {
            this.gpA.a(this.gpC);
        }
    }

    public boolean bOc() {
        if (this.gpA != null) {
            int[] iArr = new int[2];
            this.dTm.getLocationInWindow(iArr);
            int T = ah.T(6.0f);
            int height = iArr[1] + this.dTm.getHeight() + ah.T(4.0f);
            this.gpA.getView().getWidth();
            this.gpA.v(0, (ah.getDisplayWidth(getContext()) - T) - this.gpA.getView().getWidth(), height);
            this.gpA.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.gpM = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.goX = (TextView) findViewById(R.id.left_first_view);
        this.goX.setCompoundDrawables(ku(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.goX.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color));
        this.goY = (TextView) findViewById(R.id.title_text_center);
        this.goZ = (TextView) findViewById(R.id.subtitle_text_center);
        this.goZ.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.gpB = (TextView) findViewById(R.id.left_second_view);
        this.gpB.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        if (this.goU != -1.0f && this.goV != -1.0f && this.goW != -1.0f) {
            this.goX.setShadowLayer(this.goW, this.goU, this.goV, this.goT);
        }
        this.gpI = findViewById(R.id.titlebar_right_txtzone2);
        this.gpI.setVisibility(VISIBILITY_FLAGS[this.gpH]);
        this.gpJ = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.gpK != null) {
            this.gpJ.setText(this.gpK);
        }
        if (this.gpL != -1) {
            this.gpJ.setTextColor(this.gpL);
        } else {
            this.gpJ.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gpb = findViewById(R.id.titlebar_right_txtzone1);
        this.gpb.setVisibility(VISIBILITY_FLAGS[this.gpv]);
        this.gpc = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.gpn != null) {
            this.gpc.setText(this.gpn);
        }
        if (this.gpo != -1) {
            this.gpc.setTextColor(this.gpo);
        } else {
            this.gpc.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gpd = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.gpe = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.gpg = (ImageView) findViewById(R.id.new_tip_img);
        this.gph = findViewById(R.id.titlebar_right_imgzone2);
        this.gph.setVisibility(VISIBILITY_FLAGS[this.gpx]);
        this.gpi = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.gpk = findViewById(R.id.titlebar_right_imgzone1);
        this.gpk.setVisibility(VISIBILITY_FLAGS[this.gpw]);
        this.gpm = findViewById(R.id.titlebar_right_zones);
        this.gpm.setVisibility(VISIBILITY_FLAGS[this.gpu]);
        this.gpE = findViewById(R.id.titlebar_left_zones);
        this.gpl = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.gpF = findViewById(R.id.titlebar_center_zones);
        this.dTm = findViewById(R.id.titlebar_right_menu);
        this.dTj = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.goP = findViewById(R.id.titlebar_right_menu_line);
        this.dTk = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.goR);
        setTitleColor(R.color.aiapps_black_text);
        setRightMenuImageSrc(R.drawable.aiapps_action_bar_menu_normal_selector);
        setRightImgZone2Src(R.drawable.aiapps_action_bar_add_2_selector);
        setRightImgZone1Src(R.drawable.aiapps_action_bar_add_selector);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new a());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setTitleBarTitleSize(float f) {
        this.goY.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.gpa = i;
        setTitle(this.goR);
    }

    public void setSubTitle(String str) {
        this.goS = str;
        if (TextUtils.isEmpty(this.goS)) {
            this.goZ.setVisibility(8);
        } else {
            this.goZ.setVisibility(0);
        }
        if (1 == this.gpa) {
            this.goZ.setText(str);
        } else if (this.gpa == 0) {
            this.goZ.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.goS;
    }

    public void setSubTitleColor(int i) {
        this.goZ.setTextColor(i);
    }

    public void setTitle(String str) {
        this.goR = str;
        if (1 == this.gpa) {
            this.goY.setText(str);
            if (this.gpD) {
                Fz(str);
            } else {
                this.goX.setText((CharSequence) null);
            }
        } else if (this.gpa == 0) {
            this.goX.setText(str);
            this.goY.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.goR;
    }

    public void setTitleColor(int i) {
        this.anp = i;
        this.goY.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.goX.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.goX.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.goX.setShadowLayer(f, f2, f3, i);
        this.goY.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.gpc.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.gpc.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.gpc != null) {
            this.gpc.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.gpc.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.gpc.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.gpc.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.gpb.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.gpm.setVisibility(0);
        }
        this.gpb.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.gpb.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.goX.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gpb.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.gpb.setClickable(z);
        this.gpc.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gph.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gph.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.gph.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpe.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.gpe.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gpk.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpk.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gpk.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.gpk.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.gpk.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.gpj = i;
        this.gpi.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.gpi.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.gpe.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.gpe.setEnabled(z);
        this.gph.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.gpf = i;
        this.gpe.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.gpy = drawable;
        this.gpe.setImageDrawable(this.gpy);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpe.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.gpe.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.gph.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.gpk.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.gpl.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.gpd.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.gpl.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.goX.setCompoundDrawables(drawable, null, null, null);
        this.goX.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.goX.setCompoundDrawables(drawable, null, null, null);
        this.goX.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.goX.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.goX.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.goX.setSelected(z);
    }

    @TargetApi(16)
    public void setTxtZoneBackgroundResource(int i) {
        this.gpb.setBackground(getResources().getDrawable(i));
        this.gpI.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.gpb.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.gpb.setMinimumHeight(i);
    }

    @TargetApi(16)
    public void setImgZoneBackgroundResource(int i) {
        this.goX.setBackground(getResources().getDrawable(i));
        this.gpk.setBackground(getResources().getDrawable(i));
        this.gph.setBackground(getResources().getDrawable(i));
        this.gpB.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.gpj = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.gpz = drawable;
        this.gpi.setImageDrawable(this.gpz);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.gpB.getVisibility() != i) {
            this.gpB.setVisibility(i);
            Fz(this.goR);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.gpB.getVisibility() == 0) {
            this.gpB.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.goX != null) {
            this.goX.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.gpB.getVisibility() == 0) {
            this.gpB.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.gpB.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gpB.setCompoundDrawables(drawable, null, null, null);
        this.gpB.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gpB.setCompoundDrawables(drawable, null, null, null);
        this.gpB.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.gpB.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.gpD = z;
    }

    public void setLeftTitle(String str) {
        this.goX.setText(str);
    }

    private void Fz(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.goQ = i;
        this.dTj.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dTk.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.goP.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.dTm.setBackgroundResource(i);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.gpG = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0454a interfaceC0454a) {
        this.dEs = interfaceC0454a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.dTa;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.gpG != null) {
                SwanAppBdActionBar.this.gpG.ax(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.goX != null) {
            if (z) {
                this.goX.setVisibility(0);
            } else {
                this.goX.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dTk.setVisibility(0);
            this.goP.setVisibility(0);
            return;
        }
        this.dTk.setVisibility(8);
        this.goP.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dTm.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.gpb.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.gpm.setVisibility(0);
        }
        this.gpI.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.gpI.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gpI.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.gpJ.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.gpg.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.gpE.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.gpm.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.gpF.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.dTm.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dTj.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dTk.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.anp;
    }

    public int getRightMenuImageViewSrcId() {
        return this.goQ;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.gpj;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.gpf;
    }

    public TextView getTitleViewCenter() {
        return this.goY;
    }

    public View getRightMenu() {
        return this.dTm;
    }

    private Drawable ku(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.dTa = z;
        int i = this.dTa ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
