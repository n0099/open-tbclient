package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageShaderView;
/* loaded from: classes.dex */
class az implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        HeadImageShaderView headImageShaderView;
        if (dVar != null) {
            headImageShaderView = this.a.q;
            dVar.a(headImageShaderView.getHeadImageView());
        }
    }
}
