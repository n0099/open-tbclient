package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class cl implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ MsgrightView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(MsgrightView msgrightView) {
        this.a = msgrightView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.a.r;
            eVar.a(headImageView);
        }
    }
}
