package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes11.dex */
public class a {
    private l<byte[]> hjb;

    public a() {
        aHS();
    }

    private void aHS() {
        if (this.hjb == null) {
            this.hjb = com.baidu.tbadk.core.c.a.aSS().vL("tb.god_square");
        }
    }

    public byte[] Es(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aHS();
            bVar = this.hjb.bt(str);
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
            aHS();
            this.hjb.set(str, bArr, 604800000L);
        }
    }
}
