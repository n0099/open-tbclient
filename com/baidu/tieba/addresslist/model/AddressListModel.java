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
/* loaded from: classes6.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a dXZ;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dXZ = a.aWm();
    }

    public void a(a.InterfaceC0397a interfaceC0397a) {
        this.dXZ.a(interfaceC0397a);
    }

    public void b(a.InterfaceC0397a interfaceC0397a) {
        this.dXZ.b(interfaceC0397a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aWG() {
        return this.dXZ.aWn();
    }

    public void aWH() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void aWC() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bc(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dXZ.aY(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.dXZ.a(aVar);
    }

    public void cn(long j) {
        this.dXZ.cn(j);
    }

    public int xa(String str) {
        int i;
        if (c.ug(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aWn = this.dXZ.aWn();
            if (aWn != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aWn) {
                    if (str.equals(aVar.aJS())) {
                        i = aWn.indexOf(aVar);
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
