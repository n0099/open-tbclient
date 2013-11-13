package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.widget.ImageView.BDImageView2;
/* loaded from: classes.dex */
class ae implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BDImageView2 f1684a;
    final /* synthetic */ PhotoWallView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PhotoWallView photoWallView, BDImageView2 bDImageView2) {
        this.b = photoWallView;
        this.f1684a = bDImageView2;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            eVar.a(this.f1684a);
        }
    }
}
