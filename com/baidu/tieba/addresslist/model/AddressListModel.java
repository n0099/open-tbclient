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
/* loaded from: classes20.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a fUI;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fUI = a.bJh();
    }

    public void a(a.InterfaceC0610a interfaceC0610a) {
        this.fUI.a(interfaceC0610a);
    }

    public void b(a.InterfaceC0610a interfaceC0610a) {
        this.fUI.b(interfaceC0610a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bJA() {
        return this.fUI.bJi();
    }

    public void bJB() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bJx() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bT(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fUI.bP(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.fUI.a(aVar);
    }

    public void ej(long j) {
        this.fUI.ej(j);
    }

    public int Fg(String str) {
        int i;
        if (c.Cz(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bJi = this.fUI.bJi();
            if (bJi != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bJi) {
                    if (str.equals(aVar.bwG())) {
                        i = bJi.indexOf(aVar);
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
