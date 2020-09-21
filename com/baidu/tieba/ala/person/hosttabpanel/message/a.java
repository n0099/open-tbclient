package com.baidu.tieba.ala.person.hosttabpanel.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private long fxY;
    private int gTK;
    private long mGroupId;
    private int mPn;
    private long mUserId;

    public a(int i, int i2, long j, long j2, long j3) {
        super(1021076);
        this.mPn = i;
        this.gTK = i2;
        this.mUserId = j;
        this.fxY = j2;
        this.mGroupId = j3;
        setHttpParams();
    }

    private void setHttpParams() {
        addParam("user_id", this.mUserId);
        addParam("anchor_id", this.fxY);
        addParam("group_id", this.mGroupId);
        addParam(Config.PACKAGE_NAME, this.mPn);
        addParam("ps", this.gTK);
    }
}
