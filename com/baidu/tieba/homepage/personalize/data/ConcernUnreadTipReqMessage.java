package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.r;
import tbclient.UnreadTip.DataReq;
import tbclient.UnreadTip.UnreadTipReqIdl;
/* loaded from: classes4.dex */
public class ConcernUnreadTipReqMessage extends NetMessage {
    public ConcernUnreadTipReqMessage() {
        super(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                r.a(builder, true);
            }
            UnreadTipReqIdl.Builder builder2 = new UnreadTipReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
