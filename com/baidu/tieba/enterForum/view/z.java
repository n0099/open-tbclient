package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bvv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bvv = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bvv.bfx;
        if (viewEventCenter != null && this.bvv.getData() != null) {
            if (this.bvv.getData().getType() == 0) {
                viewEventCenter3 = this.bvv.bfx;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bvv.getData(), null, null));
            } else if (this.bvv.getData().getType() == 1) {
                TiebaStatic.eventStat(this.bvv.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bvv.bfx;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
