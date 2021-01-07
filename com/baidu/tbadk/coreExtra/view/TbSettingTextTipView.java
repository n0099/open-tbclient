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
    protected LinearLayout fAp;
    protected TextView fAq;
    private boolean fAs;
    private int fAt;
    protected ImageView fAu;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAs = true;
        this.mContext = context;
        bDh();
        i(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.fAs = true;
        this.mContext = context;
        bDh();
    }

    public void displayTip() {
        if (this.fAq != null) {
            this.fAq.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.fAq != null) {
            this.fAq.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.fAq != null) {
        }
    }

    public void A(int i, int i2, int i3, int i4) {
        if (this.fAq != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.fAq.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.fAu.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.fAq.setText(str);
    }

    public CharSequence getTip() {
        return this.fAq.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fAq.setBackgroundDrawable(drawable);
    }

    protected void bDh() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.fAp = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fAq = (TextView) findViewById(R.id.tip);
        this.fAu = (ImageView) findViewById(R.id.arrow2);
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
                this.fAq.setText(string2);
            }
            this.fAs = obtainStyledAttributes.getBoolean(R.styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.fAp.setClickable(false);
        this.fAp.setFocusable(false);
        if (!this.fAs) {
            this.fAu.setVisibility(4);
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
        this.fAq.setTextSize(0, f);
    }

    public void bDi() {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds42);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds33);
        setMainTextSize(dimens);
        setTipTextSize(dimens2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.fAq.getLayoutParams()).setMargins(0, 0, l.getDimens(this.mContext, R.dimen.tbds18), 0);
        this.fAp.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0205);
        ao.setViewTextColor(this.textView, R.color.CAM_X0105);
        ao.setViewTextColor(this.fAq, this.fAt == 0 ? R.color.CAM_X0109 : this.fAt);
        SvgManager.bwr().a(this.fAu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        if (this.fAp != null) {
            this.fAp.setBackgroundDrawable(ao.qe(R.color.CAM_X0205));
        }
    }

    public void setTipViewColor(int i) {
        this.fAt = i;
        ao.setViewTextColor(this.fAq, this.fAt);
    }
}
