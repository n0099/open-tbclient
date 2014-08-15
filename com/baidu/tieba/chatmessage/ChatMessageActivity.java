package com.baidu.tieba.chatmessage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.h;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class ChatMessageActivity extends BaseFragmentActivity {
    private NavigationBar d;
    private ImageView e;
    private FragmentManager g;
    private FragmentTransaction h;
    private View.OnClickListener f = null;
    private CustomMessageListener i = new a(this, 2008002);

    static {
        TbadkApplication.m252getInst().RegisterIntent(h.class, ChatMessageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
        a(this.i);
        a(new CustomMessage(2008002));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, Integer.valueOf(FrsActivity.d)));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        super.a(i);
        this.d.c(i);
    }

    private void g() {
        setContentView(v.chat_message_activity);
        this.f = new b(this);
        this.d = (NavigationBar) findViewById(u.view_navigation_bar);
        this.d.a(x.my_chat);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (ImageView) this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, v.widget_nb_item_addchat, this.f);
    }
}
