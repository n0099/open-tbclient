package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class o implements q {
    public static final BdUniqueId ajD = BdUniqueId.gen();
    private boolean cBC = false;
    private String fta;
    private String ftb;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ajD;
    }

    public String bBN() {
        return this.fta;
    }

    public void DC(String str) {
        this.fta = str;
    }

    public String getSmallUrl() {
        return this.ftb;
    }

    public void DD(String str) {
        this.ftb = str;
    }

    public boolean bBO() {
        return this.cBC;
    }

    public void kk(boolean z) {
        this.cBC = z;
    }
}
