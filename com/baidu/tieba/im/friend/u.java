package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.tbadk.core.util.bz;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class u implements bz {
    final /* synthetic */ t a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = tVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.bz
    public boolean a(View view) {
        if (view instanceof HeadImageView) {
            HeadImageView headImageView = (HeadImageView) view;
            if (!(headImageView.getTag() instanceof com.baidu.tbadk.coreExtra.relationship.b) ? this.b.equals(headImageView.getTag()) : this.b.equals(((com.baidu.tbadk.coreExtra.relationship.b) headImageView.getTag()).d())) {
                if (this.c != null) {
                    headImageView.setImageBitmap(this.c.h());
                } else {
                    headImageView.setImageBitmap(com.baidu.tbadk.core.util.h.a(com.baidu.tieba.u.photo));
                }
                headImageView.invalidate();
            }
        }
        return false;
    }
}
