package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.view.HeadImageShaderView;
/* loaded from: classes.dex */
final class co implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageShaderView headImageShaderView;
        if (bVar != null) {
            headImageShaderView = this.a.r;
            bVar.a(headImageShaderView.getHeadImageView());
        }
    }
}
