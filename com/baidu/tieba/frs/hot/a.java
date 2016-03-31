package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> bhe;

    public a() {
        PX();
    }

    public void PX() {
        if (this.bhe == null) {
            this.bhe = com.baidu.tbadk.core.b.a.um().cy("tb.forum_hot_thread");
        }
    }

    public byte[] hC(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> Z = this.bhe != null ? this.bhe.Z(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (Z == null || Z.sI == null) {
            return null;
        }
        return Z.sI;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            PX();
            this.bhe.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
