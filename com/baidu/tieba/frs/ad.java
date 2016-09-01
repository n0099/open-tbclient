package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.b;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.bg bgVar;
        com.baidu.tbadk.core.data.bg bgVar2;
        com.baidu.tbadk.core.data.bg bgVar3;
        com.baidu.tbadk.core.data.bg bgVar4;
        com.baidu.tbadk.core.data.bg bgVar5;
        com.baidu.tbadk.core.data.bg bgVar6;
        bm bmVar;
        com.baidu.tbadk.core.data.bg bgVar7;
        if (bdUniqueId == null) {
            return false;
        }
        if (vVar instanceof com.baidu.tbadk.core.data.bg) {
            this.bQp.bPs = (com.baidu.tbadk.core.data.bg) vVar;
            bgVar = this.bQp.bPs;
            if (!bgVar.isPhotoLiveThread()) {
                bgVar2 = this.bQp.bPs;
                if (!(bgVar2 instanceof com.baidu.tbadk.core.data.ar)) {
                    bgVar3 = this.bQp.bPs;
                    if (bgVar3 instanceof b) {
                        bgVar7 = this.bQp.bPs;
                        if (((b) bgVar7).Pp != null) {
                            return false;
                        }
                    }
                    FrsActivity frsActivity = this.bQp;
                    bgVar4 = this.bQp.bPs;
                    frsActivity.mThreadId = bgVar4.getId();
                    bgVar5 = this.bQp.bPs;
                    String rH = bgVar5.rH();
                    if (rH == null || rH.equals("")) {
                        this.bQp.bPm = false;
                    } else {
                        this.bQp.bPm = true;
                    }
                    FrsActivity frsActivity2 = this.bQp;
                    bgVar6 = this.bQp.bPs;
                    frsActivity2.d(bgVar6);
                    bmVar = this.bQp.bPo;
                    bmVar.abw();
                }
            }
        }
        return true;
    }
}
