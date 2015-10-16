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
    private TextView alQ;
    protected TextView alR;
    private BdSwitchView alS;
    private LinearLayout container;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zk();
        c(attributeSet);
        dF(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        zk();
        dF(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        zk();
        c(attributeSet);
        dF(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.container;
    }

    public void dF(int i) {
        this.alS.a(an.cw(i.e.bg_switch_open), an.cw(i.e.bg_switch_close), an.cw(i.e.btn_handle));
        an.b(this.alQ, i.c.cp_cont_b, 1);
        if (this.alR != null) {
            an.b(this.alR, i.c.cp_cont_d, 1);
        }
    }

    public void mC() {
        this.alS.mC();
    }

    public void mB() {
        this.alS.mB();
    }

    public void P(boolean z) {
        this.alS.P(z);
    }

    public void O(boolean z) {
        this.alS.O(z);
    }

    public void setText(String str) {
        this.alQ.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.alS.setOnSwitchStateChangeListener(aVar);
    }

    private void zk() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_switch_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alQ = (TextView) findViewById(i.f.text);
        this.alS = (BdSwitchView) findViewById(i.f.button);
        this.alR = (TextView) findViewById(i.f.tip);
        if (this.alR != null) {
            this.alR.setVisibility(8);
        }
        setTag(this.alS);
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
        if (this.alR != null && string2 != null) {
            this.alR.setVisibility(0);
            this.alR.setText(string2);
            if (color2 > -1) {
                this.alR.setTextColor(color2);
            }
        }
        if (string != null) {
            this.alQ.setText(string);
        }
        if (color > -1) {
            this.alQ.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.alQ.setTextSize(0, dimension);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.alR != null) {
            displayTip();
            this.alR.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.alR != null) {
            displayTip();
            this.alR.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.alR != null) {
            this.alR.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.alR != null) {
            this.alR.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.alQ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alQ.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.alQ.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.alS;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.alS = bdSwitchView;
    }
}
