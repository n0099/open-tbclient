package com.baidu.tieba.im.live.livelist;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class LiveGroupHistoryActivity extends BaseActivity implements com.baidu.adp.widget.ListView.x {
    private ak a;
    private com.baidu.tieba.im.model.z b;
    private com.baidu.tbadk.editortool.ab c;
    private String d = null;
    private final com.baidu.adp.framework.listener.b e = new af(this, MessageTypes.CMD_LIVE_GROUP_HISTORY);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.ab.class, LiveGroupHistoryActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        b();
        c();
        com.baidu.tieba.im.live.b.b().c();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    private void b() {
        this.a = new ak(this);
        BdListView d = this.a.d();
        d.setOnSrollToBottomListener(this);
        d.setOnItemClickListener(new ag(this));
    }

    private void c() {
        showLoadingDialog(getString(com.baidu.tieba.y.group_tab_enterchatroom_loading), null);
        this.b.a(this.b.a(), this.b.b(), 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        closeLoadingDialog();
    }

    public void a(Bundle bundle) {
        this.b = new com.baidu.tieba.im.model.z();
        if (bundle == null) {
            this.b.a(getIntent());
        } else {
            this.b.b(bundle);
        }
        this.c = new com.baidu.tbadk.editortool.ab(this);
        this.c.d(true);
        this.b.registerListener(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return this.b.c() == 0;
    }

    private void f() {
        if (this.a.e().a()) {
            this.b.a(this.b.a(), this.b.b(), 20);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void f_() {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LiveCardData d = this.b.d();
        if (d != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ah(this, d.getName(), this.d, d.getGroupId(), d.getPublisherId(), d.getPublisherName())));
        }
    }
}
