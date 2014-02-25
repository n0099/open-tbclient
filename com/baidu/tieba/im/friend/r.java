package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.tieba.util.cj;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class r implements cj {
    final /* synthetic */ q a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = qVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tieba.util.cj
    public boolean a(View view) {
        if (view instanceof HeadImageView) {
            HeadImageView headImageView = (HeadImageView) view;
            if (this.b.equals(headImageView.getTag())) {
                if (this.c != null) {
                    headImageView.setImageBitmap(this.c.h());
                } else {
                    headImageView.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
                }
                headImageView.invalidate();
            }
        }
        return false;
    }
}
