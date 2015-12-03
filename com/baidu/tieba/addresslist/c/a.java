package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.addresslist.b.a;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<BaseFragmentActivity> {
    private com.baidu.tieba.addresslist.b.a aJY;

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.aJY = com.baidu.tieba.addresslist.b.a.Hi();
    }

    public void a(a.InterfaceC0059a interfaceC0059a) {
        this.aJY.a(interfaceC0059a);
    }

    public void b(a.InterfaceC0059a interfaceC0059a) {
        this.aJY.b(interfaceC0059a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> HI() {
        return this.aJY.Hj();
    }

    public void HJ() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void Hx() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void A(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aJY.w(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.aJY.a(aVar);
    }

    public void ag(long j) {
        this.aJY.ag(j);
    }

    public int gy(String str) {
        int i;
        if (c.ey(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Hj = this.aJY.Hj();
            if (Hj != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Hj) {
                    if (str.equals(aVar.zv())) {
                        i = Hj.indexOf(aVar);
                        break;
                    }
                }
            }
            i = -1;
            return i;
        }
        return -1;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
