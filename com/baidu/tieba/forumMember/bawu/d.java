package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class d {
    private l<byte[]> dfT;

    public d() {
        SM();
    }

    public void SM() {
        if (this.dfT == null) {
            this.dfT = com.baidu.tbadk.core.c.a.aaW().lu("tb.bawu_team_info");
        }
    }

    public byte[] uL(String str) {
        l.b<byte[]> aF = (this.dfT == null || str == null) ? null : this.dfT.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            SM();
            this.dfT.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
