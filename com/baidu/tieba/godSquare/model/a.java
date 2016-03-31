package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> bhe;
    private final long bhf = TbConfig.APP_OVERDUR_DRAFT_BOX;

    public a() {
        PX();
    }

    private void PX() {
        if (this.bhe == null) {
            this.bhe = com.baidu.tbadk.core.b.a.um().cy("tb.god_square");
        }
    }

    public byte[] hC(String str) {
        o.b<byte[]> bVar;
        if (str != null) {
            PX();
            bVar = this.bhe.Z(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.sI == null) {
            return null;
        }
        return bVar.sI;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            PX();
            this.bhe.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
