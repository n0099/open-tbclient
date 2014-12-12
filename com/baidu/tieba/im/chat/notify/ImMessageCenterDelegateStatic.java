package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static TextView UU;

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d wd() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.acb = new g();
        dVar.type = 3;
        dVar.acc = z.enter_message;
        dVar.abS = v.icon_tabbar_imcenter;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator W(Context context) {
        this.abP = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, x.fragmenttabindicator, null);
        UU = (TextView) com.baidu.adp.lib.g.b.ek().inflate(context, x.message_tip_item, null);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aca = this.abP;
        cVar.view = UU;
        cVar.abY = v.icon_dot_orange;
        cVar.abZ = t.frs_slidebar_message_text;
        UU.setVisibility(8);
        this.abP.a(AddFriendActivityConfig.MSG, cVar);
        return this.abP;
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
        ax.b(textView, t.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            ax.i((View) textView, v.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            ax.i((View) textView, v.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            ax.i((View) textView, v.icon_news_head_prompt_more);
        }
    }
}
