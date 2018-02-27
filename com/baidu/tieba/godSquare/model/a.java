package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> ccx;

    public a() {
        atL();
    }

    private void atL() {
        if (this.ccx == null) {
            this.ccx = com.baidu.tbadk.core.c.a.AQ().dg("tb.god_square");
        }
    }

    public byte[] lw(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            atL();
            bVar = this.ccx.ae(str);
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
            atL();
            this.ccx.a(str, bArr, 604800000L);
        }
    }
}
