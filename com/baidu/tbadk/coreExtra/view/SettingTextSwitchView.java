package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout afE;
    private TextView afF;
    protected TextView afG;
    private BdSwitchView afH;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        xo();
        c(attributeSet);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        xo();
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        xo();
        c(attributeSet);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.afE;
    }

    public void dc(int i) {
        this.afH.a(ba.cg(com.baidu.tieba.u.bg_game_switch_open), ba.cg(com.baidu.tieba.u.bg_game_switch_close), ba.cg(com.baidu.tieba.u.btn_game_handle));
        ba.b(this.afF, com.baidu.tieba.s.cp_cont_b, 1);
        if (this.afG != null) {
            ba.b(this.afG, com.baidu.tieba.s.cp_cont_d, 1);
        }
    }

    public void mb() {
        this.afH.mb();
    }

    public void ma() {
        this.afH.ma();
    }

    public void M(boolean z) {
        this.afH.M(z);
    }

    public void L(boolean z) {
        this.afH.L(z);
    }

    public void setText(String str) {
        this.afF.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        this.afH.setOnSwitchStateChangeListener(bVar);
    }

    private void xo() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.setting_text_switch_view, this, true);
        this.afE = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.afF = (TextView) findViewById(com.baidu.tieba.v.text);
        this.afH = (BdSwitchView) findViewById(com.baidu.tieba.v.button);
        this.afG = (TextView) findViewById(com.baidu.tieba.v.tip);
        if (this.afG != null) {
            this.afG.setVisibility(8);
        }
        setTag(this.afH);
        this.afE.setClickable(false);
        this.afE.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.afG != null && string2 != null) {
            this.afG.setVisibility(0);
            this.afG.setText(string2);
            if (color2 > -1) {
                this.afG.setTextColor(color2);
            }
        }
        if (string != null) {
            this.afF.setText(string);
        }
        if (color > -1) {
            this.afF.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.afF.setTextSize(0, dimension);
        }
        this.afE.setClickable(false);
        this.afE.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.afG != null) {
            displayTip();
            this.afG.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.afG != null) {
            displayTip();
            this.afG.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.afG != null) {
            this.afG.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.afG != null) {
            this.afG.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.afF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afF.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.afF.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.afH;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.afH = bdSwitchView;
    }
}
