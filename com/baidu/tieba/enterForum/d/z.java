package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y aWT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aWT = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aWT.aUs;
        if (viewEventCenter != null && this.aWT.getData() != null) {
            if (this.aWT.getData().getType() == 0) {
                viewEventCenter3 = this.aWT.aUs;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aWT.getData(), null, null));
            } else if (this.aWT.getData().getType() == 1) {
                TiebaStatic.eventStat(this.aWT.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aWT.aUs;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
