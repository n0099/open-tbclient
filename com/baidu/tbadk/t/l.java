package com.baidu.tbadk.t;

import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void C(int i) {
        TbSingleton.getInstance().setEnableBenchmark(i != 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_benchmark_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] fi() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fj() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fk() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fl() {
        return 10;
    }
}
