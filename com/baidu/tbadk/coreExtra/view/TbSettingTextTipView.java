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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout dTF;
    protected TextView dTG;
    private boolean dTI;
    protected ImageView dTJ;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTI = true;
        this.mContext = context;
        aVu();
        e(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.dTI = true;
        this.mContext = context;
        aVu();
    }

    public void displayTip() {
        if (this.dTG != null) {
            this.dTG.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.dTG != null) {
            this.dTG.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.dTG != null) {
        }
    }

    public void s(int i, int i2, int i3, int i4) {
        if (this.dTG != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.dTG.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.dTJ.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.dTG.setText(str);
    }

    public CharSequence getTip() {
        return this.dTG.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.dTG.setBackgroundDrawable(drawable);
    }

    protected void aVu() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.dTF = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dTG = (TextView) findViewById(R.id.tip);
        this.dTJ = (ImageView) findViewById(R.id.arrow2);
        this.mTopLine = findViewById(R.id.top_line_ll);
    }

    protected void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(5);
            String string2 = obtainStyledAttributes.getString(1);
            if (string != null) {
                this.textView.setText(string);
            }
            if (string2 != null) {
                this.dTG.setText(string2);
            }
            this.dTI = obtainStyledAttributes.getBoolean(2, true);
            obtainStyledAttributes.recycle();
        }
        this.dTF.setClickable(false);
        this.dTF.setFocusable(false);
        if (!this.dTI) {
            this.dTJ.setVisibility(4);
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
        this.dTG.setTextSize(0, f);
    }

    public void aVv() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.dTG.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.dTF.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_e);
        am.setViewTextColor(this.textView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dTG, (int) R.color.cp_cont_d);
        SvgManager.aOU().a(this.dTJ, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        if (this.dTF != null) {
            this.dTF.setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
        }
    }
}
