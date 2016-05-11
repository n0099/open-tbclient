package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnLongClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w aXG;
    final /* synthetic */ o aZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.aZj = oVar;
        this.aXG = wVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aZj.aXs;
        if (viewEventCenter == null || this.aXG.getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.aZj.aXs;
        i = this.aZj.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
    }
}
