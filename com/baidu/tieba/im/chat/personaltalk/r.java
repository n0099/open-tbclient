package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
final class r implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
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
