package com.baidu.tieba.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class af extends com.baidu.tbadk.core.data.q {
    public static final BdUniqueId alI = BdUniqueId.gen();
    private boolean alJ;
    private u alK;
    private String fortune_desc;

    public boolean zH() {
        return this.alJ;
    }

    public void bq(boolean z) {
        this.alJ = z;
    }

    public String zI() {
        return this.fortune_desc;
    }

    public void ev(String str) {
        this.fortune_desc = str;
    }

    public u zJ() {
        return this.alK;
    }

    public void a(u uVar) {
        this.alK = uVar;
    }

    @Override // com.baidu.tbadk.core.data.q, com.baidu.adp.widget.ListView.al
    public BdUniqueId hu() {
        return alI;
    }
}
