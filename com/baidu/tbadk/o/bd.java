package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.lib.b.a {
    public static final String[] aMR = {"com.baidu.tieba.voice"};

    @Override // com.baidu.adp.lib.b.a
    protected void Q(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected void initData() {
        this.mName = "voice";
        this.sa = aMR;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ev() {
        return aMR;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ew() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ex() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ey() {
        return 10;
    }
}
