package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        UserInfoBigVip userInfoBigVip;
        if (customMessage == null || !(customMessage.getData() instanceof Long)) {
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_RECOMMEND_DETAIL, null);
        }
        long longValue = ((Long) customMessage.getData()).longValue();
        l<byte[]> nk = com.baidu.tbadk.core.d.a.akL().nk("tb.im_recommend_detail");
        if (nk == null) {
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_RECOMMEND_DETAIL, null);
        }
        byte[] bArr = nk.get(longValue + "");
        if (bArr == null) {
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_RECOMMEND_DETAIL, null);
        }
        try {
            userInfoBigVip = ((BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class)).data.user_info;
        } catch (Exception e) {
            BdLog.e(e);
            userInfoBigVip = null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_RECOMMEND_DETAIL, userInfoBigVip);
    }
}
