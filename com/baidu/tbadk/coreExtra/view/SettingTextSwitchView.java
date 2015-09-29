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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private TextView alP;
    protected TextView alQ;
    private BdSwitchView alR;
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
        this.alR.a(am.cw(i.e.bg_switch_open), am.cw(i.e.bg_switch_close), am.cw(i.e.btn_handle));
        am.b(this.alP, i.c.cp_cont_b, 1);
        if (this.alQ != null) {
            am.b(this.alQ, i.c.cp_cont_d, 1);
        }
    }

    public void mC() {
        this.alR.mC();
    }

    public void mB() {
        this.alR.mB();
    }

    public void P(boolean z) {
        this.alR.P(z);
    }

    public void O(boolean z) {
        this.alR.O(z);
    }

    public void setText(String str) {
        this.alP.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.alR.setOnSwitchStateChangeListener(aVar);
    }

    private void zk() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_switch_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alP = (TextView) findViewById(i.f.text);
        this.alR = (BdSwitchView) findViewById(i.f.button);
        this.alQ = (TextView) findViewById(i.f.tip);
        if (this.alQ != null) {
            this.alQ.setVisibility(8);
        }
        setTag(this.alR);
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
        if (this.alQ != null && string2 != null) {
            this.alQ.setVisibility(0);
            this.alQ.setText(string2);
            if (color2 > -1) {
                this.alQ.setTextColor(color2);
            }
        }
        if (string != null) {
            this.alP.setText(string);
        }
        if (color > -1) {
            this.alP.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.alP.setTextSize(0, dimension);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.alQ != null) {
            displayTip();
            this.alQ.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.alQ != null) {
            displayTip();
            this.alQ.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.alQ != null) {
            this.alQ.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.alQ != null) {
            this.alQ.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.alP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alP.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.alP.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.alR;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.alR = bdSwitchView;
    }
}
