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
    private static final int[] diZ = {8, 0, 4};
    private a.InterfaceC0167a aPy;
    private boolean bbH;
    private ImageView bbO;
    private ImageView bbP;
    private View bbR;
    private View diA;
    private TextView diB;
    private ProgressBar diC;
    private ImageView diD;
    private int diE;
    private ImageView diF;
    private View diG;
    private ImageView diH;
    private int diI;
    private View diJ;
    private View diK;
    private View diL;
    private String diM;
    private int diN;
    private float diO;
    private int diP;
    private float diQ;
    private float diR;
    private float diS;
    private int diT;
    private int diU;
    private int diV;
    private int diW;
    private Drawable diX;
    private Drawable diY;
    private View din;
    private int dio;
    private String dip;
    private String diq;
    private int dir;
    private float dis;
    private float dit;
    private float diu;
    private int div;
    private TextView diw;
    private TextView dix;
    private TextView diy;
    private int diz;
    private com.baidu.swan.apps.res.ui.a dja;
    private TextView djb;
    private b.a djc;
    private boolean djd;
    private View dje;
    private View djf;
    private b djg;
    private int djh;
    private View dji;
    private TextView djj;
    private String djk;
    private int djl;
    private ProgressBar djm;
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
        this.diN = -1;
        this.diO = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aHP();
            }
        };
        this.djl = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diN = -1;
        this.diO = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aHP();
            }
        };
        this.djl = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.diN = -1;
        this.diO = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aHP();
            }
        };
        this.djl = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, c.a.SwanAppBdActionBar, 0, 0);
            try {
                this.dip = obtainStyledAttributes.getString(19);
                this.dir = obtainStyledAttributes.getColor(9, ViewCompat.MEASURED_STATE_MASK);
                this.dis = obtainStyledAttributes.getFloat(7, -1.0f);
                this.dit = obtainStyledAttributes.getFloat(8, -1.0f);
                this.diu = obtainStyledAttributes.getFloat(6, -1.0f);
                this.djh = obtainStyledAttributes.getInt(2, 0);
                this.djk = obtainStyledAttributes.getString(10);
                this.diU = obtainStyledAttributes.getInt(2, 0);
                this.diM = obtainStyledAttributes.getString(10);
                this.diX = obtainStyledAttributes.getDrawable(17);
                this.diT = obtainStyledAttributes.getInt(3, 0);
                this.diY = obtainStyledAttributes.getDrawable(18);
                this.diV = obtainStyledAttributes.getInt(0, 0);
                this.diW = obtainStyledAttributes.getInt(1, 0);
                this.diN = obtainStyledAttributes.getColor(11, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.diO = obtainStyledAttributes.getDimension(12, -1.0f);
                this.diP = obtainStyledAttributes.getColor(16, ViewCompat.MEASURED_STATE_MASK);
                this.diQ = obtainStyledAttributes.getFloat(14, -1.0f);
                this.diR = obtainStyledAttributes.getFloat(15, -1.0f);
                this.diS = obtainStyledAttributes.getFloat(13, -1.0f);
                this.diz = obtainStyledAttributes.getInt(4, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.bbR.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.djc = aVar;
        if (this.dja != null) {
            this.dja.a(this.djc);
        }
    }

    public boolean aHP() {
        if (this.dja != null) {
            int[] iArr = new int[2];
            this.bbR.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.bbR.getHeight() + getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_top_padding);
            this.dja.getView().getWidth();
            this.dja.l(0, (z.getDisplayWidth(getContext()) - dimensionPixelSize) - this.dja.getView().getWidth(), height);
            this.dja.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.djm = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.diw = (TextView) findViewById(R.id.left_first_view);
        this.diw.setCompoundDrawables(eI(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.diw.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        this.dix = (TextView) findViewById(R.id.title_text_center);
        this.diy = (TextView) findViewById(R.id.subtitle_text_center);
        this.diy.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.djb = (TextView) findViewById(R.id.left_second_view);
        this.djb.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        if (this.dis != -1.0f && this.dit != -1.0f && this.diu != -1.0f) {
            this.diw.setShadowLayer(this.diu, this.dis, this.dit, this.dir);
        }
        this.dji = findViewById(R.id.titlebar_right_txtzone2);
        this.dji.setVisibility(diZ[this.djh]);
        this.djj = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.djk != null) {
            this.djj.setText(this.djk);
        }
        if (this.djl != -1) {
            this.djj.setTextColor(this.djl);
        } else {
            this.djj.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.diA = findViewById(R.id.titlebar_right_txtzone1);
        this.diA.setVisibility(diZ[this.diU]);
        this.diB = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.diM != null) {
            this.diB.setText(this.diM);
        }
        if (this.diN != -1) {
            this.diB.setTextColor(this.diN);
        } else {
            this.diB.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.diC = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.diD = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.diF = (ImageView) findViewById(R.id.new_tip_img);
        this.diG = findViewById(R.id.titlebar_right_imgzone2);
        this.diG.setVisibility(diZ[this.diW]);
        this.diH = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.diJ = findViewById(R.id.titlebar_right_imgzone1);
        this.diJ.setVisibility(diZ[this.diV]);
        this.diL = findViewById(R.id.titlebar_right_zones);
        this.diL.setVisibility(diZ[this.diT]);
        this.dje = findViewById(R.id.titlebar_left_zones);
        this.diK = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.djf = findViewById(R.id.titlebar_center_zones);
        this.bbR = findViewById(R.id.titlebar_right_menu);
        this.bbO = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.din = findViewById(R.id.titlebar_right_menu_line);
        this.bbP = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.dip);
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
        this.dix.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.diz = i;
        setTitle(this.dip);
    }

    public void setSubTitle(String str) {
        this.diq = str;
        if (TextUtils.isEmpty(this.diq)) {
            this.diy.setVisibility(8);
        } else {
            this.diy.setVisibility(0);
        }
        if (1 == this.diz) {
            this.diy.setText(str);
        } else if (this.diz == 0) {
            this.diy.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.diq;
    }

    public void setSubTitleColor(int i) {
        this.diy.setTextColor(i);
    }

    public void setTitle(String str) {
        this.dip = str;
        if (1 == this.diz) {
            this.dix.setText(str);
            if (this.djd) {
                tr(str);
            } else {
                this.diw.setText((CharSequence) null);
            }
        } else if (this.diz == 0) {
            this.diw.setText(str);
            this.dix.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.dip;
    }

    public void setTitleColor(int i) {
        this.div = i;
        this.dix.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.diw.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.diw.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.diw.setShadowLayer(f, f2, f3, i);
        this.dix.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.diB.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.diB.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.diB != null) {
            this.diB.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.diB.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.diB.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.diB.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.diA.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.diL.setVisibility(0);
        }
        this.diA.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.diA.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.diw.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.diA.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.diA.setClickable(z);
        this.diB.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.diG.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.diG.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.diG.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.diD.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.diD.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.diJ.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.diJ.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.diJ.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.diJ.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.diJ.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.diI = i;
        this.diH.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.diH.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.diD.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.diD.setEnabled(z);
        this.diG.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.diE = i;
        this.diD.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.diX = drawable;
        this.diD.setImageDrawable(this.diX);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.diD.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.diD.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.diG.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.diJ.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.diK.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.diC.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.diK.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.diw.setCompoundDrawables(drawable, null, null, null);
        this.diw.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.diw.setCompoundDrawables(drawable, null, null, null);
        this.diw.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.diw.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.diw.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.diw.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.diA.setBackground(getResources().getDrawable(i));
        this.dji.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.diA.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.diA.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.diw.setBackground(getResources().getDrawable(i));
        this.diJ.setBackground(getResources().getDrawable(i));
        this.diG.setBackground(getResources().getDrawable(i));
        this.djb.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.diI = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.diY = drawable;
        this.diH.setImageDrawable(this.diY);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.djb.getVisibility() != i) {
            this.djb.setVisibility(i);
            tr(this.dip);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.djb.getVisibility() == 0) {
            this.djb.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.diw != null) {
            this.diw.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.djb.getVisibility() == 0) {
            this.djb.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.djb.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.djb.setCompoundDrawables(drawable, null, null, null);
        this.djb.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.djb.setCompoundDrawables(drawable, null, null, null);
        this.djb.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.djb.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.djd = z;
    }

    public void setLeftTitle(String str) {
        this.diw.setText(str);
    }

    private void tr(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.dio = i;
        this.bbO.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bbP.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.din.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.bbR.setBackgroundResource(i);
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
        this.djg = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0167a interfaceC0167a) {
        this.aPy = interfaceC0167a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.bbH;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.djg != null) {
                SwanAppBdActionBar.this.djg.U(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.diw != null) {
            if (z) {
                this.diw.setVisibility(0);
            } else {
                this.diw.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bbP.setVisibility(0);
            this.din.setVisibility(0);
            return;
        }
        this.bbP.setVisibility(8);
        this.din.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bbR.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.diA.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.diL.setVisibility(0);
        }
        this.dji.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.dji.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.dji.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.djj.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.diF.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.dje.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.diL.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.djf.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.bbR.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.bbO.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.bbP.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.div;
    }

    public int getRightMenuImageViewSrcId() {
        return this.dio;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.diI;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.diE;
    }

    public TextView getTitleViewCenter() {
        return this.dix;
    }

    public View getRightMenu() {
        return this.bbR;
    }

    private Drawable eI(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.bbH = z;
        int i = this.bbH ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
