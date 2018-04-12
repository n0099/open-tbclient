package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bmz;

    public a() {
        aob();
    }

    private void aob() {
        if (this.bmz == null) {
            this.bmz = com.baidu.tbadk.core.c.a.tz().cY("tb.god_square");
        }
    }

    public byte[] lz(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aob();
            bVar = this.bmz.ab(str);
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
            aob();
            this.bmz.a(str, bArr, 604800000L);
        }
    }
}
