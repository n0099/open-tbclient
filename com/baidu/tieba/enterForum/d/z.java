package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y aZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aZh = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aZh.aWA;
        if (viewEventCenter != null && this.aZh.getData() != null) {
            if (this.aZh.getData().getType() == 0) {
                viewEventCenter3 = this.aZh.aWA;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aZh.getData(), null, null));
            } else if (this.aZh.getData().getType() == 1) {
                TiebaStatic.eventStat(this.aZh.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aZh.aWA;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
