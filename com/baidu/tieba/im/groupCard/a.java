package com.baidu.tieba.im.groupCard;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ GroupCardActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GroupCardActivity groupCardActivity) {
        this.a = groupCardActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        dVar2 = this.a.d;
        dVar2.e();
        if (dVar == null) {
            dVar5 = this.a.d;
            dVar5.a(0, this.a.getString(R.string.group_card_error));
            return;
        }
        this.a.i = dVar.h();
        dVar3 = this.a.d;
        dVar3.a(dVar);
        dVar4 = this.a.d;
        dVar4.f();
    }
}
