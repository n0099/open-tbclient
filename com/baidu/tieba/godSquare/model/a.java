package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes6.dex */
public class a {
    private l<byte[]> fre;

    public a() {
        ack();
    }

    private void ack() {
        if (this.fre == null) {
            this.fre = com.baidu.tbadk.core.d.a.akN().nk("tb.god_square");
        }
    }

    public byte[] vB(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            ack();
            bVar = this.fre.Y(str);
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
            ack();
            this.fre.set(str, bArr, 604800000L);
        }
    }
}
