package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aIi;
    final /* synthetic */ ForumMemberIconView ceJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.ceJ = forumMemberIconView;
        this.aIi = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bb wn = bb.wn();
        TbPageContext<?> tbPageContext = this.aIi;
        str = this.ceJ.mUrl;
        wn.c(tbPageContext, new String[]{str});
    }
}
