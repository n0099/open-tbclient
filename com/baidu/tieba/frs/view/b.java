package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext azf;
    final /* synthetic */ ForumMemberIconView buO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.buO = forumMemberIconView;
        this.azf = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bg ut = bg.ut();
        TbPageContext<?> tbPageContext = this.azf;
        str = this.buO.mUrl;
        ut.c(tbPageContext, new String[]{str});
    }
}
