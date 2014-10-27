package com.baidu.tieba.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class af extends com.baidu.tbadk.core.data.q {
    public static final BdUniqueId alz = BdUniqueId.gen();
    private boolean alA;
    private u alB;
    private String fortune_desc;

    public boolean zF() {
        return this.alA;
    }

    public void bq(boolean z) {
        this.alA = z;
    }

    public String zG() {
        return this.fortune_desc;
    }

    public void ev(String str) {
        this.fortune_desc = str;
    }

    public u zH() {
        return this.alB;
    }

    public void a(u uVar) {
        this.alB = uVar;
    }

    @Override // com.baidu.tbadk.core.data.q, com.baidu.adp.widget.ListView.al
    public BdUniqueId hu() {
        return alz;
    }
}
