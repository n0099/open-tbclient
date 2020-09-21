package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.u;
import tbclient.RedNotify.DataReq;
import tbclient.RedNotify.RedNotifyReqIdl;
/* loaded from: classes21.dex */
public class CheckRedNotifyReqMessage extends NetMessage {
    public boolean reqUnreadTipAfterFinish;

    public CheckRedNotifyReqMessage() {
        super(1003344, CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY);
        this.reqUnreadTipAfterFinish = false;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                u.a(builder, true);
            }
            RedNotifyReqIdl.Builder builder2 = new RedNotifyReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
