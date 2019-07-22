package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes6.dex */
public class a {
    private l<byte[]> dsK;

    public a() {
        Xr();
    }

    private void Xr() {
        if (this.dsK == null) {
            this.dsK = com.baidu.tbadk.core.d.a.agF().mK("tb.god_square");
        }
    }

    public byte[] wI(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            Xr();
            bVar = this.dsK.aq(str);
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
            Xr();
            this.dsK.a(str, bArr, 604800000L);
        }
    }
}
