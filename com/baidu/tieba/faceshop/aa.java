package com.baidu.tieba.faceshop;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.a = xVar;
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
