package com.baidu.tieba.im.groupCard;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ GroupCardActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GroupCardActivity groupCardActivity) {
        this.a = groupCardActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        dVar = this.a.d;
        dVar.e();
        if (bVar == null) {
            dVar4 = this.a.d;
            dVar4.a(0, this.a.getString(R.string.group_card_error));
            return;
        }
        this.a.i = bVar.h();
        dVar2 = this.a.d;
        dVar2.a(bVar);
        dVar3 = this.a.d;
        dVar3.f();
    }
}
