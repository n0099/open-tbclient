package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (aVar != null) {
            headImageView = this.a.f;
            headImageView.setImageResource(0);
            headImageView2 = this.a.f;
            aVar.a(headImageView2);
        }
    }
}
