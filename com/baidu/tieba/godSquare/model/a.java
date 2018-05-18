package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bmO;

    public a() {
        aoa();
    }

    private void aoa() {
        if (this.bmO == null) {
            this.bmO = com.baidu.tbadk.core.c.a.ty().cY("tb.god_square");
        }
    }

    public byte[] lC(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aoa();
            bVar = this.bmO.ab(str);
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
            aoa();
            this.bmO.a(str, bArr, 604800000L);
        }
    }
}
