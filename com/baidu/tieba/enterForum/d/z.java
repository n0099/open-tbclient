package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y brW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.brW = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.brW.aRj;
        if (viewEventCenter != null && this.brW.getData() != null) {
            if (this.brW.getData().getType() == 0) {
                viewEventCenter3 = this.brW.aRj;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.brW.getData(), null, null));
            } else if (this.brW.getData().getType() == 1) {
                TiebaStatic.eventStat(this.brW.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.brW.aRj;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
