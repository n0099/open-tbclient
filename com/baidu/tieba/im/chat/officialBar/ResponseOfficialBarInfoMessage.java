package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.QueryForumDetail.DataRes;
import protobuf.QueryForumDetail.QueryForumDetailResIdl;
/* loaded from: classes3.dex */
public class ResponseOfficialBarInfoMessage extends TbSocketReponsedMessage {
    public String authen;
    public String portrait;

    public ResponseOfficialBarInfoMessage() {
        super(208001);
        this.portrait = null;
        this.authen = null;
    }

    public String getAuthen() {
        return this.authen;
    }

    public String getPortrait() {
        return this.portrait;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryForumDetailResIdl queryForumDetailResIdl = (QueryForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryForumDetailResIdl.class);
        setError(queryForumDetailResIdl.error.errorno.intValue());
        setErrorString(queryForumDetailResIdl.error.usermsg);
        DataRes dataRes = queryForumDetailResIdl.data;
        this.portrait = dataRes.portrait;
        this.authen = dataRes.authen;
    }
}
