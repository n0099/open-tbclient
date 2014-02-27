package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
final class q implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (bVar != null) {
            headImageView = this.a.f;
            headImageView.setImageResource(0);
            headImageView2 = this.a.f;
            bVar.a(headImageView2);
        }
    }
}
