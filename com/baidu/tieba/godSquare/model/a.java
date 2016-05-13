package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> bcU;
    private final long bcV = TbConfig.APP_OVERDUR_DRAFT_BOX;

    public a() {
        OS();
    }

    private void OS() {
        if (this.bcU == null) {
            this.bcU = com.baidu.tbadk.core.b.a.rS().cw("tb.god_square");
        }
    }

    public byte[] hC(String str) {
        o.b<byte[]> bVar;
        if (str != null) {
            OS();
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
            OS();
            this.bcU.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
