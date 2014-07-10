package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static TextView c;

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new d();
        dVar.c = 3;
        dVar.b = y.enter_message;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.fragmenttabindicator, (ViewGroup) null);
        c = (TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.message_tip_item, (ViewGroup) null);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.h = this.b;
        cVar.a = c;
        cVar.d = com.baidu.tieba.u.icon_dot_orange;
        cVar.e = com.baidu.tieba.u.icon_dot_orange_1;
        c.setVisibility(8);
        this.b.a("msg", cVar);
        return this.b;
    }

    static {
        b bVar = new b(2007002);
        bVar.setPriority(3);
        MessageManager.getInstance().registerListener(bVar);
        MessageManager.getInstance().registerListener(new c(2001124));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TextView textView, int i) {
        textView.setVisibility(0);
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        textView.setTextColor(TbadkApplication.m252getInst().getResources().getColor(z ? com.baidu.tieba.s.top_msg_num_night : com.baidu.tieba.s.top_msg_num_day));
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            textView.setBackgroundResource(z ? com.baidu.tieba.u.icon_news_head_prompt_one_1 : com.baidu.tieba.u.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            textView.setBackgroundResource(z ? com.baidu.tieba.u.icon_news_head_prompt_two_1 : com.baidu.tieba.u.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            textView.setBackgroundResource(z ? com.baidu.tieba.u.icon_news_head_prompt_more_1 : com.baidu.tieba.u.icon_news_head_prompt_more);
        }
    }
}
