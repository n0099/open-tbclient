package com.baidu.tieba.homepage.lowFlows.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.homepage.lowFlows.a;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements a.b {
    private a.c khD;
    private a.InterfaceC0747a khE = new com.baidu.tieba.homepage.lowFlows.b.a(this);

    public a(a.c cVar) {
        this.khD = cVar;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean b(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (this.khE != null) {
            return this.khE.a(bdUniqueId, str, str2, str3);
        }
        return false;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean a(int i, com.baidu.tieba.homepage.lowFlows.message.a aVar) {
        if (aVar == null || this.khD == null) {
            return false;
        }
        this.khD.setData(aVar.getDataList());
        return true;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean BT(int i) {
        if (this.khD != null) {
            this.khD.BU(i);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public void setData(List<n> list) {
        if (this.khD != null) {
            this.khD.setData(list);
        }
    }
}
