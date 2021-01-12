package com.baidu.tieba.ala.live.c;

import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pay.channel.PayChannelManager;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
/* loaded from: classes10.dex */
public class c {
    public static a c(BaseActivity baseActivity) {
        return (TbadkCoreApplication.getInst().isMobileBaidu() && PayChannelManager.getInstance().isPayChannelAvaliable(PayChannelType.NUOMI)) ? new b(baseActivity) : new d(baseActivity);
    }
}
