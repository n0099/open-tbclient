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
    private a eCz;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eCz = a.bgK();
    }

    public void a(a.InterfaceC0460a interfaceC0460a) {
        this.eCz.a(interfaceC0460a);
    }

    public void b(a.InterfaceC0460a interfaceC0460a) {
        this.eCz.b(interfaceC0460a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bhe() {
        return this.eCz.bgL();
    }

    public void bhf() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bha() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bm(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eCz.bi(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.eCz.a(aVar);
    }

    public void cY(long j) {
        this.eCz.cY(j);
    }

    public int yL(String str) {
        int i;
        if (c.vP(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bgL = this.eCz.bgL();
            if (bgL != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bgL) {
                    if (str.equals(aVar.aUO())) {
                        i = bgL.indexOf(aVar);
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
