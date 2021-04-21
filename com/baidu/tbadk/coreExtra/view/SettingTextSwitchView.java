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
    public final Context f13443e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13444f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13445g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13446h;
    public BdSwitchView i;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13443e = context;
        c();
        b(attributeSet);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a() {
        TextView textView = this.f13446h;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f13443e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R$styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTipColor, -1);
        TextView textView = this.f13446h;
        if (textView != null && string2 != null) {
            textView.setVisibility(0);
            this.f13446h.setText(string2);
            if (color2 > -1) {
                this.f13446h.setTextColor(color2);
            }
        }
        if (string != null) {
            this.f13445g.setText(string);
        }
        if (color > -1) {
            this.f13445g.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.f13445g.setTextSize(0, dimension);
        }
        this.f13444f.setClickable(false);
        this.f13444f.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public final void c() {
        LayoutInflater.from(this.f13443e).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.f13444f = (LinearLayout) findViewById(R.id.container);
        this.f13445g = (TextView) findViewById(R.id.text);
        BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.button);
        this.i = bdSwitchView;
        bdSwitchView.setFocusable(true);
        TextView textView = (TextView) findViewById(R.id.tip);
        this.f13446h = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        setTag(this.i);
        this.f13444f.setClickable(false);
        this.f13444f.setFocusable(false);
    }

    public void d(int i) {
        this.i.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        SkinManager.setViewTextColor(this.f13445g, R.color.CAM_X0105, 1);
        TextView textView = this.f13446h;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
        }
    }

    public void e(boolean z) {
        this.i.g(z);
        BdSwitchView bdSwitchView = this.i;
        bdSwitchView.setContentDescription(this.f13443e.getString(R.string.talk_message_tip) + this.f13443e.getString(R.string.talk_close));
    }

    public void f(boolean z) {
        this.i.j(z);
        BdSwitchView bdSwitchView = this.i;
        bdSwitchView.setContentDescription(this.f13443e.getString(R.string.talk_message_tip) + this.f13443e.getString(R.string.talk_open));
    }

    public BdSwitchView getSwitchView() {
        return this.i;
    }

    public View getView() {
        return this.f13444f;
    }

    public void setSwitchStateChangeListener(BdSwitchView.b bVar) {
        this.i.setOnSwitchStateChangeListener(bVar);
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.i = bdSwitchView;
    }

    public void setText(String str) {
        this.f13445g.setText(str);
    }

    public void setTextLeftMargin(int i) {
        if (this.f13445g.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13445g.getLayoutParams();
            layoutParams.leftMargin = this.f13443e.getResources().getDimensionPixelSize(i);
            this.f13445g.setLayoutParams(layoutParams);
        }
    }

    public void setTip(String str) {
        if (str == null || this.f13446h == null) {
            return;
        }
        a();
        this.f13446h.setText(str);
    }

    public void setTipColor(int i) {
        TextView textView = this.f13446h;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTip(int i) {
        if (i == -1 || this.f13446h == null) {
            return;
        }
        a();
        this.f13446h.setText(i);
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.f13443e = context;
        c();
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13443e = context;
        c();
        b(attributeSet);
        d(TbadkCoreApplication.getInst().getSkinType());
    }
}
