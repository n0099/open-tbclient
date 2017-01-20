package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
class v implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        if (bdUniqueId == null) {
            return false;
        }
        if (vVar instanceof com.baidu.tbadk.core.data.bh) {
            com.baidu.tbadk.core.data.bh bhVar = (com.baidu.tbadk.core.data.bh) vVar;
            if (!bhVar.isPhotoLiveThread() && !(bhVar instanceof com.baidu.tbadk.core.data.av)) {
                if ((bhVar instanceof com.baidu.tbadk.core.data.c) && ((com.baidu.tbadk.core.data.c) bhVar).legoCard != null) {
                    return false;
                }
                this.bGL.mThreadId = bhVar.getId();
                String rD = bhVar.rD();
                if (rD == null || rD.equals("")) {
                    this.bGL.bFD = false;
                } else {
                    this.bGL.bFD = true;
                }
                this.bGL.q(bhVar);
                this.bGL.bFF.Yw();
            }
        }
        return true;
    }
}
