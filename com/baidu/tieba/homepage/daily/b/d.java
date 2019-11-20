package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfd = BdUniqueId.gen();
    private String gfe;
    private String gff;
    private boolean gfg;

    public String btj() {
        return this.gfe;
    }

    public void wT(String str) {
        this.gfe = str;
    }

    public String btk() {
        return this.gff;
    }

    public void wU(String str) {
        this.gff = str;
    }

    public boolean btl() {
        return this.gfg;
    }

    public void la(boolean z) {
        this.gfg = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gfd;
    }
}
