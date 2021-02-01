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
    protected LinearLayout fxX;
    protected TextView fxY;
    private boolean fya;
    private int fyb;
    protected ImageView fyc;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fya = true;
        this.mContext = context;
        bzF();
        h(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.fya = true;
        this.mContext = context;
        bzF();
    }

    public void displayTip() {
        if (this.fxY != null) {
            this.fxY.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.fxY != null) {
            this.fxY.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.fxY != null) {
        }
    }

    public void A(int i, int i2, int i3, int i4) {
        if (this.fxY != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.fxY.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.fyc.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.fxY.setText(str);
    }

    public CharSequence getTip() {
        return this.fxY.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fxY.setBackgroundDrawable(drawable);
    }

    protected void bzF() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.fxX = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fxY = (TextView) findViewById(R.id.tip);
        this.fyc = (ImageView) findViewById(R.id.arrow2);
        this.mTopLine = findViewById(R.id.top_line_ll);
    }

    protected void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
            if (string != null) {
                this.textView.setText(string);
            }
            if (string2 != null) {
                this.fxY.setText(string2);
            }
            this.fya = obtainStyledAttributes.getBoolean(R.styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.fxX.setClickable(false);
        this.fxX.setFocusable(false);
        if (!this.fya) {
            this.fyc.setVisibility(4);
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
        this.fxY.setTextSize(0, f);
    }

    public void bzG() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.fxY.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.fxX.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0205);
        ap.setViewTextColor(this.textView, R.color.CAM_X0105);
        ap.setViewTextColor(this.fxY, this.fyb == 0 ? R.color.CAM_X0109 : this.fyb);
        SvgManager.bsR().a(this.fyc, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        if (this.fxX != null) {
            this.fxX.setBackgroundDrawable(ap.oC(R.color.CAM_X0205));
        }
    }

    public void setTipViewColor(int i) {
        this.fyb = i;
        ap.setViewTextColor(this.fxY, this.fyb);
    }
}
