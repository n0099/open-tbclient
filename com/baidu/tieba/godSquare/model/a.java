package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes11.dex */
public class a {
    private l<byte[]> hvk;

    public a() {
        aIY();
    }

    private void aIY() {
        if (this.hvk == null) {
            this.hvk = com.baidu.tbadk.core.c.a.aUM().wb("tb.god_square");
        }
    }

    public byte[] ET(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aIY();
            bVar = this.hvk.bu(str);
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
            aIY();
            this.hvk.set(str, bArr, 604800000L);
        }
    }
}
