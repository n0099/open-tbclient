package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
class v implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        if (bdUniqueId == null) {
            return false;
        }
        if (vVar instanceof com.baidu.tbadk.core.data.bi) {
            com.baidu.tbadk.core.data.bi biVar = (com.baidu.tbadk.core.data.bi) vVar;
            if (!biVar.isPhotoLiveThread() && !(biVar instanceof com.baidu.tbadk.core.data.aw)) {
                if ((biVar instanceof AdvertAppInfo) && ((AdvertAppInfo) biVar).legoCard != null) {
                    return false;
                }
                this.bNJ.mThreadId = biVar.getId();
                String sv = biVar.sv();
                if (sv == null || sv.equals("")) {
                    this.bNJ.bMB = false;
                } else {
                    this.bNJ.bMB = true;
                }
                this.bNJ.q(biVar);
                this.bNJ.bMD.ZT();
            }
        }
        return true;
    }
}
