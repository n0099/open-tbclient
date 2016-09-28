package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId asG = BdUniqueId.gen();
    private String SC;
    private String SD;
    private boolean asH = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return asG;
    }

    public String Ch() {
        return this.SD;
    }

    public void fg(String str) {
        this.SD = str;
    }

    public String getSmallUrl() {
        return this.SC;
    }

    public void fh(String str) {
        this.SC = str;
    }

    public boolean Ci() {
        return this.asH;
    }

    public void br(boolean z) {
        this.asH = z;
    }
}
