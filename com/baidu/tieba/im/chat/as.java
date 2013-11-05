package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class as implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(MsgleftView msgleftView) {
        this.f1419a = msgleftView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1419a.n;
            eVar.a(headImageView);
        }
    }
}
