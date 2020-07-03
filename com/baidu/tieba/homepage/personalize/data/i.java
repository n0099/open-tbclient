package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class i {
    public static boolean iuY = false;

    public static DataRes ckb() {
        l<byte[]> dc = com.baidu.tbadk.core.c.a.aUM().dc("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount());
        if (dc == null) {
            return null;
        }
        byte[] bArr = dc.get("0");
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

    public static void ckc() {
        l<byte[]> dc = com.baidu.tbadk.core.c.a.aUM().dc("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount());
        if (dc != null) {
            dc.set("0", new byte[0], 0L);
        }
    }

    public static boolean g(ResponsedMessage responsedMessage) {
        if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RecPersonalizeRequest)) {
            return false;
        }
        return ((RecPersonalizeRequest) responsedMessage.getOrginalMessage().getExtra()).getLoadType() == 2;
    }
}
