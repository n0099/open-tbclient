package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aRa;

    public a() {
        KB();
    }

    public void KB() {
        if (this.aRa == null) {
            this.aRa = com.baidu.tbadk.core.b.a.sO().cq("tb.forum_hot_thread");
        }
    }

    public byte[] gL(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> aa = this.aRa != null ? this.aRa.aa(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (aa == null || aa.sl == null) {
            return null;
        }
        return aa.sl;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            KB();
            this.aRa.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
