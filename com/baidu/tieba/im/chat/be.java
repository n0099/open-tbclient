package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bd f1516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.f1516a = bdVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        String a2;
        if (eVar == null) {
            this.f1516a.a(this.f1516a.c.getString(R.string.save_error));
            return;
        }
        bd bdVar = this.f1516a;
        a2 = this.f1516a.a(str, eVar.i());
        bdVar.a(a2);
    }
}
