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
/* loaded from: classes9.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    private static final int[] gpD = {8, 0, 4};
    private int amY;
    private a.InterfaceC0468a dFy;
    private boolean dUf;
    private ImageView dUo;
    private ImageView dUp;
    private View dUr;
    private View goS;
    private int goT;
    private String goU;
    private String goV;
    private int goW;
    private float goX;
    private float goY;
    private float goZ;
    private int gpA;
    private Drawable gpB;
    private Drawable gpC;
    private com.baidu.swan.apps.res.ui.a gpE;
    private TextView gpF;
    private b.a gpG;
    private boolean gpH;
    private View gpI;
    private View gpJ;
    private b gpK;
    private int gpL;
    private View gpM;
    private TextView gpN;
    private String gpO;
    private int gpP;
    private ProgressBar gpQ;
    private TextView gpa;
    private TextView gpb;
    private TextView gpc;
    private int gpd;
    private View gpe;
    private TextView gpf;
    private ProgressBar gpg;
    private ImageView gph;
    private int gpi;
    private ImageView gpj;
    private View gpk;
    private ImageView gpl;
    private int gpm;
    private View gpn;
    private View gpo;
    private View gpp;
    private String gpq;
    private int gpr;
    private float gps;
    private int gpt;
    private float gpu;
    private float gpv;
    private float gpw;
    private int gpx;
    private int gpy;
    private int gpz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes9.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes9.dex */
    public interface b {
        void aB(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.gpr = -1;
        this.gps = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bRg();
            }
        };
        this.gpP = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gpr = -1;
        this.gps = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bRg();
            }
        };
        this.gpP = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gpr = -1;
        this.gps = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bRg();
            }
        };
        this.gpP = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwanAppBdActionBar, 0, 0);
            try {
                this.goU = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_titleText);
                this.goW = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.goX = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.goY = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.goZ = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.gpL = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gpO = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gpy = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gpq = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gpB = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.gpx = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.gpC = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.gpz = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.gpA = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.gpr = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.gps = obtainStyledAttributes.getDimension(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.gpt = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.gpu = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.gpv = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.gpw = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.gpd = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.dUr.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.gpG = aVar;
        if (this.gpE != null) {
            this.gpE.a(this.gpG);
        }
    }

    public boolean bRg() {
        if (this.gpE != null) {
            int[] iArr = new int[2];
            this.dUr.getLocationInWindow(iArr);
            int O = ah.O(6.0f);
            int height = iArr[1] + this.dUr.getHeight() + ah.O(4.0f);
            this.gpE.getView().getWidth();
            this.gpE.v(0, (ah.getDisplayWidth(getContext()) - O) - this.gpE.getView().getWidth(), height);
            this.gpE.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.gpQ = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.gpa = (TextView) findViewById(R.id.left_first_view);
        this.gpa.setCompoundDrawables(lW(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.gpa.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color));
        this.gpb = (TextView) findViewById(R.id.title_text_center);
        this.gpc = (TextView) findViewById(R.id.subtitle_text_center);
        this.gpc.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.gpF = (TextView) findViewById(R.id.left_second_view);
        this.gpF.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        if (this.goX != -1.0f && this.goY != -1.0f && this.goZ != -1.0f) {
            this.gpa.setShadowLayer(this.goZ, this.goX, this.goY, this.goW);
        }
        this.gpM = findViewById(R.id.titlebar_right_txtzone2);
        this.gpM.setVisibility(gpD[this.gpL]);
        this.gpN = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.gpO != null) {
            this.gpN.setText(this.gpO);
        }
        if (this.gpP != -1) {
            this.gpN.setTextColor(this.gpP);
        } else {
            this.gpN.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gpe = findViewById(R.id.titlebar_right_txtzone1);
        this.gpe.setVisibility(gpD[this.gpy]);
        this.gpf = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.gpq != null) {
            this.gpf.setText(this.gpq);
        }
        if (this.gpr != -1) {
            this.gpf.setTextColor(this.gpr);
        } else {
            this.gpf.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gpg = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.gph = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.gpj = (ImageView) findViewById(R.id.new_tip_img);
        this.gpk = findViewById(R.id.titlebar_right_imgzone2);
        this.gpk.setVisibility(gpD[this.gpA]);
        this.gpl = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.gpn = findViewById(R.id.titlebar_right_imgzone1);
        this.gpn.setVisibility(gpD[this.gpz]);
        this.gpp = findViewById(R.id.titlebar_right_zones);
        this.gpp.setVisibility(gpD[this.gpx]);
        this.gpI = findViewById(R.id.titlebar_left_zones);
        this.gpo = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.gpJ = findViewById(R.id.titlebar_center_zones);
        this.dUr = findViewById(R.id.titlebar_right_menu);
        this.dUo = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.goS = findViewById(R.id.titlebar_right_menu_line);
        this.dUp = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.goU);
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
        this.gpb.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.gpd = i;
        setTitle(this.goU);
    }

    public void setSubTitle(String str) {
        this.goV = str;
        if (TextUtils.isEmpty(this.goV)) {
            this.gpc.setVisibility(8);
        } else {
            this.gpc.setVisibility(0);
        }
        if (1 == this.gpd) {
            this.gpc.setText(str);
        } else if (this.gpd == 0) {
            this.gpc.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.goV;
    }

    public void setSubTitleColor(int i) {
        this.gpc.setTextColor(i);
    }

    public void setTitle(String str) {
        this.goU = str;
        if (1 == this.gpd) {
            this.gpb.setText(str);
            if (this.gpH) {
                Gc(str);
            } else {
                this.gpa.setText((CharSequence) null);
            }
        } else if (this.gpd == 0) {
            this.gpa.setText(str);
            this.gpb.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.goU;
    }

    public void setTitleColor(int i) {
        this.amY = i;
        this.gpb.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.gpa.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.gpa.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.gpa.setShadowLayer(f, f2, f3, i);
        this.gpb.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.gpf.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.gpf.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.gpf != null) {
            this.gpf.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.gpf.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.gpf.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.gpf.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.gpe.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.gpp.setVisibility(0);
        }
        this.gpe.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.gpe.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.gpa.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gpe.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.gpe.setClickable(z);
        this.gpf.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gpk.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpk.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.gpk.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gph.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.gph.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gpn.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpn.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gpn.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.gpn.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.gpn.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.gpm = i;
        this.gpl.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.gpl.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.gph.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.gph.setEnabled(z);
        this.gpk.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.gpi = i;
        this.gph.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.gpB = drawable;
        this.gph.setImageDrawable(this.gpB);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gph.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.gph.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.gpk.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.gpn.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.gpo.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.gpg.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.gpo.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gpa.setCompoundDrawables(drawable, null, null, null);
        this.gpa.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gpa.setCompoundDrawables(drawable, null, null, null);
        this.gpa.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.gpa.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.gpa.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.gpa.setSelected(z);
    }

    @TargetApi(16)
    public void setTxtZoneBackgroundResource(int i) {
        this.gpe.setBackground(getResources().getDrawable(i));
        this.gpM.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.gpe.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.gpe.setMinimumHeight(i);
    }

    @TargetApi(16)
    public void setImgZoneBackgroundResource(int i) {
        this.gpa.setBackground(getResources().getDrawable(i));
        this.gpn.setBackground(getResources().getDrawable(i));
        this.gpk.setBackground(getResources().getDrawable(i));
        this.gpF.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.gpm = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.gpC = drawable;
        this.gpl.setImageDrawable(this.gpC);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.gpF.getVisibility() != i) {
            this.gpF.setVisibility(i);
            Gc(this.goU);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.gpF.getVisibility() == 0) {
            this.gpF.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.gpa != null) {
            this.gpa.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.gpF.getVisibility() == 0) {
            this.gpF.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.gpF.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gpF.setCompoundDrawables(drawable, null, null, null);
        this.gpF.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gpF.setCompoundDrawables(drawable, null, null, null);
        this.gpF.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.gpF.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.gpH = z;
    }

    public void setLeftTitle(String str) {
        this.gpa.setText(str);
    }

    private void Gc(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.goT = i;
        this.dUo.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dUp.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.goS.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.dUr.setBackgroundResource(i);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.gpK = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0468a interfaceC0468a) {
        this.dFy = interfaceC0468a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.dUf;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.gpK != null) {
                SwanAppBdActionBar.this.gpK.aB(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.gpa != null) {
            if (z) {
                this.gpa.setVisibility(0);
            } else {
                this.gpa.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dUp.setVisibility(0);
            this.goS.setVisibility(0);
            return;
        }
        this.dUp.setVisibility(8);
        this.goS.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dUr.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.gpe.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.gpp.setVisibility(0);
        }
        this.gpM.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.gpM.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gpM.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.gpN.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.gpj.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.gpI.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.gpp.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.gpJ.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.dUr.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dUo.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dUp.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.amY;
    }

    public int getRightMenuImageViewSrcId() {
        return this.goT;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.gpm;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.gpi;
    }

    public TextView getTitleViewCenter() {
        return this.gpb;
    }

    public View getRightMenu() {
        return this.dUr;
    }

    private Drawable lW(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.dUf = z;
        int i = this.dUf ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
