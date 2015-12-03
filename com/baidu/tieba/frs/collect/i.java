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
    final /* synthetic */ MyCollectFrsActivity bgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MyCollectFrsActivity myCollectFrsActivity) {
        this.bgk = myCollectFrsActivity;
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
            this.bgk.bgi = (z) uVar;
            zVar = this.bgk.bgi;
            if (zVar.isPhotoLiveThread()) {
                return true;
            }
            zVar2 = this.bgk.bgi;
            if (zVar2 instanceof t) {
                return true;
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bgk;
            zVar3 = this.bgk.bgi;
            myCollectFrsActivity.bgd = zVar3.getId();
            zVar4 = this.bgk.bgi;
            String sN = zVar4.sN();
            if (sN == null || sN.equals("")) {
                this.bgk.bgj = false;
            } else {
                this.bgk.bgj = true;
            }
            MyCollectFrsActivity myCollectFrsActivity2 = this.bgk;
            zVar5 = this.bgk.bgi;
            myCollectFrsActivity2.a(zVar5);
            lVar = this.bgk.bgf;
            lVar.NA();
            return true;
        }
        return true;
    }
}
