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
    private a eRj;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eRj = a.bmX();
    }

    public void a(a.InterfaceC0507a interfaceC0507a) {
        this.eRj.a(interfaceC0507a);
    }

    public void b(a.InterfaceC0507a interfaceC0507a) {
        this.eRj.b(interfaceC0507a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bnr() {
        return this.eRj.bmY();
    }

    public void bns() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bnn() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bh(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eRj.bd(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.eRj.a(aVar);
    }

    public void da(long j) {
        this.eRj.da(j);
    }

    public int Ar(String str) {
        int i;
        if (c.xv(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bmY = this.eRj.bmY();
            if (bmY != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bmY) {
                    if (str.equals(aVar.baZ())) {
                        i = bmY.indexOf(aVar);
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
