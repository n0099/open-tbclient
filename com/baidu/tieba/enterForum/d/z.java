package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bIZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bIZ = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bIZ.aPL;
        if (viewEventCenter != null && this.bIZ.getData() != null) {
            if (this.bIZ.getData().getType() == 0) {
                viewEventCenter3 = this.bIZ.aPL;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bIZ.getData(), null, null));
            } else if (this.bIZ.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bIZ.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bIZ.aPL;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
