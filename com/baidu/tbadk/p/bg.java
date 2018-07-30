package com.baidu.tbadk.p;
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.lib.b.a {
    public static final String[] aVN = {"com.baidu.tieba.voice"};

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected void initData() {
        this.mName = "voice";
        this.yf = aVN;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hl() {
        return aVN;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hm() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 10;
    }
}
