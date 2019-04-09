package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class d {
    private l<byte[]> dfY;

    public d() {
        SK();
    }

    public void SK() {
        if (this.dfY == null) {
            this.dfY = com.baidu.tbadk.core.c.a.aaT().lv("tb.bawu_team_info");
        }
    }

    public byte[] uK(String str) {
        l.b<byte[]> aF = (this.dfY == null || str == null) ? null : this.dfY.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            SK();
            this.dfY.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
