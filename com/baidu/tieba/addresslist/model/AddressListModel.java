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
    private a fGQ;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fGQ = a.bFw();
    }

    public void a(a.InterfaceC0584a interfaceC0584a) {
        this.fGQ.a(interfaceC0584a);
    }

    public void b(a.InterfaceC0584a interfaceC0584a) {
        this.fGQ.b(interfaceC0584a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bFP() {
        return this.fGQ.bFx();
    }

    public void bFQ() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bFM() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bD(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fGQ.bz(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.fGQ.a(aVar);
    }

    public void dL(long j) {
        this.fGQ.dL(j);
    }

    public int EY(String str) {
        int i;
        if (c.Ct(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bFx = this.fGQ.bFx();
            if (bFx != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bFx) {
                    if (str.equals(aVar.bsY())) {
                        i = bFx.indexOf(aVar);
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
