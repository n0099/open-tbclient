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
    private a frq;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.frq = a.bBx();
    }

    public void a(a.InterfaceC0571a interfaceC0571a) {
        this.frq.a(interfaceC0571a);
    }

    public void b(a.InterfaceC0571a interfaceC0571a) {
        this.frq.b(interfaceC0571a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bBQ() {
        return this.frq.bBy();
    }

    public void bBR() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bBN() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bv(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.frq.br(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.frq.a(aVar);
    }

    public void dB(long j) {
        this.frq.dB(j);
    }

    public int DP(String str) {
        int i;
        if (c.Bk(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bBy = this.frq.bBy();
            if (bBy != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bBy) {
                    if (str.equals(aVar.bpt())) {
                        i = bBy.indexOf(aVar);
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
