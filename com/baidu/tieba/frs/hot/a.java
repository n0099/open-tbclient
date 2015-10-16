package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aQS;
    private final long aQT = TbConfig.APP_OVERDUR_DRAFT_BOX;

    public a() {
        Kp();
    }

    public void Kp() {
        if (this.aQS == null) {
            this.aQS = com.baidu.tbadk.core.b.a.sO().cq("tb.forum_hot_thread");
        }
    }

    public byte[] gJ(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> ac = this.aQS != null ? this.aQS.ac(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ac == null || ac.sl == null) {
            return null;
        }
        return ac.sl;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Kp();
            this.aQS.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
