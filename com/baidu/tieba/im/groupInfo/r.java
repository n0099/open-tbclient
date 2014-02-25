package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;
    private final /* synthetic */ HeadImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar, HeadImageView headImageView) {
        this.a = mVar;
        this.b = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            bVar.a(this.b);
        }
    }
}
