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
    private LinearLayout Pg;
    private TextView Ph;
    protected TextView Pi;
    private BdSwitchView Pj;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        qk();
        c(attributeSet);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        qk();
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        qk();
        c(attributeSet);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.Pg == null) {
            super.setOnClickListener(onClickListener);
        } else {
            this.Pg.setOnClickListener(onClickListener);
        }
    }

    public View getView() {
        return this.Pg;
    }

    public void cu(int i) {
        if (i == 1) {
            this.Pj.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
        } else {
            this.Pj.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
        }
        com.baidu.tbadk.core.util.aw.b(this.Ph, com.baidu.tieba.s.about_tip_color, 1);
        if (this.Pi != null) {
            com.baidu.tbadk.core.util.aw.b(this.Pi, com.baidu.tieba.s.setting_subtip_color, 1);
        }
    }

    public void gO() {
        B(false);
    }

    public void gN() {
        A(false);
    }

    public void B(boolean z) {
        this.Pj.B(z);
    }

    public void A(boolean z) {
        this.Pj.A(z);
    }

    public void setText(String str) {
        this.Ph.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.Pj.setOnSwitchStateChangeListener(cVar);
    }

    private void qk() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.setting_text_switch_view, this, true);
        this.Pg = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.Ph = (TextView) findViewById(com.baidu.tieba.v.text);
        this.Pj = (BdSwitchView) findViewById(com.baidu.tieba.v.button);
        this.Pi = (TextView) findViewById(com.baidu.tieba.v.tip);
        if (this.Pi != null) {
            this.Pi.setVisibility(8);
        }
        setTag(this.Pj);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.Pi != null && string2 != null) {
            this.Pi.setVisibility(0);
            this.Pi.setText(string2);
            if (color2 > -1) {
                this.Pi.setTextColor(color2);
            }
        }
        if (string != null) {
            this.Ph.setText(string);
        }
        if (color > -1) {
            this.Ph.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.Ph.setTextSize(0, dimension);
        }
        this.Pg.setClickable(false);
        this.Pg.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.Pi != null) {
            ql();
            this.Pi.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.Pi != null) {
            ql();
            this.Pi.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.Pi != null) {
            this.Pi.setTextColor(i);
        }
    }

    public void ql() {
        if (this.Pi != null) {
            this.Pi.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.Pj;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.Pj = bdSwitchView;
    }
}
