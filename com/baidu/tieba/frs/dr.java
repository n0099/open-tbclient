package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class dr implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ dp a;
    private final /* synthetic */ HeadImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dp dpVar, HeadImageView headImageView) {
        this.a = dpVar;
        this.b = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            aVar.a(this.b);
        } else {
            this.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.photo));
        }
    }
}
