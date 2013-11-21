package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HeadImageView f1691a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar, HeadImageView headImageView) {
        this.b = nVar;
        this.f1691a = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            eVar.a(this.f1691a);
        }
    }
}
