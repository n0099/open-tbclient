package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.df;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements db {
    private dc aRO;

    @Override // com.baidu.tieba.frs.db
    public void a(int i, int i2, de deVar) {
        if (i > 100 && this.aRO != null && deVar != null && deVar.aYH != null && (deVar.aYH instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            arrayList.add(new g((String) deVar.aYH));
            df dfVar = new df();
            dfVar.hasMore = false;
            dfVar.aYI = false;
            dfVar.aYJ = false;
            dfVar.pn = deVar.pn;
            dfVar.aYH = deVar.aYH;
            this.aRO.a(i, i2, dfVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.db
    public void a(dc dcVar) {
        this.aRO = dcVar;
    }

    @Override // com.baidu.tieba.frs.db
    public void init() {
    }

    @Override // com.baidu.tieba.frs.db
    public void KL() {
    }
}
