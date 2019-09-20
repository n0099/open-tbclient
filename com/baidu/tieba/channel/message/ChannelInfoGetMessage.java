package com.baidu.tieba.channel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.GetChannelInfo.DataReq;
import tbclient.GetChannelInfo.GetChannelInfoReqIdl;
/* loaded from: classes6.dex */
public class ChannelInfoGetMessage extends NetMessage {
    private long channelId;
    private int pn;
    private int ps;

    public ChannelInfoGetMessage(long j, int i, int i2) {
        super(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437);
        this.channelId = j;
        this.pn = i;
        this.ps = i2;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.channel_id = Long.valueOf(this.channelId);
        builder.pn = Integer.valueOf(this.pn);
        builder.ps = Integer.valueOf(this.ps);
        if (z) {
            r.bindCommonParamsToProtobufData(builder, true);
        }
        GetChannelInfoReqIdl.Builder builder2 = new GetChannelInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getPn() {
        return this.pn;
    }
}
