package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aRq;

    public a() {
        XS();
    }

    public void XS() {
        if (this.aRq == null) {
            this.aRq = com.baidu.tbadk.core.c.a.to().ct("tb.forum_hot_thread");
        }
    }

    public byte[] iy(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.c<byte[]> S = this.aRq != null ? this.aRq.S(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (S == null || S.te == null) {
            return null;
        }
        return S.te;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            XS();
            this.aRq.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
