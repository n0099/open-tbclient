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
/* loaded from: classes8.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a ecd;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.ecd = a.aYB();
    }

    public void a(a.InterfaceC0408a interfaceC0408a) {
        this.ecd.a(interfaceC0408a);
    }

    public void b(a.InterfaceC0408a interfaceC0408a) {
        this.ecd.b(interfaceC0408a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aYV() {
        return this.ecd.aYC();
    }

    public void aYW() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void aYR() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bc(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ecd.aY(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.ecd.a(aVar);
    }

    public void cr(long j) {
        this.ecd.cr(j);
    }

    public int xu(String str) {
        int i;
        if (c.ux(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aYC = this.ecd.aYC();
            if (aYC != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aYC) {
                    if (str.equals(aVar.aMm())) {
                        i = aYC.indexOf(aVar);
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
