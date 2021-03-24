package com.baidu.tbadk.mutiprocess;

import android.os.Process;
import com.baidu.adp.BdUniqueId;
import d.b.h0.f0.a;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class SerializableEvent implements Serializable, a {
    public int mPid;
    public int mTag;
    public int mType;

    public SerializableEvent() {
        this.mTag = 0;
        this.mType = 0;
        this.mPid = Process.myPid();
    }

    @Override // d.b.h0.f0.a
    public int getPid() {
        return this.mPid;
    }

    @Override // d.b.h0.f0.a
    public int getTag() {
        return this.mTag;
    }

    @Override // d.b.h0.f0.a
    public int getType() {
        return this.mType;
    }

    @Override // d.b.h0.f0.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.mTag = bdUniqueId.getId();
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public SerializableEvent(int i) {
        this.mTag = 0;
        this.mType = 0;
        this.mPid = Process.myPid();
        this.mType = i;
    }
}
