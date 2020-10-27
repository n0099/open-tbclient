package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes23.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> iwO;

    public d() {
        baD();
    }

    public void baD() {
        if (this.iwO == null) {
            this.iwO = com.baidu.tbadk.core.c.a.bmx().AX("tb.forum_member_info");
        }
    }

    public byte[] JP(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bB = this.iwO != null ? this.iwO.bB(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            baD();
            this.iwO.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
