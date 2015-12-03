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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private TextView anI;
    protected TextView anJ;
    private BdSwitchView anK;
    private LinearLayout container;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ai();
        c(attributeSet);
        dU(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Ai();
        dU(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Ai();
        c(attributeSet);
        dU(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.container;
    }

    public void dU(int i) {
        this.anK.a(as.cE(n.e.bg_switch_open), as.cE(n.e.bg_switch_close), as.cE(n.e.btn_handle));
        as.b(this.anI, n.c.cp_cont_b, 1);
        if (this.anJ != null) {
            as.b(this.anJ, n.c.cp_cont_d, 1);
        }
    }

    public void mH() {
        this.anK.mH();
    }

    public void mG() {
        this.anK.mG();
    }

    public void P(boolean z) {
        this.anK.P(z);
    }

    public void O(boolean z) {
        this.anK.O(z);
    }

    public void setText(String str) {
        this.anI.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.anK.setOnSwitchStateChangeListener(aVar);
    }

    private void Ai() {
        LayoutInflater.from(this.mContext).inflate(n.g.setting_text_switch_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(n.f.container);
        this.anI = (TextView) findViewById(n.f.text);
        this.anK = (BdSwitchView) findViewById(n.f.button);
        this.anJ = (TextView) findViewById(n.f.tip);
        if (this.anJ != null) {
            this.anJ.setVisibility(8);
        }
        setTag(this.anK);
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, n.k.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.anJ != null && string2 != null) {
            this.anJ.setVisibility(0);
            this.anJ.setText(string2);
            if (color2 > -1) {
                this.anJ.setTextColor(color2);
            }
        }
        if (string != null) {
            this.anI.setText(string);
        }
        if (color > -1) {
            this.anI.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.anI.setTextSize(0, dimension);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.anJ != null) {
            displayTip();
            this.anJ.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.anJ != null) {
            displayTip();
            this.anJ.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.anJ != null) {
            this.anJ.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.anJ != null) {
            this.anJ.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.anI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anI.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.anI.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.anK;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.anK = bdSwitchView;
    }
}
