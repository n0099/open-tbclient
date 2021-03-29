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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public class SettingTextSwitchView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public final Context f13774e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13775f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13776g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13777h;
    public BdSwitchView i;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13774e = context;
        c();
        b(attributeSet);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a() {
        TextView textView = this.f13777h;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f13774e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R$styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTipColor, -1);
        TextView textView = this.f13777h;
        if (textView != null && string2 != null) {
            textView.setVisibility(0);
            this.f13777h.setText(string2);
            if (color2 > -1) {
                this.f13777h.setTextColor(color2);
            }
        }
        if (string != null) {
            this.f13776g.setText(string);
        }
        if (color > -1) {
            this.f13776g.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.f13776g.setTextSize(0, dimension);
        }
        this.f13775f.setClickable(false);
        this.f13775f.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public final void c() {
        LayoutInflater.from(this.f13774e).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.f13775f = (LinearLayout) findViewById(R.id.container);
        this.f13776g = (TextView) findViewById(R.id.text);
        BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.button);
        this.i = bdSwitchView;
        bdSwitchView.setFocusable(true);
        TextView textView = (TextView) findViewById(R.id.tip);
        this.f13777h = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        setTag(this.i);
        this.f13775f.setClickable(false);
        this.f13775f.setFocusable(false);
    }

    public void d(int i) {
        this.i.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        SkinManager.setViewTextColor(this.f13776g, R.color.CAM_X0105, 1);
        TextView textView = this.f13777h;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
        }
    }

    public void e(boolean z) {
        this.i.g(z);
        BdSwitchView bdSwitchView = this.i;
        bdSwitchView.setContentDescription(this.f13774e.getString(R.string.talk_message_tip) + this.f13774e.getString(R.string.talk_close));
    }

    public void f(boolean z) {
        this.i.j(z);
        BdSwitchView bdSwitchView = this.i;
        bdSwitchView.setContentDescription(this.f13774e.getString(R.string.talk_message_tip) + this.f13774e.getString(R.string.talk_open));
    }

    public BdSwitchView getSwitchView() {
        return this.i;
    }

    public View getView() {
        return this.f13775f;
    }

    public void setSwitchStateChangeListener(BdSwitchView.b bVar) {
        this.i.setOnSwitchStateChangeListener(bVar);
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.i = bdSwitchView;
    }

    public void setText(String str) {
        this.f13776g.setText(str);
    }

    public void setTextLeftMargin(int i) {
        if (this.f13776g.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13776g.getLayoutParams();
            layoutParams.leftMargin = this.f13774e.getResources().getDimensionPixelSize(i);
            this.f13776g.setLayoutParams(layoutParams);
        }
    }

    public void setTip(String str) {
        if (str == null || this.f13777h == null) {
            return;
        }
        a();
        this.f13777h.setText(str);
    }

    public void setTipColor(int i) {
        TextView textView = this.f13777h;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTip(int i) {
        if (i == -1 || this.f13777h == null) {
            return;
        }
        a();
        this.f13777h.setText(i);
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.f13774e = context;
        c();
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13774e = context;
        c();
        b(attributeSet);
        d(TbadkCoreApplication.getInst().getSkinType());
    }
}
