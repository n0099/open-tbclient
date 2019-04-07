package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class a {
    private l<byte[]> dfX;

    public a() {
        SK();
    }

    private void SK() {
        if (this.dfX == null) {
            this.dfX = com.baidu.tbadk.core.c.a.aaT().lv("tb.tbtiel_level_info");
        }
    }

    public byte[] uK(String str) {
        l.b<byte[]> aF = (this.dfX == null || str == null) ? null : this.dfX.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            SK();
            this.dfX.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
