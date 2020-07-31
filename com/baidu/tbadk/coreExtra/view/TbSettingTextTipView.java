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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout ewV;
    protected TextView ewW;
    private boolean ewY;
    protected ImageView ewZ;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewY = true;
        this.mContext = context;
        bhn();
        e(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.ewY = true;
        this.mContext = context;
        bhn();
    }

    public void displayTip() {
        if (this.ewW != null) {
            this.ewW.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.ewW != null) {
            this.ewW.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.ewW != null) {
        }
    }

    public void u(int i, int i2, int i3, int i4) {
        if (this.ewW != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.ewW.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ewZ.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.ewW.setText(str);
    }

    public CharSequence getTip() {
        return this.ewW.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ewW.setBackgroundDrawable(drawable);
    }

    protected void bhn() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.ewV = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.ewW = (TextView) findViewById(R.id.tip);
        this.ewZ = (ImageView) findViewById(R.id.arrow2);
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
                this.ewW.setText(string2);
            }
            this.ewY = obtainStyledAttributes.getBoolean(R.styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.ewV.setClickable(false);
        this.ewV.setFocusable(false);
        if (!this.ewY) {
            this.ewZ.setVisibility(4);
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
        this.ewW.setTextSize(0, f);
    }

    public void bho() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.ewW.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.ewV.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.textView, R.color.cp_cont_b);
        ao.setViewTextColor(this.ewW, R.color.cp_cont_d);
        SvgManager.baR().a(this.ewZ, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        if (this.ewV != null) {
            this.ewV.setBackgroundDrawable(ao.lM(R.color.cp_bg_line_e));
        }
    }
}
