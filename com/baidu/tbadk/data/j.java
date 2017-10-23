package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId azr = BdUniqueId.gen();
    private String azs;
    private String azt;
    private boolean azu = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azr;
    }

    public String BV() {
        return this.azs;
    }

    public void fn(String str) {
        this.azs = str;
    }

    public String getSmallUrl() {
        return this.azt;
    }

    public void fo(String str) {
        this.azt = str;
    }

    public boolean BW() {
        return this.azu;
    }

    public void bu(boolean z) {
        this.azu = z;
    }
}
