package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBc;
    public boolean aBl;
    public boolean aDf;
    public String aDg;
    public int aDh;
    public String aDi;
    public String aDk;
    public String aDl;
    public boolean aDm;
    public boolean aDn;
    public boolean aDo;
    public int duration;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public c() {
        super("viewId", "video");
        this.aBc = "";
        this.aDf = false;
        this.aDg = "";
        this.aDh = 0;
        this.duration = 0;
        this.aBl = false;
        this.mLoop = false;
        this.aDi = "";
        this.mPos = 0;
        this.aDk = "";
        this.aDl = "";
        this.aDm = false;
        this.aDn = false;
        this.aDo = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBc);
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aBc + "', mSlaveId='" + this.aDU + "', mMuted=" + this.aDf + "', mObjectFit='" + this.aDi + "', mControl=" + this.aDo + '}';
    }
}
