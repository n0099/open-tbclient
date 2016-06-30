package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext azW;
    final /* synthetic */ ForumMemberIconView bSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.bSz = forumMemberIconView;
        this.azW = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bi us = bi.us();
        TbPageContext<?> tbPageContext = this.azW;
        str = this.bSz.mUrl;
        us.c(tbPageContext, new String[]{str});
    }
}
