package com.baidu.tbadk.mutiprocess;

import android.os.Process;
import com.baidu.adp.BdUniqueId;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class SerializableEvent implements a, Serializable {
    private int mPid;
    private int mTag;
    private int mType;

    public SerializableEvent() {
        this.mTag = 0;
        this.mType = 0;
        this.mPid = Process.myPid();
    }

    public SerializableEvent(int i) {
        this.mTag = 0;
        this.mType = 0;
        this.mPid = Process.myPid();
        this.mType = i;
    }

    @Override // com.baidu.tbadk.mutiprocess.a
    public int getTag() {
        return this.mTag;
    }

    @Override // com.baidu.tbadk.mutiprocess.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tbadk.mutiprocess.a
    public int getPid() {
        return this.mPid;
    }

    @Override // com.baidu.tbadk.mutiprocess.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.mTag = bdUniqueId.getId();
        }
    }

    public void setType(int i) {
        this.mType = i;
    }
}
