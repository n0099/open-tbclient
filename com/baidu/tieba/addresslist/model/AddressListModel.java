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
    private a glI;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.glI = a.bLW();
    }

    public void a(a.InterfaceC0600a interfaceC0600a) {
        this.glI.a(interfaceC0600a);
    }

    public void b(a.InterfaceC0600a interfaceC0600a) {
        this.glI.b(interfaceC0600a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bMp() {
        return this.glI.bLX();
    }

    public void bMq() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bMm() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bZ(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.glI.bV(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.glI.a(aVar);
    }

    public void eS(long j) {
        this.glI.eS(j);
    }

    public int Fm(String str) {
        int i;
        if (c.Cr(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bLX = this.glI.bLX();
            if (bLX != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bLX) {
                    if (str.equals(aVar.bzc())) {
                        i = bLX.indexOf(aVar);
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
