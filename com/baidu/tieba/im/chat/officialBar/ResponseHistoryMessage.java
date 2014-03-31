package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryHistoryMsg.QueryHistoryMsgRes;
/* loaded from: classes.dex */
public class ResponseHistoryMessage extends TbSocketReponsedMessage {
    private int a;
    private List<bf> b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        byte[] bArr = (byte[]) obj;
        QueryHistoryMsgRes.QueryHistoryMsgResIdl parseFrom = QueryHistoryMsgRes.QueryHistoryMsgResIdl.parseFrom(bArr);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        this.a = parseFrom.getData().getTotal();
        for (QueryHistoryMsgRes.MsgInfo msgInfo : parseFrom.getData().getResList()) {
            bf bfVar = new bf();
            if (msgInfo != null) {
                Date date = new Date();
                date.setTime(msgInfo.getSendTime() * 1000);
                bfVar.a = com.baidu.tbadk.core.util.bc.c(date);
                bfVar.b = msgInfo.getType();
                bfVar.c = msgInfo.getContent();
                bfVar.d = msgInfo.getId();
                com.baidu.adp.lib.util.f.e("history:item:" + bfVar.d);
                this.b.add(bfVar);
            }
        }
        if (this.b.isEmpty()) {
            return;
        }
        com.baidu.adp.lib.cache.s<byte[]> z = com.baidu.tbadk.core.c.b.a().z();
        bc bcVar = (bc) h();
        if (bcVar == null || bcVar.j() != 0) {
            return;
        }
        z.a(String.valueOf(TbadkApplication.E()) + "@" + String.valueOf(bcVar.i()), bArr);
    }

    public final List<bf> d() {
        return this.b;
    }

    public ResponseHistoryMessage() {
        super(208002);
        this.a = 0;
        this.b = new LinkedList();
    }
}
