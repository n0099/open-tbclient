package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bwX;

    public a() {
        asT();
    }

    private void asT() {
        if (this.bwX == null) {
            this.bwX = com.baidu.tbadk.core.c.a.xa().dx("tb.god_square");
        }
    }

    public byte[] mj(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            asT();
            bVar = this.bwX.ao(str);
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
            asT();
            this.bwX.a(str, bArr, 604800000L);
        }
    }
}
