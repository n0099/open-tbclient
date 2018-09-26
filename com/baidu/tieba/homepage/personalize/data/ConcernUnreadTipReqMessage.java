package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.p;
import tbclient.UnreadTip.DataReq;
import tbclient.UnreadTip.UnreadTipReqIdl;
/* loaded from: classes2.dex */
public class ConcernUnreadTipReqMessage extends NetMessage {
    public ConcernUnreadTipReqMessage() {
        super(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                p.bindCommonParamsToProtobufData(builder, true);
            }
            UnreadTipReqIdl.Builder builder2 = new UnreadTipReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
