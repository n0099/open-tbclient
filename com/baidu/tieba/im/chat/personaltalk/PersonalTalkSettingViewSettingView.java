package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView aSR;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.aSR != null) {
            this.aSR.setSwitchStateChangeListener(cVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), w.p2ptalk_setting_detail_view, this);
        this.aSR = (SettingTextSwitchView) findViewById(v.sv_person_msg_notify);
    }

    public void cN(boolean z) {
        if (z) {
            this.aSR.A(false);
        } else {
            this.aSR.B(false);
        }
    }
}
