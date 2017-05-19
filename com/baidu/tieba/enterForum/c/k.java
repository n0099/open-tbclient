package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j bIc;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.e bId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, com.baidu.tieba.enterForum.b.e eVar) {
        this.bIc = jVar;
        this.bId = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        ViewEventCenter viewEventCenter4;
        viewEventCenter = this.bIc.bGb;
        if (viewEventCenter != null) {
            switch (this.bId.getType()) {
                case 0:
                    viewEventCenter4 = this.bIc.bGb;
                    viewEventCenter4.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bId, null, null));
                    return;
                case 1:
                    viewEventCenter3 = this.bIc.bGb;
                    viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                    return;
                case 2:
                default:
                    return;
                case 3:
                    viewEventCenter2 = this.bIc.bGb;
                    viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, this.bId, null, null));
                    return;
            }
        }
    }
}
