package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aEn;
    final /* synthetic */ ForumMemberIconView ckH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.ckH = forumMemberIconView;
        this.aEn = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bf vP = bf.vP();
        TbPageContext<?> tbPageContext = this.aEn;
        str = this.ckH.mUrl;
        vP.c(tbPageContext, new String[]{str});
    }
}
