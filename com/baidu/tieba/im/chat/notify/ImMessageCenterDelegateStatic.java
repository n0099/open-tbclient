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
    private static TextView Pe;

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d sC() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.VU = new g();
        dVar.type = 3;
        dVar.VV = y.enter_message;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator z(Context context) {
        this.VM = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, w.fragmenttabindicator, null);
        Pe = (TextView) com.baidu.adp.lib.g.b.ek().inflate(context, w.message_tip_item, null);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.VT = this.VM;
        cVar.view = Pe;
        cVar.VR = u.icon_dot_orange;
        cVar.VS = s.frs_slidebar_message_text;
        Pe.setVisibility(8);
        this.VM.a(AddFriendActivityConfig.MSG, cVar);
        return this.VM;
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
        aw.b(textView, s.top_msg_num_day, 1);
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
