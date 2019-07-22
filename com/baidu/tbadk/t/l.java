package com.baidu.tbadk.t;

import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
        TbSingleton.getInstance().setEnableBenchmark(i != 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_benchmark_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hI() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hJ() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hK() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hL() {
        return 10;
    }
}
