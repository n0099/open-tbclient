package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bj f1569a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.f1569a = bjVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        String a2;
        if (eVar == null) {
            this.f1569a.a(this.f1569a.c.getString(R.string.save_error));
            return;
        }
        bj bjVar = this.f1569a;
        a2 = this.f1569a.a(str, eVar.i());
        bjVar.a(a2);
    }
}
