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
    protected LinearLayout fqI;
    protected TextView fqJ;
    private boolean fqL;
    private int fqM;
    protected ImageView fqN;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fqL = true;
        this.mContext = context;
        bAM();
        e(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.fqL = true;
        this.mContext = context;
        bAM();
    }

    public void displayTip() {
        if (this.fqJ != null) {
            this.fqJ.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.fqJ != null) {
            this.fqJ.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.fqJ != null) {
        }
    }

    public void z(int i, int i2, int i3, int i4) {
        if (this.fqJ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.fqJ.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.fqN.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.fqJ.setText(str);
    }

    public CharSequence getTip() {
        return this.fqJ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fqJ.setBackgroundDrawable(drawable);
    }

    protected void bAM() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.fqI = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fqJ = (TextView) findViewById(R.id.tip);
        this.fqN = (ImageView) findViewById(R.id.arrow2);
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
                this.fqJ.setText(string2);
            }
            this.fqL = obtainStyledAttributes.getBoolean(R.styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.fqI.setClickable(false);
        this.fqI.setFocusable(false);
        if (!this.fqL) {
            this.fqN.setVisibility(4);
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
        this.fqJ.setTextSize(0, f);
    }

    public void bAN() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.fqJ.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.fqI.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0205);
        ap.setViewTextColor(this.textView, R.color.CAM_X0105);
        ap.setViewTextColor(this.fqJ, this.fqM == 0 ? R.color.CAM_X0109 : this.fqM);
        SvgManager.btW().a(this.fqN, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        if (this.fqI != null) {
            this.fqI.setBackgroundDrawable(ap.pT(R.color.CAM_X0205));
        }
    }

    public void setTipViewColor(int i) {
        this.fqM = i;
        ap.setViewTextColor(this.fqJ, this.fqM);
    }
}
