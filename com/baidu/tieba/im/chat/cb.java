package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageShaderView;
/* loaded from: classes.dex */
final class cb implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageShaderView headImageShaderView;
        if (bVar != null) {
            headImageShaderView = this.a.q;
            bVar.a(headImageShaderView.getHeadImageView());
        }
    }
}
