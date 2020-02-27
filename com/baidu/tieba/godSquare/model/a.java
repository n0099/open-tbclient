package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes11.dex */
public class a {
    private l<byte[]> gjU;

    public a() {
        auV();
    }

    private void auV() {
        if (this.gjU == null) {
            this.gjU = com.baidu.tbadk.core.c.a.aEz().sP("tb.god_square");
        }
    }

    public byte[] AT(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            auV();
            bVar = this.gjU.ad(str);
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
            auV();
            this.gjU.set(str, bArr, 604800000L);
        }
    }
}
