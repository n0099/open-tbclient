package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
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
        inflate(getContext(), com.baidu.tieba.im.i.p2ptalk_setting_detail_view, this);
        this.a = (SettingTextSwitchView) findViewById(com.baidu.tieba.im.h.sv_person_msg_notify);
        this.b = (TextView) findViewById(com.baidu.tieba.im.h.change_attention_text);
        this.c = (RelativeLayout) findViewById(com.baidu.tieba.im.h.change_attention);
    }

    public final void a(boolean z) {
        if (z) {
            this.a.b(false);
        } else {
            this.a.a(false);
        }
    }

    public final void b(boolean z) {
        boolean z2 = false;
        Context context = getContext();
        if (context instanceof com.baidu.tbadk.a) {
            z2 = ((com.baidu.tbadk.a) context).getLayoutMode().a();
        } else if (context instanceof com.baidu.tbadk.core.e) {
            z2 = ((com.baidu.tbadk.core.e) getContext()).b().a();
        }
        if (z) {
            this.b.setText(com.baidu.tieba.im.j.cancel_attention);
            this.b.setCompoundDrawables(null, null, null, null);
            if (z2) {
                this.b.setTextColor(getResources().getColor(com.baidu.tieba.im.e.btn_attention_remove_1));
                this.c.setBackgroundResource(com.baidu.tieba.im.g.btn_information_add_1);
                return;
            }
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.im.e.btn_attention_remove));
            this.c.setBackgroundResource(com.baidu.tieba.im.g.btn_information_add);
            return;
        }
        this.b.setText(com.baidu.tieba.im.j.add_attention);
        if (z2) {
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.im.e.btn_attention_add_1));
            this.b.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.c.setBackgroundResource(com.baidu.tieba.im.g.btn_information_discuss_1);
            return;
        }
        this.b.setTextColor(getResources().getColor(com.baidu.tieba.im.e.btn_attention_add));
        this.b.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
        this.c.setBackgroundResource(com.baidu.tieba.im.g.btn_information_discuss);
    }
}
