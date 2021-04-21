package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.RedNotify.DataReq;
import tbclient.RedNotify.RedNotifyReqIdl;
/* loaded from: classes4.dex */
public class CheckRedNotifyReqMessage extends NetMessage {
    public boolean reqUnreadTipAfterFinish;

    public CheckRedNotifyReqMessage() {
        super(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, 309476);
        this.reqUnreadTipAfterFinish = false;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                w.a(builder, true);
            }
            RedNotifyReqIdl.Builder builder2 = new RedNotifyReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }
}
