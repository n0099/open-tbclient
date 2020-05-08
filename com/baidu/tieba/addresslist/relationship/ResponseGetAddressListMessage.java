package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import tbclient.GetAddressList.GetAddressListResIdl;
/* loaded from: classes8.dex */
public class ResponseGetAddressListMessage extends SocketResponsedMessage {
    private a mAddressListData;

    public void setAddressListData(a aVar) {
        this.mAddressListData = aVar;
    }

    public a getAddressListData() {
        return this.mAddressListData;
    }

    public ResponseGetAddressListMessage() {
        super(CmdConfigSocket.CMD_GET_ADDRESSLIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetAddressListResIdl getAddressListResIdl = (GetAddressListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetAddressListResIdl.class);
        if (getAddressListResIdl != null) {
            if (getAddressListResIdl.data != null) {
                this.mAddressListData = new a();
                if (this.mAddressListData.a(getAddressListResIdl.data)) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), true);
                }
            }
            if (getAddressListResIdl.error != null) {
                setError(getAddressListResIdl.error.errorno.intValue());
                setErrorString(getAddressListResIdl.error.errmsg);
            }
        }
    }
}
