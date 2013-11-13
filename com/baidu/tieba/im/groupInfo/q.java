package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1699a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.f1699a = nVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1699a.q;
            eVar.a(headImageView);
        }
    }
}
