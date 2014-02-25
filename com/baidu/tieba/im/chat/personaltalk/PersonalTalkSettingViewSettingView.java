package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.more.SettingTextSwitchView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView a;
    private TextView b;
    private RelativeLayout c;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        a();
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.a != null) {
            this.a.setSwitchStateChangeListener(cVar);
        }
    }

    private void a() {
        setOrientation(1);
        inflate(getContext(), R.layout.p2ptalk_setting_detail_view, this);
        this.a = (SettingTextSwitchView) findViewById(R.id.sv_person_msg_notify);
        this.b = (TextView) findViewById(R.id.change_attention_text);
        this.c = (RelativeLayout) findViewById(R.id.change_attention);
    }

    public void a(boolean z) {
        if (z) {
            this.a.b(false);
        } else {
            this.a.a(false);
        }
    }

    public void b(boolean z) {
        boolean z2 = false;
        Context context = getContext();
        if (context instanceof com.baidu.tieba.f) {
            z2 = ((com.baidu.tieba.f) context).getLayoutMode().a();
        } else if (context instanceof com.baidu.tieba.k) {
            z2 = ((com.baidu.tieba.k) getContext()).a().a();
        }
        if (z) {
            this.b.setText(R.string.cancel_attention);
            this.b.setCompoundDrawables(null, null, null, null);
            if (z2) {
                this.b.setTextColor(getResources().getColor(R.color.btn_attention_remove_1));
                this.c.setBackgroundResource(R.drawable.btn_information_add_1);
                return;
            }
            this.b.setTextColor(getResources().getColor(R.color.btn_attention_remove));
            this.c.setBackgroundResource(R.drawable.btn_information_add);
            return;
        }
        this.b.setText(R.string.add_attention);
        if (z2) {
            this.b.setTextColor(getResources().getColor(R.color.btn_attention_add_1));
            this.b.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.icon_information_add_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.c.setBackgroundResource(R.drawable.btn_information_discuss_1);
            return;
        }
        this.b.setTextColor(getResources().getColor(R.color.btn_attention_add));
        this.b.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.icon_information_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.c.setBackgroundResource(R.drawable.btn_information_discuss);
    }
}
