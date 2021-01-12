package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class a {
    private l<byte[]> iVY;

    public a() {
        bef();
    }

    private void bef() {
        if (this.iVY == null) {
            this.iVY = com.baidu.tbadk.core.c.a.bpZ().Aa("tb.god_square");
        }
    }

    public byte[] Jj(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            bef();
            bVar = this.iVY.by(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void m(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bef();
            this.iVY.set(str, bArr, 604800000L);
        }
    }
}
