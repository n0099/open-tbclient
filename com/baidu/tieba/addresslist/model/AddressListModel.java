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
    private a fuH;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fuH = a.bCK();
    }

    public void a(a.InterfaceC0567a interfaceC0567a) {
        this.fuH.a(interfaceC0567a);
    }

    public void b(a.InterfaceC0567a interfaceC0567a) {
        this.fuH.b(interfaceC0567a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bDd() {
        return this.fuH.bCL();
    }

    public void bDe() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bDa() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bA(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fuH.bw(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.fuH.a(aVar);
    }

    public void dC(long j) {
        this.fuH.dC(j);
    }

    public int En(String str) {
        int i;
        if (c.BH(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bCL = this.fuH.bCL();
            if (bCL != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bCL) {
                    if (str.equals(aVar.bqo())) {
                        i = bCL.indexOf(aVar);
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
