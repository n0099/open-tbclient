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
/* loaded from: classes7.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a ghD;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.ghD = a.bLr();
    }

    public void a(a.InterfaceC0596a interfaceC0596a) {
        this.ghD.a(interfaceC0596a);
    }

    public void b(a.InterfaceC0596a interfaceC0596a) {
        this.ghD.b(interfaceC0596a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bLK() {
        return this.ghD.bLs();
    }

    public void bLL() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bLH() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void ce(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ghD.ca(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.ghD.a(aVar);
    }

    public void eM(long j) {
        this.ghD.eM(j);
    }

    public int EG(String str) {
        int i;
        if (c.BT(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bLs = this.ghD.bLs();
            if (bLs != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bLs) {
                    if (str.equals(aVar.byH())) {
                        i = bLs.indexOf(aVar);
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
