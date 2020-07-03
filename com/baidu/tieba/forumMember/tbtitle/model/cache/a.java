package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class a {
    private l<byte[]> hvk;

    public a() {
        aIY();
    }

    private void aIY() {
        if (this.hvk == null) {
            this.hvk = com.baidu.tbadk.core.c.a.aUM().wb("tb.tbtiel_level_info");
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
