package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageShaderView;
/* loaded from: classes.dex */
class cj implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ MsgrightView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(MsgrightView msgrightView) {
        this.a = msgrightView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageShaderView headImageShaderView;
        if (bVar != null) {
            headImageShaderView = this.a.s;
            bVar.a(headImageShaderView.getHeadImageView());
        }
    }
}
