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
    private int gnA;
    private View gnB;
    private View gnC;
    private View gnD;
    private String gnE;
    private int gnF;
    private float gnG;
    private int gnH;
    private float gnI;
    private float gnJ;
    private float gnK;
    private int gnL;
    private int gnM;
    private int gnN;
    private int gnO;
    private Drawable gnP;
    private Drawable gnQ;
    private com.baidu.swan.apps.res.ui.a gnR;
    private TextView gnS;
    private b.a gnT;
    private boolean gnU;
    private View gnV;
    private View gnW;
    private b gnX;
    private int gnY;
    private View gnZ;
    private View gng;
    private int gnh;
    private String gni;
    private String gnj;
    private int gnk;
    private float gnl;
    private float gnm;
    private float gnn;
    private TextView gno;
    private TextView gnp;
    private TextView gnq;
    private int gnr;
    private View gns;
    private TextView gnt;
    private ProgressBar gnu;
    private ImageView gnv;
    private int gnw;
    private ImageView gnx;
    private View gny;
    private ImageView gnz;
    private TextView goa;
    private String gob;
    private int goc;
    private ProgressBar god;
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
        this.gnF = -1;
        this.gnG = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNW();
            }
        };
        this.goc = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnF = -1;
        this.gnG = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNW();
            }
        };
        this.goc = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnF = -1;
        this.gnG = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNW();
            }
        };
        this.goc = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwanAppBdActionBar, 0, 0);
            try {
                this.gni = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_titleText);
                this.gnk = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.gnl = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.gnm = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.gnn = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.gnY = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gob = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gnM = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gnE = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gnP = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.gnL = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.gnQ = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.gnN = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.gnO = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.gnF = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.gnG = obtainStyledAttributes.getDimension(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.gnH = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.gnI = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.gnJ = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.gnK = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.gnr = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.dRL.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.gnT = aVar;
        if (this.gnR != null) {
            this.gnR.a(this.gnT);
        }
    }

    public boolean bNW() {
        if (this.gnR != null) {
            int[] iArr = new int[2];
            this.dRL.getLocationInWindow(iArr);
            int P = ah.P(6.0f);
            int height = iArr[1] + this.dRL.getHeight() + ah.P(4.0f);
            this.gnR.getView().getWidth();
            this.gnR.v(0, (ah.getDisplayWidth(getContext()) - P) - this.gnR.getView().getWidth(), height);
            this.gnR.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.god = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.gno = (TextView) findViewById(R.id.left_first_view);
        this.gno.setCompoundDrawables(kt(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.gno.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color));
        this.gnp = (TextView) findViewById(R.id.title_text_center);
        this.gnq = (TextView) findViewById(R.id.subtitle_text_center);
        this.gnq.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.gnS = (TextView) findViewById(R.id.left_second_view);
        this.gnS.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        if (this.gnl != -1.0f && this.gnm != -1.0f && this.gnn != -1.0f) {
            this.gno.setShadowLayer(this.gnn, this.gnl, this.gnm, this.gnk);
        }
        this.gnZ = findViewById(R.id.titlebar_right_txtzone2);
        this.gnZ.setVisibility(VISIBILITY_FLAGS[this.gnY]);
        this.goa = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.gob != null) {
            this.goa.setText(this.gob);
        }
        if (this.goc != -1) {
            this.goa.setTextColor(this.goc);
        } else {
            this.goa.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gns = findViewById(R.id.titlebar_right_txtzone1);
        this.gns.setVisibility(VISIBILITY_FLAGS[this.gnM]);
        this.gnt = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.gnE != null) {
            this.gnt.setText(this.gnE);
        }
        if (this.gnF != -1) {
            this.gnt.setTextColor(this.gnF);
        } else {
            this.gnt.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gnu = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.gnv = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.gnx = (ImageView) findViewById(R.id.new_tip_img);
        this.gny = findViewById(R.id.titlebar_right_imgzone2);
        this.gny.setVisibility(VISIBILITY_FLAGS[this.gnO]);
        this.gnz = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.gnB = findViewById(R.id.titlebar_right_imgzone1);
        this.gnB.setVisibility(VISIBILITY_FLAGS[this.gnN]);
        this.gnD = findViewById(R.id.titlebar_right_zones);
        this.gnD.setVisibility(VISIBILITY_FLAGS[this.gnL]);
        this.gnV = findViewById(R.id.titlebar_left_zones);
        this.gnC = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.gnW = findViewById(R.id.titlebar_center_zones);
        this.dRL = findViewById(R.id.titlebar_right_menu);
        this.dRI = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.gng = findViewById(R.id.titlebar_right_menu_line);
        this.dRJ = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.gni);
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
        this.gnp.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.gnr = i;
        setTitle(this.gni);
    }

    public void setSubTitle(String str) {
        this.gnj = str;
        if (TextUtils.isEmpty(this.gnj)) {
            this.gnq.setVisibility(8);
        } else {
            this.gnq.setVisibility(0);
        }
        if (1 == this.gnr) {
            this.gnq.setText(str);
        } else if (this.gnr == 0) {
            this.gnq.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.gnj;
    }

    public void setSubTitleColor(int i) {
        this.gnq.setTextColor(i);
    }

    public void setTitle(String str) {
        this.gni = str;
        if (1 == this.gnr) {
            this.gnp.setText(str);
            if (this.gnU) {
                Fq(str);
            } else {
                this.gno.setText((CharSequence) null);
            }
        } else if (this.gnr == 0) {
            this.gno.setText(str);
            this.gnp.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.gni;
    }

    public void setTitleColor(int i) {
        this.alX = i;
        this.gnp.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.gno.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.gno.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.gno.setShadowLayer(f, f2, f3, i);
        this.gnp.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.gnt.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.gnt.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.gnt != null) {
            this.gnt.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.gnt.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.gnt.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.gnt.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.gns.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.gnD.setVisibility(0);
        }
        this.gns.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.gns.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.gno.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gns.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.gns.setClickable(z);
        this.gnt.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gny.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gny.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.gny.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnv.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.gnv.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gnB.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnB.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gnB.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.gnB.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.gnB.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.gnA = i;
        this.gnz.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.gnz.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.gnv.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.gnv.setEnabled(z);
        this.gny.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.gnw = i;
        this.gnv.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.gnP = drawable;
        this.gnv.setImageDrawable(this.gnP);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnv.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.gnv.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.gny.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.gnB.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.gnC.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.gnu.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.gnC.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gno.setCompoundDrawables(drawable, null, null, null);
        this.gno.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gno.setCompoundDrawables(drawable, null, null, null);
        this.gno.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.gno.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.gno.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.gno.setSelected(z);
    }

    @TargetApi(16)
    public void setTxtZoneBackgroundResource(int i) {
        this.gns.setBackground(getResources().getDrawable(i));
        this.gnZ.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.gns.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.gns.setMinimumHeight(i);
    }

    @TargetApi(16)
    public void setImgZoneBackgroundResource(int i) {
        this.gno.setBackground(getResources().getDrawable(i));
        this.gnB.setBackground(getResources().getDrawable(i));
        this.gny.setBackground(getResources().getDrawable(i));
        this.gnS.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.gnA = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.gnQ = drawable;
        this.gnz.setImageDrawable(this.gnQ);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.gnS.getVisibility() != i) {
            this.gnS.setVisibility(i);
            Fq(this.gni);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.gnS.getVisibility() == 0) {
            this.gnS.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.gno != null) {
            this.gno.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.gnS.getVisibility() == 0) {
            this.gnS.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.gnS.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gnS.setCompoundDrawables(drawable, null, null, null);
        this.gnS.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gnS.setCompoundDrawables(drawable, null, null, null);
        this.gnS.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.gnS.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.gnU = z;
    }

    public void setLeftTitle(String str) {
        this.gno.setText(str);
    }

    private void Fq(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.gnh = i;
        this.dRI.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dRJ.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.gng.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.dRL.setBackgroundResource(i);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.gnX = bVar;
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
            if (SwanAppBdActionBar.this.gnX != null) {
                SwanAppBdActionBar.this.gnX.ax(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.gno != null) {
            if (z) {
                this.gno.setVisibility(0);
            } else {
                this.gno.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dRJ.setVisibility(0);
            this.gng.setVisibility(0);
            return;
        }
        this.dRJ.setVisibility(8);
        this.gng.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dRL.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.gns.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.gnD.setVisibility(0);
        }
        this.gnZ.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.gnZ.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gnZ.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.goa.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.gnx.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.gnV.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.gnD.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.gnW.setVisibility(i);
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
        return this.gnh;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.gnA;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.gnw;
    }

    public TextView getTitleViewCenter() {
        return this.gnp;
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
