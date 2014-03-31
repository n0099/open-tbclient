package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public class ResponseQueryGroupCountMessage extends TbSocketReponsedMessage {
    private int a;
    private int b;
    private String c;
    private String d;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryGroupCountRes.QueryGroupCountResIdl parseFrom = QueryGroupCountRes.QueryGroupCountResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.b = parseFrom.getData().getLocalGroupCount();
            this.a = parseFrom.getData().getUserGroupCount();
            this.d = parseFrom.getData().getBanner().getPicUrl();
            this.c = parseFrom.getData().getBanner().getLink();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.baidu.adp.framework.message.f
    public final /* synthetic */ void b(int i, byte[] bArr) {
        a(com.baidu.tbadk.core.c.b.a().t(), "p_enter_forum_group_info", bArr);
    }

    public ResponseQueryGroupCountMessage() {
        super(103011);
    }

    public ResponseQueryGroupCountMessage(int i) {
        super(i);
    }

    public final String d() {
        return this.c;
    }

    public final String i() {
        return this.d;
    }

    public final int j() {
        return this.a;
    }

    public final int k() {
        return this.b;
    }
}
