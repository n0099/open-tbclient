package com.baidu.tieba.aiapps.apps.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
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
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    private static final int[] dtn = {8, 0, 4};
    private a.InterfaceC0203a biJ;
    private boolean buo;
    private ImageView buv;
    private ImageView buw;
    private View buy;
    private View dsB;
    private int dsC;
    private String dsD;
    private String dsE;
    private int dsF;
    private float dsG;
    private float dsH;
    private float dsI;
    private int dsJ;
    private TextView dsK;
    private TextView dsL;
    private TextView dsM;
    private int dsN;
    private View dsO;
    private TextView dsP;
    private ProgressBar dsQ;
    private ImageView dsR;
    private int dsS;
    private ImageView dsT;
    private View dsU;
    private ImageView dsV;
    private int dsW;
    private View dsX;
    private View dsY;
    private View dsZ;
    private ProgressBar dtA;
    private String dta;
    private int dtb;
    private float dtc;
    private int dtd;
    private float dte;
    private float dtf;
    private float dtg;
    private int dth;
    private int dti;
    private int dtj;
    private int dtk;
    private Drawable dtl;
    private Drawable dtm;
    private com.baidu.swan.apps.res.ui.a dto;
    private TextView dtp;
    private b.a dtq;
    private boolean dtr;
    private View dts;
    private View dtt;
    private b dtu;
    private int dtv;
    private View dtw;
    private TextView dtx;
    private String dty;
    private int dtz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes4.dex */
    public interface b {
        void aa(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.dtb = -1;
        this.dtc = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aIB();
            }
        };
        this.dtz = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtb = -1;
        this.dtc = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aIB();
            }
        };
        this.dtz = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtb = -1;
        this.dtc = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aIB();
            }
        };
        this.dtz = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwanAppBdActionBar, 0, 0);
            try {
                this.dsD = obtainStyledAttributes.getString(19);
                this.dsF = obtainStyledAttributes.getColor(9, ViewCompat.MEASURED_STATE_MASK);
                this.dsG = obtainStyledAttributes.getFloat(7, -1.0f);
                this.dsH = obtainStyledAttributes.getFloat(8, -1.0f);
                this.dsI = obtainStyledAttributes.getFloat(6, -1.0f);
                this.dtv = obtainStyledAttributes.getInt(2, 0);
                this.dty = obtainStyledAttributes.getString(10);
                this.dti = obtainStyledAttributes.getInt(2, 0);
                this.dta = obtainStyledAttributes.getString(10);
                this.dtl = obtainStyledAttributes.getDrawable(17);
                this.dth = obtainStyledAttributes.getInt(3, 0);
                this.dtm = obtainStyledAttributes.getDrawable(18);
                this.dtj = obtainStyledAttributes.getInt(0, 0);
                this.dtk = obtainStyledAttributes.getInt(1, 0);
                this.dtb = obtainStyledAttributes.getColor(11, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.dtc = obtainStyledAttributes.getDimension(12, -1.0f);
                this.dtd = obtainStyledAttributes.getColor(16, ViewCompat.MEASURED_STATE_MASK);
                this.dte = obtainStyledAttributes.getFloat(14, -1.0f);
                this.dtf = obtainStyledAttributes.getFloat(15, -1.0f);
                this.dtg = obtainStyledAttributes.getFloat(13, -1.0f);
                this.dsN = obtainStyledAttributes.getInt(4, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.buy.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.dtq = aVar;
        if (this.dto != null) {
            this.dto.a(this.dtq);
        }
    }

    public boolean aIB() {
        if (this.dto != null) {
            int[] iArr = new int[2];
            this.buy.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.buy.getHeight() + getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_top_padding);
            this.dto.getView().getWidth();
            this.dto.r(0, (z.getDisplayWidth(getContext()) - dimensionPixelSize) - this.dto.getView().getWidth(), height);
            this.dto.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.dtA = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.dsK = (TextView) findViewById(R.id.left_first_view);
        this.dsK.setCompoundDrawables(fD(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.dsK.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        this.dsL = (TextView) findViewById(R.id.title_text_center);
        this.dsM = (TextView) findViewById(R.id.subtitle_text_center);
        this.dsM.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.dtp = (TextView) findViewById(R.id.left_second_view);
        this.dtp.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        if (this.dsG != -1.0f && this.dsH != -1.0f && this.dsI != -1.0f) {
            this.dsK.setShadowLayer(this.dsI, this.dsG, this.dsH, this.dsF);
        }
        this.dtw = findViewById(R.id.titlebar_right_txtzone2);
        this.dtw.setVisibility(dtn[this.dtv]);
        this.dtx = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.dty != null) {
            this.dtx.setText(this.dty);
        }
        if (this.dtz != -1) {
            this.dtx.setTextColor(this.dtz);
        } else {
            this.dtx.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dsO = findViewById(R.id.titlebar_right_txtzone1);
        this.dsO.setVisibility(dtn[this.dti]);
        this.dsP = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.dta != null) {
            this.dsP.setText(this.dta);
        }
        if (this.dtb != -1) {
            this.dsP.setTextColor(this.dtb);
        } else {
            this.dsP.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dsQ = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.dsR = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.dsT = (ImageView) findViewById(R.id.new_tip_img);
        this.dsU = findViewById(R.id.titlebar_right_imgzone2);
        this.dsU.setVisibility(dtn[this.dtk]);
        this.dsV = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.dsX = findViewById(R.id.titlebar_right_imgzone1);
        this.dsX.setVisibility(dtn[this.dtj]);
        this.dsZ = findViewById(R.id.titlebar_right_zones);
        this.dsZ.setVisibility(dtn[this.dth]);
        this.dts = findViewById(R.id.titlebar_left_zones);
        this.dsY = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.dtt = findViewById(R.id.titlebar_center_zones);
        this.buy = findViewById(R.id.titlebar_right_menu);
        this.buv = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.dsB = findViewById(R.id.titlebar_right_menu_line);
        this.buw = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.dsD);
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
        this.dsL.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.dsN = i;
        setTitle(this.dsD);
    }

    public void setSubTitle(String str) {
        this.dsE = str;
        if (TextUtils.isEmpty(this.dsE)) {
            this.dsM.setVisibility(8);
        } else {
            this.dsM.setVisibility(0);
        }
        if (1 == this.dsN) {
            this.dsM.setText(str);
        } else if (this.dsN == 0) {
            this.dsM.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.dsE;
    }

    public void setSubTitleColor(int i) {
        this.dsM.setTextColor(i);
    }

    public void setTitle(String str) {
        this.dsD = str;
        if (1 == this.dsN) {
            this.dsL.setText(str);
            if (this.dtr) {
                sA(str);
            } else {
                this.dsK.setText((CharSequence) null);
            }
        } else if (this.dsN == 0) {
            this.dsK.setText(str);
            this.dsL.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.dsD;
    }

    public void setTitleColor(int i) {
        this.dsJ = i;
        this.dsL.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.dsK.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dsK.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.dsK.setShadowLayer(f, f2, f3, i);
        this.dsL.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.dsP.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.dsP.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.dsP != null) {
            this.dsP.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.dsP.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.dsP.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.dsP.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.dsO.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.dsZ.setVisibility(0);
        }
        this.dsO.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.dsO.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.dsK.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dsO.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.dsO.setClickable(z);
        this.dsP.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dsU.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dsU.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.dsU.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dsR.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.dsR.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dsX.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dsX.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.dsX.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.dsX.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.dsX.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.dsW = i;
        this.dsV.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.dsV.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.dsR.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.dsR.setEnabled(z);
        this.dsU.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.dsS = i;
        this.dsR.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.dtl = drawable;
        this.dsR.setImageDrawable(this.dtl);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dsR.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.dsR.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.dsU.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.dsX.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.dsY.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.dsQ.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.dsY.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dsK.setCompoundDrawables(drawable, null, null, null);
        this.dsK.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dsK.setCompoundDrawables(drawable, null, null, null);
        this.dsK.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.dsK.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.dsK.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.dsK.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.dsO.setBackground(getResources().getDrawable(i));
        this.dtw.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.dsO.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.dsO.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.dsK.setBackground(getResources().getDrawable(i));
        this.dsX.setBackground(getResources().getDrawable(i));
        this.dsU.setBackground(getResources().getDrawable(i));
        this.dtp.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.dsW = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.dtm = drawable;
        this.dsV.setImageDrawable(this.dtm);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.dtp.getVisibility() != i) {
            this.dtp.setVisibility(i);
            sA(this.dsD);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.dtp.getVisibility() == 0) {
            this.dtp.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.dsK != null) {
            this.dsK.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.dtp.getVisibility() == 0) {
            this.dtp.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.dtp.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dtp.setCompoundDrawables(drawable, null, null, null);
        this.dtp.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dtp.setCompoundDrawables(drawable, null, null, null);
        this.dtp.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.dtp.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.dtr = z;
    }

    public void setLeftTitle(String str) {
        this.dsK.setText(str);
    }

    private void sA(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.dsC = i;
        this.buv.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.buw.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.dsB.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.buy.setBackgroundResource(i);
    }

    public void setTemplate(ActionbarTemplate actionbarTemplate) {
        if (actionbarTemplate != null) {
            switch (actionbarTemplate) {
                case WHITE_TITLE_TEMPLATE:
                    setTitleColor(R.color.aiapps_white_text);
                    setRightMenuImageSrc(R.drawable.aiapps_action_bar_menu_normal_selector);
                    return;
                case BALCK_TITLE_TEMPLATE:
                    setTitleColor(R.color.aiapps_black_text);
                    setRightMenuImageSrc(R.drawable.aiapps_action_bar_black_menu_normal_selector);
                    return;
                default:
                    return;
            }
        }
    }

    public void setOnDoubleClickListener(b bVar) {
        this.dtu = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0203a interfaceC0203a) {
        this.biJ = interfaceC0203a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.buo;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.dtu != null) {
                SwanAppBdActionBar.this.dtu.aa(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.dsK != null) {
            if (z) {
                this.dsK.setVisibility(0);
            } else {
                this.dsK.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.buw.setVisibility(0);
            this.dsB.setVisibility(0);
            return;
        }
        this.buw.setVisibility(8);
        this.dsB.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.buy.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.dsO.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.dsZ.setVisibility(0);
        }
        this.dtw.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.dtw.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dtw.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.dtx.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.dsT.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.dts.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.dsZ.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.dtt.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.buy.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.buv.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.buw.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.dsJ;
    }

    public int getRightMenuImageViewSrcId() {
        return this.dsC;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.dsW;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.dsS;
    }

    public TextView getTitleViewCenter() {
        return this.dsL;
    }

    public View getRightMenu() {
        return this.buy;
    }

    private Drawable fD(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.buo = z;
        int i = this.buo ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
