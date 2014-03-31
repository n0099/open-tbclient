package com.baidu.tieba.faceshop;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ap implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.a = amVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        TbImageView tbImageView;
        if (bVar != null) {
            tbImageView = this.a.f;
            tbImageView.invalidate();
        }
    }
}
