package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ds implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ dq a;
    private final /* synthetic */ HeadImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dq dqVar, HeadImageView headImageView) {
        this.a = dqVar;
        this.b = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            aVar.a(this.b);
        } else {
            this.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.u.photo));
        }
    }
}
