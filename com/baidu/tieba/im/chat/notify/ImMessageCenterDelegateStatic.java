package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static TextView Pi;

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d sE() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.VY = new g();
        dVar.type = 3;
        dVar.VZ = y.enter_message;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator z(Context context) {
        this.VQ = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, w.fragmenttabindicator, null);
        Pi = (TextView) com.baidu.adp.lib.g.b.ek().inflate(context, w.message_tip_item, null);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.VX = this.VQ;
        cVar.view = Pi;
        cVar.VV = u.icon_dot_orange;
        cVar.VW = s.frs_slidebar_message_text;
        Pi.setVisibility(8);
        this.VQ.a(AddFriendActivityConfig.MSG, cVar);
        return this.VQ;
    }

    static {
        e eVar = new e(2007002);
        eVar.setPriority(3);
        MessageManager.getInstance().registerListener(eVar);
        MessageManager.getInstance().registerListener(new f(2001124));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(TextView textView, int i) {
        textView.setVisibility(0);
        aw.b(textView, s.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            aw.h((View) textView, u.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            aw.h((View) textView, u.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            aw.h((View) textView, u.icon_news_head_prompt_more);
        }
    }
}
