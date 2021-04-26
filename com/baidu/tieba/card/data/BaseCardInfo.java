package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import d.a.d.j;
import d.a.d.k;
/* loaded from: classes4.dex */
public abstract class BaseCardInfo implements n, k {
    public int position;
    public j trigger;
    public boolean needTopMargin = false;
    public boolean isFirstFloor = false;
    public SupportType mSupportType = SupportType.NONE;

    /* loaded from: classes4.dex */
    public enum SupportType {
        NONE,
        FULL,
        TOP,
        CONTENT,
        BOTTOM,
        EXTEND
    }

    public j getTrigger() {
        return this.trigger;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }

    public boolean isSupportBottom() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    public boolean isSupportContent() {
        return this.mSupportType == SupportType.CONTENT;
    }

    public boolean isSupportExtend() {
        return this.mSupportType == SupportType.EXTEND;
    }

    public boolean isSupportFull() {
        return this.mSupportType == SupportType.FULL;
    }

    public boolean isSupportNone() {
        return this.mSupportType == SupportType.NONE;
    }

    public boolean isSupportTop() {
        return this.mSupportType == SupportType.TOP;
    }

    public void setSupportType(SupportType supportType) {
        this.mSupportType = supportType;
    }

    @Override // d.a.d.k
    public void setTrigger(j jVar) {
        this.trigger = jVar;
    }
}
