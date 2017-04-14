package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aw implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bOa = BdUniqueId.gen();
    private int height = 0;
    private int blf = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bOa;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int ZH() {
        return this.blf;
    }

    public void hP(int i) {
        this.blf = i;
    }
}
