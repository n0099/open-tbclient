package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bCM;

    public d() {
        auH();
    }

    public void auH() {
        if (this.bCM == null) {
            this.bCM = com.baidu.tbadk.core.c.a.yh().dP("tb.bawu_team_info");
        }
    }

    public byte[] mL(String str) {
        l.b<byte[]> aF = (this.bCM == null || str == null) ? null : this.bCM.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            auH();
            this.bCM.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
