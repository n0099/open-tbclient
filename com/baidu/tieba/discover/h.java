package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ d bJp;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.bJp = dVar;
        this.bJq = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.ao(this.bJq.linkUrl);
        k.showToast(this.bJp.ajh.getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
