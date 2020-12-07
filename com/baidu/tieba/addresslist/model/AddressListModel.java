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
    private a gcS;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.gcS = a.bMP();
    }

    public void a(a.InterfaceC0622a interfaceC0622a) {
        this.gcS.a(interfaceC0622a);
    }

    public void b(a.InterfaceC0622a interfaceC0622a) {
        this.gcS.b(interfaceC0622a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bNi() {
        return this.gcS.bMQ();
    }

    public void bNj() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bNf() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bX(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gcS.bT(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.gcS.a(aVar);
    }

    public void eM(long j) {
        this.gcS.eM(j);
    }

    public int FU(String str) {
        int i;
        if (c.Dh(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bMQ = this.gcS.bMQ();
            if (bMQ != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bMQ) {
                    if (str.equals(aVar.bAg())) {
                        i = bMQ.indexOf(aVar);
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
