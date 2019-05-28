package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class h {
    public static boolean get = false;

    public static DataRes bux() {
        l<byte[]> bD = com.baidu.tbadk.core.c.a.afD().bD("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount());
        if (bD == null) {
            return null;
        }
        byte[] bArr = bD.get("0");
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
        } catch (IOException e) {
            BdLog.e(e);
            return null;
        }
    }

    public static void buy() {
        l<byte[]> bD = com.baidu.tbadk.core.c.a.afD().bD("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount());
        if (bD != null) {
            bD.a("0", new byte[0], 0L);
        }
    }

    public static boolean g(ResponsedMessage responsedMessage) {
        if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RecPersonalizeRequest)) {
            return false;
        }
        return ((RecPersonalizeRequest) responsedMessage.getOrginalMessage().getExtra()).getLoadType() == 2;
    }
}
