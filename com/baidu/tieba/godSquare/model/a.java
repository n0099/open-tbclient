package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes6.dex */
public class a {
    private l<byte[]> fqn;

    public a() {
        aci();
    }

    private void aci() {
        if (this.fqn == null) {
            this.fqn = com.baidu.tbadk.core.d.a.akL().nk("tb.god_square");
        }
    }

    public byte[] vB(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aci();
            bVar = this.fqn.Y(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void i(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aci();
            this.fqn.set(str, bArr, 604800000L);
        }
    }
}
