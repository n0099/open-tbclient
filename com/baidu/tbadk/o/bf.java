package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.lib.b.a {
    public static final String[] aUP = {"com.baidu.tieba.voice"};

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected void initData() {
        this.mName = "voice";
        this.yn = aUP;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hm() {
        return aUP;
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
