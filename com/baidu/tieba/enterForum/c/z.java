package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bIX = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bIX.bHa;
        if (viewEventCenter != null && this.bIX.getData() != null) {
            if (this.bIX.getData().getType() == 0) {
                viewEventCenter3 = this.bIX.bHa;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bIX.getData(), null, null));
            } else if (this.bIX.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bIX.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bIX.bHa;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
