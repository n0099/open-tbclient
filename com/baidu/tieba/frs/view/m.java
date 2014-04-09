package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.ag;
import com.baidu.tbadk.core.data.FrsPostListData;
import com.baidu.tbadk.core.data.MetaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements View.OnClickListener {
    final /* synthetic */ FrsReplyView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsReplyView frsReplyView) {
        this.a = frsReplyView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FrsPostListData frsPostListData;
        Context context;
        frsPostListData = this.a.e;
        MetaData author = frsPostListData.getAuthor();
        if (author != null) {
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            context = this.a.a;
            a.a(new com.baidu.adp.framework.message.a(2001003, new ag(context, author.getUserId(), author.getName_show())));
        }
    }
}
