package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes23.dex */
public class a {
    private l<byte[]> iCL;

    public a() {
        bdd();
    }

    private void bdd() {
        if (this.iCL == null) {
            this.iCL = com.baidu.tbadk.core.c.a.boX().Bl("tb.tbtiel_level_info");
        }
    }

    public byte[] Kg(String str) {
        l.b<byte[]> bB = (this.iCL == null || str == null) ? null : this.iCL.bB(str);
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bdd();
            this.iCL.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
