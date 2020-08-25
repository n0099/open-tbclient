package com.baidu.tbadk.mutiprocess.event;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes2.dex */
public class PrivacyPolicyEvent extends SerializableEvent {
    public boolean isAgreePrivacyPolicy;

    public PrivacyPolicyEvent(Boolean bool) {
        setType(0);
        this.isAgreePrivacyPolicy = bool.booleanValue();
    }
}
