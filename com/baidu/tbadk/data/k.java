package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId ask = BdUniqueId.gen();
    private String asl;
    private String asm;
    private boolean asn = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ask;
    }

    public String BY() {
        return this.asl;
    }

    public void fc(String str) {
        this.asl = str;
    }

    public String getSmallUrl() {
        return this.asm;
    }

    public void fd(String str) {
        this.asm = str;
    }

    public boolean BZ() {
        return this.asn;
    }

    public void bv(boolean z) {
        this.asn = z;
    }
}
