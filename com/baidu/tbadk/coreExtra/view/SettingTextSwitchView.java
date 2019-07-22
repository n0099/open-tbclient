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
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout cob;
    protected TextView coc;
    private BdSwitchView cod;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aqv();
        c(attributeSet);
        jZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        aqv();
        jZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        aqv();
        c(attributeSet);
        jZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.cob;
    }

    public void jZ(int i) {
        this.cod.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        am.f(this.textView, R.color.cp_cont_b, 1);
        if (this.coc != null) {
            am.f(this.coc, R.color.cp_cont_d, 1);
        }
    }

    public void nn() {
        this.cod.nn();
        this.cod.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void nm() {
        this.cod.nm();
        this.cod.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void ao(boolean z) {
        this.cod.ao(z);
        this.cod.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void an(boolean z) {
        this.cod.an(z);
        this.cod.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cod.setOnSwitchStateChangeListener(aVar);
    }

    private void aqv() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.cob = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.cod = (BdSwitchView) findViewById(R.id.button);
        this.cod.setFocusable(true);
        this.coc = (TextView) findViewById(R.id.tip);
        if (this.coc != null) {
            this.coc.setVisibility(8);
        }
        setTag(this.cod);
        this.cob.setClickable(false);
        this.cob.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.coc != null && string2 != null) {
            this.coc.setVisibility(0);
            this.coc.setText(string2);
            if (color2 > -1) {
                this.coc.setTextColor(color2);
            }
        }
        if (string != null) {
            this.textView.setText(string);
        }
        if (color > -1) {
            this.textView.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.textView.setTextSize(0, dimension);
        }
        this.cob.setClickable(false);
        this.cob.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.coc != null) {
            displayTip();
            this.coc.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.coc != null) {
            displayTip();
            this.coc.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.coc != null) {
            this.coc.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.coc != null) {
            this.coc.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.textView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.textView.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cod;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.cod = bdSwitchView;
    }
}
