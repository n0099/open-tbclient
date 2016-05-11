package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext azg;
    final /* synthetic */ ForumMemberIconView buO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.buO = forumMemberIconView;
        this.azg = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bg us = bg.us();
        TbPageContext<?> tbPageContext = this.azg;
        str = this.buO.mUrl;
        us.c(tbPageContext, new String[]{str});
    }
}
