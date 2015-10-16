package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bog = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u aA;
        HotTopicActivity hotTopicActivity;
        if (this.bog.aA(((Integer) view.getTag()).intValue()) instanceof w) {
            String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((w) aA).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title);
            hotTopicActivity = this.bog.bod;
            com.baidu.tbadk.browser.g.a(hotTopicActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new aq("c10134").r("obj_type", 3));
        }
    }
}
