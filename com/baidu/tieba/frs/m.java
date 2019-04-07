package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fbw = BdUniqueId.gen();
    private int fbx;

    public int bdT() {
        return this.fbx;
    }

    public void qe(int i) {
        this.fbx = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbw;
    }
}
