package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aRL;
    private final long aRM = TbConfig.APP_OVERDUR_DRAFT_BOX;

    public a() {
        Ku();
    }

    public void Ku() {
        if (this.aRL == null) {
            this.aRL = com.baidu.tbadk.core.b.a.sR().cp("tb.forum_hot_thread");
        }
    }

    public byte[] gG(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> ac = this.aRL != null ? this.aRL.ac(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ac == null || ac.sl == null) {
            return null;
        }
        return ac.sl;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Ku();
            this.aRL.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
