package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> dfY;

    public d() {
        SK();
    }

    public void SK() {
        if (this.dfY == null) {
            this.dfY = com.baidu.tbadk.core.c.a.aaT().lv("tb.forum_member_info");
        }
    }

    public byte[] uK(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aF = this.dfY != null ? this.dfY.aF(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            SK();
            this.dfY.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
