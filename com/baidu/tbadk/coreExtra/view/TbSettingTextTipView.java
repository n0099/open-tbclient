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
    protected LinearLayout fvH;
    protected TextView fvI;
    private boolean fvK;
    private int fvL;
    protected ImageView fvM;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvK = true;
        this.mContext = context;
        bzn();
        i(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.fvK = true;
        this.mContext = context;
        bzn();
    }

    public void displayTip() {
        if (this.fvI != null) {
            this.fvI.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.fvI != null) {
            this.fvI.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.fvI != null) {
        }
    }

    public void A(int i, int i2, int i3, int i4) {
        if (this.fvI != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.fvI.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.fvM.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.fvI.setText(str);
    }

    public CharSequence getTip() {
        return this.fvI.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fvI.setBackgroundDrawable(drawable);
    }

    protected void bzn() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.fvH = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fvI = (TextView) findViewById(R.id.tip);
        this.fvM = (ImageView) findViewById(R.id.arrow2);
        this.mTopLine = findViewById(R.id.top_line_ll);
    }

    protected void i(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
            if (string != null) {
                this.textView.setText(string);
            }
            if (string2 != null) {
                this.fvI.setText(string2);
            }
            this.fvK = obtainStyledAttributes.getBoolean(R.styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.fvH.setClickable(false);
        this.fvH.setFocusable(false);
        if (!this.fvK) {
            this.fvM.setVisibility(4);
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
        this.fvI.setTextSize(0, f);
    }

    public void bzo() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.fvI.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.fvH.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0205);
        ao.setViewTextColor(this.textView, R.color.CAM_X0105);
        ao.setViewTextColor(this.fvI, this.fvL == 0 ? R.color.CAM_X0109 : this.fvL);
        SvgManager.bsx().a(this.fvM, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        if (this.fvH != null) {
            this.fvH.setBackgroundDrawable(ao.ox(R.color.CAM_X0205));
        }
    }

    public void setTipViewColor(int i) {
        this.fvL = i;
        ao.setViewTextColor(this.fvI, this.fvL);
    }
}
