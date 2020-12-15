package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.addresslist.b.a;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import java.util.List;
/* loaded from: classes21.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a gcU;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.gcU = a.bMQ();
    }

    public void a(a.InterfaceC0622a interfaceC0622a) {
        this.gcU.a(interfaceC0622a);
    }

    public void b(a.InterfaceC0622a interfaceC0622a) {
        this.gcU.b(interfaceC0622a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bNj() {
        return this.gcU.bMR();
    }

    public void bNk() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bNg() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bX(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gcU.bT(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.gcU.a(aVar);
    }

    public void eM(long j) {
        this.gcU.eM(j);
    }

    public int FU(String str) {
        int i;
        if (c.Dh(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bMR = this.gcU.bMR();
            if (bMR != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bMR) {
                    if (str.equals(aVar.bAg())) {
                        i = bMR.indexOf(aVar);
                        break;
                    }
                }
            }
            i = -1;
            return i;
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
