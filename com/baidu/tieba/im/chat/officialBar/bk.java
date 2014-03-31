package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class bk implements bp {
    final /* synthetic */ bj a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = bjVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public final boolean a(View view) {
        if ((view instanceof TbImageView) && this.b.equals(view.getTag())) {
            view.setTag(null);
            TbImageView tbImageView = (TbImageView) view;
            tbImageView.a();
            this.c.a(tbImageView);
            return false;
        }
        return false;
    }
}
