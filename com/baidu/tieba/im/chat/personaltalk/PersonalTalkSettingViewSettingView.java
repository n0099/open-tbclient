package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView a;

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
        inflate(getContext(), v.p2ptalk_setting_detail_view, this);
        this.a = (SettingTextSwitchView) findViewById(u.sv_person_msg_notify);
    }

    public void a(boolean z) {
        if (z) {
            this.a.b(false);
        } else {
            this.a.a(false);
        }
    }
}
