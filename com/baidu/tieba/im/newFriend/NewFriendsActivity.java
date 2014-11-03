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
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.newFriends.NewFriendsActivityConfig;
/* loaded from: classes.dex */
public class NewFriendsActivity extends BaseActivity {
    private az bhg;
    private AlertDialog bhh;
    private String bhf = "recommend_new_friend" + TbadkApplication.getCurrentAccount();
    private aj bhi = new al(this);
    final CustomMessageListener bhj = new aq(this, 2001178);
    final com.baidu.adp.framework.listener.e bhk = new ar(this, 304101);
    private final com.baidu.adp.widget.ListView.f aQN = new as(this);
    private final ba bhl = new ba(this, new at(this));

    static {
        TbadkApplication.m251getInst().RegisterIntent(NewFriendsActivityConfig.class, NewFriendsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rj() {
        com.baidu.tieba.im.e.a(new au(this), new av(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.new_friend_activity);
        this.bhg = new az(this);
        this.bhg.a(this.aQN);
        this.bhg.a(this.bhi);
        registerListener(this.bhj);
        registerListener(this.bhk);
        if (TbadkSettings.getInst().loadBoolean(this.bhf, false)) {
            Rk();
            this.bhg.hO();
            return;
        }
        this.bhl.setUniqueId(getUniqueId());
        this.bhl.registerListener();
        this.bhl.xF();
        this.bhg.hO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bhg.a(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rk() {
        com.baidu.tieba.im.e.a(new aw(this), new ax(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rl() {
        com.baidu.tieba.im.e.a(new am(this), new an(this));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(this)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.e item = this.bhg.Ro().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.e)) {
            com.baidu.tieba.im.data.e eVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, String.valueOf(eVar.getId()), eVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.e item = this.bhg.Ro().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.e)) {
            com.baidu.tieba.im.data.e eVar = item;
            if (this.bhh == null) {
                this.bhh = Rm();
            }
            ay ayVar = new ay(this, eVar);
            this.bhh.setButton(-1, getString(com.baidu.tieba.y.confirm), ayVar);
            this.bhh.setButton(-2, getString(com.baidu.tieba.y.cancel), ayVar);
            com.baidu.adp.lib.g.j.a(this.bhh, this);
            return true;
        }
        return true;
    }

    private AlertDialog Rm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.y.operation);
        builder.setMessage(com.baidu.tieba.y.delete);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.im.data.e eVar) {
        if (eVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this, String.valueOf(eVar.getId()), eVar.getName(), eVar.getPortrait(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.im.data.e eVar) {
        com.baidu.tbadk.newFriends.a.up().c(eVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.tieba.im.data.e eVar) {
        com.baidu.tieba.im.e.a(new ao(this, eVar), new ap(this, eVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bhh != null) {
            com.baidu.adp.lib.g.j.b(this.bhh, this);
        }
    }
}
