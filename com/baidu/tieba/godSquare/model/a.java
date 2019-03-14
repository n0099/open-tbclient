package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes6.dex */
public class a {
    private l<byte[]> dfT;

    public a() {
        SM();
    }

    private void SM() {
        if (this.dfT == null) {
            this.dfT = com.baidu.tbadk.core.c.a.aaW().lu("tb.god_square");
        }
    }

    public byte[] uL(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            SM();
            bVar = this.dfT.aF(str);
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
            SM();
            this.dfT.a(str, bArr, 604800000L);
        }
    }
}
