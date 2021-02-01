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
    private static final int[] VISIBILITY_FLAGS = {8, 0, 4};
    private int alX;
    private a.InterfaceC0448a dCR;
    private ImageView dRI;
    private ImageView dRJ;
    private View dRL;
    private boolean dRz;
    private View gmS;
    private int gmT;
    private String gmU;
    private String gmV;
    private int gmW;
    private float gmX;
    private float gmY;
    private float gmZ;
    private int gnA;
    private Drawable gnB;
    private Drawable gnC;
    private com.baidu.swan.apps.res.ui.a gnD;
    private TextView gnE;
    private b.a gnF;
    private boolean gnG;
    private View gnH;
    private View gnI;
    private b gnJ;
    private int gnK;
    private View gnL;
    private TextView gnM;
    private String gnN;
    private int gnO;
    private ProgressBar gnP;
    private TextView gna;
    private TextView gnb;
    private TextView gnc;
    private int gnd;
    private View gne;
    private TextView gnf;
    private ProgressBar gng;
    private ImageView gnh;
    private int gni;
    private ImageView gnj;
    private View gnk;
    private ImageView gnl;
    private int gnm;
    private View gnn;
    private View gno;
    private View gnp;
    private String gnq;
    private int gnr;
    private float gns;
    private int gnt;
    private float gnu;
    private float gnv;
    private float gnw;
    private int gnx;
    private int gny;
    private int gnz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes9.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes9.dex */
    public interface b {
        void ax(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.gnr = -1;
        this.gns = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNP();
            }
        };
        this.gnO = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnr = -1;
        this.gns = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNP();
            }
        };
        this.gnO = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnr = -1;
        this.gns = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNP();
            }
        };
        this.gnO = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwanAppBdActionBar, 0, 0);
            try {
                this.gmU = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_titleText);
                this.gmW = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.gmX = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.gmY = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.gmZ = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.gnK = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gnN = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gny = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gnq = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gnB = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.gnx = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.gnC = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.gnz = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.gnA = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.gnr = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.gns = obtainStyledAttributes.getDimension(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.gnt = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.gnu = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.gnv = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.gnw = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.gnd = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.dRL.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.gnF = aVar;
        if (this.gnD != null) {
            this.gnD.a(this.gnF);
        }
    }

    public boolean bNP() {
        if (this.gnD != null) {
            int[] iArr = new int[2];
            this.dRL.getLocationInWindow(iArr);
            int P = ah.P(6.0f);
            int height = iArr[1] + this.dRL.getHeight() + ah.P(4.0f);
            this.gnD.getView().getWidth();
            this.gnD.v(0, (ah.getDisplayWidth(getContext()) - P) - this.gnD.getView().getWidth(), height);
            this.gnD.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.gnP = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.gna = (TextView) findViewById(R.id.left_first_view);
        this.gna.setCompoundDrawables(kt(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.gna.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color));
        this.gnb = (TextView) findViewById(R.id.title_text_center);
        this.gnc = (TextView) findViewById(R.id.subtitle_text_center);
        this.gnc.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.gnE = (TextView) findViewById(R.id.left_second_view);
        this.gnE.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        if (this.gmX != -1.0f && this.gmY != -1.0f && this.gmZ != -1.0f) {
            this.gna.setShadowLayer(this.gmZ, this.gmX, this.gmY, this.gmW);
        }
        this.gnL = findViewById(R.id.titlebar_right_txtzone2);
        this.gnL.setVisibility(VISIBILITY_FLAGS[this.gnK]);
        this.gnM = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.gnN != null) {
            this.gnM.setText(this.gnN);
        }
        if (this.gnO != -1) {
            this.gnM.setTextColor(this.gnO);
        } else {
            this.gnM.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gne = findViewById(R.id.titlebar_right_txtzone1);
        this.gne.setVisibility(VISIBILITY_FLAGS[this.gny]);
        this.gnf = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.gnq != null) {
            this.gnf.setText(this.gnq);
        }
        if (this.gnr != -1) {
            this.gnf.setTextColor(this.gnr);
        } else {
            this.gnf.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gng = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.gnh = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.gnj = (ImageView) findViewById(R.id.new_tip_img);
        this.gnk = findViewById(R.id.titlebar_right_imgzone2);
        this.gnk.setVisibility(VISIBILITY_FLAGS[this.gnA]);
        this.gnl = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.gnn = findViewById(R.id.titlebar_right_imgzone1);
        this.gnn.setVisibility(VISIBILITY_FLAGS[this.gnz]);
        this.gnp = findViewById(R.id.titlebar_right_zones);
        this.gnp.setVisibility(VISIBILITY_FLAGS[this.gnx]);
        this.gnH = findViewById(R.id.titlebar_left_zones);
        this.gno = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.gnI = findViewById(R.id.titlebar_center_zones);
        this.dRL = findViewById(R.id.titlebar_right_menu);
        this.dRI = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.gmS = findViewById(R.id.titlebar_right_menu_line);
        this.dRJ = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.gmU);
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
        this.gnb.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.gnd = i;
        setTitle(this.gmU);
    }

    public void setSubTitle(String str) {
        this.gmV = str;
        if (TextUtils.isEmpty(this.gmV)) {
            this.gnc.setVisibility(8);
        } else {
            this.gnc.setVisibility(0);
        }
        if (1 == this.gnd) {
            this.gnc.setText(str);
        } else if (this.gnd == 0) {
            this.gnc.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.gmV;
    }

    public void setSubTitleColor(int i) {
        this.gnc.setTextColor(i);
    }

    public void setTitle(String str) {
        this.gmU = str;
        if (1 == this.gnd) {
            this.gnb.setText(str);
            if (this.gnG) {
                Fp(str);
            } else {
                this.gna.setText((CharSequence) null);
            }
        } else if (this.gnd == 0) {
            this.gna.setText(str);
            this.gnb.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.gmU;
    }

    public void setTitleColor(int i) {
        this.alX = i;
        this.gnb.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.gna.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.gna.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.gna.setShadowLayer(f, f2, f3, i);
        this.gnb.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.gnf.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.gnf.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.gnf != null) {
            this.gnf.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.gnf.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.gnf.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.gnf.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.gne.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.gnp.setVisibility(0);
        }
        this.gne.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.gne.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.gna.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gne.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.gne.setClickable(z);
        this.gnf.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gnk.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnk.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.gnk.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnh.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.gnh.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gnn.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnn.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gnn.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.gnn.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.gnn.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.gnm = i;
        this.gnl.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.gnl.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.gnh.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.gnh.setEnabled(z);
        this.gnk.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.gni = i;
        this.gnh.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.gnB = drawable;
        this.gnh.setImageDrawable(this.gnB);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnh.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.gnh.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.gnk.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.gnn.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.gno.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.gng.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.gno.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gna.setCompoundDrawables(drawable, null, null, null);
        this.gna.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gna.setCompoundDrawables(drawable, null, null, null);
        this.gna.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.gna.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.gna.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.gna.setSelected(z);
    }

    @TargetApi(16)
    public void setTxtZoneBackgroundResource(int i) {
        this.gne.setBackground(getResources().getDrawable(i));
        this.gnL.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.gne.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.gne.setMinimumHeight(i);
    }

    @TargetApi(16)
    public void setImgZoneBackgroundResource(int i) {
        this.gna.setBackground(getResources().getDrawable(i));
        this.gnn.setBackground(getResources().getDrawable(i));
        this.gnk.setBackground(getResources().getDrawable(i));
        this.gnE.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.gnm = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.gnC = drawable;
        this.gnl.setImageDrawable(this.gnC);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.gnE.getVisibility() != i) {
            this.gnE.setVisibility(i);
            Fp(this.gmU);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.gnE.getVisibility() == 0) {
            this.gnE.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.gna != null) {
            this.gna.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.gnE.getVisibility() == 0) {
            this.gnE.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.gnE.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gnE.setCompoundDrawables(drawable, null, null, null);
        this.gnE.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gnE.setCompoundDrawables(drawable, null, null, null);
        this.gnE.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.gnE.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.gnG = z;
    }

    public void setLeftTitle(String str) {
        this.gna.setText(str);
    }

    private void Fp(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.gmT = i;
        this.dRI.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dRJ.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.gmS.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.dRL.setBackgroundResource(i);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.gnJ = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0448a interfaceC0448a) {
        this.dCR = interfaceC0448a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.dRz;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.gnJ != null) {
                SwanAppBdActionBar.this.gnJ.ax(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.gna != null) {
            if (z) {
                this.gna.setVisibility(0);
            } else {
                this.gna.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dRJ.setVisibility(0);
            this.gmS.setVisibility(0);
            return;
        }
        this.dRJ.setVisibility(8);
        this.gmS.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dRL.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.gne.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.gnp.setVisibility(0);
        }
        this.gnL.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.gnL.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gnL.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.gnM.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.gnj.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.gnH.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.gnp.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.gnI.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.dRL.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dRI.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dRJ.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.alX;
    }

    public int getRightMenuImageViewSrcId() {
        return this.gmT;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.gnm;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.gni;
    }

    public TextView getTitleViewCenter() {
        return this.gnb;
    }

    public View getRightMenu() {
        return this.dRL;
    }

    private Drawable kt(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.dRz = z;
        int i = this.dRz ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
