package com.baidu.tbadk.s;

import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
        TbSingleton.getInstance().setEnableBenchmark(i != 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_benchmark_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iG() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iH() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 10;
    }
}
