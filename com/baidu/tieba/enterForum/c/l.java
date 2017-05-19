package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ j bIc;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.e bId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tieba.enterForum.b.e eVar) {
        this.bIc = jVar;
        this.bId = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bIc.bGb;
        if (viewEventCenter != null) {
            switch (this.bId.getType()) {
                case 0:
                    viewEventCenter2 = this.bIc.bGb;
                    i = this.bIc.position;
                    return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.i(i), null, null));
                case 3:
                    return true;
            }
        }
        return false;
    }
}
