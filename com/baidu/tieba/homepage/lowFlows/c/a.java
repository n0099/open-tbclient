package com.baidu.tieba.homepage.lowFlows.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.homepage.lowFlows.a;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements a.b {
    private a.c khp;
    private a.InterfaceC0746a khq = new com.baidu.tieba.homepage.lowFlows.b.a(this);

    public a(a.c cVar) {
        this.khp = cVar;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean b(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (this.khq != null) {
            return this.khq.a(bdUniqueId, str, str2, str3);
        }
        return false;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean a(int i, com.baidu.tieba.homepage.lowFlows.message.a aVar) {
        if (aVar == null || this.khp == null) {
            return false;
        }
        this.khp.setData(aVar.getDataList());
        return true;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean BT(int i) {
        if (this.khp != null) {
            this.khp.BU(i);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public void setData(List<n> list) {
        if (this.khp != null) {
            this.khp.setData(list);
        }
    }
}
