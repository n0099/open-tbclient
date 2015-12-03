package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aWe;

    public a() {
        LW();
    }

    public void LW() {
        if (this.aWe == null) {
            this.aWe = com.baidu.tbadk.core.b.a.ts().cy("tb.forum_hot_thread");
        }
    }

    public byte[] hb(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> aa = this.aWe != null ? this.aWe.aa(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (aa == null || aa.sm == null) {
            return null;
        }
        return aa.sm;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            LW();
            this.aWe.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
