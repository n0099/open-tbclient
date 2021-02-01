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
    private a gjR;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.gjR = a.bLL();
    }

    public void a(a.InterfaceC0593a interfaceC0593a) {
        this.gjR.a(interfaceC0593a);
    }

    public void b(a.InterfaceC0593a interfaceC0593a) {
        this.gjR.b(interfaceC0593a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bMe() {
        return this.gjR.bLM();
    }

    public void bMf() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bMb() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bZ(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gjR.bV(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.gjR.a(aVar);
    }

    public void eS(long j) {
        this.gjR.eS(j);
    }

    public int Fe(String str) {
        int i;
        if (c.Ck(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bLM = this.gjR.bLM();
            if (bLM != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bLM) {
                    if (str.equals(aVar.byZ())) {
                        i = bLM.indexOf(aVar);
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
