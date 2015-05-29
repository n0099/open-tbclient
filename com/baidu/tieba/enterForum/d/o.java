package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.ae aFe;
    final /* synthetic */ n aGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.baidu.tieba.tbadkCore.ae aeVar) {
        this.aGv = nVar;
        this.aFe = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aGv.aET;
        if (viewEventCenter != null) {
            if (this.aFe.getType() == 0) {
                viewEventCenter3 = this.aGv.aET;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aFe, null, null));
            } else if (this.aFe.getType() == 1) {
                TiebaStatic.eventStat(this.aGv.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aGv.aET;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
