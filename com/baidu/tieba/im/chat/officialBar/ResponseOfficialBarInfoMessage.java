package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.QueryForumDetail.QueryForumDetailResIdl;
/* loaded from: classes.dex */
public class ResponseOfficialBarInfoMessage extends TbSocketReponsedMessage {
    private String authen;
    private String portrait;

    public String getPortrait() {
        return this.portrait;
    }

    private void setPortrait(String str) {
        this.portrait = str;
    }

    public String getAuthen() {
        return this.authen;
    }

    public void setAuthen(String str) {
        this.authen = str;
    }

    public ResponseOfficialBarInfoMessage() {
        super(MessageTypes.CMD_QUERY_OFFICIAL_BAR_INFO);
        this.portrait = null;
        this.authen = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryForumDetailResIdl queryForumDetailResIdl = (QueryForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryForumDetailResIdl.class);
        setError(queryForumDetailResIdl.error.errorno.intValue());
        setErrorString(queryForumDetailResIdl.error.usermsg);
        setPortrait(queryForumDetailResIdl.data.portrait);
        setAuthen(queryForumDetailResIdl.data.authen);
    }
}
