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
    private a fVb;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fVb = a.bJO();
    }

    public void a(a.InterfaceC0610a interfaceC0610a) {
        this.fVb.a(interfaceC0610a);
    }

    public void b(a.InterfaceC0610a interfaceC0610a) {
        this.fVb.b(interfaceC0610a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bKh() {
        return this.fVb.bJP();
    }

    public void bKi() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bKe() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bT(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fVb.bP(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.fVb.a(aVar);
    }

    public void ej(long j) {
        this.fVb.ej(j);
    }

    public int FF(String str) {
        int i;
        if (c.Da(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bJP = this.fVb.bJP();
            if (bJP != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bJP) {
                    if (str.equals(aVar.bxq())) {
                        i = bJP.indexOf(aVar);
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
