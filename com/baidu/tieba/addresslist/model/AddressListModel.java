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
    private a gkf;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.gkf = a.bLS();
    }

    public void a(a.InterfaceC0594a interfaceC0594a) {
        this.gkf.a(interfaceC0594a);
    }

    public void b(a.InterfaceC0594a interfaceC0594a) {
        this.gkf.b(interfaceC0594a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bMl() {
        return this.gkf.bLT();
    }

    public void bMm() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bMi() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bZ(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gkf.bV(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.gkf.a(aVar);
    }

    public void eS(long j) {
        this.gkf.eS(j);
    }

    public int Ff(String str) {
        int i;
        if (c.Ck(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bLT = this.gkf.bLT();
            if (bLT != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bLT) {
                    if (str.equals(aVar.byZ())) {
                        i = bLT.indexOf(aVar);
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
