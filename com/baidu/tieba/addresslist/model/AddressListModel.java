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
    private a gml;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.gml = a.bPi();
    }

    public void a(a.InterfaceC0613a interfaceC0613a) {
        this.gml.a(interfaceC0613a);
    }

    public void b(a.InterfaceC0613a interfaceC0613a) {
        this.gml.b(interfaceC0613a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bPB() {
        return this.gml.bPj();
    }

    public void bPC() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bPy() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void ce(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gml.ca(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.gml.a(aVar);
    }

    public void eM(long j) {
        this.gml.eM(j);
    }

    public int FS(String str) {
        int i;
        if (c.Df(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bPj = this.gml.bPj();
            if (bPj != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bPj) {
                    if (str.equals(aVar.bCA())) {
                        i = bPj.indexOf(aVar);
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
