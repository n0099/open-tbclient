package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes6.dex */
public class a {
    private l<byte[]> dfY;

    public a() {
        SK();
    }

    private void SK() {
        if (this.dfY == null) {
            this.dfY = com.baidu.tbadk.core.c.a.aaT().lv("tb.god_square");
        }
    }

    public byte[] uK(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            SK();
            bVar = this.dfY.aF(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            SK();
            this.dfY.a(str, bArr, 604800000L);
        }
    }
}
