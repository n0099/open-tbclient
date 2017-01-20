package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aLF;

    public a() {
        WU();
    }

    public void WU() {
        if (this.aLF == null) {
            this.aLF = com.baidu.tbadk.core.c.a.sR().cA("tb.forum_hot_thread");
        }
    }

    public byte[] iI(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.c<byte[]> T = this.aLF != null ? this.aLF.T(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (T == null || T.lj == null) {
            return null;
        }
        return T.lj;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            WU();
            this.aLF.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
