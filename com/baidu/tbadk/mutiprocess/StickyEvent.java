package com.baidu.tbadk.mutiprocess;

import android.os.Process;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import d.a.i0.f0.a;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class StickyEvent extends OrmObject implements Serializable, a {
    public int mTag = 0;
    public int mType = 2;
    public int mPid = Process.myPid();

    @Override // d.a.i0.f0.a
    public int getPid() {
        return this.mPid;
    }

    @Override // d.a.i0.f0.a
    public int getTag() {
        return this.mTag;
    }

    @Override // d.a.i0.f0.a
    public int getType() {
        return this.mType;
    }

    public void resetPid() {
        this.mPid = Process.myPid();
    }

    @Override // d.a.i0.f0.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.mTag = bdUniqueId.getId();
        }
    }

    public void setType(int i2) {
        this.mType = i2;
    }
}
