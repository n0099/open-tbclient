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
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    private static final int[] dhj = {8, 0, 4};
    private a.InterfaceC0165a aOO;
    private boolean baW;
    private ImageView bbd;
    private ImageView bbe;
    private View bbg;
    private String dgA;
    private int dgB;
    private float dgC;
    private float dgD;
    private float dgE;
    private int dgF;
    private TextView dgG;
    private TextView dgH;
    private TextView dgI;
    private int dgJ;
    private View dgK;
    private TextView dgL;
    private ProgressBar dgM;
    private ImageView dgN;
    private int dgO;
    private ImageView dgP;
    private View dgQ;
    private ImageView dgR;
    private int dgS;
    private View dgT;
    private View dgU;
    private View dgV;
    private String dgW;
    private int dgX;
    private float dgY;
    private int dgZ;
    private View dgx;
    private int dgy;
    private String dgz;
    private float dha;
    private float dhb;
    private float dhc;
    private int dhd;
    private int dhe;
    private int dhf;
    private int dhg;
    private Drawable dhh;
    private Drawable dhi;
    private com.baidu.swan.apps.res.ui.a dhk;
    private TextView dhl;
    private b.a dhm;
    private boolean dhn;
    private View dho;
    private View dhp;
    private b dhq;
    private int dhr;
    private View dhs;
    private TextView dht;
    private String dhu;
    private int dhv;
    private ProgressBar dhw;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes4.dex */
    public interface b {
        void S(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.dgX = -1;
        this.dgY = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aGo();
            }
        };
        this.dhv = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgX = -1;
        this.dgY = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aGo();
            }
        };
        this.dhv = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgX = -1;
        this.dgY = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aGo();
            }
        };
        this.dhv = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, c.a.SwanAppBdActionBar, 0, 0);
            try {
                this.dgz = obtainStyledAttributes.getString(19);
                this.dgB = obtainStyledAttributes.getColor(9, ViewCompat.MEASURED_STATE_MASK);
                this.dgC = obtainStyledAttributes.getFloat(7, -1.0f);
                this.dgD = obtainStyledAttributes.getFloat(8, -1.0f);
                this.dgE = obtainStyledAttributes.getFloat(6, -1.0f);
                this.dhr = obtainStyledAttributes.getInt(2, 0);
                this.dhu = obtainStyledAttributes.getString(10);
                this.dhe = obtainStyledAttributes.getInt(2, 0);
                this.dgW = obtainStyledAttributes.getString(10);
                this.dhh = obtainStyledAttributes.getDrawable(17);
                this.dhd = obtainStyledAttributes.getInt(3, 0);
                this.dhi = obtainStyledAttributes.getDrawable(18);
                this.dhf = obtainStyledAttributes.getInt(0, 0);
                this.dhg = obtainStyledAttributes.getInt(1, 0);
                this.dgX = obtainStyledAttributes.getColor(11, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.dgY = obtainStyledAttributes.getDimension(12, -1.0f);
                this.dgZ = obtainStyledAttributes.getColor(16, ViewCompat.MEASURED_STATE_MASK);
                this.dha = obtainStyledAttributes.getFloat(14, -1.0f);
                this.dhb = obtainStyledAttributes.getFloat(15, -1.0f);
                this.dhc = obtainStyledAttributes.getFloat(13, -1.0f);
                this.dgJ = obtainStyledAttributes.getInt(4, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.bbg.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.dhm = aVar;
        if (this.dhk != null) {
            this.dhk.a(this.dhm);
        }
    }

    public boolean aGo() {
        if (this.dhk != null) {
            int[] iArr = new int[2];
            this.bbg.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.bbg.getHeight() + getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_top_padding);
            this.dhk.getView().getWidth();
            this.dhk.l(0, (z.getDisplayWidth(getContext()) - dimensionPixelSize) - this.dhk.getView().getWidth(), height);
            this.dhk.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.dhw = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.dgG = (TextView) findViewById(R.id.left_first_view);
        this.dgG.setCompoundDrawables(eF(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.dgG.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        this.dgH = (TextView) findViewById(R.id.title_text_center);
        this.dgI = (TextView) findViewById(R.id.subtitle_text_center);
        this.dgI.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.dhl = (TextView) findViewById(R.id.left_second_view);
        this.dhl.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        if (this.dgC != -1.0f && this.dgD != -1.0f && this.dgE != -1.0f) {
            this.dgG.setShadowLayer(this.dgE, this.dgC, this.dgD, this.dgB);
        }
        this.dhs = findViewById(R.id.titlebar_right_txtzone2);
        this.dhs.setVisibility(dhj[this.dhr]);
        this.dht = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.dhu != null) {
            this.dht.setText(this.dhu);
        }
        if (this.dhv != -1) {
            this.dht.setTextColor(this.dhv);
        } else {
            this.dht.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dgK = findViewById(R.id.titlebar_right_txtzone1);
        this.dgK.setVisibility(dhj[this.dhe]);
        this.dgL = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.dgW != null) {
            this.dgL.setText(this.dgW);
        }
        if (this.dgX != -1) {
            this.dgL.setTextColor(this.dgX);
        } else {
            this.dgL.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dgM = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.dgN = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.dgP = (ImageView) findViewById(R.id.new_tip_img);
        this.dgQ = findViewById(R.id.titlebar_right_imgzone2);
        this.dgQ.setVisibility(dhj[this.dhg]);
        this.dgR = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.dgT = findViewById(R.id.titlebar_right_imgzone1);
        this.dgT.setVisibility(dhj[this.dhf]);
        this.dgV = findViewById(R.id.titlebar_right_zones);
        this.dgV.setVisibility(dhj[this.dhd]);
        this.dho = findViewById(R.id.titlebar_left_zones);
        this.dgU = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.dhp = findViewById(R.id.titlebar_center_zones);
        this.bbg = findViewById(R.id.titlebar_right_menu);
        this.bbd = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.dgx = findViewById(R.id.titlebar_right_menu_line);
        this.bbe = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.dgz);
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
        this.dgH.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.dgJ = i;
        setTitle(this.dgz);
    }

    public void setSubTitle(String str) {
        this.dgA = str;
        if (TextUtils.isEmpty(this.dgA)) {
            this.dgI.setVisibility(8);
        } else {
            this.dgI.setVisibility(0);
        }
        if (1 == this.dgJ) {
            this.dgI.setText(str);
        } else if (this.dgJ == 0) {
            this.dgI.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.dgA;
    }

    public void setSubTitleColor(int i) {
        this.dgI.setTextColor(i);
    }

    public void setTitle(String str) {
        this.dgz = str;
        if (1 == this.dgJ) {
            this.dgH.setText(str);
            if (this.dhn) {
                sV(str);
            } else {
                this.dgG.setText((CharSequence) null);
            }
        } else if (this.dgJ == 0) {
            this.dgG.setText(str);
            this.dgH.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.dgz;
    }

    public void setTitleColor(int i) {
        this.dgF = i;
        this.dgH.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.dgG.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dgG.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.dgG.setShadowLayer(f, f2, f3, i);
        this.dgH.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.dgL.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.dgL.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.dgL != null) {
            this.dgL.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.dgL.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.dgL.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.dgL.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.dgK.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.dgV.setVisibility(0);
        }
        this.dgK.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.dgK.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.dgG.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dgK.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.dgK.setClickable(z);
        this.dgL.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dgQ.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgQ.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.dgQ.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dgN.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.dgN.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dgT.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgT.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.dgT.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.dgT.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.dgT.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.dgS = i;
        this.dgR.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.dgR.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.dgN.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.dgN.setEnabled(z);
        this.dgQ.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.dgO = i;
        this.dgN.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.dhh = drawable;
        this.dgN.setImageDrawable(this.dhh);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dgN.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.dgN.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.dgQ.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.dgT.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.dgU.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.dgM.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.dgU.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dgG.setCompoundDrawables(drawable, null, null, null);
        this.dgG.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dgG.setCompoundDrawables(drawable, null, null, null);
        this.dgG.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.dgG.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.dgG.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.dgG.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.dgK.setBackground(getResources().getDrawable(i));
        this.dhs.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.dgK.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.dgK.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.dgG.setBackground(getResources().getDrawable(i));
        this.dgT.setBackground(getResources().getDrawable(i));
        this.dgQ.setBackground(getResources().getDrawable(i));
        this.dhl.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.dgS = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.dhi = drawable;
        this.dgR.setImageDrawable(this.dhi);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.dhl.getVisibility() != i) {
            this.dhl.setVisibility(i);
            sV(this.dgz);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.dhl.getVisibility() == 0) {
            this.dhl.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.dgG != null) {
            this.dgG.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.dhl.getVisibility() == 0) {
            this.dhl.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.dhl.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dhl.setCompoundDrawables(drawable, null, null, null);
        this.dhl.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dhl.setCompoundDrawables(drawable, null, null, null);
        this.dhl.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.dhl.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.dhn = z;
    }

    public void setLeftTitle(String str) {
        this.dgG.setText(str);
    }

    private void sV(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.dgy = i;
        this.bbd.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bbe.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.dgx.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.bbg.setBackgroundResource(i);
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
        this.dhq = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0165a interfaceC0165a) {
        this.aOO = interfaceC0165a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.baW;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.dhq != null) {
                SwanAppBdActionBar.this.dhq.S(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.dgG != null) {
            if (z) {
                this.dgG.setVisibility(0);
            } else {
                this.dgG.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bbe.setVisibility(0);
            this.dgx.setVisibility(0);
            return;
        }
        this.bbe.setVisibility(8);
        this.dgx.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bbg.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.dgK.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.dgV.setVisibility(0);
        }
        this.dhs.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.dhs.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dhs.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.dht.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.dgP.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.dho.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.dgV.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.dhp.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.bbg.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.bbd.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.bbe.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.dgF;
    }

    public int getRightMenuImageViewSrcId() {
        return this.dgy;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.dgS;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.dgO;
    }

    public TextView getTitleViewCenter() {
        return this.dgH;
    }

    public View getRightMenu() {
        return this.bbg;
    }

    private Drawable eF(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.baW = z;
        int i = this.baW ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
