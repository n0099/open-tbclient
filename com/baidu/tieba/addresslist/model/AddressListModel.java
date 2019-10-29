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
    private a dkY;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dkY = a.aEc();
    }

    public void a(a.InterfaceC0314a interfaceC0314a) {
        this.dkY.a(interfaceC0314a);
    }

    public void b(a.InterfaceC0314a interfaceC0314a) {
        this.dkY.b(interfaceC0314a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aEv() {
        return this.dkY.aEd();
    }

    public void aEw() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void aEr() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void aW(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dkY.aS(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.dkY.a(aVar);
    }

    public void bH(long j) {
        this.dkY.bH(j);
    }

    public int rQ(String str) {
        int i;
        if (c.oX(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aEd = this.dkY.aEd();
            if (aEd != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aEd) {
                    if (str.equals(aVar.asb())) {
                        i = aEd.indexOf(aVar);
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
