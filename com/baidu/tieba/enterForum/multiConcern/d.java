package com.baidu.tieba.enterForum.multiConcern;

import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
/* loaded from: classes.dex */
class d implements MultiConcernModel.a {
    final /* synthetic */ c bTZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bTZ = cVar;
    }

    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
    public void z(int i, String str) {
        b bVar;
        TextView textView;
        b bVar2;
        TbPageContext tbPageContext;
        b bVar3;
        b bVar4;
        ViewEventCenter viewEventCenter;
        b bVar5;
        ViewEventCenter viewEventCenter2;
        bVar = this.bTZ.bTY;
        textView = bVar.bTU;
        textView.setClickable(true);
        if (i == 0) {
            bVar3 = this.bTZ.bTY;
            bVar3.abk();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
            bVar4 = this.bTZ.bTY;
            viewEventCenter = bVar4.bSq;
            if (viewEventCenter != null) {
                bVar5 = this.bTZ.bTY;
                viewEventCenter2 = bVar5.bSq;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                return;
            }
            return;
        }
        bVar2 = this.bTZ.bTY;
        tbPageContext = bVar2.aat;
        k.showToast(tbPageContext.getPageActivity(), str);
    }
}
