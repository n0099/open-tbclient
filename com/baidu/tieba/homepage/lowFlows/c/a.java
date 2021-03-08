package com.baidu.tieba.homepage.lowFlows.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.homepage.lowFlows.a;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements a.b {
    private a.c kjG;
    private a.InterfaceC0753a kjH = new com.baidu.tieba.homepage.lowFlows.b.a(this);

    public a(a.c cVar) {
        this.kjG = cVar;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean b(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (this.kjH != null) {
            return this.kjH.a(bdUniqueId, str, str2, str3);
        }
        return false;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean a(int i, com.baidu.tieba.homepage.lowFlows.message.a aVar) {
        if (aVar == null || this.kjG == null) {
            return false;
        }
        this.kjG.setData(aVar.getDataList());
        return true;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public boolean BW(int i) {
        if (this.kjG != null) {
            this.kjG.BX(i);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.b
    public void setData(List<n> list) {
        if (this.kjG != null) {
            this.kjG.setData(list);
        }
    }
}
