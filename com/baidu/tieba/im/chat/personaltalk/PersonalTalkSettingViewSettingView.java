package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView aVx;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.aVx != null) {
            this.aVx.setSwitchStateChangeListener(cVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), com.baidu.tieba.x.p2ptalk_setting_detail_view, this);
        this.aVx = (SettingTextSwitchView) findViewById(com.baidu.tieba.w.sv_person_msg_notify);
    }

    public void cF(boolean z) {
        if (z) {
            this.aVx.M(false);
        } else {
            this.aVx.N(false);
        }
    }
}
