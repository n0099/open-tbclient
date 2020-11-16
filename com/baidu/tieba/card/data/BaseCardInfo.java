package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public abstract class BaseCardInfo implements q, com.baidu.afd.k {
    public int position;
    private com.baidu.afd.j trigger;
    public boolean needTopMargin = false;
    public boolean isFirstFloor = false;
    private SupportType mSupportType = SupportType.NONE;

    /* loaded from: classes.dex */
    public enum SupportType {
        NONE,
        FULL,
        TOP,
        CONTENT,
        BOTTOM,
        EXTEND
    }

    @Override // com.baidu.afd.k
    public void setTrigger(com.baidu.afd.j jVar) {
        this.trigger = jVar;
    }

    public com.baidu.afd.j getTrigger() {
        return this.trigger;
    }

    public void setSupportType(SupportType supportType) {
        this.mSupportType = supportType;
    }

    public boolean isSupportNone() {
        return this.mSupportType == SupportType.NONE;
    }

    public boolean isSupportFull() {
        return this.mSupportType == SupportType.FULL;
    }

    public boolean isSupportTop() {
        return this.mSupportType == SupportType.TOP;
    }

    public boolean isSupportContent() {
        return this.mSupportType == SupportType.CONTENT;
    }

    public boolean isSupportExtend() {
        return this.mSupportType == SupportType.EXTEND;
    }

    public boolean isSupportBottom() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
