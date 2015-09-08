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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private BdSwitchView anA;
    private TextView any;
    protected TextView anz;
    private LinearLayout container;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zy();
        c(attributeSet);
        dE(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        zy();
        dE(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        zy();
        c(attributeSet);
        dE(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.container;
    }

    public void dE(int i) {
        this.anA.a(al.cu(i.e.bg_switch_open), al.cu(i.e.bg_switch_close), al.cu(i.e.btn_handle));
        al.b(this.any, i.c.cp_cont_b, 1);
        if (this.anz != null) {
            al.b(this.anz, i.c.cp_cont_d, 1);
        }
    }

    public void mB() {
        this.anA.mB();
    }

    public void mA() {
        this.anA.mA();
    }

    public void P(boolean z) {
        this.anA.P(z);
    }

    public void O(boolean z) {
        this.anA.O(z);
    }

    public void setText(String str) {
        this.any.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.anA.setOnSwitchStateChangeListener(aVar);
    }

    private void zy() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_switch_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.any = (TextView) findViewById(i.f.text);
        this.anA = (BdSwitchView) findViewById(i.f.button);
        this.anz = (TextView) findViewById(i.f.tip);
        if (this.anz != null) {
            this.anz.setVisibility(8);
        }
        setTag(this.anA);
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
        if (this.anz != null && string2 != null) {
            this.anz.setVisibility(0);
            this.anz.setText(string2);
            if (color2 > -1) {
                this.anz.setTextColor(color2);
            }
        }
        if (string != null) {
            this.any.setText(string);
        }
        if (color > -1) {
            this.any.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.any.setTextSize(0, dimension);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.anz != null) {
            displayTip();
            this.anz.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.anz != null) {
            displayTip();
            this.anz.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.anz != null) {
            this.anz.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.anz != null) {
            this.anz.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.any.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.any.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.any.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.anA;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.anA = bdSwitchView;
    }
}
