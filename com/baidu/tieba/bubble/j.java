package com.baidu.tieba.bubble;

import android.app.Activity;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ Activity Fu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Activity activity) {
        this.Fu = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.core.j.l(this.Fu, "remind_expired");
    }
}
