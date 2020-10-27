package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes23.dex */
public class a {
    private l<byte[]> iwO;

    public a() {
        baD();
    }

    private void baD() {
        if (this.iwO == null) {
            this.iwO = com.baidu.tbadk.core.c.a.bmx().AX("tb.tbtiel_level_info");
        }
    }

    public byte[] JP(String str) {
        l.b<byte[]> bB = (this.iwO == null || str == null) ? null : this.iwO.bB(str);
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            baD();
            this.iwO.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
