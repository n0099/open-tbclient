package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes9.dex */
public class a {
    private l<byte[]> ghT;

    public a() {
        asH();
    }

    private void asH() {
        if (this.ghT == null) {
            this.ghT = com.baidu.tbadk.core.c.a.aCo().sz("tb.god_square");
        }
    }

    public byte[] AD(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            asH();
            bVar = this.ghT.ad(str);
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
            asH();
            this.ghT.set(str, bArr, 604800000L);
        }
    }
}
