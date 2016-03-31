package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bdR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bdR = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bdR.bbj;
        if (viewEventCenter != null && this.bdR.getData() != null) {
            if (this.bdR.getData().getType() == 0) {
                viewEventCenter3 = this.bdR.bbj;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bdR.getData(), null, null));
            } else if (this.bdR.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bdR.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bdR.bbj;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
