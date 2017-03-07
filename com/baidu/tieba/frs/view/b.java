package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aHR;
    final /* synthetic */ ForumMemberIconView cdR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.cdR = forumMemberIconView;
        this.aHR = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bb vQ = bb.vQ();
        TbPageContext<?> tbPageContext = this.aHR;
        str = this.cdR.mUrl;
        vQ.c(tbPageContext, new String[]{str});
    }
}
