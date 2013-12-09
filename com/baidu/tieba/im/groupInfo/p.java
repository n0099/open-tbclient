package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1757a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.f1757a = mVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1757a.r;
            eVar.a(headImageView);
        }
    }
}
