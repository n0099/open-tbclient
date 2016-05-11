package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aZz = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aZz.aXs;
        if (viewEventCenter != null && this.aZz.getData() != null) {
            if (this.aZz.getData().getType() == 0) {
                viewEventCenter3 = this.aZz.aXs;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aZz.getData(), null, null));
            } else if (this.aZz.getData().getType() == 1) {
                TiebaStatic.eventStat(this.aZz.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aZz.aXs;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
