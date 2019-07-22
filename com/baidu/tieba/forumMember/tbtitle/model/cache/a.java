package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class a {
    private l<byte[]> dsK;

    public a() {
        Xr();
    }

    private void Xr() {
        if (this.dsK == null) {
            this.dsK = com.baidu.tbadk.core.d.a.agF().mK("tb.tbtiel_level_info");
        }
    }

    public byte[] wI(String str) {
        l.b<byte[]> aq = (this.dsK == null || str == null) ? null : this.dsK.aq(str);
        if (aq == null || aq.value == null) {
            return null;
        }
        return aq.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Xr();
            this.dsK.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
