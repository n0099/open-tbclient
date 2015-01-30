package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static TextView Vz;

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d wv() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.acz = new g();
        dVar.type = 3;
        dVar.acA = z.enter_message;
        dVar.acp = v.icon_tabbar_imcenter;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator W(Context context) {
        this.acm = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ei().inflate(context, x.fragmenttabindicator, null);
        Vz = (TextView) com.baidu.adp.lib.g.b.ei().inflate(context, x.message_tip_item, null);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.acy = this.acm;
        cVar.view = Vz;
        cVar.acw = v.icon_dot_orange;
        cVar.acx = t.frs_slidebar_message_text;
        Vz.setVisibility(8);
        this.acm.a(AddFriendActivityConfig.MSG, cVar);
        return this.acm;
    }

    static {
        e eVar = new e(2007002);
        eVar.setPriority(3);
        MessageManager.getInstance().registerListener(eVar);
        MessageManager.getInstance().registerListener(new f(2001124));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(TextView textView, int i) {
        textView.setVisibility(0);
        bc.b(textView, t.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            bc.i((View) textView, v.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            bc.i((View) textView, v.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            bc.i((View) textView, v.icon_news_head_prompt_more);
        }
    }
}
