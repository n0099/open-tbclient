package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes11.dex */
public class a {
    private l<byte[]> gTY;

    public a() {
        aDl();
    }

    private void aDl() {
        if (this.gTY == null) {
            this.gTY = com.baidu.tbadk.core.c.a.aMT().uc("tb.god_square");
        }
    }

    public byte[] CG(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aDl();
            bVar = this.gTY.bs(str);
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
            this.gTY.set(str, bArr, 604800000L);
        }
    }
}
