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
    private TextView api;
    protected TextView apj;
    private BdSwitchView apk;
    private LinearLayout container;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zU();
        c(attributeSet);
        dO(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        zU();
        dO(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        zU();
        c(attributeSet);
        dO(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.container;
    }

    public void dO(int i) {
        this.apk.a(as.cx(n.f.bg_switch_open), as.cx(n.f.bg_switch_close), as.cx(n.f.btn_handle));
        as.b(this.api, n.d.cp_cont_b, 1);
        if (this.apj != null) {
            as.b(this.apj, n.d.cp_cont_d, 1);
        }
    }

    public void mf() {
        this.apk.mf();
    }

    public void me() {
        this.apk.me();
    }

    public void M(boolean z) {
        this.apk.M(z);
    }

    public void L(boolean z) {
        this.apk.L(z);
    }

    public void setText(String str) {
        this.api.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.apk.setOnSwitchStateChangeListener(aVar);
    }

    private void zU() {
        LayoutInflater.from(this.mContext).inflate(n.h.setting_text_switch_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(n.g.container);
        this.api = (TextView) findViewById(n.g.text);
        this.apk = (BdSwitchView) findViewById(n.g.button);
        this.apj = (TextView) findViewById(n.g.tip);
        if (this.apj != null) {
            this.apj.setVisibility(8);
        }
        setTag(this.apk);
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, n.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.apj != null && string2 != null) {
            this.apj.setVisibility(0);
            this.apj.setText(string2);
            if (color2 > -1) {
                this.apj.setTextColor(color2);
            }
        }
        if (string != null) {
            this.api.setText(string);
        }
        if (color > -1) {
            this.api.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.api.setTextSize(0, dimension);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.apj != null) {
            displayTip();
            this.apj.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.apj != null) {
            displayTip();
            this.apj.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.apj != null) {
            this.apj.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.apj != null) {
            this.apj.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.api.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.api.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.api.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.apk;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.apk = bdSwitchView;
    }
}
