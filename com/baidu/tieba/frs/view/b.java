package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aCz;
    final /* synthetic */ ForumMemberIconView bWw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.bWw = forumMemberIconView;
        this.aCz = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        ba vt = ba.vt();
        TbPageContext<?> tbPageContext = this.aCz;
        str = this.bWw.mUrl;
        vt.c(tbPageContext, new String[]{str});
    }
}
