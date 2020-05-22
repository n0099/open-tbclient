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
    private a eQY;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eQY = a.bmV();
    }

    public void a(a.InterfaceC0507a interfaceC0507a) {
        this.eQY.a(interfaceC0507a);
    }

    public void b(a.InterfaceC0507a interfaceC0507a) {
        this.eQY.b(interfaceC0507a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bnp() {
        return this.eQY.bmW();
    }

    public void bnq() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bnl() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bh(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eQY.bd(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.eQY.a(aVar);
    }

    public void da(long j) {
        this.eQY.da(j);
    }

    public int Ar(String str) {
        int i;
        if (c.xv(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bmW = this.eQY.bmW();
            if (bmW != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bmW) {
                    if (str.equals(aVar.baY())) {
                        i = bmW.indexOf(aVar);
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
