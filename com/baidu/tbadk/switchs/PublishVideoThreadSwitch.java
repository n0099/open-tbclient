package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class PublishVideoThreadSwitch extends a {
    public static final int MOTU = 1;
    public static final String PUBLISH_VIDEO_THREAD_KEY = "add_video_thread_switch";
    public static final int TBVIDEO = 0;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 0;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return PUBLISH_VIDEO_THREAD_KEY;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 1;
    }
}
