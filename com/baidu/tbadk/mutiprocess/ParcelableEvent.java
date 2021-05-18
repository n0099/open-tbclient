package com.baidu.tbadk.mutiprocess;

import android.os.Parcelable;
import android.os.Process;
import com.baidu.adp.BdUniqueId;
import d.a.j0.f0.a;
/* loaded from: classes3.dex */
public abstract class ParcelableEvent implements a, Parcelable {
    public int mTag = 0;
    public int mType = 0;
    public int mPid = Process.myPid();

    @Override // d.a.j0.f0.a
    public int getPid() {
        return this.mPid;
    }

    @Override // d.a.j0.f0.a
    public int getTag() {
        return this.mTag;
    }

    @Override // d.a.j0.f0.a
    public int getType() {
        return this.mType;
    }

    @Override // d.a.j0.f0.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.mTag = bdUniqueId.getId();
        }
    }
}
