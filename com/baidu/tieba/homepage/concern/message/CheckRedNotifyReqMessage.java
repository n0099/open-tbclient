package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.n;
import tbclient.RedNotify.DataReq;
import tbclient.RedNotify.RedNotifyReqIdl;
/* loaded from: classes.dex */
public class CheckRedNotifyReqMessage extends NetMessage {
    public CheckRedNotifyReqMessage() {
        super(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, 309476);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                n.bindCommonParamsToProtobufData(builder, true);
            }
            RedNotifyReqIdl.Builder builder2 = new RedNotifyReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
