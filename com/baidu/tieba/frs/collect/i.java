package com.baidu.tieba.frs.collect;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.data.z;
/* loaded from: classes.dex */
class i implements w {
    final /* synthetic */ MyCollectFrsActivity bkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MyCollectFrsActivity myCollectFrsActivity) {
        this.bkc = myCollectFrsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5;
        l lVar;
        if (bdUniqueId == null || (uVar instanceof com.baidu.tbadk.core.data.b)) {
            return false;
        }
        if (uVar instanceof z) {
            this.bkc.bka = (z) uVar;
            zVar = this.bkc.bka;
            if (zVar.isPhotoLiveThread()) {
                return true;
            }
            zVar2 = this.bkc.bka;
            if (zVar2 instanceof t) {
                return true;
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bkc;
            zVar3 = this.bkc.bka;
            myCollectFrsActivity.bjV = zVar3.getId();
            zVar4 = this.bkc.bka;
            String sx = zVar4.sx();
            if (sx == null || sx.equals("")) {
                this.bkc.bkb = false;
            } else {
                this.bkc.bkb = true;
            }
            MyCollectFrsActivity myCollectFrsActivity2 = this.bkc;
            zVar5 = this.bkc.bka;
            myCollectFrsActivity2.c(zVar5);
            lVar = this.bkc.bjX;
            lVar.NT();
            return true;
        }
        return true;
    }
}
