package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aNn;

    public a() {
        abn();
    }

    public void abn() {
        if (this.aNn == null) {
            this.aNn = com.baidu.tbadk.core.b.a.tm().cB("tb.forum_hot_thread");
        }
    }

    public byte[] jN(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.c<byte[]> T = this.aNn != null ? this.aNn.T(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (T == null || T.lp == null) {
            return null;
        }
        return T.lp;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            abn();
            this.aNn.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
