package com.baidu.tieba.im.groupActivity;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.a = sVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView;
        if (aVar != null) {
            headImageView = this.a.b;
            aVar.a(headImageView);
        }
    }
}
