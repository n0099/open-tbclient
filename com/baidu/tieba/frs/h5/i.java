package com.baidu.tieba.frs.h5;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fq;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements fg {
    private fi bdw;

    public void setTag(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(int i, int i2, fo foVar) {
        if (i > 100 && this.bdw != null && foVar != null && foVar.bmS != null && (foVar.bmS instanceof String)) {
            ArrayList<v> arrayList = new ArrayList<>();
            h hVar = new h((String) foVar.bmS);
            hVar.stType = foVar.stType;
            arrayList.add(hVar);
            fq fqVar = new fq();
            fqVar.hasMore = false;
            fqVar.bmU = false;
            fqVar.bmV = false;
            fqVar.pn = foVar.pn;
            fqVar.bmS = foVar.bmS;
            this.bdw.a(i, i2, fqVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(fi fiVar) {
        this.bdw = fiVar;
    }

    @Override // com.baidu.tieba.frs.fg
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fg
    public void Pa() {
    }
}
