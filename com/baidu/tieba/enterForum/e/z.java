package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bIY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bIY = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bIY.aOw;
        if (viewEventCenter != null && this.bIY.getData() != null) {
            if (this.bIY.getData().getType() == 0) {
                viewEventCenter3 = this.bIY.aOw;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bIY.getData(), null, null));
            } else if (this.bIY.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bIY.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bIY.aOw;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
