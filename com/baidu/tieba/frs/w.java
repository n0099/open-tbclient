package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
class w implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        if (bdUniqueId == null) {
            return false;
        }
        if (vVar instanceof com.baidu.tbadk.core.data.bg) {
            com.baidu.tbadk.core.data.bg bgVar = (com.baidu.tbadk.core.data.bg) vVar;
            if (!bgVar.isPhotoLiveThread() && !(bgVar instanceof com.baidu.tbadk.core.data.au)) {
                if ((bgVar instanceof com.baidu.tbadk.core.data.c) && ((com.baidu.tbadk.core.data.c) bgVar).Py != null) {
                    return false;
                }
                this.bzl.mThreadId = bgVar.getId();
                String rM = bgVar.rM();
                if (rM == null || rM.equals("")) {
                    this.bzl.bye = false;
                } else {
                    this.bzl.bye = true;
                }
                this.bzl.m(bgVar);
                this.bzl.byg.Xh();
            }
        }
        return true;
    }
}
