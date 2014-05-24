package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.tbadk.core.util.br;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class v implements br {
    final /* synthetic */ u a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = uVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        if (view instanceof HeadImageView) {
            HeadImageView headImageView = (HeadImageView) view;
            if (this.b.equals(headImageView.getTag())) {
                if (this.c != null) {
                    headImageView.setImageBitmap(this.c.h());
                } else {
                    headImageView.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.u.photo));
                }
                headImageView.invalidate();
            }
        }
        return false;
    }
}
