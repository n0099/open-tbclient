package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import tbclient.GetAddressList.GetAddressListResIdl;
/* loaded from: classes.dex */
public class ResponseGetAddressListMessage extends SocketResponsedMessage {
    private a mAddressListData;

    public void setAddressListData(a aVar) {
        this.mAddressListData = aVar;
    }

    public a getAddressListData() {
        return this.mAddressListData;
    }

    public ResponseGetAddressListMessage() {
        super(304001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetAddressListResIdl getAddressListResIdl = (GetAddressListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetAddressListResIdl.class);
        if (getAddressListResIdl != null) {
            if (getAddressListResIdl.data != null) {
                this.mAddressListData = new a();
                if (this.mAddressListData.a(getAddressListResIdl.data)) {
                    com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
                }
            }
            if (getAddressListResIdl.error != null) {
                setError(getAddressListResIdl.error.errorno.intValue());
                setErrorString(getAddressListResIdl.error.errmsg);
            }
        }
    }
}
