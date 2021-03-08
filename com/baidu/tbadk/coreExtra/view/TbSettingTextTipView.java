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
    private int fzA;
    protected ImageView fzB;
    protected LinearLayout fzw;
    protected TextView fzx;
    private boolean fzz;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzz = true;
        this.mContext = context;
        bzI();
        h(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.fzz = true;
        this.mContext = context;
        bzI();
    }

    public void displayTip() {
        if (this.fzx != null) {
            this.fzx.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.fzx != null) {
            this.fzx.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.fzx != null) {
        }
    }

    public void A(int i, int i2, int i3, int i4) {
        if (this.fzx != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.fzx.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.fzB.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.fzx.setText(str);
    }

    public CharSequence getTip() {
        return this.fzx.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fzx.setBackgroundDrawable(drawable);
    }

    protected void bzI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.fzw = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fzx = (TextView) findViewById(R.id.tip);
        this.fzB = (ImageView) findViewById(R.id.arrow2);
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
                this.fzx.setText(string2);
            }
            this.fzz = obtainStyledAttributes.getBoolean(R.styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.fzw.setClickable(false);
        this.fzw.setFocusable(false);
        if (!this.fzz) {
            this.fzB.setVisibility(4);
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
        this.fzx.setTextSize(0, f);
    }

    public void bzJ() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.fzx.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.fzw.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0205);
        ap.setViewTextColor(this.textView, R.color.CAM_X0105);
        ap.setViewTextColor(this.fzx, this.fzA == 0 ? R.color.CAM_X0109 : this.fzA);
        SvgManager.bsU().a(this.fzB, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        if (this.fzw != null) {
            this.fzw.setBackgroundDrawable(ap.oD(R.color.CAM_X0205));
        }
    }

    public void setTipViewColor(int i) {
        this.fzA = i;
        ap.setViewTextColor(this.fzx, this.fzA);
    }
}
