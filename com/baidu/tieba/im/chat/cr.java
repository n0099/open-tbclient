package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ cq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cq cqVar) {
        this.a = cqVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        String a;
        if (bVar != null) {
            cq cqVar = this.a;
            a = this.a.a(str, bVar.k());
            cqVar.a(a);
            return;
        }
        this.a.a(this.a.b.getString(R.string.save_error));
    }
}
