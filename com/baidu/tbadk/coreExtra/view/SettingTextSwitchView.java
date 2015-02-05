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
    private LinearLayout Vu;
    private TextView Vv;
    protected TextView Vw;
    private BdSwitchView Vx;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        tO();
        c(attributeSet);
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        tO();
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        tO();
        c(attributeSet);
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.Vu == null) {
            super.setOnClickListener(onClickListener);
        } else {
            this.Vu.setOnClickListener(onClickListener);
        }
    }

    public View getView() {
        return this.Vu;
    }

    public void da(int i) {
        if (i == 1) {
            this.Vx.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
        } else {
            this.Vx.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
        }
        bc.b(this.Vv, com.baidu.tieba.t.about_tip_color, 1);
        if (this.Vw != null) {
            bc.b(this.Vw, com.baidu.tieba.t.setting_subtip_color, 1);
        }
    }

    public void iF() {
        N(false);
    }

    public void iE() {
        M(false);
    }

    public void N(boolean z) {
        this.Vx.N(z);
    }

    public void M(boolean z) {
        this.Vx.M(z);
    }

    public void setText(String str) {
        this.Vv.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.Vx.setOnSwitchStateChangeListener(cVar);
    }

    private void tO() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.setting_text_switch_view, this, true);
        this.Vu = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.Vv = (TextView) findViewById(com.baidu.tieba.w.text);
        this.Vx = (BdSwitchView) findViewById(com.baidu.tieba.w.button);
        this.Vw = (TextView) findViewById(com.baidu.tieba.w.tip);
        if (this.Vw != null) {
            this.Vw.setVisibility(8);
        }
        setTag(this.Vx);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.Vw != null && string2 != null) {
            this.Vw.setVisibility(0);
            this.Vw.setText(string2);
            if (color2 > -1) {
                this.Vw.setTextColor(color2);
            }
        }
        if (string != null) {
            this.Vv.setText(string);
        }
        if (color > -1) {
            this.Vv.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.Vv.setTextSize(0, dimension);
        }
        this.Vu.setClickable(false);
        this.Vu.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.Vw != null) {
            tP();
            this.Vw.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.Vw != null) {
            tP();
            this.Vw.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.Vw != null) {
            this.Vw.setTextColor(i);
        }
    }

    public void tP() {
        if (this.Vw != null) {
            this.Vw.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.Vx;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.Vx = bdSwitchView;
    }
}
