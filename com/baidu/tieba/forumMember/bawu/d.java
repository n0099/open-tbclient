package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class d {
    private l<byte[]> hvk;

    public d() {
        aIY();
    }

    public void aIY() {
        if (this.hvk == null) {
            this.hvk = com.baidu.tbadk.core.c.a.aUM().wb("tb.bawu_team_info");
        }
    }

    public byte[] ET(String str) {
        l.b<byte[]> bu = (this.hvk == null || str == null) ? null : this.hvk.bu(str);
        if (bu == null || bu.value == null) {
            return null;
        }
        return bu.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aIY();
            this.hvk.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
