package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class l implements v {
    public static final BdUniqueId ate = BdUniqueId.gen();
    private String atf;
    private String atg;
    private boolean ath = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ate;
    }

    public String Cc() {
        return this.atf;
    }

    public void ff(String str) {
        this.atf = str;
    }

    public String getSmallUrl() {
        return this.atg;
    }

    public void fg(String str) {
        this.atg = str;
    }

    public boolean Cd() {
        return this.ath;
    }

    public void bv(boolean z) {
        this.ath = z;
    }
}
