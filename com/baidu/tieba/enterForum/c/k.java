package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ i bUL;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.e bUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, com.baidu.tieba.enterForum.b.e eVar) {
        this.bUL = iVar;
        this.bUM = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bUL.bSq;
        if (viewEventCenter != null) {
            switch (this.bUM.getType()) {
                case 0:
                    viewEventCenter2 = this.bUL.bSq;
                    i = this.bUL.position;
                    return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.i(i), null, null));
                case 3:
                    return true;
            }
        }
        return false;
    }
}
