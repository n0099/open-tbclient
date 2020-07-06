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
    private a fbu;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fbu = a.bpy();
    }

    public void a(a.InterfaceC0515a interfaceC0515a) {
        this.fbu.a(interfaceC0515a);
    }

    public void b(a.InterfaceC0515a interfaceC0515a) {
        this.fbu.b(interfaceC0515a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bpS() {
        return this.fbu.bpz();
    }

    public void bpT() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bpO() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void br(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fbu.bn(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.fbu.a(aVar);
    }

    public void dc(long j) {
        this.fbu.dc(j);
    }

    public int AK(String str) {
        int i;
        if (c.xO(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bpz = this.fbu.bpz();
            if (bpz != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bpz) {
                    if (str.equals(aVar.bdb())) {
                        i = bpz.indexOf(aVar);
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
