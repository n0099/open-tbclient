package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDS;
    final /* synthetic */ ForumMemberIconView cfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumMemberIconView forumMemberIconView, TbPageContext tbPageContext) {
        this.cfH = forumMemberIconView;
        this.aDS = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bi vx = bi.vx();
        TbPageContext<?> tbPageContext = this.aDS;
        str = this.cfH.mUrl;
        vx.c(tbPageContext, new String[]{str});
    }
}
