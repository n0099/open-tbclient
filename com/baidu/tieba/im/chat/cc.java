package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class cc implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(MsgrightView msgrightView) {
        this.f1587a = msgrightView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1587a.q;
            eVar.a(headImageView);
        }
    }
}
