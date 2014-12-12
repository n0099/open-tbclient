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
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout US;
    private TextView UT;
    protected TextView UU;
    private BdSwitchView UV;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        tD();
        c(attributeSet);
        cT(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        tD();
        cT(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        tD();
        c(attributeSet);
        cT(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.US == null) {
            super.setOnClickListener(onClickListener);
        } else {
            this.US.setOnClickListener(onClickListener);
        }
    }

    public View getView() {
        return this.US;
    }

    public void cT(int i) {
        if (i == 1) {
            this.UV.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
        } else {
            this.UV.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
        }
        com.baidu.tbadk.core.util.ax.b(this.UT, com.baidu.tieba.t.about_tip_color, 1);
        if (this.UU != null) {
            com.baidu.tbadk.core.util.ax.b(this.UU, com.baidu.tieba.t.setting_subtip_color, 1);
        }
    }

    public void iL() {
        N(false);
    }

    public void iK() {
        M(false);
    }

    public void N(boolean z) {
        this.UV.N(z);
    }

    public void M(boolean z) {
        this.UV.M(z);
    }

    public void setText(String str) {
        this.UT.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.UV.setOnSwitchStateChangeListener(cVar);
    }

    private void tD() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.setting_text_switch_view, this, true);
        this.US = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.UT = (TextView) findViewById(com.baidu.tieba.w.text);
        this.UV = (BdSwitchView) findViewById(com.baidu.tieba.w.button);
        this.UU = (TextView) findViewById(com.baidu.tieba.w.tip);
        if (this.UU != null) {
            this.UU.setVisibility(8);
        }
        setTag(this.UV);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.UU != null && string2 != null) {
            this.UU.setVisibility(0);
            this.UU.setText(string2);
            if (color2 > -1) {
                this.UU.setTextColor(color2);
            }
        }
        if (string != null) {
            this.UT.setText(string);
        }
        if (color > -1) {
            this.UT.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.UT.setTextSize(0, dimension);
        }
        this.US.setClickable(false);
        this.US.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.UU != null) {
            tE();
            this.UU.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.UU != null) {
            tE();
            this.UU.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.UU != null) {
            this.UU.setTextColor(i);
        }
    }

    public void tE() {
        if (this.UU != null) {
            this.UU.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.UV;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.UV = bdSwitchView;
    }
}
