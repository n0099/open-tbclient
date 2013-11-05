package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class bx implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(MsgrightView msgrightView) {
        this.f1450a = msgrightView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1450a.p;
            eVar.a(headImageView);
        }
    }
}
