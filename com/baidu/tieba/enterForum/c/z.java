package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bzH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bzH = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bzH.bxK;
        if (viewEventCenter != null && this.bzH.getData() != null) {
            if (this.bzH.getData().getType() == 0) {
                viewEventCenter3 = this.bzH.bxK;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bzH.getData(), null, null));
            } else if (this.bzH.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bzH.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bzH.bxK;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
