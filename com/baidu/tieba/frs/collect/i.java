package com.baidu.tieba.frs.collect;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.x;
/* loaded from: classes.dex */
class i implements w {
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MyCollectFrsActivity myCollectFrsActivity) {
        this.bmY = myCollectFrsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        ah ahVar4;
        ah ahVar5;
        l lVar;
        if (bdUniqueId == null || (uVar instanceof com.baidu.tbadk.core.data.c)) {
            return false;
        }
        if (uVar instanceof ah) {
            this.bmY.bmW = (ah) uVar;
            ahVar = this.bmY.bmW;
            if (ahVar.isPhotoLiveThread()) {
                return true;
            }
            ahVar2 = this.bmY.bmW;
            if (ahVar2 instanceof x) {
                return true;
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bmY;
            ahVar3 = this.bmY.bmW;
            myCollectFrsActivity.bmR = ahVar3.getId();
            ahVar4 = this.bmY.bmW;
            String tq = ahVar4.tq();
            if (tq == null || tq.equals("")) {
                this.bmY.bmX = false;
            } else {
                this.bmY.bmX = true;
            }
            MyCollectFrsActivity myCollectFrsActivity2 = this.bmY;
            ahVar5 = this.bmY.bmW;
            myCollectFrsActivity2.c(ahVar5);
            lVar = this.bmY.bmT;
            lVar.PU();
            return true;
        }
        return true;
    }
}
