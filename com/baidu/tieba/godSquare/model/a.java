package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes24.dex */
public class a {
    private l<byte[]> iwO;

    public a() {
        baD();
    }

    private void baD() {
        if (this.iwO == null) {
            this.iwO = com.baidu.tbadk.core.c.a.bmx().AX("tb.god_square");
        }
    }

    public byte[] JP(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            baD();
            bVar = this.iwO.bB(str);
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
            baD();
            this.iwO.set(str, bArr, 604800000L);
        }
    }
}
