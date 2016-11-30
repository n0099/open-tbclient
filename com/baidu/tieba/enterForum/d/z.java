package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bLS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bLS = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bLS.aRS;
        if (viewEventCenter != null && this.bLS.getData() != null) {
            if (this.bLS.getData().getType() == 0) {
                viewEventCenter3 = this.bLS.aRS;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bLS.getData(), null, null));
            } else if (this.bLS.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bLS.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bLS.aRS;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
