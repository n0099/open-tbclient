package com.baidu.tieba.channel.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.channel.data.d;
import com.squareup.wire.Wire;
import tbclient.GetChannelInfo.GetChannelInfoResIdl;
/* loaded from: classes6.dex */
public class ChannelInfoGetSocketResponseMessage extends SocketResponsedMessage {
    private d channelHomeData;

    public ChannelInfoGetSocketResponseMessage() {
        super(309437);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetChannelInfoResIdl getChannelInfoResIdl = (GetChannelInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetChannelInfoResIdl.class);
        if (getChannelInfoResIdl != null) {
            if (getChannelInfoResIdl.error != null) {
                setError(getChannelInfoResIdl.error.errorno.intValue());
                setErrorString(getChannelInfoResIdl.error.errmsg);
            }
            if (getChannelInfoResIdl.data != null && getChannelInfoResIdl.data != null) {
                this.channelHomeData = d.a(getChannelInfoResIdl.data);
            }
        }
    }

    public d getData() {
        return this.channelHomeData;
    }
}
