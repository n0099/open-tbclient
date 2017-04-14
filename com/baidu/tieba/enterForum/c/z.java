package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bGG = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bGG.bEJ;
        if (viewEventCenter != null && this.bGG.getData() != null) {
            if (this.bGG.getData().getType() == 0) {
                viewEventCenter3 = this.bGG.bEJ;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bGG.getData(), null, null));
            } else if (this.bGG.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bGG.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bGG.bEJ;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
