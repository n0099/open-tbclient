package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView aUe;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.aUe != null) {
            this.aUe.setSwitchStateChangeListener(cVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), x.p2ptalk_setting_detail_view, this);
        this.aUe = (SettingTextSwitchView) findViewById(w.sv_person_msg_notify);
    }

    public void cA(boolean z) {
        if (z) {
            this.aUe.M(false);
        } else {
            this.aUe.N(false);
        }
    }
}
