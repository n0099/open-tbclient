package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import d.b.i0.r.d0.b;
import d.b.j0.q.f.a;
import tbclient.Error;
import tbclient.GetAddressList.GetAddressListResIdl;
/* loaded from: classes4.dex */
public class ResponseGetAddressListMessage extends SocketResponsedMessage {
    public a mAddressListData;

    public ResponseGetAddressListMessage() {
        super(304001);
    }

    public a getAddressListData() {
        return this.mAddressListData;
    }

    public void setAddressListData(a aVar) {
        this.mAddressListData = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetAddressListResIdl getAddressListResIdl = (GetAddressListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetAddressListResIdl.class);
        if (getAddressListResIdl != null) {
            if (getAddressListResIdl.data != null) {
                a aVar = new a();
                this.mAddressListData = aVar;
                if (aVar.c(getAddressListResIdl.data)) {
                    b j = b.j();
                    j.t("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
                }
            }
            Error error = getAddressListResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getAddressListResIdl.error.errmsg);
            }
        }
    }
}
