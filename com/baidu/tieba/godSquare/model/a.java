package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bMc;

    public a() {
        axB();
    }

    private void axB() {
        if (this.bMc == null) {
            this.bMc = com.baidu.tbadk.core.c.a.Ax().ef("tb.god_square");
        }
    }

    public byte[] no(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            axB();
            bVar = this.bMc.aF(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            axB();
            this.bMc.a(str, bArr, 604800000L);
        }
    }
}
