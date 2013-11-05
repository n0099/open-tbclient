package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ be f1433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.f1433a = beVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        String a2;
        if (eVar == null) {
            this.f1433a.a(this.f1433a.c.getString(R.string.save_error));
            return;
        }
        be beVar = this.f1433a;
        a2 = this.f1433a.a(str, eVar.h());
        beVar.a(a2);
    }
}
