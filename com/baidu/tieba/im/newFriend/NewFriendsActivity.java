package com.baidu.tieba.im.newFriend;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tbadk.core.atomData.bj;
/* loaded from: classes.dex */
public class NewFriendsActivity extends BaseActivity {
    private ao d;
    private AlertDialog e;
    private String c = "recommend_new_friend" + TbadkApplication.getCurrentAccount();
    private aa f = new ac(this);
    final CustomMessageListener a = new af(this, 2001178);
    final com.baidu.adp.framework.listener.b b = new ag(this, 304101);
    private final com.baidu.adp.widget.ListView.d g = new ah(this);
    private final ap h = new ap(new ai(this));

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.newFriends.b.class, NewFriendsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.new_friend_activity);
        this.d = new ao(this);
        this.d.a(this.g);
        this.d.a(this.f);
        registerListener(this.a);
        registerListener(this.b);
        if (com.baidu.tbadk.i.a().a(this.c, false)) {
            a();
            this.d.a();
            return;
        }
        this.h.setUniqueId(getUniqueId());
        this.h.a();
        this.h.b();
        this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.d.a(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.baidu.tieba.im.i.a(new aj(this), new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.tieba.im.i.a(new al(this), new am(this));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bj(this)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.k item = this.d.c().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.k)) {
            com.baidu.tieba.im.data.k kVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bb(this, String.valueOf(kVar.a()), kVar.b())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.k item = this.d.c().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.k)) {
            com.baidu.tieba.im.data.k kVar = item;
            if (this.e == null) {
                this.e = c();
            }
            an anVar = new an(this, kVar);
            this.e.setButton(-1, getString(com.baidu.tieba.y.confirm), anVar);
            this.e.setButton(-2, getString(com.baidu.tieba.y.cancel), anVar);
            this.e.show();
            return true;
        }
        return true;
    }

    private AlertDialog c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.y.operation);
        builder.setMessage(com.baidu.tieba.y.delete);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.data.k kVar) {
        if (kVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(this, String.valueOf(kVar.a()), kVar.b(), kVar.c(), "", false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.data.k kVar) {
        com.baidu.tbadk.newFriends.a.a().b(kVar.a(), "new_frd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.data.k kVar) {
        com.baidu.tieba.im.i.a(new ad(this, kVar), new ae(this, kVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.e != null) {
            this.e.dismiss();
        }
    }
}
