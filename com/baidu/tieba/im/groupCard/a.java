package com.baidu.tieba.im.groupCard;

import com.baidu.adp.widget.ImageView.e;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupCardActivity f1662a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GroupCardActivity groupCardActivity) {
        this.f1662a = groupCardActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(e eVar, String str, boolean z) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        dVar = this.f1662a.d;
        dVar.e();
        if (eVar == null) {
            dVar4 = this.f1662a.d;
            dVar4.a(0, this.f1662a.getString(R.string.group_card_error));
            return;
        }
        this.f1662a.i = eVar.f();
        dVar2 = this.f1662a.d;
        dVar2.a(eVar);
        dVar3 = this.f1662a.d;
        dVar3.f();
    }
}
