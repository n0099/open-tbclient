package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import com.baidu.tbadk.core.util.br;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class bf implements br {
    final /* synthetic */ be a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = beVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        if ((view instanceof TbImageView) && this.b.equals(view.getTag())) {
            view.setTag(null);
            TbImageView tbImageView = (TbImageView) view;
            tbImageView.f();
            this.c.a(tbImageView);
            return false;
        }
        return false;
    }
}
