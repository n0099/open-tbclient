package com.baidu.tieba.frs.adModel;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.o0.r0.h1.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetADList.GetADListResIdl;
/* loaded from: classes4.dex */
public class ADHttpResponseMessage extends TbHttpResponsedMessage {
    public int has_more;
    public List<c> list;
    public long offset;

    public ADHttpResponseMessage(int i2) {
        super(i2);
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
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
        for (int i3 = 0; i3 < getADListResIdl.data.ad_list.size(); i3++) {
            c cVar = new c();
            cVar.t(getADListResIdl.data.ad_list.get(i3));
            if (getADListResIdl.data.ad_list.size() - 1 == i3) {
                cVar.w(true);
            } else {
                cVar.w(false);
            }
            if (cVar.q() == 0 || cVar.q() == 2) {
                this.list.add(cVar);
            }
        }
        this.has_more = getADListResIdl.data.has_more.intValue();
        this.offset = getADListResIdl.data.offset.longValue();
    }
}
