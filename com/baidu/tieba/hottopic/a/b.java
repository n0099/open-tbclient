package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bnV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bnV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u aA;
        HotTopicActivity hotTopicActivity;
        if (this.bnV.aA(((Integer) view.getTag()).intValue()) instanceof v) {
            String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((v) aA).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title);
            hotTopicActivity = this.bnV.bnS;
            com.baidu.tbadk.browser.g.a(hotTopicActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new ap("c10134").r("obj_type", 3));
        }
    }
}
