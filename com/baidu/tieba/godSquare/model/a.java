package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes6.dex */
public class a {
    private l<byte[]> duC;

    public a() {
        Xv();
    }

    private void Xv() {
        if (this.duC == null) {
            this.duC = com.baidu.tbadk.core.d.a.agL().mM("tb.god_square");
        }
    }

    public byte[] xi(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            Xv();
            bVar = this.duC.aq(str);
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
            Xv();
            this.duC.a(str, bArr, 604800000L);
        }
    }
}
