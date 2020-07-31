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
/* loaded from: classes15.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a ffW;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.ffW = a.bsA();
    }

    public void a(a.InterfaceC0525a interfaceC0525a) {
        this.ffW.a(interfaceC0525a);
    }

    public void b(a.InterfaceC0525a interfaceC0525a) {
        this.ffW.b(interfaceC0525a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bsU() {
        return this.ffW.bsB();
    }

    public void bsV() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bsQ() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bv(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ffW.br(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.ffW.a(aVar);
    }

    public void dq(long j) {
        this.ffW.dq(j);
    }

    public int Bv(String str) {
        int i;
        if (c.yU(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bsB = this.ffW.bsB();
            if (bsB != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bsB) {
                    if (str.equals(aVar.bgI())) {
                        i = bsB.indexOf(aVar);
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
