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
/* loaded from: classes3.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a dkh;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dkh = a.aEa();
    }

    public void a(a.InterfaceC0309a interfaceC0309a) {
        this.dkh.a(interfaceC0309a);
    }

    public void b(a.InterfaceC0309a interfaceC0309a) {
        this.dkh.b(interfaceC0309a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aEt() {
        return this.dkh.aEb();
    }

    public void aEu() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void aEp() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void aW(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dkh.aS(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.dkh.a(aVar);
    }

    public void bG(long j) {
        this.dkh.bG(j);
    }

    public int rQ(String str) {
        int i;
        if (c.oX(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aEb = this.dkh.aEb();
            if (aEb != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aEb) {
                    if (str.equals(aVar.arZ())) {
                        i = aEb.indexOf(aVar);
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
