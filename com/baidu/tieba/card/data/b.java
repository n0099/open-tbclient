package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.adp.widget.ListView.q, com.baidu.afd.j {
    public int position;
    private com.baidu.afd.i trigger;
    public boolean needTopMargin = false;
    public boolean isFirstFloor = false;

    @Override // com.baidu.afd.j
    public void setTrigger(com.baidu.afd.i iVar) {
        this.trigger = iVar;
    }

    public com.baidu.afd.i getTrigger() {
        return this.trigger;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
