package com.baidu.tbadk.mutiprocess.mission;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes.dex */
public class MissionEvent extends SerializableEvent {
    public static final String MESSAGE_ACTIVITY = "onActivity";
    public static final String MESSAGE_CREATE = "onCreate";
    public static final String MESSAGE_DESTROY = "onDestroy";
    public static final String MESSAGE_PAUSE = "onPause";
    public static final String MESSAGE_RESUME = "onResume";
    public static final String MESSAGE_START = "onStart";
    public static final String MESSAGE_STOP = "onStop";
    public static final String MESSAGE_TOUCH = "onTouch";
    public String actionType;
    public int pageId;
    public int pageType;
    public long tid;

    public MissionEvent() {
        setType(1);
    }
}
