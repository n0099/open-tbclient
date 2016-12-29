package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDH;
    final /* synthetic */ ForumMemberIconView bPR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.bPR = forumMemberIconView;
        this.aDH = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bc vz = bc.vz();
        TbPageContext<?> tbPageContext = this.aDH;
        str = this.bPR.mUrl;
        vz.c(tbPageContext, new String[]{str});
    }
}
