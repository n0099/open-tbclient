package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes11.dex */
public class a {
    private l<byte[]> gjW;

    public a() {
        auX();
    }

    private void auX() {
        if (this.gjW == null) {
            this.gjW = com.baidu.tbadk.core.c.a.aEB().sP("tb.god_square");
        }
    }

    public byte[] AT(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            auX();
            bVar = this.gjW.ad(str);
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
            this.gjW.set(str, bArr, 604800000L);
        }
    }
}
