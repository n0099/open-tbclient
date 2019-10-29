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
    private static final int[] due = {8, 0, 4};
    private a.InterfaceC0208a bjb;
    private boolean bvf;
    private ImageView bvm;
    private ImageView bvn;
    private View bvp;
    private int dtA;
    private TextView dtB;
    private TextView dtC;
    private TextView dtD;
    private int dtE;
    private View dtF;
    private TextView dtG;
    private ProgressBar dtH;
    private ImageView dtI;
    private int dtJ;
    private ImageView dtK;
    private View dtL;
    private ImageView dtM;
    private int dtN;
    private View dtO;
    private View dtP;
    private View dtQ;
    private String dtR;
    private int dtS;
    private float dtT;
    private int dtU;
    private float dtV;
    private float dtW;
    private float dtX;
    private int dtY;
    private int dtZ;
    private View dts;
    private int dtt;
    private String dtu;
    private String dtv;
    private int dtw;
    private float dtx;
    private float dty;
    private float dtz;
    private int dua;
    private int dub;
    private Drawable duc;
    private Drawable dud;
    private com.baidu.swan.apps.res.ui.a duf;
    private TextView dug;
    private b.a duh;
    private boolean dui;
    private View duj;
    private View duk;
    private b dul;
    private int dum;
    private View dun;
    private TextView duo;
    private String dup;
    private int duq;
    private ProgressBar dur;
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
        this.dtS = -1;
        this.dtT = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aID();
            }
        };
        this.duq = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtS = -1;
        this.dtT = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aID();
            }
        };
        this.duq = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtS = -1;
        this.dtT = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aID();
            }
        };
        this.duq = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwanAppBdActionBar, 0, 0);
            try {
                this.dtu = obtainStyledAttributes.getString(19);
                this.dtw = obtainStyledAttributes.getColor(9, ViewCompat.MEASURED_STATE_MASK);
                this.dtx = obtainStyledAttributes.getFloat(7, -1.0f);
                this.dty = obtainStyledAttributes.getFloat(8, -1.0f);
                this.dtz = obtainStyledAttributes.getFloat(6, -1.0f);
                this.dum = obtainStyledAttributes.getInt(2, 0);
                this.dup = obtainStyledAttributes.getString(10);
                this.dtZ = obtainStyledAttributes.getInt(2, 0);
                this.dtR = obtainStyledAttributes.getString(10);
                this.duc = obtainStyledAttributes.getDrawable(17);
                this.dtY = obtainStyledAttributes.getInt(3, 0);
                this.dud = obtainStyledAttributes.getDrawable(18);
                this.dua = obtainStyledAttributes.getInt(0, 0);
                this.dub = obtainStyledAttributes.getInt(1, 0);
                this.dtS = obtainStyledAttributes.getColor(11, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.dtT = obtainStyledAttributes.getDimension(12, -1.0f);
                this.dtU = obtainStyledAttributes.getColor(16, ViewCompat.MEASURED_STATE_MASK);
                this.dtV = obtainStyledAttributes.getFloat(14, -1.0f);
                this.dtW = obtainStyledAttributes.getFloat(15, -1.0f);
                this.dtX = obtainStyledAttributes.getFloat(13, -1.0f);
                this.dtE = obtainStyledAttributes.getInt(4, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.bvp.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.duh = aVar;
        if (this.duf != null) {
            this.duf.a(this.duh);
        }
    }

    public boolean aID() {
        if (this.duf != null) {
            int[] iArr = new int[2];
            this.bvp.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.bvp.getHeight() + getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_top_padding);
            this.duf.getView().getWidth();
            this.duf.r(0, (z.getDisplayWidth(getContext()) - dimensionPixelSize) - this.duf.getView().getWidth(), height);
            this.duf.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.dur = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.dtB = (TextView) findViewById(R.id.left_first_view);
        this.dtB.setCompoundDrawables(fE(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.dtB.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        this.dtC = (TextView) findViewById(R.id.title_text_center);
        this.dtD = (TextView) findViewById(R.id.subtitle_text_center);
        this.dtD.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.dug = (TextView) findViewById(R.id.left_second_view);
        this.dug.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        if (this.dtx != -1.0f && this.dty != -1.0f && this.dtz != -1.0f) {
            this.dtB.setShadowLayer(this.dtz, this.dtx, this.dty, this.dtw);
        }
        this.dun = findViewById(R.id.titlebar_right_txtzone2);
        this.dun.setVisibility(due[this.dum]);
        this.duo = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.dup != null) {
            this.duo.setText(this.dup);
        }
        if (this.duq != -1) {
            this.duo.setTextColor(this.duq);
        } else {
            this.duo.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dtF = findViewById(R.id.titlebar_right_txtzone1);
        this.dtF.setVisibility(due[this.dtZ]);
        this.dtG = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.dtR != null) {
            this.dtG.setText(this.dtR);
        }
        if (this.dtS != -1) {
            this.dtG.setTextColor(this.dtS);
        } else {
            this.dtG.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dtH = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.dtI = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.dtK = (ImageView) findViewById(R.id.new_tip_img);
        this.dtL = findViewById(R.id.titlebar_right_imgzone2);
        this.dtL.setVisibility(due[this.dub]);
        this.dtM = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.dtO = findViewById(R.id.titlebar_right_imgzone1);
        this.dtO.setVisibility(due[this.dua]);
        this.dtQ = findViewById(R.id.titlebar_right_zones);
        this.dtQ.setVisibility(due[this.dtY]);
        this.duj = findViewById(R.id.titlebar_left_zones);
        this.dtP = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.duk = findViewById(R.id.titlebar_center_zones);
        this.bvp = findViewById(R.id.titlebar_right_menu);
        this.bvm = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.dts = findViewById(R.id.titlebar_right_menu_line);
        this.bvn = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.dtu);
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
        this.dtC.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.dtE = i;
        setTitle(this.dtu);
    }

    public void setSubTitle(String str) {
        this.dtv = str;
        if (TextUtils.isEmpty(this.dtv)) {
            this.dtD.setVisibility(8);
        } else {
            this.dtD.setVisibility(0);
        }
        if (1 == this.dtE) {
            this.dtD.setText(str);
        } else if (this.dtE == 0) {
            this.dtD.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.dtv;
    }

    public void setSubTitleColor(int i) {
        this.dtD.setTextColor(i);
    }

    public void setTitle(String str) {
        this.dtu = str;
        if (1 == this.dtE) {
            this.dtC.setText(str);
            if (this.dui) {
                sA(str);
            } else {
                this.dtB.setText((CharSequence) null);
            }
        } else if (this.dtE == 0) {
            this.dtB.setText(str);
            this.dtC.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.dtu;
    }

    public void setTitleColor(int i) {
        this.dtA = i;
        this.dtC.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.dtB.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dtB.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.dtB.setShadowLayer(f, f2, f3, i);
        this.dtC.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.dtG.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.dtG.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.dtG != null) {
            this.dtG.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.dtG.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.dtG.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.dtG.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.dtF.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.dtQ.setVisibility(0);
        }
        this.dtF.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.dtF.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.dtB.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dtF.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.dtF.setClickable(z);
        this.dtG.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dtL.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dtL.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.dtL.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dtI.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.dtI.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dtO.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dtO.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.dtO.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.dtO.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.dtO.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.dtN = i;
        this.dtM.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.dtM.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.dtI.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.dtI.setEnabled(z);
        this.dtL.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.dtJ = i;
        this.dtI.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.duc = drawable;
        this.dtI.setImageDrawable(this.duc);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dtI.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.dtI.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.dtL.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.dtO.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.dtP.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.dtH.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.dtP.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dtB.setCompoundDrawables(drawable, null, null, null);
        this.dtB.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dtB.setCompoundDrawables(drawable, null, null, null);
        this.dtB.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.dtB.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.dtB.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.dtB.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.dtF.setBackground(getResources().getDrawable(i));
        this.dun.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.dtF.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.dtF.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.dtB.setBackground(getResources().getDrawable(i));
        this.dtO.setBackground(getResources().getDrawable(i));
        this.dtL.setBackground(getResources().getDrawable(i));
        this.dug.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.dtN = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.dud = drawable;
        this.dtM.setImageDrawable(this.dud);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.dug.getVisibility() != i) {
            this.dug.setVisibility(i);
            sA(this.dtu);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.dug.getVisibility() == 0) {
            this.dug.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.dtB != null) {
            this.dtB.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.dug.getVisibility() == 0) {
            this.dug.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.dug.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dug.setCompoundDrawables(drawable, null, null, null);
        this.dug.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dug.setCompoundDrawables(drawable, null, null, null);
        this.dug.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.dug.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.dui = z;
    }

    public void setLeftTitle(String str) {
        this.dtB.setText(str);
    }

    private void sA(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.dtt = i;
        this.bvm.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bvn.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.dts.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.bvp.setBackgroundResource(i);
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
        this.dul = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0208a interfaceC0208a) {
        this.bjb = interfaceC0208a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.bvf;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.dul != null) {
                SwanAppBdActionBar.this.dul.aa(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.dtB != null) {
            if (z) {
                this.dtB.setVisibility(0);
            } else {
                this.dtB.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bvn.setVisibility(0);
            this.dts.setVisibility(0);
            return;
        }
        this.bvn.setVisibility(8);
        this.dts.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bvp.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.dtF.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.dtQ.setVisibility(0);
        }
        this.dun.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.dun.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dun.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.duo.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.dtK.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.duj.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.dtQ.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.duk.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.bvp.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.bvm.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.bvn.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.dtA;
    }

    public int getRightMenuImageViewSrcId() {
        return this.dtt;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.dtN;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.dtJ;
    }

    public TextView getTitleViewCenter() {
        return this.dtC;
    }

    public View getRightMenu() {
        return this.bvp;
    }

    private Drawable fE(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.bvf = z;
        int i = this.bvf ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
