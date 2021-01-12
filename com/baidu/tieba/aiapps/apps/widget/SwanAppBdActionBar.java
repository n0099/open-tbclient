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
    private static final int[] gkW = {8, 0, 4};
    private int amh;
    private a.InterfaceC0451a dAM;
    private ImageView dPC;
    private ImageView dPD;
    private View dPF;
    private boolean dPt;
    private ImageView gkA;
    private int gkB;
    private ImageView gkC;
    private View gkD;
    private ImageView gkE;
    private int gkF;
    private View gkG;
    private View gkH;
    private View gkI;
    private String gkJ;
    private int gkK;
    private float gkL;
    private int gkM;
    private float gkN;
    private float gkO;
    private float gkP;
    private int gkQ;
    private int gkR;
    private int gkS;
    private int gkT;
    private Drawable gkU;
    private Drawable gkV;
    private com.baidu.swan.apps.res.ui.a gkX;
    private TextView gkY;
    private b.a gkZ;
    private View gkl;
    private int gkm;
    private String gkn;
    private String gko;
    private int gkp;
    private float gkq;
    private float gkr;
    private float gks;
    private TextView gkt;
    private TextView gku;
    private TextView gkv;
    private int gkw;
    private View gkx;
    private TextView gky;
    private ProgressBar gkz;
    private boolean gla;
    private View glb;
    private View glc;
    private b gld;
    private int gle;
    private View glf;
    private TextView glg;
    private String glh;
    private int gli;
    private ProgressBar glj;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes8.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes8.dex */
    public interface b {
        void aB(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.gkK = -1;
        this.gkL = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNo();
            }
        };
        this.gli = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkK = -1;
        this.gkL = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNo();
            }
        };
        this.gli = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkK = -1;
        this.gkL = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.bNo();
            }
        };
        this.gli = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwanAppBdActionBar, 0, 0);
            try {
                this.gkn = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_titleText);
                this.gkp = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.gkq = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.gkr = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.gks = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.gle = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.glh = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gkR = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.gkJ = obtainStyledAttributes.getString(R.styleable.SwanAppBdActionBar_rightTxtZone1Text);
                this.gkU = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.gkQ = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.gkV = obtainStyledAttributes.getDrawable(R.styleable.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.gkS = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.gkT = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.gkK = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.gkL = obtainStyledAttributes.getDimension(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.gkM = obtainStyledAttributes.getColor(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.gkN = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.gkO = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.gkP = obtainStyledAttributes.getFloat(R.styleable.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.gkw = obtainStyledAttributes.getInt(R.styleable.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.dPF.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.gkZ = aVar;
        if (this.gkX != null) {
            this.gkX.a(this.gkZ);
        }
    }

    public boolean bNo() {
        if (this.gkX != null) {
            int[] iArr = new int[2];
            this.dPF.getLocationInWindow(iArr);
            int O = ah.O(6.0f);
            int height = iArr[1] + this.dPF.getHeight() + ah.O(4.0f);
            this.gkX.getView().getWidth();
            this.gkX.v(0, (ah.getDisplayWidth(getContext()) - O) - this.gkX.getView().getWidth(), height);
            this.gkX.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.glj = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.gkt = (TextView) findViewById(R.id.left_first_view);
        this.gkt.setCompoundDrawables(kq(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.gkt.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color));
        this.gku = (TextView) findViewById(R.id.title_text_center);
        this.gkv = (TextView) findViewById(R.id.subtitle_text_center);
        this.gkv.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.gkY = (TextView) findViewById(R.id.left_second_view);
        this.gkY.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        if (this.gkq != -1.0f && this.gkr != -1.0f && this.gks != -1.0f) {
            this.gkt.setShadowLayer(this.gks, this.gkq, this.gkr, this.gkp);
        }
        this.glf = findViewById(R.id.titlebar_right_txtzone2);
        this.glf.setVisibility(gkW[this.gle]);
        this.glg = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.glh != null) {
            this.glg.setText(this.glh);
        }
        if (this.gli != -1) {
            this.glg.setTextColor(this.gli);
        } else {
            this.glg.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gkx = findViewById(R.id.titlebar_right_txtzone1);
        this.gkx.setVisibility(gkW[this.gkR]);
        this.gky = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.gkJ != null) {
            this.gky.setText(this.gkJ);
        }
        if (this.gkK != -1) {
            this.gky.setTextColor(this.gkK);
        } else {
            this.gky.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_txt_color_pressed));
        }
        this.gkz = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.gkA = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.gkC = (ImageView) findViewById(R.id.new_tip_img);
        this.gkD = findViewById(R.id.titlebar_right_imgzone2);
        this.gkD.setVisibility(gkW[this.gkT]);
        this.gkE = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.gkG = findViewById(R.id.titlebar_right_imgzone1);
        this.gkG.setVisibility(gkW[this.gkS]);
        this.gkI = findViewById(R.id.titlebar_right_zones);
        this.gkI.setVisibility(gkW[this.gkQ]);
        this.glb = findViewById(R.id.titlebar_left_zones);
        this.gkH = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.glc = findViewById(R.id.titlebar_center_zones);
        this.dPF = findViewById(R.id.titlebar_right_menu);
        this.dPC = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.gkl = findViewById(R.id.titlebar_right_menu_line);
        this.dPD = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.gkn);
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
        this.gku.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.gkw = i;
        setTitle(this.gkn);
    }

    public void setSubTitle(String str) {
        this.gko = str;
        if (TextUtils.isEmpty(this.gko)) {
            this.gkv.setVisibility(8);
        } else {
            this.gkv.setVisibility(0);
        }
        if (1 == this.gkw) {
            this.gkv.setText(str);
        } else if (this.gkw == 0) {
            this.gkv.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.gko;
    }

    public void setSubTitleColor(int i) {
        this.gkv.setTextColor(i);
    }

    public void setTitle(String str) {
        this.gkn = str;
        if (1 == this.gkw) {
            this.gku.setText(str);
            if (this.gla) {
                ER(str);
            } else {
                this.gkt.setText((CharSequence) null);
            }
        } else if (this.gkw == 0) {
            this.gkt.setText(str);
            this.gku.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.gkn;
    }

    public void setTitleColor(int i) {
        this.amh = i;
        this.gku.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.gkt.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.gkt.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.gkt.setShadowLayer(f, f2, f3, i);
        this.gku.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.gky.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.gky.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.gky != null) {
            this.gky.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.gky.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.gky.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.gky.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.gkx.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.gkI.setVisibility(0);
        }
        this.gkx.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.gkx.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.gkt.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gkx.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.gkx.setClickable(z);
        this.gky.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.gkD.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gkD.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.gkD.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gkA.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.gkA.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.gkG.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gkG.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gkG.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.gkG.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.gkG.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.gkF = i;
        this.gkE.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.gkE.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.gkA.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.gkA.setEnabled(z);
        this.gkD.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.gkB = i;
        this.gkA.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.gkU = drawable;
        this.gkA.setImageDrawable(this.gkU);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gkA.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.gkA.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.gkD.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.gkG.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.gkH.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.gkz.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.gkH.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gkt.setCompoundDrawables(drawable, null, null, null);
        this.gkt.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gkt.setCompoundDrawables(drawable, null, null, null);
        this.gkt.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.gkt.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.gkt.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.gkt.setSelected(z);
    }

    @TargetApi(16)
    public void setTxtZoneBackgroundResource(int i) {
        this.gkx.setBackground(getResources().getDrawable(i));
        this.glf.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.gkx.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.gkx.setMinimumHeight(i);
    }

    @TargetApi(16)
    public void setImgZoneBackgroundResource(int i) {
        this.gkt.setBackground(getResources().getDrawable(i));
        this.gkG.setBackground(getResources().getDrawable(i));
        this.gkD.setBackground(getResources().getDrawable(i));
        this.gkY.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.gkF = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.gkV = drawable;
        this.gkE.setImageDrawable(this.gkV);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.gkY.getVisibility() != i) {
            this.gkY.setVisibility(i);
            ER(this.gkn);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.gkY.getVisibility() == 0) {
            this.gkY.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.gkt != null) {
            this.gkt.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.gkY.getVisibility() == 0) {
            this.gkY.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.gkY.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.gkY.setCompoundDrawables(drawable, null, null, null);
        this.gkY.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.gkY.setCompoundDrawables(drawable, null, null, null);
        this.gkY.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.gkY.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.gla = z;
    }

    public void setLeftTitle(String str) {
        this.gkt.setText(str);
    }

    private void ER(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.gkm = i;
        this.dPC.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dPD.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.gkl.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.dPF.setBackgroundResource(i);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.gld = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0451a interfaceC0451a) {
        this.dAM = interfaceC0451a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.dPt;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.gld != null) {
                SwanAppBdActionBar.this.gld.aB(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.gkt != null) {
            if (z) {
                this.gkt.setVisibility(0);
            } else {
                this.gkt.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dPD.setVisibility(0);
            this.gkl.setVisibility(0);
            return;
        }
        this.dPD.setVisibility(8);
        this.gkl.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dPF.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.gkx.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.gkI.setVisibility(0);
        }
        this.glf.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.glf.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.glf.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.glg.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.gkC.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.glb.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.gkI.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.glc.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.dPF.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dPC.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dPD.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.amh;
    }

    public int getRightMenuImageViewSrcId() {
        return this.gkm;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.gkF;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.gkB;
    }

    public TextView getTitleViewCenter() {
        return this.gku;
    }

    public View getRightMenu() {
        return this.dPF;
    }

    private Drawable kq(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.dPt = z;
        int i = this.dPt ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
