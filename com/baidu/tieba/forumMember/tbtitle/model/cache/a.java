package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class a {
    private l<byte[]> gUe;

    public a() {
        aDl();
    }

    private void aDl() {
        if (this.gUe == null) {
            this.gUe = com.baidu.tbadk.core.c.a.aMR().uf("tb.tbtiel_level_info");
        }
    }

    public byte[] CJ(String str) {
        l.b<byte[]> bs = (this.gUe == null || str == null) ? null : this.gUe.bs(str);
        if (bs == null || bs.value == null) {
            return null;
        }
        return bs.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aDl();
            this.gUe.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
