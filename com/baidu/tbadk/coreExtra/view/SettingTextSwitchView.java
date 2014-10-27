package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout Pc;
    private TextView Pd;
    protected TextView Pe;
    private BdSwitchView Pf;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        qi();
        c(attributeSet);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        qi();
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        qi();
        c(attributeSet);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.Pc == null) {
            super.setOnClickListener(onClickListener);
        } else {
            this.Pc.setOnClickListener(onClickListener);
        }
    }

    public View getView() {
        return this.Pc;
    }

    public void cu(int i) {
        if (i == 1) {
            this.Pf.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
        } else {
            this.Pf.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
        }
        com.baidu.tbadk.core.util.aw.b(this.Pd, com.baidu.tieba.s.about_tip_color, 1);
        if (this.Pe != null) {
            com.baidu.tbadk.core.util.aw.b(this.Pe, com.baidu.tieba.s.setting_subtip_color, 1);
        }
    }

    public void gO() {
        B(false);
    }

    public void gN() {
        A(false);
    }

    public void B(boolean z) {
        this.Pf.B(z);
    }

    public void A(boolean z) {
        this.Pf.A(z);
    }

    public void setText(String str) {
        this.Pd.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.Pf.setOnSwitchStateChangeListener(cVar);
    }

    private void qi() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.setting_text_switch_view, this, true);
        this.Pc = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.Pd = (TextView) findViewById(com.baidu.tieba.v.text);
        this.Pf = (BdSwitchView) findViewById(com.baidu.tieba.v.button);
        this.Pe = (TextView) findViewById(com.baidu.tieba.v.tip);
        if (this.Pe != null) {
            this.Pe.setVisibility(8);
        }
        setTag(this.Pf);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.Pe != null && string2 != null) {
            this.Pe.setVisibility(0);
            this.Pe.setText(string2);
            if (color2 > -1) {
                this.Pe.setTextColor(color2);
            }
        }
        if (string != null) {
            this.Pd.setText(string);
        }
        if (color > -1) {
            this.Pd.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.Pd.setTextSize(0, dimension);
        }
        this.Pc.setClickable(false);
        this.Pc.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.Pe != null) {
            qj();
            this.Pe.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.Pe != null) {
            qj();
            this.Pe.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.Pe != null) {
            this.Pe.setTextColor(i);
        }
    }

    public void qj() {
        if (this.Pe != null) {
            this.Pe.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.Pf;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.Pf = bdSwitchView;
    }
}
