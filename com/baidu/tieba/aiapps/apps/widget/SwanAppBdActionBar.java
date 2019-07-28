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
    private static final int[] diS = {8, 0, 4};
    private a.InterfaceC0167a aPy;
    private boolean bbH;
    private ImageView bbO;
    private ImageView bbP;
    private View bbR;
    private ImageView diA;
    private int diB;
    private View diC;
    private View diD;
    private View diE;
    private String diF;
    private int diG;
    private float diH;
    private int diI;
    private float diJ;
    private float diK;
    private float diL;
    private int diM;
    private int diN;
    private int diO;
    private int diP;
    private Drawable diQ;
    private Drawable diR;
    private com.baidu.swan.apps.res.ui.a diT;
    private TextView diU;
    private b.a diV;
    private boolean diW;
    private View diX;
    private View diY;
    private b diZ;
    private View dig;
    private int dih;
    private String dii;
    private String dij;
    private int dik;
    private float dil;
    private float dim;
    private float din;
    private int dio;
    private TextView dip;
    private TextView diq;
    private TextView dir;
    private int dis;
    private View dit;
    private TextView diu;
    private ProgressBar div;
    private ImageView diw;
    private int dix;
    private ImageView diy;
    private View diz;
    private int dja;
    private View djb;
    private TextView djc;
    private String djd;
    private int dje;
    private ProgressBar djf;
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
        this.diG = -1;
        this.diH = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aHN();
            }
        };
        this.dje = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diG = -1;
        this.diH = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aHN();
            }
        };
        this.dje = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.diG = -1;
        this.diH = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.aHN();
            }
        };
        this.dje = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, c.a.SwanAppBdActionBar, 0, 0);
            try {
                this.dii = obtainStyledAttributes.getString(19);
                this.dik = obtainStyledAttributes.getColor(9, ViewCompat.MEASURED_STATE_MASK);
                this.dil = obtainStyledAttributes.getFloat(7, -1.0f);
                this.dim = obtainStyledAttributes.getFloat(8, -1.0f);
                this.din = obtainStyledAttributes.getFloat(6, -1.0f);
                this.dja = obtainStyledAttributes.getInt(2, 0);
                this.djd = obtainStyledAttributes.getString(10);
                this.diN = obtainStyledAttributes.getInt(2, 0);
                this.diF = obtainStyledAttributes.getString(10);
                this.diQ = obtainStyledAttributes.getDrawable(17);
                this.diM = obtainStyledAttributes.getInt(3, 0);
                this.diR = obtainStyledAttributes.getDrawable(18);
                this.diO = obtainStyledAttributes.getInt(0, 0);
                this.diP = obtainStyledAttributes.getInt(1, 0);
                this.diG = obtainStyledAttributes.getColor(11, getResources().getColor(R.color.aiapps_action_bar_operation_btn_txt_color));
                this.diH = obtainStyledAttributes.getDimension(12, -1.0f);
                this.diI = obtainStyledAttributes.getColor(16, ViewCompat.MEASURED_STATE_MASK);
                this.diJ = obtainStyledAttributes.getFloat(14, -1.0f);
                this.diK = obtainStyledAttributes.getFloat(15, -1.0f);
                this.diL = obtainStyledAttributes.getFloat(13, -1.0f);
                this.dis = obtainStyledAttributes.getInt(4, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.bbR.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.diV = aVar;
        if (this.diT != null) {
            this.diT.a(this.diV);
        }
    }

    public boolean aHN() {
        if (this.diT != null) {
            int[] iArr = new int[2];
            this.bbR.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.bbR.getHeight() + getContext().getResources().getDimensionPixelSize(R.dimen.aiapps_actionbar_menu_top_padding);
            this.diT.getView().getWidth();
            this.diT.l(0, (z.getDisplayWidth(getContext()) - dimensionPixelSize) - this.diT.getView().getWidth(), height);
            this.diT.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ai_apps_action_bar, this);
        this.djf = (ProgressBar) findViewById(R.id.aiapps_nav_loading_progressbar);
        this.dip = (TextView) findViewById(R.id.left_first_view);
        this.dip.setCompoundDrawables(eI(R.drawable.aiapps_action_bar_back_selector), null, null, null);
        this.dip.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        this.diq = (TextView) findViewById(R.id.title_text_center);
        this.dir = (TextView) findViewById(R.id.subtitle_text_center);
        this.dir.setTextColor(getResources().getColor(R.color.aiapps_white_text));
        this.diU = (TextView) findViewById(R.id.left_second_view);
        this.diU.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        if (this.dil != -1.0f && this.dim != -1.0f && this.din != -1.0f) {
            this.dip.setShadowLayer(this.din, this.dil, this.dim, this.dik);
        }
        this.djb = findViewById(R.id.titlebar_right_txtzone2);
        this.djb.setVisibility(diS[this.dja]);
        this.djc = (TextView) findViewById(R.id.titlebar_right_txtzone2_txt);
        if (this.djd != null) {
            this.djc.setText(this.djd);
        }
        if (this.dje != -1) {
            this.djc.setTextColor(this.dje);
        } else {
            this.djc.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.dit = findViewById(R.id.titlebar_right_txtzone1);
        this.dit.setVisibility(diS[this.diN]);
        this.diu = (TextView) findViewById(R.id.titlebar_right_txtzone1_txt);
        if (this.diF != null) {
            this.diu.setText(this.diF);
        }
        if (this.diG != -1) {
            this.diu.setTextColor(this.diG);
        } else {
            this.diu.setTextColor(getResources().getColorStateList(R.color.aiapps_action_bar_operation_btn_selector));
        }
        this.div = (ProgressBar) findViewById(R.id.titlebar_right_txtzone1_progress);
        this.diw = (ImageView) findViewById(R.id.titlebar_right_imgzone2_img);
        this.diy = (ImageView) findViewById(R.id.new_tip_img);
        this.diz = findViewById(R.id.titlebar_right_imgzone2);
        this.diz.setVisibility(diS[this.diP]);
        this.diA = (ImageView) findViewById(R.id.titlebar_right_imgzone1_img);
        this.diC = findViewById(R.id.titlebar_right_imgzone1);
        this.diC.setVisibility(diS[this.diO]);
        this.diE = findViewById(R.id.titlebar_right_zones);
        this.diE.setVisibility(diS[this.diM]);
        this.diX = findViewById(R.id.titlebar_left_zones);
        this.diD = findViewById(R.id.titlebar_right_imgzone2_notify);
        this.diY = findViewById(R.id.titlebar_center_zones);
        this.bbR = findViewById(R.id.titlebar_right_menu);
        this.bbO = (ImageView) findViewById(R.id.titlebar_right_menu_img);
        this.dig = findViewById(R.id.titlebar_right_menu_line);
        this.bbP = (ImageView) findViewById(R.id.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.dii);
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
        this.diq.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.dis = i;
        setTitle(this.dii);
    }

    public void setSubTitle(String str) {
        this.dij = str;
        if (TextUtils.isEmpty(this.dij)) {
            this.dir.setVisibility(8);
        } else {
            this.dir.setVisibility(0);
        }
        if (1 == this.dis) {
            this.dir.setText(str);
        } else if (this.dis == 0) {
            this.dir.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.dij;
    }

    public void setSubTitleColor(int i) {
        this.dir.setTextColor(i);
    }

    public void setTitle(String str) {
        this.dii = str;
        if (1 == this.dis) {
            this.diq.setText(str);
            if (this.diW) {
                tq(str);
            } else {
                this.dip.setText((CharSequence) null);
            }
        } else if (this.dis == 0) {
            this.dip.setText(str);
            this.diq.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.dii;
    }

    public void setTitleColor(int i) {
        this.dio = i;
        this.diq.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.dip.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dip.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.dip.setShadowLayer(f, f2, f3, i);
        this.diq.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.diu.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.diu.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.diu != null) {
            this.diu.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.diu.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.diu.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.diu.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.dit.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.diE.setVisibility(0);
        }
        this.dit.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.dit.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.dip.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.dit.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.dit.setClickable(z);
        this.diu.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.diz.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.diz.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.diz.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.diw.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.diw.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.diC.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.diC.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.diC.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.diC.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.diC.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.diB = i;
        this.diA.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.diA.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.diw.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.diw.setEnabled(z);
        this.diz.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.dix = i;
        this.diw.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.diQ = drawable;
        this.diw.setImageDrawable(this.diQ);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.diw.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.diw.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.diz.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.diC.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.diD.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.div.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.diD.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dip.setCompoundDrawables(drawable, null, null, null);
        this.dip.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.dip.setCompoundDrawables(drawable, null, null, null);
        this.dip.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.dip.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.dip.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.dip.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.dit.setBackground(getResources().getDrawable(i));
        this.djb.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.dit.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.dit.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.dip.setBackground(getResources().getDrawable(i));
        this.diC.setBackground(getResources().getDrawable(i));
        this.diz.setBackground(getResources().getDrawable(i));
        this.diU.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.diB = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.diR = drawable;
        this.diA.setImageDrawable(this.diR);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.diU.getVisibility() != i) {
            this.diU.setVisibility(i);
            tq(this.dii);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.diU.getVisibility() == 0) {
            this.diU.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.dip != null) {
            this.dip.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.diU.getVisibility() == 0) {
            this.diU.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.diU.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.diU.setCompoundDrawables(drawable, null, null, null);
        this.diU.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.diU.setCompoundDrawables(drawable, null, null, null);
        this.diU.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.diU.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.diW = z;
    }

    public void setLeftTitle(String str) {
        this.dip.setText(str);
    }

    private void tq(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.dih = i;
        this.bbO.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bbP.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.dig.setBackgroundResource(i);
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
        this.diZ = bVar;
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
            if (SwanAppBdActionBar.this.diZ != null) {
                SwanAppBdActionBar.this.diZ.U(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.dip != null) {
            if (z) {
                this.dip.setVisibility(0);
            } else {
                this.dip.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bbP.setVisibility(0);
            this.dig.setVisibility(0);
            return;
        }
        this.bbP.setVisibility(8);
        this.dig.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bbR.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.dit.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.diE.setVisibility(0);
        }
        this.djb.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.djb.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.djb.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.djc.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.diy.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.diX.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.diE.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.diY.setVisibility(i);
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
        return this.dio;
    }

    public int getRightMenuImageViewSrcId() {
        return this.dih;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.diB;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.dix;
    }

    public TextView getTitleViewCenter() {
        return this.diq;
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
