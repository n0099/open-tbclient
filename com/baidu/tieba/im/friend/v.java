package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
final class v implements bp {
    final /* synthetic */ u a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = uVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public final boolean a(View view) {
        if (view instanceof HeadImageView) {
            HeadImageView headImageView = (HeadImageView) view;
            if (this.b.equals(headImageView.getTag())) {
                if (this.c != null) {
                    headImageView.setImageBitmap(this.c.h());
                } else {
                    headImageView.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.photo));
                }
                headImageView.invalidate();
            }
        }
        return false;
    }
}
