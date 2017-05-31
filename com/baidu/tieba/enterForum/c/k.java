package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j bNQ;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.e bNR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, com.baidu.tieba.enterForum.b.e eVar) {
        this.bNQ = jVar;
        this.bNR = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        ViewEventCenter viewEventCenter4;
        viewEventCenter = this.bNQ.bLQ;
        if (viewEventCenter != null) {
            switch (this.bNR.getType()) {
                case 0:
                    viewEventCenter4 = this.bNQ.bLQ;
                    viewEventCenter4.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bNR, null, null));
                    return;
                case 1:
                    viewEventCenter3 = this.bNQ.bLQ;
                    viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                    return;
                case 2:
                default:
                    return;
                case 3:
                    viewEventCenter2 = this.bNQ.bLQ;
                    viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, this.bNR, null, null));
                    return;
            }
        }
    }
}
