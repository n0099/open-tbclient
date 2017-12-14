package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.lib.b.a {
    public static final String[] aMp = {"com.baidu.tieba.voice"};

    @Override // com.baidu.adp.lib.b.a
    protected void W(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected void initData() {
        this.mName = "voice";
        this.f0tv = aMp;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eM() {
        return aMp;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eN() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eO() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eP() {
        return 10;
    }
}
