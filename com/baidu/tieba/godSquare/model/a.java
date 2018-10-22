package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bLr;

    public a() {
        aye();
    }

    private void aye() {
        if (this.bLr == null) {
            this.bLr = com.baidu.tbadk.core.c.a.Aq().ef("tb.god_square");
        }
    }

    public byte[] nn(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aye();
            bVar = this.bLr.aF(str);
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
            aye();
            this.bLr.a(str, bArr, 604800000L);
        }
    }
}
