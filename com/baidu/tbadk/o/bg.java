package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.lib.b.a {
    public static final String[] aVL = {"com.baidu.tieba.voice"};

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected void initData() {
        this.mName = "voice";
        this.yl = aVL;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hm() {
        return aVL;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hp() {
        return 10;
    }
}
