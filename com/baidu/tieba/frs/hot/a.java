package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aQH;
    private final long aQI = TbConfig.APP_OVERDUR_DRAFT_BOX;

    public a() {
        Kp();
    }

    public void Kp() {
        if (this.aQH == null) {
            this.aQH = com.baidu.tbadk.core.b.a.sO().cp("tb.forum_hot_thread");
        }
    }

    public byte[] gJ(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> ac = this.aQH != null ? this.aQH.ac(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ac == null || ac.sl == null) {
            return null;
        }
        return ac.sl;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Kp();
            this.aQH.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
