package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i bUL;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.e bUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, com.baidu.tieba.enterForum.b.e eVar) {
        this.bUL = iVar;
        this.bUM = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        ViewEventCenter viewEventCenter4;
        viewEventCenter = this.bUL.bSq;
        if (viewEventCenter != null) {
            switch (this.bUM.getType()) {
                case 0:
                    viewEventCenter4 = this.bUL.bSq;
                    viewEventCenter4.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bUM, null, null));
                    return;
                case 1:
                    viewEventCenter3 = this.bUL.bSq;
                    viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                    return;
                case 2:
                default:
                    return;
                case 3:
                    viewEventCenter2 = this.bUL.bSq;
                    viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, this.bUM, null, null));
                    return;
            }
        }
    }
}
