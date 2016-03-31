package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDl;
    final /* synthetic */ ForumMemberIconView buZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.buZ = forumMemberIconView;
        this.aDl = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bg wM = bg.wM();
        TbPageContext<?> tbPageContext = this.aDl;
        str = this.buZ.mUrl;
        wM.c(tbPageContext, new String[]{str});
    }
}
