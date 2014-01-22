package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (dVar != null) {
            headImageView = this.a.f;
            headImageView.setImageResource(0);
            headImageView2 = this.a.f;
            dVar.a(headImageView2);
        }
    }
}
