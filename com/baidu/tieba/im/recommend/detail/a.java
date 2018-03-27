package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        UserInfoBigVip userInfoBigVip;
        if (customMessage == null || !(customMessage.getData() instanceof Long)) {
            return new CustomResponsedMessage<>(2001306, null);
        }
        long longValue = ((Long) customMessage.getData()).longValue();
        l<byte[]> dg = com.baidu.tbadk.core.c.a.AR().dg("tb.im_recommend_detail");
        if (dg == null) {
            return new CustomResponsedMessage<>(2001306, null);
        }
        byte[] bArr = dg.get(longValue + "");
        if (bArr == null) {
            return new CustomResponsedMessage<>(2001306, null);
        }
        try {
            userInfoBigVip = ((BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class)).data.user_info;
        } catch (Exception e) {
            BdLog.e(e);
            userInfoBigVip = null;
        }
        return new CustomResponsedMessage<>(2001306, userInfoBigVip);
    }
}
