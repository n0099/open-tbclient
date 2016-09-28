package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aMc;

    public a() {
        aal();
    }

    public void aal() {
        if (this.aMc == null) {
            this.aMc = com.baidu.tbadk.core.b.a.ti().cz("tb.forum_hot_thread");
        }
    }

    public byte[] jJ(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.c<byte[]> T = this.aMc != null ? this.aMc.T(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (T == null || T.lo == null) {
            return null;
        }
        return T.lo;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aal();
            this.aMc.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
