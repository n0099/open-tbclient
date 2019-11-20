package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean aUF;
    public boolean aUG;
    public String aUw;
    public boolean aWA;
    public String aWB;
    public int aWC;
    public String aWD;
    public String aWF;
    public String aWG;
    public boolean aWH;
    public boolean aWI;
    public boolean aWJ;
    public int duration;
    public int mPos;
    public String mSrc;

    public c() {
        super("viewId", "video");
        this.aUw = "";
        this.aWA = false;
        this.aWB = "";
        this.aWC = 0;
        this.duration = 0;
        this.aUF = false;
        this.aUG = false;
        this.aWD = "";
        this.mPos = 0;
        this.aWF = "";
        this.aWG = "";
        this.aWH = false;
        this.aWI = false;
        this.aWJ = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aUw);
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aUw + "', mSlaveId='" + this.aXp + "', mMuted=" + this.aWA + "', mObjectFit='" + this.aWD + "', mControl=" + this.aWJ + '}';
    }
}
