package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static TextView c;

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new e();
        dVar.c = 3;
        dVar.b = x.enter_message;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) com.baidu.adp.lib.e.b.a().a(context, v.fragmenttabindicator, null);
        c = (TextView) com.baidu.adp.lib.e.b.a().a(context, v.message_tip_item, null);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.h = this.b;
        cVar.a = c;
        cVar.d = t.icon_dot_orange;
        cVar.e = t.icon_dot_orange_1;
        cVar.f = r.frs_slidebar_message_text;
        cVar.g = r.frs_slidebar_message_text_1;
        c.setVisibility(8);
        this.b.a("msg", cVar);
        return this.b;
    }

    static {
        c cVar = new c(2007002);
        cVar.setPriority(3);
        MessageManager.getInstance().registerListener(cVar);
        MessageManager.getInstance().registerListener(new d(2001124));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TextView textView, int i) {
        textView.setVisibility(0);
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        textView.setTextColor(TbadkApplication.m252getInst().getResources().getColor(z ? r.top_msg_num_night : r.top_msg_num_day));
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            textView.setBackgroundResource(z ? t.icon_news_head_prompt_one_1 : t.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            textView.setBackgroundResource(z ? t.icon_news_head_prompt_two_1 : t.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            textView.setBackgroundResource(z ? t.icon_news_head_prompt_more_1 : t.icon_news_head_prompt_more);
        }
    }
}
