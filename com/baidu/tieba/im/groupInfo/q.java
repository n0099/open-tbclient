package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HeadImageView f1757a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar, HeadImageView headImageView) {
        this.b = mVar;
        this.f1757a = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            eVar.a(this.f1757a);
        }
    }
}
