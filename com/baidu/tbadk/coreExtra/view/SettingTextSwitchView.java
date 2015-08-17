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
    private TextView alM;
    protected TextView alN;
    private BdSwitchView alO;
    private LinearLayout container;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zl();
        c(attributeSet);
        dw(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        zl();
        dw(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        zl();
        c(attributeSet);
        dw(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.container;
    }

    public void dw(int i) {
        this.alO.a(al.cq(i.e.bg_switch_open), al.cq(i.e.bg_switch_close), al.cq(i.e.btn_handle));
        al.b(this.alM, i.c.cp_cont_b, 1);
        if (this.alN != null) {
            al.b(this.alN, i.c.cp_cont_d, 1);
        }
    }

    public void mE() {
        this.alO.mE();
    }

    public void mD() {
        this.alO.mD();
    }

    public void P(boolean z) {
        this.alO.P(z);
    }

    public void O(boolean z) {
        this.alO.O(z);
    }

    public void setText(String str) {
        this.alM.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.alO.setOnSwitchStateChangeListener(aVar);
    }

    private void zl() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_switch_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alM = (TextView) findViewById(i.f.text);
        this.alO = (BdSwitchView) findViewById(i.f.button);
        this.alN = (TextView) findViewById(i.f.tip);
        if (this.alN != null) {
            this.alN.setVisibility(8);
        }
        setTag(this.alO);
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.k.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.alN != null && string2 != null) {
            this.alN.setVisibility(0);
            this.alN.setText(string2);
            if (color2 > -1) {
                this.alN.setTextColor(color2);
            }
        }
        if (string != null) {
            this.alM.setText(string);
        }
        if (color > -1) {
            this.alM.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.alM.setTextSize(0, dimension);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.alN != null) {
            displayTip();
            this.alN.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.alN != null) {
            displayTip();
            this.alN.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.alN != null) {
            this.alN.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.alN != null) {
            this.alN.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.alM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alM.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.alM.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.alO;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.alO = bdSwitchView;
    }
}
