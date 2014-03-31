package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.view.HeadImageShaderView;
/* loaded from: classes.dex */
final class cv implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ MsgrightView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(MsgrightView msgrightView) {
        this.a = msgrightView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageShaderView headImageShaderView;
        if (bVar != null) {
            headImageShaderView = this.a.t;
            bVar.a(headImageShaderView.getHeadImageView());
        }
    }
}
