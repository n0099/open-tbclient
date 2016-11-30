package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
class s implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        if (bdUniqueId == null) {
            return false;
        }
        if (vVar instanceof com.baidu.tbadk.core.data.bk) {
            com.baidu.tbadk.core.data.bk bkVar = (com.baidu.tbadk.core.data.bk) vVar;
            if (!bkVar.isPhotoLiveThread() && !(bkVar instanceof com.baidu.tbadk.core.data.av)) {
                if ((bkVar instanceof com.baidu.tbadk.core.data.c) && ((com.baidu.tbadk.core.data.c) bkVar).PC != null) {
                    return false;
                }
                this.bTa.mThreadId = bkVar.getId();
                String rV = bkVar.rV();
                if (rV == null || rV.equals("")) {
                    this.bTa.bRU = false;
                } else {
                    this.bTa.bRU = true;
                }
                this.bTa.h(bkVar);
                this.bTa.bRW.acR();
            }
        }
        return true;
    }
}
