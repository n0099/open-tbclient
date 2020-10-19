package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout eVN;
    protected TextView eVO;
    private boolean eVQ;
    private int eVR;
    protected ImageView eVS;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eVQ = true;
        this.mContext = context;
        btE();
        e(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.eVQ = true;
        this.mContext = context;
        btE();
    }

    public void displayTip() {
        if (this.eVO != null) {
            this.eVO.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.eVO != null) {
            this.eVO.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.eVO != null) {
        }
    }

    public void u(int i, int i2, int i3, int i4) {
        if (this.eVO != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.eVO.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.eVS.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.eVO.setText(str);
    }

    public CharSequence getTip() {
        return this.eVO.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.eVO.setBackgroundDrawable(drawable);
    }

    protected void btE() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.eVN = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.eVO = (TextView) findViewById(R.id.tip);
        this.eVS = (ImageView) findViewById(R.id.arrow2);
        this.mTopLine = findViewById(R.id.top_line_ll);
    }

    protected void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
            if (string != null) {
                this.textView.setText(string);
            }
            if (string2 != null) {
                this.eVO.setText(string2);
            }
            this.eVQ = obtainStyledAttributes.getBoolean(R.styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.eVN.setClickable(false);
        this.eVN.setFocusable(false);
        if (!this.eVQ) {
            this.eVS.setVisibility(4);
        }
    }

    @Deprecated
    public void setTopLineVisibility(boolean z) {
        this.mTopLine.setVisibility(8);
    }

    public void setBottomLineVisibility(boolean z) {
    }

    private void setMainTextSize(float f) {
        this.textView.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.eVO.setTextSize(0, f);
    }

    public void btF() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.eVO.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.eVN.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.textView, R.color.cp_cont_b);
        ap.setViewTextColor(this.eVO, this.eVR == 0 ? R.color.cp_cont_d : this.eVR);
        SvgManager.bmU().a(this.eVS, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        if (this.eVN != null) {
            this.eVN.setBackgroundDrawable(ap.oC(R.color.cp_bg_line_e));
        }
    }

    public void setTipViewColor(int i) {
        this.eVR = i;
        ap.setViewTextColor(this.eVO, this.eVR);
    }
}
