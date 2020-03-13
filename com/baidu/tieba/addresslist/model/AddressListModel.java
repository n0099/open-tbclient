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
    private a ecr;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.ecr = a.aYE();
    }

    public void a(a.InterfaceC0408a interfaceC0408a) {
        this.ecr.a(interfaceC0408a);
    }

    public void b(a.InterfaceC0408a interfaceC0408a) {
        this.ecr.b(interfaceC0408a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aYY() {
        return this.ecr.aYF();
    }

    public void aYZ() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void aYU() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bc(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ecr.aY(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.ecr.a(aVar);
    }

    public void cr(long j) {
        this.ecr.cr(j);
    }

    public int xv(String str) {
        int i;
        if (c.uy(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aYF = this.ecr.aYF();
            if (aYF != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aYF) {
                    if (str.equals(aVar.aMp())) {
                        i = aYF.indexOf(aVar);
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
