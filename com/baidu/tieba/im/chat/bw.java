package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class bw implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(MsgrightView msgrightView) {
        this.f1542a = msgrightView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1542a.p;
            eVar.a(headImageView);
        }
    }
}
