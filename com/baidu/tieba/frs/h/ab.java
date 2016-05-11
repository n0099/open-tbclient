package com.baidu.tieba.frs.h;

import com.baidu.tieba.frs.fi;
import com.baidu.tieba.frs.fq;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ab implements fi {
    final /* synthetic */ aa buH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.buH = aaVar;
    }

    @Override // com.baidu.tieba.frs.fi
    public void a(int i, int i2, fq fqVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.h.h.dL().post(new ac(this));
    }
}
