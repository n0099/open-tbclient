package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private TextView alV;
    protected TextView alW;
    private BdSwitchView alX;
    private LinearLayout container;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zm();
        c(attributeSet);
        dF(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        zm();
        dF(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        zm();
        c(attributeSet);
        dF(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.container;
    }

    public void dF(int i) {
        this.alX.a(an.cw(i.e.bg_switch_open), an.cw(i.e.bg_switch_close), an.cw(i.e.btn_handle));
        an.b(this.alV, i.c.cp_cont_b, 1);
        if (this.alW != null) {
            an.b(this.alW, i.c.cp_cont_d, 1);
        }
    }

    public void mD() {
        this.alX.mD();
    }

    public void mC() {
        this.alX.mC();
    }

    public void P(boolean z) {
        this.alX.P(z);
    }

    public void O(boolean z) {
        this.alX.O(z);
    }

    public void setText(String str) {
        this.alV.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.alX.setOnSwitchStateChangeListener(aVar);
    }

    private void zm() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_switch_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alV = (TextView) findViewById(i.f.text);
        this.alX = (BdSwitchView) findViewById(i.f.button);
        this.alW = (TextView) findViewById(i.f.tip);
        if (this.alW != null) {
            this.alW.setVisibility(8);
        }
        setTag(this.alX);
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.alW != null && string2 != null) {
            this.alW.setVisibility(0);
            this.alW.setText(string2);
            if (color2 > -1) {
                this.alW.setTextColor(color2);
            }
        }
        if (string != null) {
            this.alV.setText(string);
        }
        if (color > -1) {
            this.alV.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.alV.setTextSize(0, dimension);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.alW != null) {
            displayTip();
            this.alW.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.alW != null) {
            displayTip();
            this.alW.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.alW != null) {
            this.alW.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.alW != null) {
            this.alW.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.alV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alV.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.alV.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.alX;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.alX = bdSwitchView;
    }
}
