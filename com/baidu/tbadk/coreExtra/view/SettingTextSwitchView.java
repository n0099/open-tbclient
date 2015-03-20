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
    private LinearLayout afw;
    private TextView afx;
    protected TextView afy;
    private BdSwitchView afz;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        xi();
        c(attributeSet);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        xi();
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        xi();
        c(attributeSet);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.afw;
    }

    public void dc(int i) {
        this.afz.a(ba.cg(com.baidu.tieba.u.bg_game_switch_open), ba.cg(com.baidu.tieba.u.bg_game_switch_close), ba.cg(com.baidu.tieba.u.btn_game_handle));
        ba.b(this.afx, com.baidu.tieba.s.cp_cont_b, 1);
        if (this.afy != null) {
            ba.b(this.afy, com.baidu.tieba.s.cp_cont_d, 1);
        }
    }

    public void mb() {
        this.afz.mb();
    }

    public void ma() {
        this.afz.ma();
    }

    public void M(boolean z) {
        this.afz.M(z);
    }

    public void L(boolean z) {
        this.afz.L(z);
    }

    public void setText(String str) {
        this.afx.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        this.afz.setOnSwitchStateChangeListener(bVar);
    }

    private void xi() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.setting_text_switch_view, this, true);
        this.afw = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.afx = (TextView) findViewById(com.baidu.tieba.v.text);
        this.afz = (BdSwitchView) findViewById(com.baidu.tieba.v.button);
        this.afy = (TextView) findViewById(com.baidu.tieba.v.tip);
        if (this.afy != null) {
            this.afy.setVisibility(8);
        }
        setTag(this.afz);
        this.afw.setClickable(false);
        this.afw.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.afy != null && string2 != null) {
            this.afy.setVisibility(0);
            this.afy.setText(string2);
            if (color2 > -1) {
                this.afy.setTextColor(color2);
            }
        }
        if (string != null) {
            this.afx.setText(string);
        }
        if (color > -1) {
            this.afx.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.afx.setTextSize(0, dimension);
        }
        this.afw.setClickable(false);
        this.afw.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.afy != null) {
            displayTip();
            this.afy.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.afy != null) {
            displayTip();
            this.afy.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.afy != null) {
            this.afy.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.afy != null) {
            this.afy.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.afx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afx.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.afx.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.afz;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.afz = bdSwitchView;
    }
}
