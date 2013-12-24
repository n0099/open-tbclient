package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (eVar != null) {
            headImageView = this.a.f;
            headImageView.setImageResource(0);
            headImageView2 = this.a.f;
            eVar.a(headImageView2);
        }
    }
}
