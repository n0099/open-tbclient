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
    protected LinearLayout fjk;
    protected TextView fjl;
    private boolean fjn;
    private int fjo;
    protected ImageView fjp;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjn = true;
        this.mContext = context;
        bxm();
        e(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.fjn = true;
        this.mContext = context;
        bxm();
    }

    public void displayTip() {
        if (this.fjl != null) {
            this.fjl.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.fjl != null) {
            this.fjl.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.fjl != null) {
        }
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.fjl != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.fjl.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.fjp.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.fjl.setText(str);
    }

    public CharSequence getTip() {
        return this.fjl.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fjl.setBackgroundDrawable(drawable);
    }

    protected void bxm() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.fjk = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fjl = (TextView) findViewById(R.id.tip);
        this.fjp = (ImageView) findViewById(R.id.arrow2);
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
                this.fjl.setText(string2);
            }
            this.fjn = obtainStyledAttributes.getBoolean(R.styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.fjk.setClickable(false);
        this.fjk.setFocusable(false);
        if (!this.fjn) {
            this.fjp.setVisibility(4);
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
        this.fjl.setTextSize(0, f);
    }

    public void bxn() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.fjl.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.fjk.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0205);
        ap.setViewTextColor(this.textView, R.color.CAM_X0105);
        ap.setViewTextColor(this.fjl, this.fjo == 0 ? R.color.CAM_X0109 : this.fjo);
        SvgManager.bqB().a(this.fjp, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        if (this.fjk != null) {
            this.fjk.setBackgroundDrawable(ap.pt(R.color.CAM_X0205));
        }
    }

    public void setTipViewColor(int i) {
        this.fjo = i;
        ap.setViewTextColor(this.fjl, this.fjo);
    }
}
