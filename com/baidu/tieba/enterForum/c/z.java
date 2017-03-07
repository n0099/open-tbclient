package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bGN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bGN = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bGN.bEQ;
        if (viewEventCenter != null && this.bGN.getData() != null) {
            if (this.bGN.getData().getType() == 0) {
                viewEventCenter3 = this.bGN.bEQ;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bGN.getData(), null, null));
            } else if (this.bGN.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bGN.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bGN.bEQ;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
