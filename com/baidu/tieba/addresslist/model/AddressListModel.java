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
/* loaded from: classes5.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a dXQ;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dXQ = a.aVT();
    }

    public void a(a.InterfaceC0395a interfaceC0395a) {
        this.dXQ.a(interfaceC0395a);
    }

    public void b(a.InterfaceC0395a interfaceC0395a) {
        this.dXQ.b(interfaceC0395a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aWm() {
        return this.dXQ.aVU();
    }

    public void aWn() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void aWi() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bd(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dXQ.aZ(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.dXQ.a(aVar);
    }

    public void ci(long j) {
        this.dXQ.ci(j);
    }

    public int wW(String str) {
        int i;
        if (c.ub(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aVU = this.dXQ.aVU();
            if (aVU != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aVU) {
                    if (str.equals(aVar.aJy())) {
                        i = aVU.indexOf(aVar);
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
