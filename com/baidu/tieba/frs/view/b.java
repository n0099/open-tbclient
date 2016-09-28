package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDv;
    final /* synthetic */ ForumMemberIconView cfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.cfE = forumMemberIconView;
        this.aDv = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bh vL = bh.vL();
        TbPageContext<?> tbPageContext = this.aDv;
        str = this.cfE.mUrl;
        vL.c(tbPageContext, new String[]{str});
    }
}
