package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes11.dex */
public class a {
    private l<byte[]> gkj;

    public a() {
        auX();
    }

    private void auX() {
        if (this.gkj == null) {
            this.gkj = com.baidu.tbadk.core.c.a.aEB().sP("tb.god_square");
        }
    }

    public byte[] AU(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            auX();
            bVar = this.gkj.ad(str);
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
            auX();
            this.gkj.set(str, bArr, 604800000L);
        }
    }
}
