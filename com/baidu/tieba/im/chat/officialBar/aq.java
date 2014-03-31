package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
final class aq implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.a = apVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        com.baidu.adp.lib.util.f.e("img load finish");
        if (bVar != null) {
            com.baidu.adp.lib.util.f.e("img load suceess");
            headImageView = this.a.e;
            bVar.a(headImageView);
        }
    }
}
