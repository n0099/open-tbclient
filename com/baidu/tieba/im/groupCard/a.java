package com.baidu.tieba.im.groupCard;

import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GroupCardActivity aZD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GroupCardActivity groupCardActivity) {
        this.aZD = groupCardActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        super.a((a) aVar, str, i);
        dVar = this.aZD.aZz;
        dVar.hideProgress();
        if (aVar == null) {
            dVar4 = this.aZD.aZz;
            dVar4.showErr(0, this.aZD.getString(y.group_card_error));
            return;
        }
        dVar2 = this.aZD.aZz;
        dVar2.f(aVar);
        dVar3 = this.aZD.aZz;
        dVar3.Os();
    }
}
