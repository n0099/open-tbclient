package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes11.dex */
public class a {
    private l<byte[]> gUe;

    public a() {
        aDl();
    }

    private void aDl() {
        if (this.gUe == null) {
            this.gUe = com.baidu.tbadk.core.c.a.aMR().uf("tb.god_square");
        }
    }

    public byte[] CJ(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aDl();
            bVar = this.gUe.bs(str);
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
            aDl();
            this.gUe.set(str, bArr, 604800000L);
        }
    }
}
