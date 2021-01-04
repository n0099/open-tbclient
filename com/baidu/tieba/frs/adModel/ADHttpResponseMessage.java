package com.baidu.tieba.frs.adModel;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.frs.ad.c;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetADList.GetADListResIdl;
/* loaded from: classes2.dex */
public class ADHttpResponseMessage extends TbHttpResponsedMessage {
    private int has_more;
    List<c> list;
    private long offset;

    public ADHttpResponseMessage(int i) {
        super(i);
        this.list = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetADListResIdl getADListResIdl;
        if (bArr != null && (getADListResIdl = (GetADListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetADListResIdl.class)) != null) {
            if (getADListResIdl.error != null && getADListResIdl.error.errorno != null) {
                setError(getADListResIdl.error.errorno.intValue());
            }
            if (getADListResIdl.error != null && getADListResIdl.error.usermsg != null && getADListResIdl.error.usermsg.length() > 0) {
                setErrorString(getADListResIdl.error.usermsg);
            }
            if (getADListResIdl.data != null) {
                for (int i2 = 0; i2 < getADListResIdl.data.ad_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(getADListResIdl.data.ad_list.get(i2));
                    if (getADListResIdl.data.ad_list.size() - 1 == i2) {
                        cVar.qN(true);
                    } else {
                        cVar.qN(false);
                    }
                    if (cVar.cHE() == 0 || cVar.cHE() == 2) {
                        this.list.add(cVar);
                    }
                }
                this.has_more = getADListResIdl.data.has_more.intValue();
                this.offset = getADListResIdl.data.offset.longValue();
            }
        }
    }

    public List<c> getList() {
        return this.list;
    }

    public int getHas_more() {
        return this.has_more;
    }

    public long getOffset() {
        return this.offset;
    }
}
