package com.baidu.tieba.homepage.daily.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.DailyPage.DailyPageReqIdl;
import tbclient.DailyPage.DataReq;
/* loaded from: classes4.dex */
public class DailyPageRequetMessage extends NetMessage {
    public int pn;
    public int rn;

    public DailyPageRequetMessage() {
        super(CmdConfigHttp.CMD_DAILY_PAGE, 309617);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = Integer.valueOf(this.rn);
            if (z) {
                r.bindCommonParamsToProtobufData(builder, true);
            }
            DailyPageReqIdl.Builder builder2 = new DailyPageReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
