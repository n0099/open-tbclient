package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bxJ = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bxJ.bgJ;
        if (viewEventCenter != null && this.bxJ.getData() != null) {
            if (this.bxJ.getData().getType() == 0) {
                viewEventCenter3 = this.bxJ.bgJ;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bxJ.getData(), null, null));
            } else if (this.bxJ.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bxJ.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bxJ.bgJ;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
