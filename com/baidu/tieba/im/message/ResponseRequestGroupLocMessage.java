package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
public class ResponseRequestGroupLocMessage extends SocketResponsedMessage {
    private String a;
    private List<String> b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryGroupLocationRes.QueryGroupLocationResIdl parseFrom = QueryGroupLocationRes.QueryGroupLocationResIdl.parseFrom((byte[]) obj);
        QueryGroupLocationRes.DataRes data = parseFrom.getData();
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        int businessCount = data.getBusinessCount();
        for (int i2 = 0; i2 < businessCount; i2++) {
            String business = data.getBusiness(i2);
            if (business != null && !business.equals("") && !this.b.contains(business)) {
                this.b.add(business);
            }
        }
    }

    public ResponseRequestGroupLocMessage() {
        super(103010);
        this.a = "";
        this.b = new ArrayList();
    }

    public final String d() {
        return this.a;
    }

    public final Iterator<String> i() {
        return this.b.iterator();
    }
}
