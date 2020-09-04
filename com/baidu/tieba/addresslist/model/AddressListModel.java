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
    private a frv;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.frv = a.bBy();
    }

    public void a(a.InterfaceC0571a interfaceC0571a) {
        this.frv.a(interfaceC0571a);
    }

    public void b(a.InterfaceC0571a interfaceC0571a) {
        this.frv.b(interfaceC0571a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bBR() {
        return this.frv.bBz();
    }

    public void bBS() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bBO() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bv(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.frv.br(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.frv.a(aVar);
    }

    public void dB(long j) {
        this.frv.dB(j);
    }

    public int DQ(String str) {
        int i;
        if (c.Bl(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bBz = this.frv.bBz();
            if (bBz != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bBz) {
                    if (str.equals(aVar.bpu())) {
                        i = bBz.indexOf(aVar);
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
