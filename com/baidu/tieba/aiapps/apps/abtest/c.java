package com.baidu.tieba.aiapps.apps.abtest;

import com.baidu.swan.apps.b.b.e;
/* loaded from: classes4.dex */
public class c implements e {
    private int cRf;

    @Override // com.baidu.swan.apps.b.b.e
    public int vs() {
        return 0;
    }

    @Override // com.baidu.swan.apps.b.b.e
    public boolean vt() {
        return false;
    }

    @Override // com.baidu.swan.apps.b.b.e
    public boolean vu() {
        return this.cRf >= 10;
    }

    @Override // com.baidu.swan.apps.b.b.e
    public int vv() {
        return 0;
    }

    @Override // com.baidu.swan.apps.b.b.e
    public void bM(int i) {
        this.cRf = i;
    }
}
