package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iBb = BdUniqueId.gen();
    private int height = 0;
    private int iBc = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iBb;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cvA() {
        return this.iBc;
    }

    public void yo(int i) {
        this.iBc = i;
    }
}
