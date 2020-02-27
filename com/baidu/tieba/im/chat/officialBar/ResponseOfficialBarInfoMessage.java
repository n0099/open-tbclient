package com.baidu.tieba.im.chat.officialBar;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.QueryForumDetail.QueryForumDetailResIdl;
/* loaded from: classes13.dex */
public class ResponseOfficialBarInfoMessage extends TbSocketReponsedMessage {
    private String authen;
    private String portrait;

    public String getPortrait() {
        return this.portrait;
    }

    public String getAuthen() {
        return this.authen;
    }

    public ResponseOfficialBarInfoMessage() {
        super(CmdConfigSocket.CMD_QUERY_OFFICIAL_BAR_INFO);
        this.portrait = null;
        this.authen = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryForumDetailResIdl queryForumDetailResIdl = (QueryForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryForumDetailResIdl.class);
        setError(queryForumDetailResIdl.error.errorno.intValue());
        setErrorString(queryForumDetailResIdl.error.usermsg);
        this.portrait = queryForumDetailResIdl.data.portrait;
        this.authen = queryForumDetailResIdl.data.authen;
    }
}
