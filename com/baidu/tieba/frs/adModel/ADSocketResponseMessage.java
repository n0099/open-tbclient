package com.baidu.tieba.frs.adModel;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.j0.q0.h1.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetADList.GetADListResIdl;
/* loaded from: classes4.dex */
public class ADSocketResponseMessage extends SocketResponsedMessage {
    public int has_more;
    public List<c> list;
    public long offset;

    public ADSocketResponseMessage() {
        super(309611);
        this.list = new ArrayList();
    }

    public int getHas_more() {
        return this.has_more;
    }

    public List<c> getList() {
        return this.list;
    }

    public long getOffset() {
        return this.offset;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetADListResIdl getADListResIdl;
        String str;
        Integer num;
        if (bArr == null || (getADListResIdl = (GetADListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetADListResIdl.class)) == null) {
            return;
        }
        Error error = getADListResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = getADListResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(getADListResIdl.error.usermsg);
        }
        if (getADListResIdl.data == null) {
            return;
        }
        for (int i2 = 0; i2 < getADListResIdl.data.ad_list.size(); i2++) {
            c cVar = new c();
            cVar.v(getADListResIdl.data.ad_list.get(i2));
            if (getADListResIdl.data.ad_list.size() - 1 == i2) {
                cVar.w(true);
            } else {
                cVar.w(false);
            }
            if (cVar.u() == 0 || cVar.u() == 2) {
                this.list.add(cVar);
            }
        }
        this.has_more = getADListResIdl.data.has_more.intValue();
        this.offset = getADListResIdl.data.offset.longValue();
    }
}
