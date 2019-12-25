package com.baidu.tbadk.mutiprocess.agree;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tieba.tbadkCore.data.AgreeData;
/* loaded from: classes.dex */
public class AgreeEvent extends SerializableEvent {
    public static final String IS_POST = "isInPost";
    public static final String IS_THREAD = "isInThread";
    public AgreeData agreeData;
    public String agreeExtra;

    public AgreeEvent() {
        setType(1);
    }
}
