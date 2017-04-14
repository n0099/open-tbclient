package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aIg;
    final /* synthetic */ ForumMemberIconView ccs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.ccs = forumMemberIconView;
        this.aIg = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bb wn = bb.wn();
        TbPageContext<?> tbPageContext = this.aIg;
        str = this.ccs.mUrl;
        wn.c(tbPageContext, new String[]{str});
    }
}
