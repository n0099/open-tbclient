package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aCn;
    final /* synthetic */ ForumMemberIconView bpX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.bpX = forumMemberIconView;
        this.aCn = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        be wt = be.wt();
        TbPageContext<?> tbPageContext = this.aCn;
        str = this.bpX.mUrl;
        wt.c(tbPageContext, new String[]{str});
    }
}
