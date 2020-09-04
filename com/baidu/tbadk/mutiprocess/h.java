package com.baidu.tbadk.mutiprocess;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.mutiprocess.a;
/* loaded from: classes.dex */
public abstract class h<T extends a> extends com.baidu.adp.framework.d implements b<T> {
    private boolean mSelfListener = false;
    private BdUniqueId mTag = null;

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public boolean isSelfListener() {
        return this.mSelfListener;
    }
}
