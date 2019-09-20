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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    private static final int[] dkK = {8, 0, 4};
    private a.InterfaceC0176a aPW;
    private boolean bcf;
    private ImageView bcm;
    private ImageView bcn;
    private View bcp;
    private View djY;
    private int djZ;
    private int dkA;
    private float dkB;
    private float dkC;
    private float dkD;
    private int dkE;
    private int dkF;
    private int dkG;
    private int dkH;
    private Drawable dkI;
    private Drawable dkJ;
    private com.baidu.swan.apps.res.ui.a dkL;
    private TextView dkM;
    private b.a dkN;
    private boolean dkO;
    private View dkP;
    private View dkQ;
    private b dkR;
    private int dkS;
    private View dkT;
    private TextView dkU;
    private String dkV;
    private int dkW;
    private ProgressBar dkX;
    private String dka;
    private String dkb;
    private int dkc;
    private float dkd;
    private float dke;
    private float dkf;
    private int dkg;
    private TextView dkh;
    private TextView dki;
    private TextView dkj;
    private int dkk;
    private View dkl;
    private TextView dkm;
    private ProgressBar dkn;
    private ImageView dko;
    private int dkp;
    private ImageView dkq;
    private View dkr;
    private ImageView dks;
    private int dkt;
    private View dku;
    private View dkv;
    private View dkw;
    private String dkx;
    private int dky;
    private float dkz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes4.dex */
    public interface b {
        void U(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.dky = -1;
        this.dkz = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aIt();
            }
        };
        this.dkW = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dky = -1;
        this.dkz = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aIt();
            }
        };
        this.dkW = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dky = -1;
        this.dkz = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aIt();
            }
        };
        this.dkW = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, d.a.SwanAppBdActionBar, 0, 0);
            try {
                this.dka = obtainStyledAttributes.getString(19);
                this.dkc = obtainStyledAttributes.getColor(9, ViewCompat.MEASURED_STATE_MASK);
                this.dkd = obtainStyledAttributes.getFloat(7, -1.0f);
                this.dke = obtainStyledAttributes.getFloat(8, -1.0f);
                this.dkf = obtainStyledAttributes.getFloat(6, -1.0f);
                this.dkS = obtainStyledAttributes.getInt(2, 0);
                this.dkV = obtainStyledAttributes.getString(10);
                this.dkF = obtainStyledAttributes.getInt(2, 0);
                this.dkx = obtainStyledAttributes.getString(10);
                this.dkI = obtainStyledAttributes.getDrawable(17);
                this.dkE = obtainStyledAttributes.getInt(3, 0);
                this.dkJ = obtainStyledAttributes.getDrawable(18);
                this.dkG = obtainStyledAttributes.getInt(0, 0);
                this.dkH = obtainStyledAttributes.getInt(1, 0);
                this.dky = obtainStyledAttributes.getColor(11, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.dkz = obtainStyledAttributes.getDimension(12, -1.0f);
                this.dkA = obtainStyledAttributes.getColor(16, ViewCompat.MEASURED_STATE_MASK);
                this.dkB = obtainStyledAttributes.getFloat(14, -1.0f);
                this.dkC = obtainStyledAttributes.getFloat(15, -1.0f);
                this.dkD = obtainStyledAttributes.getFloat(13, -1.0f);
                this.dkk = obtainStyledAttributes.getInt(4, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.bcp.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.dkN = aVar;
        if (this.dkL != null) {
            this.dkL.a(this.dkN);
        }
    }

    public boolean aIt() {
        if (this.dkL != null) {
            int[] iArr = new int[2];
            this.bcp.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.bcp.getHeight() + getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_top_padding);
            this.dkL.getView().getWidth();
            this.dkL.l(0, (z.getDisplayWidth(getContext()) - dimensionPixelSize) - this.dkL.getView().getWidth(), height);
            this.dkL.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.dkX = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.dkh = (TextView) findViewById(R.id.left_first_view);
        this.dkh.setCompoundDrawables(eJ(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.dkh.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        this.dki = (TextView) findViewById(R.id.title_text_center);
        this.dkj = (TextView) findViewById(R.id.subtitle_text_center);
        this.dkj.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.dkM = (TextView) findViewById(R.id.left_second_view);
        this.dkM.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        if (this.dkd != -1.0f && this.dke != -1.0f && this.dkf != -1.0f) {
            this.dkh.setShadowLayer(this.dkf, this.dkd, this.dke, this.dkc);
        }
        this.dkT = findViewById(R.id.titlebar_right_txtzone2);
        this.dkT.setVisibility(dkK[this.dkS]);
        this.dkU = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.dkV != null) {
            this.dkU.setText(this.dkV);
        }
        if (this.dkW != -1) {
            this.dkU.setTextColor(this.dkW);
        } else {
            this.dkU.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dkl = findViewById(R.id.titlebar_right_txtzone1);
        this.dkl.setVisibility(dkK[this.dkF]);
        this.dkm = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.dkx != null) {
            this.dkm.setText(this.dkx);
        }
        if (this.dky != -1) {
            this.dkm.setTextColor(this.dky);
        } else {
            this.dkm.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dkn = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.dko = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.dkq = (ImageView) findViewById(R.id.new_tip_img);
        this.dkr = findViewById(R.id.titlebar_right_imgzone2);
        this.dkr.setVisibility(dkK[this.dkH]);
        this.dks = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.dku = findViewById(R.id.titlebar_right_imgzone1);
        this.dku.setVisibility(dkK[this.dkG]);
        this.dkw = findViewById(R.id.titlebar_right_zones);
        this.dkw.setVisibility(dkK[this.dkE]);
        this.dkP = findViewById(R.id.titlebar_left_zones);
        this.dkv = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.dkQ = findViewById(R.id.titlebar_center_zones);
        this.bcp = findViewById(R.id.titlebar_right_menu);
        this.bcm = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.djY = findViewById(R.id.titlebar_right_menu_line);
        this.bcn = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.dka);
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
        this.dki.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.dkk = i;
        setTitle(this.dka);
    }

    public void setSubTitle(String str) {
        this.dkb = str;
        if (TextUtils.isEmpty(this.dkb)) {
            this.dkj.setVisibility(8);
        } else {
            this.dkj.setVisibility(0);
        }
        if (1 == this.dkk) {
            this.dkj.setText(str);
        } else if (this.dkk == 0) {
            this.dkj.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.dkb;
    }

    public void setSubTitleColor(int i) {
        this.dkj.setTextColor(i);
    }

    public void setTitle(String str) {
        this.dka = str;
        if (1 == this.dkk) {
            this.dki.setText(str);
            if (this.dkO) {
                tQ(str);
            } else {
                this.dkh.setText((CharSequence) null);
            }
        } else if (this.dkk == 0) {
            this.dkh.setText(str);
            this.dki.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.dka;
    }

    public void setTitleColor(int i) {
        this.dkg = i;
        this.dki.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.dkh.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dkh.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.dkh.setShadowLayer(f, f2, f3, i);
        this.dki.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.dkm.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.dkm.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.dkm != null) {
            this.dkm.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.dkm.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.dkm.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.dkm.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.dkl.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.dkw.setVisibility(0);
        }
        this.dkl.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.dkl.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.dkh.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dkl.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.dkl.setClickable(z);
        this.dkm.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dkr.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dkr.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.dkr.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dko.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.dko.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dku.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dku.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.dku.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.dku.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.dku.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.dkt = i;
        this.dks.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.dks.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.dko.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.dko.setEnabled(z);
        this.dkr.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.dkp = i;
        this.dko.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.dkI = drawable;
        this.dko.setImageDrawable(this.dkI);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dko.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.dko.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.dkr.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.dku.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.dkv.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.dkn.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.dkv.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dkh.setCompoundDrawables(drawable, null, null, null);
        this.dkh.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dkh.setCompoundDrawables(drawable, null, null, null);
        this.dkh.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.dkh.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.dkh.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.dkh.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.dkl.setBackground(getResources().getDrawable(i));
        this.dkT.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.dkl.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.dkl.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.dkh.setBackground(getResources().getDrawable(i));
        this.dku.setBackground(getResources().getDrawable(i));
        this.dkr.setBackground(getResources().getDrawable(i));
        this.dkM.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.dkt = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.dkJ = drawable;
        this.dks.setImageDrawable(this.dkJ);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.dkM.getVisibility() != i) {
            this.dkM.setVisibility(i);
            tQ(this.dka);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.dkM.getVisibility() == 0) {
            this.dkM.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.dkh != null) {
            this.dkh.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.dkM.getVisibility() == 0) {
            this.dkM.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.dkM.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dkM.setCompoundDrawables(drawable, null, null, null);
        this.dkM.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dkM.setCompoundDrawables(drawable, null, null, null);
        this.dkM.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.dkM.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.dkO = z;
    }

    public void setLeftTitle(String str) {
        this.dkh.setText(str);
    }

    private void tQ(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.djZ = i;
        this.bcm.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bcn.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.djY.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.bcp.setBackgroundResource(i);
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
        this.dkR = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0176a interfaceC0176a) {
        this.aPW = interfaceC0176a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.bcf;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.dkR != null) {
                SwanAppBdActionBar.this.dkR.U(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.dkh != null) {
            if (z) {
                this.dkh.setVisibility(0);
            } else {
                this.dkh.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bcn.setVisibility(0);
            this.djY.setVisibility(0);
            return;
        }
        this.bcn.setVisibility(8);
        this.djY.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bcp.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.dkl.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.dkw.setVisibility(0);
        }
        this.dkT.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.dkT.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dkT.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.dkU.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.dkq.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.dkP.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.dkw.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.dkQ.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.bcp.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.bcm.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.bcn.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.dkg;
    }

    public int getRightMenuImageViewSrcId() {
        return this.djZ;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.dkt;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.dkp;
    }

    public TextView getTitleViewCenter() {
        return this.dki;
    }

    public View getRightMenu() {
        return this.bcp;
    }

    private Drawable eJ(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.bcf = z;
        int i = this.bcf ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
