package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
final class dj implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ dh a;
    private final /* synthetic */ HeadImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(dh dhVar, HeadImageView headImageView) {
        this.a = dhVar;
        this.b = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            bVar.a(this.b);
        } else {
            this.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo));
        }
    }
}
