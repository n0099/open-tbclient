package com.baidu.tieba.im.friend;

import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ r a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, r rVar) {
        this.b = oVar;
        this.a = rVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        HeadImageView headImageView = this.a.b;
        if (headImageView != null) {
            if (dVar != null) {
                headImageView.setImageBitmap(dVar.h());
            } else {
                headImageView.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
            }
            headImageView.invalidate();
        }
    }
}
