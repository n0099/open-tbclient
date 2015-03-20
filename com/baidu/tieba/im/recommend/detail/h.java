package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes.dex */
public class h implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        UserInfoBigVip userInfoBigVip;
        if (customMessage == null || !(customMessage.getData() instanceof Integer)) {
            return new CustomResponsedMessage<>(2001313, null);
        }
        int intValue = ((Integer) customMessage.getData()).intValue();
        t<byte[]> bW = com.baidu.tbadk.core.b.a.rc().bW("tb.im_recommend_detail");
        if (bW == null) {
            return new CustomResponsedMessage<>(2001313, null);
        }
        byte[] bArr = bW.get(new StringBuilder(String.valueOf(intValue)).toString());
        if (bArr == null) {
            return new CustomResponsedMessage<>(2001313, null);
        }
        try {
            userInfoBigVip = ((BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class)).data.user_info;
        } catch (Exception e) {
            BdLog.e(e);
            userInfoBigVip = null;
        }
        return new CustomResponsedMessage<>(2001313, userInfoBigVip);
    }
}
