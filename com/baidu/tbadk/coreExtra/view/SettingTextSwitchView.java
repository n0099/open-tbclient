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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private TextView ajd;
    private LinearLayout cpd;
    protected TextView cpe;
    private BdSwitchView cpf;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aqJ();
        c(attributeSet);
        kd(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        aqJ();
        kd(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        aqJ();
        c(attributeSet);
        kd(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.cpd;
    }

    public void kd(int i) {
        this.cpf.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        am.f(this.ajd, R.color.cp_cont_b, 1);
        if (this.cpe != null) {
            am.f(this.cpe, R.color.cp_cont_d, 1);
        }
    }

    public void nn() {
        this.cpf.nn();
        this.cpf.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void nm() {
        this.cpf.nm();
        this.cpf.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void ao(boolean z) {
        this.cpf.ao(z);
        this.cpf.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void an(boolean z) {
        this.cpf.an(z);
        this.cpf.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.ajd.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cpf.setOnSwitchStateChangeListener(aVar);
    }

    private void aqJ() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.cpd = (LinearLayout) findViewById(R.id.container);
        this.ajd = (TextView) findViewById(R.id.text);
        this.cpf = (BdSwitchView) findViewById(R.id.button);
        this.cpf.setFocusable(true);
        this.cpe = (TextView) findViewById(R.id.tip);
        if (this.cpe != null) {
            this.cpe.setVisibility(8);
        }
        setTag(this.cpf);
        this.cpd.setClickable(false);
        this.cpd.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.cpe != null && string2 != null) {
            this.cpe.setVisibility(0);
            this.cpe.setText(string2);
            if (color2 > -1) {
                this.cpe.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ajd.setText(string);
        }
        if (color > -1) {
            this.ajd.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ajd.setTextSize(0, dimension);
        }
        this.cpd.setClickable(false);
        this.cpd.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.cpe != null) {
            displayTip();
            this.cpe.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.cpe != null) {
            displayTip();
            this.cpe.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.cpe != null) {
            this.cpe.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.cpe != null) {
            this.cpe.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ajd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajd.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ajd.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cpf;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.cpf = bdSwitchView;
    }
}
