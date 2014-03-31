package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import protobuf.QueryForumDetail.QueryForumDetailRes;
/* loaded from: classes.dex */
public class ResponseOfficialBarInfoMessage extends TbSocketReponsedMessage {
    private String a;
    private String b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryForumDetailRes.QueryForumDetailResIdl parseFrom = QueryForumDetailRes.QueryForumDetailResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        this.a = parseFrom.getData().getPortrait();
        this.b = parseFrom.getData().getAuthen();
    }

    public final String d() {
        return this.a;
    }

    public final String i() {
        return this.b;
    }

    public ResponseOfficialBarInfoMessage() {
        super(208001);
        this.a = null;
        this.b = null;
    }
}
