package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ br a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar) {
        this.a = brVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        String a;
        if (eVar == null) {
            this.a.a(this.a.c.getString(R.string.save_error));
            return;
        }
        br brVar = this.a;
        a = this.a.a(str, eVar.i());
        brVar.a(a);
    }
}
