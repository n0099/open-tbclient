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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout awv;
    private TextView aww;
    protected TextView awx;
    private BdSwitchView awy;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bk();
        c(attributeSet);
        ek(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bk();
        ek(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bk();
        c(attributeSet);
        ek(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.awv;
    }

    public void ek(int i) {
        this.awy.a(as.cO(w.g.bg_switch_open), as.cO(w.g.bg_switch_close), as.cO(w.g.btn_handle));
        as.c(this.aww, w.e.cp_cont_b, 1);
        if (this.awx != null) {
            as.c(this.awx, w.e.cp_cont_d, 1);
        }
    }

    public void kq() {
        this.awy.kq();
        this.awy.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void kp() {
        this.awy.kp();
        this.awy.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void Q(boolean z) {
        this.awy.Q(z);
        this.awy.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void P(boolean z) {
        this.awy.P(z);
        this.awy.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void setText(String str) {
        this.aww.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.awy.setOnSwitchStateChangeListener(aVar);
    }

    private void Bk() {
        LayoutInflater.from(this.mContext).inflate(w.j.setting_text_switch_view, (ViewGroup) this, true);
        this.awv = (LinearLayout) findViewById(w.h.container);
        this.aww = (TextView) findViewById(w.h.text);
        this.awy = (BdSwitchView) findViewById(w.h.button);
        this.awy.setFocusable(true);
        this.awx = (TextView) findViewById(w.h.tip);
        if (this.awx != null) {
            this.awx.setVisibility(8);
        }
        setTag(this.awy);
        this.awv.setClickable(false);
        this.awv.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.awx != null && string2 != null) {
            this.awx.setVisibility(0);
            this.awx.setText(string2);
            if (color2 > -1) {
                this.awx.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aww.setText(string);
        }
        if (color > -1) {
            this.aww.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aww.setTextSize(0, dimension);
        }
        this.awv.setClickable(false);
        this.awv.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.awx != null) {
            displayTip();
            this.awx.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.awx != null) {
            displayTip();
            this.awx.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.awx != null) {
            this.awx.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.awx != null) {
            this.awx.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aww.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aww.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aww.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.awy;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.awy = bdSwitchView;
    }
}
