package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean aAD;
    public String aAu;
    public String aCA;
    public String aCC;
    public String aCD;
    public boolean aCE;
    public boolean aCF;
    public boolean aCG;
    public boolean aCx;
    public String aCy;
    public int aCz;
    public int duration;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public c() {
        super("viewId", "video");
        this.aAu = "";
        this.aCx = false;
        this.aCy = "";
        this.aCz = 0;
        this.duration = 0;
        this.aAD = false;
        this.mLoop = false;
        this.aCA = "";
        this.mPos = 0;
        this.aCC = "";
        this.aCD = "";
        this.aCE = false;
        this.aCF = false;
        this.aCG = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aAu);
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aAu + "', mSlaveId='" + this.aDm + "', mMuted=" + this.aCx + "', mObjectFit='" + this.aCA + "', mControl=" + this.aCG + '}';
    }
}
