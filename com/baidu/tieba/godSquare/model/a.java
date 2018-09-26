package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bCM;

    public a() {
        auH();
    }

    private void auH() {
        if (this.bCM == null) {
            this.bCM = com.baidu.tbadk.core.c.a.yh().dP("tb.god_square");
        }
    }

    public byte[] mL(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            auH();
            bVar = this.bCM.aF(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            auH();
            this.bCM.a(str, bArr, 604800000L);
        }
    }
}
