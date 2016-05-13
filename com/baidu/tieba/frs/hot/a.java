package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> bcU;

    public a() {
        OS();
    }

    public void OS() {
        if (this.bcU == null) {
            this.bcU = com.baidu.tbadk.core.b.a.rS().cw("tb.forum_hot_thread");
        }
    }

    public byte[] hC(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> Q = this.bcU != null ? this.bcU.Q(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (Q == null || Q.iz == null) {
            return null;
        }
        return Q.iz;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            OS();
            this.bcU.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
