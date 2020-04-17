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
    private a eCu;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eCu = a.bgM();
    }

    public void a(a.InterfaceC0439a interfaceC0439a) {
        this.eCu.a(interfaceC0439a);
    }

    public void b(a.InterfaceC0439a interfaceC0439a) {
        this.eCu.b(interfaceC0439a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bhg() {
        return this.eCu.bgN();
    }

    public void bhh() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bhc() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bm(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eCu.bi(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.eCu.a(aVar);
    }

    public void cY(long j) {
        this.eCu.cY(j);
    }

    public int yI(String str) {
        int i;
        if (c.vM(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bgN = this.eCu.bgN();
            if (bgN != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bgN) {
                    if (str.equals(aVar.aUQ())) {
                        i = bgN.indexOf(aVar);
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
