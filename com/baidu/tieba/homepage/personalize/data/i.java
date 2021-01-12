package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class i {
    public static boolean kdn = false;

    public static DataRes cPF() {
        l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount());
        if (dK == null) {
            return null;
        }
        byte[] bArr = dK.get("0");
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

    public static void cPG() {
        l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount());
        if (dK != null) {
            dK.set("0", new byte[0], 0L);
        }
    }

    public static boolean g(ResponsedMessage responsedMessage) {
        if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RecPersonalizeRequest)) {
            return false;
        }
        return ((RecPersonalizeRequest) responsedMessage.getOrginalMessage().getExtra()).getLoadType() == 2;
    }
}
