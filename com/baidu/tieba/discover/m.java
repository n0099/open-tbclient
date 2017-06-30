package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ e bPN;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h bPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.bPN = eVar;
        this.bPO = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.at(this.bPO.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.bPN.ajP.getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
