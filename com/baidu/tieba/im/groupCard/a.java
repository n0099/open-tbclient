package com.baidu.tieba.im.groupCard;

import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GroupCardActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GroupCardActivity groupCardActivity) {
        this.a = groupCardActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        super.a((a) aVar, str, i);
        dVar = this.a.d;
        dVar.b();
        if (aVar == null) {
            dVar4 = this.a.d;
            dVar4.a(0, this.a.getString(x.group_card_error));
            return;
        }
        dVar2 = this.a.d;
        dVar2.a(aVar);
        dVar3 = this.a.d;
        dVar3.c();
    }
}
