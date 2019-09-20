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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected ImageView ahO;
    protected TextView ajd;
    protected LinearLayout cpd;
    protected TextView cpe;
    private boolean cpg;
    protected Context mContext;
    private View mTopLine;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cpg = true;
        this.mContext = context;
        aqK();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.cpg = true;
        this.mContext = context;
        aqK();
    }

    public void displayTip() {
        if (this.cpe != null) {
            this.cpe.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.cpe != null) {
            this.cpe.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.cpe != null) {
        }
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.cpe != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.cpe.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ahO.setVisibility(8);
    }

    public void setText(String str) {
        this.ajd.setText(str);
    }

    public void setText(int i) {
        this.ajd.setText(i);
    }

    public void setTip(String str) {
        this.cpe.setText(str);
    }

    public CharSequence getTip() {
        return this.cpe.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.cpe.setBackgroundDrawable(drawable);
    }

    protected void aqK() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.cpd = (LinearLayout) findViewById(R.id.container);
        this.ajd = (TextView) findViewById(R.id.text);
        this.cpe = (TextView) findViewById(R.id.tip);
        this.ahO = (ImageView) findViewById(R.id.arrow2);
        this.mTopLine = findViewById(R.id.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.a.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(5);
            String string2 = obtainStyledAttributes.getString(1);
            if (string != null) {
                this.ajd.setText(string);
            }
            if (string2 != null) {
                this.cpe.setText(string2);
            }
            this.cpg = obtainStyledAttributes.getBoolean(2, true);
            obtainStyledAttributes.recycle();
        }
        this.cpd.setClickable(false);
        this.cpd.setFocusable(false);
        if (!this.cpg) {
            this.ahO.setVisibility(4);
        }
    }

    @Deprecated
    public void setTopLineVisibility(boolean z) {
        this.mTopLine.setVisibility(8);
    }

    public void setBottomLineVisibility(boolean z) {
    }

    private void setMainTextSize(float f) {
        this.ajd.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.cpe.setTextSize(0, f);
    }

    public void aqL() {
        int g = l.g(this.mContext, R.dimen.tbds42);
        int g2 = l.g(this.mContext, R.dimen.tbds33);
        setMainTextSize(g);
        setTipTextSize(g2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajd.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.cpe.getLayoutParams()).setMargins(0, 0, l.g(this.mContext, R.dimen.tbds18), 0);
        this.cpd.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        am.l(this.mTopLine, R.color.cp_bg_line_e);
        am.j(this.ajd, R.color.cp_cont_b);
        am.j(this.cpe, R.color.cp_cont_d);
        SvgManager.ajv().a(this.ahO, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        if (this.cpd != null) {
            this.cpd.setBackgroundDrawable(am.io(R.color.cp_bg_line_e));
        }
    }
}
