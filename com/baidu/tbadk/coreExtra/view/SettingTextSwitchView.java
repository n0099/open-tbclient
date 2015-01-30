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
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private BdSwitchView VA;
    private LinearLayout Vx;
    private TextView Vy;
    protected TextView Vz;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        tU();
        c(attributeSet);
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        tU();
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        tU();
        c(attributeSet);
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.Vx == null) {
            super.setOnClickListener(onClickListener);
        } else {
            this.Vx.setOnClickListener(onClickListener);
        }
    }

    public View getView() {
        return this.Vx;
    }

    public void da(int i) {
        if (i == 1) {
            this.VA.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
        } else {
            this.VA.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
        }
        bc.b(this.Vy, com.baidu.tieba.t.about_tip_color, 1);
        if (this.Vz != null) {
            bc.b(this.Vz, com.baidu.tieba.t.setting_subtip_color, 1);
        }
    }

    public void iM() {
        N(false);
    }

    public void iL() {
        M(false);
    }

    public void N(boolean z) {
        this.VA.N(z);
    }

    public void M(boolean z) {
        this.VA.M(z);
    }

    public void setText(String str) {
        this.Vy.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.VA.setOnSwitchStateChangeListener(cVar);
    }

    private void tU() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.setting_text_switch_view, this, true);
        this.Vx = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.Vy = (TextView) findViewById(com.baidu.tieba.w.text);
        this.VA = (BdSwitchView) findViewById(com.baidu.tieba.w.button);
        this.Vz = (TextView) findViewById(com.baidu.tieba.w.tip);
        if (this.Vz != null) {
            this.Vz.setVisibility(8);
        }
        setTag(this.VA);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.Vz != null && string2 != null) {
            this.Vz.setVisibility(0);
            this.Vz.setText(string2);
            if (color2 > -1) {
                this.Vz.setTextColor(color2);
            }
        }
        if (string != null) {
            this.Vy.setText(string);
        }
        if (color > -1) {
            this.Vy.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.Vy.setTextSize(0, dimension);
        }
        this.Vx.setClickable(false);
        this.Vx.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.Vz != null) {
            tV();
            this.Vz.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.Vz != null) {
            tV();
            this.Vz.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.Vz != null) {
            this.Vz.setTextColor(i);
        }
    }

    public void tV() {
        if (this.Vz != null) {
            this.Vz.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.VA;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.VA = bdSwitchView;
    }
}
