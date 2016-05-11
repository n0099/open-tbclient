package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> bcU;
    private final long bcV = TbConfig.APP_OVERDUR_DRAFT_BOX;

    public a() {
        OQ();
    }

    private void OQ() {
        if (this.bcU == null) {
            this.bcU = com.baidu.tbadk.core.b.a.rR().cw("tb.god_square");
        }
    }

    public byte[] hC(String str) {
        o.b<byte[]> bVar;
        if (str != null) {
            OQ();
            bVar = this.bcU.Q(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.iz == null) {
            return null;
        }
        return bVar.iz;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            OQ();
            this.bcU.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
