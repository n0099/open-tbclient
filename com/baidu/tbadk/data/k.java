package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId aoZ = BdUniqueId.gen();
    private String Pn;
    private String Po;
    private boolean apa = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aoZ;
    }

    public String AP() {
        return this.Po;
    }

    public void fc(String str) {
        this.Po = str;
    }

    public String getSmallUrl() {
        return this.Pn;
    }

    public void fd(String str) {
        this.Pn = str;
    }

    public boolean AQ() {
        return this.apa;
    }

    public void bn(boolean z) {
        this.apa = z;
    }
}
