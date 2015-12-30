package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bGb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bGb = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u au;
        HotTopicActivity hotTopicActivity;
        if (this.bGb.au(((Integer) view.getTag()).intValue()) instanceof z) {
            String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((z) au).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(n.j.user_icon_web_view_title);
            hotTopicActivity = this.bGb.bFY;
            com.baidu.tbadk.browser.f.a(hotTopicActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new av("c10134").r("obj_type", 3));
        }
    }
}
