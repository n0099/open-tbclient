package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId asV = BdUniqueId.gen();
    private String Sv;
    private String Sw;
    private boolean asW = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return asV;
    }

    public String Ce() {
        return this.Sw;
    }

    public void fd(String str) {
        this.Sw = str;
    }

    public String getSmallUrl() {
        return this.Sv;
    }

    public void fe(String str) {
        this.Sv = str;
    }

    public boolean Cf() {
        return this.asW;
    }

    public void bs(boolean z) {
        this.asW = z;
    }
}
