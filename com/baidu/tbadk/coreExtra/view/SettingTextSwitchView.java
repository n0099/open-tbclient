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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aqa;
    private TextView aqb;
    protected TextView aqc;
    private BdSwitchView aqd;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bk();
        d(attributeSet);
        ej(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bk();
        ej(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bk();
        d(attributeSet);
        ej(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.aqa;
    }

    public void ej(int i) {
        this.aqd.a(ar.cO(t.f.bg_switch_open), ar.cO(t.f.bg_switch_close), ar.cO(t.f.btn_handle));
        ar.b(this.aqb, t.d.cp_cont_b, 1);
        if (this.aqc != null) {
            ar.b(this.aqc, t.d.cp_cont_d, 1);
        }
    }

    public void mt() {
        this.aqd.mt();
    }

    public void ms() {
        this.aqd.ms();
    }

    public void M(boolean z) {
        this.aqd.M(z);
    }

    public void L(boolean z) {
        this.aqd.L(z);
    }

    public void setText(String str) {
        this.aqb.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aqd.setOnSwitchStateChangeListener(aVar);
    }

    private void Bk() {
        LayoutInflater.from(this.mContext).inflate(t.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aqa = (LinearLayout) findViewById(t.g.container);
        this.aqb = (TextView) findViewById(t.g.text);
        this.aqd = (BdSwitchView) findViewById(t.g.button);
        this.aqc = (TextView) findViewById(t.g.tip);
        if (this.aqc != null) {
            this.aqc.setVisibility(8);
        }
        setTag(this.aqd);
        this.aqa.setClickable(false);
        this.aqa.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.aqc != null && string2 != null) {
            this.aqc.setVisibility(0);
            this.aqc.setText(string2);
            if (color2 > -1) {
                this.aqc.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aqb.setText(string);
        }
        if (color > -1) {
            this.aqb.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aqb.setTextSize(0, dimension);
        }
        this.aqa.setClickable(false);
        this.aqa.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aqc != null) {
            displayTip();
            this.aqc.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aqc != null) {
            displayTip();
            this.aqc.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aqc != null) {
            this.aqc.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aqc != null) {
            this.aqc.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aqb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqb.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aqb.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aqd;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aqd = bdSwitchView;
    }
}
