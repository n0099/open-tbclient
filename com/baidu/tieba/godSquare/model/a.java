package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> ccA;

    public a() {
        atM();
    }

    private void atM() {
        if (this.ccA == null) {
            this.ccA = com.baidu.tbadk.core.c.a.AR().dg("tb.god_square");
        }
    }

    public byte[] lw(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            atM();
            bVar = this.ccA.ae(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            atM();
            this.ccA.a(str, bArr, 604800000L);
        }
    }
}
