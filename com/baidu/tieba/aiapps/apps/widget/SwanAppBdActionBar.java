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
    private static final int[] dhk = {8, 0, 4};
    private a.InterfaceC0165a aOO;
    private boolean baW;
    private ImageView bbd;
    private ImageView bbe;
    private View bbg;
    private String dgA;
    private String dgB;
    private int dgC;
    private float dgD;
    private float dgE;
    private float dgF;
    private int dgG;
    private TextView dgH;
    private TextView dgI;
    private TextView dgJ;
    private int dgK;
    private View dgL;
    private TextView dgM;
    private ProgressBar dgN;
    private ImageView dgO;
    private int dgP;
    private ImageView dgQ;
    private View dgR;
    private ImageView dgS;
    private int dgT;
    private View dgU;
    private View dgV;
    private View dgW;
    private String dgX;
    private int dgY;
    private float dgZ;
    private View dgy;
    private int dgz;
    private int dha;
    private float dhb;
    private float dhc;
    private float dhd;
    private int dhe;
    private int dhf;
    private int dhg;
    private int dhh;
    private Drawable dhi;
    private Drawable dhj;
    private com.baidu.swan.apps.res.ui.a dhl;
    private TextView dhm;
    private b.a dhn;
    private boolean dho;
    private View dhp;
    private View dhq;
    private b dhr;
    private int dhs;
    private View dht;
    private TextView dhu;
    private String dhv;
    private int dhw;
    private ProgressBar dhx;
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
        this.dgY = -1;
        this.dgZ = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aGr();
            }
        };
        this.dhw = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgY = -1;
        this.dgZ = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aGr();
            }
        };
        this.dhw = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgY = -1;
        this.dgZ = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aGr();
            }
        };
        this.dhw = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, c.a.SwanAppBdActionBar, 0, 0);
            try {
                this.dgA = obtainStyledAttributes.getString(19);
                this.dgC = obtainStyledAttributes.getColor(9, ViewCompat.MEASURED_STATE_MASK);
                this.dgD = obtainStyledAttributes.getFloat(7, -1.0f);
                this.dgE = obtainStyledAttributes.getFloat(8, -1.0f);
                this.dgF = obtainStyledAttributes.getFloat(6, -1.0f);
                this.dhs = obtainStyledAttributes.getInt(2, 0);
                this.dhv = obtainStyledAttributes.getString(10);
                this.dhf = obtainStyledAttributes.getInt(2, 0);
                this.dgX = obtainStyledAttributes.getString(10);
                this.dhi = obtainStyledAttributes.getDrawable(17);
                this.dhe = obtainStyledAttributes.getInt(3, 0);
                this.dhj = obtainStyledAttributes.getDrawable(18);
                this.dhg = obtainStyledAttributes.getInt(0, 0);
                this.dhh = obtainStyledAttributes.getInt(1, 0);
                this.dgY = obtainStyledAttributes.getColor(11, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.dgZ = obtainStyledAttributes.getDimension(12, -1.0f);
                this.dha = obtainStyledAttributes.getColor(16, ViewCompat.MEASURED_STATE_MASK);
                this.dhb = obtainStyledAttributes.getFloat(14, -1.0f);
                this.dhc = obtainStyledAttributes.getFloat(15, -1.0f);
                this.dhd = obtainStyledAttributes.getFloat(13, -1.0f);
                this.dgK = obtainStyledAttributes.getInt(4, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.bbg.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.dhn = aVar;
        if (this.dhl != null) {
            this.dhl.a(this.dhn);
        }
    }

    public boolean aGr() {
        if (this.dhl != null) {
            int[] iArr = new int[2];
            this.bbg.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.bbg.getHeight() + getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_top_padding);
            this.dhl.getView().getWidth();
            this.dhl.l(0, (z.getDisplayWidth(getContext()) - dimensionPixelSize) - this.dhl.getView().getWidth(), height);
            this.dhl.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.dhx = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.dgH = (TextView) findViewById(R.id.left_first_view);
        this.dgH.setCompoundDrawables(eF(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.dgH.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        this.dgI = (TextView) findViewById(R.id.title_text_center);
        this.dgJ = (TextView) findViewById(R.id.subtitle_text_center);
        this.dgJ.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.dhm = (TextView) findViewById(R.id.left_second_view);
        this.dhm.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        if (this.dgD != -1.0f && this.dgE != -1.0f && this.dgF != -1.0f) {
            this.dgH.setShadowLayer(this.dgF, this.dgD, this.dgE, this.dgC);
        }
        this.dht = findViewById(R.id.titlebar_right_txtzone2);
        this.dht.setVisibility(dhk[this.dhs]);
        this.dhu = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.dhv != null) {
            this.dhu.setText(this.dhv);
        }
        if (this.dhw != -1) {
            this.dhu.setTextColor(this.dhw);
        } else {
            this.dhu.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dgL = findViewById(R.id.titlebar_right_txtzone1);
        this.dgL.setVisibility(dhk[this.dhf]);
        this.dgM = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.dgX != null) {
            this.dgM.setText(this.dgX);
        }
        if (this.dgY != -1) {
            this.dgM.setTextColor(this.dgY);
        } else {
            this.dgM.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dgN = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.dgO = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.dgQ = (ImageView) findViewById(R.id.new_tip_img);
        this.dgR = findViewById(R.id.titlebar_right_imgzone2);
        this.dgR.setVisibility(dhk[this.dhh]);
        this.dgS = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.dgU = findViewById(R.id.titlebar_right_imgzone1);
        this.dgU.setVisibility(dhk[this.dhg]);
        this.dgW = findViewById(R.id.titlebar_right_zones);
        this.dgW.setVisibility(dhk[this.dhe]);
        this.dhp = findViewById(R.id.titlebar_left_zones);
        this.dgV = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.dhq = findViewById(R.id.titlebar_center_zones);
        this.bbg = findViewById(R.id.titlebar_right_menu);
        this.bbd = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.dgy = findViewById(R.id.titlebar_right_menu_line);
        this.bbe = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.dgA);
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
        this.dgI.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.dgK = i;
        setTitle(this.dgA);
    }

    public void setSubTitle(String str) {
        this.dgB = str;
        if (TextUtils.isEmpty(this.dgB)) {
            this.dgJ.setVisibility(8);
        } else {
            this.dgJ.setVisibility(0);
        }
        if (1 == this.dgK) {
            this.dgJ.setText(str);
        } else if (this.dgK == 0) {
            this.dgJ.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.dgB;
    }

    public void setSubTitleColor(int i) {
        this.dgJ.setTextColor(i);
    }

    public void setTitle(String str) {
        this.dgA = str;
        if (1 == this.dgK) {
            this.dgI.setText(str);
            if (this.dho) {
                sV(str);
            } else {
                this.dgH.setText((CharSequence) null);
            }
        } else if (this.dgK == 0) {
            this.dgH.setText(str);
            this.dgI.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.dgA;
    }

    public void setTitleColor(int i) {
        this.dgG = i;
        this.dgI.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.dgH.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dgH.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.dgH.setShadowLayer(f, f2, f3, i);
        this.dgI.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.dgM.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.dgM.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.dgM != null) {
            this.dgM.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.dgM.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.dgM.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.dgM.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.dgL.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.dgW.setVisibility(0);
        }
        this.dgL.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.dgL.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.dgH.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dgL.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.dgL.setClickable(z);
        this.dgM.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dgR.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgR.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.dgR.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dgO.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.dgO.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dgU.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgU.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.dgU.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.dgU.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.dgU.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.dgT = i;
        this.dgS.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.dgS.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.dgO.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.dgO.setEnabled(z);
        this.dgR.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.dgP = i;
        this.dgO.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.dhi = drawable;
        this.dgO.setImageDrawable(this.dhi);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dgO.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.dgO.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.dgR.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.dgU.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.dgV.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.dgN.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.dgV.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dgH.setCompoundDrawables(drawable, null, null, null);
        this.dgH.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dgH.setCompoundDrawables(drawable, null, null, null);
        this.dgH.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.dgH.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.dgH.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.dgH.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.dgL.setBackground(getResources().getDrawable(i));
        this.dht.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.dgL.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.dgL.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.dgH.setBackground(getResources().getDrawable(i));
        this.dgU.setBackground(getResources().getDrawable(i));
        this.dgR.setBackground(getResources().getDrawable(i));
        this.dhm.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.dgT = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.dhj = drawable;
        this.dgS.setImageDrawable(this.dhj);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.dhm.getVisibility() != i) {
            this.dhm.setVisibility(i);
            sV(this.dgA);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.dhm.getVisibility() == 0) {
            this.dhm.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.dgH != null) {
            this.dgH.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.dhm.getVisibility() == 0) {
            this.dhm.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.dhm.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dhm.setCompoundDrawables(drawable, null, null, null);
        this.dhm.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dhm.setCompoundDrawables(drawable, null, null, null);
        this.dhm.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.dhm.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.dho = z;
    }

    public void setLeftTitle(String str) {
        this.dgH.setText(str);
    }

    private void sV(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.dgz = i;
        this.bbd.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bbe.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.dgy.setBackgroundResource(i);
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
        this.dhr = bVar;
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
            if (SwanAppBdActionBar.this.dhr != null) {
                SwanAppBdActionBar.this.dhr.S(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.dgH != null) {
            if (z) {
                this.dgH.setVisibility(0);
            } else {
                this.dgH.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bbe.setVisibility(0);
            this.dgy.setVisibility(0);
            return;
        }
        this.bbe.setVisibility(8);
        this.dgy.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bbg.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.dgL.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.dgW.setVisibility(0);
        }
        this.dht.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.dht.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dht.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.dhu.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.dgQ.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.dhp.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.dgW.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.dhq.setVisibility(i);
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
        return this.dgG;
    }

    public int getRightMenuImageViewSrcId() {
        return this.dgz;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.dgT;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.dgP;
    }

    public TextView getTitleViewCenter() {
        return this.dgI;
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
