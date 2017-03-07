package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
class v implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        if (bdUniqueId == null) {
            return false;
        }
        if (vVar instanceof com.baidu.tbadk.core.data.bj) {
            com.baidu.tbadk.core.data.bj bjVar = (com.baidu.tbadk.core.data.bj) vVar;
            if (!bjVar.isPhotoLiveThread() && !(bjVar instanceof com.baidu.tbadk.core.data.ax)) {
                if ((bjVar instanceof AdvertAppInfo) && ((AdvertAppInfo) bjVar).legoCard != null) {
                    return false;
                }
                this.bNU.mThreadId = bjVar.getId();
                String rX = bjVar.rX();
                if (rX == null || rX.equals("")) {
                    this.bNU.bML = false;
                } else {
                    this.bNU.bML = true;
                }
                this.bNU.q(bjVar);
                this.bNU.bMN.Zv();
            }
        }
        return true;
    }
}
