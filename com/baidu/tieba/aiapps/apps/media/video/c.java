package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aUO;
    public boolean aUX;
    public boolean aUY;
    public boolean aWS;
    public String aWT;
    public int aWU;
    public String aWV;
    public String aWX;
    public String aWY;
    public boolean aWZ;
    public boolean aXa;
    public boolean aXb;
    public int duration;
    public int mPos;
    public String mSrc;

    public c() {
        super("viewId", "video");
        this.aUO = "";
        this.aWS = false;
        this.aWT = "";
        this.aWU = 0;
        this.duration = 0;
        this.aUX = false;
        this.aUY = false;
        this.aWV = "";
        this.mPos = 0;
        this.aWX = "";
        this.aWY = "";
        this.aWZ = false;
        this.aXa = false;
        this.aXb = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aUO);
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aUO + "', mSlaveId='" + this.aXH + "', mMuted=" + this.aWS + "', mObjectFit='" + this.aWV + "', mControl=" + this.aXb + '}';
    }
}
