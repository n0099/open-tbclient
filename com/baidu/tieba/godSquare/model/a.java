package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes11.dex */
public class a {
    private l<byte[]> gkR;

    public a() {
        ava();
    }

    private void ava() {
        if (this.gkR == null) {
            this.gkR = com.baidu.tbadk.core.c.a.aEF().sO("tb.god_square");
        }
    }

    public byte[] AV(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            ava();
            bVar = this.gkR.ad(str);
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
            ava();
            this.gkR.set(str, bArr, 604800000L);
        }
    }
}
