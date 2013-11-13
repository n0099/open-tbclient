package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class ar implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(MsgleftView msgleftView) {
        this.f1511a = msgleftView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1511a.n;
            eVar.a(headImageView);
        }
    }
}
