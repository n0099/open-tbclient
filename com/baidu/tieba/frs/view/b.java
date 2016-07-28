package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aAL;
    final /* synthetic */ ForumMemberIconView bUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.bUz = forumMemberIconView;
        this.aAL = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bi us = bi.us();
        TbPageContext<?> tbPageContext = this.aAL;
        str = this.bUz.mUrl;
        us.c(tbPageContext, new String[]{str});
    }
}
