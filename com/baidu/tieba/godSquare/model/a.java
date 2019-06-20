package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes6.dex */
public class a {
    private l<byte[]> dqB;

    public a() {
        Wx();
    }

    private void Wx() {
        if (this.dqB == null) {
            this.dqB = com.baidu.tbadk.core.c.a.afD().mz("tb.god_square");
        }
    }

    public byte[] wd(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            Wx();
            bVar = this.dqB.ap(str);
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
            Wx();
            this.dqB.a(str, bArr, 604800000L);
        }
    }
}
