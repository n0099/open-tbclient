package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBA;
    public boolean aBJ;
    public boolean aDD;
    public String aDE;
    public int aDF;
    public String aDG;
    public String aDI;
    public String aDJ;
    public boolean aDK;
    public boolean aDL;
    public boolean aDM;
    public int duration;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public c() {
        super("viewId", "video");
        this.aBA = "";
        this.aDD = false;
        this.aDE = "";
        this.aDF = 0;
        this.duration = 0;
        this.aBJ = false;
        this.mLoop = false;
        this.aDG = "";
        this.mPos = 0;
        this.aDI = "";
        this.aDJ = "";
        this.aDK = false;
        this.aDL = false;
        this.aDM = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBA);
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aBA + "', mSlaveId='" + this.aEs + "', mMuted=" + this.aDD + "', mObjectFit='" + this.aDG + "', mControl=" + this.aDM + '}';
    }
}
