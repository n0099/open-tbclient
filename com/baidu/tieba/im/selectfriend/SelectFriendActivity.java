package com.baidu.tieba.im.selectfriend;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bu;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class SelectFriendActivity extends BaseActivity {
    NavigationBar a;
    BdListView b;
    d c;
    p d;
    private CustomMessageListener e = new a(this, 2001188);
    private AdapterView.OnItemClickListener f = new b(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bu.class, SelectFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(v.select_friend_main);
        this.a = (NavigationBar) findViewById(u.select_friend_nevigation_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.a.a(x.select_friend_title);
        this.b = (BdListView) findViewById(u.select_friend_listview);
        this.c = new d(this);
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnItemClickListener(this.f);
        registerListener(this.e);
        MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        this.d = new p(this, t.pic_emotion05, t.pic_emotion05_1, u.no_data_container, u.no_data_image, u.no_data_image_text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.c(i);
        if (this.d != null) {
            this.d.a(i);
        }
        getLayoutMode().a(i == 1);
        getLayoutMode().a(findViewById(u.select_friend_root_view));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.d.b();
    }
}
