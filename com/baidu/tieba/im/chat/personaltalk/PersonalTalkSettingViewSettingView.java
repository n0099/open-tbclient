package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
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
        inflate(getContext(), w.p2ptalk_setting_detail_view, this);
        this.a = (SettingTextSwitchView) findViewById(v.sv_person_msg_notify);
        this.b = (TextView) findViewById(v.change_attention_text);
        this.c = (RelativeLayout) findViewById(v.change_attention);
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
        if (context instanceof BaseActivity) {
            z2 = ((BaseActivity) context).getLayoutMode().a();
        } else if (context instanceof BaseFragmentActivity) {
            z2 = ((BaseFragmentActivity) getContext()).a().a();
        }
        if (z) {
            this.b.setText(y.cancel_attention);
            this.b.setCompoundDrawables(null, null, null, null);
            if (z2) {
                this.b.setTextColor(getResources().getColor(s.btn_attention_remove_1));
                this.c.setBackgroundResource(u.btn_information_add_1);
                return;
            }
            this.b.setTextColor(getResources().getColor(s.btn_attention_remove));
            this.c.setBackgroundResource(u.btn_information_add);
            return;
        }
        this.b.setText(y.add_attention);
        if (z2) {
            this.b.setTextColor(getResources().getColor(s.btn_attention_add_1));
            this.b.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(u.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.c.setBackgroundResource(u.btn_information_discuss_1);
            return;
        }
        this.b.setTextColor(getResources().getColor(s.btn_attention_add));
        this.b.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(u.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
        this.c.setBackgroundResource(u.btn_information_discuss);
    }
}
