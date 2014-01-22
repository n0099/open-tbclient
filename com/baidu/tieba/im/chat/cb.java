package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageShaderView;
/* loaded from: classes.dex */
class cb implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ MsgrightView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(MsgrightView msgrightView) {
        this.a = msgrightView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        HeadImageShaderView headImageShaderView;
        if (dVar != null) {
            headImageShaderView = this.a.s;
            dVar.a(headImageShaderView.getHeadImageView());
        }
    }
}
