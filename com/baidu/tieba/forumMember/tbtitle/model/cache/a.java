package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes8.dex */
public class a {
    private l<byte[]> jaF;

    public a() {
        bhY();
    }

    private void bhY() {
        if (this.jaF == null) {
            this.jaF = com.baidu.tbadk.core.c.a.btS().Bm("tb.tbtiel_level_info");
        }
    }

    public byte[] Kv(String str) {
        l.b<byte[]> by = (this.jaF == null || str == null) ? null : this.jaF.by(str);
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void m(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bhY();
            this.jaF.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
